package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

class zzo implements ContainerHolder {
    private boolean zzaLQ;
    private Status zzair;
    private Container zzbFc;
    private Container zzbFd;
    private zzb zzbFe;
    private zza zzbFf;
    private TagManager zzbFg;
    private final Looper zzrs;

    public interface zza {
        String zzQh();

        void zzQj();

        void zzgW(String str);
    }

    private class zzb extends Handler {
        private final ContainerAvailableListener zzbFh;
        final /* synthetic */ zzo zzbFi;

        public zzb(zzo com_google_android_gms_tagmanager_zzo, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.zzbFi = com_google_android_gms_tagmanager_zzo;
            super(looper);
            this.zzbFh = containerAvailableListener;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    zzgY((String) message.obj);
                default:
                    zzbo.m4711e("Don't know how to handle this message.");
            }
        }

        public void zzgX(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void zzgY(String str) {
            this.zzbFh.onContainerAvailable(this.zzbFi, str);
        }
    }

    public zzo(Status status) {
        this.zzair = status;
        this.zzrs = null;
    }

    public zzo(TagManager tagManager, Looper looper, Container container, zza com_google_android_gms_tagmanager_zzo_zza) {
        this.zzbFg = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzrs = looper;
        this.zzbFc = container;
        this.zzbFf = com_google_android_gms_tagmanager_zzo_zza;
        this.zzair = Status.zzazx;
        tagManager.zza(this);
    }

    private void zzQi() {
        if (this.zzbFe != null) {
            this.zzbFe.zzgX(this.zzbFd.zzQf());
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.zzaLQ) {
                zzbo.m4711e("ContainerHolder is released.");
            } else {
                if (this.zzbFd != null) {
                    this.zzbFc = this.zzbFd;
                    this.zzbFd = null;
                }
                container = this.zzbFc;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.zzaLQ) {
            return this.zzbFc.getContainerId();
        }
        zzbo.m4711e("getContainerId called on a released ContainerHolder.");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public Status getStatus() {
        return this.zzair;
    }

    public synchronized void refresh() {
        if (this.zzaLQ) {
            zzbo.m4711e("Refreshing a released ContainerHolder.");
        } else {
            this.zzbFf.zzQj();
        }
    }

    public synchronized void release() {
        if (this.zzaLQ) {
            zzbo.m4711e("Releasing a released ContainerHolder.");
        } else {
            this.zzaLQ = true;
            this.zzbFg.zzb(this);
            this.zzbFc.release();
            this.zzbFc = null;
            this.zzbFd = null;
            this.zzbFf = null;
            this.zzbFe = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener containerAvailableListener) {
        if (this.zzaLQ) {
            zzbo.m4711e("ContainerHolder is released.");
        } else if (containerAvailableListener == null) {
            this.zzbFe = null;
        } else {
            this.zzbFe = new zzb(this, containerAvailableListener, this.zzrs);
            if (this.zzbFd != null) {
                zzQi();
            }
        }
    }

    String zzQh() {
        if (!this.zzaLQ) {
            return this.zzbFf.zzQh();
        }
        zzbo.m4711e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public synchronized void zza(Container container) {
        if (!this.zzaLQ) {
            if (container == null) {
                zzbo.m4711e("Unexpected null container.");
            } else {
                this.zzbFd = container;
                zzQi();
            }
        }
    }

    public synchronized void zzgU(String str) {
        if (!this.zzaLQ) {
            this.zzbFc.zzgU(str);
        }
    }

    void zzgW(String str) {
        if (this.zzaLQ) {
            zzbo.m4711e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.zzbFf.zzgW(str);
        }
    }
}
