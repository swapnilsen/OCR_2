package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0740c;
import com.facebook.ads.internal.view.p038c.p039a.C0745h;
import com.facebook.ads.internal.view.p038c.p039a.C0746i;
import com.facebook.ads.internal.view.p038c.p039a.C0747j;
import com.facebook.ads.internal.view.p038c.p039a.C0748k;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.view.c.b.b */
public class C0771b extends C0765m implements OnAudioFocusChangeListener {
    private WeakReference<OnAudioFocusChangeListener> f1840b;
    private final C0740c f1841c;
    private final C0746i f1842d;
    private final C0748k f1843e;

    /* renamed from: com.facebook.ads.internal.view.c.b.b.1 */
    class C07671 extends C0740c {
        final /* synthetic */ C0771b f1836a;

        C07671(C0771b c0771b) {
            this.f1836a = c0771b;
        }

        public void m2394a(C0739b c0739b) {
            ((AudioManager) this.f1836a.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.f1836a.f1840b == null ? null : (OnAudioFocusChangeListener) this.f1836a.f1840b.get());
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.b.2 */
    class C07682 extends C0746i {
        final /* synthetic */ C0771b f1837a;

        C07682(C0771b c0771b) {
            this.f1837a = c0771b;
        }

        public void m2396a(C0745h c0745h) {
            ((AudioManager) this.f1837a.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.f1837a.f1840b == null ? null : (OnAudioFocusChangeListener) this.f1837a.f1840b.get());
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.b.3 */
    class C07703 extends C0748k {
        final /* synthetic */ C0771b f1839a;

        /* renamed from: com.facebook.ads.internal.view.c.b.b.3.1 */
        class C07691 implements OnAudioFocusChangeListener {
            final /* synthetic */ C07703 f1838a;

            C07691(C07703 c07703) {
                this.f1838a = c07703;
            }

            public void onAudioFocusChange(int i) {
                if (this.f1838a.f1839a.getVideoView() != null && i <= 0) {
                    this.f1838a.f1839a.getVideoView().m2554e();
                }
            }
        }

        C07703(C0771b c0771b) {
            this.f1839a = c0771b;
        }

        public void m2398a(C0747j c0747j) {
            if (this.f1839a.f1840b == null || this.f1839a.f1840b.get() == null) {
                this.f1839a.f1840b = new WeakReference(new C07691(this));
            }
            ((AudioManager) this.f1839a.getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus((OnAudioFocusChangeListener) this.f1839a.f1840b.get(), 3, 1);
        }
    }

    public C0771b(Context context) {
        super(context);
        this.f1840b = null;
        this.f1841c = new C07671(this);
        this.f1842d = new C07682(this);
        this.f1843e = new C07703(this);
    }

    protected void a_(C0827j c0827j) {
        c0827j.getEventBus().m1846a(this.f1843e);
        c0827j.getEventBus().m1846a(this.f1841c);
        c0827j.getEventBus().m1846a(this.f1842d);
        super.a_(c0827j);
    }

    public void onAudioFocusChange(int i) {
        if (getVideoView() != null && i <= 0) {
            getVideoView().m2554e();
        }
    }

    protected void onDetachedFromWindow() {
        ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.f1840b == null ? null : (OnAudioFocusChangeListener) this.f1840b.get());
        super.onDetachedFromWindow();
    }
}
