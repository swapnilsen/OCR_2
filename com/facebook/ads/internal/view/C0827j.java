package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.C0649j;
import com.facebook.ads.internal.p021m.C0689j.C0697a;
import com.facebook.ads.internal.p021m.C0699k;
import com.facebook.ads.internal.p021m.ak;
import com.facebook.ads.internal.p021m.ak.C0672a;
import com.facebook.ads.internal.p025h.C0492s;
import com.facebook.ads.internal.p025h.C0590q;
import com.facebook.ads.internal.p025h.C0591r;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0741d;
import com.facebook.ads.internal.view.p038c.p039a.C0745h;
import com.facebook.ads.internal.view.p038c.p039a.C0747j;
import com.facebook.ads.internal.view.p038c.p039a.C0749l;
import com.facebook.ads.internal.view.p038c.p039a.C0750n;
import com.facebook.ads.internal.view.p038c.p039a.C0752p;
import com.facebook.ads.internal.view.p038c.p039a.C0753q;
import com.facebook.ads.internal.view.p038c.p039a.C0754r;
import com.facebook.ads.internal.view.p038c.p039a.C0755s;
import com.facebook.ads.internal.view.p038c.p039a.C0756u;
import com.facebook.ads.internal.view.p038c.p039a.C0757v;
import com.facebook.ads.internal.view.p038c.p042b.C0764l;
import com.facebook.ads.internal.view.p038c.p042b.C0765m;
import com.facebook.ads.internal.view.p038c.p043c.C0811c;
import com.facebook.ads.internal.view.p038c.p043c.C0812a;
import com.facebook.ads.internal.view.p038c.p043c.C0815b;
import com.facebook.ads.internal.view.p038c.p043c.C0816d;
import com.facebook.ads.internal.view.p038c.p043c.C0817e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.view.j */
public class C0827j extends RelativeLayout implements C0697a, C0817e {
    private static final C0749l f2026i;
    private static final C0741d f2027j;
    private static final C0739b f2028k;
    private static final C0750n f2029l;
    private static final C0753q f2030m;
    private static final C0745h f2031n;
    private static final C0747j f2032o;
    private static final C0755s f2033p;
    private static final C0757v f2034q;
    private static final C0756u f2035r;
    private final C0591r<C0492s, C0590q> f2036a;
    protected final C0811c f2037b;
    private final List<C0764l> f2038c;
    private boolean f2039d;
    @Deprecated
    private boolean f2040e;
    @Deprecated
    private boolean f2041f;
    private C0699k f2042g;
    private boolean f2043h;
    private final Handler f2044s;
    private final OnTouchListener f2045t;

    /* renamed from: com.facebook.ads.internal.view.j.1 */
    class C08421 implements Runnable {
        final /* synthetic */ C0827j f2102a;

        C08421(C0827j c0827j) {
            this.f2102a = c0827j;
        }

