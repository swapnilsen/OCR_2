package com.facebook.ads.internal.p031g;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.g.a */
public class C0553a {
    private final String f1243a;
    private final JSONObject f1244b;
    private final Map<C0563h, List<String>> f1245c;

    public C0553a(String str, JSONObject jSONObject, @Nullable JSONArray jSONArray) {
        this.f1245c = new HashMap();
        this.f1243a = str;
        this.f1244b = jSONObject;
        if (jSONArray != null && jSONArray.length() != 0) {
            int i;
            for (Object put : C0563h.values()) {
                this.f1245c.put(put, new LinkedList());
            }
            for (i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("type");
                    CharSequence string2 = jSONObject2.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
                    C0563h valueOf = C0563h.valueOf(string.toUpperCase(Locale.US));
                    if (!(valueOf == null || TextUtils.isEmpty(string2))) {
                        ((List) this.f1245c.get(valueOf)).add(string2);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public String m1711a() {
        return this.f1243a;
    }

    public List<String> m1712a(C0563h c0563h) {
        return (List) this.f1245c.get(c0563h);
    }

    public JSONObject m1713b() {
        return this.f1244b;
    }
}
