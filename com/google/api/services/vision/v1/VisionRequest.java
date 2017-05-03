package com.google.api.services.vision.v1;

import com.google.api.client.googleapis.p087c.p088a.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.p082b.Key;

public abstract class VisionRequest<T> extends AbstractGoogleJsonClientRequest<T> {
    @Key(a = "$.xgafv")
    private String $Xgafv;
    @Key(a = "access_token")
    private String accessToken;
    @Key
    private String alt;
    @Key(a = "bearer_token")
    private String bearerToken;
    @Key
    private String callback;
    @Key
    private String fields;
    @Key
    private String key;
    @Key(a = "oauth_token")
    private String oauthToken;
    @Key
    private Boolean pp;
    @Key
    private Boolean prettyPrint;
    @Key
    private String quotaUser;
    @Key(a = "upload_protocol")
    private String uploadProtocol;
    @Key
    private String uploadType;

    public VisionRequest(Vision vision, String str, String str2, Object obj, Class<T> cls) {
        super(vision, str, str2, obj, cls);
    }

    public String get$Xgafv() {
        return this.$Xgafv;
    }

    public VisionRequest<T> set$Xgafv(String str) {
        this.$Xgafv = str;
        return this;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public VisionRequest<T> setAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public String getAlt() {
        return this.alt;
    }

    public VisionRequest<T> setAlt(String str) {
        this.alt = str;
        return this;
    }

    public String getBearerToken() {
        return this.bearerToken;
    }

    public VisionRequest<T> setBearerToken(String str) {
        this.bearerToken = str;
        return this;
    }

    public String getCallback() {
        return this.callback;
    }

    public VisionRequest<T> setCallback(String str) {
        this.callback = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public VisionRequest<T> setFields(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public VisionRequest<T> setKey(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    public VisionRequest<T> setOauthToken(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPp() {
        return this.pp;
    }

    public VisionRequest<T> setPp(Boolean bool) {
        this.pp = bool;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public VisionRequest<T> setPrettyPrint(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    public VisionRequest<T> setQuotaUser(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUploadType() {
        return this.uploadType;
    }

    public VisionRequest<T> setUploadType(String str) {
        this.uploadType = str;
        return this;
    }

    public String getUploadProtocol() {
        return this.uploadProtocol;
    }

    public VisionRequest<T> setUploadProtocol(String str) {
        this.uploadProtocol = str;
        return this;
    }

    public final Vision getAbstractGoogleClient() {
        return (Vision) super.getAbstractGoogleClient();
    }

    public VisionRequest<T> setDisableGZipContent(boolean z) {
        return (VisionRequest) super.setDisableGZipContent(z);
    }

    public VisionRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (VisionRequest) super.setRequestHeaders(httpHeaders);
    }

    public VisionRequest<T> set(String str, Object obj) {
        return (VisionRequest) super.set(str, obj);
    }
}
