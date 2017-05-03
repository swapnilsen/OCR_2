package com.google.android.gms.auth.api.signin.internal;

public class zzh {
    static int zzakE;
    private int zzakF;

    static {
        zzakE = 31;
    }

    public zzh() {
        this.zzakF = 1;
    }

    public zzh zzae(boolean z) {
        this.zzakF = (z ? 1 : 0) + (this.zzakF * zzakE);
        return this;
    }

    public zzh zzq(Object obj) {
        this.zzakF = (obj == null ? 0 : obj.hashCode()) + (this.zzakF * zzakE);
        return this;
    }

    public int zzru() {
        return this.zzakF;
    }
}
