package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzal;
import com.google.android.gms.internal.zzaad.zza;

public class zzaaq implements zzaau {
    private final zzaav zzaBk;
    private boolean zzaBl;

    /* renamed from: com.google.android.gms.internal.zzaaq.1 */
    class C10231 extends zza {
        final /* synthetic */ zzaaq zzaBm;

        C10231(zzaaq com_google_android_gms_internal_zzaaq, zzaau com_google_android_gms_internal_zzaau) {
            this.zzaBm = com_google_android_gms_internal_zzaaq;
            super(com_google_android_gms_internal_zzaau);
        }

        public void zzwe() {
            this.zzaBm.onConnectionSuspended(1);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaaq.2 */
    class C10242 extends zza {
        final /* synthetic */ zzaaq zzaBm;

        C10242(zzaaq com_google_android_gms_internal_zzaaq, zzaau com_google_android_gms_internal_zzaau) {
            this.zzaBm = com_google_android_gms_internal_zzaaq;
            super(com_google_android_gms_internal_zzaau);
        }

        public void zzwe() {
            this.zzaBm.zzaBk.zzaCj.zzo(null);
        }
    }

    public zzaaq(zzaav com_google_android_gms_internal_zzaav) {
        this.zzaBl = false;
        this.zzaBk = com_google_android_gms_internal_zzaav;
    }

    private <A extends zzb> void zze(zza<? extends Result, A> com_google_android_gms_internal_zzaad_zza__extends_com_google_android_gms_common_api_Result__A) {
        this.zzaBk.zzaAw.zzaBW.zzb(com_google_android_gms_internal_zzaad_zza__extends_com_google_android_gms_common_api_Result__A);
        zzb zzc = this.zzaBk.zzaAw.zzc(com_google_android_gms_internal_zzaad_zza__extends_com_google_android_gms_common_api_Result__A.zzvg());
        if (zzc.isConnected() || !this.zzaBk.zzaCf.containsKey(com_google_android_gms_internal_zzaad_zza__extends_com_google_android_gms_common_api_Result__A.zzvg())) {
            if (zzc instanceof zzal) {
                zzc = ((zzal) zzc).zzyn();
            }
            com_google_android_gms_internal_zzaad_zza__extends_com_google_android_gms_common_api_Result__A.zzb(zzc);
            return;
        }
        com_google_android_gms_internal_zzaad_zza__extends_com_google_android_gms_common_api_Result__A.zzB(new Status(17));
    }

    public void begin() {
    }

    public void connect() {
        if (this.zzaBl) {
            this.zzaBl = false;
            this.zzaBk.zza(new C10242(this, this));
        }
    }

    public boolean disconnect() {
        if (this.zzaBl) {
            return false;
        }
        if (this.zzaBk.zzaAw.zzwq()) {
            this.zzaBl = true;
            for (zzabx zzxb : this.zzaBk.zzaAw.zzaBV) {
                zzxb.zzxb();
            }
            return false;
        }
        this.zzaBk.zzh(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        this.zzaBk.zzh(null);
        this.zzaBk.zzaCj.zzc(i, this.zzaBl);
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zza(T t) {
        return zzb(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzb(T t) {
        try {
            zze(t);
        } catch (DeadObjectException e) {
            this.zzaBk.zza(new C10231(this, this));
        }
        return t;
    }

    void zzwd() {
        if (this.zzaBl) {
            this.zzaBl = false;
            this.zzaBk.zzaAw.zzaBW.release();
            disconnect();
        }
    }
}
