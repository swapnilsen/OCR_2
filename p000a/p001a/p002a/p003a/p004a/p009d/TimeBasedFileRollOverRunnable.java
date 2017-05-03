package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;

/* renamed from: a.a.a.a.a.d.i */
public class TimeBasedFileRollOverRunnable implements Runnable {
    private final Context f155a;
    private final FileRollOverManager f156b;

    public TimeBasedFileRollOverRunnable(Context context, FileRollOverManager fileRollOverManager) {
        this.f155a = context;
        this.f156b = fileRollOverManager;
    }

    public void run() {
        try {
            CommonUtils.m54a(this.f155a, "Performing time based file roll over.");
            if (!this.f156b.rollFileOver()) {
                this.f156b.cancelTimeBasedFileRollOver();
            }
        } catch (Throwable e) {
            CommonUtils.m55a(this.f155a, "Failed to roll over file", e);
        }
    }
}
