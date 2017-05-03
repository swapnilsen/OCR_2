package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzf;
import com.google.android.gms.internal.zzaj.zzi;
import com.google.android.gms.internal.zzaj.zzj;
import com.google.android.gms.internal.zzbjf;
import com.google.android.gms.internal.zzbjf.zzc;
import com.google.android.gms.internal.zzbjf.zzg;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final Context mContext;
    private final String zzbEU;
    private final DataLayer zzbEV;
    private zzcx zzbEW;
    private Map<String, FunctionCallMacroCallback> zzbEX;
    private Map<String, FunctionCallTagCallback> zzbEY;
    private volatile long zzbEZ;
    private volatile String zzbFa;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class zza implements com.google.android.gms.tagmanager.zzu.zza {
        final /* synthetic */ Container zzbFb;

        private zza(Container container) {
            this.zzbFb = container;
        }

        public Object zze(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzgS = this.zzbFb.zzgS(str);
            return zzgS == null ? null : zzgS.getValue(str, map);
        }
    }

    private class zzb implements com.google.android.gms.tagmanager.zzu.zza {
        final /* synthetic */ Container zzbFb;

        private zzb(Container container) {
            this.zzbFb = container;
        }

        public Object zze(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzgT = this.zzbFb.zzgT(str);
            if (zzgT != null) {
                zzgT.execute(str, map);
            }
            return zzdl.zzRQ();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzj com_google_android_gms_internal_zzaj_zzj) {
        this.zzbEX = new HashMap();
        this.zzbEY = new HashMap();
        this.zzbFa = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.mContext = context;
        this.zzbEV = dataLayer;
        this.zzbEU = str;
        this.zzbEZ = j;
        zza(com_google_android_gms_internal_zzaj_zzj.zzlr);
        if (com_google_android_gms_internal_zzaj_zzj.zzlq != null) {
            zza(com_google_android_gms_internal_zzaj_zzj.zzlq);
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzc com_google_android_gms_internal_zzbjf_zzc) {
        this.zzbEX = new HashMap();
        this.zzbEY = new HashMap();
        this.zzbFa = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.mContext = context;
        this.zzbEV = dataLayer;
        this.zzbEU = str;
        this.zzbEZ = j;
        zza(com_google_android_gms_internal_zzbjf_zzc);
    }

    private synchronized zzcx zzQg() {
        return this.zzbEW;
    }

    private void zza(zzf com_google_android_gms_internal_zzaj_zzf) {
        if (com_google_android_gms_internal_zzaj_zzf == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzbjf.zzb(com_google_android_gms_internal_zzaj_zzf));
        } catch (zzg e) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzaj_zzf);
            String valueOf2 = String.valueOf(e.toString());
            zzbo.m4711e(new StringBuilder((String.valueOf(valueOf).length() + 46) + String.valueOf(valueOf2).length()).append("Not loading resource: ").append(valueOf).append(" because it is invalid: ").append(valueOf2).toString());
        }
    }

    private void zza(zzc com_google_android_gms_internal_zzbjf_zzc) {
        this.zzbFa = com_google_android_gms_internal_zzbjf_zzc.getVersion();
        zzc com_google_android_gms_internal_zzbjf_zzc2 = com_google_android_gms_internal_zzbjf_zzc;
        zza(new zzcx(this.mContext, com_google_android_gms_internal_zzbjf_zzc2, this.zzbEV, new zza(), new zzb(), zzgV(this.zzbFa)));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzbEV.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzbEU));
        }
    }

    private synchronized void zza(zzcx com_google_android_gms_tagmanager_zzcx) {
        this.zzbEW = com_google_android_gms_tagmanager_zzcx;
    }

    private void zza(zzi[] com_google_android_gms_internal_zzaj_zziArr) {
        List arrayList = new ArrayList();
        for (Object add : com_google_android_gms_internal_zzaj_zziArr) {
            arrayList.add(add);
        }
        zzQg().zzQ(arrayList);
    }

    public boolean getBoolean(String str) {
        zzcx zzQg = zzQg();
        if (zzQg == null) {
            zzbo.m4711e("getBoolean called for closed container.");
            return zzdl.zzRO().booleanValue();
        }
        try {
            return zzdl.zzi((com.google.android.gms.internal.zzak.zza) zzQg.zzhq(str).getObject()).booleanValue();
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbo.m4711e(new StringBuilder(String.valueOf(valueOf).length() + 66).append("Calling getBoolean() threw an exception: ").append(valueOf).append(" Returning default value.").toString());
            return zzdl.zzRO().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzbEU;
    }

    public double getDouble(String str) {
        zzcx zzQg = zzQg();
        if (zzQg == null) {
            zzbo.m4711e("getDouble called for closed container.");
            return zzdl.zzRN().doubleValue();
        }
        try {
            return zzdl.zzh((com.google.android.gms.internal.zzak.zza) zzQg.zzhq(str).getObject()).doubleValue();
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbo.m4711e(new StringBuilder(String.valueOf(valueOf).length() + 65).append("Calling getDouble() threw an exception: ").append(valueOf).append(" Returning default value.").toString());
            return zzdl.zzRN().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzbEZ;
    }

    public long getLong(String str) {
        zzcx zzQg = zzQg();
        if (zzQg == null) {
            zzbo.m4711e("getLong called for closed container.");
            return zzdl.zzRM().longValue();
        }
        try {
            return zzdl.zzg((com.google.android.gms.internal.zzak.zza) zzQg.zzhq(str).getObject()).longValue();
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbo.m4711e(new StringBuilder(String.valueOf(valueOf).length() + 63).append("Calling getLong() threw an exception: ").append(valueOf).append(" Returning default value.").toString());
            return zzdl.zzRM().longValue();
        }
    }

    public String getString(String str) {
        zzcx zzQg = zzQg();
        if (zzQg == null) {
            zzbo.m4711e("getString called for closed container.");
            return zzdl.zzRQ();
        }
        try {
            return zzdl.zze((com.google.android.gms.internal.zzak.zza) zzQg.zzhq(str).getObject());
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbo.m4711e(new StringBuilder(String.valueOf(valueOf).length() + 65).append("Calling getString() threw an exception: ").append(valueOf).append(" Returning default value.").toString());
            return zzdl.zzRQ();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzbEX) {
            this.zzbEX.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzbEY) {
            this.zzbEY.put(str, functionCallTagCallback);
        }
    }

    void release() {
        this.zzbEW = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzbEX) {
            this.zzbEX.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzbEY) {
            this.zzbEY.remove(str);
        }
    }

    public String zzQf() {
        return this.zzbFa;
    }

    FunctionCallMacroCallback zzgS(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzbEX) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zzbEX.get(str);
        }
        return functionCallMacroCallback;
    }

    public FunctionCallTagCallback zzgT(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzbEY) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzbEY.get(str);
        }
        return functionCallTagCallback;
    }

    public void zzgU(String str) {
        zzQg().zzgU(str);
    }

    zzaj zzgV(String str) {
        zzcj.zzRe().zzRf().equals(zza.CONTAINER_DEBUG);
        return new zzbw();
    }
}
