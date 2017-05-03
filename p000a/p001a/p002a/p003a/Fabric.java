package p000a.p001a.p002a.p003a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p002a.p003a.ActivityLifecycleManager.ActivityLifecycleManager;
import p000a.p001a.p002a.p003a.p004a.p006b.IdManager;
import p000a.p001a.p002a.p003a.p004a.p007c.DependsOn;
import p000a.p001a.p002a.p003a.p004a.p007c.PriorityThreadPoolExecutor;
import p000a.p001a.p002a.p003a.p004a.p007c.UnmetDependencyException;

/* renamed from: a.a.a.a.c */
public class Fabric {
    static volatile Fabric f308a;
    static final Logger f309b;
    final Logger f310c;
    final boolean f311d;
    private final Context f312e;
    private final Map<Class<? extends Kit>, Kit> f313f;
    private final ExecutorService f314g;
    private final Handler f315h;
    private final InitializationCallback<Fabric> f316i;
    private final InitializationCallback<?> f317j;
    private final IdManager f318k;
    private ActivityLifecycleManager f319l;
    private WeakReference<Activity> f320m;
    private AtomicBoolean f321n;

    /* renamed from: a.a.a.a.c.1 */
    class Fabric extends ActivityLifecycleManager {
        final /* synthetic */ Fabric f294a;

        Fabric(Fabric fabric) {
            this.f294a = fabric;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.f294a.m400a(activity);
        }

        public void onActivityStarted(Activity activity) {
            this.f294a.m400a(activity);
        }

        public void onActivityResumed(Activity activity) {
            this.f294a.m400a(activity);
        }
    }

    /* renamed from: a.a.a.a.c.2 */
    class Fabric implements InitializationCallback {
        final CountDownLatch f296a;
        final /* synthetic */ int f297b;
        final /* synthetic */ Fabric f298c;

        Fabric(Fabric fabric, int i) {
            this.f298c = fabric;
            this.f297b = i;
            this.f296a = new CountDownLatch(this.f297b);
        }

        public void m384a(Object obj) {
            this.f296a.countDown();
            if (this.f296a.getCount() == 0) {
                this.f298c.f321n.set(true);
                this.f298c.f316i.m382a(this.f298c);
            }
        }

        public void m383a(Exception exception) {
            this.f298c.f316i.m381a(exception);
        }
    }

    /* renamed from: a.a.a.a.c.a */
    public static class Fabric {
        private final Context f299a;
        private Kit[] f300b;
        private PriorityThreadPoolExecutor f301c;
        private Handler f302d;
        private Logger f303e;
        private boolean f304f;
        private String f305g;
        private String f306h;
        private InitializationCallback<Fabric> f307i;

        public Fabric(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f299a = context;
        }

        public Fabric m385a(Kit... kitArr) {
            if (this.f300b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.f300b = kitArr;
            return this;
        }

        public Fabric m386a() {
            Map hashMap;
            if (this.f301c == null) {
                this.f301c = PriorityThreadPoolExecutor.m185a();
            }
            if (this.f302d == null) {
                this.f302d = new Handler(Looper.getMainLooper());
            }
            if (this.f303e == null) {
                if (this.f304f) {
                    this.f303e = new DefaultLogger(3);
                } else {
                    this.f303e = new DefaultLogger();
                }
            }
            if (this.f306h == null) {
                this.f306h = this.f299a.getPackageName();
            }
            if (this.f307i == null) {
                this.f307i = InitializationCallback.f295d;
            }
            if (this.f300b == null) {
                hashMap = new HashMap();
            } else {
                hashMap = Fabric.m394b(Arrays.asList(this.f300b));
            }
            return new Fabric(this.f299a, hashMap, this.f301c, this.f302d, this.f303e, this.f304f, this.f307i, new IdManager(this.f299a, this.f306h, this.f305g, hashMap.values()));
        }
    }

    static {
        f309b = new DefaultLogger();
    }

