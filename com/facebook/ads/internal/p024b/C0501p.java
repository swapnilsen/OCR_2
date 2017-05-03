package com.facebook.ads.internal.p024b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C0430b;
import com.facebook.ads.C0439c;
import com.facebook.ads.C0852j;
import com.facebook.ads.internal.p021m.C0710t;
import com.facebook.ads.internal.p025h.C0578f;
import com.facebook.ads.internal.view.C0504c;
import com.facebook.ads.p022a.C0431a;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.p */
public class C0501p extends C0474d {
    private static final ConcurrentMap<String, C0504c> f953a;
    private final String f954b;
    private Context f955c;
    private C0519y f956d;
    private C0459e f957e;
    private boolean f958f;
    private C0514u f959g;
    private C0500a f960h;

    /* renamed from: com.facebook.ads.internal.b.p.1 */
    class C04991 implements C0431a {
        final /* synthetic */ C0505q f947a;
        final /* synthetic */ C0501p f948b;

        C04991(C0501p c0501p, C0505q c0505q) {
            this.f948b = c0501p;
            this.f947a = c0505q;
        }

        public void m1353a(C0497x c0497x) {
            this.f948b.f958f = true;
            if (this.f948b.f957e != null) {
                this.f948b.f957e.m1157a(this.f948b);
            }
        }

        public void m1354a(C0497x c0497x, View view) {
            this.f948b.f960h = this.f947a.m1397l();
            C0501p.f953a.put(this.f948b.f954b, this.f947a);
        }

        public void m1355a(C0497x c0497x, C0439c c0439c) {
            this.f948b.f957e.m1158a(this.f948b, c0439c);
        }

        public void m1356b(C0497x c0497x) {
            this.f948b.f957e.m1159a(this.f948b, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, true);
        }

        public void m1357c(C0497x c0497x) {
            this.f948b.f957e.m1160b(this.f948b);
            this.f948b.f957e.m1161c(this.f948b);
        }

        public void m1358d(C0497x c0497x) {
        }
    }

    /* renamed from: com.facebook.ads.internal.b.p.a */
    public enum C0500a {
        UNSPECIFIED,
        VERTICAL,
        HORIZONTAL;

        public static C0500a m1359a(int i) {
            return i == 0 ? UNSPECIFIED : i == 2 ? HORIZONTAL : VERTICAL;
        }
    }

    static {
        f953a = new ConcurrentHashMap();
    }

    public C0501p() {
        this.f954b = UUID.randomUUID().toString();
        this.f958f = false;
    }

    public static C0504c m1362a(String str) {
        return (C0504c) f953a.get(str);
    }

    public static void m1363a(C0504c c0504c) {
        for (Entry entry : f953a.entrySet()) {
            if (entry.getValue() == c0504c) {
                f953a.remove(entry.getKey());
            }
        }
    }

    private int m1367e() {
        int rotation = ((WindowManager) this.f955c.getSystemService("window")).getDefaultDisplay().getRotation();
        if (this.f960h == C0500a.UNSPECIFIED) {
            return -1;
        }
        if (this.f960h == C0500a.HORIZONTAL) {
            switch (rotation) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    return 8;
                default:
                    return 0;
            }
        }
        switch (rotation) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return 9;
            default:
                return 1;
        }
    }

    public void m1368a(Context context, C0459e c0459e, Map<String, Object> map, C0578f c0578f) {
        this.f955c = context;
        this.f957e = c0459e;
        JSONObject jSONObject = (JSONObject) map.get("data");
        if (jSONObject.has("markup")) {
            this.f959g = C0514u.m1496a(jSONObject);
            if (C0710t.m2289a(context, this.f959g)) {
                c0459e.m1158a(this, C0439c.f737b);
                return;
            }
            this.f956d = new C0519y(context, this.f954b, this, this.f957e);
            this.f956d.m1555a();
            Map e = this.f959g.m1507e();
            if (e.containsKey("orientation")) {
                this.f960h = C0500a.m1359a(Integer.parseInt((String) e.get("orientation")));
            }
            this.f958f = true;
            if (this.f957e != null) {
                this.f957e.m1157a(this);
                return;
            }
            return;
        }
        this.f956d = new C0519y(context, this.f954b, this, this.f957e);
        this.f956d.m1555a();
        C0505q c0505q = new C0505q();
        c0505q.m1346a(context, new C04991(this, c0505q), map, c0578f);
    }

    public void m1369b() {
        if (this.f956d != null) {
            this.f956d.m1556b();
        }
    }

    public boolean m1370c() {
        if (this.f958f) {
            Intent intent = new Intent(this.f955c, AudienceNetworkActivity.class);
            intent.putExtra("predefinedOrientationKey", m1367e());
            intent.putExtra("uniqueId", this.f954b);
            if (f953a.containsKey(this.f954b)) {
                intent.putExtra("viewType", C0430b.NATIVE);
            } else {
                intent.putExtra("viewType", C0430b.DISPLAY);
                this.f959g.m1503a(intent);
            }
            intent.addFlags(268435456);
            try {
                this.f955c.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                intent.setClass(this.f955c, C0852j.class);
                this.f955c.startActivity(intent);
            }
            return true;
        }
        if (this.f957e != null) {
            this.f957e.m1158a(this, C0439c.f740e);
        }
        return false;
    }
}
