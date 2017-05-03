package com.crashlytics.android.core;

import java.io.File;
import java.util.Map.Entry;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;
import p000a.p001a.p002a.p003a.p004a.p006b.ResponseParser;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpMethod;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequest;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;

class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";
    static final String MULTI_FILE_PARAM = "report[file";

    public DefaultCreateReportSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
    }

    DefaultCreateReportSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        HttpRequest applyMultipartDataTo = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createReportRequest), createReportRequest.report);
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Sending report to: " + getUrl());
        int b = applyMultipartDataTo.m263b();
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Create report request ID: " + applyMultipartDataTo.m265b(AbstractSpiCall.HEADER_REQUEST_ID));
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Result was: " + b);
        return ResponseParser.m139a(b) == 0;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        HttpRequest a = httpRequest.m253a(AbstractSpiCall.HEADER_API_KEY, createReportRequest.apiKey).m253a(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).m253a(AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion());
        HttpRequest httpRequest2 = a;
        for (Entry a2 : createReportRequest.report.getCustomHeaders().entrySet()) {
            httpRequest2 = httpRequest2.m259a(a2);
        }
        return httpRequest2;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        int i = 0;
        httpRequest.m273e(IDENTIFIER_PARAM, report.getIdentifier());
        if (report.getFiles().length == 1) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Adding single file " + report.getFileName() + " to report " + report.getIdentifier());
            return httpRequest.m256a(FILE_PARAM, report.getFileName(), FILE_CONTENT_TYPE, report.getFile());
        }
        File[] files = report.getFiles();
        int length = files.length;
        int i2 = 0;
        while (i < length) {
            File file = files[i];
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Adding file " + file.getName() + " to report " + report.getIdentifier());
            httpRequest.m256a(MULTI_FILE_PARAM + i2 + "]", file.getName(), FILE_CONTENT_TYPE, file);
            i2++;
            i++;
        }
        return httpRequest;
    }
}
