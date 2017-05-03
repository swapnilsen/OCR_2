package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;

@zzme
public abstract class zzlp extends zzpj {
    protected final Context mContext;
    protected final com.google.android.gms.internal.zzlq.zza zzPQ;
    protected final com.google.android.gms.internal.zzpb.zza zzPR;
    protected zzmn zzPS;
    protected final Object zzPU;
    protected final Object zzrJ;

    /* renamed from: com.google.android.gms.internal.zzlp.1 */
    class C12921 implements Runnable {
        final /* synthetic */ zzlp zzPX;

        C12921(zzlp com_google_android_gms_internal_zzlp) {
            this.zzPX = com_google_android_gms_internal_zzlp;
        }

        public void run() {
            this.zzPX.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlp.2 */
    class C12932 implements Runnable {
        final /* synthetic */ zzlp zzPX;
        final /* synthetic */ zzpb zzsX;

        C12932(zzlp com_google_android_gms_internal_zzlp, zzpb com_google_android_gms_internal_zzpb) {
            this.zzPX = com_google_android_gms_internal_zzlp;
            this.zzsX = com_google_android_gms_internal_zzpb;
        }

        public void run() {
            synchronized (this.zzPX.zzrJ) {
                this.zzPX.zzn(this.zzsX);
            }
        }
    }

    protected static final class zza extends Exception {
        private final int zzPY;

        public zza(String str, int i) {
            super(str);
            this.zzPY = i;
        }

        public int getErrorCode() {
            return this.zzPY;
        }
    }

    protected zzlp(Context context, com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, com.google.android.gms.internal.zzlq.zza com_google_android_gms_internal_zzlq_zza) {
        super(true);
        this.zzrJ = new Object();
        this.zzPU = new Object();
        this.mContext = context;
        this.zzPR = com_google_android_gms_internal_zzpb_zza;
        this.zzPS = com_google_android_gms_internal_zzpb_zza.zzWm;
        this.zzPQ = com_google_android_gms_internal_zzlq_zza;
    }

    public void onStop() {
    }

    protected abstract zzpb zzR(int i);

    public void zzco() {
        int errorCode;
        synchronized (this.zzrJ) {
            zzqf.zzbf("AdRendererBackgroundTask started.");
            int i = this.zzPR.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzqf.zzbg(e.getMessage());
                } else {
                    zzqf.zzbh(e.getMessage());
                }
                if (this.zzPS == null) {
                    this.zzPS = new zzmn(errorCode);
                } else {
                    this.zzPS = new zzmn(errorCode, this.zzPS.zzKL);
                }
                zzpo.zzXC.post(new C12921(this));
                i = errorCode;
            }
            zzpo.zzXC.post(new C12932(this, zzR(i)));
        }
    }

    protected abstract void zzh(long j);

    protected void zzn(zzpb com_google_android_gms_internal_zzpb) {
        this.zzPQ.zzb(com_google_android_gms_internal_zzpb);
    }
}
