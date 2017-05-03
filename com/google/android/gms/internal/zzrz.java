package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzrz {
    private final zzsc zzadO;

    protected zzrz(zzsc com_google_android_gms_internal_zzsc) {
        zzac.zzw(com_google_android_gms_internal_zzsc);
        this.zzadO = com_google_android_gms_internal_zzsc;
    }

    private void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zztd com_google_android_gms_internal_zztd = null;
        if (this.zzadO != null) {
            com_google_android_gms_internal_zztd = this.zzadO.zzoe();
        }
        if (com_google_android_gms_internal_zztd != null) {
            com_google_android_gms_internal_zztd.zza(i, str, obj, obj2, obj3);
            return;
        }
        String str2 = (String) zzsw.zzafl.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzc(str, obj, obj2, obj3));
        }
    }

    protected static String zzc(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        Object zzk = zzk(obj);
        Object zzk2 = zzk(obj2);
        Object zzk3 = zzk(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzk)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzk);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzk2)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzk2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzk3)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzk3);
        }
        return stringBuilder.toString();
    }

    private static String zzk(Object obj) {
        if (obj == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
        } else {
            return obj == Boolean.TRUE ? "true" : "false";
        }
    }

    protected Context getContext() {
        return this.zzadO.getContext();
    }

    public void zza(String str, Object obj) {
        zza(2, str, obj, null, null);
    }

    public void zza(String str, Object obj, Object obj2) {
        zza(2, str, obj, obj2, null);
    }

    public void zza(String str, Object obj, Object obj2, Object obj3) {
        zza(3, str, obj, obj2, obj3);
    }

    public void zzb(String str, Object obj) {
        zza(3, str, obj, null, null);
    }

    public void zzb(String str, Object obj, Object obj2) {
        zza(3, str, obj, obj2, null);
    }

    public void zzb(String str, Object obj, Object obj2, Object obj3) {
        zza(5, str, obj, obj2, obj3);
    }

    public void zzbP(String str) {
        zza(2, str, null, null, null);
    }

    public void zzbQ(String str) {
        zza(3, str, null, null, null);
    }

    public void zzbR(String str) {
        zza(4, str, null, null, null);
    }

    public void zzbS(String str) {
        zza(5, str, null, null, null);
    }

    public void zzbT(String str) {
        zza(6, str, null, null, null);
    }

    public void zzc(String str, Object obj) {
        zza(4, str, obj, null, null);
    }

    public void zzc(String str, Object obj, Object obj2) {
        zza(5, str, obj, obj2, null);
    }

    public void zzd(String str, Object obj) {
        zza(5, str, obj, null, null);
    }

    public void zzd(String str, Object obj, Object obj2) {
        zza(6, str, obj, obj2, null);
    }

    public void zze(String str, Object obj) {
        zza(6, str, obj, null, null);
    }

    public boolean zzkI() {
        return Log.isLoggable((String) zzsw.zzafl.get(), 2);
    }

    protected zzry zzmA() {
        return this.zzadO.zzmA();
    }

    protected zztn zzmB() {
        return this.zzadO.zzmB();
    }

    protected void zzmR() {
        this.zzadO.zzmR();
    }

    public GoogleAnalytics zzmu() {
        return this.zzadO.zzof();
    }

    public zzsc zznQ() {
        return this.zzadO;
    }

    protected zze zznR() {
        return this.zzadO.zznR();
    }

    protected zztd zznS() {
        return this.zzadO.zznS();
    }

    protected zzsp zznT() {
        return this.zzadO.zznT();
    }

    protected zzh zznU() {
        return this.zzadO.zznU();
    }

    protected zzst zznV() {
        return this.zzadO.zznV();
    }

    protected zztg zznW() {
        return this.zzadO.zznW();
    }

    protected zzsk zznX() {
        return this.zzadO.zzoi();
    }

    protected zzrx zznY() {
        return this.zzadO.zzoh();
    }

    protected zzsh zznZ() {
        return this.zzadO.zznZ();
    }

    protected zzss zzoa() {
        return this.zzadO.zzoa();
    }
}
