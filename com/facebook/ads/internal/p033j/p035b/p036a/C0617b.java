package com.facebook.ads.internal.p033j.p035b.p036a;

import com.facebook.ads.internal.p033j.p035b.C0616a;
import com.facebook.ads.internal.p033j.p035b.C0642l;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.facebook.ads.internal.j.b.a.b */
public class C0617b implements C0616a {
    public File f1423a;
    private final C0615a f1424b;
    private RandomAccessFile f1425c;

    public C0617b(File file, C0615a c0615a) {
        if (c0615a == null) {
            try {
                throw new NullPointerException();
            } catch (Throwable e) {
                throw new C0642l("Error using file " + file + " as disc cache", e);
            }
        }
        this.f1424b = c0615a;
        C0621d.m1951a(file.getParentFile());
        boolean exists = file.exists();
        this.f1423a = exists ? file : new File(file.getParentFile(), file.getName() + ".download");
        this.f1425c = new RandomAccessFile(this.f1423a, exists ? "r" : "rw");
    }

    private boolean m1941a(File file) {
        return file.getName().endsWith(".download");
    }

    public synchronized int m1942a() {
        try {
        } catch (Throwable e) {
            throw new C0642l("Error reading length of file " + this.f1423a, e);
        }
        return (int) this.f1425c.length();
    }

    public synchronized int m1943a(byte[] bArr, long j, int i) {
        try {
            this.f1425c.seek(j);
        } catch (Throwable e) {
            throw new C0642l(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(m1942a()), Integer.valueOf(bArr.length)}), e);
        }
        return this.f1425c.read(bArr, 0, i);
    }

    public synchronized void m1944a(byte[] bArr, int i) {
        try {
            if (m1947d()) {
                throw new C0642l("Error append cache: cache file " + this.f1423a + " is completed!");
            }
            this.f1425c.seek((long) m1942a());
            this.f1425c.write(bArr, 0, i);
        } catch (Throwable e) {
            throw new C0642l(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.f1425c, Integer.valueOf(bArr.length)}), e);
        }
    }

    public synchronized void m1945b() {
        try {
            this.f1425c.close();
            this.f1424b.m1934a(this.f1423a);
        } catch (Throwable e) {
            throw new C0642l("Error closing file " + this.f1423a, e);
        }
    }

    public synchronized void m1946c() {
        if (!m1947d()) {
            m1945b();
            File file = new File(this.f1423a.getParentFile(), this.f1423a.getName().substring(0, this.f1423a.getName().length() - ".download".length()));
            if (this.f1423a.renameTo(file)) {
                this.f1423a = file;
                try {
                    this.f1425c = new RandomAccessFile(this.f1423a, "r");
                } catch (Throwable e) {
                    throw new C0642l("Error opening " + this.f1423a + " as disc cache", e);
                }
            }
            throw new C0642l("Error renaming file " + this.f1423a + " to " + file + " for completion!");
        }
    }

    public synchronized boolean m1947d() {
        return !m1941a(this.f1423a);
    }
}
