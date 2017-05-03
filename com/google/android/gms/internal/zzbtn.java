package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzbts.zza;
import com.google.android.gms.internal.zzbts.zzb;
import com.google.android.gms.internal.zzbts.zzc;
import com.google.android.gms.internal.zzbts.zzd;
import com.google.android.gms.internal.zzbts.zze;
import com.google.android.gms.internal.zzbts.zzf;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class zzbtn implements Runnable {
    public final Context mContext;
    public final zzbtr zzclY;
    public final zzbto zzcmg;
    public final zzbto zzcmh;
    public final zzbto zzcmi;

    public zzbtn(Context context, zzbto com_google_android_gms_internal_zzbto, zzbto com_google_android_gms_internal_zzbto2, zzbto com_google_android_gms_internal_zzbto3, zzbtr com_google_android_gms_internal_zzbtr) {
        this.mContext = context;
        this.zzcmg = com_google_android_gms_internal_zzbto;
        this.zzcmh = com_google_android_gms_internal_zzbto2;
        this.zzcmi = com_google_android_gms_internal_zzbto3;
        this.zzclY = com_google_android_gms_internal_zzbtr;
    }

    private zza zza(zzbto com_google_android_gms_internal_zzbto) {
        zza com_google_android_gms_internal_zzbts_zza = new zza();
        if (com_google_android_gms_internal_zzbto.zzacf() != null) {
            Map zzacf = com_google_android_gms_internal_zzbto.zzacf();
            List arrayList = new ArrayList();
            for (String str : zzacf.keySet()) {
                List arrayList2 = new ArrayList();
                Map map = (Map) zzacf.get(str);
                for (String str2 : map.keySet()) {
                    zzb com_google_android_gms_internal_zzbts_zzb = new zzb();
                    com_google_android_gms_internal_zzbts_zzb.zzaB = str2;
                    com_google_android_gms_internal_zzbts_zzb.zzcmt = (byte[]) map.get(str2);
                    arrayList2.add(com_google_android_gms_internal_zzbts_zzb);
                }
                zzd com_google_android_gms_internal_zzbts_zzd = new zzd();
                com_google_android_gms_internal_zzbts_zzd.zzaGP = str;
                com_google_android_gms_internal_zzbts_zzd.zzcmy = (zzb[]) arrayList2.toArray(new zzb[arrayList2.size()]);
                arrayList.add(com_google_android_gms_internal_zzbts_zzd);
            }
            com_google_android_gms_internal_zzbts_zza.zzcmq = (zzd[]) arrayList.toArray(new zzd[arrayList.size()]);
        }
        if (com_google_android_gms_internal_zzbto.zzzE() != null) {
            List zzzE = com_google_android_gms_internal_zzbto.zzzE();
            com_google_android_gms_internal_zzbts_zza.zzcmr = (byte[][]) zzzE.toArray(new byte[zzzE.size()][]);
        }
        com_google_android_gms_internal_zzbts_zza.timestamp = com_google_android_gms_internal_zzbto.getTimestamp();
        return com_google_android_gms_internal_zzbts_zza;
    }

    public void run() {
        zzbxt com_google_android_gms_internal_zzbts_zze = new zze();
        if (this.zzcmg != null) {
            com_google_android_gms_internal_zzbts_zze.zzcmz = zza(this.zzcmg);
        }
        if (this.zzcmh != null) {
            com_google_android_gms_internal_zzbts_zze.zzcmA = zza(this.zzcmh);
        }
        if (this.zzcmi != null) {
            com_google_android_gms_internal_zzbts_zze.zzcmB = zza(this.zzcmi);
        }
        if (this.zzclY != null) {
            zzc com_google_android_gms_internal_zzbts_zzc = new zzc();
            com_google_android_gms_internal_zzbts_zzc.zzcmu = this.zzclY.getLastFetchStatus();
            com_google_android_gms_internal_zzbts_zzc.zzcmv = this.zzclY.isDeveloperModeEnabled();
            com_google_android_gms_internal_zzbts_zzc.zzcmw = this.zzclY.zzack();
            com_google_android_gms_internal_zzbts_zze.zzcmC = com_google_android_gms_internal_zzbts_zzc;
        }
        if (!(this.zzclY == null || this.zzclY.zzaci() == null)) {
            List arrayList = new ArrayList();
            Map zzaci = this.zzclY.zzaci();
            for (String str : zzaci.keySet()) {
                if (zzaci.get(str) != null) {
                    zzf com_google_android_gms_internal_zzbts_zzf = new zzf();
                    com_google_android_gms_internal_zzbts_zzf.zzaGP = str;
                    com_google_android_gms_internal_zzbts_zzf.zzcmF = ((zzbtl) zzaci.get(str)).zzace();
                    com_google_android_gms_internal_zzbts_zzf.resourceId = ((zzbtl) zzaci.get(str)).zzacd();
                    arrayList.add(com_google_android_gms_internal_zzbts_zzf);
                }
            }
            com_google_android_gms_internal_zzbts_zze.zzcmD = (zzf[]) arrayList.toArray(new zzf[arrayList.size()]);
        }
        byte[] zzf = zzbxt.zzf(com_google_android_gms_internal_zzbts_zze);
        try {
            FileOutputStream openFileOutput = this.mContext.openFileOutput("persisted_config", 0);
            openFileOutput.write(zzf);
            openFileOutput.close();
        } catch (Throwable e) {
            Log.e("AsyncPersisterTask", "Could not persist config.", e);
        }
    }
}
