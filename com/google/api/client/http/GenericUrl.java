package com.google.api.client.http;

import com.google.api.client.p082b.GenericData;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.p083a.CharEscapers;
import com.google.api.client.p082b.p083a.Escaper;
import com.google.api.client.p082b.p083a.PercentEscaper;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class GenericUrl extends GenericData {
    private static final Escaper f4324c;
    private String f4325d;
    private String f4326e;
    private String f4327f;
    private int f4328g;
    private List<String> f4329h;
    private String f4330i;

    static {
        f4324c = new PercentEscaper("=&-_.!~*'()@:$,;/?:", false);
    }

    public GenericUrl() {
        this.f4328g = -1;
    }

    public GenericUrl(String str) {
        this(m5009b(str));
    }

    public GenericUrl(URI uri) {
        this(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getRawPath(), uri.getRawFragment(), uri.getRawQuery(), uri.getRawUserInfo());
    }

    public GenericUrl(URL url) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    private GenericUrl(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        String str7 = null;
        this.f4328g = -1;
        this.f4325d = str.toLowerCase();
        this.f4326e = str2;
        this.f4328g = i;
        this.f4329h = toPathParts(str3);
        this.f4330i = str4 != null ? CharEscapers.m4810b(str4) : null;
        if (str5 != null) {
            UrlEncodedParser.parse(str5, (Object) this);
        }
        if (str6 != null) {
            str7 = CharEscapers.m4810b(str6);
        }
        this.f4327f = str7;
    }

    public int hashCode() {
        return build().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof GenericUrl)) {
            return false;
        }
        return build().equals(((GenericUrl) obj).toString());
    }

    public String toString() {
        return build();
    }

    public GenericUrl clone() {
        GenericUrl genericUrl = (GenericUrl) super.clone();
        if (this.f4329h != null) {
            genericUrl.f4329h = new ArrayList(this.f4329h);
        }
        return genericUrl;
    }

    public GenericUrl set(String str, Object obj) {
        return (GenericUrl) super.set(str, obj);
    }

    public final String getScheme() {
        return this.f4325d;
    }

    public final void setScheme(String str) {
        this.f4325d = (String) Preconditions.m4968a((Object) str);
    }

    public String getHost() {
        return this.f4326e;
    }

    public final void setHost(String str) {
        this.f4326e = (String) Preconditions.m4968a((Object) str);
    }

    public final String getUserInfo() {
        return this.f4327f;
    }

    public final void setUserInfo(String str) {
        this.f4327f = str;
    }

    public int getPort() {
        return this.f4328g;
    }

    public final void setPort(int i) {
        Preconditions.m4972a(i >= -1, (Object) "expected port >= -1");
        this.f4328g = i;
    }

    public List<String> getPathParts() {
        return this.f4329h;
    }

    public void setPathParts(List<String> list) {
        this.f4329h = list;
    }

    public String getFragment() {
        return this.f4330i;
    }

    public final void setFragment(String str) {
        this.f4330i = str;
    }

    public final String build() {
        return buildAuthority() + buildRelativeUrl();
    }

    public final String buildAuthority() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String) Preconditions.m4968a(this.f4325d));
        stringBuilder.append("://");
        if (this.f4327f != null) {
            stringBuilder.append(CharEscapers.m4813e(this.f4327f)).append('@');
        }
        stringBuilder.append((String) Preconditions.m4968a(this.f4326e));
        int i = this.f4328g;
        if (i != -1) {
            stringBuilder.append(':').append(i);
        }
        return stringBuilder.toString();
    }

    public final String buildRelativeUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f4329h != null) {
            m5006a(stringBuilder);
        }
        m5007a(entrySet(), stringBuilder);
        String str = this.f4330i;
        if (str != null) {
            stringBuilder.append('#').append(f4324c.m4815a(str));
        }
        return stringBuilder.toString();
    }

    public final URI toURI() {
        return m5005a(build());
    }

    public final URL toURL() {
        return m5009b(build());
    }

    public final URL toURL(String str) {
        try {
            return new URL(toURL(), str);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Object getFirst(String str) {
        Object obj = get(str);
        if (!(obj instanceof Collection)) {
            return obj;
        }
        Iterator it = ((Collection) obj).iterator();
        return it.hasNext() ? it.next() : null;
    }

    public Collection<Object> getAll(String str) {
        Object obj = get(str);
        if (obj == null) {
            return Collections.emptySet();
        }
        if (obj instanceof Collection) {
            return Collections.unmodifiableCollection((Collection) obj);
        }
        return Collections.singleton(obj);
    }

    public String getRawPath() {
        if (this.f4329h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        m5006a(stringBuilder);
        return stringBuilder.toString();
    }

    public void setRawPath(String str) {
        this.f4329h = toPathParts(str);
    }

    public void appendRawPath(String str) {
        if (str != null && str.length() != 0) {
            List toPathParts = toPathParts(str);
            if (this.f4329h == null || this.f4329h.isEmpty()) {
                this.f4329h = toPathParts;
                return;
            }
            int size = this.f4329h.size();
            this.f4329h.set(size - 1, ((String) this.f4329h.get(size - 1)) + ((String) toPathParts.get(0)));
            this.f4329h.addAll(toPathParts.subList(1, toPathParts.size()));
        }
    }

    public static List<String> toPathParts(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        Object obj = 1;
        int i = 0;
        while (obj != null) {
            String substring;
            int indexOf = str.indexOf(47, i);
            obj = indexOf != -1 ? 1 : null;
            if (obj != null) {
                substring = str.substring(i, indexOf);
            } else {
                substring = str.substring(i);
            }
            arrayList.add(CharEscapers.m4810b(substring));
            i = indexOf + 1;
        }
        return arrayList;
    }

    private void m5006a(StringBuilder stringBuilder) {
        int size = this.f4329h.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f4329h.get(i);
            if (i != 0) {
                stringBuilder.append('/');
            }
            if (str.length() != 0) {
                stringBuilder.append(CharEscapers.m4811c(str));
            }
        }
    }

    static void m5007a(Set<Entry<String, Object>> set, StringBuilder stringBuilder) {
        boolean z = true;
        for (Entry entry : set) {
            boolean z2;
            Object value = entry.getValue();
            if (value != null) {
                String f = CharEscapers.m4814f((String) entry.getKey());
                if (value instanceof Collection) {
                    for (Object value2 : (Collection) value2) {
                        z = m5008a(z, stringBuilder, f, value2);
                    }
                    z2 = z;
                } else {
                    z2 = m5008a(z, stringBuilder, f, value2);
                }
            } else {
                z2 = z;
            }
            z = z2;
        }
    }

    private static boolean m5008a(boolean z, StringBuilder stringBuilder, String str, Object obj) {
        if (z) {
            z = false;
            stringBuilder.append('?');
        } else {
            stringBuilder.append('&');
        }
        stringBuilder.append(str);
        String f = CharEscapers.m4814f(obj.toString());
        if (f.length() != 0) {
            stringBuilder.append('=').append(f);
        }
        return z;
    }

    private static URI m5005a(String str) {
        try {
            return new URI(str);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static URL m5009b(String str) {
        try {
            return new URL(str);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }
}
