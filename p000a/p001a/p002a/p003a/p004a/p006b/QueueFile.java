package p000a.p001a.p002a.p003a.p004a.p006b;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.MotionEventCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: a.a.a.a.a.b.q */
public class QueueFile implements Closeable {
    private static final Logger f83b;
    int f84a;
    private final RandomAccessFile f85c;
    private int f86d;
    private QueueFile f87e;
    private QueueFile f88f;
    private final byte[] f89g;

    /* renamed from: a.a.a.a.a.b.q.c */
    public interface QueueFile {
        void read(InputStream inputStream, int i);
    }

    /* renamed from: a.a.a.a.a.b.q.1 */
    class QueueFile implements QueueFile {
        boolean f74a;
        final /* synthetic */ StringBuilder f75b;
        final /* synthetic */ QueueFile f76c;

        QueueFile(QueueFile queueFile, StringBuilder stringBuilder) {
            this.f76c = queueFile;
            this.f75b = stringBuilder;
            this.f74a = true;
        }

        public void read(InputStream inputStream, int i) {
            if (this.f74a) {
                this.f74a = false;
            } else {
                this.f75b.append(", ");
            }
            this.f75b.append(i);
        }
    }

    /* renamed from: a.a.a.a.a.b.q.a */
    static class QueueFile {
        static final QueueFile f77a;
        final int f78b;
        final int f79c;

        static {
            f77a = new QueueFile(0, 0);
        }

        QueueFile(int i, int i2) {
            this.f78b = i;
            this.f79c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[" + "position = " + this.f78b + ", length = " + this.f79c + "]";
        }
    }

    /* renamed from: a.a.a.a.a.b.q.b */
    private final class QueueFile extends InputStream {
        final /* synthetic */ QueueFile f80a;
        private int f81b;
        private int f82c;

        private QueueFile(QueueFile queueFile, QueueFile queueFile2) {
            this.f80a = queueFile;
            this.f81b = queueFile.m122b(queueFile2.f78b + 4);
            this.f82c = queueFile2.f79c;
        }

        public int read(byte[] bArr, int i, int i2) {
            QueueFile.m124b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.f82c <= 0) {
                return -1;
            } else {
                if (i2 > this.f82c) {
                    i2 = this.f82c;
                }
                this.f80a.m125b(this.f81b, bArr, i, i2);
                this.f81b = this.f80a.m122b(this.f81b + i2);
                this.f82c -= i2;
                return i2;
            }
        }

