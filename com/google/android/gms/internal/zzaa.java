package com.google.android.gms.internal;

import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpStatusCodes;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class zzaa implements zzz {
    private final zza zzaE;
    private final SSLSocketFactory zzaF;

    public interface zza {
        String zzh(String str);
    }

    public zzaa() {
        this(null);
    }

    public zzaa(zza com_google_android_gms_internal_zzaa_zza) {
        this(com_google_android_gms_internal_zzaa_zza, null);
    }

    public zzaa(zza com_google_android_gms_internal_zzaa_zza, SSLSocketFactory sSLSocketFactory) {
        this.zzaE = com_google_android_gms_internal_zzaa_zza;
        this.zzaF = sSLSocketFactory;
    }

    private HttpURLConnection zza(URL url, zzl<?> com_google_android_gms_internal_zzl_) {
        HttpURLConnection zza = zza(url);
        int zzp = com_google_android_gms_internal_zzl_.zzp();
        zza.setConnectTimeout(zzp);
        zza.setReadTimeout(zzp);
        zza.setUseCaches(false);
        zza.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.zzaF != null) {
            ((HttpsURLConnection) zza).setSSLSocketFactory(this.zzaF);
        }
        return zza;
    }

    private static HttpEntity zza(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void zza(HttpURLConnection httpURLConnection, zzl<?> com_google_android_gms_internal_zzl_) {
        switch (com_google_android_gms_internal_zzl_.getMethod()) {
            case FirebaseRemoteConfig.LAST_FETCH_STATUS_SUCCESS /*-1*/:
                byte[] zzj = com_google_android_gms_internal_zzl_.zzj();
                if (zzj != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod(HttpMethods.POST);
                    httpURLConnection.addRequestProperty("Content-Type", com_google_android_gms_internal_zzl_.zzi());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(zzj);
                    dataOutputStream.close();
                }
            case NendAdIconLayout.HORIZONTAL /*0*/:
                httpURLConnection.setRequestMethod(HttpMethods.GET);
            case NendIconError.ERROR_ICONVIEW /*1*/:
                httpURLConnection.setRequestMethod(HttpMethods.POST);
                zzb(httpURLConnection, com_google_android_gms_internal_zzl_);
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                httpURLConnection.setRequestMethod(HttpMethods.PUT);
                zzb(httpURLConnection, com_google_android_gms_internal_zzl_);
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                httpURLConnection.setRequestMethod(HttpMethods.DELETE);
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                httpURLConnection.setRequestMethod(HttpMethods.HEAD);
            case Type.OTHER_PROFILE /*5*/:
                httpURLConnection.setRequestMethod(HttpMethods.OPTIONS);
            case Type.CONTRIBUTOR /*6*/:
                httpURLConnection.setRequestMethod(HttpMethods.TRACE);
            case Type.WEBSITE /*7*/:
                httpURLConnection.setRequestMethod(HttpMethods.PATCH);
                zzb(httpURLConnection, com_google_android_gms_internal_zzl_);
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static boolean zza(int i, int i2) {
        return (i == 4 || ((100 <= i2 && i2 < HttpStatusCodes.STATUS_CODE_OK) || i2 == HttpStatusCodes.STATUS_CODE_NO_CONTENT || i2 == HttpStatusCodes.STATUS_CODE_NOT_MODIFIED)) ? false : true;
    }

    private static void zzb(HttpURLConnection httpURLConnection, zzl<?> com_google_android_gms_internal_zzl_) {
        byte[] zzm = com_google_android_gms_internal_zzl_.zzm();
        if (zzm != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", com_google_android_gms_internal_zzl_.zzl());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzm);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection zza(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public HttpResponse zza(zzl<?> com_google_android_gms_internal_zzl_, Map<String, String> map) {
        String zzh;
        String url = com_google_android_gms_internal_zzl_.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(com_google_android_gms_internal_zzl_.getHeaders());
        hashMap.putAll(map);
        if (this.zzaE != null) {
            zzh = this.zzaE.zzh(url);
            if (zzh == null) {
                throw new IOException("URL blocked by rewriter: " + url);
            }
        }
        zzh = url;
        HttpURLConnection zza = zza(new URL(zzh), (zzl) com_google_android_gms_internal_zzl_);
        for (String zzh2 : hashMap.keySet()) {
            zza.addRequestProperty(zzh2, (String) hashMap.get(zzh2));
        }
        zza(zza, (zzl) com_google_android_gms_internal_zzl_);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (zza.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        StatusLine basicStatusLine = new BasicStatusLine(protocolVersion, zza.getResponseCode(), zza.getResponseMessage());
        HttpResponse basicHttpResponse = new BasicHttpResponse(basicStatusLine);
        if (zza(com_google_android_gms_internal_zzl_.getMethod(), basicStatusLine.getStatusCode())) {
            basicHttpResponse.setEntity(zza(zza));
        }
        for (Entry entry : zza.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
