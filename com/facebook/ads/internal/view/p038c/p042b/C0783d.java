package com.facebook.ads.internal.view.p038c.p042b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.internal.p025h.C0492s;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0740c;
import com.facebook.ads.internal.view.p038c.p039a.C0745h;
import com.facebook.ads.internal.view.p038c.p039a.C0746i;
import com.facebook.ads.internal.view.p038c.p039a.C0747j;
import com.facebook.ads.internal.view.p038c.p039a.C0748k;
import com.facebook.ads.internal.view.p038c.p039a.C0754r;

@TargetApi(12)
/* renamed from: com.facebook.ads.internal.view.c.b.d */
public class C0783d implements C0764l {
    private final Handler f1860a;
    private View f1861b;
    @Nullable
    private C0782a f1862c;
    @Nullable
    private C0827j f1863d;
    private final C0746i f1864e;
    private final C0748k f1865f;
    private final C0740c f1866g;
    private final C0492s<C0754r> f1867h;

    /* renamed from: com.facebook.ads.internal.view.c.b.d.1 */
    class C07741 extends C0746i {
        final /* synthetic */ C0783d f1848a;

        C07741(C0783d c0783d) {
            this.f1848a = c0783d;
        }

        public void m2408a(C0745h c0745h) {
            this.f1848a.f1860a.removeCallbacksAndMessages(null);
            this.f1848a.f1861b.clearAnimation();
            this.f1848a.f1861b.setAlpha(1.0f);
            this.f1848a.f1861b.setVisibility(0);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.d.2 */
    class C07762 extends C0748k {
        final /* synthetic */ C0783d f1850a;

        /* renamed from: com.facebook.ads.internal.view.c.b.d.2.1 */
        class C07751 extends AnimatorListenerAdapter {
            final /* synthetic */ C07762 f1849a;

            C07751(C07762 c07762) {
                this.f1849a = c07762;
            }

            public void onAnimationEnd(Animator animator) {
                this.f1849a.f1850a.f1861b.setVisibility(8);
            }
        }

        C07762(C0783d c0783d) {
            this.f1850a = c0783d;
        }

        public void m2410a(C0747j c0747j) {
            if (this.f1850a.f1862c == C0782a.FADE_OUT_ON_PLAY) {
                this.f1850a.f1862c = null;
                this.f1850a.f1861b.animate().alpha(0.0f).setDuration(2000).setListener(new C07751(this));
                return;
            }
            this.f1850a.f1860a.removeCallbacksAndMessages(null);
            this.f1850a.f1861b.clearAnimation();
            this.f1850a.f1861b.setAlpha(0.0f);
            this.f1850a.f1861b.setVisibility(8);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.d.3 */
    class C07773 extends C0740c {
        final /* synthetic */ C0783d f1851a;

        C07773(C0783d c0783d) {
            this.f1851a = c0783d;
        }

        public void m2412a(C0739b c0739b) {
            if (this.f1851a.f1862c != C0782a.INVSIBLE) {
                this.f1851a.f1861b.setAlpha(1.0f);
                this.f1851a.f1861b.setVisibility(0);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.d.4 */
    class C07814 extends C0492s<C0754r> {
        final /* synthetic */ C0783d f1855a;

        /* renamed from: com.facebook.ads.internal.view.c.b.d.4.1 */
        class C07801 extends AnimatorListenerAdapter {
            final /* synthetic */ C07814 f1854a;

            /* renamed from: com.facebook.ads.internal.view.c.b.d.4.1.1 */
            class C07791 implements Runnable {
                final /* synthetic */ C07801 f1853a;

                /* renamed from: com.facebook.ads.internal.view.c.b.d.4.1.1.1 */
                class C07781 extends AnimatorListenerAdapter {
                    final /* synthetic */ C07791 f1852a;

                    C07781(C07791 c07791) {
                        this.f1852a = c07791;
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.f1852a.f1853a.f1854a.f1855a.f1861b.setVisibility(8);
                    }
                }

                C07791(C07801 c07801) {
                    this.f1853a = c07801;
                }

                public void run() {
                    this.f1853a.f1854a.f1855a.f1861b.animate().alpha(0.0f).setDuration(500).setListener(new C07781(this));
                }
            }

            C07801(C07814 c07814) {
                this.f1854a = c07814;
            }

            public void onAnimationEnd(Animator animator) {
                this.f1854a.f1855a.f1860a.postDelayed(new C07791(this), 2000);
            }
        }

        C07814(C0783d c0783d) {
            this.f1855a = c0783d;
        }

        public Class<C0754r> m2413a() {
            return C0754r.class;
        }

        public void m2415a(C0754r c0754r) {
            if (this.f1855a.f1863d != null && c0754r.m2380b().getAction() == 0) {
                this.f1855a.f1860a.removeCallbacksAndMessages(null);
                this.f1855a.f1861b.setVisibility(0);
                this.f1855a.f1861b.animate().alpha(1.0f).setDuration(500).setListener(new C07801(this));
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.d.a */
    public enum C0782a {
        VISIBLE,
        INVSIBLE,
        FADE_OUT_ON_PLAY
    }

    public C0783d(View view, C0782a c0782a) {
        this.f1864e = new C07741(this);
        this.f1865f = new C07762(this);
        this.f1866g = new C07773(this);
        this.f1867h = new C07814(this);
        this.f1861b = view;
        this.f1862c = c0782a;
        this.f1860a = new Handler();
        this.f1861b.clearAnimation();
        if (c0782a == C0782a.INVSIBLE) {
            this.f1861b.setAlpha(0.0f);
            this.f1861b.setVisibility(8);
            return;
        }
        this.f1861b.setAlpha(1.0f);
        this.f1861b.setVisibility(0);
    }

    public void m2421a(View view, C0782a c0782a) {
        this.f1861b = view;
        this.f1862c = c0782a;
        this.f1861b.clearAnimation();
        if (c0782a == C0782a.INVSIBLE) {
            this.f1861b.setAlpha(0.0f);
            this.f1861b.setVisibility(8);
            return;
        }
        this.f1861b.setAlpha(1.0f);
        this.f1861b.setVisibility(0);
    }

    public void m2422a(C0827j c0827j) {
        c0827j.getEventBus().m1846a(this.f1864e);
        c0827j.getEventBus().m1846a(this.f1865f);
        c0827j.getEventBus().m1846a(this.f1867h);
        c0827j.getEventBus().m1846a(this.f1866g);
        this.f1863d = c0827j;
    }
}
