package com.google.gson.internal.bind;

import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import net.nend.android.NendIconError;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;

public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Currency> CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.1 */
    static class C15781 extends TypeAdapter<Class> {
        C15781() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5468a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5469a(jsonWriter, (Class) obj);
        }

        public void m5469a(JsonWriter jsonWriter, Class cls) {
            if (cls == null) {
                jsonWriter.nullValue();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        public Class m5468a(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.25 */
    static class AnonymousClass25 implements TypeAdapterFactory {
        final /* synthetic */ TypeToken f4893a;
        final /* synthetic */ TypeAdapter f4894b;

        AnonymousClass25(TypeToken typeToken, TypeAdapter typeAdapter) {
            this.f4893a = typeToken;
            this.f4894b = typeAdapter;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            return typeToken.equals(this.f4893a) ? this.f4894b : null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.26 */
    static class AnonymousClass26 implements TypeAdapterFactory {
        final /* synthetic */ Class f4895a;
        final /* synthetic */ TypeAdapter f4896b;

        AnonymousClass26(Class cls, TypeAdapter typeAdapter) {
            this.f4895a = cls;
            this.f4896b = typeAdapter;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            return typeToken.getRawType() == this.f4895a ? this.f4896b : null;
        }

        public String toString() {
            return "Factory[type=" + this.f4895a.getName() + ",adapter=" + this.f4896b + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.27 */
    static class AnonymousClass27 implements TypeAdapterFactory {
        final /* synthetic */ Class f4897a;
        final /* synthetic */ Class f4898b;
        final /* synthetic */ TypeAdapter f4899c;

        AnonymousClass27(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.f4897a = cls;
            this.f4898b = cls2;
            this.f4899c = typeAdapter;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class rawType = typeToken.getRawType();
            return (rawType == this.f4897a || rawType == this.f4898b) ? this.f4899c : null;
        }

        public String toString() {
            return "Factory[type=" + this.f4898b.getName() + "+" + this.f4897a.getName() + ",adapter=" + this.f4899c + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.28 */
    static class AnonymousClass28 implements TypeAdapterFactory {
        final /* synthetic */ Class f4900a;
        final /* synthetic */ Class f4901b;
        final /* synthetic */ TypeAdapter f4902c;

        AnonymousClass28(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.f4900a = cls;
            this.f4901b = cls2;
            this.f4902c = typeAdapter;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class rawType = typeToken.getRawType();
            return (rawType == this.f4900a || rawType == this.f4901b) ? this.f4902c : null;
        }

        public String toString() {
            return "Factory[type=" + this.f4900a.getName() + "+" + this.f4901b.getName() + ",adapter=" + this.f4902c + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.29 */
    static class AnonymousClass29 implements TypeAdapterFactory {
        final /* synthetic */ Class f4905a;
        final /* synthetic */ TypeAdapter f4906b;

        /* renamed from: com.google.gson.internal.bind.TypeAdapters.29.1 */
        class C15791 extends TypeAdapter<T1> {
            final /* synthetic */ Class f4903a;
            final /* synthetic */ AnonymousClass29 f4904b;

            C15791(AnonymousClass29 anonymousClass29, Class cls) {
                this.f4904b = anonymousClass29;
                this.f4903a = cls;
            }

            public void write(JsonWriter jsonWriter, T1 t1) {
                this.f4904b.f4906b.write(jsonWriter, t1);
            }

            public T1 read(JsonReader jsonReader) {
                T1 read = this.f4904b.f4906b.read(jsonReader);
                if (read == null || this.f4903a.isInstance(read)) {
                    return read;
                }
                throw new JsonSyntaxException("Expected a " + this.f4903a.getName() + " but was " + read.getClass().getName());
            }
        }

        AnonymousClass29(Class cls, TypeAdapter typeAdapter) {
            this.f4905a = cls;
            this.f4906b = typeAdapter;
        }

        public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
            Class rawType = typeToken.getRawType();
            if (this.f4905a.isAssignableFrom(rawType)) {
                return new C15791(this, rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f4905a.getName() + ",adapter=" + this.f4906b + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.2 */
    static class C15802 extends TypeAdapter<AtomicIntegerArray> {
        C15802() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5478a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5479a(jsonWriter, (AtomicIntegerArray) obj);
        }

        public AtomicIntegerArray m5478a(JsonReader jsonReader) {
            List arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        public void m5479a(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value((long) atomicIntegerArray.get(i));
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.30 */
    static /* synthetic */ class AnonymousClass30 {
        static final /* synthetic */ int[] f4907a;

        static {
            f4907a = new int[JsonToken.values().length];
            try {
                f4907a[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4907a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4907a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4907a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4907a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4907a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4907a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4907a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f4907a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f4907a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.3 */
    static class C15813 extends TypeAdapter<Number> {
        C15813() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5492a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5493a(jsonWriter, (Number) obj);
        }

        public Number m5492a(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void m5493a(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.4 */
    static class C15824 extends TypeAdapter<Number> {
        C15824() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5494a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5495a(jsonWriter, (Number) obj);
        }

        public Number m5494a(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void m5495a(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.5 */
    static class C15835 extends TypeAdapter<Number> {
        C15835() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5496a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5497a(jsonWriter, (Number) obj);
        }

        public Number m5496a(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void m5497a(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.6 */
    static class C15846 extends TypeAdapter<Number> {
        C15846() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5498a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5499a(jsonWriter, (Number) obj);
        }

        public Number m5498a(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            switch (AnonymousClass30.f4907a[peek.ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    return new LazilyParsedNumber(jsonReader.nextString());
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    jsonReader.nextNull();
                    return null;
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + peek);
            }
        }

        public void m5499a(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.7 */
    static class C15857 extends TypeAdapter<Character> {
        C15857() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5500a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5501a(jsonWriter, (Character) obj);
        }

        public Character m5500a(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + nextString);
        }

        public void m5501a(JsonWriter jsonWriter, Character ch) {
            jsonWriter.value(ch == null ? null : String.valueOf(ch));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.8 */
    static class C15868 extends TypeAdapter<String> {
        C15868() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5502a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5503a(jsonWriter, (String) obj);
        }

        public String m5502a(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            } else if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            } else {
                return jsonReader.nextString();
            }
        }

        public void m5503a(JsonWriter jsonWriter, String str) {
            jsonWriter.value(str);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.9 */
    static class C15879 extends TypeAdapter<BigDecimal> {
        C15879() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5504a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5505a(jsonWriter, (BigDecimal) obj);
        }

        public BigDecimal m5504a(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.nextString());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void m5505a(JsonWriter jsonWriter, BigDecimal bigDecimal) {
            jsonWriter.value((Number) bigDecimal);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.a */
    private static final class C1588a<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> f4908a;
        private final Map<T, String> f4909b;

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5506a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5507a(jsonWriter, (Enum) obj);
        }

        public C1588a(Class<T> cls) {
            this.f4908a = new HashMap();
            this.f4909b = new HashMap();
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    SerializedName serializedName = (SerializedName) cls.getField(name).getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        name = serializedName.value();
                        for (Object put : serializedName.alternate()) {
                            this.f4908a.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.f4908a.put(str, enumR);
                    this.f4909b.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public T m5506a(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return (Enum) this.f4908a.get(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        public void m5507a(JsonWriter jsonWriter, T t) {
            jsonWriter.value(t == null ? null : (String) this.f4909b.get(t));
        }
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    static {
        CLASS = new C15781();
        CLASS_FACTORY = newFactory(Class.class, CLASS);
        BIT_SET = new TypeAdapter<BitSet>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5452a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5453a(jsonWriter, (BitSet) obj);
            }

            public BitSet m5452a(JsonReader jsonReader) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                BitSet bitSet = new BitSet();
                jsonReader.beginArray();
                JsonToken peek = jsonReader.peek();
                int i = 0;
                while (peek != JsonToken.END_ARRAY) {
                    boolean z;
                    switch (AnonymousClass30.f4907a[peek.ordinal()]) {
                        case NendIconError.ERROR_ICONVIEW /*1*/:
                            if (jsonReader.nextInt() == 0) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            z = jsonReader.nextBoolean();
                            break;
                        case SendException.ERROR_TTL_EXCEEDED /*3*/:
                            String nextString = jsonReader.nextString();
                            try {
                                if (Integer.parseInt(nextString) == 0) {
                                    z = false;
                                    break;
                                }
                                z = true;
                                break;
                            } catch (NumberFormatException e) {
                                throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + nextString);
                            }
                        default:
                            throw new JsonSyntaxException("Invalid bitset value type: " + peek);
                    }
                    if (z) {
                        bitSet.set(i);
                    }
                    i++;
                    peek = jsonReader.peek();
                }
                jsonReader.endArray();
                return bitSet;
            }

            public void m5453a(JsonWriter jsonWriter, BitSet bitSet) {
                if (bitSet == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginArray();
                for (int i = 0; i < bitSet.length(); i++) {
                    int i2;
                    if (bitSet.get(i)) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    jsonWriter.value((long) i2);
                }
                jsonWriter.endArray();
            }
        };
        BIT_SET_FACTORY = newFactory(BitSet.class, BIT_SET);
        BOOLEAN = new TypeAdapter<Boolean>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5476a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5477a(jsonWriter, (Boolean) obj);
            }

            public Boolean m5476a(JsonReader jsonReader) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
                } else {
                    return Boolean.valueOf(jsonReader.nextBoolean());
                }
            }

            public void m5477a(JsonWriter jsonWriter, Boolean bool) {
                jsonWriter.value(bool);
            }
        };
        BOOLEAN_AS_STRING = new TypeAdapter<Boolean>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5480a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5481a(jsonWriter, (Boolean) obj);
            }

            public Boolean m5480a(JsonReader jsonReader) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Boolean.valueOf(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            public void m5481a(JsonWriter jsonWriter, Boolean bool) {
                jsonWriter.value(bool == null ? "null" : bool.toString());
            }
        };
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
        BYTE = new TypeAdapter<Number>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5482a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5483a(jsonWriter, (Number) obj);
            }

            public Number m5482a(JsonReader jsonReader) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) jsonReader.nextInt());
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }

            public void m5483a(JsonWriter jsonWriter, Number number) {
                jsonWriter.value(number);
            }
        };
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, BYTE);
        SHORT = new TypeAdapter<Number>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5484a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5485a(jsonWriter, (Number) obj);
            }

            public Number m5484a(JsonReader jsonReader) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Short.valueOf((short) jsonReader.nextInt());
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }

            public void m5485a(JsonWriter jsonWriter, Number number) {
                jsonWriter.value(number);
            }
        };
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, SHORT);
        INTEGER = new TypeAdapter<Number>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5486a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5487a(jsonWriter, (Number) obj);
            }

            public Number m5486a(JsonReader jsonReader) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.nextInt());
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }

            public void m5487a(JsonWriter jsonWriter, Number number) {
                jsonWriter.value(number);
            }
        };
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, INTEGER);
        ATOMIC_INTEGER = new TypeAdapter<AtomicInteger>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5488a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5489a(jsonWriter, (AtomicInteger) obj);
            }

            public AtomicInteger m5488a(JsonReader jsonReader) {
                try {
                    return new AtomicInteger(jsonReader.nextInt());
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }

            public void m5489a(JsonWriter jsonWriter, AtomicInteger atomicInteger) {
                jsonWriter.value((long) atomicInteger.get());
            }
        }.nullSafe();
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, ATOMIC_INTEGER);
        ATOMIC_BOOLEAN = new TypeAdapter<AtomicBoolean>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5490a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5491a(jsonWriter, (AtomicBoolean) obj);
            }

            public AtomicBoolean m5490a(JsonReader jsonReader) {
                return new AtomicBoolean(jsonReader.nextBoolean());
            }

            public void m5491a(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) {
                jsonWriter.value(atomicBoolean.get());
            }
        }.nullSafe();
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, ATOMIC_BOOLEAN);
        ATOMIC_INTEGER_ARRAY = new C15802().nullSafe();
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, ATOMIC_INTEGER_ARRAY);
        LONG = new C15813();
        FLOAT = new C15824();
        DOUBLE = new C15835();
        NUMBER = new C15846();
        NUMBER_FACTORY = newFactory(Number.class, NUMBER);
        CHARACTER = new C15857();
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, CHARACTER);
        STRING = new C15868();
        BIG_DECIMAL = new C15879();
        BIG_INTEGER = new TypeAdapter<BigInteger>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5448a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5449a(jsonWriter, (BigInteger) obj);
            }

            public BigInteger m5448a(JsonReader jsonReader) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return new BigInteger(jsonReader.nextString());
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }

            public void m5449a(JsonWriter jsonWriter, BigInteger bigInteger) {
                jsonWriter.value((Number) bigInteger);
            }
        };
        STRING_FACTORY = newFactory(String.class, STRING);
        STRING_BUILDER = new TypeAdapter<StringBuilder>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5450a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5451a(jsonWriter, (StringBuilder) obj);
            }

            public StringBuilder m5450a(JsonReader jsonReader) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new StringBuilder(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            public void m5451a(JsonWriter jsonWriter, StringBuilder stringBuilder) {
                jsonWriter.value(stringBuilder == null ? null : stringBuilder.toString());
            }
        };
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, STRING_BUILDER);
        STRING_BUFFER = new TypeAdapter<StringBuffer>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5454a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5455a(jsonWriter, (StringBuffer) obj);
            }

            public StringBuffer m5454a(JsonReader jsonReader) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new StringBuffer(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            public void m5455a(JsonWriter jsonWriter, StringBuffer stringBuffer) {
                jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, STRING_BUFFER);
        URL = new TypeAdapter<URL>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5456a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5457a(jsonWriter, (URL) obj);
            }

            public URL m5456a(JsonReader jsonReader) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String nextString = jsonReader.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URL(nextString);
            }

            public void m5457a(JsonWriter jsonWriter, URL url) {
                jsonWriter.value(url == null ? null : url.toExternalForm());
            }
        };
        URL_FACTORY = newFactory(URL.class, URL);
        URI = new TypeAdapter<URI>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5458a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5459a(jsonWriter, (URI) obj);
            }

            public URI m5458a(JsonReader jsonReader) {
                URI uri = null;
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    try {
                        String nextString = jsonReader.nextString();
                        if (!"null".equals(nextString)) {
                            uri = new URI(nextString);
                        }
                    } catch (Throwable e) {
                        throw new JsonIOException(e);
                    }
                }
                return uri;
            }

            public void m5459a(JsonWriter jsonWriter, URI uri) {
                jsonWriter.value(uri == null ? null : uri.toASCIIString());
            }
        };
        URI_FACTORY = newFactory(URI.class, URI);
        INET_ADDRESS = new TypeAdapter<InetAddress>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5460a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5461a(jsonWriter, (InetAddress) obj);
            }

            public InetAddress m5460a(JsonReader jsonReader) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return InetAddress.getByName(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            public void m5461a(JsonWriter jsonWriter, InetAddress inetAddress) {
                jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
        UUID = new TypeAdapter<UUID>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5462a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5463a(jsonWriter, (UUID) obj);
            }

            public UUID m5462a(JsonReader jsonReader) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return UUID.fromString(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            public void m5463a(JsonWriter jsonWriter, UUID uuid) {
                jsonWriter.value(uuid == null ? null : uuid.toString());
            }
        };
        UUID_FACTORY = newFactory(UUID.class, UUID);
        CURRENCY = new TypeAdapter<Currency>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5464a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5465a(jsonWriter, (Currency) obj);
            }

            public Currency m5464a(JsonReader jsonReader) {
                return Currency.getInstance(jsonReader.nextString());
            }

            public void m5465a(JsonWriter jsonWriter, Currency currency) {
                jsonWriter.value(currency.getCurrencyCode());
            }
        }.nullSafe();
        CURRENCY_FACTORY = newFactory(Currency.class, CURRENCY);
        TIMESTAMP_FACTORY = new TypeAdapterFactory() {

            /* renamed from: com.google.gson.internal.bind.TypeAdapters.19.1 */
            class C15771 extends TypeAdapter<Timestamp> {
                final /* synthetic */ TypeAdapter f4891a;
                final /* synthetic */ AnonymousClass19 f4892b;

                C15771(AnonymousClass19 anonymousClass19, TypeAdapter typeAdapter) {
                    this.f4892b = anonymousClass19;
                    this.f4891a = typeAdapter;
                }

                public /* synthetic */ Object read(JsonReader jsonReader) {
                    return m5466a(jsonReader);
                }

                public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                    m5467a(jsonWriter, (Timestamp) obj);
                }

                public Timestamp m5466a(JsonReader jsonReader) {
                    Date date = (Date) this.f4891a.read(jsonReader);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }

                public void m5467a(JsonWriter jsonWriter, Timestamp timestamp) {
                    this.f4891a.write(jsonWriter, timestamp);
                }
            }

            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                return new C15771(this, gson.getAdapter(Date.class));
            }
        };
        CALENDAR = new TypeAdapter<Calendar>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5470a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5471a(jsonWriter, (Calendar) obj);
            }

            public Calendar m5470a(JsonReader jsonReader) {
                int i = 0;
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                jsonReader.beginObject();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String nextName = jsonReader.nextName();
                    int nextInt = jsonReader.nextInt();
                    if ("year".equals(nextName)) {
                        i6 = nextInt;
                    } else if ("month".equals(nextName)) {
                        i5 = nextInt;
                    } else if ("dayOfMonth".equals(nextName)) {
                        i4 = nextInt;
                    } else if ("hourOfDay".equals(nextName)) {
                        i3 = nextInt;
                    } else if ("minute".equals(nextName)) {
                        i2 = nextInt;
                    } else if ("second".equals(nextName)) {
                        i = nextInt;
                    }
                }
                jsonReader.endObject();
                return new GregorianCalendar(i6, i5, i4, i3, i2, i);
            }

            public void m5471a(JsonWriter jsonWriter, Calendar calendar) {
                if (calendar == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                jsonWriter.name("year");
                jsonWriter.value((long) calendar.get(1));
                jsonWriter.name("month");
                jsonWriter.value((long) calendar.get(2));
                jsonWriter.name("dayOfMonth");
                jsonWriter.value((long) calendar.get(5));
                jsonWriter.name("hourOfDay");
                jsonWriter.value((long) calendar.get(11));
                jsonWriter.name("minute");
                jsonWriter.value((long) calendar.get(12));
                jsonWriter.name("second");
                jsonWriter.value((long) calendar.get(13));
                jsonWriter.endObject();
            }
        };
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, CALENDAR);
        LOCALE = new TypeAdapter<Locale>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5472a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5473a(jsonWriter, (Locale) obj);
            }

            public Locale m5472a(JsonReader jsonReader) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String nextToken;
                String nextToken2;
                String nextToken3;
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                if (stringTokenizer.hasMoreElements()) {
                    nextToken = stringTokenizer.nextToken();
                } else {
                    nextToken = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    nextToken2 = stringTokenizer.nextToken();
                } else {
                    nextToken2 = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    nextToken3 = stringTokenizer.nextToken();
                } else {
                    nextToken3 = null;
                }
                if (nextToken2 == null && nextToken3 == null) {
                    return new Locale(nextToken);
                }
                if (nextToken3 == null) {
                    return new Locale(nextToken, nextToken2);
                }
                return new Locale(nextToken, nextToken2, nextToken3);
            }

            public void m5473a(JsonWriter jsonWriter, Locale locale) {
                jsonWriter.value(locale == null ? null : locale.toString());
            }
        };
        LOCALE_FACTORY = newFactory(Locale.class, LOCALE);
        JSON_ELEMENT = new TypeAdapter<JsonElement>() {
            public /* synthetic */ Object read(JsonReader jsonReader) {
                return m5474a(jsonReader);
            }

            public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
                m5475a(jsonWriter, (JsonElement) obj);
            }

            public JsonElement m5474a(JsonReader jsonReader) {
                JsonElement jsonArray;
                switch (AnonymousClass30.f4907a[jsonReader.peek().ordinal()]) {
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        return new JsonPrimitive(jsonReader.nextString());
                    case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                        jsonReader.nextNull();
                        return JsonNull.INSTANCE;
                    case Type.OTHER_PROFILE /*5*/:
                        jsonArray = new JsonArray();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonArray.add(m5474a(jsonReader));
                        }
                        jsonReader.endArray();
                        return jsonArray;
                    case Type.CONTRIBUTOR /*6*/:
                        jsonArray = new JsonObject();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            jsonArray.add(jsonReader.nextName(), m5474a(jsonReader));
                        }
                        jsonReader.endObject();
                        return jsonArray;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            public void m5475a(JsonWriter jsonWriter, JsonElement jsonElement) {
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    jsonWriter.nullValue();
                } else if (jsonElement.isJsonPrimitive()) {
                    JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                    if (asJsonPrimitive.isNumber()) {
                        jsonWriter.value(asJsonPrimitive.getAsNumber());
                    } else if (asJsonPrimitive.isBoolean()) {
                        jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    } else {
                        jsonWriter.value(asJsonPrimitive.getAsString());
                    }
                } else if (jsonElement.isJsonArray()) {
                    jsonWriter.beginArray();
                    Iterator it = jsonElement.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        m5475a(jsonWriter, (JsonElement) it.next());
                    }
                    jsonWriter.endArray();
                } else if (jsonElement.isJsonObject()) {
                    jsonWriter.beginObject();
                    for (Entry entry : jsonElement.getAsJsonObject().entrySet()) {
                        jsonWriter.name((String) entry.getKey());
                        m5475a(jsonWriter, (JsonElement) entry.getValue());
                    }
                    jsonWriter.endObject();
                } else {
                    throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
                }
            }
        };
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, JSON_ELEMENT);
        ENUM_FACTORY = new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new C1588a(rawType);
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        return new AnonymousClass25(typeToken, typeAdapter);
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new AnonymousClass26(cls, typeAdapter);
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new AnonymousClass27(cls, cls2, typeAdapter);
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new AnonymousClass28(cls, cls2, typeAdapter);
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> cls, TypeAdapter<T1> typeAdapter) {
        return new AnonymousClass29(cls, typeAdapter);
    }
}
