package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface zzadi {

    public static class zza {
        private final long zzaIC;
        private final Map<String, String> zzaID;
        private final int zzaIE;
        private final List<zzadk> zzaIF;
        private final int zzaIG;
        private final int zzaIH;

        public static class zza {
            private long zzaIC;
            private Map<String, String> zzaID;
            private int zzaIE;
            private int zzaIG;
            private int zzaIH;

            public zza() {
                this.zzaIC = 43200;
                this.zzaIG = -1;
                this.zzaIH = -1;
            }

            public zza zzH(String str, String str2) {
                if (this.zzaID == null) {
                    this.zzaID = new HashMap();
                }
                this.zzaID.put(str, str2);
                return this;
            }

            public zza zzK(long j) {
                this.zzaIC = j;
                return this;
            }

            public zza zzdr(int i) {
                this.zzaIE = i;
                return this;
            }

            public zza zzds(int i) {
                this.zzaIG = i;
                return this;
            }

            public zza zzdt(int i) {
                this.zzaIH = i;
                return this;
            }

            public zza zzzD() {
                return new zza();
            }
        }

        private zza(zza com_google_android_gms_internal_zzadi_zza_zza) {
            this.zzaIC = com_google_android_gms_internal_zzadi_zza_zza.zzaIC;
            this.zzaID = com_google_android_gms_internal_zzadi_zza_zza.zzaID;
            this.zzaIE = com_google_android_gms_internal_zzadi_zza_zza.zzaIE;
            this.zzaIF = null;
            this.zzaIG = com_google_android_gms_internal_zzadi_zza_zza.zzaIG;
            this.zzaIH = com_google_android_gms_internal_zzadi_zza_zza.zzaIH;
        }

        public int zzzA() {
            return this.zzaIE;
        }

        public int zzzB() {
            return this.zzaIH;
        }

        public int zzzC() {
            return this.zzaIG;
        }

        public long zzzy() {
            return this.zzaIC;
        }

        public Map<String, String> zzzz() {
            return this.zzaID == null ? Collections.emptyMap() : this.zzaID;
        }
    }

    public interface zzb extends Result {
        Status getStatus();

        long getThrottleEndTimeMillis();

        byte[] zza(String str, byte[] bArr, String str2);

        List<byte[]> zzzE();

        Map<String, Set<String>> zzzF();
    }

    PendingResult<zzb> zza(GoogleApiClient googleApiClient, zza com_google_android_gms_internal_zzadi_zza);
}
