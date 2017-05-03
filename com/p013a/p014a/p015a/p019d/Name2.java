package com.p013a.p014a.p015a.p019d;

/* renamed from: com.a.a.a.d.e */
public final class Name2 extends Name {
    final int f605c;
    final int f606d;

    Name2(String str, int i, int i2, int i3) {
        super(str, i);
        this.f605c = i2;
        this.f606d = i3;
    }

    public boolean m901a(int i) {
        return false;
    }

    public boolean m902a(int i, int i2) {
        return i == this.f605c && i2 == this.f606d;
    }

    public boolean m903a(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.f605c && iArr[1] == this.f606d;
    }
}
