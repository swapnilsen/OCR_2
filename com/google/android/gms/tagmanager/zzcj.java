package com.google.android.gms.tagmanager;

import android.net.Uri;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzcj {
    private static zzcj zzbHd;
    private volatile String zzbEU;
    private volatile zza zzbHe;
    private volatile String zzbHf;
    private volatile String zzbHg;

    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzcj() {
        clear();
    }

    static zzcj zzRe() {
        zzcj com_google_android_gms_tagmanager_zzcj;
        synchronized (zzcj.class) {
            if (zzbHd == null) {
                zzbHd = new zzcj();
            }
            com_google_android_gms_tagmanager_zzcj = zzbHd;
        }
        return com_google_android_gms_tagmanager_zzcj;
    }

    private String zzhn(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String zzw(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
    }

    void clear() {
        this.zzbHe = zza.NONE;
        this.zzbHf = null;
        this.zzbEU = null;
        this.zzbHg = null;
    }

    String getContainerId() {
        return this.zzbEU;
    }

    zza zzRf() {
        return this.zzbHe;
    }

    String zzRg() {
        return this.zzbHf;
    }

    synchronized boolean zzv(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                String str;
                String valueOf;
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    str = "Container preview url: ";
                    valueOf = String.valueOf(decode);
                    zzbo.m4712v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.zzbHe = zza.CONTAINER_DEBUG;
                    } else {
                        this.zzbHe = zza.CONTAINER;
                    }
                    this.zzbHg = zzw(uri);
                    if (this.zzbHe == zza.CONTAINER || this.zzbHe == zza.CONTAINER_DEBUG) {
                        decode = String.valueOf("/r?");
                        valueOf = String.valueOf(this.zzbHg);
                        this.zzbHf = valueOf.length() != 0 ? decode.concat(valueOf) : new String(decode);
                    }
                    this.zzbEU = zzhn(this.zzbHg);
                } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    str = "Invalid preview uri: ";
                    String valueOf2 = String.valueOf(decode);
                    zzbo.zzbh(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                    z = false;
                } else if (zzhn(uri.getQuery()).equals(this.zzbEU)) {
                    decode = "Exit preview mode for container: ";
                    valueOf = String.valueOf(this.zzbEU);
                    zzbo.m4712v(valueOf.length() != 0 ? decode.concat(valueOf) : new String(decode));
                    this.zzbHe = zza.NONE;
                    this.zzbHf = null;
                } else {
                    z = false;
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }
}
