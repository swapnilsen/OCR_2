package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzpb.zza;
import com.google.android.gms.internal.zzqx.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzme
public class zzly {
    private final Context mContext;
    private final zzs zzGJ;
    private final zzaw zzGP;
    private final zza zzPR;
    private OnGlobalLayoutListener zzQV;
    private OnScrollChangedListener zzQW;
    private final Object zzrJ;
    private final zzgl zzsn;
    private int zzvR;
    private int zzvS;
    private zzpz zzvT;

    /* renamed from: com.google.android.gms.internal.zzly.1 */
    class C13091 implements Runnable {
        final /* synthetic */ JSONObject zzQX;
        final /* synthetic */ zzqj zzQY;
        final /* synthetic */ zzly zzQZ;

        /* renamed from: com.google.android.gms.internal.zzly.1.1 */
        class C13071 implements zzb {
            final /* synthetic */ C13091 zzRa;
            final /* synthetic */ zzqw zztS;

            C13071(C13091 c13091, zzqw com_google_android_gms_internal_zzqw) {
                this.zzRa = c13091;
                this.zztS = com_google_android_gms_internal_zzqw;
            }

            public void zzk(zzqw com_google_android_gms_internal_zzqw) {
                this.zztS.zza("google.afma.nativeAds.renderVideo", this.zzRa.zzQX);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzly.1.2 */
        class C13082 implements zzqx.zza {
            final /* synthetic */ C13091 zzRa;

            C13082(C13091 c13091) {
                this.zzRa = c13091;
            }

            public void zza(zzqw com_google_android_gms_internal_zzqw, boolean z) {
                this.zzRa.zzQZ.zzGJ.zzcw();
                this.zzRa.zzQY.zzh(com_google_android_gms_internal_zzqw);
            }
        }

        C13091(zzly com_google_android_gms_internal_zzly, JSONObject jSONObject, zzqj com_google_android_gms_internal_zzqj) {
            this.zzQZ = com_google_android_gms_internal_zzly;
            this.zzQX = jSONObject;
            this.zzQY = com_google_android_gms_internal_zzqj;
        }

        public void run() {
            try {
                zzqw zzjj = this.zzQZ.zzjj();
                this.zzQZ.zzGJ.zzc(zzjj);
                WeakReference weakReference = new WeakReference(zzjj);
                zzjj.zzlv().zza(this.zzQZ.zza(weakReference), this.zzQZ.zzb(weakReference));
                this.zzQZ.zzj(zzjj);
                zzjj.zzlv().zza(new C13071(this, zzjj));
                zzjj.zzlv().zza(new C13082(this));
                zzjj.loadUrl((String) zzgd.zzEl.get());
            } catch (Throwable e) {
                zzqf.zzc("Exception occurred while getting video view", e);
                this.zzQY.zzh(null);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzly.2 */
    class C13102 implements zzid {
        final /* synthetic */ zzly zzQZ;

        C13102(zzly com_google_android_gms_internal_zzly) {
            this.zzQZ = com_google_android_gms_internal_zzly;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            this.zzQZ.zzGJ.zzct();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzly.3 */
    class C13113 implements OnGlobalLayoutListener {
        final /* synthetic */ zzly zzQZ;
        final /* synthetic */ WeakReference zzRb;

        C13113(zzly com_google_android_gms_internal_zzly, WeakReference weakReference) {
            this.zzQZ = com_google_android_gms_internal_zzly;
            this.zzRb = weakReference;
        }

        public void onGlobalLayout() {
            this.zzQZ.zza(this.zzRb, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzly.4 */
    class C13124 implements OnScrollChangedListener {
        final /* synthetic */ zzly zzQZ;
        final /* synthetic */ WeakReference zzRb;

        C13124(zzly com_google_android_gms_internal_zzly, WeakReference weakReference) {
            this.zzQZ = com_google_android_gms_internal_zzly;
            this.zzRb = weakReference;
        }

        public void onScrollChanged() {
            this.zzQZ.zza(this.zzRb, true);
        }
    }

    public zzly(Context context, zzaw com_google_android_gms_internal_zzaw, zza com_google_android_gms_internal_zzpb_zza, zzgl com_google_android_gms_internal_zzgl, zzs com_google_android_gms_ads_internal_zzs) {
        this.zzrJ = new Object();
        this.zzvR = -1;
        this.zzvS = -1;
        this.mContext = context;
        this.zzGP = com_google_android_gms_internal_zzaw;
        this.zzPR = com_google_android_gms_internal_zzpb_zza;
        this.zzsn = com_google_android_gms_internal_zzgl;
        this.zzGJ = com_google_android_gms_ads_internal_zzs;
        this.zzvT = new zzpz(200);
    }

    private OnGlobalLayoutListener zza(WeakReference<zzqw> weakReference) {
        if (this.zzQV == null) {
            this.zzQV = new C13113(this, weakReference);
        }
        return this.zzQV;
    }

    private void zza(WeakReference<zzqw> weakReference, boolean z) {
        if (weakReference != null) {
            zzqw com_google_android_gms_internal_zzqw = (zzqw) weakReference.get();
            if (com_google_android_gms_internal_zzqw != null && com_google_android_gms_internal_zzqw.getView() != null) {
                if (!z || this.zzvT.tryAcquire()) {
                    int[] iArr = new int[2];
                    com_google_android_gms_internal_zzqw.getView().getLocationOnScreen(iArr);
                    int zzc = zzel.zzeT().zzc(this.mContext, iArr[0]);
                    int zzc2 = zzel.zzeT().zzc(this.mContext, iArr[1]);
                    synchronized (this.zzrJ) {
                        if (!(this.zzvR == zzc && this.zzvS == zzc2)) {
                            this.zzvR = zzc;
                            this.zzvS = zzc2;
                            com_google_android_gms_internal_zzqw.zzlv().zza(this.zzvR, this.zzvS, !z);
                        }
                    }
                }
            }
        }
    }

    private OnScrollChangedListener zzb(WeakReference<zzqw> weakReference) {
        if (this.zzQW == null) {
            this.zzQW = new C13124(this, weakReference);
        }
        return this.zzQW;
    }

    private void zzj(zzqw com_google_android_gms_internal_zzqw) {
        zzqx zzlv = com_google_android_gms_internal_zzqw.zzlv();
        zzlv.zza("/video", zzic.zzHQ);
        zzlv.zza("/videoMeta", zzic.zzHR);
        zzlv.zza("/precache", zzic.zzHT);
        zzlv.zza("/delayPageLoaded", zzic.zzHW);
        zzlv.zza("/instrument", zzic.zzHU);
        zzlv.zza("/log", zzic.zzHL);
        zzlv.zza("/videoClicked", zzic.zzHM);
        zzlv.zza("/trackActiveViewUnit", new C13102(this));
    }

    public zzqm<zzqw> zze(JSONObject jSONObject) {
        zzqm com_google_android_gms_internal_zzqj = new zzqj();
        zzw.zzcM().runOnUiThread(new C13091(this, jSONObject, com_google_android_gms_internal_zzqj));
        return com_google_android_gms_internal_zzqj;
    }

    zzqw zzjj() {
        return zzw.zzcN().zza(this.mContext, zzeg.zzk(this.mContext), false, false, this.zzGP, this.zzPR.zzTi.zzvn, this.zzsn, null, this.zzGJ.zzby());
    }
}
