package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat f4811a;
    private final DateFormat f4812b;

    /* renamed from: com.google.gson.internal.bind.DateTypeAdapter.1 */
    static class C15641 implements TypeAdapterFactory {
        C15641() {
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            return typeToken.getRawType() == Date.class ? new DateTypeAdapter() : null;
        }
    }

    public DateTypeAdapter() {
        this.f4811a = DateFormat.getDateTimeInstance(2, 2, Locale.US);
        this.f4812b = DateFormat.getDateTimeInstance(2, 2);
    }

    static {
        FACTORY = new C15641();
    }

    public Date read(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return m5394a(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    private synchronized Date m5394a(String str) {
        Date parse;
        try {
            parse = this.f4812b.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.f4811a.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = ISO8601Utils.parse(str, new ParsePosition(0));
                } catch (Throwable e3) {
                    throw new JsonSyntaxException(str, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void write(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(this.f4811a.format(date));
        }
    }
}
