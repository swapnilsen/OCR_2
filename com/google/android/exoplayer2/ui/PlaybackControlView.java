package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.appcompat.C0268R;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.google.ads.AdSize;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.R.R;
import com.google.android.exoplayer2.Timeline.Timeline;
import com.google.android.exoplayer2.p050j.Util;
import java.util.Formatter;
import java.util.Locale;

public class PlaybackControlView extends FrameLayout {
    private final C0900a f3980a;
    private final View f3981b;
    private final View f3982c;
    private final ImageButton f3983d;
    private final TextView f3984e;
    private final TextView f3985f;
    private final SeekBar f3986g;
    private final View f3987h;
    private final View f3988i;
    private final StringBuilder f3989j;
    private final Formatter f3990k;
    private final Timeline f3991l;
    private ExoPlayer f3992m;
    private C0901b f3993n;
    private boolean f3994o;
    private int f3995p;
    private int f3996q;
    private int f3997r;
    private long f3998s;
    private final Runnable f3999t;
    private final Runnable f4000u;

    /* renamed from: com.google.android.exoplayer2.ui.PlaybackControlView.1 */
    class C08981 implements Runnable {
        final /* synthetic */ PlaybackControlView f3977a;

        C08981(PlaybackControlView playbackControlView) {
            this.f3977a = playbackControlView;
        }

