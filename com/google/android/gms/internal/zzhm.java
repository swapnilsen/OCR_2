package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzhf.zza;
import java.util.ArrayList;
import java.util.List;

@zzme
public class zzhm extends NativeContentAd {
    private final VideoController zzAl;
    private final List<Image> zzHs;
    private final zzhl zzHu;
    private final zzhg zzHv;

    public zzhm(zzhl com_google_android_gms_internal_zzhl) {
        zzhg com_google_android_gms_internal_zzhg;
        this.zzHs = new ArrayList();
        this.zzAl = new VideoController();
        this.zzHu = com_google_android_gms_internal_zzhl;
        try {
            List<Object> images = this.zzHu.getImages();
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
            zzhf zzfV = this.zzHu.zzfV();
            if (zzfV != null) {
                com_google_android_gms_internal_zzhg = new zzhg(zzfV);
                this.zzHv = com_google_android_gms_internal_zzhg;
            }
        } catch (Throwable e2) {
            zzqf.zzb("Failed to get icon.", e2);
        }
        com_google_android_gms_internal_zzhg = null;
        this.zzHv = com_google_android_gms_internal_zzhg;
    }

    public void destroy() {
        try {
            this.zzHu.destroy();
        } catch (Throwable e) {
            zzqf.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getAdvertiser() {
        try {
            return this.zzHu.getAdvertiser();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get attribution.", e);
            return null;
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzHu.getBody();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzHu.getCallToAction();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.zzHu.getExtras();
        } catch (Throwable e) {
            zzqf.zzc("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzHu.getHeadline();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public List<Image> getImages() {
        return this.zzHs;
    }

    public Image getLogo() {
        return this.zzHv;
    }

    public VideoController getVideoController() {
        try {
            if (this.zzHu.zzbF() != null) {
                this.zzAl.zza(this.zzHu.zzbF());
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
            return this.zzHu.zzfR();
        } catch (Throwable e) {
            zzqf.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
