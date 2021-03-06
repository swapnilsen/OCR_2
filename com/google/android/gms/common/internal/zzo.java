package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

final class zzo extends zzn implements Callback {
    private final Handler mHandler;
    private final HashMap<zza, zza> zzaGf;
    private final com.google.android.gms.common.stats.zza zzaGg;
    private final long zzaGh;
    private final long zzaGi;
    private final Context zzwi;

    private final class zza implements ServiceConnection {
        private int mState;
        private IBinder zzaFz;
        private ComponentName zzaGe;
        private final Set<ServiceConnection> zzaGj;
        private boolean zzaGk;
        private final zza zzaGl;
        final /* synthetic */ zzo zzaGm;

        public zza(zzo com_google_android_gms_common_internal_zzo, zza com_google_android_gms_common_internal_zzn_zza) {
            this.zzaGm = com_google_android_gms_common_internal_zzo;
            this.zzaGl = com_google_android_gms_common_internal_zzn_zza;
            this.zzaGj = new HashSet();
            this.mState = 2;
        }

        public IBinder getBinder() {
            return this.zzaFz;
        }

        public ComponentName getComponentName() {
            return this.zzaGe;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzaGk;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this.zzaGm.zzaGf) {
                this.zzaGm.mHandler.removeMessages(1, this.zzaGl);
                this.zzaFz = iBinder;
                this.zzaGe = componentName;
                for (ServiceConnection onServiceConnected : this.zzaGj) {
                    onServiceConnected.onServiceConnected(componentName, iBinder);
                }
                this.mState = 1;
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.zzaGm.zzaGf) {
                this.zzaGm.mHandler.removeMessages(1, this.zzaGl);
                this.zzaFz = null;
                this.zzaGe = componentName;
                for (ServiceConnection onServiceDisconnected : this.zzaGj) {
                    onServiceDisconnected.onServiceDisconnected(componentName);
                }
                this.mState = 2;
            }
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            this.zzaGm.zzaGg.zza(this.zzaGm.zzwi, serviceConnection, str, this.zzaGl.zzxZ());
            this.zzaGj.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzaGj.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            this.zzaGm.zzaGg.zzb(this.zzaGm.zzwi, serviceConnection);
            this.zzaGj.remove(serviceConnection);
        }

        public void zzdn(String str) {
            this.mState = 3;
            this.zzaGk = this.zzaGm.zzaGg.zza(this.zzaGm.zzwi, str, this.zzaGl.zzxZ(), this, 129);
            if (this.zzaGk) {
                this.zzaGm.mHandler.sendMessageDelayed(this.zzaGm.mHandler.obtainMessage(1, this.zzaGl), this.zzaGm.zzaGi);
                return;
            }
            this.mState = 2;
            try {
                this.zzaGm.zzaGg.zza(this.zzaGm.zzwi, this);
            } catch (IllegalArgumentException e) {
            }
        }

        public void zzdo(String str) {
            this.zzaGm.mHandler.removeMessages(1, this.zzaGl);
            this.zzaGm.zzaGg.zza(this.zzaGm.zzwi, this);
            this.zzaGk = false;
            this.mState = 2;
        }

