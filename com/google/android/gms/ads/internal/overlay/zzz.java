package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzpu.zza;
import com.google.android.gms.internal.zzpu.zzb;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqh;
import java.util.concurrent.TimeUnit;

@zzme
public class zzz {
    private final Context mContext;
    @Nullable
    private final zzgl zzNU;
    private boolean zzNY;
    private final String zzOV;
    @Nullable
    private final zzgj zzOW;
    private final zzpu zzOX;
    private final long[] zzOY;
    private final String[] zzOZ;
    private boolean zzPa;
    private boolean zzPb;
    private boolean zzPc;
    private boolean zzPd;
    private zzj zzPe;
    private boolean zzPf;
    private boolean zzPg;
    private long zzPh;
    private final zzqh zzuc;

    public zzz(Context context, zzqh com_google_android_gms_internal_zzqh, String str, @Nullable zzgl com_google_android_gms_internal_zzgl, @Nullable zzgj com_google_android_gms_internal_zzgj) {
        this.zzOX = new zzb().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzla();
        this.zzPa = false;
        this.zzPb = false;
        this.zzPc = false;
        this.zzPd = false;
        this.zzPh = -1;
        this.mContext = context;
        this.zzuc = com_google_android_gms_internal_zzqh;
        this.zzOV = str;
        this.zzNU = com_google_android_gms_internal_zzgl;
        this.zzOW = com_google_android_gms_internal_zzgj;
        String str2 = (String) zzgd.zzBE.get();
        if (str2 == null) {
            this.zzOZ = new String[0];
            this.zzOY = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzOZ = new String[split.length];
        this.zzOY = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzOY[i] = Long.parseLong(split[i]);
            } catch (Throwable e) {
                zzqf.zzc("Unable to parse frame hash target time number.", e);
                this.zzOY[i] = -1;
            }
        }
    }

    private void zzc(zzj com_google_android_gms_ads_internal_overlay_zzj) {
        long longValue = ((Long) zzgd.zzBF.get()).longValue();
        long currentPosition = (long) com_google_android_gms_ads_internal_overlay_zzj.getCurrentPosition();
        int i = 0;
        while (i < this.zzOZ.length) {
            if (this.zzOZ[i] == null && longValue > Math.abs(currentPosition - this.zzOY[i])) {
                this.zzOZ[i] = zza((TextureView) com_google_android_gms_ads_internal_overlay_zzj);
                return;
            }
            i++;
        }
    }

    private void zziw() {
        if (this.zzPc && !this.zzPd) {
            zzgh.zza(this.zzNU, this.zzOW, "vff2");
            this.zzPd = true;
        }
        long nanoTime = zzw.zzcS().nanoTime();
        if (this.zzNY && this.zzPg && this.zzPh != -1) {
            this.zzOX.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzPh)));
        }
        this.zzPg = this.zzNY;
        this.zzPh = nanoTime;
    }

    public void onStop() {
        if (((Boolean) zzgd.zzBD.get()).booleanValue() && !this.zzPf) {
            String valueOf;
            String valueOf2;
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzOV);
            bundle.putString("player", this.zzPe.zzhy());
            for (zza com_google_android_gms_internal_zzpu_zza : this.zzOX.getBuckets()) {
                valueOf = String.valueOf("fps_c_");
                valueOf2 = String.valueOf(com_google_android_gms_internal_zzpu_zza.name);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(com_google_android_gms_internal_zzpu_zza.count));
                valueOf = String.valueOf("fps_p_");
                valueOf2 = String.valueOf(com_google_android_gms_internal_zzpu_zza.name);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Double.toString(com_google_android_gms_internal_zzpu_zza.zzYi));
            }
            for (int i = 0; i < this.zzOY.length; i++) {
                valueOf2 = this.zzOZ[i];
                if (valueOf2 != null) {
                    String valueOf3 = String.valueOf("fh_");
                    valueOf = String.valueOf(Long.valueOf(this.zzOY[i]));
                    bundle.putString(new StringBuilder(String.valueOf(valueOf3).length() + String.valueOf(valueOf).length()).append(valueOf3).append(valueOf).toString(), valueOf2);
                }
            }
            zzw.zzcM().zza(this.mContext, this.zzuc.zzba, "gmob-apps", bundle, true);
            this.zzPf = true;
        }
    }

    @TargetApi(14)
    String zza(TextureView textureView) {
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j = 0;
        long j2 = 63;
        int i = 0;
        while (i < 8) {
            long j3 = j;
            j = j2;
            for (int i2 = 0; i2 < 8; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                j3 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS ? 1 : 0) << ((int) j);
                j--;
            }
            i++;
            j2 = j;
            j = j3;
        }
        return String.format("%016X", new Object[]{Long.valueOf(j)});
    }

    public void zza(zzj com_google_android_gms_ads_internal_overlay_zzj) {
        zzgh.zza(this.zzNU, this.zzOW, "vpc2");
        this.zzPa = true;
        if (this.zzNU != null) {
            this.zzNU.zzh("vpn", com_google_android_gms_ads_internal_overlay_zzj.zzhy());
        }
        this.zzPe = com_google_android_gms_ads_internal_overlay_zzj;
    }

    public void zzb(zzj com_google_android_gms_ads_internal_overlay_zzj) {
        zziw();
        zzc(com_google_android_gms_ads_internal_overlay_zzj);
    }

    public void zzhU() {
        if (this.zzPa && !this.zzPb) {
            zzgh.zza(this.zzNU, this.zzOW, "vfr2");
            this.zzPb = true;
        }
    }

    public void zzix() {
        this.zzNY = true;
        if (this.zzPb && !this.zzPc) {
            zzgh.zza(this.zzNU, this.zzOW, "vfp2");
            this.zzPc = true;
        }
    }

    public void zziy() {
        this.zzNY = false;
    }
}
