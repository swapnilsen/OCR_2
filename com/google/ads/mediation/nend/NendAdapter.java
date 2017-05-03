package com.google.ads.mediation.nend;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpStatusCodes;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdInterstitial;
import net.nend.android.NendAdInterstitial.NendAdInterstitialClickType;
import net.nend.android.NendAdInterstitial.NendAdInterstitialShowResult;
import net.nend.android.NendAdInterstitial.NendAdInterstitialStatusCode;
import net.nend.android.NendAdInterstitial.OnClickListener;
import net.nend.android.NendAdInterstitial.OnCompletionListener;
import net.nend.android.NendAdListener;
import net.nend.android.NendAdView;
import net.nend.android.NendAdView.NendError;
import net.nend.android.NendIconError;

public class NendAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, NendAdListener {
    public static final String VERSION = "1.2.1";
    private static /* synthetic */ int[] f2314e;
    private static /* synthetic */ int[] f2315f;
    private MediationBannerListener f2316a;
    private MediationInterstitialListener f2317b;
    private NendAdView f2318c;
    private Activity f2319d;

    /* renamed from: com.google.ads.mediation.nend.NendAdapter.1 */
    class C08921 implements OnCompletionListener {
        private static /* synthetic */ int[] f2310b;
        final /* synthetic */ NendAdapter f2311a;

        C08921(NendAdapter nendAdapter) {
            this.f2311a = nendAdapter;
        }

