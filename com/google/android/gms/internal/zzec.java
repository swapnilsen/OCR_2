package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.List;

@zzme
public final class zzec extends zza {
    public static final Creator<zzec> CREATOR;
    public final Bundle extras;
    public final int versionCode;
    public final long zzyT;
    public final int zzyU;
    public final List<String> zzyV;
    public final boolean zzyW;
    public final int zzyX;
    public final boolean zzyY;
    public final String zzyZ;
    public final zzfp zzza;
    public final Location zzzb;
    public final String zzzc;
    public final Bundle zzzd;
    public final Bundle zzze;
    public final List<String> zzzf;
    public final String zzzg;
    public final String zzzh;
    public final boolean zzzi;

    static {
        CREATOR = new zzee();
    }

    public zzec(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, zzfp com_google_android_gms_internal_zzfp, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.versionCode = i;
        this.zzyT = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.extras = bundle;
        this.zzyU = i2;
        this.zzyV = list;
        this.zzyW = z;
        this.zzyX = i3;
        this.zzyY = z2;
        this.zzyZ = str;
        this.zzza = com_google_android_gms_internal_zzfp;
        this.zzzb = location;
        this.zzzc = str2;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        this.zzzd = bundle2;
        this.zzze = bundle3;
        this.zzzf = list2;
        this.zzzg = str3;
        this.zzzh = str4;
        this.zzzi = z3;
    }

    public static void zzi(zzec com_google_android_gms_internal_zzec) {
        com_google_android_gms_internal_zzec.zzzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", com_google_android_gms_internal_zzec.extras);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzec)) {
            return false;
        }
        zzec com_google_android_gms_internal_zzec = (zzec) obj;
        return this.versionCode == com_google_android_gms_internal_zzec.versionCode && this.zzyT == com_google_android_gms_internal_zzec.zzyT && zzaa.equal(this.extras, com_google_android_gms_internal_zzec.extras) && this.zzyU == com_google_android_gms_internal_zzec.zzyU && zzaa.equal(this.zzyV, com_google_android_gms_internal_zzec.zzyV) && this.zzyW == com_google_android_gms_internal_zzec.zzyW && this.zzyX == com_google_android_gms_internal_zzec.zzyX && this.zzyY == com_google_android_gms_internal_zzec.zzyY && zzaa.equal(this.zzyZ, com_google_android_gms_internal_zzec.zzyZ) && zzaa.equal(this.zzza, com_google_android_gms_internal_zzec.zzza) && zzaa.equal(this.zzzb, com_google_android_gms_internal_zzec.zzzb) && zzaa.equal(this.zzzc, com_google_android_gms_internal_zzec.zzzc) && zzaa.equal(this.zzzd, com_google_android_gms_internal_zzec.zzzd) && zzaa.equal(this.zzze, com_google_android_gms_internal_zzec.zzze) && zzaa.equal(this.zzzf, com_google_android_gms_internal_zzec.zzzf) && zzaa.equal(this.zzzg, com_google_android_gms_internal_zzec.zzzg) && zzaa.equal(this.zzzh, com_google_android_gms_internal_zzec.zzzh) && this.zzzi == com_google_android_gms_internal_zzec.zzzi;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzyT), this.extras, Integer.valueOf(this.zzyU), this.zzyV, Boolean.valueOf(this.zzyW), Integer.valueOf(this.zzyX), Boolean.valueOf(this.zzyY), this.zzyZ, this.zzza, this.zzzb, this.zzzc, this.zzzd, this.zzze, this.zzzf, this.zzzg, this.zzzh, Boolean.valueOf(this.zzzi));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzee.zza(this, parcel, i);
    }
}
