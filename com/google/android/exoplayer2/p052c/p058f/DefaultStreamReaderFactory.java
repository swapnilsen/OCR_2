package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.media.TransportMediator;
import android.support.v7.appcompat.C0268R;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.google.android.exoplayer2.c.f.e */
public final class DefaultStreamReaderFactory implements ElementaryStreamReader {
    private final int f3047a;

    public DefaultStreamReaderFactory() {
        this(0);
    }

    public DefaultStreamReaderFactory(int i) {
        this.f3047a = i;
    }

    public ElementaryStreamReader m3585a(int i, ElementaryStreamReader elementaryStreamReader) {
        boolean z = true;
        switch (i) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return new H262Reader();
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return new MpegAudioReader(elementaryStreamReader.f3059b);
            case CommonStatusCodes.TIMEOUT /*15*/:
                if ((this.f3047a & 2) == 0) {
                    return new AdtsReader(false, elementaryStreamReader.f3059b);
                }
                return null;
            case C0268R.styleable.Toolbar_buttonGravity /*21*/:
                return new Id3Reader();
            case C0268R.styleable.Toolbar_titleTextColor /*27*/:
                if ((this.f3047a & 4) != 0) {
                    return null;
                }
                boolean z2 = (this.f3047a & 1) != 0;
                if ((this.f3047a & 8) == 0) {
                    z = false;
                }
                return new H264Reader(z2, z);
            case C0268R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                return new H265Reader();
            case 129:
            case 135:
                return new Ac3Reader(elementaryStreamReader.f3059b);
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
            case 138:
                return new DtsReader(elementaryStreamReader.f3059b);
            default:
                return null;
        }
    }
}
