package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzha.zza;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzme
public class zzgz extends zzhb {
    @Nullable
    private zzke zzGH;
    @Nullable
    private zzkf zzGI;
    private final zzs zzGJ;
    @Nullable
    private zzha zzGK;
    private boolean zzGL;
    private Object zzrJ;

    private zzgz(Context context, zzs com_google_android_gms_ads_internal_zzs, zzaw com_google_android_gms_internal_zzaw, zza com_google_android_gms_internal_zzha_zza) {
        super(context, com_google_android_gms_ads_internal_zzs, null, com_google_android_gms_internal_zzaw, null, com_google_android_gms_internal_zzha_zza, null, null);
        this.zzGL = false;
        this.zzrJ = new Object();
        this.zzGJ = com_google_android_gms_ads_internal_zzs;
    }

    public zzgz(Context context, zzs com_google_android_gms_ads_internal_zzs, zzaw com_google_android_gms_internal_zzaw, zzke com_google_android_gms_internal_zzke, zza com_google_android_gms_internal_zzha_zza) {
        this(context, com_google_android_gms_ads_internal_zzs, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzha_zza);
        this.zzGH = com_google_android_gms_internal_zzke;
    }

    public zzgz(Context context, zzs com_google_android_gms_ads_internal_zzs, zzaw com_google_android_gms_internal_zzaw, zzkf com_google_android_gms_internal_zzkf, zza com_google_android_gms_internal_zzha_zza) {
        this(context, com_google_android_gms_ads_internal_zzs, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzha_zza);
        this.zzGI = com_google_android_gms_internal_zzkf;
    }

    @Nullable
    public View zza(OnClickListener onClickListener, boolean z) {
        synchronized (this.zzrJ) {
            if (this.zzGK != null) {
                View zza = this.zzGK.zza(onClickListener, z);
                return zza;
            }
            IObjectWrapper zzhh;
            try {
                if (this.zzGH != null) {
                    zzhh = this.zzGH.zzhh();
                } else {
                    if (this.zzGI != null) {
                        zzhh = this.zzGI.zzhh();
                    }
                    zzhh = null;
                }
            } catch (Throwable e) {
                zzqf.zzc("Failed to call getAdChoicesContent", e);
            }
            if (zzhh != null) {
                zza = (View) zzd.zzF(zzhh);
                return zza;
            }
            return null;
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        synchronized (this.zzrJ) {
            this.zzGL = true;
            try {
                if (this.zzGH != null) {
                    this.zzGH.zzm(zzd.zzA(view));
                } else if (this.zzGI != null) {
                    this.zzGI.zzm(zzd.zzA(view));
                }
            } catch (Throwable e) {
                zzqf.zzc("Failed to call prepareAd", e);
            }
            this.zzGL = false;
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, View view2) {
        zzac.zzdj("performClick must be called on the main UI thread.");
        synchronized (this.zzrJ) {
            if (this.zzGK != null) {
                this.zzGK.zza(view, map, jSONObject, view2);
                this.zzGJ.onAdClicked();
            } else {
                try {
                    if (!(this.zzGH == null || this.zzGH.getOverrideClickHandling())) {
                        this.zzGH.zzl(zzd.zzA(view));
                        this.zzGJ.onAdClicked();
                    }
                    if (!(this.zzGI == null || this.zzGI.getOverrideClickHandling())) {
                        this.zzGI.zzl(zzd.zzA(view));
                        this.zzGJ.onAdClicked();
                    }
                } catch (Throwable e) {
                    zzqf.zzc("Failed to call performClick", e);
                }
            }
        }
    }

    public void zzb(View view, Map<String, WeakReference<View>> map) {
        zzac.zzdj("recordImpression must be called on the main UI thread.");
        synchronized (this.zzrJ) {
            zzq(true);
            if (this.zzGK != null) {
                this.zzGK.zzb(view, map);
                this.zzGJ.recordImpression();
            } else {
                try {
                    if (this.zzGH != null && !this.zzGH.getOverrideImpressionRecording()) {
                        this.zzGH.recordImpression();
                        this.zzGJ.recordImpression();
                    } else if (!(this.zzGI == null || this.zzGI.getOverrideImpressionRecording())) {
                        this.zzGI.recordImpression();
                        this.zzGJ.recordImpression();
                    }
                } catch (Throwable e) {
                    zzqf.zzc("Failed to call recordImpression", e);
                }
            }
        }
    }

    public void zzc(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.zzrJ) {
            try {
                if (this.zzGH != null) {
                    this.zzGH.zzn(zzd.zzA(view));
                } else if (this.zzGI != null) {
                    this.zzGI.zzn(zzd.zzA(view));
                }
            } catch (Throwable e) {
                zzqf.zzc("Failed to call untrackView", e);
            }
        }
    }

    public void zzc(@Nullable zzha com_google_android_gms_internal_zzha) {
        synchronized (this.zzrJ) {
            this.zzGK = com_google_android_gms_internal_zzha;
        }
    }

    public boolean zzfY() {
        boolean zzfY;
        synchronized (this.zzrJ) {
            if (this.zzGK != null) {
                zzfY = this.zzGK.zzfY();
            } else {
                zzfY = this.zzGJ.zzcx();
            }
        }
        return zzfY;
    }

    public boolean zzfZ() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzGL;
        }
        return z;
    }

    public zzha zzga() {
        zzha com_google_android_gms_internal_zzha;
        synchronized (this.zzrJ) {
            com_google_android_gms_internal_zzha = this.zzGK;
        }
        return com_google_android_gms_internal_zzha;
    }

    @Nullable
    public zzqw zzgb() {
        return null;
    }
}
