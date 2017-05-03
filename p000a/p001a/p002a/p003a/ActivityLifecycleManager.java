package p000a.p001a.p002a.p003a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: a.a.a.a.a */
public class ActivityLifecycleManager {
    private final Application f291a;
    private ActivityLifecycleManager f292b;

    /* renamed from: a.a.a.a.a.a */
    private static class ActivityLifecycleManager {
        private final Set<ActivityLifecycleCallbacks> f2a;
        private final Application f3b;

        /* renamed from: a.a.a.a.a.a.1 */
        class ActivityLifecycleManager implements ActivityLifecycleCallbacks {
            final /* synthetic */ ActivityLifecycleManager f0a;
            final /* synthetic */ ActivityLifecycleManager f1b;

            ActivityLifecycleManager(ActivityLifecycleManager activityLifecycleManager, ActivityLifecycleManager activityLifecycleManager2) {
                this.f1b = activityLifecycleManager;
                this.f0a = activityLifecycleManager2;
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                this.f0a.onActivityCreated(activity, bundle);
            }

            public void onActivityStarted(Activity activity) {
                this.f0a.onActivityStarted(activity);
            }

            public void onActivityResumed(Activity activity) {
                this.f0a.onActivityResumed(activity);
            }

            public void onActivityPaused(Activity activity) {
                this.f0a.onActivityPaused(activity);
            }

            public void onActivityStopped(Activity activity) {
                this.f0a.onActivityStopped(activity);
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                this.f0a.onActivitySaveInstanceState(activity, bundle);
            }

            public void onActivityDestroyed(Activity activity) {
                this.f0a.onActivityDestroyed(activity);
            }
        }

        ActivityLifecycleManager(Application application) {
            this.f2a = new HashSet();
            this.f3b = application;
        }

        @TargetApi(14)
        private void m0a() {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f2a) {
                this.f3b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        @TargetApi(14)
        private boolean m3a(ActivityLifecycleManager activityLifecycleManager) {
            if (this.f3b == null) {
                return false;
            }
            ActivityLifecycleCallbacks activityLifecycleManager2 = new ActivityLifecycleManager(this, activityLifecycleManager);
            this.f3b.registerActivityLifecycleCallbacks(activityLifecycleManager2);
            this.f2a.add(activityLifecycleManager2);
            return true;
        }
    }

    /* renamed from: a.a.a.a.a.b */
    public static abstract class ActivityLifecycleManager {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }
    }

    public ActivityLifecycleManager(Context context) {
        this.f291a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f292b = new ActivityLifecycleManager(this.f291a);
        }
    }

    public boolean m356a(ActivityLifecycleManager activityLifecycleManager) {
        return this.f292b != null && this.f292b.m3a(activityLifecycleManager);
    }

    public void m355a() {
        if (this.f292b != null) {
            this.f292b.m0a();
        }
    }
}
