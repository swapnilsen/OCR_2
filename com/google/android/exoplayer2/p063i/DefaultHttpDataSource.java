package com.google.android.exoplayer2.p063i;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.Predicate;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p063i.HttpDataSource.HttpDataSource;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpStatusCodes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

/* renamed from: com.google.android.exoplayer2.i.m */
public class DefaultHttpDataSource implements HttpDataSource {
    private static final Pattern f3747b;
    private static final AtomicReference<byte[]> f3748c;
    private final boolean f3749d;
    private final int f3750e;
    private final int f3751f;
    private final String f3752g;
    private final Predicate<String> f3753h;
    private final HashMap<String, String> f3754i;
    private final TransferListener<? super DefaultHttpDataSource> f3755j;
    private DataSpec f3756k;
    private HttpURLConnection f3757l;
    private InputStream f3758m;
    private boolean f3759n;
    private long f3760o;
    private long f3761p;
    private long f3762q;
    private long f3763r;

    static {
        f3747b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
        f3748c = new AtomicReference();
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener, int i, int i2, boolean z) {
        this.f3752g = Assertions.m4403a(str);
        this.f3753h = predicate;
        this.f3755j = transferListener;
        this.f3754i = new HashMap();
        this.f3750e = i;
        this.f3751f = i2;
        this.f3749d = z;
    }

    public long m4374a(DataSpec dataSpec) {
        long j = 0;
        this.f3756k = dataSpec;
        this.f3763r = 0;
        this.f3762q = 0;
        try {
            this.f3757l = m4370b(dataSpec);
            try {
                int responseCode = this.f3757l.getResponseCode();
                if (responseCode < HttpStatusCodes.STATUS_CODE_OK || responseCode > 299) {
                    Map headerFields = this.f3757l.getHeaderFields();
                    m4372d();
                    HttpDataSource httpDataSource = new HttpDataSource(responseCode, headerFields, dataSpec);
                    if (responseCode == 416) {
                        httpDataSource.initCause(new DataSourceException(0));
                    }
                    throw httpDataSource;
                }
                String contentType = this.f3757l.getContentType();
                if (this.f3753h == null || this.f3753h.m4382a(contentType)) {
                    if (responseCode == HttpStatusCodes.STATUS_CODE_OK && dataSpec.f3713d != 0) {
                        j = dataSpec.f3713d;
                    }
                    this.f3760o = j;
                    if ((dataSpec.f3716g & 1) != 0) {
                        this.f3761p = dataSpec.f3714e;
                    } else if (dataSpec.f3714e != -1) {
                        this.f3761p = dataSpec.f3714e;
                    } else {
                        j = DefaultHttpDataSource.m4365a(this.f3757l);
                        this.f3761p = j != -1 ? j - this.f3760o : -1;
                    }
                    try {
                        this.f3758m = this.f3757l.getInputStream();
                        this.f3759n = true;
                        if (this.f3755j != null) {
                            this.f3755j.m4353a((Object) this, dataSpec);
                        }
                        return this.f3761p;
                    } catch (IOException e) {
                        m4372d();
                        throw new HttpDataSource(e, dataSpec, 1);
                    }
                }
                m4372d();
                throw new HttpDataSource(contentType, dataSpec);
            } catch (IOException e2) {
                m4372d();
                throw new HttpDataSource("Unable to connect to " + dataSpec.f3710a.toString(), e2, dataSpec, 1);
            }
        } catch (IOException e22) {
            throw new HttpDataSource("Unable to connect to " + dataSpec.f3710a.toString(), e22, dataSpec, 1);
        }
    }

    public int m4373a(byte[] bArr, int i, int i2) {
        try {
            m4371c();
            return m4369b(bArr, i, i2);
        } catch (IOException e) {
            throw new HttpDataSource(e, this.f3756k, 2);
        }
    }

    public void m4375a() {
        try {
            if (this.f3758m != null) {
                DefaultHttpDataSource.m4368a(this.f3757l, m4376b());
                this.f3758m.close();
            }
            this.f3758m = null;
            m4372d();
            if (this.f3759n) {
                this.f3759n = false;
                if (this.f3755j != null) {
                    this.f3755j.m4351a(this);
                }
            }
        } catch (IOException e) {
            throw new HttpDataSource(e, this.f3756k, 3);
        } catch (Throwable th) {
            this.f3758m = null;
            m4372d();
            if (this.f3759n) {
                this.f3759n = false;
                if (this.f3755j != null) {
                    this.f3755j.m4351a(this);
                }
            }
        }
    }

