package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzji.zzc;
import com.google.android.gms.internal.zzqp.zza;
import com.google.android.gms.internal.zzqp.zzb;
import java.util.Map;
import org.json.JSONObject;

@zzme
public class zzcw implements zzcx {
    private final zzct zzwG;
    private final zzid zzwI;
    private final zzid zzwJ;
    private final zzid zzwK;
    private zzc zzwM;
    private boolean zzwN;
    private final zzid zzwO;

    /* renamed from: com.google.android.gms.internal.zzcw.1 */
    class C11371 implements zzqp.zzc<zzjj> {
        final /* synthetic */ zzcw zzwP;

        C11371(zzcw com_google_android_gms_internal_zzcw) {
            this.zzwP = com_google_android_gms_internal_zzcw;
        }

        public void zzb(zzjj com_google_android_gms_internal_zzjj) {
            this.zzwP.zzwN = true;
            this.zzwP.zzc(com_google_android_gms_internal_zzjj);
        }

        public /* synthetic */ void zzd(Object obj) {
            zzb((zzjj) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.2 */
    class C11382 implements zza {
        final /* synthetic */ zzcw zzwP;

        C11382(zzcw com_google_android_gms_internal_zzcw) {
            this.zzwP = com_google_android_gms_internal_zzcw;
        }

        public void run() {
            this.zzwP.zzwG.zzb(this.zzwP);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.3 */
    class C11393 implements zzqp.zzc<zzjj> {
        final /* synthetic */ JSONObject zzwQ;

        C11393(zzcw com_google_android_gms_internal_zzcw, JSONObject jSONObject) {
            this.zzwQ = jSONObject;
        }

        public void zzb(zzjj com_google_android_gms_internal_zzjj) {
            com_google_android_gms_internal_zzjj.zza("AFMA_updateActiveView", this.zzwQ);
        }

        public /* synthetic */ void zzd(Object obj) {
            zzb((zzjj) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.4 */
    class C11404 implements zzqp.zzc<zzjj> {
        final /* synthetic */ zzcw zzwP;

        C11404(zzcw com_google_android_gms_internal_zzcw) {
            this.zzwP = com_google_android_gms_internal_zzcw;
        }

        public void zzb(zzjj com_google_android_gms_internal_zzjj) {
            this.zzwP.zzd(com_google_android_gms_internal_zzjj);
        }

        public /* synthetic */ void zzd(Object obj) {
            zzb((zzjj) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.5 */
    class C11415 implements zzid {
        final /* synthetic */ zzcw zzwP;

        C11415(zzcw com_google_android_gms_internal_zzcw) {
            this.zzwP = com_google_android_gms_internal_zzcw;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            if (this.zzwP.zzwG.zzb((Map) map)) {
                this.zzwP.zzwG.zzb(com_google_android_gms_internal_zzqw, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.6 */
    class C11426 implements zzid {
        final /* synthetic */ zzcw zzwP;

        C11426(zzcw com_google_android_gms_internal_zzcw) {
            this.zzwP = com_google_android_gms_internal_zzcw;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            if (this.zzwP.zzwG.zzb((Map) map)) {
                this.zzwP.zzwG.zza(this.zzwP, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.7 */
    class C11437 implements zzid {
        final /* synthetic */ zzcw zzwP;

        C11437(zzcw com_google_android_gms_internal_zzcw) {
            this.zzwP = com_google_android_gms_internal_zzcw;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            if (this.zzwP.zzwG.zzb((Map) map)) {
                this.zzwP.zzwG.zzc(map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.8 */
    class C11448 implements zzid {
        final /* synthetic */ zzcw zzwP;

        C11448(zzcw com_google_android_gms_internal_zzcw) {
            this.zzwP = com_google_android_gms_internal_zzcw;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            if (this.zzwP.zzwG.zzb((Map) map)) {
                zzic.zzHS.zza(com_google_android_gms_internal_zzqw, map);
            }
        }
    }

    public zzcw(zzct com_google_android_gms_internal_zzct, zzji com_google_android_gms_internal_zzji) {
        this.zzwI = new C11415(this);
        this.zzwJ = new C11426(this);
        this.zzwK = new C11437(this);
        this.zzwO = new C11448(this);
        this.zzwG = com_google_android_gms_internal_zzct;
        this.zzwM = com_google_android_gms_internal_zzji.zzgO();
        this.zzwM.zza(new C11371(this), new C11382(this));
        String str = "Core JS tracking ad unit: ";
        String valueOf = String.valueOf(this.zzwG.zzdR().zzdC());
        zzqf.zzbf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void zzc(zzjj com_google_android_gms_internal_zzjj) {
        com_google_android_gms_internal_zzjj.zza("/updateActiveView", this.zzwI);
        com_google_android_gms_internal_zzjj.zza("/untrackActiveViewUnit", this.zzwJ);
        com_google_android_gms_internal_zzjj.zza("/visibilityChanged", this.zzwK);
        if (zzw.zzdl().zzjQ()) {
            com_google_android_gms_internal_zzjj.zza("/logScionEvent", this.zzwO);
        }
    }

    public void zzc(JSONObject jSONObject, boolean z) {
        this.zzwM.zza(new C11393(this, jSONObject), new zzb());
    }

    void zzd(zzjj com_google_android_gms_internal_zzjj) {
        com_google_android_gms_internal_zzjj.zzb("/visibilityChanged", this.zzwK);
        com_google_android_gms_internal_zzjj.zzb("/untrackActiveViewUnit", this.zzwJ);
        com_google_android_gms_internal_zzjj.zzb("/updateActiveView", this.zzwI);
        if (zzw.zzdl().zzjQ()) {
            com_google_android_gms_internal_zzjj.zzb("/logScionEvent", this.zzwO);
        }
    }

    public boolean zzdV() {
        return this.zzwN;
    }

    public void zzdW() {
        this.zzwM.zza(new C11404(this), new zzb());
        this.zzwM.release();
    }
}
