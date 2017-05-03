package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzqf;

public abstract class NativeAdView extends FrameLayout {
    private final FrameLayout zzrY;
    private final zzhh zzrZ;

    public NativeAdView(Context context) {
        super(context);
        this.zzrY = zzd(context);
        this.zzrZ = zzbv();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzrY = zzd(context);
        this.zzrZ = zzbv();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzrY = zzd(context);
        this.zzrZ = zzbv();
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzrY = zzd(context);
        this.zzrZ = zzbv();
    }

    private zzhh zzbv() {
        zzac.zzb(this.zzrY, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return zzel.zzeU().zza(this.zzrY.getContext(), (FrameLayout) this, this.zzrY);
    }

    private FrameLayout zzd(Context context) {
        View zze = zze(context);
        zze.setLayoutParams(new LayoutParams(-1, -1));
        addView(zze);
        return zze;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzrY);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.zzrY != view) {
            super.bringChildToFront(this.zzrY);
        }
    }

    public void destroy() {
        try {
            this.zzrZ.destroy();
        } catch (Throwable e) {
            zzqf.zzb("Unable to destroy native ad view", e);
        }
    }

    public AdChoicesView getAdChoicesView() {
        View zzt = zzt("1098");
        return zzt instanceof AdChoicesView ? (AdChoicesView) zzt : null;
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.zzrZ != null) {
            try {
                this.zzrZ.zzb(zzd.zzA(view), i);
            } catch (Throwable e) {
                zzqf.zzb("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzrY);
    }

    public void removeView(View view) {
        if (this.zzrY != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza("1098", adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzrZ.zze((IObjectWrapper) nativeAd.zzbu());
        } catch (Throwable e) {
            zzqf.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    protected void zza(String str, View view) {
        try {
            this.zzrZ.zzd(str, zzd.zzA(view));
        } catch (Throwable e) {
            zzqf.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    FrameLayout zze(Context context) {
        return new FrameLayout(context);
    }

    protected View zzt(String str) {
        try {
            IObjectWrapper zzU = this.zzrZ.zzU(str);
            if (zzU != null) {
                return (View) zzd.zzF(zzU);
            }
        } catch (Throwable e) {
            zzqf.zzb("Unable to call getAssetView on delegate", e);
        }
        return null;
    }
}
