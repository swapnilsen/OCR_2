package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.zzw;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzme
public final class zznf {
    private int mOrientation;
    private String zzGr;
    private boolean zzLa;
    private final zzmk zzLo;
    private List<String> zzQx;
    private String zzTR;
    private String zzTS;
    private List<String> zzTT;
    private String zzTU;
    private String zzTV;
    private String zzTW;
    private List<String> zzTX;
    private long zzTY;
    private boolean zzTZ;
    private final long zzUa;
    private long zzUb;
    private boolean zzUc;
    private boolean zzUd;
    private boolean zzUe;
    private boolean zzUf;
    private boolean zzUg;
    private String zzUh;
    private boolean zzUi;
    private zzoo zzUj;
    private List<String> zzUk;
    private List<String> zzUl;
    private boolean zzUm;
    private zzmp zzUn;
    private boolean zzUo;
    private String zzUp;
    private List<String> zzUq;
    private boolean zzUr;
    private String zzUs;
    private zzor zzUt;
    private boolean zzUu;

    public zznf(zzmk com_google_android_gms_internal_zzmk, String str) {
        this.zzTY = -1;
        this.zzTZ = false;
        this.zzUa = -1;
        this.zzUb = -1;
        this.mOrientation = -1;
        this.zzUc = false;
        this.zzUd = false;
        this.zzUe = false;
        this.zzUf = true;
        this.zzUg = true;
        this.zzUh = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.zzUi = false;
        this.zzLa = false;
        this.zzUm = false;
        this.zzUo = false;
        this.zzTS = str;
        this.zzLo = com_google_android_gms_internal_zzmk;
    }

