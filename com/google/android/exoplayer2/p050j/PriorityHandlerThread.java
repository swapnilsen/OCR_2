package com.google.android.exoplayer2.p050j;

import android.os.HandlerThread;
import android.os.Process;

/* renamed from: com.google.android.exoplayer2.j.n */
public final class PriorityHandlerThread extends HandlerThread {
    private final int f3838a;

    public PriorityHandlerThread(String str, int i) {
        super(str);
        this.f3838a = i;
    }

    public void run() {
        Process.setThreadPriority(this.f3838a);
        super.run();
    }
}
