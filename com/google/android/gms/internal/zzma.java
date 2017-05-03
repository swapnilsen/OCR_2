package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.internal.zzlx.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@zzme
public class zzma implements zza<zzgw> {
    private final boolean zzRc;
    private final boolean zzRd;

    public zzma(boolean z, boolean z2) {
        this.zzRc = z;
        this.zzRd = z2;
    }

    public /* synthetic */ zzha.zza zza(zzlx com_google_android_gms_internal_zzlx, JSONObject jSONObject) {
        return zzc(com_google_android_gms_internal_zzlx, jSONObject);
    }

    public zzgw zzc(zzlx com_google_android_gms_internal_zzlx, JSONObject jSONObject) {
        View view = null;
        List<zzqm> zza = com_google_android_gms_internal_zzlx.zza(jSONObject, "images", true, this.zzRc, this.zzRd);
        Future zza2 = com_google_android_gms_internal_zzlx.zza(jSONObject, "secondary_image", false, this.zzRc);
        Future zzd = com_google_android_gms_internal_zzlx.zzd(jSONObject);
        zzqm zzc = com_google_android_gms_internal_zzlx.zzc(jSONObject, "video");
        List arrayList = new ArrayList();
        for (zzqm com_google_android_gms_internal_zzqm : zza) {
            arrayList.add((zzgu) com_google_android_gms_internal_zzqm.get());
        }
        zzqw zzb = zzlx.zzb(zzc);
        String string = jSONObject.getString("headline");
        String string2 = jSONObject.getString("body");
        zzhf com_google_android_gms_internal_zzhf = (zzhf) zza2.get();
        String string3 = jSONObject.getString("call_to_action");
        String string4 = jSONObject.getString("advertiser");
        zzgs com_google_android_gms_internal_zzgs = (zzgs) zzd.get();
        Bundle bundle = new Bundle();
        zzfa zzlG = zzb != null ? zzb.zzlG() : null;
        if (zzb != null) {
            view = zzb.getView();
        }
        return new zzgw(string, arrayList, string2, com_google_android_gms_internal_zzhf, string3, string4, com_google_android_gms_internal_zzgs, bundle, zzlG, view);
    }
}
