package com.google.api.client.http;

import com.google.api.client.p082b.ArrayValueMap;
import com.google.api.client.p082b.Base64;
import com.google.api.client.p082b.ClassInfo;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.FieldInfo;
import com.google.api.client.p082b.GenericData;
import com.google.api.client.p082b.Key;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.af;
import com.google.api.client.p082b.ah;
import com.google.api.client.p082b.ai;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpHeaders extends GenericData {
    @Key(a = "Accept")
    private List<String> accept;
    @Key(a = "Accept-Encoding")
    private List<String> acceptEncoding;
    @Key(a = "Age")
    private List<Long> age;
    @Key(a = "WWW-Authenticate")
    private List<String> authenticate;
    @Key(a = "Authorization")
    private List<String> authorization;
    @Key(a = "Cache-Control")
    private List<String> cacheControl;
    @Key(a = "Content-Encoding")
    private List<String> contentEncoding;
    @Key(a = "Content-Length")
    private List<Long> contentLength;
    @Key(a = "Content-MD5")
    private List<String> contentMD5;
    @Key(a = "Content-Range")
    private List<String> contentRange;
    @Key(a = "Content-Type")
    private List<String> contentType;
    @Key(a = "Cookie")
    private List<String> cookie;
    @Key(a = "Date")
    private List<String> date;
    @Key(a = "ETag")
    private List<String> etag;
    @Key(a = "Expires")
    private List<String> expires;
    @Key(a = "If-Match")
    private List<String> ifMatch;
    @Key(a = "If-Modified-Since")
    private List<String> ifModifiedSince;
    @Key(a = "If-None-Match")
    private List<String> ifNoneMatch;
    @Key(a = "If-Range")
    private List<String> ifRange;
    @Key(a = "If-Unmodified-Since")
    private List<String> ifUnmodifiedSince;
    @Key(a = "Last-Modified")
    private List<String> lastModified;
    @Key(a = "Location")
    private List<String> location;
    @Key(a = "MIME-Version")
    private List<String> mimeVersion;
    @Key(a = "Range")
    private List<String> range;
    @Key(a = "Retry-After")
    private List<String> retryAfter;
    @Key(a = "User-Agent")
    private List<String> userAgent;

    /* renamed from: com.google.api.client.http.HttpHeaders.a */
    private static class C1477a extends LowLevelHttpRequest {
        private final HttpHeaders f4342a;
        private final C1478b f4343b;

        C1477a(HttpHeaders httpHeaders, C1478b c1478b) {
            this.f4342a = httpHeaders;
            this.f4343b = c1478b;
        }

        public void addHeader(String str, String str2) {
            this.f4342a.m5018a(str, str2, this.f4343b);
        }

        public LowLevelHttpResponse execute() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.api.client.http.HttpHeaders.b */
    private static final class C1478b {
        final ArrayValueMap f4344a;
        final StringBuilder f4345b;
        final ClassInfo f4346c;
        final List<Type> f4347d;

        public C1478b(HttpHeaders httpHeaders, StringBuilder stringBuilder) {
            this.f4347d = Arrays.asList(new Type[]{httpHeaders.getClass()});
            this.f4346c = ClassInfo.m4892a(r0, true);
            this.f4345b = stringBuilder;
            this.f4344a = new ArrayValueMap(httpHeaders);
        }

        void m5010a() {
            this.f4344a.m4878a();
        }
    }

    public HttpHeaders() {
        super(EnumSet.of(GenericData.GenericData.IGNORE_CASE));
        this.acceptEncoding = new ArrayList(Collections.singleton("gzip"));
    }

    public HttpHeaders clone() {
        return (HttpHeaders) super.clone();
    }

    public HttpHeaders set(String str, Object obj) {
        return (HttpHeaders) super.set(str, obj);
    }

    public final String getAccept() {
        return (String) m5012a(this.accept);
    }

    public HttpHeaders setAccept(String str) {
        this.accept = m5017b(str);
        return this;
    }

    public final String getAcceptEncoding() {
        return (String) m5012a(this.acceptEncoding);
    }

    public HttpHeaders setAcceptEncoding(String str) {
        this.acceptEncoding = m5017b(str);
        return this;
    }

    public final String getAuthorization() {
        return (String) m5012a(this.authorization);
    }

    public final List<String> getAuthorizationAsList() {
        return this.authorization;
    }

    public HttpHeaders setAuthorization(String str) {
        return setAuthorization(m5017b(str));
    }

    public HttpHeaders setAuthorization(List<String> list) {
        this.authorization = list;
        return this;
    }

    public final String getCacheControl() {
        return (String) m5012a(this.cacheControl);
    }

    public HttpHeaders setCacheControl(String str) {
        this.cacheControl = m5017b(str);
        return this;
    }

    public final String getContentEncoding() {
        return (String) m5012a(this.contentEncoding);
    }

    public HttpHeaders setContentEncoding(String str) {
        this.contentEncoding = m5017b(str);
        return this;
    }

    public final Long getContentLength() {
        return (Long) m5012a(this.contentLength);
    }

    public HttpHeaders setContentLength(Long l) {
        this.contentLength = m5017b(l);
        return this;
    }

    public final String getContentMD5() {
        return (String) m5012a(this.contentMD5);
    }

    public HttpHeaders setContentMD5(String str) {
        this.contentMD5 = m5017b(str);
        return this;
    }

    public final String getContentRange() {
        return (String) m5012a(this.contentRange);
    }

    public HttpHeaders setContentRange(String str) {
        this.contentRange = m5017b(str);
        return this;
    }

    public final String getContentType() {
        return (String) m5012a(this.contentType);
    }

    public HttpHeaders setContentType(String str) {
        this.contentType = m5017b(str);
        return this;
    }

    public final String getCookie() {
        return (String) m5012a(this.cookie);
    }

    public HttpHeaders setCookie(String str) {
        this.cookie = m5017b(str);
        return this;
    }

    public final String getDate() {
        return (String) m5012a(this.date);
    }

    public HttpHeaders setDate(String str) {
        this.date = m5017b(str);
        return this;
    }

    public final String getETag() {
        return (String) m5012a(this.etag);
    }

    public HttpHeaders setETag(String str) {
        this.etag = m5017b(str);
        return this;
    }

    public final String getExpires() {
        return (String) m5012a(this.expires);
    }

    public HttpHeaders setExpires(String str) {
        this.expires = m5017b(str);
        return this;
    }

    public final String getIfModifiedSince() {
        return (String) m5012a(this.ifModifiedSince);
    }

    public HttpHeaders setIfModifiedSince(String str) {
        this.ifModifiedSince = m5017b(str);
        return this;
    }

    public final String getIfMatch() {
        return (String) m5012a(this.ifMatch);
    }

    public HttpHeaders setIfMatch(String str) {
        this.ifMatch = m5017b(str);
        return this;
    }

    public final String getIfNoneMatch() {
        return (String) m5012a(this.ifNoneMatch);
    }

    public HttpHeaders setIfNoneMatch(String str) {
        this.ifNoneMatch = m5017b(str);
        return this;
    }

    public final String getIfUnmodifiedSince() {
        return (String) m5012a(this.ifUnmodifiedSince);
    }

    public HttpHeaders setIfUnmodifiedSince(String str) {
        this.ifUnmodifiedSince = m5017b(str);
        return this;
    }

    public final String getIfRange() {
        return (String) m5012a(this.ifRange);
    }

    public HttpHeaders setIfRange(String str) {
        this.ifRange = m5017b(str);
        return this;
    }

    public final String getLastModified() {
        return (String) m5012a(this.lastModified);
    }

    public HttpHeaders setLastModified(String str) {
        this.lastModified = m5017b(str);
        return this;
    }

    public final String getLocation() {
        return (String) m5012a(this.location);
    }

    public HttpHeaders setLocation(String str) {
        this.location = m5017b(str);
        return this;
    }

    public final String getMimeVersion() {
        return (String) m5012a(this.mimeVersion);
    }

    public HttpHeaders setMimeVersion(String str) {
        this.mimeVersion = m5017b(str);
        return this;
    }

    public final String getRange() {
        return (String) m5012a(this.range);
    }

    public HttpHeaders setRange(String str) {
        this.range = m5017b(str);
        return this;
    }

    public final String getRetryAfter() {
        return (String) m5012a(this.retryAfter);
    }

    public HttpHeaders setRetryAfter(String str) {
        this.retryAfter = m5017b(str);
        return this;
    }

    public final String getUserAgent() {
        return (String) m5012a(this.userAgent);
    }

    public HttpHeaders setUserAgent(String str) {
        this.userAgent = m5017b(str);
        return this;
    }

    public final String getAuthenticate() {
        return (String) m5012a(this.authenticate);
    }

    public final List<String> getAuthenticateAsList() {
        return this.authenticate;
    }

    public HttpHeaders setAuthenticate(String str) {
        this.authenticate = m5017b(str);
        return this;
    }

    public final Long getAge() {
        return (Long) m5012a(this.age);
    }

    public HttpHeaders setAge(Long l) {
        this.age = m5017b(l);
        return this;
    }

    public HttpHeaders setBasicAuthentication(String str, String str2) {
        return setAuthorization("Basic " + Base64.m4884a(af.m4857a(((String) Preconditions.m4968a((Object) str)) + ":" + ((String) Preconditions.m4968a((Object) str2)))));
    }

    private static void m5016a(Logger logger, StringBuilder stringBuilder, StringBuilder stringBuilder2, LowLevelHttpRequest lowLevelHttpRequest, String str, Object obj, Writer writer) {
        if (obj != null && !Data.m4902a(obj)) {
            String str2;
            String a = m5013a(obj);
            if (("Authorization".equalsIgnoreCase(str) || "Cookie".equalsIgnoreCase(str)) && (logger == null || !logger.isLoggable(Level.ALL))) {
                str2 = "<Not Logged>";
            } else {
                str2 = a;
            }
            if (stringBuilder != null) {
                stringBuilder.append(str).append(": ");
                stringBuilder.append(str2);
                stringBuilder.append(af.f4124a);
            }
            if (stringBuilder2 != null) {
                stringBuilder2.append(" -H '").append(str).append(": ").append(str2).append("'");
            }
            if (lowLevelHttpRequest != null) {
                lowLevelHttpRequest.addHeader(str, a);
            }
            if (writer != null) {
                writer.write(str);
                writer.write(": ");
                writer.write(a);
                writer.write("\r\n");
            }
        }
    }

    private static String m5013a(Object obj) {
        return obj instanceof Enum ? FieldInfo.m4941a((Enum) obj).m4948b() : obj.toString();
    }

    static void m5014a(HttpHeaders httpHeaders, StringBuilder stringBuilder, StringBuilder stringBuilder2, Logger logger, LowLevelHttpRequest lowLevelHttpRequest) {
        m5015a(httpHeaders, stringBuilder, stringBuilder2, logger, lowLevelHttpRequest, null);
    }

    public static void serializeHeadersForMultipartRequests(HttpHeaders httpHeaders, StringBuilder stringBuilder, Logger logger, Writer writer) {
        m5015a(httpHeaders, stringBuilder, null, logger, null, writer);
    }

    static void m5015a(HttpHeaders httpHeaders, StringBuilder stringBuilder, StringBuilder stringBuilder2, Logger logger, LowLevelHttpRequest lowLevelHttpRequest, Writer writer) {
        HashSet hashSet = new HashSet();
        for (Entry entry : httpHeaders.entrySet()) {
            String str = (String) entry.getKey();
            Preconditions.m4973a(hashSet.add(str), "multiple headers of the same name (headers are case insensitive): %s", str);
            Object value = entry.getValue();
            if (value != null) {
                String b;
                FieldInfo a = httpHeaders.getClassInfo().m4893a(str);
                if (a != null) {
                    b = a.m4948b();
                } else {
                    b = str;
                }
                Class cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    for (Object value2 : ai.m4863a(value2)) {
                        m5016a(logger, stringBuilder, stringBuilder2, lowLevelHttpRequest, b, value2, writer);
                    }
                } else {
                    m5016a(logger, stringBuilder, stringBuilder2, lowLevelHttpRequest, b, value2, writer);
                }
            }
        }
        if (writer != null) {
            writer.flush();
        }
    }

    public final void fromHttpResponse(LowLevelHttpResponse lowLevelHttpResponse, StringBuilder stringBuilder) {
        clear();
        C1478b c1478b = new C1478b(this, stringBuilder);
        int headerCount = lowLevelHttpResponse.getHeaderCount();
        for (int i = 0; i < headerCount; i++) {
            m5018a(lowLevelHttpResponse.getHeaderName(i), lowLevelHttpResponse.getHeaderValue(i), c1478b);
        }
        c1478b.m5010a();
    }

    private <T> T m5012a(List<T> list) {
        return list == null ? null : list.get(0);
    }

    private <T> List<T> m5017b(T t) {
        if (t == null) {
            return null;
        }
        List<T> arrayList = new ArrayList();
        arrayList.add(t);
        return arrayList;
    }

    public String getFirstHeaderStringValue(String str) {
        Object obj = get(str.toLowerCase());
        if (obj == null) {
            return null;
        }
        Class cls = obj.getClass();
        if ((obj instanceof Iterable) || cls.isArray()) {
            Iterator it = ai.m4863a(obj).iterator();
            if (it.hasNext()) {
                return m5013a(it.next());
            }
        }
        return m5013a(obj);
    }

    public List<String> getHeaderStringValues(String str) {
        Object obj = get(str.toLowerCase());
        if (obj == null) {
            return Collections.emptyList();
        }
        Class cls = obj.getClass();
        if (!(obj instanceof Iterable) && !cls.isArray()) {
            return Collections.singletonList(m5013a(obj));
        }
        List arrayList = new ArrayList();
        for (Object a : ai.m4863a(obj)) {
            arrayList.add(m5013a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final void fromHttpHeaders(HttpHeaders httpHeaders) {
        try {
            C1478b c1478b = new C1478b(this, null);
            m5014a(httpHeaders, null, null, null, new C1477a(this, c1478b));
            c1478b.m5010a();
        } catch (Throwable e) {
            throw ah.m4859a(e);
        }
    }

    void m5018a(String str, String str2, C1478b c1478b) {
        List list = c1478b.f4347d;
        ClassInfo classInfo = c1478b.f4346c;
        ArrayValueMap arrayValueMap = c1478b.f4344a;
        StringBuilder stringBuilder = c1478b.f4345b;
        if (stringBuilder != null) {
            stringBuilder.append(str + ": " + str2).append(af.f4124a);
        }
        FieldInfo a = classInfo.m4893a(str);
        if (a != null) {
            Type a2 = Data.m4900a(list, a.m4950d());
            if (ai.m4871a(a2)) {
                Type a3 = ai.m4861a(list, ai.m4872b(a2));
                arrayValueMap.m4879a(a.m4946a(), a3, m5011a(a3, list, str2));
                return;
            } else if (ai.m4870a(ai.m4861a(list, a2), Iterable.class)) {
                Collection collection = (Collection) a.m4945a((Object) this);
                if (collection == null) {
                    collection = Data.m4904b(a2);
                    a.m4947a((Object) this, (Object) collection);
                }
                collection.add(m5011a(a2 == Object.class ? null : ai.m4873c(a2), list, str2));
                return;
            } else {
                a.m4947a((Object) this, m5011a(a2, list, str2));
                return;
            }
        }
        ArrayList arrayList = (ArrayList) get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            set(str, (Object) arrayList);
        }
        arrayList.add(str2);
    }

    private static Object m5011a(Type type, List<Type> list, String str) {
        return Data.m4899a(Data.m4900a((List) list, type), str);
    }
}