        public void run() {
            if (!this.f2102a.f2039d) {
                this.f2102a.f2036a.m1845a(C0827j.f2029l);
                this.f2102a.f2044s.postDelayed(this, 250);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.j.2 */
    class C08432 implements OnTouchListener {
        final /* synthetic */ C0827j f2103a;

        C08432(C0827j c0827j) {
            this.f2103a = c0827j;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f2103a.f2036a.m1845a(new C0754r(view, motionEvent));
            return true;
        }
    }

    static {
        f2026i = new C0749l();
        f2027j = new C0741d();
        f2028k = new C0739b();
        f2029l = new C0750n();
        f2030m = new C0753q();
        f2031n = new C0745h();
        f2032o = new C0747j();
        f2033p = new C0755s();
        f2034q = new C0757v();
        f2035r = new C0756u();
    }

    public C0827j(@Nullable Context context) {
        this(context, null);
    }

    public C0827j(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0827j(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2038c = new ArrayList();
        this.f2039d = false;
        this.f2040e = false;
        this.f2041f = false;
        this.f2042g = C0699k.UNKNOWN;
        this.f2043h = false;
        this.f2045t = new C08432(this);
        if (C0649j.m2051a(getContext())) {
            this.f2037b = new C0812a(getContext());
        } else {
            this.f2037b = new C0815b(getContext());
        }
        this.f2037b.setRequestedVolume(1.0f);
        this.f2037b.setVideoStateChangeListener(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView((View) this.f2037b, layoutParams);
        this.f2044s = new Handler();
        this.f2036a = new C0591r();
        setOnTouchListener(this.f2045t);
    }

    public void m2546a(int i) {
        this.f2037b.seekTo(i);
    }

    public void m2547a(int i, int i2) {
        this.f2036a.m1845a(new C0752p(i, i2));
    }

    public void m2548a(C0764l c0764l) {
        this.f2038c.add(c0764l);
    }

    public void m2549a(C0816d c0816d) {
        if (c0816d == C0816d.PREPARED) {
            this.f2036a.m1845a(f2026i);
            if (m2558i() && !this.f2039d) {
                m2553d();
            }
        } else if (c0816d == C0816d.ERROR) {
            this.f2039d = true;
            this.f2036a.m1845a(f2027j);
        } else if (c0816d == C0816d.PLAYBACK_COMPLETED) {
            this.f2039d = true;
            this.f2044s.removeCallbacksAndMessages(null);
            this.f2036a.m1845a(f2028k);
        } else if (c0816d == C0816d.STARTED) {
            this.f2036a.m1845a(f2032o);
            this.f2044s.removeCallbacksAndMessages(null);
            this.f2044s.postDelayed(new C08421(this), 250);
        } else if (c0816d == C0816d.PAUSED) {
            this.f2036a.m1845a(f2031n);
            this.f2044s.removeCallbacksAndMessages(null);
        }
    }

    public boolean m2550a() {
        return m2558i();
    }

    public boolean m2551b() {
        return C0649j.m2051a(getContext());
    }

    public boolean m2552c() {
        return this.f2043h;
    }

    public void m2553d() {
        if (this.f2039d && this.f2037b.getState() == C0816d.PLAYBACK_COMPLETED) {
            this.f2039d = false;
        }
        this.f2037b.start();
    }

    public void m2554e() {
        this.f2037b.pause();
    }

    public void m2555f() {
        getEventBus().m1845a(f2030m);
        this.f2037b.m2468c();
    }

    public void m2556g() {
        this.f2037b.m2469d();
    }

    public int getCurrentPosition() {
        return this.f2037b.getCurrentPosition();
    }

    public int getDuration() {
        return this.f2037b.getDuration();
    }

    @NonNull
    public C0591r<C0492s, C0590q> getEventBus() {
        return this.f2036a;
    }

    public long getInitialBufferTime() {
        return this.f2037b.getInitialBufferTime();
    }

    public C0699k getIsAutoPlayFromServer() {
        return this.f2042g;
    }

    public C0816d getState() {
        return this.f2037b.getState();
    }

    public TextureView getTextureView() {
        return (TextureView) this.f2037b;
    }

    public int getVideoHeight() {
        return this.f2037b.getVideoHeight();
    }

    public View getVideoView() {
        return this.f2037b.getView();
    }

    public int getVideoWidth() {
        return this.f2037b.getVideoWidth();
    }

    public float getVolume() {
        return this.f2037b.getVolume();
    }

    public void m2557h() {
        this.f2037b.m2467a(true);
    }

    protected boolean m2558i() {
        boolean z = this.f2040e && (!this.f2041f || ak.m2169c(getContext()) == C0672a.MOBILE_INTERNET);
        return getIsAutoPlayFromServer() == C0699k.UNKNOWN ? z : getIsAutoPlayFromServer() == C0699k.ON;
    }

    protected void onAttachedToWindow() {
        this.f2036a.m1845a(f2035r);
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        this.f2036a.m1845a(f2034q);
        super.onDetachedFromWindow();
    }

    @Deprecated
    public void setAutoplay(boolean z) {
        this.f2040e = z;
    }

    public void setControlsAnchorView(View view) {
        if (this.f2037b != null) {
            this.f2037b.setControlsAnchorView(view);
        }
    }

    public void setIsAutoPlayFromServer(C0699k c0699k) {
        this.f2042g = c0699k;
    }

    @Deprecated
    public void setIsAutoplayOnMobile(boolean z) {
        this.f2041f = z;
    }

    public void setIsFullScreen(boolean z) {
        this.f2043h = z;
        this.f2037b.setFullScreen(z);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(String str) {
        this.f2037b.setVideoMPD(str);
    }

    public void setVideoURI(Uri uri) {
        for (C0764l c0764l : this.f2038c) {
            if (c0764l instanceof C0765m) {
                C0765m c0765m = (C0765m) c0764l;
                if (c0765m.getParent() == null) {
                    addView(c0765m);
                    c0765m.m2392a(this);
                }
            } else {
                c0764l.m2391a(this);
            }
        }
        this.f2039d = false;
        this.f2037b.setup(uri);
    }

    public void setVideoURI(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVolume(float f) {
        this.f2037b.setRequestedVolume(f);
        getEventBus().m1845a(f2033p);
    }
}
