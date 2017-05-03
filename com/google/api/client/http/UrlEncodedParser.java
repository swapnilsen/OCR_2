package com.google.api.client.http;

import android.support.v7.appcompat.C0268R;
import com.google.api.client.p082b.ArrayValueMap;
import com.google.api.client.p082b.Charsets;
import com.google.api.client.p082b.ClassInfo;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.FieldInfo;
import com.google.api.client.p082b.GenericData;
import com.google.api.client.p082b.ObjectParser;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ah;
import com.google.api.client.p082b.ai;
import com.google.api.client.p082b.p083a.CharEscapers;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UrlEncodedParser implements ObjectParser {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final String MEDIA_TYPE;

    static {
        MEDIA_TYPE = new HttpMediaType(CONTENT_TYPE).setCharsetParameter(Charsets.f4139a).build();
    }

    public static void parse(String str, Object obj) {
        if (str != null) {
            try {
                parse(new StringReader(str), obj);
            } catch (Throwable e) {
                throw ah.m4859a(e);
            }
        }
    }

    public static void parse(Reader reader, Object obj) {
        Map map;
        Class cls = obj.getClass();
        ClassInfo a = ClassInfo.m4891a(cls);
        List asList = Arrays.asList(new Type[]{cls});
        GenericData genericData = GenericData.class.isAssignableFrom(cls) ? (GenericData) obj : null;
        if (Map.class.isAssignableFrom(cls)) {
            map = (Map) obj;
        } else {
            map = null;
        }
        ArrayValueMap arrayValueMap = new ArrayValueMap(obj);
        StringWriter stringWriter = new StringWriter();
        StringWriter stringWriter2 = new StringWriter();
        int i = 1;
        while (true) {
            int read = reader.read();
            switch (read) {
                case FirebaseRemoteConfig.LAST_FETCH_STATUS_SUCCESS /*-1*/:
                case C0268R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    String b = CharEscapers.m4810b(stringWriter.toString());
                    if (b.length() != 0) {
                        String b2 = CharEscapers.m4810b(stringWriter2.toString());
                        FieldInfo a2 = a.m4893a(b);
                        if (a2 != null) {
                            Type a3 = Data.m4900a(asList, a2.m4950d());
                            if (ai.m4871a(a3)) {
                                Object a4 = ai.m4861a(asList, ai.m4872b(a3));
                                arrayValueMap.m4879a(a2.m4946a(), a4, m5037a(a4, asList, b2));
                            } else if (ai.m4870a(ai.m4861a(asList, a3), Iterable.class)) {
                                Collection collection = (Collection) a2.m4945a(obj);
                                if (collection == null) {
                                    collection = Data.m4904b(a3);
                                    a2.m4947a(obj, (Object) collection);
                                }
                                collection.add(m5037a(a3 == Object.class ? null : ai.m4873c(a3), asList, b2));
                            } else {
                                a2.m4947a(obj, m5037a(a3, asList, b2));
                            }
                        } else if (map != null) {
                            ArrayList arrayList = (ArrayList) map.get(b);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                if (genericData != null) {
                                    genericData.set(b, arrayList);
                                } else {
                                    map.put(b, arrayList);
                                }
                            }
                            arrayList.add(b2);
                        }
                    }
                    stringWriter = new StringWriter();
                    stringWriter2 = new StringWriter();
                    if (read != -1) {
                        i = 1;
                        break;
                    } else {
                        arrayValueMap.m4878a();
                        return;
                    }
                case C0268R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    i = 0;
                    break;
                default:
                    if (i == 0) {
                        stringWriter2.write(read);
                        break;
                    } else {
                        stringWriter.write(read);
                        break;
                    }
            }
        }
    }

    private static Object m5037a(Type type, List<Type> list, String str) {
        return Data.m4899a(Data.m4900a((List) list, type), str);
    }

    public <T> T parseAndClose(InputStream inputStream, Charset charset, Class<T> cls) {
        return parseAndClose(new InputStreamReader(inputStream, charset), (Class) cls);
    }

    public Object parseAndClose(InputStream inputStream, Charset charset, Type type) {
        return parseAndClose(new InputStreamReader(inputStream, charset), type);
    }

    public <T> T parseAndClose(Reader reader, Class<T> cls) {
        return parseAndClose(reader, (Type) cls);
    }

    public Object parseAndClose(Reader reader, Type type) {
        Preconditions.m4972a(type instanceof Class, (Object) "dataType has to be of type Class<?>");
        Object a = ai.m4864a((Class) type);
        parse(new BufferedReader(reader), a);
        return a;
    }
}
