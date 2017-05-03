package com.google.android.exoplayer2.p064g;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.p051b.DecoderInputBuffer;
import com.google.android.exoplayer2.p051b.OutputBuffer;
import com.google.android.exoplayer2.p051b.SimpleDecoder;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.g.c */
public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {
    private final String f3438a;

    protected abstract Subtitle m4020a(byte[] bArr, int i);

    protected /* synthetic */ DecoderInputBuffer m4026g() {
        return m4028i();
    }

    protected /* synthetic */ OutputBuffer m4027h() {
        return m4029j();
    }

    protected SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.f3438a = str;
        m3103a((int) AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
    }

    public void m4023a(long j) {
    }

    protected final SubtitleInputBuffer m4028i() {
        return new SubtitleInputBuffer();
    }

    protected final SubtitleOutputBuffer m4029j() {
        return new SimpleSubtitleOutputBuffer(this);
    }

    protected final void m4025a(SubtitleOutputBuffer subtitleOutputBuffer) {
        super.m3105a((OutputBuffer) subtitleOutputBuffer);
    }

    protected final SubtitleDecoderException m4021a(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean z) {
        try {
            ByteBuffer byteBuffer = subtitleInputBuffer.b;
            Subtitle a = m4020a(byteBuffer.array(), byteBuffer.limit());
            subtitleOutputBuffer.m4008a(subtitleInputBuffer.c, a, subtitleInputBuffer.f3558d);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }
}
