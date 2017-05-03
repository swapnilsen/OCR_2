package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzmd.zza;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

@zzme
public class zzmc implements zzmd {
    private static zzmd zzRe;
    private static final Object zztX;
    private final Object zzRf;
    private final String zzRg;
    private final WeakHashMap<Thread, Boolean> zzRh;
    private final zzqh zzuc;

    /* renamed from: com.google.android.gms.internal.zzmc.1 */
    class C13131 implements UncaughtExceptionHandler {
        final /* synthetic */ UncaughtExceptionHandler zzRi;
        final /* synthetic */ zzmc zzRj;

        C13131(zzmc com_google_android_gms_internal_zzmc, UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.zzRj = com_google_android_gms_internal_zzmc;
            this.zzRi = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            try {
                this.zzRj.zza(thread, th);
                if (this.zzRi != null) {
                    this.zzRi.uncaughtException(thread, th);
                }
            } catch (Throwable th2) {
                if (this.zzRi != null) {
                    this.zzRi.uncaughtException(thread, th);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmc.2 */
    class C13142 implements UncaughtExceptionHandler {
        final /* synthetic */ zzmc zzRj;
        final /* synthetic */ UncaughtExceptionHandler zzRk;

        C13142(zzmc com_google_android_gms_internal_zzmc, UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.zzRj = com_google_android_gms_internal_zzmc;
            this.zzRk = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            try {
                this.zzRj.zza(thread, th);
                if (this.zzRk != null) {
                    this.zzRk.uncaughtException(thread, th);
                }
            } catch (Throwable th2) {
                if (this.zzRk != null) {
                    this.zzRk.uncaughtException(thread, th);
                }
            }
        }
    }

    static {
        zztX = new Object();
        zzRe = null;
    }

    zzmc(String str, zzqh com_google_android_gms_internal_zzqh) {
        this.zzRf = new Object();
        this.zzRh = new WeakHashMap();
        this.zzRg = str;
        this.zzuc = com_google_android_gms_internal_zzqh;
        zzjl();
        zzjk();
    }

    public static zzmd zzb(Context context, zzqh com_google_android_gms_internal_zzqh) {
        synchronized (zztX) {
            if (zzRe == null) {
                if (((Boolean) zzgd.zzBm.get()).booleanValue()) {
                    String str = EnvironmentCompat.MEDIA_UNKNOWN;
                    try {
                        str = context.getApplicationContext().getPackageName();
                    } catch (Throwable th) {
                        zzqf.zzbh("Cannot obtain package name, proceeding.");
                    }
                    zzRe = new zzmc(str, com_google_android_gms_internal_zzqh);
                } else {
                    zzRe = new zza();
                }
            }
        }
        return zzRe;
    }

    private Throwable zzd(Throwable th) {
        if (((Boolean) zzgd.zzBn.get()).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3;
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzaI(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    i = 1;
                } else if (zzaJ(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (i != 0) {
                th3 = th2 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th2);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th3 = th2;
            }
            th2 = th3;
        }
        return th2;
    }

    private void zzjk() {
        Thread.setDefaultUncaughtExceptionHandler(new C13131(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private void zzjl() {
        zza(Looper.getMainLooper().getThread());
    }

    String zza(Class cls, Throwable th, String str) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter(FacebookAdapter.KEY_ID, "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", zzw.zzcM().zzkN()).appendQueryParameter("js", this.zzuc.zzba).appendQueryParameter("appid", this.zzRg).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzgd.zzfs())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "149960398").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzw.zzcQ().getSessionId()).toString();
    }

    public void zza(Thread thread) {
        if (thread != null) {
            synchronized (this.zzRf) {
                this.zzRh.put(thread, Boolean.valueOf(true));
            }
            thread.setUncaughtExceptionHandler(new C13142(this, thread.getUncaughtExceptionHandler()));
        }
    }

    protected void zza(Thread thread, Throwable th) {
        if (zzb(th)) {
            zzc(th);
        }
    }

    public void zza(Throwable th, String str) {
        Throwable zzd = zzd(th);
        if (zzd != null) {
            Class cls = th.getClass();
            List arrayList = new ArrayList();
            arrayList.add(zza(cls, zzd, str));
            zzw.zzcM().zza(arrayList, zzw.zzcQ().zzkn());
        }
    }

    protected boolean zzaI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) zzgd.zzBo.get())) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzme.class);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Fail to check class type for class ";
            String valueOf = String.valueOf(str);
            zzqf.zza(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return false;
        }
    }

    protected boolean zzaJ(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }

    protected boolean zzb(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (zzaI(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || r2) {
            z = false;
        }
        return z;
    }

    public void zzc(Throwable th) {
        zza(th, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
    }
}
