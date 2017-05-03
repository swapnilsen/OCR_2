package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@zzme
class zzje {
    final int zzJf;
    final String zzts;
    final zzec zzum;

    zzje(zzec com_google_android_gms_internal_zzec, String str, int i) {
        this.zzum = com_google_android_gms_internal_zzec;
        this.zzts = str;
        this.zzJf = i;
    }

    zzje(zzjb com_google_android_gms_internal_zzjb) {
        this(com_google_android_gms_internal_zzjb.zzgx(), com_google_android_gms_internal_zzjb.getAdUnitId(), com_google_android_gms_internal_zzjb.getNetworkType());
    }

    static zzje zzal(String str) {
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            String str2 = new String(Base64.decode(split[0], 0), "UTF-8");
            int parseInt = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            zzje com_google_android_gms_internal_zzje = new zzje((zzec) zzec.CREATOR.createFromParcel(obtain), str2, parseInt);
            obtain.recycle();
            return com_google_android_gms_internal_zzje;
        } catch (Throwable th) {
            obtain.recycle();
        }
    }

    String zzgL() {
        String encodeToString;
        Parcel obtain = Parcel.obtain();
        try {
            encodeToString = Base64.encodeToString(this.zzts.getBytes("UTF-8"), 0);
            String num = Integer.toString(this.zzJf);
            this.zzum.writeToParcel(obtain, 0);
            String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
            encodeToString = new StringBuilder(((String.valueOf(encodeToString).length() + 2) + String.valueOf(num).length()) + String.valueOf(encodeToString2).length()).append(encodeToString).append("\u0000").append(num).append("\u0000").append(encodeToString2).toString();
            return encodeToString;
        } catch (UnsupportedEncodingException e) {
            encodeToString = "QueueSeed encode failed because UTF-8 is not available.";
            zzqf.m4708e(encodeToString);
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        } finally {
            obtain.recycle();
        }
    }
}
