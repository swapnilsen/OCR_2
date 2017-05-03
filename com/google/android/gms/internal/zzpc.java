package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzme
public class zzpc {
    private boolean zzTZ;
    private final LinkedList<zza> zzWn;
    private final String zzWo;
    private final String zzWp;
    private long zzWq;
    private long zzWr;
    private long zzWs;
    private long zzWt;
    private long zzWu;
    private long zzWv;
    private final Object zzrJ;
    private final zzpe zzuM;

    @zzme
    private static final class zza {
        private long zzWw;
        private long zzWx;

        public zza() {
            this.zzWw = -1;
            this.zzWx = -1;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.zzWw);
            bundle.putLong("tclose", this.zzWx);
            return bundle;
        }

        public long zzjY() {
            return this.zzWx;
        }

        public void zzjZ() {
            this.zzWx = SystemClock.elapsedRealtime();
        }

        public void zzka() {
            this.zzWw = SystemClock.elapsedRealtime();
        }
    }

    public zzpc(zzpe com_google_android_gms_internal_zzpe, String str, String str2) {
        this.zzrJ = new Object();
        this.zzWq = -1;
        this.zzWr = -1;
        this.zzTZ = false;
        this.zzWs = -1;
        this.zzWt = 0;
        this.zzWu = -1;
        this.zzWv = -1;
        this.zzuM = com_google_android_gms_internal_zzpe;
        this.zzWo = str;
        this.zzWp = str2;
        this.zzWn = new LinkedList();
    }

    public zzpc(String str, String str2) {
        this(zzw.zzcQ(), str, str2);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzrJ) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzWo);
            bundle.putString("slotid", this.zzWp);
            bundle.putBoolean("ismediation", this.zzTZ);
            bundle.putLong("treq", this.zzWu);
            bundle.putLong("tresponse", this.zzWv);
            bundle.putLong("timp", this.zzWr);
            bundle.putLong("tload", this.zzWs);
            bundle.putLong("pcc", this.zzWt);
            bundle.putLong("tfetch", this.zzWq);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzWn.iterator();
            while (it.hasNext()) {
                arrayList.add(((zza) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public void zzD(boolean z) {
        synchronized (this.zzrJ) {
            if (this.zzWv != -1) {
                this.zzWs = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzWr = this.zzWs;
                    this.zzuM.zza(this);
                }
            }
        }
    }

    public void zzE(boolean z) {
        synchronized (this.zzrJ) {
            if (this.zzWv != -1) {
                this.zzTZ = z;
                this.zzuM.zza(this);
            }
        }
    }

    public void zzjV() {
        synchronized (this.zzrJ) {
            if (this.zzWv != -1 && this.zzWr == -1) {
                this.zzWr = SystemClock.elapsedRealtime();
                this.zzuM.zza(this);
            }
            this.zzuM.zzkj().zzjV();
        }
    }

    public void zzjW() {
        synchronized (this.zzrJ) {
            if (this.zzWv != -1) {
                zza com_google_android_gms_internal_zzpc_zza = new zza();
                com_google_android_gms_internal_zzpc_zza.zzka();
                this.zzWn.add(com_google_android_gms_internal_zzpc_zza);
                this.zzWt++;
                this.zzuM.zzkj().zzjW();
                this.zzuM.zza(this);
            }
        }
    }

    public void zzjX() {
        synchronized (this.zzrJ) {
            if (!(this.zzWv == -1 || this.zzWn.isEmpty())) {
                zza com_google_android_gms_internal_zzpc_zza = (zza) this.zzWn.getLast();
                if (com_google_android_gms_internal_zzpc_zza.zzjY() == -1) {
                    com_google_android_gms_internal_zzpc_zza.zzjZ();
                    this.zzuM.zza(this);
                }
            }
        }
    }

    public void zzm(long j) {
        synchronized (this.zzrJ) {
            this.zzWv = j;
            if (this.zzWv != -1) {
                this.zzuM.zza(this);
            }
        }
    }

    public void zzn(long j) {
        synchronized (this.zzrJ) {
            if (this.zzWv != -1) {
                this.zzWq = j;
                this.zzuM.zza(this);
            }
        }
    }

    public void zzs(zzec com_google_android_gms_internal_zzec) {
        synchronized (this.zzrJ) {
            this.zzWu = SystemClock.elapsedRealtime();
            this.zzuM.zzkj().zzb(com_google_android_gms_internal_zzec, this.zzWu);
        }
    }
}
