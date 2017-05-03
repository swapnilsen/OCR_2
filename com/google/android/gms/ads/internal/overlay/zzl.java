package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.HashMap;
import java.util.Map;

@zzme
public class zzl extends FrameLayout implements zzi {
    private final zzqw zzIs;
    private String zzIx;
    private final FrameLayout zzNT;
    private final zzgl zzNU;
    private final zzaa zzNV;
    private final long zzNW;
    @Nullable
    private zzj zzNX;
    private boolean zzNY;
    private boolean zzNZ;
    private boolean zzOa;
    private boolean zzOb;
    private long zzOc;
    private long zzOd;
    private Bitmap zzOe;
    private ImageView zzOf;
    private boolean zzOg;

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzl.1 */
    class C09211 implements Runnable {
        final /* synthetic */ zzl zzOh;

        C09211(zzl com_google_android_gms_ads_internal_overlay_zzl) {
            this.zzOh = com_google_android_gms_ads_internal_overlay_zzl;
        }

        public void run() {
            this.zzOh.zza("surfaceCreated", new String[0]);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzl.2 */
    class C09222 implements Runnable {
        final /* synthetic */ zzl zzOh;

        C09222(zzl com_google_android_gms_ads_internal_overlay_zzl) {
            this.zzOh = com_google_android_gms_ads_internal_overlay_zzl;
        }

        public void run() {
            this.zzOh.zza("surfaceDestroyed", new String[0]);
        }
    }

    public zzl(Context context, zzqw com_google_android_gms_internal_zzqw, int i, boolean z, zzgl com_google_android_gms_internal_zzgl) {
        super(context);
        this.zzIs = com_google_android_gms_internal_zzqw;
        this.zzNU = com_google_android_gms_internal_zzgl;
        this.zzNT = new FrameLayout(context);
        addView(this.zzNT, new LayoutParams(-1, -1));
        zzc.zzt(com_google_android_gms_internal_zzqw.zzby());
        this.zzNX = com_google_android_gms_internal_zzqw.zzby().zzsN.zza(context, com_google_android_gms_internal_zzqw, i, z, com_google_android_gms_internal_zzgl);
        if (this.zzNX != null) {
            this.zzNT.addView(this.zzNX, new LayoutParams(-1, -1, 17));
            if (((Boolean) zzgd.zzBG.get()).booleanValue()) {
                zzic();
            }
        }
        this.zzOf = new ImageView(context);
        this.zzNW = ((Long) zzgd.zzBK.get()).longValue();
        this.zzOb = ((Boolean) zzgd.zzBI.get()).booleanValue();
        if (this.zzNU != null) {
            this.zzNU.zzh("spinner_used", this.zzOb ? "1" : "0");
        }
        this.zzNV = new zzaa(this);
        if (this.zzNX != null) {
            this.zzNX.zza(this);
        }
        if (this.zzNX == null) {
            zzl("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private void zza(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.zzIs.zza("onVideoEvent", hashMap);
    }

    private void zzh(int i, int i2) {
        if (this.zzOb) {
            int max = Math.max(i / ((Integer) zzgd.zzBJ.get()).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzgd.zzBJ.get()).intValue(), 1);
            if (this.zzOe == null || this.zzOe.getWidth() != max || this.zzOe.getHeight() != max2) {
                this.zzOe = Bitmap.createBitmap(max, max2, Config.ARGB_8888);
                this.zzOg = false;
            }
        }
    }

    public static void zzi(zzqw com_google_android_gms_internal_zzqw) {
        Map hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "no_video_view");
        com_google_android_gms_internal_zzqw.zza("onVideoEvent", hashMap);
    }

    @TargetApi(14)
    private void zzie() {
        if (this.zzOe != null) {
            long elapsedRealtime = zzw.zzcS().elapsedRealtime();
            if (this.zzNX.getBitmap(this.zzOe) != null) {
                this.zzOg = true;
            }
            elapsedRealtime = zzw.zzcS().elapsedRealtime() - elapsedRealtime;
            if (zzpk.zzkI()) {
                zzpk.m4709v("Spinner frame grab took " + elapsedRealtime + "ms");
            }
            if (elapsedRealtime > this.zzNW) {
                zzqf.zzbh("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzOb = false;
                this.zzOe = null;
                if (this.zzNU != null) {
                    this.zzNU.zzh("spinner_jank", Long.toString(elapsedRealtime));
                }
            }
        }
    }

    private void zzif() {
        if (this.zzOg && this.zzOe != null && !zzih()) {
            this.zzOf.setImageBitmap(this.zzOe);
            this.zzOf.invalidate();
            this.zzNT.addView(this.zzOf, new LayoutParams(-1, -1));
            this.zzNT.bringChildToFront(this.zzOf);
        }
    }

    private void zzig() {
        if (zzih()) {
            this.zzNT.removeView(this.zzOf);
        }
    }

    private boolean zzih() {
        return this.zzOf.getParent() != null;
    }

    private void zzii() {
        if (this.zzIs.zzlr() != null && !this.zzNZ) {
            this.zzOa = (this.zzIs.zzlr().getWindow().getAttributes().flags & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0;
            if (!this.zzOa) {
                this.zzIs.zzlr().getWindow().addFlags(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                this.zzNZ = true;
            }
        }
    }

    private void zzij() {
        if (this.zzIs.zzlr() != null && this.zzNZ && !this.zzOa) {
            this.zzIs.zzlr().getWindow().clearFlags(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            this.zzNZ = false;
        }
    }

    public void destroy() {
        this.zzNV.pause();
        if (this.zzNX != null) {
            this.zzNX.stop();
        }
        zzij();
    }

    public void onPaused() {
        zza("pause", new String[0]);
        zzij();
        this.zzNY = false;
    }

    public void pause() {
        if (this.zzNX != null) {
            this.zzNX.pause();
        }
    }

    public void play() {
        if (this.zzNX != null) {
            this.zzNX.play();
        }
    }

    public void seekTo(int i) {
        if (this.zzNX != null) {
            this.zzNX.seekTo(i);
        }
    }

    public void zza(float f, float f2) {
        if (this.zzNX != null) {
            this.zzNX.zza(f, f2);
        }
    }

    public void zzaC(String str) {
        this.zzIx = str;
    }

    public void zzb(float f) {
        if (this.zzNX != null) {
            this.zzNX.zzb(f);
        }
    }

    public void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzNT.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    @TargetApi(14)
    public void zzf(MotionEvent motionEvent) {
        if (this.zzNX != null) {
            this.zzNX.dispatchTouchEvent(motionEvent);
        }
    }

    public void zzg(int i, int i2) {
        zzh(i, i2);
    }

    public void zzhT() {
        this.zzNV.resume();
        zzpo.zzXC.post(new C09211(this));
    }

    public void zzhU() {
        if (this.zzNX != null && this.zzOd == 0) {
            float duration = ((float) this.zzNX.getDuration()) / 1000.0f;
            int videoWidth = this.zzNX.getVideoWidth();
            int videoHeight = this.zzNX.getVideoHeight();
            zza("canplaythrough", "duration", String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    public void zzhV() {
        zzii();
        this.zzNY = true;
    }

    public void zzhW() {
        zza("ended", new String[0]);
        zzij();
    }

    public void zzhX() {
        zzif();
        this.zzNV.pause();
        this.zzOd = this.zzOc;
        zzpo.zzXC.post(new C09222(this));
    }

    public void zzhY() {
        if (this.zzNY) {
            zzig();
        }
        zzie();
    }

    public void zzhZ() {
        if (this.zzNX != null) {
            this.zzNX.zzhZ();
        }
    }

    public void zzia() {
        if (this.zzNX != null) {
            this.zzNX.zzia();
        }
    }

    public void zzib() {
        if (this.zzNX != null) {
            if (TextUtils.isEmpty(this.zzIx)) {
                zza("no_src", new String[0]);
            } else {
                this.zzNX.setVideoPath(this.zzIx);
            }
        }
    }

    @TargetApi(14)
    public void zzic() {
        if (this.zzNX != null) {
            View textView = new TextView(this.zzNX.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.zzNX.zzhy());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzNT.addView(textView, new LayoutParams(-2, -2, 17));
            this.zzNT.bringChildToFront(textView);
        }
    }

    void zzid() {
        if (this.zzNX != null) {
            long currentPosition = (long) this.zzNX.getCurrentPosition();
            if (this.zzOc != currentPosition && currentPosition > 0) {
                float f = ((float) currentPosition) / 1000.0f;
                zza("timeupdate", "time", String.valueOf(f));
                this.zzOc = currentPosition;
            }
        }
    }

    public void zzl(String str, @Nullable String str2) {
        zza("error", "what", str, "extra", str2);
    }
}
