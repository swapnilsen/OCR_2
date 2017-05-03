package com.p013a.p014a.p015a.p017b;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/* renamed from: com.a.a.a.b.j */
public abstract class OutputDecorator implements Serializable {
    public abstract OutputStream m600a(IOContext iOContext, OutputStream outputStream);

    public abstract Writer m601a(IOContext iOContext, Writer writer);
}
