package com.google.android.exoplayer2.p060e;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p051b.DecoderInputBuffer;
import java.nio.ByteBuffer;
import net.nend.android.NendAdIconLayout;

/* renamed from: com.google.android.exoplayer2.e.c */
public final class MetadataRenderer<T> extends BaseRenderer implements Callback {
    private final MetadataDecoder<T> f3327a;
    private final MetadataRenderer<T> f3328b;
    private final Handler f3329c;
    private final FormatHolder f3330d;
    private final DecoderInputBuffer f3331e;
    private boolean f3332f;
    private long f3333g;
    private T f3334h;

    /* renamed from: com.google.android.exoplayer2.e.c.a */
    public interface MetadataRenderer<T> {
        void m3830a(T t);
    }

    public MetadataRenderer(MetadataRenderer<T> metadataRenderer, Looper looper, MetadataDecoder<T> metadataDecoder) {
        super(4);
        this.f3328b = (MetadataRenderer) Assertions.m4402a((Object) metadataRenderer);
        this.f3329c = looper == null ? null : new Handler(looper, this);
        this.f3327a = (MetadataDecoder) Assertions.m4402a((Object) metadataDecoder);
        this.f3330d = new FormatHolder();
        this.f3331e = new DecoderInputBuffer(1);
    }

    public int m3833a(Format format) {
        return this.f3327a.m3815a(format.f2324e) ? 3 : 0;
    }

    protected void m3835a(long j, boolean z) {
        this.f3334h = null;
        this.f3332f = false;
    }

    public void m3834a(long j, long j2) {
        if (!this.f3332f && this.f3334h == null) {
            this.f3331e.m3089a();
            if (m2983a(this.f3330d, this.f3331e) == -4) {
                if (this.f3331e.m3076c()) {
                    this.f3332f = true;
                } else {
                    this.f3333g = this.f3331e.f2503c;
                    try {
                        this.f3331e.m3091e();
                        ByteBuffer byteBuffer = this.f3331e.f2502b;
                        this.f3334h = this.f3327a.m3814a(byteBuffer.array(), byteBuffer.limit());
                    } catch (Exception e) {
                        throw ExoPlaybackException.m3798a(e, m3007p());
                    }
                }
            }
        }
        if (this.f3334h != null && this.f3333g <= j) {
            m3831a(this.f3334h);
            this.f3334h = null;
        }
    }

    protected void m3836o() {
        this.f3334h = null;
        super.m3006o();
    }

    public boolean m3838s() {
        return this.f3332f;
    }

    public boolean m3837r() {
        return true;
    }

    private void m3831a(T t) {
        if (this.f3329c != null) {
            this.f3329c.obtainMessage(0, t).sendToTarget();
        } else {
            m3832b(t);
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                m3832b(message.obj);
                return true;
            default:
                return false;
        }
    }

    private void m3832b(T t) {
        this.f3328b.m3830a(t);
    }
}
