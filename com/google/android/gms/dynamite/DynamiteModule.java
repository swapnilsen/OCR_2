package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public final class DynamiteModule {
    private static Boolean zzaRO;
    private static zza zzaRP;
    private static zzb zzaRQ;
    private static final HashMap<String, byte[]> zzaRR;
    private static String zzaRS;
    private static final zza zzaRT;
    public static final zzb zzaRU;
    public static final zzb zzaRV;
    public static final zzb zzaRW;
    public static final zzb zzaRX;
    public static final zzb zzaRY;
    private final Context zzaRZ;

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.1 */
    class C10011 implements zza {
        C10011() {
        }

        public int zzH(Context context, String str) {
            return DynamiteModule.zzH(context, str);
        }

        public int zzb(Context context, String str, boolean z) {
            return DynamiteModule.zzb(context, str, z);
        }
    }

    public interface zzb {

        public interface zza {
            int zzH(Context context, String str);

            int zzb(Context context, String str, boolean z);
        }

        public static class zzb {
            public int zzaSb;
            public int zzaSc;
            public int zzaSd;

            public zzb() {
                this.zzaSb = 0;
                this.zzaSc = 0;
                this.zzaSd = 0;
            }
        }

        zzb zza(Context context, String str, zza com_google_android_gms_dynamite_DynamiteModule_zzb_zza);
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.2 */
    class C10022 implements zzb {
        C10022() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_dynamite_DynamiteModule_zzb_zza) {
            zzb com_google_android_gms_dynamite_DynamiteModule_zzb_zzb = new zzb();
            com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzb(context, str, true);
            if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc != 0) {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = 1;
            } else {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzH(context, str);
                if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb != 0) {
                    com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = -1;
                }
            }
            return com_google_android_gms_dynamite_DynamiteModule_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.3 */
    class C10033 implements zzb {
        C10033() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_dynamite_DynamiteModule_zzb_zza) {
            zzb com_google_android_gms_dynamite_DynamiteModule_zzb_zzb = new zzb();
            com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzH(context, str);
            if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb != 0) {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = -1;
            } else {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzb(context, str, true);
                if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc != 0) {
                    com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = 1;
                }
            }
            return com_google_android_gms_dynamite_DynamiteModule_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.4 */
    class C10044 implements zzb {
        C10044() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_dynamite_DynamiteModule_zzb_zza) {
            zzb com_google_android_gms_dynamite_DynamiteModule_zzb_zzb = new zzb();
            com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzH(context, str);
            com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzb(context, str, true);
            if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb == 0 && com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc == 0) {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = 0;
            } else if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb >= com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc) {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = -1;
            } else {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = 1;
            }
            return com_google_android_gms_dynamite_DynamiteModule_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.5 */
    class C10055 implements zzb {
        C10055() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_dynamite_DynamiteModule_zzb_zza) {
            zzb com_google_android_gms_dynamite_DynamiteModule_zzb_zzb = new zzb();
            com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzH(context, str);
            com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzb(context, str, true);
            if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb == 0 && com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc == 0) {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = 0;
            } else if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc >= com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb) {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = 1;
            } else {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = -1;
            }
            return com_google_android_gms_dynamite_DynamiteModule_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.6 */
    class C10066 implements zzb {
        C10066() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_dynamite_DynamiteModule_zzb_zza) {
            zzb com_google_android_gms_dynamite_DynamiteModule_zzb_zzb = new zzb();
            com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzH(context, str);
            if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb != 0) {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzb(context, str, false);
            } else {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc = com_google_android_gms_dynamite_DynamiteModule_zzb_zza.zzb(context, str, true);
            }
            if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb == 0 && com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc == 0) {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = 0;
            } else if (com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSc >= com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSb) {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = 1;
            } else {
                com_google_android_gms_dynamite_DynamiteModule_zzb_zzb.zzaSd = -1;
            }
            return com_google_android_gms_dynamite_DynamiteModule_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.7 */
    class C10077 implements zza {
        final /* synthetic */ int zzaSa;

        C10077(int i) {
            this.zzaSa = i;
        }

        public int zzH(Context context, String str) {
            return this.zzaSa;
        }

        public int zzb(Context context, String str, boolean z) {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.8 */
    class C10088 extends PathClassLoader {
        C10088(String str, ClassLoader classLoader) {
            super(str, classLoader);
        }

        protected Class<?> loadClass(String str, boolean z) {
            if (!(str.startsWith("java.") || str.startsWith("android."))) {
                try {
                    return findClass(str);
                } catch (ClassNotFoundException e) {
                }
            }
            return super.loadClass(str, z);
        }
    }

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }
    }

    static {
        zzaRR = new HashMap();
        zzaRT = new C10011();
        zzaRU = new C10022();
        zzaRV = new C10033();
        zzaRW = new C10044();
        zzaRX = new C10055();
        zzaRY = new C10066();
    }

    private DynamiteModule(Context context) {
        this.zzaRZ = (Context) zzac.zzw(context);
    }

    private static ClassLoader zzBT() {
        return new C10088(zzaRS, ClassLoader.getSystemClassLoader());
    }

    public static int zzH(Context context, String str) {
        String valueOf;
        String valueOf2;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            valueOf = "DynamiteModule";
            valueOf2 = "Failed to load module descriptor class: ";
            String valueOf3 = String.valueOf(e2.getMessage());
            Log.e(valueOf, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
            return 0;
        }
    }

    public static int zzI(Context context, String str) {
        return zzb(context, str, false);
    }

    private static DynamiteModule zzJ(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static Context zza(Context context, String str, byte[] bArr, zzb com_google_android_gms_dynamite_zzb) {
        try {
            return (Context) zzd.zzF(com_google_android_gms_dynamite_zzb.zza(zzd.zzA(context), str, bArr));
        } catch (Exception e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
    }

    public static DynamiteModule zza(Context context, zzb com_google_android_gms_dynamite_DynamiteModule_zzb, String str) {
        zzb zza = com_google_android_gms_dynamite_DynamiteModule_zzb.zza(context, str, zzaRT);
        Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zza.zzaSb).append(" and remote module ").append(str).append(":").append(zza.zzaSc).toString());
        if (zza.zzaSd == 0 || ((zza.zzaSd == -1 && zza.zzaSb == 0) || (zza.zzaSd == 1 && zza.zzaSc == 0))) {
            throw new zza(null);
        } else if (zza.zzaSd == -1) {
            return zzJ(context, str);
        } else {
            if (zza.zzaSd == 1) {
                try {
                    return zza(context, str, zza.zzaSc);
                } catch (Throwable e) {
                    Throwable th = e;
                    String str2 = "DynamiteModule";
                    String str3 = "Failed to load remote module: ";
                    String valueOf = String.valueOf(th.getMessage());
                    Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    if (zza.zzaSb != 0 && com_google_android_gms_dynamite_DynamiteModule_zzb.zza(context, str, new C10077(zza.zzaSb)).zzaSd == -1) {
                        return zzJ(context, str);
                    }
                    throw new zza(th, null);
                }
            }
            throw new zza(null);
        }
    }

    private static DynamiteModule zza(Context context, String str, int i) {
        synchronized (DynamiteModule.class) {
            Boolean bool = zzaRO;
        }
        if (bool != null) {
            return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
        } else {
            throw new zza(null);
        }
    }

    private static void zza(ClassLoader classLoader) {
        Throwable e;
        try {
            zzaRQ = com.google.android.gms.dynamite.zzb.zza.zzcf((IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new zza(e, null);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new zza(e, null);
        } catch (InstantiationException e4) {
            e = e4;
            throw new zza(e, null);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new zza(e, null);
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new zza(e, null);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(android.content.Context r6, java.lang.String r7, boolean r8) {
        /*
        r1 = com.google.android.gms.dynamite.DynamiteModule.class;
        monitor-enter(r1);
        r0 = zzaRO;	 Catch:{ all -> 0x0074 }
        if (r0 != 0) goto L_0x0034;
    L_0x0007:
        r0 = r6.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x0098, IllegalAccessException -> 0x00f1, NoSuchFieldException -> 0x00ef }
        r0 = r0.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0098, IllegalAccessException -> 0x00f1, NoSuchFieldException -> 0x00ef }
        r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class;
        r2 = r2.getName();	 Catch:{ ClassNotFoundException -> 0x0098, IllegalAccessException -> 0x00f1, NoSuchFieldException -> 0x00ef }
        r2 = r0.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x0098, IllegalAccessException -> 0x00f1, NoSuchFieldException -> 0x00ef }
        r0 = "sClassLoader";
        r3 = r2.getDeclaredField(r0);	 Catch:{ ClassNotFoundException -> 0x0098, IllegalAccessException -> 0x00f1, NoSuchFieldException -> 0x00ef }
        monitor-enter(r2);	 Catch:{ ClassNotFoundException -> 0x0098, IllegalAccessException -> 0x00f1, NoSuchFieldException -> 0x00ef }
        r0 = 0;
        r0 = r3.get(r0);	 Catch:{ all -> 0x0095 }
        r0 = (java.lang.ClassLoader) r0;	 Catch:{ all -> 0x0095 }
        if (r0 == 0) goto L_0x0046;
    L_0x0029:
        r3 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0095 }
        if (r0 != r3) goto L_0x0040;
    L_0x002f:
        r0 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0095 }
    L_0x0031:
        monitor-exit(r2);	 Catch:{ all -> 0x0095 }
    L_0x0032:
        zzaRO = r0;	 Catch:{ all -> 0x0074 }
    L_0x0034:
        monitor-exit(r1);	 Catch:{ all -> 0x0074 }
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00e6;
    L_0x003b:
        r0 = zzd(r6, r7, r8);	 Catch:{ zza -> 0x00c3 }
    L_0x003f:
        return r0;
    L_0x0040:
        zza(r0);	 Catch:{ zza -> 0x00ec }
    L_0x0043:
        r0 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x0095 }
        goto L_0x0031;
    L_0x0046:
        r0 = "com.google.android.gms";
        r4 = r6.getApplicationContext();	 Catch:{ all -> 0x0095 }
        r4 = r4.getPackageName();	 Catch:{ all -> 0x0095 }
        r0 = r0.equals(r4);	 Catch:{ all -> 0x0095 }
        if (r0 == 0) goto L_0x0061;
    L_0x0056:
        r0 = 0;
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0095 }
        r3.set(r0, r4);	 Catch:{ all -> 0x0095 }
        r0 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0095 }
        goto L_0x0031;
    L_0x0061:
        r0 = zzd(r6, r7, r8);	 Catch:{ zza -> 0x0089 }
        r4 = zzaRS;	 Catch:{ zza -> 0x0089 }
        if (r4 == 0) goto L_0x0071;
    L_0x0069:
        r4 = zzaRS;	 Catch:{ zza -> 0x0089 }
        r4 = r4.isEmpty();	 Catch:{ zza -> 0x0089 }
        if (r4 == 0) goto L_0x0077;
    L_0x0071:
        monitor-exit(r2);	 Catch:{ all -> 0x0095 }
        monitor-exit(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x003f;
    L_0x0074:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0074 }
        throw r0;
    L_0x0077:
        r4 = zzBT();	 Catch:{ zza -> 0x0089 }
        zza(r4);	 Catch:{ zza -> 0x0089 }
        r5 = 0;
        r3.set(r5, r4);	 Catch:{ zza -> 0x0089 }
        r4 = java.lang.Boolean.TRUE;	 Catch:{ zza -> 0x0089 }
        zzaRO = r4;	 Catch:{ zza -> 0x0089 }
        monitor-exit(r2);	 Catch:{ all -> 0x0095 }
        monitor-exit(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x003f;
    L_0x0089:
        r0 = move-exception;
        r0 = 0;
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0095 }
        r3.set(r0, r4);	 Catch:{ all -> 0x0095 }
        r0 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0095 }
        goto L_0x0031;
    L_0x0095:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0095 }
        throw r0;	 Catch:{ ClassNotFoundException -> 0x0098, IllegalAccessException -> 0x00f1, NoSuchFieldException -> 0x00ef }
    L_0x0098:
        r0 = move-exception;
    L_0x0099:
        r2 = "DynamiteModule";
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0074 }
        r3 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0074 }
        r3 = r3.length();	 Catch:{ all -> 0x0074 }
        r3 = r3 + 30;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r4.<init>(r3);	 Catch:{ all -> 0x0074 }
        r3 = "Failed to load module via V2: ";
        r3 = r4.append(r3);	 Catch:{ all -> 0x0074 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x0074 }
        r0 = r0.toString();	 Catch:{ all -> 0x0074 }
        android.util.Log.w(r2, r0);	 Catch:{ all -> 0x0074 }
        r0 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0074 }
        goto L_0x0032;
    L_0x00c3:
        r0 = move-exception;
        r1 = "DynamiteModule";
        r2 = "Failed to retrieve remote module version: ";
        r0 = r0.getMessage();
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x00e0;
    L_0x00d6:
        r0 = r2.concat(r0);
    L_0x00da:
        android.util.Log.w(r1, r0);
        r0 = 0;
        goto L_0x003f;
    L_0x00e0:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x00da;
    L_0x00e6:
        r0 = zzc(r6, r7, r8);
        goto L_0x003f;
    L_0x00ec:
        r0 = move-exception;
        goto L_0x0043;
    L_0x00ef:
        r0 = move-exception;
        goto L_0x0099;
    L_0x00f1:
        r0 = move-exception;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zzb(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zza zzbm = zzbm(context);
        if (zzbm == null) {
            throw new zza(null);
        }
        try {
            IObjectWrapper zza = zzbm.zza(zzd.zzA(context), str, i);
            if (zzd.zzF(zza) != null) {
                return new DynamiteModule((Context) zzd.zzF(zza));
            }
            throw new zza(null);
        } catch (Throwable e) {
            throw new zza(e, null);
        }
    }

    private static zza zzbm(Context context) {
        synchronized (DynamiteModule.class) {
            zza com_google_android_gms_dynamite_zza;
            if (zzaRP != null) {
                com_google_android_gms_dynamite_zza = zzaRP;
                return com_google_android_gms_dynamite_zza;
            } else if (zze.zzuY().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    com_google_android_gms_dynamite_zza = com.google.android.gms.dynamite.zza.zza.zzce((IBinder) context.createPackageContext(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (com_google_android_gms_dynamite_zza != null) {
                        zzaRP = com_google_android_gms_dynamite_zza;
                        return com_google_android_gms_dynamite_zza;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                return null;
            }
        }
    }

    private static int zzc(Context context, String str, boolean z) {
        zza zzbm = zzbm(context);
        if (zzbm == null) {
            return 0;
        }
        try {
            return zzbm.zza(zzd.zzA(context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    private static DynamiteModule zzc(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        synchronized (DynamiteModule.class) {
            byte[] bArr = (byte[]) zzaRR.get(new StringBuilder(String.valueOf(str).length() + 12).append(str).append(":").append(i).toString());
            zzb com_google_android_gms_dynamite_zzb = zzaRQ;
        }
        if (bArr == null) {
            throw new zza(null);
        } else if (com_google_android_gms_dynamite_zzb == null) {
            throw new zza(null);
        } else {
            Context zza = zza(context.getApplicationContext(), str, bArr, com_google_android_gms_dynamite_zzb);
            if (zza != null) {
                return new DynamiteModule(zza);
            }
            throw new zza(null);
        }
    }

    private static int zzd(Context context, String str, boolean z) {
        Cursor cursor = null;
        try {
            cursor = zze(context, str, z);
            if (cursor == null || !cursor.moveToFirst()) {
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new zza(null);
            }
            int i = cursor.getInt(0);
            if (i > 0) {
                synchronized (DynamiteModule.class) {
                    zzaRR.put(new StringBuilder(String.valueOf(str).length() + 12).append(str).append(":").append(i).toString(), Base64.decode(cursor.getString(3), 0));
                    zzaRS = cursor.getString(2);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return i;
        } catch (Throwable e) {
            if (e instanceof zza) {
                throw e;
            }
            throw new zza(e, null);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static Cursor zze(Context context, String str, boolean z) {
        String str2 = z ? "api_force_staging" : "api";
        String valueOf = String.valueOf("content://com.google.android.gms.chimera/");
        return context.getContentResolver().query(Uri.parse(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str2).length()) + String.valueOf(str).length()).append(valueOf).append(str2).append("/").append(str).toString()), null, null, null, null);
    }

    public Context zzBS() {
        return this.zzaRZ;
    }

    public IBinder zzdT(String str) {
        Throwable e;
        String str2;
        String valueOf;
        try {
            return (IBinder) this.zzaRZ.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            throw new zza(e, null);
        } catch (InstantiationException e3) {
            e = e3;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new zza(e, null);
        } catch (IllegalAccessException e4) {
            e = e4;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new zza(e, null);
        }
    }
}
