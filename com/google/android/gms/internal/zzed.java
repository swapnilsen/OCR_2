package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@zzme
public final class zzed {
    private Bundle mExtras;
    private Location zzcV;
    private boolean zzsS;
    private long zzzj;
    private int zzzk;
    private List<String> zzzl;
    private boolean zzzm;
    private int zzzn;
    private String zzzo;
    private zzfp zzzp;
    private String zzzq;
    private Bundle zzzr;
    private Bundle zzzs;
    private List<String> zzzt;
    private String zzzu;
    private String zzzv;
    private boolean zzzw;

    public zzed() {
        this.zzzj = -1;
        this.mExtras = new Bundle();
        this.zzzk = -1;
        this.zzzl = new ArrayList();
        this.zzzm = false;
        this.zzzn = -1;
        this.zzsS = false;
        this.zzzo = null;
        this.zzzp = null;
        this.zzcV = null;
        this.zzzq = null;
        this.zzzr = new Bundle();
        this.zzzs = new Bundle();
        this.zzzt = new ArrayList();
        this.zzzu = null;
        this.zzzv = null;
        this.zzzw = false;
    }

    public zzed(zzec com_google_android_gms_internal_zzec) {
        this.zzzj = com_google_android_gms_internal_zzec.zzyT;
        this.mExtras = com_google_android_gms_internal_zzec.extras;
        this.zzzk = com_google_android_gms_internal_zzec.zzyU;
        this.zzzl = com_google_android_gms_internal_zzec.zzyV;
        this.zzzm = com_google_android_gms_internal_zzec.zzyW;
        this.zzzn = com_google_android_gms_internal_zzec.zzyX;
        this.zzsS = com_google_android_gms_internal_zzec.zzyY;
        this.zzzo = com_google_android_gms_internal_zzec.zzyZ;
        this.zzzp = com_google_android_gms_internal_zzec.zzza;
        this.zzcV = com_google_android_gms_internal_zzec.zzzb;
        this.zzzq = com_google_android_gms_internal_zzec.zzzc;
        this.zzzr = com_google_android_gms_internal_zzec.zzzd;
        this.zzzs = com_google_android_gms_internal_zzec.zzze;
        this.zzzt = com_google_android_gms_internal_zzec.zzzf;
        this.zzzu = com_google_android_gms_internal_zzec.zzzg;
        this.zzzv = com_google_android_gms_internal_zzec.zzzh;
    }

    public zzed zza(@Nullable Location location) {
        this.zzcV = location;
        return this;
    }

    public zzec zzeC() {
        return new zzec(7, this.zzzj, this.mExtras, this.zzzk, this.zzzl, this.zzzm, this.zzzn, this.zzsS, this.zzzo, this.zzzp, this.zzcV, this.zzzq, this.zzzr, this.zzzs, this.zzzt, this.zzzu, this.zzzv, false);
    }
}
