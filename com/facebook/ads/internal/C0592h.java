package com.facebook.ads.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.C0712u.C0711a;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.h */
public class C0592h {
    public static final String f1378a;
    private final String f1379b;
    private final boolean f1380c;
    private final C0569c f1381d;

    /* renamed from: com.facebook.ads.internal.h.a */
    private static final class C0567a implements IInterface {
        private IBinder f1332a;

        C0567a(IBinder iBinder) {
            this.f1332a = iBinder;
        }

        public String m1751a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f1332a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f1332a;
        }

        public boolean m1752b() {
            boolean z = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f1332a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.h.b */
    private static final class C0568b implements ServiceConnection {
        private AtomicBoolean f1333a;
        private final BlockingQueue<IBinder> f1334b;

        private C0568b() {
            this.f1333a = new AtomicBoolean(false);
            this.f1334b = new LinkedBlockingDeque();
        }

        public IBinder m1753a() {
            if (!this.f1333a.compareAndSet(true, true)) {
                return (IBinder) this.f1334b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f1334b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.facebook.ads.internal.h.c */
    public enum C0569c {
        SHARED_PREFS,
        FB4A,
        DIRECT,
        REFLECTION,
        SERVICE
    }

    static {
        f1378a = C0592h.class.getSimpleName();
    }

    private C0592h(String str, boolean z, C0569c c0569c) {
        this.f1379b = str;
        this.f1380c = z;
        this.f1381d = c0569c;
    }

    private static C0592h m1848a(Context context) {
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return new C0592h(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled(), C0569c.DIRECT);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static C0592h m1849a(Context context, C0711a c0711a) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        } else if (c0711a != null && !TextUtils.isEmpty(c0711a.f1738b)) {
            return new C0592h(c0711a.f1738b, c0711a.f1739c, C0569c.FB4A);
        } else {
            C0592h a = C0592h.m1848a(context);
            if (a == null || TextUtils.isEmpty(a.m1852a())) {
                a = C0592h.m1850b(context);
            }
            return (a == null || TextUtils.isEmpty(a.m1852a())) ? C0592h.m1851c(context) : a;
        }
    }

    private static C0592h m1850b(Context context) {
        Method a = C0712u.m2304a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (a == null) {
            return null;
        }
        Object a2 = C0712u.m2295a(null, a, context);
        if (a2 == null || ((Integer) a2).intValue() != 0) {
            return null;
        }
        a = C0712u.m2304a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
        if (a == null) {
            return null;
        }
        Object a3 = C0712u.m2295a(null, a, context);
        if (a3 == null) {
            return null;
        }
        a = C0712u.m2303a(a3.getClass(), "getId", new Class[0]);
        Method a4 = C0712u.m2303a(a3.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        return (a == null || a4 == null) ? null : new C0592h((String) C0712u.m2295a(a3, a, new Object[0]), ((Boolean) C0712u.m2295a(a3, a4, new Object[0])).booleanValue(), C0569c.REFLECTION);
    }

    private static C0592h m1851c(Context context) {
        ServiceConnection c0568b = new C0568b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        if (context.bindService(intent, c0568b, 1)) {
            C0592h c0592h;
            try {
                C0567a c0567a = new C0567a(c0568b.m1753a());
                c0592h = new C0592h(c0567a.m1751a(), c0567a.m1752b(), C0569c.SERVICE);
                return c0592h;
            } catch (Exception e) {
                c0592h = e;
            } finally {
                context.unbindService(c0568b);
            }
        }
        return null;
    }

    public String m1852a() {
        return this.f1379b;
    }

    public boolean m1853b() {
        return this.f1380c;
    }

    public C0569c m1854c() {
        return this.f1381d;
    }
}
