package com.google.api.client.http;

import com.google.api.client.p072a.p073a.p074a.p075a.p076a.Splitter;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.FieldInfo;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ai;
import com.google.api.client.p082b.p083a.CharEscapers;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

public class UriTemplate {
    static final Map<Character, C1480a> f4422a;

    /* renamed from: com.google.api.client.http.UriTemplate.a */
    private enum C1480a {
        PLUS(Character.valueOf('+'), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, ",", false, true),
        HASH(Character.valueOf('#'), "#", ",", false, true),
        DOT(Character.valueOf('.'), ".", ".", false, false),
        FORWARD_SLASH(Character.valueOf('/'), "/", "/", false, false),
        SEMI_COLON(Character.valueOf(';'), ";", ";", true, false),
        QUERY(Character.valueOf('?'), "?", "&", true, false),
        AMP(Character.valueOf('&'), "&", "&", true, false),
        SIMPLE(null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, ",", false, false);
        
        private final Character f4417i;
        private final String f4418j;
        private final String f4419k;
        private final boolean f4420l;
        private final boolean f4421m;

        private C1480a(Character ch, String str, String str2, boolean z, boolean z2) {
            this.f4417i = ch;
            this.f4418j = (String) Preconditions.m4968a((Object) str);
            this.f4419k = (String) Preconditions.m4968a((Object) str2);
            this.f4420l = z;
            this.f4421m = z2;
            if (ch != null) {
                UriTemplate.f4422a.put(ch, this);
            }
        }

        String m5026a() {
            return this.f4418j;
        }

        String m5028b() {
            return this.f4419k;
        }

        boolean m5029c() {
            return this.f4420l;
        }

        int m5030d() {
            return this.f4417i == null ? 0 : 1;
        }

        String m5027a(String str) {
            if (this.f4421m) {
                return CharEscapers.m4811c(str);
            }
            return CharEscapers.m4809a(str);
        }

        boolean m5031e() {
            return this.f4421m;
        }
    }

    static {
        f4422a = new HashMap();
        C1480a.values();
    }

    static C1480a m5032a(String str) {
        C1480a c1480a = (C1480a) f4422a.get(Character.valueOf(str.charAt(0)));
        return c1480a == null ? C1480a.SIMPLE : c1480a;
    }

    private static Map<String, Object> m5035a(Object obj) {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        for (Entry entry : Data.m4906b(obj).entrySet()) {
            Object value = entry.getValue();
            if (!(value == null || Data.m4902a(value))) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    public static String expand(String str, String str2, Object obj, boolean z) {
        if (str2.startsWith("/")) {
            GenericUrl genericUrl = new GenericUrl(str);
            genericUrl.setRawPath(null);
            str2 = genericUrl.build() + str2;
        } else if (!(str2.startsWith("http://") || str2.startsWith("https://"))) {
            str2 = str + str2;
        }
        return expand(str2, obj, z);
    }

    public static String expand(String str, Object obj, boolean z) {
        Map a = m5035a(obj);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int length = str.length();
        while (i < length) {
            int indexOf = str.indexOf(123, i);
            if (indexOf != -1) {
                stringBuilder.append(str.substring(i, indexOf));
                i = str.indexOf(125, indexOf + 2);
                int i2 = i + 1;
                CharSequence substring = str.substring(indexOf + 1, i);
                C1480a a2 = m5032a((String) substring);
                ListIterator listIterator = Splitter.m4770a(',').m4775a(substring).listIterator();
                Object obj2 = 1;
                while (listIterator.hasNext()) {
                    String str2 = (String) listIterator.next();
                    boolean endsWith = str2.endsWith("*");
                    int d = listIterator.nextIndex() == 1 ? a2.m5030d() : 0;
                    int length2 = str2.length();
                    if (endsWith) {
                        length2--;
                    }
                    String substring2 = str2.substring(d, length2);
                    Object remove = a.remove(substring2);
                    if (remove != null) {
                        Object obj3;
                        if (obj2 == null) {
                            stringBuilder.append(a2.m5028b());
                            obj3 = obj2;
                        } else {
                            stringBuilder.append(a2.m5026a());
                            obj3 = null;
                        }
                        if (remove instanceof Iterator) {
                            remove = m5033a(substring2, (Iterator) remove, endsWith, a2);
                        } else if ((remove instanceof Iterable) || remove.getClass().isArray()) {
                            remove = m5033a(substring2, ai.m4863a(remove).iterator(), endsWith, a2);
                        } else if (remove.getClass().isEnum()) {
                            if (FieldInfo.m4941a((Enum) remove).m4948b() != null) {
                                if (a2.m5029c()) {
                                    remove = String.format("%s=%s", new Object[]{substring2, remove});
                                }
                                remove = CharEscapers.m4811c(remove.toString());
                            }
                        } else if (Data.m4908d(remove)) {
                            if (a2.m5029c()) {
                                remove = String.format("%s=%s", new Object[]{substring2, remove});
                            }
                            if (a2.m5031e()) {
                                remove = CharEscapers.m4812d(remove.toString());
                            } else {
                                remove = CharEscapers.m4811c(remove.toString());
                            }
                        } else {
                            remove = m5034a(substring2, m5035a(remove), endsWith, a2);
                        }
                        stringBuilder.append(remove);
                        obj2 = obj3;
                    }
                }
                i = i2;
            } else if (i == 0 && !z) {
                return str;
            } else {
                stringBuilder.append(str.substring(i));
                if (z) {
                    GenericUrl.m5007a(a.entrySet(), stringBuilder);
                }
                return stringBuilder.toString();
            }
        }
        if (z) {
            GenericUrl.m5007a(a.entrySet(), stringBuilder);
        }
        return stringBuilder.toString();
    }

    private static String m5033a(String str, Iterator<?> it, boolean z, C1480a c1480a) {
        if (!it.hasNext()) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        String b;
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            b = c1480a.m5028b();
        } else {
            b = ",";
            if (c1480a.m5029c()) {
                stringBuilder.append(CharEscapers.m4811c(str));
                stringBuilder.append("=");
            }
        }
        while (it.hasNext()) {
            if (z && c1480a.m5029c()) {
                stringBuilder.append(CharEscapers.m4811c(str));
                stringBuilder.append("=");
            }
            stringBuilder.append(c1480a.m5027a(it.next().toString()));
            if (it.hasNext()) {
                stringBuilder.append(b);
            }
        }
        return stringBuilder.toString();
    }

    private static String m5034a(String str, Map<String, Object> map, boolean z, C1480a c1480a) {
        if (map.isEmpty()) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        String str2;
        String b;
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            str2 = "=";
            b = c1480a.m5028b();
        } else {
            String str3 = ",";
            String str4 = ",";
            if (c1480a.m5029c()) {
                stringBuilder.append(CharEscapers.m4811c(str));
                stringBuilder.append("=");
            }
            str2 = str4;
            b = str3;
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            str3 = c1480a.m5027a((String) entry.getKey());
            str4 = c1480a.m5027a(entry.getValue().toString());
            stringBuilder.append(str3);
            stringBuilder.append(str2);
            stringBuilder.append(str4);
            if (it.hasNext()) {
                stringBuilder.append(b);
            }
        }
        return stringBuilder.toString();
    }
}
