package com.google.android.gms.internal;

public class zztk extends zzso<zztl> {

    private static class zza extends zzrz implements com.google.android.gms.internal.zzso.zza<zztl> {
        private final zztl zzagN;

        public zza(zzsc com_google_android_gms_internal_zzsc) {
            super(com_google_android_gms_internal_zzsc);
            this.zzagN = new zztl();
        }

        public void zzd(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.zzagN.zzagP = i;
            } else {
                zzd("int configuration name not recognized", str);
            }
        }

        public void zze(String str, boolean z) {
            int i = 1;
            zztl com_google_android_gms_internal_zztl;
            if ("ga_autoActivityTracking".equals(str)) {
                com_google_android_gms_internal_zztl = this.zzagN;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_internal_zztl.zzagQ = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                com_google_android_gms_internal_zztl = this.zzagN;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_internal_zztl.zzagR = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                com_google_android_gms_internal_zztl = this.zzagN;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_internal_zztl.zzagS = i;
            } else {
                zzd("bool configuration name not recognized", str);
            }
        }

        public /* synthetic */ zzsn zzoV() {
            return zzqr();
        }

        public void zzp(String str, String str2) {
            this.zzagN.zzagT.put(str, str2);
        }

        public void zzq(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.zzagN.zzabs = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.zzagN.zzagO = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    zzc("Error parsing ga_sampleFrequency value", str2, e);
                }
            } else {
                zzd("string configuration name not recognized", str);
            }
        }

        public zztl zzqr() {
            return this.zzagN;
        }
    }

    public zztk(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc, new zza(com_google_android_gms_internal_zzsc));
    }
}
