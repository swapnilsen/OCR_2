package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.internal.zzpb.zza;

@zzme
@TargetApi(19)
public class zzlt extends zzlr {
    private Object zzQb;
    private PopupWindow zzQc;
    private boolean zzQd;

    zzlt(Context context, zza com_google_android_gms_internal_zzpb_zza, zzqw com_google_android_gms_internal_zzqw, zzlq.zza com_google_android_gms_internal_zzlq_zza) {
        super(context, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzqw, com_google_android_gms_internal_zzlq_zza);
        this.zzQb = new Object();
        this.zzQd = false;
    }

    private void zziR() {
        synchronized (this.zzQb) {
            this.zzQd = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzQc = null;
            }
            if (this.zzQc != null) {
                if (this.zzQc.isShowing()) {
                    this.zzQc.dismiss();
                }
                this.zzQc = null;
            }
        }
    }

    public void cancel() {
        zziR();
        super.cancel();
    }

    protected void zzQ(int i) {
        zziR();
        super.zzQ(i);
    }

    protected void zziQ() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.mContext).isDestroyed()) {
            View frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(this.zzIs.getView(), -1, -1);
            synchronized (this.zzQb) {
                if (this.zzQd) {
                    return;
                }
                this.zzQc = new PopupWindow(frameLayout, 1, 1, false);
                this.zzQc.setOutsideTouchable(true);
                this.zzQc.setClippingEnabled(false);
                zzqf.zzbf("Displaying the 1x1 popup off the screen.");
                try {
                    this.zzQc.showAtLocation(window.getDecorView(), 0, -1, -1);
                } catch (Exception e) {
                    this.zzQc = null;
                }
            }
        }
    }
}
