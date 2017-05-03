package com.facebook.ads.internal.p024b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.ads.C0439c;
import com.facebook.ads.C0869n;
import com.facebook.ads.C0869n.C0864a;
import com.facebook.ads.C0869n.C0866c;
import com.facebook.ads.C0872p;
import com.facebook.ads.internal.p021m.C0699k;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.aj;
import com.facebook.ads.internal.p025h.C0578f;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAdView;
import java.util.List;
import java.util.Map;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.i */
public class C0482i extends ab implements C0481z {
    private static final String f873a;
    private View f874b;
    private NativeAd f875c;
    private ac f876d;
    private NativeAdView f877e;
    private View f878f;
    private boolean f879g;
    private Uri f880h;
    private Uri f881i;
    private String f882j;
    private String f883k;
    private String f884l;
    private String f885m;

    /* renamed from: com.facebook.ads.internal.b.i.1 */
    class C04771 implements OnAppInstallAdLoadedListener {
        final /* synthetic */ Context f866a;
        final /* synthetic */ C0482i f867b;

        C04771(C0482i c0482i, Context context) {
            this.f867b = c0482i;
            this.f866a = context;
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            Uri uri = null;
            this.f867b.f875c = nativeAppInstallAd;
            this.f867b.f879g = true;
            this.f867b.f882j = nativeAppInstallAd.getHeadline() != null ? nativeAppInstallAd.getHeadline().toString() : null;
            this.f867b.f883k = nativeAppInstallAd.getBody() != null ? nativeAppInstallAd.getBody().toString() : null;
            this.f867b.f885m = nativeAppInstallAd.getStore() != null ? nativeAppInstallAd.getStore().toString() : null;
            this.f867b.f884l = nativeAppInstallAd.getCallToAction() != null ? nativeAppInstallAd.getCallToAction().toString() : null;
            List images = nativeAppInstallAd.getImages();
            C0482i c0482i = this.f867b;
            Uri uri2 = (images == null || images.size() <= 0) ? null : ((Image) images.get(0)).getUri();
            c0482i.f880h = uri2;
            C0482i c0482i2 = this.f867b;
            if (nativeAppInstallAd.getIcon() != null) {
                uri = nativeAppInstallAd.getIcon().getUri();
            }
            c0482i2.f881i = uri;
            if (this.f867b.f876d != null) {
                C0712u.m2307a(this.f866a, aj.m2160a(this.f867b.m1263D()) + " Loaded");
                this.f867b.f876d.m1169a(this.f867b);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.i.2 */
    class C04782 implements OnContentAdLoadedListener {
        final /* synthetic */ Context f868a;
        final /* synthetic */ C0482i f869b;

        C04782(C0482i c0482i, Context context) {
            this.f869b = c0482i;
            this.f868a = context;
        }

        public void onContentAdLoaded(NativeContentAd nativeContentAd) {
            Uri uri = null;
            this.f869b.f875c = nativeContentAd;
            this.f869b.f879g = true;
            this.f869b.f882j = nativeContentAd.getHeadline() != null ? nativeContentAd.getHeadline().toString() : null;
            this.f869b.f883k = nativeContentAd.getBody() != null ? nativeContentAd.getBody().toString() : null;
            this.f869b.f885m = nativeContentAd.getAdvertiser() != null ? nativeContentAd.getAdvertiser().toString() : null;
            this.f869b.f884l = nativeContentAd.getCallToAction() != null ? nativeContentAd.getCallToAction().toString() : null;
            List images = nativeContentAd.getImages();
            C0482i c0482i = this.f869b;
            Uri uri2 = (images == null || images.size() <= 0) ? null : ((Image) images.get(0)).getUri();
            c0482i.f880h = uri2;
            C0482i c0482i2 = this.f869b;
            if (nativeContentAd.getLogo() != null) {
                uri = nativeContentAd.getLogo().getUri();
            }
            c0482i2.f881i = uri;
            if (this.f869b.f876d != null) {
                C0712u.m2307a(this.f868a, aj.m2160a(this.f869b.m1263D()) + " Loaded");
                this.f869b.f876d.m1169a(this.f869b);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.i.3 */
    class C04793 extends AdListener {
        final /* synthetic */ Context f870a;
        final /* synthetic */ C0482i f871b;

        C04793(C0482i c0482i, Context context) {
            this.f871b = c0482i;
            this.f870a = context;
        }

        public void onAdFailedToLoad(int i) {
            C0712u.m2307a(this.f870a, aj.m2160a(this.f871b.m1263D()) + " Failed with error code: " + i);
            if (this.f871b.f876d != null) {
                this.f871b.f876d.m1170a(this.f871b, new C0439c(3001, "AdMob error code: " + i));
            }
        }

        public void onAdOpened() {
            if (this.f871b.f876d != null) {
                this.f871b.f876d.m1172c(this.f871b);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.i.4 */
    class C04804 implements OnClickListener {
        final /* synthetic */ C0482i f872a;

        C04804(C0482i c0482i) {
            this.f872a = c0482i;
        }

        public void onClick(View view) {
            this.f872a.f878f.performClick();
        }
    }

    static {
        f873a = C0482i.class.getSimpleName();
    }

    private void m1253a(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    public String m1260A() {
        return null;
    }

    public List<C0869n> m1261B() {
        return null;
    }

    public String m1262C() {
        return null;
    }

    public C0485k m1263D() {
        return C0485k.ADMOB;
    }

    public void m1264a(int i) {
    }

    public void m1265a(Context context, ac acVar, C0578f c0578f, Map<String, Object> map) {
        boolean z;
        boolean z2;
        C0712u.m2307a(context, aj.m2160a(m1263D()) + " Loading");
        JSONObject jSONObject = (JSONObject) map.get("data");
        String optString = jSONObject.optString("ad_unit_id");
        JSONArray optJSONArray = jSONObject.optJSONArray("creative_types");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i = 0;
            z = false;
            z2 = false;
            while (i < length) {
                try {
                    String string = optJSONArray.getString(i);
                    if (string != null) {
                        boolean z3 = true;
                        switch (string.hashCode()) {
                            case 704091517:
                                if (string.equals("app_install")) {
                                    z3 = false;
                                    break;
                                }
                                break;
                            case 883765328:
                                if (string.equals("page_post")) {
                                    z3 = true;
                                    break;
                                }
                                break;
                        }
                        switch (z3) {
                            case NendAdIconLayout.HORIZONTAL /*0*/:
                                z2 = true;
                                break;
                            case NendIconError.ERROR_ICONVIEW /*1*/:
                                z = true;
                                break;
                            default:
                                break;
                        }
                    }
                    i++;
                } catch (JSONException e) {
                    C0712u.m2307a(context, aj.m2160a(m1263D()) + " AN server error");
                    acVar.m1170a(this, C0439c.f739d);
                    return;
                }
            }
        }
        z = false;
        z2 = false;
        if (TextUtils.isEmpty(optString) || !(z2 || z)) {
            C0712u.m2307a(context, aj.m2160a(m1263D()) + " AN server error");
            acVar.m1170a(this, C0439c.f739d);
            return;
        }
        this.f876d = acVar;
        Builder builder = new Builder(context, optString);
        if (z2) {
            builder.forAppInstallAd(new C04771(this, context));
        }
        if (z) {
            builder.forContentAd(new C04782(this, context));
        }
        builder.withAdListener(new C04793(this, context)).withNativeAdOptions(new NativeAdOptions.Builder().setReturnUrlsForImageAssets(true).build()).build().loadAd(new AdRequest.Builder().build());
    }

    public void m1266a(View view, List<View> list) {
        this.f874b = view;
        if (m1272d() && view != null) {
            ViewGroup viewGroup;
            int i;
            int i2 = -1;
            ViewGroup viewGroup2 = null;
            while (true) {
                ViewGroup viewGroup3 = (ViewGroup) view.getParent();
                if (viewGroup3 == null) {
                    Log.e(f873a, "View must have valid parent for AdMob registration, skipping registration. Impressions and clicks will not be logged.");
                    return;
                }
                if (viewGroup3 instanceof NativeAdView) {
                    viewGroup = (ViewGroup) viewGroup3.getParent();
                    if (viewGroup == null) {
                        Log.e(f873a, "View must have valid parent for AdMob registration, skipping registration. Impressions and clicks will not be logged.");
                        return;
                    }
                    int indexOfChild = viewGroup.indexOfChild(viewGroup3);
                    viewGroup3.removeView(view);
                    viewGroup.removeView(viewGroup3);
                    viewGroup.addView(view, indexOfChild);
                    i = i2;
                    viewGroup = viewGroup2;
                } else {
                    viewGroup = viewGroup3;
                    i = viewGroup3.indexOfChild(view);
                }
                if (viewGroup != null) {
                    break;
                }
                i2 = i;
                viewGroup2 = viewGroup;
            }
            View nativeContentAdView = this.f875c instanceof NativeContentAd ? new NativeContentAdView(view.getContext()) : new NativeAppInstallAdView(view.getContext());
            if (view instanceof ViewGroup) {
                nativeContentAdView.setLayoutParams(view.getLayoutParams());
            }
            m1253a(view);
            nativeContentAdView.addView(view);
            viewGroup.removeView(nativeContentAdView);
            viewGroup.addView(nativeContentAdView, i);
            this.f877e = nativeContentAdView;
            this.f877e.setNativeAd(this.f875c);
            this.f878f = new View(view.getContext());
            this.f877e.addView(this.f878f);
            this.f878f.setVisibility(8);
            if (this.f877e instanceof NativeContentAdView) {
                ((NativeContentAdView) this.f877e).setCallToActionView(this.f878f);
            } else if (this.f877e instanceof NativeAppInstallAdView) {
                ((NativeAppInstallAdView) this.f877e).setCallToActionView(this.f878f);
            }
            OnClickListener c04804 = new C04804(this);
            for (View onClickListener : list) {
                onClickListener.setOnClickListener(c04804);
            }
        }
    }

    public void m1267a(ac acVar) {
        this.f876d = acVar;
    }

    public void m1268a(Map<String, String> map) {
        if (m1272d() && this.f876d != null) {
            this.f876d.m1171b(this);
        }
    }

    public void m1269b() {
        m1271c();
        this.f876d = null;
        this.f875c = null;
        this.f879g = false;
        this.f880h = null;
        this.f881i = null;
        this.f882j = null;
        this.f883k = null;
        this.f884l = null;
        this.f885m = null;
    }

    public void m1270b(Map<String, String> map) {
    }

    public void m1271c() {
        m1253a(this.f878f);
        this.f878f = null;
        if (this.f874b != null) {
            View view = (ViewGroup) this.f874b.getParent();
            if ((view instanceof NativeContentAdView) || (view instanceof NativeAppInstallAdView)) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    int indexOfChild = viewGroup.indexOfChild(view);
                    m1253a(this.f874b);
                    m1253a(view);
                    viewGroup.addView(this.f874b, indexOfChild);
                }
            }
            this.f874b = null;
        }
        this.f877e = null;
    }

    public boolean m1272d() {
        return this.f879g && this.f875c != null;
    }

    public boolean m1273e() {
        return false;
    }

    public boolean m1274f() {
        return false;
    }

    public boolean m1275g() {
        return false;
    }

    public boolean m1276h() {
        return false;
    }

    public int m1277i() {
        return 0;
    }

    public int m1278j() {
        return 0;
    }

    public int m1279k() {
        return 0;
    }

    public C0864a m1280l() {
        return (!m1272d() || this.f881i == null) ? null : new C0864a(this.f881i.toString(), 50, 50);
    }

    public C0864a m1281m() {
        return (!m1272d() || this.f880h == null) ? null : new C0864a(this.f880h.toString(), 1200, 600);
    }

    public C0872p m1282n() {
        return null;
    }

    public String m1283o() {
        return this.f882j;
    }

    public String m1284p() {
        return null;
    }

    public String m1285q() {
        return this.f883k;
    }

    public String m1286r() {
        return this.f884l;
    }

    public String m1287s() {
        return this.f885m;
    }

    public C0866c m1288t() {
        return null;
    }

    public C0864a m1289u() {
        return null;
    }

    public String m1290v() {
        return null;
    }

    public String m1291w() {
        return null;
    }

    public String m1292x() {
        return null;
    }

    public String m1293y() {
        return null;
    }

    public C0699k m1294z() {
        return C0699k.UNKNOWN;
    }
}
