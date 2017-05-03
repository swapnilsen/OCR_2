package com.facebook.ads.internal.p024b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C0430b;
import com.facebook.ads.C0439c;
import com.facebook.ads.C0441e;
import com.facebook.ads.internal.C0649j;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p026d.C0509a;
import com.facebook.ads.internal.p026d.C0532b;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;

/* renamed from: com.facebook.ads.internal.b.s */
public class C0511s extends ad {
    private ae f1035b;
    private Context f1036c;
    private boolean f1037d;
    private String f1038e;
    private String f1039f;
    private String f1040g;
    private String f1041h;
    private String f1042i;
    private String f1043j;
    private String f1044k;
    private String f1045l;
    private String f1046m;
    private String f1047n;
    private af f1048o;
    private C0532b f1049p;

    /* renamed from: com.facebook.ads.internal.b.s.1 */
    class C05101 implements C0509a {
        final /* synthetic */ C0511s f1034a;

        C05101(C0511s c0511s) {
            this.f1034a = c0511s;
        }

        public void m1449a() {
            this.f1034a.f1037d = true;
            this.f1034a.f1035b.m1134a(this.f1034a);
        }
    }

    public C0511s() {
        this.f1037d = false;
        this.f1038e = UUID.randomUUID().toString();
    }

    private void m1452e() {
        LocalBroadcastManager.getInstance(this.f1036c).registerReceiver(this.f1048o, this.f1048o.m1235a());
    }

    private void m1453f() {
        if (this.f1048o != null) {
            try {
                LocalBroadcastManager.getInstance(this.f1036c).unregisterReceiver(this.f1048o);
            } catch (Exception e) {
            }
        }
    }

    private String m1454g() {
        if (this.a == null) {
            return null;
        }
        String a = C0441e.m1052a();
        if (a == null || a.isEmpty()) {
            a = "https://www.facebook.com/audience_network/server_side_reward";
        } else {
            a = String.format("https://www.%s.facebook.com/audience_network/server_side_reward", new Object[]{a});
        }
        Uri parse = Uri.parse(a);
        Builder builder = new Builder();
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        builder.query(parse.getQuery());
        builder.fragment(parse.getFragment());
        builder.appendQueryParameter("puid", this.a.m2748a());
        builder.appendQueryParameter("pc", this.a.m2749b());
        builder.appendQueryParameter("ptid", this.f1038e);
        builder.appendQueryParameter("appid", this.f1045l);
        return builder.build().toString();
    }

    private String m1455h() {
        return this.f1046m;
    }

    public void m1456a(Context context, ae aeVar, Map<String, Object> map) {
        this.f1035b = aeVar;
        this.f1036c = context;
        this.f1037d = false;
        JSONObject jSONObject = (JSONObject) map.get("data");
        this.f1039f = jSONObject.optString("video_url");
        if (this.f1039f == null || this.f1039f.isEmpty()) {
            this.f1035b.m1135a(this, C0439c.f740e);
            return;
        }
        this.f1040g = jSONObject.optString("video_report_url");
        this.f1041h = jSONObject.optString("impression_report_url");
        this.f1042i = jSONObject.optString("close_report_url");
        this.f1047n = jSONObject.optString("ct");
        this.f1043j = jSONObject.optString("end_card_markup");
        this.f1044k = jSONObject.optString("activation_command");
        this.f1046m = jSONObject.optString("context_switch", "endvideo");
        String str = (String) map.get("placement_id");
        if (str != null) {
            this.f1045l = str.split(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR)[0];
        } else {
            this.f1045l = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        this.f1048o = new af(this.f1038e, this, aeVar);
        m1452e();
        this.f1049p = new C0532b(context);
        this.f1049p.m1647b(this.f1039f);
        this.f1049p.m1645a(new C05101(this));
    }

    public void m1457b() {
        m1453f();
    }

    public String m1458c() {
        Object obj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        if (this.f1049p != null) {
            obj = this.f1049p.m1648c(this.f1039f);
        }
        return TextUtils.isEmpty(obj) ? this.f1039f : obj;
    }

    public boolean m1459d() {
        if (!this.f1037d) {
            return false;
        }
        Intent intent = new Intent(this.f1036c, AudienceNetworkActivity.class);
        intent.putExtra("viewType", C0430b.REWARDED_VIDEO);
        intent.putExtra("videoURL", m1458c());
        intent.putExtra("videoReportURL", this.f1040g);
        if (!C0649j.m2057g(this.f1036c)) {
            intent.putExtra("predefinedOrientationKey", 6);
        }
        intent.putExtra("facebookRewardedVideoEndCardActivationCommand", this.f1044k);
        intent.putExtra("impressionReportURL", this.f1041h);
        intent.putExtra("uniqueId", this.f1038e);
        intent.putExtra("facebookRewardedVideoEndCardMarkup", C0712u.m2311a(this.f1043j));
        intent.putExtra("closeReportURL", this.f1042i);
        intent.putExtra("clientToken", this.f1047n);
        intent.putExtra("rewardServerURL", m1454g());
        intent.putExtra("contextSwitchBehavior", m1455h());
        if (!(this.f1036c instanceof Activity)) {
            intent.setFlags(intent.getFlags() | 268435456);
        }
        this.f1036c.startActivity(intent);
        return true;
    }
}
