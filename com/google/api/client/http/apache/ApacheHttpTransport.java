package com.google.api.client.http.apache;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.aa;
import com.google.api.client.p082b.ad;
import java.io.InputStream;
import java.net.ProxySelector;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class ApacheHttpTransport extends HttpTransport {
    private final HttpClient f4427b;

    public static final class Builder {
        private SSLSocketFactory f4424a;
        private HttpParams f4425b;
        private ProxySelector f4426c;

        public Builder() {
            this.f4424a = SSLSocketFactory.getSocketFactory();
            this.f4425b = ApacheHttpTransport.m5039b();
            this.f4426c = ProxySelector.getDefault();
        }

        public Builder setProxy(HttpHost httpHost) {
            ConnRouteParams.setDefaultProxy(this.f4425b, httpHost);
            if (httpHost != null) {
                this.f4426c = null;
            }
            return this;
        }

        public Builder setProxySelector(ProxySelector proxySelector) {
            this.f4426c = proxySelector;
            if (proxySelector != null) {
                ConnRouteParams.setDefaultProxy(this.f4425b, null);
            }
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
            return setSocketFactory(new SSLSocketFactoryExtension(a));
        }

        public Builder doNotValidateCertificate() {
            this.f4424a = new SSLSocketFactoryExtension(ad.m4855c());
            this.f4424a.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return this;
        }

        public Builder setSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f4424a = (SSLSocketFactory) Preconditions.m4968a((Object) sSLSocketFactory);
            return this;
        }

        public SSLSocketFactory getSSLSocketFactory() {
            return this.f4424a;
        }

        public HttpParams getHttpParams() {
            return this.f4425b;
        }

        public ApacheHttpTransport build() {
            return new ApacheHttpTransport(ApacheHttpTransport.m5038a(this.f4424a, this.f4425b, this.f4426c));
        }
    }

    protected /* synthetic */ LowLevelHttpRequest m5040a(String str, String str2) {
        return m5041b(str, str2);
    }

    public ApacheHttpTransport() {
        this(newDefaultHttpClient());
    }

    public ApacheHttpTransport(HttpClient httpClient) {
        this.f4427b = httpClient;
        HttpParams params = httpClient.getParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        params.setBooleanParameter("http.protocol.handle-redirects", false);
    }

    public static DefaultHttpClient newDefaultHttpClient() {
        return m5038a(SSLSocketFactory.getSocketFactory(), m5039b(), ProxySelector.getDefault());
    }

    static HttpParams m5039b() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, HttpStatusCodes.STATUS_CODE_OK);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(20));
        return basicHttpParams;
    }

    static DefaultHttpClient m5038a(SSLSocketFactory sSLSocketFactory, HttpParams httpParams, ProxySelector proxySelector) {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", sSLSocketFactory, 443));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
        defaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        if (proxySelector != null) {
            defaultHttpClient.setRoutePlanner(new ProxySelectorRoutePlanner(schemeRegistry, proxySelector));
        }
        return defaultHttpClient;
    }

    public boolean supportsMethod(String str) {
        return true;
    }

    protected ApacheHttpRequest m5041b(String str, String str2) {
        HttpRequestBase httpDelete;
        if (str.equals(HttpMethods.DELETE)) {
            httpDelete = new HttpDelete(str2);
        } else if (str.equals(HttpMethods.GET)) {
            httpDelete = new HttpGet(str2);
        } else if (str.equals(HttpMethods.HEAD)) {
            httpDelete = new HttpHead(str2);
        } else if (str.equals(HttpMethods.POST)) {
            httpDelete = new HttpPost(str2);
        } else if (str.equals(HttpMethods.PUT)) {
            httpDelete = new HttpPut(str2);
        } else if (str.equals(HttpMethods.TRACE)) {
            httpDelete = new HttpTrace(str2);
        } else if (str.equals(HttpMethods.OPTIONS)) {
            httpDelete = new HttpOptions(str2);
        } else {
            httpDelete = new HttpExtensionMethod(str, str2);
        }
        return new ApacheHttpRequest(this.f4427b, httpDelete);
    }

    public void shutdown() {
        this.f4427b.getConnectionManager().shutdown();
    }

    public HttpClient getHttpClient() {
        return this.f4427b;
    }
}
