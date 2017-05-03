package com.google.android.gms.internal;

import org.json.JSONObject;

@zzme
public class zzku {
    private final boolean zzMr;
    private final boolean zzMs;
    private final boolean zzMt;
    private final boolean zzMu;
    private final boolean zzMv;

    public static final class zza {
        private boolean zzMr;
        private boolean zzMs;
        private boolean zzMt;
        private boolean zzMu;
        private boolean zzMv;

        public zzku zzho() {
            return new zzku();
        }

        public zza zzt(boolean z) {
            this.zzMr = z;
            return this;
        }

        public zza zzu(boolean z) {
            this.zzMs = z;
            return this;
        }

        public zza zzv(boolean z) {
            this.zzMt = z;
            return this;
        }

        public zza zzw(boolean z) {
            this.zzMu = z;
            return this;
        }

        public zza zzx(boolean z) {
            this.zzMv = z;
            return this;
        }
    }

    private zzku(zza com_google_android_gms_internal_zzku_zza) {
        this.zzMr = com_google_android_gms_internal_zzku_zza.zzMr;
        this.zzMs = com_google_android_gms_internal_zzku_zza.zzMs;
        this.zzMt = com_google_android_gms_internal_zzku_zza.zzMt;
        this.zzMu = com_google_android_gms_internal_zzku_zza.zzMu;
        this.zzMv = com_google_android_gms_internal_zzku_zza.zzMv;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzMr).put("tel", this.zzMs).put("calendar", this.zzMt).put("storePicture", this.zzMu).put("inlineVideo", this.zzMv);
        } catch (Throwable e) {
            zzqf.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
