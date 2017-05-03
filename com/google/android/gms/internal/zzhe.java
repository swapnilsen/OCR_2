package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcy.zzb;
import com.google.android.gms.internal.zzhh.zza;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public class zzhe extends zza implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    static final String[] zzHf;
    @Nullable
    zzha zzGA;
    private final FrameLayout zzHg;
    Map<String, WeakReference<View>> zzHh;
    @Nullable
    View zzHi;
    boolean zzHj;
    Point zzHk;
    Point zzHl;
    WeakReference<zzcy> zzHm;
    private final Object zzrJ;
    @Nullable
    FrameLayout zzrY;

    /* renamed from: com.google.android.gms.internal.zzhe.1 */
    class C12001 implements Runnable {
        final /* synthetic */ zzhb zzHn;
        final /* synthetic */ zzhe zzHo;

        C12001(zzhe com_google_android_gms_internal_zzhe, zzhb com_google_android_gms_internal_zzhb) {
            this.zzHo = com_google_android_gms_internal_zzhe;
            this.zzHn = com_google_android_gms_internal_zzhb;
        }

        public void run() {
            zzqw zzgb = this.zzHn.zzgb();
            if (!(zzgb == null || this.zzHo.zzrY == null)) {
                this.zzHo.zzrY.addView(zzgb.getView());
            }
            if (!(this.zzHn instanceof zzgz)) {
                this.zzHo.zzb(this.zzHn);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhe.2 */
    class C12012 implements zzgy {
        final /* synthetic */ zzhe zzHo;
        final /* synthetic */ View zzHp;

        C12012(zzhe com_google_android_gms_internal_zzhe, View view) {
            this.zzHo = com_google_android_gms_internal_zzhe;
            this.zzHp = view;
        }

        public void zzc(MotionEvent motionEvent) {
            this.zzHo.onTouch(null, motionEvent);
        }

        public void zzfX() {
            this.zzHo.onClick(this.zzHp);
        }
    }

    static {
        zzHf = new String[]{"2011", "1009"};
    }

    public zzhe(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzrJ = new Object();
        this.zzHh = new HashMap();
        this.zzHj = false;
        this.zzHk = new Point();
        this.zzHl = new Point();
        this.zzHm = new WeakReference(null);
        this.zzHg = frameLayout;
        this.zzrY = frameLayout2;
        zzw.zzdk().zza(this.zzHg, (OnGlobalLayoutListener) this);
        zzw.zzdk().zza(this.zzHg, (OnScrollChangedListener) this);
        this.zzHg.setOnTouchListener(this);
        this.zzHg.setOnClickListener(this);
        zzgd.initialize(this.zzHg.getContext());
    }

    private void zza(zzhb com_google_android_gms_internal_zzhb) {
        View view;
        ViewGroup viewGroup = null;
        boolean zzfY = com_google_android_gms_internal_zzhb.zzfY();
        if (zzfY && this.zzHh != null) {
            WeakReference weakReference = (WeakReference) this.zzHh.get("1098");
            view = weakReference != null ? (View) weakReference.get() : null;
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            }
        }
        boolean z = zzfY && viewGroup != null;
        this.zzHi = zza(com_google_android_gms_internal_zzhb, z);
        if (this.zzHi != null) {
            if (this.zzHh != null) {
                this.zzHh.put("1007", new WeakReference(this.zzHi));
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.zzHi);
                return;
            }
            view = zzp(com_google_android_gms_internal_zzhb.getContext());
            view.setLayoutParams(new LayoutParams(-1, -1));
            view.addView(this.zzHi);
            if (this.zzrY != null) {
                this.zzrY.addView(view);
            }
        }
    }

    private void zzb(zzhb com_google_android_gms_internal_zzhb) {
        synchronized (this.zzrJ) {
            View zzgk = zzgk();
            if (zzgk instanceof FrameLayout) {
                com_google_android_gms_internal_zzhb.zza(zzgk, new C12012(this, zzgk));
                return;
            }
            com_google_android_gms_internal_zzhb.zzgd();
        }
    }

    private View zzgk() {
        if (this.zzHh == null) {
            return null;
        }
        for (Object obj : zzHf) {
            WeakReference weakReference = (WeakReference) this.zzHh.get(obj);
            if (weakReference != null) {
                return (View) weakReference.get();
            }
        }
        return null;
    }

    public void destroy() {
        synchronized (this.zzrJ) {
            if (this.zzrY != null) {
                this.zzrY.removeAllViews();
            }
            this.zzrY = null;
            this.zzHh = null;
            this.zzHi = null;
            this.zzGA = null;
            this.zzHk = null;
            this.zzHl = null;
            this.zzHm = null;
        }
    }

    int getMeasuredHeight() {
        return this.zzHg.getMeasuredHeight();
    }

    int getMeasuredWidth() {
        return this.zzHg.getMeasuredWidth();
    }

    public void onClick(View view) {
        synchronized (this.zzrJ) {
            if (this.zzGA == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", zzC(this.zzHk.x));
                jSONObject.put("y", zzC(this.zzHk.y));
                jSONObject.put("start_x", zzC(this.zzHl.x));
                jSONObject.put("start_y", zzC(this.zzHl.y));
            } catch (JSONException e) {
                zzqf.zzbh("Unable to get click location");
            }
            if (this.zzHi == null || !this.zzHi.equals(view)) {
                this.zzGA.zza(view, this.zzHh, jSONObject, this.zzHg);
            } else if (!(this.zzGA instanceof zzgz)) {
                this.zzGA.zza(view, "1007", jSONObject, this.zzHh, this.zzHg);
            } else if (((zzgz) this.zzGA).zzga() != null) {
                ((zzgz) this.zzGA).zzga().zza(view, "1007", jSONObject, this.zzHh, this.zzHg);
            }
        }
    }

    public void onGlobalLayout() {
        synchronized (this.zzrJ) {
            if (this.zzHj) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (!(measuredWidth == 0 || measuredHeight == 0 || this.zzrY == null)) {
                    this.zzrY.setLayoutParams(new LayoutParams(measuredWidth, measuredHeight));
                    this.zzHj = false;
                }
            }
            if (this.zzGA != null) {
                this.zzGA.zzd(this.zzHg, this.zzHh);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.zzrJ) {
            if (this.zzGA != null) {
                this.zzGA.zzd(this.zzHg, this.zzHh);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.zzrJ) {
            if (this.zzGA == null) {
            } else {
                Point zze = zze(motionEvent);
                this.zzHk = zze;
                if (motionEvent.getAction() == 0) {
                    this.zzHl = zze;
                }
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) zze.x, (float) zze.y);
                this.zzGA.zzd(obtain);
                obtain.recycle();
            }
        }
        return false;
    }

    int zzC(int i) {
        return zzel.zzeT().zzc(this.zzGA.getContext(), i);
    }

    public IObjectWrapper zzU(String str) {
        Object obj = null;
        synchronized (this.zzrJ) {
            if (this.zzHh == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) this.zzHh.get(str);
            if (weakReference != null) {
                View view = (View) weakReference.get();
            }
            IObjectWrapper zzA = zzd.zzA(obj);
            return zzA;
        }
    }

    @Nullable
    View zza(zzhb com_google_android_gms_internal_zzhb, boolean z) {
        return com_google_android_gms_internal_zzhb.zza((OnClickListener) this, z);
    }

    public void zzb(IObjectWrapper iObjectWrapper, int i) {
        if (zzw.zzdl().zzjS()) {
            zzcy com_google_android_gms_internal_zzcy = (zzcy) this.zzHm.get();
            if (com_google_android_gms_internal_zzcy != null) {
                com_google_android_gms_internal_zzcy.zzdY();
            }
        }
    }

    public void zzd(String str, IObjectWrapper iObjectWrapper) {
        View view = (View) zzd.zzF(iObjectWrapper);
        synchronized (this.zzrJ) {
            if (this.zzHh == null) {
                return;
            }
            if (view == null) {
                this.zzHh.remove(str);
            } else {
                this.zzHh.put(str, new WeakReference(view));
                if ("1098".equals(str)) {
                    return;
                }
                view.setOnTouchListener(this);
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    Point zze(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.zzHg.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
    }

    public void zze(IObjectWrapper iObjectWrapper) {
        synchronized (this.zzrJ) {
            zzj(null);
            Object zzF = zzd.zzF(iObjectWrapper);
            if (zzF instanceof zzhb) {
                if (this.zzrY != null) {
                    this.zzrY.setLayoutParams(new LayoutParams(0, 0));
                    this.zzHg.requestLayout();
                }
                this.zzHj = true;
                zzhb com_google_android_gms_internal_zzhb = (zzhb) zzF;
                if (this.zzGA != null && ((Boolean) zzgd.zzEp.get()).booleanValue()) {
                    this.zzGA.zzc(this.zzHg, this.zzHh);
                }
                zzgj();
                if ((this.zzGA instanceof zzgz) && ((zzgz) this.zzGA).zzfZ()) {
                    ((zzgz) this.zzGA).zzc(com_google_android_gms_internal_zzhb);
                } else {
                    this.zzGA = com_google_android_gms_internal_zzhb;
                    if (com_google_android_gms_internal_zzhb instanceof zzgz) {
                        ((zzgz) com_google_android_gms_internal_zzhb).zzc(null);
                    }
                }
                if (((Boolean) zzgd.zzEp.get()).booleanValue()) {
                    this.zzrY.setClickable(false);
                }
                this.zzrY.removeAllViews();
                zza(com_google_android_gms_internal_zzhb);
                com_google_android_gms_internal_zzhb.zza(this.zzHg, this.zzHh, (OnTouchListener) this, (OnClickListener) this);
                zzpo.zzXC.post(new C12001(this, com_google_android_gms_internal_zzhb));
                zzj(this.zzHg);
                zzgi();
                return;
            }
            zzqf.zzbh("Not an instance of native engine. This is most likely a transient error");
        }
    }

    void zzgi() {
        if (this.zzGA instanceof zzhb) {
            zzhb com_google_android_gms_internal_zzhb = (zzhb) this.zzGA;
            if (zzw.zzdl().zzjS() && com_google_android_gms_internal_zzhb != null && com_google_android_gms_internal_zzhb.getContext() != null) {
                zzcy com_google_android_gms_internal_zzcy = (zzcy) this.zzHm.get();
                if (com_google_android_gms_internal_zzcy == null) {
                    com_google_android_gms_internal_zzcy = new zzcy(this.zzHg.getContext(), this.zzHg);
                    this.zzHm = new WeakReference(com_google_android_gms_internal_zzcy);
                }
                com_google_android_gms_internal_zzcy.zza(com_google_android_gms_internal_zzhb.zzgg());
            }
        }
    }

    void zzgj() {
        if (this.zzGA instanceof zzhb) {
            zzhb com_google_android_gms_internal_zzhb = (zzhb) this.zzGA;
            if (zzw.zzdl().zzjS() && com_google_android_gms_internal_zzhb != null && com_google_android_gms_internal_zzhb.getContext() != null) {
                zzb zzgg = com_google_android_gms_internal_zzhb.zzgg();
                if (zzgg != null) {
                    zzgg.zzC(false);
                }
                zzcy com_google_android_gms_internal_zzcy = (zzcy) this.zzHm.get();
                if (com_google_android_gms_internal_zzcy != null && zzgg != null) {
                    com_google_android_gms_internal_zzcy.zzb(zzgg);
                }
            }
        }
    }

    void zzj(@Nullable View view) {
        if (this.zzGA != null) {
            zzha zzga = this.zzGA instanceof zzgz ? ((zzgz) this.zzGA).zzga() : this.zzGA;
            if (zzga != null) {
                zzga.zzj(view);
            }
        }
    }

    AdChoicesView zzp(Context context) {
        return new AdChoicesView(context);
    }
}
