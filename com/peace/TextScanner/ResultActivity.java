package com.peace.TextScanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.plus.PlusOneButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import java.util.HashMap;
import java.util.Map;

public class ResultActivity extends Activity {
    Globals f5045a;
    AlertDialog f5046b;
    EvaluateDialog f5047c;
    PlusOneButton f5048d;
    AdView f5049e;
    FirebaseRemoteConfig f5050f;
    boolean f5051g;
    InterstitialAd f5052h;

    /* renamed from: com.peace.TextScanner.ResultActivity.1 */
    class C16161 implements OnClickListener {
        final /* synthetic */ ResultActivity f5038a;

        C16161(ResultActivity resultActivity) {
            this.f5038a = resultActivity;
        }

        public void onClick(View view) {
            this.f5038a.m5561b();
        }
    }

    /* renamed from: com.peace.TextScanner.ResultActivity.2 */
    class C16172 implements OnClickListener {
        final /* synthetic */ ResultActivity f5039a;

        C16172(ResultActivity resultActivity) {
            this.f5039a = resultActivity;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", this.f5039a.f5045a.f5012u);
            intent.setType("text/plain");
            this.f5039a.startActivity(intent);
        }
    }

    /* renamed from: com.peace.TextScanner.ResultActivity.3 */
    class C16183 implements OnClickListener {
        final /* synthetic */ ResultActivity f5040a;

        C16183(ResultActivity resultActivity) {
            this.f5040a = resultActivity;
        }

        public void onClick(View view) {
            if (!this.f5040a.m5564e()) {
                this.f5040a.startActivity(new Intent(this.f5040a, CameraActivity.class));
            }
        }
    }

    /* renamed from: com.peace.TextScanner.ResultActivity.4 */
    class C16194 implements OnClickListener {
        final /* synthetic */ ResultActivity f5041a;

        C16194(ResultActivity resultActivity) {
            this.f5041a = resultActivity;
        }

        public void onClick(View view) {
            this.f5041a.f5047c = new EvaluateDialog(view.getContext(), this.f5041a.f5046b);
            this.f5041a.f5047c.m5569a(view.getContext());
        }
    }

    /* renamed from: com.peace.TextScanner.ResultActivity.5 */
    class C16205 implements OnCompleteListener<Void> {
        final /* synthetic */ ResultActivity f5042a;

        C16205(ResultActivity resultActivity) {
            this.f5042a = resultActivity;
        }

