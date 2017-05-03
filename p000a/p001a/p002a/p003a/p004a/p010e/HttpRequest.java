package p000a.p001a.p002a.p003a.p004a.p010e;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpStatusCodes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

/* renamed from: a.a.a.a.a.e.d */
public class HttpRequest {
    private static final String[] f174b;
    private static HttpRequest f175c;
    public final URL f176a;
    private HttpURLConnection f177d;
    private final String f178e;
    private HttpRequest f179f;
    private boolean f180g;
    private boolean f181h;
    private boolean f182i;
    private int f183j;
    private String f184k;
    private int f185l;

    /* renamed from: a.a.a.a.a.e.d.d */
    protected static abstract class HttpRequest<V> implements Callable<V> {
        protected abstract V m223b();

        protected abstract void m224c();

        protected HttpRequest() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V call() {
            /*
            r3 = this;
            r1 = 1;
            r2 = 0;
            r0 = r3.m223b();	 Catch:{ c -> 0x0011, IOException -> 0x0018, all -> 0x0028 }
            r3.m224c();	 Catch:{ IOException -> 0x000a }
            return r0;
        L_0x000a:
            r0 = move-exception;
            r1 = new a.a.a.a.a.e.d$c;
            r1.<init>(r0);
            throw r1;
        L_0x0011:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x0013 }
        L_0x0013:
            r0 = move-exception;
        L_0x0014:
            r3.m224c();	 Catch:{ IOException -> 0x001f }
        L_0x0017:
            throw r0;
        L_0x0018:
            r0 = move-exception;
            r2 = new a.a.a.a.a.e.d$c;	 Catch:{ all -> 0x0013 }
            r2.<init>(r0);	 Catch:{ all -> 0x0013 }
            throw r2;	 Catch:{ all -> 0x0013 }
        L_0x001f:
            r2 = move-exception;
            if (r1 != 0) goto L_0x0017;
        L_0x0022:
            r0 = new a.a.a.a.a.e.d$c;
            r0.<init>(r2);
            throw r0;
        L_0x0028:
            r0 = move-exception;
            r1 = r2;
            goto L_0x0014;
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.e.d.d.call():V");
        }
    }

    /* renamed from: a.a.a.a.a.e.d.a */
    protected static abstract class HttpRequest<V> extends HttpRequest<V> {
        private final Closeable f167a;
        private final boolean f168b;

        protected HttpRequest(Closeable closeable, boolean z) {
            this.f167a = closeable;
            this.f168b = z;
        }

        protected void m225c() {
            if (this.f167a instanceof Flushable) {
                ((Flushable) this.f167a).flush();
            }
            if (this.f168b) {
                try {
                    this.f167a.close();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.f167a.close();
        }
    }

    /* renamed from: a.a.a.a.a.e.d.1 */
    class HttpRequest extends HttpRequest<HttpRequest> {
        final /* synthetic */ InputStream f169a;
        final /* synthetic */ OutputStream f170b;
        final /* synthetic */ HttpRequest f171c;

        HttpRequest(HttpRequest httpRequest, Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
            this.f171c = httpRequest;
            this.f169a = inputStream;
            this.f170b = outputStream;
            super(closeable, z);
        }

        public /* synthetic */ Object m227b() {
            return m226a();
        }

        public HttpRequest m226a() {
            byte[] bArr = new byte[this.f171c.f183j];
            while (true) {
                int read = this.f169a.read(bArr);
                if (read == -1) {
                    return this.f171c;
                }
                this.f170b.write(bArr, 0, read);
            }
        }
    }

    /* renamed from: a.a.a.a.a.e.d.b */
    public interface HttpRequest {
        public static final HttpRequest f172a;

        /* renamed from: a.a.a.a.a.e.d.b.1 */
        static class HttpRequest implements HttpRequest {
            HttpRequest() {
            }

            public HttpURLConnection m230a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            public HttpURLConnection m231a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        HttpURLConnection m228a(URL url);

        HttpURLConnection m229a(URL url, Proxy proxy);

        static {
            f172a = new HttpRequest();
        }
    }

    /* renamed from: a.a.a.a.a.e.d.c */
    public static class HttpRequest extends RuntimeException {
        public /* synthetic */ Throwable getCause() {
            return m232a();
        }

        protected HttpRequest(IOException iOException) {
            super(iOException);
        }

        public IOException m232a() {
            return (IOException) super.getCause();
        }
    }

    /* renamed from: a.a.a.a.a.e.d.e */
    public static class HttpRequest extends BufferedOutputStream {
        private final CharsetEncoder f173a;

        public HttpRequest(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f173a = Charset.forName(HttpRequest.m246f(str)).newEncoder();
        }

        public HttpRequest m233a(String str) {
            ByteBuffer encode = this.f173a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    static {
        f174b = new String[0];
        f175c = HttpRequest.f172a;
    }

    private static String m246f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static StringBuilder m238a(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    private static StringBuilder m241b(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static String m236a(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String toASCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = toASCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < toASCIIString.length()) {
                    toASCIIString = toASCIIString.substring(0, indexOf + 1) + toASCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return toASCIIString;
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequest(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequest(e2);
        }
    }

    public static String m237a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        HttpRequest.m238a(charSequence2, stringBuilder);
        HttpRequest.m241b(charSequence2, stringBuilder);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static HttpRequest m239b(CharSequence charSequence) {
        return new HttpRequest(charSequence, HttpMethods.GET);
    }

    public static HttpRequest m235a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = HttpRequest.m237a(charSequence, (Map) map);
        if (z) {
            a = HttpRequest.m236a(a);
        }
        return HttpRequest.m239b(a);
    }

    public static HttpRequest m242c(CharSequence charSequence) {
        return new HttpRequest(charSequence, HttpMethods.POST);
    }

    public static HttpRequest m240b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = HttpRequest.m237a(charSequence, (Map) map);
        if (z) {
            a = HttpRequest.m236a(a);
        }
        return HttpRequest.m242c(a);
    }

    public static HttpRequest m243d(CharSequence charSequence) {
        return new HttpRequest(charSequence, HttpMethods.PUT);
    }

    public static HttpRequest m244e(CharSequence charSequence) {
        return new HttpRequest(charSequence, HttpMethods.DELETE);
    }

    public HttpRequest(CharSequence charSequence, String str) {
        this.f177d = null;
        this.f181h = true;
        this.f182i = false;
        this.f183j = AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD;
        try {
            this.f176a = new URL(charSequence.toString());
            this.f178e = str;
        } catch (IOException e) {
            throw new HttpRequest(e);
        }
    }

    private Proxy m247q() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f184k, this.f185l));
    }

    private HttpURLConnection m248r() {
        try {
            HttpURLConnection a;
            if (this.f184k != null) {
                a = f175c.m229a(this.f176a, m247q());
            } else {
                a = f175c.m228a(this.f176a);
            }
            a.setRequestMethod(this.f178e);
            return a;
        } catch (IOException e) {
            throw new HttpRequest(e);
        }
    }

    public String toString() {
        return m287p() + ' ' + m286o();
    }

    public HttpURLConnection m262a() {
        if (this.f177d == null) {
            this.f177d = m248r();
        }
        return this.f177d;
    }

    public int m263b() {
        try {
            m282k();
            return m262a().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequest(e);
        }
    }

    public boolean m269c() {
        return HttpStatusCodes.STATUS_CODE_OK == m263b();
    }

    protected ByteArrayOutputStream m272d() {
        int j = m281j();
        if (j > 0) {
            return new ByteArrayOutputStream(j);
        }
        return new ByteArrayOutputStream();
    }

    public String m261a(String str) {
        OutputStream d = m272d();
        try {
            m251a(m277f(), d);
            return d.toString(HttpRequest.m246f(str));
        } catch (IOException e) {
            throw new HttpRequest(e);
        }
    }

    public String m274e() {
        return m261a(m279h());
    }

    public BufferedInputStream m277f() {
        return new BufferedInputStream(m278g(), this.f183j);
    }

    public InputStream m278g() {
        if (m263b() < 400) {
            try {
                InputStream inputStream = m262a().getInputStream();
            } catch (IOException e) {
                throw new HttpRequest(e);
            }
        }
        inputStream = m262a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = m262a().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequest(e2);
            }
        }
        if (!this.f182i || !"gzip".equals(m280i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new HttpRequest(e22);
        }
    }

    public HttpRequest m250a(int i) {
        m262a().setConnectTimeout(i);
        return this;
    }

    public HttpRequest m253a(String str, String str2) {
        m262a().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest m259a(Entry<String, String> entry) {
        return m253a((String) entry.getKey(), (String) entry.getValue());
    }

    public String m265b(String str) {
        m283l();
        return m262a().getHeaderField(str);
    }

    public int m267c(String str) {
        return m249a(str, -1);
    }

    public int m249a(String str, int i) {
        m283l();
        return m262a().getHeaderFieldInt(str, i);
    }

    public String m266b(String str, String str2) {
        return m268c(m265b(str), str2);
    }

    protected String m268c(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length) {
            return null;
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = indexOf;
            indexOf = length;
        } else {
            int i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        while (indexOf2 < indexOf) {
            int indexOf3 = str.indexOf(61, indexOf2);
            if (indexOf3 != -1 && indexOf3 < indexOf && str2.equals(str.substring(indexOf2, indexOf3).trim())) {
                String trim = str.substring(indexOf3 + 1, indexOf).trim();
                indexOf3 = trim.length();
                if (indexOf3 != 0) {
                    if (indexOf3 > 2 && '\"' == trim.charAt(0) && '\"' == trim.charAt(indexOf3 - 1)) {
                        return trim.substring(1, indexOf3 - 1);
                    }
                    return trim;
                }
            }
            indexOf++;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length;
            }
            i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        return null;
    }

    public String m279h() {
        return m266b("Content-Type", "charset");
    }

    public HttpRequest m260a(boolean z) {
        m262a().setUseCaches(z);
        return this;
    }

    public String m280i() {
        return m265b("Content-Encoding");
    }

    public HttpRequest m270d(String str) {
        return m271d(str, null);
    }

    public HttpRequest m271d(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return m253a("Content-Type", str);
        }
        String str3 = "; charset=";
        return m253a("Content-Type", str + "; charset=" + str2);
    }

    public int m281j() {
        return m267c("Content-Length");
    }

    protected HttpRequest m251a(InputStream inputStream, OutputStream outputStream) {
        return (HttpRequest) new HttpRequest(this, inputStream, this.f181h, inputStream, outputStream).call();
    }

    protected HttpRequest m282k() {
        if (this.f179f != null) {
            if (this.f180g) {
                this.f179f.m233a("\r\n--00content0boundary00--\r\n");
            }
            if (this.f181h) {
                try {
                    this.f179f.close();
                } catch (IOException e) {
                }
            } else {
                this.f179f.close();
            }
            this.f179f = null;
        }
        return this;
    }

    protected HttpRequest m283l() {
        try {
            return m282k();
        } catch (IOException e) {
            throw new HttpRequest(e);
        }
    }

    protected HttpRequest m284m() {
        if (this.f179f == null) {
            m262a().setDoOutput(true);
            this.f179f = new HttpRequest(m262a().getOutputStream(), m268c(m262a().getRequestProperty("Content-Type"), "charset"), this.f183j);
        }
        return this;
    }

    protected HttpRequest m285n() {
        if (this.f180g) {
            this.f179f.m233a("\r\n--00content0boundary00\r\n");
        } else {
            this.f180g = true;
            m270d("multipart/form-data; boundary=00content0boundary00").m284m();
            this.f179f.m233a("--00content0boundary00\r\n");
        }
        return this;
    }

    protected HttpRequest m255a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"").append(str2);
        }
        stringBuilder.append('\"');
        m276f("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            m276f("Content-Type", str3);
        }
        return m275f((CharSequence) "\r\n");
    }

