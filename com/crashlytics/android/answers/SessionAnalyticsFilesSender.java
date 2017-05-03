package com.crashlytics.android.answers;

import java.io.File;
import java.util.List;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;
import p000a.p001a.p002a.p003a.p004a.p006b.ResponseParser;
import p000a.p001a.p002a.p003a.p004a.p009d.FilesSender;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpMethod;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequest;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;

class SessionAnalyticsFilesSender extends AbstractSpiCall implements FilesSender {
    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
        this.apiKey = str3;
    }

    public boolean send(List<File> list) {
        HttpRequest a = getHttpRequest().m253a(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).m253a(AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion()).m253a(AbstractSpiCall.HEADER_API_KEY, this.apiKey);
        int i = 0;
        for (File file : list) {
            a.m256a(FILE_PARAM_NAME + i, file.getName(), FILE_CONTENT_TYPE, file);
            i++;
        }
        Fabric.m397h().m359a(Answers.TAG, "Sending " + list.size() + " analytics files to " + getUrl());
        int b = a.m263b();
        Fabric.m397h().m359a(Answers.TAG, "Response code for analytics file send is " + b);
        if (ResponseParser.m139a(b) == 0) {
            return true;
        }
        return false;
    }
}
