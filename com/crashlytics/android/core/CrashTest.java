package com.crashlytics.android.core;

import android.os.AsyncTask;
import p000a.p001a.p002a.p003a.Fabric;

public class CrashTest {

    /* renamed from: com.crashlytics.android.core.CrashTest.1 */
    class C03861 extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ long val$delayMs;

        C03861(long j) {
            this.val$delayMs = j;
        }

        protected Void doInBackground(Void... voidArr) {
            try {
                Thread.sleep(this.val$delayMs);
            } catch (InterruptedException e) {
            }
            CrashTest.this.throwRuntimeException("Background thread crash");
            return null;
        }
    }

    public void throwRuntimeException(String str) {
        throw new RuntimeException(str);
    }

    public int stackOverflow() {
        return stackOverflow() + ((int) Math.random());
    }

    public void indexOutOfBounds() {
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Out of bounds value: " + new int[2][10]);
    }

    public void crashAsyncTask(long j) {
        new C03861(j).execute(new Void[]{(Void) null});
    }

    public void throwFiveChainedExceptions() {
        try {
            privateMethodThatThrowsException("1");
        } catch (Throwable e) {
            throw new RuntimeException("2", e);
        } catch (Throwable e2) {
            try {
                throw new RuntimeException("3", e2);
            } catch (Throwable e22) {
                try {
                    throw new RuntimeException("4", e22);
                } catch (Throwable e222) {
                    throw new RuntimeException("5", e222);
                }
            }
        }
    }

    private void privateMethodThatThrowsException(String str) {
        throw new RuntimeException(str);
    }
}
