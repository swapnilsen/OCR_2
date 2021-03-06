package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v7.cardview.C0269R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public interface zzbaq extends IInterface {

    public static abstract class zza extends Binder implements zzbaq {

        private static class zza implements zzbaq {
            private IBinder zzrk;

            zza(IBinder iBinder) {
                this.zzrk = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrk;
            }

            public void zza(int i, Account account, zzbap com_google_android_gms_internal_zzbap) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzbap != null ? com_google_android_gms_internal_zzbap.asBinder() : null);
                    this.zzrk.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzad com_google_android_gms_common_internal_zzad, zzx com_google_android_gms_common_internal_zzx) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_common_internal_zzad != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzad.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_common_internal_zzx != null ? com_google_android_gms_common_internal_zzx.asBinder() : null);
                    this.zzrk.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_common_internal_zzd, zzbap com_google_android_gms_internal_zzbap) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_common_internal_zzd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzbap != null ? com_google_android_gms_internal_zzbap.asBinder() : null);
                    this.zzrk.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzr com_google_android_gms_common_internal_zzr, int i, boolean z) {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_common_internal_zzr != null ? com_google_android_gms_common_internal_zzr.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzrk.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzban com_google_android_gms_internal_zzban) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_internal_zzban != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzban.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrk.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzbar com_google_android_gms_internal_zzbar, zzbap com_google_android_gms_internal_zzbap) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_internal_zzbar != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzbar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzbap != null ? com_google_android_gms_internal_zzbap.asBinder() : null);
                    this.zzrk.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzbau com_google_android_gms_internal_zzbau, zzbap com_google_android_gms_internal_zzbap) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_internal_zzbau != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzbau.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzbap != null ? com_google_android_gms_internal_zzbap.asBinder() : null);
                    this.zzrk.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaP(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzrk.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaQ(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzrk.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzbap com_google_android_gms_internal_zzbap) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzbap != null ? com_google_android_gms_internal_zzbap.asBinder() : null);
                    this.zzrk.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zznv(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.zzrk.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzbaq zzff(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzbaq)) ? new zza(iBinder) : (zzbaq) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            zzbau com_google_android_gms_internal_zzbau = null;
            switch (i) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    zzd com_google_android_gms_common_internal_zzd;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzd = (zzd) zzd.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_common_internal_zzd, com.google.android.gms.internal.zzbap.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    zzban com_google_android_gms_internal_zzban;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzban = (zzban) zzban.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzban);
                    parcel2.writeNoException();
                    return true;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzaP(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case Type.OTHER_PROFILE /*5*/:
                    zzad com_google_android_gms_common_internal_zzad;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzad = (zzad) zzad.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_common_internal_zzad, com.google.android.gms.common.internal.zzx.zza.zzbw(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Type.WEBSITE /*7*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zznv(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    Account account;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(parcel);
                    }
                    zza(readInt, account, com.google.android.gms.internal.zzbap.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzr zzbr = com.google.android.gms.common.internal.zzr.zza.zzbr(parcel.readStrongBinder());
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbr, readInt2, z);
                    parcel2.writeNoException();
                    return true;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    zzbar com_google_android_gms_internal_zzbar;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzbar = (zzbar) zzbar.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzbar, com.google.android.gms.internal.zzbap.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzb(com.google.android.gms.internal.zzbap.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzbau = (zzbau) zzbau.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzbau, com.google.android.gms.internal.zzbap.zza.zzfe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zzaQ(z);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(int i, Account account, zzbap com_google_android_gms_internal_zzbap);

    void zza(zzad com_google_android_gms_common_internal_zzad, zzx com_google_android_gms_common_internal_zzx);

    void zza(zzd com_google_android_gms_common_internal_zzd, zzbap com_google_android_gms_internal_zzbap);

    void zza(zzr com_google_android_gms_common_internal_zzr, int i, boolean z);

    void zza(zzban com_google_android_gms_internal_zzban);

    void zza(zzbar com_google_android_gms_internal_zzbar, zzbap com_google_android_gms_internal_zzbap);

    void zza(zzbau com_google_android_gms_internal_zzbau, zzbap com_google_android_gms_internal_zzbap);

    void zzaP(boolean z);

    void zzaQ(boolean z);

    void zzb(zzbap com_google_android_gms_internal_zzbap);

    void zznv(int i);
}
