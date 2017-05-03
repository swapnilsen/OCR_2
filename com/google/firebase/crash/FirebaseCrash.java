package com.google.firebase.crash;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzbnl;
import com.google.android.gms.internal.zzbnm;
import com.google.android.gms.internal.zzbnn;
import com.google.android.gms.internal.zzbnp;
import com.google.android.gms.internal.zzbnq;
import com.google.android.gms.internal.zzbnr;
import com.google.android.gms.internal.zzbns;
import com.google.firebase.C1488a;
import com.google.firebase.iid.C1497c;

public class FirebaseCrash {
    private static final String f4521a;
    private static volatile FirebaseCrash f4522e;
    private boolean f4523b;
    private zzbnp f4524c;
    private zzbnl f4525d;

    static {
        f4521a = FirebaseCrash.class.getSimpleName();
    }

    FirebaseCrash(C1488a c1488a, boolean z) {
        this.f4523b = z;
        Context a = c1488a.m5080a();
        if (a == null) {
            Log.w(f4521a, "Application context is missing, disabling api");
            this.f4523b = false;
        }
        if (this.f4523b) {
            try {
                zzbnn com_google_android_gms_internal_zzbnn = new zzbnn(c1488a.m5082c().m5086b(), c1488a.m5082c().m5085a());
                zzbnq.zzWD().zzaG(a);
                this.f4524c = zzbnq.zzWD().zzWE();
                this.f4524c.zza(zzd.zzA(a), com_google_android_gms_internal_zzbnn);
                this.f4525d = new zzbnl(a);
                m5094f();
                String str = f4521a;
                String str2 = "FirebaseCrash reporting initialized ";
                String valueOf = String.valueOf(zzbnq.zzWD().toString());
                Log.i(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return;
            } catch (Exception e) {
                str = f4521a;
                str2 = "Failed to initialize crash reporting: ";
                valueOf = String.valueOf(e.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                this.f4523b = false;
                return;
            }
        }
        Log.i(f4521a, "Crash reporting is disabled");
    }

    public static FirebaseCrash m5088a() {
        if (f4522e == null) {
            synchronized (FirebaseCrash.class) {
                if (f4522e == null) {
                    f4522e = getInstance(C1488a.m5076d());
                }
            }
        }
        return f4522e;
    }

    public static void m5089a(String str, long j, Bundle bundle) {
        try {
            m5088a().m5097b(str, j, bundle);
        } catch (zzbnm e) {
            Log.v(f4521a, e.getMessage());
        }
    }

    private void m5090b() {
        if (m5092d()) {
            this.f4525d.zzWB();
            return;
        }
        throw new zzbnm("Firebase Crash Reporting is disabled.");
    }

    private zzbnp m5091c() {
        return this.f4524c;
    }

    private boolean m5092d() {
        return this.f4523b;
    }

    private static boolean m5093e() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    private void m5094f() {
        if (m5093e()) {
            Thread.setDefaultUncaughtExceptionHandler(new zzbnr(Thread.getDefaultUncaughtExceptionHandler(), this));
            return;
        }
        throw new RuntimeException("FirebaseCrash reporting may only be initialized on the main thread (preferably in your app's Application.onCreate)");
    }

    private String m5095g() {
        return C1497c.m5149a().m5150b();
    }

    @Keep
    @Deprecated
    public static FirebaseCrash getInstance(C1488a c1488a) {
        zzbns.initialize(c1488a.m5080a());
        FirebaseCrash firebaseCrash = new FirebaseCrash(c1488a, ((Boolean) zzbns.zzbZp.get()).booleanValue());
        synchronized (FirebaseCrash.class) {
            if (f4522e == null) {
                f4522e = firebaseCrash;
                try {
                    f4522e.m5090b();
                } catch (zzbnm e) {
                    Log.d(f4521a, "Cannot register Firebase Analytics listener since Firebase Crash Reporting is not enabled");
                }
            }
        }
        return firebaseCrash;
    }

    public void m5096a(Throwable th) {
        if (m5092d()) {
            zzbnp c = m5091c();
            if (c != null && th != null) {
                try {
                    this.f4525d.zza(true, System.currentTimeMillis());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    c.zziC(m5095g());
                    c.zzO(zzd.zzA(th));
                    return;
                } catch (Throwable e2) {
                    Log.e(f4521a, "report remoting failed", e2);
                    return;
                }
            }
            return;
        }
        throw new zzbnm("Firebase Crash Reporting is disabled.");
    }

    public void m5097b(String str, long j, Bundle bundle) {
        if (m5092d()) {
            zzbnp c = m5091c();
            if (c != null && str != null) {
                try {
                    c.zzb(str, j, bundle);
                    return;
                } catch (Throwable e) {
                    Log.e(f4521a, "log remoting failed", e);
                    return;
                }
            }
            return;
        }
        throw new zzbnm("Firebase Crash Reporting is disabled.");
    }
}
