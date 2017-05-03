package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.Map;
import org.json.JSONObject;

@zzme
public final class zzio implements zzid {
    private boolean zzIv;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = zzel.zzeT().zzb(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                zzqf.zzbh(new StringBuilder((String.valueOf(str).length() + 34) + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            }
        }
        return i;
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            zzqf.zzbh("Action missing from video GMSG.");
            return;
        }
        if (zzqf.zzak(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject.toString());
            zzqf.zzbf(new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()).append("Video GMSG: ").append(str).append(" ").append(valueOf).toString());
        }
        if ("background".equals(str)) {
            valueOf = (String) map.get("color");
            if (TextUtils.isEmpty(valueOf)) {
                zzqf.zzbh("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                com_google_android_gms_internal_zzqw.setBackgroundColor(Color.parseColor(valueOf));
                return;
            } catch (IllegalArgumentException e) {
                zzqf.zzbh("Invalid color parameter in video GMSG.");
                return;
            }
        }
        zzqv zzlD = com_google_android_gms_internal_zzqw.zzlD();
        if (zzlD == null) {
            zzqf.zzbh("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int zza;
        int min;
        if (equals || equals2) {
            Context context = com_google_android_gms_internal_zzqw.getContext();
            int zza2 = zza(context, map, "x", 0);
            zza = zza(context, map, "y", 0);
            int zza3 = zza(context, map, "w", -1);
            int zza4 = zza(context, map, "h", -1);
            if (((Boolean) zzgd.zzEv.get()).booleanValue()) {
                min = Math.min(zza3, com_google_android_gms_internal_zzqw.getMeasuredWidth() - zza2);
                zza4 = Math.min(zza4, com_google_android_gms_internal_zzqw.getMeasuredHeight() - zza);
            } else {
                min = zza3;
            }
            try {
                zza3 = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
                zza3 = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (equals && zzlD.zzlo() == null) {
                zzlD.zza(zza2, zza, min, zza4, zza3, parseBoolean);
                return;
            } else {
                zzlD.zze(zza2, zza, min, zza4);
                return;
            }
        }
        zzl zzlo = zzlD.zzlo();
        if (zzlo == null) {
            zzl.zzi(com_google_android_gms_internal_zzqw);
        } else if (Promotion.ACTION_CLICK.equals(str)) {
            r0 = com_google_android_gms_internal_zzqw.getContext();
            zza = zza(r0, map, "x", 0);
            min = zza(r0, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza, (float) min, 0);
            zzlo.zzf(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            valueOf = (String) map.get("time");
            if (valueOf == null) {
                zzqf.zzbh("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzlo.seekTo((int) (Float.parseFloat(valueOf) * 1000.0f));
            } catch (NumberFormatException e3) {
                str = "Could not parse time parameter from currentTime video GMSG: ";
                valueOf = String.valueOf(valueOf);
                zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("hide".equals(str)) {
            zzlo.setVisibility(4);
        } else if ("load".equals(str)) {
            zzlo.zzib();
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzlo.zzhZ();
            } else {
                zzlo.zzia();
            }
        } else if ("pause".equals(str)) {
            zzlo.pause();
        } else if ("play".equals(str)) {
            zzlo.play();
        } else if ("show".equals(str)) {
            zzlo.setVisibility(0);
        } else if ("src".equals(str)) {
            zzlo.zzaC((String) map.get("src"));
        } else if ("touchMove".equals(str)) {
            r0 = com_google_android_gms_internal_zzqw.getContext();
            zzlo.zza((float) zza(r0, map, "dx", 0), (float) zza(r0, map, "dy", 0));
            if (!this.zzIv) {
                com_google_android_gms_internal_zzqw.zzlt().zzhL();
                this.zzIv = true;
            }
        } else if ("volume".equals(str)) {
            valueOf = (String) map.get("volume");
            if (valueOf == null) {
                zzqf.zzbh("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                zzlo.zzb(Float.parseFloat(valueOf));
            } catch (NumberFormatException e4) {
                str = "Could not parse volume parameter from volume video GMSG: ";
                valueOf = String.valueOf(valueOf);
                zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("watermark".equals(str)) {
            zzlo.zzic();
        } else {
            String str2 = "Unknown video action: ";
            valueOf = String.valueOf(str);
            zzqf.zzbh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }
}
