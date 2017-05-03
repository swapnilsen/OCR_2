package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

public class zzbwl {
    private final byte[] zzcsP;
    private int zzcsQ;
    private int zzcsR;

    public zzbwl(byte[] bArr) {
        int i;
        this.zzcsP = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        for (i = 0; i < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i++) {
            this.zzcsP[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i2++) {
            i = ((i + this.zzcsP[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.zzcsP[i2];
            this.zzcsP[i2] = this.zzcsP[i];
            this.zzcsP[i] = b;
        }
        this.zzcsQ = 0;
        this.zzcsR = 0;
    }

    public void zzaa(byte[] bArr) {
        int i = this.zzcsQ;
        int i2 = this.zzcsR;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.zzcsP[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.zzcsP[i];
            this.zzcsP[i] = this.zzcsP[i2];
            this.zzcsP[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzcsP[(this.zzcsP[i] + this.zzcsP[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.zzcsQ = i;
        this.zzcsR = i2;
    }
}
