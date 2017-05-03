package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzru;
import com.google.android.gms.internal.zzrv;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrz;
import com.google.android.gms.internal.zzsb;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.internal.zztm;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzb extends zzrz implements zzi {
    private static DecimalFormat zzabr;
    private final zzsc zzabn;
    private final String zzabs;
    private final Uri zzabt;
    private final boolean zzabu;
    private final boolean zzabv;

    public zzb(zzsc com_google_android_gms_internal_zzsc, String str) {
        this(com_google_android_gms_internal_zzsc, str, true, false);
    }

    public zzb(zzsc com_google_android_gms_internal_zzsc, String str, boolean z, boolean z2) {
        super(com_google_android_gms_internal_zzsc);
        zzac.zzdr(str);
        this.zzabn = com_google_android_gms_internal_zzsc;
        this.zzabs = str;
        this.zzabu = z;
        this.zzabv = z2;
        this.zzabt = zzbq(this.zzabs);
    }

    private static String zzR(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }

    private static void zza(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, zzb(d));
        }
    }

    private static void zza(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void zza(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    static String zzb(double d) {
        if (zzabr == null) {
            zzabr = new DecimalFormat("0.######");
        }
        return zzabr.format(d);
    }

    private static void zzb(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    static Uri zzbq(String str) {
        zzac.zzdr(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    public static Map<String, String> zzc(zze com_google_android_gms_analytics_zze) {
        CharSequence zzao;
        Map hashMap = new HashMap();
        zzro com_google_android_gms_internal_zzro = (zzro) com_google_android_gms_analytics_zze.zza(zzro.class);
        if (com_google_android_gms_internal_zzro != null) {
            for (Entry entry : com_google_android_gms_internal_zzro.zznj().entrySet()) {
                String zzi = zzi(entry.getValue());
                if (zzi != null) {
                    hashMap.put((String) entry.getKey(), zzi);
                }
            }
        }
        zzrt com_google_android_gms_internal_zzrt = (zzrt) com_google_android_gms_analytics_zze.zza(zzrt.class);
        if (com_google_android_gms_internal_zzrt != null) {
            zzb(hashMap, "t", com_google_android_gms_internal_zzrt.zznu());
            zzb(hashMap, "cid", com_google_android_gms_internal_zzrt.zzmy());
            zzb(hashMap, "uid", com_google_android_gms_internal_zzrt.getUserId());
            zzb(hashMap, "sc", com_google_android_gms_internal_zzrt.zznx());
            zza(hashMap, "sf", com_google_android_gms_internal_zzrt.zznz());
            zza(hashMap, "ni", com_google_android_gms_internal_zzrt.zzny());
            zzb(hashMap, "adid", com_google_android_gms_internal_zzrt.zznv());
            zza(hashMap, "ate", com_google_android_gms_internal_zzrt.zznw());
        }
        zzru com_google_android_gms_internal_zzru = (zzru) com_google_android_gms_analytics_zze.zza(zzru.class);
        if (com_google_android_gms_internal_zzru != null) {
            zzb(hashMap, "cd", com_google_android_gms_internal_zzru.zznB());
            zza(hashMap, "a", (double) com_google_android_gms_internal_zzru.zznC());
            zzb(hashMap, "dr", com_google_android_gms_internal_zzru.zznD());
        }
        zzrr com_google_android_gms_internal_zzrr = (zzrr) com_google_android_gms_analytics_zze.zza(zzrr.class);
        if (com_google_android_gms_internal_zzrr != null) {
            zzb(hashMap, "ec", com_google_android_gms_internal_zzrr.getCategory());
            zzb(hashMap, "ea", com_google_android_gms_internal_zzrr.getAction());
            zzb(hashMap, "el", com_google_android_gms_internal_zzrr.getLabel());
            zza(hashMap, "ev", (double) com_google_android_gms_internal_zzrr.getValue());
        }
        zzrl com_google_android_gms_internal_zzrl = (zzrl) com_google_android_gms_analytics_zze.zza(zzrl.class);
        if (com_google_android_gms_internal_zzrl != null) {
            zzb(hashMap, "cn", com_google_android_gms_internal_zzrl.getName());
            zzb(hashMap, "cs", com_google_android_gms_internal_zzrl.getSource());
            zzb(hashMap, "cm", com_google_android_gms_internal_zzrl.zznb());
            zzb(hashMap, "ck", com_google_android_gms_internal_zzrl.zznc());
            zzb(hashMap, "cc", com_google_android_gms_internal_zzrl.getContent());
            zzb(hashMap, "ci", com_google_android_gms_internal_zzrl.getId());
            zzb(hashMap, "anid", com_google_android_gms_internal_zzrl.zznd());
            zzb(hashMap, "gclid", com_google_android_gms_internal_zzrl.zzne());
            zzb(hashMap, "dclid", com_google_android_gms_internal_zzrl.zznf());
            zzb(hashMap, Param.ACLID, com_google_android_gms_internal_zzrl.zzng());
        }
        zzrs com_google_android_gms_internal_zzrs = (zzrs) com_google_android_gms_analytics_zze.zza(zzrs.class);
        if (com_google_android_gms_internal_zzrs != null) {
            zzb(hashMap, "exd", com_google_android_gms_internal_zzrs.getDescription());
            zza(hashMap, "exf", com_google_android_gms_internal_zzrs.zznt());
        }
        zzrv com_google_android_gms_internal_zzrv = (zzrv) com_google_android_gms_analytics_zze.zza(zzrv.class);
        if (com_google_android_gms_internal_zzrv != null) {
            zzb(hashMap, "sn", com_google_android_gms_internal_zzrv.zznE());
            zzb(hashMap, "sa", com_google_android_gms_internal_zzrv.getAction());
            zzb(hashMap, "st", com_google_android_gms_internal_zzrv.getTarget());
        }
        zzrw com_google_android_gms_internal_zzrw = (zzrw) com_google_android_gms_analytics_zze.zza(zzrw.class);
        if (com_google_android_gms_internal_zzrw != null) {
            zzb(hashMap, "utv", com_google_android_gms_internal_zzrw.zznF());
            zza(hashMap, "utt", (double) com_google_android_gms_internal_zzrw.getTimeInMillis());
            zzb(hashMap, "utc", com_google_android_gms_internal_zzrw.getCategory());
            zzb(hashMap, "utl", com_google_android_gms_internal_zzrw.getLabel());
        }
        zzrm com_google_android_gms_internal_zzrm = (zzrm) com_google_android_gms_analytics_zze.zza(zzrm.class);
        if (com_google_android_gms_internal_zzrm != null) {
            for (Entry entry2 : com_google_android_gms_internal_zzrm.zznh().entrySet()) {
                zzao = zzc.zzao(((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(zzao)) {
                    hashMap.put(zzao, (String) entry2.getValue());
                }
            }
        }
        zzrn com_google_android_gms_internal_zzrn = (zzrn) com_google_android_gms_analytics_zze.zza(zzrn.class);
        if (com_google_android_gms_internal_zzrn != null) {
            for (Entry entry22 : com_google_android_gms_internal_zzrn.zzni().entrySet()) {
                zzao = zzc.zzaq(((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(zzao)) {
                    hashMap.put(zzao, zzb(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        zzrq com_google_android_gms_internal_zzrq = (zzrq) com_google_android_gms_analytics_zze.zza(zzrq.class);
        if (com_google_android_gms_internal_zzrq != null) {
            ProductAction zznp = com_google_android_gms_internal_zzrq.zznp();
            if (zznp != null) {
                for (Entry entry3 : zznp.build().entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), (String) entry3.getValue());
                    } else {
                        hashMap.put((String) entry3.getKey(), (String) entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (Promotion zzbM : com_google_android_gms_internal_zzrq.zzns()) {
                hashMap.putAll(zzbM.zzbM(zzc.zzau(i)));
                i++;
            }
            i = 1;
            for (Product zzbM2 : com_google_android_gms_internal_zzrq.zznq()) {
                hashMap.putAll(zzbM2.zzbM(zzc.zzas(i)));
                i++;
            }
            i = 1;
            for (Entry entry222 : com_google_android_gms_internal_zzrq.zznr().entrySet()) {
                List<Product> list = (List) entry222.getValue();
                String zzax = zzc.zzax(i);
                int i2 = 1;
                for (Product zzbM22 : list) {
                    String valueOf = String.valueOf(zzax);
                    String valueOf2 = String.valueOf(zzc.zzav(i2));
                    hashMap.putAll(zzbM22.zzbM(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i2++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry222.getKey())) {
                    String valueOf3 = String.valueOf(zzax);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry222.getKey());
                }
                i++;
            }
        }
        zzrp com_google_android_gms_internal_zzrp = (zzrp) com_google_android_gms_analytics_zze.zza(zzrp.class);
        if (com_google_android_gms_internal_zzrp != null) {
            zzb(hashMap, "ul", com_google_android_gms_internal_zzrp.getLanguage());
            zza(hashMap, "sd", (double) com_google_android_gms_internal_zzrp.zznk());
            zza(hashMap, "sr", com_google_android_gms_internal_zzrp.zznl(), com_google_android_gms_internal_zzrp.zznm());
            zza(hashMap, "vp", com_google_android_gms_internal_zzrp.zznn(), com_google_android_gms_internal_zzrp.zzno());
        }
        zzrk com_google_android_gms_internal_zzrk = (zzrk) com_google_android_gms_analytics_zze.zza(zzrk.class);
        if (com_google_android_gms_internal_zzrk != null) {
            zzb(hashMap, "an", com_google_android_gms_internal_zzrk.zzmY());
            zzb(hashMap, "aid", com_google_android_gms_internal_zzrk.zzke());
            zzb(hashMap, "aiid", com_google_android_gms_internal_zzrk.zzna());
            zzb(hashMap, "av", com_google_android_gms_internal_zzrk.zzmZ());
        }
        return hashMap;
    }

    private static String zzi(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return TextUtils.isEmpty(str) ? null : str;
        } else if (!(obj instanceof Double)) {
            return obj instanceof Boolean ? obj != Boolean.FALSE ? "1" : null : String.valueOf(obj);
        } else {
            Double d = (Double) obj;
            return d.doubleValue() != 0.0d ? zzb(d.doubleValue()) : null;
        }
    }

    public void zzb(zze com_google_android_gms_analytics_zze) {
        zzac.zzw(com_google_android_gms_analytics_zze);
        zzac.zzb(com_google_android_gms_analytics_zze.zzmH(), (Object) "Can't deliver not submitted measurement");
        zzac.zzdk("deliver should be called on worker thread");
        zze zzmC = com_google_android_gms_analytics_zze.zzmC();
        zzrt com_google_android_gms_internal_zzrt = (zzrt) zzmC.zzb(zzrt.class);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzrt.zznu())) {
            zznS().zzg(zzc(zzmC), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(com_google_android_gms_internal_zzrt.zzmy())) {
            zznS().zzg(zzc(zzmC), "Ignoring measurement without client id");
        } else if (!this.zzabn.zzof().getAppOptOut()) {
            double zznz = com_google_android_gms_internal_zzrt.zznz();
            if (zztm.zza(zznz, com_google_android_gms_internal_zzrt.zzmy())) {
                zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zznz));
                return;
            }
            Map zzc = zzc(zzmC);
            zzc.put("v", "1");
            zzc.put("_v", zzsb.zzadQ);
            zzc.put("tid", this.zzabs);
            if (this.zzabn.zzof().isDryRunEnabled()) {
                zzc("Dry run is enabled. GoogleAnalytics would have sent", zzR(zzc));
                return;
            }
            Map hashMap = new HashMap();
            zztm.zzc(hashMap, "uid", com_google_android_gms_internal_zzrt.getUserId());
            zzrk com_google_android_gms_internal_zzrk = (zzrk) com_google_android_gms_analytics_zze.zza(zzrk.class);
            if (com_google_android_gms_internal_zzrk != null) {
                zztm.zzc(hashMap, "an", com_google_android_gms_internal_zzrk.zzmY());
                zztm.zzc(hashMap, "aid", com_google_android_gms_internal_zzrk.zzke());
                zztm.zzc(hashMap, "av", com_google_android_gms_internal_zzrk.zzmZ());
                zztm.zzc(hashMap, "aiid", com_google_android_gms_internal_zzrk.zzna());
            }
            zzc.put("_s", String.valueOf(zzmA().zza(new zzse(0, com_google_android_gms_internal_zzrt.zzmy(), this.zzabs, !TextUtils.isEmpty(com_google_android_gms_internal_zzrt.zznv()), 0, hashMap))));
            zzmA().zza(new zzsz(zznS(), zzc, com_google_android_gms_analytics_zze.zzmF(), true));
        }
    }

    public Uri zzmr() {
        return this.zzabt;
    }
}
