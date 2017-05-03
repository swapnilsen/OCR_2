package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

@zzme
public final class zzoz implements zzpa {

    /* renamed from: com.google.android.gms.internal.zzoz.1 */
    class C13441 implements Runnable {
        final /* synthetic */ zzqj zzVZ;
        final /* synthetic */ Context zztf;

        C13441(zzoz com_google_android_gms_internal_zzoz, Context context, zzqj com_google_android_gms_internal_zzqj) {
            this.zztf = context;
            this.zzVZ = com_google_android_gms_internal_zzqj;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r2 = this;
            r0 = r2.zztf;	 Catch:{ IOException -> 0x001c, IllegalStateException -> 0x0018, GooglePlayServicesNotAvailableException -> 0x001a, GooglePlayServicesRepairableException -> 0x000c }
            r0 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r0);	 Catch:{ IOException -> 0x001c, IllegalStateException -> 0x0018, GooglePlayServicesNotAvailableException -> 0x001a, GooglePlayServicesRepairableException -> 0x000c }
            r1 = r2.zzVZ;	 Catch:{ IOException -> 0x001c, IllegalStateException -> 0x0018, GooglePlayServicesNotAvailableException -> 0x001a, GooglePlayServicesRepairableException -> 0x000c }
            r1.zzh(r0);	 Catch:{ IOException -> 0x001c, IllegalStateException -> 0x0018, GooglePlayServicesNotAvailableException -> 0x001a, GooglePlayServicesRepairableException -> 0x000c }
        L_0x000b:
            return;
        L_0x000c:
            r0 = move-exception;
        L_0x000d:
            r1 = r2.zzVZ;
            r1.zze(r0);
            r1 = "Exception while getting advertising Id info";
            com.google.android.gms.internal.zzqf.zzb(r1, r0);
            goto L_0x000b;
        L_0x0018:
            r0 = move-exception;
            goto L_0x000d;
        L_0x001a:
            r0 = move-exception;
            goto L_0x000d;
        L_0x001c:
            r0 = move-exception;
            goto L_0x000d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzoz.1.run():void");
        }
    }

    public zzqm<Info> zzG(Context context) {
        zzqm com_google_android_gms_internal_zzqj = new zzqj();
        if (zzel.zzeT().zzag(context)) {
            zzpn.zza(new C13441(this, context, com_google_android_gms_internal_zzqj));
        }
        return com_google_android_gms_internal_zzqj;
    }

    public zzqm<String> zzg(zzmk com_google_android_gms_internal_zzmk) {
        return new zzqk(com_google_android_gms_internal_zzmk.zzRA);
    }
}
