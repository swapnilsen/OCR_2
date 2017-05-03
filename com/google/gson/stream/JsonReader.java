package com.google.gson.stream;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import android.support.v7.cardview.C0269R;
import com.google.ads.AdSize;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import net.nend.android.NendIconError;

public class JsonReader implements Closeable {
    private static final char[] f4814b;
    int f4815a;
    private final Reader f4816c;
    private boolean f4817d;
    private final char[] f4818e;
    private int f4819f;
    private int f4820g;
    private int f4821h;
    private int f4822i;
    private long f4823j;
    private int f4824k;
    private String f4825l;
    private int[] f4826m;
    private int f4827n;
    private String[] f4828o;
    private int[] f4829p;

    /* renamed from: com.google.gson.stream.JsonReader.1 */
    static class C15891 extends JsonReaderInternalAccess {
        C15891() {
        }

        public void promoteNameToValue(JsonReader jsonReader) {
            if (jsonReader instanceof JsonTreeReader) {
                ((JsonTreeReader) jsonReader).promoteNameToValue();
                return;
            }
            int i = jsonReader.f4815a;
            if (i == 0) {
                i = jsonReader.m5414a();
            }
            if (i == 13) {
                jsonReader.f4815a = 9;
            } else if (i == 12) {
                jsonReader.f4815a = 8;
            } else if (i == 14) {
                jsonReader.f4815a = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.m5411h());
            }
        }
    }

    static {
        f4814b = ")]}'\n".toCharArray();
        JsonReaderInternalAccess.INSTANCE = new C15891();
    }

    public JsonReader(Reader reader) {
        this.f4817d = false;
        this.f4818e = new char[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        this.f4819f = 0;
        this.f4820g = 0;
        this.f4821h = 0;
        this.f4822i = 0;
        this.f4815a = 0;
        this.f4826m = new int[32];
        this.f4827n = 0;
        int[] iArr = this.f4826m;
        int i = this.f4827n;
        this.f4827n = i + 1;
        iArr[i] = 6;
        this.f4828o = new String[32];
        this.f4829p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f4816c = reader;
    }

    public final void setLenient(boolean z) {
        this.f4817d = z;
    }

    public final boolean isLenient() {
        return this.f4817d;
    }

    public void beginArray() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 3) {
            m5398a(1);
            this.f4829p[this.f4827n - 1] = 0;
            this.f4815a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + m5411h());
    }

    public void endArray() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 4) {
            this.f4827n--;
            int[] iArr = this.f4829p;
            int i2 = this.f4827n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f4815a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + m5411h());
    }

    public void beginObject() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 1) {
            m5398a(3);
            this.f4815a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + m5411h());
    }

    public void endObject() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 2) {
            this.f4827n--;
            this.f4828o[this.f4827n] = null;
            int[] iArr = this.f4829p;
            int i2 = this.f4827n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f4815a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + m5411h());
    }

    public boolean hasNext() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken peek() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return JsonToken.BEGIN_OBJECT;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return JsonToken.END_OBJECT;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return JsonToken.BEGIN_ARRAY;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return JsonToken.END_ARRAY;
            case Type.OTHER_PROFILE /*5*/:
            case Type.CONTRIBUTOR /*6*/:
                return JsonToken.BOOLEAN;
            case Type.WEBSITE /*7*/:
                return JsonToken.NULL;
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
            case ConnectionResult.SERVICE_INVALID /*9*/:
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return JsonToken.STRING;
            case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
            case CommonStatusCodes.ERROR /*13*/:
            case CommonStatusCodes.INTERRUPTED /*14*/:
                return JsonToken.NAME;
            case CommonStatusCodes.TIMEOUT /*15*/:
            case CommonStatusCodes.CANCELED /*16*/:
                return JsonToken.NUMBER;
            case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    int m5414a() {
        int a;
        int i = this.f4826m[this.f4827n - 1];
        if (i == 1) {
            this.f4826m[this.f4827n - 1] = 2;
        } else if (i == 2) {
            switch (m5396a(true)) {
                case C0268R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    break;
                case C0268R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    m5409f();
                    break;
                case C0268R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                    this.f4815a = 4;
                    return 4;
                default:
                    throw m5402b("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.f4826m[this.f4827n - 1] = 4;
            if (i == 5) {
                switch (m5396a(true)) {
                    case C0268R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                        break;
                    case C0268R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                        m5409f();
                        break;
                    case 125:
                        this.f4815a = 2;
                        return 2;
                    default:
                        throw m5402b("Unterminated object");
                }
            }
            a = m5396a(true);
            switch (a) {
                case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.f4815a = 13;
                    return 13;
                case C0268R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    m5409f();
                    this.f4815a = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.f4815a = 2;
                        return 2;
                    }
                    throw m5402b("Expected name");
                default:
                    m5409f();
                    this.f4819f--;
                    if (m5399a((char) a)) {
                        this.f4815a = 14;
                        return 14;
                    }
                    throw m5402b("Expected name");
            }
        } else if (i == 4) {
            this.f4826m[this.f4827n - 1] = 5;
            switch (m5396a(true)) {
                case C0268R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    break;
                case C0268R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    m5409f();
                    if ((this.f4819f < this.f4820g || m5404b(1)) && this.f4818e[this.f4819f] == '>') {
                        this.f4819f++;
                        break;
                    }
                default:
                    throw m5402b("Expected ':'");
            }
        } else if (i == 6) {
            if (this.f4817d) {
                m5413j();
            }
            this.f4826m[this.f4827n - 1] = 7;
        } else if (i == 7) {
            if (m5396a(false) == -1) {
                this.f4815a = 17;
                return 17;
            }
            m5409f();
            this.f4819f--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (m5396a(true)) {
            case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                this.f4815a = 9;
                return 9;
            case C0268R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                m5409f();
                this.f4815a = 8;
                return 8;
            case C0268R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
            case C0268R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                break;
            case C0268R.styleable.AppCompatTheme_controlBackground /*91*/:
                this.f4815a = 3;
                return 3;
            case C0268R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                if (i == 1) {
                    this.f4815a = 4;
                    return 4;
                }
                break;
            case 123:
                this.f4815a = 1;
                return 1;
            default:
                this.f4819f--;
                a = m5401b();
                if (a != 0) {
                    return a;
                }
                a = m5405c();
                if (a != 0) {
                    return a;
                }
                if (m5399a(this.f4818e[this.f4819f])) {
                    m5409f();
                    this.f4815a = 10;
                    return 10;
                }
                throw m5402b("Expected value");
        }
        if (i == 1 || i == 2) {
            m5409f();
            this.f4819f--;
            this.f4815a = 7;
            return 7;
        }
        throw m5402b("Unexpected value");
    }

    private int m5401b() {
        String str;
        int i;
        char c = this.f4818e[this.f4819f];
        String str2;
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.f4819f + i2 >= this.f4820g && !m5404b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f4818e[this.f4819f + i2];
            if (c2 != str.charAt(i2) && c2 != r1.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.f4819f + length < this.f4820g || m5404b(length + 1)) && m5399a(this.f4818e[this.f4819f + length])) {
            return 0;
        }
        this.f4819f += length;
        this.f4815a = i;
        return i;
    }

    private int m5405c() {
        char[] cArr = this.f4818e;
        int i = this.f4819f;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f4820g;
        int i6 = i;
        while (true) {
            Object obj2;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (m5404b(i4 + 1)) {
                    i6 = this.f4819f;
                    i5 = this.f4820g;
                } else if (i3 != 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
                    if (obj == null) {
                        j = -j;
                    }
                    this.f4823j = j;
                    this.f4819f += i4;
                    this.f4815a = 15;
                    return 15;
                } else if (i3 == 2 && i3 != 4 && i3 != 7) {
                    return 0;
                } else {
                    this.f4824k = i4;
                    this.f4815a = 16;
                    return 16;
                }
            }
            char c = cArr[i6 + i4];
            int i7;
            switch (c) {
                case C0268R.styleable.AppCompatTheme_dialogTheme /*43*/:
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case C0268R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        break;
                    } else {
                        return 0;
                    }
                case C0268R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case C0268R.styleable.AppCompatTheme_searchViewStyle /*69*/:
                case C0268R.styleable.AppCompatTheme_autoCompleteTextViewStyle /*101*/:
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j = j2;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        continue;
                    } else if (m5399a(c)) {
                        return 0;
                    }
                    break;
            }
            if (i3 != 2) {
            }
            if (i3 == 2) {
            }
            this.f4824k = i4;
            this.f4815a = 16;
            return 16;
            i4++;
            obj = obj2;
            i2 = i3;
            i3 = i;
        }
    }

    private boolean m5399a(char c) {
        switch (c) {
            case ConnectionResult.SERVICE_INVALID /*9*/:
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
            case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
            case CommonStatusCodes.ERROR /*13*/:
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
            case C0268R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
            case C0268R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
            case C0268R.styleable.AppCompatTheme_controlBackground /*91*/:
            case C0268R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
            case '{':
            case '}':
                break;
            case C0268R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
            case C0268R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
            case C0268R.styleable.AppCompatTheme_toolbarStyle /*59*/:
            case C0268R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
            case C0268R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                m5409f();
                break;
            default:
                return true;
        }
        return false;
    }

    public String nextName() {
        String d;
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 14) {
            d = m5407d();
        } else if (i == 12) {
            d = m5403b('\'');
        } else if (i == 13) {
            d = m5403b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + m5411h());
        }
        this.f4815a = 0;
        this.f4828o[this.f4827n - 1] = d;
        return d;
    }

    public String nextString() {
        String d;
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 10) {
            d = m5407d();
        } else if (i == 8) {
            d = m5403b('\'');
        } else if (i == 9) {
            d = m5403b('\"');
        } else if (i == 11) {
            d = this.f4825l;
            this.f4825l = null;
        } else if (i == 15) {
            d = Long.toString(this.f4823j);
        } else if (i == 16) {
            d = new String(this.f4818e, this.f4819f, this.f4824k);
            this.f4819f += this.f4824k;
        } else {
            throw new IllegalStateException("Expected a string but was " + peek() + m5411h());
        }
        this.f4815a = 0;
        int[] iArr = this.f4829p;
        int i2 = this.f4827n - 1;
        iArr[i2] = iArr[i2] + 1;
        return d;
    }

    public boolean nextBoolean() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 5) {
            this.f4815a = 0;
            int[] iArr = this.f4829p;
            i = this.f4827n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (i == 6) {
            this.f4815a = 0;
            int[] iArr2 = this.f4829p;
            int i2 = this.f4827n - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + m5411h());
        }
    }

    public void nextNull() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 7) {
            this.f4815a = 0;
            int[] iArr = this.f4829p;
            int i2 = this.f4827n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + m5411h());
    }

    public double nextDouble() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 15) {
            this.f4815a = 0;
            int[] iArr = this.f4829p;
            int i2 = this.f4827n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f4823j;
        }
        if (i == 16) {
            this.f4825l = new String(this.f4818e, this.f4819f, this.f4824k);
            this.f4819f += this.f4824k;
        } else if (i == 8 || i == 9) {
            this.f4825l = m5403b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f4825l = m5407d();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + m5411h());
        }
        this.f4815a = 11;
        double parseDouble = Double.parseDouble(this.f4825l);
        if (this.f4817d || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.f4825l = null;
            this.f4815a = 0;
            int[] iArr2 = this.f4829p;
            int i3 = this.f4827n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + m5411h());
    }

    public long nextLong() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        if (i == 15) {
            this.f4815a = 0;
            int[] iArr = this.f4829p;
            int i2 = this.f4827n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f4823j;
        }
        long parseLong;
        if (i == 16) {
            this.f4825l = new String(this.f4818e, this.f4819f, this.f4824k);
            this.f4819f += this.f4824k;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.f4825l = m5407d();
            } else {
                this.f4825l = m5403b(i == 8 ? '\'' : '\"');
            }
            try {
                parseLong = Long.parseLong(this.f4825l);
                this.f4815a = 0;
                int[] iArr2 = this.f4829p;
                int i3 = this.f4827n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + peek() + m5411h());
        }
        this.f4815a = 11;
        double parseDouble = Double.parseDouble(this.f4825l);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f4825l + m5411h());
        }
        this.f4825l = null;
        this.f4815a = 0;
        iArr2 = this.f4829p;
        i3 = this.f4827n - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseLong;
    }

    private String m5403b(char c) {
        char[] cArr = this.f4818e;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int i = this.f4819f;
            int i2 = this.f4820g;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f4819f = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                }
                if (c2 == '\\') {
                    this.f4819f = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(m5412i());
                    i = this.f4819f;
                    i2 = this.f4820g;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.f4821h++;
                    this.f4822i = i4;
                }
                i3 = i4;
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.f4819f = i3;
        } while (m5404b(1));
        throw m5402b("Unterminated string");
    }

    private String m5407d() {
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            String str;
            if (this.f4819f + i < this.f4820g) {
                switch (this.f4818e[this.f4819f + i]) {
                    case ConnectionResult.SERVICE_INVALID /*9*/:
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    case CommonStatusCodes.ERROR /*13*/:
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    case C0268R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    case C0268R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    case C0268R.styleable.AppCompatTheme_controlBackground /*91*/:
                    case C0268R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                    case '{':
                    case '}':
                        break;
                    case C0268R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case C0268R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    case C0268R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    case C0268R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    case C0268R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                        m5409f();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f4818e.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.f4818e, this.f4819f, i);
                this.f4819f = i + this.f4819f;
                if (m5404b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (m5404b(i + 1)) {
            }
            if (stringBuilder == null) {
                str = new String(this.f4818e, this.f4819f, i);
            } else {
                stringBuilder.append(this.f4818e, this.f4819f, i);
                str = stringBuilder.toString();
            }
            this.f4819f = i + this.f4819f;
            return str;
        }
    }

    private void m5406c(char c) {
        char[] cArr = this.f4818e;
        do {
            int i = this.f4819f;
            int i2 = this.f4820g;
            int i3 = i;
            while (i3 < i2) {
                i = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f4819f = i;
                    return;
                }
                if (c2 == '\\') {
                    this.f4819f = i;
                    m5412i();
                    i = this.f4819f;
                    i2 = this.f4820g;
                } else if (c2 == '\n') {
                    this.f4821h++;
                    this.f4822i = i;
                }
                i3 = i;
            }
            this.f4819f = i3;
        } while (m5404b(1));
        throw m5402b("Unterminated string");
    }

    private void m5408e() {
        do {
            int i = 0;
            while (this.f4819f + i < this.f4820g) {
                switch (this.f4818e[this.f4819f + i]) {
                    case ConnectionResult.SERVICE_INVALID /*9*/:
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    case CommonStatusCodes.ERROR /*13*/:
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    case C0268R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    case C0268R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    case C0268R.styleable.AppCompatTheme_controlBackground /*91*/:
                    case C0268R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                    case '{':
                    case '}':
                        break;
                    case C0268R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case C0268R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    case C0268R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    case C0268R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    case C0268R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                        m5409f();
                        break;
                    default:
                        i++;
                }
                this.f4819f = i + this.f4819f;
                return;
            }
            this.f4819f = i + this.f4819f;
        } while (m5404b(1));
    }

    public int nextInt() {
        int i = this.f4815a;
        if (i == 0) {
            i = m5414a();
        }
        int[] iArr;
        int i2;
        if (i == 15) {
            i = (int) this.f4823j;
            if (this.f4823j != ((long) i)) {
                throw new NumberFormatException("Expected an int but was " + this.f4823j + m5411h());
            }
            this.f4815a = 0;
            iArr = this.f4829p;
            i2 = this.f4827n - 1;
            iArr[i2] = iArr[i2] + 1;
        } else {
            if (i == 16) {
                this.f4825l = new String(this.f4818e, this.f4819f, this.f4824k);
                this.f4819f += this.f4824k;
            } else if (i == 8 || i == 9 || i == 10) {
                if (i == 10) {
                    this.f4825l = m5407d();
                } else {
                    this.f4825l = m5403b(i == 8 ? '\'' : '\"');
                }
                try {
                    i = Integer.parseInt(this.f4825l);
                    this.f4815a = 0;
                    iArr = this.f4829p;
                    i2 = this.f4827n - 1;
                    iArr[i2] = iArr[i2] + 1;
                } catch (NumberFormatException e) {
                }
            } else {
                throw new IllegalStateException("Expected an int but was " + peek() + m5411h());
            }
            this.f4815a = 11;
            double parseDouble = Double.parseDouble(this.f4825l);
            i = (int) parseDouble;
            if (((double) i) != parseDouble) {
                throw new NumberFormatException("Expected an int but was " + this.f4825l + m5411h());
            }
            this.f4825l = null;
            this.f4815a = 0;
            iArr = this.f4829p;
            i2 = this.f4827n - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return i;
    }

    public void close() {
        this.f4815a = 0;
        this.f4826m[0] = 8;
        this.f4827n = 1;
        this.f4816c.close();
    }

    public void skipValue() {
        int i = 0;
        do {
            int i2 = this.f4815a;
            if (i2 == 0) {
                i2 = m5414a();
            }
            if (i2 == 3) {
                m5398a(1);
                i++;
            } else if (i2 == 1) {
                m5398a(3);
                i++;
            } else if (i2 == 4) {
                this.f4827n--;
                i--;
            } else if (i2 == 2) {
                this.f4827n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m5408e();
            } else if (i2 == 8 || i2 == 12) {
                m5406c('\'');
            } else if (i2 == 9 || i2 == 13) {
                m5406c('\"');
            } else if (i2 == 16) {
                this.f4819f += this.f4824k;
            }
            this.f4815a = 0;
        } while (i != 0);
        int[] iArr = this.f4829p;
        int i3 = this.f4827n - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f4828o[this.f4827n - 1] = "null";
    }

    private void m5398a(int i) {
        if (this.f4827n == this.f4826m.length) {
            Object obj = new int[(this.f4827n * 2)];
            Object obj2 = new int[(this.f4827n * 2)];
            Object obj3 = new String[(this.f4827n * 2)];
            System.arraycopy(this.f4826m, 0, obj, 0, this.f4827n);
            System.arraycopy(this.f4829p, 0, obj2, 0, this.f4827n);
            System.arraycopy(this.f4828o, 0, obj3, 0, this.f4827n);
            this.f4826m = obj;
            this.f4829p = obj2;
            this.f4828o = obj3;
        }
        int[] iArr = this.f4826m;
        int i2 = this.f4827n;
        this.f4827n = i2 + 1;
        iArr[i2] = i;
    }

    private boolean m5404b(int i) {
        Object obj = this.f4818e;
        this.f4822i -= this.f4819f;
        if (this.f4820g != this.f4819f) {
            this.f4820g -= this.f4819f;
            System.arraycopy(obj, this.f4819f, obj, 0, this.f4820g);
        } else {
            this.f4820g = 0;
        }
        this.f4819f = 0;
        do {
            int read = this.f4816c.read(obj, this.f4820g, obj.length - this.f4820g);
            if (read == -1) {
                return false;
            }
            this.f4820g = read + this.f4820g;
            if (this.f4821h == 0 && this.f4822i == 0 && this.f4820g > 0 && obj[0] == '\ufeff') {
                this.f4819f++;
                this.f4822i++;
                i++;
            }
        } while (this.f4820g < i);
        return true;
    }

    private int m5396a(boolean z) {
        char[] cArr = this.f4818e;
        int i = this.f4819f;
        int i2 = this.f4820g;
        while (true) {
            if (i == i2) {
                this.f4819f = i;
                if (m5404b(1)) {
                    i = this.f4819f;
                    i2 = this.f4820g;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + m5411h());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f4821h++;
                this.f4822i = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.f4819f = i3;
                if (i3 == i2) {
                    this.f4819f--;
                    boolean b = m5404b(2);
                    this.f4819f++;
                    if (!b) {
                        return c;
                    }
                }
                m5409f();
                switch (cArr[this.f4819f]) {
                    case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        this.f4819f++;
                        if (m5400a("*/")) {
                            i = this.f4819f + 2;
                            i2 = this.f4820g;
                            break;
                        }
                        throw m5402b("Unterminated comment");
                    case C0268R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                        this.f4819f++;
                        m5410g();
                        i = this.f4819f;
                        i2 = this.f4820g;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f4819f = i3;
                m5409f();
                m5410g();
                i = this.f4819f;
                i2 = this.f4820g;
            } else {
                this.f4819f = i3;
                return c;
            }
        }
    }

    private void m5409f() {
        if (!this.f4817d) {
            throw m5402b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void m5410g() {
        char c;
        do {
            if (this.f4819f < this.f4820g || m5404b(1)) {
                char[] cArr = this.f4818e;
                int i = this.f4819f;
                this.f4819f = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.f4821h++;
                    this.f4822i = this.f4819f;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean m5400a(String str) {
        while (true) {
            if (this.f4819f + str.length() > this.f4820g && !m5404b(str.length())) {
                return false;
            }
            if (this.f4818e[this.f4819f] == '\n') {
                this.f4821h++;
                this.f4822i = this.f4819f + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.f4818e[this.f4819f + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.f4819f++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + m5411h();
    }

    private String m5411h() {
        return " at line " + (this.f4821h + 1) + " column " + ((this.f4819f - this.f4822i) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.f4827n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f4826m[i2]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    append.append('[').append(this.f4829p[i2]).append(']');
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                case Type.OTHER_PROFILE /*5*/:
                    append.append('.');
                    if (this.f4828o[i2] == null) {
                        break;
                    }
                    append.append(this.f4828o[i2]);
                    break;
                default:
                    break;
            }
        }
        return append.toString();
    }

    private char m5412i() {
        if (this.f4819f != this.f4820g || m5404b(1)) {
            char[] cArr = this.f4818e;
            int i = this.f4819f;
            this.f4819f = i + 1;
            char c = cArr[i];
            switch (c) {
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    this.f4821h++;
                    this.f4822i = this.f4819f;
                    return c;
                case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                case C0268R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                case C0268R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                case C0268R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                    return c;
                case C0268R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                    return '\b';
                case C0268R.styleable.AppCompatTheme_buttonStyle /*102*/:
                    return '\f';
                case C0268R.styleable.AppCompatTheme_ratingBarStyleSmall /*110*/:
                    return '\n';
                case C0268R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.f4819f + 4 <= this.f4820g || m5404b(4)) {
                        int i2 = this.f4819f;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = '\u0000';
                        for (i = i4; i < i3; i++) {
                            char c2 = this.f4818e[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < 'A' || c2 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f4818e, this.f4819f, 4));
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                        }
                        this.f4819f += 4;
                        return c;
                    }
                    throw m5402b("Unterminated escape sequence");
                default:
                    throw m5402b("Invalid escape sequence");
            }
        }
        throw m5402b("Unterminated escape sequence");
    }

    private IOException m5402b(String str) {
        throw new MalformedJsonException(str + m5411h());
    }

    private void m5413j() {
        m5396a(true);
        this.f4819f--;
        if (this.f4819f + f4814b.length <= this.f4820g || m5404b(f4814b.length)) {
            int i = 0;
            while (i < f4814b.length) {
                if (this.f4818e[this.f4819f + i] == f4814b[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f4819f += f4814b.length;
        }
    }
}
