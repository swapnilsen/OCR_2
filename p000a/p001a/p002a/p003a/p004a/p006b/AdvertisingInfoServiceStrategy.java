package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p002a.p003a.Fabric;

/* renamed from: a.a.a.a.a.b.e */
class AdvertisingInfoServiceStrategy implements AdvertisingInfoStrategy {
    private final Context f16a;

    /* renamed from: a.a.a.a.a.b.e.a */
    private static final class AdvertisingInfoServiceStrategy implements ServiceConnection {
        private boolean f13a;
        private final LinkedBlockingQueue<IBinder> f14b;

        private AdvertisingInfoServiceStrategy() {
            this.f13a = false;
            this.f14b = new LinkedBlockingQueue(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f14b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f14b.clear();
        }

        public IBinder m27a() {
            if (this.f13a) {
                Fabric.m397h().m366e("Fabric", "getBinder already called");
            }
            this.f13a = true;
            try {
                return (IBinder) this.f14b.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    /* renamed from: a.a.a.a.a.b.e.b */
    private static final class AdvertisingInfoServiceStrategy implements IInterface {
        private final IBinder f15a;

        public boolean m29b() {
            /* JADX: method processing error */
/*
            Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r7 = this;
            r0 = 1;
            r1 = 0;
            r2 = android.os.Parcel.obtain();
            r3 = android.os.Parcel.obtain();
            r4 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInterfaceToken(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = 1;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInt(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r7.f15a;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = 2;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r6 = 0;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4.transact(r5, r2, r3, r6);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.readException();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r3.readInt();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            if (r4 == 0) goto L_0x002a;
        L_0x0023:
            r3.recycle();
            r2.recycle();
        L_0x0029:
            return r0;
        L_0x002a:
            r0 = r1;
            goto L_0x0023;
        L_0x002c:
            r0 = move-exception;
            r0 = p000a.p001a.p002a.p003a.Fabric.m397h();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = "Fabric";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r0.m359a(r4, r5);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.recycle();
            r2.recycle();
            r0 = r1;
            goto L_0x0029;
        L_0x0040:
            r0 = move-exception;
            r3.recycle();
            r2.recycle();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.b.e.b.b():boolean");
        }

        public AdvertisingInfoServiceStrategy(IBinder iBinder) {
            this.f15a = iBinder;
        }

        public IBinder asBinder() {
            return this.f15a;
        }

        public String m28a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str = null;
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f15a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Exception e) {
                Fabric.m397h().m359a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
            return str;
        }
    }

    public AdvertisingInfoServiceStrategy(Context context) {
        this.f16a = context.getApplicationContext();
    }

    public AdvertisingInfo m30a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Fabric.m397h().m359a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f16a.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            ServiceConnection advertisingInfoServiceStrategy = new AdvertisingInfoServiceStrategy();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            try {
                if (this.f16a.bindService(intent, advertisingInfoServiceStrategy, 1)) {
                    AdvertisingInfoServiceStrategy advertisingInfoServiceStrategy2 = new AdvertisingInfoServiceStrategy(advertisingInfoServiceStrategy.m27a());
                    AdvertisingInfo advertisingInfo = new AdvertisingInfo(advertisingInfoServiceStrategy2.m28a(), advertisingInfoServiceStrategy2.m29b());
                    this.f16a.unbindService(advertisingInfoServiceStrategy);
                    return advertisingInfo;
                }
                Fabric.m397h().m359a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                return null;
            } catch (Throwable e) {
                Fabric.m397h().m365d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                this.f16a.unbindService(advertisingInfoServiceStrategy);
                return null;
            } catch (Throwable e2) {
                Fabric.m397h().m360a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", e2);
                return null;
            }
        } catch (NameNotFoundException e3) {
            Fabric.m397h().m359a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Throwable e22) {
            Fabric.m397h().m360a("Fabric", "Unable to determine if Google Play Services is available", e22);
            return null;
        }
    }
}
