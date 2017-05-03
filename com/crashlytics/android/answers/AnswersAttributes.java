package com.crashlytics.android.answers;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class AnswersAttributes {
    final Map<String, Object> attributes;
    final AnswersEventValidator validator;

    public AnswersAttributes(AnswersEventValidator answersEventValidator) {
        this.attributes = new ConcurrentHashMap();
        this.validator = answersEventValidator;
    }

    void put(String str, String str2) {
        if (!this.validator.isNull(str, "key") && !this.validator.isNull(str2, Param.VALUE)) {
            putAttribute(this.validator.limitStringLength(str), this.validator.limitStringLength(str2));
        }
    }

    void put(String str, Number number) {
        if (!this.validator.isNull(str, "key") && !this.validator.isNull(number, Param.VALUE)) {
            putAttribute(this.validator.limitStringLength(str), number);
        }
    }

    void putAttribute(String str, Object obj) {
        if (!this.validator.isFullMap(this.attributes, str)) {
            this.attributes.put(str, obj);
        }
    }

    public String toString() {
        return new JSONObject(this.attributes).toString();
    }
}
