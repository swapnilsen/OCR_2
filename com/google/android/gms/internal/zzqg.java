package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.internal.zzqe.zza;
import com.google.api.client.http.HttpStatusCodes;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzme
public class zzqg implements zza {
    @Nullable
    private final String zzIA;

    public zzqg() {
        this(null);
    }

    public zzqg(@Nullable String str) {
        this.zzIA = str;
    }

    @WorkerThread
    public void zzu(String str) {
        String valueOf;
        HttpURLConnection httpURLConnection;
        try {
            String str2 = "Pinging URL: ";
            valueOf = String.valueOf(str);
            zzqf.zzbf(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            zzel.zzeT().zza(true, httpURLConnection, this.zzIA);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < HttpStatusCodes.STATUS_CODE_OK || responseCode >= HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES) {
                zzqf.zzbh(new StringBuilder(String.valueOf(str).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(str).toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            valueOf = String.valueOf(e.getMessage());
            zzqf.zzbh(new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("Error while parsing ping URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (IOException e2) {
            valueOf = String.valueOf(e2.getMessage());
            zzqf.zzbh(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (RuntimeException e3) {
            valueOf = String.valueOf(e3.getMessage());
            zzqf.zzbh(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