    private void zzA(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.zzUe = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void zzB(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.zzUf = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void zzC(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Vertical-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.zzUg = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void zzD(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Gws-Query-Id");
        if (list != null && !list.isEmpty()) {
            this.zzUh = (String) list.get(0);
        }
    }

    private void zzE(Map<String, List<String>> map) {
        String zzc = zzc(map, "X-Afma-Fluid");
        if (zzc != null && zzc.equals("height")) {
            this.zzUi = true;
        }
    }

    private void zzF(Map<String, List<String>> map) {
        this.zzLa = "native_express".equals(zzc(map, "X-Afma-Ad-Format"));
    }

    private void zzG(Map<String, List<String>> map) {
        this.zzUj = zzoo.zzaR(zzc(map, "X-Afma-Rewards"));
    }

    private void zzH(Map<String, List<String>> map) {
        if (this.zzUk == null) {
            this.zzUk = zze(map, "X-Afma-Reward-Video-Start-Urls");
        }
    }

    private void zzI(Map<String, List<String>> map) {
        if (this.zzUl == null) {
            this.zzUl = zze(map, "X-Afma-Reward-Video-Complete-Urls");
        }
    }

    private void zzJ(Map<String, List<String>> map) {
        this.zzUm |= zzf(map, "X-Afma-Use-Displayed-Impression");
    }

    private void zzK(Map<String, List<String>> map) {
        this.zzUo |= zzf(map, "X-Afma-Auto-Collect-Location");
    }

    private void zzL(Map<String, List<String>> map) {
        List zze = zze(map, "X-Afma-Remote-Ping-Urls");
        if (zze != null) {
            this.zzUq = zze;
        }
    }

    private void zzM(Map<String, List<String>> map) {
        Object zzc = zzc(map, "X-Afma-Auto-Protection-Configuration");
        if (zzc == null || TextUtils.isEmpty(zzc)) {
            Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter(FacebookAdapter.KEY_ID, "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.zzTV)) {
                buildUpon.appendQueryParameter("debugDialog", this.zzTV);
            }
            boolean booleanValue = ((Boolean) zzgd.zzBp.get()).booleanValue();
            String[] strArr = new String[1];
            String valueOf = String.valueOf(buildUpon.toString());
            String valueOf2 = String.valueOf("navigationURL");
            strArr[0] = new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append(valueOf).append("&").append(valueOf2).append("={NAVIGATION_URL}").toString();
            this.zzUn = new zzmp(booleanValue, Arrays.asList(strArr));
            return;
        }
        try {
            this.zzUn = zzmp.zzf(new JSONObject(zzc));
        } catch (Throwable e) {
            zzqf.zzc("Error parsing configuration JSON", e);
            this.zzUn = new zzmp();
        }
    }

    private void zzN(Map<String, List<String>> map) {
        this.zzUp = zzc(map, "Set-Cookie");
    }

    private void zzO(Map<String, List<String>> map) {
        Object zzc = zzc(map, "X-Afma-Safe-Browsing");
        if (!TextUtils.isEmpty(zzc)) {
            try {
                this.zzUt = zzor.zzh(new JSONObject(zzc));
            } catch (Throwable e) {
                zzqf.zzc("Error parsing safe browsing header", e);
            }
        }
    }

    private void zzP(Map<String, List<String>> map) {
        Object zzc = zzc(map, "X-Afma-Pool");
        if (!TextUtils.isEmpty(zzc)) {
            try {
                this.zzUu = new JSONObject(zzc).getBoolean("never_pool");
            } catch (Throwable e) {
                zzqf.zzc("Error parsing interstitial pool header", e);
            }
        }
    }

    static String zzc(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static long zzd(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                zzqf.zzbh(new StringBuilder((String.valueOf(str).length() + 36) + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1;
    }

    static List<String> zze(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private boolean zzf(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf((String) list.get(0)).booleanValue()) ? false : true;
    }

    private void zzl(Map<String, List<String>> map) {
        this.zzTR = zzc(map, "X-Afma-Ad-Size");
    }

    private void zzm(Map<String, List<String>> map) {
        this.zzUs = zzc(map, "X-Afma-Ad-Slot-Size");
    }

    private void zzn(Map<String, List<String>> map) {
        List zze = zze(map, "X-Afma-Click-Tracking-Urls");
        if (zze != null) {
            this.zzTT = zze;
        }
    }

    private void zzo(Map<String, List<String>> map) {
        this.zzTU = zzc(map, "X-Afma-Debug-Signals");
    }

    private void zzp(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.zzTV = (String) list.get(0);
        }
    }

    private void zzq(Map<String, List<String>> map) {
        List zze = zze(map, "X-Afma-Tracking-Urls");
        if (zze != null) {
            this.zzTX = zze;
        }
    }

    private void zzr(Map<String, List<String>> map) {
        long zzd = zzd(map, "X-Afma-Interstitial-Timeout");
        if (zzd != -1) {
            this.zzTY = zzd;
        }
    }

    private void zzs(Map<String, List<String>> map) {
        this.zzTW = zzc(map, "X-Afma-ActiveView");
    }

    private void zzt(Map<String, List<String>> map) {
        this.zzUd = "native".equals(zzc(map, "X-Afma-Ad-Format"));
    }

    private void zzu(Map<String, List<String>> map) {
        this.zzUc |= zzf(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void zzv(Map<String, List<String>> map) {
        this.zzTZ |= zzf(map, "X-Afma-Mediation");
    }

    private void zzw(Map<String, List<String>> map) {
        this.zzUr |= zzf(map, "X-Afma-Render-In-Browser");
    }

    private void zzx(Map<String, List<String>> map) {
        List zze = zze(map, "X-Afma-Manual-Tracking-Urls");
        if (zze != null) {
            this.zzQx = zze;
        }
    }

    private void zzy(Map<String, List<String>> map) {
        long zzd = zzd(map, "X-Afma-Refresh-Rate");
        if (zzd != -1) {
            this.zzUb = zzd;
        }
    }

    private void zzz(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = zzw.zzcO().zzkR();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = zzw.zzcO().zzkQ();
            }
        }
    }

    public void zzb(String str, Map<String, List<String>> map, String str2) {
        this.zzGr = str2;
        zzk(map);
    }

    public zzmn zzj(long j) {
        return new zzmn(this.zzLo, this.zzTS, this.zzGr, this.zzTT, this.zzTX, this.zzTY, this.zzTZ, -1, this.zzQx, this.zzUb, this.mOrientation, this.zzTR, j, this.zzTV, this.zzTW, this.zzUc, this.zzUd, this.zzUe, this.zzUf, false, this.zzUh, this.zzUi, this.zzLa, this.zzUj, this.zzUk, this.zzUl, this.zzUm, this.zzUn, this.zzUo, this.zzUp, this.zzUq, this.zzUr, this.zzUs, this.zzUt, this.zzTU, this.zzUg, this.zzUu);
    }

    public void zzk(Map<String, List<String>> map) {
        zzl(map);
        zzm(map);
        zzn(map);
        zzo(map);
        zzp(map);
        zzq(map);
        zzr(map);
        zzv(map);
        zzx(map);
        zzy(map);
        zzz(map);
        zzs(map);
        zzA(map);
        zzu(map);
        zzt(map);
        zzB(map);
        zzC(map);
        zzD(map);
        zzE(map);
        zzF(map);
        zzG(map);
        zzH(map);
        zzI(map);
        zzJ(map);
        zzK(map);
        zzN(map);
        zzM(map);
        zzL(map);
        zzO(map);
        zzw(map);
        zzP(map);
    }
}
