package com.peace.TextScanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.plus.PlusOneButton;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import java.util.List;

public class HistoryActivity extends Activity {
    Globals f5029a;
    ListView f5030b;
    AlertDialog f5031c;
    EvaluateDialog f5032d;
    PlusOneButton f5033e;
    AdView f5034f;
    boolean f5035g;
    InterstitialAd f5036h;
    HistoryData f5037i;

    /* renamed from: com.peace.TextScanner.HistoryActivity.1 */
    class C16061 implements OnItemClickListener {
        final /* synthetic */ HistoryActivity f5018a;

        C16061(HistoryActivity historyActivity) {
            this.f5018a = historyActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f5018a.f5029a.f5012u = (String) this.f5018a.f5037i.f5065a.get(i);
            if (!this.f5018a.f5029a.f5012u.equals(this.f5018a.getString(2131230799))) {
                this.f5018a.startActivity(new Intent(this.f5018a, ResultActivity.class));
            }
        }
    }

    /* renamed from: com.peace.TextScanner.HistoryActivity.2 */
    class C16072 implements OnClickListener {
        final /* synthetic */ HistoryActivity f5019a;

        C16072(HistoryActivity historyActivity) {
            this.f5019a = historyActivity;
        }

        public void onClick(View view) {
            this.f5019a.m5552a();
        }
    }

    /* renamed from: com.peace.TextScanner.HistoryActivity.3 */
    class C16083 implements OnClickListener {
        final /* synthetic */ HistoryActivity f5020a;

        C16083(HistoryActivity historyActivity) {
            this.f5020a = historyActivity;
        }

        public void onClick(View view) {
            this.f5020a.m5559h();
        }
    }

    /* renamed from: com.peace.TextScanner.HistoryActivity.4 */
    class C16094 implements OnClickListener {
        final /* synthetic */ HistoryActivity f5021a;

        C16094(HistoryActivity historyActivity) {
            this.f5021a = historyActivity;
        }

        public void onClick(View view) {
            if (!this.f5021a.m5555d()) {
                this.f5021a.startActivity(new Intent(this.f5021a, CameraActivity.class));
            }
        }
    }

    /* renamed from: com.peace.TextScanner.HistoryActivity.5 */
    class C16105 implements OnClickListener {
        final /* synthetic */ HistoryActivity f5022a;

        C16105(HistoryActivity historyActivity) {
            this.f5022a = historyActivity;
        }

        public void onClick(View view) {
            this.f5022a.f5032d.m5569a(view.getContext());
        }
    }

    /* renamed from: com.peace.TextScanner.HistoryActivity.6 */
    class C16116 implements DialogInterface.OnClickListener {
        final /* synthetic */ HistoryActivity f5023a;

