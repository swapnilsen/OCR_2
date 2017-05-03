package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: a.a.a.a.a.d.g */
public class GZIPQueueFileEventStorage extends QueueFileEventStorage {
    public GZIPQueueFileEventStorage(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    public OutputStream m210a(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
