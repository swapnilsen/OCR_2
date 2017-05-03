package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public final class zzoo extends zza {
    public static final Creator<zzoo> CREATOR;
    public final String type;
    public final int zzVP;

    static {
        CREATOR = new zzop();
    }

    public zzoo(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    public zzoo(String str, int i) {
        this.type = str;
        this.zzVP = i;
    }

    @Nullable
    public static zzoo zza(JSONArray jSONArray) {
        return (jSONArray == null || jSONArray.length() == 0) ? null : new zzoo(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    @Nullable
    public static zzoo zzaR(@Nullable String str) {
        zzoo com_google_android_gms_internal_zzoo = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                com_google_android_gms_internal_zzoo = zza(new JSONArray(str));
            } catch (JSONException e) {
            }
        }
        return com_google_android_gms_internal_zzoo;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzoo)) {
            return false;
        }
        zzoo com_google_android_gms_internal_zzoo = (zzoo) obj;
        return zzaa.equal(this.type, com_google_android_gms_internal_zzoo.type) && zzaa.equal(Integer.valueOf(this.zzVP), Integer.valueOf(com_google_android_gms_internal_zzoo.zzVP));
    }

    public int hashCode() {
        return zzaa.hashCode(this.type, Integer.valueOf(this.zzVP));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzop.zza(this, parcel, i);
    }

    public JSONArray zzjP() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rb_type", this.type);
        jSONObject.put("rb_amount", this.zzVP);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }
}
