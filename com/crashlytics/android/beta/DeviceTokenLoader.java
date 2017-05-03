package com.crashlytics.android.beta;

import android.content.Context;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import p000a.p001a.p002a.p003a.p004a.p005a.ValueLoader;

public class DeviceTokenLoader implements ValueLoader<String> {
    private static final String BETA_APP_PACKAGE_NAME = "io.crash.air";
    private static final String DIRFACTOR_DEVICE_TOKEN_PREFIX = "assets/com.crashlytics.android.beta/dirfactor-device-token=";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String load(android.content.Context r10) {
        /*
        r9 = this;
        r4 = java.lang.System.nanoTime();
        r0 = "";
        r1 = 0;
        r2 = "io.crash.air";
        r1 = r9.getZipInputStreamOfApkFrom(r10, r2);	 Catch:{ NameNotFoundException -> 0x0052, FileNotFoundException -> 0x0071, IOException -> 0x0093, all -> 0x00b7 }
        r0 = r9.determineDeviceToken(r1);	 Catch:{ NameNotFoundException -> 0x0052, FileNotFoundException -> 0x00d6, IOException -> 0x00d1 }
        if (r1 == 0) goto L_0x0016;
    L_0x0013:
        r1.close();	 Catch:{ IOException -> 0x0045 }
    L_0x0016:
        r2 = java.lang.System.nanoTime();
        r2 = r2 - r4;
        r2 = (double) r2;
        r4 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r2 = r2 / r4;
        r1 = p000a.p001a.p002a.p003a.Fabric.m397h();
        r4 = "Beta";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Beta device token load took ";
        r5 = r5.append(r6);
        r2 = r5.append(r2);
        r3 = "ms";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.m359a(r4, r2);
        return r0;
    L_0x0045:
        r1 = move-exception;
        r2 = p000a.p001a.p002a.p003a.Fabric.m397h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.m367e(r3, r6, r1);
        goto L_0x0016;
    L_0x0052:
        r2 = move-exception;
        r2 = p000a.p001a.p002a.p003a.Fabric.m397h();	 Catch:{ all -> 0x00cc }
        r3 = "Beta";
        r6 = "Beta by Crashlytics app is not installed";
        r2.m359a(r3, r6);	 Catch:{ all -> 0x00cc }
        if (r1 == 0) goto L_0x0016;
    L_0x0060:
        r1.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0016;
    L_0x0064:
        r1 = move-exception;
        r2 = p000a.p001a.p002a.p003a.Fabric.m397h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.m367e(r3, r6, r1);
        goto L_0x0016;
    L_0x0071:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x0075:
        r3 = p000a.p001a.p002a.p003a.Fabric.m397h();	 Catch:{ all -> 0x00cf }
        r6 = "Beta";
        r7 = "Failed to find the APK file";
        r3.m367e(r6, r7, r1);	 Catch:{ all -> 0x00cf }
        if (r2 == 0) goto L_0x0016;
    L_0x0082:
        r2.close();	 Catch:{ IOException -> 0x0086 }
        goto L_0x0016;
    L_0x0086:
        r1 = move-exception;
        r2 = p000a.p001a.p002a.p003a.Fabric.m397h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.m367e(r3, r6, r1);
        goto L_0x0016;
    L_0x0093:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x0097:
        r3 = p000a.p001a.p002a.p003a.Fabric.m397h();	 Catch:{ all -> 0x00cf }
        r6 = "Beta";
        r7 = "Failed to read the APK file";
        r3.m367e(r6, r7, r1);	 Catch:{ all -> 0x00cf }
        if (r2 == 0) goto L_0x0016;
    L_0x00a4:
        r2.close();	 Catch:{ IOException -> 0x00a9 }
        goto L_0x0016;
    L_0x00a9:
        r1 = move-exception;
        r2 = p000a.p001a.p002a.p003a.Fabric.m397h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.m367e(r3, r6, r1);
        goto L_0x0016;
    L_0x00b7:
        r0 = move-exception;
        r2 = r1;
    L_0x00b9:
        if (r2 == 0) goto L_0x00be;
    L_0x00bb:
        r2.close();	 Catch:{ IOException -> 0x00bf }
    L_0x00be:
        throw r0;
    L_0x00bf:
        r1 = move-exception;
        r2 = p000a.p001a.p002a.p003a.Fabric.m397h();
        r3 = "Beta";
        r4 = "Failed to close the APK file";
        r2.m367e(r3, r4, r1);
        goto L_0x00be;
    L_0x00cc:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00b9;
    L_0x00cf:
        r0 = move-exception;
        goto L_0x00b9;
    L_0x00d1:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0097;
    L_0x00d6:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.DeviceTokenLoader.load(android.content.Context):java.lang.String");
    }

    ZipInputStream getZipInputStreamOfApkFrom(Context context, String str) {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    String determineDeviceToken(ZipInputStream zipInputStream) {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.startsWith(DIRFACTOR_DEVICE_TOKEN_PREFIX)) {
                return name.substring(DIRFACTOR_DEVICE_TOKEN_PREFIX.length(), name.length() - 1);
            }
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }
}
