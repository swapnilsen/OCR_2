package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter.zza;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zzdx;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzrj;
import java.util.Date;
import java.util.Set;

@zzme
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, MediationRewardedVideoAdAdapter, zzrj {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    protected AdView zzcD;
    protected InterstitialAd zzcE;
    private AdLoader zzcF;
    private Context zzcG;
    private InterstitialAd zzcH;
    private MediationRewardedVideoAdListener zzcI;
    final RewardedVideoAdListener zzcJ;

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.1 */
    class C08741 implements RewardedVideoAdListener {
        final /* synthetic */ AbstractAdViewAdapter f2261a;

        C08741(AbstractAdViewAdapter abstractAdViewAdapter) {
            this.f2261a = abstractAdViewAdapter;
        }

        public void onRewarded(RewardItem rewardItem) {
            this.f2261a.zzcI.onRewarded(this.f2261a, rewardItem);
        }

        public void onRewardedVideoAdClosed() {
            this.f2261a.zzcI.onAdClosed(this.f2261a);
            this.f2261a.zzcH = null;
        }

        public void onRewardedVideoAdFailedToLoad(int i) {
            this.f2261a.zzcI.onAdFailedToLoad(this.f2261a, i);
        }

        public void onRewardedVideoAdLeftApplication() {
            this.f2261a.zzcI.onAdLeftApplication(this.f2261a);
        }

        public void onRewardedVideoAdLoaded() {
            this.f2261a.zzcI.onAdLoaded(this.f2261a);
        }

        public void onRewardedVideoAdOpened() {
            this.f2261a.zzcI.onAdOpened(this.f2261a);
        }

        public void onRewardedVideoStarted() {
            this.f2261a.zzcI.onVideoStarted(this.f2261a);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.a */
    static class C0875a extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd f2262a;

        public C0875a(NativeAppInstallAd nativeAppInstallAd) {
            this.f2262a = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f2262a);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.b */
    static class C0876b extends NativeContentAdMapper {
        private final NativeContentAd f2263a;

        public C0876b(NativeContentAd nativeContentAd) {
            this.f2263a = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f2263a);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.c */
    static final class C0877c extends AdListener implements zzdx {
        final AbstractAdViewAdapter f2264a;
        final MediationBannerListener f2265b;

        public C0877c(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.f2264a = abstractAdViewAdapter;
            this.f2265b = mediationBannerListener;
        }

        public void onAdClicked() {
            this.f2265b.onAdClicked(this.f2264a);
        }

        public void onAdClosed() {
            this.f2265b.onAdClosed(this.f2264a);
        }

        public void onAdFailedToLoad(int i) {
            this.f2265b.onAdFailedToLoad(this.f2264a, i);
        }

        public void onAdLeftApplication() {
            this.f2265b.onAdLeftApplication(this.f2264a);
        }

        public void onAdLoaded() {
            this.f2265b.onAdLoaded(this.f2264a);
        }

        public void onAdOpened() {
            this.f2265b.onAdOpened(this.f2264a);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.d */
    static final class C0878d extends AdListener implements zzdx {
        final AbstractAdViewAdapter f2266a;
        final MediationInterstitialListener f2267b;

        public C0878d(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f2266a = abstractAdViewAdapter;
            this.f2267b = mediationInterstitialListener;
        }

        public void onAdClicked() {
            this.f2267b.onAdClicked(this.f2266a);
        }

        public void onAdClosed() {
            this.f2267b.onAdClosed(this.f2266a);
        }

        public void onAdFailedToLoad(int i) {
            this.f2267b.onAdFailedToLoad(this.f2266a, i);
        }

        public void onAdLeftApplication() {
            this.f2267b.onAdLeftApplication(this.f2266a);
        }

        public void onAdLoaded() {
            this.f2267b.onAdLoaded(this.f2266a);
        }

        public void onAdOpened() {
            this.f2267b.onAdOpened(this.f2266a);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter.e */
    static final class C0879e extends AdListener implements OnAppInstallAdLoadedListener, OnContentAdLoadedListener, zzdx {
        final AbstractAdViewAdapter f2268a;
        final MediationNativeListener f2269b;

        public C0879e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f2268a = abstractAdViewAdapter;
            this.f2269b = mediationNativeListener;
        }

        public void onAdClicked() {
            this.f2269b.onAdClicked(this.f2268a);
        }

        public void onAdClosed() {
            this.f2269b.onAdClosed(this.f2268a);
        }

        public void onAdFailedToLoad(int i) {
            this.f2269b.onAdFailedToLoad(this.f2268a, i);
        }

        public void onAdLeftApplication() {
            this.f2269b.onAdLeftApplication(this.f2268a);
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
            this.f2269b.onAdOpened(this.f2268a);
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.f2269b.onAdLoaded(this.f2268a, new C0875a(nativeAppInstallAd));
        }

        public void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.f2269b.onAdLoaded(this.f2268a, new C0876b(nativeContentAd));
        }
    }

    public AbstractAdViewAdapter() {
        this.zzcJ = new C08741(this);
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzcD;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new zza().zzam(1).zzmm();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzcG = context.getApplicationContext();
        this.zzcI = mediationRewardedVideoAdListener;
        this.zzcI.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzcI != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzcG == null || this.zzcI == null) {
            zzqf.m4708e("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzcH = new InterstitialAd(this.zzcG);
        this.zzcH.zzd(true);
        this.zzcH.setAdUnitId(getAdUnitId(bundle));
        this.zzcH.setRewardedVideoAdListener(this.zzcJ);
        this.zzcH.loadAd(zza(this.zzcG, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        if (this.zzcD != null) {
            this.zzcD.destroy();
            this.zzcD = null;
        }
        if (this.zzcE != null) {
            this.zzcE = null;
        }
        if (this.zzcF != null) {
            this.zzcF = null;
        }
        if (this.zzcH != null) {
            this.zzcH = null;
        }
    }

    public void onPause() {
        if (this.zzcD != null) {
            this.zzcD.pause();
        }
    }

    public void onResume() {
        if (this.zzcD != null) {
            this.zzcD.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcD = new AdView(context);
        this.zzcD.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzcD.setAdUnitId(getAdUnitId(bundle));
        this.zzcD.setAdListener(new C0877c(this, mediationBannerListener));
        this.zzcD.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcE = new InterstitialAd(context);
        this.zzcE.setAdUnitId(getAdUnitId(bundle));
        this.zzcE.setAdListener(new C0878d(this, mediationInterstitialListener));
        this.zzcE.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        OnContentAdLoadedListener c0879e = new C0879e(this, mediationNativeListener);
        Builder withAdListener = zza(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(c0879e);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(c0879e);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(c0879e);
        }
        this.zzcF = withAdListener.build();
        this.zzcF.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzcE.show();
    }

    public void showVideo() {
        this.zzcH.show();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);

    Builder zza(Context context, String str) {
        return new Builder(context, str);
    }

    AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(zzel.zzeT().zzad(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }
}
