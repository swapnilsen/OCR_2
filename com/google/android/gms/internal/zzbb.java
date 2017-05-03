package com.google.android.gms.internal;

import java.util.HashMap;

public class zzbb extends zzal<Integer, Object> {
    public Long zzqi;
    public Boolean zzqj;
    public Boolean zzqk;

    public zzbb(String str) {
        zzk(str);
    }

    protected HashMap<Integer, Object> zzN() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.zzqi);
        hashMap.put(Integer.valueOf(1), this.zzqj);
        hashMap.put(Integer.valueOf(2), this.zzqk);
        return hashMap;
    }

    protected void zzk(String str) {
        HashMap zzl = zzal.zzl(str);
        if (zzl != null) {
            this.zzqi = (Long) zzl.get(Integer.valueOf(0));
            this.zzqj = (Boolean) zzl.get(Integer.valueOf(1));
            this.zzqk = (Boolean) zzl.get(Integer.valueOf(2));
        }
    }
}
