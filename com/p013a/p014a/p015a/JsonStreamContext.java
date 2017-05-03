package com.p013a.p014a.p015a;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.a.a.a.i */
public abstract class JsonStreamContext {
    protected int f500a;
    protected int f501b;

    protected JsonStreamContext() {
    }

    public final boolean m641a() {
        return this.f500a == 1;
    }

    public final boolean m642b() {
        return this.f500a == 0;
    }

    public final boolean m643c() {
        return this.f500a == 2;
    }

    public final String m644d() {
        switch (this.f500a) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return "ROOT";
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return "ARRAY";
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return "OBJECT";
            default:
                return "?";
        }
    }

    public final int m645e() {
        return this.f501b + 1;
    }

    public final int m646f() {
        return this.f501b < 0 ? 0 : this.f501b;
    }
}
