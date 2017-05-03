package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzbo;
import com.google.api.client.http.HttpStatusCodes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class zzbjh implements zzbji {
    private HttpURLConnection zzbMp;
    private InputStream zzbMq;

    zzbjh() {
        this.zzbMq = null;
    }

    private InputStream zzd(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpStatusCodes.STATUS_CODE_OK) {
            return httpURLConnection.getInputStream();
        }
        String str = "Bad response: " + responseCode;
        if (responseCode == HttpStatusCodes.STATUS_CODE_NOT_FOUND) {
            throw new FileNotFoundException(str);
        } else if (responseCode == HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE) {
            throw new zzbjk(str);
        } else {
            throw new IOException(str);
        }
    }

    private void zze(HttpURLConnection httpURLConnection) {
        try {
            if (this.zzbMq != null) {
                this.zzbMq.close();
            }
        } catch (Throwable e) {
            Throwable th = e;
            String str = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ";
            String valueOf = String.valueOf(th.getMessage());
            zzbo.zzb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void close() {
        zze(this.zzbMp);
    }

    public InputStream zzhX(String str) {
        this.zzbMp = zzhY(str);
        this.zzbMq = zzd(this.zzbMp);
        return this.zzbMq;
    }

    HttpURLConnection zzhY(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        return httpURLConnection;
    }
}
