package com.google.android.gms.internal;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class zztl implements zzsn {
    public String zzabs;
    public double zzagO;
    public int zzagP;
    public int zzagQ;
    public int zzagR;
    public int zzagS;
    public Map<String, String> zzagT;

    public zztl() {
        this.zzagO = -1.0d;
        this.zzagP = -1;
        this.zzagQ = -1;
        this.zzagR = -1;
        this.zzagS = -1;
        this.zzagT = new HashMap();
    }

    public int getSessionTimeout() {
        return this.zzagP;
    }

    public String getTrackingId() {
        return this.zzabs;
    }

    public String zzcd(String str) {
        String str2 = (String) this.zzagT.get(str);
        return str2 != null ? str2 : str;
    }

    public boolean zzqA() {
        return this.zzagS == 1;
    }

    public boolean zzqs() {
        return this.zzabs != null;
    }

    public boolean zzqt() {
        return this.zzagO >= 0.0d;
    }

    public double zzqu() {
        return this.zzagO;
    }

    public boolean zzqv() {
        return this.zzagP >= 0;
    }

    public boolean zzqw() {
        return this.zzagQ != -1;
    }

    public boolean zzqx() {
        return this.zzagQ == 1;
    }

    public boolean zzqy() {
        return this.zzagR != -1;
    }

    public boolean zzqz() {
        return this.zzagR == 1;
    }

    public String zzr(Activity activity) {
        return zzcd(activity.getClass().getCanonicalName());
    }
}
