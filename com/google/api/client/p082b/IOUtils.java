package com.google.api.client.p082b;

import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.api.client.b.p */
public class IOUtils {
    public static void m4956a(InputStream inputStream, OutputStream outputStream) {
        IOUtils.m4957a(inputStream, outputStream, true);
    }

    public static void m4957a(InputStream inputStream, OutputStream outputStream, boolean z) {
        try {
            ByteStreams.m4888a(inputStream, outputStream);
            if (z) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (z) {
                inputStream.close();
            }
        }
    }

    public static long m4955a(ae aeVar) {
        OutputStream byteCountingOutputStream = new ByteCountingOutputStream();
        try {
            aeVar.writeTo(byteCountingOutputStream);
            return byteCountingOutputStream.f4136a;
        } finally {
            byteCountingOutputStream.close();
        }
    }
}
