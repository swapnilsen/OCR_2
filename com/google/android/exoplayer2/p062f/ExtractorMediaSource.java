package com.google.android.exoplayer2.p062f;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline.Timeline;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p062f.MediaSource.MediaSource;
import com.google.android.exoplayer2.p063i.Allocator;
import com.google.android.exoplayer2.p063i.DataSource.DataSource;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.f.b */
public final class ExtractorMediaSource implements MediaSource, MediaSource {
    private final Uri f3385a;
    private final DataSource f3386b;
    private final ExtractorsFactory f3387c;
    private final int f3388d;
    private final Handler f3389e;
    private final ExtractorMediaSource f3390f;
    private final Timeline f3391g;
    private MediaSource f3392h;
    private com.google.android.exoplayer2.Timeline f3393i;
    private boolean f3394j;

    /* renamed from: com.google.android.exoplayer2.f.b.a */
    public interface ExtractorMediaSource {
        void m3928a(IOException iOException);
    }

    /* renamed from: com.google.android.exoplayer2.f.b.b */
    public static final class ExtractorMediaSource extends ParserException {
        public ExtractorMediaSource(Extractor[] extractorArr) {
            super("None of the available extractors (" + Util.m4513a((Object[]) extractorArr) + ") could read the stream.");
        }
    }

    public ExtractorMediaSource(Uri uri, DataSource dataSource, ExtractorsFactory extractorsFactory, Handler handler, ExtractorMediaSource extractorMediaSource) {
        this(uri, dataSource, extractorsFactory, -1, handler, extractorMediaSource);
    }

    public ExtractorMediaSource(Uri uri, DataSource dataSource, ExtractorsFactory extractorsFactory, int i, Handler handler, ExtractorMediaSource extractorMediaSource) {
        this.f3385a = uri;
        this.f3386b = dataSource;
        this.f3387c = extractorsFactory;
        this.f3388d = i;
        this.f3389e = handler;
        this.f3390f = extractorMediaSource;
        this.f3391g = new Timeline();
    }

    public void m3938a(MediaSource mediaSource) {
        this.f3392h = mediaSource;
        this.f3393i = new SinglePeriodTimeline(-9223372036854775807L, false);
        mediaSource.m3934a(this.f3393i, null);
    }

    public void m3936a() {
    }

    public MediaPeriod m3935a(int i, Allocator allocator, long j) {
        Assertions.m4404a(i == 0);
        return new ExtractorMediaPeriod(this.f3385a, this.f3386b.m4342a(), this.f3387c.m3121a(), this.f3388d, this.f3389e, this.f3390f, this, allocator);
    }

    public void m3937a(MediaPeriod mediaPeriod) {
        ((ExtractorMediaPeriod) mediaPeriod).m3920b();
    }

    public void m3940b() {
        this.f3392h = null;
    }

    public void m3939a(com.google.android.exoplayer2.Timeline timeline, Object obj) {
        boolean z = false;
        if (timeline.m3945a(0, this.f3391g).m4654b() != -9223372036854775807L) {
            z = true;
        }
        if (!this.f3394j || z) {
            this.f3393i = timeline;
            this.f3394j = z;
            this.f3392h.m3934a(this.f3393i, null);
        }
    }
}
