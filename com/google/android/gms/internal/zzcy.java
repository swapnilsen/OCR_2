package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzw;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@zzme
@TargetApi(14)
public class zzcy implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long zzwR;
    private zzpz zzvT;
    private Application zzwS;
    private WeakReference<ViewTreeObserver> zzwT;
    WeakReference<View> zzwU;
    private zzcz zzwV;
    private int zzwW;
    private HashSet<zzb> zzwX;
    private DisplayMetrics zzwY;
    private final Context zzwi;
    private final WindowManager zzwo;
    private final PowerManager zzwp;
    private final KeyguardManager zzwq;
    private boolean zzww;
    @Nullable
    BroadcastReceiver zzwx;

    /* renamed from: com.google.android.gms.internal.zzcy.1 */
    class C11451 implements Runnable {
        final /* synthetic */ zzcy zzwZ;

        C11451(zzcy com_google_android_gms_internal_zzcy) {
            this.zzwZ = com_google_android_gms_internal_zzcy;
        }

        public void run() {
            this.zzwZ.zzl(3);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcy.2 */
    class C11462 extends BroadcastReceiver {
        final /* synthetic */ zzcy zzwZ;

        C11462(zzcy com_google_android_gms_internal_zzcy) {
            this.zzwZ = com_google_android_gms_internal_zzcy;
        }

        public void onReceive(Context context, Intent intent) {
            this.zzwZ.zzl(3);
        }
    }

    public static class zza {
        public final long timestamp;
        public final boolean zzxa;
        public final boolean zzxb;
        public final int zzxc;
        public final Rect zzxd;
        public final Rect zzxe;
        public final Rect zzxf;
        public final boolean zzxg;
        public final Rect zzxh;
        public final boolean zzxi;
        public final Rect zzxj;
        public final float zzxk;
        public final boolean zzxl;

        public zza(long j, boolean z, boolean z2, int i, Rect rect, Rect rect2, Rect rect3, boolean z3, Rect rect4, boolean z4, Rect rect5, float f, boolean z5) {
            this.timestamp = j;
            this.zzxa = z;
            this.zzxb = z2;
            this.zzxc = i;
            this.zzxd = rect;
            this.zzxe = rect2;
            this.zzxf = rect3;
            this.zzxg = z3;
            this.zzxh = rect4;
            this.zzxi = z4;
            this.zzxj = rect5;
            this.zzxk = f;
            this.zzxl = z5;
        }
    }

    public interface zzb {
        void zza(zza com_google_android_gms_internal_zzcy_zza);
    }

    static {
        zzwR = ((Long) zzgd.zzDu.get()).longValue();
    }

    public zzcy(Context context, View view) {
        this.zzvT = new zzpz(zzwR);
        this.zzww = false;
        this.zzwW = -1;
        this.zzwX = new HashSet();
        this.zzwi = context.getApplicationContext();
        this.zzwo = (WindowManager) context.getSystemService("window");
        this.zzwp = (PowerManager) this.zzwi.getSystemService("power");
        this.zzwq = (KeyguardManager) context.getSystemService("keyguard");
        if (this.zzwi instanceof Application) {
            this.zzwS = (Application) this.zzwi;
            this.zzwV = new zzcz((Application) this.zzwi, this);
        }
        this.zzwY = context.getResources().getDisplayMetrics();
        zze(view);
    }

    private void zza(Activity activity, int i) {
        if (this.zzwU != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.zzwU.get();
                if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                    this.zzwW = i;
                }
            }
        }
    }

    private void zzdF() {
        if (this.zzwx == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzwx = new C11462(this);
            this.zzwi.registerReceiver(this.zzwx, intentFilter);
        }
    }

    private void zzdG() {
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

    private void zzdX() {
        zzw.zzcM();
        zzpo.zzXC.post(new C11451(this));
    }

    private void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzwT = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        zzdF();
        if (this.zzwS != null) {
            try {
                this.zzwS.registerActivityLifecycleCallbacks(this.zzwV);
            } catch (Throwable e) {
                zzqf.zzb("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private void zzg(View view) {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.zzwT != null) {
                viewTreeObserver = (ViewTreeObserver) this.zzwT.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzwT = null;
            }
        } catch (Throwable e) {
            zzqf.zzb("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this);
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        } catch (Throwable e2) {
            zzqf.zzb("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        zzdG();
        if (this.zzwS != null) {
            try {
                this.zzwS.unregisterActivityLifecycleCallbacks(this.zzwV);
            } catch (Throwable e22) {
                zzqf.zzb("Error registering activity lifecycle callbacks.", e22);
            }
        }
    }

    private void zzl(int i) {
        if (this.zzwX.size() != 0 && this.zzwU != null) {
            View view = (View) this.zzwU.get();
            Object obj = i == 1 ? 1 : null;
            Object obj2 = view == null ? 1 : null;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            boolean z = false;
            Rect rect3 = new Rect();
            boolean z2 = false;
            Rect rect4 = new Rect();
            Rect rect5 = new Rect();
            rect5.right = this.zzwo.getDefaultDisplay().getWidth();
            rect5.bottom = this.zzwo.getDefaultDisplay().getHeight();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                z = view.getGlobalVisibleRect(rect2);
                z2 = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Throwable e) {
                    zzqf.zzb("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view.getWidth();
                rect.bottom = rect.top + view.getHeight();
            }
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            if (this.zzwW != -1) {
                windowVisibility = this.zzwW;
            }
            boolean z3 = obj2 == null && zzw.zzcM().zza(view, this.zzwp, this.zzwq) && z && z2 && windowVisibility == 0;
            if (obj != null && !this.zzvT.tryAcquire() && z3 == this.zzww) {
                return;
            }
            if (z3 || this.zzww || i != 1) {
                zza com_google_android_gms_internal_zzcy_zza = new zza(zzw.zzcS().elapsedRealtime(), this.zzwp.isScreenOn(), view != null ? zzw.zzcO().isAttachedToWindow(view) : false, view != null ? view.getWindowVisibility() : 8, zza(rect5), zza(rect), zza(rect2), z, zza(rect3), z2, zza(rect4), this.zzwY.density, z3);
                Iterator it = this.zzwX.iterator();
                while (it.hasNext()) {
                    ((zzb) it.next()).zza(com_google_android_gms_internal_zzcy_zza);
                }
                this.zzww = z3;
            }
        }
    }

    private int zzm(int i) {
        return (int) (((float) i) / this.zzwY.density);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzl(3);
        zzdX();
    }

    public void onActivityDestroyed(Activity activity) {
        zzl(3);
        zzdX();
    }

    public void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzl(3);
        zzdX();
    }

    public void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzl(3);
        zzdX();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzl(3);
        zzdX();
    }

    public void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzl(3);
        zzdX();
    }

    public void onActivityStopped(Activity activity) {
        zzl(3);
        zzdX();
    }

    public void onGlobalLayout() {
        zzl(2);
        zzdX();
    }

    public void onScrollChanged() {
        zzl(1);
    }

    public void onViewAttachedToWindow(View view) {
        this.zzwW = -1;
        zzf(view);
        zzl(3);
    }

    public void onViewDetachedFromWindow(View view) {
        this.zzwW = -1;
        zzl(3);
        zzdX();
        zzg(view);
    }

    Rect zza(Rect rect) {
        return new Rect(zzm(rect.left), zzm(rect.top), zzm(rect.right), zzm(rect.bottom));
    }

    public void zza(zzb com_google_android_gms_internal_zzcy_zzb) {
        this.zzwX.add(com_google_android_gms_internal_zzcy_zzb);
        zzl(3);
    }

    public void zzb(zzb com_google_android_gms_internal_zzcy_zzb) {
        this.zzwX.remove(com_google_android_gms_internal_zzcy_zzb);
    }

    public void zzdY() {
        zzl(4);
    }

    public void zze(View view) {
        View view2 = this.zzwU != null ? (View) this.zzwU.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzg(view2);
        }
        this.zzwU = new WeakReference(view);
        if (view != null) {
            if (zzw.zzcO().isAttachedToWindow(view)) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }
}
