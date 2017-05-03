package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzlx.zza;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@zzme
public class zzlz implements zza<zzgv> {
    private final boolean zzRc;
    private final boolean zzRd;

    public zzlz(boolean z, boolean z2) {
        this.zzRc = z;
        this.zzRd = z2;
    }

    public /* synthetic */ zzha.zza zza(zzlx com_google_android_gms_internal_zzlx, JSONObject jSONObject) {
        return zzb(com_google_android_gms_internal_zzlx, jSONObject);
    }

    public zzgv zzb(zzlx com_google_android_gms_internal_zzlx, JSONObject jSONObject) {
        List<zzqm> zza = com_google_android_gms_internal_zzlx.zza(jSONObject, "images", true, this.zzRc, this.zzRd);
        Future zza2 = com_google_android_gms_internal_zzlx.zza(jSONObject, "app_icon", true, this.zzRc);
        zzqm zzc = com_google_android_gms_internal_zzlx.zzc(jSONObject, "video");
        Future zzd = com_google_android_gms_internal_zzlx.zzd(jSONObject);
        List arrayList = new ArrayList();
        for (zzqm com_google_android_gms_internal_zzqm : zza) {
            arrayList.add((zzgu) com_google_android_gms_internal_zzqm.get());
        }
        zzqw zzb = zzlx.zzb(zzc);
        return new zzgv(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzhf) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString(Param.PRICE), (zzgs) zzd.get(), new Bundle(), zzb != null ? zzb.zzlG() : null, zzb != null ? zzb.getView() : null);
    }
}
