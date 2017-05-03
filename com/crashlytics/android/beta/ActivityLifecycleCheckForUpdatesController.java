package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Activity;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.p003a.ActivityLifecycleManager.ActivityLifecycleManager;

@TargetApi(14)
class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController {
    private final ActivityLifecycleManager callbacks;
    private final ExecutorService executorService;

    /* renamed from: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.1 */
    class C03791 extends ActivityLifecycleManager {

        /* renamed from: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.1.1 */
        class C03781 implements Runnable {
            C03781() {
            }

            public void run() {
                ActivityLifecycleCheckForUpdatesController.this.checkForUpdates();
            }
        }

        C03791() {
        }

        public void onActivityStarted(Activity activity) {
            if (ActivityLifecycleCheckForUpdatesController.this.signalExternallyReady()) {
                ActivityLifecycleCheckForUpdatesController.this.executorService.submit(new C03781());
            }
        }
    }

    public ActivityLifecycleCheckForUpdatesController(p000a.p001a.p002a.p003a.ActivityLifecycleManager activityLifecycleManager, ExecutorService executorService) {
        this.callbacks = new C03791();
        this.executorService = executorService;
        activityLifecycleManager.m356a(this.callbacks);
    }

    public boolean isActivityLifecycleTriggered() {
        return true;
    }
}
