package com.google.gson;

import com.google.gson.internal.bind.util.ISO8601Utils;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.google.gson.a */
final class DefaultDateTypeAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
    private final DateFormat f4693a;
    private final DateFormat f4694b;

    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return m5331a(jsonElement, type, jsonDeserializationContext);
    }

    public /* synthetic */ JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return m5330a((Date) obj, type, jsonSerializationContext);
    }

    DefaultDateTypeAdapter() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    DefaultDateTypeAdapter(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    public DefaultDateTypeAdapter(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    DefaultDateTypeAdapter(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f4693a = dateFormat;
        this.f4694b = dateFormat2;
    }

    public JsonElement m5330a(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonPrimitive;
        synchronized (this.f4694b) {
            jsonPrimitive = new JsonPrimitive(this.f4693a.format(date));
        }
        return jsonPrimitive;
    }

    public Date m5331a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        if (jsonElement instanceof JsonPrimitive) {
            Date a = m5329a(jsonElement);
            if (type == Date.class) {
                return a;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a.getTime());
            }
            throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
        }
        throw new JsonParseException("The date should be a string value");
    }

    private Date m5329a(JsonElement jsonElement) {
        Date parse;
        synchronized (this.f4694b) {
            try {
                parse = this.f4694b.parse(jsonElement.getAsString());
            } catch (ParseException e) {
                try {
                    parse = this.f4693a.parse(jsonElement.getAsString());
                } catch (ParseException e2) {
                    try {
                        parse = ISO8601Utils.parse(jsonElement.getAsString(), new ParsePosition(0));
                    } catch (Throwable e3) {
                        throw new JsonSyntaxException(jsonElement.getAsString(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DefaultDateTypeAdapter.class.getSimpleName());
        stringBuilder.append('(').append(this.f4694b.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }
}
