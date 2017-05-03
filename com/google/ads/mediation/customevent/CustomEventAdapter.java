package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzqf;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    CustomEventBanner f2280a;
    CustomEventInterstitial f2281b;
    private View f2282c;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    static final class C0880a implements CustomEventBannerListener {
        private final CustomEventAdapter f2275a;
        private final MediationBannerListener f2276b;

        public C0880a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f2275a = customEventAdapter;
            this.f2276b = mediationBannerListener;
        }

        public void onClick() {
            zzqf.zzbf("Custom event adapter called onFailedToReceiveAd.");
            this.f2276b.onClick(this.f2275a);
        }

        public void onDismissScreen() {
            zzqf.zzbf("Custom event adapter called onFailedToReceiveAd.");
            this.f2276b.onDismissScreen(this.f2275a);
        }

        public void onFailedToReceiveAd() {
            zzqf.zzbf("Custom event adapter called onFailedToReceiveAd.");
            this.f2276b.onFailedToReceiveAd(this.f2275a, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            zzqf.zzbf("Custom event adapter called onFailedToReceiveAd.");
            this.f2276b.onLeaveApplication(this.f2275a);
        }

        public void onPresentScreen() {
            zzqf.zzbf("Custom event adapter called onFailedToReceiveAd.");
            this.f2276b.onPresentScreen(this.f2275a);
        }

        public void onReceivedAd(View view) {
            zzqf.zzbf("Custom event adapter called onReceivedAd.");
            this.f2275a.m2814a(view);
            this.f2276b.onReceivedAd(this.f2275a);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    class C0881b implements CustomEventInterstitialListener {
        final /* synthetic */ CustomEventAdapter f2277a;
        private final CustomEventAdapter f2278b;
        private final MediationInterstitialListener f2279c;

        public C0881b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f2277a = customEventAdapter;
            this.f2278b = customEventAdapter2;
            this.f2279c = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            zzqf.zzbf("Custom event adapter called onDismissScreen.");
            this.f2279c.onDismissScreen(this.f2278b);
        }

        public void onFailedToReceiveAd() {
            zzqf.zzbf("Custom event adapter called onFailedToReceiveAd.");
            this.f2279c.onFailedToReceiveAd(this.f2278b, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            zzqf.zzbf("Custom event adapter called onLeaveApplication.");
            this.f2279c.onLeaveApplication(this.f2278b);
        }

        public void onPresentScreen() {
            zzqf.zzbf("Custom event adapter called onPresentScreen.");
            this.f2279c.onPresentScreen(this.f2278b);
        }

        public void onReceivedAd() {
            zzqf.zzbf("Custom event adapter called onReceivedAd.");
            this.f2279c.onReceivedAd(this.f2277a);
        }
    }

    private static <T> T m2813a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            zzqf.zzbh(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    private void m2814a(View view) {
        this.f2282c = view;
    }

    C0881b m2816a(MediationInterstitialListener mediationInterstitialListener) {
        return new C0881b(this, this, mediationInterstitialListener);
    }

    public void destroy() {
        if (this.f2280a != null) {
            this.f2280a.destroy();
        }
        if (this.f2281b != null) {
            this.f2281b.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f2282c;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f2280a = (CustomEventBanner) m2813a(customEventServerParameters.className);
        if (this.f2280a == null) {
            mediationBannerListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f2280a.requestBannerAd(new C0880a(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f2281b = (CustomEventInterstitial) m2813a(customEventServerParameters.className);
        if (this.f2281b == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f2281b.requestInterstitialAd(m2816a(mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void showInterstitial() {
        this.f2281b.showInterstitial();
    }
}
