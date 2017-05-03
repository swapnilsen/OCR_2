package com.google.android.exoplayer2.p064g;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.MimeTypes;
import java.util.Collections;
import java.util.List;
import net.nend.android.NendAdIconLayout;

/* renamed from: com.google.android.exoplayer2.g.k */
public final class TextRenderer extends BaseRenderer implements Callback {
    private final Handler f3559a;
    private final TextRenderer f3560b;
    private final SubtitleDecoderFactory f3561c;
    private final FormatHolder f3562d;
    private boolean f3563e;
    private boolean f3564f;
    private SubtitleDecoder f3565g;
    private SubtitleInputBuffer f3566h;
    private SubtitleOutputBuffer f3567i;
    private SubtitleOutputBuffer f3568j;
    private int f3569k;

    /* renamed from: com.google.android.exoplayer2.g.k.a */
    public interface TextRenderer {
        void m4195a(List<Cue> list);
    }

    public TextRenderer(TextRenderer textRenderer, Looper looper) {
        this(textRenderer, looper, SubtitleDecoderFactory.f3557a);
    }

    public TextRenderer(TextRenderer textRenderer, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.f3560b = (TextRenderer) Assertions.m4402a((Object) textRenderer);
        this.f3559a = looper == null ? null : new Handler(looper, this);
        this.f3561c = subtitleDecoderFactory;
        this.f3562d = new FormatHolder();
    }

    public int m4200a(Format format) {
        if (this.f3561c.m4189a(format)) {
            return 3;
        }
        return MimeTypes.m4427c(format.f2324e) ? 1 : 0;
    }

    protected void m4203a(Format[] formatArr) {
        if (this.f3565g != null) {
            this.f3565g.m3086d();
            this.f3566h = null;
        }
        this.f3565g = this.f3561c.m4190b(formatArr[0]);
    }

    protected void m4202a(long j, boolean z) {
        this.f3563e = false;
        this.f3564f = false;
        if (this.f3567i != null) {
            this.f3567i.m4011d();
            this.f3567i = null;
        }
        if (this.f3568j != null) {
            this.f3568j.m4011d();
            this.f3568j = null;
        }
        this.f3566h = null;
        m4199u();
        this.f3565g.m3085c();
    }

    public void m4201a(long j, long j2) {
        if (!this.f3564f) {
            if (this.f3568j == null) {
                this.f3565g.m3963a(j);
                try {
                    this.f3568j = (SubtitleOutputBuffer) this.f3565g.m3084b();
                } catch (Exception e) {
                    throw ExoPlaybackException.m3798a(e, m3007p());
                }
            }
            if (m2995d() == 2) {
                boolean z = false;
                if (this.f3567i != null) {
                    long t = m4198t();
                    while (t <= j) {
                        this.f3569k++;
                        t = m4198t();
                        z = true;
                    }
                }
                if (this.f3568j != null) {
                    if (this.f3568j.m3076c()) {
                        if (!z && m4198t() == Long.MAX_VALUE) {
                            if (this.f3567i != null) {
                                this.f3567i.m4011d();
                                this.f3567i = null;
                            }
                            this.f3568j.m4011d();
                            this.f3568j = null;
                            this.f3564f = true;
                        }
                    } else if (this.f3568j.a <= j) {
                        if (this.f3567i != null) {
                            this.f3567i.m4011d();
                        }
                        this.f3567i = this.f3568j;
                        this.f3568j = null;
                        this.f3569k = this.f3567i.m4005a(j);
                        z = true;
                    }
                }
                if (z) {
                    m4196a(this.f3567i.m4010b(j));
                }
                while (!this.f3563e) {
                    if (this.f3566h == null) {
                        this.f3566h = (SubtitleInputBuffer) this.f3565g.m3082a();
                        if (this.f3566h == null) {
                            return;
                        }
                    }
                    int a = m2983a(this.f3562d, this.f3566h);
                    if (a == -4) {
                        this.f3566h.m3075c(RtlSpacingHelper.UNDEFINED);
                        if (this.f3566h.m3076c()) {
                            this.f3563e = true;
                        } else {
                            try {
                                this.f3566h.f3558d = this.f3562d.f3791a.f2340u;
                                this.f3566h.m3091e();
                            } catch (Exception e2) {
                                throw ExoPlaybackException.m3798a(e2, m3007p());
                            }
                        }
                        this.f3565g.m3083a(this.f3566h);
                        this.f3566h = null;
                    } else if (a == -3) {
                        return;
                    }
                }
            }
        }
    }

    protected void m4204o() {
        if (this.f3567i != null) {
            this.f3567i.m4011d();
            this.f3567i = null;
        }
        if (this.f3568j != null) {
            this.f3568j.m4011d();
            this.f3568j = null;
        }
        this.f3565g.m3086d();
        this.f3565g = null;
        this.f3566h = null;
        m4199u();
        super.m3006o();
    }

    public boolean m4206s() {
        return this.f3564f;
    }

    public boolean m4205r() {
        return true;
    }

    private long m4198t() {
        if (this.f3569k == -1 || this.f3569k >= this.f3567i.m4009b()) {
            return Long.MAX_VALUE;
        }
        return this.f3567i.m4006a(this.f3569k);
    }

    private void m4196a(List<Cue> list) {
        if (this.f3559a != null) {
            this.f3559a.obtainMessage(0, list).sendToTarget();
        } else {
            m4197b(list);
        }
    }

    private void m4199u() {
        m4196a(Collections.emptyList());
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                m4197b((List) message.obj);
                return true;
            default:
                return false;
        }
    }

    private void m4197b(List<Cue> list) {
        this.f3560b.m4195a(list);
    }
}
