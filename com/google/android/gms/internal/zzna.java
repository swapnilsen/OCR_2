package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.zznm.zza;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@zzme
public class zzna {
    @Nullable
    public String zzRA;
    @Nullable
    public Bundle zzRF;
    @Nullable
    public List<String> zzRM;
    @Nullable
    public Bundle zzTf;
    @Nullable
    public zza zzTg;
    @Nullable
    public String zzTh;
    public zzmk zzTi;
    public zzni zzTj;
    public JSONObject zzTk;
    @Nullable
    public Info zzpR;
    @Nullable
    public Location zzzb;

    public zzna() {
        this.zzTk = new JSONObject();
        this.zzRM = new ArrayList();
    }

    public zzna zza(zzni com_google_android_gms_internal_zzni) {
        this.zzTj = com_google_android_gms_internal_zzni;
        return this;
    }

    public zzna zza(zza com_google_android_gms_internal_zznm_zza) {
        this.zzTg = com_google_android_gms_internal_zznm_zza;
        return this;
    }

    public zzna zzaK(String str) {
        this.zzRA = str;
        return this;
    }

    public zzna zzaL(String str) {
        this.zzTh = str;
        return this;
    }

    public zzna zzb(Info info) {
        this.zzpR = info;
        return this;
    }

    public zzna zzc(Location location) {
        this.zzzb = location;
        return this;
    }

    public zzna zze(Bundle bundle) {
        this.zzTf = bundle;
        return this;
    }

    public zzna zzf(Bundle bundle) {
        this.zzRF = bundle;
        return this;
    }

    public zzna zzf(zzmk com_google_android_gms_internal_zzmk) {
        this.zzTi = com_google_android_gms_internal_zzmk;
        return this;
    }

    public zzna zzg(JSONObject jSONObject) {
        this.zzTk = jSONObject;
        return this;
    }

    public zzna zzk(List<String> list) {
        if (list == null) {
            this.zzRM.clear();
        }
        this.zzRM = list;
        return this;
    }
}
