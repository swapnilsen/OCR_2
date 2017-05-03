package com.google.api.client.googleapis.p087c;

import com.google.api.client.googleapis.p084a.BatchRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.p082b.ObjectParser;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ag;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.logging.Logger;

/* renamed from: com.google.api.client.googleapis.c.a */
public abstract class AbstractGoogleClient {
    static final Logger f4278a;
    private final HttpRequestFactory f4279b;
    private final GoogleClientRequestInitializer f4280c;
    private final String f4281d;
    private final String f4282e;
    private final String f4283f;
    private final ObjectParser f4284g;
    private boolean f4285h;
    private boolean f4286i;

    /* renamed from: com.google.api.client.googleapis.c.a.a */
    public static abstract class AbstractGoogleClient {
        final HttpTransport f4269a;
        GoogleClientRequestInitializer f4270b;
        HttpRequestInitializer f4271c;
        final ObjectParser f4272d;
        String f4273e;
        String f4274f;
        String f4275g;
        boolean f4276h;
        boolean f4277i;

        public abstract AbstractGoogleClient build();

        protected AbstractGoogleClient(HttpTransport httpTransport, String str, String str2, ObjectParser objectParser, HttpRequestInitializer httpRequestInitializer) {
            this.f4269a = (HttpTransport) Preconditions.m4968a((Object) httpTransport);
            this.f4272d = objectParser;
            setRootUrl(str);
            setServicePath(str2);
            this.f4271c = httpRequestInitializer;
        }

        public final HttpTransport getTransport() {
            return this.f4269a;
        }

        public ObjectParser getObjectParser() {
            return this.f4272d;
        }

        public final String getRootUrl() {
            return this.f4273e;
        }

        public AbstractGoogleClient setRootUrl(String str) {
            this.f4273e = AbstractGoogleClient.m4995a(str);
            return this;
        }

        public final String getServicePath() {
            return this.f4274f;
        }

        public AbstractGoogleClient setServicePath(String str) {
            this.f4274f = AbstractGoogleClient.m4996b(str);
            return this;
        }

        public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
            return this.f4270b;
        }

        public AbstractGoogleClient setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            this.f4270b = googleClientRequestInitializer;
            return this;
        }

        public final HttpRequestInitializer getHttpRequestInitializer() {
            return this.f4271c;
        }

        public AbstractGoogleClient setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            this.f4271c = httpRequestInitializer;
            return this;
        }

        public final String getApplicationName() {
            return this.f4275g;
        }

        public AbstractGoogleClient setApplicationName(String str) {
            this.f4275g = str;
            return this;
        }

        public final boolean getSuppressPatternChecks() {
            return this.f4276h;
        }

        public AbstractGoogleClient setSuppressPatternChecks(boolean z) {
            this.f4276h = z;
            return this;
        }

        public final boolean getSuppressRequiredParameterChecks() {
            return this.f4277i;
        }

        public AbstractGoogleClient setSuppressRequiredParameterChecks(boolean z) {
            this.f4277i = z;
            return this;
        }

        public AbstractGoogleClient setSuppressAllChecks(boolean z) {
            return setSuppressPatternChecks(true).setSuppressRequiredParameterChecks(true);
        }
    }

    static {
        f4278a = Logger.getLogger(AbstractGoogleClient.class.getName());
    }

    protected AbstractGoogleClient(AbstractGoogleClient abstractGoogleClient) {
        this.f4280c = abstractGoogleClient.f4270b;
        this.f4281d = AbstractGoogleClient.m4995a(abstractGoogleClient.f4273e);
        this.f4282e = AbstractGoogleClient.m4996b(abstractGoogleClient.f4274f);
        if (ag.m4858a(abstractGoogleClient.f4275g)) {
            f4278a.warning("Application name is not set. Call Builder#setApplicationName.");
        }
        this.f4283f = abstractGoogleClient.f4275g;
        this.f4279b = abstractGoogleClient.f4271c == null ? abstractGoogleClient.f4269a.createRequestFactory() : abstractGoogleClient.f4269a.createRequestFactory(abstractGoogleClient.f4271c);
        this.f4284g = abstractGoogleClient.f4272d;
        this.f4285h = abstractGoogleClient.f4276h;
        this.f4286i = abstractGoogleClient.f4277i;
    }

    public final String getRootUrl() {
        return this.f4281d;
    }

    public final String getServicePath() {
        return this.f4282e;
    }

    public final String getBaseUrl() {
        return this.f4281d + this.f4282e;
    }

    public final String getApplicationName() {
        return this.f4283f;
    }

    public final HttpRequestFactory getRequestFactory() {
        return this.f4279b;
    }

    public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
        return this.f4280c;
    }

    public ObjectParser getObjectParser() {
        return this.f4284g;
    }

    protected void m4997a(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
        if (getGoogleClientRequestInitializer() != null) {
            getGoogleClientRequestInitializer().initialize(abstractGoogleClientRequest);
        }
    }

    public final BatchRequest batch() {
        return batch(null);
    }

    public final BatchRequest batch(HttpRequestInitializer httpRequestInitializer) {
        BatchRequest batchRequest = new BatchRequest(getRequestFactory().getTransport(), httpRequestInitializer);
        batchRequest.m4977a(new GenericUrl(getRootUrl() + "batch"));
        return batchRequest;
    }

    public final boolean getSuppressPatternChecks() {
        return this.f4285h;
    }

    public final boolean getSuppressRequiredParameterChecks() {
        return this.f4286i;
    }

    static String m4995a(String str) {
        Preconditions.m4969a((Object) str, (Object) "root URL cannot be null.");
        if (str.endsWith("/")) {
            return str;
        }
        return str + "/";
    }

    static String m4996b(String str) {
        Preconditions.m4969a((Object) str, (Object) "service path cannot be null");
        if (str.length() == 1) {
            Preconditions.m4972a("/".equals(str), (Object) "service path must equal \"/\" if it is of length 1.");
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        } else if (str.length() <= 0) {
            return str;
        } else {
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            if (str.startsWith("/")) {
                return str.substring(1);
            }
            return str;
        }
    }
}
