package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzg extends zzam {
    private static final String ID;
    private final Context mContext;

    static {
        ID = zzah.APP_NAME.toString();
    }

    public zzg(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return zzdl.zzR(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            zzbo.zzb("App name is not found.", e);
            return zzdl.zzRR();
        }
    }
}
