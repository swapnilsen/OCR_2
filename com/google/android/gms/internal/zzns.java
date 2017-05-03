package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzpb.zza;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@zzme
public class zzns extends zzb implements zzoh {
    private static zzns zzVk;
    private static final zzjz zzVl;
    private final Map<String, zzol> zzVm;
    private boolean zzVn;

    /* renamed from: com.google.android.gms.internal.zzns.1 */
    class C13371 implements Runnable {
        final /* synthetic */ zzns zzVo;

        C13371(zzns com_google_android_gms_internal_zzns) {
            this.zzVo = com_google_android_gms_internal_zzns;
        }

        public void run() {
            this.zzVo.zzh(1);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzns.2 */
    class C13382 implements Runnable {
        final /* synthetic */ zzns zzVo;
        final /* synthetic */ zza zzsI;

        C13382(zzns com_google_android_gms_internal_zzns, zza com_google_android_gms_internal_zzpb_zza) {
            this.zzVo = com_google_android_gms_internal_zzns;
            this.zzsI = com_google_android_gms_internal_zzpb_zza;
        }

        public void run() {
            this.zzVo.zzb(new zzpb(this.zzsI, null, null, null, null, null, null, null));
        }
    }

    static {
        zzVl = new zzjz();
    }

    public zzns(Context context, zze com_google_android_gms_ads_internal_zze, zzeg com_google_android_gms_internal_zzeg, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh) {
        super(context, com_google_android_gms_internal_zzeg, null, com_google_android_gms_internal_zzka, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze);
        this.zzVm = new HashMap();
        zzVk = this;
    }

    private zza zzd(zza com_google_android_gms_internal_zzpb_zza) {
        zzpk.m4709v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = zznd.zzb(com_google_android_gms_internal_zzpb_zza.zzWm).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, com_google_android_gms_internal_zzpb_zza.zzTi.zzvl);
            zzjq com_google_android_gms_internal_zzjq = new zzjq(jSONObject, null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            return new zza(com_google_android_gms_internal_zzpb_zza.zzTi, com_google_android_gms_internal_zzpb_zza.zzWm, new zzjr(Arrays.asList(new zzjq[]{com_google_android_gms_internal_zzjq}), ((Long) zzgd.zzDM.get()).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, -1, 0, 1, null, 0, -1, -1, false), com_google_android_gms_internal_zzpb_zza.zzvr, com_google_android_gms_internal_zzpb_zza.errorCode, com_google_android_gms_internal_zzpb_zza.zzWg, com_google_android_gms_internal_zzpb_zza.zzWh, com_google_android_gms_internal_zzpb_zza.zzWa);
        } catch (Throwable e) {
            zzqf.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return zze(com_google_android_gms_internal_zzpb_zza);
        }
    }

    private zza zze(zza com_google_android_gms_internal_zzpb_zza) {
        return new zza(com_google_android_gms_internal_zzpb_zza.zzTi, com_google_android_gms_internal_zzpb_zza.zzWm, null, com_google_android_gms_internal_zzpb_zza.zzvr, 0, com_google_android_gms_internal_zzpb_zza.zzWg, com_google_android_gms_internal_zzpb_zza.zzWh, com_google_android_gms_internal_zzpb_zza.zzWa);
    }

    public static zzns zzjE() {
        return zzVk;
    }

