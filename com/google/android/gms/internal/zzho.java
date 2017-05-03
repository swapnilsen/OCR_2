package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.zzd;
import java.util.List;

@zzme
public class zzho implements NativeCustomTemplateAd {
    private final VideoController zzAl;
    private final zzhn zzHw;
    private final MediaView zzHx;

    public zzho(zzhn com_google_android_gms_internal_zzhn) {
        Context context;
        Throwable e;
        MediaView zzq;
        MediaView mediaView = null;
        this.zzAl = new VideoController();
        this.zzHw = com_google_android_gms_internal_zzhn;
        try {
            context = (Context) zzd.zzF(com_google_android_gms_internal_zzhn.zzfW());
        } catch (NullPointerException e2) {
            e = e2;
            zzqf.zzb("Unable to inflate MediaView.", e);
            context = null;
            if (context != null) {
                zzq = zzq(context);
                try {
                    if (!this.zzHw.zzj(zzd.zzA(zzq))) {
                        zzq = null;
                    }
                    mediaView = zzq;
                } catch (Throwable e3) {
                    zzqf.zzb("Unable to render video in MediaView.", e3);
                }
            }
            this.zzHx = mediaView;
        } catch (RemoteException e4) {
            e3 = e4;
            zzqf.zzb("Unable to inflate MediaView.", e3);
            context = null;
            if (context != null) {
                zzq = zzq(context);
                if (this.zzHw.zzj(zzd.zzA(zzq))) {
                    zzq = null;
                }
                mediaView = zzq;
            }
            this.zzHx = mediaView;
        }
        if (context != null) {
            zzq = zzq(context);
            if (this.zzHw.zzj(zzd.zzA(zzq))) {
                zzq = null;
            }
            mediaView = zzq;
        }
        this.zzHx = mediaView;
    }

    public void destroy() {
        try {
            this.zzHw.destroy();
        } catch (Throwable e) {
            zzqf.zzb("Failed to destroy ad.", e);
        }
    }

    public List<String> getAvailableAssetNames() {
        try {
            return this.zzHw.getAvailableAssetNames();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.zzHw.getCustomTemplateId();
        } catch (Throwable e) {
            zzqf.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    public Image getImage(String str) {
        try {
            zzhf zzZ = this.zzHw.zzZ(str);
            if (zzZ != null) {
                return new zzhg(zzZ);
            }
        } catch (Throwable e) {
            zzqf.zzb("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String str) {
        try {
            return this.zzHw.zzY(str);
        } catch (Throwable e) {
            zzqf.zzb("Failed to get string.", e);
            return null;
        }
    }

    public VideoController getVideoController() {
        try {
            zzfa zzbF = this.zzHw.zzbF();
            if (zzbF != null) {
                this.zzAl.zza(zzbF);
            }
        } catch (Throwable e) {
            zzqf.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzAl;
    }

    public MediaView getVideoMediaView() {
        return this.zzHx;
    }

    public void performClick(String str) {
        try {
            this.zzHw.performClick(str);
        } catch (Throwable e) {
            zzqf.zzb("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzHw.recordImpression();
        } catch (Throwable e) {
            zzqf.zzb("Failed to record impression.", e);
        }
    }

    protected MediaView zzq(Context context) {
        return new MediaView(context);
    }
}
