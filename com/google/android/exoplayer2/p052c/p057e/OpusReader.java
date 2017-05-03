package com.google.android.exoplayer2.p052c.p057e;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.p057e.StreamReader.StreamReader;
import com.google.api.client.http.ExponentialBackOffPolicy;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

/* renamed from: com.google.android.exoplayer2.c.e.g */
final class OpusReader extends StreamReader {
    private static final int f2965a;
    private static final byte[] f2966b;
    private boolean f2967c;

    OpusReader() {
    }

    static {
        f2965a = Util.m4524e("Opus");
        f2966b = new byte[]{(byte) 79, (byte) 112, (byte) 117, (byte) 115, (byte) 72, (byte) 101, (byte) 97, (byte) 100};
    }

    public static boolean m3511a(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.m4452b() < f2966b.length) {
            return false;
        }
        byte[] bArr = new byte[f2966b.length];
        parsableByteArray.m4451a(bArr, 0, f2966b.length);
        return Arrays.equals(bArr, f2966b);
    }

    protected void m3512a(boolean z) {
        super.m3483a(z);
        if (z) {
            this.f2967c = false;
        }
    }

    protected long m3514b(ParsableByteArray parsableByteArray) {
        return m3487c(m3509a(parsableByteArray.f3831a));
    }

    protected boolean m3513a(ParsableByteArray parsableByteArray, long j, StreamReader streamReader) {
        if (this.f2967c) {
            boolean z = parsableByteArray.m4468n() == f2965a;
            parsableByteArray.m4455c(0);
            return z;
        }
        Object copyOf = Arrays.copyOf(parsableByteArray.f3831a, parsableByteArray.m4454c());
        int i = copyOf[9] & MotionEventCompat.ACTION_MASK;
        int i2 = ((copyOf[11] & MotionEventCompat.ACTION_MASK) << 8) | (copyOf[10] & MotionEventCompat.ACTION_MASK);
        List arrayList = new ArrayList(3);
        arrayList.add(copyOf);
        m3510a(arrayList, i2);
        m3510a(arrayList, 3840);
        streamReader.f2968a = Format.m2862a(null, "audio/opus", null, -1, -1, i, 48000, arrayList, null, 0, "und");
        this.f2967c = true;
        return true;
    }

    private void m3510a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
    }

    private long m3509a(byte[] bArr) {
        int i;
        int i2 = bArr[0] & MotionEventCompat.ACTION_MASK;
        switch (i2 & 3) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                i = 1;
                break;
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                i = 2;
                break;
            default:
                i = bArr[1] & 63;
                break;
        }
        int i3 = i2 >> 3;
        i2 = i3 & 3;
        if (i3 >= 16) {
            i3 = 2500 << i2;
        } else if (i3 >= 12) {
            i3 = AbstractSpiCall.DEFAULT_TIMEOUT << (i2 & 1);
        } else if (i2 == 3) {
            i3 = ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS;
        } else {
            i3 = AbstractSpiCall.DEFAULT_TIMEOUT << i2;
        }
        return (long) (i3 * i);
    }
}
