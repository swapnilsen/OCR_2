package com.google.android.exoplayer2.p064g.p065a;

import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p064g.Subtitle;
import com.google.android.exoplayer2.p064g.SubtitleDecoder;
import com.google.android.exoplayer2.p064g.SubtitleInputBuffer;
import com.google.android.exoplayer2.p064g.SubtitleOutputBuffer;
import java.util.LinkedList;
import java.util.TreeSet;

/* renamed from: com.google.android.exoplayer2.g.a.b */
abstract class CeaDecoder implements SubtitleDecoder {
    private final LinkedList<SubtitleInputBuffer> f3409a;
    private final LinkedList<SubtitleOutputBuffer> f3410b;
    private final TreeSet<SubtitleInputBuffer> f3411c;
    private SubtitleInputBuffer f3412d;
    private long f3413e;

    protected abstract void m3967a(SubtitleInputBuffer subtitleInputBuffer);

    protected abstract boolean m3974e();

    protected abstract Subtitle m3975f();

    public /* synthetic */ Object m3965a() {
        return m3977h();
    }

    public /* synthetic */ void m3969a(Object obj) {
        m3971b((SubtitleInputBuffer) obj);
    }

    public /* synthetic */ Object m3970b() {
        return m3976g();
    }

    public CeaDecoder() {
        int i = 0;
        this.f3409a = new LinkedList();
        for (int i2 = 0; i2 < 10; i2++) {
            this.f3409a.add(new SubtitleInputBuffer());
        }
        this.f3410b = new LinkedList();
        while (i < 2) {
            this.f3410b.add(new CeaOutputBuffer(this));
            i++;
        }
        this.f3411c = new TreeSet();
    }

    public void m3966a(long j) {
        this.f3413e = j;
    }

    public SubtitleInputBuffer m3977h() {
        Assertions.m4406b(this.f3412d == null);
        if (this.f3409a.isEmpty()) {
            return null;
        }
        this.f3412d = (SubtitleInputBuffer) this.f3409a.pollFirst();
        return this.f3412d;
    }

    public void m3971b(SubtitleInputBuffer subtitleInputBuffer) {
        boolean z;
        boolean z2 = true;
        if (subtitleInputBuffer != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m4404a(z);
        if (subtitleInputBuffer != this.f3412d) {
            z2 = false;
        }
        Assertions.m4404a(z2);
        this.f3411c.add(subtitleInputBuffer);
        this.f3412d = null;
    }

    public SubtitleOutputBuffer m3976g() {
        if (this.f3410b.isEmpty()) {
            return null;
        }
        while (!this.f3411c.isEmpty() && ((SubtitleInputBuffer) this.f3411c.first()).c <= this.f3413e) {
            SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) this.f3411c.pollFirst();
            if (subtitleInputBuffer.m3076c()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) this.f3410b.pollFirst();
                subtitleOutputBuffer.m3074b(4);
                m3964c(subtitleInputBuffer);
                return subtitleOutputBuffer;
            }
            m3967a(subtitleInputBuffer);
            if (m3974e()) {
                Subtitle f = m3975f();
                if (!subtitleInputBuffer.b_()) {
                    subtitleOutputBuffer = (SubtitleOutputBuffer) this.f3410b.pollFirst();
                    subtitleOutputBuffer.m4008a(subtitleInputBuffer.c, f, 0);
                    m3964c(subtitleInputBuffer);
                    return subtitleOutputBuffer;
                }
            }
            m3964c(subtitleInputBuffer);
        }
        return null;
    }

    private void m3964c(SubtitleInputBuffer subtitleInputBuffer) {
        subtitleInputBuffer.m3089a();
        this.f3409a.add(subtitleInputBuffer);
    }

    protected void m3968a(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.m4007a();
        this.f3410b.add(subtitleOutputBuffer);
    }

    public void m3972c() {
        this.f3413e = 0;
        while (!this.f3411c.isEmpty()) {
            m3964c((SubtitleInputBuffer) this.f3411c.pollFirst());
        }
        if (this.f3412d != null) {
            m3964c(this.f3412d);
            this.f3412d = null;
        }
    }

    public void m3973d() {
    }
}
