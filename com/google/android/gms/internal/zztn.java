package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class zztn extends zzsa {
    protected boolean zzabJ;
    protected String zzacL;
    protected String zzacM;
    protected int zzafc;
    protected boolean zzagV;
    protected boolean zzagW;
    protected int zzage;

    public zztn(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
    }

    private static int zzck(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    void zza(zzsy com_google_android_gms_internal_zzsy) {
        int zzck;
        zzbP("Loading global XML config values");
        if (com_google_android_gms_internal_zzsy.zzpG()) {
            String zzmY = com_google_android_gms_internal_zzsy.zzmY();
            this.zzacL = zzmY;
            zzb("XML config - app name", zzmY);
        }
        if (com_google_android_gms_internal_zzsy.zzpH()) {
            zzmY = com_google_android_gms_internal_zzsy.zzmZ();
            this.zzacM = zzmY;
            zzb("XML config - app version", zzmY);
        }
        if (com_google_android_gms_internal_zzsy.zzpI()) {
            zzck = zzck(com_google_android_gms_internal_zzsy.zzpJ());
            if (zzck >= 0) {
                this.zzafc = zzck;
                zza("XML config - log level", Integer.valueOf(zzck));
            }
        }
        if (com_google_android_gms_internal_zzsy.zzpK()) {
            zzck = com_google_android_gms_internal_zzsy.zzpL();
            this.zzage = zzck;
            this.zzagV = true;
            zzb("XML config - dispatch period (sec)", Integer.valueOf(zzck));
        }
        if (com_google_android_gms_internal_zzsy.zzpM()) {
            boolean zzpN = com_google_android_gms_internal_zzsy.zzpN();
            this.zzabJ = zzpN;
            this.zzagW = true;
            zzb("XML config - dry run", Boolean.valueOf(zzpN));
        }
    }

    protected void zzmS() {
        zzqC();
    }

    public String zzmY() {
        zzob();
        return this.zzacL;
    }

    public String zzmZ() {
        zzob();
        return this.zzacM;
    }

    public boolean zzpI() {
        zzob();
        return false;
    }

    public boolean zzpK() {
        zzob();
        return this.zzagV;
    }

    public boolean zzpM() {
        zzob();
        return this.zzagW;
    }

    public boolean zzpN() {
        zzob();
        return this.zzabJ;
    }

    public int zzqB() {
        zzob();
        return this.zzage;
    }

    protected void zzqC() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzbS("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                zzsy com_google_android_gms_internal_zzsy = (zzsy) new zzsx(zznQ()).zzaI(i);
                if (com_google_android_gms_internal_zzsy != null) {
                    zza(com_google_android_gms_internal_zzsy);
                }
            }
        }
    }
}
