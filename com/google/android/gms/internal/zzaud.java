package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class zzaud extends zzauh {
    private static final AtomicLong zzbtS;
    private ExecutorService zzbtI;
    private zzd zzbtJ;
    private zzd zzbtK;
    private final PriorityBlockingQueue<FutureTask<?>> zzbtL;
    private final BlockingQueue<FutureTask<?>> zzbtM;
    private final UncaughtExceptionHandler zzbtN;
    private final UncaughtExceptionHandler zzbtO;
    private final Object zzbtP;
    private final Semaphore zzbtQ;
    private volatile boolean zzbtR;

    static class zza extends RuntimeException {
    }

    private final class zzb implements UncaughtExceptionHandler {
        private final String zzbtT;
        final /* synthetic */ zzaud zzbtU;

        public zzb(zzaud com_google_android_gms_internal_zzaud, String str) {
            this.zzbtU = com_google_android_gms_internal_zzaud;
            zzac.zzw(str);
            this.zzbtT = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            this.zzbtU.zzKl().zzLY().zzj(this.zzbtT, th);
        }
    }

    private final class zzc<V> extends FutureTask<V> implements Comparable<zzc> {
        private final String zzbtT;
        final /* synthetic */ zzaud zzbtU;
        private final long zzbtV;
        private final boolean zzbtW;

        zzc(zzaud com_google_android_gms_internal_zzaud, Runnable runnable, boolean z, String str) {
            this.zzbtU = com_google_android_gms_internal_zzaud;
            super(runnable, null);
            zzac.zzw(str);
            this.zzbtV = zzaud.zzbtS.getAndIncrement();
            this.zzbtT = str;
            this.zzbtW = z;
            if (this.zzbtV == Long.MAX_VALUE) {
                com_google_android_gms_internal_zzaud.zzKl().zzLY().log("Tasks index overflow");
            }
        }

        zzc(zzaud com_google_android_gms_internal_zzaud, Callable<V> callable, boolean z, String str) {
            this.zzbtU = com_google_android_gms_internal_zzaud;
            super(callable);
            zzac.zzw(str);
            this.zzbtV = zzaud.zzbtS.getAndIncrement();
            this.zzbtT = str;
            this.zzbtW = z;
            if (this.zzbtV == Long.MAX_VALUE) {
                com_google_android_gms_internal_zzaud.zzKl().zzLY().log("Tasks index overflow");
            }
        }

        public /* synthetic */ int compareTo(@NonNull Object obj) {
            return zzb((zzc) obj);
        }

        protected void setException(Throwable th) {
            this.zzbtU.zzKl().zzLY().zzj(this.zzbtT, th);
            if (th instanceof zza) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            }
            super.setException(th);
        }

        public int zzb(@NonNull zzc com_google_android_gms_internal_zzaud_zzc) {
            if (this.zzbtW != com_google_android_gms_internal_zzaud_zzc.zzbtW) {
                return this.zzbtW ? -1 : 1;
            } else {
                if (this.zzbtV < com_google_android_gms_internal_zzaud_zzc.zzbtV) {
                    return -1;
                }
                if (this.zzbtV > com_google_android_gms_internal_zzaud_zzc.zzbtV) {
                    return 1;
                }
                this.zzbtU.zzKl().zzLZ().zzj("Two tasks share the same index. index", Long.valueOf(this.zzbtV));
                return 0;
            }
        }
    }

    private final class zzd extends Thread {
        final /* synthetic */ zzaud zzbtU;
        private final Object zzbtX;
        private final BlockingQueue<FutureTask<?>> zzbtY;

        public zzd(zzaud com_google_android_gms_internal_zzaud, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            this.zzbtU = com_google_android_gms_internal_zzaud;
            zzac.zzw(str);
            zzac.zzw(blockingQueue);
            this.zzbtX = new Object();
            this.zzbtY = blockingQueue;
            setName(str);
        }

        private void zza(InterruptedException interruptedException) {
            this.zzbtU.zzKl().zzMa().zzj(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r4 = this;
            r0 = 0;
            r1 = r0;
        L_0x0002:
            if (r1 != 0) goto L_0x0015;
        L_0x0004:
            r0 = r4.zzbtU;	 Catch:{ InterruptedException -> 0x0010 }
            r0 = r0.zzbtQ;	 Catch:{ InterruptedException -> 0x0010 }
            r0.acquire();	 Catch:{ InterruptedException -> 0x0010 }
            r0 = 1;
            r1 = r0;
            goto L_0x0002;
        L_0x0010:
            r0 = move-exception;
            r4.zza(r0);
            goto L_0x0002;
        L_0x0015:
            r0 = r4.zzbtY;	 Catch:{ all -> 0x0023 }
            r0 = r0.poll();	 Catch:{ all -> 0x0023 }
            r0 = (java.util.concurrent.FutureTask) r0;	 Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x004d;
        L_0x001f:
            r0.run();	 Catch:{ all -> 0x0023 }
            goto L_0x0015;
        L_0x0023:
            r0 = move-exception;
            r1 = r4.zzbtU;
            r1 = r1.zzbtP;
            monitor-enter(r1);
            r2 = r4.zzbtU;	 Catch:{ all -> 0x00e1 }
            r2 = r2.zzbtQ;	 Catch:{ all -> 0x00e1 }
            r2.release();	 Catch:{ all -> 0x00e1 }
            r2 = r4.zzbtU;	 Catch:{ all -> 0x00e1 }
            r2 = r2.zzbtP;	 Catch:{ all -> 0x00e1 }
            r2.notifyAll();	 Catch:{ all -> 0x00e1 }
            r2 = r4.zzbtU;	 Catch:{ all -> 0x00e1 }
            r2 = r2.zzbtJ;	 Catch:{ all -> 0x00e1 }
            if (r4 != r2) goto L_0x00d1;
        L_0x0045:
            r2 = r4.zzbtU;	 Catch:{ all -> 0x00e1 }
            r3 = 0;
            r2.zzbtJ = r3;	 Catch:{ all -> 0x00e1 }
        L_0x004b:
            monitor-exit(r1);	 Catch:{ all -> 0x00e1 }
            throw r0;
        L_0x004d:
            r1 = r4.zzbtX;	 Catch:{ all -> 0x0023 }
            monitor-enter(r1);	 Catch:{ all -> 0x0023 }
            r0 = r4.zzbtY;	 Catch:{ all -> 0x00a6 }
            r0 = r0.peek();	 Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x0067;
        L_0x0058:
            r0 = r4.zzbtU;	 Catch:{ all -> 0x00a6 }
            r0 = r0.zzbtR;	 Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x0067;
        L_0x0060:
            r0 = r4.zzbtX;	 Catch:{ InterruptedException -> 0x00a1 }
            r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
            r0.wait(r2);	 Catch:{ InterruptedException -> 0x00a1 }
        L_0x0067:
            monitor-exit(r1);	 Catch:{ all -> 0x00a6 }
            r0 = r4.zzbtU;	 Catch:{ all -> 0x0023 }
            r1 = r0.zzbtP;	 Catch:{ all -> 0x0023 }
            monitor-enter(r1);	 Catch:{ all -> 0x0023 }
            r0 = r4.zzbtY;	 Catch:{ all -> 0x00ce }
            r0 = r0.peek();	 Catch:{ all -> 0x00ce }
            if (r0 != 0) goto L_0x00cb;
        L_0x0077:
            monitor-exit(r1);	 Catch:{ all -> 0x00ce }
            r0 = r4.zzbtU;
            r1 = r0.zzbtP;
            monitor-enter(r1);
            r0 = r4.zzbtU;	 Catch:{ all -> 0x00b8 }
            r0 = r0.zzbtQ;	 Catch:{ all -> 0x00b8 }
            r0.release();	 Catch:{ all -> 0x00b8 }
            r0 = r4.zzbtU;	 Catch:{ all -> 0x00b8 }
            r0 = r0.zzbtP;	 Catch:{ all -> 0x00b8 }
            r0.notifyAll();	 Catch:{ all -> 0x00b8 }
            r0 = r4.zzbtU;	 Catch:{ all -> 0x00b8 }
            r0 = r0.zzbtJ;	 Catch:{ all -> 0x00b8 }
            if (r4 != r0) goto L_0x00a9;
        L_0x0099:
            r0 = r4.zzbtU;	 Catch:{ all -> 0x00b8 }
            r2 = 0;
            r0.zzbtJ = r2;	 Catch:{ all -> 0x00b8 }
        L_0x009f:
            monitor-exit(r1);	 Catch:{ all -> 0x00b8 }
            return;
        L_0x00a1:
            r0 = move-exception;
            r4.zza(r0);	 Catch:{ all -> 0x00a6 }
            goto L_0x0067;
        L_0x00a6:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00a6 }
            throw r0;	 Catch:{ all -> 0x0023 }
        L_0x00a9:
            r0 = r4.zzbtU;	 Catch:{ all -> 0x00b8 }
            r0 = r0.zzbtK;	 Catch:{ all -> 0x00b8 }
            if (r4 != r0) goto L_0x00bb;
        L_0x00b1:
            r0 = r4.zzbtU;	 Catch:{ all -> 0x00b8 }
            r2 = 0;
            r0.zzbtK = r2;	 Catch:{ all -> 0x00b8 }
            goto L_0x009f;
        L_0x00b8:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00b8 }
            throw r0;
        L_0x00bb:
            r0 = r4.zzbtU;	 Catch:{ all -> 0x00b8 }
            r0 = r0.zzKl();	 Catch:{ all -> 0x00b8 }
            r0 = r0.zzLY();	 Catch:{ all -> 0x00b8 }
            r2 = "Current scheduler thread is neither worker nor network";
            r0.log(r2);	 Catch:{ all -> 0x00b8 }
            goto L_0x009f;
        L_0x00cb:
            monitor-exit(r1);	 Catch:{ all -> 0x00ce }
            goto L_0x0015;
        L_0x00ce:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00ce }
            throw r0;	 Catch:{ all -> 0x0023 }
        L_0x00d1:
            r2 = r4.zzbtU;	 Catch:{ all -> 0x00e1 }
            r2 = r2.zzbtK;	 Catch:{ all -> 0x00e1 }
            if (r4 != r2) goto L_0x00e4;
        L_0x00d9:
            r2 = r4.zzbtU;	 Catch:{ all -> 0x00e1 }
            r3 = 0;
            r2.zzbtK = r3;	 Catch:{ all -> 0x00e1 }
            goto L_0x004b;
        L_0x00e1:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00e1 }
            throw r0;
        L_0x00e4:
            r2 = r4.zzbtU;	 Catch:{ all -> 0x00e1 }
            r2 = r2.zzKl();	 Catch:{ all -> 0x00e1 }
            r2 = r2.zzLY();	 Catch:{ all -> 0x00e1 }
            r3 = "Current scheduler thread is neither worker nor network";
            r2.log(r3);	 Catch:{ all -> 0x00e1 }
            goto L_0x004b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaud.zzd.run():void");
        }

        public void zzhA() {
            synchronized (this.zzbtX) {
                this.zzbtX.notifyAll();
            }
        }
    }

    static {
        zzbtS = new AtomicLong(Long.MIN_VALUE);
    }

    zzaud(zzaue com_google_android_gms_internal_zzaue) {
        super(com_google_android_gms_internal_zzaue);
        this.zzbtP = new Object();
        this.zzbtQ = new Semaphore(2);
        this.zzbtL = new PriorityBlockingQueue();
        this.zzbtM = new LinkedBlockingQueue();
        this.zzbtN = new zzb(this, "Thread death: Uncaught exception on worker thread");
        this.zzbtO = new zzb(this, "Thread death: Uncaught exception on network thread");
    }

    private void zza(zzc<?> com_google_android_gms_internal_zzaud_zzc_) {
        synchronized (this.zzbtP) {
            this.zzbtL.add(com_google_android_gms_internal_zzaud_zzc_);
            if (this.zzbtJ == null) {
                this.zzbtJ = new zzd(this, "Measurement Worker", this.zzbtL);
                this.zzbtJ.setUncaughtExceptionHandler(this.zzbtN);
                this.zzbtJ.start();
            } else {
                this.zzbtJ.zzhA();
            }
        }
    }

    private void zza(FutureTask<?> futureTask) {
        synchronized (this.zzbtP) {
            this.zzbtM.add(futureTask);
            if (this.zzbtK == null) {
                this.zzbtK = new zzd(this, "Measurement Network", this.zzbtM);
                this.zzbtK.setUncaughtExceptionHandler(this.zzbtO);
                this.zzbtK.start();
            } else {
                this.zzbtK.zzhA();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzJV() {
        super.zzJV();
    }

    public /* bridge */ /* synthetic */ void zzJW() {
        super.zzJW();
    }

    public void zzJX() {
        if (Thread.currentThread() != this.zzbtK) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public /* bridge */ /* synthetic */ zzatb zzJY() {
        return super.zzJY();
    }

    public /* bridge */ /* synthetic */ zzatf zzJZ() {
        return super.zzJZ();
    }

    public /* bridge */ /* synthetic */ zzauj zzKa() {
        return super.zzKa();
    }

    public /* bridge */ /* synthetic */ zzatu zzKb() {
        return super.zzKb();
    }

    public /* bridge */ /* synthetic */ zzatl zzKc() {
        return super.zzKc();
    }

    public /* bridge */ /* synthetic */ zzaul zzKd() {
        return super.zzKd();
    }

    public /* bridge */ /* synthetic */ zzauk zzKe() {
        return super.zzKe();
    }

    public /* bridge */ /* synthetic */ zzatv zzKf() {
        return super.zzKf();
    }

    public /* bridge */ /* synthetic */ zzatj zzKg() {
        return super.zzKg();
    }

    public /* bridge */ /* synthetic */ zzaut zzKh() {
        return super.zzKh();
    }

    public /* bridge */ /* synthetic */ zzauc zzKi() {
        return super.zzKi();
    }

    public /* bridge */ /* synthetic */ zzaun zzKj() {
        return super.zzKj();
    }

    public /* bridge */ /* synthetic */ zzaud zzKk() {
        return super.zzKk();
    }

    public /* bridge */ /* synthetic */ zzatx zzKl() {
        return super.zzKl();
    }

    public /* bridge */ /* synthetic */ zzaua zzKm() {
        return super.zzKm();
    }

    public /* bridge */ /* synthetic */ zzati zzKn() {
        return super.zzKn();
    }

    public boolean zzMq() {
        return Thread.currentThread() == this.zzbtJ;
    }

    ExecutorService zzMr() {
        ExecutorService executorService;
        synchronized (this.zzbtP) {
            if (this.zzbtI == null) {
                this.zzbtI = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.zzbtI;
        }
        return executorService;
    }

    public boolean zzbc() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public <V> Future<V> zzd(Callable<V> callable) {
        zzob();
        zzac.zzw(callable);
        zzc com_google_android_gms_internal_zzaud_zzc = new zzc(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzbtJ) {
            com_google_android_gms_internal_zzaud_zzc.run();
        } else {
            zza(com_google_android_gms_internal_zzaud_zzc);
        }
        return com_google_android_gms_internal_zzaud_zzc;
    }

    public <V> Future<V> zze(Callable<V> callable) {
        zzob();
        zzac.zzw(callable);
        zzc com_google_android_gms_internal_zzaud_zzc = new zzc(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzbtJ) {
            com_google_android_gms_internal_zzaud_zzc.run();
        } else {
            zza(com_google_android_gms_internal_zzaud_zzc);
        }
        return com_google_android_gms_internal_zzaud_zzc;
    }

    public void zzm(Runnable runnable) {
        zzob();
        zzac.zzw(runnable);
        zza(new zzc(this, runnable, false, "Task exception on worker thread"));
    }

    public void zzmR() {
        if (Thread.currentThread() != this.zzbtJ) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    protected void zzmS() {
    }

    public void zzn(Runnable runnable) {
        zzob();
        zzac.zzw(runnable);
        zza(new zzc(this, runnable, false, "Task exception on network thread"));
    }

    public /* bridge */ /* synthetic */ zze zznR() {
        return super.zznR();
    }
}
