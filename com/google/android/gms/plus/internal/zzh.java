package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;

public class zzh extends zza {
    public static final Creator<zzh> CREATOR;
    private final int zzaiI;
    private final String zzaiu;
    private final String zzavz;
    private final String[] zzbCa;
    private final String[] zzbCb;
    private final String[] zzbCc;
    private final String zzbCd;
    private final String zzbCe;
    private final String zzbCf;
    private final PlusCommonExtras zzbCg;

    static {
        CREATOR = new zzi();
    }

    zzh(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.zzaiI = i;
        this.zzaiu = str;
        this.zzbCa = strArr;
        this.zzbCb = strArr2;
        this.zzbCc = strArr3;
        this.zzbCd = str2;
        this.zzbCe = str3;
        this.zzavz = str4;
        this.zzbCf = str5;
        this.zzbCg = plusCommonExtras;
    }

    public zzh(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.zzaiI = 1;
        this.zzaiu = str;
        this.zzbCa = strArr;
        this.zzbCb = strArr2;
        this.zzbCc = strArr3;
        this.zzbCd = str2;
        this.zzbCe = str3;
        this.zzavz = str4;
        this.zzbCf = null;
        this.zzbCg = plusCommonExtras;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh com_google_android_gms_plus_internal_zzh = (zzh) obj;
        return this.zzaiI == com_google_android_gms_plus_internal_zzh.zzaiI && zzaa.equal(this.zzaiu, com_google_android_gms_plus_internal_zzh.zzaiu) && Arrays.equals(this.zzbCa, com_google_android_gms_plus_internal_zzh.zzbCa) && Arrays.equals(this.zzbCb, com_google_android_gms_plus_internal_zzh.zzbCb) && Arrays.equals(this.zzbCc, com_google_android_gms_plus_internal_zzh.zzbCc) && zzaa.equal(this.zzbCd, com_google_android_gms_plus_internal_zzh.zzbCd) && zzaa.equal(this.zzbCe, com_google_android_gms_plus_internal_zzh.zzbCe) && zzaa.equal(this.zzavz, com_google_android_gms_plus_internal_zzh.zzavz) && zzaa.equal(this.zzbCf, com_google_android_gms_plus_internal_zzh.zzbCf) && zzaa.equal(this.zzbCg, com_google_android_gms_plus_internal_zzh.zzbCg);
    }

    public String getAccountName() {
        return this.zzaiu;
    }

    public int getVersionCode() {
        return this.zzaiI;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzaiI), this.zzaiu, this.zzbCa, this.zzbCb, this.zzbCc, this.zzbCd, this.zzbCe, this.zzavz, this.zzbCf, this.zzbCg);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("versionCode", Integer.valueOf(this.zzaiI)).zzg("accountName", this.zzaiu).zzg("requestedScopes", this.zzbCa).zzg("visibleActivities", this.zzbCb).zzg("requiredFeatures", this.zzbCc).zzg("packageNameForAuth", this.zzbCd).zzg("callingPackageName", this.zzbCe).zzg("applicationName", this.zzavz).zzg("extra", this.zzbCg.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public String[] zzPb() {
        return this.zzbCa;
    }

    public String[] zzPc() {
        return this.zzbCb;
    }

    public String[] zzPd() {
        return this.zzbCc;
    }

    public String zzPe() {
        return this.zzbCd;
    }

    public String zzPf() {
        return this.zzbCe;
    }

    public String zzPg() {
        return this.zzbCf;
    }

    public PlusCommonExtras zzPh() {
        return this.zzbCg;
    }

    public Bundle zzPi() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.zzbCg.zzN(bundle);
        return bundle;
    }

    public String zzur() {
        return this.zzavz;
    }
}
