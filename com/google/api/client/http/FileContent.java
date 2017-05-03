package com.google.api.client.http;

import com.google.api.client.p082b.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class FileContent extends AbstractInputStreamContent {
    private final File f4322a;

    public FileContent(String str, File file) {
        super(str);
        this.f4322a = (File) Preconditions.m4968a((Object) file);
    }

    public long getLength() {
        return this.f4322a.length();
    }

    public boolean retrySupported() {
        return true;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.f4322a);
    }

    public File getFile() {
        return this.f4322a;
    }

    public FileContent setType(String str) {
        return (FileContent) super.setType(str);
    }

    public FileContent setCloseInputStream(boolean z) {
        return (FileContent) super.setCloseInputStream(z);
    }
}
