package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public class zzaar implements zzaau {
    private final Context mContext;
    private final Lock zzaAG;
    private final zzg zzaAL;
    private final Map<Api<?>, Boolean> zzaAO;
    private final com.google.android.gms.common.zze zzaAQ;
    private ConnectionResult zzaAZ;
    private final zzaav zzaBk;
    private int zzaBn;
    private int zzaBo;
    private int zzaBp;
    private final Bundle zzaBq;
    private final Set<com.google.android.gms.common.api.Api.zzc> zzaBr;
    private zzbai zzaBs;
    private boolean zzaBt;
    private boolean zzaBu;
    private boolean zzaBv;
    private zzr zzaBw;
    private boolean zzaBx;
    private boolean zzaBy;
    private ArrayList<Future<?>> zzaBz;
    private final com.google.android.gms.common.api.Api.zza<? extends zzbai, zzbaj> zzazo;

    /* renamed from: com.google.android.gms.internal.zzaar.1 */
    class C10251 implements Runnable {
        final /* synthetic */ zzaar zzaBA;

        C10251(zzaar com_google_android_gms_internal_zzaar) {
            this.zzaBA = com_google_android_gms_internal_zzaar;
        }

        public void run() {
            this.zzaBA.zzaAQ.zzaF(this.zzaBA.mContext);
        }
    }

    private static class zza implements com.google.android.gms.common.internal.zzf.zzf {
        private final boolean zzaAu;
        private final WeakReference<zzaar> zzaBB;
        private final Api<?> zzaxf;

        public zza(zzaar com_google_android_gms_internal_zzaar, Api<?> api, boolean z) {
            this.zzaBB = new WeakReference(com_google_android_gms_internal_zzaar);
            this.zzaxf = api;
            this.zzaAu = z;
        }

        public void zzg(@NonNull ConnectionResult connectionResult) {
            boolean z = false;
            zzaar com_google_android_gms_internal_zzaar = (zzaar) this.zzaBB.get();
            if (com_google_android_gms_internal_zzaar != null) {
                if (Looper.myLooper() == com_google_android_gms_internal_zzaar.zzaBk.zzaAw.getLooper()) {
                    z = true;
                }
                zzac.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                com_google_android_gms_internal_zzaar.zzaAG.lock();
                try {
                    if (com_google_android_gms_internal_zzaar.zzcB(0)) {
                        if (!connectionResult.isSuccess()) {
                            com_google_android_gms_internal_zzaar.zzb(connectionResult, this.zzaxf, this.zzaAu);
                        }
                        if (com_google_android_gms_internal_zzaar.zzwf()) {
                            com_google_android_gms_internal_zzaar.zzwg();
                        }
                        com_google_android_gms_internal_zzaar.zzaAG.unlock();
                    }
                } finally {
                    com_google_android_gms_internal_zzaar.zzaAG.unlock();
                }
            }
        }
    }

    private abstract class zzf implements Runnable {
        final /* synthetic */ zzaar zzaBA;

        private zzf(zzaar com_google_android_gms_internal_zzaar) {
            this.zzaBA = com_google_android_gms_internal_zzaar;
        }

        @WorkerThread
        public void run() {
            this.zzaBA.zzaAG.lock();
            try {
                if (!Thread.interrupted()) {
                    zzwe();
                    this.zzaBA.zzaAG.unlock();
                }
            } catch (RuntimeException e) {
                this.zzaBA.zzaBk.zza(e);
            } finally {
                this.zzaBA.zzaAG.unlock();
            }
        }

        @WorkerThread
        protected abstract void zzwe();
    }

    private class zzb extends zzf {
        final /* synthetic */ zzaar zzaBA;
        private final Map<com.google.android.gms.common.api.Api.zze, zza> zzaBC;

        /* renamed from: com.google.android.gms.internal.zzaar.zzb.1 */
        class C10261 extends zza {
            final /* synthetic */ ConnectionResult zzaBD;
            final /* synthetic */ zzb zzaBE;

            C10261(zzb com_google_android_gms_internal_zzaar_zzb, zzaau com_google_android_gms_internal_zzaau, ConnectionResult connectionResult) {
                this.zzaBE = com_google_android_gms_internal_zzaar_zzb;
                this.zzaBD = connectionResult;
                super(com_google_android_gms_internal_zzaau);
            }

            public void zzwe() {
                this.zzaBE.zzaBA.zzf(this.zzaBD);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzaar.zzb.2 */
        class C10272 extends zza {
            final /* synthetic */ com.google.android.gms.common.internal.zzf.zzf zzaBF;

            C10272(zzb com_google_android_gms_internal_zzaar_zzb, zzaau com_google_android_gms_internal_zzaau, com.google.android.gms.common.internal.zzf.zzf com_google_android_gms_common_internal_zzf_zzf) {
                this.zzaBF = com_google_android_gms_common_internal_zzf_zzf;
                super(com_google_android_gms_internal_zzaau);
            }

            public void zzwe() {
                this.zzaBF.zzg(new ConnectionResult(16, null));
            }
        }

        public zzb(zzaar com_google_android_gms_internal_zzaar, Map<com.google.android.gms.common.api.Api.zze, zza> map) {
            this.zzaBA = com_google_android_gms_internal_zzaar;
            super(null);
            this.zzaBC = map;
        }

        @WorkerThread
        public void zzwe() {
            int i;
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            for (com.google.android.gms.common.api.Api.zze com_google_android_gms_common_api_Api_zze : this.zzaBC.keySet()) {
                if (!com_google_android_gms_common_api_Api_zze.zzvh()) {
                    i = 0;
                    i4 = i5;
                } else if (!((zza) this.zzaBC.get(com_google_android_gms_common_api_Api_zze)).zzaAu) {
                    i = 1;
                    break;
                } else {
                    i = i4;
                    i4 = 1;
                }
                i5 = i4;
                i4 = i;
            }
            i2 = i5;
            i = 0;
            if (i2 != 0) {
                i3 = this.zzaBA.zzaAQ.isGooglePlayServicesAvailable(this.zzaBA.mContext);
            }
            if (i3 == 0 || (r0 == 0 && i4 == 0)) {
                if (this.zzaBA.zzaBu) {
                    this.zzaBA.zzaBs.connect();
                }
                for (com.google.android.gms.common.api.Api.zze com_google_android_gms_common_api_Api_zze2 : this.zzaBC.keySet()) {
                    com.google.android.gms.common.internal.zzf.zzf com_google_android_gms_common_internal_zzf_zzf = (com.google.android.gms.common.internal.zzf.zzf) this.zzaBC.get(com_google_android_gms_common_api_Api_zze2);
                    if (!com_google_android_gms_common_api_Api_zze2.zzvh() || i3 == 0) {
                        com_google_android_gms_common_api_Api_zze2.zza(com_google_android_gms_common_internal_zzf_zzf);
                    } else {
                        this.zzaBA.zzaBk.zza(new C10272(this, this.zzaBA, com_google_android_gms_common_internal_zzf_zzf));
                    }
                }
                return;
            }
            this.zzaBA.zzaBk.zza(new C10261(this, this.zzaBA, new ConnectionResult(i3, null)));
        }
    }

    private class zzc extends zzf {
        final /* synthetic */ zzaar zzaBA;
        private final ArrayList<com.google.android.gms.common.api.Api.zze> zzaBG;

        public zzc(zzaar com_google_android_gms_internal_zzaar, ArrayList<com.google.android.gms.common.api.Api.zze> arrayList) {
            this.zzaBA = com_google_android_gms_internal_zzaar;
            super(null);
            this.zzaBG = arrayList;
        }

        @WorkerThread
        public void zzwe() {
            this.zzaBA.zzaBk.zzaAw.zzaBR = this.zzaBA.zzwl();
            Iterator it = this.zzaBG.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zze) it.next()).zza(this.zzaBA.zzaBw, this.zzaBA.zzaBk.zzaAw.zzaBR);
            }
        }
    }

    private static class zzd extends zzbam {
        private final WeakReference<zzaar> zzaBB;

        /* renamed from: com.google.android.gms.internal.zzaar.zzd.1 */
        class C10281 extends zza {
            final /* synthetic */ zzaar zzaBH;
            final /* synthetic */ zzbaw zzaBI;

            C10281(zzd com_google_android_gms_internal_zzaar_zzd, zzaau com_google_android_gms_internal_zzaau, zzaar com_google_android_gms_internal_zzaar, zzbaw com_google_android_gms_internal_zzbaw) {
                this.zzaBH = com_google_android_gms_internal_zzaar;
                this.zzaBI = com_google_android_gms_internal_zzbaw;
                super(com_google_android_gms_internal_zzaau);
            }

            public void zzwe() {
                this.zzaBH.zza(this.zzaBI);
            }
        }

        zzd(zzaar com_google_android_gms_internal_zzaar) {
            this.zzaBB = new WeakReference(com_google_android_gms_internal_zzaar);
        }

        @BinderThread
        public void zzb(zzbaw com_google_android_gms_internal_zzbaw) {
            zzaar com_google_android_gms_internal_zzaar = (zzaar) this.zzaBB.get();
            if (com_google_android_gms_internal_zzaar != null) {
                com_google_android_gms_internal_zzaar.zzaBk.zza(new C10281(this, com_google_android_gms_internal_zzaar, com_google_android_gms_internal_zzaar, com_google_android_gms_internal_zzbaw));
            }
        }
    }

    private class zze implements ConnectionCallbacks, OnConnectionFailedListener {
        final /* synthetic */ zzaar zzaBA;

        private zze(zzaar com_google_android_gms_internal_zzaar) {
            this.zzaBA = com_google_android_gms_internal_zzaar;
        }

        public void onConnected(Bundle bundle) {
            this.zzaBA.zzaBs.zza(new zzd(this.zzaBA));
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            this.zzaBA.zzaAG.lock();
            try {
                if (this.zzaBA.zze(connectionResult)) {
                    this.zzaBA.zzwj();
                    this.zzaBA.zzwg();
                } else {
                    this.zzaBA.zzf(connectionResult);
                }
                this.zzaBA.zzaAG.unlock();
            } catch (Throwable th) {
                this.zzaBA.zzaAG.unlock();
            }
        }

        public void onConnectionSuspended(int i) {
        }
    }

    public zzaar(zzaav com_google_android_gms_internal_zzaav, zzg com_google_android_gms_common_internal_zzg, Map<Api<?>, Boolean> map, com.google.android.gms.common.zze com_google_android_gms_common_zze, com.google.android.gms.common.api.Api.zza<? extends zzbai, zzbaj> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzbai__com_google_android_gms_internal_zzbaj, Lock lock, Context context) {
        this.zzaBo = 0;
        this.zzaBq = new Bundle();
        this.zzaBr = new HashSet();
        this.zzaBz = new ArrayList();
        this.zzaBk = com_google_android_gms_internal_zzaav;
        this.zzaAL = com_google_android_gms_common_internal_zzg;
        this.zzaAO = map;
        this.zzaAQ = com_google_android_gms_common_zze;
        this.zzazo = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzbai__com_google_android_gms_internal_zzbaj;
        this.zzaAG = lock;
        this.mContext = context;
    }

    private void zza(zzbaw com_google_android_gms_internal_zzbaw) {
        if (zzcB(0)) {
            ConnectionResult zzyh = com_google_android_gms_internal_zzbaw.zzyh();
            if (zzyh.isSuccess()) {
                zzaf zzPU = com_google_android_gms_internal_zzbaw.zzPU();
                ConnectionResult zzyh2 = zzPU.zzyh();
                if (zzyh2.isSuccess()) {
                    this.zzaBv = true;
                    this.zzaBw = zzPU.zzyg();
                    this.zzaBx = zzPU.zzyi();
                    this.zzaBy = zzPU.zzyj();
                    zzwg();
                    return;
                }
                String valueOf = String.valueOf(zzyh2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                zzf(zzyh2);
            } else if (zze(zzyh)) {
                zzwj();
                zzwg();
            } else {
                zzf(zzyh);
            }
        }
    }

    private boolean zza(int i, boolean z, ConnectionResult connectionResult) {
        return (!z || zzd(connectionResult)) ? this.zzaAZ == null || i < this.zzaBn : false;
    }

    private void zzau(boolean z) {
        if (this.zzaBs != null) {
            if (this.zzaBs.isConnected() && z) {
                this.zzaBs.zzPJ();
            }
            this.zzaBs.disconnect();
            this.zzaBw = null;
        }
    }

    private void zzb(ConnectionResult connectionResult, Api<?> api, boolean z) {
        int priority = api.zzve().getPriority();
        if (zza(priority, z, connectionResult)) {
            this.zzaAZ = connectionResult;
            this.zzaBn = priority;
        }
        this.zzaBk.zzaCf.put(api.zzvg(), connectionResult);
    }

    private boolean zzcB(int i) {
        if (this.zzaBo == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.zzaBk.zzaAw.zzwr());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", "mRemainingConnections=" + this.zzaBp);
        valueOf = String.valueOf(zzcC(this.zzaBo));
        String valueOf2 = String.valueOf(zzcC(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(valueOf2).toString(), new Exception());
        zzf(new ConnectionResult(8, null));
        return false;
    }

    private String zzcC(int i) {
        switch (i) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private boolean zzd(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.zzaAQ.zzcw(connectionResult.getErrorCode()) != null;
    }

    private boolean zze(ConnectionResult connectionResult) {
        return this.zzaBt && !connectionResult.hasResolution();
    }

    private void zzf(ConnectionResult connectionResult) {
        zzwk();
        zzau(!connectionResult.hasResolution());
        this.zzaBk.zzh(connectionResult);
        this.zzaBk.zzaCj.zzc(connectionResult);
    }

    private boolean zzwf() {
        this.zzaBp--;
        if (this.zzaBp > 0) {
            return false;
        }
        if (this.zzaBp < 0) {
            Log.w("GoogleApiClientConnecting", this.zzaBk.zzaAw.zzwr());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzf(new ConnectionResult(8, null));
            return false;
        } else if (this.zzaAZ == null) {
            return true;
        } else {
            this.zzaBk.zzaCi = this.zzaBn;
            zzf(this.zzaAZ);
            return false;
        }
    }

    private void zzwg() {
        if (this.zzaBp == 0) {
            if (!this.zzaBu || this.zzaBv) {
                zzwh();
            }
        }
    }

    private void zzwh() {
        ArrayList arrayList = new ArrayList();
        this.zzaBo = 1;
        this.zzaBp = this.zzaBk.zzaBQ.size();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzaBk.zzaBQ.keySet()) {
            if (!this.zzaBk.zzaCf.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                arrayList.add((com.google.android.gms.common.api.Api.zze) this.zzaBk.zzaBQ.get(com_google_android_gms_common_api_Api_zzc));
            } else if (zzwf()) {
                zzwi();
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzaBz.add(zzaaw.zzwv().submit(new zzc(this, arrayList)));
        }
    }

    private void zzwi() {
        this.zzaBk.zzwt();
        zzaaw.zzwv().execute(new C10251(this));
        if (this.zzaBs != null) {
            if (this.zzaBx) {
                this.zzaBs.zza(this.zzaBw, this.zzaBy);
            }
            zzau(false);
        }
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzaBk.zzaCf.keySet()) {
            ((com.google.android.gms.common.api.Api.zze) this.zzaBk.zzaBQ.get(com_google_android_gms_common_api_Api_zzc)).disconnect();
        }
        this.zzaBk.zzaCj.zzo(this.zzaBq.isEmpty() ? null : this.zzaBq);
    }

    private void zzwj() {
        this.zzaBu = false;
        this.zzaBk.zzaAw.zzaBR = Collections.emptySet();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzaBr) {
            if (!this.zzaBk.zzaCf.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                this.zzaBk.zzaCf.put(com_google_android_gms_common_api_Api_zzc, new ConnectionResult(17, null));
            }
        }
    }

    private void zzwk() {
        Iterator it = this.zzaBz.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.zzaBz.clear();
    }

    private Set<Scope> zzwl() {
        if (this.zzaAL == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.zzaAL.zzxL());
        Map zzxN = this.zzaAL.zzxN();
        for (Api api : zzxN.keySet()) {
            if (!this.zzaBk.zzaCf.containsKey(api.zzvg())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zzg.zza) zzxN.get(api)).zzakq);
            }
        }
        return hashSet;
    }

    public void begin() {
        this.zzaBk.zzaCf.clear();
        this.zzaBu = false;
        this.zzaAZ = null;
        this.zzaBo = 0;
        this.zzaBt = true;
        this.zzaBv = false;
        this.zzaBx = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (Api api : this.zzaAO.keySet()) {
            com.google.android.gms.common.api.Api.zze com_google_android_gms_common_api_Api_zze = (com.google.android.gms.common.api.Api.zze) this.zzaBk.zzaBQ.get(api.zzvg());
            int i2 = (api.zzve().getPriority() == 1 ? 1 : 0) | i;
            boolean booleanValue = ((Boolean) this.zzaAO.get(api)).booleanValue();
            if (com_google_android_gms_common_api_Api_zze.zzrd()) {
                this.zzaBu = true;
                if (booleanValue) {
                    this.zzaBr.add(api.zzvg());
                } else {
                    this.zzaBt = false;
                }
            }
            hashMap.put(com_google_android_gms_common_api_Api_zze, new zza(this, api, booleanValue));
            i = i2;
        }
        if (i != 0) {
            this.zzaBu = false;
        }
        if (this.zzaBu) {
            this.zzaAL.zzc(Integer.valueOf(this.zzaBk.zzaAw.getSessionId()));
            ConnectionCallbacks com_google_android_gms_internal_zzaar_zze = new zze();
            this.zzaBs = (zzbai) this.zzazo.zza(this.mContext, this.zzaBk.zzaAw.getLooper(), this.zzaAL, this.zzaAL.zzxR(), com_google_android_gms_internal_zzaar_zze, com_google_android_gms_internal_zzaar_zze);
        }
        this.zzaBp = this.zzaBk.zzaBQ.size();
        this.zzaBz.add(zzaaw.zzwv().submit(new zzb(this, hashMap)));
    }

    public void connect() {
    }

    public boolean disconnect() {
        zzwk();
        zzau(true);
        this.zzaBk.zzh(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
        if (zzcB(1)) {
            if (bundle != null) {
                this.zzaBq.putAll(bundle);
            }
            if (zzwf()) {
                zzwi();
            }
        }
    }

    public void onConnectionSuspended(int i) {
        zzf(new ConnectionResult(8, null));
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzaad.zza<R, A>> T zza(T t) {
        this.zzaBk.zzaAw.zzaAU.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zzcB(1)) {
            zzb(connectionResult, api, z);
            if (zzwf()) {
                zzwi();
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzaad.zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
