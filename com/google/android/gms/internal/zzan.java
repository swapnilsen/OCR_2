package com.google.android.gms.internal;

import java.util.HashMap;

public class zzan extends zzal<Integer, Object> {
    public String zzaN;
    public String zzaP;
    public String zzaQ;
    public String zzaR;
    public long zzlE;

    public zzan() {
        this.zzaN = "E";
        this.zzlE = -1;
        this.zzaP = "E";
        this.zzaQ = "E";
        this.zzaR = "E";
    }

    public zzan(String str) {
        this();
        zzk(str);
    }

    protected HashMap<Integer, Object> zzN() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.zzaN);
        hashMap.put(Integer.valueOf(4), this.zzaR);
        hashMap.put(Integer.valueOf(3), this.zzaQ);
        hashMap.put(Integer.valueOf(2), this.zzaP);
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.zzlE));
        return hashMap;
    }

    protected void zzk(String str) {
        HashMap zzl = zzal.zzl(str);
        if (zzl != null) {
            this.zzaN = zzl.get(Integer.valueOf(0)) == null ? "E" : (String) zzl.get(Integer.valueOf(0));
            this.zzlE = zzl.get(Integer.valueOf(1)) == null ? -1 : ((Long) zzl.get(Integer.valueOf(1))).longValue();
            this.zzaP = zzl.get(Integer.valueOf(2)) == null ? "E" : (String) zzl.get(Integer.valueOf(2));
            this.zzaQ = zzl.get(Integer.valueOf(3)) == null ? "E" : (String) zzl.get(Integer.valueOf(3));
            this.zzaR = zzl.get(Integer.valueOf(4)) == null ? "E" : (String) zzl.get(Integer.valueOf(4));
        }
    }
}
