package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzme;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@zzme
public class zzd {
    public static Object[] zza(String str, zzec com_google_android_gms_internal_zzec, String str2, int i, @Nullable zzeg com_google_android_gms_internal_zzeg) {
        Set hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            if (com_google_android_gms_internal_zzeg != null) {
                arrayList.add(com_google_android_gms_internal_zzeg.zzzy);
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(com_google_android_gms_internal_zzec.zzyT));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zzb(com_google_android_gms_internal_zzec.extras));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzec.zzyU));
        }
        if (hashSet.contains("keywords")) {
            if (com_google_android_gms_internal_zzec.zzyV != null) {
                arrayList.add(com_google_android_gms_internal_zzec.zzyV.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzec.zzyW));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzec.zzyX));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzec.zzyY));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(com_google_android_gms_internal_zzec.zzyZ);
        }
        if (hashSet.contains(Param.LOCATION)) {
            if (com_google_android_gms_internal_zzec.zzzb != null) {
                arrayList.add(com_google_android_gms_internal_zzec.zzzb.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(com_google_android_gms_internal_zzec.zzzc);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzb(com_google_android_gms_internal_zzec.zzzd));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzb(com_google_android_gms_internal_zzec.zzze));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (com_google_android_gms_internal_zzec.zzzf != null) {
                arrayList.add(com_google_android_gms_internal_zzec.zzzf.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(com_google_android_gms_internal_zzec.zzzg);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(com_google_android_gms_internal_zzec.zzzh);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzec.zzzi));
        }
        return arrayList.toArray();
    }

    private static String zzb(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            String zzb = obj == null ? "null" : obj instanceof Bundle ? zzb((Bundle) obj) : obj.toString();
            stringBuilder.append(zzb);
        }
        return stringBuilder.toString();
    }
}
