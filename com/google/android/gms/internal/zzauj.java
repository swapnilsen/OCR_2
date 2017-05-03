package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import com.google.android.gms.measurement.AppMeasurement.zzc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class zzauj extends zzauh {
    protected zza zzbuV;
    private zzb zzbuW;
    private final Set<zzc> zzbuX;
    private boolean zzbuY;
    private String zzbuZ;
    private String zzbva;

    /* renamed from: com.google.android.gms.internal.zzauj.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ AtomicReference zzbvd;
        final /* synthetic */ boolean zzbve;

        AnonymousClass10(zzauj com_google_android_gms_internal_zzauj, AtomicReference atomicReference, boolean z) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbvd = atomicReference;
            this.zzbve = z;
        }

        public void run() {
            this.zzbvb.zzKd().zza(this.zzbvd, this.zzbve);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.12 */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ AtomicReference zzbvd;

        AnonymousClass12(zzauj com_google_android_gms_internal_zzauj, AtomicReference atomicReference) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbvd = atomicReference;
        }

        public void run() {
            this.zzbvb.zzKd().zza(this.zzbvd);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.1 */
    class C10821 implements Runnable {
        final /* synthetic */ boolean zzaiP;
        final /* synthetic */ zzauj zzbvb;

        C10821(zzauj com_google_android_gms_internal_zzauj, boolean z) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzaiP = z;
        }

        public void run() {
            this.zzbvb.zzaM(this.zzaiP);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.2 */
    class C10832 implements Runnable {
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ ConditionalUserProperty zzbvc;

        C10832(zzauj com_google_android_gms_internal_zzauj, ConditionalUserProperty conditionalUserProperty) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbvc = conditionalUserProperty;
        }

        public void run() {
            this.zzbvb.zzb(this.zzbvc);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.3 */
    class C10843 implements Runnable {
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ ConditionalUserProperty zzbvc;

        C10843(zzauj com_google_android_gms_internal_zzauj, ConditionalUserProperty conditionalUserProperty) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbvc = conditionalUserProperty;
        }

        public void run() {
            this.zzbvb.zzc(this.zzbvc);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.4 */
    class C10854 implements Runnable {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ String zzbuP;
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ AtomicReference zzbvd;

        C10854(zzauj com_google_android_gms_internal_zzauj, AtomicReference atomicReference, String str, String str2, String str3) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbvd = atomicReference;
            this.zzbkW = str;
            this.zzbuO = str2;
            this.zzbuP = str3;
        }

        public void run() {
            this.zzbvb.zzbqc.zzKd().zza(this.zzbvd, this.zzbkW, this.zzbuO, this.zzbuP);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.5 */
    class C10865 implements Runnable {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ String zzbuP;
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ AtomicReference zzbvd;
        final /* synthetic */ boolean zzbve;

        C10865(zzauj com_google_android_gms_internal_zzauj, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbvd = atomicReference;
            this.zzbkW = str;
            this.zzbuO = str2;
            this.zzbuP = str3;
            this.zzbve = z;
        }

        public void run() {
            this.zzbvb.zzbqc.zzKd().zza(this.zzbvd, this.zzbkW, this.zzbuO, this.zzbuP, this.zzbve);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.6 */
    class C10876 implements Runnable {
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ long zzbvf;

        C10876(zzauj com_google_android_gms_internal_zzauj, long j) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbvf = j;
        }

        public void run() {
            this.zzbvb.zzKm().zzbtl.set(this.zzbvf);
            this.zzbvb.zzKl().zzMd().zzj("Minimum session duration set", Long.valueOf(this.zzbvf));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.7 */
    class C10887 implements Runnable {
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ long zzbvf;

        C10887(zzauj com_google_android_gms_internal_zzauj, long j) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbvf = j;
        }

        public void run() {
            this.zzbvb.zzKm().zzbtm.set(this.zzbvf);
            this.zzbvb.zzKl().zzMd().zzj("Session timeout duration set", Long.valueOf(this.zzbvf));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.8 */
    class C10898 implements Runnable {
        final /* synthetic */ String val$name;
        final /* synthetic */ String zzbkW;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ long zzbvg;
        final /* synthetic */ Bundle zzbvh;
        final /* synthetic */ boolean zzbvi;
        final /* synthetic */ boolean zzbvj;
        final /* synthetic */ boolean zzbvk;

        C10898(zzauj com_google_android_gms_internal_zzauj, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbuO = str;
            this.val$name = str2;
            this.zzbvg = j;
            this.zzbvh = bundle;
            this.zzbvi = z;
            this.zzbvj = z2;
            this.zzbvk = z3;
            this.zzbkW = str3;
        }

        public void run() {
            this.zzbvb.zzb(this.zzbuO, this.val$name, this.zzbvg, this.zzbvh, this.zzbvi, this.zzbvj, this.zzbvk, this.zzbkW);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauj.9 */
    class C10909 implements Runnable {
        final /* synthetic */ String val$name;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ zzauj zzbvb;
        final /* synthetic */ long zzbvg;
        final /* synthetic */ Object zzbvl;

        C10909(zzauj com_google_android_gms_internal_zzauj, String str, String str2, Object obj, long j) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
            this.zzbuO = str;
            this.val$name = str2;
            this.zzbvl = obj;
            this.zzbvg = j;
        }

        public void run() {
            this.zzbvb.zza(this.zzbuO, this.val$name, this.zzbvl, this.zzbvg);
        }
    }

    @MainThread
    @TargetApi(14)
    private class zza implements ActivityLifecycleCallbacks {
        final /* synthetic */ zzauj zzbvb;

        private zza(zzauj com_google_android_gms_internal_zzauj) {
            this.zzbvb = com_google_android_gms_internal_zzauj;
        }

        private boolean zzfR(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.zzbvb.zzd("auto", "_ldl", str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                this.zzbvb.zzKl().zzMe().log("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        if (bundle == null) {
                            Bundle zzu = this.zzbvb.zzKh().zzu(data);
                            String str = this.zzbvb.zzKh().zzA(intent) ? "gs" : "auto";
                            if (zzu != null) {
                                this.zzbvb.zze(str, "_cmp", zzu);
                            }
                        }
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            Object obj = (queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content"))) ? 1 : null;
                            if (obj == null) {
                                this.zzbvb.zzKl().zzMd().log("Activity created with data 'referrer' param without gclid and at least one utm field");
                                return;
                            } else {
                                this.zzbvb.zzKl().zzMd().zzj("Activity created with referrer", queryParameter);
                                zzfR(queryParameter);
                            }
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                this.zzbvb.zzKl().zzLY().zzj("Throwable caught in onActivityCreated", th);
            }
            this.zzbvb.zzKe().onActivityCreated(activity, bundle);
        }

        public void onActivityDestroyed(Activity activity) {
            this.zzbvb.zzKe().onActivityDestroyed(activity);
        }

        @MainThread
        public void onActivityPaused(Activity activity) {
            this.zzbvb.zzKe().onActivityPaused(activity);
            this.zzbvb.zzKj().zzNe();
        }

        @MainThread
        public void onActivityResumed(Activity activity) {
            this.zzbvb.zzKe().onActivityResumed(activity);
            this.zzbvb.zzKj().zzNc();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            this.zzbvb.zzKe().onActivitySaveInstanceState(activity, bundle);
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzauj(zzaue com_google_android_gms_internal_zzaue) {
        super(com_google_android_gms_internal_zzaue);
        this.zzbuX = new CopyOnWriteArraySet();
        this.zzbuZ = null;
        this.zzbva = null;
    }

    @WorkerThread
    private void zzMS() {
        try {
            zzf(Class.forName(zzMT()));
        } catch (ClassNotFoundException e) {
            zzKl().zzMc().log("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzMT() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void zza(ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zznR().currentTimeMillis();
        zzac.zzw(conditionalUserProperty);
        zzac.zzdr(conditionalUserProperty.mName);
        zzac.zzdr(conditionalUserProperty.mOrigin);
        zzac.zzw(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzKh().zzfX(str) != 0) {
            zzKl().zzLY().zzj("Invalid conditional user property name", str);
        } else if (zzKh().zzm(str, obj) != 0) {
            zzKl().zzLY().zze("Invalid conditional user property value", str, obj);
        } else {
            Object zzn = zzKh().zzn(str, obj);
            if (zzn == null) {
                zzKl().zzLY().zze("Unable to normalize conditional user property value", str, obj);
                return;
            }
            conditionalUserProperty.mValue = zzn;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (j > zzKn().zzLa() || j < 1) {
                zzKl().zzLY().zze("Invalid conditional user property timeout", str, Long.valueOf(j));
                return;
            }
            j = conditionalUserProperty.mTimeToLive;
            if (j > zzKn().zzLb() || j < 1) {
                zzKl().zzLY().zze("Invalid conditional user property time to live", str, Long.valueOf(j));
            } else {
                zzKk().zzm(new C10832(this, conditionalUserProperty));
            }
        }
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zznR().currentTimeMillis(), bundle, z, z2, z3, str3);
    }

    @WorkerThread
    private void zza(String str, String str2, Object obj, long j) {
        zzac.zzdr(str);
        zzac.zzdr(str2);
        zzmR();
        zzJW();
        zzob();
        if (!this.zzbqc.isEnabled()) {
            zzKl().zzMd().log("User property not set since app measurement is disabled");
        } else if (this.zzbqc.zzMt()) {
            zzKl().zzMd().zze("Setting user property (FE)", str2, obj);
            zzKd().zzb(new zzauq(str2, j, obj, str));
        }
    }

    private void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zznR().currentTimeMillis();
        zzac.zzdr(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzKk().zzm(new C10843(this, conditionalUserProperty));
    }

    @WorkerThread
    private void zzaM(boolean z) {
        zzmR();
        zzJW();
        zzob();
        zzKl().zzMd().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzKm().setMeasurementEnabled(z);
        zzKd().zzMW();
    }

    private Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzbqc.zzKk().zzm(new C10865(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzKl().zzMa().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<zzauq> list = (List) atomicReference.get();
        if (list == null) {
            zzKl().zzMa().log("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        Map<String, Object> arrayMap = new ArrayMap(list.size());
        for (zzauq com_google_android_gms_internal_zzauq : list) {
            arrayMap.put(com_google_android_gms_internal_zzauq.name, com_google_android_gms_internal_zzauq.getValue());
        }
        return arrayMap;
    }

    @WorkerThread
    private void zzb(ConditionalUserProperty conditionalUserProperty) {
        zzmR();
        zzob();
        zzac.zzw(conditionalUserProperty);
        zzac.zzdr(conditionalUserProperty.mName);
        zzac.zzdr(conditionalUserProperty.mOrigin);
        zzac.zzw(conditionalUserProperty.mValue);
        if (this.zzbqc.isEnabled()) {
            zzauq com_google_android_gms_internal_zzauq = new zzauq(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
            try {
                zzatq zza = zzKh().zza(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
                zzatq zza2 = zzKh().zza(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false);
                zzatq zza3 = zzKh().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
                zzauq com_google_android_gms_internal_zzauq2 = com_google_android_gms_internal_zzauq;
                zzKd().zzf(new zzatg(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, com_google_android_gms_internal_zzauq2, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, zza2, conditionalUserProperty.mTriggerTimeout, zza, conditionalUserProperty.mTimeToLive, zza3));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        zzKl().zzMd().log("Conditional property not sent since Firebase Analytics is disabled");
    }

    @WorkerThread
    private void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzac.zzdr(str);
        zzac.zzdr(str2);
        zzac.zzw(bundle);
        zzmR();
        zzob();
        if (this.zzbqc.isEnabled()) {
            if (!this.zzbuY) {
                this.zzbuY = true;
                zzMS();
            }
            boolean equals = "am".equals(str);
            boolean zzgd = zzaut.zzgd(str2);
            if (z && this.zzbuW != null && !zzgd && !equals) {
                zzKl().zzMd().zze("Passing event to registered event handler (FE)", str2, bundle);
                this.zzbuW.zzb(str, str2, bundle, j);
                return;
            } else if (this.zzbqc.zzMt()) {
                int zzfV = zzKh().zzfV(str2);
                if (zzfV != 0) {
                    this.zzbqc.zzKh().zza(zzfV, "_ev", zzKh().zza(str2, zzKn().zzKM(), true), str2 != null ? str2.length() : 0);
                    return;
                }
                bundle.putString("_o", str);
                Bundle zza = zzKh().zza(str2, bundle, zzf.zzx("_o"), z3);
                if (!bundle.containsKey("_sc")) {
                    zzKn().zzLg();
                    AppMeasurement.zzf zzMU = zzKe().zzMU();
                    if (zzMU != null) {
                        zzMU.zzbvz = true;
                    }
                    zzauk.zza(zzMU, zza);
                }
                Bundle zzM = z2 ? zzKh().zzM(zza) : zza;
                zzKl().zzMd().zze("Logging event (FE)", str2, zzM);
                zzKd().zzc(new zzatq(str2, new zzato(zzM), str, j), str3);
                if (!equals) {
                    for (zzc zzc : this.zzbuX) {
                        zzc.zzc(str, str2, new Bundle(zzM), j);
                    }
                    return;
                }
                return;
            } else {
                return;
            }
        }
        zzKl().zzMd().log("Event not sent since app measurement is disabled");
    }

    @WorkerThread
    private void zzc(ConditionalUserProperty conditionalUserProperty) {
        zzmR();
        zzob();
        zzac.zzw(conditionalUserProperty);
        zzac.zzdr(conditionalUserProperty.mName);
        if (this.zzbqc.isEnabled()) {
            zzauq com_google_android_gms_internal_zzauq = new zzauq(conditionalUserProperty.mName, 0, null, null);
            try {
                zzatq zza = zzKh().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false);
                zzauq com_google_android_gms_internal_zzauq2 = com_google_android_gms_internal_zzauq;
                zzKd().zzf(new zzatg(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, com_google_android_gms_internal_zzauq2, conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, zza));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        zzKl().zzMd().log("Conditional property not cleared since Firebase Analytics is disabled");
    }

    private List<ConditionalUserProperty> zzo(String str, String str2, String str3) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzbqc.zzKk().zzm(new C10854(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzKl().zzMa().zze("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List<zzatg> list = (List) atomicReference.get();
        if (list == null) {
            zzKl().zzMa().zzj("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
        for (zzatg com_google_android_gms_internal_zzatg : list) {
            ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = com_google_android_gms_internal_zzatg.zzbqX;
            conditionalUserProperty.mName = com_google_android_gms_internal_zzatg.zzbqW.name;
            conditionalUserProperty.mValue = com_google_android_gms_internal_zzatg.zzbqW.getValue();
            conditionalUserProperty.mActive = com_google_android_gms_internal_zzatg.zzbqY;
            conditionalUserProperty.mTriggerEventName = com_google_android_gms_internal_zzatg.zzbqZ;
            if (com_google_android_gms_internal_zzatg.zzbra != null) {
                conditionalUserProperty.mTimedOutEventName = com_google_android_gms_internal_zzatg.zzbra.name;
                if (com_google_android_gms_internal_zzatg.zzbra.zzbrG != null) {
                    conditionalUserProperty.mTimedOutEventParams = com_google_android_gms_internal_zzatg.zzbra.zzbrG.zzLW();
                }
            }
            conditionalUserProperty.mTriggerTimeout = com_google_android_gms_internal_zzatg.zzbrb;
            if (com_google_android_gms_internal_zzatg.zzbrc != null) {
                conditionalUserProperty.mTriggeredEventName = com_google_android_gms_internal_zzatg.zzbrc.name;
                if (com_google_android_gms_internal_zzatg.zzbrc.zzbrG != null) {
                    conditionalUserProperty.mTriggeredEventParams = com_google_android_gms_internal_zzatg.zzbrc.zzbrG.zzLW();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = com_google_android_gms_internal_zzatg.zzbqW.zzbwc;
            conditionalUserProperty.mTimeToLive = com_google_android_gms_internal_zzatg.zzbrd;
            if (com_google_android_gms_internal_zzatg.zzbre != null) {
                conditionalUserProperty.mExpiredEventName = com_google_android_gms_internal_zzatg.zzbre.name;
                if (com_google_android_gms_internal_zzatg.zzbre.zzbrG != null) {
                    conditionalUserProperty.mExpiredEventParams = com_google_android_gms_internal_zzatg.zzbre.zzbrG.zzLW();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzJW();
        zza(null, str, str2, bundle);
    }

    public void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        zzac.zzdr(str);
        zzJV();
        zza(str, str2, str3, bundle);
    }

    public Task<String> getAppInstanceId() {
        try {
            String zzMl = zzKm().zzMl();
            return zzMl != null ? Tasks.forResult(zzMl) : Tasks.call(zzKk().zzMr(), new Callable<String>() {
                final /* synthetic */ zzauj zzbvb;

                {
                    this.zzbvb = r1;
                }

                public /* synthetic */ Object call() {
                    return zzbY();
                }

                public String zzbY() {
                    String zzMl = this.zzbvb.zzKm().zzMl();
                    if (zzMl == null) {
                        zzMl = this.zzbvb.zzKa().zzar(120000);
                        if (zzMl == null) {
                            throw new TimeoutException();
                        }
                        this.zzbvb.zzKm().zzfJ(zzMl);
                    }
                    return zzMl;
                }
            });
        } catch (Exception e) {
            zzKl().zzMa().log("Failed to schedule task for getAppInstanceId");
            return Tasks.forException(e);
        }
    }

    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        zzJW();
        return zzo(null, str, str2);
    }

    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        zzac.zzdr(str);
        zzJV();
        return zzo(str, str2, str3);
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public int getMaxUserProperties(String str) {
        zzac.zzdr(str);
        return zzKn().zzKY();
    }

    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzJW();
        return zzb(null, str, str2, z);
    }

    public Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        zzac.zzdr(str);
        zzJV();
        return zzb(str, str2, str3, z);
    }

    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        zzac.zzw(conditionalUserProperty);
        zzJW();
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzKl().zzMa().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        zzac.zzw(conditionalUserProperty);
        zzac.zzdr(conditionalUserProperty.mAppId);
        zzJV();
        zza(new ConditionalUserProperty(conditionalUserProperty));
    }

    public void setMeasurementEnabled(boolean z) {
        zzob();
        zzJW();
        zzKk().zzm(new C10821(this, z));
    }

    public void setMinimumSessionDuration(long j) {
        zzJW();
        zzKk().zzm(new C10876(this, j));
    }

    public void setSessionTimeoutDuration(long j) {
        zzJW();
        zzKk().zzm(new C10887(this, j));
    }

    public /* bridge */ /* synthetic */ void zzJV() {
        super.zzJV();
    }

    public /* bridge */ /* synthetic */ void zzJW() {
        super.zzJW();
    }

    public /* bridge */ /* synthetic */ void zzJX() {
        super.zzJX();
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

    @TargetApi(14)
    public void zzMQ() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.zzbuV == null) {
                this.zzbuV = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.zzbuV);
            application.registerActivityLifecycleCallbacks(this.zzbuV);
            zzKl().zzMe().log("Registered activity lifecycle callback");
        }
    }

    @WorkerThread
    public void zzMR() {
        zzmR();
        zzJW();
        zzob();
        if (this.zzbqc.zzMt()) {
            zzKd().zzMR();
            String zzMo = zzKm().zzMo();
            if (!TextUtils.isEmpty(zzMo) && !zzMo.equals(zzKc().zzLS())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", zzMo);
                zze("auto", "_ou", bundle);
            }
        }
    }

    @WorkerThread
    public void zza(zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        zzmR();
        zzJW();
        zzob();
        if (!(com_google_android_gms_measurement_AppMeasurement_zzb == null || com_google_android_gms_measurement_AppMeasurement_zzb == this.zzbuW)) {
            zzac.zza(this.zzbuW == null, (Object) "EventInterceptor already set.");
        }
        this.zzbuW = com_google_android_gms_measurement_AppMeasurement_zzb;
    }

    public void zza(zzc com_google_android_gms_measurement_AppMeasurement_zzc) {
        zzJW();
        zzob();
        zzac.zzw(com_google_android_gms_measurement_AppMeasurement_zzc);
        if (!this.zzbuX.add(com_google_android_gms_measurement_AppMeasurement_zzc)) {
            zzKl().zzMa().log("OnEventListener already registered");
        }
    }

    protected void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzKk().zzm(new C10898(this, str, str2, j, bundle != null ? new Bundle(bundle) : new Bundle(), z, z2, z3, str3));
    }

    void zza(String str, String str2, long j, Object obj) {
        zzKk().zzm(new C10909(this, str, str2, obj, j));
    }

    public void zza(String str, String str2, Bundle bundle, boolean z) {
        zzJW();
        boolean z2 = this.zzbuW == null || zzaut.zzgd(str2);
        zza(str, str2, bundle, true, z2, z, null);
    }

    public List<zzauq> zzaN(boolean z) {
        zzJW();
        zzob();
        zzKl().zzMd().log("Fetching user attributes (FE)");
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzbqc.zzKk().zzm(new AnonymousClass10(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzKl().zzMa().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<zzauq> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzKl().zzMa().log("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    @Nullable
    public String zzar(long j) {
        if (zzKk().zzMq()) {
            zzKl().zzLY().log("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzKk().zzbc()) {
            zzKl().zzLY().log("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                zzKk().zzm(new AnonymousClass12(this, atomicReference));
                try {
                    atomicReference.wait(j);
                } catch (InterruptedException e) {
                    zzKl().zzMa().log("Interrupted waiting for app instance id");
                    return null;
                }
            }
            return (String) atomicReference.get();
        }
    }

    public void zzd(String str, String str2, Bundle bundle, long j) {
        zzJW();
        zza(str, str2, j, bundle, false, true, true, null);
    }

    public void zzd(String str, String str2, Object obj) {
        int i = 0;
        zzac.zzdr(str);
        long currentTimeMillis = zznR().currentTimeMillis();
        int zzfX = zzKh().zzfX(str2);
        String zza;
        if (zzfX != 0) {
            zza = zzKh().zza(str2, zzKn().zzKN(), true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzbqc.zzKh().zza(zzfX, "_ev", zza, i);
        } else if (obj != null) {
            zzfX = zzKh().zzm(str2, obj);
            if (zzfX != 0) {
                zza = zzKh().zza(str2, zzKn().zzKN(), true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzbqc.zzKh().zza(zzfX, "_ev", zza, i);
                return;
            }
            Object zzn = zzKh().zzn(str2, obj);
            if (zzn != null) {
                zza(str, str2, currentTimeMillis, zzn);
            }
        } else {
            zza(str, str2, currentTimeMillis, null);
        }
    }

    public void zze(String str, String str2, Bundle bundle) {
        zzJW();
        boolean z = this.zzbuW == null || zzaut.zzgd(str2);
        zza(str, str2, bundle, true, z, false, null);
    }

    @WorkerThread
    public void zzf(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
        } catch (Exception e) {
            zzKl().zzMa().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    @Nullable
    @WorkerThread
    public synchronized String zzfQ(String str) {
        String zzar;
        zzob();
        zzJW();
        if (str == null || !str.equals(this.zzbva)) {
            zzar = zzar(30000);
            if (zzar == null) {
                zzar = null;
            } else {
                this.zzbva = str;
                this.zzbuZ = zzar;
                zzar = this.zzbuZ;
            }
        } else {
            zzar = this.zzbuZ;
        }
        return zzar;
    }

    public /* bridge */ /* synthetic */ void zzmR() {
        super.zzmR();
    }

    protected void zzmS() {
    }

    public /* bridge */ /* synthetic */ zze zznR() {
        return super.zznR();
    }
}
