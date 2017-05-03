package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public class zzct implements OnGlobalLayoutListener, OnScrollChangedListener {
    protected final Object zzrJ;
    private boolean zzuo;
    private zzpz zzvT;
    private final Context zzwi;
    private final WeakReference<zzpb> zzwk;
    private WeakReference<ViewTreeObserver> zzwl;
    private final zzda zzwm;
    protected final zzcr zzwn;
    private final WindowManager zzwo;
    private final PowerManager zzwp;
    private final KeyguardManager zzwq;
    @Nullable
    private zzcu zzwr;
    private boolean zzws;
    private boolean zzwt;
    private boolean zzwu;
    private boolean zzwv;
    private boolean zzww;
    @Nullable
    BroadcastReceiver zzwx;
    private final HashSet<Object> zzwy;
    private final HashSet<zzcx> zzwz;

    /* renamed from: com.google.android.gms.internal.zzct.1 */
    class C11331 extends BroadcastReceiver {
        final /* synthetic */ zzct zzwA;

        C11331(zzct com_google_android_gms_internal_zzct) {
            this.zzwA = com_google_android_gms_internal_zzct;
        }

        public void onReceive(Context context, Intent intent) {
            this.zzwA.zzk(3);
        }
    }

    public static class zza implements zzda {
        private WeakReference<zzha> zzwB;

        public zza(zzha com_google_android_gms_internal_zzha) {
            this.zzwB = new WeakReference(com_google_android_gms_internal_zzha);
        }

        @Nullable
        public View zzdS() {
            zzha com_google_android_gms_internal_zzha = (zzha) this.zzwB.get();
            return com_google_android_gms_internal_zzha != null ? com_google_android_gms_internal_zzha.zzgc() : null;
        }

        public boolean zzdT() {
            return this.zzwB.get() == null;
        }

        public zzda zzdU() {
            return new zzb((zzha) this.zzwB.get());
        }
    }

    public static class zzb implements zzda {
        private zzha zzwC;

        public zzb(zzha com_google_android_gms_internal_zzha) {
            this.zzwC = com_google_android_gms_internal_zzha;
        }

        public View zzdS() {
            return this.zzwC != null ? this.zzwC.zzgc() : null;
        }

        public boolean zzdT() {
            return this.zzwC == null;
        }

        public zzda zzdU() {
            return this;
        }
    }

    public static class zzc implements zzda {
        @Nullable
        private final View mView;
        @Nullable
        private final zzpb zzwD;

        public zzc(View view, zzpb com_google_android_gms_internal_zzpb) {
            this.mView = view;
            this.zzwD = com_google_android_gms_internal_zzpb;
        }

        public View zzdS() {
            return this.mView;
        }

        public boolean zzdT() {
            return this.zzwD == null || this.mView == null;
        }

        public zzda zzdU() {
            return this;
        }
    }

    public static class zzd implements zzda {
        private final WeakReference<View> zzwE;
        private final WeakReference<zzpb> zzwF;

        public zzd(View view, zzpb com_google_android_gms_internal_zzpb) {
            this.zzwE = new WeakReference(view);
            this.zzwF = new WeakReference(com_google_android_gms_internal_zzpb);
        }

        public View zzdS() {
            return (View) this.zzwE.get();
        }

        public boolean zzdT() {
            return this.zzwE.get() == null || this.zzwF.get() == null;
        }

        public zzda zzdU() {
            return new zzc((View) this.zzwE.get(), (zzpb) this.zzwF.get());
        }
    }

    public zzct(Context context, zzeg com_google_android_gms_internal_zzeg, zzpb com_google_android_gms_internal_zzpb, zzqh com_google_android_gms_internal_zzqh, zzda com_google_android_gms_internal_zzda) {
        this.zzrJ = new Object();
        this.zzuo = false;
        this.zzwt = false;
        this.zzwy = new HashSet();
        this.zzwz = new HashSet();
        this.zzwk = new WeakReference(com_google_android_gms_internal_zzpb);
        this.zzwm = com_google_android_gms_internal_zzda;
        this.zzwl = new WeakReference(null);
        this.zzwu = true;
        this.zzww = false;
        this.zzvT = new zzpz(200);
        this.zzwn = new zzcr(UUID.randomUUID().toString(), com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzeg.zzzy, com_google_android_gms_internal_zzpb.zzWa, com_google_android_gms_internal_zzpb.zzdD(), com_google_android_gms_internal_zzeg.zzzB);
        this.zzwo = (WindowManager) context.getSystemService("window");
        this.zzwp = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.zzwq = (KeyguardManager) context.getSystemService("keyguard");
        this.zzwi = context;
    }

    protected void destroy() {
        synchronized (this.zzrJ) {
            zzdL();
            zzdG();
            this.zzwu = false;
            zzdI();
            zzdN();
        }
    }

    boolean isScreenOn() {
        return this.zzwp.isScreenOn();
    }

    public void onGlobalLayout() {
        zzk(2);
    }

    public void onScrollChanged() {
        zzk(1);
    }

    public void pause() {
        synchronized (this.zzrJ) {
            this.zzuo = true;
            zzk(3);
        }
    }

    public void resume() {
        synchronized (this.zzrJ) {
            this.zzuo = false;
            zzk(3);
        }
    }

    public void stop() {
        synchronized (this.zzrJ) {
            this.zzwt = true;
            zzk(3);
        }
    }

    protected int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    JSONObject zza(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    protected void zza(View view, Map<String, String> map) {
        zzk(3);
    }

    public void zza(zzcu com_google_android_gms_internal_zzcu) {
        synchronized (this.zzrJ) {
            this.zzwr = com_google_android_gms_internal_zzcu;
        }
    }

    public void zza(zzcx com_google_android_gms_internal_zzcx) {
        if (this.zzwz.isEmpty()) {
            zzdF();
            zzk(3);
        }
        this.zzwz.add(com_google_android_gms_internal_zzcx);
        try {
            com_google_android_gms_internal_zzcx.zzc(zza(zzd(this.zzwm.zzdS())), false);
        } catch (Throwable e) {
            zzqf.zzb("Skipping measurement update for new client.", e);
        }
    }

    void zza(zzcx com_google_android_gms_internal_zzcx, Map<String, String> map) {
        String str = "Received request to untrack: ";
        String valueOf = String.valueOf(this.zzwn.zzdC());
        zzqf.zzbf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        zzb(com_google_android_gms_internal_zzcx);
    }

    protected void zza(JSONObject jSONObject, boolean z) {
        try {
            zzb(zza(jSONObject), z);
        } catch (Throwable th) {
            zzqf.zzb("Skipping active view message.", th);
        }
    }

    public void zzb(zzcx com_google_android_gms_internal_zzcx) {
        this.zzwz.remove(com_google_android_gms_internal_zzcx);
        com_google_android_gms_internal_zzcx.zzdW();
        if (this.zzwz.isEmpty()) {
            destroy();
        }
    }

    void zzb(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        zza(com_google_android_gms_internal_zzqw.getView(), (Map) map);
    }

    protected void zzb(JSONObject jSONObject, boolean z) {
        Iterator it = new ArrayList(this.zzwz).iterator();
        while (it.hasNext()) {
            ((zzcx) it.next()).zzc(jSONObject, z);
        }
    }

    boolean zzb(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        boolean z = !TextUtils.isEmpty(str) && str.equals(this.zzwn.zzdC());
        return z;
    }

    void zzc(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
            zzj(z);
        }
    }

    protected JSONObject zzd(@Nullable View view) {
        if (view == null) {
            return zzdP();
        }
        boolean isAttachedToWindow = zzw.zzcO().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            zzqf.zzb("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.zzwo.getDefaultDisplay().getWidth();
        rect2.bottom = this.zzwo.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject zzdM = zzdM();
        zzdM.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", isAttachedToWindow).put("viewBox", new JSONObject().put("top", zza(rect2.top, displayMetrics)).put("bottom", zza(rect2.bottom, displayMetrics)).put("left", zza(rect2.left, displayMetrics)).put("right", zza(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", zza(rect.top, displayMetrics)).put("bottom", zza(rect.bottom, displayMetrics)).put("left", zza(rect.left, displayMetrics)).put("right", zza(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", zza(rect3.top, displayMetrics)).put("bottom", zza(rect3.bottom, displayMetrics)).put("left", zza(rect3.left, displayMetrics)).put("right", zza(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect4.top, displayMetrics)).put("bottom", zza(rect4.bottom, displayMetrics)).put("left", zza(rect4.left, displayMetrics)).put("right", zza(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect5.top, displayMetrics)).put("bottom", zza(rect5.bottom, displayMetrics)).put("left", zza(rect5.left, displayMetrics)).put("right", zza(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", zzw.zzcM().zza(view, this.zzwp, this.zzwq));
        return zzdM;
    }

    protected void zzdF() {
        synchronized (this.zzrJ) {
            if (this.zzwx != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.zzwx = new C11331(this);
            this.zzwi.registerReceiver(this.zzwx, intentFilter);
        }
    }

    protected void zzdG() {
        synchronized (this.zzrJ) {
            if (this.zzwx != null) {
                try {
                    this.zzwi.unregisterReceiver(this.zzwx);
                } catch (Throwable e) {
                    zzqf.zzb("Failed trying to unregister the receiver", e);
                } catch (Throwable e2) {
                    zzw.zzcQ().zza(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                }
                this.zzwx = null;
            }
        }
    }

    public void zzdH() {
        synchronized (this.zzrJ) {
            if (this.zzwu) {
                this.zzwv = true;
                try {
                    zza(zzdQ(), true);
                } catch (Throwable e) {
                    zzqf.zzb("JSON failure while processing active view data.", e);
                } catch (Throwable e2) {
                    zzqf.zzb("Failure while processing active view data.", e2);
                }
                String str = "Untracking ad unit: ";
                String valueOf = String.valueOf(this.zzwn.zzdC());
                zzqf.zzbf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
    }

    protected void zzdI() {
        if (this.zzwr != null) {
            this.zzwr.zza(this);
        }
    }

    public boolean zzdJ() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzwu;
        }
        return z;
    }

    protected void zzdK() {
        View zzdS = this.zzwm.zzdU().zzdS();
        if (zzdS != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzwl.get();
            ViewTreeObserver viewTreeObserver2 = zzdS.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                zzdL();
                if (!this.zzws || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                    this.zzws = true;
                    viewTreeObserver2.addOnScrollChangedListener(this);
                    viewTreeObserver2.addOnGlobalLayoutListener(this);
                }
                this.zzwl = new WeakReference(viewTreeObserver2);
            }
        }
    }

    protected void zzdL() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzwl.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject zzdM() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.zzwn.zzdA()).put("activeViewJSON", this.zzwn.zzdB()).put("timestamp", zzw.zzcS().elapsedRealtime()).put("adFormat", this.zzwn.zzdz()).put("hashCode", this.zzwn.zzdC()).put("isMraid", this.zzwn.zzdD()).put("isStopped", this.zzwt).put("isPaused", this.zzuo).put("isScreenOn", isScreenOn()).put("isNative", this.zzwn.zzdE()).put("appMuted", zzw.zzcM().zzcs()).put("appVolume", (double) zzw.zzcM().zzcq()).put("deviceVolume", (double) zzw.zzcM().zzS(this.zzwi));
        return jSONObject;
    }

    protected void zzdN() {
        Iterator it = new ArrayList(this.zzwz).iterator();
        while (it.hasNext()) {
            zzb((zzcx) it.next());
        }
    }

    protected boolean zzdO() {
        Iterator it = this.zzwz.iterator();
        while (it.hasNext()) {
            if (((zzcx) it.next()).zzdV()) {
                return true;
            }
        }
        return false;
    }

    protected JSONObject zzdP() {
        return zzdM().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
    }

    protected JSONObject zzdQ() {
        JSONObject zzdM = zzdM();
        zzdM.put("doneReasonCode", "u");
        return zzdM;
    }

    public zzcr zzdR() {
        return this.zzwn;
    }

    protected void zzj(boolean z) {
        Iterator it = this.zzwy.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    protected void zzk(int i) {
        Object obj = null;
        synchronized (this.zzrJ) {
            if (zzdO() && this.zzwu) {
                View zzdS = this.zzwm.zzdS();
                boolean z = zzdS != null && zzw.zzcM().zza(zzdS, this.zzwp, this.zzwq) && zzdS.getGlobalVisibleRect(new Rect(), null);
                if (this.zzwm.zzdT()) {
                    zzdH();
                    return;
                }
                if (i == 1) {
                    obj = 1;
                }
                if (obj != null) {
                    if (!this.zzvT.tryAcquire() && z == this.zzww) {
                        return;
                    }
                }
                if (z || this.zzww || i != 1) {
                    try {
                        zza(zzd(zzdS), false);
                        this.zzww = z;
                    } catch (JSONException e) {
                        Throwable e2 = e;
                        zzqf.zza("Active view update failed.", e2);
                        zzdK();
                        zzdI();
                        return;
                    } catch (RuntimeException e3) {
                        e2 = e3;
                        zzqf.zza("Active view update failed.", e2);
                        zzdK();
                        zzdI();
                        return;
                    }
                    zzdK();
                    zzdI();
                    return;
                }
                return;
            }
        }
    }
}
