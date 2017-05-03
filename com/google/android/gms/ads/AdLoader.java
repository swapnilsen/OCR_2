package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzfe;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhv;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzqf;

public class AdLoader {
    private final Context mContext;
    private final zzef zzrw;
    private final zzeq zzrx;

    public static class Builder {
        private final Context mContext;
        private final zzer zzry;

        Builder(Context context, zzer com_google_android_gms_internal_zzer) {
            this.mContext = context;
            this.zzry = com_google_android_gms_internal_zzer;
        }

        public Builder(Context context, String str) {
            this((Context) zzac.zzb((Object) context, (Object) "context cannot be null"), zzel.zzeU().zzb(context, str, new zzjz()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.mContext, this.zzry.zzck());
            } catch (Throwable e) {
                zzqf.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzry.zza(new zzhu(onAppInstallAdLoadedListener));
            } catch (Throwable e) {
                zzqf.zzc("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzry.zza(new zzhv(onContentAdLoadedListener));
            } catch (Throwable e) {
                zzqf.zzc("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, OnCustomClickListener onCustomClickListener) {
            try {
                this.zzry.zza(str, new zzhx(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzhw(onCustomClickListener));
            } catch (Throwable e) {
                zzqf.zzc("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzry.zzb(new zzdz(adListener));
            } catch (Throwable e) {
                zzqf.zzc("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(@NonNull Correlator correlator) {
            zzac.zzw(correlator);
            try {
                this.zzry.zzb(correlator.zzbq());
            } catch (Throwable e) {
                zzqf.zzc("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzry.zza(new zzhc(nativeAdOptions));
            } catch (Throwable e) {
                zzqf.zzc("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzeq com_google_android_gms_internal_zzeq) {
        this(context, com_google_android_gms_internal_zzeq, zzef.zzeD());
    }

    AdLoader(Context context, zzeq com_google_android_gms_internal_zzeq, zzef com_google_android_gms_internal_zzef) {
        this.mContext = context;
        this.zzrx = com_google_android_gms_internal_zzeq;
        this.zzrw = com_google_android_gms_internal_zzef;
    }

    private void zza(zzfe com_google_android_gms_internal_zzfe) {
        try {
            this.zzrx.zzf(this.zzrw.zza(this.mContext, com_google_android_gms_internal_zzfe));
        } catch (Throwable e) {
            zzqf.zzb("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.zzrx.getMediationAdapterClassName();
        } catch (Throwable e) {
            zzqf.zzc("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzrx.isLoading();
        } catch (Throwable e) {
            zzqf.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzbp());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzbp());
    }
}
