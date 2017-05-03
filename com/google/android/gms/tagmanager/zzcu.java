package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcu implements zze {
    private boolean mClosed;
    private final Context mContext;
    private final String zzbEU;
    private String zzbFs;
    private zzbn<zzj> zzbHt;
    private zzt zzbHu;
    private final ScheduledExecutorService zzbHw;
    private final zza zzbHx;
    private ScheduledFuture<?> zzbHy;

    interface zzb {
        ScheduledExecutorService zzRl();
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcu.1 */
    class C14461 implements zzb {
        C14461(zzcu com_google_android_gms_tagmanager_zzcu) {
        }

        public ScheduledExecutorService zzRl() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    interface zza {
        zzct zza(zzt com_google_android_gms_tagmanager_zzt);
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcu.2 */
    class C14472 implements zza {
        final /* synthetic */ zzcu zzbHz;

        C14472(zzcu com_google_android_gms_tagmanager_zzcu) {
            this.zzbHz = com_google_android_gms_tagmanager_zzcu;
        }

        public zzct zza(zzt com_google_android_gms_tagmanager_zzt) {
            return new zzct(this.zzbHz.mContext, this.zzbHz.zzbEU, com_google_android_gms_tagmanager_zzt);
        }
    }

    public zzcu(Context context, String str, zzt com_google_android_gms_tagmanager_zzt) {
        this(context, str, com_google_android_gms_tagmanager_zzt, null, null);
    }

    zzcu(Context context, String str, zzt com_google_android_gms_tagmanager_zzt, zzb com_google_android_gms_tagmanager_zzcu_zzb, zza com_google_android_gms_tagmanager_zzcu_zza) {
        this.zzbHu = com_google_android_gms_tagmanager_zzt;
        this.mContext = context;
        this.zzbEU = str;
        if (com_google_android_gms_tagmanager_zzcu_zzb == null) {
            com_google_android_gms_tagmanager_zzcu_zzb = new C14461(this);
        }
        this.zzbHw = com_google_android_gms_tagmanager_zzcu_zzb.zzRl();
        if (com_google_android_gms_tagmanager_zzcu_zza == null) {
            this.zzbHx = new C14472(this);
        } else {
            this.zzbHx = com_google_android_gms_tagmanager_zzcu_zza;
        }
    }

    private synchronized void zzRk() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    private zzct zzhp(String str) {
        zzct zza = this.zzbHx.zza(this.zzbHu);
        zza.zza(this.zzbHt);
        zza.zzgZ(this.zzbFs);
        zza.zzho(str);
        return zza;
    }

    public synchronized void release() {
        zzRk();
        if (this.zzbHy != null) {
            this.zzbHy.cancel(false);
        }
        this.zzbHw.shutdown();
        this.mClosed = true;
    }

    public synchronized void zza(zzbn<zzj> com_google_android_gms_tagmanager_zzbn_com_google_android_gms_internal_zzaj_zzj) {
        zzRk();
        this.zzbHt = com_google_android_gms_tagmanager_zzbn_com_google_android_gms_internal_zzaj_zzj;
    }

    public synchronized void zzf(long j, String str) {
        String str2 = this.zzbEU;
        zzbo.m4712v(new StringBuilder(String.valueOf(str2).length() + 55).append("loadAfterDelay: containerId=").append(str2).append(" delay=").append(j).toString());
        zzRk();
        if (this.zzbHt == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.zzbHy != null) {
            this.zzbHy.cancel(false);
        }
        this.zzbHy = this.zzbHw.schedule(zzhp(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void zzgZ(String str) {
        zzRk();
        this.zzbFs = str;
    }
}
