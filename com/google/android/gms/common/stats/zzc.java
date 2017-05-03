package com.google.android.gms.common.stats;

import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

public class zzc {
    static List<String> zzB(List<String> list) {
        return (list != null && list.size() == 1 && GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(list.get(0))) ? null : list;
    }

    public static String zza(WakeLock wakeLock, String str) {
        Object obj;
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (TextUtils.isEmpty(str)) {
            obj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        String valueOf2 = String.valueOf(obj);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static String zzdx(String str) {
        return GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(str) ? null : str;
    }
}
