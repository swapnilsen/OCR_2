package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.common.zze;
import com.google.android.gms.measurement.AppMeasurement.zzf;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public class zzaul extends zzauh {
    private final zza zzbvA;
    private zzatt zzbvB;
    private Boolean zzbvC;
    private final zzatk zzbvD;
    private final zzauo zzbvE;
    private final List<Runnable> zzbvF;
    private final zzatk zzbvG;

    /* renamed from: com.google.android.gms.internal.zzaul.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ String zzbuP;
        final /* synthetic */ zzaul zzbvH;
        final /* synthetic */ AtomicReference zzbvI;
        final /* synthetic */ boolean zzbve;

        AnonymousClass10(zzaul com_google_android_gms_internal_zzaul, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            this.zzbvI = atomicReference;
            this.zzbkW = str;
            this.zzbuO = str2;
            this.zzbuP = str3;
            this.zzbve = z;
        }

        public void run() {
            synchronized (this.zzbvI) {
                try {
                    zzatt zzc = this.zzbvH.zzbvB;
                    if (zzc == null) {
                        this.zzbvH.zzKl().zzLY().zzd("Failed to get user properties", zzatx.zzfE(this.zzbkW), this.zzbuO, this.zzbuP);
                        this.zzbvI.set(Collections.emptyList());
                        return;
                    }
                    if (TextUtils.isEmpty(this.zzbkW)) {
                        this.zzbvI.set(zzc.zza(this.zzbuO, this.zzbuP, this.zzbve, this.zzbvH.zzKb().zzfD(this.zzbvH.zzKl().zzMf())));
                    } else {
                        this.zzbvI.set(zzc.zza(this.zzbkW, this.zzbuO, this.zzbuP, this.zzbve));
                    }
                    this.zzbvH.zzoo();
                    this.zzbvI.notify();
                } catch (RemoteException e) {
                    this.zzbvH.zzKl().zzLY().zzd("Failed to get user properties", zzatx.zzfE(this.zzbkW), this.zzbuO, e);
                    this.zzbvI.set(Collections.emptyList());
                } finally {
                    this.zzbvI.notify();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ zzauq zzbuR;
        final /* synthetic */ zzaul zzbvH;
        final /* synthetic */ boolean zzbvL;

        AnonymousClass11(zzaul com_google_android_gms_internal_zzaul, boolean z, zzauq com_google_android_gms_internal_zzauq) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            this.zzbvL = z;
            this.zzbuR = com_google_android_gms_internal_zzauq;
        }

        public void run() {
            zzatt zzc = this.zzbvH.zzbvB;
            if (zzc == null) {
                this.zzbvH.zzKl().zzLY().log("Discarding data. Failed to set user attribute");
                return;
            }
            this.zzbvH.zza(zzc, this.zzbvL ? null : this.zzbuR);
            this.zzbvH.zzoo();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.12 */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ zzaul zzbvH;
        final /* synthetic */ AtomicReference zzbvI;
        final /* synthetic */ boolean zzbve;

        AnonymousClass12(zzaul com_google_android_gms_internal_zzaul, AtomicReference atomicReference, boolean z) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            this.zzbvI = atomicReference;
            this.zzbve = z;
        }

        public void run() {
            synchronized (this.zzbvI) {
                try {
                    zzatt zzc = this.zzbvH.zzbvB;
                    if (zzc == null) {
                        this.zzbvH.zzKl().zzLY().log("Failed to get user properties");
                        return;
                    }
                    this.zzbvI.set(zzc.zza(this.zzbvH.zzKb().zzfD(null), this.zzbve));
                    this.zzbvH.zzoo();
                    this.zzbvI.notify();
                } catch (RemoteException e) {
                    this.zzbvH.zzKl().zzLY().zzj("Failed to get user properties", e);
                } finally {
                    this.zzbvI.notify();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.1 */
    class C10931 extends zzatk {
        final /* synthetic */ zzaul zzbvH;

        C10931(zzaul com_google_android_gms_internal_zzaul, zzaue com_google_android_gms_internal_zzaue) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            super(com_google_android_gms_internal_zzaue);
        }

        public void run() {
            this.zzbvH.zzop();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.2 */
    class C10942 implements Runnable {
        final /* synthetic */ zzaul zzbvH;
        final /* synthetic */ AtomicReference zzbvI;

        C10942(zzaul com_google_android_gms_internal_zzaul, AtomicReference atomicReference) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            this.zzbvI = atomicReference;
        }

        public void run() {
            synchronized (this.zzbvI) {
                try {
                    zzatt zzc = this.zzbvH.zzbvB;
                    if (zzc == null) {
                        this.zzbvH.zzKl().zzLY().log("Failed to get app instance id");
                        return;
                    }
                    this.zzbvI.set(zzc.zzc(this.zzbvH.zzKb().zzfD(null)));
                    this.zzbvH.zzoo();
                    this.zzbvI.notify();
                } catch (RemoteException e) {
                    this.zzbvH.zzKl().zzLY().zzj("Failed to get app instance id", e);
                } finally {
                    this.zzbvI.notify();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.3 */
    class C10953 implements Runnable {
        final /* synthetic */ zzaul zzbvH;

        C10953(zzaul com_google_android_gms_internal_zzaul) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
        }

        public void run() {
            zzatt zzc = this.zzbvH.zzbvB;
            if (zzc == null) {
                this.zzbvH.zzKl().zzLY().log("Discarding data. Failed to send app launch");
                return;
            }
            try {
                zzc.zza(this.zzbvH.zzKb().zzfD(this.zzbvH.zzKl().zzMf()));
                this.zzbvH.zza(zzc, null);
                this.zzbvH.zzoo();
            } catch (RemoteException e) {
                this.zzbvH.zzKl().zzLY().zzj("Failed to send app launch to the service", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.4 */
    class C10964 implements Runnable {
        final /* synthetic */ zzaul zzbvH;
        final /* synthetic */ zzf zzbvJ;

        C10964(zzaul com_google_android_gms_internal_zzaul, zzf com_google_android_gms_measurement_AppMeasurement_zzf) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            this.zzbvJ = com_google_android_gms_measurement_AppMeasurement_zzf;
        }

        public void run() {
            zzatt zzc = this.zzbvH.zzbvB;
            if (zzc == null) {
                this.zzbvH.zzKl().zzLY().log("Failed to send current screen to service");
                return;
            }
            try {
                if (this.zzbvJ == null) {
                    zzc.zza(0, null, null, this.zzbvH.getContext().getPackageName());
                } else {
                    zzc.zza(this.zzbvJ.zzbqh, this.zzbvJ.zzbqf, this.zzbvJ.zzbqg, this.zzbvH.getContext().getPackageName());
                }
                this.zzbvH.zzoo();
            } catch (RemoteException e) {
                this.zzbvH.zzKl().zzLY().zzj("Failed to send current screen to the service", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.5 */
    class C10975 extends zzatk {
        final /* synthetic */ zzaul zzbvH;

        C10975(zzaul com_google_android_gms_internal_zzaul, zzaue com_google_android_gms_internal_zzaue) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            super(com_google_android_gms_internal_zzaue);
        }

        public void run() {
            this.zzbvH.zzKl().zzMa().log("Tasks have been queued for a long time");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.6 */
    class C10986 implements Runnable {
        final /* synthetic */ zzaul zzbvH;

        C10986(zzaul com_google_android_gms_internal_zzaul) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
        }

        public void run() {
            zzatt zzc = this.zzbvH.zzbvB;
            if (zzc == null) {
                this.zzbvH.zzKl().zzLY().log("Failed to send measurementEnabled to service");
                return;
            }
            try {
                zzc.zzb(this.zzbvH.zzKb().zzfD(this.zzbvH.zzKl().zzMf()));
                this.zzbvH.zzoo();
            } catch (RemoteException e) {
                this.zzbvH.zzKl().zzLY().zzj("Failed to send measurementEnabled to the service", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.7 */
    class C10997 implements Runnable {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ zzatq zzbuQ;
        final /* synthetic */ zzaul zzbvH;
        final /* synthetic */ boolean zzbvK;
        final /* synthetic */ boolean zzbvL;

        C10997(zzaul com_google_android_gms_internal_zzaul, boolean z, boolean z2, zzatq com_google_android_gms_internal_zzatq, String str) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            this.zzbvK = z;
            this.zzbvL = z2;
            this.zzbuQ = com_google_android_gms_internal_zzatq;
            this.zzbkW = str;
        }

        public void run() {
            zzatt zzc = this.zzbvH.zzbvB;
            if (zzc == null) {
                this.zzbvH.zzKl().zzLY().log("Discarding data. Failed to send event to service");
                return;
            }
            if (this.zzbvK) {
                this.zzbvH.zza(zzc, this.zzbvL ? null : this.zzbuQ);
            } else {
                try {
                    if (TextUtils.isEmpty(this.zzbkW)) {
                        zzc.zza(this.zzbuQ, this.zzbvH.zzKb().zzfD(this.zzbvH.zzKl().zzMf()));
                    } else {
                        zzc.zza(this.zzbuQ, this.zzbkW, this.zzbvH.zzKl().zzMf());
                    }
                } catch (RemoteException e) {
                    this.zzbvH.zzKl().zzLY().zzj("Failed to send event to the service", e);
                }
            }
            this.zzbvH.zzoo();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.8 */
    class C11008 implements Runnable {
        final /* synthetic */ zzaul zzbvH;
        final /* synthetic */ boolean zzbvK;
        final /* synthetic */ boolean zzbvL;
        final /* synthetic */ zzatg zzbvM;
        final /* synthetic */ zzatg zzbvN;

        C11008(zzaul com_google_android_gms_internal_zzaul, boolean z, boolean z2, zzatg com_google_android_gms_internal_zzatg, zzatg com_google_android_gms_internal_zzatg2) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            this.zzbvK = z;
            this.zzbvL = z2;
            this.zzbvM = com_google_android_gms_internal_zzatg;
            this.zzbvN = com_google_android_gms_internal_zzatg2;
        }

        public void run() {
            zzatt zzc = this.zzbvH.zzbvB;
            if (zzc == null) {
                this.zzbvH.zzKl().zzLY().log("Discarding data. Failed to send conditional user property to service");
                return;
            }
            if (this.zzbvK) {
                this.zzbvH.zza(zzc, this.zzbvL ? null : this.zzbvM);
            } else {
                try {
                    if (TextUtils.isEmpty(this.zzbvN.packageName)) {
                        zzc.zza(this.zzbvM, this.zzbvH.zzKb().zzfD(this.zzbvH.zzKl().zzMf()));
                    } else {
                        zzc.zzb(this.zzbvM);
                    }
                } catch (RemoteException e) {
                    this.zzbvH.zzKl().zzLY().zzj("Failed to send conditional user property to the service", e);
                }
            }
            this.zzbvH.zzoo();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaul.9 */
    class C11019 implements Runnable {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ String zzbuP;
        final /* synthetic */ zzaul zzbvH;
        final /* synthetic */ AtomicReference zzbvI;

        C11019(zzaul com_google_android_gms_internal_zzaul, AtomicReference atomicReference, String str, String str2, String str3) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
            this.zzbvI = atomicReference;
            this.zzbkW = str;
            this.zzbuO = str2;
            this.zzbuP = str3;
        }

        public void run() {
            synchronized (this.zzbvI) {
                try {
                    zzatt zzc = this.zzbvH.zzbvB;
                    if (zzc == null) {
                        this.zzbvH.zzKl().zzLY().zzd("Failed to get conditional properties", zzatx.zzfE(this.zzbkW), this.zzbuO, this.zzbuP);
                        this.zzbvI.set(Collections.emptyList());
                        return;
                    }
                    if (TextUtils.isEmpty(this.zzbkW)) {
                        this.zzbvI.set(zzc.zza(this.zzbuO, this.zzbuP, this.zzbvH.zzKb().zzfD(this.zzbvH.zzKl().zzMf())));
                    } else {
                        this.zzbvI.set(zzc.zzn(this.zzbkW, this.zzbuO, this.zzbuP));
                    }
                    this.zzbvH.zzoo();
                    this.zzbvI.notify();
                } catch (RemoteException e) {
                    this.zzbvH.zzKl().zzLY().zzd("Failed to get conditional properties", zzatx.zzfE(this.zzbkW), this.zzbuO, e);
                    this.zzbvI.set(Collections.emptyList());
                } finally {
                    this.zzbvI.notify();
                }
            }
        }
    }

    protected class zza implements ServiceConnection, zzb, zzc {
        final /* synthetic */ zzaul zzbvH;
        private volatile boolean zzbvO;
        private volatile zzatw zzbvP;

        /* renamed from: com.google.android.gms.internal.zzaul.zza.1 */
        class C11021 implements Runnable {
            final /* synthetic */ zzatt zzbvQ;
            final /* synthetic */ zza zzbvR;

            C11021(zza com_google_android_gms_internal_zzaul_zza, zzatt com_google_android_gms_internal_zzatt) {
                this.zzbvR = com_google_android_gms_internal_zzaul_zza;
                this.zzbvQ = com_google_android_gms_internal_zzatt;
            }

            public void run() {
                synchronized (this.zzbvR) {
                    this.zzbvR.zzbvO = false;
                    if (!this.zzbvR.zzbvH.isConnected()) {
                        this.zzbvR.zzbvH.zzKl().zzMe().log("Connected to service");
                        this.zzbvR.zzbvH.zza(this.zzbvQ);
                    }
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzaul.zza.2 */
        class C11032 implements Runnable {
            final /* synthetic */ ComponentName val$name;
            final /* synthetic */ zza zzbvR;

            C11032(zza com_google_android_gms_internal_zzaul_zza, ComponentName componentName) {
                this.zzbvR = com_google_android_gms_internal_zzaul_zza;
                this.val$name = componentName;
            }

            public void run() {
                this.zzbvR.zzbvH.onServiceDisconnected(this.val$name);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzaul.zza.3 */
        class C11043 implements Runnable {
            final /* synthetic */ zza zzbvR;
            final /* synthetic */ zzatt zzbvS;

            C11043(zza com_google_android_gms_internal_zzaul_zza, zzatt com_google_android_gms_internal_zzatt) {
                this.zzbvR = com_google_android_gms_internal_zzaul_zza;
                this.zzbvS = com_google_android_gms_internal_zzatt;
            }

            public void run() {
                synchronized (this.zzbvR) {
                    this.zzbvR.zzbvO = false;
                    if (!this.zzbvR.zzbvH.isConnected()) {
                        this.zzbvR.zzbvH.zzKl().zzMd().log("Connected to remote service");
                        this.zzbvR.zzbvH.zza(this.zzbvS);
                    }
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzaul.zza.4 */
        class C11054 implements Runnable {
            final /* synthetic */ zza zzbvR;

            C11054(zza com_google_android_gms_internal_zzaul_zza) {
                this.zzbvR = com_google_android_gms_internal_zzaul_zza;
            }

            public void run() {
                zzaul com_google_android_gms_internal_zzaul = this.zzbvR.zzbvH;
                Context context = this.zzbvR.zzbvH.getContext();
                this.zzbvR.zzbvH.zzKn().zzLg();
                com_google_android_gms_internal_zzaul.onServiceDisconnected(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
            }
        }

        protected zza(zzaul com_google_android_gms_internal_zzaul) {
            this.zzbvH = com_google_android_gms_internal_zzaul;
        }

        @MainThread
        public void onConnected(@Nullable Bundle bundle) {
            zzac.zzdj("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    zzatt com_google_android_gms_internal_zzatt = (zzatt) this.zzbvP.zzxD();
                    this.zzbvP = null;
                    this.zzbvH.zzKk().zzm(new C11043(this, com_google_android_gms_internal_zzatt));
                } catch (DeadObjectException e) {
                    this.zzbvP = null;
                    this.zzbvO = false;
                } catch (IllegalStateException e2) {
                    this.zzbvP = null;
                    this.zzbvO = false;
                }
            }
        }

        @MainThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzac.zzdj("MeasurementServiceConnection.onConnectionFailed");
            zzatx zzMu = this.zzbvH.zzbqc.zzMu();
            if (zzMu != null) {
                zzMu.zzMa().zzj("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.zzbvO = false;
                this.zzbvP = null;
            }
        }

        @MainThread
        public void onConnectionSuspended(int i) {
            zzac.zzdj("MeasurementServiceConnection.onConnectionSuspended");
            this.zzbvH.zzKl().zzMd().log("Service connection suspended");
            this.zzbvH.zzKk().zzm(new C11054(this));
        }

        @MainThread
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzac.zzdj("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.zzbvO = false;
                    this.zzbvH.zzKl().zzLY().log("Service connected with null binder");
                    return;
                }
                zzatt com_google_android_gms_internal_zzatt = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        com_google_android_gms_internal_zzatt = com.google.android.gms.internal.zzatt.zza.zzes(iBinder);
                        this.zzbvH.zzKl().zzMe().log("Bound to IMeasurementService interface");
                    } else {
                        this.zzbvH.zzKl().zzLY().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.zzbvH.zzKl().zzLY().log("Service connect failed to get IMeasurementService");
                }
                if (com_google_android_gms_internal_zzatt == null) {
                    this.zzbvO = false;
                    try {
                        com.google.android.gms.common.stats.zza.zzyJ().zza(this.zzbvH.getContext(), this.zzbvH.zzbvA);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.zzbvH.zzKk().zzm(new C11021(this, com_google_android_gms_internal_zzatt));
                }
                return;
            }
        }

        @MainThread
        public void onServiceDisconnected(ComponentName componentName) {
            zzac.zzdj("MeasurementServiceConnection.onServiceDisconnected");
            this.zzbvH.zzKl().zzMd().log("Service disconnected");
            this.zzbvH.zzKk().zzm(new C11032(this, componentName));
        }

        @WorkerThread
        public void zzNb() {
            this.zzbvH.zzmR();
            Context context = this.zzbvH.getContext();
            synchronized (this) {
                if (this.zzbvO) {
                    this.zzbvH.zzKl().zzMe().log("Connection attempt already in progress");
                } else if (this.zzbvP != null) {
                    this.zzbvH.zzKl().zzMe().log("Already awaiting connection attempt");
                } else {
                    this.zzbvP = new zzatw(context, Looper.getMainLooper(), this, this);
                    this.zzbvH.zzKl().zzMe().log("Connecting to remote service");
                    this.zzbvO = true;
                    this.zzbvP.zzxz();
                }
            }
        }

        @WorkerThread
        public void zzz(Intent intent) {
            this.zzbvH.zzmR();
            Context context = this.zzbvH.getContext();
            com.google.android.gms.common.stats.zza zzyJ = com.google.android.gms.common.stats.zza.zzyJ();
            synchronized (this) {
                if (this.zzbvO) {
                    this.zzbvH.zzKl().zzMe().log("Connection attempt already in progress");
                    return;
                }
                this.zzbvO = true;
                zzyJ.zza(context, intent, this.zzbvH.zzbvA, 129);
            }
        }
    }

    protected zzaul(zzaue com_google_android_gms_internal_zzaue) {
        super(com_google_android_gms_internal_zzaue);
        this.zzbvF = new ArrayList();
        this.zzbvE = new zzauo(com_google_android_gms_internal_zzaue.zznR());
        this.zzbvA = new zza(this);
        this.zzbvD = new C10931(this, com_google_android_gms_internal_zzaue);
        this.zzbvG = new C10975(this, com_google_android_gms_internal_zzaue);
    }

    @WorkerThread
    private void onServiceDisconnected(ComponentName componentName) {
        zzmR();
        if (this.zzbvB != null) {
            this.zzbvB = null;
            zzKl().zzMe().zzj("Disconnected from device MeasurementService", componentName);
            zzMZ();
        }
    }

    private boolean zzMX() {
        zzKn().zzLg();
        List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), AccessibilityNodeInfoCompat.ACTION_CUT);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    @WorkerThread
    private void zzMZ() {
        zzmR();
        zzoD();
    }

    @WorkerThread
    private void zzNa() {
        zzmR();
        zzKl().zzMe().zzj("Processing queued up service tasks", Integer.valueOf(this.zzbvF.size()));
        for (Runnable zzm : this.zzbvF) {
            zzKk().zzm(zzm);
        }
        this.zzbvF.clear();
        this.zzbvG.cancel();
    }

    @WorkerThread
    private void zzo(Runnable runnable) {
        zzmR();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzbvF.size()) >= zzKn().zzLm()) {
            zzKl().zzLY().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzbvF.add(runnable);
            this.zzbvG.zzy(60000);
            zzoD();
        }
    }

    @WorkerThread
    private void zzoo() {
        zzmR();
        this.zzbvE.start();
        this.zzbvD.zzy(zzKn().zzpq());
    }

    @WorkerThread
    private void zzop() {
        zzmR();
        if (isConnected()) {
            zzKl().zzMe().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @WorkerThread
    public void disconnect() {
        zzmR();
        zzob();
        try {
            com.google.android.gms.common.stats.zza.zzyJ().zza(getContext(), this.zzbvA);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.zzbvB = null;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public boolean isConnected() {
        zzmR();
        zzob();
        return this.zzbvB != null;
    }

    public /* bridge */ /* synthetic */ void zzJV() {
        super.zzJV();
    }

    public /* bridge */ /* synthetic */ void zzJW() {
        super.zzJW();
    }

    public /* bridge */ /* synthetic */ void zzJX() {
        super.zzJX();
    }

    public /* bridge */ /* synthetic */ zzatb zzJY() {
        return super.zzJY();
    }

    public /* bridge */ /* synthetic */ zzatf zzJZ() {
        return super.zzJZ();
    }

    public /* bridge */ /* synthetic */ zzauj zzKa() {
        return super.zzKa();
    }

    public /* bridge */ /* synthetic */ zzatu zzKb() {
        return super.zzKb();
    }

    public /* bridge */ /* synthetic */ zzatl zzKc() {
        return super.zzKc();
    }

    public /* bridge */ /* synthetic */ zzaul zzKd() {
        return super.zzKd();
    }

    public /* bridge */ /* synthetic */ zzauk zzKe() {
        return super.zzKe();
    }

    public /* bridge */ /* synthetic */ zzatv zzKf() {
        return super.zzKf();
    }

    public /* bridge */ /* synthetic */ zzatj zzKg() {
        return super.zzKg();
    }

    public /* bridge */ /* synthetic */ zzaut zzKh() {
        return super.zzKh();
    }

    public /* bridge */ /* synthetic */ zzauc zzKi() {
        return super.zzKi();
    }

    public /* bridge */ /* synthetic */ zzaun zzKj() {
        return super.zzKj();
    }

    public /* bridge */ /* synthetic */ zzaud zzKk() {
        return super.zzKk();
    }

    public /* bridge */ /* synthetic */ zzatx zzKl() {
        return super.zzKl();
    }

    public /* bridge */ /* synthetic */ zzaua zzKm() {
        return super.zzKm();
    }

    public /* bridge */ /* synthetic */ zzati zzKn() {
        return super.zzKn();
    }

    @WorkerThread
    protected void zzMR() {
        zzmR();
        zzob();
        zzo(new C10953(this));
    }

    @WorkerThread
    protected void zzMW() {
        zzmR();
        zzob();
        zzo(new C10986(this));
    }

    @WorkerThread
    protected boolean zzMY() {
        zzmR();
        zzob();
        zzKn().zzLg();
        zzKl().zzMe().log("Checking service availability");
        switch (zze.zzuY().isGooglePlayServicesAvailable(getContext())) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                zzKl().zzMe().log("Service available");
                return true;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                zzKl().zzMe().log("Service missing");
                return false;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                zzKl().zzMd().log("Service container out of date");
                return true;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                zzKl().zzMa().log("Service disabled");
                return false;
            case ConnectionResult.SERVICE_INVALID /*9*/:
                zzKl().zzMa().log("Service invalid");
                return false;
            case CommonStatusCodes.DEAD_CLIENT /*18*/:
                zzKl().zzMa().log("Service updating");
                return true;
            default:
                return false;
        }
    }

    @WorkerThread
    protected void zza(zzatt com_google_android_gms_internal_zzatt) {
        zzmR();
        zzac.zzw(com_google_android_gms_internal_zzatt);
        this.zzbvB = com_google_android_gms_internal_zzatt;
        zzoo();
        zzNa();
    }

    @WorkerThread
    void zza(zzatt com_google_android_gms_internal_zzatt, com.google.android.gms.common.internal.safeparcel.zza com_google_android_gms_common_internal_safeparcel_zza) {
        zzmR();
        zzJW();
        zzob();
        int i = VERSION.SDK_INT;
        zzKn().zzLg();
        List<com.google.android.gms.common.internal.safeparcel.zza> arrayList = new ArrayList();
        zzKn().zzLp();
        int i2 = 100;
        for (int i3 = 0; i3 < PointerIconCompat.TYPE_CONTEXT_MENU && r1 == 100; i3++) {
            Object zzlD = zzKf().zzlD(100);
            if (zzlD != null) {
                arrayList.addAll(zzlD);
                i2 = zzlD.size();
            } else {
                i2 = 0;
            }
            if (com_google_android_gms_common_internal_safeparcel_zza != null && r1 < 100) {
                arrayList.add(com_google_android_gms_common_internal_safeparcel_zza);
            }
            for (com.google.android.gms.common.internal.safeparcel.zza com_google_android_gms_common_internal_safeparcel_zza2 : arrayList) {
                if (com_google_android_gms_common_internal_safeparcel_zza2 instanceof zzatq) {
                    try {
                        com_google_android_gms_internal_zzatt.zza((zzatq) com_google_android_gms_common_internal_safeparcel_zza2, zzKb().zzfD(zzKl().zzMf()));
                    } catch (RemoteException e) {
                        zzKl().zzLY().zzj("Failed to send event to the service", e);
                    }
                } else if (com_google_android_gms_common_internal_safeparcel_zza2 instanceof zzauq) {
                    try {
                        com_google_android_gms_internal_zzatt.zza((zzauq) com_google_android_gms_common_internal_safeparcel_zza2, zzKb().zzfD(zzKl().zzMf()));
                    } catch (RemoteException e2) {
                        zzKl().zzLY().zzj("Failed to send attribute to the service", e2);
                    }
                } else if (com_google_android_gms_common_internal_safeparcel_zza2 instanceof zzatg) {
                    try {
                        com_google_android_gms_internal_zzatt.zza((zzatg) com_google_android_gms_common_internal_safeparcel_zza2, zzKb().zzfD(zzKl().zzMf()));
                    } catch (RemoteException e22) {
                        zzKl().zzLY().zzj("Failed to send conditional property to the service", e22);
                    }
                } else {
                    zzKl().zzLY().log("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }

    @WorkerThread
    protected void zza(zzf com_google_android_gms_measurement_AppMeasurement_zzf) {
        zzmR();
        zzob();
        zzo(new C10964(this, com_google_android_gms_measurement_AppMeasurement_zzf));
    }

    @WorkerThread
    public void zza(AtomicReference<String> atomicReference) {
        zzmR();
        zzob();
        zzo(new C10942(this, atomicReference));
    }

    @WorkerThread
    protected void zza(AtomicReference<List<zzatg>> atomicReference, String str, String str2, String str3) {
        zzmR();
        zzob();
        zzo(new C11019(this, atomicReference, str, str2, str3));
    }

    @WorkerThread
    protected void zza(AtomicReference<List<zzauq>> atomicReference, String str, String str2, String str3, boolean z) {
        zzmR();
        zzob();
        zzo(new AnonymousClass10(this, atomicReference, str, str2, str3, z));
    }

    @WorkerThread
    protected void zza(AtomicReference<List<zzauq>> atomicReference, boolean z) {
        zzmR();
        zzob();
        zzo(new AnonymousClass12(this, atomicReference, z));
    }

    @WorkerThread
    protected void zzb(zzauq com_google_android_gms_internal_zzauq) {
        zzmR();
        zzob();
        int i = VERSION.SDK_INT;
        zzKn().zzLg();
        zzo(new AnonymousClass11(this, zzKf().zza(com_google_android_gms_internal_zzauq), com_google_android_gms_internal_zzauq));
    }

    @WorkerThread
    protected void zzc(zzatq com_google_android_gms_internal_zzatq, String str) {
        zzac.zzw(com_google_android_gms_internal_zzatq);
        zzmR();
        zzob();
        int i = VERSION.SDK_INT;
        zzKn().zzLg();
        zzo(new C10997(this, true, zzKf().zza(com_google_android_gms_internal_zzatq), com_google_android_gms_internal_zzatq, str));
    }

    @WorkerThread
    protected void zzf(zzatg com_google_android_gms_internal_zzatg) {
        zzac.zzw(com_google_android_gms_internal_zzatg);
        zzmR();
        zzob();
        zzKn().zzLg();
        zzo(new C11008(this, true, zzKf().zzc(com_google_android_gms_internal_zzatg), new zzatg(com_google_android_gms_internal_zzatg), com_google_android_gms_internal_zzatg));
    }

    public /* bridge */ /* synthetic */ void zzmR() {
        super.zzmR();
    }

    protected void zzmS() {
    }

    public /* bridge */ /* synthetic */ com.google.android.gms.common.util.zze zznR() {
        return super.zznR();
    }

    @WorkerThread
    void zzoD() {
        zzmR();
        zzob();
        if (!isConnected()) {
            if (this.zzbvC == null) {
                this.zzbvC = zzKm().zzMm();
                if (this.zzbvC == null) {
                    zzKl().zzMe().log("State of service unknown");
                    this.zzbvC = Boolean.valueOf(zzMY());
                    zzKm().zzaK(this.zzbvC.booleanValue());
                }
            }
            if (this.zzbvC.booleanValue()) {
                zzKl().zzMe().log("Using measurement service");
                this.zzbvA.zzNb();
            } else if (zzMX()) {
                zzKl().zzMe().log("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context context = getContext();
                zzKn().zzLg();
                intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
                this.zzbvA.zzz(intent);
            } else {
                zzKl().zzLY().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }
}
