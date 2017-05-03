package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@zzme
public class zzor extends zza {
    public static final Creator<zzor> CREATOR;
    public final String zzVQ;
    public final String zzVR;
    public final boolean zzVS;
    public final boolean zzVT;
    public final List<String> zzVU;

    static {
        CREATOR = new zzos();
    }

    public zzor(String str, String str2, boolean z, boolean z2, List<String> list) {
        this.zzVQ = str;
        this.zzVR = str2;
        this.zzVS = z;
        this.zzVT = z2;
        this.zzVU = list;
    }

    @Nullable
    public static zzor zzh(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("click_string", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        String optString2 = jSONObject.optString("report_url", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        boolean optBoolean = jSONObject.optBoolean("rendered_ad_enabled", false);
        boolean optBoolean2 = jSONObject.optBoolean("non_malicious_reporting_enabled", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("allowed_headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        List arrayList = new ArrayList();
        while (i < optJSONArray.length()) {
            Object optString3 = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString3)) {
                arrayList.add(optString3.toLowerCase(Locale.ENGLISH));
            }
            i++;
        }
        return new zzor(optString, optString2, optBoolean, optBoolean2, arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzos.zza(this, parcel, i);
    }
}
