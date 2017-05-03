package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzf extends zzam {
    private static final String ID;
    private final Context mContext;

    static {
        ID = zzah.APP_ID.toString();
    }

    public zzf(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        return zzdl.zzR(this.mContext.getPackageName());
    }
}
