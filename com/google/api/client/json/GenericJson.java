package com.google.api.client.json;

import com.google.api.client.p082b.GenericData;
import com.google.api.client.p082b.ah;

public class GenericJson extends GenericData implements Cloneable {
    private JsonFactory f4305c;

    public final JsonFactory getFactory() {
        return this.f4305c;
    }

    public final void setFactory(JsonFactory jsonFactory) {
        this.f4305c = jsonFactory;
    }

    public String toString() {
        if (this.f4305c == null) {
            return super.toString();
        }
        try {
            return this.f4305c.toString(this);
        } catch (Throwable e) {
            throw ah.m4859a(e);
        }
    }

    public String toPrettyString() {
        if (this.f4305c != null) {
            return this.f4305c.toPrettyString(this);
        }
        return super.toString();
    }

    public GenericJson clone() {
        return (GenericJson) super.clone();
    }

    public GenericJson set(String str, Object obj) {
        return (GenericJson) super.set(str, obj);
    }
}
