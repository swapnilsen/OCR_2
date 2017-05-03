package com.facebook.ads.internal.p033j.p035b;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.facebook.ads.internal.p033j.p035b.p036a.C0615a;
import com.facebook.ads.internal.p033j.p035b.p036a.C0618c;
import com.facebook.ads.internal.p033j.p035b.p036a.C0624f;
import com.facebook.ads.internal.p033j.p035b.p036a.C0625g;
import com.google.api.client.http.HttpStatusCodes;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.facebook.ads.internal.j.b.f */
public class C0637f {
    private final Object f1459a;
    private final ExecutorService f1460b;
    private final Map<String, C0639g> f1461c;
    private final ServerSocket f1462d;
    private final int f1463e;
    private final Thread f1464f;
    private final C0627c f1465g;
    private boolean f1466h;

    /* renamed from: com.facebook.ads.internal.j.b.f.a */
    public static final class C0632a {
        private File f1449a;
        private C0618c f1450b;
        private C0615a f1451c;

        public C0632a(Context context) {
            this.f1449a = C0648o.m2048a(context);
            this.f1451c = new C0625g(67108864);
            this.f1450b = new C0624f();
        }

        private C0627c m1993a() {
            return new C0627c(this.f1449a, this.f1450b, this.f1451c);
        }
    }

    /* renamed from: com.facebook.ads.internal.j.b.f.b */
    private class C0633b implements Callable<Boolean> {
        final /* synthetic */ C0637f f1452a;

        private C0633b(C0637f c0637f) {
            this.f1452a = c0637f;
        }

        public Boolean m1995a() {
            return Boolean.valueOf(this.f1452a.m2006c());
        }

        public /* synthetic */ Object call() {
            return m1995a();
        }
    }

    /* renamed from: com.facebook.ads.internal.j.b.f.c */
    private class C0634c implements Callable<Boolean> {
        final /* synthetic */ C0637f f1453a;
        private final String f1454b;

        public C0634c(C0637f c0637f, String str) {
            this.f1453a = c0637f;
            this.f1454b = str;
        }

        public Boolean m1996a() {
            return Boolean.valueOf(this.f1453a.m2007c(this.f1454b));
        }

        public /* synthetic */ Object call() {
            return m1996a();
        }
    }

    /* renamed from: com.facebook.ads.internal.j.b.f.d */
    private final class C0635d implements Runnable {
        final /* synthetic */ C0637f f1455a;
        private final Socket f1456b;

        public C0635d(C0637f c0637f, Socket socket) {
            this.f1455a = c0637f;
            this.f1456b = socket;
        }

        public void run() {
            this.f1455a.m2000a(this.f1456b);
        }
    }

    /* renamed from: com.facebook.ads.internal.j.b.f.e */
    private final class C0636e implements Runnable {
        final /* synthetic */ C0637f f1457a;
        private final CountDownLatch f1458b;

        public C0636e(C0637f c0637f, CountDownLatch countDownLatch) {
            this.f1457a = c0637f;
            this.f1458b = countDownLatch;
        }

        public void run() {
            this.f1458b.countDown();
            this.f1457a.m2012e();
        }
    }

    public C0637f(Context context) {
        this(new C0632a(context).m1993a());
    }

