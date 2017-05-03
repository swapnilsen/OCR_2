package p000a.p001a.p002a.p003a.p004a.p011f;

import android.content.Context;
import java.io.File;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;

/* renamed from: a.a.a.a.a.f.b */
public class FileStoreImpl implements FileStore {
    private final Context f194a;
    private final String f195b;
    private final String f196c;

    public FileStoreImpl(Kit kit) {
        if (kit.getContext() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f194a = kit.getContext();
        this.f195b = kit.getPath();
        this.f196c = "Android/" + this.f194a.getPackageName();
    }

    public File m299a() {
        return m300a(this.f194a.getFilesDir());
    }

    File m300a(File file) {
        if (file == null) {
            Fabric.m397h().m359a("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            Fabric.m397h().m364d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
