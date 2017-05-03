package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzme
public class zzqj<T> implements zzqm<T> {
    private T mValue;
    private boolean zzLs;
    private Throwable zzZa;
    private boolean zzZb;
    private final zzqn zzZc;
    private final Object zzrJ;

    public zzqj() {
        this.zzrJ = new Object();
        this.zzZc = new zzqn();
    }

    private boolean zzll() {
        return this.zzZa != null || this.zzZb;
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.zzrJ) {
            if (zzll()) {
                return false;
            }
            this.zzLs = true;
            this.zzZb = true;
            this.zzrJ.notifyAll();
            this.zzZc.zzlm();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.zzrJ) {
            if (!zzll()) {
                try {
                    this.zzrJ.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzZa != null) {
                throw new ExecutionException(this.zzZa);
            } else if (this.zzLs) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.mValue;
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.zzrJ) {
            if (!zzll()) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.zzrJ.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzZa != null) {
                throw new ExecutionException(this.zzZa);
            } else if (!this.zzZb) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.zzLs) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.mValue;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzLs;
        }
        return z;
    }

    public boolean isDone() {
        boolean zzll;
        synchronized (this.zzrJ) {
            zzll = zzll();
        }
        return zzll;
    }

    public void zzc(Runnable runnable) {
        this.zzZc.zzc(runnable);
    }

    public void zzd(Runnable runnable) {
        this.zzZc.zzd(runnable);
    }

    public void zze(Throwable th) {
        synchronized (this.zzrJ) {
            if (this.zzLs) {
            } else if (zzll()) {
                zzw.zzcQ().zza(new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideException");
            } else {
                this.zzZa = th;
                this.zzrJ.notifyAll();
                this.zzZc.zzlm();
            }
        }
    }

    public void zzh(@Nullable T t) {
        synchronized (this.zzrJ) {
            if (this.zzLs) {
            } else if (zzll()) {
                zzw.zzcQ().zza(new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideValue");
            } else {
                this.zzZb = true;
                this.mValue = t;
                this.zzrJ.notifyAll();
                this.zzZc.zzlm();
            }
        }
    }
}
