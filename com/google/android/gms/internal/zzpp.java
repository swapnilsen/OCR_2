package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzw;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@zzme
@TargetApi(8)
public class zzpp {

    @TargetApi(9)
    public static class zza extends zzpp {
        public zza() {
            super();
        }

        public boolean zza(Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        public int zzkQ() {
            return 6;
        }

        public int zzkR() {
            return 7;
        }
    }

    @TargetApi(11)
    public static class zzb extends zza {

        /* renamed from: com.google.android.gms.internal.zzpp.zzb.1 */
        class C13641 implements Callable<Boolean> {
            final /* synthetic */ WebSettings zzXJ;
            final /* synthetic */ Context zztf;

            C13641(zzb com_google_android_gms_internal_zzpp_zzb, Context context, WebSettings webSettings) {
                this.zztf = context;
                this.zzXJ = webSettings;
            }

            public /* synthetic */ Object call() {
                return zzbX();
            }

            public Boolean zzbX() {
                if (this.zztf.getCacheDir() != null) {
                    this.zzXJ.setAppCachePath(this.zztf.getCacheDir().getAbsolutePath());
                    this.zzXJ.setAppCacheMaxSize(0);
                    this.zzXJ.setAppCacheEnabled(true);
                }
                this.zzXJ.setDatabasePath(this.zztf.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                this.zzXJ.setDatabaseEnabled(true);
                this.zzXJ.setDomStorageEnabled(true);
                this.zzXJ.setDisplayZoomControls(false);
                this.zzXJ.setBuiltInZoomControls(true);
                this.zzXJ.setSupportZoom(true);
                this.zzXJ.setAllowContentAccess(false);
                return Boolean.valueOf(true);
            }
        }

        public boolean zza(Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            return ((Boolean) zzqb.zzb(new C13641(this, context, webSettings))).booleanValue();
        }

        public boolean zza(Window window) {
            window.setFlags(AccessibilityEventCompat.TYPE_ASSIST_READING_CONTEXT, AccessibilityEventCompat.TYPE_ASSIST_READING_CONTEXT);
            return true;
        }

        public zzqx zzb(zzqw com_google_android_gms_internal_zzqw, boolean z) {
            return new zzre(com_google_android_gms_internal_zzqw, z);
        }

        public Set<String> zzh(Uri uri) {
            return uri.getQueryParameterNames();
        }

        public WebChromeClient zzn(zzqw com_google_android_gms_internal_zzqw) {
            return new zzrd(com_google_android_gms_internal_zzqw);
        }

        public boolean zzt(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public boolean zzu(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    @TargetApi(14)
    public static class zzc extends zzb {
        public String zza(SslError sslError) {
            return sslError.getUrl();
        }

        public WebChromeClient zzn(zzqw com_google_android_gms_internal_zzqw) {
            return new zzrf(com_google_android_gms_internal_zzqw);
        }
    }

    @TargetApi(16)
    public static class zzf extends zzc {
        public void zza(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void zza(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }

        public void zzb(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
            }
        }
    }

    @TargetApi(17)
    public static class zzd extends zzf {
        public String getDefaultUserAgent(Context context) {
            return zzqc.zzld().zzac(context);
        }

        public void zzW(Context context) {
            zzqc.zzld().zzab(context);
            zzw.zzcQ().zzkB();
        }

        public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
            if (!z || f <= 0.0f || f > 25.0f) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                return new BitmapDrawable(context.getResources(), createBitmap);
            } catch (RuntimeException e) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }

        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    @TargetApi(18)
    public static class zze extends zzd {
        public boolean isAttachedToWindow(View view) {
            return super.isAttachedToWindow(view) || view.getWindowId() != null;
        }

        public int zzkS() {
            return 14;
        }
    }

    @TargetApi(19)
    public static class zzg extends zze {
        public boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        public LayoutParams zzkT() {
            return new LayoutParams(-1, -1);
        }
    }

    @TargetApi(21)
    public static class zzh extends zzg {
        public CookieManager zzX(Context context) {
            try {
                return CookieManager.getInstance();
            } catch (Throwable e) {
                zzqf.zzb("Failed to obtain CookieManager.", e);
                zzw.zzcQ().zza(e, "ApiLevelUtil.getCookieManager");
                return null;
            }
        }

        public zzqx zzb(zzqw com_google_android_gms_internal_zzqw, boolean z) {
            return new zzrh(com_google_android_gms_internal_zzqw, z);
        }
    }

    private zzpp() {
    }

    public static zzpp zzaj(int i) {
        return i >= 21 ? new zzh() : i >= 19 ? new zzg() : i >= 18 ? new zze() : i >= 17 ? new zzd() : i >= 16 ? new zzf() : i >= 14 ? new zzc() : i >= 11 ? new zzb() : i >= 9 ? new zza() : new zzpp();
    }

    public String getDefaultUserAgent(Context context) {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public void zzW(Context context) {
        zzw.zzcQ().zzkB();
    }

    public CookieManager zzX(Context context) {
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable e) {
            zzqf.zzb("Failed to obtain CookieManager.", e);
            zzw.zzcQ().zza(e, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public String zza(SslError sslError) {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public void zza(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void zza(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public zzqx zzb(zzqw com_google_android_gms_internal_zzqw, boolean z) {
        return new zzqx(com_google_android_gms_internal_zzqw, z);
    }

    public void zzb(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public Set<String> zzh(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public int zzkQ() {
        return 0;
    }

    public int zzkR() {
        return 1;
    }

    public int zzkS() {
        return 5;
    }

    public LayoutParams zzkT() {
        return new LayoutParams(-2, -2);
    }

    public boolean zzl(zzqw com_google_android_gms_internal_zzqw) {
        if (com_google_android_gms_internal_zzqw == null) {
            return false;
        }
        com_google_android_gms_internal_zzqw.onPause();
        return true;
    }

    public boolean zzm(zzqw com_google_android_gms_internal_zzqw) {
        if (com_google_android_gms_internal_zzqw == null) {
            return false;
        }
        com_google_android_gms_internal_zzqw.onResume();
        return true;
    }

    public WebChromeClient zzn(zzqw com_google_android_gms_internal_zzqw) {
        return null;
    }

    public boolean zzt(View view) {
        return false;
    }

    public boolean zzu(View view) {
        return false;
    }
}