    private C0637f(C0627c c0627c) {
        Throwable e;
        this.f1459a = new Object();
        this.f1460b = Executors.newFixedThreadPool(8);
        this.f1461c = new ConcurrentHashMap();
        this.f1465g = (C0627c) C0644j.m2038a(c0627c);
        try {
            this.f1462d = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f1463e = this.f1462d.getLocalPort();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f1464f = new Thread(new C0636e(this, countDownLatch));
            this.f1464f.start();
            countDownLatch.await();
            Log.i("ProxyCache", "Proxy cache server started. Ping it...");
            m2002b();
        } catch (IOException e2) {
            e = e2;
            this.f1460b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        } catch (InterruptedException e3) {
            e = e3;
            this.f1460b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private void m1999a(Throwable th) {
        Log.e("ProxyCache", "HttpProxyCacheServer error", th);
    }

    private void m2000a(Socket socket) {
        Throwable e;
        try {
            C0628d a = C0628d.m1970a(socket.getInputStream());
            Log.i("ProxyCache", "Request to cache proxy:" + a);
            String c = C0647m.m2046c(a.f1435a);
            if ("ping".equals(c)) {
                m2003b(socket);
            } else {
                m2011e(c).m2024a(a, socket);
            }
            m2005c(socket);
            Log.d("ProxyCache", "Opened connections: " + m2014f());
        } catch (SocketException e2) {
            Log.d("ProxyCache", "Closing socket... Socket is closed by client.");
            m2005c(socket);
            Log.d("ProxyCache", "Opened connections: " + m2014f());
        } catch (C0642l e3) {
            e = e3;
            m1999a(new C0642l("Error processing request", e));
            m2005c(socket);
            Log.d("ProxyCache", "Opened connections: " + m2014f());
        } catch (IOException e4) {
            e = e4;
            m1999a(new C0642l("Error processing request", e));
            m2005c(socket);
            Log.d("ProxyCache", "Opened connections: " + m2014f());
        } catch (Throwable th) {
            m2005c(socket);
            Log.d("ProxyCache", "Opened connections: " + m2014f());
        }
    }

    private void m2002b() {
        int i = HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES;
        int i2 = 0;
        while (i2 < 3) {
            try {
                this.f1466h = ((Boolean) this.f1460b.submit(new C0633b()).get((long) i, TimeUnit.MILLISECONDS)).booleanValue();
                if (!this.f1466h) {
                    SystemClock.sleep((long) i);
                    i *= 2;
                    i2++;
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Throwable e2 = e;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            } catch (ExecutionException e3) {
                e2 = e3;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            } catch (TimeoutException e4) {
                e2 = e4;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error pinging server [attempts: " + i2 + ", max timeout: " + (i / 2) + "].");
        m2016a();
    }

    private void m2003b(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    private void m2005c(Socket socket) {
        m2010d(socket);
        m2013e(socket);
        m2015f(socket);
    }

    private boolean m2006c() {
        C0641h c0641h = new C0641h(m2008d("ping"));
        boolean equals;
        try {
            byte[] bytes = "ping ok".getBytes();
            c0641h.m2035a(0);
            byte[] bArr = new byte[bytes.length];
            c0641h.m2034a(bArr);
            equals = Arrays.equals(bytes, bArr);
            Log.d("ProxyCache", "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (C0642l e) {
            equals = e;
            Log.e("ProxyCache", "Error reading ping response", equals);
            return false;
        } finally {
            c0641h.m2036b();
        }
    }

    private boolean m2007c(String str) {
        C0641h c0641h = new C0641h(m2008d(str));
        try {
            c0641h.m2035a(0);
            while (true) {
                if (c0641h.m2034a(new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD]) == -1) {
                    break;
                }
            }
            return true;
        } catch (Throwable e) {
            Log.e("ProxyCache", "Error reading url", e);
            return false;
        } finally {
            c0641h.m2036b();
        }
    }

    private String m2008d(String str) {
        return String.format("http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f1463e), C0647m.m2045b(str)});
    }

    private void m2009d() {
        synchronized (this.f1459a) {
            for (C0639g a : this.f1461c.values()) {
                a.m2023a();
            }
            this.f1461c.clear();
        }
    }

    private void m2010d(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException e) {
            Log.d("ProxyCache", "Releasing input stream... Socket is closed by client.");
        } catch (Throwable e2) {
            m1999a(new C0642l("Error closing socket input stream", e2));
        }
    }

    private C0639g m2011e(String str) {
        C0639g c0639g;
        synchronized (this.f1459a) {
            c0639g = (C0639g) this.f1461c.get(str);
            if (c0639g == null) {
                c0639g = new C0639g(str, this.f1465g);
                this.f1461c.put(str, c0639g);
            }
        }
        return c0639g;
    }

    private void m2012e() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f1462d.accept();
                Log.d("ProxyCache", "Accept new socket " + accept);
                this.f1460b.submit(new C0635d(this, accept));
            } catch (Throwable e) {
                m1999a(new C0642l("Error during waiting connection", e));
                return;
            }
        }
    }

    private void m2013e(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (Throwable e) {
            m1999a(new C0642l("Error closing socket output stream", e));
        }
    }

    private int m2014f() {
        int i;
        synchronized (this.f1459a) {
            i = 0;
            for (C0639g b : this.f1461c.values()) {
                i = b.m2025b() + i;
            }
        }
        return i;
    }

    private void m2015f(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (Throwable e) {
            m1999a(new C0642l("Error closing socket", e));
        }
    }

    public void m2016a() {
        Log.i("ProxyCache", "Shutdown proxy server");
        m2009d();
        this.f1464f.interrupt();
        try {
            if (!this.f1462d.isClosed()) {
                this.f1462d.close();
            }
        } catch (Throwable e) {
            m1999a(new C0642l("Error shutting down proxy server", e));
        }
    }

    public void m2017a(String str) {
        int i = HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES;
        int i2 = 0;
        while (i2 < 3) {
            try {
                if (!((Boolean) this.f1460b.submit(new C0634c(this, str)).get()).booleanValue()) {
                    SystemClock.sleep((long) i);
                    i *= 2;
                    i2++;
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Throwable e2 = e;
                Log.e("ProxyCache", "Error precaching url [attempt: " + i2 + ", url: " + str + "]. ", e2);
                i *= 2;
                i2++;
            } catch (ExecutionException e3) {
                e2 = e3;
                Log.e("ProxyCache", "Error precaching url [attempt: " + i2 + ", url: " + str + "]. ", e2);
                i *= 2;
                i2++;
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error precaching url [attempts: " + i2 + ", url: " + str + "].");
        m2016a();
    }

    public String m2018b(String str) {
        if (!this.f1466h) {
            Log.e("ProxyCache", "Proxy server isn't pinged. Caching doesn't work.");
        }
        return this.f1466h ? m2008d(str) : str;
    }
}