    public void destroy() {
        String valueOf;
        zzac.zzdj("destroy must be called on the main UI thread.");
        for (String valueOf2 : this.zzVm.keySet()) {
            try {
                zzol com_google_android_gms_internal_zzol = (zzol) this.zzVm.get(valueOf2);
                if (!(com_google_android_gms_internal_zzol == null || com_google_android_gms_internal_zzol.zzjN() == null)) {
                    com_google_android_gms_internal_zzol.zzjN().destroy();
                }
            } catch (RemoteException e) {
                String str = "Fail to destroy adapter: ";
                valueOf2 = String.valueOf(valueOf2);
                zzqf.zzbh(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
            }
        }
    }

    public boolean isLoaded() {
        zzac.zzdj("isLoaded must be called on the main UI thread.");
        return this.zzss.zzvp == null && this.zzss.zzvq == null && this.zzss.zzvs != null && !this.zzVn;
    }

    public void onContextChanged(@NonNull Context context) {
        for (zzol zzjN : this.zzVm.values()) {
            try {
                zzjN.zzjN().zzk(zzd.zzA(context));
            } catch (Throwable e) {
                zzqf.zzb("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public void onRewardedVideoAdClosed() {
        zzbG();
    }

    public void onRewardedVideoAdLeftApplication() {
        zzbH();
    }

    public void onRewardedVideoAdOpened() {
        zza(this.zzss.zzvs, false);
        zzbI();
    }

    public void onRewardedVideoStarted() {
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzLi == null)) {
            zzw.zzdf().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, this.zzss.zzvs, this.zzss.zzvl, false, this.zzss.zzvs.zzLi.zzKw);
        }
        zzbK();
    }

    public void pause() {
        zzac.zzdj("pause must be called on the main UI thread.");
        for (String str : this.zzVm.keySet()) {
            String str2;
            try {
                zzol com_google_android_gms_internal_zzol = (zzol) this.zzVm.get(str2);
                if (!(com_google_android_gms_internal_zzol == null || com_google_android_gms_internal_zzol.zzjN() == null)) {
                    com_google_android_gms_internal_zzol.zzjN().pause();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to pause adapter: ";
                str2 = String.valueOf(str2);
                zzqf.zzbh(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void resume() {
        zzac.zzdj("resume must be called on the main UI thread.");
        for (String str : this.zzVm.keySet()) {
            String str2;
            try {
                zzol com_google_android_gms_internal_zzol = (zzol) this.zzVm.get(str2);
                if (!(com_google_android_gms_internal_zzol == null || com_google_android_gms_internal_zzol.zzjN() == null)) {
                    com_google_android_gms_internal_zzol.zzjN().resume();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to resume adapter: ";
                str2 = String.valueOf(str2);
                zzqf.zzbh(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void zza(zzoa com_google_android_gms_internal_zzoa) {
        zzac.zzdj("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzoa.zzvl)) {
            zzqf.zzbh("Invalid ad unit id. Aborting.");
            zzpo.zzXC.post(new C13371(this));
            return;
        }
        this.zzVn = false;
        this.zzss.zzvl = com_google_android_gms_internal_zzoa.zzvl;
        super.zzb(com_google_android_gms_internal_zzoa.zzRy);
    }

    public void zza(zza com_google_android_gms_internal_zzpb_zza, zzgl com_google_android_gms_internal_zzgl) {
        if (com_google_android_gms_internal_zzpb_zza.errorCode != -2) {
            zzpo.zzXC.post(new C13382(this, com_google_android_gms_internal_zzpb_zza));
            return;
        }
        this.zzss.zzvt = com_google_android_gms_internal_zzpb_zza;
        if (com_google_android_gms_internal_zzpb_zza.zzWc == null) {
            this.zzss.zzvt = zzd(com_google_android_gms_internal_zzpb_zza);
        }
        this.zzss.zzvO = 0;
        this.zzss.zzvq = zzw.zzcL().zza(this.zzss.zzqn, this.zzss.zzvt, this);
    }

    protected boolean zza(zzec com_google_android_gms_internal_zzec, zzpb com_google_android_gms_internal_zzpb, boolean z) {
        return false;
    }

    public boolean zza(zzpb com_google_android_gms_internal_zzpb, zzpb com_google_android_gms_internal_zzpb2) {
        return true;
    }

    @Nullable
    public zzol zzaN(String str) {
        Throwable th;
        String str2;
        String valueOf;
        zzol com_google_android_gms_internal_zzol = (zzol) this.zzVm.get(str);
        if (com_google_android_gms_internal_zzol != null) {
            return com_google_android_gms_internal_zzol;
        }
        zzol com_google_android_gms_internal_zzol2;
        try {
            com_google_android_gms_internal_zzol2 = new zzol(("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? zzVl : this.zzsz).zzas(str), this);
            try {
                this.zzVm.put(str, com_google_android_gms_internal_zzol2);
                return com_google_android_gms_internal_zzol2;
            } catch (Throwable e) {
                th = e;
                str2 = "Fail to instantiate adapter ";
                valueOf = String.valueOf(str);
                zzqf.zzc(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
                return com_google_android_gms_internal_zzol2;
            }
        } catch (Throwable e2) {
            th = e2;
            com_google_android_gms_internal_zzol2 = com_google_android_gms_internal_zzol;
            str2 = "Fail to instantiate adapter ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
            }
            zzqf.zzc(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
            return com_google_android_gms_internal_zzol2;
        }
    }

    protected void zzbG() {
        this.zzss.zzvs = null;
        super.zzbG();
    }

    public void zzc(@Nullable zzoo com_google_android_gms_internal_zzoo) {
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzLi == null)) {
            zzw.zzdf().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, this.zzss.zzvs, this.zzss.zzvl, false, this.zzss.zzvs.zzLi.zzKx);
        }
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzWc == null || TextUtils.isEmpty(this.zzss.zzvs.zzWc.zzKM))) {
            com_google_android_gms_internal_zzoo = new zzoo(this.zzss.zzvs.zzWc.zzKM, this.zzss.zzvs.zzWc.zzKN);
        }
        zza(com_google_android_gms_internal_zzoo);
    }

    public void zzjF() {
        zzac.zzdj("showAd must be called on the main UI thread.");
        if (isLoaded()) {
            this.zzVn = true;
            zzol zzaN = zzaN(this.zzss.zzvs.zzLk);
            if (zzaN != null && zzaN.zzjN() != null) {
                try {
                    zzaN.zzjN().showVideo();
                    return;
                } catch (Throwable e) {
                    zzqf.zzc("Could not call showVideo.", e);
                    return;
                }
            }
            return;
        }
        zzqf.zzbh("The reward video has not loaded.");
    }

    public void zzjG() {
        onAdClicked();
    }
}
