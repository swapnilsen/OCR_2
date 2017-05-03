package com.p013a.p014a.p015a;

import com.p013a.p014a.p015a.JsonGenerator.JsonGenerator;
import com.p013a.p014a.p015a.JsonParser.JsonParser;
import com.p013a.p014a.p015a.p017b.CharacterEscapes;
import com.p013a.p014a.p015a.p017b.IOContext;
import com.p013a.p014a.p015a.p017b.InputDecorator;
import com.p013a.p014a.p015a.p017b.OutputDecorator;
import com.p013a.p014a.p015a.p017b.UTF8Writer;
import com.p013a.p014a.p015a.p018c.ByteSourceJsonBootstrapper;
import com.p013a.p014a.p015a.p018c.ReaderBasedJsonParser;
import com.p013a.p014a.p015a.p018c.UTF8JsonGenerator;
import com.p013a.p014a.p015a.p018c.WriterBasedJsonGenerator;
import com.p013a.p014a.p015a.p019d.BytesToNameCanonicalizer;
import com.p013a.p014a.p015a.p019d.CharsToNameCanonicalizer;
import com.p013a.p014a.p015a.p020e.BufferRecycler;
import com.p013a.p014a.p015a.p020e.DefaultPrettyPrinter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;

/* renamed from: com.a.a.a.b */
public class JsonFactory implements Serializable {
    protected static final int f469a;
    protected static final int f470b;
    protected static final int f471c;
    protected static final ThreadLocal<SoftReference<BufferRecycler>> f472d;
    private static final SerializableString f473o;
    protected final transient CharsToNameCanonicalizer f474e;
    protected final transient BytesToNameCanonicalizer f475f;
    protected ObjectCodec f476g;
    protected int f477h;
    protected int f478i;
    protected int f479j;
    protected CharacterEscapes f480k;
    protected InputDecorator f481l;
    protected OutputDecorator f482m;
    protected SerializableString f483n;

    /* renamed from: com.a.a.a.b.a */
    public enum JsonFactory {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true);
        
        private final boolean f406c;

        public static int m548a() {
            int i = 0;
            for (JsonFactory jsonFactory : JsonFactory.values()) {
                if (jsonFactory.m549b()) {
                    i |= jsonFactory.m550c();
                }
            }
            return i;
        }

        private JsonFactory(boolean z) {
            this.f406c = z;
        }

        public boolean m549b() {
            return this.f406c;
        }

