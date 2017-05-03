package com.google.firebase.remoteconfig;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.XmlResourceParser;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.internal.zzadi;
import com.google.android.gms.internal.zzadi.zzb;
import com.google.android.gms.internal.zzado;
import com.google.android.gms.internal.zzblq;
import com.google.android.gms.internal.zzbtl;
import com.google.android.gms.internal.zzbtm;
import com.google.android.gms.internal.zzbtn;
import com.google.android.gms.internal.zzbto;
import com.google.android.gms.internal.zzbtp;
import com.google.android.gms.internal.zzbtq;
import com.google.android.gms.internal.zzbtr;
import com.google.android.gms.internal.zzbts;
import com.google.android.gms.internal.zzbts.zza;
import com.google.android.gms.internal.zzbts.zzc;
import com.google.android.gms.internal.zzbts.zzd;
import com.google.android.gms.internal.zzbts.zze;
import com.google.android.gms.internal.zzbts.zzf;
import com.google.android.gms.internal.zzbxl;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.C1488a;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY;
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;
    private static FirebaseRemoteConfig f4636a;
    private zzbto f4637b;
    private zzbto f4638c;
    private zzbto f4639d;
    private zzbtr f4640e;
    private final Context f4641f;
    private final ReadWriteLock f4642g;

    /* renamed from: com.google.firebase.remoteconfig.FirebaseRemoteConfig.1 */
    class C15121 implements ResultCallback<zzb> {
        final /* synthetic */ TaskCompletionSource f4634a;
        final /* synthetic */ FirebaseRemoteConfig f4635b;

        C15121(FirebaseRemoteConfig firebaseRemoteConfig, TaskCompletionSource taskCompletionSource) {
            this.f4635b = firebaseRemoteConfig;
            this.f4634a = taskCompletionSource;
        }

        public void m5281a(@NonNull zzb com_google_android_gms_internal_zzadi_zzb) {
            this.f4635b.m5293a(this.f4634a, com_google_android_gms_internal_zzadi_zzb);
        }

        public /* synthetic */ void onResult(@NonNull Result result) {
            m5281a((zzb) result);
        }
    }

    static {
        DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[LAST_FETCH_STATUS_NO_FETCH_YET];
    }

    FirebaseRemoteConfig(Context context) {
        this(context, null, null, null, null);
    }

    private FirebaseRemoteConfig(Context context, zzbto com_google_android_gms_internal_zzbto, zzbto com_google_android_gms_internal_zzbto2, zzbto com_google_android_gms_internal_zzbto3, zzbtr com_google_android_gms_internal_zzbtr) {
        this.f4642g = new ReentrantReadWriteLock(true);
        this.f4641f = context;
        if (com_google_android_gms_internal_zzbtr != null) {
            this.f4640e = com_google_android_gms_internal_zzbtr;
        } else {
            this.f4640e = new zzbtr();
        }
        this.f4640e.zzaV(m5282a(this.f4641f));
        if (com_google_android_gms_internal_zzbto != null) {
            this.f4637b = com_google_android_gms_internal_zzbto;
        }
        if (com_google_android_gms_internal_zzbto2 != null) {
            this.f4638c = com_google_android_gms_internal_zzbto2;
        }
        if (com_google_android_gms_internal_zzbto3 != null) {
            this.f4639d = com_google_android_gms_internal_zzbto3;
        }
    }

    private long m5282a(Context context) {
        long j = DEFAULT_VALUE_FOR_LONG;
        try {
            return this.f4641f.getPackageManager().getPackageInfo(context.getPackageName(), LAST_FETCH_STATUS_NO_FETCH_YET).lastUpdateTime;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(context.getPackageName());
            Log.e("FirebaseRemoteConfig", new StringBuilder(String.valueOf(valueOf).length() + 25).append("Package [").append(valueOf).append("] was not found!").toString());
            return j;
        }
    }

    private static long m5283a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        long j = DEFAULT_VALUE_FOR_LONG;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == LAST_FETCH_STATUS_SUCCESS) {
                return j;
            }
            outputStream.write(bArr, LAST_FETCH_STATUS_NO_FETCH_YET, read);
            j += (long) read;
        }
    }

    private static zzbto m5284a(zza com_google_android_gms_internal_zzbts_zza) {
        int i = LAST_FETCH_STATUS_NO_FETCH_YET;
        if (com_google_android_gms_internal_zzbts_zza == null) {
            return null;
        }
        Map hashMap = new HashMap();
        zzd[] com_google_android_gms_internal_zzbts_zzdArr = com_google_android_gms_internal_zzbts_zza.zzcmq;
        int length = com_google_android_gms_internal_zzbts_zzdArr.length;
        for (int i2 = LAST_FETCH_STATUS_NO_FETCH_YET; i2 < length; i2 += VALUE_SOURCE_DEFAULT) {
            zzd com_google_android_gms_internal_zzbts_zzd = com_google_android_gms_internal_zzbts_zzdArr[i2];
            String str = com_google_android_gms_internal_zzbts_zzd.zzaGP;
            Map hashMap2 = new HashMap();
            zzbts.zzb[] com_google_android_gms_internal_zzbts_zzbArr = com_google_android_gms_internal_zzbts_zzd.zzcmy;
            int length2 = com_google_android_gms_internal_zzbts_zzbArr.length;
            for (int i3 = LAST_FETCH_STATUS_NO_FETCH_YET; i3 < length2; i3 += VALUE_SOURCE_DEFAULT) {
                zzbts.zzb com_google_android_gms_internal_zzbts_zzb = com_google_android_gms_internal_zzbts_zzbArr[i3];
                hashMap2.put(com_google_android_gms_internal_zzbts_zzb.zzaB, com_google_android_gms_internal_zzbts_zzb.zzcmt);
            }
            hashMap.put(str, hashMap2);
        }
        byte[][] bArr = com_google_android_gms_internal_zzbts_zza.zzcmr;
        List arrayList = new ArrayList();
        int length3 = bArr.length;
        while (i < length3) {
            arrayList.add(bArr[i]);
            i += VALUE_SOURCE_DEFAULT;
        }
        return new zzbto(hashMap, com_google_android_gms_internal_zzbts_zza.timestamp, arrayList);
    }

    private static zzbtr m5285a(zzc com_google_android_gms_internal_zzbts_zzc) {
        if (com_google_android_gms_internal_zzbts_zzc == null) {
            return null;
        }
        zzbtr com_google_android_gms_internal_zzbtr = new zzbtr();
        com_google_android_gms_internal_zzbtr.zzqJ(com_google_android_gms_internal_zzbts_zzc.zzcmu);
        com_google_android_gms_internal_zzbtr.zzbh(com_google_android_gms_internal_zzbts_zzc.zzcmv);
        com_google_android_gms_internal_zzbtr.zzaW(com_google_android_gms_internal_zzbts_zzc.zzcmw);
        return com_google_android_gms_internal_zzbtr;
    }

    private static Map<String, zzbtl> m5286a(zzf[] com_google_android_gms_internal_zzbts_zzfArr) {
        Map hashMap = new HashMap();
        if (com_google_android_gms_internal_zzbts_zzfArr != null) {
            int length = com_google_android_gms_internal_zzbts_zzfArr.length;
            for (int i = LAST_FETCH_STATUS_NO_FETCH_YET; i < length; i += VALUE_SOURCE_DEFAULT) {
                zzf com_google_android_gms_internal_zzbts_zzf = com_google_android_gms_internal_zzbts_zzfArr[i];
                hashMap.put(com_google_android_gms_internal_zzbts_zzf.zzaGP, new zzbtl(com_google_android_gms_internal_zzbts_zzf.resourceId, com_google_android_gms_internal_zzbts_zzf.zzcmF));
            }
        }
        return hashMap;
    }

    private void m5287a() {
        this.f4642g.readLock().lock();
        try {
            m5289a(new zzbtn(this.f4641f, this.f4637b, this.f4638c, this.f4639d, this.f4640e));
        } finally {
            this.f4642g.readLock().unlock();
        }
    }

    private void m5288a(Context context, List<byte[]> list, long j) {
        m5289a(new zzbtm(context, list, j));
    }

    private void m5289a(Runnable runnable) {
        int i = VERSION.SDK_INT;
        AsyncTask.SERIAL_EXECUTOR.execute(runnable);
    }

    private void m5290a(Map<String, Object> map, String str, boolean z) {
        if (str != null) {
            Object obj = (map == null || map.isEmpty()) ? VALUE_SOURCE_DEFAULT : LAST_FETCH_STATUS_NO_FETCH_YET;
            Map hashMap = new HashMap();
            if (obj == null) {
                for (String str2 : map.keySet()) {
                    Object obj2 = map.get(str2);
                    if (obj2 instanceof String) {
                        hashMap.put(str2, ((String) obj2).getBytes(zzbtq.UTF_8));
                    } else if (obj2 instanceof Long) {
                        hashMap.put(str2, ((Long) obj2).toString().getBytes(zzbtq.UTF_8));
                    } else if (obj2 instanceof Integer) {
                        hashMap.put(str2, ((Integer) obj2).toString().getBytes(zzbtq.UTF_8));
                    } else if (obj2 instanceof Double) {
                        hashMap.put(str2, ((Double) obj2).toString().getBytes(zzbtq.UTF_8));
                    } else if (obj2 instanceof Float) {
                        hashMap.put(str2, ((Float) obj2).toString().getBytes(zzbtq.UTF_8));
                    } else if (obj2 instanceof byte[]) {
                        hashMap.put(str2, (byte[]) obj2);
                    } else if (obj2 instanceof Boolean) {
                        hashMap.put(str2, ((Boolean) obj2).toString().getBytes(zzbtq.UTF_8));
                    } else {
                        throw new IllegalArgumentException("The type of a default value needs to beone of String, Long, Double, Boolean, or byte[].");
                    }
                }
            }
            this.f4642g.writeLock().lock();
            if (obj != null) {
                try {
                    if (this.f4639d == null || !this.f4639d.zzjF(str)) {
                        this.f4642g.writeLock().unlock();
                        return;
                    } else {
                        this.f4639d.zzj(null, str);
                        this.f4639d.setTimestamp(System.currentTimeMillis());
                    }
                } catch (Throwable th) {
                    this.f4642g.writeLock().unlock();
                }
            } else {
                if (this.f4639d == null) {
                    this.f4639d = new zzbto(new HashMap(), System.currentTimeMillis(), null);
                }
                this.f4639d.zzj(hashMap, str);
                this.f4639d.setTimestamp(System.currentTimeMillis());
            }
            if (z) {
                this.f4640e.zzjG(str);
            }
            m5287a();
            this.f4642g.writeLock().unlock();
        }
    }

    private static byte[] m5291a(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m5283a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static zze m5292b(Context context) {
        Throwable e;
        Throwable e2;
        if (context == null) {
            return null;
        }
        FileInputStream openFileInput;
        try {
            openFileInput = context.openFileInput("persisted_config");
            try {
                zzbxl zzaf = zzbxl.zzaf(m5291a((InputStream) openFileInput));
                zze com_google_android_gms_internal_zzbts_zze = new zze();
                com_google_android_gms_internal_zzbts_zze.zzb(zzaf);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (Throwable e3) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e3);
                    }
                }
                return com_google_android_gms_internal_zzbts_zze;
            } catch (FileNotFoundException e4) {
                e2 = e4;
                try {
                    if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                        Log.d("FirebaseRemoteConfig", "Persisted config file was not found.", e2);
                    }
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (Throwable e22) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e22);
                        return null;
                    }
                } catch (Throwable th) {
                    e3 = th;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (Throwable e222) {
                            Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e222);
                        }
                    }
                    throw e3;
                }
            } catch (IOException e5) {
                e222 = e5;
                Log.e("FirebaseRemoteConfig", "Cannot initialize from persisted config.", e222);
                if (openFileInput != null) {
                    return null;
                }
                try {
                    openFileInput.close();
                    return null;
                } catch (Throwable e2222) {
                    Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e2222);
                    return null;
                }
            }
        } catch (FileNotFoundException e6) {
            e2222 = e6;
            openFileInput = null;
            if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                Log.d("FirebaseRemoteConfig", "Persisted config file was not found.", e2222);
            }
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (IOException e7) {
            e2222 = e7;
            openFileInput = null;
            Log.e("FirebaseRemoteConfig", "Cannot initialize from persisted config.", e2222);
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable e22222) {
            openFileInput = null;
            e3 = e22222;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw e3;
        }
    }

    public static FirebaseRemoteConfig getInstance() {
        if (f4636a != null) {
            return f4636a;
        }
        C1488a d = C1488a.m5076d();
        if (d != null) {
            return zzcy(d.m5080a());
        }
        throw new IllegalStateException("FirebaseApp has not been initialized.");
    }

    public static FirebaseRemoteConfig zzcy(Context context) {
        if (f4636a == null) {
            zze b = m5292b(context);
            if (b == null) {
                if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                    Log.d("FirebaseRemoteConfig", "No persisted config was found. Initializing from scratch.");
                }
                f4636a = new FirebaseRemoteConfig(context);
            } else {
                if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                    Log.d("FirebaseRemoteConfig", "Initializing from persisted config.");
                }
                zzbto a = m5284a(b.zzcmz);
                zzbto a2 = m5284a(b.zzcmA);
                zzbto a3 = m5284a(b.zzcmB);
                zzbtr a4 = m5285a(b.zzcmC);
                if (a4 != null) {
                    a4.zzaI(m5286a(b.zzcmD));
                }
                f4636a = new FirebaseRemoteConfig(context, a, a2, a3, a4);
            }
        }
        return f4636a;
    }

    @VisibleForTesting
    void m5293a(TaskCompletionSource<Void> taskCompletionSource, zzb com_google_android_gms_internal_zzadi_zzb) {
        if (com_google_android_gms_internal_zzadi_zzb == null || com_google_android_gms_internal_zzadi_zzb.getStatus() == null) {
            this.f4640e.zzqJ(VALUE_SOURCE_DEFAULT);
            taskCompletionSource.setException(new FirebaseRemoteConfigFetchException());
            m5287a();
            return;
        }
        int statusCode = com_google_android_gms_internal_zzadi_zzb.getStatus().getStatusCode();
        this.f4642g.writeLock().lock();
        Map zzzF;
        Map hashMap;
        Map hashMap2;
        switch (statusCode) {
            case -6508:
            case -6506:
                this.f4640e.zzqJ(LAST_FETCH_STATUS_SUCCESS);
                if (!(this.f4637b == null || this.f4637b.zzacg())) {
                    zzzF = com_google_android_gms_internal_zzadi_zzb.zzzF();
                    hashMap = new HashMap();
                    for (String str : zzzF.keySet()) {
                        hashMap2 = new HashMap();
                        for (String str2 : (Set) zzzF.get(str)) {
                            hashMap2.put(str2, com_google_android_gms_internal_zzadi_zzb.zza(str2, null, str));
                        }
                        hashMap.put(str, hashMap2);
                    }
                    this.f4637b = new zzbto(hashMap, this.f4637b.getTimestamp(), com_google_android_gms_internal_zzadi_zzb.zzzE());
                }
                taskCompletionSource.setResult(null);
                m5287a();
                break;
            case -6505:
                zzzF = com_google_android_gms_internal_zzadi_zzb.zzzF();
                hashMap = new HashMap();
                for (String str3 : zzzF.keySet()) {
                    hashMap2 = new HashMap();
                    for (String str22 : (Set) zzzF.get(str3)) {
                        hashMap2.put(str22, com_google_android_gms_internal_zzadi_zzb.zza(str22, null, str3));
                    }
                    hashMap.put(str3, hashMap2);
                }
                this.f4637b = new zzbto(hashMap, System.currentTimeMillis(), com_google_android_gms_internal_zzadi_zzb.zzzE());
                this.f4640e.zzqJ(LAST_FETCH_STATUS_SUCCESS);
                taskCompletionSource.setResult(null);
                m5287a();
                break;
            case 6500:
            case 6501:
            case 6503:
            case 6504:
                this.f4640e.zzqJ(VALUE_SOURCE_DEFAULT);
                taskCompletionSource.setException(new FirebaseRemoteConfigFetchException());
                m5287a();
                break;
            case 6502:
            case 6507:
                this.f4640e.zzqJ(VALUE_SOURCE_REMOTE);
                taskCompletionSource.setException(new FirebaseRemoteConfigFetchThrottledException(com_google_android_gms_internal_zzadi_zzb.getThrottleEndTimeMillis()));
                m5287a();
                break;
            default:
                try {
                    if (com_google_android_gms_internal_zzadi_zzb.getStatus().isSuccess()) {
                        Log.w("FirebaseRemoteConfig", "Unknown (successful) status code: " + statusCode);
                    }
                    this.f4640e.zzqJ(VALUE_SOURCE_DEFAULT);
                    taskCompletionSource.setException(new FirebaseRemoteConfigFetchException());
                    m5287a();
                    break;
                } catch (Throwable th) {
                    this.f4642g.writeLock().unlock();
                }
        }
        this.f4642g.writeLock().unlock();
    }

    public boolean activateFetched() {
        this.f4642g.writeLock().lock();
        try {
            if (this.f4637b == null) {
                return DEFAULT_VALUE_FOR_BOOLEAN;
            }
            if (this.f4638c == null || this.f4638c.getTimestamp() < this.f4637b.getTimestamp()) {
                long timestamp = this.f4637b.getTimestamp();
                this.f4638c = this.f4637b;
                this.f4638c.setTimestamp(System.currentTimeMillis());
                this.f4637b = new zzbto(null, timestamp, null);
                timestamp = this.f4640e.zzack();
                this.f4640e.zzaW(zzblq.zza(timestamp, this.f4638c.zzzE()));
                m5288a(this.f4641f, this.f4638c.zzzE(), timestamp);
                m5287a();
                this.f4642g.writeLock().unlock();
                return true;
            }
            this.f4642g.writeLock().unlock();
            return DEFAULT_VALUE_FOR_BOOLEAN;
        } finally {
            this.f4642g.writeLock().unlock();
        }
    }

    public Task<Void> fetch() {
        return fetch(43200);
    }

    public Task<Void> fetch(long j) {
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f4642g.readLock().lock();
        try {
            long convert;
            zzadi.zza.zza com_google_android_gms_internal_zzadi_zza_zza = new zzadi.zza.zza();
            com_google_android_gms_internal_zzadi_zza_zza.zzK(j);
            if (this.f4640e.isDeveloperModeEnabled()) {
                com_google_android_gms_internal_zzadi_zza_zza.zzH("_rcn_developer", "true");
            }
            com_google_android_gms_internal_zzadi_zza_zza.zzdr(10300);
            if (!(this.f4638c == null || this.f4638c.getTimestamp() == -1)) {
                convert = TimeUnit.SECONDS.convert(System.currentTimeMillis() - this.f4638c.getTimestamp(), TimeUnit.MILLISECONDS);
                com_google_android_gms_internal_zzadi_zza_zza.zzdt(convert < 2147483647L ? (int) convert : ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
            if (!(this.f4637b == null || this.f4637b.getTimestamp() == -1)) {
                convert = TimeUnit.SECONDS.convert(System.currentTimeMillis() - this.f4637b.getTimestamp(), TimeUnit.MILLISECONDS);
                if (convert < 2147483647L) {
                    i = (int) convert;
                }
                com_google_android_gms_internal_zzadi_zza_zza.zzds(i);
            }
            new zzado(this.f4641f).zza(com_google_android_gms_internal_zzadi_zza_zza.zzzD()).setResultCallback(new C15121(this, taskCompletionSource));
            return taskCompletionSource.getTask();
        } finally {
            this.f4642g.readLock().unlock();
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, "configns:firebase");
    }

    public boolean getBoolean(String str, String str2) {
        Lock lock = true;
        if (str2 == null) {
            return DEFAULT_VALUE_FOR_BOOLEAN;
        }
        this.f4642g.readLock().lock();
        try {
            CharSequence str3;
            if (this.f4638c != null && this.f4638c.zzaA(str, str2)) {
                str3 = new String(this.f4638c.zzaB(str, str2), zzbtq.UTF_8);
                if (zzbtq.zzaII.matcher(str3).matches()) {
                    return lock;
                }
                if (zzbtq.zzaIJ.matcher(str3).matches()) {
                    this.f4642g.readLock().unlock();
                    return DEFAULT_VALUE_FOR_BOOLEAN;
                }
            }
            if (this.f4639d != null && this.f4639d.zzaA(str, str2)) {
                str3 = new String(this.f4639d.zzaB(str, str2), zzbtq.UTF_8);
                if (zzbtq.zzaII.matcher(str3).matches()) {
                    this.f4642g.readLock().unlock();
                    return true;
                } else if (zzbtq.zzaIJ.matcher(str3).matches()) {
                    this.f4642g.readLock().unlock();
                    return DEFAULT_VALUE_FOR_BOOLEAN;
                }
            }
            this.f4642g.readLock().unlock();
            return DEFAULT_VALUE_FOR_BOOLEAN;
        } finally {
            lock = this.f4642g.readLock();
            lock.unlock();
        }
    }

    public byte[] getByteArray(String str) {
        return getByteArray(str, "configns:firebase");
    }

    public byte[] getByteArray(String str, String str2) {
        if (str2 == null) {
            return DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        this.f4642g.readLock().lock();
        byte[] bArr;
        if (this.f4638c == null || !this.f4638c.zzaA(str, str2)) {
            try {
                if (this.f4639d == null || !this.f4639d.zzaA(str, str2)) {
                    bArr = DEFAULT_VALUE_FOR_BYTE_ARRAY;
                    this.f4642g.readLock().unlock();
                    return bArr;
                }
                bArr = this.f4639d.zzaB(str, str2);
                this.f4642g.readLock().unlock();
                return bArr;
            } finally {
                this.f4642g.readLock().unlock();
            }
        } else {
            bArr = this.f4638c.zzaB(str, str2);
            return bArr;
        }
    }

    public double getDouble(String str) {
        return getDouble(str, "configns:firebase");
    }

    public double getDouble(String str, String str2) {
        double d = DEFAULT_VALUE_FOR_DOUBLE;
        if (str2 != null) {
            this.f4642g.readLock().lock();
            try {
                if (this.f4638c != null && this.f4638c.zzaA(str, str2)) {
                    try {
                        d = Double.valueOf(new String(this.f4638c.zzaB(str, str2), zzbtq.UTF_8)).doubleValue();
                    } catch (NumberFormatException e) {
                    }
                }
                if (this.f4639d != null && this.f4639d.zzaA(str, str2)) {
                    try {
                        d = Double.valueOf(new String(this.f4639d.zzaB(str, str2), zzbtq.UTF_8)).doubleValue();
                        this.f4642g.readLock().unlock();
                    } catch (NumberFormatException e2) {
                    }
                }
                this.f4642g.readLock().unlock();
            } finally {
                this.f4642g.readLock().unlock();
            }
        }
        return d;
    }

    public FirebaseRemoteConfigInfo getInfo() {
        FirebaseRemoteConfigInfo com_google_android_gms_internal_zzbtp = new zzbtp();
        this.f4642g.readLock().lock();
        try {
            com_google_android_gms_internal_zzbtp.zzaU(this.f4637b == null ? -1 : this.f4637b.getTimestamp());
            com_google_android_gms_internal_zzbtp.zzqJ(this.f4640e.getLastFetchStatus());
            com_google_android_gms_internal_zzbtp.setConfigSettings(new Builder().setDeveloperModeEnabled(this.f4640e.isDeveloperModeEnabled()).build());
            return com_google_android_gms_internal_zzbtp;
        } finally {
            this.f4642g.readLock().unlock();
        }
    }

    public Set<String> getKeysByPrefix(String str) {
        return getKeysByPrefix(str, "configns:firebase");
    }

    public Set<String> getKeysByPrefix(String str, String str2) {
        this.f4642g.readLock().lock();
        try {
            Set<String> treeSet;
            if (this.f4638c == null) {
                treeSet = new TreeSet();
            } else {
                treeSet = this.f4638c.zzaC(str, str2);
                this.f4642g.readLock().unlock();
            }
            return treeSet;
        } finally {
            this.f4642g.readLock().unlock();
        }
    }

    public long getLong(String str) {
        return getLong(str, "configns:firebase");
    }

    public long getLong(String str, String str2) {
        long j = DEFAULT_VALUE_FOR_LONG;
        if (str2 != null) {
            this.f4642g.readLock().lock();
            try {
                if (this.f4638c != null && this.f4638c.zzaA(str, str2)) {
                    try {
                        j = Long.valueOf(new String(this.f4638c.zzaB(str, str2), zzbtq.UTF_8)).longValue();
                    } catch (NumberFormatException e) {
                    }
                }
                if (this.f4639d != null && this.f4639d.zzaA(str, str2)) {
                    try {
                        j = Long.valueOf(new String(this.f4639d.zzaB(str, str2), zzbtq.UTF_8)).longValue();
                        this.f4642g.readLock().unlock();
                    } catch (NumberFormatException e2) {
                    }
                }
                this.f4642g.readLock().unlock();
            } finally {
                this.f4642g.readLock().unlock();
            }
        }
        return j;
    }

    public String getString(String str) {
        return getString(str, "configns:firebase");
    }

    public String getString(String str, String str2) {
        if (str2 == null) {
            return DEFAULT_VALUE_FOR_STRING;
        }
        this.f4642g.readLock().lock();
        String str3;
        if (this.f4638c == null || !this.f4638c.zzaA(str, str2)) {
            try {
                if (this.f4639d == null || !this.f4639d.zzaA(str, str2)) {
                    str3 = DEFAULT_VALUE_FOR_STRING;
                    this.f4642g.readLock().unlock();
                    return str3;
                }
                str3 = new String(this.f4639d.zzaB(str, str2), zzbtq.UTF_8);
                this.f4642g.readLock().unlock();
                return str3;
            } finally {
                this.f4642g.readLock().unlock();
            }
        } else {
            str3 = new String(this.f4638c.zzaB(str, str2), zzbtq.UTF_8);
            return str3;
        }
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        return getValue(str, "configns:firebase");
    }

    public FirebaseRemoteConfigValue getValue(String str, String str2) {
        if (str2 == null) {
            return new zzbtq(DEFAULT_VALUE_FOR_BYTE_ARRAY, LAST_FETCH_STATUS_NO_FETCH_YET);
        }
        this.f4642g.readLock().lock();
        FirebaseRemoteConfigValue com_google_android_gms_internal_zzbtq;
        if (this.f4638c == null || !this.f4638c.zzaA(str, str2)) {
            try {
                if (this.f4639d == null || !this.f4639d.zzaA(str, str2)) {
                    com_google_android_gms_internal_zzbtq = new zzbtq(DEFAULT_VALUE_FOR_BYTE_ARRAY, LAST_FETCH_STATUS_NO_FETCH_YET);
                    this.f4642g.readLock().unlock();
                    return com_google_android_gms_internal_zzbtq;
                }
                com_google_android_gms_internal_zzbtq = new zzbtq(this.f4639d.zzaB(str, str2), VALUE_SOURCE_DEFAULT);
                this.f4642g.readLock().unlock();
                return com_google_android_gms_internal_zzbtq;
            } finally {
                this.f4642g.readLock().unlock();
            }
        } else {
            com_google_android_gms_internal_zzbtq = new zzbtq(this.f4638c.zzaB(str, str2), VALUE_SOURCE_REMOTE);
            return com_google_android_gms_internal_zzbtq;
        }
    }

    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f4642g.writeLock().lock();
        try {
            boolean isDeveloperModeEnabled = this.f4640e.isDeveloperModeEnabled();
            boolean isDeveloperModeEnabled2 = firebaseRemoteConfigSettings == null ? DEFAULT_VALUE_FOR_BOOLEAN : firebaseRemoteConfigSettings.isDeveloperModeEnabled();
            this.f4640e.zzbh(isDeveloperModeEnabled2);
            if (isDeveloperModeEnabled != isDeveloperModeEnabled2) {
                m5287a();
            }
            this.f4642g.writeLock().unlock();
        } catch (Throwable th) {
            this.f4642g.writeLock().unlock();
        }
    }

    public void setDefaults(int i) {
        setDefaults(i, "configns:firebase");
    }

    public void setDefaults(int i, String str) {
        if (str != null) {
            this.f4642g.readLock().lock();
            try {
                if (!(this.f4640e == null || this.f4640e.zzaci() == null || this.f4640e.zzaci().get(str) == null)) {
                    zzbtl com_google_android_gms_internal_zzbtl = (zzbtl) this.f4640e.zzaci().get(str);
                    if (i == com_google_android_gms_internal_zzbtl.zzacd() && this.f4640e.zzacj() == com_google_android_gms_internal_zzbtl.zzace()) {
                        if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                            Log.d("FirebaseRemoteConfig", "Skipped setting defaults from resource file as this resource file was already applied.");
                        }
                        this.f4642g.readLock().unlock();
                        return;
                    }
                }
                this.f4642g.readLock().unlock();
                Map hashMap = new HashMap();
                try {
                    XmlResourceParser xml = this.f4641f.getResources().getXml(i);
                    Object obj = null;
                    Object obj2 = null;
                    Object obj3 = null;
                    for (int eventType = xml.getEventType(); eventType != VALUE_SOURCE_DEFAULT; eventType = xml.next()) {
                        if (eventType == VALUE_SOURCE_REMOTE) {
                            obj2 = xml.getName();
                        } else if (eventType == 3) {
                            if (!(!"entry".equals(xml.getName()) || obj == null || obj3 == null)) {
                                hashMap.put(obj, obj3);
                                obj3 = null;
                                obj = null;
                            }
                            obj2 = null;
                        } else if (eventType == 4) {
                            if ("key".equals(obj2)) {
                                obj = xml.getText();
                            } else if (Param.VALUE.equals(obj2)) {
                                obj3 = xml.getText();
                            }
                        }
                    }
                    this.f4640e.zza(str, new zzbtl(i, this.f4640e.zzacj()));
                    m5290a(hashMap, str, (boolean) DEFAULT_VALUE_FOR_BOOLEAN);
                } catch (Throwable e) {
                    Log.e("FirebaseRemoteConfig", "Caught exception while parsing XML resource. Skipping setDefaults.", e);
                }
            } catch (Throwable th) {
                this.f4642g.readLock().unlock();
            }
        } else if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
            Log.d("FirebaseRemoteConfig", "namespace cannot be null for setDefaults.");
        }
    }

    public void setDefaults(Map<String, Object> map) {
        setDefaults((Map) map, "configns:firebase");
    }

    public void setDefaults(Map<String, Object> map, String str) {
        m5290a((Map) map, str, true);
    }
}
