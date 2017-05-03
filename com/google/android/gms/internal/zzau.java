package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzag.zza;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class zzau extends zzas {
    private static final String TAG;
    private static long startTime;
    protected static final Object zzpS;
    static boolean zzpT;
    protected static volatile zzbd zzpz;
    protected boolean zzpU;
    protected String zzpV;
    protected boolean zzpW;
    protected boolean zzpX;

    static {
        zzpS = new Object();
        TAG = zzau.class.getSimpleName();
        zzpz = null;
        zzpT = false;
        startTime = 0;
    }

    protected zzau(Context context, String str) {
        super(context);
        this.zzpU = false;
        this.zzpW = false;
        this.zzpX = false;
        this.zzpV = str;
        this.zzpU = false;
    }

    protected zzau(Context context, String str, boolean z) {
        super(context);
        this.zzpU = false;
        this.zzpW = false;
        this.zzpX = false;
        this.zzpV = str;
        this.zzpU = z;
    }

    static zzbe zza(zzbd com_google_android_gms_internal_zzbd, MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        Throwable e;
        Method zzc = com_google_android_gms_internal_zzbd.zzc(zzaz.zzaC(), zzaz.zzaD());
        if (zzc == null || motionEvent == null) {
            throw new zzba();
        }
        try {
            return new zzbe((String) zzc.invoke(null, new Object[]{motionEvent, displayMetrics}));
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new zzba(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new zzba(e);
        }
    }

    protected static synchronized void zza(Context context, boolean z) {
        synchronized (zzau.class) {
            if (!zzpT) {
                startTime = zzbf.zzbb().longValue() / 1000;
                zzpz = zzb(context, z);
                zzpT = true;
            }
        }
    }

    private static void zza(zzbd com_google_android_gms_internal_zzbd) {
        List singletonList = Collections.singletonList(Context.class);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzai(), zzaz.zzaj(), singletonList);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzas(), zzaz.zzat(), singletonList);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzaq(), zzaz.zzar(), singletonList);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzac(), zzaz.zzad(), singletonList);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzam(), zzaz.zzan(), singletonList);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzW(), zzaz.zzX(), singletonList);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzaE(), zzaz.zzaF(), singletonList);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzY(), zzaz.zzZ(), singletonList);
        singletonList = Arrays.asList(new Class[]{MotionEvent.class, DisplayMetrics.class});
        com_google_android_gms_internal_zzbd.zza(zzaz.zzaC(), zzaz.zzaD(), singletonList);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzaA(), zzaz.zzaB(), singletonList);
        com_google_android_gms_internal_zzbd.zza(zzaz.zzag(), zzaz.zzah(), Collections.emptyList());
        com_google_android_gms_internal_zzbd.zza(zzaz.zzay(), zzaz.zzaz(), Collections.emptyList());
        com_google_android_gms_internal_zzbd.zza(zzaz.zzao(), zzaz.zzap(), Collections.emptyList());
        com_google_android_gms_internal_zzbd.zza(zzaz.zzae(), zzaz.zzaf(), Collections.emptyList());
        com_google_android_gms_internal_zzbd.zza(zzaz.zzak(), zzaz.zzal(), Collections.emptyList());
        com_google_android_gms_internal_zzbd.zza(zzaz.zzaw(), zzaz.zzax(), Collections.emptyList());
        com_google_android_gms_internal_zzbd.zza(zzaz.zzaa(), zzaz.zzab(), Arrays.asList(new Class[]{Context.class, Boolean.TYPE}));
        com_google_android_gms_internal_zzbd.zza(zzaz.zzau(), zzaz.zzav(), Arrays.asList(new Class[]{StackTraceElement[].class}));
        com_google_android_gms_internal_zzbd.zza(zzaz.zzaG(), zzaz.zzaH(), Arrays.asList(new Class[]{View.class}));
    }

    private void zza(zzbd com_google_android_gms_internal_zzbd, zza com_google_android_gms_internal_zzag_zza) {
        zza.zza com_google_android_gms_internal_zzag_zza_zza;
        int i = 1;
        try {
            zzbe zza = zza(com_google_android_gms_internal_zzbd, this.zzpF, this.zzpQ);
            com_google_android_gms_internal_zzag_zza.zzbn = zza.zzqI;
            com_google_android_gms_internal_zzag_zza.zzbo = zza.zzqJ;
            com_google_android_gms_internal_zzag_zza.zzbp = zza.zzqK;
            if (this.zzpP) {
                com_google_android_gms_internal_zzag_zza.zzbB = zza.zzcf;
                com_google_android_gms_internal_zzag_zza.zzbC = zza.zzcd;
            }
            com_google_android_gms_internal_zzag_zza_zza = new zza.zza();
            zzbe zzb = zzb(this.zzpF);
            com_google_android_gms_internal_zzag_zza_zza.zzbn = zzb.zzqI;
            com_google_android_gms_internal_zzag_zza_zza.zzbo = zzb.zzqJ;
            com_google_android_gms_internal_zzag_zza_zza.zzci = zzb.zzqK;
            if (this.zzpP) {
                com_google_android_gms_internal_zzag_zza_zza.zzcd = zzb.zzcd;
                com_google_android_gms_internal_zzag_zza_zza.zzcf = zzb.zzcf;
                com_google_android_gms_internal_zzag_zza_zza.zzch = Integer.valueOf(zzb.zzqL.longValue() != 0 ? 1 : 0);
                if (this.zzpI > 0) {
                    com_google_android_gms_internal_zzag_zza_zza.zzce = this.zzpQ != null ? Long.valueOf(Math.round(((double) this.zzpN) / ((double) this.zzpI))) : null;
                    com_google_android_gms_internal_zzag_zza_zza.zzcg = Long.valueOf(Math.round(((double) this.zzpM) / ((double) this.zzpI)));
                }
                com_google_android_gms_internal_zzag_zza_zza.zzck = zzb.zzck;
                com_google_android_gms_internal_zzag_zza_zza.zzcj = zzb.zzcj;
                if (zzb.zzqO.longValue() == 0) {
                    i = 0;
                }
                com_google_android_gms_internal_zzag_zza_zza.zzcl = Integer.valueOf(i);
                if (this.zzpL > 0) {
                    com_google_android_gms_internal_zzag_zza_zza.zzcm = Long.valueOf(this.zzpL);
                }
            }
            com_google_android_gms_internal_zzag_zza.zzbS = com_google_android_gms_internal_zzag_zza_zza;
        } catch (zzba e) {
        }
        if (this.zzpH > 0) {
            com_google_android_gms_internal_zzag_zza.zzbG = Long.valueOf(this.zzpH);
        }
        if (this.zzpI > 0) {
            com_google_android_gms_internal_zzag_zza.zzbF = Long.valueOf(this.zzpI);
        }
        if (this.zzpJ > 0) {
            com_google_android_gms_internal_zzag_zza.zzbE = Long.valueOf(this.zzpJ);
        }
        if (this.zzpK > 0) {
            com_google_android_gms_internal_zzag_zza.zzbH = Long.valueOf(this.zzpK);
        }
        try {
            int size = this.zzpG.size() - 1;
            if (size > 0) {
                com_google_android_gms_internal_zzag_zza.zzbT = new zza.zza[size];
                for (i = 0; i < size; i++) {
                    zzbe zza2 = zza(com_google_android_gms_internal_zzbd, (MotionEvent) this.zzpG.get(i), this.zzpQ);
                    com_google_android_gms_internal_zzag_zza_zza = new zza.zza();
                    com_google_android_gms_internal_zzag_zza_zza.zzbn = zza2.zzqI;
                    com_google_android_gms_internal_zzag_zza_zza.zzbo = zza2.zzqJ;
                    com_google_android_gms_internal_zzag_zza.zzbT[i] = com_google_android_gms_internal_zzag_zza_zza;
                }
            }
        } catch (zzba e2) {
            com_google_android_gms_internal_zzag_zza.zzbT = null;
        }
    }

    protected static zzbd zzb(Context context, boolean z) {
        if (zzpz == null) {
            synchronized (zzpS) {
                if (zzpz == null) {
                    zzbd zza = zzbd.zza(context, zzaz.getKey(), zzaz.zzV(), z);
                    zza(zza);
                    zzpz = zza;
                }
            }
        }
        return zzpz;
    }

    protected long zza(StackTraceElement[] stackTraceElementArr) {
        Throwable e;
        Method zzc = zzpz.zzc(zzaz.zzau(), zzaz.zzav());
        if (zzc == null || stackTraceElementArr == null) {
            throw new zzba();
        }
        try {
            return new zzbb((String) zzc.invoke(null, new Object[]{stackTraceElementArr})).zzqi.longValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new zzba(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new zzba(e);
        }
    }

    protected zza zza(Context context, View view) {
        zza com_google_android_gms_internal_zzag_zza = new zza();
        if (!TextUtils.isEmpty(this.zzpV)) {
            com_google_android_gms_internal_zzag_zza.zzba = this.zzpV;
        }
        zzbd zzb = zzb(context, this.zzpU);
        zzb.zzaZ();
        zzb(zzb, com_google_android_gms_internal_zzag_zza, view);
        zzb.zzba();
        return com_google_android_gms_internal_zzag_zza;
    }

    protected zza zza(Context context, zzae.zza com_google_android_gms_internal_zzae_zza) {
        zza com_google_android_gms_internal_zzag_zza = new zza();
        if (!TextUtils.isEmpty(this.zzpV)) {
            com_google_android_gms_internal_zzag_zza.zzba = this.zzpV;
        }
        zzbd zzb = zzb(context, this.zzpU);
        zzb.zzaZ();
        zza(zzb, com_google_android_gms_internal_zzag_zza, com_google_android_gms_internal_zzae_zza);
        zzb.zzba();
        return com_google_android_gms_internal_zzag_zza;
    }

    protected List<Callable<Void>> zza(zzbd com_google_android_gms_internal_zzbd, zza com_google_android_gms_internal_zzag_zza, View view) {
        ArrayList arrayList = new ArrayList();
        if (com_google_android_gms_internal_zzbd.zzaI() == null) {
            return arrayList;
        }
        int zzQ = com_google_android_gms_internal_zzbd.zzQ();
        arrayList.add(new zzbp(com_google_android_gms_internal_zzbd, com_google_android_gms_internal_zzag_zza));
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new zzbs(com_google_android_gms_internal_zzbd, zzaz.zzao(), zzaz.zzap(), com_google_android_gms_internal_zzag_zza, zzQ, 1));
        arrayList2 = arrayList;
        arrayList2.add(new zzbn(com_google_android_gms_internal_zzbd, zzaz.zzag(), zzaz.zzah(), com_google_android_gms_internal_zzag_zza, startTime, zzQ, 25));
        arrayList2 = arrayList;
        arrayList2.add(new zzbm(com_google_android_gms_internal_zzbd, zzaz.zzae(), zzaz.zzaf(), com_google_android_gms_internal_zzag_zza, zzQ, 44));
        arrayList2 = arrayList;
        arrayList2.add(new zzbh(com_google_android_gms_internal_zzbd, zzaz.zzW(), zzaz.zzX(), com_google_android_gms_internal_zzag_zza, zzQ, 3));
        arrayList2 = arrayList;
        arrayList2.add(new zzbq(com_google_android_gms_internal_zzbd, zzaz.zzak(), zzaz.zzal(), com_google_android_gms_internal_zzag_zza, zzQ, 22));
        arrayList2 = arrayList;
        arrayList2.add(new zzbl(com_google_android_gms_internal_zzbd, zzaz.zzac(), zzaz.zzad(), com_google_android_gms_internal_zzag_zza, zzQ, 5));
        arrayList2 = arrayList;
        arrayList2.add(new zzbx(com_google_android_gms_internal_zzbd, zzaz.zzaE(), zzaz.zzaF(), com_google_android_gms_internal_zzag_zza, zzQ, 48));
        if (((Boolean) zzgd.zzDR.get()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new zzbi(com_google_android_gms_internal_zzbd, zzaz.zzY(), zzaz.zzZ(), com_google_android_gms_internal_zzag_zza, zzQ, 49));
        }
        arrayList2 = arrayList;
        arrayList2.add(new zzbv(com_google_android_gms_internal_zzbd, zzaz.zzaw(), zzaz.zzax(), com_google_android_gms_internal_zzag_zza, zzQ, 51));
        arrayList2 = arrayList;
        arrayList2.add(new zzbu(com_google_android_gms_internal_zzbd, zzaz.zzau(), zzaz.zzav(), com_google_android_gms_internal_zzag_zza, zzQ, 45, new Throwable().getStackTrace()));
        if (((Boolean) zzgd.zzDS.get()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new zzby(com_google_android_gms_internal_zzbd, zzaz.zzaG(), zzaz.zzaH(), com_google_android_gms_internal_zzag_zza, zzQ, 57, view));
        }
        return arrayList;
    }

    protected void zza(zzbd com_google_android_gms_internal_zzbd, zza com_google_android_gms_internal_zzag_zza, zzae.zza com_google_android_gms_internal_zzae_zza) {
        if (com_google_android_gms_internal_zzbd.zzaI() != null) {
            zza(zzb(com_google_android_gms_internal_zzbd, com_google_android_gms_internal_zzag_zza, com_google_android_gms_internal_zzae_zza));
        }
    }

    protected void zza(List<Callable<Void>> list) {
        if (zzpz != null) {
            ExecutorService zzaI = zzpz.zzaI();
            if (zzaI != null && !list.isEmpty()) {
                try {
                    zzaI.invokeAll(list, ((Long) zzgd.zzDO.get()).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable e) {
                    Log.d(TAG, String.format("class methods got exception: %s", new Object[]{zzbf.zza(e)}));
                }
            }
        }
    }

    protected zzbe zzb(MotionEvent motionEvent) {
        Throwable e;
        Method zzc = zzpz.zzc(zzaz.zzaA(), zzaz.zzaB());
        if (zzc == null || motionEvent == null) {
            throw new zzba();
        }
        try {
            return new zzbe((String) zzc.invoke(null, new Object[]{motionEvent, this.zzpQ}));
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new zzba(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new zzba(e);
        }
    }

    protected List<Callable<Void>> zzb(zzbd com_google_android_gms_internal_zzbd, zza com_google_android_gms_internal_zzag_zza, zzae.zza com_google_android_gms_internal_zzae_zza) {
        int zzQ = com_google_android_gms_internal_zzbd.zzQ();
        List arrayList = new ArrayList();
        List list = arrayList;
        list.add(new zzbk(com_google_android_gms_internal_zzbd, zzaz.zzaa(), zzaz.zzab(), com_google_android_gms_internal_zzag_zza, zzQ, 27, com_google_android_gms_internal_zzae_zza));
        list = arrayList;
        list.add(new zzbn(com_google_android_gms_internal_zzbd, zzaz.zzag(), zzaz.zzah(), com_google_android_gms_internal_zzag_zza, startTime, zzQ, 25));
        list = arrayList;
        list.add(new zzbs(com_google_android_gms_internal_zzbd, zzaz.zzao(), zzaz.zzap(), com_google_android_gms_internal_zzag_zza, zzQ, 1));
        list = arrayList;
        list.add(new zzbt(com_google_android_gms_internal_zzbd, zzaz.zzaq(), zzaz.zzar(), com_google_android_gms_internal_zzag_zza, zzQ, 31));
        list = arrayList;
        list.add(new zzbw(com_google_android_gms_internal_zzbd, zzaz.zzay(), zzaz.zzaz(), com_google_android_gms_internal_zzag_zza, zzQ, 33));
        list = arrayList;
        list.add(new zzbj(com_google_android_gms_internal_zzbd, zzaz.zzas(), zzaz.zzat(), com_google_android_gms_internal_zzag_zza, zzQ, 29));
        list = arrayList;
        list.add(new zzbl(com_google_android_gms_internal_zzbd, zzaz.zzac(), zzaz.zzad(), com_google_android_gms_internal_zzag_zza, zzQ, 5));
        list = arrayList;
        list.add(new zzbr(com_google_android_gms_internal_zzbd, zzaz.zzam(), zzaz.zzan(), com_google_android_gms_internal_zzag_zza, zzQ, 12));
        list = arrayList;
        list.add(new zzbh(com_google_android_gms_internal_zzbd, zzaz.zzW(), zzaz.zzX(), com_google_android_gms_internal_zzag_zza, zzQ, 3));
        list = arrayList;
        list.add(new zzbm(com_google_android_gms_internal_zzbd, zzaz.zzae(), zzaz.zzaf(), com_google_android_gms_internal_zzag_zza, zzQ, 44));
        list = arrayList;
        list.add(new zzbq(com_google_android_gms_internal_zzbd, zzaz.zzak(), zzaz.zzal(), com_google_android_gms_internal_zzag_zza, zzQ, 22));
        list = arrayList;
        list.add(new zzbx(com_google_android_gms_internal_zzbd, zzaz.zzaE(), zzaz.zzaF(), com_google_android_gms_internal_zzag_zza, zzQ, 48));
        if (((Boolean) zzgd.zzDQ.get()).booleanValue()) {
            list = arrayList;
            list.add(new zzbi(com_google_android_gms_internal_zzbd, zzaz.zzY(), zzaz.zzZ(), com_google_android_gms_internal_zzag_zza, zzQ, 49));
        }
        list = arrayList;
        list.add(new zzbv(com_google_android_gms_internal_zzbd, zzaz.zzaw(), zzaz.zzax(), com_google_android_gms_internal_zzag_zza, zzQ, 51));
        return arrayList;
    }

    protected void zzb(zzbd com_google_android_gms_internal_zzbd, zza com_google_android_gms_internal_zzag_zza, View view) {
        zza(com_google_android_gms_internal_zzbd, com_google_android_gms_internal_zzag_zza);
        zza(zza(com_google_android_gms_internal_zzbd, com_google_android_gms_internal_zzag_zza, view));
    }
}
