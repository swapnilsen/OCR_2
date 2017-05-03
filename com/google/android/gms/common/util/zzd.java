package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzadg;

public class zzd {
    public static int zzC(Context context, String str) {
        return zzc(zzD(context, str));
    }

    @Nullable
    public static PackageInfo zzD(Context context, String str) {
        try {
            return zzadg.zzbi(context).getPackageInfo(str, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean zzE(Context context, String str) {
        GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(str);
        try {
            return (zzadg.zzbi(context).getApplicationInfo(str, 0).flags & AccessibilityNodeInfoCompat.ACTION_SET_TEXT) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static int zzc(PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return -1;
        }
        Bundle bundle = packageInfo.applicationInfo.metaData;
        return bundle != null ? bundle.getInt("com.google.android.gms.version", -1) : -1;
    }
}
