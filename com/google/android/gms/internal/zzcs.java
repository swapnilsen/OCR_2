package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.internal.zzct.zza;
import com.google.android.gms.internal.zzct.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@zzme
public class zzcs implements zzcu {
    private final Object zzrJ;
    private final zzqh zztt;
    private final WeakHashMap<zzpb, zzct> zzwg;
    private final ArrayList<zzct> zzwh;
    private final Context zzwi;
    private final zzji zzwj;

    public zzcs(Context context, zzqh com_google_android_gms_internal_zzqh, zzji com_google_android_gms_internal_zzji) {
        this.zzrJ = new Object();
        this.zzwg = new WeakHashMap();
        this.zzwh = new ArrayList();
        this.zzwi = context.getApplicationContext();
        this.zztt = com_google_android_gms_internal_zzqh;
        this.zzwj = com_google_android_gms_internal_zzji;
    }

    public void zza(zzct com_google_android_gms_internal_zzct) {
        synchronized (this.zzrJ) {
            if (!com_google_android_gms_internal_zzct.zzdJ()) {
                this.zzwh.remove(com_google_android_gms_internal_zzct);
                Iterator it = this.zzwg.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == com_google_android_gms_internal_zzct) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg, zzpb com_google_android_gms_internal_zzpb) {
        zza(com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzpb, com_google_android_gms_internal_zzpb.zzNH.getView());
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg, zzpb com_google_android_gms_internal_zzpb, View view) {
        zza(com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzpb, new zzd(view, com_google_android_gms_internal_zzpb), null);
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg, zzpb com_google_android_gms_internal_zzpb, View view, zzjj com_google_android_gms_internal_zzjj) {
        zza(com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzpb, new zzd(view, com_google_android_gms_internal_zzpb), com_google_android_gms_internal_zzjj);
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg, zzpb com_google_android_gms_internal_zzpb, zzda com_google_android_gms_internal_zzda, @Nullable zzjj com_google_android_gms_internal_zzjj) {
        synchronized (this.zzrJ) {
            zzct com_google_android_gms_internal_zzct;
            if (zzi(com_google_android_gms_internal_zzpb)) {
                com_google_android_gms_internal_zzct = (zzct) this.zzwg.get(com_google_android_gms_internal_zzpb);
            } else {
                com_google_android_gms_internal_zzct = new zzct(this.zzwi, com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzpb, this.zztt, com_google_android_gms_internal_zzda);
                com_google_android_gms_internal_zzct.zza((zzcu) this);
                this.zzwg.put(com_google_android_gms_internal_zzpb, com_google_android_gms_internal_zzct);
                this.zzwh.add(com_google_android_gms_internal_zzct);
            }
            if (com_google_android_gms_internal_zzjj != null) {
                com_google_android_gms_internal_zzct.zza(new zzcv(com_google_android_gms_internal_zzct, com_google_android_gms_internal_zzjj));
            } else {
                com_google_android_gms_internal_zzct.zza(new zzcw(com_google_android_gms_internal_zzct, this.zzwj));
            }
        }
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg, zzpb com_google_android_gms_internal_zzpb, zzha com_google_android_gms_internal_zzha) {
        zza(com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzpb, new zza(com_google_android_gms_internal_zzha), null);
    }

    public boolean zzi(zzpb com_google_android_gms_internal_zzpb) {
        boolean z;
        synchronized (this.zzrJ) {
            zzct com_google_android_gms_internal_zzct = (zzct) this.zzwg.get(com_google_android_gms_internal_zzpb);
            z = com_google_android_gms_internal_zzct != null && com_google_android_gms_internal_zzct.zzdJ();
        }
        return z;
    }

    public void zzj(zzpb com_google_android_gms_internal_zzpb) {
        synchronized (this.zzrJ) {
            zzct com_google_android_gms_internal_zzct = (zzct) this.zzwg.get(com_google_android_gms_internal_zzpb);
            if (com_google_android_gms_internal_zzct != null) {
                com_google_android_gms_internal_zzct.zzdH();
            }
        }
    }

    public void zzk(zzpb com_google_android_gms_internal_zzpb) {
        synchronized (this.zzrJ) {
            zzct com_google_android_gms_internal_zzct = (zzct) this.zzwg.get(com_google_android_gms_internal_zzpb);
            if (com_google_android_gms_internal_zzct != null) {
                com_google_android_gms_internal_zzct.stop();
            }
        }
    }

    public void zzl(zzpb com_google_android_gms_internal_zzpb) {
        synchronized (this.zzrJ) {
            zzct com_google_android_gms_internal_zzct = (zzct) this.zzwg.get(com_google_android_gms_internal_zzpb);
            if (com_google_android_gms_internal_zzct != null) {
                com_google_android_gms_internal_zzct.pause();
            }
        }
    }

    public void zzm(zzpb com_google_android_gms_internal_zzpb) {
        synchronized (this.zzrJ) {
            zzct com_google_android_gms_internal_zzct = (zzct) this.zzwg.get(com_google_android_gms_internal_zzpb);
            if (com_google_android_gms_internal_zzct != null) {
                com_google_android_gms_internal_zzct.resume();
            }
        }
    }
}
