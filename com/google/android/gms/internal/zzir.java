package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzme
public class zzir implements Iterable<zziq> {
    private final List<zziq> zzIz;

    public zzir() {
        this.zzIz = new LinkedList();
    }

    private zziq zzg(zzqw com_google_android_gms_internal_zzqw) {
        Iterator it = zzw.zzdj().iterator();
        while (it.hasNext()) {
            zziq com_google_android_gms_internal_zziq = (zziq) it.next();
            if (com_google_android_gms_internal_zziq.zzIs == com_google_android_gms_internal_zzqw) {
                return com_google_android_gms_internal_zziq;
            }
        }
        return null;
    }

    public Iterator<zziq> iterator() {
        return this.zzIz.iterator();
    }

    public void zza(zziq com_google_android_gms_internal_zziq) {
        this.zzIz.add(com_google_android_gms_internal_zziq);
    }

    public void zzb(zziq com_google_android_gms_internal_zziq) {
        this.zzIz.remove(com_google_android_gms_internal_zziq);
    }

    public boolean zze(zzqw com_google_android_gms_internal_zzqw) {
        zziq zzg = zzg(com_google_android_gms_internal_zzqw);
        if (zzg == null) {
            return false;
        }
        zzg.zzIw.abort();
        return true;
    }

    public boolean zzf(zzqw com_google_android_gms_internal_zzqw) {
        return zzg(com_google_android_gms_internal_zzqw) != null;
    }

    public int zzgr() {
        return this.zzIz.size();
    }
}
