package com.google.android.gms.internal;

import java.util.HashMap;

public class zzbg extends zzal<Integer, Long> {
    public Long zzqQ;

    public zzbg(String str) {
        zzk(str);
    }

    protected HashMap<Integer, Long> zzN() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.zzqQ);
        return hashMap;
    }

    protected void zzk(String str) {
        HashMap zzl = zzal.zzl(str);
        if (zzl != null) {
            this.zzqQ = (Long) zzl.get(Integer.valueOf(0));
        }
    }
}