        public void onComplete(@NonNull Task<Void> task) {
            try {
                if (task.isSuccessful()) {
                    this.f5042a.f5050f.activateFetched();
                    this.f5042a.f5045a.f5015x = (int) this.f5042a.f5050f.getLong("interstitialAdInterval");
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.peace.TextScanner.ResultActivity.6 */
    class C16216 implements DialogInterface.OnClickListener {
        final /* synthetic */ ResultActivity f5043a;

        C16216(ResultActivity resultActivity) {
            this.f5043a = resultActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.f5043a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f5043a.getString(2131230803))));
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.peace.TextScanner.ResultActivity.7 */
    class C16227 extends AdListener {
        final /* synthetic */ ResultActivity f5044a;

        C16227(ResultActivity resultActivity) {
            this.f5044a = resultActivity;
        }

        public void onAdClosed() {
            if (this.f5044a.f5051g) {
                this.f5044a.f5051g = false;
                this.f5044a.finish();
                return;
            }
            this.f5044a.startActivity(new Intent(this.f5044a, CameraActivity.class));
        }
    }

    public ResultActivity() {
        this.f5051g = false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        this.f5045a = (Globals) getApplication();
        setContentView(2130903069);
        ((TextView) findViewById(2131624086)).setText(this.f5045a.f5012u);
        ((ImageButton) findViewById(2131624080)).setOnClickListener(new C16161(this));
        ((FloatingActionButton) findViewById(2131624087)).setOnClickListener(new C16172(this));
        ((FloatingActionButton) findViewById(2131624082)).setOnClickListener(new C16183(this));
        ((FloatingActionButton) findViewById(2131624083)).setOnClickListener(new C16194(this));
        m5562c();
        m5563d();
        m5565f();
        m5560a();
    }

    void m5560a() {
        int i = 0;
        try {
            this.f5050f = FirebaseRemoteConfig.getInstance();
            this.f5050f.setConfigSettings(new Builder().setDeveloperModeEnabled(false).build());
            Map hashMap = new HashMap();
            hashMap.put("interstitialAdInterval", Integer.valueOf(2));
            this.f5050f.setDefaults(hashMap);
            if (!this.f5050f.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
                i = 3600;
            }
            this.f5050f.fetch((long) i).addOnCompleteListener(new C16205(this));
        } catch (Throwable th) {
        }
    }

    void m5561b() {
        if (this.f5046b == null || !this.f5046b.isShowing()) {
            String str = AdRequest.VERSION;
            try {
                str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (Throwable th) {
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(2131230775));
            builder.setMessage(getString(2131230776) + "\n\n" + getString(2131230815) + ": " + str + "\n");
            builder.setPositiveButton(getString(2131230801), null);
            builder.setNeutralButton(getString(2131230802), new C16216(this));
            this.f5046b = builder.create();
            this.f5046b.show();
        }
    }

    void m5562c() {
        this.f5048d = (PlusOneButton) findViewById(2131624079);
        this.f5048d.initialize("https://market.android.com/details?id=com.peace.TextScanner", 1);
    }

    protected void onResume() {
        super.onResume();
        this.f5049e.resume();
    }

    protected void onPause() {
        super.onPause();
        this.f5049e.pause();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f5049e.destroy();
    }

    void m5563d() {
        try {
            this.f5049e = (AdView) findViewById(2131624063);
            if (getSharedPreferences("info", 0).getInt("adBlockCount", 0) > 0) {
                return;
            }
            if (this.f5045a.f4991A) {
                this.f5049e.loadAd(new com.google.android.gms.ads.AdRequest.Builder().addTestDevice(SearchAdRequest.DEVICE_ID_EMULATOR).addTestDevice("0193CCEDD015F37B1D0454D1C0D2A625").addTestDevice("22E7281AB5904697CF4AAAC95956CCB4").addTestDevice("C73252D9541B09AF3D2FC9D362523FD8").addTestDevice("7454B16AE3D5879D91CCBE778354E884").addTestDevice("AF3AD439A079107A8C7C8A7F2DAC08BD").addTestDevice("7864359439FFCC1DD495AE9ACCDA2B0C").build());
                return;
            }
            this.f5049e.loadAd(new com.google.android.gms.ads.AdRequest.Builder().build());
        } catch (Throwable th) {
        }
    }

    public void onBackPressed() {
        this.f5051g = true;
        if (!m5564e()) {
            this.f5051g = false;
            super.onBackPressed();
        }
    }

    boolean m5564e() {
        if (getSharedPreferences("info", 0).getInt("adBlockCount", 0) > 0) {
            return false;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("info", 0);
        int i = sharedPreferences.getInt("readCount", 0);
        if (i < sharedPreferences.getInt("interstitialCount", 0) + this.f5045a.f5015x || !this.f5052h.isLoaded()) {
            return false;
        }
        this.f5052h.show();
        Editor edit = sharedPreferences.edit();
        edit.putInt("interstitialCount", i);
        edit.apply();
        return true;
    }

    void m5565f() {
        this.f5052h = new InterstitialAd(this);
        this.f5052h.setAdUnitId("ca-app-pub-6960107762880974/9199372964");
        this.f5052h.setAdListener(new C16227(this));
        m5566g();
    }

    void m5566g() {
        if (this.f5045a.f4991A) {
            this.f5052h.loadAd(new com.google.android.gms.ads.AdRequest.Builder().addTestDevice(SearchAdRequest.DEVICE_ID_EMULATOR).addTestDevice("0193CCEDD015F37B1D0454D1C0D2A625").addTestDevice("22E7281AB5904697CF4AAAC95956CCB4").addTestDevice("C73252D9541B09AF3D2FC9D362523FD8").addTestDevice("7454B16AE3D5879D91CCBE778354E884").addTestDevice("AF3AD439A079107A8C7C8A7F2DAC08BD").addTestDevice("7864359439FFCC1DD495AE9ACCDA2B0C").build());
            return;
        }
        this.f5052h.loadAd(new com.google.android.gms.ads.AdRequest.Builder().build());
    }
}
