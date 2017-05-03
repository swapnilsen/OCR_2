package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.internal.zzadg;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public class zze {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final zze zzayo;

    static {
        GOOGLE_PLAY_SERVICES_VERSION_CODE = zzg.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        zzayo = new zze();
    }

    zze() {
    }

    static String zzA(@Nullable Context context, @Nullable String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(zzadg.zzbi(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public static zze zzuY() {
        return zzayo;
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return zza(context, i, i2, null);
    }

    public String getErrorString(int i) {
        return zzg.getErrorString(i);
    }

    @Nullable
    public String getOpenSourceSoftwareLicenseInfo(Context context) {
        return zzg.getOpenSourceSoftwareLicenseInfo(context);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        int isGooglePlayServicesAvailable = zzg.isGooglePlayServicesAvailable(context);
        return zzg.zzd(context, isGooglePlayServicesAvailable) ? 18 : isGooglePlayServicesAvailable;
    }

    public boolean isUserResolvableError(int i) {
        return zzg.isUserRecoverableError(i);
    }

    @Nullable
    public PendingIntent zza(Context context, int i, int i2, @Nullable String str) {
        Intent zzb = zzb(context, i, str);
        return zzb == null ? null : PendingIntent.getActivity(context, i2, zzb, 268435456);
    }

    public int zzaC(Context context) {
        return zzg.zzaC(context);
    }

    public void zzaE(Context context) {
        zzg.zzaq(context);
    }

    public void zzaF(Context context) {
        zzg.zzaF(context);
    }

    @Nullable
    public Intent zzb(Context context, int i, @Nullable String str) {
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return (context == null || !zzj.zzba(context)) ? zzp.zzD(GOOGLE_PLAY_SERVICES_PACKAGE, zzA(context, str)) : zzp.zzyb();
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return zzp.zzdp(GOOGLE_PLAY_SERVICES_PACKAGE);
            default:
                return null;
        }
    }

    @Nullable
    @Deprecated
    public Intent zzcw(int i) {
        return zzb(null, i, null);
    }

    public boolean zzd(Context context, int i) {
        return zzg.zzd(context, i);
    }

    public boolean zzz(Context context, String str) {
        return zzg.zzz(context, str);
    }
}
