package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public interface zzzs extends IInterface {

    public static abstract class zza extends Binder implements zzzs {

        private static class zza implements zzzs {
            private IBinder zzrk;

            zza(IBinder iBinder) {
                this.zzrk = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrk;
            }

            public void zza(zzzr com_google_android_gms_internal_zzzr) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_zzzr != null) {
                        iBinder = com_google_android_gms_internal_zzzr.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrk.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzzr com_google_android_gms_internal_zzzr, zzzm com_google_android_gms_internal_zzzm) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_zzzr != null) {
                        iBinder = com_google_android_gms_internal_zzzr.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (com_google_android_gms_internal_zzzm != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzzm.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrk.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(zzzr com_google_android_gms_internal_zzzr) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_zzzr != null) {
                        iBinder = com_google_android_gms_internal_zzzr.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrk.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(zzzr com_google_android_gms_internal_zzzr) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_zzzr != null) {
                        iBinder = com_google_android_gms_internal_zzzr.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrk.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzd(zzzr com_google_android_gms_internal_zzzr) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_zzzr != null) {
                        iBinder = com_google_android_gms_internal_zzzr.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrk.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzzs zzbo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzzs)) ? new zza(iBinder) : (zzzs) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zza(com.google.android.gms.internal.zzzr.zza.zzbn(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzzm) zzzm.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zza(com.google.android.gms.internal.zzzr.zza.zzbn(parcel.readStrongBinder()));
                    return true;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zzb(com.google.android.gms.internal.zzzr.zza.zzbn(parcel.readStrongBinder()));
                    return true;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zzc(com.google.android.gms.internal.zzzr.zza.zzbn(parcel.readStrongBinder()));
                    return true;
                case Type.OTHER_PROFILE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zzd(com.google.android.gms.internal.zzzr.zza.zzbn(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzzr com_google_android_gms_internal_zzzr);

    void zza(zzzr com_google_android_gms_internal_zzzr, zzzm com_google_android_gms_internal_zzzm);

    void zzb(zzzr com_google_android_gms_internal_zzzr);

    void zzc(zzzr com_google_android_gms_internal_zzzr);

    void zzd(zzzr com_google_android_gms_internal_zzzr);
}
