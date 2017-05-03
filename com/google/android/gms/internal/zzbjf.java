package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import com.google.android.gms.internal.zzaj.zzh;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.android.gms.tagmanager.zzbo;
import com.google.android.gms.tagmanager.zzdl;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzbjf {

    public static class zza {
        private final com.google.android.gms.internal.zzak.zza zzbHT;
        private final Map<String, com.google.android.gms.internal.zzak.zza> zzbMx;

        private zza(Map<String, com.google.android.gms.internal.zzak.zza> map, com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza) {
            this.zzbMx = map;
            this.zzbHT = com_google_android_gms_internal_zzak_zza;
        }

        public static zzb zzTw() {
            return new zzb();
        }

        public String toString() {
            String valueOf = String.valueOf(zzSW());
            String valueOf2 = String.valueOf(this.zzbHT);
            return new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length()).append("Properties: ").append(valueOf).append(" pushAfterEvaluate: ").append(valueOf2).toString();
        }

        public com.google.android.gms.internal.zzak.zza zzRr() {
            return this.zzbHT;
        }

        public Map<String, com.google.android.gms.internal.zzak.zza> zzSW() {
            return Collections.unmodifiableMap(this.zzbMx);
        }

        public void zza(String str, com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza) {
            this.zzbMx.put(str, com_google_android_gms_internal_zzak_zza);
        }
    }

    public static class zzb {
        private com.google.android.gms.internal.zzak.zza zzbHT;
        private final Map<String, com.google.android.gms.internal.zzak.zza> zzbMx;

        private zzb() {
            this.zzbMx = new HashMap();
        }

        public zza zzTx() {
            return new zza(this.zzbHT, null);
        }

        public zzb zzb(String str, com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza) {
            this.zzbMx.put(str, com_google_android_gms_internal_zzak_zza);
            return this;
        }

        public zzb zzo(com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza) {
            this.zzbHT = com_google_android_gms_internal_zzak_zza;
            return this;
        }
    }

    public static class zzc {
        private final String zzavB;
        private final List<zze> zzbMu;
        private final Map<String, List<zza>> zzbMv;
        private final int zzbMw;

        private zzc(List<zze> list, Map<String, List<zza>> map, String str, int i) {
            this.zzbMu = Collections.unmodifiableList(list);
            this.zzbMv = Collections.unmodifiableMap(map);
            this.zzavB = str;
            this.zzbMw = i;
        }

        public static zzd zzTy() {
            return new zzd();
        }

        public String getVersion() {
            return this.zzavB;
        }

        public String toString() {
            String valueOf = String.valueOf(zzSU());
            String valueOf2 = String.valueOf(this.zzbMv);
            return new StringBuilder((String.valueOf(valueOf).length() + 17) + String.valueOf(valueOf2).length()).append("Rules: ").append(valueOf).append("  Macros: ").append(valueOf2).toString();
        }

        public List<zze> zzSU() {
            return this.zzbMu;
        }

        public Map<String, List<zza>> zzTz() {
            return this.zzbMv;
        }
    }

    public static class zzd {
        private String zzavB;
        private final List<zze> zzbMu;
        private final Map<String, List<zza>> zzbMv;
        private int zzbMw;

        private zzd() {
            this.zzbMu = new ArrayList();
            this.zzbMv = new HashMap();
            this.zzavB = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzbMw = 0;
        }

        public zzc zzTA() {
            return new zzc(this.zzbMv, this.zzavB, this.zzbMw, null);
        }

        public zzd zzb(zze com_google_android_gms_internal_zzbjf_zze) {
            this.zzbMu.add(com_google_android_gms_internal_zzbjf_zze);
            return this;
        }

        public zzd zzc(zza com_google_android_gms_internal_zzbjf_zza) {
            String zze = zzdl.zze((com.google.android.gms.internal.zzak.zza) com_google_android_gms_internal_zzbjf_zza.zzSW().get(zzai.INSTANCE_NAME.toString()));
            List list = (List) this.zzbMv.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbMv.put(zze, list);
            }
            list.add(com_google_android_gms_internal_zzbjf_zza);
            return this;
        }

        public zzd zzih(String str) {
            this.zzavB = str;
            return this;
        }

        public zzd zznO(int i) {
            this.zzbMw = i;
            return this;
        }
    }

    public static class zze {
        private final List<zza> zzbMA;
        private final List<zza> zzbMB;
        private final List<zza> zzbMC;
        private final List<zza> zzbMz;
        private final List<zza> zzbNh;
        private final List<zza> zzbNi;
        private final List<String> zzbNj;
        private final List<String> zzbNk;
        private final List<String> zzbNl;
        private final List<String> zzbNm;

        private zze(List<zza> list, List<zza> list2, List<zza> list3, List<zza> list4, List<zza> list5, List<zza> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.zzbMz = Collections.unmodifiableList(list);
            this.zzbMA = Collections.unmodifiableList(list2);
            this.zzbMB = Collections.unmodifiableList(list3);
            this.zzbMC = Collections.unmodifiableList(list4);
            this.zzbNh = Collections.unmodifiableList(list5);
            this.zzbNi = Collections.unmodifiableList(list6);
            this.zzbNj = Collections.unmodifiableList(list7);
            this.zzbNk = Collections.unmodifiableList(list8);
            this.zzbNl = Collections.unmodifiableList(list9);
            this.zzbNm = Collections.unmodifiableList(list10);
        }

        public static zzf zzTB() {
            return new zzf();
        }

        public String toString() {
            String valueOf = String.valueOf(zzSY());
            String valueOf2 = String.valueOf(zzSZ());
            String valueOf3 = String.valueOf(zzTa());
            String valueOf4 = String.valueOf(zzTb());
            String valueOf5 = String.valueOf(zzTC());
            String valueOf6 = String.valueOf(zzTD());
            return new StringBuilder((((((String.valueOf(valueOf).length() + C0268R.styleable.AppCompatTheme_buttonStyle) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()).append("Positive predicates: ").append(valueOf).append("  Negative predicates: ").append(valueOf2).append("  Add tags: ").append(valueOf3).append("  Remove tags: ").append(valueOf4).append("  Add macros: ").append(valueOf5).append("  Remove macros: ").append(valueOf6).toString();
        }

        public List<zza> zzSY() {
            return this.zzbMz;
        }

        public List<zza> zzSZ() {
            return this.zzbMA;
        }

        public List<zza> zzTC() {
            return this.zzbNh;
        }

        public List<zza> zzTD() {
            return this.zzbNi;
        }

        public List<zza> zzTa() {
            return this.zzbMB;
        }

        public List<zza> zzTb() {
            return this.zzbMC;
        }
    }

    public static class zzf {
        private final List<zza> zzbMA;
        private final List<zza> zzbMB;
        private final List<zza> zzbMC;
        private final List<zza> zzbMz;
        private final List<zza> zzbNh;
        private final List<zza> zzbNi;
        private final List<String> zzbNj;
        private final List<String> zzbNk;
        private final List<String> zzbNl;
        private final List<String> zzbNm;

        private zzf() {
            this.zzbMz = new ArrayList();
            this.zzbMA = new ArrayList();
            this.zzbMB = new ArrayList();
            this.zzbMC = new ArrayList();
            this.zzbNh = new ArrayList();
            this.zzbNi = new ArrayList();
            this.zzbNj = new ArrayList();
            this.zzbNk = new ArrayList();
            this.zzbNl = new ArrayList();
            this.zzbNm = new ArrayList();
        }

        public zze zzTE() {
            return new zze(this.zzbMA, this.zzbMB, this.zzbMC, this.zzbNh, this.zzbNi, this.zzbNj, this.zzbNk, this.zzbNl, this.zzbNm, null);
        }

        public zzf zzd(zza com_google_android_gms_internal_zzbjf_zza) {
            this.zzbMz.add(com_google_android_gms_internal_zzbjf_zza);
            return this;
        }

        public zzf zze(zza com_google_android_gms_internal_zzbjf_zza) {
            this.zzbMA.add(com_google_android_gms_internal_zzbjf_zza);
            return this;
        }

        public zzf zzf(zza com_google_android_gms_internal_zzbjf_zza) {
            this.zzbMB.add(com_google_android_gms_internal_zzbjf_zza);
            return this;
        }

        public zzf zzg(zza com_google_android_gms_internal_zzbjf_zza) {
            this.zzbMC.add(com_google_android_gms_internal_zzbjf_zza);
            return this;
        }

        public zzf zzh(zza com_google_android_gms_internal_zzbjf_zza) {
            this.zzbNh.add(com_google_android_gms_internal_zzbjf_zza);
            return this;
        }

        public zzf zzi(zza com_google_android_gms_internal_zzbjf_zza) {
            this.zzbNi.add(com_google_android_gms_internal_zzbjf_zza);
            return this;
        }

        public zzf zzii(String str) {
            this.zzbNl.add(str);
            return this;
        }

        public zzf zzij(String str) {
            this.zzbNm.add(str);
            return this;
        }

        public zzf zzik(String str) {
            this.zzbNj.add(str);
            return this;
        }

        public zzf zzil(String str) {
            this.zzbNk.add(str);
            return this;
        }
    }

    public static class zzg extends Exception {
        public zzg(String str) {
            super(str);
        }
    }

    private static com.google.android.gms.internal.zzak.zza zza(int i, com.google.android.gms.internal.zzaj.zzf com_google_android_gms_internal_zzaj_zzf, com.google.android.gms.internal.zzak.zza[] com_google_android_gms_internal_zzak_zzaArr, Set<Integer> set) {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            String valueOf = String.valueOf(set);
            zzhS(new StringBuilder(String.valueOf(valueOf).length() + 90).append("Value cycle detected.  Current value reference: ").append(i).append(".  Previous value references: ").append(valueOf).append(".").toString());
        }
        com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza = (com.google.android.gms.internal.zzak.zza) zza(com_google_android_gms_internal_zzaj_zzf.zzkF, i, "values");
        if (com_google_android_gms_internal_zzak_zzaArr[i] != null) {
            return com_google_android_gms_internal_zzak_zzaArr[i];
        }
        com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza2 = null;
        set.add(Integer.valueOf(i));
        zzh zzn;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (com_google_android_gms_internal_zzak_zza.type) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case Type.OTHER_PROFILE /*5*/:
            case Type.CONTRIBUTOR /*6*/:
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                com_google_android_gms_internal_zzak_zza2 = com_google_android_gms_internal_zzak_zza;
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                zzn = zzn(com_google_android_gms_internal_zzak_zza);
                com_google_android_gms_internal_zzak_zza2 = zzm(com_google_android_gms_internal_zzak_zza);
                com_google_android_gms_internal_zzak_zza2.zzlu = new com.google.android.gms.internal.zzak.zza[zzn.zzlg.length];
                iArr = zzn.zzlg;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzak_zza2.zzlu[i3] = zza(iArr[i2], com_google_android_gms_internal_zzaj_zzf, com_google_android_gms_internal_zzak_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                com_google_android_gms_internal_zzak_zza2 = zzm(com_google_android_gms_internal_zzak_zza);
                zzh zzn2 = zzn(com_google_android_gms_internal_zzak_zza);
                if (zzn2.zzlh.length != zzn2.zzli.length) {
                    i3 = zzn2.zzlh.length;
                    zzhS("Uneven map keys (" + i3 + ") and map values (" + zzn2.zzli.length + ")");
                }
                com_google_android_gms_internal_zzak_zza2.zzlv = new com.google.android.gms.internal.zzak.zza[zzn2.zzlh.length];
                com_google_android_gms_internal_zzak_zza2.zzlw = new com.google.android.gms.internal.zzak.zza[zzn2.zzlh.length];
                int[] iArr2 = zzn2.zzlh;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    com_google_android_gms_internal_zzak_zza2.zzlv[i4] = zza(iArr2[i3], com_google_android_gms_internal_zzaj_zzf, com_google_android_gms_internal_zzak_zzaArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = zzn2.zzli;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzak_zza2.zzlw[i3] = zza(iArr[i2], com_google_android_gms_internal_zzaj_zzf, com_google_android_gms_internal_zzak_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                com_google_android_gms_internal_zzak_zza2 = zzm(com_google_android_gms_internal_zzak_zza);
                com_google_android_gms_internal_zzak_zza2.zzlx = zzdl.zze(zza(zzn(com_google_android_gms_internal_zzak_zza).zzll, com_google_android_gms_internal_zzaj_zzf, com_google_android_gms_internal_zzak_zzaArr, (Set) set));
                break;
            case Type.WEBSITE /*7*/:
                com_google_android_gms_internal_zzak_zza2 = zzm(com_google_android_gms_internal_zzak_zza);
                zzn = zzn(com_google_android_gms_internal_zzak_zza);
                com_google_android_gms_internal_zzak_zza2.zzlB = new com.google.android.gms.internal.zzak.zza[zzn.zzlk.length];
                iArr = zzn.zzlk;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzak_zza2.zzlB[i3] = zza(iArr[i2], com_google_android_gms_internal_zzaj_zzf, com_google_android_gms_internal_zzak_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (com_google_android_gms_internal_zzak_zza2 == null) {
            valueOf = String.valueOf(com_google_android_gms_internal_zzak_zza);
            zzhS(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Invalid value: ").append(valueOf).toString());
        }
        com_google_android_gms_internal_zzak_zzaArr[i] = com_google_android_gms_internal_zzak_zza2;
        set.remove(Integer.valueOf(i));
        return com_google_android_gms_internal_zzak_zza2;
    }

    private static zza zza(com.google.android.gms.internal.zzaj.zzb com_google_android_gms_internal_zzaj_zzb, com.google.android.gms.internal.zzaj.zzf com_google_android_gms_internal_zzaj_zzf, com.google.android.gms.internal.zzak.zza[] com_google_android_gms_internal_zzak_zzaArr, int i) {
        zzb zzTw = zza.zzTw();
        for (int valueOf : com_google_android_gms_internal_zzaj_zzb.zzkq) {
            com.google.android.gms.internal.zzaj.zze com_google_android_gms_internal_zzaj_zze = (com.google.android.gms.internal.zzaj.zze) zza(com_google_android_gms_internal_zzaj_zzf.zzkG, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) zza(com_google_android_gms_internal_zzaj_zzf.zzkE, com_google_android_gms_internal_zzaj_zze.key, "keys");
            com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza = (com.google.android.gms.internal.zzak.zza) zza(com_google_android_gms_internal_zzak_zzaArr, com_google_android_gms_internal_zzaj_zze.value, "values");
            if (zzai.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzTw.zzo(com_google_android_gms_internal_zzak_zza);
            } else {
                zzTw.zzb(str, com_google_android_gms_internal_zzak_zza);
            }
        }
        return zzTw.zzTx();
    }

    private static zze zza(com.google.android.gms.internal.zzaj.zzg com_google_android_gms_internal_zzaj_zzg, List<zza> list, List<zza> list2, List<zza> list3, com.google.android.gms.internal.zzaj.zzf com_google_android_gms_internal_zzaj_zzf) {
        zzf zzTB = zze.zzTB();
        for (int valueOf : com_google_android_gms_internal_zzaj_zzg.zzkU) {
            zzTB.zzd((zza) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : com_google_android_gms_internal_zzaj_zzg.zzkV) {
            zzTB.zze((zza) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : com_google_android_gms_internal_zzaj_zzg.zzkW) {
            zzTB.zzf((zza) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : com_google_android_gms_internal_zzaj_zzg.zzkY) {
            zzTB.zzii(com_google_android_gms_internal_zzaj_zzf.zzkF[Integer.valueOf(valueOf3).intValue()].string);
        }
        for (int valueOf222 : com_google_android_gms_internal_zzaj_zzg.zzkX) {
            zzTB.zzg((zza) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : com_google_android_gms_internal_zzaj_zzg.zzkZ) {
            zzTB.zzij(com_google_android_gms_internal_zzaj_zzf.zzkF[Integer.valueOf(valueOf32).intValue()].string);
        }
        for (int valueOf2222 : com_google_android_gms_internal_zzaj_zzg.zzla) {
            zzTB.zzh((zza) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : com_google_android_gms_internal_zzaj_zzg.zzlc) {
            zzTB.zzik(com_google_android_gms_internal_zzaj_zzf.zzkF[Integer.valueOf(valueOf322).intValue()].string);
        }
        for (int valueOf22222 : com_google_android_gms_internal_zzaj_zzg.zzlb) {
            zzTB.zzi((zza) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : com_google_android_gms_internal_zzaj_zzg.zzld) {
            zzTB.zzil(com_google_android_gms_internal_zzaj_zzf.zzkF[Integer.valueOf(valueOf4).intValue()].string);
        }
        return zzTB.zzTE();
    }

    private static <T> T zza(T[] tArr, int i, String str) {
        if (i < 0 || i >= tArr.length) {
            zzhS(new StringBuilder(String.valueOf(str).length() + 45).append("Index out of bounds detected: ").append(i).append(" in ").append(str).toString());
        }
        return tArr[i];
    }

    public static zzc zzb(com.google.android.gms.internal.zzaj.zzf com_google_android_gms_internal_zzaj_zzf) {
        int i;
        int i2 = 0;
        com.google.android.gms.internal.zzak.zza[] com_google_android_gms_internal_zzak_zzaArr = new com.google.android.gms.internal.zzak.zza[com_google_android_gms_internal_zzaj_zzf.zzkF.length];
        for (i = 0; i < com_google_android_gms_internal_zzaj_zzf.zzkF.length; i++) {
            zza(i, com_google_android_gms_internal_zzaj_zzf, com_google_android_gms_internal_zzak_zzaArr, new HashSet(0));
        }
        zzd zzTy = zzc.zzTy();
        List arrayList = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzaj_zzf.zzkI.length; i++) {
            arrayList.add(zza(com_google_android_gms_internal_zzaj_zzf.zzkI[i], com_google_android_gms_internal_zzaj_zzf, com_google_android_gms_internal_zzak_zzaArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzaj_zzf.zzkJ.length; i++) {
            arrayList2.add(zza(com_google_android_gms_internal_zzaj_zzf.zzkJ[i], com_google_android_gms_internal_zzaj_zzf, com_google_android_gms_internal_zzak_zzaArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzaj_zzf.zzkH.length; i++) {
            zza zza = zza(com_google_android_gms_internal_zzaj_zzf.zzkH[i], com_google_android_gms_internal_zzaj_zzf, com_google_android_gms_internal_zzak_zzaArr, i);
            zzTy.zzc(zza);
            arrayList3.add(zza);
        }
        com.google.android.gms.internal.zzaj.zzg[] com_google_android_gms_internal_zzaj_zzgArr = com_google_android_gms_internal_zzaj_zzf.zzkK;
        int length = com_google_android_gms_internal_zzaj_zzgArr.length;
        while (i2 < length) {
            zzTy.zzb(zza(com_google_android_gms_internal_zzaj_zzgArr[i2], arrayList, arrayList3, arrayList2, com_google_android_gms_internal_zzaj_zzf));
            i2++;
        }
        zzTy.zzih(com_google_android_gms_internal_zzaj_zzf.version);
        zzTy.zznO(com_google_android_gms_internal_zzaj_zzf.zzkS);
        return zzTy.zzTA();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void zzhS(String str) {
        zzbo.m4711e(str);
        throw new zzg(str);
    }

    public static com.google.android.gms.internal.zzak.zza zzm(com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza) {
        com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza2 = new com.google.android.gms.internal.zzak.zza();
        com_google_android_gms_internal_zzak_zza2.type = com_google_android_gms_internal_zzak_zza.type;
        com_google_android_gms_internal_zzak_zza2.zzlC = (int[]) com_google_android_gms_internal_zzak_zza.zzlC.clone();
        if (com_google_android_gms_internal_zzak_zza.zzlD) {
            com_google_android_gms_internal_zzak_zza2.zzlD = com_google_android_gms_internal_zzak_zza.zzlD;
        }
        return com_google_android_gms_internal_zzak_zza2;
    }

    private static zzh zzn(com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza) {
        if (((zzh) com_google_android_gms_internal_zzak_zza.zza(zzh.zzle)) == null) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzak_zza);
            zzhS(new StringBuilder(String.valueOf(valueOf).length() + 54).append("Expected a ServingValue and didn't get one. Value is: ").append(valueOf).toString());
        }
        return (zzh) com_google_android_gms_internal_zzak_zza.zza(zzh.zzle);
    }
}
