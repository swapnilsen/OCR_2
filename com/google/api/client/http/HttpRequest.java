package com.google.api.client.http;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.api.client.p082b.ObjectParser;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ac;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public final class HttpRequest {
    public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
    public static final String USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/1.22.0 (gzip)";
    public static final String VERSION = "1.22.0";
    private HttpExecuteInterceptor f4357a;
    private HttpHeaders f4358b;
    private HttpHeaders f4359c;
    private int f4360d;
    private int f4361e;
    private boolean f4362f;
    private boolean f4363g;
    private HttpContent f4364h;
    private final HttpTransport f4365i;
    private String f4366j;
    private GenericUrl f4367k;
    private int f4368l;
    private int f4369m;
    private HttpUnsuccessfulResponseHandler f4370n;
    private HttpIOExceptionHandler f4371o;
    private HttpResponseInterceptor f4372p;
    private ObjectParser f4373q;
    private HttpEncoding f4374r;
    @Deprecated
    private BackOffPolicy f4375s;
    private boolean f4376t;
    private boolean f4377u;
    @Deprecated
    private boolean f4378v;
    private boolean f4379w;
    private ac f4380x;

    /* renamed from: com.google.api.client.http.HttpRequest.1 */
    class C14791 implements Callable<HttpResponse> {
        final /* synthetic */ HttpRequest f4356a;

        C14791(HttpRequest httpRequest) {
            this.f4356a = httpRequest;
        }

        public /* synthetic */ Object call() {
            return m5022a();
        }

        public HttpResponse m5022a() {
            return this.f4356a.execute();
        }
    }

    HttpRequest(HttpTransport httpTransport, String str) {
        this.f4358b = new HttpHeaders();
        this.f4359c = new HttpHeaders();
        this.f4360d = DEFAULT_NUMBER_OF_RETRIES;
        this.f4361e = AccessibilityNodeInfoCompat.ACTION_COPY;
        this.f4362f = true;
        this.f4363g = true;
        this.f4368l = 20000;
        this.f4369m = 20000;
        this.f4376t = true;
        this.f4377u = true;
        this.f4378v = false;
        this.f4380x = ac.f4123a;
        this.f4365i = httpTransport;
        setRequestMethod(str);
    }

    public HttpTransport getTransport() {
        return this.f4365i;
    }

    public String getRequestMethod() {
        return this.f4366j;
    }

    public HttpRequest setRequestMethod(String str) {
        boolean z = str == null || HttpMediaType.m5019a(str);
        Preconditions.m4971a(z);
        this.f4366j = str;
        return this;
    }

    public GenericUrl getUrl() {
        return this.f4367k;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.f4367k = (GenericUrl) Preconditions.m4968a((Object) genericUrl);
        return this;
    }

    public HttpContent getContent() {
        return this.f4364h;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.f4364h = httpContent;
        return this;
    }

    public HttpEncoding getEncoding() {
        return this.f4374r;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.f4374r = httpEncoding;
        return this;
    }

    @Deprecated
    public BackOffPolicy getBackOffPolicy() {
        return this.f4375s;
    }

    @Deprecated
    public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy) {
        this.f4375s = backOffPolicy;
        return this;
    }

    public int getContentLoggingLimit() {
        return this.f4361e;
    }

    public HttpRequest setContentLoggingLimit(int i) {
        Preconditions.m4972a(i >= 0, (Object) "The content logging limit must be non-negative.");
        this.f4361e = i;
        return this;
    }

    public boolean isLoggingEnabled() {
        return this.f4362f;
    }

    public HttpRequest setLoggingEnabled(boolean z) {
        this.f4362f = z;
        return this;
    }

    public boolean isCurlLoggingEnabled() {
        return this.f4363g;
    }

    public HttpRequest setCurlLoggingEnabled(boolean z) {
        this.f4363g = z;
        return this;
    }

    public int getConnectTimeout() {
        return this.f4368l;
    }

    public HttpRequest setConnectTimeout(int i) {
        Preconditions.m4971a(i >= 0);
        this.f4368l = i;
        return this;
    }

    public int getReadTimeout() {
        return this.f4369m;
    }

    public HttpRequest setReadTimeout(int i) {
        Preconditions.m4971a(i >= 0);
        this.f4369m = i;
        return this;
    }

    public HttpHeaders getHeaders() {
        return this.f4358b;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.f4358b = (HttpHeaders) Preconditions.m4968a((Object) httpHeaders);
        return this;
    }

    public HttpHeaders getResponseHeaders() {
        return this.f4359c;
    }

    public HttpRequest setResponseHeaders(HttpHeaders httpHeaders) {
        this.f4359c = (HttpHeaders) Preconditions.m4968a((Object) httpHeaders);
        return this;
    }

    public HttpExecuteInterceptor getInterceptor() {
        return this.f4357a;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.f4357a = httpExecuteInterceptor;
        return this;
    }

    public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
        return this.f4370n;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.f4370n = httpUnsuccessfulResponseHandler;
        return this;
    }

    public HttpIOExceptionHandler getIOExceptionHandler() {
        return this.f4371o;
    }

    public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.f4371o = httpIOExceptionHandler;
        return this;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.f4372p;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.f4372p = httpResponseInterceptor;
        return this;
    }

    public int getNumberOfRetries() {
        return this.f4360d;
    }

    public HttpRequest setNumberOfRetries(int i) {
        Preconditions.m4971a(i >= 0);
        this.f4360d = i;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser) {
        this.f4373q = objectParser;
        return this;
    }

    public final ObjectParser getParser() {
        return this.f4373q;
    }

    public boolean getFollowRedirects() {
        return this.f4376t;
    }

    public HttpRequest setFollowRedirects(boolean z) {
        this.f4376t = z;
        return this;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.f4377u;
    }

    public HttpRequest setThrowExceptionOnExecuteError(boolean z) {
        this.f4377u = z;
        return this;
    }

    @Deprecated
    public boolean getRetryOnExecuteIOException() {
        return this.f4378v;
    }

    @Deprecated
    public HttpRequest setRetryOnExecuteIOException(boolean z) {
        this.f4378v = z;
        return this;
    }

    public boolean getSuppressUserAgentSuffix() {
        return this.f4379w;
    }

    public HttpRequest setSuppressUserAgentSuffix(boolean z) {
        this.f4379w = z;
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.api.client.http.HttpResponse execute() {
        /*
        r22 = this;
        r0 = r22;
        r2 = r0.f4360d;
        if (r2 < 0) goto L_0x0275;
    L_0x0006:
        r2 = 1;
    L_0x0007:
        com.google.api.client.p082b.Preconditions.m4971a(r2);
        r0 = r22;
        r2 = r0.f4360d;
        r0 = r22;
        r3 = r0.f4375s;
        if (r3 == 0) goto L_0x001b;
    L_0x0014:
        r0 = r22;
        r3 = r0.f4375s;
        r3.reset();
    L_0x001b:
        r4 = 0;
        r0 = r22;
        r3 = r0.f4366j;
        com.google.api.client.p082b.Preconditions.m4968a(r3);
        r0 = r22;
        r3 = r0.f4367k;
        com.google.api.client.p082b.Preconditions.m4968a(r3);
        r8 = r2;
    L_0x002b:
        if (r4 == 0) goto L_0x0030;
    L_0x002d:
        r4.ignore();
    L_0x0030:
        r7 = 0;
        r6 = 0;
        r0 = r22;
        r2 = r0.f4357a;
        if (r2 == 0) goto L_0x0041;
    L_0x0038:
        r0 = r22;
        r2 = r0.f4357a;
        r0 = r22;
        r2.intercept(r0);
    L_0x0041:
        r0 = r22;
        r2 = r0.f4367k;
        r14 = r2.build();
        r0 = r22;
        r2 = r0.f4365i;
        r0 = r22;
        r3 = r0.f4366j;
        r15 = r2.m5025a(r3, r14);
        r16 = com.google.api.client.http.HttpTransport.f4399a;
        r0 = r22;
        r2 = r0.f4362f;
        if (r2 == 0) goto L_0x0278;
    L_0x005d:
        r2 = java.util.logging.Level.CONFIG;
        r0 = r16;
        r2 = r0.isLoggable(r2);
        if (r2 == 0) goto L_0x0278;
    L_0x0067:
        r2 = 1;
        r13 = r2;
    L_0x0069:
        r3 = 0;
        r2 = 0;
        if (r13 == 0) goto L_0x00ba;
    L_0x006d:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "-------------- REQUEST  --------------";
        r4 = r3.append(r4);
        r5 = com.google.api.client.p082b.af.f4124a;
        r4.append(r5);
        r0 = r22;
        r4 = r0.f4366j;
        r4 = r3.append(r4);
        r5 = 32;
        r4 = r4.append(r5);
        r4 = r4.append(r14);
        r5 = com.google.api.client.p082b.af.f4124a;
        r4.append(r5);
        r0 = r22;
        r4 = r0.f4363g;
        if (r4 == 0) goto L_0x00ba;
    L_0x009a:
        r2 = new java.lang.StringBuilder;
        r4 = "curl -v --compressed";
        r2.<init>(r4);
        r0 = r22;
        r4 = r0.f4366j;
        r5 = "GET";
        r4 = r4.equals(r5);
        if (r4 != 0) goto L_0x00ba;
    L_0x00ad:
        r4 = " -X ";
        r4 = r2.append(r4);
        r0 = r22;
        r5 = r0.f4366j;
        r4.append(r5);
    L_0x00ba:
        r0 = r22;
        r4 = r0.f4358b;
        r4 = r4.getUserAgent();
        r0 = r22;
        r5 = r0.f4379w;
        if (r5 != 0) goto L_0x00d3;
    L_0x00c8:
        if (r4 != 0) goto L_0x027c;
    L_0x00ca:
        r0 = r22;
        r5 = r0.f4358b;
        r9 = "Google-HTTP-Java-Client/1.22.0 (gzip)";
        r5.setUserAgent(r9);
    L_0x00d3:
        r0 = r22;
        r5 = r0.f4358b;
        r0 = r16;
        com.google.api.client.http.HttpHeaders.m5014a(r5, r3, r2, r0, r15);
        r0 = r22;
        r5 = r0.f4379w;
        if (r5 != 0) goto L_0x00e9;
    L_0x00e2:
        r0 = r22;
        r5 = r0.f4358b;
        r5.setUserAgent(r4);
    L_0x00e9:
        r0 = r22;
        r5 = r0.f4364h;
        if (r5 == 0) goto L_0x00f9;
    L_0x00ef:
        r0 = r22;
        r4 = r0.f4364h;
        r4 = r4.retrySupported();
        if (r4 == 0) goto L_0x029e;
    L_0x00f9:
        r4 = 1;
        r12 = r4;
    L_0x00fb:
        if (r5 == 0) goto L_0x01eb;
    L_0x00fd:
        r0 = r22;
        r4 = r0.f4364h;
        r17 = r4.getType();
        if (r13 == 0) goto L_0x035f;
    L_0x0107:
        r4 = new com.google.api.client.b.u;
        r9 = com.google.api.client.http.HttpTransport.f4399a;
        r10 = java.util.logging.Level.CONFIG;
        r0 = r22;
        r11 = r0.f4361e;
        r4.<init>(r5, r9, r10, r11);
    L_0x0114:
        r0 = r22;
        r5 = r0.f4374r;
        if (r5 != 0) goto L_0x02a2;
    L_0x011a:
        r5 = 0;
        r0 = r22;
        r9 = r0.f4364h;
        r10 = r9.getLength();
        r20 = r5;
        r5 = r4;
        r4 = r20;
    L_0x0128:
        if (r13 == 0) goto L_0x01d6;
    L_0x012a:
        if (r17 == 0) goto L_0x016e;
    L_0x012c:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r18 = "Content-Type: ";
        r0 = r18;
        r9 = r9.append(r0);
        r0 = r17;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r18 = r3.append(r9);
        r19 = com.google.api.client.p082b.af.f4124a;
        r18.append(r19);
        if (r2 == 0) goto L_0x016e;
    L_0x014e:
        r18 = new java.lang.StringBuilder;
        r18.<init>();
        r19 = " -H '";
        r18 = r18.append(r19);
        r0 = r18;
        r9 = r0.append(r9);
        r18 = "'";
        r0 = r18;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r2.append(r9);
    L_0x016e:
        if (r4 == 0) goto L_0x01b0;
    L_0x0170:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r18 = "Content-Encoding: ";
        r0 = r18;
        r9 = r9.append(r0);
        r9 = r9.append(r4);
        r9 = r9.toString();
        r18 = r3.append(r9);
        r19 = com.google.api.client.p082b.af.f4124a;
        r18.append(r19);
        if (r2 == 0) goto L_0x01b0;
    L_0x0190:
        r18 = new java.lang.StringBuilder;
        r18.<init>();
        r19 = " -H '";
        r18 = r18.append(r19);
        r0 = r18;
        r9 = r0.append(r9);
        r18 = "'";
        r0 = r18;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r2.append(r9);
    L_0x01b0:
        r18 = 0;
        r9 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1));
        if (r9 < 0) goto L_0x01d6;
    L_0x01b6:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r18 = "Content-Length: ";
        r0 = r18;
        r9 = r9.append(r0);
        r9 = r9.append(r10);
        r9 = r9.toString();
        r9 = r3.append(r9);
        r18 = com.google.api.client.p082b.af.f4124a;
        r0 = r18;
        r9.append(r0);
    L_0x01d6:
        if (r2 == 0) goto L_0x01dd;
    L_0x01d8:
        r9 = " -d '@-'";
        r2.append(r9);
    L_0x01dd:
        r0 = r17;
        r15.setContentType(r0);
        r15.setContentEncoding(r4);
        r15.setContentLength(r10);
        r15.setStreamingContent(r5);
    L_0x01eb:
        if (r13 == 0) goto L_0x021d;
    L_0x01ed:
        r3 = r3.toString();
        r0 = r16;
        r0.config(r3);
        if (r2 == 0) goto L_0x021d;
    L_0x01f8:
        r3 = " -- '";
        r2.append(r3);
        r3 = "'";
        r4 = "'\"'\"'";
        r3 = r14.replaceAll(r3, r4);
        r2.append(r3);
        r3 = "'";
        r2.append(r3);
        if (r5 == 0) goto L_0x0214;
    L_0x020f:
        r3 = " << $$$";
        r2.append(r3);
    L_0x0214:
        r2 = r2.toString();
        r0 = r16;
        r0.config(r2);
    L_0x021d:
        if (r12 == 0) goto L_0x02c4;
    L_0x021f:
        if (r8 <= 0) goto L_0x02c4;
    L_0x0221:
        r2 = 1;
    L_0x0222:
        r0 = r22;
        r3 = r0.f4368l;
        r0 = r22;
        r4 = r0.f4369m;
        r15.setTimeout(r3, r4);
        r4 = r15.execute();	 Catch:{ IOException -> 0x02d2 }
        r3 = new com.google.api.client.http.HttpResponse;	 Catch:{ all -> 0x02c7 }
        r0 = r22;
        r3.<init>(r0, r4);	 Catch:{ all -> 0x02c7 }
        r4 = r3;
        r3 = r6;
    L_0x023a:
        if (r4 == 0) goto L_0x0326;
    L_0x023c:
        r5 = r4.isSuccessStatusCode();	 Catch:{ all -> 0x032e }
        if (r5 != 0) goto L_0x0326;
    L_0x0242:
        r5 = 0;
        r0 = r22;
        r6 = r0.f4370n;	 Catch:{ all -> 0x032e }
        if (r6 == 0) goto L_0x0253;
    L_0x0249:
        r0 = r22;
        r5 = r0.f4370n;	 Catch:{ all -> 0x032e }
        r0 = r22;
        r5 = r5.handleResponse(r0, r4, r2);	 Catch:{ all -> 0x032e }
    L_0x0253:
        if (r5 != 0) goto L_0x0266;
    L_0x0255:
        r6 = r4.getStatusCode();	 Catch:{ all -> 0x032e }
        r7 = r4.getHeaders();	 Catch:{ all -> 0x032e }
        r0 = r22;
        r6 = r0.handleRedirect(r6, r7);	 Catch:{ all -> 0x032e }
        if (r6 == 0) goto L_0x02f8;
    L_0x0265:
        r5 = 1;
    L_0x0266:
        r2 = r2 & r5;
        if (r2 == 0) goto L_0x026c;
    L_0x0269:
        r4.ignore();	 Catch:{ all -> 0x032e }
    L_0x026c:
        r5 = r8 + -1;
        if (r4 == 0) goto L_0x0270;
    L_0x0270:
        if (r2 != 0) goto L_0x035c;
    L_0x0272:
        if (r4 != 0) goto L_0x0335;
    L_0x0274:
        throw r3;
    L_0x0275:
        r2 = 0;
        goto L_0x0007;
    L_0x0278:
        r2 = 0;
        r13 = r2;
        goto L_0x0069;
    L_0x027c:
        r0 = r22;
        r5 = r0.f4358b;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r9 = r9.append(r4);
        r10 = " ";
        r9 = r9.append(r10);
        r10 = "Google-HTTP-Java-Client/1.22.0 (gzip)";
        r9 = r9.append(r10);
        r9 = r9.toString();
        r5.setUserAgent(r9);
        goto L_0x00d3;
    L_0x029e:
        r4 = 0;
        r12 = r4;
        goto L_0x00fb;
    L_0x02a2:
        r0 = r22;
        r5 = r0.f4374r;
        r9 = r5.getName();
        r10 = new com.google.api.client.http.HttpEncodingStreamingContent;
        r0 = r22;
        r5 = r0.f4374r;
        r10.<init>(r4, r5);
        if (r12 == 0) goto L_0x02c1;
    L_0x02b5:
        r4 = com.google.api.client.p082b.IOUtils.m4955a(r10);
    L_0x02b9:
        r20 = r4;
        r4 = r9;
        r5 = r10;
        r10 = r20;
        goto L_0x0128;
    L_0x02c1:
        r4 = -1;
        goto L_0x02b9;
    L_0x02c4:
        r2 = 0;
        goto L_0x0222;
    L_0x02c7:
        r3 = move-exception;
        r4 = r4.getContent();	 Catch:{ IOException -> 0x02d2 }
        if (r4 == 0) goto L_0x02d1;
    L_0x02ce:
        r4.close();	 Catch:{ IOException -> 0x02d2 }
    L_0x02d1:
        throw r3;	 Catch:{ IOException -> 0x02d2 }
    L_0x02d2:
        r3 = move-exception;
        r4 = r7;
        r0 = r22;
        r5 = r0.f4378v;
        if (r5 != 0) goto L_0x02ed;
    L_0x02da:
        r0 = r22;
        r5 = r0.f4371o;
        if (r5 == 0) goto L_0x02ec;
    L_0x02e0:
        r0 = r22;
        r5 = r0.f4371o;
        r0 = r22;
        r5 = r5.handleIOException(r0, r2);
        if (r5 != 0) goto L_0x02ed;
    L_0x02ec:
        throw r3;
    L_0x02ed:
        r5 = java.util.logging.Level.WARNING;
        r6 = "exception thrown while executing request";
        r0 = r16;
        r0.log(r5, r6, r3);
        goto L_0x023a;
    L_0x02f8:
        if (r2 == 0) goto L_0x0266;
    L_0x02fa:
        r0 = r22;
        r6 = r0.f4375s;	 Catch:{ all -> 0x032e }
        if (r6 == 0) goto L_0x0266;
    L_0x0300:
        r0 = r22;
        r6 = r0.f4375s;	 Catch:{ all -> 0x032e }
        r7 = r4.getStatusCode();	 Catch:{ all -> 0x032e }
        r6 = r6.isBackOffRequired(r7);	 Catch:{ all -> 0x032e }
        if (r6 == 0) goto L_0x0266;
    L_0x030e:
        r0 = r22;
        r6 = r0.f4375s;	 Catch:{ all -> 0x032e }
        r6 = r6.getNextBackOffMillis();	 Catch:{ all -> 0x032e }
        r10 = -1;
        r9 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r9 == 0) goto L_0x0266;
    L_0x031c:
        r0 = r22;
        r5 = r0.f4380x;	 Catch:{ InterruptedException -> 0x035a }
        r5.m4850a(r6);	 Catch:{ InterruptedException -> 0x035a }
    L_0x0323:
        r5 = 1;
        goto L_0x0266;
    L_0x0326:
        if (r4 != 0) goto L_0x032c;
    L_0x0328:
        r5 = 1;
    L_0x0329:
        r2 = r2 & r5;
        goto L_0x026c;
    L_0x032c:
        r5 = 0;
        goto L_0x0329;
    L_0x032e:
        r2 = move-exception;
        if (r4 == 0) goto L_0x0334;
    L_0x0331:
        r4.disconnect();
    L_0x0334:
        throw r2;
    L_0x0335:
        r0 = r22;
        r2 = r0.f4372p;
        if (r2 == 0) goto L_0x0342;
    L_0x033b:
        r0 = r22;
        r2 = r0.f4372p;
        r2.interceptResponse(r4);
    L_0x0342:
        r0 = r22;
        r2 = r0.f4377u;
        if (r2 == 0) goto L_0x0359;
    L_0x0348:
        r2 = r4.isSuccessStatusCode();
        if (r2 != 0) goto L_0x0359;
    L_0x034e:
        r2 = new com.google.api.client.http.HttpResponseException;	 Catch:{ all -> 0x0354 }
        r2.<init>(r4);	 Catch:{ all -> 0x0354 }
        throw r2;	 Catch:{ all -> 0x0354 }
    L_0x0354:
        r2 = move-exception;
        r4.disconnect();
        throw r2;
    L_0x0359:
        return r4;
    L_0x035a:
        r5 = move-exception;
        goto L_0x0323;
    L_0x035c:
        r8 = r5;
        goto L_0x002b;
    L_0x035f:
        r4 = r5;
        goto L_0x0114;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.http.HttpRequest.execute():com.google.api.client.http.HttpResponse");
    }

    public Future<HttpResponse> executeAsync(Executor executor) {
        Object futureTask = new FutureTask(new C14791(this));
        executor.execute(futureTask);
        return futureTask;
    }

    public Future<HttpResponse> executeAsync() {
        return executeAsync(Executors.newSingleThreadExecutor());
    }

    public boolean handleRedirect(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!getFollowRedirects() || !HttpStatusCodes.isRedirect(i) || location == null) {
            return false;
        }
        setUrl(new GenericUrl(this.f4367k.toURL(location)));
        if (i == HttpStatusCodes.STATUS_CODE_SEE_OTHER) {
            setRequestMethod(HttpMethods.GET);
            setContent(null);
        }
        this.f4358b.setAuthorization((String) null);
        this.f4358b.setIfMatch((String) null);
        this.f4358b.setIfNoneMatch((String) null);
        this.f4358b.setIfModifiedSince((String) null);
        this.f4358b.setIfUnmodifiedSince((String) null);
        this.f4358b.setIfRange((String) null);
        return true;
    }

    public ac getSleeper() {
        return this.f4380x;
    }

    public HttpRequest setSleeper(ac acVar) {
        this.f4380x = (ac) Preconditions.m4968a((Object) acVar);
        return this;
    }
}
