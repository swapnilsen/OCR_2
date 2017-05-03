package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.io.InputStream;

@zzme
public class zzdp extends zza {
    public static final Creator<zzdp> CREATOR;
    @Nullable
    private ParcelFileDescriptor zzyK;

    static {
        CREATOR = new zzdq();
    }

    public zzdp() {
        this(null);
    }

    public zzdp(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.zzyK = parcelFileDescriptor;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzdq.zza(this, parcel, i);
    }

    public synchronized boolean zzew() {
        return this.zzyK != null;
    }

    @Nullable
    public synchronized InputStream zzex() {
        InputStream inputStream = null;
        synchronized (this) {
            if (this.zzyK != null) {
                inputStream = new AutoCloseInputStream(this.zzyK);
                this.zzyK = null;
            }
        }
        return inputStream;
    }

    synchronized ParcelFileDescriptor zzey() {
        return this.zzyK;
    }
}
