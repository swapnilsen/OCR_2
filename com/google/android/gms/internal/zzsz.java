package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzsz {
    private final Map<String, String> zzFP;
    private final List<zzsl> zzagg;
    private final long zzagh;
    private final long zzagi;
    private final int zzagj;
    private final boolean zzagk;
    private final String zzagl;

    public zzsz(zzrz com_google_android_gms_internal_zzrz, Map<String, String> map, long j, boolean z) {
        this(com_google_android_gms_internal_zzrz, map, j, z, 0, 0, null);
    }

    public zzsz(zzrz com_google_android_gms_internal_zzrz, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(com_google_android_gms_internal_zzrz, map, j, z, j2, i, null);
    }

    public zzsz(zzrz com_google_android_gms_internal_zzrz, Map<String, String> map, long j, boolean z, long j2, int i, List<zzsl> list) {
        zzac.zzw(com_google_android_gms_internal_zzrz);
        zzac.zzw(map);
        this.zzagi = j;
        this.zzagk = z;
        this.zzagh = j2;
        this.zzagj = i;
        this.zzagg = list != null ? list : Collections.emptyList();
        this.zzagl = zzs(list);
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String zza;
            if (zzl(entry.getKey())) {
                zza = zza(com_google_android_gms_internal_zzrz, entry.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(com_google_android_gms_internal_zzrz, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!zzl(entry2.getKey())) {
                zza = zza(com_google_android_gms_internal_zzrz, entry2.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(com_google_android_gms_internal_zzrz, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.zzagl)) {
            zztm.zzc(hashMap, "_v", this.zzagl);
            if (this.zzagl.equals("ma4.0.0") || this.zzagl.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.zzFP = Collections.unmodifiableMap(hashMap);
    }

    public static zzsz zza(zzrz com_google_android_gms_internal_zzrz, zzsz com_google_android_gms_internal_zzsz, Map<String, String> map) {
        return new zzsz(com_google_android_gms_internal_zzrz, map, com_google_android_gms_internal_zzsz.zzpQ(), com_google_android_gms_internal_zzsz.zzpS(), com_google_android_gms_internal_zzsz.zzpP(), com_google_android_gms_internal_zzsz.zzpO(), com_google_android_gms_internal_zzsz.zzpR());
    }

    private static String zza(zzrz com_google_android_gms_internal_zzrz, Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
            obj2 = obj2.substring(0, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
            com_google_android_gms_internal_zzrz.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        return TextUtils.isEmpty(obj2) ? null : obj2;
    }

    private static String zzb(zzrz com_google_android_gms_internal_zzrz, Object obj) {
        String obj2 = obj == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING : obj.toString();
        int length = obj2.length();
        if (length <= AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD) {
            return obj2;
        }
        obj2 = obj2.substring(0, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        com_google_android_gms_internal_zzrz.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    private static boolean zzl(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    private String zzs(String str, String str2) {
        zzac.zzdr(str);
        zzac.zzb(!str.startsWith("&"), (Object) "Short param name required");
        String str3 = (String) this.zzFP.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String zzs(List<zzsl> list) {
        CharSequence value;
        if (list != null) {
            for (zzsl com_google_android_gms_internal_zzsl : list) {
                if ("appendVersion".equals(com_google_android_gms_internal_zzsl.getId())) {
                    value = com_google_android_gms_internal_zzsl.getValue();
                    break;
                }
            }
        }
        value = null;
        return TextUtils.isEmpty(value) ? null : value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.zzagi);
        if (this.zzagh != 0) {
            stringBuffer.append(", dbId=").append(this.zzagh);
        }
        if (this.zzagj != 0) {
            stringBuffer.append(", appUID=").append(this.zzagj);
        }
        List<String> arrayList = new ArrayList(this.zzFP.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) this.zzFP.get(str));
        }
        return stringBuffer.toString();
    }

    public Map<String, String> zzfE() {
        return this.zzFP;
    }

    public int zzpO() {
        return this.zzagj;
    }

    public long zzpP() {
        return this.zzagh;
    }

    public long zzpQ() {
        return this.zzagi;
    }

    public List<zzsl> zzpR() {
        return this.zzagg;
    }

    public boolean zzpS() {
        return this.zzagk;
    }

    public long zzpT() {
        return zztm.zzcf(zzs("_s", "0"));
    }

    public String zzpU() {
        return zzs("_m", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
    }
}
