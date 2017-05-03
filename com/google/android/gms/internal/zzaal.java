package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class zzaal {
    private final Map<zzaaf<?>, Boolean> zzaBc;
    private final Map<TaskCompletionSource<?>, Boolean> zzaBd;

    /* renamed from: com.google.android.gms.internal.zzaal.1 */
    class C10211 implements zza {
        final /* synthetic */ zzaaf zzaBe;
        final /* synthetic */ zzaal zzaBf;

        C10211(zzaal com_google_android_gms_internal_zzaal, zzaaf com_google_android_gms_internal_zzaaf) {
            this.zzaBf = com_google_android_gms_internal_zzaal;
            this.zzaBe = com_google_android_gms_internal_zzaaf;
        }

        public void zzy(Status status) {
            this.zzaBf.zzaBc.remove(this.zzaBe);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaal.2 */
    class C10222 implements OnCompleteListener<TResult> {
        final /* synthetic */ zzaal zzaBf;
        final /* synthetic */ TaskCompletionSource zzaBg;

        C10222(zzaal com_google_android_gms_internal_zzaal, TaskCompletionSource taskCompletionSource) {
            this.zzaBf = com_google_android_gms_internal_zzaal;
            this.zzaBg = taskCompletionSource;
        }

        public void onComplete(@NonNull Task<TResult> task) {
            this.zzaBf.zzaBd.remove(this.zzaBg);
        }
    }

    public zzaal() {
        this.zzaBc = Collections.synchronizedMap(new WeakHashMap());
        this.zzaBd = Collections.synchronizedMap(new WeakHashMap());
    }

    private void zza(boolean z, Status status) {
        synchronized (this.zzaBc) {
            Map hashMap = new HashMap(this.zzaBc);
        }
        synchronized (this.zzaBd) {
            Map hashMap2 = new HashMap(this.zzaBd);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((zzaaf) entry.getKey()).zzC(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new com.google.android.gms.common.api.zza(status));
            }
        }
    }

    void zza(zzaaf<? extends Result> com_google_android_gms_internal_zzaaf__extends_com_google_android_gms_common_api_Result, boolean z) {
        this.zzaBc.put(com_google_android_gms_internal_zzaaf__extends_com_google_android_gms_common_api_Result, Boolean.valueOf(z));
        com_google_android_gms_internal_zzaaf__extends_com_google_android_gms_common_api_Result.zza(new C10211(this, com_google_android_gms_internal_zzaaf__extends_com_google_android_gms_common_api_Result));
    }

    <TResult> void zza(TaskCompletionSource<TResult> taskCompletionSource, boolean z) {
        this.zzaBd.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.getTask().addOnCompleteListener(new C10222(this, taskCompletionSource));
    }

    boolean zzvY() {
        return (this.zzaBc.isEmpty() && this.zzaBd.isEmpty()) ? false : true;
    }

    public void zzvZ() {
        zza(false, zzaax.zzaCn);
    }

    public void zzwa() {
        zza(true, zzaby.zzaDu);
    }
}
