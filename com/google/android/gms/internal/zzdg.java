package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@zzme
public abstract class zzdg {
    @Nullable
    private static MessageDigest zzym;
    protected Object zzrJ;

    static {
        zzym = null;
    }

    public zzdg() {
        this.zzrJ = new Object();
    }

    abstract byte[] zzF(String str);

    @Nullable
    protected MessageDigest zzet() {
        MessageDigest messageDigest;
        synchronized (this.zzrJ) {
            if (zzym != null) {
                messageDigest = zzym;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        zzym = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = zzym;
            }
        }
        return messageDigest;
    }
}