    protected final long m4376b() {
        return this.f3761p == -1 ? this.f3761p : this.f3761p - this.f3763r;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.net.HttpURLConnection m4370b(com.google.android.exoplayer2.p063i.DataSpec r13) {
        /*
        r12 = this;
        r9 = 1;
        r0 = 0;
        r2 = new java.net.URL;
        r1 = r13.f3710a;
        r1 = r1.toString();
        r2.<init>(r1);
        r3 = r13.f3711b;
        r4 = r13.f3713d;
        r6 = r13.f3714e;
        r1 = r13.f3716g;
        r1 = r1 & 1;
        if (r1 == 0) goto L_0x0024;
    L_0x0019:
        r8 = r9;
    L_0x001a:
        r1 = r12.f3749d;
        if (r1 != 0) goto L_0x0026;
    L_0x001e:
        r1 = r12;
        r0 = r1.m4366a(r2, r3, r4, r6, r8, r9);
    L_0x0023:
        return r0;
    L_0x0024:
        r8 = r0;
        goto L_0x001a;
    L_0x0026:
        r1 = r0;
    L_0x0027:
        r10 = r1 + 1;
        r9 = 20;
        if (r1 > r9) goto L_0x0063;
    L_0x002d:
        r1 = r12;
        r9 = r0;
        r1 = r1.m4366a(r2, r3, r4, r6, r8, r9);
        r9 = r1.getResponseCode();
        r11 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 == r11) goto L_0x0051;
    L_0x003b:
        r11 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r9 == r11) goto L_0x0051;
    L_0x003f:
        r11 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r9 == r11) goto L_0x0051;
    L_0x0043:
        r11 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
        if (r9 == r11) goto L_0x0051;
    L_0x0047:
        if (r3 != 0) goto L_0x0061;
    L_0x0049:
        r3 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r9 == r3) goto L_0x0051;
    L_0x004d:
        r3 = 308; // 0x134 float:4.32E-43 double:1.52E-321;
        if (r9 != r3) goto L_0x0061;
    L_0x0051:
        r3 = 0;
        r9 = "Location";
        r9 = r1.getHeaderField(r9);
        r1.disconnect();
        r2 = com.google.android.exoplayer2.p063i.DefaultHttpDataSource.m4367a(r2, r9);
        r1 = r10;
        goto L_0x0027;
    L_0x0061:
        r0 = r1;
        goto L_0x0023;
    L_0x0063:
        r0 = new java.net.NoRouteToHostException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Too many redirects: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.m.b(com.google.android.exoplayer2.i.h):java.net.HttpURLConnection");
    }

    private HttpURLConnection m4366a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f3750e);
        httpURLConnection.setReadTimeout(this.f3751f);
        synchronized (this.f3754i) {
            for (Entry entry : this.f3754i.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!(j == 0 && j2 == -1)) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.f3752g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod(HttpMethods.POST);
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL m4367a(URL url, String str) {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if ("https".equals(protocol) || "http".equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    private static long m4365a(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                Log.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]");
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = f3747b.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return parseLong;
            }
            if (j == parseLong) {
                return j;
            }
            Log.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return Math.max(j, parseLong);
        } catch (NumberFormatException e2) {
            Log.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]");
            return j;
        }
    }

    private void m4371c() {
        if (this.f3762q != this.f3760o) {
            Object obj = (byte[]) f3748c.getAndSet(null);
            if (obj == null) {
                obj = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            }
            while (this.f3762q != this.f3760o) {
                int read = this.f3758m.read(obj, 0, (int) Math.min(this.f3760o - this.f3762q, (long) obj.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                } else if (read == -1) {
                    throw new EOFException();
                } else {
                    this.f3762q += (long) read;
                    if (this.f3755j != null) {
                        this.f3755j.m4352a((Object) this, read);
                    }
                }
            }
            f3748c.set(obj);
        }
    }

    private int m4369b(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f3761p != -1) {
            long j = this.f3761p - this.f3763r;
            if (j == 0) {
                return -1;
            }
            i2 = (int) Math.min((long) i2, j);
        }
        int read = this.f3758m.read(bArr, i, i2);
        if (read != -1) {
            this.f3763r += (long) read;
            if (this.f3755j != null) {
                this.f3755j.m4352a((Object) this, read);
            }
            return read;
        } else if (this.f3761p == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    private static void m4368a(HttpURLConnection httpURLConnection, long j) {
        if (Util.f3855a == 19 || Util.f3855a == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception e) {
            }
        }
    }

    private void m4372d() {
        if (this.f3757l != null) {
            try {
                this.f3757l.disconnect();
            } catch (Throwable e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f3757l = null;
        }
    }
}
