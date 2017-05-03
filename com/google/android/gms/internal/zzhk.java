package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzhf.zza;
import java.util.ArrayList;
import java.util.List;

@zzme
public class zzhk extends NativeAppInstallAd {
    private final VideoController zzAl;
    private final zzhj zzHr;
    private final List<Image> zzHs;
    private final zzhg zzHt;

    public zzhk(zzhj com_google_android_gms_internal_zzhj) {
        zzhg com_google_android_gms_internal_zzhg;
        this.zzHs = new ArrayList();
        this.zzAl = new VideoController();
        this.zzHr = com_google_android_gms_internal_zzhj;
        try {
            List<Object> images = this.zzHr.getImages();
            if (images != null) {
                for (Object zze : images) {
                    zzhf zze2 = zze(zze);
                    if (zze2 != null) {
                        this.zzHs.add(new zzhg(zze2));
                    }
                }
            }
        } catch (Throwable e) {
            zzqf.zzb("Failed to get image.", e);
        }
        try {
            zzhf zzfQ = this.zzHr.zzfQ();
            if (zzfQ != null) {
                com_google_android_gms_internal_zzhg = new zzhg(zzfQ);
                this.zzHt = com_google_android_gms_internal_zzhg;
            }
        } catch (Throwable e2) {
            zzqf.zzb("Failed to get icon.", e2);
        }
        com_google_android_gms_internal_zzhg = null;
        this.zzHt = com_google_android_gms_internal_zzhg;
    }

    public void destroy() {
        try {
            this.zzHr.destroy();
        } catch (Throwable e) {
            zzqf.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzHr.getBody();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzHr.getCallToAction();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.zzHr.getExtras();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzHr.getHeadline();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public Image getIcon() {
        return this.zzHt;
    }

    public List<Image> getImages() {
        return this.zzHs;
    }

    public CharSequence getPrice() {
        try {
            return this.zzHr.getPrice();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get price.", e);
            return null;
        }
    }

    public Double getStarRating() {
        Double d = null;
        try {
            double starRating = this.zzHr.getStarRating();
            if (starRating != -1.0d) {
                d = Double.valueOf(starRating);
            }
        } catch (Throwable e) {
            zzqf.zzb("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence getStore() {
        try {
            return this.zzHr.getStore();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get store", e);
            return null;
        }
    }

    public VideoController getVideoController() {
        try {
            if (this.zzHr.zzbF() != null) {
                this.zzAl.zza(this.zzHr.zzbF());
            }
        } catch (Throwable e) {
            zzqf.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzAl;
    }

    protected /* synthetic */ Object zzbu() {
        return zzfR();
    }

    zzhf zze(Object obj) {
        return obj instanceof IBinder ? zza.zzB((IBinder) obj) : null;
    }

    protected IObjectWrapper zzfR() {
        try {
            return this.zzHr.zzfR();
        } catch (Throwable e) {
            zzqf.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
