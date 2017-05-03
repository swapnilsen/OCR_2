package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public interface zzew extends IInterface {

    public static abstract class zza extends Binder implements zzew {

        private static class zza implements zzew {
            private IBinder zzrk;

            zza(IBinder iBinder) {
                this.zzrk = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrk;
            }

            public zzer createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzka com_google_android_gms_internal_zzka, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzka != null) {
                        iBinder = com_google_android_gms_internal_zzka.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzrk.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    zzer zzo = com.google.android.gms.internal.zzer.zza.zzo(obtain2.readStrongBinder());
                    return zzo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzkz createAdOverlay(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    this.zzrk.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    zzkz zzT = com.google.android.gms.internal.zzkz.zza.zzT(obtain2.readStrongBinder());
                    return zzT;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzet createBannerAdManager(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzka != null) {
                        iBinder = com_google_android_gms_internal_zzka.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzrk.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzet zzq = com.google.android.gms.internal.zzet.zza.zzq(obtain2.readStrongBinder());
                    return zzq;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzlf createInAppPurchaseManager(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    this.zzrk.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    zzlf zzY = com.google.android.gms.internal.zzlf.zza.zzY(obtain2.readStrongBinder());
                    return zzY;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzet createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzka != null) {
                        iBinder = com_google_android_gms_internal_zzka.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzrk.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    zzet zzq = com.google.android.gms.internal.zzet.zza.zzq(obtain2.readStrongBinder());
                    return zzq;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzhh createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (iObjectWrapper2 != null) {
                        iBinder = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrk.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    zzhh zzC = com.google.android.gms.internal.zzhh.zza.zzC(obtain2.readStrongBinder());
                    return zzC;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zznu createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzka com_google_android_gms_internal_zzka, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (com_google_android_gms_internal_zzka != null) {
                        iBinder = com_google_android_gms_internal_zzka.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzrk.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    zznu zzah = com.google.android.gms.internal.zznu.zza.zzah(obtain2.readStrongBinder());
                    return zzah;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzet createSearchAdManager(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (com_google_android_gms_internal_zzeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzeg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzrk.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    zzet zzq = com.google.android.gms.internal.zzet.zza.zzq(obtain2.readStrongBinder());
                    return zzq;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzey getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    this.zzrk.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    zzey zzu = com.google.android.gms.internal.zzey.zza.zzu(obtain2.readStrongBinder());
                    return zzu;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzey getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzrk.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    zzey zzu = com.google.android.gms.internal.zzey.zza.zzu(obtain2.readStrongBinder());
                    return zzu;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
        }

        public static zzew asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzew)) ? new zza(iBinder) : (zzew) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            zzet createBannerAdManager;
            zzey mobileAdsSettingsManager;
            switch (i) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createBannerAdManager(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzeg) zzeg.CREATOR.createFromParcel(parcel) : null, parcel.readString(), com.google.android.gms.internal.zzka.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzeg) zzeg.CREATOR.createFromParcel(parcel) : null, parcel.readString(), com.google.android.gms.internal.zzka.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzer createAdLoaderBuilder = createAdLoaderBuilder(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()), parcel.readString(), com.google.android.gms.internal.zzka.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createAdLoaderBuilder != null) {
                        iBinder = createAdLoaderBuilder.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    mobileAdsSettingsManager = getMobileAdsSettingsManager(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManager != null) {
                        iBinder = mobileAdsSettingsManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Type.OTHER_PROFILE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzhh createNativeAdViewDelegate = createNativeAdViewDelegate(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()), com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createNativeAdViewDelegate != null) {
                        iBinder = createNativeAdViewDelegate.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Type.CONTRIBUTOR /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zznu createRewardedVideoAd = createRewardedVideoAd(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()), com.google.android.gms.internal.zzka.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createRewardedVideoAd != null) {
                        iBinder = createRewardedVideoAd.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Type.WEBSITE /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzlf createInAppPurchaseManager = createInAppPurchaseManager(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createInAppPurchaseManager != null) {
                        iBinder = createInAppPurchaseManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzkz createAdOverlay = createAdOverlay(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createAdOverlay != null) {
                        iBinder = createAdOverlay.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    mobileAdsSettingsManager = getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManager != null) {
                        iBinder = mobileAdsSettingsManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createSearchAdManager(com.google.android.gms.dynamic.IObjectWrapper.zza.zzcd(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzeg) zzeg.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IClientApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzer createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzka com_google_android_gms_internal_zzka, int i);

    zzkz createAdOverlay(IObjectWrapper iObjectWrapper);

    zzet createBannerAdManager(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka, int i);

    zzlf createInAppPurchaseManager(IObjectWrapper iObjectWrapper);

    zzet createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka, int i);

    zzhh createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2);

    zznu createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzka com_google_android_gms_internal_zzka, int i);

    zzet createSearchAdManager(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, String str, int i);

    zzey getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper);

    zzey getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i);
}
