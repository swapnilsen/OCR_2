package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v7.appcompat.C0268R;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.zzt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
class zzra extends WebView implements OnGlobalLayoutListener, DownloadListener, zzqw {
    @Nullable
    private final zzaw zzGP;
    private int zzMB;
    private int zzMC;
    private int zzMy;
    private int zzMz;
    private String zzOV;
    private zzgj zzOW;
    private Boolean zzWO;
    private final zza zzZZ;
    private final zzu zzaaa;
    private zzqx zzaab;
    private zze zzaac;
    private boolean zzaad;
    private boolean zzaae;
    private boolean zzaaf;
    private boolean zzaag;
    private int zzaah;
    private boolean zzaai;
    boolean zzaaj;
    private zzrb zzaak;
    private boolean zzaal;
    private boolean zzaam;
    private zzgy zzaan;
    private int zzaao;
    private int zzaap;
    private zzgj zzaaq;
    private zzgj zzaar;
    private zzgk zzaas;
    private WeakReference<OnClickListener> zzaat;
    private zze zzaau;
    private boolean zzaav;
    private Map<String, zzis> zzaaw;
    private final Object zzrJ;
    private final com.google.android.gms.ads.internal.zze zzsv;
    private final zzqh zztt;
    private zzeg zzus;
    private zzqd zzvY;
    private final WindowManager zzwo;

    /* renamed from: com.google.android.gms.internal.zzra.1 */
    class C13891 implements zzid {
        final /* synthetic */ zzra zzaax;

