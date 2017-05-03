package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzaj.zzj;
import com.google.android.gms.internal.zzbjf;
import com.google.android.gms.internal.zzbji;
import com.google.android.gms.internal.zzbjj;
import com.google.android.gms.internal.zzbjk;
import com.google.android.gms.tagmanager.zzbn.zza;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class zzct implements Runnable {
    private final Context mContext;
    private final String zzbEU;
    private volatile String zzbFs;
    private final zzbjj zzbHr;
    private final String zzbHs;
    private zzbn<zzj> zzbHt;
    private volatile zzt zzbHu;
    private volatile String zzbHv;

    zzct(Context context, String str, zzbjj com_google_android_gms_internal_zzbjj, zzt com_google_android_gms_tagmanager_zzt) {
        this.mContext = context;
        this.zzbHr = com_google_android_gms_internal_zzbjj;
        this.zzbEU = str;
        this.zzbHu = com_google_android_gms_tagmanager_zzt;
        String valueOf = String.valueOf("/r?id=");
        String valueOf2 = String.valueOf(str);
        this.zzbHs = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        this.zzbFs = this.zzbHs;
        this.zzbHv = null;
    }

    public zzct(Context context, String str, zzt com_google_android_gms_tagmanager_zzt) {
        this(context, str, new zzbjj(), com_google_android_gms_tagmanager_zzt);
    }

    private boolean zzRh() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbo.m4712v("...no network connectivity");
        return false;
    }

    private void zzRi() {
        String str;
        String valueOf;
        if (zzRh()) {
            String str2;
            zzbo.m4712v("Start loading resource from network ...");
            String zzRj = zzRj();
            zzbji zzTF = this.zzbHr.zzTF();
            InputStream inputStream = null;
            try {
                inputStream = zzTF.zzhX(zzRj);
            } catch (FileNotFoundException e) {
                str2 = this.zzbEU;
                zzbo.zzbh(new StringBuilder((String.valueOf(zzRj).length() + 79) + String.valueOf(str2).length()).append("No data is retrieved from the given url: ").append(zzRj).append(". Make sure container_id: ").append(str2).append(" is correct.").toString());
                this.zzbHt.zza(zza.SERVER_ERROR);
                zzTF.close();
                return;
            } catch (zzbjk e2) {
                str = "Error when loading resource for url: ";
                valueOf = String.valueOf(zzRj);
                zzbo.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                this.zzbHt.zza(zza.SERVER_UNAVAILABLE_ERROR);
            } catch (Throwable e3) {
                valueOf = String.valueOf(e3.getMessage());
                zzbo.zzc(new StringBuilder((String.valueOf(zzRj).length() + 40) + String.valueOf(valueOf).length()).append("Error when loading resources from url: ").append(zzRj).append(" ").append(valueOf).toString(), e3);
                this.zzbHt.zza(zza.IO_ERROR);
                zzTF.close();
                return;
            } catch (Throwable th) {
                zzTF.close();
            }
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzbjf.zzc(inputStream, byteArrayOutputStream);
                zzj zzg = zzj.zzg(byteArrayOutputStream.toByteArray());
                str2 = String.valueOf(zzg);
                zzbo.m4712v(new StringBuilder(String.valueOf(str2).length() + 43).append("Successfully loaded supplemented resource: ").append(str2).toString());
                if (zzg.zzlr == null && zzg.zzlq.length == 0) {
                    str = "No change for container: ";
                    str2 = String.valueOf(this.zzbEU);
                    zzbo.m4712v(str2.length() != 0 ? str.concat(str2) : new String(str));
                }
                this.zzbHt.onSuccess(zzg);
                zzTF.close();
                zzbo.m4712v("Load resource from network finished.");
                return;
            } catch (Throwable e32) {
                valueOf = String.valueOf(e32.getMessage());
                zzbo.zzc(new StringBuilder((String.valueOf(zzRj).length() + 51) + String.valueOf(valueOf).length()).append("Error when parsing downloaded resources from url: ").append(zzRj).append(" ").append(valueOf).toString(), e32);
                this.zzbHt.zza(zza.SERVER_ERROR);
                zzTF.close();
                return;
            }
        }
        this.zzbHt.zza(zza.NOT_AVAILABLE);
    }

    public void run() {
        if (this.zzbHt == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        zzRi();
    }

    String zzRj() {
        String valueOf = String.valueOf(this.zzbHu.zzQv());
        String str = this.zzbFs;
        String valueOf2 = String.valueOf("&v=a65833898");
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(valueOf2).toString();
        if (!(this.zzbHv == null || this.zzbHv.trim().equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
            valueOf = String.valueOf(valueOf);
            str = String.valueOf("&pv=");
            valueOf2 = this.zzbHv;
            valueOf = new StringBuilder((String.valueOf(valueOf).length() + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(valueOf2).toString();
        }
        if (!zzcj.zzRe().zzRf().equals(zza.CONTAINER_DEBUG)) {
            return valueOf;
        }
        str = String.valueOf(valueOf);
        valueOf = String.valueOf("&gtm_debug=x");
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    void zza(zzbn<zzj> com_google_android_gms_tagmanager_zzbn_com_google_android_gms_internal_zzaj_zzj) {
        this.zzbHt = com_google_android_gms_tagmanager_zzbn_com_google_android_gms_internal_zzaj_zzj;
    }

    void zzgZ(String str) {
        if (str == null) {
            this.zzbFs = this.zzbHs;
            return;
        }
        String str2 = "Setting CTFE URL path: ";
        String valueOf = String.valueOf(str);
        zzbo.zzbf(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.zzbFs = str;
    }

    void zzho(String str) {
        String str2 = "Setting previous container version: ";
        String valueOf = String.valueOf(str);
        zzbo.zzbf(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.zzbHv = str;
    }
}
