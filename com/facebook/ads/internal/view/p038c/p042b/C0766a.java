package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
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
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.af;
import com.facebook.ads.internal.p021m.ah;

/* renamed from: com.facebook.ads.internal.view.c.b.a */
public class C0766a extends C0765m {
    private final C0763a f1835b;

    /* renamed from: com.facebook.ads.internal.view.c.b.a.a */
    public static class C0763a extends RelativeLayout {
        private final String f1826a;
        private final String f1827b;
        private final String f1828c;
        private final DisplayMetrics f1829d;
        private ImageView f1830e;
        private TextView f1831f;
        private boolean f1832g;

        /* renamed from: com.facebook.ads.internal.view.c.b.a.a.1 */
        class C07581 implements OnTouchListener {
            final /* synthetic */ C0763a f1817a;

            C07581(C0763a c0763a) {
                this.f1817a = c0763a;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (!this.f1817a.f1832g) {
                    this.f1817a.m2388d();
                } else if (!TextUtils.isEmpty(this.f1817a.f1827b)) {
                    C0712u.m2306a(this.f1817a.getContext(), Uri.parse(this.f1817a.f1827b), this.f1817a.f1828c);
                }
                return true;
            }
        }

        /* renamed from: com.facebook.ads.internal.view.c.b.a.a.2 */
        class C07592 extends Animation {
            final /* synthetic */ int f1818a;
            final /* synthetic */ int f1819b;
            final /* synthetic */ C0763a f1820c;

            C07592(C0763a c0763a, int i, int i2) {
                this.f1820c = c0763a;
                this.f1818a = i;
                this.f1819b = i2;
            }

            protected void applyTransformation(float f, Transformation transformation) {
                int i = (int) (((float) this.f1818a) + (((float) (this.f1819b - this.f1818a)) * f));
                this.f1820c.getLayoutParams().width = i;
                this.f1820c.requestLayout();
                this.f1820c.f1831f.getLayoutParams().width = i - this.f1818a;
                this.f1820c.f1831f.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        }

        /* renamed from: com.facebook.ads.internal.view.c.b.a.a.3 */
        class C07623 implements AnimationListener {
            final /* synthetic */ int f1823a;
            final /* synthetic */ int f1824b;
            final /* synthetic */ C0763a f1825c;

            /* renamed from: com.facebook.ads.internal.view.c.b.a.a.3.1 */
            class C07611 implements Runnable {
                final /* synthetic */ C07623 f1822a;

                /* renamed from: com.facebook.ads.internal.view.c.b.a.a.3.1.1 */
                class C07601 extends Animation {
                    final /* synthetic */ C07611 f1821a;

                    C07601(C07611 c07611) {
                        this.f1821a = c07611;
                    }

                    protected void applyTransformation(float f, Transformation transformation) {
                        int i = (int) (((float) this.f1821a.f1822a.f1823a) + (((float) (this.f1821a.f1822a.f1824b - this.f1821a.f1822a.f1823a)) * f));
                        this.f1821a.f1822a.f1825c.getLayoutParams().width = i;
                        this.f1821a.f1822a.f1825c.requestLayout();
                        this.f1821a.f1822a.f1825c.f1831f.getLayoutParams().width = i - this.f1821a.f1822a.f1824b;
                        this.f1821a.f1822a.f1825c.f1831f.requestLayout();
                    }

                    public boolean willChangeBounds() {
                        return true;
                    }
                }

                C07611(C07623 c07623) {
                    this.f1822a = c07623;
                }

                public void run() {
                    if (this.f1822a.f1825c.f1832g) {
                        this.f1822a.f1825c.f1832g = false;
                        Animation c07601 = new C07601(this);
                        c07601.setDuration(300);
                        c07601.setFillAfter(true);
                        this.f1822a.f1825c.startAnimation(c07601);
                    }
                }
            }

            C07623(C0763a c0763a, int i, int i2) {
                this.f1825c = c0763a;
                this.f1823a = i;
                this.f1824b = i2;
            }

            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new C07611(this), 3000);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        }

        public C0763a(Context context, String str, String str2, float[] fArr, String str3) {
            super(context);
            this.f1832g = false;
            this.f1826a = str;
            this.f1827b = str2;
            this.f1828c = str3;
            this.f1829d = context.getResources().getDisplayMetrics();
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
            gradientDrawable.setAlpha(178);
            gradientDrawable.setCornerRadii(new float[]{fArr[0] * this.f1829d.density, fArr[0] * this.f1829d.density, fArr[1] * this.f1829d.density, fArr[1] * this.f1829d.density, fArr[2] * this.f1829d.density, fArr[2] * this.f1829d.density, fArr[3] * this.f1829d.density, fArr[3] * this.f1829d.density});
            if (VERSION.SDK_INT >= 16) {
                setBackground(gradientDrawable);
            } else {
                setBackgroundDrawable(gradientDrawable);
            }
            m2381a();
            m2385b();
            m2387c();
            setMinimumWidth(Math.round(20.0f * this.f1829d.density));
            setMinimumHeight(Math.round(18.0f * this.f1829d.density));
        }

        private void m2381a() {
            setOnTouchListener(new C07581(this));
        }

        private void m2385b() {
            Context context = getContext();
            this.f1830e = new ImageView(context);
            this.f1830e.setImageBitmap(ah.m2153a(context, af.IC_AD_CHOICES));
            addView(this.f1830e);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(this.f1829d.density * 16.0f), Math.round(this.f1829d.density * 16.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(15, -1);
            layoutParams.setMargins(Math.round(4.0f * this.f1829d.density), Math.round(this.f1829d.density * 2.0f), Math.round(this.f1829d.density * 2.0f), Math.round(this.f1829d.density * 2.0f));
            this.f1830e.setLayoutParams(layoutParams);
        }

        private void m2387c() {
            this.f1831f = new TextView(getContext());
            addView(this.f1831f);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = 0;
            layoutParams.leftMargin = (int) (20.0f * this.f1829d.density);
            layoutParams.addRule(9);
            layoutParams.addRule(15, -1);
            this.f1831f.setLayoutParams(layoutParams);
            this.f1831f.setSingleLine();
            this.f1831f.setText(this.f1826a);
            this.f1831f.setTextSize(10.0f);
            this.f1831f.setTextColor(-4341303);
        }

        private void m2388d() {
            Paint paint = new Paint();
            paint.setTextSize(this.f1831f.getTextSize());
            int round = Math.round(paint.measureText(this.f1826a) + (4.0f * this.f1829d.density));
            int width = getWidth();
            round += width;
            this.f1832g = true;
            Animation c07592 = new C07592(this, width, round);
            c07592.setAnimationListener(new C07623(this, round, width));
            c07592.setDuration(300);
            c07592.setFillAfter(true);
            startAnimation(c07592);
        }
    }

    public C0766a(Context context, String str, String str2, float[] fArr) {
        super(context);
        this.f1835b = new C0763a(context, "AdChoices", str, fArr, str2);
        addView(this.f1835b);
    }
}
