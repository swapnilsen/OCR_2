package com.google.ads.mediation.facebook;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.C0432a;
import com.facebook.ads.C0438b;
import com.facebook.ads.C0439c;
import com.facebook.ads.C0440d;
import com.facebook.ads.C0441e;
import com.facebook.ads.C0442f;
import com.facebook.ads.C0445g;
import com.facebook.ads.C0446h;
import com.facebook.ads.C0448i;
import com.facebook.ads.C0853k;
import com.facebook.ads.C0869n;
import com.facebook.ads.C0869n.C0866c;
import com.facebook.ads.C0872p;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import net.nend.android.NendAdIconLayout;

public final class FacebookAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    public static final String KEY_AD_VIEW_ATTRIBUTES = "ad_view_attributes";
    public static final String KEY_AUTOPLAY = "autoplay";
    public static final String KEY_BACKGROUND_COLOR = "background_color";
    public static final String KEY_BUTTON_BORDER_COLOR = "button_border_color";
    public static final String KEY_BUTTON_COLOR = "button_color";
    public static final String KEY_BUTTON_TEXT_COLOR = "button_text_color";
    public static final String KEY_DESCRIPTION_TEXT_COLOR = "description_text_color";
    public static final String KEY_DESCRIPTION_TEXT_SIZE = "description_text_size";
    public static final String KEY_ID = "id";
    public static final String KEY_IS_BOLD = "is_bold";
    public static final String KEY_IS_ITALIC = "is_italic";
    public static final String KEY_SOCIAL_CONTEXT_ASSET = "social_context";
    public static final String KEY_STYLE = "style";
    public static final String KEY_SUBTITLE_ASSET = "subtitle";
    public static final String KEY_TITLE_TEXT_COLOR = "title_text_color";
    public static final String KEY_TITLE_TEXT_SIZE = "title_text_size";
    public static final String KEY_TYPEFACE = "typeface";
    private MediationBannerListener f2301a;
    private MediationInterstitialListener f2302b;
    private MediationNativeListener f2303c;
    private C0445g f2304d;
    private RelativeLayout f2305e;
    private C0448i f2306f;
    private C0869n f2307g;
    private boolean f2308h;
    private boolean f2309i;

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.1 */
    class C08821 implements C0446h {
        final /* synthetic */ FacebookAdapter f2283a;

        C08821(FacebookAdapter facebookAdapter) {
            this.f2283a = facebookAdapter;
        }

        public void m2817a(C0432a c0432a) {
            if (this.f2283a.f2308h) {
                Log.d("FacebookAdapter", "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
                return;
            }
            this.f2283a.f2303c.onAdImpression(this.f2283a);
            this.f2283a.f2308h = true;
        }
    }

    public static class FacebookExtrasBundleBuilder {
        private boolean f2284a;

        public FacebookExtrasBundleBuilder setNativeAdChoicesIconExpandable(boolean z) {
            this.f2284a = z;
            return this;
        }

        public Bundle build() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("expandable_icon", this.f2284a);
            return bundle;
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.a */
    class C0883a extends NativeAppInstallAdMapper {
        final /* synthetic */ FacebookAdapter f2285a;
        private C0869n f2286b;
        private NativeAdOptions f2287c;

        public C0883a(FacebookAdapter facebookAdapter, C0869n c0869n, NativeAdOptions nativeAdOptions) {
            this.f2285a = facebookAdapter;
            this.f2286b = c0869n;
            this.f2287c = nativeAdOptions;
        }

        public void m2820a(C0889f c0889f) {
            if (m2819a(this.f2286b)) {
                boolean shouldReturnUrlsForImageAssets;
                setHeadline(this.f2286b.m2720h());
                List arrayList = new ArrayList();
                arrayList.add(new C0887d(this.f2285a, Uri.parse(this.f2286b.m2718f().m2665a())));
                setImages(arrayList);
                setBody(this.f2286b.m2722j());
                setIcon(new C0887d(this.f2285a, Uri.parse(this.f2286b.m2717e().m2665a())));
                setCallToAction(this.f2286b.m2723k());
                Double a = m2818a(this.f2286b.m2725m());
                if (a != null) {
                    setStarRating(a.doubleValue());
                }
                Bundle bundle = new Bundle();
                bundle.putCharSequence(FacebookAdapter.KEY_ID, this.f2286b.m2726n());
                bundle.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.f2286b.m2724l());
                bundle.putCharSequence(FacebookAdapter.KEY_SUBTITLE_ASSET, this.f2286b.m2721i());
                C0872p g = this.f2286b.m2719g();
                if (g != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean(FacebookAdapter.KEY_AUTOPLAY, g.m2747j());
                    bundle2.putInt(FacebookAdapter.KEY_BACKGROUND_COLOR, g.m2739b());
                    bundle2.putInt(FacebookAdapter.KEY_BUTTON_BORDER_COLOR, g.m2744g());
                    bundle2.putInt(FacebookAdapter.KEY_BUTTON_COLOR, g.m2742e());
                    bundle2.putInt(FacebookAdapter.KEY_BUTTON_TEXT_COLOR, g.m2743f());
                    bundle2.putInt(FacebookAdapter.KEY_DESCRIPTION_TEXT_COLOR, g.m2741d());
                    bundle2.putInt(FacebookAdapter.KEY_DESCRIPTION_TEXT_SIZE, g.m2746i());
                    bundle2.putInt(FacebookAdapter.KEY_TITLE_TEXT_COLOR, g.m2740c());
                    bundle2.putInt(FacebookAdapter.KEY_TITLE_TEXT_SIZE, g.m2745h());
                    Typeface a2 = g.m2738a();
                    if (a2 != null) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putBoolean(FacebookAdapter.KEY_IS_BOLD, a2.isBold());
                        bundle3.putBoolean(FacebookAdapter.KEY_IS_ITALIC, a2.isItalic());
                        bundle3.putInt(FacebookAdapter.KEY_STYLE, a2.getStyle());
                        bundle2.putBundle(FacebookAdapter.KEY_TYPEFACE, bundle3);
                    }
                    bundle.putBundle(FacebookAdapter.KEY_AD_VIEW_ATTRIBUTES, bundle2);
                }
                setExtras(bundle);
                if (this.f2287c != null) {
                    shouldReturnUrlsForImageAssets = this.f2287c.shouldReturnUrlsForImageAssets();
                } else {
                    shouldReturnUrlsForImageAssets = false;
                }
                if (shouldReturnUrlsForImageAssets) {
                    c0889f.m2834a();
                    return;
                }
                new C0886c(c0889f).execute(new Object[]{this});
                return;
            }
            Log.w("FacebookAdapter", "Ad from Facebook doesn't have all assets required for the app install format.");
            c0889f.m2835b();
        }

        private boolean m2819a(C0869n c0869n) {
            return (c0869n.m2720h() == null || c0869n.m2718f() == null || c0869n.m2722j() == null || c0869n.m2717e() == null || c0869n.m2723k() == null) ? false : true;
        }

        public void trackView(View view) {
            ViewGroup viewGroup = (ViewGroup) view;
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (childAt instanceof FrameLayout) {
                View c0438b = new C0438b(view.getContext(), this.f2286b, this.f2285a.f2309i);
                ((ViewGroup) childAt).addView(c0438b);
                LayoutParams layoutParams = (LayoutParams) c0438b.getLayoutParams();
                if (this.f2287c != null) {
                    switch (this.f2287c.getAdChoicesPlacement()) {
                        case NendAdIconLayout.HORIZONTAL /*0*/:
                            layoutParams.gravity = 51;
                            break;
                        case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            layoutParams.gravity = 85;
                            break;
                        case SendException.ERROR_TTL_EXCEEDED /*3*/:
                            layoutParams.gravity = 83;
                            break;
                        default:
                            layoutParams.gravity = 53;
                            break;
                    }
                }
                layoutParams.gravity = 53;
                viewGroup.requestLayout();
            } else {
                Log.w("FacebookAdapter", "Failed to show AdChoices icon.");
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            this.f2286b.m2706a(view);
        }

        public void untrackView(View view) {
            super.untrackView(view);
            ViewGroup viewGroup = (ViewGroup) view;
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (childAt instanceof FrameLayout) {
                ((FrameLayout) childAt).removeAllViews();
            }
            this.f2286b.m2736x();
        }

        private Double m2818a(C0866c c0866c) {
            if (c0866c == null) {
                return null;
            }
            return Double.valueOf((5.0d * c0866c.m2669a()) / c0866c.m2670b());
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.b */
    private class C0884b implements C0440d {
        final /* synthetic */ FacebookAdapter f2288a;

        private C0884b(FacebookAdapter facebookAdapter) {
            this.f2288a = facebookAdapter;
        }

        public void m2823b(C0432a c0432a) {
            this.f2288a.f2301a.onAdClicked(this.f2288a);
            this.f2288a.f2301a.onAdOpened(this.f2288a);
            this.f2288a.f2301a.onAdLeftApplication(this.f2288a);
        }

        public void m2821a(C0432a c0432a) {
            this.f2288a.f2301a.onAdLoaded(this.f2288a);
        }

        public void m2822a(C0432a c0432a, C0439c c0439c) {
            Object b = c0439c.m1048b();
            if (!TextUtils.isEmpty(b)) {
                Log.w("FacebookAdapter", b);
            }
            this.f2288a.f2301a.onAdFailedToLoad(this.f2288a, this.f2288a.m2842a(c0439c));
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.c */
    private static class C0886c extends AsyncTask<Object, Void, Boolean> {
        private C0889f f2291a;

        /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.c.1 */
        class C08851 implements Callable<Drawable> {
            final /* synthetic */ Uri f2289a;
            final /* synthetic */ C0886c f2290b;

            C08851(C0886c c0886c, Uri uri) {
                this.f2290b = c0886c;
                this.f2289a = uri;
            }

            public /* synthetic */ Object call() {
                return m2824a();
            }

            public Drawable m2824a() {
                Bitmap decodeStream = BitmapFactory.decodeStream(new URL(this.f2289a.toString()).openStream());
                decodeStream.setDensity(160);
                return new BitmapDrawable(Resources.getSystem(), decodeStream);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2826a(objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m2827a((Boolean) obj);
        }

        public C0886c(C0889f c0889f) {
            this.f2291a = c0889f;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected java.lang.Boolean m2826a(java.lang.Object... r9) {
            /*
            r8 = this;
            r3 = 0;
            r0 = r9[r3];
            r0 = (com.google.ads.mediation.facebook.FacebookAdapter.C0883a) r0;
            r4 = java.util.concurrent.Executors.newCachedThreadPool();
            r5 = new java.util.HashMap;
            r5.<init>();
            r6 = r0.getImages();
            r2 = r3;
        L_0x0013:
            r1 = r6.size();
            if (r2 >= r1) goto L_0x002e;
        L_0x0019:
            r1 = r6.get(r2);
            r1 = (com.google.ads.mediation.facebook.FacebookAdapter.C0887d) r1;
            r7 = r1.getUri();
            r7 = r8.m2825a(r7, r4);
            r5.put(r1, r7);
            r1 = r2 + 1;
            r2 = r1;
            goto L_0x0013;
        L_0x002e:
            r0 = r0.getIcon();
            r0 = (com.google.ads.mediation.facebook.FacebookAdapter.C0887d) r0;
            r1 = r0.getUri();
            r1 = r8.m2825a(r1, r4);
            r5.put(r0, r1);
            r0 = r5.entrySet();
            r2 = r0.iterator();
        L_0x0047:
            r0 = r2.hasNext();
            if (r0 == 0) goto L_0x008b;
        L_0x004d:
            r0 = r2.next();
            r0 = (java.util.Map.Entry) r0;
            r1 = r0.getValue();	 Catch:{ InterruptedException -> 0x006d, ExecutionException -> 0x0091, TimeoutException -> 0x0093 }
            r1 = (java.util.concurrent.Future) r1;	 Catch:{ InterruptedException -> 0x006d, ExecutionException -> 0x0091, TimeoutException -> 0x0093 }
            r4 = 10;
            r6 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x006d, ExecutionException -> 0x0091, TimeoutException -> 0x0093 }
            r1 = r1.get(r4, r6);	 Catch:{ InterruptedException -> 0x006d, ExecutionException -> 0x0091, TimeoutException -> 0x0093 }
            r1 = (android.graphics.drawable.Drawable) r1;	 Catch:{ InterruptedException -> 0x006d, ExecutionException -> 0x0091, TimeoutException -> 0x0093 }
            r0 = r0.getKey();
            r0 = (com.google.ads.mediation.facebook.FacebookAdapter.C0887d) r0;
            r0.m2828a(r1);
            goto L_0x0047;
        L_0x006d:
            r0 = move-exception;
        L_0x006e:
            r1 = "FacebookAdapter";
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r4 = "Exception occurred while waiting for future to return. Returning null as drawable : ";
            r2 = r2.append(r4);
            r0 = r2.append(r0);
            r0 = r0.toString();
            android.util.Log.w(r1, r0);
            r0 = java.lang.Boolean.valueOf(r3);
        L_0x008a:
            return r0;
        L_0x008b:
            r0 = 1;
            r0 = java.lang.Boolean.valueOf(r0);
            goto L_0x008a;
        L_0x0091:
            r0 = move-exception;
            goto L_0x006e;
        L_0x0093:
            r0 = move-exception;
            goto L_0x006e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.ads.mediation.facebook.FacebookAdapter.c.a(java.lang.Object[]):java.lang.Boolean");
        }

        private Future<Drawable> m2825a(Uri uri, ExecutorService executorService) {
            return executorService.submit(new C08851(this, uri));
        }

        protected void m2827a(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                this.f2291a.m2834a();
            } else {
                this.f2291a.m2835b();
            }
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.d */
    private class C0887d extends Image {
        final /* synthetic */ FacebookAdapter f2292a;
        private Drawable f2293b;
        private Uri f2294c;

        public C0887d(FacebookAdapter facebookAdapter, Uri uri) {
            this.f2292a = facebookAdapter;
            this.f2294c = uri;
        }

        protected void m2828a(Drawable drawable) {
            this.f2293b = drawable;
        }

        public Drawable getDrawable() {
            return this.f2293b;
        }

        public Uri getUri() {
            return this.f2294c;
        }

        public double getScale() {
            return 1.0d;
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.e */
    private class C0888e implements C0853k {
        final /* synthetic */ FacebookAdapter f2295a;

        private C0888e(FacebookAdapter facebookAdapter) {
            this.f2295a = facebookAdapter;
        }

        public void m2831b(C0432a c0432a) {
            this.f2295a.f2302b.onAdClicked(this.f2295a);
            this.f2295a.f2302b.onAdLeftApplication(this.f2295a);
        }

        public void m2829a(C0432a c0432a) {
            this.f2295a.f2302b.onAdLoaded(this.f2295a);
        }

        public void m2830a(C0432a c0432a, C0439c c0439c) {
            Object b = c0439c.m1048b();
            if (!TextUtils.isEmpty(b)) {
                Log.w("FacebookAdapter", b);
            }
            this.f2295a.f2302b.onAdFailedToLoad(this.f2295a, this.f2295a.m2842a(c0439c));
        }

        public void m2833d(C0432a c0432a) {
            this.f2295a.f2302b.onAdClosed(this.f2295a);
        }

        public void m2832c(C0432a c0432a) {
            this.f2295a.f2302b.onAdOpened(this.f2295a);
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.f */
    private interface C0889f {
        void m2834a();

        void m2835b();
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.g */
    private class C0891g implements C0440d {
        final /* synthetic */ FacebookAdapter f2298a;
        private C0869n f2299b;
        private NativeMediationAdRequest f2300c;

        /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter.g.1 */
        class C08901 implements C0889f {
            final /* synthetic */ C0883a f2296a;
            final /* synthetic */ C0891g f2297b;

            C08901(C0891g c0891g, C0883a c0883a) {
                this.f2297b = c0891g;
                this.f2296a = c0883a;
            }

            public void m2836a() {
                this.f2297b.f2298a.f2303c.onAdLoaded(this.f2297b.f2298a, this.f2296a);
            }

            public void m2837b() {
                this.f2297b.f2298a.f2303c.onAdFailedToLoad(this.f2297b.f2298a, 3);
            }
        }

        private C0891g(FacebookAdapter facebookAdapter, C0869n c0869n, NativeMediationAdRequest nativeMediationAdRequest) {
            this.f2298a = facebookAdapter;
            this.f2299b = c0869n;
            this.f2300c = nativeMediationAdRequest;
        }

        public void m2840b(C0432a c0432a) {
            this.f2298a.f2303c.onAdClicked(this.f2298a);
            this.f2298a.f2303c.onAdOpened(this.f2298a);
            this.f2298a.f2303c.onAdLeftApplication(this.f2298a);
        }

        public void m2838a(C0432a c0432a) {
            if (c0432a != this.f2299b) {
                Log.w("FacebookAdapter", "Ad loaded is not a native ad.");
                this.f2298a.f2303c.onAdFailedToLoad(this.f2298a, 0);
                return;
            }
            C0883a c0883a = new C0883a(this.f2298a, this.f2299b, this.f2300c.getNativeAdOptions());
            c0883a.m2820a(new C08901(this, c0883a));
        }

        public void m2839a(C0432a c0432a, C0439c c0439c) {
            Object b = c0439c.m1048b();
            if (!TextUtils.isEmpty(b)) {
                Log.w("FacebookAdapter", b);
            }
            this.f2298a.f2303c.onAdFailedToLoad(this.f2298a, this.f2298a.m2842a(c0439c));
        }
    }

    public FacebookAdapter() {
        this.f2309i = true;
    }

    public void onDestroy() {
        if (this.f2304d != null) {
            this.f2304d.m1088b();
        }
        if (this.f2306f != null) {
            this.f2306f.m1105b();
        }
        if (this.f2307g != null) {
            this.f2307g.m2736x();
            this.f2307g.m2715c();
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public View getBannerView() {
        return this.f2305e;
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f2301a = mediationBannerListener;
        String str;
        if (context == null || bundle == null || adSize == null) {
            str = "context";
            if (bundle == null) {
                str = "serverParameters";
            } else if (adSize == null) {
                str = "adSize";
            }
            Log.w("FacebookAdapter", "Fail to request banner ad, " + str + " is null");
            this.f2301a.onAdFailedToLoad(this, 0);
            return;
        }
        str = bundle.getString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER);
        if (str == null) {
            Log.w("FacebookAdapter", "Fail to request banner Ad, placementId is null");
            this.f2301a.onAdFailedToLoad(this, 0);
            return;
        }
        C0442f a = m2844a(context, adSize);
        if (a == null) {
            Log.w("FacebookAdapter", "The input ad size " + adSize.toString() + " is not supported at this moment.");
            this.f2301a.onAdFailedToLoad(this, 3);
            return;
        }
        this.f2304d = new C0445g(context, str, a);
        this.f2304d.setAdListener(new C0884b());
        m2845a(mediationAdRequest);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(adSize.getWidthInPixels(context), adSize.getHeightInPixels(context));
        this.f2305e = new RelativeLayout(context);
        this.f2305e.setLayoutParams(layoutParams);
        this.f2305e.addView(this.f2304d);
        this.f2304d.m1087a();
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f2302b = mediationInterstitialListener;
        if (context == null || bundle == null) {
            Log.w("FacebookAdapter", "Fail to request interstitial ad, " + (context == null ? "context" : "serverParameters") + " is null");
            this.f2302b.onAdFailedToLoad(this, 0);
            return;
        }
        String string = bundle.getString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER);
        if (string == null) {
            Log.w("FacebookAdapter", "Fail to request interstitial Ad, placementId is null");
            this.f2302b.onAdFailedToLoad(this, 0);
            return;
        }
        this.f2306f = new C0448i(context, string);
        this.f2306f.m1104a(new C0888e());
        m2845a(mediationAdRequest);
        this.f2306f.m1103a();
    }

    public void showInterstitial() {
        if (this.f2306f.m1106c()) {
            this.f2306f.m1107d();
        }
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.f2303c = mediationNativeListener;
        if (context == null || bundle == null) {
            Log.w("FacebookAdapter", "Failed to request native ad, " + (context == null ? "context" : "serverParameters") + " is null");
            this.f2303c.onAdFailedToLoad(this, 1);
        } else if (nativeMediationAdRequest.isAppInstallAdRequested() && nativeMediationAdRequest.isContentAdRequested()) {
            String string = bundle.getString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER);
            if (string == null) {
                Log.w("FacebookAdapter", "Failed to request native ad, placementId is null");
                this.f2303c.onAdFailedToLoad(this, 1);
                return;
            }
            if (bundle2 != null) {
                this.f2309i = bundle2.getBoolean("expandable_icon", true);
            }
            this.f2307g = new C0869n(context, string);
            this.f2307g.m2708a(new C0891g(this.f2307g, nativeMediationAdRequest, null));
            this.f2307g.m2709a(new C08821(this));
            m2845a((MediationAdRequest) nativeMediationAdRequest);
            this.f2307g.m2714b();
        } else {
            Log.w("FacebookAdapter", "Failed to request native ad. Both app install and content ad should be requested");
            this.f2303c.onAdFailedToLoad(this, 1);
        }
    }

    private int m2842a(C0439c c0439c) {
        if (c0439c == null) {
            return 0;
        }
        int a = c0439c.m1047a();
        if (a == 2001 || a == 2000) {
            return 0;
        }
        if (a == PointerIconCompat.TYPE_DEFAULT) {
            return 2;
        }
        if (a == PointerIconCompat.TYPE_HAND) {
            return 1;
        }
        return 3;
    }

    private void m2845a(MediationAdRequest mediationAdRequest) {
        boolean z = true;
        if (mediationAdRequest != null) {
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            C0441e.m1054a(z);
        }
    }

    private C0442f m2844a(Context context, AdSize adSize) {
        if (adSize.getWidth() == C0442f.f755a.m1060a() && adSize.getHeight() == C0442f.f755a.m1061b()) {
            return C0442f.f755a;
        }
        int a = m2841a(adSize.getHeightInPixels(context));
        if (a == C0442f.f757c.m1061b()) {
            return C0442f.f757c;
        }
        if (a == C0442f.f758d.m1061b()) {
            return C0442f.f758d;
        }
        if (a == C0442f.f759e.m1061b()) {
            return C0442f.f759e;
        }
        return null;
    }

    private int m2841a(int i) {
        return Math.round(((float) i) / Resources.getSystem().getDisplayMetrics().density);
    }
}
