package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public class zzie implements zzid {
    private final Context mContext;
    private final zzqh zztt;

    /* renamed from: com.google.android.gms.internal.zzie.1 */
    class C12121 implements Runnable {
        final /* synthetic */ Map zzGY;
        final /* synthetic */ zzqw zzHZ;
        final /* synthetic */ zzie zzIa;

        /* renamed from: com.google.android.gms.internal.zzie.1.1 */
        class C12111 implements Runnable {
            final /* synthetic */ JSONObject zzIb;
            final /* synthetic */ C12121 zzIc;

            C12111(C12121 c12121, JSONObject jSONObject) {
                this.zzIc = c12121;
                this.zzIb = jSONObject;
            }

            public void run() {
                this.zzIc.zzHZ.zzb("fetchHttpRequestCompleted", this.zzIb);
                zzqf.zzbf("Dispatched http response.");
            }
        }

        C12121(zzie com_google_android_gms_internal_zzie, Map map, zzqw com_google_android_gms_internal_zzqw) {
            this.zzIa = com_google_android_gms_internal_zzie;
            this.zzGY = map;
            this.zzHZ = com_google_android_gms_internal_zzqw;
        }

        public void run() {
            zzqf.zzbf("Received Http request.");
            JSONObject zzaa = this.zzIa.zzaa((String) this.zzGY.get("http_request"));
            if (zzaa == null) {
                zzqf.m4708e("Response should not be null.");
            } else {
                zzpo.zzXC.post(new C12111(this, zzaa));
            }
        }
    }

    @zzme
    static class zza {
        private final String mValue;
        private final String zzAX;

        public zza(String str, String str2) {
            this.zzAX = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zzAX;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzme
    static class zzb {
        private final String zzId;
        private final URL zzIe;
        private final ArrayList<zza> zzIf;
        private final String zzIg;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzId = str;
            this.zzIe = url;
            if (arrayList == null) {
                this.zzIf = new ArrayList();
            } else {
                this.zzIf = arrayList;
            }
            this.zzIg = str2;
        }

        public String zzgl() {
            return this.zzId;
        }

        public URL zzgm() {
            return this.zzIe;
        }

        public ArrayList<zza> zzgn() {
            return this.zzIf;
        }

        public String zzgo() {
            return this.zzIg;
        }
    }

    @zzme
    class zzc {
        private final zzd zzIh;
        private final boolean zzIi;
        private final String zzIj;

        public zzc(zzie com_google_android_gms_internal_zzie, boolean z, zzd com_google_android_gms_internal_zzie_zzd, String str) {
            this.zzIi = z;
            this.zzIh = com_google_android_gms_internal_zzie_zzd;
            this.zzIj = str;
        }

        public String getReason() {
            return this.zzIj;
        }

        public boolean isSuccess() {
            return this.zzIi;
        }

        public zzd zzgp() {
            return this.zzIh;
        }
    }

    @zzme
    static class zzd {
        private final String zzGr;
        private final String zzId;
        private final int zzIk;
        private final List<zza> zzIl;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzId = str;
            this.zzIk = i;
            if (list == null) {
                this.zzIl = new ArrayList();
            } else {
                this.zzIl = list;
            }
            this.zzGr = str2;
        }

        public String getBody() {
            return this.zzGr;
        }

        public int getResponseCode() {
            return this.zzIk;
        }

        public String zzgl() {
            return this.zzId;
        }

        public Iterable<zza> zzgq() {
            return this.zzIl;
        }
    }

    public zzie(Context context, zzqh com_google_android_gms_internal_zzqh) {
        this.mContext = context;
        this.zztt = com_google_android_gms_internal_zzqh;
    }

    protected zzc zza(zzb com_google_android_gms_internal_zzie_zzb) {
        Exception e;
        HttpURLConnection httpURLConnection;
        zzc com_google_android_gms_internal_zzie_zzc;
        Throwable th;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) com_google_android_gms_internal_zzie_zzb.zzgm().openConnection();
            try {
                zzw.zzcM().zza(this.mContext, this.zztt.zzba, false, httpURLConnection3);
                Iterator it = com_google_android_gms_internal_zzie_zzb.zzgn().iterator();
                while (it.hasNext()) {
                    zza com_google_android_gms_internal_zzie_zza = (zza) it.next();
                    httpURLConnection3.addRequestProperty(com_google_android_gms_internal_zzie_zza.getKey(), com_google_android_gms_internal_zzie_zza.getValue());
                }
                if (!TextUtils.isEmpty(com_google_android_gms_internal_zzie_zzb.zzgo())) {
                    httpURLConnection3.setDoOutput(true);
                    byte[] bytes = com_google_android_gms_internal_zzie_zzb.zzgo().getBytes();
                    httpURLConnection3.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection3.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
                List arrayList = new ArrayList();
                if (httpURLConnection3.getHeaderFields() != null) {
                    for (Entry entry : httpURLConnection3.getHeaderFields().entrySet()) {
                        for (String com_google_android_gms_internal_zzie_zza2 : (List) entry.getValue()) {
                            arrayList.add(new zza((String) entry.getKey(), com_google_android_gms_internal_zzie_zza2));
                        }
                    }
                }
                zzc com_google_android_gms_internal_zzie_zzc2 = new zzc(this, true, new zzd(com_google_android_gms_internal_zzie_zzb.zzgl(), httpURLConnection3.getResponseCode(), arrayList, zzw.zzcM().zza(new InputStreamReader(httpURLConnection3.getInputStream()))), null);
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return com_google_android_gms_internal_zzie_zzc2;
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = httpURLConnection3;
                try {
                    com_google_android_gms_internal_zzie_zzc = new zzc(this, false, null, e.toString());
                    if (httpURLConnection != null) {
                        return com_google_android_gms_internal_zzie_zzc;
                    }
                    httpURLConnection.disconnect();
                    return com_google_android_gms_internal_zzie_zzc;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                httpURLConnection2 = httpURLConnection3;
                th = th4;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e3) {
            httpURLConnection = null;
            e = e3;
            com_google_android_gms_internal_zzie_zzc = new zzc(this, false, null, e.toString());
            if (httpURLConnection != null) {
                return com_google_android_gms_internal_zzie_zzc;
            }
            httpURLConnection.disconnect();
            return com_google_android_gms_internal_zzie_zzc;
        } catch (Throwable th5) {
            th = th5;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    protected JSONObject zza(zzd com_google_android_gms_internal_zzie_zzd) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", com_google_android_gms_internal_zzie_zzd.zzgl());
            if (com_google_android_gms_internal_zzie_zzd.getBody() != null) {
                jSONObject.put("body", com_google_android_gms_internal_zzie_zzd.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza com_google_android_gms_internal_zzie_zza : com_google_android_gms_internal_zzie_zzd.zzgq()) {
                jSONArray.put(new JSONObject().put("key", com_google_android_gms_internal_zzie_zza.getKey()).put(Param.VALUE, com_google_android_gms_internal_zzie_zza.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", com_google_android_gms_internal_zzie_zzd.getResponseCode());
        } catch (Throwable e) {
            zzqf.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        zzpn.zza(new C12121(this, map, com_google_android_gms_internal_zzqw));
    }

    public JSONObject zzaa(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Object obj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            try {
                obj = jSONObject.optString("http_request_id");
                zzc zza = zza(zzb(jSONObject));
                if (zza.isSuccess()) {
                    jSONObject2.put("response", zza(zza.zzgp()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza.getReason());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            zzqf.m4708e("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    protected zzb zzb(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            zzqf.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString(Param.VALUE)));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }
}
