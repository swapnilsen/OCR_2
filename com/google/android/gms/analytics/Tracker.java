package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsb;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.internal.zztb;
import com.google.android.gms.internal.zztl;
import com.google.android.gms.internal.zztm;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Tracker extends zzsa {
    private final Map<String, String> zzFP;
    private boolean zzacs;
    private final Map<String, String> zzact;
    private final zztb zzacu;
    private final zza zzacv;
    private ExceptionReporter zzacw;
    private zztl zzacx;

    /* renamed from: com.google.android.gms.analytics.Tracker.1 */
    class C09711 implements Runnable {
        final /* synthetic */ String zzacA;
        final /* synthetic */ long zzacB;
        final /* synthetic */ boolean zzacC;
        final /* synthetic */ boolean zzacD;
        final /* synthetic */ String zzacE;
        final /* synthetic */ Tracker zzacF;
        final /* synthetic */ Map zzacy;
        final /* synthetic */ boolean zzacz;

        C09711(Tracker tracker, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
            this.zzacF = tracker;
            this.zzacy = map;
            this.zzacz = z;
            this.zzacA = str;
            this.zzacB = j;
            this.zzacC = z2;
            this.zzacD = z3;
            this.zzacE = str2;
        }

        public void run() {
            boolean z = true;
            if (this.zzacF.zzacv.zzmV()) {
                this.zzacy.put("sc", "start");
            }
            zztm.zzd(this.zzacy, "cid", this.zzacF.zzmu().zzmy());
            String str = (String) this.zzacy.get("sf");
            if (str != null) {
                double zza = zztm.zza(str, 100.0d);
                if (zztm.zza(zza, (String) this.zzacy.get("cid"))) {
                    this.zzacF.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza));
                    return;
                }
            }
            zzrx zzb = this.zzacF.zznY();
            if (this.zzacz) {
                zztm.zzb(this.zzacy, "ate", zzb.zznw());
                zztm.zzc(this.zzacy, "adid", zzb.zznG());
            } else {
                this.zzacy.remove("ate");
                this.zzacy.remove("adid");
            }
            zzrk zzoy = this.zzacF.zznZ().zzoy();
            zztm.zzc(this.zzacy, "an", zzoy.zzmY());
            zztm.zzc(this.zzacy, "av", zzoy.zzmZ());
            zztm.zzc(this.zzacy, "aid", zzoy.zzke());
            zztm.zzc(this.zzacy, "aiid", zzoy.zzna());
            this.zzacy.put("v", "1");
            this.zzacy.put("_v", zzsb.zzadQ);
            zztm.zzc(this.zzacy, "ul", this.zzacF.zzoa().zzpB().getLanguage());
            zztm.zzc(this.zzacy, "sr", this.zzacF.zzoa().zzpC());
            boolean z2 = this.zzacA.equals("transaction") || this.zzacA.equals("item");
            if (z2 || this.zzacF.zzacu.zzpV()) {
                long zzcf = zztm.zzcf((String) this.zzacy.get("ht"));
                if (zzcf == 0) {
                    zzcf = this.zzacB;
                }
                if (this.zzacC) {
                    this.zzacF.zznS().zzc("Dry run enabled. Would have sent hit", new zzsz(this.zzacF, this.zzacy, zzcf, this.zzacD));
                    return;
                }
                String str2 = (String) this.zzacy.get("cid");
                Map hashMap = new HashMap();
                zztm.zza(hashMap, "uid", this.zzacy);
                zztm.zza(hashMap, "an", this.zzacy);
                zztm.zza(hashMap, "aid", this.zzacy);
                zztm.zza(hashMap, "av", this.zzacy);
                zztm.zza(hashMap, "aiid", this.zzacy);
                String str3 = this.zzacE;
                if (TextUtils.isEmpty((CharSequence) this.zzacy.get("adid"))) {
                    z = false;
                }
                this.zzacy.put("_s", String.valueOf(this.zzacF.zzmA().zza(new zzse(0, str2, str3, z, 0, hashMap))));
                this.zzacF.zzmA().zza(new zzsz(this.zzacF, this.zzacy, zzcf, this.zzacD));
                return;
            }
            this.zzacF.zznS().zzg(this.zzacy, "Too many hits sent too quickly, rate limiting invoked");
        }
    }

    private class zza extends zzsa implements zza {
        final /* synthetic */ Tracker zzacF;
        private boolean zzacG;
        private int zzacH;
        private long zzacI;
        private boolean zzacJ;
        private long zzacK;

        protected zza(Tracker tracker, zzsc com_google_android_gms_internal_zzsc) {
            this.zzacF = tracker;
            super(com_google_android_gms_internal_zzsc);
            this.zzacI = -1;
        }

        private void zzmW() {
            if (this.zzacI >= 0 || this.zzacG) {
                zzmu().zza(this.zzacF.zzacv);
            } else {
                zzmu().zzb(this.zzacF.zzacv);
            }
        }

        public void enableAutoActivityTracking(boolean z) {
            this.zzacG = z;
            zzmW();
        }

        public void setSessionTimeout(long j) {
            this.zzacI = j;
            zzmW();
        }

        protected void zzmS() {
        }

        public synchronized boolean zzmV() {
            boolean z;
            z = this.zzacJ;
            this.zzacJ = false;
            return z;
        }

        boolean zzmX() {
            return zznR().elapsedRealtime() >= this.zzacK + Math.max(1000, this.zzacI);
        }

        public void zzo(Activity activity) {
            if (this.zzacH == 0 && zzmX()) {
                this.zzacJ = true;
            }
            this.zzacH++;
            if (this.zzacG) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.zzacF.setCampaignParamsOnNextHit(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                this.zzacF.set("&cd", this.zzacF.zzacx != null ? this.zzacF.zzacx.zzr(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    CharSequence zzq = Tracker.zzq(activity);
                    if (!TextUtils.isEmpty(zzq)) {
                        hashMap.put("&dr", zzq);
                    }
                }
                this.zzacF.send(hashMap);
            }
        }

        public void zzp(Activity activity) {
            this.zzacH--;
            this.zzacH = Math.max(0, this.zzacH);
            if (this.zzacH == 0) {
                this.zzacK = zznR().elapsedRealtime();
            }
        }
    }

    Tracker(zzsc com_google_android_gms_internal_zzsc, String str, zztb com_google_android_gms_internal_zztb) {
        super(com_google_android_gms_internal_zzsc);
        this.zzFP = new HashMap();
        this.zzact = new HashMap();
        if (str != null) {
            this.zzFP.put("&tid", str);
        }
        this.zzFP.put("useSecure", "1");
        this.zzFP.put("&a", Integer.toString(new Random().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        if (com_google_android_gms_internal_zztb == null) {
            this.zzacu = new zztb("tracking", zznR());
        } else {
            this.zzacu = com_google_android_gms_internal_zztb;
        }
        this.zzacv = new zza(this, com_google_android_gms_internal_zzsc);
    }

    private static boolean zza(Entry<String, String> entry) {
        String str = (String) entry.getKey();
        entry.getValue();
        return str.startsWith("&") && str.length() >= 2;
    }

    private static String zzb(Entry<String, String> entry) {
        return !zza((Entry) entry) ? null : ((String) entry.getKey()).substring(1);
    }

    private static void zzb(Map<String, String> map, Map<String, String> map2) {
        zzac.zzw(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String zzb = zzb(entry);
                if (zzb != null) {
                    map2.put(zzb, (String) entry.getValue());
                }
            }
        }
    }

    private static void zzc(Map<String, String> map, Map<String, String> map2) {
        zzac.zzw(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String zzb = zzb(entry);
                if (!(zzb == null || map2.containsKey(zzb))) {
                    map2.put(zzb, (String) entry.getValue());
                }
            }
        }
    }

    private boolean zzmT() {
        return this.zzacw != null;
    }

    static String zzq(Activity activity) {
        zzac.zzw(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        CharSequence stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return !TextUtils.isEmpty(stringExtra) ? stringExtra : null;
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.zzacs = z;
    }

    public void enableAutoActivityTracking(boolean z) {
        this.zzacv.enableAutoActivityTracking(z);
    }

    public void enableExceptionReporting(boolean z) {
        synchronized (this) {
            if (zzmT() == z) {
                return;
            }
            if (z) {
                this.zzacw = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), getContext());
                Thread.setDefaultUncaughtExceptionHandler(this.zzacw);
                zzbP("Uncaught exceptions will be reported to Google Analytics");
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this.zzacw.zzmv());
                zzbP("Uncaught exceptions will not be reported to Google Analytics");
            }
        }
    }

    public String get(String str) {
        zzob();
        return TextUtils.isEmpty(str) ? null : this.zzFP.containsKey(str) ? (String) this.zzFP.get(str) : str.equals("&ul") ? zztm.zza(Locale.getDefault()) : str.equals("&cid") ? zznX().zzoQ() : str.equals("&sr") ? zzoa().zzpC() : str.equals("&aid") ? zznZ().zzoy().zzke() : str.equals("&an") ? zznZ().zzoy().zzmY() : str.equals("&av") ? zznZ().zzoy().zzmZ() : str.equals("&aiid") ? zznZ().zzoy().zzna() : null;
    }

    public void send(Map<String, String> map) {
        long currentTimeMillis = zznR().currentTimeMillis();
        if (zzmu().getAppOptOut()) {
            zzbQ("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean isDryRunEnabled = zzmu().isDryRunEnabled();
        Map hashMap = new HashMap();
        zzb(this.zzFP, hashMap);
        zzb(map, hashMap);
        boolean zzg = zztm.zzg((String) this.zzFP.get("useSecure"), true);
        zzc(this.zzact, hashMap);
        this.zzact.clear();
        String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            zznS().zzg(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zznS().zzg(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean zzmU = zzmU();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt((String) this.zzFP.get("&a")) + 1;
                if (parseInt >= ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                    parseInt = 1;
                }
                this.zzFP.put("&a", Integer.toString(parseInt));
            }
        }
        zznU().zzg(new C09711(this, hashMap, zzmU, str, currentTimeMillis, isDryRunEnabled, zzg, str2));
    }

    public void set(String str, String str2) {
        zzac.zzb((Object) str, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.zzFP.put(str, str2);
        }
    }

    public void setAnonymizeIp(boolean z) {
        set("&aip", zztm.zzX(z));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            CharSequence queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                String str = "http://hostname/?";
                String valueOf = String.valueOf(queryParameter);
                Uri parse = Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                str = parse.getQueryParameter("utm_id");
                if (str != null) {
                    this.zzact.put("&ci", str);
                }
                str = parse.getQueryParameter("anid");
                if (str != null) {
                    this.zzact.put("&anid", str);
                }
                str = parse.getQueryParameter("utm_campaign");
                if (str != null) {
                    this.zzact.put("&cn", str);
                }
                str = parse.getQueryParameter("utm_content");
                if (str != null) {
                    this.zzact.put("&cc", str);
                }
                str = parse.getQueryParameter("utm_medium");
                if (str != null) {
                    this.zzact.put("&cm", str);
                }
                str = parse.getQueryParameter("utm_source");
                if (str != null) {
                    this.zzact.put("&cs", str);
                }
                str = parse.getQueryParameter("utm_term");
                if (str != null) {
                    this.zzact.put("&ck", str);
                }
                str = parse.getQueryParameter("dclid");
                if (str != null) {
                    this.zzact.put("&dclid", str);
                }
                str = parse.getQueryParameter("gclid");
                if (str != null) {
                    this.zzact.put("&gclid", str);
                }
                valueOf = parse.getQueryParameter(Param.ACLID);
                if (valueOf != null) {
                    this.zzact.put("&aclid", valueOf);
                }
            }
        }
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d) {
        set("&sf", Double.toString(d));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setScreenResolution(int i, int i2) {
        if (i >= 0 || i2 >= 0) {
            set("&sr", i + "x" + i2);
        } else {
            zzbS("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long j) {
        this.zzacv.setSessionTimeout(1000 * j);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z) {
        set("useSecure", zztm.zzX(z));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }

    void zza(zztl com_google_android_gms_internal_zztl) {
        zzbP("Loading Tracker config values");
        this.zzacx = com_google_android_gms_internal_zztl;
        if (this.zzacx.zzqs()) {
            String trackingId = this.zzacx.getTrackingId();
            set("&tid", trackingId);
            zza("trackingId loaded", trackingId);
        }
        if (this.zzacx.zzqt()) {
            trackingId = Double.toString(this.zzacx.zzqu());
            set("&sf", trackingId);
            zza("Sample frequency loaded", trackingId);
        }
        if (this.zzacx.zzqv()) {
            int sessionTimeout = this.zzacx.getSessionTimeout();
            setSessionTimeout((long) sessionTimeout);
            zza("Session timeout loaded", Integer.valueOf(sessionTimeout));
        }
        if (this.zzacx.zzqw()) {
            boolean zzqx = this.zzacx.zzqx();
            enableAutoActivityTracking(zzqx);
            zza("Auto activity tracking loaded", Boolean.valueOf(zzqx));
        }
        if (this.zzacx.zzqy()) {
            zzqx = this.zzacx.zzqz();
            if (zzqx) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(zzqx));
        }
        enableExceptionReporting(this.zzacx.zzqA());
    }

    protected void zzmS() {
        this.zzacv.initialize();
        String zzmY = zzmB().zzmY();
        if (zzmY != null) {
            set("&an", zzmY);
        }
        zzmY = zzmB().zzmZ();
        if (zzmY != null) {
            set("&av", zzmY);
        }
    }

    boolean zzmU() {
        return this.zzacs;
    }
}
