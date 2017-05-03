package com.google.api.client.p082b;

import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: SslUtils */
/* renamed from: com.google.api.client.b.ad */
public final class ad {

    /* renamed from: com.google.api.client.b.ad.1 */
    static class SslUtils implements X509TrustManager {
        SslUtils() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    /* renamed from: com.google.api.client.b.ad.2 */
    static class SslUtils implements HostnameVerifier {
        SslUtils() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public static SSLContext m4852a() {
        return SSLContext.getInstance("TLS");
    }

    public static TrustManagerFactory m4854b() {
        return TrustManagerFactory.getInstance("PKIX");
    }

    public static SSLContext m4853a(SSLContext sSLContext, KeyStore keyStore, TrustManagerFactory trustManagerFactory) {
        trustManagerFactory.init(keyStore);
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        return sSLContext;
    }

    public static SSLContext m4855c() {
        TrustManager[] trustManagerArr = new TrustManager[]{new SslUtils()};
        SSLContext a = ad.m4852a();
        a.init(null, trustManagerArr, null);
        return a;
    }

    public static HostnameVerifier m4856d() {
        return new SslUtils();
    }
}
