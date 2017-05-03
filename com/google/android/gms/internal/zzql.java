package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@zzme
public class zzql {

    public interface zza<D, R> {
        R apply(D d);
    }

    /* renamed from: com.google.android.gms.internal.zzql.1 */
    class C13831 implements Runnable {
        final /* synthetic */ zzqj zzZd;
        final /* synthetic */ zza zzZe;
        final /* synthetic */ zzqm zzZf;

        C13831(zzqj com_google_android_gms_internal_zzqj, zza com_google_android_gms_internal_zzql_zza, zzqm com_google_android_gms_internal_zzqm) {
            this.zzZd = com_google_android_gms_internal_zzqj;
            this.zzZe = com_google_android_gms_internal_zzql_zza;
            this.zzZf = com_google_android_gms_internal_zzqm;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r0 = r3.zzZd;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r1 = r3.zzZe;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r2 = r3.zzZf;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r2 = r2.get();	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r1 = r1.apply(r2);	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r0.zzh(r1);	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
        L_0x0011:
            return;
        L_0x0012:
            r0 = move-exception;
        L_0x0013:
            r0 = r3.zzZd;
            r1 = 1;
            r0.cancel(r1);
            goto L_0x0011;
        L_0x001a:
            r0 = move-exception;
            goto L_0x0013;
        L_0x001c:
            r0 = move-exception;
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzql.1.run():void");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzql.2 */
    class C13842 implements Runnable {
        final /* synthetic */ AtomicInteger zzZg;
        final /* synthetic */ int zzZh;
        final /* synthetic */ zzqj zzZi;
        final /* synthetic */ List zzZj;

        C13842(AtomicInteger atomicInteger, int i, zzqj com_google_android_gms_internal_zzqj, List list) {
            this.zzZg = atomicInteger;
            this.zzZh = i;
            this.zzZi = com_google_android_gms_internal_zzqj;
            this.zzZj = list;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r2 = this;
            r0 = r2.zzZg;
            r0 = r0.incrementAndGet();
            r1 = r2.zzZh;
            if (r0 < r1) goto L_0x0015;
        L_0x000a:
            r0 = r2.zzZi;	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r1 = r2.zzZj;	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r1 = com.google.android.gms.internal.zzql.zzp(r1);	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r0.zzh(r1);	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
        L_0x0015:
            return;
        L_0x0016:
            r0 = move-exception;
        L_0x0017:
            r1 = "Unable to convert list of futures to a future of list";
            com.google.android.gms.internal.zzqf.zzc(r1, r0);
            goto L_0x0015;
        L_0x001d:
            r0 = move-exception;
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzql.2.run():void");
        }
    }

    public static <A, B> zzqm<B> zza(zzqm<A> com_google_android_gms_internal_zzqm_A, zza<A, B> com_google_android_gms_internal_zzql_zza_A__B) {
        zzqm com_google_android_gms_internal_zzqj = new zzqj();
        com_google_android_gms_internal_zzqm_A.zzc(new C13831(com_google_android_gms_internal_zzqj, com_google_android_gms_internal_zzql_zza_A__B, com_google_android_gms_internal_zzqm_A));
        return com_google_android_gms_internal_zzqj;
    }

    public static <T> T zza(Future<T> future, T t, int i, TimeUnit timeUnit) {
        try {
            t = future.get((long) i, timeUnit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e2) {
        }
        return t;
    }

    public static <V> zzqm<List<V>> zzo(List<zzqm<V>> list) {
        zzqm com_google_android_gms_internal_zzqj = new zzqj();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzqm zzc : list) {
            zzc.zzc(new C13842(atomicInteger, size, com_google_android_gms_internal_zzqj, list));
        }
        return com_google_android_gms_internal_zzqj;
    }

    private static <V> List<V> zzp(List<zzqm<V>> list) {
        List<V> arrayList = new ArrayList();
        for (zzqm com_google_android_gms_internal_zzqm : list) {
            Object obj = com_google_android_gms_internal_zzqm.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
