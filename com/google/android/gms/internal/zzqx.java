package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdSize;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzw;
import com.google.api.client.http.HttpMethods;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzme
public class zzqx extends WebViewClient {
    private static final String[] zzZv;
    private static final String[] zzZw;
    private zzhz zzHC;
    private zzih zzIm;
    private zzf zzIo;
    private zzkr zzIp;
    private zzif zzIr;
    protected zzqw zzIs;
    private zzkx zzMh;
    private zzb zzZA;
    private zzc zzZB;
    private boolean zzZC;
    private boolean zzZD;
    private OnGlobalLayoutListener zzZE;
    private OnScrollChangedListener zzZF;
    private boolean zzZG;
    private zzq zzZH;
    private final zzkv zzZI;
    private zze zzZJ;
    @Nullable
    protected zzot zzZK;
    private boolean zzZL;
    private boolean zzZM;
    private boolean zzZN;
    private int zzZO;
    private final HashMap<String, List<zzid>> zzZx;
    private zzh zzZy;
    private zza zzZz;
    private final Object zzrJ;
    private boolean zzwe;
    private zzdx zzyR;

    public interface zza {
        void zza(zzqw com_google_android_gms_internal_zzqw, boolean z);
    }

    public interface zze {
        void zzce();
    }

    public interface zzc {
        void zzcf();
    }

    public interface zzb {
        void zzk(zzqw com_google_android_gms_internal_zzqw);
    }

    /* renamed from: com.google.android.gms.internal.zzqx.1 */
    class C13851 implements Runnable {
        final /* synthetic */ zzqx zzZP;

        C13851(zzqx com_google_android_gms_internal_zzqx) {
            this.zzZP = com_google_android_gms_internal_zzqx;
        }

