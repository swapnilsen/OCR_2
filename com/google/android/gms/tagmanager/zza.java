package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;

public class zza {
    private static Object zzbEI;
    private static zza zzbEJ;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread zzXh;
    private volatile Info zzadB;
    private volatile long zzbEC;
    private volatile long zzbED;
    private volatile long zzbEE;
    private volatile long zzbEF;
    private final Object zzbEG;
    private zza zzbEH;
    private final zze zzuP;

    public interface zza {
        Info zzQa();
    }

    /* renamed from: com.google.android.gms.tagmanager.zza.1 */
    class C14411 implements zza {
        final /* synthetic */ zza zzbEK;

        C14411(zza com_google_android_gms_tagmanager_zza) {
            this.zzbEK = com_google_android_gms_tagmanager_zza;
        }

        public Info zzQa() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.zzbEK.mContext);
            } catch (Throwable e) {
                zzbo.zzc("IllegalStateException getting Advertising Id Info", e);
            } catch (Throwable e2) {
                zzbo.zzc("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
            } catch (Throwable e22) {
                zzbo.zzc("IOException getting Ad Id Info", e22);
            } catch (Throwable e222) {
                zzbo.zzc("GooglePlayServicesNotAvailableException getting Advertising Id Info", e222);
            } catch (Throwable e2222) {
                zzbo.zzc("Unknown exception. Could not get the Advertising Id Info.", e2222);
            }
            return info;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zza.2 */
    class C14422 implements Runnable {
        final /* synthetic */ zza zzbEK;

        C14422(zza com_google_android_gms_tagmanager_zza) {
            this.zzbEK = com_google_android_gms_tagmanager_zza;
        }

        public void run() {
            this.zzbEK.zzPZ();
        }
    }

    static {
        zzbEI = new Object();
    }

    private zza(Context context) {
        this(context, null, zzi.zzzc());
    }

    public zza(Context context, zza com_google_android_gms_tagmanager_zza_zza, zze com_google_android_gms_common_util_zze) {
        this.zzbEC = 900000;
        this.zzbED = 30000;
        this.mClosed = false;
        this.zzbEG = new Object();
        this.zzbEH = new C14411(this);
        this.zzuP = com_google_android_gms_common_util_zze;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (com_google_android_gms_tagmanager_zza_zza != null) {
            this.zzbEH = com_google_android_gms_tagmanager_zza_zza;
        }
        this.zzbEE = this.zzuP.currentTimeMillis();
        this.zzXh = new Thread(new C14422(this));
    }

    private void zzPW() {
        synchronized (this) {
            try {
                zzPX();
                wait(500);
            } catch (InterruptedException e) {
            }
        }
    }

    private void zzPX() {
        if (this.zzuP.currentTimeMillis() - this.zzbEE > this.zzbED) {
            synchronized (this.zzbEG) {
                this.zzbEG.notify();
            }
            this.zzbEE = this.zzuP.currentTimeMillis();
        }
    }

    private void zzPY() {
        if (this.zzuP.currentTimeMillis() - this.zzbEF > 3600000) {
            this.zzadB = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzPZ() {
        /*
        r4 = this;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0005:
        r0 = r4.mClosed;
        r0 = r4.zzbEH;
        r0 = r0.zzQa();
        if (r0 == 0) goto L_0x001e;
    L_0x000f:
        r4.zzadB = r0;
        r0 = r4.zzuP;
        r0 = r0.currentTimeMillis();
        r4.zzbEF = r0;
        r0 = "Obtained fresh AdvertisingId info from GmsCore.";
        com.google.android.gms.tagmanager.zzbo.zzbg(r0);
    L_0x001e:
        monitor-enter(r4);
        r4.notifyAll();	 Catch:{ all -> 0x0039 }
        monitor-exit(r4);	 Catch:{ all -> 0x0039 }
        r1 = r4.zzbEG;	 Catch:{ InterruptedException -> 0x0032 }
        monitor-enter(r1);	 Catch:{ InterruptedException -> 0x0032 }
        r0 = r4.zzbEG;	 Catch:{ all -> 0x002f }
        r2 = r4.zzbEC;	 Catch:{ all -> 0x002f }
        r0.wait(r2);	 Catch:{ all -> 0x002f }
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        goto L_0x0005;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        throw r0;	 Catch:{ InterruptedException -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        r0 = "sleep interrupted in AdvertiserDataPoller thread; continuing";
        com.google.android.gms.tagmanager.zzbo.zzbg(r0);
        goto L_0x0005;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zza.zzPZ():void");
    }

    public static zza zzbS(Context context) {
        if (zzbEJ == null) {
            synchronized (zzbEI) {
                if (zzbEJ == null) {
                    zzbEJ = new zza(context);
                    zzbEJ.start();
                }
            }
        }
        return zzbEJ;
    }

    public boolean isLimitAdTrackingEnabled() {
        if (this.zzadB == null) {
            zzPW();
        } else {
            zzPX();
        }
        zzPY();
        return this.zzadB == null ? true : this.zzadB.isLimitAdTrackingEnabled();
    }

    public void start() {
        this.zzXh.start();
    }

    public String zzPV() {
        if (this.zzadB == null) {
            zzPW();
        } else {
            zzPX();
        }
        zzPY();
        return this.zzadB == null ? null : this.zzadB.getId();
    }
}
