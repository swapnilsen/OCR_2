package com.google.gson.stream;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import net.nend.android.NendIconError;

public class JsonWriter implements Closeable, Flushable {
    private static final String[] f4836a;
    private static final String[] f4837b;
    private final Writer f4838c;
    private int[] f4839d;
    private int f4840e;
    private String f4841f;
    private String f4842g;
    private boolean f4843h;
    private boolean f4844i;
    private String f4845j;
    private boolean f4846k;

    static {
        f4836a = new String[AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS];
        for (int i = 0; i <= 31; i++) {
            f4836a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f4836a[34] = "\\\"";
        f4836a[92] = "\\\\";
        f4836a[9] = "\\t";
        f4836a[8] = "\\b";
        f4836a[10] = "\\n";
        f4836a[13] = "\\r";
        f4836a[12] = "\\f";
        f4837b = (String[]) f4836a.clone();
        f4837b[60] = "\\u003c";
        f4837b[62] = "\\u003e";
        f4837b[38] = "\\u0026";
        f4837b[61] = "\\u003d";
        f4837b[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        this.f4839d = new int[32];
        this.f4840e = 0;
        m5423a(6);
        this.f4842g = ":";
        this.f4846k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f4838c = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.f4841f = null;
            this.f4842g = ":";
            return;
        }
        this.f4841f = str;
        this.f4842g = ": ";
    }

    public final void setLenient(boolean z) {
        this.f4843h = z;
    }

    public boolean isLenient() {
        return this.f4843h;
    }

    public final void setHtmlSafe(boolean z) {
        this.f4844i = z;
    }

    public final boolean isHtmlSafe() {
        return this.f4844i;
    }

    public final void setSerializeNulls(boolean z) {
        this.f4846k = z;
    }

    public final boolean getSerializeNulls() {
        return this.f4846k;
    }

    public JsonWriter beginArray() {
        m5425b();
        return m5422a(1, "[");
    }

    public JsonWriter endArray() {
        return m5421a(1, 2, "]");
    }

    public JsonWriter beginObject() {
        m5425b();
        return m5422a(3, "{");
    }

    public JsonWriter endObject() {
        return m5421a(3, 5, "}");
    }

    private JsonWriter m5422a(int i, String str) {
        m5429e();
        m5423a(i);
        this.f4838c.write(str);
        return this;
    }

    private JsonWriter m5421a(int i, int i2, String str) {
        int a = m5420a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f4845j != null) {
            throw new IllegalStateException("Dangling name: " + this.f4845j);
        } else {
            this.f4840e--;
            if (a == i2) {
                m5427c();
            }
            this.f4838c.write(str);
            return this;
        }
    }

    private void m5423a(int i) {
        if (this.f4840e == this.f4839d.length) {
            Object obj = new int[(this.f4840e * 2)];
            System.arraycopy(this.f4839d, 0, obj, 0, this.f4840e);
            this.f4839d = obj;
        }
        int[] iArr = this.f4839d;
        int i2 = this.f4840e;
        this.f4840e = i2 + 1;
        iArr[i2] = i;
    }

    private int m5420a() {
        if (this.f4840e != 0) {
            return this.f4839d[this.f4840e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void m5426b(int i) {
        this.f4839d[this.f4840e - 1] = i;
    }

    public JsonWriter name(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f4845j != null) {
            throw new IllegalStateException();
        } else if (this.f4840e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f4845j = str;
            return this;
        }
    }

    private void m5425b() {
        if (this.f4845j != null) {
            m5428d();
            m5424a(this.f4845j);
            this.f4845j = null;
        }
    }

    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        m5425b();
        m5429e();
        m5424a(str);
        return this;
    }

    public JsonWriter jsonValue(String str) {
        if (str == null) {
            return nullValue();
        }
        m5425b();
        m5429e();
        this.f4838c.append(str);
        return this;
    }

    public JsonWriter nullValue() {
        if (this.f4845j != null) {
            if (this.f4846k) {
                m5425b();
            } else {
                this.f4845j = null;
                return this;
            }
        }
        m5429e();
        this.f4838c.write("null");
        return this;
    }

    public JsonWriter value(boolean z) {
        m5425b();
        m5429e();
        this.f4838c.write(z ? "true" : "false");
        return this;
    }

    public JsonWriter value(Boolean bool) {
        if (bool == null) {
            return nullValue();
        }
        m5425b();
        m5429e();
        this.f4838c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public JsonWriter value(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        m5425b();
        m5429e();
        this.f4838c.append(Double.toString(d));
        return this;
    }

    public JsonWriter value(long j) {
        m5425b();
        m5429e();
        this.f4838c.write(Long.toString(j));
        return this;
    }

    public JsonWriter value(Number number) {
        if (number == null) {
            return nullValue();
        }
        m5425b();
        CharSequence obj = number.toString();
        if (this.f4843h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            m5429e();
            this.f4838c.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public void flush() {
        if (this.f4840e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f4838c.flush();
    }

    public void close() {
        this.f4838c.close();
        int i = this.f4840e;
        if (i > 1 || (i == 1 && this.f4839d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f4840e = 0;
    }

    private void m5424a(String str) {
        int i = 0;
        String[] strArr = this.f4844i ? f4837b : f4836a;
        this.f4838c.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String str2;
            if (charAt < '\u0080') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    this.f4838c.write(str, i, i2 - i);
                }
                this.f4838c.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == '\u2028') {
                    str2 = "\\u2028";
                } else if (charAt == '\u2029') {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.f4838c.write(str, i, i2 - i);
                }
                this.f4838c.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.f4838c.write(str, i, length - i);
        }
        this.f4838c.write("\"");
    }

    private void m5427c() {
        if (this.f4841f != null) {
            this.f4838c.write("\n");
            int i = this.f4840e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f4838c.write(this.f4841f);
            }
        }
    }

    private void m5428d() {
        int a = m5420a();
        if (a == 5) {
            this.f4838c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m5427c();
        m5426b(4);
    }

    private void m5429e() {
        switch (m5420a()) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                m5426b(2);
                m5427c();
                return;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                this.f4838c.append(',');
                m5427c();
                return;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                this.f4838c.append(this.f4842g);
                m5426b(5);
                return;
            case Type.CONTRIBUTOR /*6*/:
                break;
            case Type.WEBSITE /*7*/:
                if (!this.f4843h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        m5426b(7);
    }
}
