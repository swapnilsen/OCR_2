package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zznm.zza;
import com.google.android.gms.plus.PlusShare;
import com.google.api.client.http.HttpMethods;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public final class zznd {
    private static final SimpleDateFormat zzTJ;

    static {
        zzTJ = new SimpleDateFormat("yyyyMMdd", Locale.US);
    }

    private static Integer zzB(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    public static zzmn zza(Context context, zzmk com_google_android_gms_internal_zzmk, String str) {
        String optString;
        try {
            String str2;
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("ad_base_url", null);
            Object optString3 = jSONObject.optString("ad_url", null);
            String optString4 = jSONObject.optString("ad_size", null);
            String optString5 = jSONObject.optString("ad_slot_size", optString4);
            boolean z = (com_google_android_gms_internal_zzmk == null || com_google_android_gms_internal_zzmk.zzRE == 0) ? false : true;
            CharSequence optString6 = jSONObject.optString("ad_json", null);
            if (optString6 == null) {
                optString6 = jSONObject.optString("ad_html", null);
            }
            if (optString6 == null) {
                optString6 = jSONObject.optString("body", null);
            }
            long j = -1;
            String optString7 = jSONObject.optString("debug_dialog", null);
            String optString8 = jSONObject.optString("debug_signals", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            optString = jSONObject.optString("orientation", null);
            int i = -1;
            if ("portrait".equals(optString)) {
                i = zzw.zzcO().zzkR();
            } else if ("landscape".equals(optString)) {
                i = zzw.zzcO().zzkQ();
            }
            zzmn com_google_android_gms_internal_zzmn = null;
            if (!TextUtils.isEmpty(optString6) || TextUtils.isEmpty(optString3)) {
                CharSequence charSequence = optString6;
            } else {
                com_google_android_gms_internal_zzmn = zznc.zza(com_google_android_gms_internal_zzmk, context, com_google_android_gms_internal_zzmk.zzvn.zzba, optString3, null, null, null, null);
                optString2 = com_google_android_gms_internal_zzmn.zzNJ;
                str2 = com_google_android_gms_internal_zzmn.body;
                j = com_google_android_gms_internal_zzmn.zzSr;
            }
            if (str2 == null) {
                return new zzmn(0);
            }
            long j3;
            String optString9;
            String str3;
            boolean optBoolean;
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list = com_google_android_gms_internal_zzmn == null ? null : com_google_android_gms_internal_zzmn.zzKF;
            if (optJSONArray != null) {
                list = zza(optJSONArray, list);
            }
            optJSONArray = jSONObject.optJSONArray("impression_urls");
            List list2 = com_google_android_gms_internal_zzmn == null ? null : com_google_android_gms_internal_zzmn.zzKG;
            if (optJSONArray != null) {
                list2 = zza(optJSONArray, list2);
            }
            optJSONArray = jSONObject.optJSONArray("manual_impression_urls");
            List list3 = com_google_android_gms_internal_zzmn == null ? null : com_google_android_gms_internal_zzmn.zzSp;
            if (optJSONArray != null) {
                list3 = zza(optJSONArray, list3);
            }
            if (com_google_android_gms_internal_zzmn != null) {
                if (com_google_android_gms_internal_zzmn.orientation != -1) {
                    i = com_google_android_gms_internal_zzmn.orientation;
                }
                if (com_google_android_gms_internal_zzmn.zzSm > 0) {
                    j3 = com_google_android_gms_internal_zzmn.zzSm;
                    optString9 = jSONObject.optString("active_view");
                    str3 = null;
                    optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                    if (optBoolean) {
                        str3 = jSONObject.optString("ad_passback_url", null);
                    }
                    return new zzmn(com_google_android_gms_internal_zzmk, optString2, str2, list, list2, j3, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, str3, optString9, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzmk.zzRG, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING), "height".equals(jSONObject.optString("fluid", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)), jSONObject.optBoolean("native_express", false), zzoo.zza(jSONObject.optJSONArray("rewards")), zza(jSONObject.optJSONArray("video_start_urls"), null), zza(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzmp.zzf(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzmk.zzRV, jSONObject.optString("set_cookie", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING), zza(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzmk.zzKJ), optString5, zzor.zzh(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), com_google_android_gms_internal_zzmk.zzSh);
                }
            }
            j3 = j2;
            optString9 = jSONObject.optString("active_view");
            str3 = null;
            optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str3 = jSONObject.optString("ad_passback_url", null);
            }
            return new zzmn(com_google_android_gms_internal_zzmk, optString2, str2, list, list2, j3, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, str3, optString9, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzmk.zzRG, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING), "height".equals(jSONObject.optString("fluid", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)), jSONObject.optBoolean("native_express", false), zzoo.zza(jSONObject.optJSONArray("rewards")), zza(jSONObject.optJSONArray("video_start_urls"), null), zza(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzmp.zzf(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzmk.zzRV, jSONObject.optString("set_cookie", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING), zza(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzmk.zzKJ), optString5, zzor.zzh(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), com_google_android_gms_internal_zzmk.zzSh);
        } catch (JSONException e) {
            String str4 = "Could not parse the inline ad response: ";
            optString = String.valueOf(e.getMessage());
            zzqf.zzbh(optString.length() != 0 ? str4.concat(optString) : new String(str4));
            return new zzmn(0);
        }
    }

    @Nullable
    private static List<String> zza(@Nullable JSONArray jSONArray, @Nullable List<String> list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    @Nullable
    public static JSONObject zza(Context context, zzna com_google_android_gms_internal_zzna) {
        Object obj;
        String str;
        String valueOf;
        zzmk com_google_android_gms_internal_zzmk = com_google_android_gms_internal_zzna.zzTi;
        Location location = com_google_android_gms_internal_zzna.zzzb;
        zzni com_google_android_gms_internal_zzni = com_google_android_gms_internal_zzna.zzTj;
        Bundle bundle = com_google_android_gms_internal_zzna.zzRF;
        JSONObject jSONObject = com_google_android_gms_internal_zzna.zzTk;
        HashMap hashMap = new HashMap();
        hashMap.put("extra_caps", zzgd.zzEe.get());
        if (com_google_android_gms_internal_zzna.zzRM.size() > 0) {
            hashMap.put("eid", TextUtils.join(",", com_google_android_gms_internal_zzna.zzRM));
        }
        if (com_google_android_gms_internal_zzmk.zzRx != null) {
            hashMap.put("ad_pos", com_google_android_gms_internal_zzmk.zzRx);
        }
        zza(hashMap, com_google_android_gms_internal_zzmk.zzRy);
        if (com_google_android_gms_internal_zzmk.zzvr.zzzA != null) {
            obj = null;
            Object obj2 = null;
            for (zzeg com_google_android_gms_internal_zzeg : com_google_android_gms_internal_zzmk.zzvr.zzzA) {
                if (!com_google_android_gms_internal_zzeg.zzzC && r3 == null) {
                    hashMap.put("format", com_google_android_gms_internal_zzeg.zzzy);
                    obj2 = 1;
                }
                if (com_google_android_gms_internal_zzeg.zzzC && r2 == null) {
                    hashMap.put("fluid", "height");
                    obj = 1;
                }
                if (obj2 != null && r2 != null) {
                    break;
                }
            }
        } else {
            hashMap.put("format", com_google_android_gms_internal_zzmk.zzvr.zzzy);
            if (com_google_android_gms_internal_zzmk.zzvr.zzzC) {
                hashMap.put("fluid", "height");
            }
        }
        if (com_google_android_gms_internal_zzmk.zzvr.width == -1) {
            hashMap.put("smart_w", "full");
        }
        if (com_google_android_gms_internal_zzmk.zzvr.height == -2) {
            hashMap.put("smart_h", "auto");
        }
        if (com_google_android_gms_internal_zzmk.zzvr.zzzA != null) {
            StringBuilder stringBuilder = new StringBuilder();
            obj = null;
            for (zzeg com_google_android_gms_internal_zzeg2 : com_google_android_gms_internal_zzmk.zzvr.zzzA) {
                if (com_google_android_gms_internal_zzeg2.zzzC) {
                    obj = 1;
                } else {
                    int i;
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    if (com_google_android_gms_internal_zzeg2.width == -1) {
                        i = (int) (((float) com_google_android_gms_internal_zzeg2.widthPixels) / com_google_android_gms_internal_zzni.zzxk);
                    } else {
                        try {
                            i = com_google_android_gms_internal_zzeg2.width;
                        } catch (JSONException e) {
                            str = "Problem serializing ad request to JSON: ";
                            valueOf = String.valueOf(e.getMessage());
                            zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                            return null;
                        }
                    }
                    stringBuilder.append(i);
                    stringBuilder.append("x");
                    stringBuilder.append(com_google_android_gms_internal_zzeg2.height == -2 ? (int) (((float) com_google_android_gms_internal_zzeg2.heightPixels) / com_google_android_gms_internal_zzni.zzxk) : com_google_android_gms_internal_zzeg2.height);
                }
            }
            if (obj != null) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.insert(0, "|");
                }
                stringBuilder.insert(0, "320x50");
            }
            hashMap.put("sz", stringBuilder);
        }
        if (com_google_android_gms_internal_zzmk.zzRE != 0) {
            hashMap.put("native_version", Integer.valueOf(com_google_android_gms_internal_zzmk.zzRE));
            hashMap.put("native_templates", com_google_android_gms_internal_zzmk.zzvK);
            hashMap.put("native_image_orientation", zzc(com_google_android_gms_internal_zzmk.zzvF));
            if (!com_google_android_gms_internal_zzmk.zzRN.isEmpty()) {
                hashMap.put("native_custom_templates", com_google_android_gms_internal_zzmk.zzRN);
            }
        }
        if (com_google_android_gms_internal_zzmk.zzvr.zzzD) {
            hashMap.put("ene", Boolean.valueOf(true));
        }
        if (com_google_android_gms_internal_zzmk.zzvH != null) {
            hashMap.put("is_icon_ad", Boolean.valueOf(true));
            hashMap.put("icon_ad_expansion_behavior", Integer.valueOf(com_google_android_gms_internal_zzmk.zzvH.zzzZ));
        }
        hashMap.put("slotname", com_google_android_gms_internal_zzmk.zzvl);
        hashMap.put("pn", com_google_android_gms_internal_zzmk.applicationInfo.packageName);
        if (com_google_android_gms_internal_zzmk.zzRz != null) {
            hashMap.put("vc", Integer.valueOf(com_google_android_gms_internal_zzmk.zzRz.versionCode));
        }
        hashMap.put("ms", com_google_android_gms_internal_zzna.zzRA);
        hashMap.put("seq_num", com_google_android_gms_internal_zzmk.zzRB);
        hashMap.put("session_id", com_google_android_gms_internal_zzmk.zzRC);
        hashMap.put("js", com_google_android_gms_internal_zzmk.zzvn.zzba);
        zza(hashMap, com_google_android_gms_internal_zzni, com_google_android_gms_internal_zzna.zzTg, com_google_android_gms_internal_zzmk.zzSa, com_google_android_gms_internal_zzna.zzTf);
        zza(hashMap, com_google_android_gms_internal_zzna, context);
        hashMap.put("platform", Build.MANUFACTURER);
        hashMap.put("submodel", Build.MODEL);
        if (location != null) {
            zza(hashMap, location);
        } else if (com_google_android_gms_internal_zzmk.zzRy.versionCode >= 2 && com_google_android_gms_internal_zzmk.zzRy.zzzb != null) {
            zza(hashMap, com_google_android_gms_internal_zzmk.zzRy.zzzb);
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 2) {
            hashMap.put("quality_signals", com_google_android_gms_internal_zzmk.zzRD);
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 4 && com_google_android_gms_internal_zzmk.zzRG) {
            hashMap.put("forceHttps", Boolean.valueOf(com_google_android_gms_internal_zzmk.zzRG));
        }
        if (bundle != null) {
            hashMap.put("content_info", bundle);
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 5) {
            hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzmk.zzxk));
            hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzmk.zzRI));
            hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzmk.zzRH));
        } else {
            hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzni.zzxk));
            hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzni.zzRI));
            hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzni.zzRH));
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 6) {
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzmk.zzRJ)) {
                try {
                    hashMap.put("view_hierarchy", new JSONObject(com_google_android_gms_internal_zzmk.zzRJ));
                } catch (Throwable e2) {
                    zzqf.zzc("Problem serializing view hierarchy to JSON", e2);
                }
            }
            hashMap.put("correlation_id", Long.valueOf(com_google_android_gms_internal_zzmk.zzRK));
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 7) {
            hashMap.put("request_id", com_google_android_gms_internal_zzmk.zzRL);
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 11 && com_google_android_gms_internal_zzmk.zzRP != null) {
            hashMap.put("capability", com_google_android_gms_internal_zzmk.zzRP.toBundle());
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 12 && !TextUtils.isEmpty(com_google_android_gms_internal_zzmk.zzRQ)) {
            hashMap.put("anchor", com_google_android_gms_internal_zzmk.zzRQ);
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 13) {
            hashMap.put("android_app_volume", Float.valueOf(com_google_android_gms_internal_zzmk.zzRR));
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 18) {
            hashMap.put("android_app_muted", Boolean.valueOf(com_google_android_gms_internal_zzmk.zzRX));
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 14 && com_google_android_gms_internal_zzmk.zzRS > 0) {
            hashMap.put("target_api", Integer.valueOf(com_google_android_gms_internal_zzmk.zzRS));
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 15) {
            hashMap.put("scroll_index", Integer.valueOf(com_google_android_gms_internal_zzmk.zzRT == -1 ? -1 : com_google_android_gms_internal_zzmk.zzRT));
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 16) {
            hashMap.put("_activity_context", Boolean.valueOf(com_google_android_gms_internal_zzmk.zzRU));
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 18) {
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzmk.zzRY)) {
                try {
                    hashMap.put("app_settings", new JSONObject(com_google_android_gms_internal_zzmk.zzRY));
                } catch (Throwable e22) {
                    zzqf.zzc("Problem creating json from app settings", e22);
                }
            }
            hashMap.put("render_in_browser", Boolean.valueOf(com_google_android_gms_internal_zzmk.zzKJ));
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 18) {
            hashMap.put("android_num_video_cache_tasks", Integer.valueOf(com_google_android_gms_internal_zzmk.zzRZ));
        }
        zza(context, hashMap, com_google_android_gms_internal_zzmk.zzvn);
        hashMap.put("cache_state", jSONObject);
        if (com_google_android_gms_internal_zzmk.versionCode >= 19) {
            hashMap.put("gct", com_google_android_gms_internal_zzmk.zzSb);
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 21 && com_google_android_gms_internal_zzmk.zzSc) {
            hashMap.put("de", "1");
        }
        if (((Boolean) zzgd.zzDc.get()).booleanValue()) {
            zza(hashMap, com_google_android_gms_internal_zzmk);
        }
        if (com_google_android_gms_internal_zzmk.versionCode >= 22 && zzw.zzdl().zzjQ()) {
            hashMap.put("gmp_app_id", com_google_android_gms_internal_zzmk.zzSe);
            hashMap.put("fbs_aiid", com_google_android_gms_internal_zzmk.zzSf);
            hashMap.put("fbs_aeid", com_google_android_gms_internal_zzmk.zzSg);
        }
        if (zzqf.zzak(2)) {
            str = "Ad Request JSON: ";
            valueOf = String.valueOf(zzw.zzcM().zzQ((Map) hashMap).toString(2));
            zzpk.m4709v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        return zzw.zzcM().zzQ((Map) hashMap);
    }

    private static void zza(Context context, HashMap<String, Object> hashMap, zzqh com_google_android_gms_internal_zzqh) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putString("cl", "149960398");
        bundle2.putString("rapid_rc", "dev");
        bundle2.putString("rapid_rollup", HttpMethods.HEAD);
        bundle.putBundle("build_meta", bundle2);
        bundle.putString("mf", Boolean.toString(((Boolean) zzgd.zzEg.get()).booleanValue()));
        bundle.putBoolean("instant_app", zzadg.zzbi(context).zzzx());
        bundle.putBoolean("lite", com_google_android_gms_internal_zzqh.zzYZ);
        hashMap.put("sdk_env", bundle);
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void zza(HashMap<String, Object> hashMap, zzec com_google_android_gms_internal_zzec) {
        String zzkF = zzpi.zzkF();
        if (zzkF != null) {
            hashMap.put("abf", zzkF);
        }
        if (com_google_android_gms_internal_zzec.zzyT != -1) {
            hashMap.put("cust_age", zzTJ.format(new Date(com_google_android_gms_internal_zzec.zzyT)));
        }
        if (com_google_android_gms_internal_zzec.extras != null) {
            hashMap.put("extras", com_google_android_gms_internal_zzec.extras);
        }
        if (com_google_android_gms_internal_zzec.zzyU != -1) {
            hashMap.put("cust_gender", Integer.valueOf(com_google_android_gms_internal_zzec.zzyU));
        }
        if (com_google_android_gms_internal_zzec.zzyV != null) {
            hashMap.put("kw", com_google_android_gms_internal_zzec.zzyV);
        }
        if (com_google_android_gms_internal_zzec.zzyX != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(com_google_android_gms_internal_zzec.zzyX));
        }
        if (com_google_android_gms_internal_zzec.zzyW) {
            hashMap.put("adtest", "on");
        }
        if (com_google_android_gms_internal_zzec.versionCode >= 2) {
            if (com_google_android_gms_internal_zzec.zzyY) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzec.zzyZ)) {
                hashMap.put("ppid", com_google_android_gms_internal_zzec.zzyZ);
            }
            if (com_google_android_gms_internal_zzec.zzza != null) {
                zza((HashMap) hashMap, com_google_android_gms_internal_zzec.zzza);
            }
        }
        if (com_google_android_gms_internal_zzec.versionCode >= 3 && com_google_android_gms_internal_zzec.zzzc != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, com_google_android_gms_internal_zzec.zzzc);
        }
        if (com_google_android_gms_internal_zzec.versionCode >= 5) {
            if (com_google_android_gms_internal_zzec.zzze != null) {
                hashMap.put("custom_targeting", com_google_android_gms_internal_zzec.zzze);
            }
            if (com_google_android_gms_internal_zzec.zzzf != null) {
                hashMap.put("category_exclusions", com_google_android_gms_internal_zzec.zzzf);
            }
            if (com_google_android_gms_internal_zzec.zzzg != null) {
                hashMap.put("request_agent", com_google_android_gms_internal_zzec.zzzg);
            }
        }
        if (com_google_android_gms_internal_zzec.versionCode >= 6 && com_google_android_gms_internal_zzec.zzzh != null) {
            hashMap.put("request_pkg", com_google_android_gms_internal_zzec.zzzh);
        }
        if (com_google_android_gms_internal_zzec.versionCode >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(com_google_android_gms_internal_zzec.zzzi));
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzfp com_google_android_gms_internal_zzfp) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(com_google_android_gms_internal_zzfp.zzAH) != 0) {
            hashMap.put("acolor", zzab(com_google_android_gms_internal_zzfp.zzAH));
        }
        if (Color.alpha(com_google_android_gms_internal_zzfp.backgroundColor) != 0) {
            hashMap.put("bgcolor", zzab(com_google_android_gms_internal_zzfp.backgroundColor));
        }
        if (!(Color.alpha(com_google_android_gms_internal_zzfp.zzAI) == 0 || Color.alpha(com_google_android_gms_internal_zzfp.zzAJ) == 0)) {
            hashMap.put("gradientto", zzab(com_google_android_gms_internal_zzfp.zzAI));
            hashMap.put("gradientfrom", zzab(com_google_android_gms_internal_zzfp.zzAJ));
        }
        if (Color.alpha(com_google_android_gms_internal_zzfp.zzAK) != 0) {
            hashMap.put("bcolor", zzab(com_google_android_gms_internal_zzfp.zzAK));
        }
        hashMap.put("bthick", Integer.toString(com_google_android_gms_internal_zzfp.zzAL));
        switch (com_google_android_gms_internal_zzfp.zzAM) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                obj = "none";
                break;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                obj = "dashed";
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                obj = "dotted";
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (com_google_android_gms_internal_zzfp.zzAN) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                obj2 = "light";
                break;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                obj2 = Param.MEDIUM;
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (com_google_android_gms_internal_zzfp.zzAO != null) {
            hashMap.put("channel", com_google_android_gms_internal_zzfp.zzAO);
        }
        if (Color.alpha(com_google_android_gms_internal_zzfp.zzAP) != 0) {
            hashMap.put("dcolor", zzab(com_google_android_gms_internal_zzfp.zzAP));
        }
        if (com_google_android_gms_internal_zzfp.zzAQ != null) {
            hashMap.put("font", com_google_android_gms_internal_zzfp.zzAQ);
        }
        if (Color.alpha(com_google_android_gms_internal_zzfp.zzAR) != 0) {
            hashMap.put("hcolor", zzab(com_google_android_gms_internal_zzfp.zzAR));
        }
        hashMap.put("headersize", Integer.toString(com_google_android_gms_internal_zzfp.zzAS));
        if (com_google_android_gms_internal_zzfp.zzAT != null) {
            hashMap.put("q", com_google_android_gms_internal_zzfp.zzAT);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzmk com_google_android_gms_internal_zzmk) {
        Object obj = 1;
        String str = com_google_android_gms_internal_zzmk.zzvr.zzzy;
        Object obj2 = (str.equals("interstitial_mb") || str.equals("reward_mb")) ? 1 : null;
        Bundle bundle = com_google_android_gms_internal_zzmk.zzSd;
        if (bundle == null) {
            obj = null;
        }
        if (obj2 != null && r2 != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("interstitial_pool", bundle);
            hashMap.put("counters", bundle2);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzna com_google_android_gms_internal_zzna, Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("doritos", com_google_android_gms_internal_zzna.zzTh);
        if (((Boolean) zzgd.zzCS.get()).booleanValue()) {
            Object obj = null;
            boolean z = false;
            if (com_google_android_gms_internal_zzna.zzpR != null) {
                obj = com_google_android_gms_internal_zzna.zzpR.getId();
                z = com_google_android_gms_internal_zzna.zzpR.isLimitAdTrackingEnabled();
            }
            if (TextUtils.isEmpty(obj)) {
                bundle.putString("pdid", zzel.zzeT().zzae(context));
                bundle.putString("pdidtype", "ssaid");
            } else {
                bundle.putString("rdid", obj);
                bundle.putBoolean("is_lat", z);
                bundle.putString("idtype", "adid");
            }
        }
        hashMap.put("pii", bundle);
    }

    private static void zza(HashMap<String, Object> hashMap, zzni com_google_android_gms_internal_zzni, zza com_google_android_gms_internal_zznm_zza, Bundle bundle, Bundle bundle2) {
        hashMap.put("am", Integer.valueOf(com_google_android_gms_internal_zzni.zzUE));
        hashMap.put("cog", zzB(com_google_android_gms_internal_zzni.zzUF));
        hashMap.put("coh", zzB(com_google_android_gms_internal_zzni.zzUG));
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzni.zzUH)) {
            hashMap.put("carrier", com_google_android_gms_internal_zzni.zzUH);
        }
        hashMap.put("gl", com_google_android_gms_internal_zzni.zzUI);
        if (com_google_android_gms_internal_zzni.zzUJ) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        if (com_google_android_gms_internal_zzni.zzUK) {
            hashMap.put("is_sidewinder", Integer.valueOf(1));
        }
        hashMap.put("ma", zzB(com_google_android_gms_internal_zzni.zzUL));
        hashMap.put("sp", zzB(com_google_android_gms_internal_zzni.zzUM));
        hashMap.put("hl", com_google_android_gms_internal_zzni.zzUN);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzni.zzUO)) {
            hashMap.put("mv", com_google_android_gms_internal_zzni.zzUO);
        }
        hashMap.put("muv", Integer.valueOf(com_google_android_gms_internal_zzni.zzUP));
        if (com_google_android_gms_internal_zzni.zzUQ != -2) {
            hashMap.put("cnt", Integer.valueOf(com_google_android_gms_internal_zzni.zzUQ));
        }
        hashMap.put("gnt", Integer.valueOf(com_google_android_gms_internal_zzni.zzUR));
        hashMap.put("pt", Integer.valueOf(com_google_android_gms_internal_zzni.zzUS));
        hashMap.put("rm", Integer.valueOf(com_google_android_gms_internal_zzni.zzUT));
        hashMap.put("riv", Integer.valueOf(com_google_android_gms_internal_zzni.zzUU));
        Bundle bundle3 = new Bundle();
        bundle3.putString("build", com_google_android_gms_internal_zzni.zzUZ);
        Bundle bundle4 = new Bundle();
        bundle4.putBoolean("is_charging", com_google_android_gms_internal_zzni.zzUW);
        bundle4.putDouble("battery_level", com_google_android_gms_internal_zzni.zzUV);
        bundle3.putBundle("battery", bundle4);
        bundle4 = new Bundle();
        bundle4.putInt("active_network_state", com_google_android_gms_internal_zzni.zzUY);
        bundle4.putBoolean("active_network_metered", com_google_android_gms_internal_zzni.zzUX);
        if (com_google_android_gms_internal_zznm_zza != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putInt("predicted_latency_micros", com_google_android_gms_internal_zznm_zza.zzVf);
            bundle5.putLong("predicted_down_throughput_bps", com_google_android_gms_internal_zznm_zza.zzVg);
            bundle5.putLong("predicted_up_throughput_bps", com_google_android_gms_internal_zznm_zza.zzVh);
            bundle4.putBundle("predictions", bundle5);
        }
        bundle3.putBundle("network", bundle4);
        bundle4 = new Bundle();
        bundle4.putBoolean("is_browser_custom_tabs_capable", com_google_android_gms_internal_zzni.zzVa);
        bundle3.putBundle("browser", bundle4);
        if (bundle != null) {
            bundle3.putBundle("android_mem_info", zzg(bundle));
        }
        bundle4 = new Bundle();
        bundle4.putBundle("parental_controls", bundle2);
        bundle3.putBundle("play_store", bundle4);
        hashMap.put("device", bundle3);
    }

    private static String zzab(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK & i)});
    }

    public static JSONObject zzb(zzmn com_google_android_gms_internal_zzmn) {
        JSONObject jSONObject = new JSONObject();
        if (com_google_android_gms_internal_zzmn.zzNJ != null) {
            jSONObject.put("ad_base_url", com_google_android_gms_internal_zzmn.zzNJ);
        }
        if (com_google_android_gms_internal_zzmn.zzSq != null) {
            jSONObject.put("ad_size", com_google_android_gms_internal_zzmn.zzSq);
        }
        jSONObject.put("native", com_google_android_gms_internal_zzmn.zzzB);
        if (com_google_android_gms_internal_zzmn.zzzB) {
            jSONObject.put("ad_json", com_google_android_gms_internal_zzmn.body);
        } else {
            jSONObject.put("ad_html", com_google_android_gms_internal_zzmn.body);
        }
        if (com_google_android_gms_internal_zzmn.zzSs != null) {
            jSONObject.put("debug_dialog", com_google_android_gms_internal_zzmn.zzSs);
        }
        if (com_google_android_gms_internal_zzmn.zzSJ != null) {
            jSONObject.put("debug_signals", com_google_android_gms_internal_zzmn.zzSJ);
        }
        if (com_google_android_gms_internal_zzmn.zzSm != -1) {
            jSONObject.put("interstitial_timeout", ((double) com_google_android_gms_internal_zzmn.zzSm) / 1000.0d);
        }
        if (com_google_android_gms_internal_zzmn.orientation == zzw.zzcO().zzkR()) {
            jSONObject.put("orientation", "portrait");
        } else if (com_google_android_gms_internal_zzmn.orientation == zzw.zzcO().zzkQ()) {
            jSONObject.put("orientation", "landscape");
        }
        if (com_google_android_gms_internal_zzmn.zzKF != null) {
            jSONObject.put("click_urls", zzl(com_google_android_gms_internal_zzmn.zzKF));
        }
        if (com_google_android_gms_internal_zzmn.zzKG != null) {
            jSONObject.put("impression_urls", zzl(com_google_android_gms_internal_zzmn.zzKG));
        }
        if (com_google_android_gms_internal_zzmn.zzSp != null) {
            jSONObject.put("manual_impression_urls", zzl(com_google_android_gms_internal_zzmn.zzSp));
        }
        if (com_google_android_gms_internal_zzmn.zzSv != null) {
            jSONObject.put("active_view", com_google_android_gms_internal_zzmn.zzSv);
        }
        jSONObject.put("ad_is_javascript", com_google_android_gms_internal_zzmn.zzSt);
        if (com_google_android_gms_internal_zzmn.zzSu != null) {
            jSONObject.put("ad_passback_url", com_google_android_gms_internal_zzmn.zzSu);
        }
        jSONObject.put("mediation", com_google_android_gms_internal_zzmn.zzSn);
        jSONObject.put("custom_render_allowed", com_google_android_gms_internal_zzmn.zzSw);
        jSONObject.put("content_url_opted_out", com_google_android_gms_internal_zzmn.zzSx);
        jSONObject.put("content_vertical_opted_out", com_google_android_gms_internal_zzmn.zzSK);
        jSONObject.put("prefetch", com_google_android_gms_internal_zzmn.zzSy);
        if (com_google_android_gms_internal_zzmn.zzKL != -1) {
            jSONObject.put("refresh_interval_milliseconds", com_google_android_gms_internal_zzmn.zzKL);
        }
        if (com_google_android_gms_internal_zzmn.zzSo != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", com_google_android_gms_internal_zzmn.zzSo);
        }
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzmn.zzSB)) {
            jSONObject.put("gws_query_id", com_google_android_gms_internal_zzmn.zzSB);
        }
        jSONObject.put("fluid", com_google_android_gms_internal_zzmn.zzzC ? "height" : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        jSONObject.put("native_express", com_google_android_gms_internal_zzmn.zzzD);
        if (com_google_android_gms_internal_zzmn.zzSD != null) {
            jSONObject.put("video_start_urls", zzl(com_google_android_gms_internal_zzmn.zzSD));
        }
        if (com_google_android_gms_internal_zzmn.zzSE != null) {
            jSONObject.put("video_complete_urls", zzl(com_google_android_gms_internal_zzmn.zzSE));
        }
        if (com_google_android_gms_internal_zzmn.zzSC != null) {
            jSONObject.put("rewards", com_google_android_gms_internal_zzmn.zzSC.zzjP());
        }
        jSONObject.put("use_displayed_impression", com_google_android_gms_internal_zzmn.zzSF);
        jSONObject.put("auto_protection_configuration", com_google_android_gms_internal_zzmn.zzSG);
        jSONObject.put("render_in_browser", com_google_android_gms_internal_zzmn.zzKJ);
        return jSONObject;
    }

    private static String zzc(zzhc com_google_android_gms_internal_zzhc) {
        switch (com_google_android_gms_internal_zzhc != null ? com_google_android_gms_internal_zzhc.zzHb : 0) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return "portrait";
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return "landscape";
            default:
                return "any";
        }
    }

    private static Bundle zzg(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("runtime_free", Long.toString(bundle.getLong("runtime_free_memory", -1)));
        bundle2.putString("runtime_max", Long.toString(bundle.getLong("runtime_max_memory", -1)));
        bundle2.putString("runtime_total", Long.toString(bundle.getLong("runtime_total_memory", -1)));
        bundle2.putString("web_view_count", Integer.toString(bundle.getInt("web_view_count", 0)));
        MemoryInfo memoryInfo = (MemoryInfo) bundle.getParcelable("debug_memory_info");
        if (memoryInfo != null) {
            bundle2.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
            bundle2.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
            bundle2.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
            bundle2.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
            bundle2.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
            bundle2.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
            bundle2.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
            bundle2.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
            bundle2.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
        }
        return bundle2;
    }

    @Nullable
    static JSONArray zzl(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }
}
