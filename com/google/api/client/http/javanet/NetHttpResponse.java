package com.google.api.client.http.javanet;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.api.client.http.javanet.b */
final class NetHttpResponse extends LowLevelHttpResponse {
    private final HttpURLConnection f4449a;
    private final int f4450b;
    private final String f4451c;
    private final ArrayList<String> f4452d;
    private final ArrayList<String> f4453e;

    /* renamed from: com.google.api.client.http.javanet.b.a */
    private final class NetHttpResponse extends FilterInputStream {
        final /* synthetic */ NetHttpResponse f4447a;
        private long f4448b;

        public NetHttpResponse(NetHttpResponse netHttpResponse, InputStream inputStream) {
            this.f4447a = netHttpResponse;
            super(inputStream);
            this.f4448b = 0;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = this.in.read(bArr, i, i2);
            if (read == -1) {
                m5044a();
            } else {
                this.f4448b += (long) read;
            }
            return read;
        }

        public int read() {
            int read = this.in.read();
            if (read == -1) {
                m5044a();
            } else {
                this.f4448b++;
            }
            return read;
        }

        private void m5044a() {
            long contentLength = this.f4447a.getContentLength();
            if (contentLength != -1 && this.f4448b != 0 && this.f4448b < contentLength) {
                throw new IOException("Connection closed prematurely: bytesRead = " + this.f4448b + ", Content-Length = " + contentLength);
            }
        }
    }

    NetHttpResponse(HttpURLConnection httpURLConnection) {
        this.f4452d = new ArrayList();
        this.f4453e = new ArrayList();
        this.f4449a = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == -1) {
            responseCode = 0;
        }
        this.f4450b = responseCode;
        this.f4451c = httpURLConnection.getResponseMessage();
        List list = this.f4452d;
        List list2 = this.f4453e;
        for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                for (String str2 : (List) entry.getValue()) {
                    if (str2 != null) {
                        list.add(str);
                        list2.add(str2);
                    }
                }
            }
        }
    }

    public int getStatusCode() {
        return this.f4450b;
    }

    public InputStream getContent() {
        InputStream inputStream;
        try {
            inputStream = this.f4449a.getInputStream();
        } catch (IOException e) {
            inputStream = this.f4449a.getErrorStream();
        }
        return inputStream == null ? null : new NetHttpResponse(this, inputStream);
    }

    public String getContentEncoding() {
        return this.f4449a.getContentEncoding();
    }

    public long getContentLength() {
        String headerField = this.f4449a.getHeaderField("Content-Length");
        return headerField == null ? -1 : Long.parseLong(headerField);
    }

    public String getContentType() {
        return this.f4449a.getHeaderField("Content-Type");
    }

    public String getReasonPhrase() {
        return this.f4451c;
    }

    public String getStatusLine() {
        String headerField = this.f4449a.getHeaderField(0);
        return (headerField == null || !headerField.startsWith("HTTP/1.")) ? null : headerField;
    }

    public int getHeaderCount() {
        return this.f4452d.size();
    }

    public String getHeaderName(int i) {
        return (String) this.f4452d.get(i);
    }

    public String getHeaderValue(int i) {
        return (String) this.f4453e.get(i);
    }

    public void disconnect() {
        this.f4449a.disconnect();
    }
}
