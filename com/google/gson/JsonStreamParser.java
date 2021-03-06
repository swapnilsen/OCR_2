package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.EOFException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser implements Iterator<JsonElement> {
    private final JsonReader f4689a;
    private final Object f4690b;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    public JsonStreamParser(Reader reader) {
        this.f4689a = new JsonReader(reader);
        this.f4689a.setLenient(true);
        this.f4690b = new Object();
    }

    public JsonElement next() {
        if (hasNext()) {
            try {
                return Streams.parse(this.f4689a);
            } catch (Throwable e) {
                throw new JsonParseException("Failed parsing JSON source to Json", e);
            } catch (Throwable e2) {
                throw new JsonParseException("Failed parsing JSON source to Json", e2);
            } catch (JsonParseException e3) {
                JsonParseException e4 = e3;
                if (e4.getCause() instanceof EOFException) {
                    e4 = new NoSuchElementException();
                }
                throw e4;
            }
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        boolean z;
        synchronized (this.f4690b) {
            try {
                z = this.f4689a.peek() != JsonToken.END_DOCUMENT;
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (Throwable e2) {
                throw new JsonIOException(e2);
            }
        }
        return z;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
