package com.google.android.gms.internal;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.security.MessageDigest;

@zzme
public class zzdj extends zzdg {
    private MessageDigest zzyt;

    public byte[] zzF(String str) {
        byte[] bArr;
        int i = 4;
        byte[] zza = zza(str.split(" "));
        this.zzyt = zzet();
        synchronized (this.zzrJ) {
            if (this.zzyt == null) {
                bArr = new byte[0];
            } else {
                this.zzyt.reset();
                this.zzyt.update(zza);
                Object digest = this.zzyt.digest();
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }

    byte[] zza(String[] strArr) {
        int i = 0;
        if (strArr.length == 1) {
            return zzdi.zzp(zzdi.zzH(strArr[0]));
        }
        if (strArr.length < 5) {
            byte[] bArr = new byte[(strArr.length * 2)];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                byte[] zzs = zzs(zzdi.zzH(strArr[i2]));
                bArr[i2 * 2] = zzs[0];
                bArr[(i2 * 2) + 1] = zzs[1];
            }
            return bArr;
        }
        byte[] bArr2 = new byte[strArr.length];
        while (i < strArr.length) {
            bArr2[i] = zzr(zzdi.zzH(strArr[i]));
            i++;
        }
        return bArr2;
    }

    byte zzr(int i) {
        return (byte) ((((i & MotionEventCompat.ACTION_MASK) ^ ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((ViewCompat.MEASURED_STATE_MASK & i) >> 24));
    }

    byte[] zzs(int i) {
        int i2 = (SupportMenu.USER_MASK & i) ^ ((SupportMenu.CATEGORY_MASK & i) >> 16);
        return new byte[]{(byte) i2, (byte) (i2 >> 8)};
    }
}
