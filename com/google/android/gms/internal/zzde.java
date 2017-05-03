package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.zzt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
@TargetApi(14)
public class zzde extends Thread {
    private boolean mStarted;
    private boolean zzal;
    private final Object zzrJ;
    private boolean zzxO;
    private final zzdc zzxP;
    private final zzmd zzxQ;
    private final int zzxR;
    private final int zzxS;
    private final int zzxT;
    private final int zzxU;
    private final int zzxV;
    private final int zzxW;
    private final String zzxX;
    private final int zzxp;
    private final int zzxr;

    /* renamed from: com.google.android.gms.internal.zzde.1 */
    class C11551 implements Runnable {
        final /* synthetic */ View zzxY;
        final /* synthetic */ zzde zzxZ;

        C11551(zzde com_google_android_gms_internal_zzde, View view) {
            this.zzxZ = com_google_android_gms_internal_zzde;
            this.zzxY = view;
        }

        public void run() {
            this.zzxZ.zzi(this.zzxY);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzde.2 */
    class C11572 implements Runnable {
        final /* synthetic */ zzde zzxZ;
        ValueCallback<String> zzya;
        final /* synthetic */ zzdb zzyb;
        final /* synthetic */ WebView zzyc;
        final /* synthetic */ boolean zzyd;

        /* renamed from: com.google.android.gms.internal.zzde.2.1 */
        class C11561 implements ValueCallback<String> {
            final /* synthetic */ C11572 zzye;

            C11561(C11572 c11572) {
                this.zzye = c11572;
            }

            public /* synthetic */ void onReceiveValue(Object obj) {
                zzE((String) obj);
            }

            public void zzE(String str) {
                this.zzye.zzxZ.zza(this.zzye.zzyb, this.zzye.zzyc, str, this.zzye.zzyd);
            }
        }

        C11572(zzde com_google_android_gms_internal_zzde, zzdb com_google_android_gms_internal_zzdb, WebView webView, boolean z) {
            this.zzxZ = com_google_android_gms_internal_zzde;
            this.zzyb = com_google_android_gms_internal_zzdb;
            this.zzyc = webView;
            this.zzyd = z;
            this.zzya = new C11561(this);
        }

        public void run() {
            if (this.zzyc.getSettings().getJavaScriptEnabled()) {
                try {
                    this.zzyc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzya);
                } catch (Throwable th) {
                    this.zzya.onReceiveValue(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
                }
            }
        }
    }

    @zzme
    class zza {
        final int zzyf;
        final int zzyg;

        zza(zzde com_google_android_gms_internal_zzde, int i, int i2) {
            this.zzyf = i;
            this.zzyg = i2;
        }
    }

    public zzde(zzdc com_google_android_gms_internal_zzdc, zzmd com_google_android_gms_internal_zzmd) {
        this.mStarted = false;
        this.zzxO = false;
        this.zzal = false;
        this.zzxP = com_google_android_gms_internal_zzdc;
        this.zzxQ = com_google_android_gms_internal_zzmd;
        this.zzrJ = new Object();
        this.zzxp = ((Integer) zzgd.zzCd.get()).intValue();
        this.zzxS = ((Integer) zzgd.zzCe.get()).intValue();
        this.zzxr = ((Integer) zzgd.zzCf.get()).intValue();
        this.zzxT = ((Integer) zzgd.zzCg.get()).intValue();
        this.zzxU = ((Integer) zzgd.zzCj.get()).intValue();
        this.zzxV = ((Integer) zzgd.zzCl.get()).intValue();
        this.zzxW = ((Integer) zzgd.zzCm.get()).intValue();
        this.zzxR = ((Integer) zzgd.zzCh.get()).intValue();
        this.zzxX = (String) zzgd.zzCo.get();
        setName("ContentFetchTask");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.zzek();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        if (r0 == 0) goto L_0x003f;
    L_0x0006:
        r0 = com.google.android.gms.ads.internal.zzw.zzcP();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r0 = r0.getActivity();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        if (r0 != 0) goto L_0x0034;
    L_0x0010:
        r0 = "ContentFetchThread: no activity. Sleeping.";
        com.google.android.gms.internal.zzqf.zzbf(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r3.zzem();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
    L_0x0018:
        r0 = r3.zzxR;	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r0 = r0 * 1000;
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
    L_0x0020:
        r1 = r3.zzrJ;
        monitor-enter(r1);
    L_0x0023:
        r0 = r3.zzxO;	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0056;
    L_0x0027:
        r0 = "ContentFetchTask: waiting";
        com.google.android.gms.internal.zzqf.zzbf(r0);	 Catch:{ InterruptedException -> 0x0032 }
        r0 = r3.zzrJ;	 Catch:{ InterruptedException -> 0x0032 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0032 }
        goto L_0x0023;
    L_0x0032:
        r0 = move-exception;
        goto L_0x0023;
    L_0x0034:
        r3.zza(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        goto L_0x0018;
    L_0x0038:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.zzqf.zzb(r1, r0);
        goto L_0x0020;
    L_0x003f:
        r0 = "ContentFetchTask: sleeping";
        com.google.android.gms.internal.zzqf.zzbf(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r3.zzem();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        goto L_0x0018;
    L_0x0048:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.zzqf.zzb(r1, r0);
        r1 = r3.zzxQ;
        r2 = "ContentFetchTask.run";
        r1.zza(r0, r2);
        goto L_0x0020;
    L_0x0056:
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
        goto L_0x0000;
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzde.run():void");
    }

    public void wakeup() {
        synchronized (this.zzrJ) {
            this.zzxO = false;
            this.zzrJ.notifyAll();
            zzqf.zzbf("ContentFetchThread: wakeup");
        }
    }

    zza zza(@Nullable View view, zzdb com_google_android_gms_internal_zzdb) {
        int i = 0;
        if (view == null) {
            return new zza(this, 0, 0);
        }
        Context context = zzw.zzcP().getContext();
        if (context != null) {
            String str = (String) view.getTag(context.getResources().getIdentifier((String) zzgd.zzCn.get(), FacebookAdapter.KEY_ID, context.getPackageName()));
            if (!(TextUtils.isEmpty(this.zzxX) || str == null || !str.equals(this.zzxX))) {
                return new zza(this, 0, 0);
            }
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(this, 0, 0);
            }
            com_google_android_gms_internal_zzdb.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zza(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzqw)) {
            com_google_android_gms_internal_zzdb.zzef();
            return zza((WebView) view, com_google_android_gms_internal_zzdb, globalVisibleRect) ? new zza(this, 0, 1) : new zza(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zza(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zza zza = zza(viewGroup.getChildAt(i3), com_google_android_gms_internal_zzdb);
                i2 += zza.zzyf;
                i += zza.zzyg;
            }
            return new zza(this, i2, i);
        }
    }

    void zza(@Nullable Activity activity) {
        if (activity != null) {
            View view = null;
            try {
                if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                    view = activity.getWindow().getDecorView().findViewById(16908290);
                }
            } catch (Throwable th) {
                zzw.zzcQ().zza(th, "ContentFetchTask.extractContent");
                zzqf.zzbf("Failed getting root view of activity. Content not extracted.");
            }
            if (view != null) {
                zzh(view);
            }
        }
    }

    void zza(zzdb com_google_android_gms_internal_zzdb, WebView webView, String str, boolean z) {
        com_google_android_gms_internal_zzdb.zzee();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    com_google_android_gms_internal_zzdb.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String valueOf = String.valueOf(webView.getTitle());
                    com_google_android_gms_internal_zzdb.zza(new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(optString).length()).append(valueOf).append("\n").append(optString).toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (com_google_android_gms_internal_zzdb.zzdZ()) {
                this.zzxP.zzb(com_google_android_gms_internal_zzdb);
            }
        } catch (JSONException e) {
            zzqf.zzbf("Json string may be malformed.");
        } catch (Throwable th) {
            zzqf.zza("Failed to get webview content.", th);
            this.zzxQ.zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    boolean zza(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    @TargetApi(19)
    boolean zza(WebView webView, zzdb com_google_android_gms_internal_zzdb, boolean z) {
        if (!zzt.zzzl()) {
            return false;
        }
        com_google_android_gms_internal_zzdb.zzef();
        webView.post(new C11572(this, com_google_android_gms_internal_zzdb, webView, z));
        return true;
    }

    public void zzej() {
        synchronized (this.zzrJ) {
            if (this.mStarted) {
                zzqf.zzbf("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    boolean zzek() {
        try {
            Context context = zzw.zzcP().getContext();
            if (context == null) {
                return false;
            }
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
                    if (zza(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && zzi(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzw.zzcQ().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    public zzdb zzel() {
        return this.zzxP.zzei();
    }

    public void zzem() {
        synchronized (this.zzrJ) {
            this.zzxO = true;
            zzqf.zzbf("ContentFetchThread: paused, mPause = " + this.zzxO);
        }
    }

    public boolean zzen() {
        return this.zzxO;
    }

    boolean zzh(@Nullable View view) {
        if (view == null) {
            return false;
        }
        view.post(new C11551(this, view));
        return true;
    }

    void zzi(View view) {
        try {
            zzdb com_google_android_gms_internal_zzdb = new zzdb(this.zzxp, this.zzxS, this.zzxr, this.zzxT, this.zzxU, this.zzxV, this.zzxW);
            zza zza = zza(view, com_google_android_gms_internal_zzdb);
            com_google_android_gms_internal_zzdb.zzeg();
            if (zza.zzyf != 0 || zza.zzyg != 0) {
                if (zza.zzyg != 0 || com_google_android_gms_internal_zzdb.zzeh() != 0) {
                    if (zza.zzyg != 0 || !this.zzxP.zza(com_google_android_gms_internal_zzdb)) {
                        this.zzxP.zzc(com_google_android_gms_internal_zzdb);
                    }
                }
            }
        } catch (Throwable e) {
            zzqf.zzb("Exception in fetchContentOnUIThread", e);
            this.zzxQ.zza(e, "ContentFetchTask.fetchContent");
        }
    }

    boolean zzi(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }
}
