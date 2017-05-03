package com.google.api.client.googleapis.p087c.p088a;

import com.google.api.client.googleapis.p087c.AbstractGoogleClient;
import com.google.api.client.googleapis.p087c.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.JsonObjectParser.Builder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.google.api.client.googleapis.c.a.a */
public abstract class AbstractGoogleJsonClient extends AbstractGoogleClient {

    /* renamed from: com.google.api.client.googleapis.c.a.a.a */
    public static abstract class AbstractGoogleJsonClient extends AbstractGoogleClient.AbstractGoogleClient {
        public abstract AbstractGoogleJsonClient build();

        protected AbstractGoogleJsonClient(HttpTransport httpTransport, JsonFactory jsonFactory, String str, String str2, HttpRequestInitializer httpRequestInitializer, boolean z) {
            Collection asList;
            Builder builder = new Builder(jsonFactory);
            if (z) {
                asList = Arrays.asList(new String[]{"data", "error"});
            } else {
                asList = Collections.emptySet();
            }
            super(httpTransport, str, str2, builder.setWrapperKeys(asList).build(), httpRequestInitializer);
        }

        public final JsonObjectParser getObjectParser() {
            return (JsonObjectParser) super.getObjectParser();
        }

        public final JsonFactory getJsonFactory() {
            return getObjectParser().getJsonFactory();
        }

        public AbstractGoogleJsonClient setRootUrl(String str) {
            return (AbstractGoogleJsonClient) super.setRootUrl(str);
        }

        public AbstractGoogleJsonClient setServicePath(String str) {
            return (AbstractGoogleJsonClient) super.setServicePath(str);
        }

        public AbstractGoogleJsonClient setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (AbstractGoogleJsonClient) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }

        public AbstractGoogleJsonClient setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (AbstractGoogleJsonClient) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        public AbstractGoogleJsonClient setApplicationName(String str) {
            return (AbstractGoogleJsonClient) super.setApplicationName(str);
        }

        public AbstractGoogleJsonClient setSuppressPatternChecks(boolean z) {
            return (AbstractGoogleJsonClient) super.setSuppressPatternChecks(z);
        }

        public AbstractGoogleJsonClient setSuppressRequiredParameterChecks(boolean z) {
            return (AbstractGoogleJsonClient) super.setSuppressRequiredParameterChecks(z);
        }

        public AbstractGoogleJsonClient setSuppressAllChecks(boolean z) {
            return (AbstractGoogleJsonClient) super.setSuppressAllChecks(z);
        }
    }

    protected AbstractGoogleJsonClient(AbstractGoogleJsonClient abstractGoogleJsonClient) {
        super(abstractGoogleJsonClient);
    }

    public JsonObjectParser getObjectParser() {
        return (JsonObjectParser) super.getObjectParser();
    }

    public final JsonFactory getJsonFactory() {
        return getObjectParser().getJsonFactory();
    }
}