        public void run() {
            if (this.zzZP.zzZK != null) {
                zzot com_google_android_gms_internal_zzot = this.zzZP.zzZK;
                zzqw com_google_android_gms_internal_zzqw = this.zzZP.zzIs;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqx.2 */
    class C13862 implements Runnable {
        final /* synthetic */ zzqx zzZP;

        C13862(zzqx com_google_android_gms_internal_zzqx) {
            this.zzZP = com_google_android_gms_internal_zzqx;
        }

        public void run() {
            this.zzZP.zzIs.zzlI();
            com.google.android.gms.ads.internal.overlay.zze zzlt = this.zzZP.zzIs.zzlt();
            if (zzlt != null) {
                zzlt.zzhG();
            }
            if (this.zzZP.zzZB != null) {
                this.zzZP.zzZB.zzcf();
                this.zzZP.zzZB = null;
            }
        }
    }

    private static class zzd implements zzh {
        private zzqw zzZQ;
        private zzh zzZy;

        public zzd(zzqw com_google_android_gms_internal_zzqw, zzh com_google_android_gms_ads_internal_overlay_zzh) {
            this.zzZQ = com_google_android_gms_internal_zzqw;
            this.zzZy = com_google_android_gms_ads_internal_overlay_zzh;
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void zzbN() {
            this.zzZy.zzbN();
            this.zzZQ.zzlp();
        }

        public void zzbO() {
            this.zzZy.zzbO();
            this.zzZQ.zzhK();
        }
    }

    static {
        zzZv = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", HttpMethods.CONNECT, "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
        zzZw = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    }

    public zzqx(zzqw com_google_android_gms_internal_zzqw, boolean z) {
        this(com_google_android_gms_internal_zzqw, z, new zzkv(com_google_android_gms_internal_zzqw, com_google_android_gms_internal_zzqw.zzls(), new zzfv(com_google_android_gms_internal_zzqw.getContext())), null);
    }

    zzqx(zzqw com_google_android_gms_internal_zzqw, boolean z, zzkv com_google_android_gms_internal_zzkv, zzkr com_google_android_gms_internal_zzkr) {
        this.zzZx = new HashMap();
        this.zzrJ = new Object();
        this.zzZC = false;
        this.zzIs = com_google_android_gms_internal_zzqw;
        this.zzwe = z;
        this.zzZI = com_google_android_gms_internal_zzkv;
        this.zzIp = com_google_android_gms_internal_zzkr;
    }

    private String zzbk(String str) {
        if (TextUtils.isEmpty(str)) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    private void zzc(Context context, String str, String str2, String str3) {
        if (((Boolean) zzgd.zzDy.get()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompatApi24.CATEGORY_ERROR, str);
            bundle.putString("code", str2);
            bundle.putString("host", zzbk(str3));
            zzw.zzcM().zza(context, this.zzIs.zzly().zzba, "gmob-apps", bundle, true);
        }
    }

    private static boolean zzi(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void zzlX() {
        if (this.zzZA != null) {
            this.zzZA.zzk(this.zzIs);
            this.zzZA = null;
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2 = "Loading resource: ";
        String valueOf = String.valueOf(str);
        zzpk.m4709v(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzrJ) {
            if (this.zzZL) {
                zzpk.m4709v("Blank page loaded, 1...");
                this.zzIs.zzlA();
                return;
            }
            this.zzZM = true;
            zzlX();
            zzlY();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= zzZv.length) ? String.valueOf(i) : zzZv[(-i) - 1];
        zzc(this.zzIs.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= zzZw.length) ? String.valueOf(primaryError) : zzZw[primaryError];
            zzc(this.zzIs.getContext(), "ssl_err", valueOf, zzw.zzcO().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        if (this.zzZK != null) {
            this.zzZK = null;
        }
        synchronized (this.zzrJ) {
            this.zzZx.clear();
            this.zzyR = null;
            this.zzZy = null;
            this.zzZz = null;
            this.zzZA = null;
            this.zzHC = null;
            this.zzZC = false;
            this.zzwe = false;
            this.zzZD = false;
            this.zzZG = false;
            this.zzIr = null;
            this.zzZH = null;
            this.zzZB = null;
            if (this.zzIp != null) {
                this.zzIp.zzs(true);
                this.zzIp = null;
            }
        }
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            zzds zzJ = zzds.zzJ(str);
            if (zzJ == null) {
                return null;
            }
            zzdp zza = zzw.zzcR().zza(zzJ);
            return (zza == null || !zza.zzew()) ? null : new WebResourceResponse(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, zza.zzex());
        } catch (Throwable th) {
            zzw.zzcQ().zza(th, "AdWebViewClient.shouldInterceptRequest");
            return null;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case C0268R.styleable.AppCompatTheme_panelBackground /*79*/:
            case C0268R.styleable.AppCompatTheme_colorAccent /*85*/:
            case C0268R.styleable.AppCompatTheme_colorControlNormal /*86*/:
            case C0268R.styleable.AppCompatTheme_colorControlActivated /*87*/:
            case C0268R.styleable.AppCompatTheme_colorControlHighlight /*88*/:
            case C0268R.styleable.AppCompatTheme_colorButtonNormal /*89*/:
            case AdSize.LARGE_AD_HEIGHT /*90*/:
            case C0268R.styleable.AppCompatTheme_controlBackground /*91*/:
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "AdWebView shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(str);
        zzpk.m4709v(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        } else if (this.zzZC && webView == this.zzIs.getWebView() && zzi(parse)) {
            if (this.zzyR != null && ((Boolean) zzgd.zzCw.get()).booleanValue()) {
                this.zzyR.onAdClicked();
                this.zzyR = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (this.zzIs.getWebView().willNotDraw()) {
            str2 = "AdWebView unable to handle URL: ";
            valueOf = String.valueOf(str);
            zzqf.zzbh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            Uri uri;
            try {
                zzaw zzlx = this.zzIs.zzlx();
                if (zzlx != null && zzlx.zzc(parse)) {
                    parse = zzlx.zza(parse, this.zzIs.getContext(), this.zzIs.getView());
                }
                uri = parse;
            } catch (zzax e) {
                String str3 = "Unable to append parameter to URL: ";
                str2 = String.valueOf(str);
                zzqf.zzbh(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                uri = parse;
            }
            if (this.zzIo == null || this.zzIo.zzcd()) {
                zza(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.zzIo.zzx(str);
            }
        }
        return true;
    }

    public void zzO(boolean z) {
        this.zzZC = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzZI.zzf(i, i2);
        if (this.zzIp != null) {
            this.zzIp.zza(i, i2, z);
        }
    }

    public final void zza(OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.zzrJ) {
            this.zzZD = true;
            this.zzIs.zzlI();
            this.zzZE = onGlobalLayoutListener;
            this.zzZF = onScrollChangedListener;
        }
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zzhm = this.zzIp != null ? this.zzIp.zzhm() : false;
        com.google.android.gms.ads.internal.overlay.zzf zzcK = zzw.zzcK();
        Context context = this.zzIs.getContext();
        if (!zzhm) {
            z = true;
        }
        zzcK.zza(context, adOverlayInfoParcel, z);
        if (this.zzZK != null && adOverlayInfoParcel.url == null && adOverlayInfoParcel.zzNE != null) {
            String str = adOverlayInfoParcel.zzNE.url;
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzc com_google_android_gms_ads_internal_overlay_zzc) {
        zzh com_google_android_gms_ads_internal_overlay_zzh = null;
        boolean zzlz = this.zzIs.zzlz();
        zzdx com_google_android_gms_internal_zzdx = (!zzlz || this.zzIs.zzbC().zzzz) ? this.zzyR : null;
        if (!zzlz) {
            com_google_android_gms_ads_internal_overlay_zzh = this.zzZy;
        }
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_overlay_zzc, com_google_android_gms_internal_zzdx, com_google_android_gms_ads_internal_overlay_zzh, this.zzZH, this.zzIs.zzly()));
    }

    public void zza(zzdx com_google_android_gms_internal_zzdx, zzh com_google_android_gms_ads_internal_overlay_zzh, zzhz com_google_android_gms_internal_zzhz, zzq com_google_android_gms_ads_internal_overlay_zzq, boolean z, zzif com_google_android_gms_internal_zzif, @Nullable zzih com_google_android_gms_internal_zzih, zzf com_google_android_gms_ads_internal_zzf, zzkx com_google_android_gms_internal_zzkx, @Nullable zzot com_google_android_gms_internal_zzot) {
        if (com_google_android_gms_ads_internal_zzf == null) {
            com_google_android_gms_ads_internal_zzf = new zzf(this.zzIs.getContext());
        }
        this.zzIp = new zzkr(this.zzIs, com_google_android_gms_internal_zzkx);
        this.zzZK = com_google_android_gms_internal_zzot;
        zza("/appEvent", new zzhy(com_google_android_gms_internal_zzhz));
        zza("/backButton", zzic.zzHO);
        zza("/refresh", zzic.zzHP);
        zza("/canOpenURLs", zzic.zzHE);
        zza("/canOpenIntents", zzic.zzHF);
        zza("/click", zzic.zzHG);
        zza("/close", zzic.zzHH);
        zza("/customClose", zzic.zzHJ);
        zza("/instrument", zzic.zzHU);
        zza("/delayPageLoaded", zzic.zzHW);
        zza("/delayPageClosed", zzic.zzHX);
        zza("/getLocationInfo", zzic.zzHY);
        zza("/httpTrack", zzic.zzHK);
        zza("/log", zzic.zzHL);
        zza("/mraid", new zzik(com_google_android_gms_ads_internal_zzf, this.zzIp));
        zza("/mraidLoaded", this.zzZI);
        zza("/open", new zzil(com_google_android_gms_internal_zzif, com_google_android_gms_ads_internal_zzf, this.zzIp));
        zza("/precache", zzic.zzHT);
        zza("/touch", zzic.zzHN);
        zza("/video", zzic.zzHQ);
        zza("/videoMeta", zzic.zzHR);
        zza("/appStreaming", zzic.zzHI);
        if (zzw.zzdl().zzjQ()) {
            zza("/logScionEvent", zzic.zzHS);
        }
        if (com_google_android_gms_internal_zzih != null) {
            zza("/setInterstitialProperties", new zzig(com_google_android_gms_internal_zzih));
        }
        this.zzyR = com_google_android_gms_internal_zzdx;
        this.zzZy = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzHC = com_google_android_gms_internal_zzhz;
        this.zzIr = com_google_android_gms_internal_zzif;
        this.zzZH = com_google_android_gms_ads_internal_overlay_zzq;
        this.zzIo = com_google_android_gms_ads_internal_zzf;
        this.zzMh = com_google_android_gms_internal_zzkx;
        this.zzIm = com_google_android_gms_internal_zzih;
        zzO(z);
    }

    public void zza(zza com_google_android_gms_internal_zzqx_zza) {
        this.zzZz = com_google_android_gms_internal_zzqx_zza;
    }

    public void zza(zzb com_google_android_gms_internal_zzqx_zzb) {
        this.zzZA = com_google_android_gms_internal_zzqx_zzb;
    }

    public void zza(zzc com_google_android_gms_internal_zzqx_zzc) {
        this.zzZB = com_google_android_gms_internal_zzqx_zzc;
    }

    public void zza(zze com_google_android_gms_internal_zzqx_zze) {
        this.zzZJ = com_google_android_gms_internal_zzqx_zze;
    }

    public void zza(String str, zzid com_google_android_gms_internal_zzid) {
        synchronized (this.zzrJ) {
            List list = (List) this.zzZx.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzZx.put(str, list);
            }
            list.add(com_google_android_gms_internal_zzid);
        }
    }

    public final void zza(boolean z, int i) {
        zzdx com_google_android_gms_internal_zzdx = (!this.zzIs.zzlz() || this.zzIs.zzbC().zzzz) ? this.zzyR : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_internal_zzdx, this.zzZy, this.zzZH, this.zzIs, z, i, this.zzIs.zzly()));
    }

    public final void zza(boolean z, int i, String str) {
        zzh com_google_android_gms_ads_internal_overlay_zzh = null;
        boolean zzlz = this.zzIs.zzlz();
        zzdx com_google_android_gms_internal_zzdx = (!zzlz || this.zzIs.zzbC().zzzz) ? this.zzyR : null;
        if (!zzlz) {
            com_google_android_gms_ads_internal_overlay_zzh = new zzd(this.zzIs, this.zzZy);
        }
        zza(new AdOverlayInfoParcel(com_google_android_gms_internal_zzdx, com_google_android_gms_ads_internal_overlay_zzh, this.zzHC, this.zzZH, this.zzIs, z, i, str, this.zzIs.zzly(), this.zzIr));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzlz = this.zzIs.zzlz();
        zzdx com_google_android_gms_internal_zzdx = (!zzlz || this.zzIs.zzbC().zzzz) ? this.zzyR : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_internal_zzdx, zzlz ? null : new zzd(this.zzIs, this.zzZy), this.zzHC, this.zzZH, this.zzIs, z, i, str, str2, this.zzIs.zzly(), this.zzIr));
    }

    public void zzb(String str, zzid com_google_android_gms_internal_zzid) {
        synchronized (this.zzrJ) {
            List list = (List) this.zzZx.get(str);
            if (list == null) {
                return;
            }
            list.remove(com_google_android_gms_internal_zzid);
        }
    }

    public boolean zzdD() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzwe;
        }
        return z;
    }

    public void zze(int i, int i2) {
        if (this.zzIp != null) {
            this.zzIp.zze(i, i2);
        }
    }

    public final void zzhG() {
        synchronized (this.zzrJ) {
            this.zzZC = false;
            this.zzwe = true;
            zzw.zzcM().runOnUiThread(new C13862(this));
        }
    }

    public void zzj(Uri uri) {
        String path = uri.getPath();
        List<zzid> list = (List) this.zzZx.get(path);
        if (list != null) {
            Map zzg = zzw.zzcM().zzg(uri);
            if (zzqf.zzak(2)) {
                String str = "Received GMSG: ";
                path = String.valueOf(path);
                zzpk.m4709v(path.length() != 0 ? str.concat(path) : new String(str));
                for (String path2 : zzg.keySet()) {
                    str = (String) zzg.get(path2);
                    zzpk.m4709v(new StringBuilder((String.valueOf(path2).length() + 4) + String.valueOf(str).length()).append("  ").append(path2).append(": ").append(str).toString());
                }
            }
            for (zzid zza : list) {
                zza.zza(this.zzIs, zzg);
            }
            return;
        }
        String valueOf = String.valueOf(uri);
        zzpk.m4709v(new StringBuilder(String.valueOf(valueOf).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf).toString());
    }

    public zzf zzlN() {
        return this.zzIo;
    }

    public boolean zzlO() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzZD;
        }
        return z;
    }

