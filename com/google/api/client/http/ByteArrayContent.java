package com.google.api.client.http;

import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.af;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class ByteArrayContent extends AbstractInputStreamContent {
    private final byte[] f4317a;
    private final int f4318b;
    private final int f4319c;

    public ByteArrayContent(String str, byte[] bArr) {
        this(str, bArr, 0, bArr.length);
    }

    public ByteArrayContent(String str, byte[] bArr, int i, int i2) {
        boolean z;
        super(str);
        this.f4317a = (byte[]) Preconditions.m4968a((Object) bArr);
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.m4973a(z, "offset %s, length %s, array length %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
        this.f4318b = i;
        this.f4319c = i2;
    }

    public static ByteArrayContent fromString(String str, String str2) {
        return new ByteArrayContent(str, af.m4857a(str2));
    }

    public long getLength() {
        return (long) this.f4319c;
    }

    public boolean retrySupported() {
        return true;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f4317a, this.f4318b, this.f4319c);
    }

    public ByteArrayContent setType(String str) {
        return (ByteArrayContent) super.setType(str);
    }

    public ByteArrayContent setCloseInputStream(boolean z) {
        return (ByteArrayContent) super.setCloseInputStream(z);
    }
}
