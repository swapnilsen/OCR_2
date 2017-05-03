package com.peace.TextScanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;

/* renamed from: com.peace.TextScanner.b */
public class EvaluateDialog {
    Context f5060a;
    AlertDialog f5061b;
    SharedPreferences f5062c;
    Activity f5063d;
    Globals f5064e;

    /* renamed from: com.peace.TextScanner.b.1 */
    class EvaluateDialog implements OnClickListener {
        final /* synthetic */ EvaluateDialog f5056a;

        EvaluateDialog(EvaluateDialog evaluateDialog) {
            this.f5056a = evaluateDialog;
        }

        public void onClick(View view) {
            this.f5056a.f5064e.f5011t.send(new EventBuilder().setCategory("RateDialog").setAction("Positive").build());
            this.f5056a.f5061b.dismiss();
            this.f5056a.m5568a();
        }
    }

    /* renamed from: com.peace.TextScanner.b.2 */
    class EvaluateDialog implements OnClickListener {
        final /* synthetic */ EvaluateDialog f5057a;

        EvaluateDialog(EvaluateDialog evaluateDialog) {
            this.f5057a = evaluateDialog;
        }

        public void onClick(View view) {
            this.f5057a.f5064e.f5011t.send(new EventBuilder().setCategory("RateDialog").setAction("Negative").build());
            Editor edit = this.f5057a.f5062c.edit();
            edit.putBoolean("isEvaluate", true);
            edit.commit();
            this.f5057a.f5061b.dismiss();
        }
    }

    /* renamed from: com.peace.TextScanner.b.3 */
    class EvaluateDialog implements OnClickListener {
        final /* synthetic */ EvaluateDialog f5058a;

        EvaluateDialog(EvaluateDialog evaluateDialog) {
            this.f5058a = evaluateDialog;
        }

        public void onClick(View view) {
            this.f5058a.f5064e.f5011t.send(new EventBuilder().setCategory("RateDialog").setAction("Report").build());
            Editor edit = this.f5058a.f5062c.edit();
            edit.putBoolean("isEvaluate", true);
            edit.commit();
            this.f5058a.f5061b.dismiss();
            this.f5058a.m5570b();
        }
    }

    /* renamed from: com.peace.TextScanner.b.4 */
    class EvaluateDialog implements OnClickListener {
        final /* synthetic */ EvaluateDialog f5059a;

        EvaluateDialog(EvaluateDialog evaluateDialog) {
            this.f5059a = evaluateDialog;
        }

        public void onClick(View view) {
            this.f5059a.f5064e.f5011t.send(new EventBuilder().setCategory("RateDialog").setAction("Neutral").build());
            Editor edit = this.f5059a.f5062c.edit();
            edit.putInt("count", 0);
            edit.putLong("lastEvaluateDate", System.currentTimeMillis());
            edit.commit();
            this.f5059a.f5061b.dismiss();
        }
    }

    public EvaluateDialog(Context context, AlertDialog alertDialog) {
        this.f5060a = context;
        this.f5061b = alertDialog;
        this.f5063d = (Activity) context;
        this.f5064e = (Globals) this.f5063d.getApplication();
        Context context2 = this.f5060a;
        this.f5062c = this.f5060a.getSharedPreferences("info", 0);
    }

    void m5568a() {
        try {
            Editor edit = this.f5062c.edit();
            edit.putBoolean("isEvaluate", true);
            edit.apply();
            this.f5060a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.peace.TextScanner")));
        } catch (Throwable th) {
        }
    }

    void m5570b() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/Gmail");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{"tmp7700@gmail.com"});
            intent.putExtra("android.intent.extra.SUBJECT", "[" + this.f5060a.getString(2131230776) + "] " + this.f5060a.getString(2131230795));
            intent.putExtra("android.intent.extra.TEXT", "[" + this.f5060a.getString(2131230795) + "]\n" + this.f5060a.getString(2131230796) + "\n\n\n\n\n" + "[Device]\n" + "Vendor: " + Build.MANUFACTURER + "\n" + "Model: " + Build.DEVICE + "\n" + "Android: " + VERSION.RELEASE + "\n" + "Version: " + this.f5060a.getPackageManager().getPackageInfo(this.f5060a.getPackageName(), 0).versionCode + " ");
            intent.setPackage("com.google.android.gm");
            this.f5060a.startActivity(intent);
        } catch (Throwable th) {
        }
    }

    public void m5571c() {
        if (!this.f5062c.getBoolean("isEvaluate", false)) {
            int i = this.f5062c.getInt("count", 0);
            int currentTimeMillis = (int) ((System.currentTimeMillis() - this.f5062c.getLong("lastEvaluateDate", 0)) / 86400000);
            int i2 = this.f5062c.getInt("uncaughtException", 0);
            if (i >= 5 && currentTimeMillis >= 0 && i2 <= 10) {
                m5569a(this.f5060a);
            }
        }
    }

    public void m5569a(Context context) {
        if (this.f5061b == null || !this.f5061b.isShowing()) {
            Context context2 = this.f5060a;
            Context context3 = this.f5060a;
            View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(2130903086, (ViewGroup) this.f5063d.findViewById(2131624102));
            Builder builder = new Builder(context);
            builder.setView(inflate);
            this.f5061b = builder.create();
            ((Button) inflate.findViewById(2131624104)).setOnClickListener(new EvaluateDialog(this));
            ((Button) inflate.findViewById(2131624105)).setOnClickListener(new EvaluateDialog(this));
            ((Button) inflate.findViewById(2131624106)).setOnClickListener(new EvaluateDialog(this));
            ((Button) inflate.findViewById(2131624107)).setOnClickListener(new EvaluateDialog(this));
            this.f5064e.f5011t.send(new EventBuilder().setCategory("RateDialog").setAction("Open").build());
            this.f5061b.show();
        }
    }
}