        public void run() {
            this.f3977a.m4686h();
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlaybackControlView.2 */
    class C08992 implements Runnable {
        final /* synthetic */ PlaybackControlView f3978a;

        C08992(PlaybackControlView playbackControlView) {
            this.f3978a = playbackControlView;
        }

        public void run() {
            this.f3978a.m4700b();
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlaybackControlView.a */
    private final class C0900a implements OnClickListener, OnSeekBarChangeListener, ExoPlayer.ExoPlayer {
        final /* synthetic */ PlaybackControlView f3979a;

        private C0900a(PlaybackControlView playbackControlView) {
            this.f3979a = playbackControlView;
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f3979a.removeCallbacks(this.f3979a.f4000u);
            this.f3979a.f3994o = true;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                this.f3979a.f3985f.setText(this.f3979a.m4669a(this.f3979a.m4667a(i)));
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f3979a.f3994o = false;
            this.f3979a.f3992m.m3841a(this.f3979a.m4667a(seekBar.getProgress()));
            this.f3979a.m4678d();
        }

        public void m4663a(boolean z, int i) {
            this.f3979a.m4681f();
            this.f3979a.m4686h();
        }

        public void m4665e() {
            this.f3979a.m4683g();
            this.f3979a.m4686h();
        }

        public void m4662a(com.google.android.exoplayer2.Timeline timeline, Object obj) {
            this.f3979a.m4683g();
            this.f3979a.m4686h();
        }

        public void m4664b(boolean z) {
        }

        public void m4661a(ExoPlaybackException exoPlaybackException) {
        }

        public void onClick(View view) {
            com.google.android.exoplayer2.Timeline f = this.f3979a.f3992m.m3852f();
            if (this.f3979a.f3982c == view) {
                this.f3979a.m4690j();
            } else if (this.f3979a.f3981b == view) {
                this.f3979a.m4687i();
            } else if (this.f3979a.f3987h == view) {
                this.f3979a.m4694l();
            } else if (this.f3979a.f3988i == view && f != null) {
                this.f3979a.m4691k();
            } else if (this.f3979a.f3983d == view) {
                this.f3979a.f3992m.m3844a(!this.f3979a.f3992m.m3848b());
            }
            this.f3979a.m4678d();
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlaybackControlView.b */
    public interface C0901b {
        void m4666a(int i);
    }

    public PlaybackControlView(Context context) {
        this(context, null);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3999t = new C08981(this);
        this.f4000u = new C08992(this);
        this.f3995p = 5000;
        this.f3996q = 15000;
        this.f3997r = 5000;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.PlaybackControlView, 0, 0);
            try {
                this.f3995p = obtainStyledAttributes.getInt(R.PlaybackControlView_rewind_increment, this.f3995p);
                this.f3996q = obtainStyledAttributes.getInt(R.PlaybackControlView_fastforward_increment, this.f3996q);
                this.f3997r = obtainStyledAttributes.getInt(R.PlaybackControlView_show_timeout, this.f3997r);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f3991l = new Timeline();
        this.f3989j = new StringBuilder();
        this.f3990k = new Formatter(this.f3989j, Locale.getDefault());
        this.f3980a = new C0900a();
        LayoutInflater.from(context).inflate(R.exo_playback_control_view, this);
        this.f3984e = (TextView) findViewById(R.time);
        this.f3985f = (TextView) findViewById(R.time_current);
        this.f3986g = (SeekBar) findViewById(R.mediacontroller_progress);
        this.f3986g.setOnSeekBarChangeListener(this.f3980a);
        this.f3986g.setMax(PointerIconCompat.TYPE_DEFAULT);
        this.f3983d = (ImageButton) findViewById(R.play);
        this.f3983d.setOnClickListener(this.f3980a);
        this.f3981b = findViewById(R.prev);
        this.f3981b.setOnClickListener(this.f3980a);
        this.f3982c = findViewById(R.next);
        this.f3982c.setOnClickListener(this.f3980a);
        this.f3988i = findViewById(R.rew);
        this.f3988i.setOnClickListener(this.f3980a);
        this.f3987h = findViewById(R.ffwd);
        this.f3987h.setOnClickListener(this.f3980a);
    }

    public ExoPlayer getPlayer() {
        return this.f3992m;
    }

    public void setPlayer(ExoPlayer exoPlayer) {
        if (this.f3992m != exoPlayer) {
            if (this.f3992m != null) {
                this.f3992m.m3846b(this.f3980a);
            }
            this.f3992m = exoPlayer;
            if (exoPlayer != null) {
                exoPlayer.m3842a(this.f3980a);
            }
            m4679e();
        }
    }

    public void setVisibilityListener(C0901b c0901b) {
        this.f3993n = c0901b;
    }

    public void setRewindIncrementMs(int i) {
        this.f3995p = i;
        m4683g();
    }

    public void setFastForwardIncrementMs(int i) {
        this.f3996q = i;
        m4683g();
    }

    public int getShowTimeoutMs() {
        return this.f3997r;
    }

    public void setShowTimeoutMs(int i) {
        this.f3997r = i;
    }

    public void m4699a() {
        if (!m4701c()) {
            setVisibility(0);
            if (this.f3993n != null) {
                this.f3993n.m4666a(getVisibility());
            }
            m4679e();
        }
        m4678d();
    }

    public void m4700b() {
        if (m4701c()) {
            setVisibility(8);
            if (this.f3993n != null) {
                this.f3993n.m4666a(getVisibility());
            }
            removeCallbacks(this.f3999t);
            removeCallbacks(this.f4000u);
            this.f3998s = -9223372036854775807L;
        }
    }

    public boolean m4701c() {
        return getVisibility() == 0;
    }

    private void m4678d() {
        removeCallbacks(this.f4000u);
        if (this.f3997r > 0) {
            this.f3998s = SystemClock.uptimeMillis() + ((long) this.f3997r);
            if (isAttachedToWindow()) {
                postDelayed(this.f4000u, (long) this.f3997r);
                return;
            }
            return;
        }
        this.f3998s = -9223372036854775807L;
    }

    private void m4679e() {
        m4681f();
        m4683g();
        m4686h();
    }

    private void m4681f() {
        if (m4701c() && isAttachedToWindow()) {
            Object obj = (this.f3992m == null || !this.f3992m.m3848b()) ? null : 1;
            this.f3983d.setContentDescription(getResources().getString(obj != null ? R.exo_controls_pause_description : R.exo_controls_play_description));
            this.f3983d.setImageResource(obj != null ? R.exo_controls_pause : R.exo_controls_play);
        }
    }

    private void m4683g() {
        boolean z = true;
        if (m4701c() && isAttachedToWindow()) {
            boolean z2;
            boolean z3;
            boolean z4;
            com.google.android.exoplayer2.Timeline f = this.f3992m != null ? this.f3992m.m3852f() : null;
            if (f != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                int g = this.f3992m.m3853g();
                f.m3947a(g, this.f3991l);
                z3 = this.f3991l.f3968d;
                if (g > 0 || z3 || !this.f3991l.f3969e) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (g < f.m3943a() - 1 || this.f3991l.f3969e) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            } else {
                z4 = false;
                z2 = false;
                z3 = false;
            }
            m4672a(z2, this.f3981b);
            m4672a(z4, this.f3982c);
            if (this.f3996q <= 0 || !z3) {
                z2 = false;
            } else {
                z2 = true;
            }
            m4672a(z2, this.f3987h);
            if (this.f3995p <= 0 || !z3) {
                z = false;
            }
            m4672a(z, this.f3988i);
            this.f3986g.setEnabled(z3);
        }
    }

    private void m4686h() {
        long j = 0;
        if (m4701c() && isAttachedToWindow()) {
            long h = this.f3992m == null ? 0 : this.f3992m.m3854h();
            long i = this.f3992m == null ? 0 : this.f3992m.m3855i();
            this.f3984e.setText(m4669a(h));
            if (!this.f3994o) {
                this.f3985f.setText(m4669a(i));
            }
            if (!this.f3994o) {
                this.f3986g.setProgress(m4674b(i));
            }
            if (this.f3992m != null) {
                j = this.f3992m.m3856j();
            }
            this.f3986g.setSecondaryProgress(m4674b(j));
            removeCallbacks(this.f3999t);
            int a = this.f3992m == null ? 1 : this.f3992m.m3839a();
            if (a != 1 && a != 4) {
                if (this.f3992m.m3848b() && a == 3) {
                    h = 1000 - (i % 1000);
                    if (h < 200) {
                        h += 1000;
                    }
                } else {
                    h = 1000;
                }
                postDelayed(this.f3999t, h);
            }
        }
    }

    private void m4672a(boolean z, View view) {
        view.setEnabled(z);
        if (Util.f3855a >= 11) {
            view.setAlpha(z ? 1.0f : 0.3f);
            view.setVisibility(0);
            return;
        }
        view.setVisibility(z ? 0 : 4);
    }

    private String m4669a(long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j2 = (500 + j) / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        j2 /= 3600;
        this.f3989j.setLength(0);
        if (j2 > 0) {
            return this.f3990k.format("%d:%02d:%02d", new Object[]{Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j3)}).toString();
        }
        return this.f3990k.format("%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j3)}).toString();
    }

    private int m4674b(long j) {
        long h = this.f3992m == null ? -9223372036854775807L : this.f3992m.m3854h();
        return (h == -9223372036854775807L || h == 0) ? 0 : (int) ((1000 * j) / h);
    }

    private long m4667a(int i) {
        long h = this.f3992m == null ? -9223372036854775807L : this.f3992m.m3854h();
        return h == -9223372036854775807L ? 0 : (h * ((long) i)) / 1000;
    }

    private void m4687i() {
        com.google.android.exoplayer2.Timeline f = this.f3992m.m3852f();
        if (f != null) {
            int g = this.f3992m.m3853g();
            f.m3947a(g, this.f3991l);
            if (g <= 0 || (this.f3992m.m3855i() > 3000 && (!this.f3991l.f3969e || this.f3991l.f3968d))) {
                this.f3992m.m3841a(0);
            } else {
                this.f3992m.m3840a(g - 1);
            }
        }
    }

    private void m4690j() {
        com.google.android.exoplayer2.Timeline f = this.f3992m.m3852f();
        if (f != null) {
            int g = this.f3992m.m3853g();
            if (g < f.m3943a() - 1) {
                this.f3992m.m3840a(g + 1);
            } else if (f.m3948a(g, this.f3991l, false).f3969e) {
                this.f3992m.m3849c();
            }
        }
    }

    private void m4691k() {
        if (this.f3995p > 0) {
            this.f3992m.m3841a(Math.max(this.f3992m.m3855i() - ((long) this.f3995p), 0));
        }
    }

    private void m4694l() {
        if (this.f3996q > 0) {
            this.f3992m.m3841a(Math.min(this.f3992m.m3855i() + ((long) this.f3996q), this.f3992m.m3854h()));
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3998s != -9223372036854775807L) {
            long uptimeMillis = this.f3998s - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                m4700b();
            } else {
                postDelayed(this.f4000u, uptimeMillis);
            }
        }
        m4679e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3999t);
        removeCallbacks(this.f4000u);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = false;
        if (this.f3992m == null || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        switch (keyEvent.getKeyCode()) {
            case C0268R.styleable.Toolbar_buttonGravity /*21*/:
            case C0268R.styleable.AppCompatTheme_colorButtonNormal /*89*/:
                m4691k();
                break;
            case C0268R.styleable.Toolbar_collapseIcon /*22*/:
            case AdSize.LARGE_AD_HEIGHT /*90*/:
                m4694l();
                break;
            case C0268R.styleable.AppCompatTheme_colorAccent /*85*/:
                ExoPlayer exoPlayer = this.f3992m;
                if (!this.f3992m.m3848b()) {
                    z = true;
                }
                exoPlayer.m3844a(z);
                break;
            case C0268R.styleable.AppCompatTheme_colorControlActivated /*87*/:
                m4690j();
                break;
            case C0268R.styleable.AppCompatTheme_colorControlHighlight /*88*/:
                m4687i();
                break;
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
                this.f3992m.m3844a(true);
                break;
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
                this.f3992m.m3844a(false);
                break;
            default:
                return false;
        }
        m4699a();
        return true;
    }
}
