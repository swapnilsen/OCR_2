package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzcy.zzb;
import java.util.Map;
import org.json.JSONObject;

@zzme
public interface zzqw extends zzu, zzb, zzjj {
    void destroy();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    String getRequestId();

    int getRequestedOrientation();

    View getView();

    WebView getWebView();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    void zzK(boolean z);

    void zzL(boolean z);

    void zzM(int i);

    void zzM(boolean z);

    void zzN(boolean z);

    void zza(Context context, zzeg com_google_android_gms_internal_zzeg, zzgl com_google_android_gms_internal_zzgl);

    void zza(zzeg com_google_android_gms_internal_zzeg);

    void zza(zzrb com_google_android_gms_internal_zzrb);

    void zza(String str, Map<String, ?> map);

    void zza(String str, JSONObject jSONObject);

    void zzb(zze com_google_android_gms_ads_internal_overlay_zze);

    void zzb(zzgy com_google_android_gms_internal_zzgy);

    zzeg zzbC();

    void zzbi(String str);

    void zzbj(String str);

    com.google.android.gms.ads.internal.zze zzby();

    void zzc(zze com_google_android_gms_ads_internal_overlay_zze);

    void zzhK();

    void zzj(String str, String str2);

    void zzlA();

    boolean zzlB();

    boolean zzlC();

    @Nullable
    zzqv zzlD();

    @Nullable
    zzgj zzlE();

    zzgk zzlF();

    @Nullable
    zzrb zzlG();

    boolean zzlH();

    void zzlI();

    void zzlJ();

    @Nullable
    OnClickListener zzlK();

    zzgy zzlL();

    void zzlM();

    void zzlp();

    void zzlq();

    Activity zzlr();

    Context zzls();

    zze zzlt();

    zze zzlu();

    @Nullable
    zzqx zzlv();

    boolean zzlw();

    zzaw zzlx();

    zzqh zzly();

    boolean zzlz();
}
