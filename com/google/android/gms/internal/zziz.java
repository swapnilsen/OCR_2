package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzni.zza;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@zzme
public class zziz {
    private final LinkedList<zzja> zzJb;
    @Nullable
    private zziw zzJc;
    private final Map<zzja, zzjb> zzyE;

    public zziz() {
        this.zzyE = new HashMap();
        this.zzJb = new LinkedList();
    }

    private static void zza(String str, zzja com_google_android_gms_internal_zzja) {
        if (zzqf.zzak(2)) {
            zzpk.m4709v(String.format(str, new Object[]{com_google_android_gms_internal_zzja}));
        }
    }

    private String[] zzai(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private boolean zzaj(String str) {
        try {
            return Pattern.matches((String) zzgd.zzDj.get(), str);
        } catch (Throwable e) {
            zzw.zzcQ().zza(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    static String zzak(String str) {
        try {
            Matcher matcher = Pattern.compile("([^/]+/[0-9]+).*").matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
            }
        } catch (RuntimeException e) {
        }
        return str;
    }

    private static void zzc(Bundle bundle, String str) {
        String[] split = str.split("/", 2);
        if (split.length != 0) {
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            Bundle bundle2 = bundle.getBundle(str2);
            if (bundle2 != null) {
                zzc(bundle2, split[1]);
            }
        }
    }

    private static void zzc(zzec com_google_android_gms_internal_zzec, String str) {
        Bundle bundle = com_google_android_gms_internal_zzec.zzzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean(str, true);
        }
        com_google_android_gms_internal_zzec.extras.putBoolean(str, true);
    }

    private String zzgw() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.zzJb.iterator();
            while (it.hasNext()) {
                stringBuilder.append(Base64.encodeToString(((zzja) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    stringBuilder.append("\u0000");
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
    }

    static Set<String> zzj(zzec com_google_android_gms_internal_zzec) {
        Set<String> hashSet = new HashSet();
        hashSet.addAll(com_google_android_gms_internal_zzec.extras.keySet());
        Bundle bundle = com_google_android_gms_internal_zzec.zzzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    static zzec zzk(zzec com_google_android_gms_internal_zzec) {
        zzec zzn = zzn(com_google_android_gms_internal_zzec);
        zzc(zzn, "_skipMediation");
        return zzn;
    }

    static boolean zzl(zzec com_google_android_gms_internal_zzec) {
        return zzj(com_google_android_gms_internal_zzec).contains("_skipMediation");
    }

    static zzec zzm(zzec com_google_android_gms_internal_zzec) {
        zzec zzn = zzn(com_google_android_gms_internal_zzec);
        for (String str : ((String) zzgd.zzDf.get()).split(",")) {
            zzc(zzn.zzzd, str);
            String str2 = "com.google.ads.mediation.admob.AdMobAdapter/";
            if (str.startsWith(str2)) {
                zzc(zzn.extras, str.replaceFirst(str2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING));
            }
        }
        return zzn;
    }

    static zzec zzn(zzec com_google_android_gms_internal_zzec) {
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        zzec com_google_android_gms_internal_zzec2 = (zzec) zzec.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        if (((Boolean) zzgd.zzCX.get()).booleanValue()) {
            zzec.zzi(com_google_android_gms_internal_zzec2);
        }
        return com_google_android_gms_internal_zzec2;
    }

    void flush() {
        while (this.zzJb.size() > 0) {
            zzja com_google_android_gms_internal_zzja = (zzja) this.zzJb.remove();
            zzjb com_google_android_gms_internal_zzjb = (zzjb) this.zzyE.get(com_google_android_gms_internal_zzja);
            zza("Flushing interstitial queue for %s.", com_google_android_gms_internal_zzja);
            while (com_google_android_gms_internal_zzjb.size() > 0) {
                com_google_android_gms_internal_zzjb.zzo(null).zzJh.zzcm();
            }
            this.zzyE.remove(com_google_android_gms_internal_zzja);
        }
    }

    void restore() {
        Throwable e;
        if (this.zzJc != null) {
            SharedPreferences sharedPreferences = this.zzJc.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            flush();
            try {
                Map hashMap = new HashMap();
                for (Entry entry : sharedPreferences.getAll().entrySet()) {
                    if (!((String) entry.getKey()).equals("PoolKeys")) {
                        zzje zzal = zzje.zzal((String) entry.getValue());
                        zzja com_google_android_gms_internal_zzja = new zzja(zzal.zzum, zzal.zzts, zzal.zzJf);
                        if (!this.zzyE.containsKey(com_google_android_gms_internal_zzja)) {
                            this.zzyE.put(com_google_android_gms_internal_zzja, new zzjb(zzal.zzum, zzal.zzts, zzal.zzJf));
                            hashMap.put(com_google_android_gms_internal_zzja.toString(), com_google_android_gms_internal_zzja);
                            zza("Restored interstitial queue for %s.", com_google_android_gms_internal_zzja);
                        }
                    }
                }
                for (Object obj : zzai(sharedPreferences.getString("PoolKeys", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                    zzja com_google_android_gms_internal_zzja2 = (zzja) hashMap.get(obj);
                    if (this.zzyE.containsKey(com_google_android_gms_internal_zzja2)) {
                        this.zzJb.add(com_google_android_gms_internal_zzja2);
                    }
                }
            } catch (RuntimeException e2) {
                e = e2;
                zzw.zzcQ().zza(e, "InterstitialAdPool.restore");
                zzqf.zzc("Malformed preferences value for InterstitialAdPool.", e);
                this.zzyE.clear();
                this.zzJb.clear();
            } catch (IOException e3) {
                e = e3;
                zzw.zzcQ().zza(e, "InterstitialAdPool.restore");
                zzqf.zzc("Malformed preferences value for InterstitialAdPool.", e);
                this.zzyE.clear();
                this.zzJb.clear();
            }
        }
    }

    void save() {
        if (this.zzJc != null) {
            Editor edit = this.zzJc.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Entry entry : this.zzyE.entrySet()) {
                zzja com_google_android_gms_internal_zzja = (zzja) entry.getKey();
                zzjb com_google_android_gms_internal_zzjb = (zzjb) entry.getValue();
                if (com_google_android_gms_internal_zzjb.zzgB()) {
                    edit.putString(com_google_android_gms_internal_zzja.toString(), new zzje(com_google_android_gms_internal_zzjb).zzgL());
                    zza("Saved interstitial queue for %s.", com_google_android_gms_internal_zzja);
                }
            }
            edit.putString("PoolKeys", zzgw());
            edit.apply();
        }
    }

    @Nullable
    zza zza(zzec com_google_android_gms_internal_zzec, String str) {
        if (zzaj(str)) {
            return null;
        }
        zzjb com_google_android_gms_internal_zzjb;
        int i = new zza(this.zzJc.getApplicationContext()).zzjC().zzUQ;
        zzec zzm = zzm(com_google_android_gms_internal_zzec);
        String zzak = zzak(str);
        zzja com_google_android_gms_internal_zzja = new zzja(zzm, zzak, i);
        zzjb com_google_android_gms_internal_zzjb2 = (zzjb) this.zzyE.get(com_google_android_gms_internal_zzja);
        if (com_google_android_gms_internal_zzjb2 == null) {
            zza("Interstitial pool created at %s.", com_google_android_gms_internal_zzja);
            com_google_android_gms_internal_zzjb2 = new zzjb(zzm, zzak, i);
            this.zzyE.put(com_google_android_gms_internal_zzja, com_google_android_gms_internal_zzjb2);
            com_google_android_gms_internal_zzjb = com_google_android_gms_internal_zzjb2;
        } else {
            com_google_android_gms_internal_zzjb = com_google_android_gms_internal_zzjb2;
        }
        this.zzJb.remove(com_google_android_gms_internal_zzja);
        this.zzJb.add(com_google_android_gms_internal_zzja);
        com_google_android_gms_internal_zzjb.zzgA();
        while (this.zzJb.size() > ((Integer) zzgd.zzDg.get()).intValue()) {
            zzja com_google_android_gms_internal_zzja2 = (zzja) this.zzJb.remove();
            zzjb com_google_android_gms_internal_zzjb3 = (zzjb) this.zzyE.get(com_google_android_gms_internal_zzja2);
            zza("Evicting interstitial queue for %s.", com_google_android_gms_internal_zzja2);
            while (com_google_android_gms_internal_zzjb3.size() > 0) {
                zza zzo = com_google_android_gms_internal_zzjb3.zzo(null);
                if (zzo.zzJl) {
                    zzjc.zzgC().zzgE();
                }
                zzo.zzJh.zzcm();
            }
            this.zzyE.remove(com_google_android_gms_internal_zzja2);
        }
        while (com_google_android_gms_internal_zzjb.size() > 0) {
            zza zzo2 = com_google_android_gms_internal_zzjb.zzo(zzm);
            if (!zzo2.zzJl || zzw.zzcS().currentTimeMillis() - zzo2.zzJk <= 1000 * ((long) ((Integer) zzgd.zzDi.get()).intValue())) {
                String str2 = zzo2.zzJi != null ? " (inline) " : " ";
                zza(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), com_google_android_gms_internal_zzja);
                return zzo2;
            }
            zza("Expired interstitial at %s.", com_google_android_gms_internal_zzja);
            zzjc.zzgC().zzgD();
        }
        return null;
    }

    void zza(zziw com_google_android_gms_internal_zziw) {
        if (this.zzJc == null) {
            this.zzJc = com_google_android_gms_internal_zziw.zzgu();
            restore();
        }
    }

    void zzb(zzec com_google_android_gms_internal_zzec, String str) {
        if (this.zzJc != null) {
            int i = new zza(this.zzJc.getApplicationContext()).zzjC().zzUQ;
            zzec zzm = zzm(com_google_android_gms_internal_zzec);
            String zzak = zzak(str);
            zzja com_google_android_gms_internal_zzja = new zzja(zzm, zzak, i);
            zzjb com_google_android_gms_internal_zzjb = (zzjb) this.zzyE.get(com_google_android_gms_internal_zzja);
            if (com_google_android_gms_internal_zzjb == null) {
                zza("Interstitial pool created at %s.", com_google_android_gms_internal_zzja);
                com_google_android_gms_internal_zzjb = new zzjb(zzm, zzak, i);
                this.zzyE.put(com_google_android_gms_internal_zzja, com_google_android_gms_internal_zzjb);
            }
            com_google_android_gms_internal_zzjb.zza(this.zzJc, com_google_android_gms_internal_zzec);
            com_google_android_gms_internal_zzjb.zzgA();
            zza("Inline entry added to the queue at %s.", com_google_android_gms_internal_zzja);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void zzgv() {
        /*
        r9 = this;
        r8 = 2;
        r0 = r9.zzJc;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = r9.zzyE;
        r0 = r0.entrySet();
        r4 = r0.iterator();
    L_0x0010:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0088;
    L_0x0016:
        r0 = r4.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (com.google.android.gms.internal.zzja) r1;
        r0 = r0.getValue();
        r0 = (com.google.android.gms.internal.zzjb) r0;
        r2 = com.google.android.gms.internal.zzqf.zzak(r8);
        if (r2 == 0) goto L_0x0056;
    L_0x002e:
        r2 = r0.size();
        r3 = r0.zzgy();
        if (r3 >= r2) goto L_0x0056;
    L_0x0038:
        r5 = "Loading %s/%s pooled interstitials for %s.";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r3 = r2 - r3;
        r3 = java.lang.Integer.valueOf(r3);
        r6[r7] = r3;
        r3 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r3] = r2;
        r6[r8] = r1;
        r2 = java.lang.String.format(r5, r6);
        com.google.android.gms.internal.zzpk.m4709v(r2);
    L_0x0056:
        r2 = r0.zzgz();
        r2 = r2 + 0;
        r3 = r2;
    L_0x005d:
        r5 = r0.size();
        r2 = com.google.android.gms.internal.zzgd.zzDh;
        r2 = r2.get();
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        if (r5 >= r2) goto L_0x0080;
    L_0x006f:
        r2 = "Pooling and loading one new interstitial for %s.";
        zza(r2, r1);
        r2 = r9.zzJc;
        r2 = r0.zzb(r2);
        if (r2 == 0) goto L_0x005d;
    L_0x007c:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x005d;
    L_0x0080:
        r0 = com.google.android.gms.internal.zzjc.zzgC();
        r0.zzE(r3);
        goto L_0x0010;
    L_0x0088:
        r9.save();
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zziz.zzgv():void");
    }
}
