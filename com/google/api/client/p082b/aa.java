package com.google.api.client.p082b;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* compiled from: SecurityUtils */
/* renamed from: com.google.api.client.b.aa */
public final class aa {
    public static KeyStore m4841a() {
        return KeyStore.getInstance("JKS");
    }

    public static void m4843a(KeyStore keyStore, InputStream inputStream, String str) {
        try {
            keyStore.load(inputStream, str.toCharArray());
        } finally {
            inputStream.close();
        }
    }

    public static Signature m4847b() {
        return Signature.getInstance("SHA256withRSA");
    }

    public static byte[] m4846a(Signature signature, PrivateKey privateKey, byte[] bArr) {
        signature.initSign(privateKey);
        signature.update(bArr);
        return signature.sign();
    }

    public static boolean m4845a(Signature signature, PublicKey publicKey, byte[] bArr, byte[] bArr2) {
        signature.initVerify(publicKey);
        signature.update(bArr2);
        try {
            return signature.verify(bArr);
        } catch (SignatureException e) {
            return false;
        }
    }

    public static X509Certificate m4842a(Signature signature, X509TrustManager x509TrustManager, List<String> list, byte[] bArr, byte[] bArr2) {
        try {
            CertificateFactory c = aa.m4848c();
            X509Certificate[] x509CertificateArr = new X509Certificate[list.size()];
            int i = 0;
            for (String a : list) {
                try {
                    Certificate generateCertificate = c.generateCertificate(new ByteArrayInputStream(Base64.m4885a(a)));
                    if (!(generateCertificate instanceof X509Certificate)) {
                        return null;
                    }
                    int i2 = i + 1;
                    x509CertificateArr[i] = (X509Certificate) generateCertificate;
                    i = i2;
                } catch (CertificateException e) {
                    return null;
                }
            }
            try {
                x509TrustManager.checkServerTrusted(x509CertificateArr, "RSA");
                if (aa.m4845a(signature, x509CertificateArr[0].getPublicKey(), bArr, bArr2)) {
                    return x509CertificateArr[0];
                }
                return null;
            } catch (CertificateException e2) {
                return null;
            }
        } catch (CertificateException e3) {
            return null;
        }
    }

    public static CertificateFactory m4848c() {
        return CertificateFactory.getInstance("X.509");
    }

    public static void m4844a(KeyStore keyStore, CertificateFactory certificateFactory, InputStream inputStream) {
        int i = 0;
        for (Certificate certificateEntry : certificateFactory.generateCertificates(inputStream)) {
            keyStore.setCertificateEntry(String.valueOf(i), certificateEntry);
            i++;
        }
    }
}
