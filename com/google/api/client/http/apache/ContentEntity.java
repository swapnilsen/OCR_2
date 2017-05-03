package com.google.api.client.http.apache;

import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ae;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

/* renamed from: com.google.api.client.http.apache.c */
final class ContentEntity extends AbstractHttpEntity {
    private final long f4433a;
    private final ae f4434b;

    ContentEntity(long j, ae aeVar) {
        this.f4433a = j;
        this.f4434b = (ae) Preconditions.m4968a((Object) aeVar);
    }

    public InputStream getContent() {
        throw new UnsupportedOperationException();
    }

    public long getContentLength() {
        return this.f4433a;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return true;
    }

    public void writeTo(OutputStream outputStream) {
        if (this.f4433a != 0) {
            this.f4434b.writeTo(outputStream);
        }
    }
}
