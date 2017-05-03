package com.p013a.p014a.p015a.p018c;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.JsonEncoding;
import com.p013a.p014a.p015a.JsonParser;
import com.p013a.p014a.p015a.ObjectCodec;
import com.p013a.p014a.p015a.p017b.IOContext;
import com.p013a.p014a.p015a.p017b.MergedStream;
import com.p013a.p014a.p015a.p017b.UTF32Reader;
import com.p013a.p014a.p015a.p019d.BytesToNameCanonicalizer;
import com.p013a.p014a.p015a.p019d.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import net.nend.android.NendIconError;

/* renamed from: com.a.a.a.c.a */
public final class ByteSourceJsonBootstrapper {
    protected final IOContext f485a;
    protected final InputStream f486b;
    protected final byte[] f487c;
    protected int f488d;
    protected boolean f489e;
    protected int f490f;
    private int f491g;
    private int f492h;
    private final boolean f493i;

    /* renamed from: com.a.a.a.c.a.1 */
    static /* synthetic */ class ByteSourceJsonBootstrapper {
        static final /* synthetic */ int[] f484a;

        static {
            f484a = new int[JsonEncoding.values().length];
            try {
                f484a[JsonEncoding.UTF32_BE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f484a[JsonEncoding.UTF32_LE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f484a[JsonEncoding.UTF16_BE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f484a[JsonEncoding.UTF16_LE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f484a[JsonEncoding.UTF8.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public ByteSourceJsonBootstrapper(IOContext iOContext, InputStream inputStream) {
        this.f489e = true;
        this.f490f = 0;
        this.f485a = iOContext;
        this.f486b = inputStream;
        this.f487c = iOContext.m576e();
        this.f491g = 0;
        this.f492h = 0;
        this.f488d = 0;
        this.f493i = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.p013a.p014a.p015a.JsonEncoding m634a() {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = 4;
        r2 = r5.m636a(r2);
        if (r2 == 0) goto L_0x0056;
    L_0x0009:
        r2 = r5.f487c;
        r3 = r5.f491g;
        r2 = r2[r3];
        r2 = r2 << 24;
        r3 = r5.f487c;
        r4 = r5.f491g;
        r4 = r4 + 1;
        r3 = r3[r4];
        r3 = r3 & 255;
        r3 = r3 << 16;
        r2 = r2 | r3;
        r3 = r5.f487c;
        r4 = r5.f491g;
        r4 = r4 + 2;
        r3 = r3[r4];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r2 = r2 | r3;
        r3 = r5.f487c;
        r4 = r5.f491g;
        r4 = r4 + 3;
        r3 = r3[r4];
        r3 = r3 & 255;
        r2 = r2 | r3;
        r3 = r5.m631b(r2);
        if (r3 == 0) goto L_0x0046;
    L_0x003c:
        if (r0 != 0) goto L_0x0079;
    L_0x003e:
        r0 = com.p013a.p014a.p015a.JsonEncoding.UTF8;
    L_0x0040:
        r1 = r5.f485a;
        r1.m567a(r0);
        return r0;
    L_0x0046:
        r3 = r5.m632c(r2);
        if (r3 != 0) goto L_0x003c;
    L_0x004c:
        r2 = r2 >>> 16;
        r2 = r5.m633d(r2);
        if (r2 != 0) goto L_0x003c;
    L_0x0054:
        r0 = r1;
        goto L_0x003c;
    L_0x0056:
        r2 = 2;
        r2 = r5.m636a(r2);
        if (r2 == 0) goto L_0x0054;
    L_0x005d:
        r2 = r5.f487c;
        r3 = r5.f491g;
        r2 = r2[r3];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r3 = r5.f487c;
        r4 = r5.f491g;
        r4 = r4 + 1;
        r3 = r3[r4];
        r3 = r3 & 255;
        r2 = r2 | r3;
        r2 = r5.m633d(r2);
        if (r2 == 0) goto L_0x0054;
    L_0x0078:
        goto L_0x003c;
    L_0x0079:
        r0 = r5.f490f;
        switch(r0) {
            case 1: goto L_0x0086;
            case 2: goto L_0x0089;
            case 3: goto L_0x007e;
            case 4: goto L_0x0093;
            default: goto L_0x007e;
        };
    L_0x007e:
        r0 = new java.lang.RuntimeException;
        r1 = "Internal error";
        r0.<init>(r1);
        throw r0;
    L_0x0086:
        r0 = com.p013a.p014a.p015a.JsonEncoding.UTF8;
        goto L_0x0040;
    L_0x0089:
        r0 = r5.f489e;
        if (r0 == 0) goto L_0x0090;
    L_0x008d:
        r0 = com.p013a.p014a.p015a.JsonEncoding.UTF16_BE;
        goto L_0x0040;
    L_0x0090:
        r0 = com.p013a.p014a.p015a.JsonEncoding.UTF16_LE;
        goto L_0x0040;
    L_0x0093:
        r0 = r5.f489e;
        if (r0 == 0) goto L_0x009a;
    L_0x0097:
        r0 = com.p013a.p014a.p015a.JsonEncoding.UTF32_BE;
        goto L_0x0040;
    L_0x009a:
        r0 = com.p013a.p014a.p015a.JsonEncoding.UTF32_LE;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.a.a():com.a.a.a.a");
    }

    public Reader m637b() {
        JsonEncoding b = this.f485a.m570b();
        switch (ByteSourceJsonBootstrapper.f484a[b.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return new UTF32Reader(this.f485a, this.f486b, this.f487c, this.f491g, this.f492h, this.f485a.m570b().m547b());
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
            case Type.OTHER_PROFILE /*5*/:
                InputStream inputStream = this.f486b;
                InputStream byteArrayInputStream = inputStream == null ? new ByteArrayInputStream(this.f487c, this.f491g, this.f492h) : this.f491g < this.f492h ? new MergedStream(this.f485a, inputStream, this.f487c, this.f491g, this.f492h) : inputStream;
                return new InputStreamReader(byteArrayInputStream, b.m546a());
            default:
                throw new RuntimeException("Internal error");
        }
    }

    public JsonParser m635a(int i, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z, boolean z2) {
        if (m634a() == JsonEncoding.UTF8 && z) {
            return new UTF8StreamJsonParser(this.f485a, i, this.f486b, objectCodec, bytesToNameCanonicalizer.m860a(z, z2), this.f487c, this.f491g, this.f492h, this.f493i);
        }
        return new ReaderBasedJsonParser(this.f485a, i, m637b(), objectCodec, charsToNameCanonicalizer.m885a(z, z2));
    }

    private boolean m631b(int i) {
        switch (i) {
            case -16842752:
                break;
            case -131072:
                this.f491g += 4;
                this.f490f = 4;
                this.f489e = false;
                return true;
            case 65279:
                this.f489e = true;
                this.f491g += 4;
                this.f490f = 4;
                return true;
            case 65534:
                m630a("2143");
                break;
        }
        m630a("3412");
        int i2 = i >>> 16;
        if (i2 == 65279) {
            this.f491g += 2;
            this.f490f = 2;
            this.f489e = true;
            return true;
        } else if (i2 == 65534) {
            this.f491g += 2;
            this.f490f = 2;
            this.f489e = false;
            return true;
        } else if ((i >>> 8) != 15711167) {
            return false;
        } else {
            this.f491g += 3;
            this.f490f = 1;
            this.f489e = true;
            return true;
        }
    }

    private boolean m632c(int i) {
        if ((i >> 8) == 0) {
            this.f489e = true;
        } else if ((ViewCompat.MEASURED_SIZE_MASK & i) == 0) {
            this.f489e = false;
        } else if ((-16711681 & i) == 0) {
            m630a("3412");
        } else if ((-65281 & i) != 0) {
            return false;
        } else {
            m630a("2143");
        }
        this.f490f = 4;
        return true;
    }

    private boolean m633d(int i) {
        if ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) == 0) {
            this.f489e = true;
        } else if ((i & MotionEventCompat.ACTION_MASK) != 0) {
            return false;
        } else {
            this.f489e = false;
        }
        this.f490f = 2;
        return true;
    }

    private void m630a(String str) {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    protected boolean m636a(int i) {
        int i2 = this.f492h - this.f491g;
        while (i2 < i) {
            int i3;
            if (this.f486b == null) {
                i3 = -1;
            } else {
                i3 = this.f486b.read(this.f487c, this.f492h, this.f487c.length - this.f492h);
            }
            if (i3 < 1) {
                return false;
            }
            this.f492h += i3;
            i2 = i3 + i2;
        }
        return true;
    }
}
