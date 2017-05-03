package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public final class zzic {
    public static final zzid zzHD;
    public static final zzid zzHE;
    public static final zzid zzHF;
    public static final zzid zzHG;
    public static final zzid zzHH;
    public static final zzid zzHI;
    public static final zzid zzHJ;
    public static final zzid zzHK;
    public static final zzid zzHL;
    public static final zzid zzHM;
    public static final zzid zzHN;
    public static final zzid zzHO;
    public static final zzid zzHP;
    public static final zzid zzHQ;
    public static final zzid zzHR;
    public static final zzid zzHS;
    public static final zzid zzHT;
    public static final zzid zzHU;
    public static final zzim zzHV;
    public static final zzid zzHW;
    public static final zzid zzHX;
    public static final zzid zzHY;

    /* renamed from: com.google.android.gms.internal.zzic.1 */
    class C12021 implements zzid {
        C12021() {
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzic.2 */
    class C12032 implements zzid {
        C12032() {
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            zzgy zzlL = com_google_android_gms_internal_zzqw.zzlL();
            if (zzlL != null) {
                zzlL.zzfX();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzic.3 */
    class C12043 implements zzid {
        C12043() {
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                zzaw zzlx = com_google_android_gms_internal_zzqw.zzlx();
                if (zzlx != null) {
                    zzlx.zzT().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzqf.zzbh("Could not parse touch parameters from gmsg.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzic.4 */
    class C12054 implements zzid {
        C12054() {
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            if (((Boolean) zzgd.zzDD.get()).booleanValue()) {
                com_google_android_gms_internal_zzqw.zzM(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzic.5 */
    class C12065 implements zzid {
        C12065() {
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            String str = (String) map.get("action");
            if ("pause".equals(str)) {
                com_google_android_gms_internal_zzqw.zzbV();
            } else if ("resume".equals(str)) {
                com_google_android_gms_internal_zzqw.zzbW();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzic.6 */
    class C12076 implements zzid {
        C12076() {
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                com_google_android_gms_internal_zzqw.zzlv().zzlU();
            } else if (map.keySet().contains("stop")) {
                com_google_android_gms_internal_zzqw.zzlv().zzlV();
            } else if (map.keySet().contains("cancel")) {
                com_google_android_gms_internal_zzqw.zzlv().zzlW();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzic.7 */
    class C12087 implements zzid {
        C12087() {
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                com_google_android_gms_internal_zzqw.zzN(true);
            }
            if (map.keySet().contains("stop")) {
                com_google_android_gms_internal_zzqw.zzN(false);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzic.8 */
    class C12098 implements zzid {
        C12098() {
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            com_google_android_gms_internal_zzqw.zza("locationReady", zzw.zzcM().zza((View) com_google_android_gms_internal_zzqw, (WindowManager) com_google_android_gms_internal_zzqw.getContext().getSystemService("window")));
            zzqf.zzbh("GET LOCATION COMPILED");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzic.9 */
    class C12109 implements zzid {
        C12109() {
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzqf.zzbh("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = com_google_android_gms_internal_zzqw.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), AccessibilityNodeInfoCompat.ACTION_CUT) != null));
            }
            com_google_android_gms_internal_zzqw.zza("openableURLs", hashMap);
        }
    }

    static {
        zzHD = new C12021();
        zzHE = new C12109();
        zzHF = new zzid() {
            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                PackageManager packageManager = com_google_android_gms_internal_zzqw.getContext().getPackageManager();
                try {
                    try {
                        JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                        JSONObject jSONObject = new JSONObject();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                String optString = jSONObject2.optString(FacebookAdapter.KEY_ID);
                                Object optString2 = jSONObject2.optString("u");
                                Object optString3 = jSONObject2.optString("i");
                                Object optString4 = jSONObject2.optString("m");
                                Object optString5 = jSONObject2.optString("p");
                                Object optString6 = jSONObject2.optString("c");
                                jSONObject2.optString("f");
                                jSONObject2.optString("e");
                                Intent intent = new Intent();
                                if (!TextUtils.isEmpty(optString2)) {
                                    intent.setData(Uri.parse(optString2));
                                }
                                if (!TextUtils.isEmpty(optString3)) {
                                    intent.setAction(optString3);
                                }
                                if (!TextUtils.isEmpty(optString4)) {
                                    intent.setType(optString4);
                                }
                                if (!TextUtils.isEmpty(optString5)) {
                                    intent.setPackage(optString5);
                                }
                                if (!TextUtils.isEmpty(optString6)) {
                                    String[] split = optString6.split("/", 2);
                                    if (split.length == 2) {
                                        intent.setComponent(new ComponentName(split[0], split[1]));
                                    }
                                }
                                try {
                                    jSONObject.put(optString, packageManager.resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT) != null);
                                } catch (Throwable e) {
                                    zzqf.zzb("Error constructing openable urls response.", e);
                                }
                            } catch (Throwable e2) {
                                zzqf.zzb("Error parsing the intent data.", e2);
                            }
                        }
                        com_google_android_gms_internal_zzqw.zzb("openableIntents", jSONObject);
                    } catch (JSONException e3) {
                        com_google_android_gms_internal_zzqw.zzb("openableIntents", new JSONObject());
                    }
                } catch (JSONException e4) {
                    com_google_android_gms_internal_zzqw.zzb("openableIntents", new JSONObject());
                }
            }
        };
        zzHG = new zzid() {
            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                String str = (String) map.get("u");
                if (str == null) {
                    zzqf.zzbh("URL missing from click GMSG.");
                    return;
                }
                Uri zza;
                String zzF;
                Uri parse = Uri.parse(str);
                try {
                    zzaw zzlx = com_google_android_gms_internal_zzqw.zzlx();
                    if (zzlx != null && zzlx.zzc(parse)) {
                        zza = zzlx.zza(parse, com_google_android_gms_internal_zzqw.getContext(), com_google_android_gms_internal_zzqw.getView());
                        if (zzw.zzdl().zzjU() && TextUtils.isEmpty(zza.getQueryParameter("fbs_aeid"))) {
                            zzF = zzw.zzdl().zzF(com_google_android_gms_internal_zzqw.getContext());
                            zza = zzw.zzcM().zza(zza, "fbs_aeid", zzF);
                            zzw.zzdl().zzf(com_google_android_gms_internal_zzqw.getContext(), zzF);
                        }
                        new zzpy(com_google_android_gms_internal_zzqw.getContext(), com_google_android_gms_internal_zzqw.zzly().zzba, zza.toString()).zziP();
                    }
                } catch (zzax e) {
                    String str2 = "Unable to append parameter to URL: ";
                    str = String.valueOf(str);
                    zzqf.zzbh(str.length() != 0 ? str2.concat(str) : new String(str2));
                }
                zza = parse;
                zzF = zzw.zzdl().zzF(com_google_android_gms_internal_zzqw.getContext());
                zza = zzw.zzcM().zza(zza, "fbs_aeid", zzF);
                zzw.zzdl().zzf(com_google_android_gms_internal_zzqw.getContext(), zzF);
                new zzpy(com_google_android_gms_internal_zzqw.getContext(), com_google_android_gms_internal_zzqw.zzly().zzba, zza.toString()).zziP();
            }
        };
        zzHH = new zzid() {
            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                zze zzlt = com_google_android_gms_internal_zzqw.zzlt();
                if (zzlt != null) {
                    zzlt.close();
                    return;
                }
                zzlt = com_google_android_gms_internal_zzqw.zzlu();
                if (zzlt != null) {
                    zzlt.close();
                } else {
                    zzqf.zzbh("A GMSG tried to close something that wasn't an overlay.");
                }
            }
        };
        zzHI = new zzid() {
            private void zzd(zzqw com_google_android_gms_internal_zzqw) {
                zzqf.zzbg("Received support message, responding.");
                com.google.android.gms.ads.internal.zze zzby = com_google_android_gms_internal_zzqw.zzby();
                if (!(zzby == null || zzby.zzsO == null)) {
                    com_google_android_gms_internal_zzqw.getContext();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DataLayer.EVENT_KEY, "checkSupport");
                    jSONObject.put("supports", false);
                    com_google_android_gms_internal_zzqw.zzb("appStreaming", jSONObject);
                } catch (Throwable th) {
                    zzw.zzcQ().zza(th, "DefaultGmsgHandlers.processCheckSupportsMessage");
                }
            }

            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                if ("checkSupport".equals(map.get("action"))) {
                    zzd(com_google_android_gms_internal_zzqw);
                    return;
                }
                zze zzlt = com_google_android_gms_internal_zzqw.zzlt();
                if (zzlt != null) {
                    zzlt.zzg(com_google_android_gms_internal_zzqw, map);
                }
            }
        };
        zzHJ = new zzid() {
            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                com_google_android_gms_internal_zzqw.zzL("1".equals(map.get("custom_close")));
            }
        };
        zzHK = new zzid() {
            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                String str = (String) map.get("u");
                if (str == null) {
                    zzqf.zzbh("URL missing from httpTrack GMSG.");
                } else {
                    new zzpy(com_google_android_gms_internal_zzqw.getContext(), com_google_android_gms_internal_zzqw.zzly().zzba, str).zziP();
                }
            }
        };
        zzHL = new zzid() {
            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                String str = "Received log message: ";
                String valueOf = String.valueOf((String) map.get("string"));
                zzqf.zzbg(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        };
        zzHM = new C12032();
        zzHN = new C12043();
        zzHO = new C12054();
        zzHP = new C12065();
        zzHQ = new zzio();
        zzHR = new zzip();
        zzHS = new zzij();
        zzHT = new zzit();
        zzHU = new zzib();
        zzHV = new zzim();
        zzHW = new C12076();
        zzHX = new C12087();
        zzHY = new C12098();
    }
}
