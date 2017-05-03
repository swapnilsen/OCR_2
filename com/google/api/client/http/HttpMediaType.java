package com.google.api.client.http;

import com.google.api.client.p082b.Preconditions;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HttpMediaType {
    private static final Pattern f4348a;
    private static final Pattern f4349b;
    private static final Pattern f4350c;
    private static final Pattern f4351d;
    private String f4352e;
    private String f4353f;
    private final SortedMap<String, String> f4354g;
    private String f4355h;

    static {
        f4348a = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
        f4349b = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
        String str = "[^\\s/=;\"]+";
        f4350c = Pattern.compile("\\s*(" + str + ")/(" + str + ")" + "\\s*(" + ";.*" + ")?", 32);
        f4351d = Pattern.compile("\\s*;\\s*(" + str + ")" + "=(" + ("\"([^\"]*)\"" + "|" + "[^\\s;\"]*") + ")");
    }

    public HttpMediaType(String str, String str2) {
        this.f4352e = "application";
        this.f4353f = "octet-stream";
        this.f4354g = new TreeMap();
        setType(str);
        setSubType(str2);
    }

    public HttpMediaType(String str) {
        this.f4352e = "application";
        this.f4353f = "octet-stream";
        this.f4354g = new TreeMap();
        m5020b(str);
    }

    public HttpMediaType setType(String str) {
        Preconditions.m4972a(f4348a.matcher(str).matches(), (Object) "Type contains reserved characters");
        this.f4352e = str;
        this.f4355h = null;
        return this;
    }

    public String getType() {
        return this.f4352e;
    }

    public HttpMediaType setSubType(String str) {
        Preconditions.m4972a(f4348a.matcher(str).matches(), (Object) "Subtype contains reserved characters");
        this.f4353f = str;
        this.f4355h = null;
        return this;
    }

    public String getSubType() {
        return this.f4353f;
    }

    private HttpMediaType m5020b(String str) {
        Matcher matcher = f4350c.matcher(str);
        Preconditions.m4972a(matcher.matches(), (Object) "Type must be in the 'maintype/subtype; parameter=value' format");
        setType(matcher.group(1));
        setSubType(matcher.group(2));
        CharSequence group = matcher.group(3);
        if (group != null) {
            Matcher matcher2 = f4351d.matcher(group);
            while (matcher2.find()) {
                String group2 = matcher2.group(1);
                String group3 = matcher2.group(3);
                if (group3 == null) {
                    group3 = matcher2.group(2);
                }
                setParameter(group2, group3);
            }
        }
        return this;
    }

    public HttpMediaType setParameter(String str, String str2) {
        if (str2 == null) {
            removeParameter(str);
        } else {
            Preconditions.m4972a(f4349b.matcher(str).matches(), (Object) "Name contains reserved characters");
            this.f4355h = null;
            this.f4354g.put(str.toLowerCase(), str2);
        }
        return this;
    }

    public String getParameter(String str) {
        return (String) this.f4354g.get(str.toLowerCase());
    }

    public HttpMediaType removeParameter(String str) {
        this.f4355h = null;
        this.f4354g.remove(str.toLowerCase());
        return this;
    }

    public void clearParameters() {
        this.f4355h = null;
        this.f4354g.clear();
    }

    public Map<String, String> getParameters() {
        return Collections.unmodifiableMap(this.f4354g);
    }

    static boolean m5019a(String str) {
        return f4349b.matcher(str).matches();
    }

    private static String m5021c(String str) {
        return "\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    public String build() {
        if (this.f4355h != null) {
            return this.f4355h;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f4352e);
        stringBuilder.append('/');
        stringBuilder.append(this.f4353f);
        if (this.f4354g != null) {
            for (Entry entry : this.f4354g.entrySet()) {
                String str = (String) entry.getValue();
                stringBuilder.append("; ");
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                if (!m5019a(str)) {
                    str = m5021c(str);
                }
                stringBuilder.append(str);
            }
        }
        this.f4355h = stringBuilder.toString();
        return this.f4355h;
    }

    public String toString() {
        return build();
    }

    public boolean equalsIgnoreParameters(HttpMediaType httpMediaType) {
        return httpMediaType != null && getType().equalsIgnoreCase(httpMediaType.getType()) && getSubType().equalsIgnoreCase(httpMediaType.getSubType());
    }

    public static boolean equalsIgnoreParameters(String str, String str2) {
        return (str == null && str2 == null) || !(str == null || str2 == null || !new HttpMediaType(str).equalsIgnoreParameters(new HttpMediaType(str2)));
    }

    public HttpMediaType setCharsetParameter(Charset charset) {
        setParameter("charset", charset == null ? null : charset.name());
        return this;
    }

    public Charset getCharsetParameter() {
        String parameter = getParameter("charset");
        return parameter == null ? null : Charset.forName(parameter);
    }

    public int hashCode() {
        return build().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpMediaType)) {
            return false;
        }
        HttpMediaType httpMediaType = (HttpMediaType) obj;
        if (equalsIgnoreParameters(httpMediaType) && this.f4354g.equals(httpMediaType.f4354g)) {
            return true;
        }
        return false;
    }
}
