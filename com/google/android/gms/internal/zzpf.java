package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzw;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

@zzme
public class zzpf {
    final String zzWD;
    int zzWW;
    long zzWY;
    long zzWZ;
    int zzXa;
    long zzXb;
    int zzXc;
    int zzXd;
    private final Object zzrJ;

    public zzpf(String str) {
        this.zzWY = -1;
        this.zzWZ = -1;
        this.zzXa = -1;
        this.zzWW = -1;
        this.zzXb = 0;
        this.zzrJ = new Object();
        this.zzXc = 0;
        this.zzXd = 0;
        this.zzWD = str;
    }

    public static boolean zzI(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", FacebookAdapter.KEY_STYLE, AbstractSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier == 0) {
            zzqf.zzbg("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzqf.zzbg("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            zzqf.zzbh("Fail to fetch AdActivity theme");
            zzqf.zzbg("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public void zzai(int i) {
        this.zzWW = i;
    }

    public void zzb(zzec com_google_android_gms_internal_zzec, long j) {
        synchronized (this.zzrJ) {
            long zzks = zzw.zzcQ().zzks();
            long currentTimeMillis = zzw.zzcS().currentTimeMillis();
            if (this.zzWZ == -1) {
                if (currentTimeMillis - zzks > ((Long) zzgd.zzCR.get()).longValue()) {
                    zzai(-1);
                } else {
                    zzai(zzw.zzcQ().zzku());
                }
                this.zzWZ = j;
                this.zzWY = this.zzWZ;
            } else {
                this.zzWY = j;
            }
            if (com_google_android_gms_internal_zzec.extras == null || com_google_android_gms_internal_zzec.extras.getInt("gw", 2) != 1) {
                this.zzXa++;
                this.zzWW++;
                if (this.zzWW == 0) {
                    this.zzXb = 0;
                    zzw.zzcQ().zzp(currentTimeMillis);
                } else {
                    this.zzXb = currentTimeMillis - zzw.zzcQ().zzkt();
                }
                return;
            }
        }
    }

    public void zzjV() {
        synchronized (this.zzrJ) {
            this.zzXd++;
        }
    }

    public void zzjW() {
        synchronized (this.zzrJ) {
            this.zzXc++;
        }
    }

    public long zzkE() {
        return this.zzWZ;
    }

    public int zzku() {
        return this.zzWW;
    }

    public Bundle zzo(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzrJ) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzWD);
            bundle.putLong("basets", this.zzWZ);
            bundle.putLong("currts", this.zzWY);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzXa);
            bundle.putInt("preqs_in_session", this.zzWW);
            bundle.putLong("time_in_session", this.zzXb);
            bundle.putInt("pclick", this.zzXc);
            bundle.putInt("pimp", this.zzXd);
            bundle.putBoolean("support_transparent_background", zzI(context));
        }
        return bundle;
    }
}
