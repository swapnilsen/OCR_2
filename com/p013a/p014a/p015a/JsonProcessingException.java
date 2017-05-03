package com.p013a.p014a.p015a;

import java.io.IOException;

/* renamed from: com.a.a.a.h */
public class JsonProcessingException extends IOException {
    protected JsonLocation f548a;

    protected JsonProcessingException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
        this.f548a = jsonLocation;
    }

    protected JsonProcessingException(String str, JsonLocation jsonLocation) {
        this(str, jsonLocation, null);
    }

    public JsonLocation m838a() {
        return this.f548a;
    }

    protected String m839b() {
        return null;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        JsonLocation a = m838a();
        String b = m839b();
        if (a == null && b == null) {
            return message;
        }
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(message);
        if (b != null) {
            stringBuilder.append(b);
        }
        if (a != null) {
            stringBuilder.append('\n');
            stringBuilder.append(" at ");
            stringBuilder.append(a.toString());
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
