package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final List<JsonElement> f4685a;

    public JsonArray() {
        this.f4685a = new ArrayList();
    }

    public void add(Boolean bool) {
        this.f4685a.add(bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    public void add(Character ch) {
        this.f4685a.add(ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }

    public void add(Number number) {
        this.f4685a.add(number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    public void add(String str) {
        this.f4685a.add(str == null ? JsonNull.INSTANCE : new JsonPrimitive(str));
    }

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.f4685a.add(jsonElement);
    }

    public void addAll(JsonArray jsonArray) {
        this.f4685a.addAll(jsonArray.f4685a);
    }

    public JsonElement set(int i, JsonElement jsonElement) {
        return (JsonElement) this.f4685a.set(i, jsonElement);
    }

    public boolean remove(JsonElement jsonElement) {
        return this.f4685a.remove(jsonElement);
    }

    public JsonElement remove(int i) {
        return (JsonElement) this.f4685a.remove(i);
    }

    public boolean contains(JsonElement jsonElement) {
        return this.f4685a.contains(jsonElement);
    }

    public int size() {
        return this.f4685a.size();
    }

    public Iterator<JsonElement> iterator() {
        return this.f4685a.iterator();
    }

    public JsonElement get(int i) {
        return (JsonElement) this.f4685a.get(i);
    }

    public Number getAsNumber() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsNumber();
        }
        throw new IllegalStateException();
    }

    public String getAsString() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsString();
        }
        throw new IllegalStateException();
    }

    public double getAsDouble() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsDouble();
        }
        throw new IllegalStateException();
    }

    public BigDecimal getAsBigDecimal() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsBigDecimal();
        }
        throw new IllegalStateException();
    }

    public BigInteger getAsBigInteger() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsBigInteger();
        }
        throw new IllegalStateException();
    }

    public float getAsFloat() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsFloat();
        }
        throw new IllegalStateException();
    }

    public long getAsLong() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsLong();
        }
        throw new IllegalStateException();
    }

    public int getAsInt() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsInt();
        }
        throw new IllegalStateException();
    }

    public byte getAsByte() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsByte();
        }
        throw new IllegalStateException();
    }

    public char getAsCharacter() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsCharacter();
        }
        throw new IllegalStateException();
    }

    public short getAsShort() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsShort();
        }
        throw new IllegalStateException();
    }

    public boolean getAsBoolean() {
        if (this.f4685a.size() == 1) {
            return ((JsonElement) this.f4685a.get(0)).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).f4685a.equals(this.f4685a));
    }

    public int hashCode() {
        return this.f4685a.hashCode();
    }
}
