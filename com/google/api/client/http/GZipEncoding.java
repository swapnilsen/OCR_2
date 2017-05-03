package com.google.api.client.http;

import com.google.api.client.p082b.ae;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZipEncoding implements HttpEncoding {

    /* renamed from: com.google.api.client.http.GZipEncoding.1 */
    class C14741 extends BufferedOutputStream {
        final /* synthetic */ GZipEncoding f4323a;

        C14741(GZipEncoding gZipEncoding, OutputStream outputStream) {
            this.f4323a = gZipEncoding;
            super(outputStream);
        }

        public void close() {
            try {
                flush();
            } catch (IOException e) {
            }
        }
    }

    public String getName() {
        return "gzip";
    }

    public void encode(ae aeVar, OutputStream outputStream) {
        OutputStream gZIPOutputStream = new GZIPOutputStream(new C14741(this, outputStream));
        aeVar.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}
