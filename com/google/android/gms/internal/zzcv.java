package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

@zzme
public class zzcv implements zzcx {
    private final zzct zzwG;
    private final zzjj zzwH;
    private final zzid zzwI;
    private final zzid zzwJ;
    private final zzid zzwK;

    /* renamed from: com.google.android.gms.internal.zzcv.1 */
    class C11341 implements zzid {
        final /* synthetic */ zzcv zzwL;

        C11341(zzcv com_google_android_gms_internal_zzcv) {
            this.zzwL = com_google_android_gms_internal_zzcv;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            this.zzwL.zzwG.zzb(com_google_android_gms_internal_zzqw, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcv.2 */
    class C11352 implements zzid {
        final /* synthetic */ zzcv zzwL;

        C11352(zzcv com_google_android_gms_internal_zzcv) {
            this.zzwL = com_google_android_gms_internal_zzcv;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            this.zzwL.zzwG.zza(this.zzwL, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcv.3 */
    class C11363 implements zzid {
        final /* synthetic */ zzcv zzwL;

        C11363(zzcv com_google_android_gms_internal_zzcv) {
            this.zzwL = com_google_android_gms_internal_zzcv;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            this.zzwL.zzwG.zzc(map);
        }
    }

    public zzcv(zzct com_google_android_gms_internal_zzct, zzjj com_google_android_gms_internal_zzjj) {
        this.zzwI = new C11341(this);
        this.zzwJ = new C11352(this);
        this.zzwK = new C11363(this);
        this.zzwG = com_google_android_gms_internal_zzct;
        this.zzwH = com_google_android_gms_internal_zzjj;
        zzc(this.zzwH);
        String str = "Custom JS tracking ad unit: ";
        String valueOf = String.valueOf(this.zzwG.zzdR().zzdC());
        zzqf.zzbf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void zzc(zzjj com_google_android_gms_internal_zzjj) {
        com_google_android_gms_internal_zzjj.zza("/updateActiveView", this.zzwI);
        com_google_android_gms_internal_zzjj.zza("/untrackActiveViewUnit", this.zzwJ);
        com_google_android_gms_internal_zzjj.zza("/visibilityChanged", this.zzwK);
    }

    public void zzc(JSONObject jSONObject, boolean z) {
        if (z) {
            this.zzwG.zzb((zzcx) this);
        } else {
            this.zzwH.zza("AFMA_updateActiveView", jSONObject);
        }
    }

    void zzd(zzjj com_google_android_gms_internal_zzjj) {
        com_google_android_gms_internal_zzjj.zzb("/visibilityChanged", this.zzwK);
        com_google_android_gms_internal_zzjj.zzb("/untrackActiveViewUnit", this.zzwJ);
        com_google_android_gms_internal_zzjj.zzb("/updateActiveView", this.zzwI);
    }

    public boolean zzdV() {
        return true;
    }

    public void zzdW() {
        zzd(this.zzwH);
    }
}
