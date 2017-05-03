package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzpb.zza;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;

@zzme
public class zzlu extends zzlp {
    private final zzqw zzIs;
    private zzjr zzKY;
    zzjp zzQe;
    protected zzjv zzQf;
    private boolean zzQg;
    private final zzgl zzsn;
    private zzka zzsz;

    /* renamed from: com.google.android.gms.internal.zzlu.1 */
    class C12951 implements Runnable {
        final /* synthetic */ zzlu zzQh;
        final /* synthetic */ CountDownLatch zzsw;

        C12951(zzlu com_google_android_gms_internal_zzlu, CountDownLatch countDownLatch) {
            this.zzQh = com_google_android_gms_internal_zzlu;
            this.zzsw = countDownLatch;
        }

        public void run() {
            synchronized (this.zzQh.zzPU) {
                this.zzQh.zzQg = zzp.zza(this.zzQh.zzIs, this.zzQh.zzQf, this.zzsw);
            }
        }
    }

    zzlu(Context context, zza com_google_android_gms_internal_zzpb_zza, zzka com_google_android_gms_internal_zzka, zzlq.zza com_google_android_gms_internal_zzlq_zza, zzgl com_google_android_gms_internal_zzgl, zzqw com_google_android_gms_internal_zzqw) {
        super(context, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzlq_zza);
        this.zzsz = com_google_android_gms_internal_zzka;
        this.zzKY = com_google_android_gms_internal_zzpb_zza.zzWc;
        this.zzsn = com_google_android_gms_internal_zzgl;
        this.zzIs = com_google_android_gms_internal_zzqw;
    }

    private static int zzT(int i) {
        switch (i) {
            case FirebaseRemoteConfig.LAST_FETCH_STATUS_SUCCESS /*-1*/:
                return 4;
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return 0;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return 1;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return 2;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return 3;
            case Type.OTHER_PROFILE /*5*/:
                return 5;
            default:
                return 6;
        }
    }

    private static String zza(zzjv com_google_android_gms_internal_zzjv) {
        String str = com_google_android_gms_internal_zzjv.zzLi.zzKq;
        int zzT = zzT(com_google_android_gms_internal_zzjv.zzLh);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(zzT).append(".").append(com_google_android_gms_internal_zzjv.zzLn).toString();
    }

    private static String zzg(List<zzjv> list) {
        String str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        if (list == null) {
            return str.toString();
        }
        String str2 = str;
        for (zzjv com_google_android_gms_internal_zzjv : list) {
            if (!(com_google_android_gms_internal_zzjv == null || com_google_android_gms_internal_zzjv.zzLi == null || TextUtils.isEmpty(com_google_android_gms_internal_zzjv.zzLi.zzKq))) {
                str2 = String.valueOf(str2);
                str = String.valueOf(zza(com_google_android_gms_internal_zzjv));
                str2 = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(str).length()).append(str2).append(str).append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR).toString();
            }
        }
        return str2.substring(0, Math.max(0, str2.length() - 1));
    }

    private void zziS() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zzpo.zzXC.post(new C12951(this, countDownLatch));
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            synchronized (this.zzPU) {
                if (!this.zzQg) {
                    throw new zza("View could not be prepared", 0);
                } else if (this.zzIs.isDestroyed()) {
                    throw new zza("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(e);
            throw new zza(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
        }
    }

    public void onStop() {
        synchronized (this.zzPU) {
            super.onStop();
            if (this.zzQe != null) {
                this.zzQe.cancel();
            }
        }
    }

    protected zzpb zzR(int i) {
        zzmk com_google_android_gms_internal_zzmk = this.zzPR.zzTi;
        return new zzpb(com_google_android_gms_internal_zzmk.zzRy, this.zzIs, this.zzPS.zzKF, i, this.zzPS.zzKG, this.zzPS.zzSp, this.zzPS.orientation, this.zzPS.zzKL, com_google_android_gms_internal_zzmk.zzRB, this.zzPS.zzSn, this.zzQf != null ? this.zzQf.zzLi : null, this.zzQf != null ? this.zzQf.zzLj : null, this.zzQf != null ? this.zzQf.zzLk : AdMobAdapter.class.getName(), this.zzKY, this.zzQf != null ? this.zzQf.zzLl : null, this.zzPS.zzSo, this.zzPR.zzvr, this.zzPS.zzSm, this.zzPR.zzWg, this.zzPS.zzSr, this.zzPS.zzSs, this.zzPR.zzWa, null, this.zzPS.zzSC, this.zzPS.zzSD, this.zzPS.zzSE, this.zzKY != null ? this.zzKY.zzKQ : false, this.zzPS.zzSG, this.zzQe != null ? zzg(this.zzQe.zzgU()) : null, this.zzPS.zzKI, this.zzPS.zzSJ);
    }

    protected void zzh(long j) {
        boolean z;
        ListIterator listIterator;
        synchronized (this.zzPU) {
            this.zzQe = zzi(j);
        }
        List arrayList = new ArrayList(this.zzKY.zzKD);
        Bundle bundle = this.zzPR.zzTi.zzRy.zzzd;
        String str = "com.google.ads.mediation.admob.AdMobAdapter";
        if (bundle != null) {
            bundle = bundle.getBundle(str);
            if (bundle != null) {
                z = bundle.getBoolean("_skipMediation");
                if (z) {
                    listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        if (!((zzjq) listIterator.next()).zzKp.contains(str)) {
                            listIterator.remove();
                        }
                    }
                }
                this.zzQf = this.zzQe.zzd(arrayList);
                switch (this.zzQf.zzLh) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        if (this.zzQf.zzLi != null && this.zzQf.zzLi.zzKy != null) {
                            zziS();
                            return;
                        }
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        throw new zza("No fill from any mediation ad networks.", 3);
                    default:
                        throw new zza("Unexpected mediation result: " + this.zzQf.zzLh, 0);
                }
            }
        }
        z = false;
        if (z) {
            listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((zzjq) listIterator.next()).zzKp.contains(str)) {
                    listIterator.remove();
                }
            }
        }
        this.zzQf = this.zzQe.zzd(arrayList);
        switch (this.zzQf.zzLh) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                if (this.zzQf.zzLi != null) {
                }
            case NendIconError.ERROR_ICONVIEW /*1*/:
                throw new zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zza("Unexpected mediation result: " + this.zzQf.zzLh, 0);
        }
    }

    zzjp zzi(long j) {
        if (this.zzKY.zzKO != -1) {
            return new zzjx(this.mContext, this.zzPR.zzTi, this.zzsz, this.zzKY, this.zzPS.zzzB, this.zzPS.zzzD, j, ((Long) zzgd.zzDM.get()).longValue(), 2);
        }
        return new zzjy(this.mContext, this.zzPR.zzTi, this.zzsz, this.zzKY, this.zzPS.zzzB, this.zzPS.zzzD, j, ((Long) zzgd.zzDM.get()).longValue(), this.zzsn);
    }
}