        C16116(HistoryActivity historyActivity) {
            this.f5023a = historyActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.f5023a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f5023a.getString(2131230803))));
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.peace.TextScanner.HistoryActivity.7 */
    class C16127 extends AdListener {
        final /* synthetic */ HistoryActivity f5024a;

        C16127(HistoryActivity historyActivity) {
            this.f5024a = historyActivity;
        }

        public void onAdClosed() {
            if (this.f5024a.f5035g) {
                this.f5024a.f5035g = false;
                this.f5024a.finish();
                return;
            }
            this.f5024a.startActivity(new Intent(this.f5024a, CameraActivity.class));
        }
    }

    /* renamed from: com.peace.TextScanner.HistoryActivity.8 */
    class C16138 implements DialogInterface.OnClickListener {
        final /* synthetic */ HistoryActivity f5025a;

        C16138(HistoryActivity historyActivity) {
            this.f5025a = historyActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5025a.m5558g();
        }
    }

    /* renamed from: com.peace.TextScanner.HistoryActivity.9 */
    class C16149 implements DialogInterface.OnClickListener {
        final /* synthetic */ HistoryActivity f5026a;

        C16149(HistoryActivity historyActivity) {
            this.f5026a = historyActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.peace.TextScanner.HistoryActivity.a */
    class C1615a extends ArrayAdapter<String> {
        final /* synthetic */ HistoryActivity f5027a;
        private LayoutInflater f5028b;

        public C1615a(HistoryActivity historyActivity, Context context, int i, List<String> list) {
            this.f5027a = historyActivity;
            super(context, i, list);
            this.f5028b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            CharSequence charSequence;
            String str = (String) this.f5027a.f5037i.f5065a.get(i);
            String str2 = (String) this.f5027a.f5037i.f5066b.get(i);
            if (str.length() > 50) {
                charSequence = str.substring(0, 50) + ".....";
            } else {
                Object obj = str;
            }
            if (view == null) {
                view = this.f5028b.inflate(2130903071, null);
            }
            ((TextView) view.findViewById(2131624088)).setText(charSequence);
            ((TextView) view.findViewById(2131624089)).setText(str2);
            return view;
        }
    }

    public HistoryActivity() {
        this.f5035g = false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        this.f5029a = (Globals) getApplication();
        setContentView(2130903068);
        this.f5037i = (HistoryData) new Gson().fromJson(this.f5029a.f5014w, HistoryData.class);
        if (this.f5037i == null) {
            this.f5037i = new HistoryData();
            this.f5037i.f5065a.add(0, getString(2131230799));
            this.f5037i.f5066b.add(0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        }
        ListAdapter c1615a = new C1615a(this, this, 0, this.f5037i.f5065a);
        this.f5030b = (ListView) findViewById(2131624081);
        this.f5030b.setAdapter(c1615a);
        this.f5030b.setOnItemClickListener(new C16061(this));
        ((ImageButton) findViewById(2131624080)).setOnClickListener(new C16072(this));
        ((FloatingActionButton) findViewById(2131624084)).setOnClickListener(new C16083(this));
        ((FloatingActionButton) findViewById(2131624082)).setOnClickListener(new C16094(this));
        this.f5032d = new EvaluateDialog(this, this.f5031c);
        this.f5032d.m5571c();
        ((FloatingActionButton) findViewById(2131624083)).setOnClickListener(new C16105(this));
        m5553b();
        m5554c();
        m5556e();
    }

    void m5552a() {
        if (this.f5031c == null || !this.f5031c.isShowing()) {
            String str = AdRequest.VERSION;
            try {
                str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (Throwable th) {
            }
            Builder builder = new Builder(this);
            builder.setTitle(getString(2131230775));
            builder.setMessage(getString(2131230776) + "\n\n" + getString(2131230815) + ": " + str + "\n");
            builder.setPositiveButton(getString(2131230801), null);
            builder.setNeutralButton(getString(2131230802), new C16116(this));
            this.f5031c = builder.create();
            this.f5031c.show();
        }
    }

    void m5553b() {
        this.f5033e = (PlusOneButton) findViewById(2131624079);
        this.f5033e.initialize("https://market.android.com/details?id=com.peace.TextScanner", 1);
    }

    protected void onResume() {
        super.onResume();
        this.f5034f.resume();
    }

    protected void onPause() {
        super.onPause();
        this.f5034f.pause();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f5034f.destroy();
    }

    void m5554c() {
        try {
            this.f5034f = (AdView) findViewById(2131624063);
            if (getSharedPreferences("info", 0).getInt("adBlockCount", 0) > 0) {
                return;
            }
            if (this.f5029a.f4991A) {
                this.f5034f.loadAd(new com.google.android.gms.ads.AdRequest.Builder().addTestDevice(SearchAdRequest.DEVICE_ID_EMULATOR).addTestDevice("0193CCEDD015F37B1D0454D1C0D2A625").addTestDevice("22E7281AB5904697CF4AAAC95956CCB4").addTestDevice("C73252D9541B09AF3D2FC9D362523FD8").addTestDevice("7454B16AE3D5879D91CCBE778354E884").addTestDevice("AF3AD439A079107A8C7C8A7F2DAC08BD").addTestDevice("7864359439FFCC1DD495AE9ACCDA2B0C").build());
                return;
            }
            this.f5034f.loadAd(new com.google.android.gms.ads.AdRequest.Builder().build());
        } catch (Throwable th) {
        }
    }

    public void onBackPressed() {
        this.f5035g = true;
        if (!m5555d()) {
            this.f5035g = false;
            super.onBackPressed();
        }
    }

    boolean m5555d() {
        if (getSharedPreferences("info", 0).getInt("adBlockCount", 0) > 0) {
            return false;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("info", 0);
        int i = sharedPreferences.getInt("readCount", 0);
        if (i < sharedPreferences.getInt("interstitialCount", 0) + this.f5029a.f5015x || !this.f5036h.isLoaded()) {
            return false;
        }
        this.f5036h.show();
        Editor edit = sharedPreferences.edit();
        edit.putInt("interstitialCount", i);
        edit.apply();
        return true;
    }

    void m5556e() {
        this.f5036h = new InterstitialAd(this);
        this.f5036h.setAdUnitId("ca-app-pub-6960107762880974/9199372964");
        this.f5036h.setAdListener(new C16127(this));
        m5557f();
    }

    void m5557f() {
        if (this.f5029a.f4991A) {
            this.f5036h.loadAd(new com.google.android.gms.ads.AdRequest.Builder().addTestDevice(SearchAdRequest.DEVICE_ID_EMULATOR).addTestDevice("0193CCEDD015F37B1D0454D1C0D2A625").addTestDevice("22E7281AB5904697CF4AAAC95956CCB4").addTestDevice("C73252D9541B09AF3D2FC9D362523FD8").addTestDevice("7454B16AE3D5879D91CCBE778354E884").addTestDevice("AF3AD439A079107A8C7C8A7F2DAC08BD").addTestDevice("7864359439FFCC1DD495AE9ACCDA2B0C").build());
            return;
        }
        this.f5036h.loadAd(new com.google.android.gms.ads.AdRequest.Builder().build());
    }

    void m5558g() {
        this.f5037i.f5065a.clear();
        this.f5037i.f5066b.clear();
        this.f5037i.f5065a.add(0, getString(2131230799));
        this.f5037i.f5066b.add(0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        this.f5030b.invalidateViews();
        this.f5029a.f5014w = null;
        Editor edit = getSharedPreferences("info", 0).edit();
        edit.putString("json", this.f5029a.f5014w);
        edit.apply();
    }

    void m5559h() {
        if (this.f5031c == null || !this.f5031c.isShowing()) {
            Builder builder = new Builder(this);
            builder.setTitle(getString(2131230784));
            builder.setMessage(getString(2131230783));
            builder.setPositiveButton(getString(2131230816), new C16138(this));
            builder.setNegativeButton(getString(2131230782), new C16149(this));
            this.f5031c = builder.create();
            this.f5031c.show();
        }
    }
}
