package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcm extends zzam {
    private static final String ID;
    private static final String zzbHn;
    private static final String zzbHo;
    private static final String zzbHp;
    private static final String zzbHq;

    static {
        ID = zzah.REGEX_GROUP.toString();
        zzbHn = zzai.ARG0.toString();
        zzbHo = zzai.ARG1.toString();
        zzbHp = zzai.IGNORE_CASE.toString();
        zzbHq = zzai.GROUP.toString();
    }

    public zzcm() {
        super(ID, zzbHn, zzbHo);
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbHn);
        zza com_google_android_gms_internal_zzak_zza2 = (zza) map.get(zzbHo);
        if (com_google_android_gms_internal_zzak_zza == null || com_google_android_gms_internal_zzak_zza == zzdl.zzRR() || com_google_android_gms_internal_zzak_zza2 == null || com_google_android_gms_internal_zzak_zza2 == zzdl.zzRR()) {
            return zzdl.zzRR();
        }
        int intValue;
        int i = 64;
        if (zzdl.zzi((zza) map.get(zzbHp)).booleanValue()) {
            i = 66;
        }
        zza com_google_android_gms_internal_zzak_zza3 = (zza) map.get(zzbHq);
        if (com_google_android_gms_internal_zzak_zza3 != null) {
            Long zzg = zzdl.zzg(com_google_android_gms_internal_zzak_zza3);
            if (zzg == zzdl.zzRM()) {
                return zzdl.zzRR();
            }
            intValue = zzg.intValue();
            if (intValue < 0) {
                return zzdl.zzRR();
            }
        }
        intValue = 1;
        try {
            CharSequence zze = zzdl.zze(com_google_android_gms_internal_zzak_zza);
            Object obj = null;
            Matcher matcher = Pattern.compile(zzdl.zze(com_google_android_gms_internal_zzak_zza2), i).matcher(zze);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? zzdl.zzRR() : zzdl.zzR(obj);
        } catch (PatternSyntaxException e) {
            return zzdl.zzRR();
        }
    }
}
