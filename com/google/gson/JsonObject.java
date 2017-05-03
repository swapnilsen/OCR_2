package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map.Entry;
import java.util.Set;

public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> f4686a;

    public JsonObject() {
        this.f4686a = new LinkedTreeMap();
    }

    public void add(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.f4686a.put(str, jsonElement);
    }

    public JsonElement remove(String str) {
        return (JsonElement) this.f4686a.remove(str);
    }

    public void addProperty(String str, String str2) {
        add(str, m5324a(str2));
    }

    public void addProperty(String str, Number number) {
        add(str, m5324a(number));
    }

    public void addProperty(String str, Boolean bool) {
        add(str, m5324a(bool));
    }

    public void addProperty(String str, Character ch) {
        add(str, m5324a(ch));
    }

    private JsonElement m5324a(Object obj) {
        return obj == null ? JsonNull.INSTANCE : new JsonPrimitive(obj);
    }

    public Set<Entry<String, JsonElement>> entrySet() {
        return this.f4686a.entrySet();
    }

    public int size() {
        return this.f4686a.size();
    }

    public boolean has(String str) {
        return this.f4686a.containsKey(str);
    }

    public JsonElement get(String str) {
        return (JsonElement) this.f4686a.get(str);
    }

    public JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.f4686a.get(str);
    }

    public JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.f4686a.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.f4686a.get(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).f4686a.equals(this.f4686a));
    }

    public int hashCode() {
        return this.f4686a.hashCode();
    }
}
