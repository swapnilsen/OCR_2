package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.api.client.http.HttpStatusCodes;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

class zzde implements zzad {
    private final Context mContext;
    private final String zzIA;
    private final zzb zzbIp;
    private final zza zzbIq;

    public interface zza {
        void zza(zzas com_google_android_gms_tagmanager_zzas);

        void zzb(zzas com_google_android_gms_tagmanager_zzas);

        void zzc(zzas com_google_android_gms_tagmanager_zzas);
    }

    interface zzb {
        HttpURLConnection zzd(URL url);
    }

    /* renamed from: com.google.android.gms.tagmanager.zzde.1 */
    class C14571 implements zzb {
        C14571() {
        }

        public HttpURLConnection zzd(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    zzde(Context context, zza com_google_android_gms_tagmanager_zzde_zza) {
        this(new C14571(), context, com_google_android_gms_tagmanager_zzde_zza);
    }

    zzde(zzb com_google_android_gms_tagmanager_zzde_zzb, Context context, zza com_google_android_gms_tagmanager_zzde_zza) {
        this.zzbIp = com_google_android_gms_tagmanager_zzde_zzb;
        this.mContext = context.getApplicationContext();
        this.zzbIq = com_google_android_gms_tagmanager_zzde_zza;
        this.zzIA = zza("GoogleTagManager", "4.00", VERSION.RELEASE, zzc(Locale.getDefault()), Build.MODEL, Build.ID);
    }

    static String zzc(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    public void zzP(List<zzas> list) {
        Throwable th;
        InputStream inputStream;
        Object obj;
        Throwable th2;
        Object obj2;
        IOException iOException;
        int min = Math.min(list.size(), 40);
        Object obj3 = 1;
        int i = 0;
        while (i < min) {
            Object obj4;
            zzas com_google_android_gms_tagmanager_zzas = (zzas) list.get(i);
            URL zzd = zzd(com_google_android_gms_tagmanager_zzas);
            if (zzd == null) {
                zzbo.zzbh("No destination: discarding hit.");
                this.zzbIq.zzb(com_google_android_gms_tagmanager_zzas);
                obj4 = obj3;
            } else {
                try {
                    HttpURLConnection zzd2 = this.zzbIp.zzd(zzd);
                    if (obj3 != null) {
                        try {
                            zzbt.zzcc(this.mContext);
                            obj3 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                            obj = obj3;
                            th2 = th;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    obj2 = obj;
                                    iOException = e;
                                }
                            }
                            zzd2.disconnect();
                            throw th2;
                        }
                    }
                    zzd2.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.zzIA);
                    int responseCode = zzd2.getResponseCode();
                    InputStream inputStream2 = zzd2.getInputStream();
                    if (responseCode != HttpStatusCodes.STATUS_CODE_OK) {
                        try {
                            zzbo.zzbh("Bad response: " + responseCode);
                            this.zzbIq.zzc(com_google_android_gms_tagmanager_zzas);
                        } catch (Throwable th32) {
                            th = th32;
                            inputStream = inputStream2;
                            obj = obj3;
                            th2 = th;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            zzd2.disconnect();
                            throw th2;
                        }
                    }
                    this.zzbIq.zza(com_google_android_gms_tagmanager_zzas);
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    zzd2.disconnect();
                    obj4 = obj3;
                } catch (IOException e2) {
                    iOException = e2;
                    obj2 = obj3;
                    String str = "Exception sending hit: ";
                    String valueOf = String.valueOf(iOException.getClass().getSimpleName());
                    zzbo.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    zzbo.zzbh(iOException.getMessage());
                    this.zzbIq.zzc(com_google_android_gms_tagmanager_zzas);
                    obj4 = obj2;
                    i++;
                    obj3 = obj4;
                }
            }
            i++;
            obj3 = obj4;
        }
    }

    public boolean zzQF() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbo.m4712v("...no network connectivity");
        return false;
    }

    String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    URL zzd(zzas com_google_android_gms_tagmanager_zzas) {
        try {
            return new URL(com_google_android_gms_tagmanager_zzas.zzQP());
        } catch (MalformedURLException e) {
            zzbo.m4711e("Error trying to parse the GTM url.");
            return null;
        }
    }
}
