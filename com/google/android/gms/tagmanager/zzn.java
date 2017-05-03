package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzn extends zzam {
    private static final String ID;
    private static final String VALUE;

    static {
        ID = zzah.CONSTANT.toString();
        VALUE = zzai.VALUE.toString();
    }

    public zzn() {
        super(ID, VALUE);
    }

    public static String zzQd() {
        return ID;
    }

    public static String zzQe() {
        return VALUE;
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        return (zza) map.get(VALUE);
    }
}
