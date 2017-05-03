package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardItem;

@zzme
public class zznx implements RewardItem {
    private final zznt zzVp;

    public zznx(zznt com_google_android_gms_internal_zznt) {
        this.zzVp = com_google_android_gms_internal_zznt;
    }

    public int getAmount() {
        int i = 0;
        if (this.zzVp != null) {
            try {
                i = this.zzVp.getAmount();
            } catch (Throwable e) {
                zzqf.zzc("Could not forward getAmount to RewardItem", e);
            }
        }
        return i;
    }

    public String getType() {
        String str = null;
        if (this.zzVp != null) {
            try {
                str = this.zzVp.getType();
            } catch (Throwable e) {
                zzqf.zzc("Could not forward getType to RewardItem", e);
            }
        }
        return str;
    }
}
