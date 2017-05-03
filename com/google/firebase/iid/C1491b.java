package com.google.firebase.iid;

import android.app.Service;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.util.Pair;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.firebase.iid.b */
public abstract class C1491b extends Service {
    private Binder f4539a;
    private final Object f4540b;
    @VisibleForTesting
    final ExecutorService f4541c;
    private int f4542d;
    private int f4543e;

    /* renamed from: com.google.firebase.iid.b.1 */
    class C14931 implements Runnable {
        final /* synthetic */ Intent f4548a;
        final /* synthetic */ Intent f4549b;
        final /* synthetic */ C1491b f4550c;

        C14931(C1491b c1491b, Intent intent, Intent intent2) {
            this.f4550c = c1491b;
            this.f4548a = intent;
            this.f4549b = intent2;
        }

        public void run() {
            this.f4550c.handleIntent(this.f4548a);
            this.f4550c.m5122b(this.f4549b);
        }
    }

    /* renamed from: com.google.firebase.iid.b.a */
    public static class C1495a extends Binder {
        private final C1491b f4554a;

        /* renamed from: com.google.firebase.iid.b.a.1 */
        class C14941 implements Runnable {
            final /* synthetic */ Intent f4551a;
            final /* synthetic */ PendingResult f4552b;
            final /* synthetic */ C1495a f4553c;

            C14941(C1495a c1495a, Intent intent, PendingResult pendingResult) {
                this.f4553c = c1495a;
                this.f4551a = intent;
                this.f4552b = pendingResult;
            }

