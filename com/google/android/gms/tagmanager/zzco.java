package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzco extends zzam {
    private static final String ID;
    private final Context mContext;

    static {
        ID = zzah.RESOLUTION.toString();
    }

    public zzco(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return zzdl.zzR(i + "x" + displayMetrics.heightPixels);
    }
}
