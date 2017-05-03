package com.p013a.p014a.p015a.p019d;

/* renamed from: com.a.a.a.d.c */
public abstract class Name {
    protected final String f601a;
    protected final int f602b;

    public abstract boolean m894a(int i);

    public abstract boolean m895a(int i, int i2);

    public abstract boolean m896a(int[] iArr, int i);

    protected Name(String str, int i) {
        this.f601a = str;
        this.f602b = i;
    }

    public String m893a() {
        return this.f601a;
    }

    public String toString() {
        return this.f601a;
    }

    public final int hashCode() {
        return this.f602b;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }
}
