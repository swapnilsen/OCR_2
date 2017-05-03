package p000a.p001a.p002a.p003a.p004a.p006b;

import android.os.Process;

/* renamed from: a.a.a.a.a.b.h */
public abstract class BackgroundPriorityRunnable implements Runnable {
    protected abstract void onRun();

    public final void run() {
        Process.setThreadPriority(10);
        onRun();
    }
}
