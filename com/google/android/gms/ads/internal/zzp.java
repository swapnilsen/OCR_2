package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzgv;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzhf;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx.zza;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

@zzme
public class zzp {

    /* renamed from: com.google.android.gms.ads.internal.zzp.1 */
    class C09501 implements zza {
        final /* synthetic */ zzgv zztQ;
        final /* synthetic */ String zztR;
        final /* synthetic */ zzqw zztS;

        C09501(zzgv com_google_android_gms_internal_zzgv, String str, zzqw com_google_android_gms_internal_zzqw) {
            this.zztQ = com_google_android_gms_internal_zzgv;
            this.zztR = str;
            this.zztS = com_google_android_gms_internal_zzqw;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.zztQ.getHeadline());
                jSONObject.put("body", this.zztQ.getBody());
                jSONObject.put("call_to_action", this.zztQ.getCallToAction());
                jSONObject.put(Param.PRICE, this.zztQ.getPrice());
                jSONObject.put("star_rating", String.valueOf(this.zztQ.getStarRating()));
                jSONObject.put("store", this.zztQ.getStore());
                jSONObject.put("icon", zzp.zza(this.zztQ.zzfQ()));
                JSONArray jSONArray = new JSONArray();
                List<Object> images = this.zztQ.getImages();
                if (images != null) {
                    for (Object zzf : images) {
                        jSONArray.put(zzp.zza(zzp.zze(zzf)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", zzp.zza(this.zztQ.getExtras(), this.zztR));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", "2");
                this.zztS.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                zzqf.zzc("Exception occurred when loading assets", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzp.2 */
    class C09512 implements zza {
        final /* synthetic */ String zztR;
        final /* synthetic */ zzqw zztS;
        final /* synthetic */ zzgw zztT;

        C09512(zzgw com_google_android_gms_internal_zzgw, String str, zzqw com_google_android_gms_internal_zzqw) {
            this.zztT = com_google_android_gms_internal_zzgw;
            this.zztR = str;
            this.zztS = com_google_android_gms_internal_zzqw;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.zztT.getHeadline());
                jSONObject.put("body", this.zztT.getBody());
                jSONObject.put("call_to_action", this.zztT.getCallToAction());
                jSONObject.put("advertiser", this.zztT.getAdvertiser());
                jSONObject.put("logo", zzp.zza(this.zztT.zzfV()));
                JSONArray jSONArray = new JSONArray();
                List<Object> images = this.zztT.getImages();
                if (images != null) {
                    for (Object zzf : images) {
                        jSONArray.put(zzp.zza(zzp.zze(zzf)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", zzp.zza(this.zztT.getExtras(), this.zztR));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", "1");
                this.zztS.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                zzqf.zzc("Exception occurred when loading assets", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzp.3 */
    class C09523 implements zzid {
        final /* synthetic */ CountDownLatch zzsw;

        C09523(CountDownLatch countDownLatch) {
            this.zzsw = countDownLatch;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            this.zzsw.countDown();
            com_google_android_gms_internal_zzqw.getView().setVisibility(0);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzp.4 */
    class C09534 implements zzid {
        final /* synthetic */ CountDownLatch zzsw;

        C09534(CountDownLatch countDownLatch) {
            this.zzsw = countDownLatch;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            zzqf.zzbh("Adapter returned an ad, but assets substitution failed");
            this.zzsw.countDown();
            com_google_android_gms_internal_zzqw.destroy();
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzp.5 */
    class C09545 implements zzid {
        final /* synthetic */ zzke zztU;
        final /* synthetic */ zzg.zza zztV;
        final /* synthetic */ zzkf zztW;

        C09545(zzke com_google_android_gms_internal_zzke, zzg.zza com_google_android_gms_ads_internal_zzg_zza, zzkf com_google_android_gms_internal_zzkf) {
            this.zztU = com_google_android_gms_internal_zzke;
            this.zztV = com_google_android_gms_ads_internal_zzg_zza;
            this.zztW = com_google_android_gms_internal_zzkf;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            View view = com_google_android_gms_internal_zzqw.getView();
            if (view != null) {
                try {
                    if (this.zztU != null) {
                        if (this.zztU.getOverrideClickHandling()) {
                            zzp.zza(com_google_android_gms_internal_zzqw);
                            return;
                        }
                        this.zztU.zzl(zzd.zzA(view));
                        this.zztV.onClick();
                    } else if (this.zztW == null) {
                    } else {
                        if (this.zztW.getOverrideClickHandling()) {
                            zzp.zza(com_google_android_gms_internal_zzqw);
                            return;
                        }
                        this.zztW.zzl(zzd.zzA(view));
                        this.zztV.onClick();
                    }
                } catch (Throwable e) {
                    zzqf.zzc("Unable to call handleClick on mapper", e);
                }
            }
        }
    }

    private static zzgv zza(zzke com_google_android_gms_internal_zzke) {
        return new zzgv(com_google_android_gms_internal_zzke.getHeadline(), com_google_android_gms_internal_zzke.getImages(), com_google_android_gms_internal_zzke.getBody(), com_google_android_gms_internal_zzke.zzfQ(), com_google_android_gms_internal_zzke.getCallToAction(), com_google_android_gms_internal_zzke.getStarRating(), com_google_android_gms_internal_zzke.getStore(), com_google_android_gms_internal_zzke.getPrice(), null, com_google_android_gms_internal_zzke.getExtras(), null, null);
    }

    private static zzgw zza(zzkf com_google_android_gms_internal_zzkf) {
        return new zzgw(com_google_android_gms_internal_zzkf.getHeadline(), com_google_android_gms_internal_zzkf.getImages(), com_google_android_gms_internal_zzkf.getBody(), com_google_android_gms_internal_zzkf.zzfV(), com_google_android_gms_internal_zzkf.getCallToAction(), com_google_android_gms_internal_zzkf.getAdvertiser(), null, com_google_android_gms_internal_zzkf.getExtras(), null, null);
    }

    static zzid zza(@Nullable zzke com_google_android_gms_internal_zzke, @Nullable zzkf com_google_android_gms_internal_zzkf, zzg.zza com_google_android_gms_ads_internal_zzg_zza) {
        return new C09545(com_google_android_gms_internal_zzke, com_google_android_gms_ads_internal_zzg_zza, com_google_android_gms_internal_zzkf);
    }

    static zzid zza(CountDownLatch countDownLatch) {
        return new C09523(countDownLatch);
    }

    private static String zza(@Nullable Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzqf.zzbh("Bitmap is null. Returning empty string");
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        encodeToString = String.valueOf(encodeToString);
        return encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
    }

    static String zza(@Nullable zzhf com_google_android_gms_internal_zzhf) {
        if (com_google_android_gms_internal_zzhf == null) {
            zzqf.zzbh("Image is null. Returning empty string");
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        try {
            Uri uri = com_google_android_gms_internal_zzhf.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzqf.zzbh("Unable to get image uri. Trying data uri next");
        }
        return zzb(com_google_android_gms_internal_zzhf);
    }

    private static JSONObject zza(@Nullable Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (bundle.containsKey(str2)) {
                if ("image".equals(jSONObject2.getString(str2))) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(str2, zza((Bitmap) obj));
                    } else {
                        zzqf.zzbh("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(str2) instanceof Bitmap) {
                    zzqf.zzbh("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(str2, String.valueOf(bundle.get(str2)));
                }
            }
        }
        return jSONObject;
    }

    public static void zza(@Nullable zzpb com_google_android_gms_internal_zzpb, zzg.zza com_google_android_gms_ads_internal_zzg_zza) {
        zzkf com_google_android_gms_internal_zzkf = null;
        if (com_google_android_gms_internal_zzpb != null && zzh(com_google_android_gms_internal_zzpb)) {
            zzqw com_google_android_gms_internal_zzqw = com_google_android_gms_internal_zzpb.zzNH;
            Object view = com_google_android_gms_internal_zzqw != null ? com_google_android_gms_internal_zzqw.getView() : null;
            if (view == null) {
                zzqf.zzbh("AdWebView is null");
                return;
            }
            try {
                List list = com_google_android_gms_internal_zzpb.zzLi != null ? com_google_android_gms_internal_zzpb.zzLi.zzKB : null;
                if (list == null || list.isEmpty()) {
                    zzqf.zzbh("No template ids present in mediation response");
                    return;
                }
                zzke zzhc = com_google_android_gms_internal_zzpb.zzLj != null ? com_google_android_gms_internal_zzpb.zzLj.zzhc() : null;
                if (com_google_android_gms_internal_zzpb.zzLj != null) {
                    com_google_android_gms_internal_zzkf = com_google_android_gms_internal_zzpb.zzLj.zzhd();
                }
                if (list.contains("2") && zzhc != null) {
                    zzhc.zzm(zzd.zzA(view));
                    if (!zzhc.getOverrideImpressionRecording()) {
                        zzhc.recordImpression();
                    }
                    com_google_android_gms_internal_zzqw.zzlv().zza("/nativeExpressViewClicked", zza(zzhc, null, com_google_android_gms_ads_internal_zzg_zza));
                } else if (!list.contains("1") || com_google_android_gms_internal_zzkf == null) {
                    zzqf.zzbh("No matching template id and mapper");
                } else {
                    com_google_android_gms_internal_zzkf.zzm(zzd.zzA(view));
                    if (!com_google_android_gms_internal_zzkf.getOverrideImpressionRecording()) {
                        com_google_android_gms_internal_zzkf.recordImpression();
                    }
                    com_google_android_gms_internal_zzqw.zzlv().zza("/nativeExpressViewClicked", zza(null, com_google_android_gms_internal_zzkf, com_google_android_gms_ads_internal_zzg_zza));
                }
            } catch (Throwable e) {
                zzqf.zzc("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    private static void zza(zzqw com_google_android_gms_internal_zzqw) {
        OnClickListener zzlK = com_google_android_gms_internal_zzqw.zzlK();
        if (zzlK != null) {
            zzlK.onClick(com_google_android_gms_internal_zzqw.getView());
        }
    }

    private static void zza(zzqw com_google_android_gms_internal_zzqw, zzgv com_google_android_gms_internal_zzgv, String str) {
        com_google_android_gms_internal_zzqw.zzlv().zza(new C09501(com_google_android_gms_internal_zzgv, str, com_google_android_gms_internal_zzqw));
    }

    private static void zza(zzqw com_google_android_gms_internal_zzqw, zzgw com_google_android_gms_internal_zzgw, String str) {
        com_google_android_gms_internal_zzqw.zzlv().zza(new C09512(com_google_android_gms_internal_zzgw, str, com_google_android_gms_internal_zzqw));
    }

    private static void zza(zzqw com_google_android_gms_internal_zzqw, CountDownLatch countDownLatch) {
        com_google_android_gms_internal_zzqw.zzlv().zza("/nativeExpressAssetsLoaded", zza(countDownLatch));
        com_google_android_gms_internal_zzqw.zzlv().zza("/nativeExpressAssetsLoadingFailed", zzb(countDownLatch));
    }

    public static boolean zza(zzqw com_google_android_gms_internal_zzqw, zzjv com_google_android_gms_internal_zzjv, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            z = zzb(com_google_android_gms_internal_zzqw, com_google_android_gms_internal_zzjv, countDownLatch);
        } catch (Throwable e) {
            zzqf.zzc("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    static zzid zzb(CountDownLatch countDownLatch) {
        return new C09534(countDownLatch);
    }

    private static String zzb(zzhf com_google_android_gms_internal_zzhf) {
        try {
            IObjectWrapper zzfP = com_google_android_gms_internal_zzhf.zzfP();
            if (zzfP == null) {
                zzqf.zzbh("Drawable is null. Returning empty string");
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            }
            Drawable drawable = (Drawable) zzd.zzF(zzfP);
            if (drawable instanceof BitmapDrawable) {
                return zza(((BitmapDrawable) drawable).getBitmap());
            }
            zzqf.zzbh("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        } catch (RemoteException e) {
            zzqf.zzbh("Unable to get drawable. Returning empty string");
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
    }

    private static boolean zzb(zzqw com_google_android_gms_internal_zzqw, zzjv com_google_android_gms_internal_zzjv, CountDownLatch countDownLatch) {
        View view = com_google_android_gms_internal_zzqw.getView();
        if (view == null) {
            zzqf.zzbh("AdWebView is null");
            return false;
        }
        view.setVisibility(4);
        List list = com_google_android_gms_internal_zzjv.zzLi.zzKB;
        if (list == null || list.isEmpty()) {
            zzqf.zzbh("No template ids present in mediation response");
            return false;
        }
        zza(com_google_android_gms_internal_zzqw, countDownLatch);
        zzke zzhc = com_google_android_gms_internal_zzjv.zzLj.zzhc();
        zzkf zzhd = com_google_android_gms_internal_zzjv.zzLj.zzhd();
        if (list.contains("2") && zzhc != null) {
            zza(com_google_android_gms_internal_zzqw, zza(zzhc), com_google_android_gms_internal_zzjv.zzLi.zzKA);
        } else if (!list.contains("1") || zzhd == null) {
            zzqf.zzbh("No matching template id and mapper");
            return false;
        } else {
            zza(com_google_android_gms_internal_zzqw, zza(zzhd), com_google_android_gms_internal_zzjv.zzLi.zzKA);
        }
        String str = com_google_android_gms_internal_zzjv.zzLi.zzKy;
        String str2 = com_google_android_gms_internal_zzjv.zzLi.zzKz;
        if (str2 != null) {
            com_google_android_gms_internal_zzqw.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        } else {
            com_google_android_gms_internal_zzqw.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    @Nullable
    private static zzhf zze(Object obj) {
        return obj instanceof IBinder ? zzhf.zza.zzB((IBinder) obj) : null;
    }

    @Nullable
    public static View zzg(@Nullable zzpb com_google_android_gms_internal_zzpb) {
        if (com_google_android_gms_internal_zzpb == null) {
            zzqf.m4708e("AdState is null");
            return null;
        } else if (zzh(com_google_android_gms_internal_zzpb) && com_google_android_gms_internal_zzpb.zzNH != null) {
            return com_google_android_gms_internal_zzpb.zzNH.getView();
        } else {
            try {
                IObjectWrapper view = com_google_android_gms_internal_zzpb.zzLj != null ? com_google_android_gms_internal_zzpb.zzLj.getView() : null;
                if (view != null) {
                    return (View) zzd.zzF(view);
                }
                zzqf.zzbh("View in mediation adapter is null.");
                return null;
            } catch (Throwable e) {
                zzqf.zzc("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzh(@Nullable zzpb com_google_android_gms_internal_zzpb) {
        return (com_google_android_gms_internal_zzpb == null || !com_google_android_gms_internal_zzpb.zzSn || com_google_android_gms_internal_zzpb.zzLi == null || com_google_android_gms_internal_zzpb.zzLi.zzKy == null) ? false : true;
    }
}
