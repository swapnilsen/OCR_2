package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import java.util.List;

public interface zzadz extends IInterface {

    public static abstract class zza extends Binder implements zzadz {

        private static class zza implements zzadz {
            private IBinder zzrk;

            zza(IBinder iBinder) {
                this.zzrk = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrk;
            }

            public void zza(zzady com_google_android_gms_internal_zzady, zzadu com_google_android_gms_internal_zzadu) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzady != null ? com_google_android_gms_internal_zzady.asBinder() : null);
                    if (com_google_android_gms_internal_zzadu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzadu.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrk.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzady com_google_android_gms_internal_zzady, String str, zzayx com_google_android_gms_internal_zzayx, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzady != null ? com_google_android_gms_internal_zzady.asBinder() : null);
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzayx != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzayx.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    this.zzrk.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzady com_google_android_gms_internal_zzady, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzady != null ? com_google_android_gms_internal_zzady.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzrk.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzady com_google_android_gms_internal_zzady, String str, List list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzady != null ? com_google_android_gms_internal_zzady.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeList(list);
                    this.zzrk.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzady com_google_android_gms_internal_zzady, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzady != null ? com_google_android_gms_internal_zzady.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzrk.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzadz zzbE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.config.internal.IConfigService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzadz)) ? new zza(iBinder) : (zzadz) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzadu com_google_android_gms_internal_zzadu = null;
            zzady zzbD;
            switch (i) {
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zza(com.google.android.gms.internal.zzady.zza.zzbD(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Type.OTHER_PROFILE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zzb(com.google.android.gms.internal.zzady.zza.zzbD(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Type.CONTRIBUTOR /*6*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zza(com.google.android.gms.internal.zzady.zza.zzbD(parcel.readStrongBinder()), parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case Type.WEBSITE /*7*/:
                    zzayx com_google_android_gms_internal_zzayx;
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zzbD = com.google.android.gms.internal.zzady.zza.zzbD(parcel.readStrongBinder());
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzayx = (zzayx) zzayx.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzbD, readString, com_google_android_gms_internal_zzayx, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zzbD = com.google.android.gms.internal.zzady.zza.zzbD(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzadu = (zzadu) zzadu.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzbD, com_google_android_gms_internal_zzadu);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.config.internal.IConfigService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzady com_google_android_gms_internal_zzady, zzadu com_google_android_gms_internal_zzadu);

    void zza(zzady com_google_android_gms_internal_zzady, String str, zzayx com_google_android_gms_internal_zzayx, String str2);

    void zza(zzady com_google_android_gms_internal_zzady, String str, String str2);

    void zza(zzady com_google_android_gms_internal_zzady, String str, List list);

    void zzb(zzady com_google_android_gms_internal_zzady, String str, String str2);
}
