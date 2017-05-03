package com.crashlytics.android.beta;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpMethod;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequest;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;

class CheckForUpdatesRequest extends AbstractSpiCall {
    static final String BETA_SOURCE = "3";
    static final String BUILD_VERSION = "build_version";
    static final String DISPLAY_VERSION = "display_version";
    static final String HEADER_BETA_TOKEN = "X-CRASHLYTICS-BETA-TOKEN";
    static final String INSTANCE = "instance";
    static final String SDK_ANDROID_DIR_TOKEN_TYPE = "3";
    static final String SOURCE = "source";
    private final CheckForUpdatesResponseTransform responseTransform;

    static String createBetaTokenHeaderValueFor(String str) {
        return "3:" + str;
    }

    public CheckForUpdatesRequest(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, CheckForUpdatesResponseTransform checkForUpdatesResponseTransform) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.GET);
        this.responseTransform = checkForUpdatesResponseTransform;
    }

    public CheckForUpdatesResponse invoke(String str, String str2, BuildProperties buildProperties) {
        HttpRequest applyHeadersTo;
        Throwable e;
        Throwable th;
        CheckForUpdatesResponse checkForUpdatesResponse = null;
        try {
            Map queryParamsFor = getQueryParamsFor(buildProperties);
            try {
                applyHeadersTo = applyHeadersTo(getHttpRequest(queryParamsFor), str, str2);
                Fabric.m397h().m359a(Beta.TAG, "Checking for updates from " + getUrl());
                Fabric.m397h().m359a(Beta.TAG, "Checking for updates query params are: " + queryParamsFor);
                if (applyHeadersTo.m269c()) {
                    Fabric.m397h().m359a(Beta.TAG, "Checking for updates was successful");
                    checkForUpdatesResponse = this.responseTransform.fromJson(new JSONObject(applyHeadersTo.m274e()));
                    if (applyHeadersTo != null) {
                        Fabric.m397h().m359a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m265b(AbstractSpiCall.HEADER_REQUEST_ID));
                    }
                } else {
                    Fabric.m397h().m366e(Beta.TAG, "Checking for updates failed. Response code: " + applyHeadersTo.m263b());
                    if (applyHeadersTo != null) {
                        Fabric.m397h().m359a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m265b(AbstractSpiCall.HEADER_REQUEST_ID));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    Fabric.m397h().m367e(Beta.TAG, "Error while checking for updates from " + getUrl(), e);
                    if (applyHeadersTo != null) {
                        Fabric.m397h().m359a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m265b(AbstractSpiCall.HEADER_REQUEST_ID));
                    }
                    return checkForUpdatesResponse;
                } catch (Throwable th2) {
                    th = th2;
                    if (applyHeadersTo != null) {
                        Fabric.m397h().m359a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m265b(AbstractSpiCall.HEADER_REQUEST_ID));
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            applyHeadersTo = null;
            Fabric.m397h().m367e(Beta.TAG, "Error while checking for updates from " + getUrl(), e);
            if (applyHeadersTo != null) {
                Fabric.m397h().m359a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m265b(AbstractSpiCall.HEADER_REQUEST_ID));
            }
            return checkForUpdatesResponse;
        } catch (Throwable e4) {
            applyHeadersTo = null;
            th = e4;
            if (applyHeadersTo != null) {
                Fabric.m397h().m359a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m265b(AbstractSpiCall.HEADER_REQUEST_ID));
            }
            throw th;
        }
        return checkForUpdatesResponse;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, String str, String str2) {
        return httpRequest.m253a(AbstractSpiCall.HEADER_ACCEPT, AbstractSpiCall.ACCEPT_JSON_VALUE).m253a(AbstractSpiCall.HEADER_USER_AGENT, AbstractSpiCall.CRASHLYTICS_USER_AGENT + this.kit.getVersion()).m253a(AbstractSpiCall.HEADER_DEVELOPER_TOKEN, AbstractSpiCall.CLS_ANDROID_SDK_DEVELOPER_TOKEN).m253a(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).m253a(AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion()).m253a(AbstractSpiCall.HEADER_API_KEY, str).m253a(HEADER_BETA_TOKEN, createBetaTokenHeaderValueFor(str2));
    }

    private Map<String, String> getQueryParamsFor(BuildProperties buildProperties) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(BUILD_VERSION, buildProperties.versionCode);
        hashMap.put(DISPLAY_VERSION, buildProperties.versionName);
        hashMap.put(INSTANCE, buildProperties.buildId);
        hashMap.put(SOURCE, SDK_ANDROID_DIR_TOKEN_TYPE);
        return hashMap;
    }
}
