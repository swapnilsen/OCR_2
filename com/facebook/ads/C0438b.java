package com.facebook.ads;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.C0869n.C0864a;
import com.facebook.ads.internal.p021m.C0712u;

/* renamed from: com.facebook.ads.b */
public class C0438b extends RelativeLayout {
    private final Context f730a;
    private final C0869n f731b;
    private final DisplayMetrics f732c;
    private boolean f733d;
    private TextView f734e;
    private String f735f;

    /* renamed from: com.facebook.ads.b.1 */
    class C04331 implements OnTouchListener {
        final /* synthetic */ C0869n f720a;
        final /* synthetic */ C0438b f721b;

        C04331(C0438b c0438b, C0869n c0869n) {
            this.f721b = c0438b;
            this.f720a = c0869n;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!this.f721b.f733d) {
                this.f721b.m1040a();
            } else if (!TextUtils.isEmpty(this.f721b.f731b.m2728p())) {
                C0712u.m2306a(this.f721b.f730a, Uri.parse(this.f721b.f731b.m2728p()), this.f720a.m2735w());
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.b.2 */
    class C04342 extends Animation {
        final /* synthetic */ int f722a;
        final /* synthetic */ int f723b;
        final /* synthetic */ C0438b f724c;

        C04342(C0438b c0438b, int i, int i2) {
            this.f724c = c0438b;
            this.f722a = i;
            this.f723b = i2;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            int i = (int) (((float) this.f722a) + (((float) (this.f723b - this.f722a)) * f));
            this.f724c.getLayoutParams().width = i;
            this.f724c.requestLayout();
            this.f724c.f734e.getLayoutParams().width = i - this.f722a;
            this.f724c.f734e.requestLayout();
        }

        public boolean willChangeBounds() {
            return true;
        }
    }

    /* renamed from: com.facebook.ads.b.3 */
    class C04373 implements AnimationListener {
        final /* synthetic */ int f727a;
        final /* synthetic */ int f728b;
        final /* synthetic */ C0438b f729c;

        /* renamed from: com.facebook.ads.b.3.1 */
        class C04361 implements Runnable {
            final /* synthetic */ C04373 f726a;

            /* renamed from: com.facebook.ads.b.3.1.1 */
            class C04351 extends Animation {
                final /* synthetic */ C04361 f725a;

                C04351(C04361 c04361) {
                    this.f725a = c04361;
                }

                protected void applyTransformation(float f, Transformation transformation) {
                    int i = (int) (((float) this.f725a.f726a.f727a) + (((float) (this.f725a.f726a.f728b - this.f725a.f726a.f727a)) * f));
                    this.f725a.f726a.f729c.getLayoutParams().width = i;
                    this.f725a.f726a.f729c.requestLayout();
                    this.f725a.f726a.f729c.f734e.getLayoutParams().width = i - this.f725a.f726a.f728b;
                    this.f725a.f726a.f729c.f734e.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            }

            C04361(C04373 c04373) {
                this.f726a = c04373;
            }

            public void run() {
                if (this.f726a.f729c.f733d) {
                    this.f726a.f729c.f733d = false;
                    Animation c04351 = new C04351(this);
                    c04351.setDuration(300);
                    c04351.setFillAfter(true);
                    this.f726a.f729c.startAnimation(c04351);
                }
            }
        }

        C04373(C0438b c0438b, int i, int i2) {
            this.f729c = c0438b;
            this.f727a = i;
            this.f728b = i2;
        }

        public void onAnimationEnd(Animation animation) {
            new Handler().postDelayed(new C04361(this), 3000);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public C0438b(Context context, C0869n c0869n, boolean z) {
        super(context);
        this.f733d = false;
        this.f730a = context;
        this.f731b = c0869n;
        this.f732c = this.f730a.getResources().getDisplayMetrics();
        if (!this.f731b.m2716d() || this.f731b.m2705a().m1213h()) {
            this.f735f = this.f731b.m2729q();
            if (TextUtils.isEmpty(this.f735f)) {
                this.f735f = "AdChoices";
            }
            C0864a o = this.f731b.m2727o();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            setOnTouchListener(new C04331(this, c0869n));
            this.f734e = new TextView(this.f730a);
            addView(this.f734e);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (!z || o == null) {
                this.f733d = true;
            } else {
                layoutParams2.addRule(11, m1039a(o).getId());
                layoutParams2.width = 0;
                layoutParams.width = Math.round(((float) (o.m2666b() + 4)) * this.f732c.density);
                layoutParams.height = Math.round(((float) (o.m2667c() + 2)) * this.f732c.density);
                this.f733d = false;
            }
            setLayoutParams(layoutParams);
            layoutParams2.addRule(15, -1);
            this.f734e.setLayoutParams(layoutParams2);
            this.f734e.setSingleLine();
            this.f734e.setText(this.f735f);
            this.f734e.setTextSize(10.0f);
            this.f734e.setTextColor(-4341303);
            return;
        }
        setVisibility(8);
    }

    private ImageView m1039a(C0864a c0864a) {
        ImageView imageView = new ImageView(this.f730a);
        addView(imageView);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(((float) c0864a.m2666b()) * this.f732c.density), Math.round(((float) c0864a.m2667c()) * this.f732c.density));
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(Math.round(4.0f * this.f732c.density), Math.round(this.f732c.density * 2.0f), Math.round(this.f732c.density * 2.0f), Math.round(this.f732c.density * 2.0f));
        imageView.setLayoutParams(layoutParams);
        C0869n.m2682a(c0864a, imageView);
        return imageView;
    }

    private void m1040a() {
        Paint paint = new Paint();
        paint.setTextSize(this.f734e.getTextSize());
        int round = Math.round(paint.measureText(this.f735f) + (4.0f * this.f732c.density));
        int width = getWidth();
        round += width;
        this.f733d = true;
        Animation c04342 = new C04342(this, width, round);
        c04342.setAnimationListener(new C04373(this, round, width));
        c04342.setDuration(300);
        c04342.setFillAfter(true);
        startAnimation(c04342);
    }
}
