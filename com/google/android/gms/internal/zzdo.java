package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.internal.zzdd.zzb;

@zzme
public class zzdo {
    @Nullable
    private Context mContext;
    private final Object zzrJ;
    private final Runnable zzyG;
    @Nullable
    private zzdr zzyH;
    @Nullable
    private zzdv zzyI;

    /* renamed from: com.google.android.gms.internal.zzdo.1 */
    class C11591 implements Runnable {
        final /* synthetic */ zzdo zzyJ;

        C11591(zzdo com_google_android_gms_internal_zzdo) {
            this.zzyJ = com_google_android_gms_internal_zzdo;
        }

        public void run() {
            this.zzyJ.disconnect();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdo.2 */
    class C11602 implements zzb {
        final /* synthetic */ zzdo zzyJ;

        C11602(zzdo com_google_android_gms_internal_zzdo) {
            this.zzyJ = com_google_android_gms_internal_zzdo;
        }

        public void zzk(boolean z) {
            if (z) {
                this.zzyJ.connect();
            } else {
                this.zzyJ.disconnect();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdo.3 */
    class C11613 implements zzf.zzb {
        final /* synthetic */ zzdo zzyJ;

        C11613(zzdo com_google_android_gms_internal_zzdo) {
            this.zzyJ = com_google_android_gms_internal_zzdo;
        }

        public void onConnected(@Nullable Bundle bundle) {
            synchronized (this.zzyJ.zzrJ) {
                try {
                    this.zzyJ.zzyI = this.zzyJ.zzyH.zzeB();
                } catch (Throwable e) {
                    zzqf.zzb("Unable to obtain a cache service instance.", e);
                    this.zzyJ.disconnect();
                }
                this.zzyJ.zzrJ.notifyAll();
            }
        }

        public void onConnectionSuspended(int i) {
            synchronized (this.zzyJ.zzrJ) {
                this.zzyJ.zzyI = null;
                this.zzyJ.zzrJ.notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdo.4 */
    class C11624 implements zzc {
        final /* synthetic */ zzdo zzyJ;

        C11624(zzdo com_google_android_gms_internal_zzdo) {
            this.zzyJ = com_google_android_gms_internal_zzdo;
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            synchronized (this.zzyJ.zzrJ) {
                this.zzyJ.zzyI = null;
                if (this.zzyJ.zzyH != null) {
                    this.zzyJ.zzyH = null;
                    zzw.zzdc().zzlc();
                }
                this.zzyJ.zzrJ.notifyAll();
            }
        }
    }

    public zzdo() {
        this.zzyG = new C11591(this);
        this.zzrJ = new Object();
    }

    private void connect() {
        synchronized (this.zzrJ) {
            if (this.mContext == null || this.zzyH != null) {
                return;
            }
            this.zzyH = zza(new C11613(this), new C11624(this));
            this.zzyH.zzxz();
        }
    }

    private void disconnect() {
        synchronized (this.zzrJ) {
            if (this.zzyH == null) {
                return;
            }
            if (this.zzyH.isConnected() || this.zzyH.isConnecting()) {
                this.zzyH.disconnect();
            }
            this.zzyH = null;
            this.zzyI = null;
            Binder.flushPendingCommands();
            zzw.zzdc().zzlc();
        }
    }

    public void initialize(Context context) {
        if (context != null) {
            synchronized (this.zzrJ) {
                if (this.mContext != null) {
                    return;
                }
                this.mContext = context.getApplicationContext();
                if (((Boolean) zzgd.zzFf.get()).booleanValue()) {
                    connect();
                } else if (((Boolean) zzgd.zzFe.get()).booleanValue()) {
                    zza(new C11602(this));
                }
            }
        }
    }

    public zzdp zza(zzds com_google_android_gms_internal_zzds) {
        zzdp com_google_android_gms_internal_zzdp;
        synchronized (this.zzrJ) {
            if (this.zzyI == null) {
                com_google_android_gms_internal_zzdp = new zzdp();
            } else {
                try {
                    com_google_android_gms_internal_zzdp = this.zzyI.zza(com_google_android_gms_internal_zzds);
                } catch (Throwable e) {
                    zzqf.zzb("Unable to call into cache service.", e);
                    com_google_android_gms_internal_zzdp = new zzdp();
                }
            }
        }
        return com_google_android_gms_internal_zzdp;
    }

    protected zzdr zza(zzf.zzb com_google_android_gms_common_internal_zzf_zzb, zzc com_google_android_gms_common_internal_zzf_zzc) {
        return new zzdr(this.mContext, zzw.zzdc().zzlb(), com_google_android_gms_common_internal_zzf_zzb, com_google_android_gms_common_internal_zzf_zzc);
    }

    protected void zza(zzb com_google_android_gms_internal_zzdd_zzb) {
        zzw.zzcP().zza(com_google_android_gms_internal_zzdd_zzb);
    }

    public void zzev() {
        if (((Boolean) zzgd.zzFg.get()).booleanValue()) {
            synchronized (this.zzrJ) {
                connect();
                zzw.zzcM();
                zzpo.zzXC.removeCallbacks(this.zzyG);
                zzw.zzcM();
                zzpo.zzXC.postDelayed(this.zzyG, ((Long) zzgd.zzFh.get()).longValue());
            }
        }
    }
}
