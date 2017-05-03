package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzw;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

@zzme
@TargetApi(11)
public class zzrg extends zzqx {
    public zzrg(zzqw com_google_android_gms_internal_zzqw, boolean z) {
        super(com_google_android_gms_internal_zzqw, z);
    }

    protected WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        Exception e;
        String valueOf;
        if (webView instanceof zzqw) {
            zzqw com_google_android_gms_internal_zzqw = (zzqw) webView;
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (com_google_android_gms_internal_zzqw.zzlv() != null) {
                com_google_android_gms_internal_zzqw.zzlv().zzhG();
            }
            String str2 = com_google_android_gms_internal_zzqw.zzbC().zzzz ? (String) zzgd.zzBY.get() : com_google_android_gms_internal_zzqw.zzlz() ? (String) zzgd.zzBX.get() : (String) zzgd.zzBW.get();
            try {
                return zzn(com_google_android_gms_internal_zzqw.getContext(), com_google_android_gms_internal_zzqw.zzly().zzba, str2);
            } catch (IOException e2) {
                e = e2;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                zzqf.zzbh(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (ExecutionException e3) {
                e = e3;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                zzqf.zzbh(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (InterruptedException e4) {
                e = e4;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                zzqf.zzbh(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (TimeoutException e5) {
                e = e5;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                zzqf.zzbh(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            }
        }
        zzqf.zzbh("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return null;
    }

    protected WebResourceResponse zzn(Context context, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put(AbstractSpiCall.HEADER_USER_AGENT, zzw.zzcM().zzu(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zzpv(context).zzc(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }
}
