package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public interface zzmt extends IInterface {

    public static abstract class zza extends Binder implements zzmt {

        private static class zza implements zzmt {
            private IBinder zzrk;

            zza(IBinder iBinder) {
                this.zzrk = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrk;
            }

            public void zza(zzmk com_google_android_gms_internal_zzmk, zzmu com_google_android_gms_internal_zzmu) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (com_google_android_gms_internal_zzmk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzmk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzmu != null ? com_google_android_gms_internal_zzmu.asBinder() : null);
                    this.zzrk.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzmn zzd(zzmk com_google_android_gms_internal_zzmk) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (com_google_android_gms_internal_zzmk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzmk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrk.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzmn com_google_android_gms_internal_zzmn = obtain2.readInt() != 0 ? (zzmn) zzmn.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return com_google_android_gms_internal_zzmn;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static zzmt zzae(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmt)) ? new zza(iBinder) : (zzmt) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzmk com_google_android_gms_internal_zzmk = null;
            switch (i) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzmk = (zzmk) zzmk.CREATOR.createFromParcel(parcel);
                    }
                    zzmn zzd = zzd(com_google_android_gms_internal_zzmk);
                    parcel2.writeNoException();
                    if (zzd != null) {
                        parcel2.writeInt(1);
                        zzd.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzmk = (zzmk) zzmk.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzmk, com.google.android.gms.internal.zzmu.zza.zzaf(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzmk com_google_android_gms_internal_zzmk, zzmu com_google_android_gms_internal_zzmu);

    zzmn zzd(zzmk com_google_android_gms_internal_zzmk);
}
