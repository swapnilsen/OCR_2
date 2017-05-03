package p000a.p001a.p002a.p003a.p004a.p010e;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p000a.p001a.p002a.p003a.Fabric;

/* renamed from: a.a.a.a.a.e.h */
class PinningTrustManager implements X509TrustManager {
    private static final X509Certificate[] f186a;
    private final TrustManager[] f187b;
    private final SystemKeyStore f188c;
    private final long f189d;
    private final List<byte[]> f190e;
    private final Set<X509Certificate> f191f;

    static {
        f186a = new X509Certificate[0];
    }

    public PinningTrustManager(SystemKeyStore systemKeyStore, PinningInfoProvider pinningInfoProvider) {
        this.f190e = new LinkedList();
        this.f191f = Collections.synchronizedSet(new HashSet());
        this.f187b = m293a(systemKeyStore);
        this.f188c = systemKeyStore;
        this.f189d = pinningInfoProvider.getPinCreationTimeInMillis();
        for (String a : pinningInfoProvider.getPins()) {
            this.f190e.add(m292a(a));
        }
    }

    private TrustManager[] m293a(SystemKeyStore systemKeyStore) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(systemKeyStore.f192a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean m291a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f190e) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private void m290a(X509Certificate[] x509CertificateArr, String str) {
        for (TrustManager trustManager : this.f187b) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void m289a(X509Certificate[] x509CertificateArr) {
        if (this.f189d == -1 || System.currentTimeMillis() - this.f189d <= 15552000000L) {
            X509Certificate[] a = CertificateChainCleaner.m212a(x509CertificateArr, this.f188c);
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!m291a(a[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        Fabric.m397h().m364d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f189d) + " millis vs " + 15552000000L + " millis) " + "falling back to system trust.");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.f191f.contains(x509CertificateArr[0])) {
            m290a(x509CertificateArr, str);
            m289a(x509CertificateArr);
            this.f191f.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f186a;
    }

    private byte[] m292a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