        C13891(zzra com_google_android_gms_internal_zzra) {
            this.zzaax = com_google_android_gms_internal_zzra;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            if (map != null) {
                String str = (String) map.get("height");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        int parseInt = Integer.parseInt(str);
                        synchronized (this.zzaax.zzrJ) {
                            if (this.zzaax.zzaap != parseInt) {
                                this.zzaax.zzaap = parseInt;
                                this.zzaax.requestLayout();
                            }
                        }
                    } catch (Throwable e) {
                        zzqf.zzc("Exception occurred while getting webview content height", e);
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzra.2 */
    class C13902 implements Runnable {
        final /* synthetic */ zzra zzaax;

        C13902(zzra com_google_android_gms_internal_zzra) {
            this.zzaax = com_google_android_gms_internal_zzra;
        }

        public void run() {
            super.destroy();
        }
    }

    @zzme
    public static class zza extends MutableContextWrapper {
        private Activity zzYJ;
        private Context zzaay;
        private Context zzwi;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Object getSystemService(String str) {
            return this.zzaay.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            this.zzwi = context.getApplicationContext();
            this.zzYJ = context instanceof Activity ? (Activity) context : null;
            this.zzaay = context;
            super.setBaseContext(this.zzwi);
        }

        public void startActivity(Intent intent) {
            if (this.zzYJ != null) {
                this.zzYJ.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.zzwi.startActivity(intent);
        }

        public Activity zzlr() {
            return this.zzYJ;
        }

        public Context zzls() {
            return this.zzaay;
        }
    }

    protected zzra(zza com_google_android_gms_internal_zzra_zza, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, @Nullable zzaw com_google_android_gms_internal_zzaw, zzqh com_google_android_gms_internal_zzqh, zzgl com_google_android_gms_internal_zzgl, zzu com_google_android_gms_ads_internal_zzu, com.google.android.gms.ads.internal.zze com_google_android_gms_ads_internal_zze) {
        super(com_google_android_gms_internal_zzra_zza);
        this.zzrJ = new Object();
        this.zzaai = true;
        this.zzaaj = false;
        this.zzOV = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.zzMz = -1;
        this.zzMy = -1;
        this.zzMB = -1;
        this.zzMC = -1;
        this.zzZZ = com_google_android_gms_internal_zzra_zza;
        this.zzus = com_google_android_gms_internal_zzeg;
        this.zzaaf = z;
        this.zzaah = -1;
        this.zzGP = com_google_android_gms_internal_zzaw;
        this.zztt = com_google_android_gms_internal_zzqh;
        this.zzaaa = com_google_android_gms_ads_internal_zzu;
        this.zzsv = com_google_android_gms_ads_internal_zze;
        this.zzwo = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzw.zzcM().zza((Context) com_google_android_gms_internal_zzra_zza, com_google_android_gms_internal_zzqh.zzba, settings);
        zzw.zzcO().zza(getContext(), settings);
        setDownloadListener(this);
        zzmg();
        if (zzt.zzzj()) {
            addJavascriptInterface(new zzrc(this), "googleAdsJsInterface");
        }
        zzt.zzze();
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzvY = new zzqd(this.zzZZ.zzlr(), this, this, null);
        zzd(com_google_android_gms_internal_zzgl);
        zzw.zzcO().zzW(com_google_android_gms_internal_zzra_zza);
    }

    private void zzP(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    static zzra zzb(Context context, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, @Nullable zzaw com_google_android_gms_internal_zzaw, zzqh com_google_android_gms_internal_zzqh, zzgl com_google_android_gms_internal_zzgl, zzu com_google_android_gms_ads_internal_zzu, com.google.android.gms.ads.internal.zze com_google_android_gms_ads_internal_zze) {
        return new zzra(new zza(context), com_google_android_gms_internal_zzeg, z, z2, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzgl, com_google_android_gms_ads_internal_zzu, com_google_android_gms_ads_internal_zze);
    }

    private void zzd(zzgl com_google_android_gms_internal_zzgl) {
        zzmk();
        this.zzaas = new zzgk(new zzgl(true, "make_wv", this.zzus.zzzy));
        this.zzaas.zzfA().zzc(com_google_android_gms_internal_zzgl);
        this.zzOW = zzgh.zzb(this.zzaas.zzfA());
        this.zzaas.zza("native:view_create", this.zzOW);
        this.zzaar = null;
        this.zzaaq = null;
    }

    private void zzkC() {
        synchronized (this.zzrJ) {
            if (!this.zzaav) {
                this.zzaav = true;
                zzw.zzcQ().zzkC();
            }
        }
    }

    private void zzmc() {
        synchronized (this.zzrJ) {
            this.zzWO = zzw.zzcQ().zzkq();
            if (this.zzWO == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    zza(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    zza(Boolean.valueOf(false));
                }
            }
        }
    }

    private void zzmd() {
        zzgh.zza(this.zzaas.zzfA(), this.zzOW, "aeh2");
    }

    private void zzme() {
        zzgh.zza(this.zzaas.zzfA(), this.zzOW, "aebb2");
    }

    private void zzmg() {
        synchronized (this.zzrJ) {
            if (this.zzaaf || this.zzus.zzzz) {
                int i = VERSION.SDK_INT;
                zzqf.zzbf("Enabling hardware acceleration on an overlay.");
                zzmi();
            } else if (VERSION.SDK_INT < 18) {
                zzqf.zzbf("Disabling hardware acceleration on an AdView.");
                zzmh();
            } else {
                zzqf.zzbf("Enabling hardware acceleration on an AdView.");
                zzmi();
            }
        }
    }

    private void zzmh() {
        synchronized (this.zzrJ) {
            if (!this.zzaag) {
                zzw.zzcO().zzu(this);
            }
            this.zzaag = true;
        }
    }

    private void zzmi() {
        synchronized (this.zzrJ) {
            if (this.zzaag) {
                zzw.zzcO().zzt(this);
            }
            this.zzaag = false;
        }
    }

    private void zzmj() {
        synchronized (this.zzrJ) {
            this.zzaaw = null;
        }
    }

    private void zzmk() {
        if (this.zzaas != null) {
            zzgl zzfA = this.zzaas.zzfA();
            if (zzfA != null && zzw.zzcQ().zzkk() != null) {
                zzw.zzcQ().zzkk().zza(zzfA);
            }
        }
    }

    public void destroy() {
        synchronized (this.zzrJ) {
            zzmk();
            this.zzvY.zzlf();
            if (this.zzaac != null) {
                this.zzaac.close();
                this.zzaac.onDestroy();
                this.zzaac = null;
            }
            this.zzaab.reset();
            if (this.zzaae) {
                return;
            }
            zzw.zzdj().zze(this);
            zzmj();
            this.zzaae = true;
            zzpk.m4709v("Initiating WebView self destruct sequence in 3...");
            this.zzaab.zzlS();
        }
    }

    @TargetApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzrJ) {
            if (isDestroyed()) {
                zzqf.zzbh("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
                return;
            }
            super.evaluateJavascript(str, valueCallback);
        }
    }

    protected void finalize() {
        try {
            synchronized (this.zzrJ) {
                if (!this.zzaae) {
                    this.zzaab.reset();
                    zzw.zzdj().zze(this);
                    zzmj();
                    zzkC();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public String getRequestId() {
        String str;
        synchronized (this.zzrJ) {
            str = this.zzOV;
        }
        return str;
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.zzrJ) {
            i = this.zzaah;
        }
        return i;
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzaae;
        }
        return z;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.zzrJ) {
            if (isDestroyed()) {
                zzqf.zzbh("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.zzrJ) {
            if (isDestroyed()) {
                zzqf.zzbh("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.zzrJ) {
            if (isDestroyed()) {
                zzqf.zzbh("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    zzw.zzcQ().zza(th, "AdWebViewImpl.loadUrl");
                    zzqf.zzc("Could not call loadUrl. ", th);
                }
            }
        }
    }

    protected void onAttachedToWindow() {
        boolean z = true;
        synchronized (this.zzrJ) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzvY.onAttachedToWindow();
            }
            boolean z2 = this.zzaal;
            if (zzlv() == null || !zzlv().zzlO()) {
                z = z2;
            } else if (!this.zzaam) {
                OnGlobalLayoutListener zzlP = zzlv().zzlP();
                if (zzlP != null) {
                    zzw.zzdk().zza(getView(), zzlP);
                }
                OnScrollChangedListener zzlQ = zzlv().zzlQ();
                if (zzlQ != null) {
                    zzw.zzdk().zza(getView(), zzlQ);
                }
                this.zzaam = true;
            }
            zzP(z);
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.zzrJ) {
            if (!isDestroyed()) {
                this.zzvY.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzaam && zzlv() != null && zzlv().zzlO() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                OnGlobalLayoutListener zzlP = zzlv().zzlP();
                if (zzlP != null) {
                    zzw.zzcO().zza(getViewTreeObserver(), zzlP);
                }
                OnScrollChangedListener zzlQ = zzlv().zzlQ();
                if (zzlQ != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(zzlQ);
                }
                this.zzaam = false;
            }
        }
        zzP(false);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzw.zzcM().zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzqf.zzbf(new StringBuilder((String.valueOf(str).length() + 51) + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (zzlv() != null && zzlv().zzlZ() != null) {
                    zzlv().zzlZ().zzce();
                }
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) zzgd.zzCK.get()).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if ((motionEvent.getActionMasked() == 8 ? 1 : 0) != 0 && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onGlobalLayout() {
        boolean zzmb = zzmb();
        zze zzlt = zzlt();
        if (zzlt != null && zzmb) {
            zzlt.zzhJ();
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        synchronized (this.zzrJ) {
            if (isDestroyed()) {
                setMeasuredDimension(0, 0);
            } else if (isInEditMode() || this.zzaaf || this.zzus.zzzB) {
                super.onMeasure(i, i2);
            } else if (this.zzus.zzzC) {
                if (((Boolean) zzgd.zzEy.get()).booleanValue() || !zzt.zzzj()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zza("/contentHeight", zzmf());
                zzbm("(function() {  var height = -1;  if (document.body) { height = document.body.offsetHeight;}  else if (document.documentElement) {      height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  window.googleAdsJsInterface.notify(url);  })();");
                r0 = this.zzZZ.getResources().getDisplayMetrics().density;
                r1 = MeasureSpec.getSize(i);
                switch (this.zzaap) {
                    case FirebaseRemoteConfig.LAST_FETCH_STATUS_SUCCESS /*-1*/:
                        i3 = MeasureSpec.getSize(i2);
                        break;
                    default:
                        i3 = (int) (r0 * ((float) this.zzaap));
                        break;
                }
                setMeasuredDimension(r1, i3);
            } else if (this.zzus.zzzz) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.zzwo.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                int mode = MeasureSpec.getMode(i);
                int size = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                r1 = MeasureSpec.getSize(i2);
                mode = (mode == RtlSpacingHelper.UNDEFINED || mode == 1073741824) ? size : Integer.MAX_VALUE;
                if (mode2 == RtlSpacingHelper.UNDEFINED || mode2 == 1073741824) {
                    i3 = r1;
                }
                if (this.zzus.widthPixels > mode || this.zzus.heightPixels > r0) {
                    r0 = this.zzZZ.getResources().getDisplayMetrics().density;
                    mode2 = (int) (((float) this.zzus.heightPixels) / r0);
                    size = (int) (((float) size) / r0);
                    zzqf.zzbh(new StringBuilder(C0268R.styleable.AppCompatTheme_buttonStyleSmall).append("Not enough space to show ad. Needs ").append((int) (((float) this.zzus.widthPixels) / r0)).append("x").append(mode2).append(" dp, but only has ").append(size).append("x").append((int) (((float) r1) / r0)).append(" dp.").toString());
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                } else {
                    if (getVisibility() != 8) {
                        setVisibility(0);
                    }
                    setMeasuredDimension(this.zzus.widthPixels, this.zzus.heightPixels);
                }
            }
        }
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                zzt.zzze();
                super.onPause();
            } catch (Throwable e) {
                zzqf.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                zzt.zzze();
                super.onResume();
            } catch (Throwable e) {
                zzqf.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (zzlv().zzlO()) {
            synchronized (this.zzrJ) {
                if (this.zzaan != null) {
                    this.zzaan.zzc(motionEvent);
                }
            }
        } else if (this.zzGP != null) {
            this.zzGP.zza(motionEvent);
        }
        return isDestroyed() ? false : super.onTouchEvent(motionEvent);
    }

    public void setContext(Context context) {
        this.zzZZ.setBaseContext(context);
        this.zzvY.zzl(this.zzZZ.zzlr());
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.zzaat = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setRequestedOrientation(int i) {
        synchronized (this.zzrJ) {
            this.zzaah = i;
            if (this.zzaac != null) {
                this.zzaac.setRequestedOrientation(this.zzaah);
            }
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzqx) {
            this.zzaab = (zzqx) webViewClient;
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                zzqf.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zzK(boolean z) {
        synchronized (this.zzrJ) {
            this.zzaaf = z;
            zzmg();
        }
    }

    public void zzL(boolean z) {
        synchronized (this.zzrJ) {
            if (this.zzaac != null) {
                this.zzaac.zza(this.zzaab.zzdD(), z);
            } else {
                this.zzaad = z;
            }
        }
    }

    public void zzM(int i) {
        if (i == 0) {
            zzme();
        }
        zzmd();
        if (this.zzaas.zzfA() != null) {
            this.zzaas.zzfA().zzh("close_type", String.valueOf(i));
        }
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zztt.zzba);
        zza("onhide", hashMap);
    }

    public void zzM(boolean z) {
        synchronized (this.zzrJ) {
            this.zzaai = z;
        }
    }

    public void zzN(boolean z) {
        synchronized (this.zzrJ) {
            this.zzaao = (z ? 1 : -1) + this.zzaao;
            if (this.zzaao <= 0 && this.zzaac != null) {
                this.zzaac.zzhM();
            }
        }
    }

    public void zza(Context context, zzeg com_google_android_gms_internal_zzeg, zzgl com_google_android_gms_internal_zzgl) {
        synchronized (this.zzrJ) {
            this.zzvY.zzlf();
            setContext(context);
            this.zzaac = null;
            this.zzus = com_google_android_gms_internal_zzeg;
            this.zzaaf = false;
            this.zzaad = false;
            this.zzOV = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzaah = -1;
            zzw.zzcO().zzm(this);
            loadUrl("about:blank");
            this.zzaab.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.zzaai = true;
            this.zzaaj = false;
            this.zzaak = null;
            zzd(com_google_android_gms_internal_zzgl);
            this.zzaal = false;
            this.zzaao = 0;
            zzw.zzdj().zze(this);
            zzmj();
        }
    }

    public void zza(com.google.android.gms.internal.zzcy.zza com_google_android_gms_internal_zzcy_zza) {
        synchronized (this.zzrJ) {
            this.zzaal = com_google_android_gms_internal_zzcy_zza.zzxl;
        }
        zzP(com_google_android_gms_internal_zzcy_zza.zzxl);
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg) {
        synchronized (this.zzrJ) {
            this.zzus = com_google_android_gms_internal_zzeg;
            requestLayout();
        }
    }

    public void zza(zzrb com_google_android_gms_internal_zzrb) {
        synchronized (this.zzrJ) {
            if (this.zzaak != null) {
                zzqf.m4708e("Attempt to create multiple AdWebViewVideoControllers.");
                return;
            }
            this.zzaak = com_google_android_gms_internal_zzrb;
        }
    }

    void zza(Boolean bool) {
        synchronized (this.zzrJ) {
            this.zzWO = bool;
        }
        zzw.zzcQ().zza(bool);
    }

    @TargetApi(19)
    protected void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzrJ) {
            if (isDestroyed()) {
                zzqf.zzbh("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void zza(String str, zzid com_google_android_gms_internal_zzid) {
        if (this.zzaab != null) {
            this.zzaab.zza(str, com_google_android_gms_internal_zzid);
        }
    }

    public void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, zzw.zzcM().zzQ((Map) map));
        } catch (JSONException e) {
            zzqf.zzbh("Could not convert parameters to JSON.");
        }
    }

    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzj(str, jSONObject.toString());
    }

    public void zzb(zze com_google_android_gms_ads_internal_overlay_zze) {
        synchronized (this.zzrJ) {
            this.zzaac = com_google_android_gms_ads_internal_overlay_zze;
        }
    }

    public void zzb(zzgy com_google_android_gms_internal_zzgy) {
        synchronized (this.zzrJ) {
            this.zzaan = com_google_android_gms_internal_zzgy;
        }
    }

    public void zzb(String str, zzid com_google_android_gms_internal_zzid) {
        if (this.zzaab != null) {
            this.zzaab.zzb(str, com_google_android_gms_internal_zzid);
        }
    }

    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(window.AFMA_ReceiveMessage || function() {})('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        String str2 = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        zzqf.zzbf(jSONObject2.length() != 0 ? str2.concat(jSONObject2) : new String(str2));
        zzbm(stringBuilder.toString());
    }

    public zzeg zzbC() {
        zzeg com_google_android_gms_internal_zzeg;
        synchronized (this.zzrJ) {
            com_google_android_gms_internal_zzeg = this.zzus;
        }
        return com_google_android_gms_internal_zzeg;
    }

    public void zzbV() {
        synchronized (this.zzrJ) {
            this.zzaaj = true;
            if (this.zzaaa != null) {
                this.zzaaa.zzbV();
            }
        }
    }

    public void zzbW() {
        synchronized (this.zzrJ) {
            this.zzaaj = false;
            if (this.zzaaa != null) {
                this.zzaaa.zzbW();
            }
        }
    }

    public void zzbi(String str) {
        synchronized (this.zzrJ) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                zzw.zzcQ().zza(th, "AdWebViewImpl.loadUrlUnsafe");
                zzqf.zzc("Could not call loadUrl. ", th);
            }
        }
    }

    public void zzbj(String str) {
        synchronized (this.zzrJ) {
            if (str == null) {
                str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            }
            this.zzOV = str;
        }
    }

    protected void zzbl(String str) {
        synchronized (this.zzrJ) {
            if (isDestroyed()) {
                zzqf.zzbh("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    protected void zzbm(String str) {
        if (zzt.zzzl()) {
            if (zzkq() == null) {
                zzmc();
            }
            if (zzkq().booleanValue()) {
                zza(str, null);
                return;
            }
            String str2 = "javascript:";
            String valueOf = String.valueOf(str);
            zzbl(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        str2 = "javascript:";
        valueOf = String.valueOf(str);
        zzbl(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public com.google.android.gms.ads.internal.zze zzby() {
        return this.zzsv;
    }

    public void zzc(zze com_google_android_gms_ads_internal_overlay_zze) {
        synchronized (this.zzrJ) {
            this.zzaau = com_google_android_gms_ads_internal_overlay_zze;
        }
    }

    public void zzhK() {
        if (this.zzaaq == null) {
            zzgh.zza(this.zzaas.zzfA(), this.zzOW, "aes2");
            this.zzaaq = zzgh.zzb(this.zzaas.zzfA());
            this.zzaas.zza("native:view_show", this.zzaaq);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.zztt.zzba);
        zza("onshow", hashMap);
    }

    public void zzj(String str, String str2) {
        zzbm(new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("(").append(str2).append(");").toString());
    }

    Boolean zzkq() {
        Boolean bool;
        synchronized (this.zzrJ) {
            bool = this.zzWO;
        }
        return bool;
    }

    public void zzlA() {
        synchronized (this.zzrJ) {
            zzpk.m4709v("Destroying WebView!");
            zzkC();
            zzpo.zzXC.post(new C13902(this));
        }
    }

    public boolean zzlB() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzaai;
        }
        return z;
    }

    public boolean zzlC() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzaaj;
        }
        return z;
    }

    public zzqv zzlD() {
        return null;
    }

    public zzgj zzlE() {
        return this.zzOW;
    }

    public zzgk zzlF() {
        return this.zzaas;
    }

    public zzrb zzlG() {
        zzrb com_google_android_gms_internal_zzrb;
        synchronized (this.zzrJ) {
            com_google_android_gms_internal_zzrb = this.zzaak;
        }
        return com_google_android_gms_internal_zzrb;
    }

    public boolean zzlH() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzaao > 0;
        }
        return z;
    }

    public void zzlI() {
        this.zzvY.zzle();
    }

    public void zzlJ() {
        if (this.zzaar == null) {
            this.zzaar = zzgh.zzb(this.zzaas.zzfA());
            this.zzaas.zza("native:view_load", this.zzaar);
        }
    }

    public OnClickListener zzlK() {
        return (OnClickListener) this.zzaat.get();
    }

    public zzgy zzlL() {
        zzgy com_google_android_gms_internal_zzgy;
        synchronized (this.zzrJ) {
            com_google_android_gms_internal_zzgy = this.zzaan;
        }
        return com_google_android_gms_internal_zzgy;
    }

    public void zzlM() {
        setBackgroundColor(0);
    }

    public void zzlp() {
        zzmd();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.zztt.zzba);
        zza("onhide", hashMap);
    }

    public void zzlq() {
        Map hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzw.zzcM().zzcs()));
        hashMap.put("app_volume", String.valueOf(zzw.zzcM().zzcq()));
        hashMap.put("device_volume", String.valueOf(zzw.zzcM().zzS(getContext())));
        zza("volume", hashMap);
    }

    public Activity zzlr() {
        return this.zzZZ.zzlr();
    }

    public Context zzls() {
        return this.zzZZ.zzls();
    }

    public zze zzlt() {
        zze com_google_android_gms_ads_internal_overlay_zze;
        synchronized (this.zzrJ) {
            com_google_android_gms_ads_internal_overlay_zze = this.zzaac;
        }
        return com_google_android_gms_ads_internal_overlay_zze;
    }

    public zze zzlu() {
        zze com_google_android_gms_ads_internal_overlay_zze;
        synchronized (this.zzrJ) {
            com_google_android_gms_ads_internal_overlay_zze = this.zzaau;
        }
        return com_google_android_gms_ads_internal_overlay_zze;
    }

    public zzqx zzlv() {
        return this.zzaab;
    }

    public boolean zzlw() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzaad;
        }
        return z;
    }

    public zzaw zzlx() {
        return this.zzGP;
    }

    public zzqh zzly() {
        return this.zztt;
    }

    public boolean zzlz() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzaaf;
        }
        return z;
    }

    public boolean zzmb() {
        if (!zzlv().zzdD() && !zzlv().zzlO()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics zza = zzw.zzcM().zza(this.zzwo);
        int zzb = zzel.zzeT().zzb(zza, zza.widthPixels);
        int zzb2 = zzel.zzeT().zzb(zza, zza.heightPixels);
        Activity zzlr = zzlr();
        if (zzlr == null || zzlr.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            int[] zzh = zzw.zzcM().zzh(zzlr);
            i2 = zzel.zzeT().zzb(zza, zzh[0]);
            i = zzel.zzeT().zzb(zza, zzh[1]);
        }
        if (this.zzMy == zzb && this.zzMz == zzb2 && this.zzMB == i2 && this.zzMC == i) {
            return false;
        }
        boolean z = (this.zzMy == zzb && this.zzMz == zzb2) ? false : true;
        this.zzMy = zzb;
        this.zzMz = zzb2;
        this.zzMB = i2;
        this.zzMC = i;
        new zzkw(this).zza(zzb, zzb2, i2, i, zza.density, this.zzwo.getDefaultDisplay().getRotation());
        return z;
    }

    zzid zzmf() {
        return new C13891(this);
    }
}
