package com.google.android.exoplayer2.p070h;

import android.os.Handler;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p062f.TrackGroupArray;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.google.android.exoplayer2.h.h */
public abstract class TrackSelector<T> {
    private final Handler f3637a;
    private final CopyOnWriteArraySet<TrackSelector<? super T>> f3638b;
    private TrackSelector f3639c;
    private TrackSelections<T> f3640d;

    /* renamed from: com.google.android.exoplayer2.h.h.1 */
    class TrackSelector implements Runnable {
        final /* synthetic */ TrackSelections f3661a;
        final /* synthetic */ TrackSelector f3662b;

        TrackSelector(TrackSelector trackSelector, TrackSelections trackSelections) {
            this.f3662b = trackSelector;
            this.f3661a = trackSelections;
        }

        public void run() {
            Iterator it = this.f3662b.f3638b.iterator();
            while (it.hasNext()) {
                ((TrackSelector) it.next()).m4282a(this.f3661a);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.h.a */
    public interface TrackSelector<T> {
        void m4282a(TrackSelections<? extends T> trackSelections);
    }

    /* renamed from: com.google.android.exoplayer2.h.h.b */
    public interface TrackSelector {
    }

    public abstract TrackSelections<T> m4254a(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray);

    public TrackSelector(Handler handler) {
        this.f3637a = (Handler) Assertions.m4402a((Object) handler);
        this.f3638b = new CopyOnWriteArraySet();
    }

    public final void m4256a(TrackSelector<? super T> trackSelector) {
        this.f3638b.add(trackSelector);
    }

    public final void m4257a(TrackSelector trackSelector) {
        this.f3639c = trackSelector;
    }

    public final void m4255a(TrackSelections<T> trackSelections) {
        this.f3640d = trackSelections;
        m4253b(trackSelections);
    }

    private void m4253b(TrackSelections<T> trackSelections) {
        if (this.f3637a != null) {
            this.f3637a.post(new TrackSelector(this, trackSelections));
        }
    }
}