        public int m550c() {
            return 1 << ordinal();
        }
    }

    static {
        f469a = JsonFactory.m548a();
        f470b = JsonParser.m977a();
        f471c = JsonGenerator.m840a();
        f473o = DefaultPrettyPrinter.f636a;
        f472d = new ThreadLocal();
    }

    public JsonFactory() {
        this(null);
    }

    public JsonFactory(ObjectCodec objectCodec) {
        this.f474e = CharsToNameCanonicalizer.m875a();
        this.f475f = BytesToNameCanonicalizer.m846a();
        this.f477h = f469a;
        this.f478i = f470b;
        this.f479j = f471c;
        this.f483n = f473o;
        this.f476g = objectCodec;
    }

    public final boolean m625a(JsonFactory jsonFactory) {
        return (this.f477h & jsonFactory.m550c()) != 0;
    }

    public final JsonFactory m613a(JsonGenerator jsonGenerator, boolean z) {
        return z ? m612a(jsonGenerator) : m626b(jsonGenerator);
    }

    public JsonFactory m612a(JsonGenerator jsonGenerator) {
        this.f479j |= jsonGenerator.m842c();
        return this;
    }

    public JsonFactory m626b(JsonGenerator jsonGenerator) {
        this.f479j &= jsonGenerator.m842c() ^ -1;
        return this;
    }

    public JsonParser m619a(InputStream inputStream) {
        IOContext a = m611a((Object) inputStream, false);
        if (this.f481l != null) {
            inputStream = this.f481l.m580a(a, inputStream);
        }
        return m620a(inputStream, a);
    }

    public JsonParser m621a(Reader reader) {
        IOContext a = m611a((Object) reader, false);
        if (this.f481l != null) {
            reader = this.f481l.m581a(a, reader);
        }
        return m622a(reader, a);
    }

    public JsonParser m623a(String str) {
        Reader stringReader = new StringReader(str);
        IOContext a = m611a((Object) stringReader, true);
        if (this.f481l != null) {
            stringReader = this.f481l.m581a(a, stringReader);
        }
        return m622a(stringReader, a);
    }

    public JsonGenerator m614a(OutputStream outputStream, JsonEncoding jsonEncoding) {
        IOContext a = m611a((Object) outputStream, false);
        a.m567a(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            if (this.f482m != null) {
                outputStream = this.f482m.m600a(a, outputStream);
            }
            return m615a(outputStream, a);
        }
        Writer a2 = m624a(outputStream, jsonEncoding, a);
        if (this.f482m != null) {
            a2 = this.f482m.m601a(a, a2);
        }
        return m617a(a2, a);
    }

    public JsonGenerator m616a(Writer writer) {
        IOContext a = m611a((Object) writer, false);
        if (this.f482m != null) {
            writer = this.f482m.m601a(a, writer);
        }
        return m617a(writer, a);
    }

    protected JsonParser m620a(InputStream inputStream, IOContext iOContext) {
        return m628b(inputStream, iOContext);
    }

    @Deprecated
    protected JsonParser m628b(InputStream inputStream, IOContext iOContext) {
        return new ByteSourceJsonBootstrapper(iOContext, inputStream).m635a(this.f478i, this.f476g, this.f475f, this.f474e, m625a(JsonFactory.CANONICALIZE_FIELD_NAMES), m625a(JsonFactory.INTERN_FIELD_NAMES));
    }

    protected JsonParser m622a(Reader reader, IOContext iOContext) {
        return m629b(reader, iOContext);
    }

    @Deprecated
    protected JsonParser m629b(Reader reader, IOContext iOContext) {
        return new ReaderBasedJsonParser(iOContext, this.f478i, reader, this.f476g, this.f474e.m885a(m625a(JsonFactory.CANONICALIZE_FIELD_NAMES), m625a(JsonFactory.INTERN_FIELD_NAMES)));
    }

    protected JsonGenerator m617a(Writer writer, IOContext iOContext) {
        return m627b(writer, iOContext);
    }

    @Deprecated
    protected JsonGenerator m627b(Writer writer, IOContext iOContext) {
        JsonGenerator writerBasedJsonGenerator = new WriterBasedJsonGenerator(iOContext, this.f479j, this.f476g, writer);
        if (this.f480k != null) {
            writerBasedJsonGenerator.m639a(this.f480k);
        }
        SerializableString serializableString = this.f483n;
        if (serializableString != f473o) {
            writerBasedJsonGenerator.m640a(serializableString);
        }
        return writerBasedJsonGenerator;
    }

    @Deprecated
    protected JsonGenerator m615a(OutputStream outputStream, IOContext iOContext) {
        JsonGenerator uTF8JsonGenerator = new UTF8JsonGenerator(iOContext, this.f479j, this.f476g, outputStream);
        if (this.f480k != null) {
            uTF8JsonGenerator.m639a(this.f480k);
        }
        SerializableString serializableString = this.f483n;
        if (serializableString != f473o) {
            uTF8JsonGenerator.m640a(serializableString);
        }
        return uTF8JsonGenerator;
    }

    protected Writer m624a(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) {
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new UTF8Writer(iOContext, outputStream);
        }
        return new OutputStreamWriter(outputStream, jsonEncoding.m546a());
    }

    protected IOContext m611a(Object obj, boolean z) {
        return new IOContext(m618a(), obj, z);
    }

    public BufferRecycler m618a() {
        SoftReference softReference = (SoftReference) f472d.get();
        BufferRecycler bufferRecycler = softReference == null ? null : (BufferRecycler) softReference.get();
        if (bufferRecycler != null) {
            return bufferRecycler;
        }
        bufferRecycler = new BufferRecycler();
        f472d.set(new SoftReference(bufferRecycler));
        return bufferRecycler;
    }
}
