package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.internal.zzac;
import com.google.api.client.http.ExponentialBackOffPolicy;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzsw {
    public static zza<String> zzafA;
    public static zza<String> zzafB;
    public static zza<String> zzafC;
    public static zza<Integer> zzafD;
    public static zza<String> zzafE;
    public static zza<String> zzafF;
    public static zza<Integer> zzafG;
    public static zza<Integer> zzafH;
    public static zza<Integer> zzafI;
    public static zza<Integer> zzafJ;
    public static zza<String> zzafK;
    public static zza<Integer> zzafL;
    public static zza<Long> zzafM;
    public static zza<Integer> zzafN;
    public static zza<Integer> zzafO;
    public static zza<Long> zzafP;
    public static zza<String> zzafQ;
    public static zza<Integer> zzafR;
    public static zza<Boolean> zzafS;
    public static zza<Long> zzafT;
    public static zza<Long> zzafU;
    public static zza<Long> zzafV;
    public static zza<Long> zzafW;
    public static zza<Long> zzafX;
    public static zza<Long> zzafY;
    public static zza<Long> zzafZ;
    public static zza<Boolean> zzafj;
    public static zza<Boolean> zzafk;
    public static zza<String> zzafl;
    public static zza<Long> zzafm;
    public static zza<Float> zzafn;
    public static zza<Integer> zzafo;
    public static zza<Integer> zzafp;
    public static zza<Integer> zzafq;
    public static zza<Long> zzafr;
    public static zza<Long> zzafs;
    public static zza<Long> zzaft;
    public static zza<Long> zzafu;
    public static zza<Long> zzafv;
    public static zza<Long> zzafw;
    public static zza<Integer> zzafx;
    public static zza<Integer> zzafy;
    public static zza<String> zzafz;

    public static final class zza<V> {
        private final V zzaga;
        private final zzaca<V> zzagb;

        private zza(zzaca<V> com_google_android_gms_internal_zzaca_V, V v) {
            zzac.zzw(com_google_android_gms_internal_zzaca_V);
            this.zzagb = com_google_android_gms_internal_zzaca_V;
            this.zzaga = v;
        }

        static zza<Float> zza(String str, float f) {
            return zza(str, f, f);
        }

        static zza<Float> zza(String str, float f, float f2) {
            return new zza(zzaca.zza(str, Float.valueOf(f2)), Float.valueOf(f));
        }

        static zza<Integer> zza(String str, int i, int i2) {
            return new zza(zzaca.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Long> zza(String str, long j, long j2) {
            return new zza(zzaca.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<Boolean> zza(String str, boolean z, boolean z2) {
            return new zza(zzaca.zzj(str, z2), Boolean.valueOf(z));
        }

        static zza<Long> zzb(String str, long j) {
            return zza(str, j, j);
        }

        static zza<String> zzd(String str, String str2, String str3) {
            return new zza(zzaca.zzB(str, str3), str2);
        }

        static zza<Integer> zze(String str, int i) {
            return zza(str, i, i);
        }

        static zza<Boolean> zzf(String str, boolean z) {
            return zza(str, z, z);
        }

        static zza<String> zzr(String str, String str2) {
            return zzd(str, str2, str2);
        }

        public V get() {
            return this.zzaga;
        }
    }

    static {
        zzafj = zza.zzf("analytics.service_enabled", false);
        zzafk = zza.zzf("analytics.service_client_enabled", true);
        zzafl = zza.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
        zzafm = zza.zzb("analytics.max_tokens", 60);
        zzafn = zza.zza("analytics.tokens_per_sec", 0.5f);
        zzafo = zza.zza("analytics.max_stored_hits", 2000, 20000);
        zzafp = zza.zze("analytics.max_stored_hits_per_app", 2000);
        zzafq = zza.zze("analytics.max_stored_properties_per_app", 100);
        zzafr = zza.zza("analytics.local_dispatch_millis", 1800000, 120000);
        zzafs = zza.zza("analytics.initial_local_dispatch_millis", 5000, 5000);
        zzaft = zza.zzb("analytics.min_local_dispatch_millis", 120000);
        zzafu = zza.zzb("analytics.max_local_dispatch_millis", 7200000);
        zzafv = zza.zzb("analytics.dispatch_alarm_millis", 7200000);
        zzafw = zza.zzb("analytics.max_dispatch_alarm_millis", 32400000);
        zzafx = zza.zze("analytics.max_hits_per_dispatch", 20);
        zzafy = zza.zze("analytics.max_hits_per_batch", 20);
        zzafz = zza.zzr("analytics.insecure_host", "http://www.google-analytics.com");
        zzafA = zza.zzr("analytics.secure_host", "https://ssl.google-analytics.com");
        zzafB = zza.zzr("analytics.simple_endpoint", "/collect");
        zzafC = zza.zzr("analytics.batching_endpoint", "/batch");
        zzafD = zza.zze("analytics.max_get_length", 2036);
        zzafE = zza.zzd("analytics.batching_strategy.k", zzsj.BATCH_BY_COUNT.name(), zzsj.BATCH_BY_COUNT.name());
        zzafF = zza.zzr("analytics.compression_strategy.k", zzsm.GZIP.name());
        zzafG = zza.zze("analytics.max_hits_per_request.k", 20);
        zzafH = zza.zze("analytics.max_hit_length.k", AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        zzafI = zza.zze("analytics.max_post_length.k", AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        zzafJ = zza.zze("analytics.max_batch_post_length", AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        zzafK = zza.zzr("analytics.fallback_responses.k", "404,502");
        zzafL = zza.zze("analytics.batch_retry_interval.seconds.k", 3600);
        zzafM = zza.zzb("analytics.service_monitor_interval", 86400000);
        zzafN = zza.zze("analytics.http_connection.connect_timeout_millis", ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS);
        zzafO = zza.zze("analytics.http_connection.read_timeout_millis", 61000);
        zzafP = zza.zzb("analytics.campaigns.time_limit", 86400000);
        zzafQ = zza.zzr("analytics.first_party_experiment_id", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        zzafR = zza.zze("analytics.first_party_experiment_variant", 0);
        zzafS = zza.zzf("analytics.test.disable_receiver", false);
        zzafT = zza.zza("analytics.service_client.idle_disconnect_millis", 10000, 10000);
        zzafU = zza.zzb("analytics.service_client.connect_timeout_millis", 5000);
        zzafV = zza.zzb("analytics.service_client.second_connect_delay_millis", 5000);
        zzafW = zza.zzb("analytics.service_client.unexpected_reconnect_millis", 60000);
        zzafX = zza.zzb("analytics.service_client.reconnect_throttle_millis", 1800000);
        zzafY = zza.zzb("analytics.monitoring.sample_period_millis", 86400000);
        zzafZ = zza.zzb("analytics.initialization_warning_threshold", 5000);
    }
}
