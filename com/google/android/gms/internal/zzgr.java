package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.List;

@zzme
public class zzgr implements zzbyc {
    @Nullable
    private CustomTabsSession zzFX;
    @Nullable
    private CustomTabsClient zzFY;
    @Nullable
    private CustomTabsServiceConnection zzFZ;
    @Nullable
    private zza zzGa;

    public interface zza {
        void zzfJ();

        void zzfK();
    }

    public static boolean zzo(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, AccessibilityNodeInfoCompat.ACTION_CUT);
        if (queryIntentActivities == null || resolveActivity == null) {
            return false;
        }
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name)) {
                return resolveActivity.activityInfo.packageName.equals(zzbya.zzcC(context));
            }
        }
        return false;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        if (this.zzFY == null) {
            return false;
        }
        CustomTabsSession zzfH = zzfH();
        return zzfH != null ? zzfH.mayLaunchUrl(uri, bundle, list) : false;
    }

    public void zza(CustomTabsClient customTabsClient) {
        this.zzFY = customTabsClient;
        this.zzFY.warmup(0);
        if (this.zzGa != null) {
            this.zzGa.zzfJ();
        }
    }

    public void zza(zza com_google_android_gms_internal_zzgr_zza) {
        this.zzGa = com_google_android_gms_internal_zzgr_zza;
    }

    public void zzd(Activity activity) {
        if (this.zzFZ != null) {
            activity.unbindService(this.zzFZ);
            this.zzFY = null;
            this.zzFX = null;
            this.zzFZ = null;
        }
    }

    public void zze(Activity activity) {
        if (this.zzFY == null) {
            String zzcC = zzbya.zzcC(activity);
            if (zzcC != null) {
                this.zzFZ = new zzbyb(this);
                CustomTabsClient.bindCustomTabsService(activity, zzcC, this.zzFZ);
            }
        }
    }

    @Nullable
    public CustomTabsSession zzfH() {
        if (this.zzFY == null) {
            this.zzFX = null;
        } else if (this.zzFX == null) {
            this.zzFX = this.zzFY.newSession(null);
        }
        return this.zzFX;
    }

    public void zzfI() {
        this.zzFY = null;
        this.zzFX = null;
        if (this.zzGa != null) {
            this.zzGa.zzfK();
        }
    }
}
