package com.p013a.p014a.p015a.p018c;

import android.support.v4.media.TransportMediator;
import com.p013a.p014a.p015a.JsonGenerator.JsonGenerator;
import com.p013a.p014a.p015a.ObjectCodec;
import com.p013a.p014a.p015a.SerializableString;
import com.p013a.p014a.p015a.p016a.GeneratorBase;
import com.p013a.p014a.p015a.p017b.CharTypes;
import com.p013a.p014a.p015a.p017b.CharacterEscapes;
import com.p013a.p014a.p015a.p017b.IOContext;
import com.p013a.p014a.p015a.p020e.DefaultPrettyPrinter;

/* renamed from: com.a.a.a.c.b */
public abstract class JsonGeneratorImpl extends GeneratorBase {
    protected static final int[] f494g;
    protected final IOContext f495h;
    protected int[] f496i;
    protected int f497j;
    protected CharacterEscapes f498k;
    protected SerializableString f499l;

    static {
        f494g = CharTypes.m561f();
    }

    public JsonGeneratorImpl(IOContext iOContext, int i, ObjectCodec objectCodec) {
        super(i, objectCodec);
        this.f496i = f494g;
        this.f499l = DefaultPrettyPrinter.f636a;
        this.f495h = iOContext;
        if (m474a(JsonGenerator.ESCAPE_NON_ASCII)) {
            m638a((int) TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
    }

    public com.p013a.p014a.p015a.JsonGenerator m638a(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f497j = i;
        return this;
    }

    public com.p013a.p014a.p015a.JsonGenerator m639a(CharacterEscapes characterEscapes) {
        this.f498k = characterEscapes;
        if (characterEscapes == null) {
            this.f496i = f494g;
        } else {
            this.f496i = characterEscapes.m565a();
        }
        return this;
    }

    public com.p013a.p014a.p015a.JsonGenerator m640a(SerializableString serializableString) {
        this.f499l = serializableString;
        return this;
    }
}
