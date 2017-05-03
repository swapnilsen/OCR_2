package p000a.p001a.p002a.p003a.p004a.p010e;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: a.a.a.a.a.e.f */
public final class NetworkUtils {
    public static final SSLSocketFactory m288a(PinningInfoProvider pinningInfoProvider) {
        SSLContext instance = SSLContext.getInstance("TLS");
        PinningTrustManager pinningTrustManager = new PinningTrustManager(new SystemKeyStore(pinningInfoProvider.getKeyStoreStream(), pinningInfoProvider.getKeyStorePassword()), pinningInfoProvider);
        instance.init(null, new TrustManager[]{pinningTrustManager}, null);
        return instance.getSocketFactory();
    }
}
