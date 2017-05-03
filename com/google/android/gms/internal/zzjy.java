package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

@zzme
public class zzjy implements zzjp {
    private final Context mContext;
    private final zzjr zzKY;
    private final boolean zzLa;
    private final zzmk zzLo;
    private final long zzLp;
    private final long zzLq;
    private boolean zzLs;
    private List<zzjv> zzLu;
    private zzju zzLy;
    private final Object zzrJ;
    private final zzgl zzsn;
    private final zzka zzsz;
    private final boolean zzwf;

    /* renamed from: com.google.android.gms.internal.zzjy.1 */
    class C12701 implements Runnable {
        final /* synthetic */ zzjv zzLz;

        C12701(zzjy com_google_android_gms_internal_zzjy, zzjv com_google_android_gms_internal_zzjv) {
            this.zzLz = com_google_android_gms_internal_zzjv;
        }

        public void run() {
            try {
                this.zzLz.zzLj.destroy();
            } catch (Throwable e) {
                zzqf.zzc("Could not destroy mediation adapter.", e);
            }
        }
    }

    public zzjy(Context context, zzmk com_google_android_gms_internal_zzmk, zzka com_google_android_gms_internal_zzka, zzjr com_google_android_gms_internal_zzjr, boolean z, boolean z2, long j, long j2, zzgl com_google_android_gms_internal_zzgl) {
        this.zzrJ = new Object();
        this.zzLs = false;
        this.zzLu = new ArrayList();
        this.mContext = context;
        this.zzLo = com_google_android_gms_internal_zzmk;
        this.zzsz = com_google_android_gms_internal_zzka;
        this.zzKY = com_google_android_gms_internal_zzjr;
        this.zzwf = z;
        this.zzLa = z2;
        this.zzLp = j;
        this.zzLq = j2;
        this.zzsn = com_google_android_gms_internal_zzgl;
    }

    public void cancel() {
        synchronized (this.zzrJ) {
            this.zzLs = true;
            if (this.zzLy != null) {
                this.zzLy.cancel();
            }
        }
    }

    public zzjv zzd(List<zzjq> list) {
        zzqf.zzbf("Starting mediation.");
        Iterable arrayList = new ArrayList();
        zzgj zzfB = this.zzsn.zzfB();
        for (zzjq com_google_android_gms_internal_zzjq : list) {
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(com_google_android_gms_internal_zzjq.zzKo);
            zzqf.zzbg(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            for (String str2 : com_google_android_gms_internal_zzjq.zzKp) {
                zzgj zzfB2 = this.zzsn.zzfB();
                synchronized (this.zzrJ) {
                    if (this.zzLs) {
                        zzjv com_google_android_gms_internal_zzjv = new zzjv(-1);
                        return com_google_android_gms_internal_zzjv;
                    }
                    this.zzLy = new zzju(this.mContext, str2, this.zzsz, this.zzKY, com_google_android_gms_internal_zzjq, this.zzLo.zzRy, this.zzLo.zzvr, this.zzLo.zzvn, this.zzwf, this.zzLa, this.zzLo.zzvF, this.zzLo.zzvK);
                    com_google_android_gms_internal_zzjv = this.zzLy.zza(this.zzLp, this.zzLq);
                    this.zzLu.add(com_google_android_gms_internal_zzjv);
                    if (com_google_android_gms_internal_zzjv.zzLh == 0) {
                        zzqf.zzbf("Adapter succeeded.");
                        this.zzsn.zzh("mediation_network_succeed", str2);
                        if (!arrayList.isEmpty()) {
                            this.zzsn.zzh("mediation_networks_fail", TextUtils.join(",", arrayList));
                        }
                        this.zzsn.zza(zzfB2, "mls");
                        this.zzsn.zza(zzfB, "ttm");
                        return com_google_android_gms_internal_zzjv;
                    }
                    arrayList.add(str2);
                    this.zzsn.zza(zzfB2, "mlf");
                    if (com_google_android_gms_internal_zzjv.zzLj != null) {
                        zzpo.zzXC.post(new C12701(this, com_google_android_gms_internal_zzjv));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzsn.zzh("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new zzjv(1);
    }

    public List<zzjv> zzgU() {
        return this.zzLu;
    }
}
