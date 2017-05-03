package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzme;

@zzme
public class zzp extends FrameLayout implements OnClickListener {
    private final ImageButton zzOi;
    private final zzv zzOj;

    static class zza {
        public int paddingBottom;
        public int paddingLeft;
        public int paddingRight;
        public int paddingTop;
        public int size;

        zza() {
            this.paddingLeft = 0;
            this.paddingRight = 0;
            this.paddingTop = 0;
            this.paddingBottom = 0;
            this.size = 32;
        }
    }

    public zzp(Context context, zza com_google_android_gms_ads_internal_overlay_zzp_zza, zzv com_google_android_gms_ads_internal_overlay_zzv) {
        super(context);
        this.zzOj = com_google_android_gms_ads_internal_overlay_zzv;
        setOnClickListener(this);
        this.zzOi = new ImageButton(context);
        this.zzOi.setImageResource(17301527);
        this.zzOi.setBackgroundColor(0);
        this.zzOi.setOnClickListener(this);
        this.zzOi.setPadding(zzel.zzeT().zzb(context, com_google_android_gms_ads_internal_overlay_zzp_zza.paddingLeft), zzel.zzeT().zzb(context, 0), zzel.zzeT().zzb(context, com_google_android_gms_ads_internal_overlay_zzp_zza.paddingRight), zzel.zzeT().zzb(context, com_google_android_gms_ads_internal_overlay_zzp_zza.paddingBottom));
        this.zzOi.setContentDescription("Interstitial close button");
        zzel.zzeT().zzb(context, com_google_android_gms_ads_internal_overlay_zzp_zza.size);
        addView(this.zzOi, new LayoutParams(zzel.zzeT().zzb(context, (com_google_android_gms_ads_internal_overlay_zzp_zza.size + com_google_android_gms_ads_internal_overlay_zzp_zza.paddingLeft) + com_google_android_gms_ads_internal_overlay_zzp_zza.paddingRight), zzel.zzeT().zzb(context, (com_google_android_gms_ads_internal_overlay_zzp_zza.size + 0) + com_google_android_gms_ads_internal_overlay_zzp_zza.paddingBottom), 17));
    }

    public void onClick(View view) {
        if (this.zzOj != null) {
            this.zzOj.zzhE();
        }
    }

    public void zza(boolean z, boolean z2) {
        if (!z2) {
            this.zzOi.setVisibility(0);
        } else if (z) {
            this.zzOi.setVisibility(4);
        } else {
            this.zzOi.setVisibility(8);
        }
    }
}
