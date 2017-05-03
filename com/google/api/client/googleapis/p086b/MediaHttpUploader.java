package com.google.api.client.googleapis.p086b;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.p082b.ByteStreams;
import com.google.api.client.p082b.Preconditions;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.google.api.client.googleapis.b.b */
public final class MediaHttpUploader {
    String f4244a;
    private MediaHttpUploader f4245b;
    private final AbstractInputStreamContent f4246c;
    private final HttpRequestFactory f4247d;
    private HttpContent f4248e;
    private long f4249f;
    private boolean f4250g;
    private String f4251h;
    private HttpHeaders f4252i;
    private HttpRequest f4253j;
    private InputStream f4254k;
    private boolean f4255l;
    private MediaHttpUploaderProgressListener f4256m;
    private long f4257n;
    private int f4258o;
    private Byte f4259p;
    private long f4260q;
    private int f4261r;
    private byte[] f4262s;
    private boolean f4263t;

    /* renamed from: com.google.api.client.googleapis.b.b.a */
    public enum MediaHttpUploader {
        NOT_STARTED,
        INITIATION_STARTED,
        INITIATION_COMPLETE,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public HttpResponse m4991a(GenericUrl genericUrl) {
        Preconditions.m4971a(this.f4245b == MediaHttpUploader.NOT_STARTED);
        if (this.f4255l) {
            return m4982b(genericUrl);
        }
        return m4986c(genericUrl);
    }

    private HttpResponse m4982b(GenericUrl genericUrl) {
        m4981a(MediaHttpUploader.MEDIA_IN_PROGRESS);
        HttpContent httpContent = this.f4246c;
        if (this.f4248e != null) {
            httpContent = new MultipartContent().setContentParts(Arrays.asList(new HttpContent[]{this.f4248e, this.f4246c}));
            genericUrl.put("uploadType", (Object) "multipart");
        } else {
            genericUrl.put("uploadType", (Object) "media");
        }
        HttpRequest buildRequest = this.f4247d.buildRequest(this.f4251h, genericUrl, httpContent);
        buildRequest.getHeaders().putAll(this.f4252i);
        HttpResponse b = m4983b(buildRequest);
        try {
            if (m4984b()) {
                this.f4257n = m4985c();
            }
            m4981a(MediaHttpUploader.MEDIA_COMPLETE);
            return b;
        } catch (Throwable th) {
            b.disconnect();
        }
    }

    private HttpResponse m4986c(GenericUrl genericUrl) {
        HttpResponse d = m4987d(genericUrl);
        if (d.isSuccessStatusCode()) {
            try {
                GenericUrl genericUrl2 = new GenericUrl(d.getHeaders().getLocation());
                this.f4254k = this.f4246c.getInputStream();
                if (!this.f4254k.markSupported() && m4984b()) {
                    this.f4254k = new BufferedInputStream(this.f4254k);
                }
                while (true) {
                    this.f4253j = this.f4247d.buildPutRequest(genericUrl2, null);
                    m4988d();
                    MediaUploadErrorHandler mediaUploadErrorHandler = new MediaUploadErrorHandler(this, this.f4253j);
                    if (m4984b()) {
                        d = m4980a(this.f4253j);
                    } else {
                        d = m4983b(this.f4253j);
                    }
                    if (d.isSuccessStatusCode()) {
                        break;
                    }
                    try {
                        if (d.getStatusCode() != 308) {
                            break;
                        }
                        String location = d.getHeaders().getLocation();
                        if (location != null) {
                            genericUrl2 = new GenericUrl(location);
                        }
                        long a = m4979a(d.getHeaders().getRange());
                        long j = a - this.f4257n;
                        boolean z = j >= 0 && j <= ((long) this.f4261r);
                        Preconditions.m4974b(z);
                        long j2 = ((long) this.f4261r) - j;
                        if (m4984b()) {
                            if (j2 > 0) {
                                this.f4254k.reset();
                                Preconditions.m4974b(j == this.f4254k.skip(j));
                            }
                        } else if (j2 == 0) {
                            this.f4262s = null;
                        }
                        this.f4257n = a;
                        m4981a(MediaHttpUploader.MEDIA_IN_PROGRESS);
                        d.disconnect();
                    } catch (Throwable th) {
                        d.disconnect();
                    }
                }
                this.f4257n = m4985c();
                if (this.f4246c.getCloseInputStream()) {
                    this.f4254k.close();
                }
                m4981a(MediaHttpUploader.MEDIA_COMPLETE);
            } finally {
                d.disconnect();
            }
        }
        return d;
    }

    private boolean m4984b() {
        return m4985c() >= 0;
    }

