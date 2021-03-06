package com.crashlytics.android.answers;

public class RatingEvent extends PredefinedEvent<RatingEvent> {
    static final String CONTENT_ID_ATTRIBUTE = "contentId";
    static final String CONTENT_NAME_ATTRIBUTE = "contentName";
    static final String CONTENT_TYPE_ATTRIBUTE = "contentType";
    static final String RATING_ATTRIBUTE = "rating";
    static final String TYPE = "rating";

    public RatingEvent putContentId(String str) {
        this.predefinedAttributes.put(CONTENT_ID_ATTRIBUTE, str);
        return this;
    }

    public RatingEvent putContentName(String str) {
        this.predefinedAttributes.put(CONTENT_NAME_ATTRIBUTE, str);
        return this;
    }

    public RatingEvent putContentType(String str) {
        this.predefinedAttributes.put(CONTENT_TYPE_ATTRIBUTE, str);
        return this;
    }

    public RatingEvent putRating(int i) {
        this.predefinedAttributes.put(TYPE, Integer.valueOf(i));
        return this;
    }

    String getPredefinedType() {
        return TYPE;
    }
}
