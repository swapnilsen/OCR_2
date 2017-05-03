package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@zzme
public class zzod {
    public static void zza(Context context, Runnable runnable) {
        zzac.zzdj("Adapters must be initialized on the main thread.");
        Map zzkf = zzw.zzcQ().zzkw().zzkf();
        if (zzkf != null && !zzkf.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzqf.zzc("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            zzns zzjE = zzns.zzjE();
            if (zzjE != null) {
                zza(context, zzkf.values(), zzjE);
            }
        }
    }

    static void zza(Context context, Collection<zzjr> collection, zzns com_google_android_gms_internal_zzns) {
        Map hashMap = new HashMap();
        IObjectWrapper zzA = zzd.zzA(context);
        for (zzjr com_google_android_gms_internal_zzjr : collection) {
            for (zzjq com_google_android_gms_internal_zzjq : com_google_android_gms_internal_zzjr.zzKD) {
                String str = com_google_android_gms_internal_zzjq.zzKv;
                for (String str2 : com_google_android_gms_internal_zzjq.zzKp) {
                    String str22;
                    if (!hashMap.containsKey(str22)) {
                        hashMap.put(str22, new ArrayList());
                    }
                    if (str != null) {
                        ((Collection) hashMap.get(str22)).add(str);
                    }
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            String str3 = (String) entry.getKey();
            try {
                zzol zzaN = com_google_android_gms_internal_zzns.zzaN(str3);
                if (zzaN != null) {
                    zzkb zzjN = zzaN.zzjN();
                    if (!zzjN.isInitialized() && zzjN.zzhg()) {
                        zzjN.zza(zzA, zzaN.zzjO(), (List) entry.getValue());
                        String str4 = "Initialized rewarded video mediation adapter ";
                        str22 = String.valueOf(str3);
                        zzqf.zzbf(str22.length() != 0 ? str4.concat(str22) : new String(str4));
                    }
                }
            } catch (Throwable th) {
                zzqf.zzc(new StringBuilder(String.valueOf(str3).length() + 56).append("Failed to initialize rewarded video mediation adapter \"").append(str3).append("\"").toString(), th);
            }
        }
    }
}
