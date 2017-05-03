package com.google.android.gms.tagmanager;

import android.content.Context;

public class zzaa implements zzat {
    private static final Object zzbEI;
    private static zzaa zzbFW;
    private zzau zzbFX;
    private zzcl zzbFk;

    static {
        zzbEI = new Object();
    }

    private zzaa(Context context) {
        this(zzav.zzca(context), new zzda());
    }

    zzaa(zzau com_google_android_gms_tagmanager_zzau, zzcl com_google_android_gms_tagmanager_zzcl) {
        this.zzbFX = com_google_android_gms_tagmanager_zzau;
        this.zzbFk = com_google_android_gms_tagmanager_zzcl;
    }

    public static zzat zzbT(Context context) {
        zzat com_google_android_gms_tagmanager_zzat;
        synchronized (zzbEI) {
            if (zzbFW == null) {
                zzbFW = new zzaa(context);
            }
            com_google_android_gms_tagmanager_zzat = zzbFW;
        }
        return com_google_android_gms_tagmanager_zzat;
    }

    public boolean zzhf(String str) {
        if (this.zzbFk.zzpV()) {
            this.zzbFX.zzhj(str);
            return true;
        }
        zzbo.zzbh("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
