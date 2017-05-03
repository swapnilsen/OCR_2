package com.google.api.client.json.webtoken;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.webtoken.JsonWebToken.Payload;
import com.google.api.client.p082b.Base64;
import com.google.api.client.p082b.Key;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.aa;
import com.google.api.client.p082b.af;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class JsonWebSignature extends JsonWebToken {
    private final byte[] f4488a;
    private final byte[] f4489b;

    public static class Header extends com.google.api.client.json.webtoken.JsonWebToken.Header {
        @Key(a = "alg")
        private String algorithm;
        @Key(a = "crit")
        private List<String> critical;
        @Key(a = "jwk")
        private String jwk;
        @Key(a = "jku")
        private String jwkUrl;
        @Key(a = "kid")
        private String keyId;
        @Key(a = "x5c")
        private List<String> x509Certificates;
        @Key(a = "x5t")
        private String x509Thumbprint;
        @Key(a = "x5u")
        private String x509Url;

        public Header setType(String str) {
            super.setType(str);
            return this;
        }

        public final String getAlgorithm() {
            return this.algorithm;
        }

        public Header setAlgorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public final String getJwkUrl() {
            return this.jwkUrl;
        }

        public Header setJwkUrl(String str) {
            this.jwkUrl = str;
            return this;
        }

        public final String getJwk() {
            return this.jwk;
        }

        public Header setJwk(String str) {
            this.jwk = str;
            return this;
        }

        public final String getKeyId() {
            return this.keyId;
        }

        public Header setKeyId(String str) {
            this.keyId = str;
            return this;
        }

        public final String getX509Url() {
            return this.x509Url;
        }

        public Header setX509Url(String str) {
            this.x509Url = str;
            return this;
        }

        public final String getX509Thumbprint() {
            return this.x509Thumbprint;
        }

        public Header setX509Thumbprint(String str) {
            this.x509Thumbprint = str;
            return this;
        }

        @Deprecated
        public final String getX509Certificate() {
            if (this.x509Certificates == null || this.x509Certificates.isEmpty()) {
                return null;
            }
            return (String) this.x509Certificates.get(0);
        }

        public final List<String> getX509Certificates() {
            return this.x509Certificates;
        }

        @Deprecated
        public Header setX509Certificate(String str) {
            List arrayList = new ArrayList();
            arrayList.add(str);
            this.x509Certificates = arrayList;
            return this;
        }

        public Header setX509Certificates(List<String> list) {
            this.x509Certificates = list;
            return this;
        }

        public final List<String> getCritical() {
            return this.critical;
        }

        public Header setCritical(List<String> list) {
            this.critical = list;
            return this;
        }

        public Header set(String str, Object obj) {
            return (Header) super.set(str, obj);
        }

        public Header clone() {
            return (Header) super.clone();
        }
    }

    public static final class Parser {
        private final JsonFactory f4483a;
        private Class<? extends Header> f4484b;
        private Class<? extends Payload> f4485c;

        public Parser(JsonFactory jsonFactory) {
            this.f4484b = Header.class;
            this.f4485c = Payload.class;
            this.f4483a = (JsonFactory) Preconditions.m4968a((Object) jsonFactory);
        }

        public Class<? extends Header> getHeaderClass() {
            return this.f4484b;
        }

        public Parser setHeaderClass(Class<? extends Header> cls) {
            this.f4484b = cls;
            return this;
        }

        public Class<? extends Payload> getPayloadClass() {
            return this.f4485c;
        }

        public Parser setPayloadClass(Class<? extends Payload> cls) {
            this.f4485c = cls;
            return this;
        }

        public JsonFactory getJsonFactory() {
            return this.f4483a;
        }

        public JsonWebSignature parse(String str) {
            boolean z;
            boolean z2 = true;
            int indexOf = str.indexOf(46);
            Preconditions.m4971a(indexOf != -1);
            byte[] a = Base64.m4885a(str.substring(0, indexOf));
            int indexOf2 = str.indexOf(46, indexOf + 1);
            if (indexOf2 != -1) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.m4971a(z);
            if (str.indexOf(46, indexOf2 + 1) == -1) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.m4971a(z);
            byte[] a2 = Base64.m4885a(str.substring(indexOf + 1, indexOf2));
            byte[] a3 = Base64.m4885a(str.substring(indexOf2 + 1));
            byte[] a4 = af.m4857a(str.substring(0, indexOf2));
            Header header = (Header) this.f4483a.fromInputStream(new ByteArrayInputStream(a), this.f4484b);
            if (header.getAlgorithm() == null) {
                z2 = false;
            }
            Preconditions.m4971a(z2);
            return new JsonWebSignature(header, (Payload) this.f4483a.fromInputStream(new ByteArrayInputStream(a2), this.f4485c), a3, a4);
        }
    }

    public JsonWebSignature(Header header, Payload payload, byte[] bArr, byte[] bArr2) {
        super(header, payload);
        this.f4488a = (byte[]) Preconditions.m4968a((Object) bArr);
        this.f4489b = (byte[]) Preconditions.m4968a((Object) bArr2);
    }

    public Header getHeader() {
        return (Header) super.getHeader();
    }

    public final boolean verifySignature(PublicKey publicKey) {
        if ("RS256".equals(getHeader().getAlgorithm())) {
            return aa.m4845a(aa.m4847b(), publicKey, this.f4488a, this.f4489b);
        }
        return false;
    }

    public final X509Certificate verifySignature(X509TrustManager x509TrustManager) {
        List x509Certificates = getHeader().getX509Certificates();
        if (x509Certificates == null || x509Certificates.isEmpty()) {
            return null;
        }
        if ("RS256".equals(getHeader().getAlgorithm())) {
            return aa.m4842a(aa.m4847b(), x509TrustManager, x509Certificates, this.f4488a, this.f4489b);
        }
        return null;
    }

    public final X509Certificate verifySignature() {
        X509TrustManager a = m5060a();
        if (a == null) {
            return null;
        }
        return verifySignature(a);
    }

    private static X509TrustManager m5060a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            for (TrustManager trustManager : instance.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (KeyStoreException e2) {
            return null;
        }
    }

    public final byte[] getSignatureBytes() {
        return this.f4488a;
    }

    public final byte[] getSignedContentBytes() {
        return this.f4489b;
    }

    public static JsonWebSignature parse(JsonFactory jsonFactory, String str) {
        return parser(jsonFactory).parse(str);
    }

    public static Parser parser(JsonFactory jsonFactory) {
        return new Parser(jsonFactory);
    }

    public static String signUsingRsaSha256(PrivateKey privateKey, JsonFactory jsonFactory, Header header, Payload payload) {
        String str = Base64.m4886b(jsonFactory.toByteArray(header)) + "." + Base64.m4886b(jsonFactory.toByteArray(payload));
        return str + "." + Base64.m4886b(aa.m4846a(aa.m4847b(), privateKey, af.m4857a(str)));
    }
}
