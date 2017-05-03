package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj extends zzdj {
    private static final String ID;
    private static final String URL;
    private static final String zzbEO;
    private static final String zzbEP;
    static final String zzbEQ;
    private static final Set<String> zzbER;
    private final Context mContext;
    private final zza zzbES;

    public interface zza {
        zzat zzQc();
    }

    /* renamed from: com.google.android.gms.tagmanager.zzj.1 */
    class C14581 implements zza {
        final /* synthetic */ Context zztf;

        C14581(Context context) {
            this.zztf = context;
        }

        public zzat zzQc() {
            return zzaa.zzbT(this.zztf);
        }
    }

    static {
        ID = zzah.ARBITRARY_PIXEL.toString();
        URL = zzai.URL.toString();
        zzbEO = zzai.ADDITIONAL_PARAMS.toString();
        zzbEP = zzai.UNREPEATABLE.toString();
        String str = ID;
        zzbEQ = new StringBuilder(String.valueOf(str).length() + 17).append("gtm_").append(str).append("_unrepeatable").toString();
        zzbER = new HashSet();
    }

    public zzj(Context context) {
        this(context, new C14581(context));
    }

    zzj(Context context, zza com_google_android_gms_tagmanager_zzj_zza) {
        super(ID, URL);
        this.zzbES = com_google_android_gms_tagmanager_zzj_zza;
        this.mContext = context;
    }

    private synchronized boolean zzgO(String str) {
        boolean z = true;
        synchronized (this) {
            if (!zzgQ(str)) {
                if (zzgP(str)) {
                    zzbER.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    public void zzab(Map<String, com.google.android.gms.internal.zzak.zza> map) {
        String zze = map.get(zzbEP) != null ? zzdl.zze((com.google.android.gms.internal.zzak.zza) map.get(zzbEP)) : null;
        if (zze == null || !zzgO(zze)) {
            String valueOf;
            Builder buildUpon = Uri.parse(zzdl.zze((com.google.android.gms.internal.zzak.zza) map.get(URL))).buildUpon();
            com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza = (com.google.android.gms.internal.zzak.zza) map.get(zzbEO);
            if (com_google_android_gms_internal_zzak_zza != null) {
                Object zzj = zzdl.zzj(com_google_android_gms_internal_zzak_zza);
                if (zzj instanceof List) {
                    for (Object zzj2 : (List) zzj2) {
                        if (zzj2 instanceof Map) {
                            for (Entry entry : ((Map) zzj2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            zze = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ";
                            valueOf = String.valueOf(buildUpon.build().toString());
                            zzbo.m4711e(valueOf.length() != 0 ? zze.concat(valueOf) : new String(zze));
                            return;
                        }
                    }
                }
                zze = "ArbitraryPixel: additional params not a list: not sending partial hit: ";
                valueOf = String.valueOf(buildUpon.build().toString());
                zzbo.m4711e(valueOf.length() != 0 ? zze.concat(valueOf) : new String(zze));
                return;
            }
            valueOf = buildUpon.build().toString();
            this.zzbES.zzQc().zzhf(valueOf);
            String str = "ArbitraryPixel: url = ";
            valueOf = String.valueOf(valueOf);
            zzbo.m4712v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            if (zze != null) {
                synchronized (zzj.class) {
                    zzbER.add(zze);
                    zzdd.zzd(this.mContext, zzbEQ, zze, "true");
                }
            }
        }
    }

    boolean zzgP(String str) {
        return this.mContext.getSharedPreferences(zzbEQ, 0).contains(str);
    }

    boolean zzgQ(String str) {
        return zzbER.contains(str);
    }
}
