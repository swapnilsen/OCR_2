package com.p013a.p014a.p015a.p018c;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.JsonLocation;
import com.p013a.p014a.p015a.JsonStreamContext;
import com.p013a.p014a.p015a.p017b.CharTypes;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.a.a.a.c.c */
public final class JsonReadContext extends JsonStreamContext {
    protected final JsonReadContext f502c;
    protected int f503d;
    protected int f504e;
    protected String f505f;
    protected JsonReadContext f506g;

    public JsonReadContext(JsonReadContext jsonReadContext, int i, int i2, int i3) {
        this.f506g = null;
        this.a = i;
        this.f502c = jsonReadContext;
        this.f503d = i2;
        this.f504e = i3;
        this.b = -1;
    }

    protected void m650a(int i, int i2, int i3) {
        this.a = i;
        this.b = -1;
        this.f503d = i2;
        this.f504e = i3;
        this.f505f = null;
    }

    public static JsonReadContext m647g() {
        return new JsonReadContext(null, 0, 1, 0);
    }

    public JsonReadContext m648a(int i, int i2) {
        JsonReadContext jsonReadContext = this.f506g;
        if (jsonReadContext == null) {
            jsonReadContext = new JsonReadContext(this, 1, i, i2);
            this.f506g = jsonReadContext;
            return jsonReadContext;
        }
        jsonReadContext.m650a(1, i, i2);
        return jsonReadContext;
    }

    public JsonReadContext m652b(int i, int i2) {
        JsonReadContext jsonReadContext = this.f506g;
        if (jsonReadContext == null) {
            jsonReadContext = new JsonReadContext(this, 2, i, i2);
            this.f506g = jsonReadContext;
            return jsonReadContext;
        }
        jsonReadContext.m650a(2, i, i2);
        return jsonReadContext;
    }

    public String m653h() {
        return this.f505f;
    }

    public JsonReadContext m654i() {
        return this.f502c;
    }

    public JsonLocation m649a(Object obj) {
        return new JsonLocation(obj, -1, this.f503d, this.f504e);
    }

    public boolean m655j() {
        int i = this.b + 1;
        this.b = i;
        return this.a != 0 && i > 0;
    }

    public void m651a(String str) {
        this.f505f = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        switch (this.a) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                stringBuilder.append("/");
                break;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                stringBuilder.append('[');
                stringBuilder.append(m646f());
                stringBuilder.append(']');
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                stringBuilder.append('{');
                if (this.f505f != null) {
                    stringBuilder.append('\"');
                    CharTypes.m555a(stringBuilder, this.f505f);
                    stringBuilder.append('\"');
                } else {
                    stringBuilder.append('?');
                }
                stringBuilder.append('}');
                break;
        }
        return stringBuilder.toString();
    }
}