    static Fabric m387a() {
        if (f308a != null) {
            return f308a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    Fabric(Context context, Map<Class<? extends Kit>, Kit> map, PriorityThreadPoolExecutor priorityThreadPoolExecutor, Handler handler, Logger logger, boolean z, InitializationCallback initializationCallback, IdManager idManager) {
        this.f312e = context.getApplicationContext();
        this.f313f = map;
        this.f314g = priorityThreadPoolExecutor;
        this.f315h = handler;
        this.f310c = logger;
        this.f311d = z;
        this.f316i = initializationCallback;
        this.f321n = new AtomicBoolean(false);
        this.f317j = m401a(map.size());
        this.f318k = idManager;
        m400a(m395c(context));
    }

    public static Fabric m388a(Context context, Kit... kitArr) {
        if (f308a == null) {
            synchronized (Fabric.class) {
                if (f308a == null) {
                    Fabric.m396c(new Fabric(context).m385a(kitArr).m386a());
                }
            }
        }
        return f308a;
    }

    private static void m396c(Fabric fabric) {
        f308a = fabric;
        fabric.m399j();
    }

    public Fabric m400a(Activity activity) {
        this.f320m = new WeakReference(activity);
        return this;
    }

    public Activity m404b() {
        if (this.f320m != null) {
            return (Activity) this.f320m.get();
        }
        return null;
    }

    private void m399j() {
        this.f319l = new ActivityLifecycleManager(this.f312e);
        this.f319l.m356a(new Fabric(this));
        m402a(this.f312e);
    }

    public String m406c() {
        return "1.3.15.167";
    }

    public String m407d() {
        return "io.fabric.sdk.android:fabric";
    }

    void m402a(Context context) {
        StringBuilder append;
        Future b = m405b(context);
        Collection g = m410g();
        Onboarding onboarding = new Onboarding(b, g);
        List<Kit> arrayList = new ArrayList(g);
        Collections.sort(arrayList);
        onboarding.injectParameters(context, this, InitializationCallback.f295d, this.f318k);
        for (Kit injectParameters : arrayList) {
            injectParameters.injectParameters(context, this, this.f317j, this.f318k);
        }
        onboarding.initialize();
        if (Fabric.m397h().m361a("Fabric", 3)) {
            append = new StringBuilder("Initializing ").append(m407d()).append(" [Version: ").append(m406c()).append("], with the following kits:\n");
        } else {
            append = null;
        }
        for (Kit injectParameters2 : arrayList) {
            injectParameters2.initializationTask.m182a(onboarding.initializationTask);
            m403a(this.f313f, injectParameters2);
            injectParameters2.initialize();
            if (append != null) {
                append.append(injectParameters2.getIdentifier()).append(" [Version: ").append(injectParameters2.getVersion()).append("]\n");
            }
        }
        if (append != null) {
            Fabric.m397h().m359a("Fabric", append.toString());
        }
    }

    void m403a(Map<Class<? extends Kit>, Kit> map, Kit kit) {
        DependsOn dependsOn = kit.dependsOnAnnotation;
        if (dependsOn != null) {
            for (Class cls : dependsOn.m175a()) {
                if (cls.isInterface()) {
                    for (Kit kit2 : map.values()) {
                        if (cls.isAssignableFrom(kit2.getClass())) {
                            kit.initializationTask.m182a(kit2.initializationTask);
                        }
                    }
                } else if (((Kit) map.get(cls)) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                } else {
                    kit.initializationTask.m182a(((Kit) map.get(cls)).initializationTask);
                }
            }
        }
    }

    private Activity m395c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public ActivityLifecycleManager m408e() {
        return this.f319l;
    }

    public ExecutorService m409f() {
        return this.f314g;
    }

    public Collection<Kit> m410g() {
        return this.f313f.values();
    }

    public static <T extends Kit> T m389a(Class<T> cls) {
        return (Kit) Fabric.m387a().f313f.get(cls);
    }

    public static Logger m397h() {
        if (f308a == null) {
            return f309b;
        }
        return f308a.f310c;
    }

    public static boolean m398i() {
        if (f308a == null) {
            return false;
        }
        return f308a.f311d;
    }

    private static Map<Class<? extends Kit>, Kit> m394b(Collection<? extends Kit> collection) {
        Map hashMap = new HashMap(collection.size());
        Fabric.m392a(hashMap, (Collection) collection);
        return hashMap;
    }

    private static void m392a(Map<Class<? extends Kit>, Kit> map, Collection<? extends Kit> collection) {
        for (Kit kit : collection) {
            map.put(kit.getClass(), kit);
            if (kit instanceof KitGroup) {
                Fabric.m392a((Map) map, ((KitGroup) kit).getKits());
            }
        }
    }

    InitializationCallback<?> m401a(int i) {
        return new Fabric(this, i);
    }

    Future<Map<String, KitInfo>> m405b(Context context) {
        return m409f().submit(new FabricKitsFinder(context.getPackageCodePath()));
    }
}
