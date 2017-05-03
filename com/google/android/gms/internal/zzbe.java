package com.google.android.gms.internal;

import java.util.HashMap;

public class zzbe extends zzal<Integer, Long> {
    public Long zzcd;
    public Long zzcf;
    public Long zzcj;
    public Long zzck;
    public Long zzqI;
    public Long zzqJ;
    public Long zzqK;
    public Long zzqL;
    public Long zzqM;
    public Long zzqN;
    public Long zzqO;

    public zzbe(String str) {
        zzk(str);
    }

    protected HashMap<Integer, Long> zzN() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.zzqI);
        hashMap.put(Integer.valueOf(1), this.zzqJ);
        hashMap.put(Integer.valueOf(2), this.zzqK);
        hashMap.put(Integer.valueOf(3), this.zzcf);
        hashMap.put(Integer.valueOf(4), this.zzcd);
        hashMap.put(Integer.valueOf(5), this.zzqL);
        hashMap.put(Integer.valueOf(6), this.zzqM);
        hashMap.put(Integer.valueOf(7), this.zzqN);
        hashMap.put(Integer.valueOf(8), this.zzck);
        hashMap.put(Integer.valueOf(9), this.zzcj);
        hashMap.put(Integer.valueOf(10), this.zzqO);
        return hashMap;
    }

    protected void zzk(String str) {
        HashMap zzl = zzal.zzl(str);
        if (zzl != null) {
            this.zzqI = (Long) zzl.get(Integer.valueOf(0));
            this.zzqJ = (Long) zzl.get(Integer.valueOf(1));
            this.zzqK = (Long) zzl.get(Integer.valueOf(2));
            this.zzcf = (Long) zzl.get(Integer.valueOf(3));
            this.zzcd = (Long) zzl.get(Integer.valueOf(4));
            this.zzqL = (Long) zzl.get(Integer.valueOf(5));
            this.zzqM = (Long) zzl.get(Integer.valueOf(6));
            this.zzqN = (Long) zzl.get(Integer.valueOf(7));
            this.zzck = (Long) zzl.get(Integer.valueOf(8));
            this.zzcj = (Long) zzl.get(Integer.valueOf(9));
            this.zzqO = (Long) zzl.get(Integer.valueOf(10));
        }
    }
}
