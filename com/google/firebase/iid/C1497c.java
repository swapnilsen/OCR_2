package com.google.firebase.iid;

import android.support.annotation.Nullable;

@Deprecated
/* renamed from: com.google.firebase.iid.c */
public class C1497c {
    private final FirebaseInstanceId f4560a;

    private C1497c(FirebaseInstanceId firebaseInstanceId) {
        this.f4560a = firebaseInstanceId;
    }

    public static C1497c m5149a() {
        return new C1497c(FirebaseInstanceId.m5100a());
    }

    public String m5150b() {
        return this.f4560a.m5112c();
    }

    @Nullable
    public String m5151c() {
        return this.f4560a.m5114d();
    }
}
