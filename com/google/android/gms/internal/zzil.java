package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzme
public final class zzil implements zzid {
    private final zzf zzIo;
    private final zzkr zzIp;
    private final zzif zzIr;

    public static class zza {
        private final zzqw zzIs;

        public zza(zzqw com_google_android_gms_internal_zzqw) {
            this.zzIs = com_google_android_gms_internal_zzqw;
        }

        public Intent zza(Context context, Map<String, String> map) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = (String) map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.zzIs != null) {
                str = zzw.zzcM().zza(this.zzIs, str);
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent zzf = zzf(parse);
            Intent zzf2 = zzf(build);
            ResolveInfo zza = zza(context, zzf, arrayList);
            if (zza != null) {
                return zza(zzf, zza);
            }
            if (zzf2 != null) {
                ResolveInfo zza2 = zza(context, zzf2);
                if (zza2 != null) {
                    Intent zza3 = zza(zzf, zza2);
                    if (zza(context, zza3) != null) {
                        return zza3;
                    }
                }
            }
            if (arrayList.size() == 0) {
                return zzf;
            }
            if (parseBoolean2 && activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResolveInfo resolveInfo = (ResolveInfo) it.next();
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                return zza(zzf, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? zza(zzf, (ResolveInfo) arrayList.get(0)) : zzf;
        }

        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ResolveInfo resolveInfo;
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, AccessibilityNodeInfoCompat.ACTION_CUT);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT);
            if (!(queryIntentActivities == null || resolveActivity == null)) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }

        public Intent zzf(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public zzil(zzif com_google_android_gms_internal_zzif, zzf com_google_android_gms_ads_internal_zzf, zzkr com_google_android_gms_internal_zzkr) {
        this.zzIr = com_google_android_gms_internal_zzif;
        this.zzIo = com_google_android_gms_ads_internal_zzf;
        this.zzIp = com_google_android_gms_internal_zzkr;
    }

    private static boolean zzd(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zze(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzw.zzcO().zzkR();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzw.zzcO().zzkQ();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzw.zzcO().zzkS();
            }
        }
        return -1;
    }

    private static void zzf(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        Context context = com_google_android_gms_internal_zzqw.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            zzqf.zzbh("Destination url cannot be empty.");
            return;
        }
        try {
            com_google_android_gms_internal_zzqw.zzlv().zza(new zzc(new zza(com_google_android_gms_internal_zzqw).zza(context, (Map) map)));
        } catch (ActivityNotFoundException e) {
            zzqf.zzbh(e.getMessage());
        }
    }

    private void zzr(boolean z) {
        if (this.zzIp != null) {
            this.zzIp.zzs(z);
        }
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        Object zza;
        String str = (String) map.get("a");
        if (str == null) {
            zzqf.zzbh("Action missing from an open GMSG.");
        } else if (this.zzIo == null || this.zzIo.zzcd()) {
            zzqx zzlv = com_google_android_gms_internal_zzqw.zzlv();
            if ("expand".equalsIgnoreCase(str)) {
                if (com_google_android_gms_internal_zzqw.zzlz()) {
                    zzqf.zzbh("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzr(false);
                zzlv.zza(zzd(map), zze(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                zzr(false);
                if (str != null) {
                    zzlv.zza(zzd(map), zze(map), str);
                } else {
                    zzlv.zza(zzd(map), zze(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                r1 = (String) map.get("report_urls");
                if (this.zzIr == null) {
                    return;
                }
                if (r1 == null || r1.isEmpty()) {
                    this.zzIr.zza(str, new ArrayList());
                } else {
                    this.zzIr.zza(str, new ArrayList(Arrays.asList(r1.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                zzr(true);
                zzf(com_google_android_gms_internal_zzqw, map);
            } else {
                Intent parseUri;
                Uri data;
                Uri parse;
                zzr(true);
                str = (String) map.get("intent_url");
                r1 = (String) map.get("u");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        parseUri = Intent.parseUri(str, 0);
                    } catch (Throwable e) {
                        String str2 = "Error parsing the url: ";
                        str = String.valueOf(str);
                        zzqf.zzb(str.length() != 0 ? str2.concat(str) : new String(str2), e);
                    }
                    if (!(parseUri == null || parseUri.getData() == null)) {
                        data = parseUri.getData();
                        str = data.toString();
                        if (!TextUtils.isEmpty(str)) {
                            zza = zzw.zzcM().zza(com_google_android_gms_internal_zzqw, str);
                            try {
                                parse = Uri.parse(zza);
                            } catch (Throwable e2) {
                                String str3 = "Error parsing the uri: ";
                                str = String.valueOf(zza);
                                zzqf.zzb(str.length() != 0 ? str3.concat(str) : new String(str3), e2);
                            }
                            parseUri.setData(parse);
                        }
                        parse = data;
                        parseUri.setData(parse);
                    }
                    if (parseUri != null) {
                        zzlv.zza(new zzc(parseUri));
                    } else {
                        zzlv.zza(new zzc((String) map.get("i"), TextUtils.isEmpty(r1) ? zzw.zzcM().zza(com_google_android_gms_internal_zzqw, r1) : r1, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
                    }
                }
                parseUri = null;
                data = parseUri.getData();
                str = data.toString();
                if (TextUtils.isEmpty(str)) {
                    zza = zzw.zzcM().zza(com_google_android_gms_internal_zzqw, str);
                    parse = Uri.parse(zza);
                    parseUri.setData(parse);
                    if (parseUri != null) {
                        if (TextUtils.isEmpty(r1)) {
                        }
                        zzlv.zza(new zzc((String) map.get("i"), TextUtils.isEmpty(r1) ? zzw.zzcM().zza(com_google_android_gms_internal_zzqw, r1) : r1, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
                    } else {
                        zzlv.zza(new zzc(parseUri));
                    }
                }
                parse = data;
                parseUri.setData(parse);
                if (parseUri != null) {
                    zzlv.zza(new zzc(parseUri));
                } else {
                    if (TextUtils.isEmpty(r1)) {
                    }
                    zzlv.zza(new zzc((String) map.get("i"), TextUtils.isEmpty(r1) ? zzw.zzcM().zza(com_google_android_gms_internal_zzqw, r1) : r1, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
                }
            }
        } else {
            this.zzIo.zzx((String) map.get("u"));
        }
    }
}
