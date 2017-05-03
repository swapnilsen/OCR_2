package com.facebook.ads.internal.p033j.p035b;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.facebook.ads.internal.p033j.p035b.p036a.C0617b;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/* renamed from: com.facebook.ads.internal.j.b.e */
class C0630e extends C0629k {
    private final C0641h f1446a;
    private final C0617b f1447b;
    private C0626b f1448c;

    public C0630e(C0641h c0641h, C0617b c0617b) {
        super(c0641h, c0617b);
        this.f1447b = c0617b;
        this.f1446a = c0641h;
    }

    private void m1986a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD];
        while (true) {
            int a = m1981a(bArr, j, bArr.length);
            if (a != -1) {
                outputStream.write(bArr, 0, a);
                j += (long) a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private boolean m1987a(C0628d c0628d) {
        int a = this.f1446a.m2033a();
        boolean z = a > 0;
        int a2 = this.f1447b.m1942a();
        if (z && c0628d.f1437c) {
            if (((float) c0628d.f1436b) > (((float) a) * 0.2f) + ((float) a2)) {
                return false;
            }
        }
        return true;
    }

    private String m1988b(C0628d c0628d) {
        int i = !TextUtils.isEmpty(this.f1446a.m2037c()) ? 1 : 0;
        int a = this.f1447b.m1947d() ? this.f1447b.m1942a() : this.f1446a.m2033a();
        int i2 = a >= 0 ? 1 : 0;
        long j = c0628d.f1437c ? ((long) a) - c0628d.f1436b : (long) a;
        int i3 = (i2 == 0 || !c0628d.f1437c) ? 0 : 1;
        return (c0628d.f1437c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (i2 != 0 ? String.format("Content-Length: %d\n", new Object[]{Long.valueOf(j)}) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING) + (i3 != 0 ? String.format("Content-Range: bytes %d-%d/%d\n", new Object[]{Long.valueOf(c0628d.f1436b), Integer.valueOf(a - 1), Integer.valueOf(a)}) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING) + (i != 0 ? String.format("Content-Type: %s\n", new Object[]{r9}) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING) + "\n";
    }

    private void m1989b(OutputStream outputStream, long j) {
        try {
            C0641h c0641h = new C0641h(this.f1446a);
            c0641h.m2035a((int) j);
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD];
            while (true) {
                int a = c0641h.m2034a(bArr);
                if (a == -1) {
                    break;
                }
                outputStream.write(bArr, 0, a);
                j += (long) a;
            }
            outputStream.flush();
        } finally {
            this.f1446a.m2036b();
        }
    }

    protected void m1990a(int i) {
        if (this.f1448c != null) {
            this.f1448c.m1967a(this.f1447b.f1423a, this.f1446a.f1475a, i);
        }
    }

    public void m1991a(C0626b c0626b) {
        this.f1448c = c0626b;
    }

    public void m1992a(C0628d c0628d, Socket socket) {
        OutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m1988b(c0628d).getBytes("UTF-8"));
        long j = c0628d.f1436b;
        if (m1987a(c0628d)) {
            m1986a(bufferedOutputStream, j);
        } else {
            m1989b(bufferedOutputStream, j);
        }
    }
}
