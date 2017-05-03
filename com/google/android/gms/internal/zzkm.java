package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzkb.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzme
public final class zzkm<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzLI;
    private final NETWORK_EXTRAS zzLJ;

    public zzkm(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzLI = mediationAdapter;
        this.zzLJ = network_extras;
    }

    private SERVER_PARAMETERS zza(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                zzqf.zzc("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.zzLI.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public void destroy() {
        try {
            this.zzLI.destroy();
        } catch (Throwable th) {
            zzqf.zzc("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public IObjectWrapper getView() {
        if (this.zzLI instanceof MediationBannerAdapter) {
            try {
                return zzd.zzA(((MediationBannerAdapter) this.zzLI).getBannerView());
            } catch (Throwable th) {
                zzqf.zzc("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.zzLI.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public boolean isInitialized() {
        return true;
    }

    public void pause() {
        throw new RemoteException();
    }

    public void resume() {
        throw new RemoteException();
    }

    public void showInterstitial() {
        if (this.zzLI instanceof MediationInterstitialAdapter) {
            zzqf.zzbf("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzLI).showInterstitial();
            } catch (Throwable th) {
                zzqf.zzc("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.zzLI.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void showVideo() {
    }

    public void zza(IObjectWrapper iObjectWrapper, zzec com_google_android_gms_internal_zzec, String str, zzkc com_google_android_gms_internal_zzkc) {
        zza(iObjectWrapper, com_google_android_gms_internal_zzec, str, null, com_google_android_gms_internal_zzkc);
    }

    public void zza(IObjectWrapper iObjectWrapper, zzec com_google_android_gms_internal_zzec, String str, zzom com_google_android_gms_internal_zzom, String str2) {
    }

    public void zza(IObjectWrapper iObjectWrapper, zzec com_google_android_gms_internal_zzec, String str, String str2, zzkc com_google_android_gms_internal_zzkc) {
        if (this.zzLI instanceof MediationInterstitialAdapter) {
            zzqf.zzbf("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzLI).requestInterstitialAd(new zzkn(com_google_android_gms_internal_zzkc), (Activity) zzd.zzF(iObjectWrapper), zza(str, com_google_android_gms_internal_zzec.zzyX, str2), zzko.zzr(com_google_android_gms_internal_zzec), this.zzLJ);
            } catch (Throwable th) {
                zzqf.zzc("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.zzLI.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void zza(IObjectWrapper iObjectWrapper, zzec com_google_android_gms_internal_zzec, String str, String str2, zzkc com_google_android_gms_internal_zzkc, zzhc com_google_android_gms_internal_zzhc, List<String> list) {
    }

    public void zza(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, zzkc com_google_android_gms_internal_zzkc) {
        zza(iObjectWrapper, com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzec, str, null, com_google_android_gms_internal_zzkc);
    }

    public void zza(IObjectWrapper iObjectWrapper, zzeg com_google_android_gms_internal_zzeg, zzec com_google_android_gms_internal_zzec, String str, String str2, zzkc com_google_android_gms_internal_zzkc) {
        if (this.zzLI instanceof MediationBannerAdapter) {
            zzqf.zzbf("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.zzLI).requestBannerAd(new zzkn(com_google_android_gms_internal_zzkc), (Activity) zzd.zzF(iObjectWrapper), zza(str, com_google_android_gms_internal_zzec.zzyX, str2), zzko.zzc(com_google_android_gms_internal_zzeg), zzko.zzr(com_google_android_gms_internal_zzec), this.zzLJ);
            } catch (Throwable th) {
                zzqf.zzc("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.zzLI.getClass().getCanonicalName());
            zzqf.zzbh(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void zza(IObjectWrapper iObjectWrapper, zzom com_google_android_gms_internal_zzom, List<String> list) {
    }

    public void zza(zzec com_google_android_gms_internal_zzec, String str, String str2) {
    }

    public void zzd(zzec com_google_android_gms_internal_zzec, String str) {
    }

    public zzke zzhc() {
        return null;
    }

    public zzkf zzhd() {
        return null;
    }

    public Bundle zzhe() {
        return new Bundle();
    }

    public Bundle zzhf() {
        return new Bundle();
    }

    public boolean zzhg() {
        return false;
    }

    public void zzk(IObjectWrapper iObjectWrapper) {
    }
}
