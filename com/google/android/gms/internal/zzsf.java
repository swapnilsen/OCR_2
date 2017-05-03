package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzac;
import java.util.Collections;

public class zzsf extends zzsa {
    private final zza zzael;
    private zzta zzaem;
    private final zzsr zzaen;
    private zztj zzaeo;

    /* renamed from: com.google.android.gms.internal.zzsf.1 */
    class C14081 extends zzsr {
        final /* synthetic */ zzsf zzaep;

        C14081(zzsf com_google_android_gms_internal_zzsf, zzsc com_google_android_gms_internal_zzsc) {
            this.zzaep = com_google_android_gms_internal_zzsf;
            super(com_google_android_gms_internal_zzsc);
        }

        public void run() {
            this.zzaep.zzop();
        }
    }

    protected class zza implements ServiceConnection {
        final /* synthetic */ zzsf zzaep;
        private volatile zzta zzaeq;
        private volatile boolean zzaer;

        /* renamed from: com.google.android.gms.internal.zzsf.zza.1 */
        class C14091 implements Runnable {
            final /* synthetic */ zzta zzaes;
            final /* synthetic */ zza zzaet;

            C14091(zza com_google_android_gms_internal_zzsf_zza, zzta com_google_android_gms_internal_zzta) {
                this.zzaet = com_google_android_gms_internal_zzsf_zza;
                this.zzaes = com_google_android_gms_internal_zzta;
            }

