package com.google.android.gms.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class zzbtp implements FirebaseRemoteConfigInfo {
    private long zzcmk;
    private int zzcml;
    private FirebaseRemoteConfigSettings zzcmm;

    public FirebaseRemoteConfigSettings getConfigSettings() {
        return this.zzcmm;
    }

    public long getFetchTimeMillis() {
        return this.zzcmk;
    }

    public int getLastFetchStatus() {
        return this.zzcml;
    }

    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.zzcmm = firebaseRemoteConfigSettings;
    }

    public void zzaU(long j) {
        this.zzcmk = j;
    }

    public void zzqJ(int i) {
        this.zzcml = i;
    }
}
