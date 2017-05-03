package com.google.android.gms.internal;

import java.util.HashMap;

public class zzbc extends zzal<Integer, Long> {
    public Long zzql;
    public Long zzqm;

    public zzbc(String str) {
        zzk(str);
    }

    protected HashMap<Integer, Long> zzN() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.zzql);
        hashMap.put(Integer.valueOf(1), this.zzqm);
        return hashMap;
    }

    protected void zzk(String str) {
        HashMap zzl = zzal.zzl(str);
        if (zzl != null) {
            this.zzql = (Long) zzl.get(Integer.valueOf(0));
            this.zzqm = (Long) zzl.get(Integer.valueOf(1));
        }
    }
}
