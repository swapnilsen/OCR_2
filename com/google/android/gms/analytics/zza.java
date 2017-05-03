package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzsc;
import java.util.ListIterator;

public class zza extends zzg<zza> {
    private final zzsc zzabn;
    private boolean zzabo;

    public zza(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc.zznU(), com_google_android_gms_internal_zzsc.zznR());
        this.zzabn = com_google_android_gms_internal_zzsc;
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.zzabo = z;
    }

    protected void zza(zze com_google_android_gms_analytics_zze) {
        zzrt com_google_android_gms_internal_zzrt = (zzrt) com_google_android_gms_analytics_zze.zzb(zzrt.class);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzrt.zzmy())) {
            com_google_android_gms_internal_zzrt.setClientId(this.zzabn.zzoi().zzoQ());
        }
        if (this.zzabo && TextUtils.isEmpty(com_google_android_gms_internal_zzrt.zznv())) {
            zzrx zzoh = this.zzabn.zzoh();
            com_google_android_gms_internal_zzrt.zzbF(zzoh.zznG());
            com_google_android_gms_internal_zzrt.zzS(zzoh.zznw());
        }
    }

    public void zzbo(String str) {
        zzac.zzdr(str);
        zzbp(str);
        zzmO().add(new zzb(this.zzabn, str));
    }

    public void zzbp(String str) {
        Uri zzbq = zzb.zzbq(str);
        ListIterator listIterator = zzmO().listIterator();
        while (listIterator.hasNext()) {
            if (zzbq.equals(((zzi) listIterator.next()).zzmr())) {
                listIterator.remove();
            }
        }
    }

    zzsc zzmn() {
        return this.zzabn;
    }

    public zze zzmo() {
        zze zzmC = zzmN().zzmC();
        zzmC.zza(this.zzabn.zznZ().zzoy());
        zzmC.zza(this.zzabn.zzoa().zzpB());
        zzd(zzmC);
        return zzmC;
    }
}
