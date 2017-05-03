package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR;
    private IBinder zzaFz;

    /* renamed from: com.google.android.gms.common.internal.BinderWrapper.1 */
    class C09821 implements Creator<BinderWrapper> {
        C09821() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzaR(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzcT(i);
        }

        public BinderWrapper zzaR(Parcel parcel) {
            return new BinderWrapper(null);
        }

        public BinderWrapper[] zzcT(int i) {
            return new BinderWrapper[i];
        }
    }

    static {
        CREATOR = new C09821();
    }

    public BinderWrapper() {
        this.zzaFz = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzaFz = null;
        this.zzaFz = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzaFz = null;
        this.zzaFz = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzaFz);
    }
}
