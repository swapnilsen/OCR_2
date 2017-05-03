package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzam {
    private final Set<String> zzbGj;
    private final String zzbGk;

    public zzam(String str, String... strArr) {
        this.zzbGk = str;
        this.zzbGj = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.zzbGj.add(add);
        }
    }

    public String zzQL() {
        return this.zzbGk;
    }

    public Set<String> zzQM() {
        return this.zzbGj;
    }

    public abstract boolean zzQb();

    public abstract zza zzZ(Map<String, zza> map);

    boolean zzf(Set<String> set) {
        return set.containsAll(this.zzbGj);
    }
}
