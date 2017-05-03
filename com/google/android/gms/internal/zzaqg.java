package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class zzaqg {

    static class zza implements zzb, zzc {
        private final String packageName;
        protected zzaqh zzbgf;
        private final String zzbgg;
        private final LinkedBlockingQueue<com.google.android.gms.internal.zzag.zza> zzbgh;
        private final HandlerThread zzbgi;

        public zza(Context context, String str, String str2) {
            this.packageName = str;
            this.zzbgg = str2;
            this.zzbgi = new HandlerThread("GassClient");
            this.zzbgi.start();
            this.zzbgf = new zzaqh(context, this.zzbgi.getLooper(), this, this);
            this.zzbgh = new LinkedBlockingQueue();
            connect();
        }

        protected void connect() {
            this.zzbgf.zzxz();
        }

        public void onConnected(Bundle bundle) {
            zzaqm zzGK = zzGK();
            if (zzGK != null) {
                try {
                    this.zzbgh.put(zzGK.zza(new zzaqi(this.packageName, this.zzbgg)).zzGN());
                } catch (Throwable th) {
                } finally {
                    zzjn();
                    this.zzbgi.quit();
                }
            }
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            try {
                this.zzbgh.put(new com.google.android.gms.internal.zzag.zza());
            } catch (InterruptedException e) {
            }
        }

        public void onConnectionSuspended(int i) {
            try {
                this.zzbgh.put(new com.google.android.gms.internal.zzag.zza());
            } catch (InterruptedException e) {
            }
        }

        protected zzaqm zzGK() {
            try {
                return this.zzbgf.zzGL();
            } catch (IllegalStateException e) {
                return null;
            } catch (DeadObjectException e2) {
                return null;
            }
        }

        public com.google.android.gms.internal.zzag.zza zzaR() {
            return zzjx(5000);
        }

        public void zzjn() {
            if (this.zzbgf == null) {
                return;
            }
            if (this.zzbgf.isConnected() || this.zzbgf.isConnecting()) {
                this.zzbgf.disconnect();
            }
        }

        public com.google.android.gms.internal.zzag.zza zzjx(int i) {
            com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza;
            try {
                com_google_android_gms_internal_zzag_zza = (com.google.android.gms.internal.zzag.zza) this.zzbgh.poll((long) i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                com_google_android_gms_internal_zzag_zza = null;
            }
            return com_google_android_gms_internal_zzag_zza == null ? new com.google.android.gms.internal.zzag.zza() : com_google_android_gms_internal_zzag_zza;
        }
    }

    public static com.google.android.gms.internal.zzag.zza zzq(Context context, String str, String str2) {
        return new zza(context, str, str2).zzaR();
    }
}
