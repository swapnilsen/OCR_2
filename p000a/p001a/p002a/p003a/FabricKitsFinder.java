package p000a.p001a.p002a.p003a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;

/* renamed from: a.a.a.a.e */
class FabricKitsFinder implements Callable<Map<String, KitInfo>> {
    final String f324a;

    public /* synthetic */ Object call() {
        return m412a();
    }

    FabricKitsFinder(String str) {
        this.f324a = str;
    }

    public Map<String, KitInfo> m412a() {
        Map<String, KitInfo> hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ZipFile b = m413b();
        Enumeration entries = b.entries();
        int i = 0;
        while (entries.hasMoreElements()) {
            int i2 = i + 1;
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > "fabric/".length()) {
                KitInfo a = m411a(zipEntry, b);
                if (a != null) {
                    hashMap.put(a.m422a(), a);
                    Fabric.m397h().m362b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.m422a(), a.m423b()}));
                }
            }
            i = i2;
        }
        if (b != null) {
            try {
                b.close();
            } catch (IOException e) {
            }
        }
        Fabric.m397h().m362b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " reading:" + i);
        return hashMap;
    }

    private KitInfo m411a(ZipEntry zipEntry, ZipFile zipFile) {
        Throwable e;
        Closeable inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                KitInfo kitInfo = new KitInfo(property, property2, property3);
                CommonUtils.m56a(inputStream);
                return kitInfo;
            } catch (IOException e2) {
                e = e2;
                try {
                    Fabric.m397h().m367e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    CommonUtils.m56a(inputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m56a(inputStream);
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            Fabric.m397h().m367e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
            CommonUtils.m56a(inputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            inputStream = null;
            CommonUtils.m56a(inputStream);
            throw e;
        }
    }

    protected ZipFile m413b() {
        return new ZipFile(this.f324a);
    }
}
