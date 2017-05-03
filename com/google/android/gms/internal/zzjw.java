package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzme
public class zzjw {
    public List<String> zza(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void zza(Context context, String str, zzpb com_google_android_gms_internal_zzpb, String str2, boolean z, List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? "1" : "0";
            for (String replaceAll : list) {
                String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", com_google_android_gms_internal_zzpb.zzWc.zzKK).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", zzw.zzcQ().getSessionId()).replaceAll("@gw_seqnum@", com_google_android_gms_internal_zzpb.zzRB);
                if (!TextUtils.isEmpty(com_google_android_gms_internal_zzpb.zzWd)) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetstatus@", com_google_android_gms_internal_zzpb.zzWd);
                }
                if (com_google_android_gms_internal_zzpb.zzLi != null) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", com_google_android_gms_internal_zzpb.zzLi.zzKo).replaceAll("@gw_allocid@", com_google_android_gms_internal_zzpb.zzLi.zzKq);
                }
                zzw.zzcM().zzf(context, str, replaceAll2);
            }
        }
    }
}