            public void run() {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "bg processing of the intent starting now");
                }
                this.f4553c.f4554a.handleIntent(this.f4551a);
                C1495a.m5145b(this.f4552b);
            }
        }

        C1495a(C1491b c1491b) {
            this.f4554a = c1491b;
        }

        private static void m5145b(@Nullable PendingResult pendingResult) {
            if (pendingResult != null) {
                pendingResult.finish();
            }
        }

        public void m5146a(Intent intent, @Nullable PendingResult pendingResult) {
            if (Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException("Binding only allowed within app");
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (this.f4554a.zzE(intent)) {
                C1495a.m5145b(pendingResult);
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.f4554a.f4541c.execute(new C14941(this, intent, pendingResult));
        }
    }

    /* renamed from: com.google.firebase.iid.b.b */
    public static class C1496b implements ServiceConnection {
        private final Context f4555a;
        private final Intent f4556b;
        private final Queue<Pair<Intent, PendingResult>> f4557c;
        private C1495a f4558d;
        private boolean f4559e;

        public C1496b(Context context, String str) {
            this.f4557c = new LinkedList();
            this.f4559e = false;
            this.f4555a = context.getApplicationContext();
            this.f4556b = new Intent(str).setPackage(this.f4555a.getPackageName());
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized void m5147a() {
            /*
            r4 = this;
            r2 = 1;
            monitor-enter(r4);
            r0 = "EnhancedIntentService";
            r1 = 3;
            r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0012;
        L_0x000b:
            r0 = "EnhancedIntentService";
            r1 = "flush queue called";
            android.util.Log.d(r0, r1);	 Catch:{ all -> 0x005c }
        L_0x0012:
            r0 = r4.f4557c;	 Catch:{ all -> 0x005c }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x009e;
        L_0x001a:
            r0 = "EnhancedIntentService";
            r1 = 3;
            r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x002a;
        L_0x0023:
            r0 = "EnhancedIntentService";
            r1 = "found intent to be delivered";
            android.util.Log.d(r0, r1);	 Catch:{ all -> 0x005c }
        L_0x002a:
            r0 = r4.f4558d;	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x005f;
        L_0x002e:
            r0 = r4.f4558d;	 Catch:{ all -> 0x005c }
            r0 = r0.isBinderAlive();	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x005f;
        L_0x0036:
            r0 = "EnhancedIntentService";
            r1 = 3;
            r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0046;
        L_0x003f:
            r0 = "EnhancedIntentService";
            r1 = "binder is alive, sending the intent.";
            android.util.Log.d(r0, r1);	 Catch:{ all -> 0x005c }
        L_0x0046:
            r0 = r4.f4557c;	 Catch:{ all -> 0x005c }
            r0 = r0.poll();	 Catch:{ all -> 0x005c }
            r0 = (android.util.Pair) r0;	 Catch:{ all -> 0x005c }
            r3 = r4.f4558d;	 Catch:{ all -> 0x005c }
            r1 = r0.first;	 Catch:{ all -> 0x005c }
            r1 = (android.content.Intent) r1;	 Catch:{ all -> 0x005c }
            r0 = r0.second;	 Catch:{ all -> 0x005c }
            r0 = (android.content.BroadcastReceiver.PendingResult) r0;	 Catch:{ all -> 0x005c }
            r3.m5146a(r1, r0);	 Catch:{ all -> 0x005c }
            goto L_0x0012;
        L_0x005c:
            r0 = move-exception;
            monitor-exit(r4);
            throw r0;
        L_0x005f:
            r0 = "EnhancedIntentService";
            r1 = 3;
            r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0087;
        L_0x0068:
            r1 = "EnhancedIntentService";
            r0 = r4.f4559e;	 Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x00a0;
        L_0x006e:
            r0 = r2;
        L_0x006f:
            r2 = 39;
            r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005c }
            r3.<init>(r2);	 Catch:{ all -> 0x005c }
            r2 = "binder is dead. start connection? ";
            r2 = r3.append(r2);	 Catch:{ all -> 0x005c }
            r0 = r2.append(r0);	 Catch:{ all -> 0x005c }
            r0 = r0.toString();	 Catch:{ all -> 0x005c }
            android.util.Log.d(r1, r0);	 Catch:{ all -> 0x005c }
        L_0x0087:
            r0 = r4.f4559e;	 Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x009e;
        L_0x008b:
            r0 = 1;
            r4.f4559e = r0;	 Catch:{ all -> 0x005c }
            r0 = com.google.android.gms.common.stats.zza.zzyJ();	 Catch:{ SecurityException -> 0x00c1 }
            r1 = r4.f4555a;	 Catch:{ SecurityException -> 0x00c1 }
            r2 = r4.f4556b;	 Catch:{ SecurityException -> 0x00c1 }
            r3 = 65;
            r0 = r0.zza(r1, r2, r4, r3);	 Catch:{ SecurityException -> 0x00c1 }
            if (r0 == 0) goto L_0x00a2;
        L_0x009e:
            monitor-exit(r4);
            return;
        L_0x00a0:
            r0 = 0;
            goto L_0x006f;
        L_0x00a2:
            r0 = "EnhancedIntentService";
            r1 = "binding to the service failed";
            android.util.Log.e(r0, r1);	 Catch:{ SecurityException -> 0x00c1 }
        L_0x00a9:
            r0 = r4.f4557c;	 Catch:{ all -> 0x005c }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x009e;
        L_0x00b1:
            r0 = r4.f4557c;	 Catch:{ all -> 0x005c }
            r0 = r0.poll();	 Catch:{ all -> 0x005c }
            r0 = (android.util.Pair) r0;	 Catch:{ all -> 0x005c }
            r0 = r0.second;	 Catch:{ all -> 0x005c }
            r0 = (android.content.BroadcastReceiver.PendingResult) r0;	 Catch:{ all -> 0x005c }
            r0.finish();	 Catch:{ all -> 0x005c }
            goto L_0x00a9;
        L_0x00c1:
            r0 = move-exception;
            r1 = "EnhancedIntentService";
            r2 = "Exception while binding the service";
            android.util.Log.e(r1, r2, r0);	 Catch:{ all -> 0x005c }
            goto L_0x00a9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.b.b.a():void");
        }

        public synchronized void m5148a(Intent intent, PendingResult pendingResult) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
            }
            this.f4557c.add(new Pair(intent, pendingResult));
            m5147a();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                this.f4559e = false;
                this.f4558d = (C1495a) iBinder;
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    String valueOf = String.valueOf(componentName);
                    Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 20).append("onServiceConnected: ").append(valueOf).toString());
                }
                m5147a();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 23).append("onServiceDisconnected: ").append(valueOf).toString());
            }
            m5147a();
        }
    }

    public C1491b() {
        this.f4541c = Executors.newSingleThreadExecutor();
        this.f4540b = new Object();
        this.f4543e = 0;
    }

    private void m5122b(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.f4540b) {
            this.f4543e--;
            if (this.f4543e == 0) {
                m5124b(this.f4542d);
            }
        }
    }

    protected Intent m5123a(Intent intent) {
        return intent;
    }

    boolean m5124b(int i) {
        return stopSelfResult(i);
    }

    public abstract void handleIntent(Intent intent);

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f4539a == null) {
            this.f4539a = new C1495a(this);
        }
        return this.f4539a;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f4540b) {
            this.f4542d = i2;
            this.f4543e++;
        }
        Intent a = m5123a(intent);
        if (a == null) {
            m5122b(intent);
            return 2;
        } else if (zzE(a)) {
            m5122b(intent);
            return 2;
        } else {
            this.f4541c.execute(new C14931(this, a, intent));
            return 3;
        }
    }

    public boolean zzE(Intent intent) {
        return false;
    }
}