        static /* synthetic */ int[] m2852a() {
            int[] iArr = f2310b;
            if (iArr == null) {
                iArr = new int[NendAdInterstitialStatusCode.values().length];
                try {
                    iArr[NendAdInterstitialStatusCode.FAILED_AD_DOWNLOAD.ordinal()] = 5;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[NendAdInterstitialStatusCode.FAILED_AD_INCOMPLETE.ordinal()] = 4;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[NendAdInterstitialStatusCode.FAILED_AD_REQUEST.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[NendAdInterstitialStatusCode.INVALID_RESPONSE_TYPE.ordinal()] = 2;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[NendAdInterstitialStatusCode.SUCCESS.ordinal()] = 1;
                } catch (NoSuchFieldError e5) {
                }
                f2310b = iArr;
            }
            return iArr;
        }

        public void onCompletion(NendAdInterstitialStatusCode nendAdInterstitialStatusCode) {
            switch (C08921.m2852a()[nendAdInterstitialStatusCode.ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    this.f2311a.adLoaded();
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    this.f2311a.adFailedToLoad(0);
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    this.f2311a.adFailedToLoad(1);
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    this.f2311a.adFailedToLoad(0);
                case Type.OTHER_PROFILE /*5*/:
                    this.f2311a.adFailedToLoad(1);
                default:
            }
        }
    }

    /* renamed from: com.google.ads.mediation.nend.NendAdapter.2 */
    class C08932 implements OnClickListener {
        private static /* synthetic */ int[] f2312b;
        final /* synthetic */ NendAdapter f2313a;

        C08932(NendAdapter nendAdapter) {
            this.f2313a = nendAdapter;
        }

        static /* synthetic */ int[] m2853a() {
            int[] iArr = f2312b;
            if (iArr == null) {
                iArr = new int[NendAdInterstitialClickType.values().length];
                try {
                    iArr[NendAdInterstitialClickType.CLOSE.ordinal()] = 2;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[NendAdInterstitialClickType.DOWNLOAD.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[NendAdInterstitialClickType.EXIT.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                f2312b = iArr;
            }
            return iArr;
        }

        public void onClick(NendAdInterstitialClickType nendAdInterstitialClickType) {
            switch (C08932.m2853a()[nendAdInterstitialClickType.ordinal()]) {
            }
            this.f2313a.adClicked();
        }
    }

    static /* synthetic */ int[] m2854a() {
        int[] iArr = f2314e;
        if (iArr == null) {
            iArr = new int[NendAdInterstitialShowResult.values().length];
            try {
                iArr[NendAdInterstitialShowResult.AD_DOWNLOAD_INCOMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NendAdInterstitialShowResult.AD_FREQUENCY_NOT_RECHABLE.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NendAdInterstitialShowResult.AD_LOAD_INCOMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NendAdInterstitialShowResult.AD_REQUEST_INCOMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NendAdInterstitialShowResult.AD_SHOW_ALREADY.ordinal()] = 6;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[NendAdInterstitialShowResult.AD_SHOW_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            f2314e = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m2855b() {
        int[] iArr = f2315f;
        if (iArr == null) {
            iArr = new int[NendError.values().length];
            try {
                iArr[NendError.AD_SIZE_DIFFERENCES.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NendError.AD_SIZE_TOO_LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NendError.FAILED_AD_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NendError.FAILED_AD_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NendError.INVALID_RESPONSE_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            f2315f = iArr;
        }
        return iArr;
    }

    public void onDestroy() {
        if (this.f2318c != null) {
            this.f2318c = null;
        }
        if (this.f2316a != null) {
            this.f2316a = null;
        }
        if (this.f2317b != null) {
            this.f2317b = null;
        }
        if (this.f2319d != null) {
            this.f2319d = null;
        }
    }

    public void onPause() {
        if (this.f2318c != null) {
            this.f2318c.pause();
        }
    }

    public void onResume() {
        if (this.f2318c != null) {
            this.f2318c.resume();
        }
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f2317b = mediationInterstitialListener;
        this.f2319d = (Activity) context;
        NendAdInterstitial.loadAd(context, bundle.getString("apiKey"), Integer.parseInt(bundle.getString("spotId")));
        NendAdInterstitial.setListener(new C08921(this));
    }

    public void showInterstitial() {
        switch (m2854a()[NendAdInterstitial.showAd(this.f2319d, new C08932(this)).ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                adOpened();
            default:
        }
    }

    public View getBannerView() {
        return this.f2318c;
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        int width = adSize.getWidth();
        int height = adSize.getHeight();
        if ((width == 320 && height == 50) || ((width == 320 && height == 100) || ((width == HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES && height == Callback.DEFAULT_SWIPE_ANIMATION_DURATION) || (width == 728 && height == 90)))) {
            this.f2316a = mediationBannerListener;
            this.f2318c = new NendAdView(context, Integer.parseInt(bundle.getString("spotId")), bundle.getString("apiKey"));
            this.f2318c.pause();
            this.f2318c.setListener(this);
            this.f2318c.loadAd();
            return;
        }
        adFailedToLoad(3);
    }

    public void onReceiveAd(NendAdView nendAdView) {
        if (this.f2316a != null) {
            this.f2316a.onAdLoaded(this);
        }
    }

    public void onFailedToReceiveAd(NendAdView nendAdView) {
        switch (m2855b()[nendAdView.getNendError().ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                if (this.f2316a != null) {
                    this.f2316a.onAdFailedToLoad(this, 0);
                }
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                if (this.f2316a != null) {
                    this.f2316a.onAdFailedToLoad(this, 0);
                }
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                if (this.f2316a != null) {
                    this.f2316a.onAdFailedToLoad(this, 1);
                }
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                if (this.f2316a != null) {
                    this.f2316a.onAdFailedToLoad(this, 1);
                }
            case Type.OTHER_PROFILE /*5*/:
                if (this.f2316a != null) {
                    this.f2316a.onAdFailedToLoad(this, 0);
                }
            default:
        }
    }

    public void onClick(NendAdView nendAdView) {
        if (this.f2316a != null) {
            this.f2316a.onAdClicked(this);
        }
    }

    public void onDismissScreen(NendAdView nendAdView) {
    }

    public void adLeftApplication() {
        if (this.f2317b != null) {
            this.f2317b.onAdLeftApplication(this);
            this.f2317b.onAdClosed(this);
        }
    }

    public void adClicked() {
        if (this.f2317b != null) {
            this.f2317b.onAdClicked(this);
            this.f2317b.onAdClosed(this);
        }
    }

    public void adFailedToLoad(int i) {
        if (this.f2317b != null) {
            this.f2317b.onAdFailedToLoad(this, i);
        }
    }

    public void adLoaded() {
        if (this.f2317b != null) {
            this.f2317b.onAdLoaded(this);
        }
    }

    public void adOpened() {
        if (this.f2317b != null) {
            this.f2317b.onAdOpened(this);
        }
    }
}
