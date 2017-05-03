package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzt;
import java.util.ArrayList;
import java.util.List;

@zzme
public class zzdd {
    private final Object zzxG;
    private zza zzxH;
    private boolean zzxI;

    @TargetApi(14)
    static class zza implements ActivityLifecycleCallbacks {
        @Nullable
        private Activity mActivity;
        private Context mContext;
        private List<zzb> mListeners;
        private final Object zzrJ;
        private boolean zztZ;
        private boolean zzxJ;
        private boolean zzxK;
        private Runnable zzxL;
        private long zzxM;

        /* renamed from: com.google.android.gms.internal.zzdd.zza.1 */
        class C11541 implements Runnable {
            final /* synthetic */ zza zzxN;

            C11541(zza com_google_android_gms_internal_zzdd_zza) {
                this.zzxN = com_google_android_gms_internal_zzdd_zza;
            }

            public void run() {
                synchronized (this.zzxN.zzrJ) {
                    if (this.zzxN.zzxJ && this.zzxN.zzxK) {
                        this.zzxN.zzxJ = false;
                        zzqf.zzbf("App went background");
                        for (zzb zzk : this.zzxN.mListeners) {
                            try {
                                zzk.zzk(false);
                            } catch (Throwable e) {
                                zzqf.zzb("OnForegroundStateChangedListener threw exception.", e);
                            }
                        }
                    } else {
                        zzqf.zzbf("App is still foreground");
                    }
                }
            }
        }

        zza() {
            this.zzrJ = new Object();
            this.zzxJ = true;
            this.zzxK = false;
            this.mListeners = new ArrayList();
            this.zztZ = false;
        }

        private void setActivity(Activity activity) {
            synchronized (this.zzrJ) {
                if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                    this.mActivity = activity;
                }
            }
        }

        @Nullable
        public Activity getActivity() {
            return this.mActivity;
        }

        @Nullable
        public Context getContext() {
            return this.mContext;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            synchronized (this.zzrJ) {
                if (this.mActivity == null) {
                    return;
                }
                if (this.mActivity.equals(activity)) {
                    this.mActivity = null;
                }
            }
        }

        public void onActivityPaused(Activity activity) {
            setActivity(activity);
            this.zzxK = true;
            if (this.zzxL != null) {
                zzpo.zzXC.removeCallbacks(this.zzxL);
            }
            Handler handler = zzpo.zzXC;
            Runnable c11541 = new C11541(this);
            this.zzxL = c11541;
            handler.postDelayed(c11541, this.zzxM);
        }

        public void onActivityResumed(Activity activity) {
            boolean z = false;
            setActivity(activity);
            this.zzxK = false;
            if (!this.zzxJ) {
                z = true;
            }
            this.zzxJ = true;
            if (this.zzxL != null) {
                zzpo.zzXC.removeCallbacks(this.zzxL);
            }
            synchronized (this.zzrJ) {
                if (z) {
                    for (zzb zzk : this.mListeners) {
                        try {
                            zzk.zzk(true);
                        } catch (Throwable e) {
                            zzqf.zzb("OnForegroundStateChangedListener threw exception.", e);
                        }
                    }
                } else {
                    zzqf.zzbf("App is still foreground.");
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            setActivity(activity);
        }

        public void onActivityStopped(Activity activity) {
        }

        public void zza(Application application, Context context) {
            if (!this.zztZ) {
                application.registerActivityLifecycleCallbacks(this);
                if (context instanceof Activity) {
                    setActivity((Activity) context);
                }
                this.mContext = context;
                this.zzxM = ((Long) zzgd.zzCQ.get()).longValue();
                this.zztZ = true;
            }
        }

        public void zza(zzb com_google_android_gms_internal_zzdd_zzb) {
            this.mListeners.add(com_google_android_gms_internal_zzdd_zzb);
        }
    }

    public interface zzb {
        void zzk(boolean z);
    }

    public zzdd() {
        this.zzxG = new Object();
        this.zzxH = null;
        this.zzxI = false;
    }

    @Nullable
    public Activity getActivity() {
        Activity activity;
        synchronized (this.zzxG) {
            zzt.zzzg();
            if (this.zzxH != null) {
                activity = this.zzxH.getActivity();
            } else {
                activity = null;
            }
        }
        return activity;
    }

    @Nullable
    public Context getContext() {
        Context context;
        synchronized (this.zzxG) {
            zzt.zzzg();
            if (this.zzxH != null) {
                context = this.zzxH.getContext();
            } else {
                context = null;
            }
        }
        return context;
    }

    public void initialize(Context context) {
        synchronized (this.zzxG) {
            if (!this.zzxI) {
                zzt.zzzg();
                if (((Boolean) zzgd.zzCP.get()).booleanValue()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                    if (application == null) {
                        zzqf.zzbh("Can not cast Context to Application");
                        return;
                    }
                    if (this.zzxH == null) {
                        this.zzxH = new zza();
                    }
                    this.zzxH.zza(application, context);
                    this.zzxI = true;
                } else {
                    return;
                }
            }
        }
    }

    public void zza(zzb com_google_android_gms_internal_zzdd_zzb) {
        synchronized (this.zzxG) {
            zzt.zzzg();
            if (((Boolean) zzgd.zzCP.get()).booleanValue()) {
                if (this.zzxH == null) {
                    this.zzxH = new zza();
                }
                this.zzxH.zza(com_google_android_gms_internal_zzdd_zzb);
                return;
            }
        }
    }
}
