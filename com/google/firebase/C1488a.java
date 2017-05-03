package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.util.zzu;
import com.google.android.gms.internal.zzaac;
import com.google.android.gms.internal.zzaac.zza;
import com.google.android.gms.internal.zzbth;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.firebase.a */
public class C1488a {
    static final Map<String, C1488a> f4499a;
    private static final List<String> f4500b;
    private static final List<String> f4501c;
    private static final List<String> f4502d;
    private static final List<String> f4503e;
    private static final Set<String> f4504f;
    private static final Object f4505g;
    private final Context f4506h;
    private final String f4507i;
    private final C1489c f4508j;
    private final AtomicBoolean f4509k;
    private final AtomicBoolean f4510l;
    private final List<Object> f4511m;
    private final List<C1486a> f4512n;
    private final List<Object> f4513o;

    /* renamed from: com.google.firebase.a.1 */
    class C14851 implements zza {
        C14851() {
        }

        public void zzat(boolean z) {
            C1488a.m5073a(z);
        }
    }

    /* renamed from: com.google.firebase.a.a */
    public interface C1486a {
        void m5063a(boolean z);
    }

    @TargetApi(24)
    /* renamed from: com.google.firebase.a.b */
    private static class C1487b extends BroadcastReceiver {
        private static AtomicReference<C1487b> f4497a;
        private final Context f4498b;

        static {
            f4497a = new AtomicReference();
        }

        public C1487b(Context context) {
            this.f4498b = context;
        }

        private static void m5065b(Context context) {
            if (f4497a.get() == null) {
                BroadcastReceiver c1487b = new C1487b(context);
                if (f4497a.compareAndSet(null, c1487b)) {
                    context.registerReceiver(c1487b, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void m5066a() {
            this.f4498b.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (C1488a.f4505g) {
                for (C1488a a : C1488a.f4499a.values()) {
                    a.m5079h();
                }
            }
            m5066a();
        }
    }

    static {
        f4500b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
        f4501c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
        f4502d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
        f4503e = Arrays.asList(new String[0]);
        f4504f = Collections.emptySet();
        f4505g = new Object();
        f4499a = new ArrayMap();
    }

    protected C1488a(Context context, String str, C1489c c1489c) {
        this.f4509k = new AtomicBoolean(false);
        this.f4510l = new AtomicBoolean();
        this.f4511m = new CopyOnWriteArrayList();
        this.f4512n = new CopyOnWriteArrayList();
        this.f4513o = new CopyOnWriteArrayList();
        this.f4506h = (Context) zzac.zzw(context);
        this.f4507i = zzac.zzdr(str);
        this.f4508j = (C1489c) zzac.zzw(c1489c);
    }

    @Nullable
    public static C1488a m5067a(Context context) {
        C1488a d;
        synchronized (f4505g) {
            if (f4499a.containsKey("[DEFAULT]")) {
                d = C1488a.m5076d();
            } else {
                C1489c a = C1489c.m5084a(context);
                if (a == null) {
                    d = null;
                } else {
                    d = C1488a.m5068a(context, a);
                }
            }
        }
        return d;
    }

    public static C1488a m5068a(Context context, C1489c c1489c) {
        return C1488a.m5069a(context, c1489c, "[DEFAULT]");
    }

    public static C1488a m5069a(Context context, C1489c c1489c, String str) {
        Object c1488a;
        zzbth zzcw = zzbth.zzcw(context);
        C1488a.m5074b(context);
        String a = C1488a.m5070a(str);
        if (context.getApplicationContext() != null) {
            Object applicationContext = context.getApplicationContext();
        }
        synchronized (f4505g) {
            zzac.zza(!f4499a.containsKey(a), new StringBuilder(String.valueOf(a).length() + 33).append("FirebaseApp name ").append(a).append(" already exists!").toString());
            zzac.zzb(applicationContext, (Object) "Application context cannot be null.");
            c1488a = new C1488a(applicationContext, a, c1489c);
            f4499a.put(a, c1488a);
        }
        zzcw.zzg(c1488a);
        c1488a.m5072a(C1488a.class, c1488a, f4500b);
        if (c1488a.m5083e()) {
            c1488a.m5072a(C1488a.class, c1488a, f4501c);
            c1488a.m5072a(Context.class, c1488a.m5080a(), f4502d);
        }
        return c1488a;
    }

    private static String m5070a(@NonNull String str) {
        return str.trim();
    }

    private <T> void m5072a(Class<T> cls, T t, Iterable<String> iterable) {
        String valueOf;
        boolean isDeviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.f4506h);
        if (isDeviceProtectedStorage) {
            C1487b.m5065b(this.f4506h);
        }
        for (String valueOf2 : iterable) {
            if (isDeviceProtectedStorage) {
                try {
                    if (!f4503e.contains(valueOf2)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (f4504f.contains(valueOf2)) {
                        throw new IllegalStateException(String.valueOf(valueOf2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(valueOf2).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(String.valueOf(valueOf2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (Throwable e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (Throwable e4) {
                    String str = "FirebaseApp";
                    String str2 = "Failed to initialize ";
                    valueOf2 = String.valueOf(valueOf2);
                    Log.wtf(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e4);
                }
            }
            Method method = Class.forName(valueOf2).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }

    public static void m5073a(boolean z) {
        synchronized (f4505g) {
            Iterator it = new ArrayList(f4499a.values()).iterator();
            while (it.hasNext()) {
                C1488a c1488a = (C1488a) it.next();
                if (c1488a.f4509k.get()) {
                    c1488a.m5075b(z);
                }
            }
        }
    }

    @TargetApi(14)
    private static void m5074b(Context context) {
        zzt.zzzg();
        if (context.getApplicationContext() instanceof Application) {
            zzaac.zza((Application) context.getApplicationContext());
            zzaac.zzvB().zza(new C14851());
        }
    }

    private void m5075b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (C1486a a : this.f4512n) {
            a.m5063a(z);
        }
    }

    @Nullable
    public static C1488a m5076d() {
        C1488a c1488a;
        synchronized (f4505g) {
            c1488a = (C1488a) f4499a.get("[DEFAULT]");
            if (c1488a == null) {
                String valueOf = String.valueOf(zzu.zzzr());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(valueOf).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return c1488a;
    }

    private void m5078g() {
        zzac.zza(!this.f4510l.get(), (Object) "FirebaseApp was deleted");
    }

    private void m5079h() {
        m5072a(C1488a.class, (Object) this, f4500b);
        if (m5083e()) {
            m5072a(C1488a.class, (Object) this, f4501c);
            m5072a(Context.class, this.f4506h, f4502d);
        }
    }

    @NonNull
    public Context m5080a() {
        m5078g();
        return this.f4506h;
    }

    @NonNull
    public String m5081b() {
        m5078g();
        return this.f4507i;
    }

    @NonNull
    public C1489c m5082c() {
        m5078g();
        return this.f4508j;
    }

    public boolean m5083e() {
        return "[DEFAULT]".equals(m5081b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof C1488a) ? false : this.f4507i.equals(((C1488a) obj).m5081b());
    }

    public int hashCode() {
        return this.f4507i.hashCode();
    }

    public String toString() {
        return zzaa.zzv(this).zzg("name", this.f4507i).zzg("options", this.f4508j).toString();
    }
}
