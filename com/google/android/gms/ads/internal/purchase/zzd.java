package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzadg;
import com.google.android.gms.internal.zzld.zza;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqf;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzme
public class zzd extends zza {
    private Context mContext;
    private ArrayList<String> zzPA;
    private String zzPz;
    private String zzwd;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.zzPz = str;
        this.zzPA = arrayList;
        this.zzwd = str2;
        this.mContext = context;
    }

    public String getProductId() {
        return this.zzPz;
    }

    public void recordPlayBillingResolution(int i) {
        if (i == 0) {
            zziK();
        }
        Map zziJ = zziJ();
        zziJ.put("google_play_status", String.valueOf(i));
        zziJ.put("sku", this.zzPz);
        zziJ.put(NotificationCompatApi24.CATEGORY_STATUS, String.valueOf(zzP(i)));
        List linkedList = new LinkedList();
        Iterator it = this.zzPA.iterator();
        while (it.hasNext()) {
            linkedList.add(zzw.zzcM().zzb((String) it.next(), zziJ));
        }
        zzw.zzcM().zza(this.mContext, this.zzwd, linkedList);
    }

    public void recordResolution(int i) {
        if (i == 1) {
            zziK();
        }
        Map zziJ = zziJ();
        zziJ.put(NotificationCompatApi24.CATEGORY_STATUS, String.valueOf(i));
        zziJ.put("sku", this.zzPz);
        List linkedList = new LinkedList();
        Iterator it = this.zzPA.iterator();
        while (it.hasNext()) {
            linkedList.add(zzw.zzcM().zzb((String) it.next(), zziJ));
        }
        zzw.zzcM().zza(this.mContext, this.zzwd, linkedList);
    }

    protected int zzP(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }

    Map<String, String> zziJ() {
        String packageName = this.mContext.getPackageName();
        Object obj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        try {
            obj = zzadg.zzbi(this.mContext).getPackageInfo(packageName, 0).versionName;
        } catch (Throwable e) {
            zzqf.zzc("Error to retrieve app version", e);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzw.zzcQ().zzkj().zzkE();
        Map<String, String> hashMap = new HashMap();
        hashMap.put("sessionid", zzw.zzcQ().getSessionId());
        hashMap.put("appid", packageName);
        hashMap.put("osversion", String.valueOf(VERSION.SDK_INT));
        hashMap.put("sdkversion", this.zzwd);
        hashMap.put("appversion", obj);
        hashMap.put("timestamp", String.valueOf(elapsedRealtime));
        return hashMap;
    }

    void zziK() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.mContext, this.zzPz, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            zzqf.zzbh("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            zzqf.zzbh("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            zzqf.zzc("Fail to report a conversion.", e3);
        }
    }
}
