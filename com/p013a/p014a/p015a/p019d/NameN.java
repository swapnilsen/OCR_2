package com.p013a.p014a.p015a.p019d;

/* renamed from: com.a.a.a.d.g */
public final class NameN extends Name {
    final int[] f610c;
    final int f611d;

    NameN(String str, int i, int[] iArr, int i2) {
        super(str, i);
        if (i2 < 3) {
            throw new IllegalArgumentException("Qlen must >= 3");
        }
        this.f610c = iArr;
        this.f611d = i2;
    }

    public boolean m907a(int i) {
        return false;
    }

    public boolean m908a(int i, int i2) {
        return false;
    }

    public boolean m909a(int[] iArr, int i) {
        if (i != this.f611d) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != this.f610c[i2]) {
                return false;
            }
        }
        return true;
    }
}
