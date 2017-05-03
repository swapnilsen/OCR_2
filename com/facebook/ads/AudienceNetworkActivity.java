package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.C0595i;
import com.facebook.ads.internal.C0655k;
import com.facebook.ads.internal.p021m.C0705p;
import com.facebook.ads.internal.p021m.C0706q;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.C0713v;
import com.facebook.ads.internal.p021m.al;
import com.facebook.ads.internal.p021m.al.C0425a;
import com.facebook.ads.internal.p021m.am;
import com.facebook.ads.internal.p023a.C0449a;
import com.facebook.ads.internal.p023a.C0450b;
import com.facebook.ads.internal.p024b.C0501p;
import com.facebook.ads.internal.p024b.C0505q;
import com.facebook.ads.internal.p025h.C0590q;
import com.facebook.ads.internal.view.C0504c;
import com.facebook.ads.internal.view.C0504c.C0417a;
import com.facebook.ads.internal.view.C0737b;
import com.facebook.ads.internal.view.C0737b.C0428b;
import com.facebook.ads.internal.view.C0822e;
import com.facebook.ads.internal.view.C0826g;
import com.facebook.ads.internal.view.C0841i;
import com.facebook.ads.internal.view.C0849l;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AudienceNetworkActivity extends Activity {
    private static final String f704a;
    private String f705b;
    private String f706c;
    private C0737b f707d;
    private boolean f708e;
    private RelativeLayout f709f;
    private Intent f710g;
    private C0595i f711h;
    private int f712i;
    private String f713j;
    private C0430b f714k;
    private long f715l;
    private long f716m;
    private int f717n;
    private C0504c f718o;
    private List<C0420a> f719p;

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.1 */
    class C04161 implements OnClickListener {
        final /* synthetic */ AudienceNetworkActivity f688a;

        C04161(AudienceNetworkActivity audienceNetworkActivity) {
            this.f688a = audienceNetworkActivity;
        }

        public void onClick(View view) {
            this.f688a.finish();
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.2 */
    class C04182 implements C0417a {
        final /* synthetic */ AudienceNetworkActivity f689a;

        C04182(AudienceNetworkActivity audienceNetworkActivity) {
            this.f689a = audienceNetworkActivity;
        }

        public void m984a(View view) {
            this.f689a.f709f.addView(view);
            if (this.f689a.f711h != null) {
                this.f689a.f709f.addView(this.f689a.f711h);
            }
        }

        public void m985a(String str) {
            this.f689a.m1018a(str);
        }

        public void m986a(String str, C0590q c0590q) {
            this.f689a.m1019a(str, c0590q);
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.3 */
    class C04193 implements C0417a {
        final /* synthetic */ AudienceNetworkActivity f690a;

        C04193(AudienceNetworkActivity audienceNetworkActivity) {
            this.f690a = audienceNetworkActivity;
        }

        public void m987a(View view) {
            this.f690a.f709f.addView(view);
        }

        public void m988a(String str) {
            this.f690a.m1018a(str);
            if (str.equals(C0655k.REWARDED_VIDEO_END_ACTIVITY)) {
                this.f690a.finish();
            }
        }

        public void m989a(String str, C0590q c0590q) {
            this.f690a.m1018a(str);
            if (str.startsWith(C0655k.REWARDED_VIDEO_COMPLETE.m2098a())) {
                if (!str.equals(C0655k.REWARDED_VIDEO_COMPLETE_WITHOUT_REWARD.m2098a())) {
                    this.f690a.m1022b();
                }
                this.f690a.f708e = true;
                this.f690a.m1025d();
            }
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.a */
    public interface C0420a {
        boolean m990a();
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.4 */
    class C04214 implements C0420a {
        final /* synthetic */ AudienceNetworkActivity f691a;

        C04214(AudienceNetworkActivity audienceNetworkActivity) {
            this.f691a = audienceNetworkActivity;
        }

        public boolean m991a() {
            return !this.f691a.f708e;
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.5 */
    class C04225 implements C0417a {
        final /* synthetic */ AudienceNetworkActivity f692a;

        C04225(AudienceNetworkActivity audienceNetworkActivity) {
            this.f692a = audienceNetworkActivity;
        }

        public void m992a(View view) {
            this.f692a.f709f.addView(view);
            if (this.f692a.f711h != null) {
                this.f692a.f709f.addView(this.f692a.f711h);
            }
        }

        public void m993a(String str) {
            this.f692a.m1018a(str);
        }

        public void m994a(String str, C0590q c0590q) {
            this.f692a.m1019a(str, c0590q);
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.6 */
    class C04236 implements C0417a {
        final /* synthetic */ AudienceNetworkActivity f693a;

        C04236(AudienceNetworkActivity audienceNetworkActivity) {
            this.f693a = audienceNetworkActivity;
        }

        public void m995a(View view) {
            this.f693a.f709f.addView(view);
            if (this.f693a.f711h != null) {
                this.f693a.f709f.addView(this.f693a.f711h);
            }
        }

        public void m996a(String str) {
            this.f693a.m1018a(str);
        }

        public void m997a(String str, C0590q c0590q) {
            this.f693a.m1019a(str, c0590q);
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.7 */
    class C04247 implements C0417a {
        final /* synthetic */ AudienceNetworkActivity f694a;

        C04247(AudienceNetworkActivity audienceNetworkActivity) {
            this.f694a = audienceNetworkActivity;
        }

        public void m998a(View view) {
            this.f694a.f709f.addView(view);
        }

        public void m999a(String str) {
            this.f694a.m1018a(str);
        }

        public void m1000a(String str, C0590q c0590q) {
            this.f694a.m1019a(str, c0590q);
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.8 */
    class C04268 implements C0425a {
        final /* synthetic */ AudienceNetworkActivity f695a;

        C04268(AudienceNetworkActivity audienceNetworkActivity) {
            this.f695a = audienceNetworkActivity;
        }

        public void m1003a() {
            this.f695a.m1018a(C0655k.REWARD_SERVER_FAILED.m2098a());
        }

        public void m1004a(am amVar) {
            if (amVar == null || !amVar.m2178a()) {
                this.f695a.m1018a(C0655k.REWARD_SERVER_FAILED.m2098a());
            } else {
                this.f695a.m1018a(C0655k.REWARD_SERVER_SUCCESS.m2098a());
            }
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.9 */
    class C04299 implements C0428b {
        final /* synthetic */ AudienceNetworkActivity f697a;

        /* renamed from: com.facebook.ads.AudienceNetworkActivity.9.1 */
        class C04271 implements Runnable {
            final /* synthetic */ C04299 f696a;

            C04271(C04299 c04299) {
                this.f696a = c04299;
            }

            public void run() {
                if (this.f696a.f697a.f707d.m2349e()) {
                    Log.w(AudienceNetworkActivity.f704a, "Webview already destroyed, cannot activate");
                } else {
                    this.f696a.f697a.f707d.loadUrl("javascript:" + this.f696a.f697a.f706c);
                }
            }
        }

        C04299(AudienceNetworkActivity audienceNetworkActivity) {
            this.f697a = audienceNetworkActivity;
        }

        public void m1009a() {
            if (this.f697a.f707d != null && !TextUtils.isEmpty(this.f697a.f706c)) {
                this.f697a.f707d.post(new C04271(this));
            }
        }

        public void m1010a(int i) {
        }

        public void m1011a(String str, Map<String, String> map) {
            Uri parse = Uri.parse(str);
            if ("fbad".equals(parse.getScheme()) && parse.getAuthority().equals("close")) {
                this.f697a.finish();
                return;
            }
            if ("fbad".equals(parse.getScheme()) && C0450b.m1112a(parse.getAuthority())) {
                this.f697a.m1018a(C0655k.REWARDED_VIDEO_AD_CLICK.m2098a());
            }
            C0449a a = C0450b.m1111a(this.f697a, this.f697a.f705b, parse, map);
            if (a != null) {
                try {
                    a.m1110b();
                } catch (Throwable e) {
                    Log.e(AudienceNetworkActivity.f704a, "Error executing action", e);
                }
            }
        }

        public void m1012b() {
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity.b */
    public enum C0430b {
        DISPLAY,
        VIDEO,
        REWARDED_VIDEO,
        NATIVE,
        BROWSER
    }

    static {
        f704a = AudienceNetworkActivity.class.getSimpleName();
    }

    public AudienceNetworkActivity() {
        this.f708e = false;
        this.f712i = -1;
        this.f719p = new ArrayList();
    }

    private void m1015a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.f712i = bundle.getInt("predefinedOrientationKey", -1);
            this.f713j = bundle.getString("uniqueId");
            this.f714k = (C0430b) bundle.getSerializable("viewType");
            return;
        }
        this.f712i = intent.getIntExtra("predefinedOrientationKey", -1);
        this.f713j = intent.getStringExtra("uniqueId");
        this.f714k = (C0430b) intent.getSerializableExtra("viewType");
        this.f717n = intent.getIntExtra("skipAfterSeconds", 0) * PointerIconCompat.TYPE_DEFAULT;
    }

    private void m1018a(String str) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(str + ":" + this.f713j));
    }

    private void m1019a(String str, C0590q c0590q) {
        Intent intent = new Intent(str + ":" + this.f713j);
        intent.putExtra(DataLayer.EVENT_KEY, c0590q);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void m1022b() {
        if (!TextUtils.isEmpty(this.f710g.getStringExtra("rewardServerURL"))) {
            al alVar = new al(new HashMap());
            alVar.m2176a(new C04268(this));
            alVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{r0});
        }
    }

    private void m1023c() {
        Object a = C0712u.m2302a(this.f710g.getByteArrayExtra("facebookRewardedVideoEndCardMarkup"));
        if (!TextUtils.isEmpty(a)) {
            this.f707d = new C0737b(this, new C04299(this), 1);
            this.f706c = this.f710g.getStringExtra("facebookRewardedVideoEndCardActivationCommand");
            this.f707d.loadDataWithBaseURL(C0713v.m2314a(), a, "text/html", "utf-8", null);
        }
    }

    private void m1025d() {
        if (this.f707d == null) {
            finish();
            return;
        }
        this.f709f.removeAllViews();
        this.f718o = null;
        setContentView(this.f707d);
    }

    public void m1031a(C0420a c0420a) {
        this.f719p.add(c0420a);
    }

    public void m1032b(C0420a c0420a) {
        this.f719p.remove(c0420a);
    }

    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f716m += currentTimeMillis - this.f715l;
        this.f715l = currentTimeMillis;
        if (this.f716m > ((long) this.f717n)) {
            Object obj = null;
            for (C0420a a : this.f719p) {
                obj = a.m990a() ? 1 : obj;
            }
            if (obj == null) {
                super.onBackPressed();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f718o instanceof C0505q) {
            ((C0505q) this.f718o).m1389a(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        this.f709f = new RelativeLayout(this);
        this.f709f.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        setContentView(this.f709f, new LayoutParams(-1, -1));
        this.f710g = getIntent();
        if (this.f710g.getBooleanExtra("useNativeCloseButton", false)) {
            this.f711h = new C0595i(this);
            this.f711h.setId(100002);
            this.f711h.setOnClickListener(new C04161(this));
        }
        this.f705b = this.f710g.getStringExtra("clientToken");
        m1015a(this.f710g, bundle);
        if (this.f714k == C0430b.VIDEO) {
            C0504c c0849l = new C0849l(this, new C04182(this));
            c0849l.m2627a(this.f709f);
            this.f718o = c0849l;
        } else if (this.f714k == C0430b.REWARDED_VIDEO) {
            m1023c();
            this.f718o = new C0841i(this, new C04193(this));
            m1031a(new C04214(this));
        } else if (this.f714k == C0430b.DISPLAY) {
            this.f718o = new C0826g(this, new C04225(this));
        } else if (this.f714k == C0430b.BROWSER) {
            this.f718o = new C0822e(this, new C04236(this));
        } else if (this.f714k == C0430b.NATIVE) {
            this.f718o = C0501p.m1362a(this.f710g.getStringExtra("uniqueId"));
            if (this.f718o == null) {
                C0706q.m2279a(C0705p.m2276a(null, "Unable to find view"));
                m1018a("com.facebook.ads.interstitial.error");
                finish();
                return;
            }
            this.f718o.m1374a(new C04247(this));
        } else {
            C0706q.m2279a(C0705p.m2276a(null, "Unable to infer viewType from intent or savedInstanceState"));
            m1018a("com.facebook.ads.interstitial.error");
            finish();
            return;
        }
        this.f718o.m1372a(this.f710g, bundle, this);
        m1018a("com.facebook.ads.interstitial.displayed");
        this.f715l = System.currentTimeMillis();
    }

    protected void onDestroy() {
        if (this.f718o != null) {
            C0501p.m1363a(this.f718o);
            this.f718o.m1377k();
            this.f718o = null;
        }
        this.f709f.removeAllViews();
        if (this.f714k == C0430b.REWARDED_VIDEO) {
            m1018a(C0655k.REWARDED_VIDEO_CLOSED.m2098a());
        } else {
            m1018a("com.facebook.ads.interstitial.dismissed");
        }
        super.onDestroy();
    }

    public void onPause() {
        this.f716m += System.currentTimeMillis() - this.f715l;
        if (!(this.f718o == null || this.f708e)) {
            this.f718o.m1375i();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f715l = System.currentTimeMillis();
        if (this.f718o != null) {
            this.f718o.m1376j();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f718o != null) {
            this.f718o.m1373a(bundle);
        }
        bundle.putInt("predefinedOrientationKey", this.f712i);
        bundle.putString("uniqueId", this.f713j);
        bundle.putSerializable("viewType", this.f714k);
    }

    public void onStart() {
        super.onStart();
        if (this.f712i != -1) {
            setRequestedOrientation(this.f712i);
        }
    }
}
