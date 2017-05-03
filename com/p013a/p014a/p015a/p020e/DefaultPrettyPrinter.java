package com.p013a.p014a.p015a.p020e;

import com.p013a.p014a.p015a.JsonGenerator;
import com.p013a.p014a.p015a.PrettyPrinter;
import com.p013a.p014a.p015a.SerializableString;
import com.p013a.p014a.p015a.p017b.SerializedString;
import java.io.Serializable;
import java.util.Arrays;

/* renamed from: com.a.a.a.e.c */
public class DefaultPrettyPrinter implements PrettyPrinter, Serializable {
    public static final SerializedString f636a;
    protected DefaultPrettyPrinter f637b;
    protected DefaultPrettyPrinter f638c;
    protected final SerializableString f639d;
    protected boolean f640e;
    protected transient int f641f;

    /* renamed from: com.a.a.a.e.c.b */
    public interface DefaultPrettyPrinter {
        void m924a(JsonGenerator jsonGenerator, int i);

        boolean m925a();
    }

    /* renamed from: com.a.a.a.e.c.a */
    public static class DefaultPrettyPrinter implements DefaultPrettyPrinter, Serializable {
        public static DefaultPrettyPrinter f632a;

        static {
            f632a = new DefaultPrettyPrinter();
        }

        public void m926a(JsonGenerator jsonGenerator, int i) {
            jsonGenerator.m454a(' ');
        }

        public boolean m927a() {
            return true;
        }
    }

    /* renamed from: com.a.a.a.e.c.c */
    public static class DefaultPrettyPrinter implements DefaultPrettyPrinter, Serializable {
        public static DefaultPrettyPrinter f633a;
        static final String f634b;
        static final char[] f635c;

        static {
            f633a = new DefaultPrettyPrinter();
            String str = null;
            try {
                str = System.getProperty("line.separator");
            } catch (Throwable th) {
            }
            if (str == null) {
                str = "\n";
            }
            f634b = str;
            f635c = new char[64];
            Arrays.fill(f635c, ' ');
        }

        public boolean m929a() {
            return false;
        }

        public void m928a(JsonGenerator jsonGenerator, int i) {
            jsonGenerator.m468c(f634b);
            if (i > 0) {
                int i2 = i + i;
                while (i2 > 64) {
                    jsonGenerator.m462a(f635c, 0, 64);
                    i2 -= f635c.length;
                }
                jsonGenerator.m462a(f635c, 0, i2);
            }
        }
    }

    static {
        f636a = new SerializedString(" ");
    }

    public DefaultPrettyPrinter() {
        this(f636a);
    }

    public DefaultPrettyPrinter(SerializableString serializableString) {
        this.f637b = DefaultPrettyPrinter.f632a;
        this.f638c = DefaultPrettyPrinter.f633a;
        this.f640e = true;
        this.f641f = 0;
        this.f639d = serializableString;
    }

    public void m940a(JsonGenerator jsonGenerator) {
        if (this.f639d != null) {
            jsonGenerator.m465b(this.f639d);
        }
    }

    public void m942b(JsonGenerator jsonGenerator) {
        jsonGenerator.m454a('{');
        if (!this.f638c.m925a()) {
            this.f641f++;
        }
    }

    public void m949h(JsonGenerator jsonGenerator) {
        this.f638c.m924a(jsonGenerator, this.f641f);
    }

    public void m945d(JsonGenerator jsonGenerator) {
        if (this.f640e) {
            jsonGenerator.m468c(" : ");
        } else {
            jsonGenerator.m454a(':');
        }
    }

    public void m944c(JsonGenerator jsonGenerator) {
        jsonGenerator.m454a(',');
        this.f638c.m924a(jsonGenerator, this.f641f);
    }

    public void m941a(JsonGenerator jsonGenerator, int i) {
        if (!this.f638c.m925a()) {
            this.f641f--;
        }
        if (i > 0) {
            this.f638c.m924a(jsonGenerator, this.f641f);
        } else {
            jsonGenerator.m454a(' ');
        }
        jsonGenerator.m454a('}');
    }

    public void m946e(JsonGenerator jsonGenerator) {
        if (!this.f637b.m925a()) {
            this.f641f++;
        }
        jsonGenerator.m454a('[');
    }

    public void m948g(JsonGenerator jsonGenerator) {
        this.f637b.m924a(jsonGenerator, this.f641f);
    }

    public void m947f(JsonGenerator jsonGenerator) {
        jsonGenerator.m454a(',');
        this.f637b.m924a(jsonGenerator, this.f641f);
    }

    public void m943b(JsonGenerator jsonGenerator, int i) {
        if (!this.f637b.m925a()) {
            this.f641f--;
        }
        if (i > 0) {
            this.f637b.m924a(jsonGenerator, this.f641f);
        } else {
            jsonGenerator.m454a(' ');
        }
        jsonGenerator.m454a(']');
    }
}
