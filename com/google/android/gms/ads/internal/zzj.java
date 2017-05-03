package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzar;
import com.google.android.gms.internal.zzav;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzqf;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzme
class zzj implements zzar, Runnable {
    private zzx zzss;
    private final List<Object[]> zzth;
    private final AtomicReference<zzar> zzti;
    CountDownLatch zztj;

    public zzj(zzx com_google_android_gms_ads_internal_zzx) {
        this.zzth = new Vector();
        this.zzti = new AtomicReference();
        this.zztj = new CountDownLatch(1);
        this.zzss = com_google_android_gms_ads_internal_zzx;
        if (zzel.zzeT().zzlj()) {
            zzpn.zza((Runnable) this);
        } else {
            run();
        }
    }

    private void zzch() {
        if (!this.zzth.isEmpty()) {
            for (Object[] objArr : this.zzth) {
                if (objArr.length == 1) {
                    ((zzar) this.zzti.get()).zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzar) this.zzti.get()).zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzth.clear();
        }
    }

    private Context zzg(Context context) {
        if (!((Boolean) zzgd.zzBs.get()).booleanValue()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    public void run() {
        try {
            Object obj = (this.zzss.zzvn.zzYY || !((Boolean) zzgd.zzBO.get()).booleanValue()) ? 1 : null;
            boolean z = (((Boolean) zzgd.zzCU.get()).booleanValue() || obj == null) ? false : true;
            zza(zzd(this.zzss.zzvn.zzba, zzg(this.zzss.zzqn), z));
        } finally {
            this.zztj.countDown();
            this.zzss = null;
        }
    }

    public String zza(Context context, String str, View view) {
        if (zzcg()) {
            zzar com_google_android_gms_internal_zzar = (zzar) this.zzti.get();
            if (com_google_android_gms_internal_zzar != null) {
                zzch();
                return com_google_android_gms_internal_zzar.zza(zzg(context), str, view);
            }
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public String zza(Context context, byte[] bArr) {
        if (zzcg()) {
            zzar com_google_android_gms_internal_zzar = (zzar) this.zzti.get();
            if (com_google_android_gms_internal_zzar != null) {
                zzch();
                return com_google_android_gms_internal_zzar.zzb(zzg(context));
            }
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public void zza(int i, int i2, int i3) {
        zzar com_google_android_gms_internal_zzar = (zzar) this.zzti.get();
        if (com_google_android_gms_internal_zzar != null) {
            zzch();
            com_google_android_gms_internal_zzar.zza(i, i2, i3);
            return;
        }
        this.zzth.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void zza(MotionEvent motionEvent) {
        zzar com_google_android_gms_internal_zzar = (zzar) this.zzti.get();
        if (com_google_android_gms_internal_zzar != null) {
            zzch();
            com_google_android_gms_internal_zzar.zza(motionEvent);
            return;
        }
        this.zzth.add(new Object[]{motionEvent});
    }

    protected void zza(zzar com_google_android_gms_internal_zzar) {
        this.zzti.set(com_google_android_gms_internal_zzar);
    }

    public String zzb(Context context) {
        return zza(context, null);
    }

    protected boolean zzcg() {
        try {
            this.zztj.await();
            return true;
        } catch (Throwable e) {
            zzqf.zzc("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    protected zzar zzd(String str, Context context, boolean z) {
        return zzav.zza(str, context, z);
    }
}
