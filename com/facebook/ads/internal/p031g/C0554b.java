package com.facebook.ads.internal.p031g;

import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.g.b */
public class C0554b {
    public String f1246a;
    public String f1247b;
    public String f1248c;
    public Date f1249d;
    public boolean f1250e;

    public C0554b(String str, String str2, String str3, Date date) {
        this.f1246a = str;
        this.f1247b = str2;
        this.f1248c = str3;
        this.f1249d = date;
        boolean z = (str2 == null || str3 == null) ? false : true;
        this.f1250e = z;
    }

    public C0554b(JSONObject jSONObject) {
        this(jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL), jSONObject.optString("key"), jSONObject.optString(Param.VALUE), new Date(jSONObject.optLong("expiration") * 1000));
    }

    public static List<C0554b> m1714a(String str) {
        if (str == null) {
            return null;
        }
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        List<C0554b> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject;
            try {
                jSONObject = jSONArray.getJSONObject(i);
            } catch (JSONException e2) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                C0554b c0554b = new C0554b(jSONObject);
                if (c0554b != null) {
                    arrayList.add(c0554b);
                }
            }
        }
        return arrayList;
    }

    public String m1715a() {
        Date date = this.f1249d;
        if (date == null) {
            date = new Date();
            date.setTime(date.getTime() + 3600000);
        }
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss zzz");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }

    public boolean m1716b() {
        return (this.f1247b == null || this.f1248c == null || this.f1246a == null) ? false : true;
    }
}
