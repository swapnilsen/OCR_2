package com.google.android.gms.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.internal.zzac;
import com.google.api.client.http.HttpStatusCodes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

class zztf extends zzsa {
    private static final byte[] zzagz;
    private final String zzIA;
    private final zztj zzagy;

    private class zza {
        private int zzagA;
        private ByteArrayOutputStream zzagB;
        final /* synthetic */ zztf zzagC;

        public zza(zztf com_google_android_gms_internal_zztf) {
            this.zzagC = com_google_android_gms_internal_zztf;
            this.zzagB = new ByteArrayOutputStream();
        }

        public byte[] getPayload() {
            return this.zzagB.toByteArray();
        }

        public boolean zzj(zzsz com_google_android_gms_internal_zzsz) {
            zzac.zzw(com_google_android_gms_internal_zzsz);
            if (this.zzagA + 1 > this.zzagC.zznT().zzph()) {
                return false;
            }
            String zza = this.zzagC.zza(com_google_android_gms_internal_zzsz, false);
            if (zza == null) {
                this.zzagC.zznS().zza(com_google_android_gms_internal_zzsz, "Error formatting hit");
                return true;
            }
            byte[] bytes = zza.getBytes();
            int length = bytes.length;
            if (length > this.zzagC.zznT().zzoZ()) {
                this.zzagC.zznS().zza(com_google_android_gms_internal_zzsz, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzagB.size() > 0) {
                length++;
            }
            if (length + this.zzagB.size() > this.zzagC.zznT().zzpb()) {
                return false;
            }
            try {
                if (this.zzagB.size() > 0) {
                    this.zzagB.write(zztf.zzagz);
                }
                this.zzagB.write(bytes);
                this.zzagA++;
                return true;
            } catch (IOException e) {
                this.zzagC.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzqd() {
            return this.zzagA;
        }
    }

    static {
        zzagz = "\n".getBytes();
    }

    zztf(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
        this.zzIA = zza("GoogleAnalytics", zzsb.VERSION, VERSION.RELEASE, zztm.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzagy = new zztj(com_google_android_gms_internal_zzsc.zznR());
    }

    private int zza(URL url, byte[] bArr) {
        HttpURLConnection zzc;
        Object e;
        Throwable th;
        OutputStream outputStream = null;
        zzac.zzw(url);
        zzac.zzw(bArr);
        zzb("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (zzkI()) {
            zza("Post payload\n", new String(bArr));
        }
        try {
            getContext().getPackageName();
            zzc = zzc(url);
            try {
                zzc.setDoOutput(true);
                zzc.setFixedLengthStreamingMode(bArr.length);
                zzc.connect();
                outputStream = zzc.getOutputStream();
                outputStream.write(bArr);
                zzb(zzc);
                int responseCode = zzc.getResponseCode();
                if (responseCode == HttpStatusCodes.STATUS_CODE_OK) {
                    zzmA().zznP();
                }
                zzb("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        zze("Error closing http post connection output stream", e2);
                    }
                }
                if (zzc == null) {
                    return responseCode;
                }
                zzc.disconnect();
                return responseCode;
            } catch (IOException e3) {
                e = e3;
                try {
                    zzd("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            zze("Error closing http post connection output stream", e4);
                        }
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            zze("Error closing http post connection output stream", e22);
                        }
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            zzc = outputStream;
            zzd("Network POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzc != null) {
                zzc.disconnect();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            zzc = outputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzc != null) {
                zzc.disconnect();
            }
            throw th;
        }
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    private void zza(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        zzac.zzw(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = zzc(url);
            httpURLConnection.connect();
            zzb(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpStatusCodes.STATUS_CODE_OK) {
                zzmA().zznP();
            }
            zzb("GET status", Integer.valueOf(responseCode));
            if (httpURLConnection == null) {
                return responseCode;
            }
            httpURLConnection.disconnect();
            return responseCode;
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            return 0;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private int zzb(URL url, byte[] bArr) {
        Object e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        OutputStream outputStream = null;
        zzac.zzw(url);
        zzac.zzw(bArr);
        HttpURLConnection zzc;
        try {
            getContext().getPackageName();
            byte[] zzk = zzk(bArr);
            zza("POST compressed size, ratio %, url", Integer.valueOf(zzk.length), Long.valueOf((100 * ((long) zzk.length)) / ((long) bArr.length)), url);
            if (zzk.length > bArr.length) {
                zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(zzk.length), Integer.valueOf(bArr.length));
            }
            if (zzkI()) {
                String str = "Post payload";
                String str2 = "\n";
                String valueOf = String.valueOf(new String(bArr));
                zza(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            zzc = zzc(url);
            try {
                zzc.setDoOutput(true);
                zzc.addRequestProperty("Content-Encoding", "gzip");
                zzc.setFixedLengthStreamingMode(zzk.length);
                zzc.connect();
                OutputStream outputStream2 = zzc.getOutputStream();
                try {
                    outputStream2.write(zzk);
                    outputStream2.close();
                    zzb(zzc);
                    int responseCode = zzc.getResponseCode();
                    if (responseCode == HttpStatusCodes.STATUS_CODE_OK) {
                        zzmA().zznP();
                    }
                    zzb("POST status", Integer.valueOf(responseCode));
                    if (zzc == null) {
                        return responseCode;
                    }
                    zzc.disconnect();
                    return responseCode;
                } catch (IOException e2) {
                    e = e2;
                    outputStream = outputStream2;
                    httpURLConnection = zzc;
                    try {
                        zzd("Network compressed POST connection error", e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                zze("Error closing http compressed post connection output stream", e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        zzc = httpURLConnection;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                                zze("Error closing http compressed post connection output stream", e4);
                            }
                        }
                        if (zzc != null) {
                            zzc.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                httpURLConnection = zzc;
                zzd("Network compressed POST connection error", e);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return 0;
            } catch (Throwable th4) {
                th = th4;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzc != null) {
                    zzc.disconnect();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnection = null;
            zzd("Network compressed POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return 0;
        } catch (Throwable th5) {
            th = th5;
            zzc = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzc != null) {
                zzc.disconnect();
            }
            throw th;
        }
    }

    private URL zzb(zzsz com_google_android_gms_internal_zzsz, String str) {
        String valueOf;
        String valueOf2;
        if (com_google_android_gms_internal_zzsz.zzpS()) {
            valueOf2 = String.valueOf(zznT().zzpj());
            valueOf = String.valueOf(zznT().zzpl());
            valueOf = new StringBuilder(((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str).length()).append(valueOf2).append(valueOf).append("?").append(str).toString();
        } else {
            valueOf2 = String.valueOf(zznT().zzpk());
            valueOf = String.valueOf(zznT().zzpl());
            valueOf = new StringBuilder(((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str).length()).append(valueOf2).append(valueOf).append("?").append(str).toString();
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void zzb(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private boolean zzg(zzsz com_google_android_gms_internal_zzsz) {
        zzac.zzw(com_google_android_gms_internal_zzsz);
        String zza = zza(com_google_android_gms_internal_zzsz, !com_google_android_gms_internal_zzsz.zzpS());
        if (zza == null) {
            zznS().zza(com_google_android_gms_internal_zzsz, "Error formatting hit for upload");
            return true;
        } else if (zza.length() <= zznT().zzoY()) {
            URL zzb = zzb(com_google_android_gms_internal_zzsz, zza);
            if (zzb != null) {
                return zzb(zzb) == HttpStatusCodes.STATUS_CODE_OK;
            } else {
                zzbT("Failed to build collect GET endpoint url");
                return false;
            }
        } else {
            zza = zza(com_google_android_gms_internal_zzsz, false);
            if (zza == null) {
                zznS().zza(com_google_android_gms_internal_zzsz, "Error formatting hit for POST upload");
                return true;
            }
            byte[] bytes = zza.getBytes();
            if (bytes.length > zznT().zzpa()) {
                zznS().zza(com_google_android_gms_internal_zzsz, "Hit payload exceeds size limit");
                return true;
            }
            URL zzh = zzh(com_google_android_gms_internal_zzsz);
            if (zzh != null) {
                return zza(zzh, bytes) == HttpStatusCodes.STATUS_CODE_OK;
            } else {
                zzbT("Failed to build collect POST endpoint url");
                return false;
            }
        }
    }

    private URL zzh(zzsz com_google_android_gms_internal_zzsz) {
        String valueOf;
        String valueOf2;
        if (com_google_android_gms_internal_zzsz.zzpS()) {
            valueOf = String.valueOf(zznT().zzpj());
            valueOf2 = String.valueOf(zznT().zzpl());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            valueOf = String.valueOf(zznT().zzpk());
            valueOf2 = String.valueOf(zznT().zzpl());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzsz com_google_android_gms_internal_zzsz) {
        return String.valueOf(com_google_android_gms_internal_zzsz.zzpP());
    }

    private static byte[] zzk(byte[] bArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzqb() {
        String valueOf = String.valueOf(zznT().zzpj());
        String valueOf2 = String.valueOf(zznT().zzpm());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String zza(zzsz com_google_android_gms_internal_zzsz, boolean z) {
        zzac.zzw(com_google_android_gms_internal_zzsz);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : com_google_android_gms_internal_zzsz.zzfE().entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    zza(stringBuilder, str, (String) entry.getValue());
                }
            }
            zza(stringBuilder, "ht", String.valueOf(com_google_android_gms_internal_zzsz.zzpQ()));
            zza(stringBuilder, "qt", String.valueOf(zznR().currentTimeMillis() - com_google_android_gms_internal_zzsz.zzpQ()));
            if (z) {
                long zzpT = com_google_android_gms_internal_zzsz.zzpT();
                zza(stringBuilder, "z", zzpT != 0 ? String.valueOf(zzpT) : zzi(com_google_android_gms_internal_zzsz));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    List<Long> zza(List<zzsz> list, boolean z) {
        zzac.zzax(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza com_google_android_gms_internal_zztf_zza = new zza(this);
        List<Long> arrayList = new ArrayList();
        for (zzsz com_google_android_gms_internal_zzsz : list) {
            if (!com_google_android_gms_internal_zztf_zza.zzj(com_google_android_gms_internal_zzsz)) {
                break;
            }
            arrayList.add(Long.valueOf(com_google_android_gms_internal_zzsz.zzpP()));
        }
        if (com_google_android_gms_internal_zztf_zza.zzqd() == 0) {
            return arrayList;
        }
        URL zzqb = zzqb();
        if (zzqb == null) {
            zzbT("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int zzb = z ? zzb(zzqb, com_google_android_gms_internal_zztf_zza.getPayload()) : zza(zzqb, com_google_android_gms_internal_zztf_zza.getPayload());
        if (HttpStatusCodes.STATUS_CODE_OK == zzb) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(com_google_android_gms_internal_zztf_zza.zzqd()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(zzb));
        if (zznT().zzpp().contains(Integer.valueOf(zzb))) {
            zzbS("Server instructed the client to stop batching");
            this.zzagy.start();
        }
        return Collections.emptyList();
    }

    HttpURLConnection zzc(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(zznT().zzpw());
            httpURLConnection.setReadTimeout(zznT().zzpx());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.zzIA);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    protected void zzmS() {
        zza("Network initialized. User agent", this.zzIA);
    }

    public boolean zzqa() {
        NetworkInfo activeNetworkInfo;
        zzmR();
        zzob();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbP("No network connectivity");
        return false;
    }

    public List<Long> zzt(List<zzsz> list) {
        boolean z;
        boolean z2 = true;
        zzmR();
        zzob();
        zzac.zzw(list);
        if (zznT().zzpp().isEmpty() || !this.zzagy.zzA(zznT().zzpi() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = zznT().zzpn() != zzsj.NONE;
            if (zznT().zzpo() != zzsm.GZIP) {
                z2 = false;
            }
        }
        return z ? zza((List) list, z2) : zzu(list);
    }

    List<Long> zzu(List<zzsz> list) {
        List<Long> arrayList = new ArrayList(list.size());
        for (zzsz com_google_android_gms_internal_zzsz : list) {
            if (!zzg(com_google_android_gms_internal_zzsz)) {
                break;
            }
            arrayList.add(Long.valueOf(com_google_android_gms_internal_zzsz.zzpP()));
            if (arrayList.size() >= zznT().zzpg()) {
                break;
            }
        }
        return arrayList;
    }
}
