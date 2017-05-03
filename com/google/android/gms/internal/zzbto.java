package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class zzbto {
    private List<byte[]> zzaIP;
    private long zzaxb;
    private Map<String, Map<String, byte[]>> zzcmj;

    public zzbto(Map<String, Map<String, byte[]>> map, long j, List<byte[]> list) {
        this.zzcmj = map;
        this.zzaxb = j;
        this.zzaIP = list;
    }

    public long getTimestamp() {
        return this.zzaxb;
    }

    public void setTimestamp(long j) {
        this.zzaxb = j;
    }

    public boolean zzaA(String str, String str2) {
        return zzacg() && zzjF(str2) && zzaB(str, str2) != null;
    }

    public byte[] zzaB(String str, String str2) {
        return (str == null || !zzjF(str2)) ? null : (byte[]) ((Map) this.zzcmj.get(str2)).get(str);
    }

    public Set<String> zzaC(String str, String str2) {
        Set<String> treeSet = new TreeSet();
        if (!zzjF(str2)) {
            return treeSet;
        }
        if (str == null || str.isEmpty()) {
            return ((Map) this.zzcmj.get(str2)).keySet();
        }
        for (String str3 : ((Map) this.zzcmj.get(str2)).keySet()) {
            if (str3.startsWith(str)) {
                treeSet.add(str3);
            }
        }
        return treeSet;
    }

    public Map<String, Map<String, byte[]>> zzacf() {
        return this.zzcmj;
    }

    public boolean zzacg() {
        return (this.zzcmj == null || this.zzcmj.isEmpty()) ? false : true;
    }

    public void zzj(Map<String, byte[]> map, String str) {
        if (this.zzcmj == null) {
            this.zzcmj = new HashMap();
        }
        this.zzcmj.put(str, map);
    }

    public boolean zzjF(String str) {
        if (str == null) {
            return false;
        }
        boolean z = (!zzacg() || this.zzcmj.get(str) == null || ((Map) this.zzcmj.get(str)).isEmpty()) ? false : true;
        return z;
    }

    public List<byte[]> zzzE() {
        return this.zzaIP;
    }
}