            public void run() {
                if (!this.zzaet.zzaep.isConnected()) {
                    this.zzaet.zzaep.zzbQ("Connected to service after a timeout");
                    this.zzaet.zzaep.zza(this.zzaes);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzsf.zza.2 */
        class C14102 implements Runnable {
            final /* synthetic */ ComponentName val$name;
            final /* synthetic */ zza zzaet;

            C14102(zza com_google_android_gms_internal_zzsf_zza, ComponentName componentName) {
                this.zzaet = com_google_android_gms_internal_zzsf_zza;
                this.val$name = componentName;
            }

            public void run() {
                this.zzaet.zzaep.onServiceDisconnected(this.val$name);
            }
        }

        protected zza(zzsf com_google_android_gms_internal_zzsf) {
            this.zzaep = com_google_android_gms_internal_zzsf;
        }

        public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.internal.zzsf.zza.onServiceConnected(android.content.ComponentName, android.os.IBinder):void. bs: [B:3:0x0008, B:9:0x0015]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:57)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r4 = this;
            r0 = "AnalyticsServiceConnection.onServiceConnected";
            com.google.android.gms.common.internal.zzac.zzdj(r0);
            monitor-enter(r4);
            if (r6 != 0) goto L_0x0014;
        L_0x0008:
            r0 = r4.zzaep;	 Catch:{ all -> 0x005a }
            r1 = "Service connected with null binder";	 Catch:{ all -> 0x005a }
            r0.zzbT(r1);	 Catch:{ all -> 0x005a }
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        L_0x0013:
            return;
        L_0x0014:
            r0 = 0;
            r1 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0051 }
            r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x0051 }
            r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0051 }
            if (r2 == 0) goto L_0x0049;	 Catch:{ RemoteException -> 0x0051 }
        L_0x0021:
            r0 = com.google.android.gms.internal.zzta.zza.zzam(r6);	 Catch:{ RemoteException -> 0x0051 }
            r1 = r4.zzaep;	 Catch:{ RemoteException -> 0x0051 }
            r2 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x0051 }
            r1.zzbP(r2);	 Catch:{ RemoteException -> 0x0051 }
        L_0x002c:
            if (r0 != 0) goto L_0x005f;
        L_0x002e:
            r0 = com.google.android.gms.common.stats.zza.zzyJ();	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r4.zzaep;	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r1.getContext();	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r4.zzaep;	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r2.zzael;	 Catch:{ IllegalArgumentException -> 0x007c }
            r0.zza(r1, r2);	 Catch:{ IllegalArgumentException -> 0x007c }
        L_0x0041:
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            goto L_0x0013;	 Catch:{ all -> 0x0046 }
        L_0x0046:
            r0 = move-exception;	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            throw r0;
        L_0x0049:
            r2 = r4.zzaep;	 Catch:{ RemoteException -> 0x0051 }
            r3 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0051 }
            r2.zze(r3, r1);	 Catch:{ RemoteException -> 0x0051 }
            goto L_0x002c;
        L_0x0051:
            r1 = move-exception;
            r1 = r4.zzaep;	 Catch:{ all -> 0x005a }
            r2 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x005a }
            r1.zzbT(r2);	 Catch:{ all -> 0x005a }
            goto L_0x002c;
        L_0x005a:
            r0 = move-exception;
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            throw r0;	 Catch:{ all -> 0x0046 }
        L_0x005f:
            r1 = r4.zzaer;	 Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0079;	 Catch:{ all -> 0x005a }
        L_0x0063:
            r1 = r4.zzaep;	 Catch:{ all -> 0x005a }
            r2 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x005a }
            r1.zzbS(r2);	 Catch:{ all -> 0x005a }
            r1 = r4.zzaep;	 Catch:{ all -> 0x005a }
            r1 = r1.zznU();	 Catch:{ all -> 0x005a }
            r2 = new com.google.android.gms.internal.zzsf$zza$1;	 Catch:{ all -> 0x005a }
            r2.<init>(r4, r0);	 Catch:{ all -> 0x005a }
            r1.zzg(r2);	 Catch:{ all -> 0x005a }
            goto L_0x0041;	 Catch:{ all -> 0x005a }
        L_0x0079:
            r4.zzaeq = r0;	 Catch:{ all -> 0x005a }
            goto L_0x0041;
        L_0x007c:
            r0 = move-exception;
            goto L_0x0041;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsf.zza.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            zzac.zzdj("AnalyticsServiceConnection.onServiceDisconnected");
            this.zzaep.zznU().zzg(new C14102(this, componentName));
        }

        public zzta zzoq() {
            zzta com_google_android_gms_internal_zzta = null;
            this.zzaep.zzmR();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
            Context context = this.zzaep.getContext();
            intent.putExtra("app_package_name", context.getPackageName());
            com.google.android.gms.common.stats.zza zzyJ = com.google.android.gms.common.stats.zza.zzyJ();
            synchronized (this) {
                this.zzaeq = null;
                this.zzaer = true;
                boolean zza = zzyJ.zza(context, intent, this.zzaep.zzael, 129);
                this.zzaep.zza("Bind to service requested", Boolean.valueOf(zza));
                if (zza) {
                    try {
                        wait(this.zzaep.zznT().zzpr());
                    } catch (InterruptedException e) {
                        this.zzaep.zzbS("Wait for service connect was interrupted");
                    }
                    this.zzaer = false;
                    com_google_android_gms_internal_zzta = this.zzaeq;
                    this.zzaeq = null;
                    if (com_google_android_gms_internal_zzta == null) {
                        this.zzaep.zzbT("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.zzaer = false;
                }
            }
            return com_google_android_gms_internal_zzta;
        }
    }

    protected zzsf(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
        this.zzaeo = new zztj(com_google_android_gms_internal_zzsc.zznR());
        this.zzael = new zza(this);
        this.zzaen = new C14081(this, com_google_android_gms_internal_zzsc);
    }

    private void onDisconnect() {
        zzmA().zznN();
    }

    private void onServiceDisconnected(ComponentName componentName) {
        zzmR();
        if (this.zzaem != null) {
            this.zzaem = null;
            zza("Disconnected from device AnalyticsService", componentName);
            onDisconnect();
        }
    }

    private void zza(zzta com_google_android_gms_internal_zzta) {
        zzmR();
        this.zzaem = com_google_android_gms_internal_zzta;
        zzoo();
        zzmA().onServiceConnected();
    }

    private void zzoo() {
        this.zzaeo.start();
        this.zzaen.zzy(zznT().zzpq());
    }

    private void zzop() {
        zzmR();
        if (isConnected()) {
            zzbP("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public boolean connect() {
        zzmR();
        zzob();
        if (this.zzaem != null) {
            return true;
        }
        zzta zzoq = this.zzael.zzoq();
        if (zzoq == null) {
            return false;
        }
        this.zzaem = zzoq;
        zzoo();
        return true;
    }

    public void disconnect() {
        zzmR();
        zzob();
        try {
            com.google.android.gms.common.stats.zza.zzyJ().zza(getContext(), this.zzael);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.zzaem != null) {
            this.zzaem = null;
            onDisconnect();
        }
    }

    public boolean isConnected() {
        zzmR();
        zzob();
        return this.zzaem != null;
    }

    public boolean zzb(zzsz com_google_android_gms_internal_zzsz) {
        zzac.zzw(com_google_android_gms_internal_zzsz);
        zzmR();
        zzob();
        zzta com_google_android_gms_internal_zzta = this.zzaem;
        if (com_google_android_gms_internal_zzta == null) {
            return false;
        }
        try {
            com_google_android_gms_internal_zzta.zza(com_google_android_gms_internal_zzsz.zzfE(), com_google_android_gms_internal_zzsz.zzpQ(), com_google_android_gms_internal_zzsz.zzpS() ? zznT().zzpj() : zznT().zzpk(), Collections.emptyList());
            zzoo();
            return true;
        } catch (RemoteException e) {
            zzbP("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    protected void zzmS() {
    }

    public boolean zzon() {
        zzmR();
        zzob();
        zzta com_google_android_gms_internal_zzta = this.zzaem;
        if (com_google_android_gms_internal_zzta == null) {
            return false;
        }
        try {
            com_google_android_gms_internal_zzta.zznK();
            zzoo();
            return true;
        } catch (RemoteException e) {
            zzbP("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
