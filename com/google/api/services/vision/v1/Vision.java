package com.google.api.services.vision.v1;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.p087c.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.p087c.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.p087c.p088a.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.p082b.Preconditions;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;

public class Vision extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://vision.googleapis.com/";
    public static final String DEFAULT_ROOT_URL = "https://vision.googleapis.com/";
    public static final String DEFAULT_SERVICE_PATH = "";

    public static final class Builder extends AbstractGoogleJsonClient.AbstractGoogleJsonClient {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, Vision.DEFAULT_ROOT_URL, Vision.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
        }

        public Vision build() {
            return new Vision(this);
        }

        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }

        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }

        public Builder setVisionRequestInitializer(VisionRequestInitializer visionRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) visionRequestInitializer);
        }

        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }

    public class Images {
        final /* synthetic */ Vision f4491a;

        public class Annotate extends VisionRequest<BatchAnnotateImagesResponse> {
            final /* synthetic */ Images f4490c;

            protected Annotate(Images images, BatchAnnotateImagesRequest batchAnnotateImagesRequest) {
                this.f4490c = images;
                super(images.f4491a, HttpMethods.POST, "v1/images:annotate", batchAnnotateImagesRequest, BatchAnnotateImagesResponse.class);
            }

            public Annotate set$Xgafv(String str) {
                return (Annotate) super.set$Xgafv(str);
            }

            public Annotate setAccessToken(String str) {
                return (Annotate) super.setAccessToken(str);
            }

            public Annotate setAlt(String str) {
                return (Annotate) super.setAlt(str);
            }

            public Annotate setBearerToken(String str) {
                return (Annotate) super.setBearerToken(str);
            }

            public Annotate setCallback(String str) {
                return (Annotate) super.setCallback(str);
            }

            public Annotate setFields(String str) {
                return (Annotate) super.setFields(str);
            }

            public Annotate setKey(String str) {
                return (Annotate) super.setKey(str);
            }

            public Annotate setOauthToken(String str) {
                return (Annotate) super.setOauthToken(str);
            }

            public Annotate setPp(Boolean bool) {
                return (Annotate) super.setPp(bool);
            }

            public Annotate setPrettyPrint(Boolean bool) {
                return (Annotate) super.setPrettyPrint(bool);
            }

            public Annotate setQuotaUser(String str) {
                return (Annotate) super.setQuotaUser(str);
            }

            public Annotate setUploadType(String str) {
                return (Annotate) super.setUploadType(str);
            }

            public Annotate setUploadProtocol(String str) {
                return (Annotate) super.setUploadProtocol(str);
            }

            public Annotate set(String str, Object obj) {
                return (Annotate) super.set(str, obj);
            }
        }

        public Images(Vision vision) {
            this.f4491a = vision;
        }

        public Annotate annotate(BatchAnnotateImagesRequest batchAnnotateImagesRequest) {
            AbstractGoogleClientRequest annotate = new Annotate(this, batchAnnotateImagesRequest);
            this.f4491a.m5061a(annotate);
            return annotate;
        }
    }

    static {
        boolean z = GoogleUtils.f4234a.intValue() == 1 && GoogleUtils.f4235b.intValue() >= 15;
        Preconditions.m4975b(z, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.22.0 of the Google Cloud Vision API library.", GoogleUtils.f4237d);
    }

    public Vision(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    Vision(Builder builder) {
        super(builder);
    }

    protected void m5061a(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
        super.m4997a((AbstractGoogleClientRequest) abstractGoogleClientRequest);
    }

    public Images images() {
        return new Images(this);
    }
}