    public OnGlobalLayoutListener zzlP() {
        OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.zzrJ) {
            onGlobalLayoutListener = this.zzZE;
        }
        return onGlobalLayoutListener;
    }

    public OnScrollChangedListener zzlQ() {
        OnScrollChangedListener onScrollChangedListener;
        synchronized (this.zzrJ) {
            onScrollChangedListener = this.zzZF;
        }
        return onScrollChangedListener;
    }

    public boolean zzlR() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzZG;
        }
        return z;
    }

    public void zzlS() {
        synchronized (this.zzrJ) {
            zzpk.m4709v("Loading blank page in WebView, 2...");
            this.zzZL = true;
            this.zzIs.zzbi("about:blank");
        }
    }

    public void zzlT() {
        if (this.zzZK != null) {
            zzpo.zzXC.post(new C13851(this));
        }
    }

    public void zzlU() {
        synchronized (this.zzrJ) {
            this.zzZG = true;
        }
        this.zzZO++;
        zzlY();
    }

    public void zzlV() {
        this.zzZO--;
        zzlY();
    }

    public void zzlW() {
        this.zzZN = true;
        zzlY();
    }

    public final void zzlY() {
        if (this.zzZz != null && ((this.zzZM && this.zzZO <= 0) || this.zzZN)) {
            this.zzZz.zza(this.zzIs, !this.zzZN);
            this.zzZz = null;
        }
        this.zzIs.zzlJ();
    }

    public zze zzlZ() {
        return this.zzZJ;
    }

    public void zzo(zzqw com_google_android_gms_internal_zzqw) {
        this.zzIs = com_google_android_gms_internal_zzqw;
    }
}
