package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.analytics.zzf;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Map;

public final class zzrl extends zzf<zzrl> {
    private String mName;
    private String zzFV;
    private String zzGV;
    private String zzacO;
    private String zzacP;
    private String zzacQ;
    private String zzacR;
    private String zzacS;
    private String zzacT;
    private String zzacU;

    public String getContent() {
        return this.zzFV;
    }

    public String getId() {
        return this.zzGV;
    }

    public String getName() {
        return this.mName;
    }

    public String getSource() {
        return this.zzacO;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.mName);
        hashMap.put(Param.SOURCE, this.zzacO);
        hashMap.put(Param.MEDIUM, this.zzacP);
        hashMap.put("keyword", this.zzacQ);
        hashMap.put(Param.CONTENT, this.zzFV);
        hashMap.put(FacebookAdapter.KEY_ID, this.zzGV);
        hashMap.put("adNetworkId", this.zzacR);
        hashMap.put("gclid", this.zzacS);
        hashMap.put("dclid", this.zzacT);
        hashMap.put(Param.ACLID, this.zzacU);
        return zzf.zzj(hashMap);
    }

    public void zza(zzrl com_google_android_gms_internal_zzrl) {
        if (!TextUtils.isEmpty(this.mName)) {
            com_google_android_gms_internal_zzrl.setName(this.mName);
        }
        if (!TextUtils.isEmpty(this.zzacO)) {
            com_google_android_gms_internal_zzrl.zzbr(this.zzacO);
        }
        if (!TextUtils.isEmpty(this.zzacP)) {
            com_google_android_gms_internal_zzrl.zzbs(this.zzacP);
        }
        if (!TextUtils.isEmpty(this.zzacQ)) {
            com_google_android_gms_internal_zzrl.zzbt(this.zzacQ);
        }
        if (!TextUtils.isEmpty(this.zzFV)) {
            com_google_android_gms_internal_zzrl.zzbu(this.zzFV);
        }
        if (!TextUtils.isEmpty(this.zzGV)) {
            com_google_android_gms_internal_zzrl.zzbv(this.zzGV);
        }
        if (!TextUtils.isEmpty(this.zzacR)) {
            com_google_android_gms_internal_zzrl.zzbw(this.zzacR);
        }
        if (!TextUtils.isEmpty(this.zzacS)) {
            com_google_android_gms_internal_zzrl.zzbx(this.zzacS);
        }
        if (!TextUtils.isEmpty(this.zzacT)) {
            com_google_android_gms_internal_zzrl.zzby(this.zzacT);
        }
        if (!TextUtils.isEmpty(this.zzacU)) {
            com_google_android_gms_internal_zzrl.zzbz(this.zzacU);
        }
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrl) com_google_android_gms_analytics_zzf);
    }

    public void zzbr(String str) {
        this.zzacO = str;
    }

    public void zzbs(String str) {
        this.zzacP = str;
    }

    public void zzbt(String str) {
        this.zzacQ = str;
    }

    public void zzbu(String str) {
        this.zzFV = str;
    }

    public void zzbv(String str) {
        this.zzGV = str;
    }

    public void zzbw(String str) {
        this.zzacR = str;
    }

    public void zzbx(String str) {
        this.zzacS = str;
    }

    public void zzby(String str) {
        this.zzacT = str;
    }

    public void zzbz(String str) {
        this.zzacU = str;
    }

    public String zznb() {
        return this.zzacP;
    }

    public String zznc() {
        return this.zzacQ;
    }

    public String zznd() {
        return this.zzacR;
    }

    public String zzne() {
        return this.zzacS;
    }

    public String zznf() {
        return this.zzacT;
    }

    public String zzng() {
        return this.zzacU;
    }
}
