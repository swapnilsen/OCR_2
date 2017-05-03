package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzaqk extends zza {
    public static final Creator<zzaqk> CREATOR;
    public final int versionCode;
    private zzag.zza zzbgk;
    private byte[] zzbgl;

    static {
        CREATOR = new zzaql();
    }

    zzaqk(int i, byte[] bArr) {
        this.versionCode = i;
        this.zzbgk = null;
        this.zzbgl = bArr;
        zzzT();
    }

    private void zzzR() {
        if (!zzzS()) {
            try {
                this.zzbgk = zzag.zza.zzd(this.zzbgl);
                this.zzbgl = null;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        zzzT();
    }

    private boolean zzzS() {
        return this.zzbgk != null;
    }

    private void zzzT() {
        if (this.zzbgk == null && this.zzbgl != null) {
            return;
        }
        if (this.zzbgk != null && this.zzbgl == null) {
            return;
        }
        if (this.zzbgk != null && this.zzbgl != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.zzbgk == null && this.zzbgl == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaql.zza(this, parcel, i);
    }

    public byte[] zzGM() {
        return this.zzbgl != null ? this.zzbgl : zzbxt.zzf(this.zzbgk);
    }

    public zzag.zza zzGN() {
        zzzR();
        return this.zzbgk;
    }
}
