package com.google.api.client.http.apache;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* renamed from: com.google.api.client.http.apache.e */
final class SSLSocketFactoryExtension extends SSLSocketFactory {
    private final javax.net.ssl.SSLSocketFactory f4436a;

    SSLSocketFactoryExtension(SSLContext sSLContext) {
        super((KeyStore) null);
        this.f4436a = sSLContext.getSocketFactory();
    }

    public Socket createSocket() {
        return this.f4436a.createSocket();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        SSLSocket sSLSocket = (SSLSocket) this.f4436a.createSocket(socket, str, i, z);
        getHostnameVerifier().verify(str, sSLSocket);
        return sSLSocket;
    }
}
