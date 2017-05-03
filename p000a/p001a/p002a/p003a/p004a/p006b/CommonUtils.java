package p000a.p001a.p002a.p003a.p004a.p006b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.Fabric;

/* renamed from: a.a.a.a.a.b.i */
public class CommonUtils {
    public static final Comparator<File> f29a;
    private static Boolean f30b;
    private static final char[] f31c;
    private static long f32d;

    /* renamed from: a.a.a.a.a.b.i.1 */
    static class CommonUtils implements Comparator<File> {
        CommonUtils() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m36a((File) obj, (File) obj2);
        }

        public int m36a(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* renamed from: a.a.a.a.a.b.i.a */
    enum CommonUtils {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, CommonUtils> f27k;

        static {
            f27k = new HashMap(4);
            f27k.put("armeabi-v7a", ARMV7);
            f27k.put("armeabi", ARMV6);
            f27k.put("arm64-v8a", ARM64);
            f27k.put("x86", X86_32);
        }

        static CommonUtils m37a() {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(obj)) {
                Fabric.m397h().m359a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            CommonUtils commonUtils = (CommonUtils) f27k.get(obj.toLowerCase(Locale.US));
            if (commonUtils == null) {
                return UNKNOWN;
            }
            return commonUtils;
        }
    }

    static {
        f30b = null;
        f31c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f32d = -1;
        f29a = new CommonUtils();
    }

    public static SharedPreferences m43a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String m45a(File file, String str) {
        Closeable bufferedReader;
        Throwable e;
        Throwable th;
        String str2 = null;
        if (file.exists()) {
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                str2 = split[1];
                CommonUtils.m57a(bufferedReader, "Failed to close system file reader.");
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                try {
                    Fabric.m397h().m367e("Fabric", "Error parsing " + file, e);
                    CommonUtils.m57a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.m57a(bufferedReader, "Failed to close system file reader.");
                    throw th;
                }
            } catch (Throwable e4) {
                bufferedReader = null;
                th = e4;
                CommonUtils.m57a(bufferedReader, "Failed to close system file reader.");
                throw th;
            }
        }
        return str2;
    }

    public static int m38a() {
        return CommonUtils.m37a().ordinal();
    }

    public static synchronized long m61b() {
        long j;
        synchronized (CommonUtils.class) {
            if (f32d == -1) {
                j = 0;
                Object a = CommonUtils.m45a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a)) {
                    String toUpperCase = a.toUpperCase(Locale.US);
                    try {
                        if (toUpperCase.endsWith("KB")) {
                            j = CommonUtils.m41a(toUpperCase, "KB", (int) AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
                        } else if (toUpperCase.endsWith("MB")) {
                            j = CommonUtils.m41a(toUpperCase, "MB", (int) AccessibilityNodeInfoCompat.ACTION_DISMISS);
                        } else if (toUpperCase.endsWith("GB")) {
                            j = CommonUtils.m41a(toUpperCase, "GB", 1073741824);
                        } else {
                            Fabric.m397h().m359a("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase);
                        }
                    } catch (Throwable e) {
                        Fabric.m397h().m367e("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase, e);
                    }
                }
                f32d = j;
            }
            j = f32d;
        }
        return j;
    }

    static long m41a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo m42a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String m46a(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public static String m48a(String str) {
        return CommonUtils.m49a(str, "SHA-1");
    }

    public static String m66b(InputStream inputStream) {
        return CommonUtils.m47a(inputStream, "SHA-1");
    }

    private static String m47a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return CommonUtils.m50a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            Fabric.m397h().m367e("Fabric", "Could not calculate hash for app icon.", e);
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
    }

    private static String m51a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return CommonUtils.m50a(instance.digest());
        } catch (Throwable e) {
            Fabric.m397h().m367e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
    }

    private static String m49a(String str, String str2) {
        return CommonUtils.m51a(str.getBytes(), str2);
    }

