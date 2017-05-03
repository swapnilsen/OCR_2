package p000a.p001a.p002a.p003a.p004a.p012g;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p011f.FileStoreImpl;

/* renamed from: a.a.a.a.a.g.i */
class DefaultCachedSettingsIo implements CachedSettingsIo {
    private final Kit f231a;

    public DefaultCachedSettingsIo(Kit kit) {
        this.f231a = kit;
    }

    public JSONObject m315a() {
        Closeable fileInputStream;
        Throwable e;
        Closeable closeable = null;
        Fabric.m397h().m359a("Fabric", "Reading cached settings...");
        try {
            JSONObject jSONObject;
            File file = new File(new FileStoreImpl(this.f231a).m299a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(CommonUtils.m46a((InputStream) fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Fabric.m397h().m367e("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.m57a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        CommonUtils.m57a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            Fabric.m397h().m359a("Fabric", "No cached settings found.");
            jSONObject = null;
            CommonUtils.m57a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            Fabric.m397h().m367e("Fabric", "Failed to fetch cached settings", e);
            CommonUtils.m57a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.m57a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    public void m316a(long j, JSONObject jSONObject) {
        Closeable fileWriter;
        Throwable e;
        Fabric.m397h().m359a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            try {
                jSONObject.put("expires_at", j);
                fileWriter = new FileWriter(new File(new FileStoreImpl(this.f231a).m299a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    CommonUtils.m57a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Fabric.m397h().m367e("Fabric", "Failed to cache settings", e);
                        CommonUtils.m57a(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileWriter;
                        CommonUtils.m57a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
                Fabric.m397h().m367e("Fabric", "Failed to cache settings", e);
                CommonUtils.m57a(fileWriter, "Failed to close settings writer.");
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.m57a(closeable, "Failed to close settings writer.");
                throw e;
            }
        }
    }
}
