package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzme
public class zzhc extends zza {
    public static final Creator<zzhc> CREATOR;
    public final int versionCode;
    public final boolean zzHa;
    public final int zzHb;
    public final boolean zzHc;
    public final int zzHd;
    @Nullable
    public final zzft zzHe;

    static {
        CREATOR = new zzhd();
    }

    public zzhc(int i, boolean z, int i2, boolean z2, int i3, zzft com_google_android_gms_internal_zzft) {
        this.versionCode = i;
        this.zzHa = z;
        this.zzHb = i2;
        this.zzHc = z2;
        this.zzHd = i3;
        this.zzHe = com_google_android_gms_internal_zzft;
    }

    public zzhc(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzft(nativeAdOptions.getVideoOptions()) : null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzhd.zza(this, parcel, i);
    }
}
