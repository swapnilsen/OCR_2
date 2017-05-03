package com.p013a.p014a.p015a;

/* renamed from: com.a.a.a.a */
public enum JsonEncoding {
    UTF8("UTF-8", false),
    UTF16_BE("UTF-16BE", true),
    UTF16_LE("UTF-16LE", false),
    UTF32_BE("UTF-32BE", true),
    UTF32_LE("UTF-32LE", false);
    
    protected final String f401f;
    protected final boolean f402g;

    private JsonEncoding(String str, boolean z) {
        this.f401f = str;
        this.f402g = z;
    }

    public String m546a() {
        return this.f401f;
    }

    public boolean m547b() {
        return this.f402g;
    }
}