    public HttpRequest m273e(String str, String str2) {
        return m264b(str, null, str2);
    }

    public HttpRequest m264b(String str, String str2, String str3) {
        return m258a(str, str2, null, str3);
    }

    public HttpRequest m258a(String str, String str2, String str3, String str4) {
        try {
            m285n();
            m255a(str, str2, str3);
            this.f179f.m233a(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequest(e);
        }
    }

    public HttpRequest m252a(String str, Number number) {
        return m254a(str, null, number);
    }

    public HttpRequest m254a(String str, String str2, Number number) {
        return m264b(str, str2, number != null ? number.toString() : null);
    }

    public HttpRequest m256a(String str, String str2, String str3, File file) {
        InputStream bufferedInputStream;
        IOException e;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                HttpRequest a = m257a(str, str2, str3, bufferedInputStream);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return a;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new HttpRequest(e);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            throw new HttpRequest(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public HttpRequest m257a(String str, String str2, String str3, InputStream inputStream) {
        try {
            m285n();
            m255a(str, str2, str3);
            m251a(inputStream, this.f179f);
            return this;
        } catch (IOException e) {
            throw new HttpRequest(e);
        }
    }

    public HttpRequest m276f(String str, String str2) {
        return m275f((CharSequence) str).m275f((CharSequence) ": ").m275f((CharSequence) str2).m275f((CharSequence) "\r\n");
    }

    public HttpRequest m275f(CharSequence charSequence) {
        try {
            m284m();
            this.f179f.m233a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequest(e);
        }
    }

    public URL m286o() {
        return m262a().getURL();
    }

    public String m287p() {
        return m262a().getRequestMethod();
    }
}
