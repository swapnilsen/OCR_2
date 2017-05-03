package com.google.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzam;
import com.google.android.gms.common.util.zzw;

/* renamed from: com.google.firebase.c */
public final class C1489c {
    private final String f4515a;
    private final String f4516b;
    private final String f4517c;
    private final String f4518d;
    private final String f4519e;
    private final String f4520f;

    private C1489c(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        zzac.zza(!zzw.zzdz(str), (Object) "ApplicationId must be set.");
        this.f4516b = str;
        this.f4515a = str2;
        this.f4517c = str3;
        this.f4518d = str4;
        this.f4519e = str5;
        this.f4520f = str6;
    }

    public static C1489c m5084a(Context context) {
        zzam com_google_android_gms_common_internal_zzam = new zzam(context);
        Object string = com_google_android_gms_common_internal_zzam.getString("google_app_id");
        return TextUtils.isEmpty(string) ? null : new C1489c(string, com_google_android_gms_common_internal_zzam.getString("google_api_key"), com_google_android_gms_common_internal_zzam.getString("firebase_database_url"), com_google_android_gms_common_internal_zzam.getString("ga_trackingId"), com_google_android_gms_common_internal_zzam.getString("gcm_defaultSenderId"), com_google_android_gms_common_internal_zzam.getString("google_storage_bucket"));
    }

    public String m5085a() {
        return this.f4515a;
    }

    public String m5086b() {
        return this.f4516b;
    }

    public String m5087c() {
        return this.f4519e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1489c)) {
            return false;
        }
        C1489c c1489c = (C1489c) obj;
        return zzaa.equal(this.f4516b, c1489c.f4516b) && zzaa.equal(this.f4515a, c1489c.f4515a) && zzaa.equal(this.f4517c, c1489c.f4517c) && zzaa.equal(this.f4518d, c1489c.f4518d) && zzaa.equal(this.f4519e, c1489c.f4519e) && zzaa.equal(this.f4520f, c1489c.f4520f);
    }

    public int hashCode() {
        return zzaa.hashCode(this.f4516b, this.f4515a, this.f4517c, this.f4518d, this.f4519e, this.f4520f);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("applicationId", this.f4516b).zzg("apiKey", this.f4515a).zzg("databaseUrl", this.f4517c).zzg("gcmSenderId", this.f4519e).zzg("storageBucket", this.f4520f).toString();
    }
}
