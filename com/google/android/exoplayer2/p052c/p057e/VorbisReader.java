package com.google.android.exoplayer2.p052c.p057e;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.p057e.StreamReader.StreamReader;
import com.google.android.exoplayer2.p052c.p057e.VorbisUtil.VorbisUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.e.j */
final class VorbisReader extends StreamReader {
    private VorbisReader f2979a;
    private int f2980b;
    private boolean f2981c;
    private VorbisUtil f2982d;
    private VorbisUtil f2983e;

    /* renamed from: com.google.android.exoplayer2.c.e.j.a */
    static final class VorbisReader {
        public final VorbisUtil f2974a;
        public final VorbisUtil f2975b;
        public final byte[] f2976c;
        public final VorbisUtil[] f2977d;
        public final int f2978e;

        public VorbisReader(VorbisUtil vorbisUtil, VorbisUtil vorbisUtil2, byte[] bArr, VorbisUtil[] vorbisUtilArr, int i) {
            this.f2974a = vorbisUtil;
            this.f2975b = vorbisUtil2;
            this.f2976c = bArr;
            this.f2977d = vorbisUtilArr;
            this.f2978e = i;
        }
    }

    VorbisReader() {
    }

    public static boolean m3524a(ParsableByteArray parsableByteArray) {
        try {
            return VorbisUtil.m3534a(1, parsableByteArray, true);
        } catch (ParserException e) {
            return false;
        }
    }

    protected void m3525a(boolean z) {
        super.m3483a(z);
        if (z) {
            this.f2979a = null;
            this.f2982d = null;
            this.f2983e = null;
        }
        this.f2980b = 0;
        this.f2981c = false;
    }

    protected void m3529d(long j) {
        boolean z;
        int i = 0;
        super.m3488d(j);
        if (j != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2981c = z;
        if (this.f2982d != null) {
            i = this.f2982d.f3002g;
        }
        this.f2980b = i;
    }

    protected long m3527b(ParsableByteArray parsableByteArray) {
        int i = 0;
        if ((parsableByteArray.f3831a[0] & 1) == 1) {
            return -1;
        }
        int a = VorbisReader.m3522a(parsableByteArray.f3831a[0], this.f2979a);
        if (this.f2981c) {
            i = (this.f2980b + a) / 4;
        }
        VorbisReader.m3523a(parsableByteArray, (long) i);
        this.f2981c = true;
        this.f2980b = a;
        return (long) i;
    }

    protected boolean m3526a(ParsableByteArray parsableByteArray, long j, StreamReader streamReader) {
        if (this.f2979a != null) {
            return false;
        }
        this.f2979a = m3528c(parsableByteArray);
        if (this.f2979a == null) {
            return true;
        }
        List arrayList = new ArrayList();
        arrayList.add(this.f2979a.f2974a.f3005j);
        arrayList.add(this.f2979a.f2976c);
        streamReader.f2968a = Format.m2862a(null, "audio/vorbis", null, this.f2979a.f2974a.f3000e, 65025, this.f2979a.f2974a.f2997b, (int) this.f2979a.f2974a.f2998c, arrayList, null, 0, null);
        return true;
    }

    VorbisReader m3528c(ParsableByteArray parsableByteArray) {
        if (this.f2982d == null) {
            this.f2982d = VorbisUtil.m3532a(parsableByteArray);
            return null;
        } else if (this.f2983e == null) {
            this.f2983e = VorbisUtil.m3537b(parsableByteArray);
            return null;
        } else {
            Object obj = new byte[parsableByteArray.m4454c()];
            System.arraycopy(parsableByteArray.f3831a, 0, obj, 0, parsableByteArray.m4454c());
            VorbisUtil[] a = VorbisUtil.m3536a(parsableByteArray, this.f2982d.f2997b);
            return new VorbisReader(this.f2982d, this.f2983e, obj, a, VorbisUtil.m3530a(a.length - 1));
        }
    }

    static int m3521a(byte b, int i, int i2) {
        return (b >> i2) & (MotionEventCompat.ACTION_MASK >>> (8 - i));
    }

    static void m3523a(ParsableByteArray parsableByteArray, long j) {
        parsableByteArray.m4453b(parsableByteArray.m4454c() + 4);
        parsableByteArray.f3831a[parsableByteArray.m4454c() - 4] = (byte) ((int) (j & 255));
        parsableByteArray.f3831a[parsableByteArray.m4454c() - 3] = (byte) ((int) ((j >>> 8) & 255));
        parsableByteArray.f3831a[parsableByteArray.m4454c() - 2] = (byte) ((int) ((j >>> 16) & 255));
        parsableByteArray.f3831a[parsableByteArray.m4454c() - 1] = (byte) ((int) ((j >>> 24) & 255));
    }

    private static int m3522a(byte b, VorbisReader vorbisReader) {
        if (vorbisReader.f2977d[VorbisReader.m3521a(b, vorbisReader.f2978e, 1)].f2992a) {
            return vorbisReader.f2974a.f3003h;
        }
        return vorbisReader.f2974a.f3002g;
    }
}
