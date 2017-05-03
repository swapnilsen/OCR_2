package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public final class FieldAttributes {
    private final Field f4646a;

    public FieldAttributes(Field field) {
        C$Gson$Preconditions.checkNotNull(field);
        this.f4646a = field;
    }

    public Class<?> getDeclaringClass() {
        return this.f4646a.getDeclaringClass();
    }

    public String getName() {
        return this.f4646a.getName();
    }

    public Type getDeclaredType() {
        return this.f4646a.getGenericType();
    }

    public Class<?> getDeclaredClass() {
        return this.f4646a.getType();
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return this.f4646a.getAnnotation(cls);
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.f4646a.getAnnotations());
    }

    public boolean hasModifier(int i) {
        return (this.f4646a.getModifiers() & i) != 0;
    }
}
