package com.google.api.client.json;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.JsonPolymorphicTypeMap.TypeDef;
import com.google.api.client.p082b.ClassInfo;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.FieldInfo;
import com.google.api.client.p082b.GenericData;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ab;
import com.google.api.client.p082b.ai;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import net.nend.android.NendIconError;

public abstract class JsonParser {
    private static WeakHashMap<Class<?>, Field> f4462a;
    private static final Lock f4463b;

    /* renamed from: com.google.api.client.json.JsonParser.1 */
    static /* synthetic */ class C14811 {
        static final /* synthetic */ int[] f4461a;

        static {
            f4461a = new int[JsonToken.values().length];
            try {
                f4461a[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4461a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4461a[JsonToken.END_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4461a[JsonToken.FIELD_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4461a[JsonToken.END_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4461a[JsonToken.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4461a[JsonToken.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4461a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f4461a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f4461a[JsonToken.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f4461a[JsonToken.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public abstract void close();

    public abstract BigInteger getBigIntegerValue();

    public abstract byte getByteValue();

    public abstract String getCurrentName();

    public abstract JsonToken getCurrentToken();

    public abstract BigDecimal getDecimalValue();

    public abstract double getDoubleValue();

    public abstract JsonFactory getFactory();

    public abstract float getFloatValue();

    public abstract int getIntValue();

    public abstract long getLongValue();

    public abstract short getShortValue();

    public abstract String getText();

    public abstract JsonToken nextToken();

    public abstract JsonParser skipChildren();

    static {
        f4462a = new WeakHashMap();
        f4463b = new ReentrantLock();
    }

    public final <T> T parseAndClose(Class<T> cls) {
        return parseAndClose((Class) cls, null);
    }

    public final <T> T parseAndClose(Class<T> cls, CustomizeJsonParser customizeJsonParser) {
        try {
            T parse = parse((Class) cls, customizeJsonParser);
            return parse;
        } finally {
            close();
        }
    }

    public final void skipToKey(String str) {
        skipToKey(Collections.singleton(str));
    }

    public final String skipToKey(Set<String> set) {
        JsonToken b = m5055b();
        while (b == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (set.contains(text)) {
                return text;
            }
            skipChildren();
            b = nextToken();
        }
        return null;
    }

    private JsonToken m5049a() {
        JsonToken nextToken;
        JsonToken currentToken = getCurrentToken();
        if (currentToken == null) {
            nextToken = nextToken();
        } else {
            nextToken = currentToken;
        }
        Preconditions.m4972a(nextToken != null, (Object) "no JSON input found");
        return nextToken;
    }

    private JsonToken m5055b() {
        JsonToken a = m5049a();
        switch (C14811.f4461a[a.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                JsonToken nextToken = nextToken();
                boolean z = nextToken == JsonToken.FIELD_NAME || nextToken == JsonToken.END_OBJECT;
                Preconditions.m4972a(z, (Object) nextToken);
                return nextToken;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return nextToken();
            default:
                return a;
        }
    }

    public final void parseAndClose(Object obj) {
        parseAndClose(obj, null);
    }

    public final void parseAndClose(Object obj, CustomizeJsonParser customizeJsonParser) {
        try {
            parse(obj, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final <T> T parse(Class<T> cls) {
        return parse((Class) cls, null);
    }

    public final <T> T parse(Class<T> cls, CustomizeJsonParser customizeJsonParser) {
        return parse(cls, false, customizeJsonParser);
    }

    public Object parse(Type type, boolean z) {
        return parse(type, z, null);
    }

    public Object parse(Type type, boolean z, CustomizeJsonParser customizeJsonParser) {
        try {
            if (!Void.class.equals(type)) {
                m5049a();
            }
            Object a = m5050a(null, type, new ArrayList(), null, customizeJsonParser, true);
            return a;
        } finally {
            if (z) {
                close();
            }
        }
    }

    public final void parse(Object obj) {
        parse(obj, null);
    }

    public final void parse(Object obj, CustomizeJsonParser customizeJsonParser) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj.getClass());
        m5054a(arrayList, obj, customizeJsonParser);
    }

    private void m5054a(ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser) {
        if (obj instanceof GenericJson) {
            ((GenericJson) obj).setFactory(getFactory());
        }
        JsonToken b = m5055b();
        Class cls = obj.getClass();
        ClassInfo a = ClassInfo.m4891a(cls);
        boolean isAssignableFrom = GenericData.class.isAssignableFrom(cls);
        if (isAssignableFrom || !Map.class.isAssignableFrom(cls)) {
            while (b == JsonToken.FIELD_NAME) {
                String text = getText();
                nextToken();
                if (customizeJsonParser == null || !customizeJsonParser.stopAt(obj, text)) {
                    FieldInfo a2 = a.m4893a(text);
                    if (a2 != null) {
                        if (!a2.m4951e() || a2.m4952f()) {
                            Field a3 = a2.m4946a();
                            int size = arrayList.size();
                            arrayList.add(a3.getGenericType());
                            Object a4 = m5050a(a3, a2.m4950d(), arrayList, obj, customizeJsonParser, true);
                            arrayList.remove(size);
                            a2.m4947a(obj, a4);
                        } else {
                            throw new IllegalArgumentException("final array/object fields are not supported");
                        }
                    } else if (isAssignableFrom) {
                        ((GenericData) obj).set(text, m5050a(null, null, arrayList, obj, customizeJsonParser, true));
                    } else {
                        if (customizeJsonParser != null) {
                            customizeJsonParser.handleUnrecognizedKey(obj, text);
                        }
                        skipChildren();
                    }
                    b = nextToken();
                } else {
                    return;
                }
            }
            return;
        }
        m5053a(null, (Map) obj, ai.m4874d(cls), (ArrayList) arrayList, customizeJsonParser);
    }

    public final <T> Collection<T> parseArrayAndClose(Class<?> cls, Class<T> cls2) {
        return parseArrayAndClose((Class) cls, (Class) cls2, null);
    }

    public final <T> Collection<T> parseArrayAndClose(Class<?> cls, Class<T> cls2, CustomizeJsonParser customizeJsonParser) {
        try {
            Collection<T> parseArray = parseArray((Class) cls, (Class) cls2, customizeJsonParser);
            return parseArray;
        } finally {
            close();
        }
    }

    public final <T> void parseArrayAndClose(Collection<? super T> collection, Class<T> cls) {
        parseArrayAndClose((Collection) collection, (Class) cls, null);
    }

    public final <T> void parseArrayAndClose(Collection<? super T> collection, Class<T> cls, CustomizeJsonParser customizeJsonParser) {
        try {
            parseArray((Collection) collection, (Class) cls, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final <T> Collection<T> parseArray(Class<?> cls, Class<T> cls2) {
        return parseArray((Class) cls, (Class) cls2, null);
    }

    public final <T> Collection<T> parseArray(Class<?> cls, Class<T> cls2, CustomizeJsonParser customizeJsonParser) {
        Collection b = Data.m4904b((Type) cls);
        parseArray(b, (Class) cls2, customizeJsonParser);
        return b;
    }

    public final <T> void parseArray(Collection<? super T> collection, Class<T> cls) {
        parseArray((Collection) collection, (Class) cls, null);
    }

    public final <T> void parseArray(Collection<? super T> collection, Class<T> cls, CustomizeJsonParser customizeJsonParser) {
        m5052a(null, (Collection) collection, (Type) cls, new ArrayList(), customizeJsonParser);
    }

    private <T> void m5052a(Field field, Collection<T> collection, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) {
        JsonToken b = m5055b();
        while (b != JsonToken.END_ARRAY) {
            collection.add(m5050a(field, type, arrayList, collection, customizeJsonParser, true));
            b = nextToken();
        }
    }

    private void m5053a(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) {
        JsonToken b = m5055b();
        while (b == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (customizeJsonParser == null || !customizeJsonParser.stopAt(map, text)) {
                map.put(text, m5050a(field, type, arrayList, map, customizeJsonParser, true));
                b = nextToken();
            } else {
                return;
            }
        }
    }

    private final Object m5050a(Field field, Type type, ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser, boolean z) {
        StringBuilder stringBuilder;
        Type a = Data.m4900a((List) arrayList, type);
        Class cls = a instanceof Class ? (Class) a : null;
        if (a instanceof ParameterizedType) {
            cls = ai.m4860a((ParameterizedType) a);
        }
        if (cls == Void.class) {
            skipChildren();
            return null;
        }
        String toLowerCase;
        JsonToken currentToken = getCurrentToken();
        try {
            Type d;
            boolean z2;
            boolean z3;
            switch (C14811.f4461a[getCurrentToken().ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                case Urls.Type.OTHER_PROFILE /*5*/:
                    Preconditions.m4973a(!ai.m4871a(a), "expected object or map type but got %s", a);
                    Field a2 = z ? m5051a(cls) : null;
                    Object obj2 = null;
                    if (!(cls == null || customizeJsonParser == null)) {
                        obj2 = customizeJsonParser.newInstanceForObject(obj, cls);
                    }
                    Object obj3 = (cls == null || !ai.m4870a(cls, Map.class)) ? null : 1;
                    if (a2 != null) {
                        obj2 = new GenericJson();
                    } else if (obj2 == null) {
                        if (obj3 != null || cls == null) {
                            obj2 = Data.m4905b(cls);
                        } else {
                            obj2 = ai.m4864a(cls);
                        }
                    }
                    int size = arrayList.size();
                    if (a != null) {
                        arrayList.add(a);
                    }
                    if (!(obj3 == null || GenericData.class.isAssignableFrom(cls))) {
                        d = Map.class.isAssignableFrom(cls) ? ai.m4874d(a) : null;
                        if (d != null) {
                            m5053a(field, (Map) obj2, d, (ArrayList) arrayList, customizeJsonParser);
                            return obj2;
                        }
                    }
                    m5054a(arrayList, obj2, customizeJsonParser);
                    if (a != null) {
                        arrayList.remove(size);
                    }
                    if (a2 == null) {
                        return obj2;
                    }
                    JsonFactory factory;
                    JsonParser createJsonParser;
                    Object obj4 = ((GenericJson) obj2).get(a2.getName());
                    Preconditions.m4972a(obj4 != null, (Object) "No value specified for @JsonPolymorphicTypeMap field");
                    String obj5 = obj4.toString();
                    Type type2 = null;
                    for (TypeDef typeDef : ((JsonPolymorphicTypeMap) a2.getAnnotation(JsonPolymorphicTypeMap.class)).typeDefinitions()) {
                        if (typeDef.key().equals(obj5)) {
                            type2 = typeDef.ref();
                            Preconditions.m4972a(type2 == null, "No TypeDef annotation found with key: " + obj5);
                            factory = getFactory();
                            createJsonParser = factory.createJsonParser(factory.toString(obj2));
                            createJsonParser.m5049a();
                            return createJsonParser.m5050a(field, type2, arrayList, null, null, false);
                        }
                    }
                    if (type2 == null) {
                    }
                    Preconditions.m4972a(type2 == null, "No TypeDef annotation found with key: " + obj5);
                    factory = getFactory();
                    createJsonParser = factory.createJsonParser(factory.toString(obj2));
                    createJsonParser.m5049a();
                    return createJsonParser.m5050a(field, type2, arrayList, null, null, false);
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    Type b;
                    boolean a3 = ai.m4871a(a);
                    z2 = a == null || a3 || (cls != null && ai.m4870a(cls, Collection.class));
                    Preconditions.m4973a(z2, "expected collection or array type but got %s", a);
                    Collection collection = null;
                    if (!(customizeJsonParser == null || field == null)) {
                        collection = customizeJsonParser.newInstanceForArray(obj, field);
                    }
                    if (collection == null) {
                        collection = Data.m4904b(a);
                    }
                    if (a3) {
                        b = ai.m4872b(a);
                    } else if (cls == null || !Iterable.class.isAssignableFrom(cls)) {
                        b = null;
                    } else {
                        b = ai.m4873c(a);
                    }
                    d = Data.m4900a((List) arrayList, b);
                    m5052a(field, collection, d, (ArrayList) arrayList, customizeJsonParser);
                    if (a3) {
                        return ai.m4865a(collection, ai.m4861a((List) arrayList, d));
                    }
                    return collection;
                case Urls.Type.CONTRIBUTOR /*6*/:
                case Urls.Type.WEBSITE /*7*/:
                    z3 = a == null || cls == Boolean.TYPE || (cls != null && cls.isAssignableFrom(Boolean.class));
                    Preconditions.m4973a(z3, "expected type Boolean or boolean but got %s", a);
                    return currentToken == JsonToken.VALUE_TRUE ? Boolean.TRUE : Boolean.FALSE;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    z2 = field == null || field.getAnnotation(JsonString.class) == null;
                    Preconditions.m4972a(z2, (Object) "number type formatted as a JSON number cannot use @JsonString annotation");
                    if (cls == null || cls.isAssignableFrom(BigDecimal.class)) {
                        return getDecimalValue();
                    }
                    if (cls == BigInteger.class) {
                        return getBigIntegerValue();
                    }
                    if (cls == Double.class || cls == Double.TYPE) {
                        return Double.valueOf(getDoubleValue());
                    }
                    if (cls == Long.class || cls == Long.TYPE) {
                        return Long.valueOf(getLongValue());
                    }
                    if (cls == Float.class || cls == Float.TYPE) {
                        return Float.valueOf(getFloatValue());
                    }
                    if (cls == Integer.class || cls == Integer.TYPE) {
                        return Integer.valueOf(getIntValue());
                    }
                    if (cls == Short.class || cls == Short.TYPE) {
                        return Short.valueOf(getShortValue());
                    }
                    if (cls == Byte.class || cls == Byte.TYPE) {
                        return Byte.valueOf(getByteValue());
                    }
                    throw new IllegalArgumentException("expected numeric type but got " + a);
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    toLowerCase = getText().trim().toLowerCase(Locale.US);
                    if (!((cls == Float.TYPE || cls == Float.class || cls == Double.TYPE || cls == Double.class) && (toLowerCase.equals("nan") || toLowerCase.equals("infinity") || toLowerCase.equals("-infinity")))) {
                        z3 = (cls != null && Number.class.isAssignableFrom(cls) && (field == null || field.getAnnotation(JsonString.class) == null)) ? false : true;
                        Preconditions.m4972a(z3, (Object) "number field formatted as a JSON string must use the @JsonString annotation");
                    }
                    return Data.m4899a(a, getText());
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    z2 = cls == null || !cls.isPrimitive();
                    Preconditions.m4972a(z2, (Object) "primitive number field but found a JSON null");
                    if (!(cls == null || (cls.getModifiers() & 1536) == 0)) {
                        if (ai.m4870a(cls, Collection.class)) {
                            return Data.m4898a(Data.m4904b(a).getClass());
                        }
                        if (ai.m4870a(cls, Map.class)) {
                            return Data.m4898a(Data.m4905b(cls).getClass());
                        }
                    }
                    return Data.m4898a(ai.m4861a((List) arrayList, a));
                default:
                    throw new IllegalArgumentException("unexpected JSON node type: " + currentToken);
            }
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            toLowerCase = getCurrentName();
            if (toLowerCase != null) {
                stringBuilder.append("key ").append(toLowerCase);
            }
            if (field != null) {
                if (toLowerCase != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append("field ").append(field);
            }
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        }
        stringBuilder = new StringBuilder();
        toLowerCase = getCurrentName();
        if (toLowerCase != null) {
            stringBuilder.append("key ").append(toLowerCase);
        }
        if (field != null) {
            if (toLowerCase != null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("field ").append(field);
        }
        throw new IllegalArgumentException(stringBuilder.toString(), e);
    }

    private static Field m5051a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        f4463b.lock();
        try {
            Field field;
            if (f4462a.containsKey(cls)) {
                field = (Field) f4462a.get(cls);
                return field;
            }
            Field field2 = null;
            for (FieldInfo a : ClassInfo.m4891a((Class) cls).m4897c()) {
                Field a2 = a.m4946a();
                JsonPolymorphicTypeMap jsonPolymorphicTypeMap = (JsonPolymorphicTypeMap) a2.getAnnotation(JsonPolymorphicTypeMap.class);
                if (jsonPolymorphicTypeMap != null) {
                    boolean z;
                    Preconditions.m4973a(field2 == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", cls);
                    Preconditions.m4973a(Data.m4903a(a2.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", cls, a2.getType());
                    TypeDef[] typeDefinitions = jsonPolymorphicTypeMap.typeDefinitions();
                    HashSet a3 = ab.m4849a();
                    if (typeDefinitions.length > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.m4972a(z, (Object) "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                    for (TypeDef key : typeDefinitions) {
                        Preconditions.m4973a(a3.add(key.key()), "Class contains two @TypeDef annotations with identical key: %s", typeDefinitions[r0].key());
                    }
                    field = a2;
                } else {
                    field = field2;
                }
                field2 = field;
            }
            f4462a.put(cls, field2);
            f4463b.unlock();
            return field2;
        } finally {
            f4463b.unlock();
        }
    }
}
