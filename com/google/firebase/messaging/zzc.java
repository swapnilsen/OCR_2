package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzbxs;
import com.google.android.gms.internal.zzbxz.zzb;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class zzc {
    static int m5259a(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, int i) {
        return com_google_android_gms_internal_zzbxz_zzb.zzcwa != 0 ? com_google_android_gms_internal_zzbxz_zzb.zzcwa : i == 0 ? 1 : i;
    }

    static Bundle m5260a(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb) {
        return m5261a(com_google_android_gms_internal_zzbxz_zzb.zzcvP, com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
    }

    static Bundle m5261a(@NonNull String str, @NonNull String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    @Nullable
    static zzb m5262a(@NonNull byte[] bArr) {
        try {
            return zzb.zzak(bArr);
        } catch (zzbxs e) {
            return null;
        }
    }

    @Nullable
    static AppMeasurement m5263a(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    @Nullable
    static Object m5264a(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull String str, @NonNull zzb com_google_firebase_messaging_zzb) {
        Object newInstance;
        Throwable e;
        Object obj = null;
        try {
            Class cls = Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            Bundle a = m5260a(com_google_android_gms_internal_zzbxz_zzb);
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
                cls.getField("mTimedOutEventName").set(newInstance, m5277d(com_google_android_gms_internal_zzbxz_zzb, com_google_firebase_messaging_zzb));
                cls.getField("mTimedOutEventParams").set(newInstance, a);
                cls.getField("mTriggerTimeout").set(newInstance, Integer.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvT));
                cls.getField("mTriggeredEventName").set(newInstance, m5270b(com_google_android_gms_internal_zzbxz_zzb, com_google_firebase_messaging_zzb));
                cls.getField("mTriggeredEventParams").set(newInstance, a);
                cls.getField("mTimeToLive").set(newInstance, Integer.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvU));
                cls.getField("mExpiredEventName").set(newInstance, m5278e(com_google_android_gms_internal_zzbxz_zzb, com_google_firebase_messaging_zzb));
                cls.getField("mExpiredEventParams").set(newInstance, a);
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

    static String m5265a(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzb com_google_firebase_messaging_zzb) {
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvV) ? com_google_android_gms_internal_zzbxz_zzb.zzcvV : com_google_firebase_messaging_zzb.zzUZ();
    }

    static String m5266a(@NonNull Object obj) {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mName").get(obj);
    }

    static void m5267a(@NonNull AppMeasurement appMeasurement, @NonNull Context context, @NonNull String str, @NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzb com_google_firebase_messaging_zzb, int i) {
        Throwable e;
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvP);
            String valueOf2 = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
            Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(valueOf2).length()).append("_SEI: ").append(valueOf).append(" ").append(valueOf2).toString());
        }
        try {
            Object obj;
            Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            List b = m5272b(appMeasurement, str);
            if (m5269a(appMeasurement, str)) {
                if (m5259a(com_google_android_gms_internal_zzbxz_zzb, i) == 1) {
                    obj = b.get(0);
                    valueOf2 = m5266a(obj);
                    valueOf = m5271b(obj);
                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(valueOf2).length() + 38).append("Clearing _E due to overflow policy: [").append(valueOf2).append("]").toString());
                    }
                    zza(context, str, valueOf2, valueOf, m5276c(com_google_android_gms_internal_zzbxz_zzb, com_google_firebase_messaging_zzb));
                } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    valueOf = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvP);
                    valueOf2 = String.valueOf(com_google_android_gms_internal_zzbxz_zzb.zzcvQ);
                    Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(valueOf).length() + 44) + String.valueOf(valueOf2).length()).append("_E won't be set due to overflow policy. [").append(valueOf).append(", ").append(valueOf2).append("]").toString());
                    return;
                } else {
                    return;
                }
            }
            for (Object obj2 : b) {
                valueOf2 = m5266a(obj2);
                valueOf = m5271b(obj2);
                if (valueOf2.equals(com_google_android_gms_internal_zzbxz_zzb.zzcvP) && !valueOf.equals(com_google_android_gms_internal_zzbxz_zzb.zzcvQ) && Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(valueOf2).length() + 77) + String.valueOf(valueOf).length()).append("Clearing _E, as only one _V of the same _E can be set atany given time: [").append(valueOf2).append(", ").append(valueOf).append("].").toString());
                    zza(context, str, valueOf2, valueOf, m5276c(com_google_android_gms_internal_zzbxz_zzb, com_google_firebase_messaging_zzb));
                }
            }
            Object a = m5264a(com_google_android_gms_internal_zzbxz_zzb, str, com_google_firebase_messaging_zzb);
            if (a != null) {
                m5268a(appMeasurement, com_google_android_gms_internal_zzbxz_zzb, com_google_firebase_messaging_zzb, a, str);
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
    static void m5268a(@android.support.annotation.NonNull com.google.android.gms.measurement.AppMeasurement r6, @android.support.annotation.NonNull com.google.android.gms.internal.zzbxz.zzb r7, @android.support.annotation.NonNull com.google.firebase.messaging.zzb r8, @android.support.annotation.NonNull java.lang.Object r9, @android.support.annotation.NonNull java.lang.String r10) {
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
        r1 = m5265a(r7, r8);	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
        r2 = m5260a(r7);	 Catch:{ ClassNotFoundException -> 0x0096, NoSuchMethodException -> 0x00a1, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x00a3 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzc.a(com.google.android.gms.measurement.AppMeasurement, com.google.android.gms.internal.zzbxz$zzb, com.google.firebase.messaging.zzb, java.lang.Object, java.lang.String):void");
    }

    static boolean m5269a(@NonNull AppMeasurement appMeasurement, @NonNull String str) {
        return m5272b(appMeasurement, str).size() >= m5274c(appMeasurement, str);
    }

    static String m5270b(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzb com_google_firebase_messaging_zzb) {
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvW) ? com_google_android_gms_internal_zzbxz_zzb.zzcvW : com_google_firebase_messaging_zzb.zzVa();
    }

    static String m5271b(@NonNull Object obj) {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mValue").get(obj);
    }

    static List<Object> m5272b(@NonNull AppMeasurement appMeasurement, @NonNull String str) {
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

    private static boolean m5273b(Context context) {
        if (m5263a(context) != null) {
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

    static int m5274c(@NonNull AppMeasurement appMeasurement, @NonNull String str) {
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

    static long m5275c(@NonNull Object obj) {
        return ((Long) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mCreationTimestamp").get(obj)).longValue();
    }

    static String m5276c(@Nullable zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzb com_google_firebase_messaging_zzb) {
        return (com_google_android_gms_internal_zzbxz_zzb == null || TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvX)) ? com_google_firebase_messaging_zzb.zzVd() : com_google_android_gms_internal_zzbxz_zzb.zzcvX;
    }

    static String m5277d(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzb com_google_firebase_messaging_zzb) {
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvY) ? com_google_android_gms_internal_zzbxz_zzb.zzcvY : com_google_firebase_messaging_zzb.zzVb();
    }

    static String m5278e(@NonNull zzb com_google_android_gms_internal_zzbxz_zzb, @NonNull zzb com_google_firebase_messaging_zzb) {
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzbxz_zzb.zzcvZ) ? com_google_android_gms_internal_zzbxz_zzb.zzcvZ : com_google_firebase_messaging_zzb.zzVc();
    }

    public static void zza(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        Throwable e;
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str5 = "FirebaseAbtUtil";
            String str6 = "_CE(experimentId) called by ";
            String valueOf = String.valueOf(str);
            Log.v(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
        }
        if (m5273b(context)) {
            AppMeasurement a = m5263a(context);
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("clearConditionalUserProperty", new Class[]{String.class, String.class, Bundle.class});
                declaredMethod.setAccessible(true);
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(str2).length() + 17) + String.valueOf(str3).length()).append("Clearing _E: [").append(str2).append(", ").append(str3).append("]").toString());
                }
                declaredMethod.invoke(a, new Object[]{str2, str4, m5261a(str2, str3)});
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(@android.support.annotation.NonNull android.content.Context r15, @android.support.annotation.NonNull java.lang.String r16, @android.support.annotation.NonNull byte[] r17, @android.support.annotation.NonNull com.google.firebase.messaging.zzb r18, int r19) {
        /*
        r2 = "FirebaseAbtUtil";
        r3 = 2;
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x001e;
    L_0x0009:
        r3 = "FirebaseAbtUtil";
        r4 = "_SE called by ";
        r2 = java.lang.String.valueOf(r16);
        r5 = r2.length();
        if (r5 == 0) goto L_0x0025;
    L_0x0017:
        r2 = r4.concat(r2);
    L_0x001b:
        android.util.Log.v(r3, r2);
    L_0x001e:
        r2 = m5273b(r15);
        if (r2 != 0) goto L_0x002b;
    L_0x0024:
        return;
    L_0x0025:
        r2 = new java.lang.String;
        r2.<init>(r4);
        goto L_0x001b;
    L_0x002b:
        r2 = m5263a(r15);
        r5 = m5262a(r17);
        if (r5 != 0) goto L_0x0046;
    L_0x0035:
        r2 = "FirebaseAbtUtil";
        r3 = 2;
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x0024;
    L_0x003e:
        r2 = "FirebaseAbtUtil";
        r3 = "_SE failed; either _P was not set, or we couldn't deserialize the _P.";
        android.util.Log.v(r2, r3);
        goto L_0x0024;
    L_0x0046:
        r3 = "com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty";
        java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r0 = r16;
        r4 = m5272b(r2, r0);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r3 = 0;
        r7 = r4.iterator();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r6 = r3;
    L_0x0057:
        r3 = r7.hasNext();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        if (r3 == 0) goto L_0x01c9;
    L_0x005d:
        r3 = r7.next();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r8 = m5266a(r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r9 = m5271b(r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r10 = m5275c(r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r3 = r5.zzcvP;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r3 = r3.equals(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        if (r3 == 0) goto L_0x00c4;
    L_0x0075:
        r3 = r5.zzcvQ;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r3 = r3.equals(r9);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        if (r3 == 0) goto L_0x00c4;
    L_0x007d:
        r3 = "FirebaseAbtUtil";
        r4 = 2;
        r3 = android.util.Log.isLoggable(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        if (r3 == 0) goto L_0x00c1;
    L_0x0086:
        r3 = "FirebaseAbtUtil";
        r4 = java.lang.String.valueOf(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4 + 23;
        r6 = java.lang.String.valueOf(r9);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r6 = r6.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4 + r6;
        r6 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r6.<init>(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = "_E is already set. [";
        r4 = r6.append(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.append(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r6 = ", ";
        r4 = r4.append(r6);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.append(r9);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r6 = "]";
        r4 = r4.append(r6);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.toString();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        android.util.Log.v(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
    L_0x00c1:
        r3 = 1;
        r6 = r3;
        goto L_0x0057;
    L_0x00c4:
        r3 = 0;
        r12 = r5.zzcwb;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r13 = r12.length;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = 0;
    L_0x00c9:
        if (r4 >= r13) goto L_0x011a;
    L_0x00cb:
        r14 = r12[r4];	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r14 = r14.zzcvP;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r14 = r14.equals(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        if (r14 == 0) goto L_0x017d;
    L_0x00d5:
        r3 = "FirebaseAbtUtil";
        r4 = 2;
        r3 = android.util.Log.isLoggable(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        if (r3 == 0) goto L_0x0119;
    L_0x00de:
        r3 = "FirebaseAbtUtil";
        r4 = java.lang.String.valueOf(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4 + 33;
        r12 = java.lang.String.valueOf(r9);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r12 = r12.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4 + r12;
        r12 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r12.<init>(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = "_E is found in the _OE list. [";
        r4 = r12.append(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.append(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r12 = ", ";
        r4 = r4.append(r12);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.append(r9);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r12 = "]";
        r4 = r4.append(r12);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.toString();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        android.util.Log.v(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
    L_0x0119:
        r3 = 1;
    L_0x011a:
        if (r3 != 0) goto L_0x0057;
    L_0x011c:
        r12 = r5.zzcvR;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0181;
    L_0x0122:
        r3 = "FirebaseAbtUtil";
        r4 = 2;
        r3 = android.util.Log.isLoggable(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        if (r3 == 0) goto L_0x0166;
    L_0x012b:
        r3 = "FirebaseAbtUtil";
        r4 = java.lang.String.valueOf(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4 + 115;
        r10 = java.lang.String.valueOf(r9);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r10 = r10.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4 + r10;
        r10 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r10.<init>(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = "Clearing _E as it was not in the _OE list, andits start time is older than the start time of the _E to be set. [";
        r4 = r10.append(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.append(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r10 = ", ";
        r4 = r4.append(r10);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.append(r9);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r10 = "]";
        r4 = r4.append(r10);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.toString();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        android.util.Log.v(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
    L_0x0166:
        r0 = r18;
        r3 = m5276c(r5, r0);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r0 = r16;
        zza(r15, r0, r8, r9, r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        goto L_0x0057;
    L_0x0173:
        r2 = move-exception;
    L_0x0174:
        r3 = "FirebaseAbtUtil";
        r4 = "Could not complete the operation due to an internal error.";
        android.util.Log.e(r3, r4, r2);
        goto L_0x0024;
    L_0x017d:
        r4 = r4 + 1;
        goto L_0x00c9;
    L_0x0181:
        r3 = "FirebaseAbtUtil";
        r4 = 2;
        r3 = android.util.Log.isLoggable(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        if (r3 == 0) goto L_0x0057;
    L_0x018a:
        r3 = "FirebaseAbtUtil";
        r4 = java.lang.String.valueOf(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4 + 109;
        r10 = java.lang.String.valueOf(r9);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r10 = r10.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4 + r10;
        r10 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r10.<init>(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = "_E was not found in the _OE list, but not clearing it as it has a new start time than the _E to be set.  [";
        r4 = r10.append(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.append(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r8 = ", ";
        r4 = r4.append(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.append(r9);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r8 = "]";
        r4 = r4.append(r8);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r4.toString();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        android.util.Log.v(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        goto L_0x0057;
    L_0x01c7:
        r2 = move-exception;
        goto L_0x0174;
    L_0x01c9:
        if (r6 == 0) goto L_0x0220;
    L_0x01cb:
        r2 = "FirebaseAbtUtil";
        r3 = 2;
        r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        if (r2 == 0) goto L_0x0024;
    L_0x01d4:
        r2 = "FirebaseAbtUtil";
        r3 = r5.zzcvP;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = r5.zzcvQ;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r5 = java.lang.String.valueOf(r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r5 = r5.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r5 = r5 + 44;
        r6 = java.lang.String.valueOf(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r6 = r6.length();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r5 = r5 + r6;
        r6 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r6.<init>(r5);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r5 = "_E is already set. Not setting it again [";
        r5 = r6.append(r5);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r3 = r5.append(r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r5 = ", ";
        r3 = r3.append(r5);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r3 = r3.append(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r4 = "]";
        r3 = r3.append(r4);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        r3 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        android.util.Log.v(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        goto L_0x0024;
    L_0x021d:
        r2 = move-exception;
        goto L_0x0174;
    L_0x0220:
        r3 = r15;
        r4 = r16;
        r6 = r18;
        r7 = r19;
        m5267a(r2, r3, r4, r5, r6, r7);	 Catch:{ ClassNotFoundException -> 0x0173, IllegalAccessException -> 0x01c7, NoSuchFieldException -> 0x021d }
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzc.zza(android.content.Context, java.lang.String, byte[], com.google.firebase.messaging.zzb, int):void");
    }
}
