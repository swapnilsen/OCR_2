package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzaj.zzi;
import com.google.android.gms.internal.zzbjf;
import com.google.android.gms.internal.zzbjf.zze;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcx {
    private static final zzce<com.google.android.gms.internal.zzak.zza> zzbHC;
    private final DataLayer zzbEV;
    private final com.google.android.gms.internal.zzbjf.zzc zzbHD;
    private final zzaj zzbHE;
    private final Map<String, zzam> zzbHF;
    private final Map<String, zzam> zzbHG;
    private final Map<String, zzam> zzbHH;
    private final zzl<com.google.android.gms.internal.zzbjf.zza, zzce<com.google.android.gms.internal.zzak.zza>> zzbHI;
    private final zzl<String, zzb> zzbHJ;
    private final Set<zze> zzbHK;
    private final Map<String, zzc> zzbHL;
    private volatile String zzbHM;
    private int zzbHN;

    /* renamed from: com.google.android.gms.tagmanager.zzcx.1 */
    class C14501 implements com.google.android.gms.tagmanager.zzm.zza<com.google.android.gms.internal.zzbjf.zza, zzce<com.google.android.gms.internal.zzak.zza>> {
        C14501(zzcx com_google_android_gms_tagmanager_zzcx) {
        }

        public /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return zza((com.google.android.gms.internal.zzbjf.zza) obj, (zzce) obj2);
        }

        public int zza(com.google.android.gms.internal.zzbjf.zza com_google_android_gms_internal_zzbjf_zza, zzce<com.google.android.gms.internal.zzak.zza> com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza) {
            return ((com.google.android.gms.internal.zzak.zza) com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza.getObject()).zzaeS();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcx.2 */
    class C14512 implements com.google.android.gms.tagmanager.zzm.zza<String, zzb> {
        C14512(zzcx com_google_android_gms_tagmanager_zzcx) {
        }

        public /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return zza((String) obj, (zzb) obj2);
        }

        public int zza(String str, zzb com_google_android_gms_tagmanager_zzcx_zzb) {
            return str.length() + com_google_android_gms_tagmanager_zzcx_zzb.getSize();
        }
    }

    interface zza {
        void zza(zze com_google_android_gms_internal_zzbjf_zze, Set<com.google.android.gms.internal.zzbjf.zza> set, Set<com.google.android.gms.internal.zzbjf.zza> set2, zzcs com_google_android_gms_tagmanager_zzcs);
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcx.3 */
    class C14523 implements zza {
        final /* synthetic */ Map zzbHO;
        final /* synthetic */ Map zzbHP;
        final /* synthetic */ Map zzbHQ;
        final /* synthetic */ Map zzbHR;

        C14523(zzcx com_google_android_gms_tagmanager_zzcx, Map map, Map map2, Map map3, Map map4) {
            this.zzbHO = map;
            this.zzbHP = map2;
            this.zzbHQ = map3;
            this.zzbHR = map4;
        }

        public void zza(zze com_google_android_gms_internal_zzbjf_zze, Set<com.google.android.gms.internal.zzbjf.zza> set, Set<com.google.android.gms.internal.zzbjf.zza> set2, zzcs com_google_android_gms_tagmanager_zzcs) {
            List list = (List) this.zzbHO.get(com_google_android_gms_internal_zzbjf_zze);
            this.zzbHP.get(com_google_android_gms_internal_zzbjf_zze);
            if (list != null) {
                set.addAll(list);
                com_google_android_gms_tagmanager_zzcs.zzQT();
            }
            list = (List) this.zzbHQ.get(com_google_android_gms_internal_zzbjf_zze);
            this.zzbHR.get(com_google_android_gms_internal_zzbjf_zze);
            if (list != null) {
                set2.addAll(list);
                com_google_android_gms_tagmanager_zzcs.zzQU();
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcx.4 */
    class C14534 implements zza {
        C14534(zzcx com_google_android_gms_tagmanager_zzcx) {
        }

        public void zza(zze com_google_android_gms_internal_zzbjf_zze, Set<com.google.android.gms.internal.zzbjf.zza> set, Set<com.google.android.gms.internal.zzbjf.zza> set2, zzcs com_google_android_gms_tagmanager_zzcs) {
            set.addAll(com_google_android_gms_internal_zzbjf_zze.zzTa());
            set2.addAll(com_google_android_gms_internal_zzbjf_zze.zzTb());
            com_google_android_gms_tagmanager_zzcs.zzQV();
            com_google_android_gms_tagmanager_zzcs.zzQW();
        }
    }

    private static class zzb {
        private zzce<com.google.android.gms.internal.zzak.zza> zzbHS;
        private com.google.android.gms.internal.zzak.zza zzbHT;

        public zzb(zzce<com.google.android.gms.internal.zzak.zza> com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza, com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza) {
            this.zzbHS = com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza;
            this.zzbHT = com_google_android_gms_internal_zzak_zza;
        }

        public int getSize() {
            return (this.zzbHT == null ? 0 : this.zzbHT.zzaeS()) + ((com.google.android.gms.internal.zzak.zza) this.zzbHS.getObject()).zzaeS();
        }

        public zzce<com.google.android.gms.internal.zzak.zza> zzRq() {
            return this.zzbHS;
        }

        public com.google.android.gms.internal.zzak.zza zzRr() {
            return this.zzbHT;
        }
    }

    private static class zzc {
        private final Set<zze> zzbHK;
        private final Map<zze, List<com.google.android.gms.internal.zzbjf.zza>> zzbHU;
        private final Map<zze, List<com.google.android.gms.internal.zzbjf.zza>> zzbHV;
        private final Map<zze, List<String>> zzbHW;
        private final Map<zze, List<String>> zzbHX;
        private com.google.android.gms.internal.zzbjf.zza zzbHY;

        public zzc() {
            this.zzbHK = new HashSet();
            this.zzbHU = new HashMap();
            this.zzbHW = new HashMap();
            this.zzbHV = new HashMap();
            this.zzbHX = new HashMap();
        }

        public Set<zze> zzRs() {
            return this.zzbHK;
        }

        public Map<zze, List<com.google.android.gms.internal.zzbjf.zza>> zzRt() {
            return this.zzbHU;
        }

        public Map<zze, List<String>> zzRu() {
            return this.zzbHW;
        }

        public Map<zze, List<String>> zzRv() {
            return this.zzbHX;
        }

        public Map<zze, List<com.google.android.gms.internal.zzbjf.zza>> zzRw() {
            return this.zzbHV;
        }

        public com.google.android.gms.internal.zzbjf.zza zzRx() {
            return this.zzbHY;
        }

        public void zza(zze com_google_android_gms_internal_zzbjf_zze) {
            this.zzbHK.add(com_google_android_gms_internal_zzbjf_zze);
        }

        public void zza(zze com_google_android_gms_internal_zzbjf_zze, com.google.android.gms.internal.zzbjf.zza com_google_android_gms_internal_zzbjf_zza) {
            List list = (List) this.zzbHU.get(com_google_android_gms_internal_zzbjf_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbHU.put(com_google_android_gms_internal_zzbjf_zze, list);
            }
            list.add(com_google_android_gms_internal_zzbjf_zza);
        }

        public void zza(zze com_google_android_gms_internal_zzbjf_zze, String str) {
            List list = (List) this.zzbHW.get(com_google_android_gms_internal_zzbjf_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbHW.put(com_google_android_gms_internal_zzbjf_zze, list);
            }
            list.add(str);
        }

        public void zzb(com.google.android.gms.internal.zzbjf.zza com_google_android_gms_internal_zzbjf_zza) {
            this.zzbHY = com_google_android_gms_internal_zzbjf_zza;
        }

        public void zzb(zze com_google_android_gms_internal_zzbjf_zze, com.google.android.gms.internal.zzbjf.zza com_google_android_gms_internal_zzbjf_zza) {
            List list = (List) this.zzbHV.get(com_google_android_gms_internal_zzbjf_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbHV.put(com_google_android_gms_internal_zzbjf_zze, list);
            }
            list.add(com_google_android_gms_internal_zzbjf_zza);
        }

        public void zzb(zze com_google_android_gms_internal_zzbjf_zze, String str) {
            List list = (List) this.zzbHX.get(com_google_android_gms_internal_zzbjf_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbHX.put(com_google_android_gms_internal_zzbjf_zze, list);
            }
            list.add(str);
        }
    }

    static {
        zzbHC = new zzce(zzdl.zzRR(), true);
    }

    public zzcx(Context context, com.google.android.gms.internal.zzbjf.zzc com_google_android_gms_internal_zzbjf_zzc, DataLayer dataLayer, com.google.android.gms.tagmanager.zzu.zza com_google_android_gms_tagmanager_zzu_zza, com.google.android.gms.tagmanager.zzu.zza com_google_android_gms_tagmanager_zzu_zza2, zzaj com_google_android_gms_tagmanager_zzaj) {
        if (com_google_android_gms_internal_zzbjf_zzc == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.zzbHD = com_google_android_gms_internal_zzbjf_zzc;
        this.zzbHK = new HashSet(com_google_android_gms_internal_zzbjf_zzc.zzSU());
        this.zzbEV = dataLayer;
        this.zzbHE = com_google_android_gms_tagmanager_zzaj;
        this.zzbHI = new zzm().zza(AccessibilityNodeInfoCompat.ACTION_DISMISS, new C14501(this));
        this.zzbHJ = new zzm().zza(AccessibilityNodeInfoCompat.ACTION_DISMISS, new C14512(this));
        this.zzbHF = new HashMap();
        zzb(new zzj(context));
        zzb(new zzu(com_google_android_gms_tagmanager_zzu_zza2));
        zzb(new zzy(dataLayer));
        zzb(new zzdm(context, dataLayer));
        this.zzbHG = new HashMap();
        zzc(new zzs());
        zzc(new zzag());
        zzc(new zzah());
        zzc(new zzao());
        zzc(new zzap());
        zzc(new zzbk());
        zzc(new zzbl());
        zzc(new zzcn());
        zzc(new zzdf());
        this.zzbHH = new HashMap();
        zza(new zzb(context));
        zza(new zzc(context));
        zza(new zze(context));
        zza(new zzf(context));
        zza(new zzg(context));
        zza(new zzh(context));
        zza(new zzi(context));
        zza(new zzn());
        zza(new zzr(this.zzbHD.getVersion()));
        zza(new zzu(com_google_android_gms_tagmanager_zzu_zza));
        zza(new zzw(dataLayer));
        zza(new zzab(context));
        zza(new zzac());
        zza(new zzaf());
        zza(new zzak(this));
        zza(new zzaq());
        zza(new zzar());
        zza(new zzbe(context));
        zza(new zzbg());
        zza(new zzbj());
        zza(new zzbq());
        zza(new zzbs(context));
        zza(new zzcf());
        zza(new zzch());
        zza(new zzck());
        zza(new zzcm());
        zza(new zzco(context));
        zza(new zzcy());
        zza(new zzcz());
        zza(new zzdh());
        zza(new zzdn());
        this.zzbHL = new HashMap();
        for (zze com_google_android_gms_internal_zzbjf_zze : this.zzbHK) {
            int i;
            for (i = 0; i < com_google_android_gms_internal_zzbjf_zze.zzTC().size(); i++) {
                com.google.android.gms.internal.zzbjf.zza com_google_android_gms_internal_zzbjf_zza = (com.google.android.gms.internal.zzbjf.zza) com_google_android_gms_internal_zzbjf_zze.zzTC().get(i);
                zzc zzh = zzh(this.zzbHL, zza(com_google_android_gms_internal_zzbjf_zza));
                zzh.zza(com_google_android_gms_internal_zzbjf_zze);
                zzh.zza(com_google_android_gms_internal_zzbjf_zze, com_google_android_gms_internal_zzbjf_zza);
                zzh.zza(com_google_android_gms_internal_zzbjf_zze, "Unknown");
            }
            for (i = 0; i < com_google_android_gms_internal_zzbjf_zze.zzTD().size(); i++) {
                com_google_android_gms_internal_zzbjf_zza = (com.google.android.gms.internal.zzbjf.zza) com_google_android_gms_internal_zzbjf_zze.zzTD().get(i);
                zzh = zzh(this.zzbHL, zza(com_google_android_gms_internal_zzbjf_zza));
                zzh.zza(com_google_android_gms_internal_zzbjf_zze);
                zzh.zzb(com_google_android_gms_internal_zzbjf_zze, com_google_android_gms_internal_zzbjf_zza);
                zzh.zzb(com_google_android_gms_internal_zzbjf_zze, "Unknown");
            }
        }
        for (Entry entry : this.zzbHD.zzTz().entrySet()) {
            for (com.google.android.gms.internal.zzbjf.zza com_google_android_gms_internal_zzbjf_zza2 : (List) entry.getValue()) {
                if (!zzdl.zzi((com.google.android.gms.internal.zzak.zza) com_google_android_gms_internal_zzbjf_zza2.zzSW().get(zzai.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    zzh(this.zzbHL, (String) entry.getKey()).zzb(com_google_android_gms_internal_zzbjf_zza2);
                }
            }
        }
    }

    private String zzRp() {
        if (this.zzbHN <= 1) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.zzbHN));
        for (int i = 2; i < this.zzbHN; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    private zzce<com.google.android.gms.internal.zzak.zza> zza(com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza, Set<String> set, zzdo com_google_android_gms_tagmanager_zzdo) {
        if (!com_google_android_gms_internal_zzak_zza.zzlD) {
            return new zzce(com_google_android_gms_internal_zzak_zza, true);
        }
        com.google.android.gms.internal.zzak.zza zzm;
        int i;
        zzce zza;
        String str;
        String valueOf;
        switch (com_google_android_gms_internal_zzak_zza.type) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                zzm = zzbjf.zzm(com_google_android_gms_internal_zzak_zza);
                zzm.zzlu = new com.google.android.gms.internal.zzak.zza[com_google_android_gms_internal_zzak_zza.zzlu.length];
                for (i = 0; i < com_google_android_gms_internal_zzak_zza.zzlu.length; i++) {
                    zza = zza(com_google_android_gms_internal_zzak_zza.zzlu[i], (Set) set, com_google_android_gms_tagmanager_zzdo.zznC(i));
                    if (zza == zzbHC) {
                        return zzbHC;
                    }
                    zzm.zzlu[i] = (com.google.android.gms.internal.zzak.zza) zza.getObject();
                }
                return new zzce(zzm, false);
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                zzm = zzbjf.zzm(com_google_android_gms_internal_zzak_zza);
                if (com_google_android_gms_internal_zzak_zza.zzlv.length != com_google_android_gms_internal_zzak_zza.zzlw.length) {
                    str = "Invalid serving value: ";
                    valueOf = String.valueOf(com_google_android_gms_internal_zzak_zza.toString());
                    zzbo.m4711e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return zzbHC;
                }
                zzm.zzlv = new com.google.android.gms.internal.zzak.zza[com_google_android_gms_internal_zzak_zza.zzlv.length];
                zzm.zzlw = new com.google.android.gms.internal.zzak.zza[com_google_android_gms_internal_zzak_zza.zzlv.length];
                for (i = 0; i < com_google_android_gms_internal_zzak_zza.zzlv.length; i++) {
                    zza = zza(com_google_android_gms_internal_zzak_zza.zzlv[i], (Set) set, com_google_android_gms_tagmanager_zzdo.zznD(i));
                    zzce zza2 = zza(com_google_android_gms_internal_zzak_zza.zzlw[i], (Set) set, com_google_android_gms_tagmanager_zzdo.zznE(i));
                    if (zza == zzbHC || zza2 == zzbHC) {
                        return zzbHC;
                    }
                    zzm.zzlv[i] = (com.google.android.gms.internal.zzak.zza) zza.getObject();
                    zzm.zzlw[i] = (com.google.android.gms.internal.zzak.zza) zza2.getObject();
                }
                return new zzce(zzm, false);
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                if (set.contains(com_google_android_gms_internal_zzak_zza.zzlx)) {
                    valueOf = String.valueOf(com_google_android_gms_internal_zzak_zza.zzlx);
                    str = String.valueOf(set.toString());
                    zzbo.m4711e(new StringBuilder((String.valueOf(valueOf).length() + 79) + String.valueOf(str).length()).append("Macro cycle detected.  Current macro reference: ").append(valueOf).append(".  Previous macro references: ").append(str).append(".").toString());
                    return zzbHC;
                }
                set.add(com_google_android_gms_internal_zzak_zza.zzlx);
                zzce<com.google.android.gms.internal.zzak.zza> zza3 = zzdp.zza(zza(com_google_android_gms_internal_zzak_zza.zzlx, (Set) set, com_google_android_gms_tagmanager_zzdo.zzQY()), com_google_android_gms_internal_zzak_zza.zzlC);
                set.remove(com_google_android_gms_internal_zzak_zza.zzlx);
                return zza3;
            case Type.WEBSITE /*7*/:
                zzm = zzbjf.zzm(com_google_android_gms_internal_zzak_zza);
                zzm.zzlB = new com.google.android.gms.internal.zzak.zza[com_google_android_gms_internal_zzak_zza.zzlB.length];
                for (i = 0; i < com_google_android_gms_internal_zzak_zza.zzlB.length; i++) {
                    zza = zza(com_google_android_gms_internal_zzak_zza.zzlB[i], (Set) set, com_google_android_gms_tagmanager_zzdo.zznF(i));
                    if (zza == zzbHC) {
                        return zzbHC;
                    }
                    zzm.zzlB[i] = (com.google.android.gms.internal.zzak.zza) zza.getObject();
                }
                return new zzce(zzm, false);
            default:
                zzbo.m4711e("Unknown type: " + com_google_android_gms_internal_zzak_zza.type);
                return zzbHC;
        }
    }

    private zzce<com.google.android.gms.internal.zzak.zza> zza(String str, Set<String> set, zzbr com_google_android_gms_tagmanager_zzbr) {
        this.zzbHN++;
        zzb com_google_android_gms_tagmanager_zzcx_zzb = (zzb) this.zzbHJ.get(str);
        if (com_google_android_gms_tagmanager_zzcx_zzb != null) {
            zza(com_google_android_gms_tagmanager_zzcx_zzb.zzRr(), (Set) set);
            this.zzbHN--;
            return com_google_android_gms_tagmanager_zzcx_zzb.zzRq();
        }
        zzc com_google_android_gms_tagmanager_zzcx_zzc = (zzc) this.zzbHL.get(str);
        if (com_google_android_gms_tagmanager_zzcx_zzc == null) {
            String valueOf = String.valueOf(zzRp());
            zzbo.m4711e(new StringBuilder((String.valueOf(valueOf).length() + 15) + String.valueOf(str).length()).append(valueOf).append("Invalid macro: ").append(str).toString());
            this.zzbHN--;
            return zzbHC;
        }
        com.google.android.gms.internal.zzbjf.zza zzRx;
        zzce zza = zza(str, com_google_android_gms_tagmanager_zzcx_zzc.zzRs(), com_google_android_gms_tagmanager_zzcx_zzc.zzRt(), com_google_android_gms_tagmanager_zzcx_zzc.zzRu(), com_google_android_gms_tagmanager_zzcx_zzc.zzRw(), com_google_android_gms_tagmanager_zzcx_zzc.zzRv(), set, com_google_android_gms_tagmanager_zzbr.zzQz());
        if (((Set) zza.getObject()).isEmpty()) {
            zzRx = com_google_android_gms_tagmanager_zzcx_zzc.zzRx();
        } else {
            if (((Set) zza.getObject()).size() > 1) {
                valueOf = String.valueOf(zzRp());
                zzbo.zzbh(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(str).length()).append(valueOf).append("Multiple macros active for macroName ").append(str).toString());
            }
            zzRx = (com.google.android.gms.internal.zzbjf.zza) ((Set) zza.getObject()).iterator().next();
        }
        if (zzRx == null) {
            this.zzbHN--;
            return zzbHC;
        }
        zzce zza2 = zza(this.zzbHH, zzRx, (Set) set, com_google_android_gms_tagmanager_zzbr.zzQQ());
        boolean z = zza.zzQZ() && zza2.zzQZ();
        zzce<com.google.android.gms.internal.zzak.zza> com_google_android_gms_tagmanager_zzce = zza2 == zzbHC ? zzbHC : new zzce((com.google.android.gms.internal.zzak.zza) zza2.getObject(), z);
        com.google.android.gms.internal.zzak.zza zzRr = zzRx.zzRr();
        if (com_google_android_gms_tagmanager_zzce.zzQZ()) {
            this.zzbHJ.zzh(str, new zzb(com_google_android_gms_tagmanager_zzce, zzRr));
        }
        zza(zzRr, (Set) set);
        this.zzbHN--;
        return com_google_android_gms_tagmanager_zzce;
    }

    private zzce<com.google.android.gms.internal.zzak.zza> zza(Map<String, zzam> map, com.google.android.gms.internal.zzbjf.zza com_google_android_gms_internal_zzbjf_zza, Set<String> set, zzcp com_google_android_gms_tagmanager_zzcp) {
        boolean z = true;
        com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza = (com.google.android.gms.internal.zzak.zza) com_google_android_gms_internal_zzbjf_zza.zzSW().get(zzai.FUNCTION.toString());
        if (com_google_android_gms_internal_zzak_zza == null) {
            zzbo.m4711e("No function id in properties");
            return zzbHC;
        }
        String str = com_google_android_gms_internal_zzak_zza.zzly;
        zzam com_google_android_gms_tagmanager_zzam = (zzam) map.get(str);
        if (com_google_android_gms_tagmanager_zzam == null) {
            zzbo.m4711e(String.valueOf(str).concat(" has no backing implementation."));
            return zzbHC;
        }
        zzce<com.google.android.gms.internal.zzak.zza> com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza = (zzce) this.zzbHI.get(com_google_android_gms_internal_zzbjf_zza);
        if (com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza != null) {
            return com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : com_google_android_gms_internal_zzbjf_zza.zzSW().entrySet()) {
            zzce zza = zza((com.google.android.gms.internal.zzak.zza) entry.getValue(), (Set) set, com_google_android_gms_tagmanager_zzcp.zzhm((String) entry.getKey()).zzd((com.google.android.gms.internal.zzak.zza) entry.getValue()));
            if (zza == zzbHC) {
                return zzbHC;
            }
            boolean z3;
            if (zza.zzQZ()) {
                com_google_android_gms_internal_zzbjf_zza.zza((String) entry.getKey(), (com.google.android.gms.internal.zzak.zza) zza.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put((String) entry.getKey(), (com.google.android.gms.internal.zzak.zza) zza.getObject());
            z2 = z3;
        }
        if (com_google_android_gms_tagmanager_zzam.zzf(hashMap.keySet())) {
            if (!(z2 && com_google_android_gms_tagmanager_zzam.zzQb())) {
                z = false;
            }
            com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza = new zzce(com_google_android_gms_tagmanager_zzam.zzZ(hashMap), z);
            if (!z) {
                return com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza;
            }
            this.zzbHI.zzh(com_google_android_gms_internal_zzbjf_zza, com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza);
            return com_google_android_gms_tagmanager_zzce_com_google_android_gms_internal_zzak_zza;
        }
        String valueOf = String.valueOf(com_google_android_gms_tagmanager_zzam.zzQM());
        String valueOf2 = String.valueOf(hashMap.keySet());
        zzbo.m4711e(new StringBuilder(((String.valueOf(str).length() + 43) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append("Incorrect keys for function ").append(str).append(" required ").append(valueOf).append(" had ").append(valueOf2).toString());
        return zzbHC;
    }

    private zzce<Set<com.google.android.gms.internal.zzbjf.zza>> zza(Set<zze> set, Set<String> set2, zza com_google_android_gms_tagmanager_zzcx_zza, zzcw com_google_android_gms_tagmanager_zzcw) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (zze com_google_android_gms_internal_zzbjf_zze : set) {
            zzcs zzQX = com_google_android_gms_tagmanager_zzcw.zzQX();
            zzce zza = zza(com_google_android_gms_internal_zzbjf_zze, (Set) set2, zzQX);
            if (((Boolean) zza.getObject()).booleanValue()) {
                com_google_android_gms_tagmanager_zzcx_zza.zza(com_google_android_gms_internal_zzbjf_zze, hashSet, hashSet2, zzQX);
            }
            boolean z2 = z && zza.zzQZ();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        return new zzce(hashSet, z);
    }

    private static String zza(com.google.android.gms.internal.zzbjf.zza com_google_android_gms_internal_zzbjf_zza) {
        return zzdl.zze((com.google.android.gms.internal.zzak.zza) com_google_android_gms_internal_zzbjf_zza.zzSW().get(zzai.INSTANCE_NAME.toString()));
    }

    private void zza(com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza, Set<String> set) {
        if (com_google_android_gms_internal_zzak_zza != null) {
            zzce zza = zza(com_google_android_gms_internal_zzak_zza, (Set) set, new zzcc());
            if (zza != zzbHC) {
                Object zzj = zzdl.zzj((com.google.android.gms.internal.zzak.zza) zza.getObject());
                if (zzj instanceof Map) {
                    this.zzbEV.push((Map) zzj);
                } else if (zzj instanceof List) {
                    for (Object zzj2 : (List) zzj2) {
                        if (zzj2 instanceof Map) {
                            this.zzbEV.push((Map) zzj2);
                        } else {
                            zzbo.zzbh("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    zzbo.zzbh("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void zza(Map<String, zzam> map, zzam com_google_android_gms_tagmanager_zzam) {
        if (map.containsKey(com_google_android_gms_tagmanager_zzam.zzQL())) {
            String str = "Duplicate function type name: ";
            String valueOf = String.valueOf(com_google_android_gms_tagmanager_zzam.zzQL());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        map.put(com_google_android_gms_tagmanager_zzam.zzQL(), com_google_android_gms_tagmanager_zzam);
    }

    private static zzc zzh(Map<String, zzc> map, String str) {
        zzc com_google_android_gms_tagmanager_zzcx_zzc = (zzc) map.get(str);
        if (com_google_android_gms_tagmanager_zzcx_zzc != null) {
            return com_google_android_gms_tagmanager_zzcx_zzc;
        }
        com_google_android_gms_tagmanager_zzcx_zzc = new zzc();
        map.put(str, com_google_android_gms_tagmanager_zzcx_zzc);
        return com_google_android_gms_tagmanager_zzcx_zzc;
    }

    public synchronized void zzQ(List<zzi> list) {
        for (zzi com_google_android_gms_internal_zzaj_zzi : list) {
            if (com_google_android_gms_internal_zzaj_zzi.name == null || !com_google_android_gms_internal_zzaj_zzi.name.startsWith("gaExperiment:")) {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzaj_zzi);
                zzbo.m4712v(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Ignored supplemental: ").append(valueOf).toString());
            } else {
                zzal.zza(this.zzbEV, com_google_android_gms_internal_zzaj_zzi);
            }
        }
    }

    synchronized String zzRo() {
        return this.zzbHM;
    }

    zzce<Boolean> zza(com.google.android.gms.internal.zzbjf.zza com_google_android_gms_internal_zzbjf_zza, Set<String> set, zzcp com_google_android_gms_tagmanager_zzcp) {
        zzce zza = zza(this.zzbHG, com_google_android_gms_internal_zzbjf_zza, (Set) set, com_google_android_gms_tagmanager_zzcp);
        Boolean zzi = zzdl.zzi((com.google.android.gms.internal.zzak.zza) zza.getObject());
        zzdl.zzR(zzi);
        return new zzce(zzi, zza.zzQZ());
    }

    zzce<Boolean> zza(zze com_google_android_gms_internal_zzbjf_zze, Set<String> set, zzcs com_google_android_gms_tagmanager_zzcs) {
        boolean z = true;
        for (com.google.android.gms.internal.zzbjf.zza zza : com_google_android_gms_internal_zzbjf_zze.zzSZ()) {
            zzce zza2 = zza(zza, (Set) set, com_google_android_gms_tagmanager_zzcs.zzQR());
            if (((Boolean) zza2.getObject()).booleanValue()) {
                zzdl.zzR(Boolean.valueOf(false));
                return new zzce(Boolean.valueOf(false), zza2.zzQZ());
            }
            boolean z2 = z && zza2.zzQZ();
            z = z2;
        }
        for (com.google.android.gms.internal.zzbjf.zza zza3 : com_google_android_gms_internal_zzbjf_zze.zzSY()) {
            zza2 = zza(zza3, (Set) set, com_google_android_gms_tagmanager_zzcs.zzQS());
            if (((Boolean) zza2.getObject()).booleanValue()) {
                z = z && zza2.zzQZ();
            } else {
                zzdl.zzR(Boolean.valueOf(false));
                return new zzce(Boolean.valueOf(false), zza2.zzQZ());
            }
        }
        zzdl.zzR(Boolean.valueOf(true));
        return new zzce(Boolean.valueOf(true), z);
    }

    zzce<Set<com.google.android.gms.internal.zzbjf.zza>> zza(String str, Set<zze> set, Map<zze, List<com.google.android.gms.internal.zzbjf.zza>> map, Map<zze, List<String>> map2, Map<zze, List<com.google.android.gms.internal.zzbjf.zza>> map3, Map<zze, List<String>> map4, Set<String> set2, zzcw com_google_android_gms_tagmanager_zzcw) {
        return zza((Set) set, (Set) set2, new C14523(this, map, map2, map3, map4), com_google_android_gms_tagmanager_zzcw);
    }

    zzce<Set<com.google.android.gms.internal.zzbjf.zza>> zza(Set<zze> set, zzcw com_google_android_gms_tagmanager_zzcw) {
        return zza((Set) set, new HashSet(), new C14534(this), com_google_android_gms_tagmanager_zzcw);
    }

    void zza(zzam com_google_android_gms_tagmanager_zzam) {
        zza(this.zzbHH, com_google_android_gms_tagmanager_zzam);
    }

    void zzb(zzam com_google_android_gms_tagmanager_zzam) {
        zza(this.zzbHF, com_google_android_gms_tagmanager_zzam);
    }

    void zzc(zzam com_google_android_gms_tagmanager_zzam) {
        zza(this.zzbHG, com_google_android_gms_tagmanager_zzam);
    }

    public synchronized void zzgU(String str) {
        zzhr(str);
        zzv zzQK = this.zzbHE.zzhh(str).zzQK();
        for (com.google.android.gms.internal.zzbjf.zza zza : (Set) zza(this.zzbHK, zzQK.zzQz()).getObject()) {
            zza(this.zzbHF, zza, new HashSet(), zzQK.zzQy());
        }
        zzhr(null);
    }

    public zzce<com.google.android.gms.internal.zzak.zza> zzhq(String str) {
        this.zzbHN = 0;
        return zza(str, new HashSet(), this.zzbHE.zzhg(str).zzQJ());
    }

    synchronized void zzhr(String str) {
        this.zzbHM = str;
    }
}
