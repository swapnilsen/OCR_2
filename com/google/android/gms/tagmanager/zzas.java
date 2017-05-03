package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzas {
    private final long zzagi;
    private final long zzbGm;
    private final long zzbGn;
    private String zzbGo;

    zzas(long j, long j2, long j3) {
        this.zzbGm = j;
        this.zzagi = j2;
        this.zzbGn = j3;
    }

    long zzQN() {
        return this.zzbGm;
    }

    long zzQO() {
        return this.zzbGn;
    }

    String zzQP() {
        return this.zzbGo;
    }

    void zzhi(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzbGo = str;
        }
    }
}
