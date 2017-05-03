package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.QueueFile;

/* renamed from: a.a.a.a.a.d.h */
public class QueueFileEventStorage implements EventsStorage {
    private final Context f149a;
    private final File f150b;
    private final String f151c;
    private final File f152d;
    private QueueFile f153e;
    private File f154f;

    public QueueFileEventStorage(Context context, File file, String str, String str2) {
        this.f149a = context;
        this.f150b = file;
        this.f151c = str2;
        this.f152d = new File(this.f150b, str);
        this.f153e = new QueueFile(this.f152d);
        m199e();
    }

    private void m199e() {
        this.f154f = new File(this.f150b, this.f151c);
        if (!this.f154f.exists()) {
            this.f154f.mkdirs();
        }
    }

    public void m205a(byte[] bArr) {
        this.f153e.m133a(bArr);
    }

    public int m200a() {
        return this.f153e.m131a();
    }

    public void m203a(String str) {
        this.f153e.close();
        m198a(this.f152d, new File(this.f154f, str));
        this.f153e = new QueueFile(this.f152d);
    }

    private void m198a(File file, File file2) {
        Closeable fileInputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                closeable = m201a(file2);
                CommonUtils.m59a((InputStream) fileInputStream, (OutputStream) closeable, new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT]);
                CommonUtils.m57a(fileInputStream, "Failed to close file input stream");
                CommonUtils.m57a(closeable, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m57a(fileInputStream, "Failed to close file input stream");
                CommonUtils.m57a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            CommonUtils.m57a(fileInputStream, "Failed to close file input stream");
            CommonUtils.m57a(closeable, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream m201a(File file) {
        return new FileOutputStream(file);
    }

    public List<File> m202a(int i) {
        List<File> arrayList = new ArrayList();
        for (Object add : this.f154f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void m204a(List<File> list) {
        for (File file : list) {
            CommonUtils.m54a(this.f149a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public List<File> m208c() {
        return Arrays.asList(this.f154f.listFiles());
    }

    public void m209d() {
        try {
            this.f153e.close();
        } catch (IOException e) {
        }
        this.f152d.delete();
    }

    public boolean m207b() {
        return this.f153e.m136b();
    }

    public boolean m206a(int i, int i2) {
        return this.f153e.m135a(i, i2);
    }
}
