package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

@zzme
public final class zzpm {

    public interface zzb {
        void zzh(Bundle bundle);
    }

    private static abstract class zza extends zzpj {
        private zza() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.10 */
    class AnonymousClass10 extends zza {
        final /* synthetic */ zzb zzXn;
        final /* synthetic */ Context zztf;

        AnonymousClass10(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
            this.zztf = context;
            this.zzXn = com_google_android_gms_internal_zzpm_zzb;
            super();
        }

        public void zzco() {
            SharedPreferences zzn = zzpm.zzn(this.zztf);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", zzn.getBoolean("use_https", true));
            if (this.zzXn != null) {
                this.zzXn.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.11 */
    class AnonymousClass11 extends zza {
        final /* synthetic */ zzb zzXn;
        final /* synthetic */ Context zztf;

        AnonymousClass11(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
            this.zztf = context;
            this.zzXn = com_google_android_gms_internal_zzpm_zzb;
            super();
        }

        public void zzco() {
            SharedPreferences zzn = zzpm.zzn(this.zztf);
            Bundle bundle = new Bundle();
            bundle.putInt("request_in_session_count", zzn.getInt("request_in_session_count", -1));
            if (this.zzXn != null) {
                this.zzXn.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.12 */
    class AnonymousClass12 extends zza {
        final /* synthetic */ long zzXs;
        final /* synthetic */ Context zztf;

        AnonymousClass12(Context context, long j) {
            this.zztf = context;
            this.zzXs = j;
            super();
        }

        public void zzco() {
            Editor edit = zzpm.zzn(this.zztf).edit();
            edit.putLong("first_ad_req_time_ms", this.zzXs);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.13 */
    class AnonymousClass13 extends zza {
        final /* synthetic */ zzb zzXn;
        final /* synthetic */ Context zztf;

        AnonymousClass13(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
            this.zztf = context;
            this.zzXn = com_google_android_gms_internal_zzpm_zzb;
            super();
        }

        public void zzco() {
            SharedPreferences zzn = zzpm.zzn(this.zztf);
            Bundle bundle = new Bundle();
            bundle.putLong("first_ad_req_time_ms", zzn.getLong("first_ad_req_time_ms", 0));
            if (this.zzXn != null) {
                this.zzXn.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.14 */
    class AnonymousClass14 extends zza {
        final /* synthetic */ zzb zzXn;
        final /* synthetic */ Context zztf;

        AnonymousClass14(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
            this.zztf = context;
            this.zzXn = com_google_android_gms_internal_zzpm_zzb;
            super();
        }

        public void zzco() {
            SharedPreferences zzn = zzpm.zzn(this.zztf);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", zzn.getInt("webview_cache_version", 0));
            if (this.zzXn != null) {
                this.zzXn.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.15 */
    class AnonymousClass15 extends zza {
        final /* synthetic */ boolean zzXt;
        final /* synthetic */ Context zztf;

        AnonymousClass15(Context context, boolean z) {
            this.zztf = context;
            this.zzXt = z;
            super();
        }

        public void zzco() {
            Editor edit = zzpm.zzn(this.zztf).edit();
            edit.putBoolean("content_url_opted_out", this.zzXt);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.16 */
    class AnonymousClass16 extends zza {
        final /* synthetic */ zzb zzXn;
        final /* synthetic */ Context zztf;

        AnonymousClass16(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
            this.zztf = context;
            this.zzXn = com_google_android_gms_internal_zzpm_zzb;
            super();
        }

        public void zzco() {
            SharedPreferences zzn = zzpm.zzn(this.zztf);
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", zzn.getBoolean("content_url_opted_out", true));
            if (this.zzXn != null) {
                this.zzXn.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.17 */
    class AnonymousClass17 extends zza {
        final /* synthetic */ String zzXl;
        final /* synthetic */ Context zztf;

        AnonymousClass17(Context context, String str) {
            this.zztf = context;
            this.zzXl = str;
            super();
        }

        public void zzco() {
            Editor edit = zzpm.zzn(this.zztf).edit();
            edit.putString("content_url_hashes", this.zzXl);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.18 */
    class AnonymousClass18 extends zza {
        final /* synthetic */ zzb zzXn;
        final /* synthetic */ Context zztf;

        AnonymousClass18(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
            this.zztf = context;
            this.zzXn = com_google_android_gms_internal_zzpm_zzb;
            super();
        }

        public void zzco() {
            SharedPreferences zzn = zzpm.zzn(this.zztf);
            Bundle bundle = new Bundle();
            bundle.putString("content_url_hashes", zzn.getString("content_url_hashes", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING));
            if (this.zzXn != null) {
                this.zzXn.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.1 */
    class C13461 extends zza {
        final /* synthetic */ boolean zzXk;
        final /* synthetic */ Context zztf;

        C13461(Context context, boolean z) {
            this.zztf = context;
            this.zzXk = z;
            super();
        }

        public void zzco() {
            Editor edit = zzpm.zzn(this.zztf).edit();
            edit.putBoolean("use_https", this.zzXk);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.2 */
    class C13472 extends zza {
        final /* synthetic */ String zzXl;
        final /* synthetic */ Context zztf;

        C13472(Context context, String str) {
            this.zztf = context;
            this.zzXl = str;
            super();
        }

        public void zzco() {
            Editor edit = zzpm.zzn(this.zztf).edit();
            edit.putString("content_vertical_hashes", this.zzXl);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.3 */
    class C13483 extends zza {
        final /* synthetic */ boolean zzXm;
        final /* synthetic */ Context zztf;

        C13483(Context context, boolean z) {
            this.zztf = context;
            this.zzXm = z;
            super();
        }

        public void zzco() {
            Editor edit = zzpm.zzn(this.zztf).edit();
            edit.putBoolean("auto_collect_location", this.zzXm);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.4 */
    class C13494 extends zza {
        final /* synthetic */ zzb zzXn;
        final /* synthetic */ Context zztf;

        C13494(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
            this.zztf = context;
            this.zzXn = com_google_android_gms_internal_zzpm_zzb;
            super();
        }

        public void zzco() {
            SharedPreferences zzn = zzpm.zzn(this.zztf);
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", zzn.getBoolean("auto_collect_location", false));
            if (this.zzXn != null) {
                this.zzXn.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.5 */
    class C13505 extends zza {
        final /* synthetic */ String zzXo;
        final /* synthetic */ long zzXp;
        final /* synthetic */ Context zztf;

        C13505(Context context, String str, long j) {
            this.zztf = context;
            this.zzXo = str;
            this.zzXp = j;
            super();
        }

        public void zzco() {
            Editor edit = zzpm.zzn(this.zztf).edit();
            edit.putString("app_settings_json", this.zzXo);
            edit.putLong("app_settings_last_update_ms", this.zzXp);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.6 */
    class C13516 extends zza {
        final /* synthetic */ zzb zzXn;
        final /* synthetic */ Context zztf;

        C13516(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
            this.zztf = context;
            this.zzXn = com_google_android_gms_internal_zzpm_zzb;
            super();
        }

        public void zzco() {
            SharedPreferences zzn = zzpm.zzn(this.zztf);
            Bundle bundle = new Bundle();
            bundle.putString("app_settings_json", zzn.getString("app_settings_json", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING));
            bundle.putLong("app_settings_last_update_ms", zzn.getLong("app_settings_last_update_ms", 0));
            if (this.zzXn != null) {
                this.zzXn.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.7 */
    class C13527 extends zza {
        final /* synthetic */ long zzXq;
        final /* synthetic */ Context zztf;

        C13527(Context context, long j) {
            this.zztf = context;
            this.zzXq = j;
            super();
        }

        public void zzco() {
            Editor edit = zzpm.zzn(this.zztf).edit();
            edit.putLong("app_last_background_time_ms", this.zzXq);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.8 */
    class C13538 extends zza {
        final /* synthetic */ zzb zzXn;
        final /* synthetic */ Context zztf;

        C13538(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
            this.zztf = context;
            this.zzXn = com_google_android_gms_internal_zzpm_zzb;
            super();
        }

        public void zzco() {
            SharedPreferences zzn = zzpm.zzn(this.zztf);
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", zzn.getLong("app_last_background_time_ms", 0));
            if (this.zzXn != null) {
                this.zzXn.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpm.9 */
    class C13549 extends zza {
        final /* synthetic */ int zzXr;
        final /* synthetic */ Context zztf;

        C13549(Context context, int i) {
            this.zztf = context;
            this.zzXr = i;
            super();
        }

        public void zzco() {
            Editor edit = zzpm.zzn(this.zztf).edit();
            edit.putInt("request_in_session_count", this.zzXr);
            edit.apply();
        }
    }

    public static Future zza(Context context, int i) {
        return (Future) new C13549(context, i).zziP();
    }

    public static Future zza(Context context, long j) {
        return (Future) new C13527(context, j).zziP();
    }

    public static Future zza(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
        return (Future) new AnonymousClass10(context, com_google_android_gms_internal_zzpm_zzb).zziP();
    }

    public static Future zza(Context context, String str, long j) {
        return (Future) new C13505(context, str, j).zziP();
    }

    public static Future zzb(Context context, long j) {
        return (Future) new AnonymousClass12(context, j).zziP();
    }

    public static Future zzb(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
        return (Future) new AnonymousClass14(context, com_google_android_gms_internal_zzpm_zzb).zziP();
    }

    public static Future zzc(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
        return (Future) new AnonymousClass16(context, com_google_android_gms_internal_zzpm_zzb).zziP();
    }

    public static Future zzc(Context context, boolean z) {
        return (Future) new C13461(context, z).zziP();
    }

    public static Future zzd(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
        return (Future) new AnonymousClass18(context, com_google_android_gms_internal_zzpm_zzb).zziP();
    }

    public static Future zze(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
        return (Future) new C13494(context, com_google_android_gms_internal_zzpm_zzb).zziP();
    }

    public static Future zze(Context context, boolean z) {
        return (Future) new AnonymousClass15(context, z).zziP();
    }

    public static Future zzf(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
        return (Future) new C13516(context, com_google_android_gms_internal_zzpm_zzb).zziP();
    }

    public static Future zzf(Context context, boolean z) {
        return (Future) new C13483(context, z).zziP();
    }

    public static Future zzg(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
        return (Future) new C13538(context, com_google_android_gms_internal_zzpm_zzb).zziP();
    }

    public static Future zzh(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
        return (Future) new AnonymousClass11(context, com_google_android_gms_internal_zzpm_zzb).zziP();
    }

    public static Future zzi(Context context, zzb com_google_android_gms_internal_zzpm_zzb) {
        return (Future) new AnonymousClass13(context, com_google_android_gms_internal_zzpm_zzb).zziP();
    }

    public static SharedPreferences zzn(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    public static Future zzp(Context context, String str) {
        return (Future) new AnonymousClass17(context, str).zziP();
    }

    public static Future zzq(Context context, String str) {
        return (Future) new C13472(context, str).zziP();
    }

    public static void zzr(Context context, String str) {
        SharedPreferences zzn = zzn(context);
        Collection stringSet = zzn.getStringSet("never_pool_slots", Collections.emptySet());
        if (!stringSet.contains(str)) {
            Set hashSet = new HashSet(stringSet);
            hashSet.add(str);
            Editor edit = zzn.edit();
            edit.putStringSet("never_pool_slots", hashSet);
            edit.apply();
        }
    }

    public static void zzs(Context context, String str) {
        SharedPreferences zzn = zzn(context);
        Collection stringSet = zzn.getStringSet("never_pool_slots", Collections.emptySet());
        if (stringSet.contains(str)) {
            Set hashSet = new HashSet(stringSet);
            hashSet.remove(str);
            Editor edit = zzn.edit();
            edit.putStringSet("never_pool_slots", hashSet);
            edit.apply();
        }
    }

    public static boolean zzt(Context context, String str) {
        return zzn(context).getStringSet("never_pool_slots", Collections.emptySet()).contains(str);
    }
}
