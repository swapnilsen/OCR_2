package com.google.api.client.http;

import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ae;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class MultipartContent extends AbstractHttpContent {
    private ArrayList<Part> f4407a;

    public static final class Part {
        HttpContent f4404a;
        HttpHeaders f4405b;
        HttpEncoding f4406c;

        public Part() {
            this(null);
        }

        public Part(HttpContent httpContent) {
            this(null, httpContent);
        }

        public Part(HttpHeaders httpHeaders, HttpContent httpContent) {
            setHeaders(httpHeaders);
            setContent(httpContent);
        }

        public Part setContent(HttpContent httpContent) {
            this.f4404a = httpContent;
            return this;
        }

        public HttpContent getContent() {
            return this.f4404a;
        }

        public Part setHeaders(HttpHeaders httpHeaders) {
            this.f4405b = httpHeaders;
            return this;
        }

        public HttpHeaders getHeaders() {
            return this.f4405b;
        }

        public Part setEncoding(HttpEncoding httpEncoding) {
            this.f4406c = httpEncoding;
            return this;
        }

        public HttpEncoding getEncoding() {
            return this.f4406c;
        }
    }

    public MultipartContent() {
        super(new HttpMediaType("multipart/related").setParameter("boundary", "__END_OF_PART__"));
        this.f4407a = new ArrayList();
    }

    public void writeTo(OutputStream outputStream) {
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, m5003a());
        String boundary = getBoundary();
        Iterator it = this.f4407a.iterator();
        while (it.hasNext()) {
            ae aeVar;
            Part part = (Part) it.next();
            HttpHeaders acceptEncoding = new HttpHeaders().setAcceptEncoding(null);
            if (part.f4405b != null) {
                acceptEncoding.fromHttpHeaders(part.f4405b);
            }
            acceptEncoding.setContentEncoding(null).setUserAgent(null).setContentType(null).setContentLength(null).set("Content-Transfer-Encoding", null);
            ae aeVar2 = part.f4404a;
            if (aeVar2 != null) {
                long length;
                acceptEncoding.set("Content-Transfer-Encoding", Arrays.asList(new String[]{"binary"}));
                acceptEncoding.setContentType(aeVar2.getType());
                HttpEncoding httpEncoding = part.f4406c;
                if (httpEncoding == null) {
                    length = aeVar2.getLength();
                    aeVar = aeVar2;
                } else {
                    acceptEncoding.setContentEncoding(httpEncoding.getName());
                    aeVar = new HttpEncodingStreamingContent(aeVar2, httpEncoding);
                    length = AbstractHttpContent.computeLength(aeVar2);
                }
                if (length != -1) {
                    acceptEncoding.setContentLength(Long.valueOf(length));
                }
            } else {
                aeVar = null;
            }
            outputStreamWriter.write("--");
            outputStreamWriter.write(boundary);
            outputStreamWriter.write("\r\n");
            HttpHeaders.serializeHeadersForMultipartRequests(acceptEncoding, null, null, outputStreamWriter);
            if (aeVar != null) {
                outputStreamWriter.write("\r\n");
                outputStreamWriter.flush();
                aeVar.writeTo(outputStream);
            }
            outputStreamWriter.write("\r\n");
        }
        outputStreamWriter.write("--");
        outputStreamWriter.write(boundary);
        outputStreamWriter.write("--");
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
    }

    public boolean retrySupported() {
        Iterator it = this.f4407a.iterator();
        while (it.hasNext()) {
            if (!((Part) it.next()).f4404a.retrySupported()) {
                return false;
            }
        }
        return true;
    }

    public MultipartContent setMediaType(HttpMediaType httpMediaType) {
        super.setMediaType(httpMediaType);
        return this;
    }

    public final Collection<Part> getParts() {
        return Collections.unmodifiableCollection(this.f4407a);
    }

    public MultipartContent addPart(Part part) {
        this.f4407a.add(Preconditions.m4968a((Object) part));
        return this;
    }

    public MultipartContent setParts(Collection<Part> collection) {
        this.f4407a = new ArrayList(collection);
        return this;
    }

    public MultipartContent setContentParts(Collection<? extends HttpContent> collection) {
        this.f4407a = new ArrayList(collection.size());
        for (HttpContent part : collection) {
            addPart(new Part(part));
        }
        return this;
    }

    public final String getBoundary() {
        return getMediaType().getParameter("boundary");
    }

    public MultipartContent setBoundary(String str) {
        getMediaType().setParameter("boundary", (String) Preconditions.m4968a((Object) str));
        return this;
    }
}
