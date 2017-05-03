package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzme
public class zzgf {
    final Context mContext;
    BlockingQueue<zzgl> zzFA;
    ExecutorService zzFB;
    LinkedHashMap<String, String> zzFC;
    Map<String, zzgi> zzFD;
    private AtomicBoolean zzFE;
    private File zzFF;
    String zzFy;
    final String zzwd;

    /* renamed from: com.google.android.gms.internal.zzgf.1 */
    class C11871 implements Runnable {
        final /* synthetic */ zzgf zzFG;

        C11871(zzgf com_google_android_gms_internal_zzgf) {
            this.zzFG = com_google_android_gms_internal_zzgf;
        }

        public void run() {
            this.zzFG.zzfx();
        }
    }

    public zzgf(Context context, String str, String str2, Map<String, String> map) {
        this.zzFC = new LinkedHashMap();
        this.zzFD = new HashMap();
        this.mContext = context;
        this.zzwd = str;
        this.zzFy = str2;
        this.zzFE = new AtomicBoolean(false);
        this.zzFE.set(((Boolean) zzgd.zzCb.get()).booleanValue());
        if (this.zzFE.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.zzFF = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.zzFC.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.zzFA = new ArrayBlockingQueue(30);
        this.zzFB = Executors.newSingleThreadExecutor();
        this.zzFB.execute(new C11871(this));
        this.zzFD.put("action", zzgi.zzFI);
        this.zzFD.put("ad_format", zzgi.zzFI);
        this.zzFD.put("e", zzgi.zzFJ);
    }

    private void zzb(Map<String, String> map, String str) {
        String zza = zza(this.zzFy, map, str);
        if (this.zzFE.get()) {
            zzc(this.zzFF, zza);
        } else {
            zzw.zzcM().zzf(this.mContext, this.zzwd, zza);
        }
    }

    private void zzc(@Nullable File file, String str) {
        Throwable e;
        if (file != null) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write(10);
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (Throwable e2) {
                        zzqf.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                        return;
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        zzqf.zzc("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e2);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable e22) {
                                zzqf.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e22);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                zzqf.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = null;
                zzqf.zzc("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e22);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e22 = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22;
            }
        }
        zzqf.zzbh("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
    }

    private void zzfx() {
        while (true) {
            try {
                zzgl com_google_android_gms_internal_zzgl = (zzgl) this.zzFA.take();
                Object zzfD = com_google_android_gms_internal_zzgl.zzfD();
                if (!TextUtils.isEmpty(zzfD)) {
                    zzb(zza(this.zzFC, com_google_android_gms_internal_zzgl.zzfE()), zzfD);
                }
            } catch (Throwable e) {
                zzqf.zzc("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public zzgi zzV(String str) {
        zzgi com_google_android_gms_internal_zzgi = (zzgi) this.zzFD.get(str);
        return com_google_android_gms_internal_zzgi != null ? com_google_android_gms_internal_zzgi : zzgi.zzFH;
    }

    String zza(String str, Map<String, String> map, @NonNull String str2) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        StringBuilder stringBuilder = new StringBuilder(buildUpon.build().toString());
        stringBuilder.append("&").append("it").append("=").append(str2);
        return stringBuilder.toString();
    }

    Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzV(str).zzg(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public boolean zza(zzgl com_google_android_gms_internal_zzgl) {
        return this.zzFA.offer(com_google_android_gms_internal_zzgl);
    }

    public void zzc(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.zzFC.put("e", TextUtils.join(",", list));
        }
    }
}