        public int read() {
            if (this.f82c == 0) {
                return -1;
            }
            this.f80a.f85c.seek((long) this.f81b);
            int read = this.f80a.f85c.read();
            this.f81b = this.f80a.m122b(this.f81b + 1);
            this.f82c--;
            return read;
        }
    }

    static {
        f83b = Logger.getLogger(QueueFile.class.getName());
    }

    public QueueFile(File file) {
        this.f89g = new byte[16];
        if (!file.exists()) {
            QueueFile.m120a(file);
        }
        this.f85c = QueueFile.m123b(file);
        m129e();
    }

    private static void m126b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void m121a(byte[] bArr, int... iArr) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            QueueFile.m126b(bArr, i2, iArr[i]);
            i2 += 4;
            i++;
        }
    }

    private static int m113a(byte[] bArr, int i) {
        return ((((bArr[i] & MotionEventCompat.ACTION_MASK) << 24) + ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) << 16)) + ((bArr[i + 2] & MotionEventCompat.ACTION_MASK) << 8)) + (bArr[i + 3] & MotionEventCompat.ACTION_MASK);
    }

    private void m129e() {
        this.f85c.seek(0);
        this.f85c.readFully(this.f89g);
        this.f84a = QueueFile.m113a(this.f89g, 0);
        if (((long) this.f84a) > this.f85c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f84a + ", Actual length: " + this.f85c.length());
        }
        this.f86d = QueueFile.m113a(this.f89g, 4);
        int a = QueueFile.m113a(this.f89g, 8);
        int a2 = QueueFile.m113a(this.f89g, 12);
        this.f87e = m114a(a);
        this.f88f = m114a(a2);
    }

    private void m117a(int i, int i2, int i3, int i4) {
        QueueFile.m121a(this.f89g, i, i2, i3, i4);
        this.f85c.seek(0);
        this.f85c.write(this.f89g);
    }

    private QueueFile m114a(int i) {
        if (i == 0) {
            return QueueFile.f77a;
        }
        this.f85c.seek((long) i);
        return new QueueFile(i, this.f85c.readInt());
    }

    private static void m120a(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b = QueueFile.m123b(file2);
        try {
            b.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            b.seek(0);
            byte[] bArr = new byte[16];
            QueueFile.m121a(bArr, CodedOutputStream.DEFAULT_BUFFER_SIZE, 0, 0, 0);
            b.write(bArr);
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } finally {
            b.close();
        }
    }

    private static RandomAccessFile m123b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private int m122b(int i) {
        return i < this.f84a ? i : (i + 16) - this.f84a;
    }

    private void m118a(int i, byte[] bArr, int i2, int i3) {
        int b = m122b(i);
        if (b + i3 <= this.f84a) {
            this.f85c.seek((long) b);
            this.f85c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f84a - b;
        this.f85c.seek((long) b);
        this.f85c.write(bArr, i2, i4);
        this.f85c.seek(16);
        this.f85c.write(bArr, i2 + i4, i3 - i4);
    }

    private void m125b(int i, byte[] bArr, int i2, int i3) {
        int b = m122b(i);
        if (b + i3 <= this.f84a) {
            this.f85c.seek((long) b);
            this.f85c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f84a - b;
        this.f85c.seek((long) b);
        this.f85c.readFully(bArr, i2, i4);
        this.f85c.seek(16);
        this.f85c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void m133a(byte[] bArr) {
        m134a(bArr, 0, bArr.length);
    }

    public synchronized void m134a(byte[] bArr, int i, int i2) {
        QueueFile.m124b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3;
        m127c(i2);
        boolean b = m136b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m122b((this.f88f.f78b + 4) + this.f88f.f79c);
        }
        QueueFile queueFile = new QueueFile(i3, i2);
        QueueFile.m126b(this.f89g, 0, i2);
        m118a(queueFile.f78b, this.f89g, 0, 4);
        m118a(queueFile.f78b + 4, bArr, i, i2);
        m117a(this.f84a, this.f86d + 1, b ? queueFile.f78b : this.f87e.f78b, queueFile.f78b);
        this.f88f = queueFile;
        this.f86d++;
        if (b) {
            this.f87e = this.f88f;
        }
    }

    public int m131a() {
        if (this.f86d == 0) {
            return 16;
        }
        if (this.f88f.f78b >= this.f87e.f78b) {
            return (((this.f88f.f78b - this.f87e.f78b) + 4) + this.f88f.f79c) + 16;
        }
        return (((this.f88f.f78b + 4) + this.f88f.f79c) + this.f84a) - this.f87e.f78b;
    }

    private int m130f() {
        return this.f84a - m131a();
    }

    public synchronized boolean m136b() {
        return this.f86d == 0;
    }

    private void m127c(int i) {
        int i2 = i + 4;
        int f = m130f();
        if (f < i2) {
            int i3 = this.f84a;
            do {
                f += i3;
                i3 <<= 1;
            } while (f < i2);
            m128d(i3);
            i2 = m122b((this.f88f.f78b + 4) + this.f88f.f79c);
            if (i2 < this.f87e.f78b) {
                FileChannel channel = this.f85c.getChannel();
                channel.position((long) this.f84a);
                int i4 = i2 - 4;
                if (channel.transferTo(16, (long) i4, channel) != ((long) i4)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f88f.f78b < this.f87e.f78b) {
                f = (this.f84a + this.f88f.f78b) - 16;
                m117a(i3, this.f86d, this.f87e.f78b, f);
                this.f88f = new QueueFile(f, this.f88f.f79c);
            } else {
                m117a(i3, this.f86d, this.f87e.f78b, this.f88f.f78b);
            }
            this.f84a = i3;
        }
    }

    private void m128d(int i) {
        this.f85c.setLength((long) i);
        this.f85c.getChannel().force(true);
    }

    public synchronized void m132a(QueueFile queueFile) {
        int i = this.f87e.f78b;
        for (int i2 = 0; i2 < this.f86d; i2++) {
            QueueFile a = m114a(i);
            queueFile.read(new QueueFile(a, null), a.f79c);
            i = m122b(a.f79c + (a.f78b + 4));
        }
    }

    private static <T> T m124b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void m137c() {
        if (m136b()) {
            throw new NoSuchElementException();
        } else if (this.f86d == 1) {
            m138d();
        } else {
            int b = m122b((this.f87e.f78b + 4) + this.f87e.f79c);
            m125b(b, this.f89g, 0, 4);
            int a = QueueFile.m113a(this.f89g, 0);
            m117a(this.f84a, this.f86d - 1, b, this.f88f.f78b);
            this.f86d--;
            this.f87e = new QueueFile(b, a);
        }
    }

    public synchronized void m138d() {
        m117a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE, 0, 0, 0);
        this.f86d = 0;
        this.f87e = QueueFile.f77a;
        this.f88f = QueueFile.f77a;
        if (this.f84a > CodedOutputStream.DEFAULT_BUFFER_SIZE) {
            m128d(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        }
        this.f84a = CodedOutputStream.DEFAULT_BUFFER_SIZE;
    }

    public synchronized void close() {
        this.f85c.close();
    }

    public boolean m135a(int i, int i2) {
        return (m131a() + 4) + i <= i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.f84a);
        stringBuilder.append(", size=").append(this.f86d);
        stringBuilder.append(", first=").append(this.f87e);
        stringBuilder.append(", last=").append(this.f88f);
        stringBuilder.append(", element lengths=[");
        try {
            m132a(new QueueFile(this, stringBuilder));
        } catch (Throwable e) {
            f83b.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
