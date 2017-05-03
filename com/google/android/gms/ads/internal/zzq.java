package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzey.zza;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqh;

@zzme
public class zzq extends zza {
    private static final Object zztX;
    @Nullable
    private static zzq zztY;
    private final Context mContext;
    private final Object zzrJ;
    private boolean zztZ;
    private boolean zzua;
    private float zzub;
    private zzqh zzuc;

    /* renamed from: com.google.android.gms.ads.internal.zzq.1 */
    class C09561 implements Runnable {
        final /* synthetic */ Runnable zzud;
        final /* synthetic */ zzq zzue;

        /* renamed from: com.google.android.gms.ads.internal.zzq.1.1 */
        class C09551 implements Runnable {
            final /* synthetic */ C09561 zzuf;

            C09551(C09561 c09561) {
                this.zzuf = c09561;
            }

            public void run() {
                zzod.zza(this.zzuf.zzue.mContext, this.zzuf.zzud);
            }
        }

        C09561(zzq com_google_android_gms_ads_internal_zzq, Runnable runnable) {
            this.zzue = com_google_android_gms_ads_internal_zzq;
            this.zzud = runnable;
        }

        public void run() {
            zzw.zzcM().runOnUiThread(new C09551(this));
        }
    }

    static {
        zztX = new Object();
    }

    zzq(Context context, zzqh com_google_android_gms_internal_zzqh) {
        this.zzrJ = new Object();
        this.zzub = -1.0f;
        this.mContext = context;
        this.zzuc = com_google_android_gms_internal_zzqh;
        this.zztZ = false;
    }

    public static zzq zza(Context context, zzqh com_google_android_gms_internal_zzqh) {
        zzq com_google_android_gms_ads_internal_zzq;
        synchronized (zztX) {
            if (zztY == null) {
                zztY = new zzq(context.getApplicationContext(), com_google_android_gms_internal_zzqh);
            }
            com_google_android_gms_ads_internal_zzq = zztY;
        }
        return com_google_android_gms_ads_internal_zzq;
    }

    @Nullable
    public static zzq zzcp() {
        zzq com_google_android_gms_ads_internal_zzq;
        synchronized (zztX) {
            com_google_android_gms_ads_internal_zzq = zztY;
        }
        return com_google_android_gms_ads_internal_zzq;
    }

    public void initialize() {
        synchronized (zztX) {
            if (this.zztZ) {
                zzqf.zzbh("Mobile ads is initialized already.");
                return;
            }
            this.zztZ = true;
            zzgd.initialize(this.mContext);
            zzw.zzcQ().zzc(this.mContext, this.zzuc);
            zzw.zzcR().initialize(this.mContext);
        }
    }

    public void setAppMuted(boolean z) {
        synchronized (this.zzrJ) {
            this.zzua = z;
        }
    }

    public void setAppVolume(float f) {
        synchronized (this.zzrJ) {
            this.zzub = f;
        }
    }

    public void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzqf.m4708e("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) zzd.zzF(iObjectWrapper);
        if (context == null) {
            zzqf.m4708e("Context is null. Failed to open debug menu.");
            return;
        }
        zzpr zzh = zzh(context);
        zzh.setAdUnitId(str);
        zzh.zzba(this.zzuc.zzba);
        zzh.showDialog();
    }

    public void zzc(String str, IObjectWrapper iObjectWrapper) {
        if (!TextUtils.isEmpty(str)) {
            Runnable c09561;
            int i;
            zzgd.initialize(this.mContext);
            int booleanValue = ((Boolean) zzgd.zzEJ.get()).booleanValue() | ((Boolean) zzgd.zzCN.get()).booleanValue();
            if (((Boolean) zzgd.zzCN.get()).booleanValue()) {
                c09561 = new C09561(this, (Runnable) zzd.zzF(iObjectWrapper));
                i = 1;
            } else {
                c09561 = null;
                i = booleanValue;
            }
            if (i != 0) {
                zzw.zzdi().zza(this.mContext, this.zzuc, str, c09561);
            }
        }
    }

    public float zzcq() {
        float f;
        synchronized (this.zzrJ) {
            f = this.zzub;
        }
        return f;
    }

    public boolean zzcr() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzub >= 0.0f;
        }
        return z;
    }

    public boolean zzcs() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzua;
        }
        return z;
    }

    zzpr zzh(Context context) {
        return new zzpr(context);
    }

    public void zzy(String str) {
        zzgd.initialize(this.mContext);
        if (!TextUtils.isEmpty(str) && ((Boolean) zzgd.zzEJ.get()).booleanValue()) {
            zzw.zzdi().zza(this.mContext, this.zzuc, str, null);
        }
    }
}
