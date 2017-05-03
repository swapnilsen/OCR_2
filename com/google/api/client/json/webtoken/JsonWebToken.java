package com.google.api.client.json.webtoken;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import com.google.api.client.p082b.Objects;
import com.google.api.client.p082b.Preconditions;
import java.util.Collections;
import java.util.List;

public class JsonWebToken {
    private final Header f4486a;
    private final Payload f4487b;

    public static class Header extends GenericJson {
        @Key(a = "cty")
        private String contentType;
        @Key(a = "typ")
        private String type;

        public final String getType() {
            return this.type;
        }

        public Header setType(String str) {
            this.type = str;
            return this;
        }

        public final String getContentType() {
            return this.contentType;
        }

        public Header setContentType(String str) {
            this.contentType = str;
            return this;
        }

        public Header set(String str, Object obj) {
            return (Header) super.set(str, obj);
        }

        public Header clone() {
            return (Header) super.clone();
        }
    }

    public static class Payload extends GenericJson {
        @Key(a = "aud")
        private Object audience;
        @Key(a = "exp")
        private Long expirationTimeSeconds;
        @Key(a = "iat")
        private Long issuedAtTimeSeconds;
        @Key(a = "iss")
        private String issuer;
        @Key(a = "jti")
        private String jwtId;
        @Key(a = "nbf")
        private Long notBeforeTimeSeconds;
        @Key(a = "sub")
        private String subject;
        @Key(a = "typ")
        private String type;

        public final Long getExpirationTimeSeconds() {
            return this.expirationTimeSeconds;
        }

        public Payload setExpirationTimeSeconds(Long l) {
            this.expirationTimeSeconds = l;
            return this;
        }

        public final Long getNotBeforeTimeSeconds() {
            return this.notBeforeTimeSeconds;
        }

        public Payload setNotBeforeTimeSeconds(Long l) {
            this.notBeforeTimeSeconds = l;
            return this;
        }

        public final Long getIssuedAtTimeSeconds() {
            return this.issuedAtTimeSeconds;
        }

        public Payload setIssuedAtTimeSeconds(Long l) {
            this.issuedAtTimeSeconds = l;
            return this;
        }

        public final String getIssuer() {
            return this.issuer;
        }

        public Payload setIssuer(String str) {
            this.issuer = str;
            return this;
        }

        public final Object getAudience() {
            return this.audience;
        }

        public final List<String> getAudienceAsList() {
            if (this.audience == null) {
                return Collections.emptyList();
            }
            if (this.audience instanceof String) {
                return Collections.singletonList((String) this.audience);
            }
            return (List) this.audience;
        }

        public Payload setAudience(Object obj) {
            this.audience = obj;
            return this;
        }

        public final String getJwtId() {
            return this.jwtId;
        }

        public Payload setJwtId(String str) {
            this.jwtId = str;
            return this;
        }

        public final String getType() {
            return this.type;
        }

        public Payload setType(String str) {
            this.type = str;
            return this;
        }

        public final String getSubject() {
            return this.subject;
        }

        public Payload setSubject(String str) {
            this.subject = str;
            return this;
        }

        public Payload set(String str, Object obj) {
            return (Payload) super.set(str, obj);
        }

        public Payload clone() {
            return (Payload) super.clone();
        }
    }

    public JsonWebToken(Header header, Payload payload) {
        this.f4486a = (Header) Preconditions.m4968a((Object) header);
        this.f4487b = (Payload) Preconditions.m4968a((Object) payload);
    }

    public String toString() {
        return Objects.m4966a(this).m4965a("header", this.f4486a).m4965a("payload", this.f4487b).toString();
    }

    public Header getHeader() {
        return this.f4486a;
    }

    public Payload getPayload() {
        return this.f4487b;
    }
}
