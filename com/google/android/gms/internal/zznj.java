package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@zzme
public final class zznj {
    private WeakHashMap<Context, zza> zzVb;

    /* renamed from: com.google.android.gms.internal.zznj.1 */
    class C13361 implements Callable<zzni> {
        final /* synthetic */ zznj zzVc;
        final /* synthetic */ Context zztf;

        C13361(zznj com_google_android_gms_internal_zznj, Context context) {
            this.zzVc = com_google_android_gms_internal_zznj;
            this.zztf = context;
        }

        public /* synthetic */ Object call() {
            return zzjD();
        }

        public zzni zzjD() {
            zza com_google_android_gms_internal_zznj_zza = (zza) this.zzVc.zzVb.get(this.zztf);
            zzni zzjC = (com_google_android_gms_internal_zznj_zza == null || com_google_android_gms_internal_zznj_zza.hasExpired() || !((Boolean) zzgd.zzDv.get()).booleanValue()) ? new com.google.android.gms.internal.zzni.zza(this.zztf).zzjC() : new com.google.android.gms.internal.zzni.zza(this.zztf, com_google_android_gms_internal_zznj_zza.zzVe).zzjC();
            this.zzVc.zzVb.put(this.zztf, new zza(this.zzVc, zzjC));
            return zzjC;
        }
    }

    private class zza {
        public final long zzVd;
        public final zzni zzVe;

        public zza(zznj com_google_android_gms_internal_zznj, zzni com_google_android_gms_internal_zzni) {
            this.zzVd = zzw.zzcS().currentTimeMillis();
            this.zzVe = com_google_android_gms_internal_zzni;
        }

        public boolean hasExpired() {
            return ((Long) zzgd.zzDw.get()).longValue() + this.zzVd < zzw.zzcS().currentTimeMillis();
        }
    }

    public zznj() {
        this.zzVb = new WeakHashMap();
    }

    public Future<zzni> zzA(Context context) {
        return zzpn.zza(new C13361(this, context));
    }
}
