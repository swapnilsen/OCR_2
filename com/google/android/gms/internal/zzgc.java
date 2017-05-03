package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.zzg;
import java.util.concurrent.Callable;

@zzme
public class zzgc {
    private final ConditionVariable zzBc;
    @Nullable
    private SharedPreferences zzBd;
    private final Object zzrJ;
    private volatile boolean zztZ;

    /* renamed from: com.google.android.gms.internal.zzgc.1 */
    class C11851 implements Callable<T> {
        final /* synthetic */ zzfz zzBe;
        final /* synthetic */ zzgc zzBf;

        C11851(zzgc com_google_android_gms_internal_zzgc, zzfz com_google_android_gms_internal_zzfz) {
            this.zzBf = com_google_android_gms_internal_zzgc;
            this.zzBe = com_google_android_gms_internal_zzfz;
        }

        public T call() {
            return this.zzBe.zza(this.zzBf.zzBd);
        }
    }

    public zzgc() {
        this.zzrJ = new Object();
        this.zzBc = new ConditionVariable();
        this.zztZ = false;
        this.zzBd = null;
    }

    public void initialize(Context context) {
        if (!this.zztZ) {
            synchronized (this.zzrJ) {
                if (this.zztZ) {
                    return;
                }
                try {
                    Context remoteContext = zzg.getRemoteContext(context);
                    if (remoteContext == null) {
                        return;
                    }
                    this.zzBd = zzw.zzcW().zzn(remoteContext);
                    this.zztZ = true;
                    this.zzBc.open();
                } finally {
                    this.zzBc.open();
                }
            }
        }
    }

    public <T> T zzd(zzfz<T> com_google_android_gms_internal_zzfz_T) {
        if (this.zzBc.block(5000)) {
            if (!this.zztZ) {
                synchronized (this.zzrJ) {
                    if (this.zztZ) {
                    } else {
                        T zzfr = com_google_android_gms_internal_zzfz_T.zzfr();
                        return zzfr;
                    }
                }
            }
            return zzqb.zzb(new C11851(this, com_google_android_gms_internal_zzfz_T));
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }
}
