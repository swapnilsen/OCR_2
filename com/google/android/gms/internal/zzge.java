package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzw;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@zzme
public class zzge {
    private Context mContext;
    private boolean zzFx;
    private String zzFy;
    private Map<String, String> zzFz;
    private String zzwd;

    public zzge(Context context, String str) {
        this.mContext = null;
        this.zzwd = null;
        this.mContext = context;
        this.zzwd = str;
        this.zzFx = ((Boolean) zzgd.zzBZ.get()).booleanValue();
        this.zzFy = (String) zzgd.zzCa.get();
        this.zzFz = new LinkedHashMap();
        this.zzFz.put("s", "gmob_sdk");
        this.zzFz.put("v", "3");
        this.zzFz.put("os", VERSION.RELEASE);
        this.zzFz.put("sdk", VERSION.SDK);
        this.zzFz.put("device", zzw.zzcM().zzkN());
        this.zzFz.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        this.zzFz.put("is_lite_sdk", zzw.zzcM().zzU(context) ? "1" : "0");
        Future zzA = zzw.zzcV().zzA(this.mContext);
        try {
            zzA.get();
            this.zzFz.put("network_coarse", Integer.toString(((zzni) zzA.get()).zzUQ));
            this.zzFz.put("network_fine", Integer.toString(((zzni) zzA.get()).zzUR));
        } catch (Throwable e) {
            zzw.zzcQ().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    Context getContext() {
        return this.mContext;
    }

    String zzdA() {
        return this.zzwd;
    }

    boolean zzfu() {
        return this.zzFx;
    }

    String zzfv() {
        return this.zzFy;
    }

    Map<String, String> zzfw() {
        return this.zzFz;
    }
}
