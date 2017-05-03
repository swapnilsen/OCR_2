package com.p013a.p014a.p015a.p016a;

import android.support.v4.view.MotionEventCompat;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.JsonParseException;
import com.p013a.p014a.p015a.JsonParser;
import com.p013a.p014a.p015a.JsonToken;
import net.nend.android.NendIconError;

/* renamed from: com.a.a.a.a.c */
public abstract class ParserMinimalBase extends JsonParser {
    protected JsonToken f358K;

    /* renamed from: com.a.a.a.a.c.1 */
    static /* synthetic */ class ParserMinimalBase {
        static final /* synthetic */ int[] f394a;

        static {
            f394a = new int[JsonToken.values().length];
            try {
                f394a[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f394a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f394a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f394a[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f394a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f394a[JsonToken.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f394a[JsonToken.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f394a[JsonToken.VALUE_NULL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f394a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f394a[JsonToken.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f394a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public abstract JsonToken m502a();

    public abstract String m512f();

    protected abstract void m513t();

    protected ParserMinimalBase() {
    }

    public JsonToken m508c() {
        return this.f358K;
    }

    public JsonParser m505b() {
        if (this.f358K == JsonToken.START_OBJECT || this.f358K == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken a = m502a();
                if (a == null) {
                    m513t();
                } else {
                    switch (ParserMinimalBase.f394a[a.ordinal()]) {
                        case NendIconError.ERROR_ICONVIEW /*1*/:
                        case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            i++;
                            continue;
                        case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                            i--;
                            if (i == 0) {
                                break;
                            }
                            continue;
                        default:
                            continue;
                    }
                }
            }
        }
        return this;
    }

    protected void m507b(int i, String str) {
        String str2 = "Unexpected character (" + ParserMinimalBase.m497c(i) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        m511d(str2);
    }

    protected void m498C() {
        m510c(" in " + this.f358K);
    }

    protected void m510c(String str) {
        m511d("Unexpected end-of-input" + str);
    }

    protected void m499D() {
        m510c(" in a value");
    }

    protected void m506b(int i) {
        m511d("Illegal character (" + ParserMinimalBase.m497c((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    protected void m509c(int i, String str) {
        if (!m483a(JsonParser.JsonParser.ALLOW_UNQUOTED_CONTROL_CHARS) || i >= 32) {
            m511d("Illegal unquoted character (" + ParserMinimalBase.m497c((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    protected char m501a(char c) {
        if (!(m483a(JsonParser.JsonParser.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) || (c == '\'' && m483a(JsonParser.JsonParser.ALLOW_SINGLE_QUOTES)))) {
            m511d("Unrecognized character escape " + ParserMinimalBase.m497c((int) c));
        }
        return c;
    }

    protected static final String m497c(int i) {
        char c = (char) i;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + i + ")";
        }
        if (i > MotionEventCompat.ACTION_MASK) {
            return "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
        }
        return "'" + c + "' (code " + i + ")";
    }

    protected final void m511d(String str) {
        throw m481a(str);
    }

    protected final void m503a(String str, Throwable th) {
        throw m504b(str, th);
    }

    protected final void m500E() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    protected final JsonParseException m504b(String str, Throwable th) {
        return new JsonParseException(str, m487e(), th);
    }
}
