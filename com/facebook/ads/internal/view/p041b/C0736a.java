package com.facebook.ads.internal.view.p041b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p023a.C0449a;
import com.facebook.ads.internal.p023a.C0450b;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0738a;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;

/* renamed from: com.facebook.ads.internal.view.b.a */
public class C0736a extends RelativeLayout {
    private final String f1804a;
    private C0827j f1805b;
    private final Paint f1806c;
    private final RectF f1807d;

    /* renamed from: com.facebook.ads.internal.view.b.a.1 */
    class C07351 implements OnClickListener {
        final /* synthetic */ C0736a f1803a;

        C07351(C0736a c0736a) {
            this.f1803a = c0736a;
        }

        public void onClick(View view) {
            try {
                Uri parse = Uri.parse(this.f1803a.f1804a);
                this.f1803a.f1805b.getEventBus().m1845a(new C0738a(parse));
                C0449a a = C0450b.m1111a(this.f1803a.getContext(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, parse, new HashMap());
                if (a != null) {
                    a.m1110b();
                }
            } catch (Throwable e) {
                Log.e(String.valueOf(C0736a.class), "Error while opening " + this.f1803a.f1804a, e);
            } catch (Throwable e2) {
                Log.e(String.valueOf(C0736a.class), "Error executing action", e2);
            }
        }
    }

    public C0736a(Context context, String str, String str2, int i, C0827j c0827j) {
        super(context);
        this.f1804a = str;
        this.f1805b = c0827j;
        View textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.setText(str2);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        addView(textView);
        this.f1806c = new Paint();
        this.f1806c.setStyle(Style.FILL);
        this.f1806c.setColor(i);
        this.f1807d = new RectF();
        setBackgroundColor(0);
        setOnClickListener(new C07351(this));
    }

    protected void onDraw(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f1807d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        canvas.drawRoundRect(this.f1807d, 10.0f * f, f * 10.0f, this.f1806c);
        super.onDraw(canvas);
    }
}
