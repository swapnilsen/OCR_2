package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzt;
import com.google.api.client.http.ExponentialBackOffPolicy;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

@zzme
public class zzpo {
    public static final Handler zzXC;
    private String zzIA;
    private zzji zzTy;
    private boolean zzXD;
    private boolean zzXE;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.internal.zzpo.1 */
    class C13601 implements com.google.android.gms.internal.zzgr.zza {
        final /* synthetic */ List zzXF;
        final /* synthetic */ zzgr zzXG;
        final /* synthetic */ Context zztf;

        C13601(zzpo com_google_android_gms_internal_zzpo, List list, zzgr com_google_android_gms_internal_zzgr, Context context) {
            this.zzXF = list;
            this.zzXG = com_google_android_gms_internal_zzgr;
            this.zztf = context;
        }

        public void zzfJ() {
            for (String str : this.zzXF) {
                String str2 = "Pinging url: ";
                String valueOf = String.valueOf(str);
                zzqf.zzbg(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                this.zzXG.mayLaunchUrl(Uri.parse(str), null, null);
            }
            this.zzXG.zzd((Activity) this.zztf);
        }

        public void zzfK() {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpo.2 */
    class C13612 implements Runnable {
        final /* synthetic */ zzpo zzXH;
        final /* synthetic */ Context zztf;

        C13612(zzpo com_google_android_gms_internal_zzpo, Context context) {
            this.zzXH = com_google_android_gms_internal_zzpo;
            this.zztf = context;
        }

        public void run() {
            synchronized (this.zzXH.zzrJ) {
                this.zzXH.zzIA = this.zzXH.zzL(this.zztf);
                this.zzXH.zzrJ.notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpo.3 */
    class C13623 implements com.google.android.gms.internal.zzqe.zza {
        final /* synthetic */ String zzXI;
        final /* synthetic */ Context zztf;

        C13623(zzpo com_google_android_gms_internal_zzpo, Context context, String str) {
            this.zztf = context;
            this.zzXI = str;
        }

        public void zzu(String str) {
            zzw.zzcM().zzf(this.zztf, this.zzXI, str);
        }
    }

    private final class zza extends BroadcastReceiver {
        final /* synthetic */ zzpo zzXH;

        private zza(zzpo com_google_android_gms_internal_zzpo) {
            this.zzXH = com_google_android_gms_internal_zzpo;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                this.zzXH.zzXD = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.zzXH.zzXD = false;
            }
        }
    }

    static {
        zzXC = new zzpl(Looper.getMainLooper());
    }

    public zzpo() {
        this.zzrJ = new Object();
        this.zzXD = true;
        this.zzXE = false;
    }

    private JSONArray zza(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : collection) {
            zza(jSONArray, zza);
        }
        return jSONArray;
    }

    private void zza(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(zzi((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzQ((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(zza((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void zza(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzi((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzQ((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zza(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private boolean zza(KeyguardManager keyguardManager) {
        return keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode();
    }

    private boolean zza(PowerManager powerManager) {
        return powerManager == null || powerManager.isScreenOn();
    }

    public static void zzb(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzpn.zza(runnable);
        }
    }

    private JSONObject zzi(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private boolean zzi(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    private Bitmap zzq(@NonNull View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                zzqf.zzbh("Width or height of view is zero");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            view.layout(0, 0, width, height);
            view.draw(canvas);
            return createBitmap;
        } catch (Throwable e) {
            zzqf.zzb("Fail to capture the webview", e);
            return null;
        }
    }

    private Bitmap zzr(@NonNull View view) {
        Bitmap drawingCache;
        Throwable e;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            drawingCache = view.getDrawingCache();
            drawingCache = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            try {
                view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            } catch (RuntimeException e2) {
                e = e2;
                zzqf.zzb("Fail to capture the web view", e);
                return drawingCache;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            drawingCache = null;
            e = th;
            zzqf.zzb("Fail to capture the web view", e);
            return drawingCache;
        }
        return drawingCache;
    }

    public void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            zzXC.post(runnable);
        }
    }

    public boolean zzJ(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            zzqf.zzbh("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            zzqf.zzbh(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            zzqf.zzbh(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == 0) {
            zzqf.zzbh(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) == 0) {
            zzqf.zzbh(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
            zzqf.zzbh(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) == 0) {
            zzqf.zzbh(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & ItemAnimator.FLAG_MOVED) != 0) {
            return z;
        }
        zzqf.zzbh(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public boolean zzK(Context context) {
        if (this.zzXE) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zza(), intentFilter);
        this.zzXE = true;
        return true;
    }

    protected String zzL(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Exception e) {
            return zzkK();
        }
    }

    public Builder zzM(Context context) {
        return new Builder(context);
    }

    public zzfv zzN(Context context) {
        return new zzfv(context);
    }

    public String zzO(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List runningTasks = activityManager.getRunningTasks(1);
            if (!(runningTasks == null || runningTasks.isEmpty())) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception e) {
        }
    }

    public boolean zzP(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && zzi(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public Bitmap zzQ(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        Bitmap zzr;
        try {
            if (((Boolean) zzgd.zzEb.get()).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    zzr = zzr(window.getDecorView().getRootView());
                }
                zzr = null;
            } else {
                zzr = zzq(((Activity) context).getWindow().getDecorView());
            }
        } catch (Throwable e) {
            zzqf.zzb("Fail to capture screen shot", e);
        }
        return zzr;
    }

    public JSONObject zzQ(Map<String, ?> map) {
        String valueOf;
        try {
            JSONObject jSONObject = new JSONObject();
            for (String valueOf2 : map.keySet()) {
                zza(jSONObject, valueOf2, map.get(valueOf2));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String str = "Could not convert map to JSON: ";
            valueOf2 = String.valueOf(e.getMessage());
            throw new JSONException(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }

    public AudioManager zzR(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public float zzS(Context context) {
        AudioManager zzR = zzR(context);
        if (zzR == null) {
            return 0.0f;
        }
        int streamMaxVolume = zzR.getStreamMaxVolume(3);
        return streamMaxVolume != 0 ? ((float) zzR.getStreamVolume(3)) / ((float) streamMaxVolume) : 0.0f;
    }

    public int zzT(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
    }

    public boolean zzU(Context context) {
        try {
            context.getClassLoader().loadClass(ClientApi.class.getName());
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (Throwable th) {
            zzqf.zzb("Error loading class.", th);
            zzw.zzcQ().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public Bundle zzV(Context context) {
        zzde zzH = zzw.zzcQ().zzH(context);
        return zzH == null ? null : zza(zzH);
    }

    public Uri zza(Uri uri, String str, String str2) {
        return zzc(uri.toString(), str, str2);
    }

    public Bundle zza(zzde com_google_android_gms_internal_zzde) {
        if (com_google_android_gms_internal_zzde == null) {
            return null;
        }
        if (!((Boolean) zzgd.zzCi.get()).booleanValue() && !((Boolean) zzgd.zzCk.get()).booleanValue()) {
            return null;
        }
        if (zzw.zzcQ().zzkg() && zzw.zzcQ().zzkh()) {
            return null;
        }
        String zzea;
        String zzeb;
        String str;
        if (com_google_android_gms_internal_zzde.zzen()) {
            com_google_android_gms_internal_zzde.wakeup();
        }
        zzdb zzel = com_google_android_gms_internal_zzde.zzel();
        if (zzel != null) {
            zzea = zzel.zzea();
            zzeb = zzel.zzeb();
            String zzec = zzel.zzec();
            if (zzea != null) {
                zzw.zzcQ().zzaU(zzea);
            }
            if (zzec != null) {
                zzw.zzcQ().zzaV(zzec);
                str = zzea;
                zzea = zzeb;
                zzeb = zzec;
            } else {
                str = zzea;
                zzea = zzeb;
                zzeb = zzec;
            }
        } else {
            zzea = null;
            str = zzw.zzcQ().zzko();
            zzeb = zzw.zzcQ().zzkp();
        }
        Bundle bundle = new Bundle(1);
        if (!(zzeb == null || !((Boolean) zzgd.zzCk.get()).booleanValue() || zzw.zzcQ().zzkh())) {
            bundle.putString("v_fp_vertical", zzeb);
        }
        if (!(str == null || !((Boolean) zzgd.zzCi.get()).booleanValue() || zzw.zzcQ().zzkg())) {
            bundle.putString("fingerprint", str);
            if (!str.equals(zzea)) {
                bundle.putString("v_fp", zzea);
            }
        }
        return !bundle.isEmpty() ? bundle : null;
    }

    public DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public String zza(Context context, View view, zzeg com_google_android_gms_internal_zzeg) {
        String str = null;
        if (((Boolean) zzgd.zzCz.get()).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", com_google_android_gms_internal_zzeg.width);
                jSONObject2.put("height", com_google_android_gms_internal_zzeg.height);
                jSONObject.put("size", jSONObject2);
                jSONObject.put("activity", zzO(context));
                if (!com_google_android_gms_internal_zzeg.zzzz) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int i = -1;
                            if (parent instanceof ViewGroup) {
                                i = ((ViewGroup) parent).indexOfChild(view);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("type", parent.getClass().getName());
                            jSONObject3.put("index_of_child", i);
                            jSONArray.put(jSONObject3);
                        }
                        View view2 = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                        view = view2;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                str = jSONObject.toString();
            } catch (Throwable e) {
                zzqf.zzc("Fail to get view hierarchy json", e);
            }
        }
        return str;
    }

    public String zza(Context context, zzaw com_google_android_gms_internal_zzaw, String str, View view) {
        if (com_google_android_gms_internal_zzaw != null) {
            try {
                Uri parse = Uri.parse(str);
                if (com_google_android_gms_internal_zzaw.zzd(parse)) {
                    parse = com_google_android_gms_internal_zzaw.zza(parse, context, view);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public String zza(zzqw com_google_android_gms_internal_zzqw, String str) {
        return zza(com_google_android_gms_internal_zzqw.getContext(), com_google_android_gms_internal_zzqw.zzlx(), str, com_google_android_gms_internal_zzqw.getView());
    }

    public String zza(InputStreamReader inputStreamReader) {
        StringBuilder stringBuilder = new StringBuilder(AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        char[] cArr = new char[ItemAnimator.FLAG_MOVED];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public Map<String, Integer> zza(View view, WindowManager windowManager) {
        DisplayMetrics zza = zza(windowManager);
        int i = zza.widthPixels;
        int i2 = zza.heightPixels;
        int[] iArr = new int[2];
        Map<String, Integer> hashMap = new HashMap();
        view.getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        return hashMap;
    }

    JSONArray zza(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : objArr) {
            zza(jSONArray, zza);
        }
        return jSONArray;
    }

    public void zza(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void zza(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    @TargetApi(18)
    public void zza(Context context, Uri uri) {
        try {
            Bundle bundle = new Bundle();
            if (((Boolean) zzgd.zzFj.get()).booleanValue() && zzt.zzzk()) {
                bundle.putBinder("android.support.customtabs.extra.SESSION", null);
            }
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(new Intent("android.intent.action.VIEW", uri).putExtras(bundle));
            String valueOf = String.valueOf(uri.toString());
            zzqf.zzbf(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Opening ").append(valueOf).append(" in a new browser.").toString());
        } catch (Throwable e) {
            zzqf.zzb("No browser is found.", e);
        }
    }

    public void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zzu(context, str));
    }

    public void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            bundle.putString("device", zzw.zzcM().zzkN());
            bundle.putString("eids", TextUtils.join(",", zzgd.zzfs()));
        }
        zzel.zzeT().zza(context, str, str2, bundle, z, new C13623(this, context, str));
    }

    public void zza(Context context, String str, List<String> list) {
        for (String com_google_android_gms_internal_zzpy : list) {
            new zzpy(context, str, com_google_android_gms_internal_zzpy).zziP();
        }
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        zza(context, str, z, httpURLConnection, false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS);
        httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, zzu(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public void zza(Context context, List<String> list) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(zzbya.zzcC((Activity) context))) {
            return;
        }
        if (list == null) {
            zzpk.m4709v("Cannot ping urls: empty list.");
        } else if (zzgr.zzo(context)) {
            zzgr com_google_android_gms_internal_zzgr = new zzgr();
            com_google_android_gms_internal_zzgr.zza(new C13601(this, list, com_google_android_gms_internal_zzgr, context));
            com_google_android_gms_internal_zzgr.zze((Activity) context);
        } else {
            zzpk.m4709v("Cannot ping url because custom tabs is not supported");
        }
    }

    public void zza(List<String> list, String str) {
        for (String com_google_android_gms_internal_zzpy : list) {
            new zzpy(com_google_android_gms_internal_zzpy, str).zziP();
        }
    }

    @TargetApi(24)
    public boolean zza(Activity activity, Configuration configuration) {
        zzqe zzeT = zzel.zzeT();
        int zzb = zzeT.zzb((Context) activity, configuration.screenHeightDp);
        int zzb2 = zzeT.zzb((Context) activity, configuration.screenWidthDp);
        DisplayMetrics zza = zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza.heightPixels;
        int i2 = zza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        identifier = ((Integer) zzgd.zzFs.get()).intValue() * ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + ExponentialBackOffPolicy.DEFAULT_RANDOMIZATION_FACTOR));
        return zzb(i, dimensionPixelSize + zzb, identifier) && zzb(i2, zzb2, identifier);
    }

    public boolean zza(View view, Context context) {
        KeyguardManager keyguardManager = null;
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return zza(view, powerManager, keyguardManager);
    }

    public boolean zza(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = zzw.zzcM().zzkJ() || !zza(keyguardManager);
        return view.getVisibility() == 0 && view.isShown() && zza(powerManager) && z && (!((Boolean) zzgd.zzDs.get()).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect()));
    }

    public boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public String zzaX(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public int zzaY(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            zzqf.zzbh(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Could not parse value:").append(valueOf).toString());
            return 0;
        }
    }

    public boolean zzaZ(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public String zzb(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{Uri.encode((String) map.get(str2))}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING})).replaceAll("@@", "@");
    }

    public void zzb(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void zzb(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void zzb(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) zzgd.zzDx.get()).booleanValue()) {
            zza(context, str, str2, bundle, z);
        }
    }

    boolean zzb(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public Uri zzc(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(str.substring(0, indexOf + 1)).append(str2).append("=").append(str3).append("&").append(str.substring(indexOf + 1)).toString()) : Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }

    public float zzcq() {
        zzq zzcp = zzw.zzdg().zzcp();
        return (zzcp == null || !zzcp.zzcr()) ? 1.0f : zzcp.zzcq();
    }

    public boolean zzcs() {
        zzq zzcp = zzw.zzdg().zzcp();
        return zzcp != null ? zzcp.zzcs() : false;
    }

    public zzji zzd(Context context, zzqh com_google_android_gms_internal_zzqh) {
        zzji com_google_android_gms_internal_zzji;
        synchronized (this.zzrJ) {
            if (this.zzTy == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.zzTy = new zzji(context, com_google_android_gms_internal_zzqh, (String) zzgd.zzBh.get());
            }
            com_google_android_gms_internal_zzji = this.zzTy;
        }
        return com_google_android_gms_internal_zzji;
    }

    public boolean zze(Context context, String str, String str2) {
        return zzadg.zzbi(context).checkPermission(str2, str) == 0;
    }

    public void zzf(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, arrayList);
    }

    public Map<String, String> zzg(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : zzw.zzcO().zzh(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public void zzg(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Throwable e) {
            zzqf.zzb("Error writing to file in internal storage.", e);
        }
    }

    public int[] zzh(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return zzkO();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public int[] zzi(Activity activity) {
        int[] zzh = zzh(activity);
        return new int[]{zzel.zzeT().zzc(activity, zzh[0]), zzel.zzeT().zzc(activity, zzh[1])};
    }

    public int[] zzj(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return zzkO();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    public int[] zzk(Activity activity) {
        int[] zzj = zzj(activity);
        return new int[]{zzel.zzeT().zzc(activity, zzj[0]), zzel.zzeT().zzc(activity, zzj[1])};
    }

    public boolean zzkJ() {
        return this.zzXD;
    }

    String zzkK() {
        StringBuffer stringBuffer = new StringBuffer(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public String zzkL() {
        return UUID.randomUUID().toString();
    }

    public String zzkM() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public String zzkN() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
    }

    protected int[] zzkO() {
        return new int[]{0, 0};
    }

    public Bundle zzkP() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) zzgd.zzBL.get()).booleanValue()) {
                Parcelable memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            if (((Boolean) zzgd.zzBM.get()).booleanValue()) {
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free_memory", runtime.freeMemory());
                bundle.putLong("runtime_max_memory", runtime.maxMemory());
                bundle.putLong("runtime_total_memory", runtime.totalMemory());
            }
            bundle.putInt("web_view_count", zzw.zzcQ().zzkD());
        } catch (Throwable e) {
            zzqf.zzc("Unable to gather memory stats", e);
        }
        return bundle;
    }

    public Bitmap zzp(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public int zzs(@Nullable View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        return parent == null ? -1 : ((AdapterView) parent).getPositionForView(view);
    }

    public String zzu(Context context, String str) {
        String str2;
        synchronized (this.zzrJ) {
            if (this.zzIA != null) {
                str2 = this.zzIA;
            } else if (str == null) {
                str2 = zzkK();
            } else {
                try {
                    this.zzIA = zzw.zzcO().getDefaultUserAgent(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.zzIA)) {
                    if (zzel.zzeT().zzlj()) {
                        this.zzIA = zzL(context);
                    } else {
                        this.zzIA = null;
                        zzXC.post(new C13612(this, context));
                        while (this.zzIA == null) {
                            try {
                                this.zzrJ.wait();
                            } catch (InterruptedException e2) {
                                this.zzIA = zzkK();
                                String str3 = "Interrupted, use default user agent: ";
                                str2 = String.valueOf(this.zzIA);
                                zzqf.zzbh(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                            }
                        }
                    }
                }
                str2 = String.valueOf(this.zzIA);
                this.zzIA = new StringBuilder((String.valueOf(str2).length() + 11) + String.valueOf(str).length()).append(str2).append(" (Mobile; ").append(str).append(")").toString();
                str2 = this.zzIA;
            }
        }
        return str2;
    }

    public String zzv(Context context, String str) {
        try {
            return new String(zzp.zza(context.openFileInput(str), true), "UTF-8");
        } catch (Throwable e) {
            zzqf.zzb("Error reading from internal storage.", e);
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
    }
}
