package com.facebook.ads.internal.p021m;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.os.StatFs;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.facebook.ads.internal.m.b */
public class C0675b {
    private static SensorManager f1618a;
    private static Sensor f1619b;
    private static Sensor f1620c;
    private static volatile float[] f1621d;
    private static volatile float[] f1622e;
    private static Map<String, String> f1623f;
    private static String[] f1624g;

    /* renamed from: com.facebook.ads.internal.m.b.a */
    private static class C0674a implements SensorEventListener {
        private C0674a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor == C0675b.f1619b) {
                C0675b.f1621d = sensorEvent.values;
            } else if (sensorEvent.sensor == C0675b.f1620c) {
                C0675b.f1622e = sensorEvent.values;
            }
            C0675b.m2181a(this);
        }
    }

    static {
        f1618a = null;
        f1619b = null;
        f1620c = null;
        f1623f = new ConcurrentHashMap();
        f1624g = new String[]{"x", "y", "z"};
    }

    public static Map<String, String> m2179a() {
        Map hashMap = new HashMap();
        hashMap.putAll(f1623f);
        C0675b.m2182a(hashMap);
        return hashMap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m2180a(android.content.Context r5) {
        /*
        r1 = com.facebook.ads.internal.p021m.C0675b.class;
        monitor-enter(r1);
        com.facebook.ads.internal.p021m.C0675b.m2185b(r5);	 Catch:{ all -> 0x005f }
        com.facebook.ads.internal.p021m.C0675b.m2188c(r5);	 Catch:{ all -> 0x005f }
        com.facebook.ads.internal.p021m.C0675b.m2189d(r5);	 Catch:{ all -> 0x005f }
        r0 = f1618a;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x0020;
    L_0x0010:
        r0 = "sensor";
        r0 = r5.getSystemService(r0);	 Catch:{ all -> 0x005f }
        r0 = (android.hardware.SensorManager) r0;	 Catch:{ all -> 0x005f }
        f1618a = r0;	 Catch:{ all -> 0x005f }
        r0 = f1618a;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r1);
        return;
    L_0x0020:
        r0 = f1619b;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x002d;
    L_0x0024:
        r0 = f1618a;	 Catch:{ all -> 0x005f }
        r2 = 1;
        r0 = r0.getDefaultSensor(r2);	 Catch:{ all -> 0x005f }
        f1619b = r0;	 Catch:{ all -> 0x005f }
    L_0x002d:
        r0 = f1620c;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x003a;
    L_0x0031:
        r0 = f1618a;	 Catch:{ all -> 0x005f }
        r2 = 4;
        r0 = r0.getDefaultSensor(r2);	 Catch:{ all -> 0x005f }
        f1620c = r0;	 Catch:{ all -> 0x005f }
    L_0x003a:
        r0 = f1619b;	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x004c;
    L_0x003e:
        r0 = f1618a;	 Catch:{ all -> 0x005f }
        r2 = new com.facebook.ads.internal.m.b$a;	 Catch:{ all -> 0x005f }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x005f }
        r3 = f1619b;	 Catch:{ all -> 0x005f }
        r4 = 3;
        r0.registerListener(r2, r3, r4);	 Catch:{ all -> 0x005f }
    L_0x004c:
        r0 = f1620c;	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x001e;
    L_0x0050:
        r0 = f1618a;	 Catch:{ all -> 0x005f }
        r2 = new com.facebook.ads.internal.m.b$a;	 Catch:{ all -> 0x005f }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x005f }
        r3 = f1620c;	 Catch:{ all -> 0x005f }
        r4 = 3;
        r0.registerListener(r2, r3, r4);	 Catch:{ all -> 0x005f }
        goto L_0x001e;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.b.a(android.content.Context):void");
    }

    public static synchronized void m2181a(C0674a c0674a) {
        synchronized (C0675b.class) {
            if (f1618a != null) {
                f1618a.unregisterListener(c0674a);
            }
        }
    }

    private static void m2182a(Map<String, String> map) {
        int i;
        int i2 = 0;
        float[] fArr = f1621d;
        float[] fArr2 = f1622e;
        if (fArr != null) {
            int min = Math.min(f1624g.length, fArr.length);
            for (i = 0; i < min; i++) {
                map.put("accelerometer_" + f1624g[i], String.valueOf(fArr[i]));
            }
        }
        if (fArr2 != null) {
            i = Math.min(f1624g.length, fArr2.length);
            while (i2 < i) {
                map.put("rotation_" + f1624g[i2], String.valueOf(fArr2[i2]));
                i2++;
            }
        }
    }

    private static void m2185b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        f1623f.put("available_memory", String.valueOf(memoryInfo.availMem));
    }

    private static void m2188c(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = (long) statFs.getAvailableBlocks();
        f1623f.put("free_space", String.valueOf(availableBlocks * ((long) statFs.getBlockSize())));
    }

    private static void m2189d(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(Param.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra(NotificationCompatApi24.CATEGORY_STATUS, -1);
            Object obj = (intExtra3 == 2 || intExtra3 == 5) ? 1 : null;
            float f = 0.0f;
            if (intExtra2 > 0) {
                f = (((float) intExtra) / ((float) intExtra2)) * 100.0f;
            }
            f1623f.put("battery", String.valueOf(f));
            f1623f.put("charging", obj != null ? "1" : "0");
        }
    }
}
