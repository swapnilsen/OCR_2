package com.facebook.ads.internal.p024b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v4.os.EnvironmentCompat;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.C0854l;
import com.facebook.ads.C0871o.C0870a;
import com.facebook.ads.internal.p037k.C0652a;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.aa */
public class aa extends C0472f {
    private final ab f852c;
    private C0870a f853d;
    private boolean f854e;
    private boolean f855f;
    private boolean f856g;
    private View f857h;
    private List<View> f858i;

    public aa(Context context, C0476h c0476h, C0652a c0652a, ab abVar) {
        super(context, c0476h, c0652a);
        this.f852c = abVar;
    }

    private String m1188b(View view) {
        try {
            return m1189c(view).toString();
        } catch (JSONException e) {
            return "Json exception";
        }
    }

    private JSONObject m1189c(View view) {
        boolean z = true;
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt(FacebookAdapter.KEY_ID, Integer.valueOf(view.getId()));
        jSONObject.putOpt("class", view.getClass());
        jSONObject.putOpt(Param.ORIGIN, String.format("{x:%d, y:%d}", new Object[]{Integer.valueOf(view.getTop()), Integer.valueOf(view.getLeft())}));
        jSONObject.putOpt("size", String.format("{h:%d, w:%d}", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())}));
        if (this.f858i == null || !this.f858i.contains(view)) {
            z = false;
        }
        jSONObject.putOpt("clickable", Boolean.valueOf(z));
        Object obj = EnvironmentCompat.MEDIA_UNKNOWN;
        if (view instanceof Button) {
            obj = "button";
        } else if (view instanceof TextView) {
            obj = "text";
        } else if (view instanceof ImageView) {
            obj = "image";
        } else if (view instanceof C0854l) {
            obj = "mediaview";
        } else if (view instanceof ViewGroup) {
            obj = "viewgroup";
        }
        jSONObject.putOpt("type", obj);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            JSONArray jSONArray = new JSONArray();
            while (i < viewGroup.getChildCount()) {
                jSONArray.put(m1189c(viewGroup.getChildAt(i)));
                i++;
            }
            jSONObject.putOpt("list", jSONArray);
        }
        return jSONObject;
    }

    private String m1190d(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
            createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(createBitmap));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, this.f852c.m1214i(), byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
    }

    public void m1191a(View view) {
        this.f857h = view;
    }

    public void m1192a(C0870a c0870a) {
        this.f853d = c0870a;
    }

    public void m1193a(List<View> list) {
        this.f858i = list;
    }

    protected void m1194a(Map<String, String> map) {
        if (this.f852c != null) {
            if (this.a != null) {
                map.put("mil", String.valueOf(this.a.m1243a()));
                map.put("eil", String.valueOf(this.a.m1244b()));
                map.put("eil_source", this.a.m1245c());
            }
            if (this.f853d != null) {
                map.put("nti", String.valueOf(this.f853d.m2737a()));
            }
            if (this.f854e) {
                map.put("nhs", Boolean.TRUE.toString());
            }
            if (this.f855f) {
                map.put("nmv", Boolean.TRUE.toString());
            }
            if (this.f856g) {
                map.put("nmvap", Boolean.TRUE.toString());
            }
            if (this.f857h != null && this.f852c.m1212g()) {
                map.put(Promotion.ACTION_VIEW, m1188b(this.f857h));
            }
            if (this.f857h != null && this.f852c.m1211f()) {
                map.put("snapshot", m1190d(this.f857h));
            }
            this.f852c.m1206a((Map) map);
        }
    }

    public void m1195a(boolean z) {
        this.f854e = z;
    }

    public void m1196b(boolean z) {
        this.f855f = z;
    }

    public void m1197c(boolean z) {
        this.f856g = z;
    }
}
