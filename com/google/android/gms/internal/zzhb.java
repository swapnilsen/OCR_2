package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzha.zzb;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import net.nend.android.NendAdIconLayout;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public class zzhb implements zzha {
    private final Context mContext;
    private final zzs zzGJ;
    @Nullable
    private final JSONObject zzGM;
    @Nullable
    private final zzlw zzGN;
    @Nullable
    private final com.google.android.gms.internal.zzha.zza zzGO;
    private final zzaw zzGP;
    boolean zzGQ;
    @Nullable
    private String zzGR;
    private WeakReference<View> zzGS;
    private final Object zzrJ;
    @Nullable
    private zzov zztF;
    @Nullable
    private final zzqh zztt;

    /* renamed from: com.google.android.gms.internal.zzhb.1 */
    class C11921 extends com.google.android.gms.internal.zzlw.zza {
        final /* synthetic */ JSONObject zzGT;

        C11921(zzhb com_google_android_gms_internal_zzhb, JSONObject jSONObject) {
            this.zzGT = jSONObject;
        }

        public void zze(zzjj com_google_android_gms_internal_zzjj) {
            com_google_android_gms_internal_zzjj.zza("google.afma.nativeAds.handleClickGmsg", this.zzGT);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhb.2 */
    class C11932 extends com.google.android.gms.internal.zzlw.zza {
        final /* synthetic */ JSONObject zzGT;

        C11932(zzhb com_google_android_gms_internal_zzhb, JSONObject jSONObject) {
            this.zzGT = jSONObject;
        }

        public void zze(zzjj com_google_android_gms_internal_zzjj) {
            com_google_android_gms_internal_zzjj.zza("google.afma.nativeAds.handleImpressionPing", this.zzGT);
        }
    }

    private static class zza {
        private final WeakReference<zzqw> zzGU;
        private String zzGV;

        /* renamed from: com.google.android.gms.internal.zzhb.zza.1 */
        class C11951 implements zzid {
            final /* synthetic */ zzjj zzGW;
            final /* synthetic */ zza zzGX;

            /* renamed from: com.google.android.gms.internal.zzhb.zza.1.1 */
            class C11941 implements com.google.android.gms.internal.zzqx.zza {
                final /* synthetic */ Map zzGY;
                final /* synthetic */ C11951 zzGZ;

                C11941(C11951 c11951, Map map) {
                    this.zzGZ = c11951;
                    this.zzGY = map;
                }

                public void zza(zzqw com_google_android_gms_internal_zzqw, boolean z) {
                    this.zzGZ.zzGX.zzGV = (String) this.zzGY.get(FacebookAdapter.KEY_ID);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("messageType", "htmlLoaded");
                        jSONObject.put(FacebookAdapter.KEY_ID, this.zzGZ.zzGX.zzGV);
                        this.zzGZ.zzGW.zzb("sendMessageToNativeJs", jSONObject);
                    } catch (Throwable e) {
                        zzqf.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                    }
                }
            }

            C11951(zza com_google_android_gms_internal_zzhb_zza, zzjj com_google_android_gms_internal_zzjj) {
                this.zzGX = com_google_android_gms_internal_zzhb_zza;
                this.zzGW = com_google_android_gms_internal_zzjj;
            }

            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                zzqw com_google_android_gms_internal_zzqw2 = (zzqw) this.zzGX.zzGU.get();
                if (com_google_android_gms_internal_zzqw2 == null) {
                    this.zzGW.zzb("/loadHtml", (zzid) this);
                    return;
                }
                com_google_android_gms_internal_zzqw2.zzlv().zza(new C11941(this, map));
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    com_google_android_gms_internal_zzqw2.loadData(str, "text/html", "UTF-8");
                } else {
                    com_google_android_gms_internal_zzqw2.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzhb.zza.2 */
        class C11962 implements zzid {
            final /* synthetic */ zzjj zzGW;
            final /* synthetic */ zza zzGX;

            C11962(zza com_google_android_gms_internal_zzhb_zza, zzjj com_google_android_gms_internal_zzjj) {
                this.zzGX = com_google_android_gms_internal_zzhb_zza;
                this.zzGW = com_google_android_gms_internal_zzjj;
            }

            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                zzqw com_google_android_gms_internal_zzqw2 = (zzqw) this.zzGX.zzGU.get();
                if (com_google_android_gms_internal_zzqw2 == null) {
                    this.zzGW.zzb("/showOverlay", (zzid) this);
                } else {
                    com_google_android_gms_internal_zzqw2.getView().setVisibility(0);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzhb.zza.3 */
        class C11973 implements zzid {
            final /* synthetic */ zzjj zzGW;
            final /* synthetic */ zza zzGX;

            C11973(zza com_google_android_gms_internal_zzhb_zza, zzjj com_google_android_gms_internal_zzjj) {
                this.zzGX = com_google_android_gms_internal_zzhb_zza;
                this.zzGW = com_google_android_gms_internal_zzjj;
            }

            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                zzqw com_google_android_gms_internal_zzqw2 = (zzqw) this.zzGX.zzGU.get();
                if (com_google_android_gms_internal_zzqw2 == null) {
                    this.zzGW.zzb("/hideOverlay", (zzid) this);
                } else {
                    com_google_android_gms_internal_zzqw2.getView().setVisibility(8);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzhb.zza.4 */
        class C11984 implements zzid {
            final /* synthetic */ zzjj zzGW;
            final /* synthetic */ zza zzGX;

            C11984(zza com_google_android_gms_internal_zzhb_zza, zzjj com_google_android_gms_internal_zzjj) {
                this.zzGX = com_google_android_gms_internal_zzhb_zza;
                this.zzGW = com_google_android_gms_internal_zzjj;
            }

            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : map.keySet()) {
                        jSONObject.put(str, map.get(str));
                    }
                    jSONObject.put(FacebookAdapter.KEY_ID, this.zzGX.zzGV);
                    this.zzGW.zzb("sendMessageToNativeJs", jSONObject);
                } catch (Throwable e) {
                    zzqf.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzhb.zza.5 */
        class C11995 extends com.google.android.gms.internal.zzlw.zza {
            final /* synthetic */ zza zzGX;

            C11995(zza com_google_android_gms_internal_zzhb_zza) {
                this.zzGX = com_google_android_gms_internal_zzhb_zza;
            }

            public void zze(zzjj com_google_android_gms_internal_zzjj) {
                zzqw com_google_android_gms_internal_zzqw = (zzqw) this.zzGX.zzGU.get();
                if (com_google_android_gms_internal_zzqw != null) {
                    com_google_android_gms_internal_zzjj.zza("/loadHtml", this.zzGX.zzf(com_google_android_gms_internal_zzjj));
                    com_google_android_gms_internal_zzjj.zza("/showOverlay", this.zzGX.zzg(com_google_android_gms_internal_zzjj));
                    com_google_android_gms_internal_zzjj.zza("/hideOverlay", this.zzGX.zzh(com_google_android_gms_internal_zzjj));
                    com_google_android_gms_internal_zzqw.zzlv().zza("/sendMessageToSdk", this.zzGX.zzi(com_google_android_gms_internal_zzjj));
                }
            }
        }

        public zza(zzqw com_google_android_gms_internal_zzqw) {
            this.zzGU = new WeakReference(com_google_android_gms_internal_zzqw);
        }

        private zzid zzf(zzjj com_google_android_gms_internal_zzjj) {
            return new C11951(this, com_google_android_gms_internal_zzjj);
        }

        private zzid zzg(zzjj com_google_android_gms_internal_zzjj) {
            return new C11962(this, com_google_android_gms_internal_zzjj);
        }

        private zzid zzh(zzjj com_google_android_gms_internal_zzjj) {
            return new C11973(this, com_google_android_gms_internal_zzjj);
        }

        private zzid zzi(zzjj com_google_android_gms_internal_zzjj) {
            return new C11984(this, com_google_android_gms_internal_zzjj);
        }

        public com.google.android.gms.internal.zzlw.zza zzgh() {
            return new C11995(this);
        }
    }

    public zzhb(Context context, zzs com_google_android_gms_ads_internal_zzs, @Nullable zzlw com_google_android_gms_internal_zzlw, zzaw com_google_android_gms_internal_zzaw, @Nullable JSONObject jSONObject, @Nullable com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza, @Nullable zzqh com_google_android_gms_internal_zzqh, @Nullable String str) {
        this.zzrJ = new Object();
        this.zzGS = null;
        this.mContext = context;
        this.zzGJ = com_google_android_gms_ads_internal_zzs;
        this.zzGN = com_google_android_gms_internal_zzlw;
        this.zzGP = com_google_android_gms_internal_zzaw;
        this.zzGM = jSONObject;
        this.zzGO = com_google_android_gms_internal_zzha_zza;
        this.zztt = com_google_android_gms_internal_zzqh;
        this.zzGR = str;
    }

    private JSONObject zza(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        try {
            int[] zzk = zzk(view);
            for (Entry entry : map.entrySet()) {
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] zzk2 = zzk(view2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("width", zzC(zzl(view2)));
                    jSONObject2.put("height", zzC(zzm(view2)));
                    jSONObject2.put("x", zzC(zzk2[0] - zzk[0]));
                    jSONObject2.put("y", zzC(zzk2[1] - zzk[1]));
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                }
            }
        } catch (JSONException e) {
            zzqf.zzbh("Unable to get all view rectangles");
        }
        return jSONObject;
    }

    private JSONObject zzb(Rect rect) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", zzC(rect.left));
        jSONObject.put("y", zzC(rect.top));
        jSONObject.put("width", zzC(rect.right - rect.left));
        jSONObject.put("height", zzC(rect.bottom - rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private JSONObject zzb(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        int[] zzk = zzk(view);
        for (Entry entry : map.entrySet()) {
            View view2 = (View) ((WeakReference) entry.getValue()).get();
            if (view2 != null) {
                int[] zzk2 = zzk(view2);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    Object zzb;
                    jSONObject3.put("width", zzC(zzl(view2)));
                    jSONObject3.put("height", zzC(zzm(view2)));
                    jSONObject3.put("x", zzC(zzk2[0] - zzk[0]));
                    jSONObject3.put("y", zzC(zzk2[1] - zzk[1]));
                    jSONObject3.put("relative_to", "ad_view");
                    jSONObject2.put("frame", jSONObject3);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        zzb = zzb(rect);
                    } else {
                        zzb = new JSONObject();
                        zzb.put("x", zzC(zzk2[0] - zzk[0]));
                        zzb.put("y", zzC(zzk2[1] - zzk[1]));
                        zzb.put("width", 0);
                        zzb.put("height", 0);
                        zzb.put("relative_to", "ad_view");
                    }
                    jSONObject2.put("visible_bounds", zzb);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject2.put("text_color", textView.getCurrentTextColor());
                        jSONObject2.put("font_size", (double) textView.getTextSize());
                        jSONObject2.put("text", textView.getText());
                    }
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                } catch (JSONException e) {
                    zzqf.zzbh("Unable to get asset views information");
                }
            }
        }
        return jSONObject;
    }

    private JSONObject zzn(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                jSONObject.put("width", zzC(zzl(view)));
                jSONObject.put("height", zzC(zzm(view)));
            } catch (Exception e) {
                zzqf.zzbh("Unable to get native ad view bounding box");
            }
        }
        return jSONObject;
    }

    private JSONObject zzo(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                Object zzb;
                int[] zzk = zzk(view);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", zzC(zzl(view)));
                jSONObject2.put("height", zzC(zzm(view)));
                jSONObject2.put("x", zzC(zzk[0]));
                jSONObject2.put("y", zzC(zzk[1]));
                jSONObject2.put("relative_to", "window");
                jSONObject.put("frame", jSONObject2);
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    zzb = zzb(rect);
                } else {
                    zzb = new JSONObject();
                    zzb.put("x", zzC(zzk[0]));
                    zzb.put("y", zzC(zzk[1]));
                    zzb.put("width", 0);
                    zzb.put("height", 0);
                    zzb.put("relative_to", "window");
                }
                jSONObject.put("visible_bounds", zzb);
            } catch (Exception e) {
                zzqf.zzbh("Unable to get native ad view bounding box");
            }
        }
        return jSONObject;
    }

    public Context getContext() {
        return this.mContext;
    }

    int zzC(int i) {
        return zzel.zzeT().zzc(this.mContext, i);
    }

    @Nullable
    public View zza(OnClickListener onClickListener, boolean z) {
        zzgs zzfT = this.zzGO.zzfT();
        if (zzfT == null) {
            return null;
        }
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (!z) {
            switch (zzfT.zzfN()) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
        }
        View com_google_android_gms_internal_zzgt = new zzgt(this.mContext, zzfT, layoutParams);
        com_google_android_gms_internal_zzgt.setOnClickListener(onClickListener);
        com_google_android_gms_internal_zzgt.setContentDescription((CharSequence) zzgd.zzEu.get());
        return com_google_android_gms_internal_zzgt;
    }

    public void zza(View view, zzgy com_google_android_gms_internal_zzgy) {
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View zzfU = this.zzGO.zzfU();
        if (zzfU != null) {
            ViewParent parent = zzfU.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(zzfU);
            }
            ((FrameLayout) view).addView(zzfU, layoutParams);
            this.zzGJ.zza(com_google_android_gms_internal_zzgy);
        } else if (this.zzGO instanceof zzb) {
            zzb com_google_android_gms_internal_zzha_zzb = (zzb) this.zzGO;
            if (com_google_android_gms_internal_zzha_zzb.getImages() != null && com_google_android_gms_internal_zzha_zzb.getImages().size() > 0) {
                zzhf zze = zze(com_google_android_gms_internal_zzha_zzb.getImages().get(0));
                if (zze != null) {
                    try {
                        IObjectWrapper zzfP = zze.zzfP();
                        if (zzfP != null) {
                            Drawable drawable = (Drawable) zzd.zzF(zzfP);
                            zzfU = zzgf();
                            zzfU.setImageDrawable(drawable);
                            zzfU.setScaleType(ScaleType.CENTER_INSIDE);
                            ((FrameLayout) view).addView(zzfU, layoutParams);
                        }
                    } catch (RemoteException e) {
                        zzqf.zzbh("Could not get drawable from image");
                    }
                }
            }
        }
    }

    public void zza(View view, String str, @Nullable JSONObject jSONObject, Map<String, WeakReference<View>> map, View view2) {
        zzac.zzdj("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("asset", str);
            jSONObject2.put("template", this.zzGO.zzfS());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad", this.zzGM);
            jSONObject3.put(Promotion.ACTION_CLICK, jSONObject2);
            jSONObject3.put("has_custom_click_handler", this.zzGJ.zzz(this.zzGO.getCustomTemplateId()) != null);
            if (((Boolean) zzgd.zzEw.get()).booleanValue()) {
                if (((Boolean) zzgd.zzEx.get()).booleanValue()) {
                    jSONObject3.put("asset_view_signal", zzb((Map) map, view2));
                    jSONObject3.put("ad_view_signal", zzo(view2));
                } else {
                    jSONObject3.put("view_rectangles", zza((Map) map, view2));
                    jSONObject3.put("native_view_rectangle", zzn(view2));
                }
            }
            if (jSONObject != null) {
                jSONObject3.put("click_point", jSONObject);
            }
            try {
                JSONObject optJSONObject = this.zzGM.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject2.put("click_signals", this.zzGP.zzT().zza(this.mContext, optJSONObject.optString("click_string"), view));
            } catch (Throwable e) {
                zzqf.zzb("Exception obtaining click signals", e);
            }
            jSONObject3.put("ads_id", this.zzGR);
            this.zzGN.zza(new C11921(this, jSONObject3));
        } catch (Throwable e2) {
            zzqf.zzb("Unable to create click JSON.", e2);
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        if (((Boolean) zzgd.zzEr.get()).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            if (map != null) {
                for (Entry value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener(onTouchListener);
                        view2.setClickable(true);
                        view2.setOnClickListener(onClickListener);
                    }
                }
            }
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, View view2) {
        zzac.zzdj("performClick must be called on the main UI thread.");
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    zza(view, (String) entry.getKey(), jSONObject, map, view2);
                    return;
                }
            }
        }
        if ("2".equals(this.zzGO.zzfS())) {
            zza(view, "2099", jSONObject, map, view2);
        } else if ("1".equals(this.zzGO.zzfS())) {
            zza(view, "1099", jSONObject, map, view2);
        }
    }

    public void zzb(View view, Map<String, WeakReference<View>> map) {
        zzac.zzdj("recordImpression must be called on the main UI thread.");
        zzq(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzGM);
            jSONObject.put("ads_id", this.zzGR);
            if (((Boolean) zzgd.zzEw.get()).booleanValue()) {
                if (((Boolean) zzgd.zzEx.get()).booleanValue()) {
                    jSONObject.put("asset_view_signal", zzb((Map) map, view));
                    jSONObject.put("ad_view_signal", zzo(view));
                } else {
                    jSONObject.put("view_rectangles", zza((Map) map, view));
                    jSONObject.put("native_view_rectangle", zzn(view));
                }
            }
            this.zzGN.zza(new C11932(this, jSONObject));
        } catch (Throwable e) {
            zzqf.zzb("Unable to create impression JSON.", e);
        }
        this.zzGJ.zza((zzha) this);
        this.zzGJ.zzbL();
    }

    public void zzc(View view, Map<String, WeakReference<View>> map) {
        if (!((Boolean) zzgd.zzEq.get()).booleanValue()) {
            view.setOnTouchListener(null);
            view.setClickable(false);
            view.setOnClickListener(null);
            if (map != null) {
                for (Entry value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener(null);
                        view2.setClickable(false);
                        view2.setOnClickListener(null);
                    }
                }
            }
        }
    }

    public void zzd(MotionEvent motionEvent) {
        this.zzGP.zza(motionEvent);
    }

    public void zzd(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.zzrJ) {
            if (this.zzGQ) {
            } else if (!view.isShown()) {
            } else if (view.getGlobalVisibleRect(new Rect(), null)) {
                zzb(view, (Map) map);
            }
        }
    }

    @Nullable
    zzhf zze(Object obj) {
        return obj instanceof IBinder ? com.google.android.gms.internal.zzhf.zza.zzB((IBinder) obj) : null;
    }

    public boolean zzfY() {
        zzgs zzfT = this.zzGO.zzfT();
        return zzfT != null && zzfT.zzfO();
    }

    public zzqw zzgb() {
        if (this.zzGM == null || this.zzGM.optJSONObject("overlay") == null) {
            return null;
        }
        zzqw zzge = zzge();
        zzge.getView().setVisibility(8);
        this.zzGN.zza(new zza(zzge).zzgh());
        return zzge;
    }

    public View zzgc() {
        return this.zzGS != null ? (View) this.zzGS.get() : null;
    }

    public void zzgd() {
        this.zzGJ.zzcv();
    }

    zzqw zzge() {
        return zzw.zzcN().zza(this.mContext, zzeg.zzk(this.mContext), false, false, this.zzGP, this.zztt);
    }

    ImageView zzgf() {
        return new ImageView(this.mContext);
    }

    @Nullable
    public zzov zzgg() {
        if (!zzw.zzdl().zzjS()) {
            return null;
        }
        if (this.zztF == null) {
            this.zztF = new zzov(this.mContext, this.zzGJ.getAdUnitId());
        }
        return this.zztF;
    }

    public void zzj(View view) {
        this.zzGS = new WeakReference(view);
    }

    int[] zzk(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    int zzl(View view) {
        return view.getMeasuredWidth();
    }

    int zzm(View view) {
        return view.getMeasuredHeight();
    }

    protected void zzq(boolean z) {
        this.zzGQ = z;
    }
}
