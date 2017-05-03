package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.zzaj.zzf;
import com.google.android.gms.internal.zzbjd.zza;
import com.google.android.gms.internal.zzbjf;
import com.google.android.gms.internal.zzbjf.zzc;
import com.google.android.gms.internal.zzbjf.zzg;
import com.google.android.gms.internal.zzbxs;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class zzcv implements zzf {
    private final Context mContext;
    private final String zzbEU;
    private zzbn<zza> zzbHt;
    private final ExecutorService zzbtI;

    /* renamed from: com.google.android.gms.tagmanager.zzcv.1 */
    class C14481 implements Runnable {
        final /* synthetic */ zzcv zzbHA;

        C14481(zzcv com_google_android_gms_tagmanager_zzcv) {
            this.zzbHA = com_google_android_gms_tagmanager_zzcv;
        }

        public void run() {
            this.zzbHA.zzRm();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcv.2 */
    class C14492 implements Runnable {
        final /* synthetic */ zzcv zzbHA;
        final /* synthetic */ zza zzbHB;

        C14492(zzcv com_google_android_gms_tagmanager_zzcv, zza com_google_android_gms_internal_zzbjd_zza) {
            this.zzbHA = com_google_android_gms_tagmanager_zzcv;
            this.zzbHB = com_google_android_gms_internal_zzbjd_zza;
        }

        public void run() {
            this.zzbHA.zzc(this.zzbHB);
        }
    }

    zzcv(Context context, String str) {
        this.mContext = context;
        this.zzbEU = str;
        this.zzbtI = Executors.newSingleThreadExecutor();
    }

    private zzc zzM(byte[] bArr) {
        try {
            zzc zzb = zzbjf.zzb(zzf.zzf(bArr));
            if (zzb == null) {
                return zzb;
            }
            zzbo.m4712v("The container was successfully loaded from the resource (using binary file)");
            return zzb;
        } catch (zzbxs e) {
            zzbo.m4711e("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (zzg e2) {
            zzbo.zzbh("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    private zzc zza(ByteArrayOutputStream byteArrayOutputStream) {
        zzc com_google_android_gms_internal_zzbjf_zzc = null;
        try {
            com_google_android_gms_internal_zzbjf_zzc = zzbh.zzhl(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbo.zzbf("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
        } catch (JSONException e2) {
            zzbo.zzbh("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return com_google_android_gms_internal_zzbjf_zzc;
    }

    private void zzd(zza com_google_android_gms_internal_zzbjd_zza) {
        if (com_google_android_gms_internal_zzbjd_zza.zzlr == null && com_google_android_gms_internal_zzbjd_zza.zzbNf == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    public synchronized void release() {
        this.zzbtI.shutdown();
    }

    public void zzQp() {
        this.zzbtI.execute(new C14481(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void zzRm() {
        /*
        r3 = this;
        r0 = r3.zzbHt;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "Callback must be set before execute";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = "Attempting to load resource from disk";
        com.google.android.gms.tagmanager.zzbo.m4712v(r0);
        r0 = com.google.android.gms.tagmanager.zzcj.zzRe();
        r0 = r0.zzRf();
        r1 = com.google.android.gms.tagmanager.zzcj.zza.CONTAINER;
        if (r0 == r1) goto L_0x0029;
    L_0x001d:
        r0 = com.google.android.gms.tagmanager.zzcj.zzRe();
        r0 = r0.zzRf();
        r1 = com.google.android.gms.tagmanager.zzcj.zza.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x0041;
    L_0x0029:
        r0 = r3.zzbEU;
        r1 = com.google.android.gms.tagmanager.zzcj.zzRe();
        r1 = r1.getContainerId();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0041;
    L_0x0039:
        r0 = r3.zzbHt;
        r1 = com.google.android.gms.tagmanager.zzbn.zza.NOT_AVAILABLE;
        r0.zza(r1);
    L_0x0040:
        return;
    L_0x0041:
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x006b }
        r0 = r3.zzRn();	 Catch:{ FileNotFoundException -> 0x006b }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x006b }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0080, IllegalArgumentException -> 0x0098 }
        r0.<init>();	 Catch:{ IOException -> 0x0080, IllegalArgumentException -> 0x0098 }
        com.google.android.gms.internal.zzbjf.zzc(r1, r0);	 Catch:{ IOException -> 0x0080, IllegalArgumentException -> 0x0098 }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x0080, IllegalArgumentException -> 0x0098 }
        r0 = com.google.android.gms.internal.zzbjd.zza.zzQ(r0);	 Catch:{ IOException -> 0x0080, IllegalArgumentException -> 0x0098 }
        r3.zzd(r0);	 Catch:{ IOException -> 0x0080, IllegalArgumentException -> 0x0098 }
        r2 = r3.zzbHt;	 Catch:{ IOException -> 0x0080, IllegalArgumentException -> 0x0098 }
        r2.onSuccess(r0);	 Catch:{ IOException -> 0x0080, IllegalArgumentException -> 0x0098 }
        r1.close();	 Catch:{ IOException -> 0x0079 }
    L_0x0065:
        r0 = "The Disk resource was successfully read.";
        com.google.android.gms.tagmanager.zzbo.m4712v(r0);
        goto L_0x0040;
    L_0x006b:
        r0 = move-exception;
        r0 = "Failed to find the resource in the disk";
        com.google.android.gms.tagmanager.zzbo.zzbf(r0);
        r0 = r3.zzbHt;
        r1 = com.google.android.gms.tagmanager.zzbn.zza.NOT_AVAILABLE;
        r0.zza(r1);
        goto L_0x0040;
    L_0x0079:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbo.zzbh(r0);
        goto L_0x0065;
    L_0x0080:
        r0 = move-exception;
        r0 = r3.zzbHt;	 Catch:{ all -> 0x00b0 }
        r2 = com.google.android.gms.tagmanager.zzbn.zza.IO_ERROR;	 Catch:{ all -> 0x00b0 }
        r0.zza(r2);	 Catch:{ all -> 0x00b0 }
        r0 = "Failed to read the resource from disk";
        com.google.android.gms.tagmanager.zzbo.zzbh(r0);	 Catch:{ all -> 0x00b0 }
        r1.close();	 Catch:{ IOException -> 0x0091 }
        goto L_0x0065;
    L_0x0091:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbo.zzbh(r0);
        goto L_0x0065;
    L_0x0098:
        r0 = move-exception;
        r0 = r3.zzbHt;	 Catch:{ all -> 0x00b0 }
        r2 = com.google.android.gms.tagmanager.zzbn.zza.IO_ERROR;	 Catch:{ all -> 0x00b0 }
        r0.zza(r2);	 Catch:{ all -> 0x00b0 }
        r0 = "Failed to read the resource from disk. The resource is inconsistent";
        com.google.android.gms.tagmanager.zzbo.zzbh(r0);	 Catch:{ all -> 0x00b0 }
        r1.close();	 Catch:{ IOException -> 0x00a9 }
        goto L_0x0065;
    L_0x00a9:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbo.zzbh(r0);
        goto L_0x0065;
    L_0x00b0:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x00b5 }
    L_0x00b4:
        throw r0;
    L_0x00b5:
        r1 = move-exception;
        r1 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbo.zzbh(r1);
        goto L_0x00b4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcv.zzRm():void");
    }

    File zzRn() {
        String valueOf = String.valueOf("resource_");
        String valueOf2 = String.valueOf(this.zzbEU);
        return new File(this.mContext.getDir("google_tagmanager", 0), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    public void zza(zzbn<zza> com_google_android_gms_tagmanager_zzbn_com_google_android_gms_internal_zzbjd_zza) {
        this.zzbHt = com_google_android_gms_tagmanager_zzbn_com_google_android_gms_internal_zzbjd_zza;
    }

    public void zzb(zza com_google_android_gms_internal_zzbjd_zza) {
        this.zzbtI.execute(new C14492(this, com_google_android_gms_internal_zzbjd_zza));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean zzc(com.google.android.gms.internal.zzbjd.zza r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.zzRn();
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0016 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0016 }
        r3 = com.google.android.gms.internal.zzbxt.zzf(r5);	 Catch:{ IOException -> 0x0024 }
        r2.write(r3);	 Catch:{ IOException -> 0x0024 }
        r2.close();	 Catch:{ IOException -> 0x001d }
    L_0x0014:
        r0 = 1;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = move-exception;
        r1 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.zzbo.m4711e(r1);
        goto L_0x0015;
    L_0x001d:
        r0 = move-exception;
        r0 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbo.zzbh(r0);
        goto L_0x0014;
    L_0x0024:
        r3 = move-exception;
        r3 = "Error writing resource to disk. Removing resource from disk.";
        com.google.android.gms.tagmanager.zzbo.zzbh(r3);	 Catch:{ all -> 0x0038 }
        r1.delete();	 Catch:{ all -> 0x0038 }
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0015;
    L_0x0031:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbo.zzbh(r1);
        goto L_0x0015;
    L_0x0038:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbo.zzbh(r1);
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcv.zzc(com.google.android.gms.internal.zzbjd$zza):boolean");
    }

    public zzc zznz(int i) {
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            String valueOf = String.valueOf(this.mContext.getResources().getResourceName(i));
            zzbo.m4712v(new StringBuilder(String.valueOf(valueOf).length() + 66).append("Attempting to load a container from the resource ID ").append(i).append(" (").append(valueOf).append(")").toString());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzbjf.zzc(openRawResource, byteArrayOutputStream);
                zzc zza = zza(byteArrayOutputStream);
                if (zza == null) {
                    return zzM(byteArrayOutputStream.toByteArray());
                }
                zzbo.m4712v("The container was successfully loaded from the resource (using JSON file format)");
                return zza;
            } catch (IOException e) {
                String valueOf2 = String.valueOf(this.mContext.getResources().getResourceName(i));
                zzbo.zzbh(new StringBuilder(String.valueOf(valueOf2).length() + 67).append("Error reading the default container with resource ID ").append(i).append(" (").append(valueOf2).append(")").toString());
                return null;
            }
        } catch (NotFoundException e2) {
            zzbo.zzbh("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }
}
