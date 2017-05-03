package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzqf;

@zzme
public class zza {
    public boolean zza(Context context, Intent intent, zzq com_google_android_gms_ads_internal_overlay_zzq) {
        try {
            String str = "Launching an intent: ";
            String valueOf = String.valueOf(intent.toURI());
            zzpk.m4709v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            zzw.zzcM().zzb(context, intent);
            if (com_google_android_gms_ads_internal_overlay_zzq != null) {
                com_google_android_gms_ads_internal_overlay_zzq.zzbD();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzqf.zzbh(e.getMessage());
            return false;
        }
    }

    public boolean zza(Context context, zzc com_google_android_gms_ads_internal_overlay_zzc, zzq com_google_android_gms_ads_internal_overlay_zzq) {
        if (com_google_android_gms_ads_internal_overlay_zzc == null) {
            zzqf.zzbh("No intent data for launcher overlay.");
            return false;
        }
        zzgd.initialize(context);
        if (com_google_android_gms_ads_internal_overlay_zzc.intent != null) {
            return zza(context, com_google_android_gms_ads_internal_overlay_zzc.intent, com_google_android_gms_ads_internal_overlay_zzq);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(com_google_android_gms_ads_internal_overlay_zzc.url)) {
            zzqf.zzbh("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(com_google_android_gms_ads_internal_overlay_zzc.mimeType)) {
            intent.setData(Uri.parse(com_google_android_gms_ads_internal_overlay_zzc.url));
        } else {
            intent.setDataAndType(Uri.parse(com_google_android_gms_ads_internal_overlay_zzc.url), com_google_android_gms_ads_internal_overlay_zzc.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(com_google_android_gms_ads_internal_overlay_zzc.packageName)) {
            intent.setPackage(com_google_android_gms_ads_internal_overlay_zzc.packageName);
        }
        if (!TextUtils.isEmpty(com_google_android_gms_ads_internal_overlay_zzc.zzMH)) {
            String[] split = com_google_android_gms_ads_internal_overlay_zzc.zzMH.split("/", 2);
            if (split.length < 2) {
                String str = "Could not parse component name from open GMSG: ";
                String valueOf = String.valueOf(com_google_android_gms_ads_internal_overlay_zzc.zzMH);
                zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        Object obj = com_google_android_gms_ads_internal_overlay_zzc.zzMI;
        if (!TextUtils.isEmpty(obj)) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(obj);
            } catch (NumberFormatException e) {
                zzqf.zzbh("Could not parse intent flags.");
                parseInt = 0;
            }
            intent.addFlags(parseInt);
        }
        if (((Boolean) zzgd.zzFk.get()).booleanValue()) {
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        }
        return zza(context, intent, com_google_android_gms_ads_internal_overlay_zzq);
    }
}
