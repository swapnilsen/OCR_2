package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzqf;

public final class PublisherAdView extends ViewGroup {
    private final zzff zzrF;

    public PublisherAdView(Context context) {
        super(context);
        this.zzrF = new zzff(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzrF = new zzff(this, attributeSet, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzrF = new zzff(this, attributeSet, true);
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

    public AdSize[] getAdSizes() {
        return this.zzrF.getAdSizes();
    }

    public String getAdUnitId() {
        return this.zzrF.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzrF.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzrF.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzrF.getOnCustomRenderedAdLoadedListener();
    }

    public VideoController getVideoController() {
        return this.zzrF.getVideoController();
    }

    public VideoOptions getVideoOptions() {
        return this.zzrF.getVideoOptions();
    }

    public boolean isLoading() {
        return this.zzrF.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzrF.zza(publisherAdRequest.zzbp());
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

    public void recordManualImpression() {
        this.zzrF.recordManualImpression();
    }

    public void resume() {
        this.zzrF.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzrF.setAdListener(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzrF.zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        this.zzrF.setAdUnitId(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zzrF.setAppEventListener(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.zzrF.setCorrelator(correlator);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.zzrF.setManualImpressionsEnabled(z);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzrF.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public void setVideoOptions(VideoOptions videoOptions) {
        this.zzrF.setVideoOptions(videoOptions);
    }
}
