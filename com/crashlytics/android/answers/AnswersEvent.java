package com.crashlytics.android.answers;

import java.util.Map;
import p000a.p001a.p002a.p003a.Fabric;

public abstract class AnswersEvent<T extends AnswersEvent> {
    public static final int MAX_NUM_ATTRIBUTES = 20;
    public static final int MAX_STRING_LENGTH = 100;
    final AnswersAttributes customAttributes;
    final AnswersEventValidator validator;

    public AnswersEvent() {
        this.validator = new AnswersEventValidator(MAX_NUM_ATTRIBUTES, MAX_STRING_LENGTH, Fabric.m398i());
        this.customAttributes = new AnswersAttributes(this.validator);
    }

    Map<String, Object> getCustomAttributes() {
        return this.customAttributes.attributes;
    }

    public T putCustomAttribute(String str, String str2) {
        this.customAttributes.put(str, str2);
        return this;
    }

    public T putCustomAttribute(String str, Number number) {
        this.customAttributes.put(str, number);
        return this;
    }
}
