package com.google.android.gms.internal;

import android.os.Bundle;

@zzme
public class zzjc {
    private static zzjc zzJo;
    private int zzJp;
    private int zzJq;
    private int zzJr;
    private int zzJs;
    private int zzJt;

    static {
        zzJo = new zzjc();
    }

    public static zzjc zzgC() {
        return zzJo;
    }

    public Bundle asBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("ipl", this.zzJp);
        bundle.putInt("ipds", this.zzJq);
        bundle.putInt("ipde", this.zzJr);
        bundle.putInt("iph", this.zzJs);
        bundle.putInt("ipm", this.zzJt);
        return bundle;
    }

    void zzE(int i) {
        this.zzJp += i;
    }

    void zzgD() {
        this.zzJq++;
    }

    void zzgE() {
        this.zzJr++;
    }

    void zzgF() {
        this.zzJs++;
    }

    void zzgG() {
        this.zzJt++;
    }

    public int zzgH() {
        return this.zzJq;
    }

    public int zzgI() {
        return this.zzJr;
    }

    public int zzgJ() {
        return this.zzJs;
    }
}
