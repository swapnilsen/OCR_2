package com.google.android.gms.internal;

public class zzsx extends zzso<zzsy> {

    private static class zza implements com.google.android.gms.internal.zzso.zza<zzsy> {
        private final zzsc zzadO;
        private final zzsy zzagc;

        public zza(zzsc com_google_android_gms_internal_zzsc) {
            this.zzadO = com_google_android_gms_internal_zzsc;
            this.zzagc = new zzsy();
        }

        public void zzd(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.zzagc.zzage = i;
            } else {
                this.zzadO.zznS().zzd("Int xml configuration name not recognized", str);
            }
        }

        public void zze(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.zzagc.zzagf = z ? 1 : 0;
                return;
            }
            this.zzadO.zznS().zzd("Bool xml configuration name not recognized", str);
        }

        public /* synthetic */ zzsn zzoV() {
            return zzpF();
        }

        public void zzp(String str, String str2) {
        }

        public zzsy zzpF() {
            return this.zzagc;
        }

        public void zzq(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.zzagc.zzacL = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.zzagc.zzacM = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.zzagc.zzagd = str2;
            } else {
                this.zzadO.zznS().zzd("String xml configuration name not recognized", str);
            }
        }
    }

    public zzsx(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc, new zza(com_google_android_gms_internal_zzsc));
    }
}
