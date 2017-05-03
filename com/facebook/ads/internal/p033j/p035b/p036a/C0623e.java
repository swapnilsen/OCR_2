package com.facebook.ads.internal.p033j.p035b.p036a;

import android.util.Log;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.facebook.ads.internal.j.b.a.e */
abstract class C0623e implements C0615a {
    private final ExecutorService f1428a;

    /* renamed from: com.facebook.ads.internal.j.b.a.e.a */
    private class C0622a implements Callable<Void> {
        final /* synthetic */ C0623e f1426a;
        private final File f1427b;

        public C0622a(C0623e c0623e, File file) {
            this.f1426a = c0623e;
            this.f1427b = file;
        }

        public Void m1956a() {
            this.f1426a.m1960b(this.f1427b);
            return null;
        }

        public /* synthetic */ Object call() {
            return m1956a();
        }
    }

    C0623e() {
        this.f1428a = Executors.newSingleThreadExecutor();
    }

    private void m1958a(List<File> list) {
        long b = m1959b((List) list);
        int size = list.size();
        int i = size;
        for (File file : list) {
            if (!m1962a(file, b, i)) {
                long length = file.length();
                if (file.delete()) {
                    i--;
                    b -= length;
                    Log.i("ProxyCache", "Cache file " + file + " is deleted because it exceeds cache limit");
                    size = i;
                    i = size;
                } else {
                    Log.e("ProxyCache", "Error deleting file " + file + " for trimming cache");
                }
            }
            size = i;
            i = size;
        }
    }

    private long m1959b(List<File> list) {
        long j = 0;
        for (File length : list) {
            j = length.length() + j;
        }
        return j;
    }

    private void m1960b(File file) {
        C0621d.m1953c(file);
        m1958a(C0621d.m1952b(file.getParentFile()));
    }

    public void m1961a(File file) {
        this.f1428a.submit(new C0622a(this, file));
    }

    protected abstract boolean m1962a(File file, long j, int i);
}