    public static String m52a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING).toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : arrayList) {
            stringBuilder.append(append);
        }
        String append2 = stringBuilder.toString();
        return append2.length() > 0 ? CommonUtils.m48a(append2) : null;
    }

    public static long m62b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long m63b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    public static Float m67c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(((float) registerReceiver.getIntExtra(Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
    }

    public static boolean m71d(Context context) {
        if (CommonUtils.m73f(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static void m54a(Context context, String str) {
        if (CommonUtils.m72e(context)) {
            Fabric.m397h().m359a("Fabric", str);
        }
    }

    public static void m55a(Context context, String str, Throwable th) {
        if (CommonUtils.m72e(context)) {
            Fabric.m397h().m366e("Fabric", str);
        }
    }

    public static void m53a(Context context, int i, String str, String str2) {
        if (CommonUtils.m72e(context)) {
            Fabric.m397h().m357a(i, "Fabric", str2);
        }
    }

    public static boolean m72e(Context context) {
        if (f30b == null) {
            f30b = Boolean.valueOf(CommonUtils.m60a(context, "com.crashlytics.Trace", false));
        }
        return f30b.booleanValue();
    }

    public static boolean m60a(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return z;
        }
        int a = CommonUtils.m39a(context, str, "bool");
        if (a > 0) {
            return resources.getBoolean(a);
        }
        int a2 = CommonUtils.m39a(context, str, "string");
        if (a2 > 0) {
            return Boolean.parseBoolean(context.getString(a2));
        }
        return z;
    }

    public static int m39a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, CommonUtils.m77j(context));
    }

    public static boolean m73f(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean m74g(Context context) {
        boolean f = CommonUtils.m73f(context);
        String str = Build.TAGS;
        if ((!f && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (f || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean m68c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int m75h(Context context) {
        int i = 0;
        if (CommonUtils.m73f(context)) {
            i = 1;
        }
        if (CommonUtils.m74g(context)) {
            i |= 2;
        }
        if (CommonUtils.m68c()) {
            return i | 4;
        }
        return i;
    }

    public static int m40a(Context context, boolean z) {
        Float c = CommonUtils.m67c(context);
        if (!z || c == null) {
            return 1;
        }
        if (((double) c.floatValue()) >= 99.0d) {
            return 3;
        }
        if (((double) c.floatValue()) < 99.0d) {
            return 2;
        }
        return 0;
    }

    public static String m50a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
            cArr[i * 2] = f31c[i2 >>> 4];
            cArr[(i * 2) + 1] = f31c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean m76i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String m65b(Context context, String str) {
        int a = CommonUtils.m39a(context, str, "string");
        if (a > 0) {
            return context.getString(a);
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public static void m57a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                Fabric.m397h().m367e("Fabric", str, e);
            }
        }
    }

    public static void m58a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable e) {
                Fabric.m397h().m367e("Fabric", str, e);
            }
        }
    }

    public static boolean m70c(String str) {
        return str == null || str.length() == 0;
    }

    public static String m44a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i)}).replace(' ', '0');
    }

    public static String m77j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static void m59a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String m64b(int i) {
        switch (i) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return "V";
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return "D";
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return "I";
            case Type.OTHER_PROFILE /*5*/:
                return "W";
            case Type.CONTRIBUTOR /*6*/:
                return "E";
            case Type.WEBSITE /*7*/:
                return "A";
            default:
                return "?";
        }
    }

    public static String m78k(Context context) {
        Closeable openRawResource;
        Throwable e;
        Throwable th;
        String str = null;
        try {
            openRawResource = context.getResources().openRawResource(CommonUtils.m79l(context));
            try {
                String b = CommonUtils.m66b((InputStream) openRawResource);
                if (!CommonUtils.m70c(b)) {
                    str = b;
                }
                CommonUtils.m57a(openRawResource, "Failed to close icon input stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    Fabric.m397h().m367e("Fabric", "Could not calculate hash for app icon.", e);
                    CommonUtils.m57a(openRawResource, "Failed to close icon input stream.");
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.m57a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            Fabric.m397h().m367e("Fabric", "Could not calculate hash for app icon.", e);
            CommonUtils.m57a(openRawResource, "Failed to close icon input stream.");
            return str;
        } catch (Throwable e4) {
            openRawResource = null;
            th = e4;
            CommonUtils.m57a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
        return str;
    }

    public static int m79l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m80m(Context context) {
        int a = CommonUtils.m39a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = CommonUtils.m39a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        Fabric.m397h().m359a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void m56a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean m69c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean m81n(Context context) {
        if (!CommonUtils.m69c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
