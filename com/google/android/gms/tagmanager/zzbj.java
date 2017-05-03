package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class zzbj extends zzam {
    private static final String ID;

    static {
        ID = zzah.LANGUAGE.toString();
    }

    public zzbj() {
        super(ID, new String[0]);
    }

    public /* bridge */ /* synthetic */ String zzQL() {
        return super.zzQL();
    }

    public /* bridge */ /* synthetic */ Set zzQM() {
        return super.zzQM();
    }

    public boolean zzQb() {
        return false;
    }

    public zza zzZ(Map<String, zza> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzdl.zzRR();
        }
        String language = locale.getLanguage();
        return language == null ? zzdl.zzRR() : zzdl.zzR(language.toLowerCase());
    }
}