        public boolean zzya() {
            return this.zzaGj.isEmpty();
        }
    }

    zzo(Context context) {
        this.zzaGf = new HashMap();
        this.zzwi = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzaGg = com.google.android.gms.common.stats.zza.zzyJ();
        this.zzaGh = 5000;
        this.zzaGi = 300000;
    }

    public boolean handleMessage(Message message) {
        zza com_google_android_gms_common_internal_zzn_zza;
        zza com_google_android_gms_common_internal_zzo_zza;
        switch (message.what) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                synchronized (this.zzaGf) {
                    com_google_android_gms_common_internal_zzn_zza = (zza) message.obj;
                    com_google_android_gms_common_internal_zzo_zza = (zza) this.zzaGf.get(com_google_android_gms_common_internal_zzn_zza);
                    if (com_google_android_gms_common_internal_zzo_zza != null && com_google_android_gms_common_internal_zzo_zza.zzya()) {
                        if (com_google_android_gms_common_internal_zzo_zza.isBound()) {
                            com_google_android_gms_common_internal_zzo_zza.zzdo("GmsClientSupervisor");
                        }
                        this.zzaGf.remove(com_google_android_gms_common_internal_zzn_zza);
                    }
                    break;
                }
                return true;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                synchronized (this.zzaGf) {
                    com_google_android_gms_common_internal_zzn_zza = (zza) message.obj;
                    com_google_android_gms_common_internal_zzo_zza = (zza) this.zzaGf.get(com_google_android_gms_common_internal_zzn_zza);
                    if (com_google_android_gms_common_internal_zzo_zza != null && com_google_android_gms_common_internal_zzo_zza.getState() == 3) {
                        String valueOf = String.valueOf(com_google_android_gms_common_internal_zzn_zza);
                        Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                        ComponentName componentName = com_google_android_gms_common_internal_zzo_zza.getComponentName();
                        if (componentName == null) {
                            componentName = com_google_android_gms_common_internal_zzn_zza.getComponentName();
                        }
                        com_google_android_gms_common_internal_zzo_zza.onServiceDisconnected(componentName == null ? new ComponentName(com_google_android_gms_common_internal_zzn_zza.getPackage(), EnvironmentCompat.MEDIA_UNKNOWN) : componentName);
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }

    protected boolean zza(zza com_google_android_gms_common_internal_zzn_zza, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzac.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzaGf) {
            zza com_google_android_gms_common_internal_zzo_zza = (zza) this.zzaGf.get(com_google_android_gms_common_internal_zzn_zza);
            if (com_google_android_gms_common_internal_zzo_zza != null) {
                this.mHandler.removeMessages(0, com_google_android_gms_common_internal_zzn_zza);
                if (!com_google_android_gms_common_internal_zzo_zza.zza(serviceConnection)) {
                    com_google_android_gms_common_internal_zzo_zza.zza(serviceConnection, str);
                    switch (com_google_android_gms_common_internal_zzo_zza.getState()) {
                        case NendIconError.ERROR_ICONVIEW /*1*/:
                            serviceConnection.onServiceConnected(com_google_android_gms_common_internal_zzo_zza.getComponentName(), com_google_android_gms_common_internal_zzo_zza.getBinder());
                            break;
                        case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            com_google_android_gms_common_internal_zzo_zza.zzdn(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(com_google_android_gms_common_internal_zzn_zza);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            com_google_android_gms_common_internal_zzo_zza = new zza(this, com_google_android_gms_common_internal_zzn_zza);
            com_google_android_gms_common_internal_zzo_zza.zza(serviceConnection, str);
            com_google_android_gms_common_internal_zzo_zza.zzdn(str);
            this.zzaGf.put(com_google_android_gms_common_internal_zzn_zza, com_google_android_gms_common_internal_zzo_zza);
            isBound = com_google_android_gms_common_internal_zzo_zza.isBound();
        }
        return isBound;
    }

    protected void zzb(zza com_google_android_gms_common_internal_zzn_zza, ServiceConnection serviceConnection, String str) {
        zzac.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzaGf) {
            zza com_google_android_gms_common_internal_zzo_zza = (zza) this.zzaGf.get(com_google_android_gms_common_internal_zzn_zza);
            String valueOf;
            if (com_google_android_gms_common_internal_zzo_zza == null) {
                valueOf = String.valueOf(com_google_android_gms_common_internal_zzn_zza);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (com_google_android_gms_common_internal_zzo_zza.zza(serviceConnection)) {
                com_google_android_gms_common_internal_zzo_zza.zzb(serviceConnection, str);
                if (com_google_android_gms_common_internal_zzo_zza.zzya()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, com_google_android_gms_common_internal_zzn_zza), this.zzaGh);
                }
            } else {
                valueOf = String.valueOf(com_google_android_gms_common_internal_zzn_zza);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }
}
