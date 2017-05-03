package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzdx;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzqf;

class BaseAdView extends ViewGroup {
    protected final zzff zzrF;

    public BaseAdView(Context context, int i) {
        super(context);
        this.zzrF = new zzff(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zzrF = new zzff(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zzrF = new zzff(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.zzrF.destroy();
    }

    public AdListener getAdListener() {
        return this.zzrF.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzrF.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzrF.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzrF.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzrF.getMediationAdapterClassName();
    }

    public boolean isLoading() {
        return this.zzrF.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.zzrF.zza(adRequest.zzbp());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int widthInPixels;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize;
            AdSize adSize2 = null;
            try {
                adSize = getAdSize();
            } catch (Throwable e) {
                zzqf.zzb("Unable to retrieve ad size.", e);
                adSize = adSize2;
            }
            if (adSize != null) {
                Context context = getContext();
                widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
            } else {
                widthInPixels = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            widthInPixels = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(widthInPixels, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zzrF.pause();
    }

    public void resume() {
        this.zzrF.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzrF.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzdx)) {
            this.zzrF.zza((zzdx) adListener);
        } else if (adListener == null) {
            this.zzrF.zza(null);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzrF.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzrF.setAdUnitId(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.zzrF.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.zzrF.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }
}
