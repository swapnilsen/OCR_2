package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzme
public class zzeg extends zza {
    public static final Creator<zzeg> CREATOR;
    public final int height;
    public final int heightPixels;
    public final int width;
    public final int widthPixels;
    public final zzeg[] zzzA;
    public final boolean zzzB;
    public final boolean zzzC;
    public boolean zzzD;
    public final String zzzy;
    public final boolean zzzz;

    static {
        CREATOR = new zzeh();
    }

    public zzeg() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzeg(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public zzeg(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        AdSize adSize = adSizeArr[0];
        this.zzzz = false;
        this.zzzC = adSize.isFluid();
        if (this.zzzC) {
            this.width = AdSize.BANNER.getWidth();
            this.height = AdSize.BANNER.getHeight();
        } else {
            this.width = adSize.getWidth();
            this.height = adSize.getHeight();
        }
        boolean z = this.width == -1;
        boolean z2 = this.height == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (zzel.zzeT().zzah(context) && zzel.zzeT().zzai(context)) {
                this.widthPixels = zza(displayMetrics) - zzel.zzeT().zzaj(context);
            } else {
                this.widthPixels = zza(displayMetrics);
            }
            double d = (double) (((float) this.widthPixels) / displayMetrics.density);
            i = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i++;
            }
            i2 = i;
        } else {
            i = this.width;
            this.widthPixels = zzel.zzeT().zza(displayMetrics, this.width);
            i2 = i;
        }
        i = z2 ? zzc(displayMetrics) : this.height;
        this.heightPixels = zzel.zzeT().zza(displayMetrics, i);
        if (z || z2) {
            this.zzzy = i2 + "x" + i + "_as";
        } else if (this.zzzC) {
            this.zzzy = "320x50_mb";
        } else {
            this.zzzy = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.zzzA = new zzeg[adSizeArr.length];
            for (int i3 = 0; i3 < adSizeArr.length; i3++) {
                this.zzzA[i3] = new zzeg(context, adSizeArr[i3]);
            }
        } else {
            this.zzzA = null;
        }
        this.zzzB = false;
        this.zzzD = false;
    }

    public zzeg(zzeg com_google_android_gms_internal_zzeg, zzeg[] com_google_android_gms_internal_zzegArr) {
        this(com_google_android_gms_internal_zzeg.zzzy, com_google_android_gms_internal_zzeg.height, com_google_android_gms_internal_zzeg.heightPixels, com_google_android_gms_internal_zzeg.zzzz, com_google_android_gms_internal_zzeg.width, com_google_android_gms_internal_zzeg.widthPixels, com_google_android_gms_internal_zzegArr, com_google_android_gms_internal_zzeg.zzzB, com_google_android_gms_internal_zzeg.zzzC, com_google_android_gms_internal_zzeg.zzzD);
    }

    zzeg(String str, int i, int i2, boolean z, int i3, int i4, zzeg[] com_google_android_gms_internal_zzegArr, boolean z2, boolean z3, boolean z4) {
        this.zzzy = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzzz = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzzA = com_google_android_gms_internal_zzegArr;
        this.zzzB = z2;
        this.zzzC = z3;
        this.zzzD = z4;
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return (int) (((float) zzc(displayMetrics)) * displayMetrics.density);
    }

    private static int zzc(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public static zzeg zzeE() {
        return new zzeg("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public static zzeg zzk(Context context) {
        return new zzeg("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzeh.zza(this, parcel, i);
    }

    public AdSize zzeF() {
        return com.google.android.gms.ads.zza.zza(this.width, this.height, this.zzzy);
    }

    public void zzl(boolean z) {
        this.zzzD = z;
    }
}
