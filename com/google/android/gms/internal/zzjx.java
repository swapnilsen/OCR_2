package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzw;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzme
public class zzjx implements zzjp {
    private final Context mContext;
    private final zzjr zzKY;
    private final boolean zzLa;
    private final zzmk zzLo;
    private final long zzLp;
    private final long zzLq;
    private final int zzLr;
    private boolean zzLs;
    private final Map<zzqm<zzjv>, zzju> zzLt;
    private List<zzjv> zzLu;
    private final Object zzrJ;
    private final zzka zzsz;
    private final boolean zzwf;

    /* renamed from: com.google.android.gms.internal.zzjx.1 */
    class C12681 implements Callable<zzjv> {
        final /* synthetic */ zzju zzLv;
        final /* synthetic */ zzjx zzLw;

        C12681(zzjx com_google_android_gms_internal_zzjx, zzju com_google_android_gms_internal_zzju) {
            this.zzLw = com_google_android_gms_internal_zzjx;
            this.zzLv = com_google_android_gms_internal_zzju;
        }

        public /* synthetic */ Object call() {
            return zzhb();
        }

        public zzjv zzhb() {
            synchronized (this.zzLw.zzrJ) {
                if (this.zzLw.zzLs) {
                    return null;
                }
                return this.zzLv.zza(this.zzLw.zzLp, this.zzLw.zzLq);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjx.2 */
    class C12692 implements Runnable {
        final /* synthetic */ zzjx zzLw;
        final /* synthetic */ zzqm zzLx;

        C12692(zzjx com_google_android_gms_internal_zzjx, zzqm com_google_android_gms_internal_zzqm) {
            this.zzLw = com_google_android_gms_internal_zzjx;
            this.zzLx = com_google_android_gms_internal_zzqm;
        }

        public void run() {
            for (zzqm com_google_android_gms_internal_zzqm : this.zzLw.zzLt.keySet()) {
                if (com_google_android_gms_internal_zzqm != this.zzLx) {
                    ((zzju) this.zzLw.zzLt.get(com_google_android_gms_internal_zzqm)).cancel();
                }
            }
        }
    }

    public zzjx(Context context, zzmk com_google_android_gms_internal_zzmk, zzka com_google_android_gms_internal_zzka, zzjr com_google_android_gms_internal_zzjr, boolean z, boolean z2, long j, long j2, int i) {
        this.zzrJ = new Object();
        this.zzLs = false;
        this.zzLt = new HashMap();
        this.zzLu = new ArrayList();
        this.mContext = context;
        this.zzLo = com_google_android_gms_internal_zzmk;
        this.zzsz = com_google_android_gms_internal_zzka;
        this.zzKY = com_google_android_gms_internal_zzjr;
        this.zzwf = z;
        this.zzLa = z2;
        this.zzLp = j;
        this.zzLq = j2;
        this.zzLr = i;
    }

    private void zza(zzqm<zzjv> com_google_android_gms_internal_zzqm_com_google_android_gms_internal_zzjv) {
        zzpo.zzXC.post(new C12692(this, com_google_android_gms_internal_zzqm_com_google_android_gms_internal_zzjv));
    }

    private zzjv zze(List<zzqm<zzjv>> list) {
        Throwable e;
        synchronized (this.zzrJ) {
            if (this.zzLs) {
                zzjv com_google_android_gms_internal_zzjv = new zzjv(-1);
                return com_google_android_gms_internal_zzjv;
            }
            for (zzqm com_google_android_gms_internal_zzqm : list) {
                try {
                    com_google_android_gms_internal_zzjv = (zzjv) com_google_android_gms_internal_zzqm.get();
                    this.zzLu.add(com_google_android_gms_internal_zzjv);
                    if (com_google_android_gms_internal_zzjv != null && com_google_android_gms_internal_zzjv.zzLh == 0) {
                        zza(com_google_android_gms_internal_zzqm);
                        return com_google_android_gms_internal_zzjv;
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    zzqf.zzc("Exception while processing an adapter; continuing with other adapters", e);
                } catch (ExecutionException e3) {
                    e = e3;
                    zzqf.zzc("Exception while processing an adapter; continuing with other adapters", e);
                }
            }
            zza(null);
            return new zzjv(1);
        }
    }

    private zzjv zzf(List<zzqm<zzjv>> list) {
        synchronized (this.zzrJ) {
            if (this.zzLs) {
                zzjv com_google_android_gms_internal_zzjv = new zzjv(-1);
                return com_google_android_gms_internal_zzjv;
            }
            long j = -1;
            zzqm com_google_android_gms_internal_zzqm = null;
            com_google_android_gms_internal_zzjv = null;
            long j2 = this.zzKY.zzKP != -1 ? this.zzKY.zzKP : 10000;
            long j3 = j2;
            for (zzqm com_google_android_gms_internal_zzqm2 : list) {
                zzjv com_google_android_gms_internal_zzjv2;
                zzkd com_google_android_gms_internal_zzkd;
                int zzha;
                zzjv com_google_android_gms_internal_zzjv3;
                zzqm com_google_android_gms_internal_zzqm3;
                zzjv com_google_android_gms_internal_zzjv4;
                RemoteException max;
                long currentTimeMillis = zzw.zzcS().currentTimeMillis();
                if (j3 == 0) {
                    try {
                        if (com_google_android_gms_internal_zzqm2.isDone()) {
                            com_google_android_gms_internal_zzjv2 = (zzjv) com_google_android_gms_internal_zzqm2.get();
                            this.zzLu.add(com_google_android_gms_internal_zzjv2);
                            if (com_google_android_gms_internal_zzjv2 != null && com_google_android_gms_internal_zzjv2.zzLh == 0) {
                                com_google_android_gms_internal_zzkd = com_google_android_gms_internal_zzjv2.zzLm;
                                if (com_google_android_gms_internal_zzkd != null && com_google_android_gms_internal_zzkd.zzha() > j) {
                                    zzha = com_google_android_gms_internal_zzkd.zzha();
                                    com_google_android_gms_internal_zzjv3 = com_google_android_gms_internal_zzjv2;
                                    com_google_android_gms_internal_zzqm3 = com_google_android_gms_internal_zzqm2;
                                    com_google_android_gms_internal_zzjv4 = com_google_android_gms_internal_zzjv3;
                                    com_google_android_gms_internal_zzqm = com_google_android_gms_internal_zzqm3;
                                    com_google_android_gms_internal_zzjv3 = com_google_android_gms_internal_zzjv4;
                                    max = Math.max(j3 - (zzw.zzcS().currentTimeMillis() - currentTimeMillis), 0);
                                    j = zzha;
                                    com_google_android_gms_internal_zzjv = com_google_android_gms_internal_zzjv3;
                                    j3 = max;
                                }
                            }
                            com_google_android_gms_internal_zzjv4 = com_google_android_gms_internal_zzjv;
                            com_google_android_gms_internal_zzqm3 = com_google_android_gms_internal_zzqm;
                            zzha = j;
                            com_google_android_gms_internal_zzqm = com_google_android_gms_internal_zzqm3;
                            com_google_android_gms_internal_zzjv3 = com_google_android_gms_internal_zzjv4;
                            max = Math.max(j3 - (zzw.zzcS().currentTimeMillis() - currentTimeMillis), 0);
                            j = zzha;
                            com_google_android_gms_internal_zzjv = com_google_android_gms_internal_zzjv3;
                            j3 = max;
                        }
                    } catch (InterruptedException e) {
                        max = e;
                        try {
                            zzqf.zzc("Exception while processing an adapter; continuing with other adapters", max);
                            j3 = max;
                        } finally {
                            com_google_android_gms_internal_zzjv = j3 - (zzw.zzcS().currentTimeMillis() - currentTimeMillis);
                            j = 0;
                            Math.max(com_google_android_gms_internal_zzjv, j);
                            j = j3;
                        }
                    } catch (ExecutionException e2) {
                        max = e2;
                        zzqf.zzc("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    } catch (RemoteException e3) {
                        max = e3;
                        zzqf.zzc("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    } catch (TimeoutException e4) {
                        max = e4;
                        zzqf.zzc("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    }
                }
                com_google_android_gms_internal_zzjv2 = (zzjv) com_google_android_gms_internal_zzqm2.get(j3, TimeUnit.MILLISECONDS);
                this.zzLu.add(com_google_android_gms_internal_zzjv2);
                com_google_android_gms_internal_zzkd = com_google_android_gms_internal_zzjv2.zzLm;
                zzha = com_google_android_gms_internal_zzkd.zzha();
                com_google_android_gms_internal_zzjv3 = com_google_android_gms_internal_zzjv2;
                com_google_android_gms_internal_zzqm3 = com_google_android_gms_internal_zzqm2;
                com_google_android_gms_internal_zzjv4 = com_google_android_gms_internal_zzjv3;
                com_google_android_gms_internal_zzqm = com_google_android_gms_internal_zzqm3;
                com_google_android_gms_internal_zzjv3 = com_google_android_gms_internal_zzjv4;
                max = Math.max(j3 - (zzw.zzcS().currentTimeMillis() - currentTimeMillis), 0);
                j = zzha;
                com_google_android_gms_internal_zzjv = com_google_android_gms_internal_zzjv3;
                j3 = max;
            }
            zza(com_google_android_gms_internal_zzqm);
            return com_google_android_gms_internal_zzjv == null ? new zzjv(1) : com_google_android_gms_internal_zzjv;
        }
    }

    public void cancel() {
        synchronized (this.zzrJ) {
            this.zzLs = true;
            for (zzju cancel : this.zzLt.values()) {
                cancel.cancel();
            }
        }
    }

    public zzjv zzd(List<zzjq> list) {
        zzqf.zzbf("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List arrayList = new ArrayList();
        for (zzjq com_google_android_gms_internal_zzjq : list) {
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(com_google_android_gms_internal_zzjq.zzKo);
            zzqf.zzbg(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            for (String com_google_android_gms_internal_zzju : com_google_android_gms_internal_zzjq.zzKp) {
                zzju com_google_android_gms_internal_zzju2 = new zzju(this.mContext, com_google_android_gms_internal_zzju, this.zzsz, this.zzKY, com_google_android_gms_internal_zzjq, this.zzLo.zzRy, this.zzLo.zzvr, this.zzLo.zzvn, this.zzwf, this.zzLa, this.zzLo.zzvF, this.zzLo.zzvK);
                zzqm zza = zzpn.zza(newCachedThreadPool, new C12681(this, com_google_android_gms_internal_zzju2));
                this.zzLt.put(zza, com_google_android_gms_internal_zzju2);
                arrayList.add(zza);
            }
        }
        switch (this.zzLr) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return zzf(arrayList);
            default:
                return zze(arrayList);
        }
    }

    public List<zzjv> zzgU() {
        return this.zzLu;
    }
}
