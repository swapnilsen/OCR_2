package com.google.android.gms.internal;

import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.internal.zzac;
import com.google.api.client.http.HttpStatusCodes;

public final class zzats {
    public static zza<Boolean> zzbrI;
    public static zza<Boolean> zzbrJ;
    public static zza<Boolean> zzbrK;
    public static zza<Boolean> zzbrL;
    public static zza<Boolean> zzbrM;
    public static zza<Boolean> zzbrN;
    public static zza<String> zzbrO;
    public static zza<Long> zzbrP;
    public static zza<Long> zzbrQ;
    public static zza<Long> zzbrR;
    public static zza<String> zzbrS;
    public static zza<String> zzbrT;
    public static zza<Integer> zzbrU;
    public static zza<Integer> zzbrV;
    public static zza<Integer> zzbrW;
    public static zza<Integer> zzbrX;
    public static zza<Integer> zzbrY;
    public static zza<Integer> zzbrZ;
    public static zza<Integer> zzbsa;
    public static zza<Integer> zzbsb;
    public static zza<Integer> zzbsc;
    public static zza<Integer> zzbsd;
    public static zza<String> zzbse;
    public static zza<Long> zzbsf;
    public static zza<Long> zzbsg;
    public static zza<Long> zzbsh;
    public static zza<Long> zzbsi;
    public static zza<Long> zzbsj;
    public static zza<Long> zzbsk;
    public static zza<Long> zzbsl;
    public static zza<Long> zzbsm;
    public static zza<Long> zzbsn;
    public static zza<Long> zzbso;
    public static zza<Long> zzbsp;
    public static zza<Integer> zzbsq;
    public static zza<Long> zzbsr;
    public static zza<Integer> zzbss;
    public static zza<Integer> zzbst;
    public static zza<Long> zzbsu;

    public static final class zza<V> {
        private final String zzAX;
        private final V zzaga;
        private final zzaca<V> zzagb;

        private zza(String str, zzaca<V> com_google_android_gms_internal_zzaca_V, V v) {
            zzac.zzw(com_google_android_gms_internal_zzaca_V);
            this.zzagb = com_google_android_gms_internal_zzaca_V;
            this.zzaga = v;
            this.zzAX = str;
        }

        static zza<Integer> zzB(String str, int i) {
            return zzo(str, i, i);
        }

        static zza<String> zzY(String str, String str2) {
            return zzm(str, str2, str2);
        }

        static zza<Long> zzb(String str, long j, long j2) {
            return new zza(str, zzaca.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<Boolean> zzb(String str, boolean z, boolean z2) {
            return new zza(str, zzaca.zzj(str, z2), Boolean.valueOf(z));
        }

        static zza<Long> zzj(String str, long j) {
            return zzb(str, j, j);
        }

        static zza<Boolean> zzl(String str, boolean z) {
            return zzb(str, z, z);
        }

        static zza<String> zzm(String str, String str2, String str3) {
            return new zza(str, zzaca.zzB(str, str3), str2);
        }

        static zza<Integer> zzo(String str, int i, int i2) {
            return new zza(str, zzaca.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        public V get() {
            return this.zzaga;
        }

        public V get(V v) {
            return v != null ? v : this.zzaga;
        }

        public String getKey() {
            return this.zzAX;
        }
    }

    static {
        zzbrI = zza.zzl("measurement.service_enabled", true);
        zzbrJ = zza.zzl("measurement.service_client_enabled", true);
        zzbrK = zza.zzl("measurement.log_third_party_store_events_enabled", false);
        zzbrL = zza.zzl("measurement.log_installs_enabled", false);
        zzbrM = zza.zzl("measurement.log_upgrades_enabled", false);
        zzbrN = zza.zzl("measurement.log_androidId_enabled", false);
        zzbrO = zza.zzm("measurement.log_tag", "FA", "FA-SVC");
        zzbrP = zza.zzj("measurement.ad_id_cache_time", 10000);
        zzbrQ = zza.zzj("measurement.monitoring.sample_period_millis", 86400000);
        zzbrR = zza.zzb("measurement.config.cache_time", 86400000, 3600000);
        zzbrS = zza.zzY("measurement.config.url_scheme", "https");
        zzbrT = zza.zzY("measurement.config.url_authority", "app-measurement.com");
        zzbrU = zza.zzB("measurement.upload.max_bundles", 100);
        zzbrV = zza.zzB("measurement.upload.max_batch_size", AccessibilityNodeInfoCompat.ACTION_CUT);
        zzbrW = zza.zzB("measurement.upload.max_bundle_size", AccessibilityNodeInfoCompat.ACTION_CUT);
        zzbrX = zza.zzB("measurement.upload.max_events_per_bundle", PointerIconCompat.TYPE_DEFAULT);
        zzbrY = zza.zzB("measurement.upload.max_events_per_day", 100000);
        zzbrZ = zza.zzB("measurement.upload.max_error_events_per_day", PointerIconCompat.TYPE_DEFAULT);
        zzbsa = zza.zzB("measurement.upload.max_public_events_per_day", 50000);
        zzbsb = zza.zzB("measurement.upload.max_conversions_per_day", HttpStatusCodes.STATUS_CODE_SERVER_ERROR);
        zzbsc = zza.zzB("measurement.upload.max_realtime_events_per_day", 10);
        zzbsd = zza.zzB("measurement.store.max_stored_events_per_app", 100000);
        zzbse = zza.zzY("measurement.upload.url", "https://app-measurement.com/a");
        zzbsf = zza.zzj("measurement.upload.backoff_period", 43200000);
        zzbsg = zza.zzj("measurement.upload.window_interval", 3600000);
        zzbsh = zza.zzj("measurement.upload.interval", 3600000);
        zzbsi = zza.zzj("measurement.upload.realtime_upload_interval", 10000);
        zzbsj = zza.zzj("measurement.upload.debug_upload_interval", 1000);
        zzbsk = zza.zzj("measurement.upload.minimum_delay", 500);
        zzbsl = zza.zzj("measurement.alarm_manager.minimum_interval", 60000);
        zzbsm = zza.zzj("measurement.upload.stale_data_deletion_interval", 86400000);
        zzbsn = zza.zzj("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzbso = zza.zzj("measurement.upload.initial_upload_delay_time", 15000);
        zzbsp = zza.zzj("measurement.upload.retry_time", 1800000);
        zzbsq = zza.zzB("measurement.upload.retry_count", 6);
        zzbsr = zza.zzj("measurement.upload.max_queue_time", 2419200000L);
        zzbss = zza.zzB("measurement.lifetimevalue.max_currency_tracked", 4);
        zzbst = zza.zzB("measurement.audience.filter_result_max_count", HttpStatusCodes.STATUS_CODE_OK);
        zzbsu = zza.zzj("measurement.service_client.idle_disconnect_millis", 5000);
    }
}
