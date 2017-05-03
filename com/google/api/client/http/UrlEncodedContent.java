package com.google.api.client.http;

import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.FieldInfo;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ai;
import com.google.api.client.p082b.p083a.CharEscapers;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map.Entry;

public class UrlEncodedContent extends AbstractHttpContent {
    private Object f4423a;

    public UrlEncodedContent(Object obj) {
        super(UrlEncodedParser.MEDIA_TYPE);
        setData(obj);
    }

    public void writeTo(OutputStream outputStream) {
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, m5003a()));
        boolean z = true;
        for (Entry entry : Data.m4906b(this.f4423a).entrySet()) {
            boolean z2;
            Object value = entry.getValue();
            if (value != null) {
                String a = CharEscapers.m4809a((String) entry.getKey());
                Class cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    for (Object a2 : ai.m4863a(value)) {
                        z = m5036a(z, bufferedWriter, a, a2);
                    }
                    z2 = z;
                } else {
                    z2 = m5036a(z, bufferedWriter, a, value);
                }
            } else {
                z2 = z;
            }
            z = z2;
        }
        bufferedWriter.flush();
    }

    public UrlEncodedContent setMediaType(HttpMediaType httpMediaType) {
        super.setMediaType(httpMediaType);
        return this;
    }

    public final Object getData() {
        return this.f4423a;
    }

    public UrlEncodedContent setData(Object obj) {
        this.f4423a = Preconditions.m4968a(obj);
        return this;
    }

    public static UrlEncodedContent getContent(HttpRequest httpRequest) {
        HttpContent content = httpRequest.getContent();
        if (content != null) {
            return (UrlEncodedContent) content;
        }
        UrlEncodedContent urlEncodedContent = new UrlEncodedContent(new HashMap());
        httpRequest.setContent(urlEncodedContent);
        return urlEncodedContent;
    }

    private static boolean m5036a(boolean z, Writer writer, String str, Object obj) {
        if (!(obj == null || Data.m4902a(obj))) {
            if (z) {
                z = false;
            } else {
                writer.write("&");
            }
            writer.write(str);
            String a = CharEscapers.m4809a(obj instanceof Enum ? FieldInfo.m4941a((Enum) obj).m4948b() : obj.toString());
            if (a.length() != 0) {
                writer.write("=");
                writer.write(a);
            }
        }
        return z;
    }
}
