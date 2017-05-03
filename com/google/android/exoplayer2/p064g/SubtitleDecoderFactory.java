package com.google.android.exoplayer2.p064g;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.g.h */
public interface SubtitleDecoderFactory {
    public static final SubtitleDecoderFactory f3557a;

    /* renamed from: com.google.android.exoplayer2.g.h.1 */
    static class SubtitleDecoderFactory implements SubtitleDecoderFactory {
        SubtitleDecoderFactory() {
        }

        public boolean m4192a(Format format) {
            return m4191a(format.f2324e) != null;
        }

        public SubtitleDecoder m4193b(Format format) {
            try {
                Class a = m4191a(format.f2324e);
                if (a != null) {
                    return (SubtitleDecoder) a.asSubclass(SubtitleDecoder.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                }
                throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            } catch (Throwable e) {
                throw new IllegalStateException("Unexpected error instantiating decoder", e);
            }
        }

        private Class<?> m4191a(String str) {
            Object obj = -1;
            try {
                switch (str.hashCode()) {
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            obj = 4;
                            break;
                        }
                        break;
                    case 1490991545:
                        if (str.equals("application/x-mp4vtt")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            obj = 5;
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            obj = 3;
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        return Class.forName("com.google.android.exoplayer2.g.e.g");
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        return Class.forName("com.google.android.exoplayer2.g.c.a");
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        return Class.forName("com.google.android.exoplayer2.g.e.b");
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        return Class.forName("com.google.android.exoplayer2.g.b.a");
                    case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                        return Class.forName("com.google.android.exoplayer2.g.d.a");
                    case Type.OTHER_PROFILE /*5*/:
                        return Class.forName("com.google.android.exoplayer2.g.a.a");
                    default:
                        return null;
                }
            } catch (ClassNotFoundException e) {
                return null;
            }
        }
    }

    boolean m4189a(Format format);

    SubtitleDecoder m4190b(Format format);

    static {
        f3557a = new SubtitleDecoderFactory();
    }
}
