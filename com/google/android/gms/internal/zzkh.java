package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzkb.zza;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzme
public final class zzkh extends zza {
    private final MediationAdapter zzLC;
    private zzki zzLD;

    public zzkh(MediationAdapter mediationAdapter) {
        this.zzLC = mediationAdapter;
    }

    private Bundle zza(String str, zzec com_google_android_gms_internal_zzec, String str2) {
        String str3 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        zzqf.zzbh(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    valueOf = (String) keys.next();
                    bundle2.putString(valueOf, jSONObject.getString(valueOf));
                }
                bundle = bundle2;
            }
            if (this.zzLC instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (com_google_android_gms_internal_zzec != null) {
                    bundle.putInt("tagForChildDirectedTreatment", com_google_android_gms_internal_zzec.zzyX);
                }
            }
            return bundle;
        } catch (Throwable th) {
            zzqf.zzc("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void destroy() {
        try {
            this.zzLC.onDestroy();
        } catch (Throwable th) {
            zzqf.zzc("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        if (this.zzLC instanceof zzrj) {
            return ((zzrj) this.zzLC).getInterstitialAdapterInfo();
        }
        String str = "MediationAdapter is not a v2 MediationInterstitialAdapter: ";
        String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
        zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public IObjectWrapper getView() {
        if (this.zzLC instanceof MediationBannerAdapter) {
            try {
                return zzd.zzA(((MediationBannerAdapter) this.zzLC).getBannerView());
            } catch (Throwable th) {
                zzqf.zzc("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public boolean isInitialized() {
        if (this.zzLC instanceof MediationRewardedVideoAdAdapter) {
            zzqf.zzbf("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzLC).isInitialized();
            } catch (Throwable th) {
                zzqf.zzc("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void pause() {
        try {
            this.zzLC.onPause();
        } catch (Throwable th) {
            zzqf.zzc("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void resume() {
        try {
            this.zzLC.onResume();
        } catch (Throwable th) {
            zzqf.zzc("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void showInterstitial() {
        if (this.zzLC instanceof MediationInterstitialAdapter) {
            zzqf.zzbf("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzLC).showInterstitial();
            } catch (Throwable th) {
                zzqf.zzc("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void showVideo() {
        if (this.zzLC instanceof MediationRewardedVideoAdAdapter) {
            zzqf.zzbf("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzLC).showVideo();
            } catch (Throwable th) {
                zzqf.zzc("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void zza(IObjectWrapper iObjectWrapper, zzec com_google_android_gms_internal_zzec, String str, zzkc com_google_android_gms_internal_zzkc) {
        zza(iObjectWrapper, com_google_android_gms_internal_zzec, str, null, com_google_android_gms_internal_zzkc);
    }

    public void zza(IObjectWrapper iObjectWrapper, zzec com_google_android_gms_internal_zzec, String str, zzom com_google_android_gms_internal_zzom, String str2) {
        if (this.zzLC instanceof MediationRewardedVideoAdAdapter) {
            zzqf.zzbf("Initialize rewarded video adapter.");
            try {
                Bundle bundle;
                MediationAdRequest mediationAdRequest;
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzLC;
                Bundle zza = zza(str2, com_google_android_gms_internal_zzec, null);
                if (com_google_android_gms_internal_zzec != null) {
                    zzkg com_google_android_gms_internal_zzkg = new zzkg(com_google_android_gms_internal_zzec.zzyT == -1 ? null : new Date(com_google_android_gms_internal_zzec.zzyT), com_google_android_gms_internal_zzec.zzyU, com_google_android_gms_internal_zzec.zzyV != null ? new HashSet(com_google_android_gms_internal_zzec.zzyV) : null, com_google_android_gms_internal_zzec.zzzb, com_google_android_gms_internal_zzec.zzyW, com_google_android_gms_internal_zzec.zzyX, com_google_android_gms_internal_zzec.zzzi);
                    if (com_google_android_gms_internal_zzec.zzzd != null) {
                        bundle = com_google_android_gms_internal_zzec.zzzd.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                        mediationAdRequest = com_google_android_gms_internal_zzkg;
                    } else {
                        bundle = null;
                        Object obj = com_google_android_gms_internal_zzkg;
                    }
                } else {
                    bundle = null;
                    mediationAdRequest = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) zzd.zzF(iObjectWrapper), mediationAdRequest, str, new zzon(com_google_android_gms_internal_zzom), zza, bundle);
            } catch (Throwable th) {
                zzqf.zzc("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void zza(IObjectWrapper iObjectWrapper, zzec com_google_android_gms_internal_zzec, String str, String str2, zzkc com_google_android_gms_internal_zzkc) {
        if (this.zzLC instanceof MediationInterstitialAdapter) {
            zzqf.zzbf("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzLC;
                mediationInterstitialAdapter.requestInterstitialAd((Context) zzd.zzF(iObjectWrapper), new zzki(com_google_android_gms_internal_zzkc), zza(str, com_google_android_gms_internal_zzec, str2), new zzkg(com_google_android_gms_internal_zzec.zzyT == -1 ? null : new Date(com_google_android_gms_internal_zzec.zzyT), com_google_android_gms_internal_zzec.zzyU, com_google_android_gms_internal_zzec.zzyV != null ? new HashSet(com_google_android_gms_internal_zzec.zzyV) : null, com_google_android_gms_internal_zzec.zzzb, com_google_android_gms_internal_zzec.zzyW, com_google_android_gms_internal_zzec.zzyX, com_google_android_gms_internal_zzec.zzzi), com_google_android_gms_internal_zzec.zzzd != null ? com_google_android_gms_internal_zzec.zzzd.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzqf.zzc("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void zza(IObjectWrapper iObjectWrapper, zzec com_google_android_gms_internal_zzec, String str, String str2, zzkc com_google_android_gms_internal_zzkc, zzhc com_google_android_gms_internal_zzhc, List<String> list) {
        if (this.zzLC instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzLC;
                zzkl com_google_android_gms_internal_zzkl = new zzkl(com_google_android_gms_internal_zzec.zzyT == -1 ? null : new Date(com_google_android_gms_internal_zzec.zzyT), com_google_android_gms_internal_zzec.zzyU, com_google_android_gms_internal_zzec.zzyV != null ? new HashSet(com_google_android_gms_internal_zzec.zzyV) : null, com_google_android_gms_internal_zzec.zzzb, com_google_android_gms_internal_zzec.zzyW, com_google_android_gms_internal_zzec.zzyX, com_google_android_gms_internal_zzhc, list, com_google_android_gms_internal_zzec.zzzi);
                Bundle bundle = com_google_android_gms_internal_zzec.zzzd != null ? com_google_android_gms_internal_zzec.zzzd.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.zzLD = new zzki(com_google_android_gms_internal_zzkc);
                mediationNativeAdapter.requestNativeAd((Context) zzd.zzF(iObjectWrapper), this.zzLD, zza(str, com_google_android_gms_internal_zzec, str2), com_google_android_gms_internal_zzkl, bundle);
            } catch (Throwable th) {
                zzqf.zzc("Could not request native ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationNativeAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void zza(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, zzkc com_google_android_gms_internal_zzkc) {
        zza(iObjectWrapper, com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzec, str, null, com_google_android_gms_internal_zzkc);
    }

    public void zza(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, String str2, zzkc com_google_android_gms_internal_zzkc) {
        if (this.zzLC instanceof MediationBannerAdapter) {
            zzqf.zzbf("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzLC;
                mediationBannerAdapter.requestBannerAd((Context) zzd.zzF(iObjectWrapper), new zzki(com_google_android_gms_internal_zzkc), zza(str, com_google_android_gms_internal_zzec, str2), com.google.android.gms.ads.zza.zza(com_google_android_gms_internal_zzeg.width, com_google_android_gms_internal_zzeg.height, com_google_android_gms_internal_zzeg.zzzy), new zzkg(com_google_android_gms_internal_zzec.zzyT == -1 ? null : new Date(com_google_android_gms_internal_zzec.zzyT), com_google_android_gms_internal_zzec.zzyU, com_google_android_gms_internal_zzec.zzyV != null ? new HashSet(com_google_android_gms_internal_zzec.zzyV) : null, com_google_android_gms_internal_zzec.zzzb, com_google_android_gms_internal_zzec.zzyW, com_google_android_gms_internal_zzec.zzyX, com_google_android_gms_internal_zzec.zzzi), com_google_android_gms_internal_zzec.zzzd != null ? com_google_android_gms_internal_zzec.zzzd.getBundle(mediationBannerAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzqf.zzc("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void zza(IObjectWrapper iObjectWrapper, zzom com_google_android_gms_internal_zzom, List<String> list) {
        String str;
        if (this.zzLC instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzqf.zzbf("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzLC;
                List arrayList = new ArrayList();
                for (String str2 : list) {
                    arrayList.add(zza(str2, null, null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) zzd.zzF(iObjectWrapper), new zzon(com_google_android_gms_internal_zzom), arrayList);
            } catch (Throwable th) {
                zzqf.zzc("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            str2 = "MediationAdapter is not an InitializableMediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            throw new RemoteException();
        }
    }

    public void zza(zzec com_google_android_gms_internal_zzec, String str, String str2) {
        if (this.zzLC instanceof MediationRewardedVideoAdAdapter) {
            zzqf.zzbf("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzLC;
                mediationRewardedVideoAdAdapter.loadAd(new zzkg(com_google_android_gms_internal_zzec.zzyT == -1 ? null : new Date(com_google_android_gms_internal_zzec.zzyT), com_google_android_gms_internal_zzec.zzyU, com_google_android_gms_internal_zzec.zzyV != null ? new HashSet(com_google_android_gms_internal_zzec.zzyV) : null, com_google_android_gms_internal_zzec.zzzb, com_google_android_gms_internal_zzec.zzyW, com_google_android_gms_internal_zzec.zzyX, com_google_android_gms_internal_zzec.zzzi), zza(str, com_google_android_gms_internal_zzec, str2), com_google_android_gms_internal_zzec.zzzd != null ? com_google_android_gms_internal_zzec.zzzd.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzqf.zzc("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void zzd(zzec com_google_android_gms_internal_zzec, String str) {
        zza(com_google_android_gms_internal_zzec, str, null);
    }

    public zzke zzhc() {
        NativeAdMapper zzhi = this.zzLD.zzhi();
        return zzhi instanceof NativeAppInstallAdMapper ? new zzkj((NativeAppInstallAdMapper) zzhi) : null;
    }

    public zzkf zzhd() {
        NativeAdMapper zzhi = this.zzLD.zzhi();
        return zzhi instanceof NativeContentAdMapper ? new zzkk((NativeContentAdMapper) zzhi) : null;
    }

    public Bundle zzhe() {
        if (this.zzLC instanceof zzri) {
            return ((zzri) this.zzLC).zzhe();
        }
        String str = "MediationAdapter is not a v2 MediationBannerAdapter: ";
        String valueOf = String.valueOf(this.zzLC.getClass().getCanonicalName());
        zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public Bundle zzhf() {
        return new Bundle();
    }

    public boolean zzhg() {
        return this.zzLC instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public void zzk(IObjectWrapper iObjectWrapper) {
        try {
            ((OnContextChangedListener) this.zzLC).onContextChanged((Context) zzd.zzF(iObjectWrapper));
        } catch (Throwable th) {
            zzqf.zza("Could not inform adapter of changed context", th);
        }
    }
}
