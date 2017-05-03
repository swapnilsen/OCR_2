package com.google.api.client.json.jackson2;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.p082b.Preconditions;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.JsonEncoding;
import com.p013a.p014a.p015a.JsonGenerator.JsonGenerator;
import com.p013a.p014a.p015a.JsonToken;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import net.nend.android.NendIconError;

public final class JacksonFactory extends JsonFactory {
    private final com.p013a.p014a.p015a.JsonFactory f4478a;

    /* renamed from: com.google.api.client.json.jackson2.JacksonFactory.1 */
    static /* synthetic */ class C14831 {
        static final /* synthetic */ int[] f4476a;

        static {
            f4476a = new int[JsonToken.values().length];
            try {
                f4476a[JsonToken.END_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4476a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4476a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4476a[JsonToken.START_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4476a[JsonToken.VALUE_FALSE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4476a[JsonToken.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4476a[JsonToken.VALUE_NULL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4476a[JsonToken.VALUE_STRING.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f4476a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f4476a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f4476a[JsonToken.FIELD_NAME.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* renamed from: com.google.api.client.json.jackson2.JacksonFactory.a */
    static class C1484a {
        static final JacksonFactory f4477a;

        static {
            f4477a = new JacksonFactory();
        }
    }

    public JacksonFactory() {
        this.f4478a = new com.p013a.p014a.p015a.JsonFactory();
        this.f4478a.m613a(JsonGenerator.AUTO_CLOSE_JSON_CONTENT, false);
    }

    public static JacksonFactory getDefaultInstance() {
        return C1484a.f4477a;
    }

    public com.google.api.client.json.JsonGenerator createJsonGenerator(OutputStream outputStream, Charset charset) {
        return new JacksonGenerator(this, this.f4478a.m614a(outputStream, JsonEncoding.UTF8));
    }

    public com.google.api.client.json.JsonGenerator createJsonGenerator(Writer writer) {
        return new JacksonGenerator(this, this.f4478a.m616a(writer));
    }

    public JsonParser createJsonParser(Reader reader) {
        Preconditions.m4968a((Object) reader);
        return new JacksonParser(this, this.f4478a.m621a(reader));
    }

    public JsonParser createJsonParser(InputStream inputStream) {
        Preconditions.m4968a((Object) inputStream);
        return new JacksonParser(this, this.f4478a.m619a(inputStream));
    }

    public JsonParser createJsonParser(InputStream inputStream, Charset charset) {
        Preconditions.m4968a((Object) inputStream);
        return new JacksonParser(this, this.f4478a.m619a(inputStream));
    }

    public JsonParser createJsonParser(String str) {
        Preconditions.m4968a((Object) str);
        return new JacksonParser(this, this.f4478a.m623a(str));
    }

    static com.google.api.client.json.JsonToken m5057a(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (C14831.f4476a[jsonToken.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return com.google.api.client.json.JsonToken.END_ARRAY;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return com.google.api.client.json.JsonToken.START_ARRAY;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return com.google.api.client.json.JsonToken.END_OBJECT;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return com.google.api.client.json.JsonToken.START_OBJECT;
            case Type.OTHER_PROFILE /*5*/:
                return com.google.api.client.json.JsonToken.VALUE_FALSE;
            case Type.CONTRIBUTOR /*6*/:
                return com.google.api.client.json.JsonToken.VALUE_TRUE;
            case Type.WEBSITE /*7*/:
                return com.google.api.client.json.JsonToken.VALUE_NULL;
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                return com.google.api.client.json.JsonToken.VALUE_STRING;
            case ConnectionResult.SERVICE_INVALID /*9*/:
                return com.google.api.client.json.JsonToken.VALUE_NUMBER_FLOAT;
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                return com.google.api.client.json.JsonToken.VALUE_NUMBER_INT;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return com.google.api.client.json.JsonToken.FIELD_NAME;
            default:
                return com.google.api.client.json.JsonToken.NOT_AVAILABLE;
        }
    }
}