    private long m4985c() {
        if (!this.f4250g) {
            this.f4249f = this.f4246c.getLength();
            this.f4250g = true;
        }
        return this.f4249f;
    }

    private HttpResponse m4987d(GenericUrl genericUrl) {
        m4981a(MediaHttpUploader.INITIATION_STARTED);
        genericUrl.put("uploadType", (Object) "resumable");
        HttpRequest buildRequest = this.f4247d.buildRequest(this.f4251h, genericUrl, this.f4248e == null ? new EmptyContent() : this.f4248e);
        this.f4252i.set("X-Upload-Content-Type", this.f4246c.getType());
        if (m4984b()) {
            this.f4252i.set("X-Upload-Content-Length", Long.valueOf(m4985c()));
        }
        buildRequest.getHeaders().putAll(this.f4252i);
        HttpResponse b = m4983b(buildRequest);
        try {
            m4981a(MediaHttpUploader.INITIATION_COMPLETE);
            return b;
        } catch (Throwable th) {
            b.disconnect();
        }
    }

    private HttpResponse m4980a(HttpRequest httpRequest) {
        new MethodOverride().intercept(httpRequest);
        httpRequest.setThrowExceptionOnExecuteError(false);
        return httpRequest.execute();
    }

    private HttpResponse m4983b(HttpRequest httpRequest) {
        if (!(this.f4263t || (httpRequest.getContent() instanceof EmptyContent))) {
            httpRequest.setEncoding(new GZipEncoding());
        }
        return m4980a(httpRequest);
    }

    private void m4988d() {
        int min;
        HttpContent closeInputStream;
        if (m4984b()) {
            min = (int) Math.min((long) this.f4258o, m4985c() - this.f4257n);
        } else {
            min = this.f4258o;
        }
        if (m4984b()) {
            this.f4254k.mark(min);
            closeInputStream = new InputStreamContent(this.f4246c.getType(), ByteStreams.m4889a(this.f4254k, (long) min)).setRetrySupported(true).setLength((long) min).setCloseInputStream(false);
            this.f4244a = String.valueOf(m4985c());
        } else {
            int i;
            int i2;
            if (this.f4262s == null) {
                i = this.f4259p == null ? min + 1 : min;
                this.f4262s = new byte[(min + 1)];
                if (this.f4259p != null) {
                    this.f4262s[0] = this.f4259p.byteValue();
                    i2 = i;
                    i = 0;
                } else {
                    i2 = i;
                    i = 0;
                }
            } else {
                i = (int) (this.f4260q - this.f4257n);
                System.arraycopy(this.f4262s, this.f4261r - i, this.f4262s, 0, i);
                if (this.f4259p != null) {
                    this.f4262s[i] = this.f4259p.byteValue();
                }
                i2 = min - i;
            }
            int a = ByteStreams.m4887a(this.f4254k, this.f4262s, (min + 1) - i2, i2);
            if (a < i2) {
                min = Math.max(0, a) + i;
                if (this.f4259p != null) {
                    min++;
                    this.f4259p = null;
                }
                if (this.f4244a.equals("*")) {
                    this.f4244a = String.valueOf(this.f4257n + ((long) min));
                }
            } else {
                this.f4259p = Byte.valueOf(this.f4262s[min]);
            }
            closeInputStream = new ByteArrayContent(this.f4246c.getType(), this.f4262s, 0, min);
            this.f4260q = this.f4257n + ((long) min);
        }
        this.f4261r = min;
        this.f4253j.setContent(closeInputStream);
        if (min == 0) {
            this.f4253j.getHeaders().setContentRange("bytes */" + this.f4244a);
        } else {
            this.f4253j.getHeaders().setContentRange("bytes " + this.f4257n + "-" + ((this.f4257n + ((long) min)) - 1) + "/" + this.f4244a);
        }
    }

    void m4992a() {
        Preconditions.m4969a(this.f4253j, (Object) "The current request should not be null");
        this.f4253j.setContent(new EmptyContent());
        this.f4253j.getHeaders().setContentRange("bytes */" + this.f4244a);
    }

    private long m4979a(String str) {
        if (str == null) {
            return 0;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1)) + 1;
    }

    public MediaHttpUploader m4990a(boolean z) {
        this.f4263t = z;
        return this;
    }

    public MediaHttpUploader m4989a(HttpHeaders httpHeaders) {
        this.f4252i = httpHeaders;
        return this;
    }

    private void m4981a(MediaHttpUploader mediaHttpUploader) {
        this.f4245b = mediaHttpUploader;
        if (this.f4256m != null) {
            this.f4256m.m4993a(this);
        }
    }
}
