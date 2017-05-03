package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import java.util.Map.Entry;

public class zztd extends zzsa {
    private static String zzags;
    private static String zzagt;
    private static zztd zzagu;

    static {
        zzags = "3";
        zzagt = "01VDIWEA?";
    }

    public zztd(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
    }

    public static zztd zzpW() {
        return zzagu;
    }

    public void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = (String) zzsw.zzafl.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzrz.zzc(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    public void zza(zzsz com_google_android_gms_internal_zzsz, String str) {
        Object obj;
        if (str == null) {
            obj = "no reason provided";
        }
        Object com_google_android_gms_internal_zzsz2 = com_google_android_gms_internal_zzsz != null ? com_google_android_gms_internal_zzsz.toString() : "no hit data";
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(obj);
        zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), com_google_android_gms_internal_zzsz2);
    }

    public synchronized void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            zzac.zzw(str);
            if (i >= 0) {
                i2 = i;
            }
            int length = i2 >= zzagt.length() ? zzagt.length() - 1 : i2;
            char c = zznT().zzoW() ? 'C' : 'c';
            String str2 = zzags;
            char charAt = zzagt.charAt(length);
            String str3 = zzsb.VERSION;
            String valueOf = String.valueOf(zzrz.zzc(str, zzm(obj), zzm(obj2), zzm(obj3)));
            String stringBuilder = new StringBuilder(((String.valueOf(str2).length() + 3) + String.valueOf(str3).length()) + String.valueOf(valueOf).length()).append(str2).append(charAt).append(c).append(str3).append(":").append(valueOf).toString();
            if (stringBuilder.length() > AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) {
                stringBuilder = stringBuilder.substring(0, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
            }
            zztg zzog = zznQ().zzog();
            if (zzog != null) {
                zzog.zzqj().zzcc(stringBuilder);
            }
        }
    }

    public void zzg(Map<String, String> map, String str) {
        Object obj;
        Object stringBuilder;
        if (str == null) {
            obj = "no reason provided";
        }
        if (map != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(',');
                }
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append('=');
                stringBuilder2.append((String) entry.getValue());
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "no hit data";
        }
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(obj);
        zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), stringBuilder);
    }

    protected String zzm(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        } else {
            if (Math.abs(((Long) l).longValue()) < 100) {
                return String.valueOf(l);
            }
            String str = String.valueOf(l).charAt(0) == '-' ? "-" : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
            return stringBuilder.toString();
        }
    }

    protected void zzmS() {
        synchronized (zztd.class) {
            zzagu = this;
        }
    }
}
