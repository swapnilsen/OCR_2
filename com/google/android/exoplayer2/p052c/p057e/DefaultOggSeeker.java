package com.google.android.exoplayer2.p052c.p057e;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.SeekMap;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.EOFException;
import java.io.IOException;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.e.a */
final class DefaultOggSeeker implements OggSeeker {
    private final OggPageHeader f2911a;
    private final long f2912b;
    private final long f2913c;
    private final StreamReader f2914d;
    private int f2915e;
    private long f2916f;
    private volatile long f2917g;
    private long f2918h;
    private long f2919i;
    private long f2920j;
    private long f2921k;
    private long f2922l;
    private long f2923m;

    /* renamed from: com.google.android.exoplayer2.c.e.a.a */
    private class DefaultOggSeeker implements SeekMap {
        final /* synthetic */ DefaultOggSeeker f2910a;

        private DefaultOggSeeker(DefaultOggSeeker defaultOggSeeker) {
            this.f2910a = defaultOggSeeker;
        }

        public boolean m3450a() {
            return true;
        }

        public long m3452b(long j) {
            if (j == 0) {
                this.f2910a.f2917g = 0;
                return this.f2910a.f2912b;
            }
            this.f2910a.f2917g = this.f2910a.f2914d.m3487c(j);
            return this.f2910a.m3455a(this.f2910a.f2912b, this.f2910a.f2917g, 30000);
        }

        public long m3451b() {
            return this.f2910a.f2914d.m3485b(this.f2910a.f2916f);
        }
    }

    public /* synthetic */ SeekMap m3470d() {
        return m3466b();
    }

    public DefaultOggSeeker(long j, long j2, StreamReader streamReader) {
        this.f2911a = new OggPageHeader();
        boolean z = j >= 0 && j2 > j;
        Assertions.m4404a(z);
        this.f2914d = streamReader;
        this.f2912b = j;
        this.f2913c = j2;
        this.f2915e = 0;
    }

    public long m3463a(ExtractorInput extractorInput) {
        long j = 0;
        switch (this.f2915e) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                this.f2918h = extractorInput.m3238c();
                this.f2915e = 1;
                j = this.f2913c - 65307;
                if (j > this.f2918h) {
                    return j;
                }
                break;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                if (this.f2919i != 0) {
                    long a = m3462a(this.f2919i, extractorInput);
                    if (a >= 0) {
                        return a;
                    }
                    ExtractorInput extractorInput2 = extractorInput;
                    j = m3464a(extractorInput2, this.f2919i, -(a + 2));
                }
                this.f2915e = 3;
                return -(j + 2);
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return -1;
            default:
                throw new IllegalStateException();
        }
        this.f2916f = m3468c(extractorInput);
        this.f2915e = 3;
        return this.f2918h;
    }

    public long a_() {
        boolean z = this.f2915e == 3 || this.f2915e == 2;
        Assertions.m4404a(z);
        this.f2919i = this.f2917g;
        this.f2915e = 2;
        m3469c();
        return this.f2919i;
    }

    public DefaultOggSeeker m3466b() {
        return this.f2916f != 0 ? new DefaultOggSeeker() : null;
    }

    public void m3469c() {
        this.f2920j = this.f2912b;
        this.f2921k = this.f2913c;
        this.f2922l = 0;
        this.f2923m = this.f2916f;
    }

    public long m3462a(long j, ExtractorInput extractorInput) {
        if (this.f2920j == this.f2921k) {
            return -(this.f2922l + 2);
        }
        long c = extractorInput.m3238c();
        if (m3465a(extractorInput, this.f2921k)) {
            this.f2911a.m3508a(extractorInput, false);
            extractorInput.m3232a();
            long j2 = j - this.f2911a.f2956c;
            int i = this.f2911a.f2961h + this.f2911a.f2962i;
            if (j2 < 0 || j2 > 72000) {
                if (j2 < 0) {
                    this.f2921k = c;
                    this.f2923m = this.f2911a.f2956c;
                } else {
                    this.f2920j = extractorInput.m3238c() + ((long) i);
                    this.f2922l = this.f2911a.f2956c;
                    if ((this.f2921k - this.f2920j) + ((long) i) < 100000) {
                        extractorInput.m3235b(i);
                        return -(this.f2922l + 2);
                    }
                }
                if (this.f2921k - this.f2920j < 100000) {
                    this.f2921k = this.f2920j;
                    return this.f2920j;
                }
                return Math.min(Math.max((extractorInput.m3238c() - ((long) ((j2 <= 0 ? 2 : 1) * i))) + ((j2 * (this.f2921k - this.f2920j)) / (this.f2923m - this.f2922l)), this.f2920j), this.f2921k - 1);
            }
            extractorInput.m3235b(i);
            return -(this.f2911a.f2956c + 2);
        } else if (this.f2920j != c) {
            return this.f2920j;
        } else {
            throw new IOException("No ogg page can be found.");
        }
    }

    private long m3455a(long j, long j2, long j3) {
        long j4 = ((((this.f2913c - this.f2912b) * j2) / this.f2916f) - j3) + j;
        if (j4 < this.f2912b) {
            j4 = this.f2912b;
        }
        if (j4 >= this.f2913c) {
            return this.f2913c - 1;
        }
        return j4;
    }

    void m3467b(ExtractorInput extractorInput) {
        if (!m3465a(extractorInput, this.f2913c)) {
            throw new EOFException();
        }
    }

    boolean m3465a(ExtractorInput extractorInput, long j) {
        long min = Math.min(3 + j, this.f2913c);
        byte[] bArr = new byte[ItemAnimator.FLAG_MOVED];
        int length = bArr.length;
        while (true) {
            if (extractorInput.m3238c() + ((long) length) > min) {
                length = (int) (min - extractorInput.m3238c());
                if (length < 4) {
                    return false;
                }
            }
            extractorInput.m3237b(bArr, 0, length, false);
            int i = 0;
            while (i < length - 3) {
                if (bArr[i] == 79 && bArr[i + 1] == (byte) 103 && bArr[i + 2] == (byte) 103 && bArr[i + 3] == 83) {
                    extractorInput.m3235b(i);
                    return true;
                }
                i++;
            }
            extractorInput.m3235b(length - 3);
        }
    }

    long m3468c(ExtractorInput extractorInput) {
        m3467b(extractorInput);
        this.f2911a.m3507a();
        while ((this.f2911a.f2955b & 4) != 4 && extractorInput.m3238c() < this.f2913c) {
            this.f2911a.m3508a(extractorInput, false);
            extractorInput.m3235b(this.f2911a.f2961h + this.f2911a.f2962i);
        }
        return this.f2911a.f2956c;
    }

    long m3464a(ExtractorInput extractorInput, long j, long j2) {
        this.f2911a.m3508a(extractorInput, false);
        while (this.f2911a.f2956c < j) {
            extractorInput.m3235b(this.f2911a.f2961h + this.f2911a.f2962i);
            j2 = this.f2911a.f2956c;
            this.f2911a.m3508a(extractorInput, false);
        }
        extractorInput.m3232a();
        return j2;
    }
}
