package p000a.p001a.p002a.p003a.p004a.p010e;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* renamed from: a.a.a.a.a.e.a */
final class CertificateChainCleaner {
    public static X509Certificate[] m212a(X509Certificate[] x509CertificateArr, SystemKeyStore systemKeyStore) {
        int i;
        int i2 = 1;
        LinkedList linkedList = new LinkedList();
        if (systemKeyStore.m296a(x509CertificateArr[0])) {
            i = 1;
        } else {
            i = 0;
        }
        linkedList.add(x509CertificateArr[0]);
        int i3 = i;
        i = 1;
        while (i < x509CertificateArr.length) {
            if (systemKeyStore.m296a(x509CertificateArr[i])) {
                i3 = 1;
            }
            if (!CertificateChainCleaner.m211a(x509CertificateArr[i], x509CertificateArr[i - 1])) {
                break;
            }
            linkedList.add(x509CertificateArr[i]);
            i++;
        }
        X509Certificate b = systemKeyStore.m297b(x509CertificateArr[i - 1]);
        if (b != null) {
            linkedList.add(b);
        } else {
            i2 = i3;
        }
        if (i2 != 0) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    private static boolean m211a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }
}
