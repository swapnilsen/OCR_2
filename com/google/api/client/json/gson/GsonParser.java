package com.google.api.client.json.gson;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.p082b.Preconditions;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.stream.JsonReader;
import java.io.EOFException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import net.nend.android.NendIconError;

/* renamed from: com.google.api.client.json.gson.b */
class GsonParser extends JsonParser {
    private final JsonReader f4471a;
    private final GsonFactory f4472b;
    private List<String> f4473c;
    private JsonToken f4474d;
    private String f4475e;

    /* renamed from: com.google.api.client.json.gson.b.1 */
    static /* synthetic */ class GsonParser {
        static final /* synthetic */ int[] f4469a;
        static final /* synthetic */ int[] f4470b;

        static {
            f4470b = new int[com.google.gson.stream.JsonToken.values().length];
            try {
                f4470b[com.google.gson.stream.JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4470b[com.google.gson.stream.JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4470b[com.google.gson.stream.JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4470b[com.google.gson.stream.JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4470b[com.google.gson.stream.JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4470b[com.google.gson.stream.JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4470b[com.google.gson.stream.JsonToken.STRING.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4470b[com.google.gson.stream.JsonToken.NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f4470b[com.google.gson.stream.JsonToken.NAME.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            f4469a = new int[JsonToken.values().length];
            try {
                f4469a[JsonToken.START_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f4469a[JsonToken.START_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    GsonParser(GsonFactory gsonFactory, JsonReader jsonReader) {
        this.f4473c = new ArrayList();
        this.f4472b = gsonFactory;
        this.f4471a = jsonReader;
        jsonReader.setLenient(true);
    }

    public void close() {
        this.f4471a.close();
    }

    public String getCurrentName() {
        return this.f4473c.isEmpty() ? null : (String) this.f4473c.get(this.f4473c.size() - 1);
    }

    public JsonToken getCurrentToken() {
        return this.f4474d;
    }

    public JsonFactory getFactory() {
        return this.f4472b;
    }

    public byte getByteValue() {
        m5056a();
        return Byte.valueOf(this.f4475e).byteValue();
    }

    public short getShortValue() {
        m5056a();
        return Short.valueOf(this.f4475e).shortValue();
    }

    public int getIntValue() {
        m5056a();
        return Integer.valueOf(this.f4475e).intValue();
    }

    public float getFloatValue() {
        m5056a();
        return Float.valueOf(this.f4475e).floatValue();
    }

    public BigInteger getBigIntegerValue() {
        m5056a();
        return new BigInteger(this.f4475e);
    }

    public BigDecimal getDecimalValue() {
        m5056a();
        return new BigDecimal(this.f4475e);
    }

    public double getDoubleValue() {
        m5056a();
        return Double.valueOf(this.f4475e).doubleValue();
    }

    public long getLongValue() {
        m5056a();
        return Long.valueOf(this.f4475e).longValue();
    }

    private void m5056a() {
        boolean z = this.f4474d == JsonToken.VALUE_NUMBER_INT || this.f4474d == JsonToken.VALUE_NUMBER_FLOAT;
        Preconditions.m4971a(z);
    }

    public String getText() {
        return this.f4475e;
    }

    public JsonToken nextToken() {
        com.google.gson.stream.JsonToken peek;
        if (this.f4474d != null) {
            switch (GsonParser.f4469a[this.f4474d.ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    this.f4471a.beginArray();
                    this.f4473c.add(null);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    this.f4471a.beginObject();
                    this.f4473c.add(null);
                    break;
            }
        }
        try {
            peek = this.f4471a.peek();
        } catch (EOFException e) {
            peek = com.google.gson.stream.JsonToken.END_DOCUMENT;
        }
        switch (GsonParser.f4470b[peek.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                this.f4475e = "[";
                this.f4474d = JsonToken.START_ARRAY;
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                this.f4475e = "]";
                this.f4474d = JsonToken.END_ARRAY;
                this.f4473c.remove(this.f4473c.size() - 1);
                this.f4471a.endArray();
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                this.f4475e = "{";
                this.f4474d = JsonToken.START_OBJECT;
                break;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                this.f4475e = "}";
                this.f4474d = JsonToken.END_OBJECT;
                this.f4473c.remove(this.f4473c.size() - 1);
                this.f4471a.endObject();
                break;
            case Type.OTHER_PROFILE /*5*/:
                if (!this.f4471a.nextBoolean()) {
                    this.f4475e = "false";
                    this.f4474d = JsonToken.VALUE_FALSE;
                    break;
                }
                this.f4475e = "true";
                this.f4474d = JsonToken.VALUE_TRUE;
                break;
            case Type.CONTRIBUTOR /*6*/:
                this.f4475e = "null";
                this.f4474d = JsonToken.VALUE_NULL;
                this.f4471a.nextNull();
                break;
            case Type.WEBSITE /*7*/:
                this.f4475e = this.f4471a.nextString();
                this.f4474d = JsonToken.VALUE_STRING;
                break;
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                this.f4475e = this.f4471a.nextString();
                this.f4474d = this.f4475e.indexOf(46) == -1 ? JsonToken.VALUE_NUMBER_INT : JsonToken.VALUE_NUMBER_FLOAT;
                break;
            case ConnectionResult.SERVICE_INVALID /*9*/:
                this.f4475e = this.f4471a.nextName();
                this.f4474d = JsonToken.FIELD_NAME;
                this.f4473c.set(this.f4473c.size() - 1, this.f4475e);
                break;
            default:
                this.f4475e = null;
                this.f4474d = null;
                break;
        }
        return this.f4474d;
    }

    public JsonParser skipChildren() {
        if (this.f4474d != null) {
            switch (GsonParser.f4469a[this.f4474d.ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    this.f4471a.skipValue();
                    this.f4475e = "]";
                    this.f4474d = JsonToken.END_ARRAY;
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    this.f4471a.skipValue();
                    this.f4475e = "}";
                    this.f4474d = JsonToken.END_OBJECT;
                    break;
            }
        }
        return this;
    }
}
