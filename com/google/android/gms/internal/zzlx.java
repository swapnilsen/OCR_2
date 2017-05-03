package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.appcompat.C0268R;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public class zzlx implements Callable<zzpb> {
    static long zzQl;
    private final Context mContext;
    private final zzlw zzGN;
    private final zzaw zzGP;
    private final com.google.android.gms.internal.zzpb.zza zzPR;
    private int zzPY;
    private final zzpv zzQu;
    private final zzs zzQv;
    private boolean zzQw;
    private List<String> zzQx;
    private JSONObject zzQy;
    private String zzQz;
    private final Object zzrJ;
    private final zzgl zzsn;

    /* renamed from: com.google.android.gms.internal.zzlx.1 */
    class C13011 extends com.google.android.gms.internal.zzlw.zza {
        final /* synthetic */ String zzQA;
        final /* synthetic */ zzb zzQB;
        final /* synthetic */ zzqj zzQC;
        final /* synthetic */ zzlx zzQD;

        /* renamed from: com.google.android.gms.internal.zzlx.1.1 */
        class C13001 implements zzid {
            final /* synthetic */ zzjj zzGW;
            final /* synthetic */ C13011 zzQE;

            C13001(C13011 c13011, zzjj com_google_android_gms_internal_zzjj) {
                this.zzQE = c13011;
                this.zzGW = com_google_android_gms_internal_zzjj;
            }

            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                try {
                    JSONObject jSONObject;
                    int i;
                    String str = (String) map.get("success");
                    String str2 = (String) map.get("failure");
                    if (TextUtils.isEmpty(str2)) {
                        jSONObject = new JSONObject(str);
                        i = 1;
                    } else {
                        jSONObject = new JSONObject(str2);
                        i = 0;
                    }
                    if (this.zzQE.zzQA.equals(jSONObject.optString("ads_id", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                        this.zzGW.zzb("/nativeAdPreProcess", this.zzQE.zzQB.zzQU);
                        if (i != 0) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("ads");
                            if (optJSONArray == null || optJSONArray.length() <= 0) {
                                this.zzQE.zzQD.zzU(3);
                                this.zzQE.zzQC.zzh(null);
                                return;
                            }
                            this.zzQE.zzQC.zzh(optJSONArray.getJSONObject(0));
                            return;
                        }
                        this.zzQE.zzQD.zzU(0);
                        zzac.zza(this.zzQE.zzQD.zzjf(), (Object) "Unable to set the ad state error!");
                        this.zzQE.zzQC.zzh(null);
                    }
                } catch (Throwable e) {
                    zzqf.zzb("Malformed native JSON response.", e);
                }
            }
        }

        C13011(zzlx com_google_android_gms_internal_zzlx, String str, zzb com_google_android_gms_internal_zzlx_zzb, zzqj com_google_android_gms_internal_zzqj) {
            this.zzQD = com_google_android_gms_internal_zzlx;
            this.zzQA = str;
            this.zzQB = com_google_android_gms_internal_zzlx_zzb;
            this.zzQC = com_google_android_gms_internal_zzqj;
        }

        public void zze(zzjj com_google_android_gms_internal_zzjj) {
            zzid c13001 = new C13001(this, com_google_android_gms_internal_zzjj);
            this.zzQB.zzQU = c13001;
            com_google_android_gms_internal_zzjj.zza("/nativeAdPreProcess", c13001);
            try {
                JSONObject jSONObject = new JSONObject(this.zzQD.zzPR.zzWm.body);
                jSONObject.put("ads_id", this.zzQA);
                com_google_android_gms_internal_zzjj.zza("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
            } catch (Throwable e) {
                zzqf.zzc("Exception occurred while invoking javascript", e);
                this.zzQC.zzh(null);
            }
        }

        public void zzjd() {
            this.zzQC.zzh(null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlx.2 */
    class C13022 implements Runnable {
        final /* synthetic */ zzlx zzQD;
        final /* synthetic */ zzqj zzQF;
        final /* synthetic */ String zzQG;

        C13022(zzlx com_google_android_gms_internal_zzlx, zzqj com_google_android_gms_internal_zzqj, String str) {
            this.zzQD = com_google_android_gms_internal_zzlx;
            this.zzQF = com_google_android_gms_internal_zzqj;
            this.zzQG = str;
        }

        public void run() {
            this.zzQF.zzh((zzhs) this.zzQD.zzQv.zzcu().get(this.zzQG));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlx.3 */
    class C13033 implements zzid {
        final /* synthetic */ zzlx zzQD;
        final /* synthetic */ zzgx zzQH;

        C13033(zzlx com_google_android_gms_internal_zzlx, zzgx com_google_android_gms_internal_zzgx) {
            this.zzQD = com_google_android_gms_internal_zzlx;
            this.zzQH = com_google_android_gms_internal_zzgx;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            this.zzQD.zzb(this.zzQH, (String) map.get("asset"));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlx.4 */
    class C13044 extends com.google.android.gms.internal.zzlw.zza {
        final /* synthetic */ zzid zzQI;

        C13044(zzlx com_google_android_gms_internal_zzlx, zzid com_google_android_gms_internal_zzid) {
            this.zzQI = com_google_android_gms_internal_zzid;
        }

        public void zze(zzjj com_google_android_gms_internal_zzjj) {
            com_google_android_gms_internal_zzjj.zza("/nativeAdCustomClick", this.zzQI);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlx.5 */
    class C13055 implements com.google.android.gms.internal.zzql.zza<List<zzgu>, zzgs> {
        final /* synthetic */ String zzQJ;
        final /* synthetic */ Integer zzQK;
        final /* synthetic */ Integer zzQL;
        final /* synthetic */ int zzQM;
        final /* synthetic */ int zzQN;
        final /* synthetic */ int zzQO;
        final /* synthetic */ int zzQP;
        final /* synthetic */ boolean zzQQ;

        C13055(zzlx com_google_android_gms_internal_zzlx, String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
            this.zzQJ = str;
            this.zzQK = num;
            this.zzQL = num2;
            this.zzQM = i;
            this.zzQN = i2;
            this.zzQO = i3;
            this.zzQP = i4;
            this.zzQQ = z;
        }

        public /* synthetic */ Object apply(Object obj) {
            return zzj((List) obj);
        }

        public zzgs zzj(List<zzgu> list) {
            zzgs com_google_android_gms_internal_zzgs;
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        com_google_android_gms_internal_zzgs = new zzgs(this.zzQJ, zzlx.zzh(list), this.zzQK, this.zzQL, this.zzQM > 0 ? Integer.valueOf(this.zzQM) : null, this.zzQN + this.zzQO, this.zzQP, this.zzQQ);
                        return com_google_android_gms_internal_zzgs;
                    }
                } catch (Throwable e) {
                    zzqf.zzb("Could not get attribution icon", e);
                    return null;
                }
            }
            com_google_android_gms_internal_zzgs = null;
            return com_google_android_gms_internal_zzgs;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlx.6 */
    class C13066 implements com.google.android.gms.internal.zzpv.zza<zzgu> {
        final /* synthetic */ String zzMo;
        final /* synthetic */ zzlx zzQD;
        final /* synthetic */ boolean zzQR;
        final /* synthetic */ double zzQS;
        final /* synthetic */ boolean zzQT;

        C13066(zzlx com_google_android_gms_internal_zzlx, boolean z, double d, boolean z2, String str) {
            this.zzQD = com_google_android_gms_internal_zzlx;
            this.zzQR = z;
            this.zzQS = d;
            this.zzQT = z2;
            this.zzMo = str;
        }

        @TargetApi(19)
        public zzgu zzg(InputStream inputStream) {
            Bitmap decodeStream;
            Options options = new Options();
            options.inDensity = (int) (160.0d * this.zzQS);
            if (!this.zzQT) {
                options.inPreferredConfig = Config.RGB_565;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (Throwable e) {
                zzqf.zzb("Error grabbing image.", e);
                decodeStream = null;
            }
            if (decodeStream == null) {
                this.zzQD.zza(2, this.zzQR);
                return null;
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (zzt.zzzl() && zzpk.zzkI()) {
                int width = decodeStream.getWidth();
                int height = decodeStream.getHeight();
                zzpk.m4709v(new StringBuilder(C0268R.styleable.AppCompatTheme_ratingBarStyle).append("Decoded image w: ").append(width).append(" h:").append(height).append(" bytes: ").append(decodeStream.getAllocationByteCount()).append(" time: ").append(uptimeMillis2 - uptimeMillis).append(" on ui thread: ").append(Looper.getMainLooper().getThread() == Thread.currentThread()).toString());
            }
            return new zzgu(new BitmapDrawable(Resources.getSystem(), decodeStream), Uri.parse(this.zzMo), this.zzQS);
        }

        @TargetApi(19)
        public /* synthetic */ Object zzh(InputStream inputStream) {
            return zzg(inputStream);
        }

        public zzgu zzjh() {
            this.zzQD.zza(2, this.zzQR);
            return null;
        }

        public /* synthetic */ Object zzji() {
            return zzjh();
        }
    }

    public interface zza<T extends com.google.android.gms.internal.zzha.zza> {
        T zza(zzlx com_google_android_gms_internal_zzlx, JSONObject jSONObject);
    }

    class zzb {
        public zzid zzQU;

        zzb(zzlx com_google_android_gms_internal_zzlx) {
        }
    }

    static {
        zzQl = TimeUnit.SECONDS.toMillis(60);
    }

    public zzlx(Context context, zzs com_google_android_gms_ads_internal_zzs, zzpv com_google_android_gms_internal_zzpv, zzaw com_google_android_gms_internal_zzaw, com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, zzgl com_google_android_gms_internal_zzgl) {
        this.zzrJ = new Object();
        this.mContext = context;
        this.zzQv = com_google_android_gms_ads_internal_zzs;
        this.zzQu = com_google_android_gms_internal_zzpv;
        this.zzPR = com_google_android_gms_internal_zzpb_zza;
        this.zzGP = com_google_android_gms_internal_zzaw;
        this.zzsn = com_google_android_gms_internal_zzgl;
        this.zzGN = zza(context, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_ads_internal_zzs, com_google_android_gms_internal_zzaw);
        this.zzGN.zziT();
        this.zzQw = false;
        this.zzPY = -2;
        this.zzQx = null;
        this.zzQz = null;
    }

    private com.google.android.gms.internal.zzha.zza zza(zza com_google_android_gms_internal_zzlx_zza, JSONObject jSONObject, String str) {
        if (zzjf() || com_google_android_gms_internal_zzlx_zza == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] zzd = zzd(jSONObject2, "impression_tracking_urls");
        this.zzQx = zzd == null ? null : Arrays.asList(zzd);
        this.zzQy = jSONObject2.optJSONObject("active_view");
        this.zzQz = jSONObject.optString("debug_signals");
        com.google.android.gms.internal.zzha.zza zza = com_google_android_gms_internal_zzlx_zza.zza(this, jSONObject);
        if (zza == null) {
            zzqf.m4708e("Failed to retrieve ad assets.");
            return null;
        }
        zza.zzb(new zzhb(this.mContext, this.zzQv, this.zzGN, this.zzGP, jSONObject, zza, this.zzPR.zzTi.zzvn, str));
        return zza;
    }

    private zzqm<zzgu> zza(JSONObject jSONObject, boolean z, boolean z2) {
        String string = z ? jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new zzqk(new zzgu(null, Uri.parse(string), optDouble)) : this.zzQu.zza(string, new C13066(this, z, optDouble, optBoolean, string));
        } else {
            zza(0, z);
            return new zzqk(null);
        }
    }

    private void zza(com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza) {
        if (com_google_android_gms_internal_zzha_zza instanceof zzgx) {
            zzgx com_google_android_gms_internal_zzgx = (zzgx) com_google_android_gms_internal_zzha_zza;
            zzb com_google_android_gms_internal_zzlx_zzb = new zzb(this);
            zzid c13033 = new C13033(this, com_google_android_gms_internal_zzgx);
            com_google_android_gms_internal_zzlx_zzb.zzQU = c13033;
            this.zzGN.zza(new C13044(this, c13033));
        }
    }

    private JSONObject zzaH(String str) {
        if (zzjf()) {
            return null;
        }
        zzqj com_google_android_gms_internal_zzqj = new zzqj();
        this.zzGN.zza(new C13011(this, str, new zzb(this), com_google_android_gms_internal_zzqj));
        return (JSONObject) com_google_android_gms_internal_zzqj.get(zzQl, TimeUnit.MILLISECONDS);
    }

    private zzpb zzb(com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza) {
        int i;
        synchronized (this.zzrJ) {
            i = this.zzPY;
            if (com_google_android_gms_internal_zzha_zza == null && this.zzPY == -2) {
                i = 0;
            }
        }
        return new zzpb(this.zzPR.zzTi.zzRy, null, this.zzPR.zzWm.zzKF, i, this.zzPR.zzWm.zzKG, this.zzQx, this.zzPR.zzWm.orientation, this.zzPR.zzWm.zzKL, this.zzPR.zzTi.zzRB, false, null, null, null, null, null, 0, this.zzPR.zzvr, this.zzPR.zzWm.zzSm, this.zzPR.zzWg, this.zzPR.zzWh, this.zzPR.zzWm.zzSs, this.zzQy, i != -2 ? null : com_google_android_gms_internal_zzha_zza, null, null, null, this.zzPR.zzWm.zzSF, this.zzPR.zzWm.zzSG, null, this.zzPR.zzWm.zzKI, this.zzQz);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.zzqw zzb(com.google.android.gms.internal.zzqm<com.google.android.gms.internal.zzqw> r3) {
        /*
        r0 = com.google.android.gms.internal.zzgd.zzEs;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = (java.lang.Integer) r0;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = r0.intValue();	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = r3.get(r0, r2);	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = (com.google.android.gms.internal.zzqw) r0;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = move-exception;
        r1 = "InterruptedException occurred while waiting for video to load";
        com.google.android.gms.internal.zzqf.zzc(r1, r0);
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
    L_0x0023:
        r0 = 0;
        goto L_0x0015;
    L_0x0025:
        r0 = move-exception;
    L_0x0026:
        r1 = "Exception occurred while waiting for video to load";
        com.google.android.gms.internal.zzqf.zzc(r1, r0);
        goto L_0x0023;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0026;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlx.zzb(com.google.android.gms.internal.zzqm):com.google.android.gms.internal.zzqw");
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private void zzb(zzhn com_google_android_gms_internal_zzhn, String str) {
        try {
            zzhr zzz = this.zzQv.zzz(com_google_android_gms_internal_zzhn.getCustomTemplateId());
            if (zzz != null) {
                zzz.zza(com_google_android_gms_internal_zzhn, str);
            }
        } catch (Throwable e) {
            zzqf.zzc(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private String[] zzd(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private static List<Drawable> zzh(List<zzgu> list) {
        List<Drawable> arrayList = new ArrayList();
        for (zzgu zzfP : list) {
            arrayList.add((Drawable) zzd.zzF(zzfP.zzfP()));
        }
        return arrayList;
    }

    public /* synthetic */ Object call() {
        return zzje();
    }

    public void zzU(int i) {
        synchronized (this.zzrJ) {
            this.zzQw = true;
            this.zzPY = i;
        }
    }

    zzlw zza(Context context, com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, zzs com_google_android_gms_ads_internal_zzs, zzaw com_google_android_gms_internal_zzaw) {
        return new zzlw(context, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_ads_internal_zzs, com_google_android_gms_internal_zzaw);
    }

    zzly zza(Context context, zzaw com_google_android_gms_internal_zzaw, com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, zzgl com_google_android_gms_internal_zzgl, zzs com_google_android_gms_ads_internal_zzs) {
        return new zzly(context, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzgl, com_google_android_gms_ads_internal_zzs);
    }

    public zzqm<zzgu> zza(JSONObject jSONObject, String str, boolean z, boolean z2) {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzqm<zzgu>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        List<zzqm<zzgu>> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<zzgu> zza(JSONObject jSONObject, String str, boolean z) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzU(i);
        }
    }

    protected zza zzc(JSONObject jSONObject) {
        if (zzjf() || jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzPR.zzTi.zzvF != null ? this.zzPR.zzTi.zzvF.zzHa : false;
        boolean z2 = this.zzPR.zzTi.zzvF != null ? this.zzPR.zzTi.zzvF.zzHc : false;
        if ("2".equals(string)) {
            return new zzlz(z, z2);
        }
        if ("1".equals(string)) {
            return new zzma(z, z2);
        }
        if ("3".equals(string)) {
            String string2 = jSONObject.getString("custom_template_id");
            zzqj com_google_android_gms_internal_zzqj = new zzqj();
            zzpo.zzXC.post(new C13022(this, com_google_android_gms_internal_zzqj, string2));
            if (com_google_android_gms_internal_zzqj.get(zzQl, TimeUnit.MILLISECONDS) != null) {
                return new zzmb(z);
            }
            string2 = "No handler for custom template: ";
            String valueOf = String.valueOf(jSONObject.getString("custom_template_id"));
            zzqf.m4708e(valueOf.length() != 0 ? string2.concat(valueOf) : new String(string2));
        } else {
            zzU(0);
        }
        return null;
    }

    public zzqm<zzqw> zzc(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return new zzqk(null);
        }
        if (!TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            return zza(this.mContext, this.zzGP, this.zzPR, this.zzsn, this.zzQv).zze(optJSONObject);
        }
        zzqf.zzbh("Required field 'vast_xml' is missing");
        return new zzqk(null);
    }

    public zzqm<zzgs> zzd(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzqk(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", PointerIconCompat.TYPE_DEFAULT);
        int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        int i = (this.zzPR.zzTi.zzvF == null || this.zzPR.zzTi.zzvF.versionCode < 2) ? 1 : this.zzPR.zzTi.zzvF.zzHd;
        boolean optBoolean = optJSONObject.optBoolean("allow_pub_rendering");
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        return zzql.zza(zzql.zzo(arrayList), new C13055(this, optString, zzb2, zzb, optInt, optInt3, optInt2, i, optBoolean));
    }

    public zzpb zzje() {
        try {
            this.zzGN.zziU();
            String zzjg = zzjg();
            JSONObject zzaH = zzaH(zzjg);
            com.google.android.gms.internal.zzha.zza zza = zza(zzc(zzaH), zzaH, zzjg);
            zza(zza);
            return zzb(zza);
        } catch (CancellationException e) {
            if (!this.zzQw) {
                zzU(0);
            }
            return zzb(null);
        } catch (ExecutionException e2) {
            if (this.zzQw) {
                zzU(0);
            }
            return zzb(null);
        } catch (InterruptedException e3) {
            if (this.zzQw) {
                zzU(0);
            }
            return zzb(null);
        } catch (Throwable e4) {
            zzqf.zzc("Malformed native JSON response.", e4);
            if (this.zzQw) {
                zzU(0);
            }
            return zzb(null);
        } catch (Throwable e42) {
            zzqf.zzc("Timeout when loading native ad.", e42);
            if (this.zzQw) {
                zzU(0);
            }
            return zzb(null);
        }
    }

    public boolean zzjf() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzQw;
        }
        return z;
    }

    String zzjg() {
        return UUID.randomUUID().toString();
    }
}
