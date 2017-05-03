package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import java.nio.charset.Charset;
import java.security.MessageDigest;

@zzme
public class zzdl extends zzdg {
    private MessageDigest zzyt;
    private final int zzyw;
    private final int zzyx;

    public zzdl(int i) {
        int i2 = i / 8;
        if (i % 8 > 0) {
            i2++;
        }
        this.zzyw = i2;
        this.zzyx = i;
    }

    public byte[] zzF(String str) {
        byte[] bArr;
        synchronized (this.zzrJ) {
            this.zzyt = zzet();
            if (this.zzyt == null) {
                bArr = new byte[0];
            } else {
                this.zzyt.reset();
                this.zzyt.update(str.getBytes(Charset.forName("UTF-8")));
                Object digest = this.zzyt.digest();
                bArr = new byte[(digest.length > this.zzyw ? this.zzyw : digest.length)];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
                if (this.zzyx % 8 > 0) {
                    int i;
                    long j = 0;
                    for (i = 0; i < bArr.length; i++) {
                        if (i > 0) {
                            j <<= 8;
                        }
                        j += (long) (bArr[i] & MotionEventCompat.ACTION_MASK);
                    }
                    j >>>= 8 - (this.zzyx % 8);
                    for (i = this.zzyw - 1; i >= 0; i--) {
                        bArr[i] = (byte) ((int) (255 & j));
                        j >>>= 8;
                    }
                }
            }
        }
        return bArr;
    }
}
