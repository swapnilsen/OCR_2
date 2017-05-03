package com.google.android.exoplayer2.p052c.p054b;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Stack;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.b.a */
final class DefaultEbmlReader implements EbmlReader {
    private final byte[] f2558a;
    private final Stack<DefaultEbmlReader> f2559b;
    private final VarintReader f2560c;
    private EbmlReaderOutput f2561d;
    private int f2562e;
    private int f2563f;
    private long f2564g;

    /* renamed from: com.google.android.exoplayer2.c.b.a.a */
    private static final class DefaultEbmlReader {
        private final int f2556a;
        private final long f2557b;

        private DefaultEbmlReader(int i, long j) {
            this.f2556a = i;
            this.f2557b = j;
        }
    }

    DefaultEbmlReader() {
        this.f2558a = new byte[8];
        this.f2559b = new Stack();
        this.f2560c = new VarintReader();
    }

    public void m3172a(EbmlReaderOutput ebmlReaderOutput) {
        this.f2561d = ebmlReaderOutput;
    }

    public void m3171a() {
        this.f2562e = 0;
        this.f2559b.clear();
        this.f2560c.m3228a();
    }

    public boolean m3173a(ExtractorInput extractorInput) {
        Assertions.m4406b(this.f2561d != null);
        while (true) {
            if (this.f2559b.isEmpty() || extractorInput.m3238c() < ((DefaultEbmlReader) this.f2559b.peek()).f2557b) {
                if (this.f2562e == 0) {
                    long a = this.f2560c.m3227a(extractorInput, true, false, 4);
                    if (a == -2) {
                        a = m3169b(extractorInput);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.f2563f = (int) a;
                    this.f2562e = 1;
                }
                if (this.f2562e == 1) {
                    this.f2564g = this.f2560c.m3227a(extractorInput, false, true, 8);
                    this.f2562e = 2;
                }
                int a2 = this.f2561d.m3174a(this.f2563f);
                switch (a2) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        extractorInput.m3235b((int) this.f2564g);
                        this.f2562e = 0;
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        long c = extractorInput.m3238c();
                        this.f2559b.add(new DefaultEbmlReader(this.f2564g + c, null));
                        this.f2561d.m3178a(this.f2563f, c, this.f2564g);
                        this.f2562e = 0;
                        return true;
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        if (this.f2564g > 8) {
                            throw new ParserException("Invalid integer size: " + this.f2564g);
                        }
                        this.f2561d.m3177a(this.f2563f, m3167a(extractorInput, (int) this.f2564g));
                        this.f2562e = 0;
                        return true;
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        if (this.f2564g > 2147483647L) {
                            throw new ParserException("String element size: " + this.f2564g);
                        }
                        this.f2561d.m3179a(this.f2563f, m3170c(extractorInput, (int) this.f2564g));
                        this.f2562e = 0;
                        return true;
                    case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                        this.f2561d.m3176a(this.f2563f, (int) this.f2564g, extractorInput);
                        this.f2562e = 0;
                        return true;
                    case Type.OTHER_PROFILE /*5*/:
                        if (this.f2564g == 4 || this.f2564g == 8) {
                            this.f2561d.m3175a(this.f2563f, m3168b(extractorInput, (int) this.f2564g));
                            this.f2562e = 0;
                            return true;
                        }
                        throw new ParserException("Invalid float size: " + this.f2564g);
                    default:
                        throw new ParserException("Invalid element type " + a2);
                }
            }
            this.f2561d.m3181c(((DefaultEbmlReader) this.f2559b.pop()).f2556a);
            return true;
        }
    }

    private long m3169b(ExtractorInput extractorInput) {
        extractorInput.m3232a();
        while (true) {
            extractorInput.m3240c(this.f2558a, 0, 4);
            int a = VarintReader.m3225a(this.f2558a[0]);
            if (a != -1 && a <= 4) {
                int a2 = (int) VarintReader.m3226a(this.f2558a, a, false);
                if (this.f2561d.m3180b(a2)) {
                    extractorInput.m3235b(a);
                    return (long) a2;
                }
            }
            extractorInput.m3235b(1);
        }
    }

    private long m3167a(ExtractorInput extractorInput, int i) {
        int i2 = 0;
        extractorInput.m3236b(this.f2558a, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.f2558a[i2] & MotionEventCompat.ACTION_MASK));
            i2++;
        }
        return j;
    }

    private double m3168b(ExtractorInput extractorInput, int i) {
        long a = m3167a(extractorInput, i);
        if (i == 4) {
            return (double) Float.intBitsToFloat((int) a);
        }
        return Double.longBitsToDouble(a);
    }

    private String m3170c(ExtractorInput extractorInput, int i) {
        if (i == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        byte[] bArr = new byte[i];
        extractorInput.m3236b(bArr, 0, i);
        return new String(bArr);
    }
}
