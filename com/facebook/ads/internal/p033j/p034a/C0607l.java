package com.facebook.ads.internal.p033j.p034a;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.facebook.ads.internal.j.a.l */
public abstract class C0607l {
    protected String f1408a;
    protected C0609j f1409b;
    protected String f1410c;
    protected byte[] f1411d;

    public C0607l(String str, C0614p c0614p) {
        this.f1408a = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        if (str != null) {
            this.f1408a = str;
        }
        if (c0614p != null) {
            this.f1408a += "?" + c0614p.m1929a();
        }
    }

    public String m1913a() {
        return this.f1408a;
    }

    public C0609j m1914b() {
        return this.f1409b;
    }

    public String m1915c() {
        return this.f1410c;
    }

    public byte[] m1916d() {
        return this.f1411d;
    }
}
