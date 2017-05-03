package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzme
public class zzdc {
    private final Object zzrJ;
    private int zzxE;
    private List<zzdb> zzxF;

    public zzdc() {
        this.zzrJ = new Object();
        this.zzxF = new LinkedList();
    }

    public boolean zza(zzdb com_google_android_gms_internal_zzdb) {
        boolean z;
        synchronized (this.zzrJ) {
            if (this.zzxF.contains(com_google_android_gms_internal_zzdb)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean zzb(zzdb com_google_android_gms_internal_zzdb) {
        synchronized (this.zzrJ) {
            Iterator it = this.zzxF.iterator();
            while (it.hasNext()) {
                zzdb com_google_android_gms_internal_zzdb2 = (zzdb) it.next();
                if (!((Boolean) zzgd.zzCi.get()).booleanValue() || zzw.zzcQ().zzkg()) {
                    if (((Boolean) zzgd.zzCk.get()).booleanValue() && !zzw.zzcQ().zzkh() && com_google_android_gms_internal_zzdb != com_google_android_gms_internal_zzdb2 && com_google_android_gms_internal_zzdb2.zzec().equals(com_google_android_gms_internal_zzdb.zzec())) {
                        it.remove();
                        return true;
                    }
                } else if (com_google_android_gms_internal_zzdb != com_google_android_gms_internal_zzdb2 && com_google_android_gms_internal_zzdb2.zzea().equals(com_google_android_gms_internal_zzdb.zzea())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public void zzc(zzdb com_google_android_gms_internal_zzdb) {
        synchronized (this.zzrJ) {
            if (this.zzxF.size() >= 10) {
                zzqf.zzbf("Queue is full, current size = " + this.zzxF.size());
                this.zzxF.remove(0);
            }
            int i = this.zzxE;
            this.zzxE = i + 1;
            com_google_android_gms_internal_zzdb.zzn(i);
            this.zzxF.add(com_google_android_gms_internal_zzdb);
        }
    }

    @Nullable
    public zzdb zzei() {
        zzdb com_google_android_gms_internal_zzdb = null;
        int i = 0;
        synchronized (this.zzrJ) {
            if (this.zzxF.size() == 0) {
                zzqf.zzbf("Queue empty");
                return null;
            } else if (this.zzxF.size() >= 2) {
                int i2 = RtlSpacingHelper.UNDEFINED;
                int i3 = 0;
                for (zzdb com_google_android_gms_internal_zzdb2 : this.zzxF) {
                    zzdb com_google_android_gms_internal_zzdb3;
                    int i4;
                    int score = com_google_android_gms_internal_zzdb2.getScore();
                    if (score > i2) {
                        i = score;
                        com_google_android_gms_internal_zzdb3 = com_google_android_gms_internal_zzdb2;
                        i4 = i3;
                    } else {
                        i4 = i;
                        com_google_android_gms_internal_zzdb3 = com_google_android_gms_internal_zzdb;
                        i = i2;
                    }
                    i3++;
                    i2 = i;
                    com_google_android_gms_internal_zzdb = com_google_android_gms_internal_zzdb3;
                    i = i4;
                }
                this.zzxF.remove(i);
                return com_google_android_gms_internal_zzdb;
            } else {
                com_google_android_gms_internal_zzdb2 = (zzdb) this.zzxF.get(0);
                com_google_android_gms_internal_zzdb2.zzed();
                return com_google_android_gms_internal_zzdb2;
            }
        }
    }
}
