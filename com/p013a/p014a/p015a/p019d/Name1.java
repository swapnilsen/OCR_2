package com.p013a.p014a.p015a.p019d;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.a.a.a.d.d */
public final class Name1 extends Name {
    static final Name1 f603c;
    final int f604d;

    static {
        f603c = new Name1(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, 0, 0);
    }

    Name1(String str, int i, int i2) {
        super(str, i);
        this.f604d = i2;
    }

    static Name1 m897b() {
        return f603c;
    }

    public boolean m898a(int i) {
        return i == this.f604d;
    }

    public boolean m899a(int i, int i2) {
        return i == this.f604d && i2 == 0;
    }

    public boolean m900a(int[] iArr, int i) {
        return i == 1 && iArr[0] == this.f604d;
    }
}
