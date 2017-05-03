package com.google.api.client.p082b.p083a;

import java.net.URLDecoder;

/* renamed from: com.google.api.client.b.a.a */
public final class CharEscapers {
    private static final Escaper f4111a;
    private static final Escaper f4112b;
    private static final Escaper f4113c;
    private static final Escaper f4114d;
    private static final Escaper f4115e;

    static {
        f4111a = new PercentEscaper("-_.*", true);
        f4112b = new PercentEscaper("-_.!~*'()@:$&,;=", false);
        f4113c = new PercentEscaper("-_.!~*'()@:$&,;=+/?", false);
        f4114d = new PercentEscaper("-_.!~*'():$&,;=", false);
        f4115e = new PercentEscaper("-_.!~*'()@:$,;/?:", false);
    }

    public static String m4809a(String str) {
        return f4111a.m4815a(str);
    }

    public static String m4810b(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String m4811c(String str) {
        return f4112b.m4815a(str);
    }

    public static String m4812d(String str) {
        return f4113c.m4815a(str);
    }

    public static String m4813e(String str) {
        return f4114d.m4815a(str);
    }

    public static String m4814f(String str) {
        return f4115e.m4815a(str);
    }
}
