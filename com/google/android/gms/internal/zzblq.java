package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.appcompat.C0268R;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzbxz.zzb;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class zzblq {
    @Nullable
    static zzb zzU(@NonNull byte[] bArr) {
        try {
            return zzb.zzak(bArr);
        } catch (zzbxs e) {
            return null;
        }
    }

    static int zza(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, int i) {
        return com_google_android_gms_internal_zzbxz_zzb.zzcwa != 0 ? com_google_android_gms_internal_zzbxz_zzb.zzcwa : i == 0 ? 1 : i;
    }

    public static long zza(long j, @Nullable List<byte[]> list) {
        if (list != null) {
            for (byte[] bArr : list) {
                if (bArr != null) {
                    zzb zzU = zzU(bArr);
                    if (zzU != null && zzU.zzcvR > r4) {
                        j = zzU.zzcvR;
                    }
                }
            }
        }
        return j;
    }

    static Bundle zza(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb) {
        return zzam(com_google_android_gms_internal_zzbxz_zzb.zzcvP, com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
    }

    @Nullable
    static Object zza(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull String str, @NonNull zzblp com_google_android_gms_internal_zzblp) {
        Object newInstance;
        Throwable e;
        Object obj = null;
        try {
            Class cls = Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            Bundle zza = zza(com_google_android_gms_internal_zzbxz_zzb);
            newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            try {
                cls.getField("mOrigin").set(newInstance, str);
                cls.getField("mCreationTimestamp").set(newInstance, Long.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvR));
                cls.getField("mName").set(newInstance, com_google_android_gms_internal_zzbxz_zzb.zzcvP);
                cls.getField("mValue").set(newInstance, com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
                if (!TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvS)) {
                    obj = com_google_android_gms_internal_zzbxz_zzb.zzcvS;
                }
                cls.getField("mTriggerEventName").set(newInstance, obj);
                cls.getField("mTimedOutEventName").set(newInstance, zzd(com_google_android_gms_internal_zzbxz_zzb, com_google_android_gms_internal_zzblp));
                cls.getField("mTimedOutEventParams").set(newInstance, zza);
                cls.getField("mTriggerTimeout").set(newInstance, Integer.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvT));
                cls.getField("mTriggeredEventName").set(newInstance, zzb(com_google_android_gms_internal_zzbxz_zzb, com_google_android_gms_internal_zzblp));
                cls.getField("mTriggeredEventParams").set(newInstance, zza);
                cls.getField("mTimeToLive").set(newInstance, Integer.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvU));
                cls.getField("mExpiredEventName").set(newInstance, zze(com_google_android_gms_internal_zzbxz_zzb, com_google_android_gms_internal_zzblp));
                cls.getField("mExpiredEventParams").set(newInstance, zza);
            } catch (ClassNotFoundException e2) {
                e = e2;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (NoSuchMethodException e3) {
                e = e3;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (IllegalAccessException e4) {
                e = e4;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (InvocationTargetException e5) {
                e = e5;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (NoSuchFieldException e6) {
                e = e6;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (InstantiationException e7) {
                e = e7;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            }
        } catch (ClassNotFoundException e8) {
            e = e8;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (NoSuchMethodException e9) {
            e = e9;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (IllegalAccessException e10) {
            e = e10;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (InvocationTargetException e11) {
            e = e11;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (NoSuchFieldException e12) {
            e = e12;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (InstantiationException e13) {
            e = e13;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        }
        return newInstance;
    }

    static String zza(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzblp com_google_android_gms_internal_zzblp) {
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvV) ? com_google_android_gms_internal_zzbxz_zzb.zzcvV : com_google_android_gms_internal_zzblp.zzUZ();
    }

    public static void zza(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        Throwable e;
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str5 = "FirebaseAbtUtil";
            String str6 = "_CE(experimentId) called by ";
            String valueOf = String.valueOf(str);
            Log.v(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
        }
        if (zzco(context)) {
            AppMeasurement zzbj = zzbj(context);
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("clearConditionalUserProperty", new Class[]{String.class, String.class, Bundle.class});
                declaredMethod.setAccessible(true);
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(str2).length() + 17) + String.valueOf(str3).length()).append("Clearing _E: [").append(str2).append(", ").append(str3).append("]").toString());
                }
                declaredMethod.invoke(zzbj, new Object[]{str2, str4, zzam(str2, str3)});
            } catch (NoSuchMethodException e2) {
                e = e2;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            } catch (IllegalAccessException e3) {
                e = e3;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            } catch (InvocationTargetException e4) {
                e = e4;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        }
    }

    public static void zza(@NonNull Context context, @NonNull String str, @NonNull List<byte[]> list, int i, @NonNull zzblp com_google_android_gms_internal_zzblp, long j) {
        Throwable e;
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str2 = "FirebaseAbtUtil";
            String str3 = "_UE called by ";
            String valueOf = String.valueOf(str);
            Log.v(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        if (zzco(context)) {
            AppMeasurement zzbj = zzbj(context);
            try {
                String zzab;
                Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                List zzb = zzb(zzbj, str);
                ArrayList arrayList = new ArrayList();
                List<zzb> zzc = zzc((List) list, zzb);
                for (Object next : zzd((List) list, zzb)) {
                    zzab = zzab(next);
                    String zzac = zzac(next);
                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(zzab).length() + 30).append("Clearing _E as part of _UE: [").append(zzab).append("]").toString());
                    }
                    zza(context, str, zzab, zzac, zzc(null, com_google_android_gms_internal_zzblp));
                }
                for (zzb com_google_android_gms_internal_zzbxz_zzb : zzc) {
                    if (com_google_android_gms_internal_zzbxz_zzb.zzcvR > j) {
                        str3 = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvP);
                        zzab = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
                        Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(str3).length() + C0268R.styleable.AppCompatTheme_editTextStyle) + String.valueOf(zzab).length()).append("Setting _E as part of _UE: [").append(str3).append(", ").append(zzab).append(", ").append(com_google_android_gms_internal_zzbxz_zzb.zzcvR).append("], latestOriginKnownExpStartTime: ").append(j).toString());
                        zza(zzbj, context, str, com_google_android_gms_internal_zzbxz_zzb, com_google_android_gms_internal_zzblp, i);
                    } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        str3 = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvP);
                        zzab = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
                        Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(str3).length() + 118) + String.valueOf(zzab).length()).append("Not setting _E, due to lastUpdateTime: [").append(str3).append(", ").append(zzab).append(", ").append(com_google_android_gms_internal_zzbxz_zzb.zzcvR).append("], latestOriginKnownExpStartTime: ").append(j).toString());
                    }
                }
            } catch (ClassNotFoundException e2) {
                e = e2;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            } catch (IllegalAccessException e3) {
                e = e3;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            } catch (NoSuchFieldException e4) {
                e = e4;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        }
    }

    static void zza(@NonNull AppMeasurement appMeasurement, @NonNull Context context, @NonNull String str, @NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzblp com_google_android_gms_internal_zzblp, int i) {
        Throwable e;
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvP);
            String valueOf2 = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
            Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(valueOf2).length()).append("_SEI: ").append(valueOf).append(" ").append(valueOf2).toString());
        }
        try {
            Object obj;
            Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            List zzb = zzb(appMeasurement, str);
            if (zza(appMeasurement, str)) {
                if (zza(com_google_android_gms_internal_zzbxz_zzb, i) == 1) {
                    obj = zzb.get(0);
                    valueOf2 = zzab(obj);
                    valueOf = zzac(obj);
                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(valueOf2).length() + 38).append("Clearing _E due to overflow policy: [").append(valueOf2).append("]").toString());
                    }
                    zza(context, str, valueOf2, valueOf, zzc(com_google_android_gms_internal_zzbxz_zzb, com_google_android_gms_internal_zzblp));
                } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    valueOf = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvP);
                    valueOf2 = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
                    Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(valueOf).length() + 44) + String.valueOf(valueOf2).length()).append("_E won't be set due to overflow policy. [").append(valueOf).append(", ").append(valueOf2).append("]").toString());
                    return;
                } else {
                    return;
                }
            }
            for (Object obj2 : zzb) {
                valueOf2 = zzab(obj2);
                valueOf = zzac(obj2);
                if (valueOf2.equals(com_google_android_gms_internal_zzbxz_zzb.zzcvP) && !valueOf.equals(com_google_android_gms_internal_zzbxz_zzb.zzcvQ) && Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(valueOf2).length() + 77) + String.valueOf(valueOf).length()).append("Clearing _E, as only one _V of the same _E can be set atany given time: [").append(valueOf2).append(", ").append(valueOf).append("].").toString());
                    zza(context, str, valueOf2, valueOf, zzc(com_google_android_gms_internal_zzbxz_zzb, com_google_android_gms_internal_zzblp));
                }
            }
            Object zza = zza(com_google_android_gms_internal_zzbxz_zzb, str, com_google_android_gms_internal_zzblp);
            if (zza != null) {
                zza(appMeasurement, com_google_android_gms_internal_zzbxz_zzb, com_google_android_gms_internal_zzblp, zza, str);
            } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                valueOf = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvP);
                valueOf2 = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
                Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(valueOf).length() + 42) + String.valueOf(valueOf2).length()).append("Could not create _CUP for: [").append(valueOf).append(", ").append(valueOf2).append("]. Skipping.").toString());
            }
        } catch (ClassNotFoundException e2) {
            e = e2;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
        } catch (IllegalAccessException e3) {
            e = e3;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
        } catch (NoSuchFieldException e4) {
            e = e4;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zza(@android.support.annotation.NonNull com.google.android.gms.measurement.AppMeasurement r6, @android.support.annotation.NonNull com.google.android.gms.internal.zzbxz.zzb r7, @android.support.annotation.NonNull com.google.android.gms.internal.zzblp r8, @android.support.annotation.NonNull java.lang.Object r9, @android.support.annotation.NonNull java.lang.String r10) {
        /*
        r0 = "FirebaseAbtUtil";
        r1 = 2;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0069;
    L_0x0009:
        r0 = "FirebaseAbtUtil";
        r1 = r7.zzcvP;
        r1 = java.lang.String.valueOf(r1);
        r2 = r7.zzcvQ;
        r2 = java.lang.String.valueOf(r2);
        r3 = r7.zzcvS;
        r3 = java.lang.String.valueOf(r3);
        r4 = java.lang.String.valueOf(r1);
        r4 = r4.length();
        r4 = r4 + 27;
        r5 = java.lang.String.valueOf(r2);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Setting _CUP for _E: [";
        r4 = r5.append(r4);
        r1 = r4.append(r1);
        r4 = ", ";
        r1 = r1.append(r4);
        r1 = r1.append(r2);
        r2 = ", ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = "]";
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0069:
        r0 = "com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r1 = com.google.android.gms.measurement.AppMeasurement.class;
        r2 = "setConditionalUserProperty";
        r3 = 1;
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r4 = 0;
        r3[r4] = r0;	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r0 = r1.getDeclaredMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r1 = 1;
        r0.setAccessible(r1);	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r1 = zza(r7, r8);	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r2 = zza(r7);	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r6.logEventInternal(r10, r1, r2);	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r2 = 0;
        r1[r2] = r9;	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r0.invoke(r6, r1);	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
    L_0x0095:
        return;
    L_0x0096:
        r0 = move-exception;
    L_0x0097:
        r1 = "FirebaseAbtUtil";
        r2 = "Could not complete the operation due to an internal error.";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0095;
    L_0x009f:
        r0 = move-exception;
        goto L_0x0097;
    L_0x00a1:
        r0 = move-exception;
        goto L_0x0097;
    L_0x00a3:
        r0 = move-exception;
        goto L_0x0097;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzblq.zza(com.google.android.gms.measurement.AppMeasurement, com.google.android.gms.internal.zzbxz$zzb, com.google.android.gms.internal.zzblp, java.lang.Object, java.lang.String):void");
    }

    static boolean zza(@NonNull AppMeasurement appMeasurement, @NonNull String str) {
        return zzb(appMeasurement, str).size() >= zzc(appMeasurement, str);
    }

    static String zzab(@NonNull Object obj) {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mName").get(obj);
    }

    static String zzac(@NonNull Object obj) {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mValue").get(obj);
    }

    static Bundle zzam(@NonNull String str, @NonNull String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    static String zzb(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzblp com_google_android_gms_internal_zzblp) {
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvW) ? com_google_android_gms_internal_zzbxz_zzb.zzcvW : com_google_android_gms_internal_zzblp.zzVa();
    }

    static List<Object> zzb(@NonNull AppMeasurement appMeasurement, @NonNull String str) {
        List<Object> list;
        Throwable e;
        Object obj;
        ArrayList arrayList = new ArrayList();
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getConditionalUserProperties", new Class[]{String.class, String.class});
            declaredMethod.setAccessible(true);
            list = (List) declaredMethod.invoke(appMeasurement, new Object[]{str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING});
        } catch (NoSuchMethodException e2) {
            e = e2;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            obj = arrayList;
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str).length() + 55).append("Number of currently set _Es for origin: ").append(str).append(" is ").append(list.size()).toString());
            }
            return list;
        } catch (IllegalAccessException e3) {
            e = e3;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            obj = arrayList;
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str).length() + 55).append("Number of currently set _Es for origin: ").append(str).append(" is ").append(list.size()).toString());
            }
            return list;
        } catch (InvocationTargetException e4) {
            e = e4;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            obj = arrayList;
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str).length() + 55).append("Number of currently set _Es for origin: ").append(str).append(" is ").append(list.size()).toString());
            }
            return list;
        }
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str).length() + 55).append("Number of currently set _Es for origin: ").append(str).append(" is ").append(list.size()).toString());
        }
        return list;
    }

    @Nullable
    static AppMeasurement zzbj(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    static int zzc(@NonNull AppMeasurement appMeasurement, @NonNull String str) {
        Throwable e;
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getMaxUserProperties", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(appMeasurement, new Object[]{str})).intValue();
        } catch (NoSuchMethodException e2) {
            e = e2;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        } catch (IllegalAccessException e3) {
            e = e3;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        } catch (InvocationTargetException e4) {
            e = e4;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        }
    }

    static String zzc(@Nullable zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzblp com_google_android_gms_internal_zzblp) {
        return (com_google_android_gms_internal_zzbxz_zzb == null || TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvX)) ? com_google_android_gms_internal_zzblp.zzVd() : com_google_android_gms_internal_zzbxz_zzb.zzcvX;
    }

    static List<zzb> zzc(@NonNull List<byte[]> list, @NonNull List<Object> list2) {
        Throwable e;
        List<zzb> arrayList = new ArrayList();
        for (byte[] zzU : list) {
            zzb zzU2 = zzU(zzU);
            if (zzU2 != null) {
                Object obj;
                for (Object obj2 : list2) {
                    try {
                        Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                        zzab(obj2);
                        String zzac = zzac(obj2);
                        if (zzU2.zzcvP.equals(zzab(obj2)) && zzU2.zzcvQ.equals(zzac)) {
                            obj2 = 1;
                            break;
                        }
                    } catch (ClassNotFoundException e2) {
                        e = e2;
                        Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                    } catch (IllegalAccessException e3) {
                        e = e3;
                        Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                    } catch (NoSuchFieldException e4) {
                        e = e4;
                        Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                    }
                }
                obj2 = null;
                if (obj2 == null) {
                    arrayList.add(zzU2);
                }
            } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", "Couldn't deserialize the payload; skipping.");
            }
        }
        return arrayList;
    }

    private static boolean zzco(Context context) {
        if (zzbj(context) != null) {
            try {
                Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                return true;
            } catch (ClassNotFoundException e) {
                if (!Log.isLoggable("FirebaseAbtUtil", 2)) {
                    return false;
                }
                Log.v("FirebaseAbtUtil", "Firebase Analytics library is missing support for abt. Please update to a more recent version.");
                return false;
            }
        } else if (!Log.isLoggable("FirebaseAbtUtil", 2)) {
            return false;
        } else {
            Log.v("FirebaseAbtUtil", "Firebase Analytics not available");
            return false;
        }
    }

    static String zzd(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzblp com_google_android_gms_internal_zzblp) {
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvY) ? com_google_android_gms_internal_zzbxz_zzb.zzcvY : com_google_android_gms_internal_zzblp.zzVb();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<java.lang.Object> zzd(@android.support.annotation.NonNull java.util.List<byte[]> r9, @android.support.annotation.NonNull java.util.List<java.lang.Object> r10) {
        /*
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = r10.iterator();
    L_0x0009:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x006a;
    L_0x000f:
        r4 = r3.next();
        r0 = "com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty";
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        r5 = zzab(r4);	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        r6 = zzac(r4);	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        r1 = 1;
        r7 = r9.iterator();	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
    L_0x0025:
        r0 = r7.hasNext();	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        if (r0 == 0) goto L_0x006d;
    L_0x002b:
        r0 = r7.next();	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        r0 = (byte[]) r0;	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        r0 = zzU(r0);	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        if (r0 != 0) goto L_0x0051;
    L_0x0037:
        r0 = "FirebaseAbtUtil";
        r8 = 2;
        r0 = android.util.Log.isLoggable(r0, r8);	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        if (r0 == 0) goto L_0x0025;
    L_0x0040:
        r0 = "FirebaseAbtUtil";
        r8 = "Couldn't deserialize the payload; skipping.";
        android.util.Log.v(r0, r8);	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        goto L_0x0025;
    L_0x0048:
        r0 = move-exception;
    L_0x0049:
        r1 = "FirebaseAbtUtil";
        r4 = "Could not complete the operation due to an internal error.";
        android.util.Log.e(r1, r4, r0);
        goto L_0x0009;
    L_0x0051:
        r8 = r0.zzcvP;	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        r8 = r8.equals(r5);	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        if (r8 == 0) goto L_0x0025;
    L_0x0059:
        r0 = r0.zzcvQ;	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        r0 = r0.equals(r6);	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        if (r0 == 0) goto L_0x0025;
    L_0x0061:
        r0 = 0;
    L_0x0062:
        if (r0 == 0) goto L_0x0009;
    L_0x0064:
        r2.add(r4);	 Catch:{ ClassNotFoundException -> 0x0048, IllegalAccessException -> 0x0068, NoSuchFieldException -> 0x006b }
        goto L_0x0009;
    L_0x0068:
        r0 = move-exception;
        goto L_0x0049;
    L_0x006a:
        return r2;
    L_0x006b:
        r0 = move-exception;
        goto L_0x0049;
    L_0x006d:
        r0 = r1;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzblq.zzd(java.util.List, java.util.List):java.util.List<java.lang.Object>");
    }

    static String zze(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzblp com_google_android_gms_internal_zzblp) {
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvZ) ? com_google_android_gms_internal_zzbxz_zzb.zzcvZ : com_google_android_gms_internal_zzblp.zzVc();
    }
}
