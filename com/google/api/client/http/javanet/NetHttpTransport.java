package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.aa;
import com.google.api.client.p082b.ad;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class NetHttpTransport extends HttpTransport {
    private static final String[] f4442b;
    private final ConnectionFactory f4443c;
    private final SSLSocketFactory f4444d;
    private final HostnameVerifier f4445e;

    public static final class Builder {
        private SSLSocketFactory f4438a;
        private HostnameVerifier f4439b;
        private Proxy f4440c;
        private ConnectionFactory f4441d;

        public Builder setProxy(Proxy proxy) {
            this.f4440c = proxy;
            return this;
        }

        public Builder setConnectionFactory(ConnectionFactory connectionFactory) {
            this.f4441d = connectionFactory;
            return this;
        }

        public Builder trustCertificatesFromJavaKeyStore(InputStream inputStream, String str) {
            KeyStore a = aa.m4841a();
            aa.m4843a(a, inputStream, str);
            return trustCertificates(a);
        }

        public Builder trustCertificatesFromStream(InputStream inputStream) {
            KeyStore a = aa.m4841a();
            a.load(null, null);
            aa.m4844a(a, aa.m4848c(), inputStream);
            return trustCertificates(a);
        }

        public Builder trustCertificates(KeyStore keyStore) {
            SSLContext a = ad.m4852a();
            ad.m4853a(a, keyStore, ad.m4854b());
            return setSslSocketFactory(a.getSocketFactory());
        }

        public Builder doNotValidateCertificate() {
            this.f4439b = ad.m4856d();
            this.f4438a = ad.m4855c().getSocketFactory();
            return this;
        }

        public SSLSocketFactory getSslSocketFactory() {
            return this.f4438a;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f4438a = sSLSocketFactory;
            return this;
        }

        public HostnameVerifier getHostnameVerifier() {
            return this.f4439b;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f4439b = hostnameVerifier;
            return this;
        }

        public NetHttpTransport build() {
            return this.f4440c == null ? new NetHttpTransport(this.f4441d, this.f4438a, this.f4439b) : new NetHttpTransport(this.f4440c, this.f4438a, this.f4439b);
        }
    }

    protected /* synthetic */ LowLevelHttpRequest m5042a(String str, String str2) {
        return m5043b(str, str2);
    }

    static {
        f4442b = new String[]{HttpMethods.DELETE, HttpMethods.GET, HttpMethods.HEAD, HttpMethods.OPTIONS, HttpMethods.POST, HttpMethods.PUT, HttpMethods.TRACE};
        Arrays.sort(f4442b);
    }

    public NetHttpTransport() {
        this((ConnectionFactory) null, null, null);
    }

    NetHttpTransport(Proxy proxy, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        this(new DefaultConnectionFactory(proxy), sSLSocketFactory, hostnameVerifier);
    }

    NetHttpTransport(ConnectionFactory connectionFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        if (connectionFactory == null) {
            connectionFactory = new DefaultConnectionFactory();
        }
        this.f4443c = connectionFactory;
        this.f4444d = sSLSocketFactory;
        this.f4445e = hostnameVerifier;
    }

    public boolean supportsMethod(String str) {
        return Arrays.binarySearch(f4442b, str) >= 0;
    }

    protected NetHttpRequest m5043b(String str, String str2) {
        Preconditions.m4973a(supportsMethod(str), "HTTP method %s not supported", str);
        HttpURLConnection openConnection = this.f4443c.openConnection(new URL(str2));
        openConnection.setRequestMethod(str);
        if (openConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            if (this.f4445e != null) {
                httpsURLConnection.setHostnameVerifier(this.f4445e);
            }
            if (this.f4444d != null) {
                httpsURLConnection.setSSLSocketFactory(this.f4444d);
            }
        }
        return new NetHttpRequest(openConnection);
    }
}
