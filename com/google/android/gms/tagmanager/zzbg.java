package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.nend.android.NendIconError;

class zzbg extends zzam {
    private static final String ID;
    private static final String zzbGf;
    private static final String zzbGx;
    private static final String zzbGy;
    private static final String zzbGz;

    /* renamed from: com.google.android.gms.tagmanager.zzbg.1 */
    static /* synthetic */ class C14441 {
        static final /* synthetic */ int[] zzbGA;

        static {
            zzbGA = new int[zza.values().length];
            try {
                zzbGA[zza.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzbGA[zza.BACKSLASH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzbGA[zza.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private enum zza {
        NONE,
        URL,
        BACKSLASH
    }

    static {
        ID = zzah.JOINER.toString();
        zzbGf = zzai.ARG0.toString();
        zzbGx = zzai.ITEM_SEPARATOR.toString();
        zzbGy = zzai.KEY_VALUE_SEPARATOR.toString();
        zzbGz = zzai.ESCAPE.toString();
    }

    public zzbg() {
        super(ID, zzbGf);
    }

    private String zza(String str, zza com_google_android_gms_tagmanager_zzbg_zza, Set<Character> set) {
        switch (C14441.zzbGA[com_google_android_gms_tagmanager_zzbg_zza.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                try {
                    return zzdp.zzhD(str);
                } catch (Throwable e) {
                    zzbo.zzb("Joiner: unsupported encoding", e);
                    return str;
                }
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    String str3 = "\\";
                    replace = String.valueOf(ch2);
                    str2 = str2.replace(ch2, replace.length() != 0 ? str3.concat(replace) : new String(str3));
                }
                return str2;
            default:
                return str;
        }
    }

    private void zza(StringBuilder stringBuilder, String str, zza com_google_android_gms_tagmanager_zzbg_zza, Set<Character> set) {
        stringBuilder.append(zza(str, com_google_android_gms_tagmanager_zzbg_zza, set));
    }

    private void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public boolean zzQb() {
        return true;
    }

    public com.google.android.gms.internal.zzak.zza zzZ(Map<String, com.google.android.gms.internal.zzak.zza> map) {
        com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza = (com.google.android.gms.internal.zzak.zza) map.get(zzbGf);
        if (com_google_android_gms_internal_zzak_zza == null) {
            return zzdl.zzRR();
        }
        zza com_google_android_gms_tagmanager_zzbg_zza;
        com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza2 = (com.google.android.gms.internal.zzak.zza) map.get(zzbGx);
        String zze = com_google_android_gms_internal_zzak_zza2 != null ? zzdl.zze(com_google_android_gms_internal_zzak_zza2) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        com_google_android_gms_internal_zzak_zza2 = (com.google.android.gms.internal.zzak.zza) map.get(zzbGy);
        String zze2 = com_google_android_gms_internal_zzak_zza2 != null ? zzdl.zze(com_google_android_gms_internal_zzak_zza2) : "=";
        zza com_google_android_gms_tagmanager_zzbg_zza2 = zza.NONE;
        com_google_android_gms_internal_zzak_zza2 = (com.google.android.gms.internal.zzak.zza) map.get(zzbGz);
        Set set;
        if (com_google_android_gms_internal_zzak_zza2 != null) {
            String zze3 = zzdl.zze(com_google_android_gms_internal_zzak_zza2);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(zze3)) {
                com_google_android_gms_tagmanager_zzbg_zza = zza.URL;
                set = null;
            } else if ("backslash".equals(zze3)) {
                com_google_android_gms_tagmanager_zzbg_zza = zza.BACKSLASH;
                set = new HashSet();
                zza(set, zze);
                zza(set, zze2);
                set.remove(Character.valueOf('\\'));
            } else {
                zze = "Joiner: unsupported escape type: ";
                String valueOf = String.valueOf(zze3);
                zzbo.m4711e(valueOf.length() != 0 ? zze.concat(valueOf) : new String(zze));
                return zzdl.zzRR();
            }
        }
        set = null;
        com_google_android_gms_tagmanager_zzbg_zza = com_google_android_gms_tagmanager_zzbg_zza2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (com_google_android_gms_internal_zzak_zza.type) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                Object obj = 1;
                com.google.android.gms.internal.zzak.zza[] com_google_android_gms_internal_zzak_zzaArr = com_google_android_gms_internal_zzak_zza.zzlu;
                int length = com_google_android_gms_internal_zzak_zzaArr.length;
                int i = 0;
                while (i < length) {
                    com.google.android.gms.internal.zzak.zza com_google_android_gms_internal_zzak_zza3 = com_google_android_gms_internal_zzak_zzaArr[i];
                    if (obj == null) {
                        stringBuilder.append(zze);
                    }
                    zza(stringBuilder, zzdl.zze(com_google_android_gms_internal_zzak_zza3), com_google_android_gms_tagmanager_zzbg_zza, set);
                    i++;
                    obj = null;
                }
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                for (int i2 = 0; i2 < com_google_android_gms_internal_zzak_zza.zzlv.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(zze);
                    }
                    String zze4 = zzdl.zze(com_google_android_gms_internal_zzak_zza.zzlv[i2]);
                    String zze5 = zzdl.zze(com_google_android_gms_internal_zzak_zza.zzlw[i2]);
                    zza(stringBuilder, zze4, com_google_android_gms_tagmanager_zzbg_zza, set);
                    stringBuilder.append(zze2);
                    zza(stringBuilder, zze5, com_google_android_gms_tagmanager_zzbg_zza, set);
                }
                break;
            default:
                zza(stringBuilder, zzdl.zze(com_google_android_gms_internal_zzak_zza), com_google_android_gms_tagmanager_zzbg_zza, set);
                break;
        }
        return zzdl.zzR(stringBuilder.toString());
    }
}
