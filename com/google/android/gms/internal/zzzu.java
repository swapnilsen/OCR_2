package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public class zzzu extends zza {
    public static final Creator<zzzu> CREATOR;
    public final String packageName;
    public final int zzaxZ;
    public final int zzaya;
    public final String zzayb;
    public final String zzayc;
    public final boolean zzayd;
    public final String zzaye;
    public final boolean zzayf;
    public final int zzayg;

    static {
        CREATOR = new zzzv();
    }

    public zzzu(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.packageName = (String) zzac.zzw(str);
        this.zzaxZ = i;
        this.zzaya = i2;
        this.zzaye = str2;
        this.zzayb = str3;
        this.zzayc = str4;
        this.zzayd = !z;
        this.zzayf = z;
        this.zzayg = i3;
    }

    public zzzu(String str, int i, int i2, String str2, String str3, boolean z, String str4, boolean z2, int i3) {
        this.packageName = str;
        this.zzaxZ = i;
        this.zzaya = i2;
        this.zzayb = str2;
        this.zzayc = str3;
        this.zzayd = z;
        this.zzaye = str4;
        this.zzayf = z2;
        this.zzayg = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzu)) {
            return false;
        }
        zzzu com_google_android_gms_internal_zzzu = (zzzu) obj;
        return this.packageName.equals(com_google_android_gms_internal_zzzu.packageName) && this.zzaxZ == com_google_android_gms_internal_zzzu.zzaxZ && this.zzaya == com_google_android_gms_internal_zzzu.zzaya && zzaa.equal(this.zzaye, com_google_android_gms_internal_zzzu.zzaye) && zzaa.equal(this.zzayb, com_google_android_gms_internal_zzzu.zzayb) && zzaa.equal(this.zzayc, com_google_android_gms_internal_zzzu.zzayc) && this.zzayd == com_google_android_gms_internal_zzzu.zzayd && this.zzayf == com_google_android_gms_internal_zzzu.zzayf && this.zzayg == com_google_android_gms_internal_zzzu.zzayg;
    }

    public int hashCode() {
        return zzaa.hashCode(this.packageName, Integer.valueOf(this.zzaxZ), Integer.valueOf(this.zzaya), this.zzaye, this.zzayb, this.zzayc, Boolean.valueOf(this.zzayd), Boolean.valueOf(this.zzayf), Integer.valueOf(this.zzayg));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("package=").append(this.packageName).append(',');
        stringBuilder.append("packageVersionCode=").append(this.zzaxZ).append(',');
        stringBuilder.append("logSource=").append(this.zzaya).append(',');
        stringBuilder.append("logSourceName=").append(this.zzaye).append(',');
        stringBuilder.append("uploadAccount=").append(this.zzayb).append(',');
        stringBuilder.append("loggingId=").append(this.zzayc).append(',');
        stringBuilder.append("logAndroidId=").append(this.zzayd).append(',');
        stringBuilder.append("isAnonymous=").append(this.zzayf).append(',');
        stringBuilder.append("qosTier=").append(this.zzayg);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzzv.zza(this, parcel, i);
    }
}
