package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdx;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqw;

@zzme
public final class AdOverlayInfoParcel extends zza implements ReflectedParcelable {
    public static final Creator<AdOverlayInfoParcel> CREATOR;
    public final int orientation;
    public final String url;
    public final zzc zzNE;
    public final zzdx zzNF;
    public final zzh zzNG;
    public final zzqw zzNH;
    public final zzhz zzNI;
    public final String zzNJ;
    public final boolean zzNK;
    public final String zzNL;
    public final zzq zzNM;
    public final int zzNN;
    public final zzif zzNO;
    public final String zzNP;
    public final zzn zzNQ;
    public final zzqh zzvn;

    static {
        CREATOR = new zzg();
    }

    AdOverlayInfoParcel(zzc com_google_android_gms_ads_internal_overlay_zzc, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzqh com_google_android_gms_internal_zzqh, IBinder iBinder6, String str4, zzn com_google_android_gms_ads_internal_zzn) {
        this.zzNE = com_google_android_gms_ads_internal_overlay_zzc;
        this.zzNF = (zzdx) zzd.zzF(IObjectWrapper.zza.zzcd(iBinder));
        this.zzNG = (zzh) zzd.zzF(IObjectWrapper.zza.zzcd(iBinder2));
        this.zzNH = (zzqw) zzd.zzF(IObjectWrapper.zza.zzcd(iBinder3));
        this.zzNI = (zzhz) zzd.zzF(IObjectWrapper.zza.zzcd(iBinder4));
        this.zzNJ = str;
        this.zzNK = z;
        this.zzNL = str2;
        this.zzNM = (zzq) zzd.zzF(IObjectWrapper.zza.zzcd(iBinder5));
        this.orientation = i;
        this.zzNN = i2;
        this.url = str3;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = (zzif) zzd.zzF(IObjectWrapper.zza.zzcd(iBinder6));
        this.zzNP = str4;
        this.zzNQ = com_google_android_gms_ads_internal_zzn;
    }

    public AdOverlayInfoParcel(zzc com_google_android_gms_ads_internal_overlay_zzc, zzdx com_google_android_gms_internal_zzdx, zzh com_google_android_gms_ads_internal_overlay_zzh, zzq com_google_android_gms_ads_internal_overlay_zzq, zzqh com_google_android_gms_internal_zzqh) {
        this.zzNE = com_google_android_gms_ads_internal_overlay_zzc;
        this.zzNF = com_google_android_gms_internal_zzdx;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = null;
        this.zzNI = null;
        this.zzNJ = null;
        this.zzNK = false;
        this.zzNL = null;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = -1;
        this.zzNN = 4;
        this.url = null;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = null;
        this.zzNP = null;
        this.zzNQ = null;
    }

    public AdOverlayInfoParcel(zzdx com_google_android_gms_internal_zzdx, zzh com_google_android_gms_ads_internal_overlay_zzh, zzq com_google_android_gms_ads_internal_overlay_zzq, zzqw com_google_android_gms_internal_zzqw, int i, zzqh com_google_android_gms_internal_zzqh, String str, zzn com_google_android_gms_ads_internal_zzn) {
        this.zzNE = null;
        this.zzNF = com_google_android_gms_internal_zzdx;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = com_google_android_gms_internal_zzqw;
        this.zzNI = null;
        this.zzNJ = null;
        this.zzNK = false;
        this.zzNL = null;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNN = 1;
        this.url = null;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = null;
        this.zzNP = str;
        this.zzNQ = com_google_android_gms_ads_internal_zzn;
    }

    public AdOverlayInfoParcel(zzdx com_google_android_gms_internal_zzdx, zzh com_google_android_gms_ads_internal_overlay_zzh, zzq com_google_android_gms_ads_internal_overlay_zzq, zzqw com_google_android_gms_internal_zzqw, boolean z, int i, zzqh com_google_android_gms_internal_zzqh) {
        this.zzNE = null;
        this.zzNF = com_google_android_gms_internal_zzdx;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = com_google_android_gms_internal_zzqw;
        this.zzNI = null;
        this.zzNJ = null;
        this.zzNK = z;
        this.zzNL = null;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNN = 2;
        this.url = null;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = null;
        this.zzNP = null;
        this.zzNQ = null;
    }

    public AdOverlayInfoParcel(zzdx com_google_android_gms_internal_zzdx, zzh com_google_android_gms_ads_internal_overlay_zzh, zzhz com_google_android_gms_internal_zzhz, zzq com_google_android_gms_ads_internal_overlay_zzq, zzqw com_google_android_gms_internal_zzqw, boolean z, int i, String str, zzqh com_google_android_gms_internal_zzqh, zzif com_google_android_gms_internal_zzif) {
        this.zzNE = null;
        this.zzNF = com_google_android_gms_internal_zzdx;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = com_google_android_gms_internal_zzqw;
        this.zzNI = com_google_android_gms_internal_zzhz;
        this.zzNJ = null;
        this.zzNK = z;
        this.zzNL = null;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNN = 3;
        this.url = str;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = com_google_android_gms_internal_zzif;
        this.zzNP = null;
        this.zzNQ = null;
    }

    public AdOverlayInfoParcel(zzdx com_google_android_gms_internal_zzdx, zzh com_google_android_gms_ads_internal_overlay_zzh, zzhz com_google_android_gms_internal_zzhz, zzq com_google_android_gms_ads_internal_overlay_zzq, zzqw com_google_android_gms_internal_zzqw, boolean z, int i, String str, String str2, zzqh com_google_android_gms_internal_zzqh, zzif com_google_android_gms_internal_zzif) {
        this.zzNE = null;
        this.zzNF = com_google_android_gms_internal_zzdx;
        this.zzNG = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzNH = com_google_android_gms_internal_zzqw;
        this.zzNI = com_google_android_gms_internal_zzhz;
        this.zzNJ = str2;
        this.zzNK = z;
        this.zzNL = str;
        this.zzNM = com_google_android_gms_ads_internal_overlay_zzq;
        this.orientation = i;
        this.zzNN = 3;
        this.url = null;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzNO = com_google_android_gms_internal_zzif;
        this.zzNP = null;
        this.zzNQ = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    IBinder zzhN() {
        return zzd.zzA(this.zzNF).asBinder();
    }

    IBinder zzhO() {
        return zzd.zzA(this.zzNG).asBinder();
    }

    IBinder zzhP() {
        return zzd.zzA(this.zzNH).asBinder();
    }

    IBinder zzhQ() {
        return zzd.zzA(this.zzNI).asBinder();
    }

    IBinder zzhR() {
        return zzd.zzA(this.zzNO).asBinder();
    }

    IBinder zzhS() {
        return zzd.zzA(this.zzNM).asBinder();
    }
}
