package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzar extends zzam {
    private static final String ID;
    private static final String zzbGf;
    private static final String zzbGh;
    private static final String zzbGl;

    static {
        ID = zzah.HASH.toString();
        zzbGf = zzai.ARG0.toString();
        zzbGl = zzai.ALGORITHM.toString();
        zzbGh = zzai.INPUT_FORMAT.toString();
    }

    public zzar() {
        super(ID, zzbGf);
    }

    private byte[] zzf(String str, byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbGf);
        if (com_google_android_gms_internal_zzak_zza == null || com_google_android_gms_internal_zzak_zza == zzdl.zzRR()) {
            return zzdl.zzRR();
        }
        byte[] bytes;
        String zze = zzdl.zze(com_google_android_gms_internal_zzak_zza);
        com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbGl);
        String zze2 = com_google_android_gms_internal_zzak_zza == null ? "MD5" : zzdl.zze(com_google_android_gms_internal_zzak_zza);
        com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbGh);
        Object zze3 = com_google_android_gms_internal_zzak_zza == null ? "text" : zzdl.zze(com_google_android_gms_internal_zzak_zza);
        if ("text".equals(zze3)) {
            bytes = zze.getBytes();
        } else if ("base16".equals(zze3)) {
            bytes = zzk.zzgR(zze);
        } else {
            zze2 = "Hash: unknown input format: ";
            String valueOf = String.valueOf(zze3);
            zzbo.m4711e(valueOf.length() != 0 ? zze2.concat(valueOf) : new String(zze2));
            return zzdl.zzRR();
        }
        try {
            return zzdl.zzR(zzk.zzq(zzf(zze2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            zze = "Hash: unknown algorithm: ";
            valueOf = String.valueOf(zze2);
            zzbo.m4711e(valueOf.length() != 0 ? zze.concat(valueOf) : new String(zze));
            return zzdl.zzRR();
        }
    }
}
