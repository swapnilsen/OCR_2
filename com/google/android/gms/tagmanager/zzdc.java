package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzdc extends zzdb {
    private static final Object zzbIa;
    private static zzdc zzbIm;
    private boolean connected;
    private Context zzbIb;
    private zzaw zzbIc;
    private volatile zzau zzbId;
    private int zzbIe;
    private boolean zzbIf;
    private boolean zzbIg;
    private boolean zzbIh;
    private zzax zzbIi;
    private zza zzbIj;
    private zzbt zzbIk;
    private boolean zzbIl;

    /* renamed from: com.google.android.gms.tagmanager.zzdc.1 */
    class C14541 implements zzax {
        final /* synthetic */ zzdc zzbIn;

        C14541(zzdc com_google_android_gms_tagmanager_zzdc) {
            this.zzbIn = com_google_android_gms_tagmanager_zzdc;
        }

        public void zzaS(boolean z) {
            this.zzbIn.zze(z, this.zzbIn.connected);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzdc.2 */
    class C14552 implements Runnable {
        final /* synthetic */ zzdc zzbIn;

        C14552(zzdc com_google_android_gms_tagmanager_zzdc) {
            this.zzbIn = com_google_android_gms_tagmanager_zzdc;
        }

        public void run() {
            this.zzbIn.zzbIc.dispatch();
        }
    }

    public interface zza {
        void cancel();

        void zzRD();

        void zzy(long j);
    }

    private class zzb implements zza {
        private Handler handler;
        final /* synthetic */ zzdc zzbIn;

        /* renamed from: com.google.android.gms.tagmanager.zzdc.zzb.1 */
        class C14561 implements Callback {
            final /* synthetic */ zzb zzbIo;

            C14561(zzb com_google_android_gms_tagmanager_zzdc_zzb) {
                this.zzbIo = com_google_android_gms_tagmanager_zzdc_zzb;
            }

            public boolean handleMessage(Message message) {
                if (1 == message.what && zzdc.zzbIa.equals(message.obj)) {
                    this.zzbIo.zzbIn.dispatch();
                    if (!this.zzbIo.zzbIn.isPowerSaveMode()) {
                        this.zzbIo.zzy((long) this.zzbIo.zzbIn.zzbIe);
                    }
                }
                return true;
            }
        }

        private zzb(zzdc com_google_android_gms_tagmanager_zzdc) {
            this.zzbIn = com_google_android_gms_tagmanager_zzdc;
            this.handler = new Handler(this.zzbIn.zzbIb.getMainLooper(), new C14561(this));
        }

        private Message obtainMessage() {
            return this.handler.obtainMessage(1, zzdc.zzbIa);
        }

        public void cancel() {
            this.handler.removeMessages(1, zzdc.zzbIa);
        }

        public void zzRD() {
            this.handler.removeMessages(1, zzdc.zzbIa);
            this.handler.sendMessage(obtainMessage());
        }

        public void zzy(long j) {
            this.handler.removeMessages(1, zzdc.zzbIa);
            this.handler.sendMessageDelayed(obtainMessage(), j);
        }
    }

    static {
        zzbIa = new Object();
    }

    private zzdc() {
        this.zzbIe = 1800000;
        this.zzbIf = true;
        this.zzbIg = false;
        this.connected = true;
        this.zzbIh = true;
        this.zzbIi = new C14541(this);
        this.zzbIl = false;
    }

    private boolean isPowerSaveMode() {
        return this.zzbIl || !this.connected || this.zzbIe <= 0;
    }

    private void zzRA() {
        this.zzbIj = new zzb();
        if (this.zzbIe > 0) {
            this.zzbIj.zzy((long) this.zzbIe);
        }
    }

    public static zzdc zzRy() {
        if (zzbIm == null) {
            zzbIm = new zzdc();
        }
        return zzbIm;
    }

    private void zzRz() {
        this.zzbIk = new zzbt(this);
        this.zzbIk.zzcb(this.zzbIb);
    }

    private void zzoH() {
        if (isPowerSaveMode()) {
            this.zzbIj.cancel();
            zzbo.m4712v("PowerSaveMode initiated.");
            return;
        }
        this.zzbIj.zzy((long) this.zzbIe);
        zzbo.m4712v("PowerSaveMode terminated.");
    }

    public synchronized void dispatch() {
        if (this.zzbIg) {
            this.zzbId.zzp(new C14552(this));
        } else {
            zzbo.m4712v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzbIf = true;
        }
    }

    synchronized zzaw zzRB() {
        if (this.zzbIc == null) {
            if (this.zzbIb == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzbIc = new zzcg(this.zzbIi, this.zzbIb);
        }
        if (this.zzbIj == null) {
            zzRA();
        }
        this.zzbIg = true;
        if (this.zzbIf) {
            dispatch();
            this.zzbIf = false;
        }
        if (this.zzbIk == null && this.zzbIh) {
            zzRz();
        }
        return this.zzbIc;
    }

    synchronized void zza(Context context, zzau com_google_android_gms_tagmanager_zzau) {
        if (this.zzbIb == null) {
            this.zzbIb = context.getApplicationContext();
            if (this.zzbId == null) {
                this.zzbId = com_google_android_gms_tagmanager_zzau;
            }
        }
    }

    public synchronized void zzaT(boolean z) {
        zze(this.zzbIl, z);
    }

    synchronized void zze(boolean z, boolean z2) {
        boolean isPowerSaveMode = isPowerSaveMode();
        this.zzbIl = z;
        this.connected = z2;
        if (isPowerSaveMode() != isPowerSaveMode) {
            zzoH();
        }
    }

    public synchronized void zznO() {
        if (!isPowerSaveMode()) {
            this.zzbIj.zzRD();
        }
    }
}
