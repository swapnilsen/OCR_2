package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class zzzt implements com.google.android.gms.internal.zzzk.zzb {
    private static final Charset UTF_8;
    static Boolean zzaxU;
    final zza zzaxV;

    static class zza {
        final ContentResolver mContentResolver;

        zza(Context context) {
            if (context == null || !zzaB(context)) {
                this.mContentResolver = null;
                return;
            }
            this.mContentResolver = context.getContentResolver();
            zzble.zzb(this.mContentResolver, "gms:playlog:service:sampling_");
        }

        private static boolean zzaB(Context context) {
            if (zzzt.zzaxU == null) {
                zzzt.zzaxU = Boolean.valueOf(zzadg.zzbi(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
            }
            return zzzt.zzaxU.booleanValue();
        }

        String zzdb(String str) {
            if (this.mContentResolver == null) {
                return null;
            }
            ContentResolver contentResolver = this.mContentResolver;
            String valueOf = String.valueOf("gms:playlog:service:sampling_");
            String valueOf2 = String.valueOf(str);
            return zzble.zza(contentResolver, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), null);
        }

        long zzuW() {
            return this.mContentResolver == null ? 0 : zzble.getLong(this.mContentResolver, "android_id", 0);
        }
    }

    static class zzb {
        public final String zzaxW;
        public final long zzaxX;
        public final long zzaxY;

        public zzb(String str, long j, long j2) {
            this.zzaxW = str;
            this.zzaxX = j;
            this.zzaxY = j2;
        }
    }

    static {
        UTF_8 = Charset.forName("UTF-8");
        zzaxU = null;
    }

    public zzzt() {
        this(new zza(null));
    }

    public zzzt(Context context) {
        this(new zza(context));
    }

    zzzt(zza com_google_android_gms_internal_zzzt_zza) {
        this.zzaxV = (zza) zzac.zzw(com_google_android_gms_internal_zzzt_zza);
    }

    static long zzJ(long j) {
        return zzzq.zzn(ByteBuffer.allocate(8).putLong(j).array());
    }

    static boolean zza(long j, long j2, long j3) {
        if (j2 >= 0 && j3 >= 0) {
            return j3 > 0 && zzzw.zzd(j, j3) < j2;
        } else {
            throw new IllegalArgumentException("negative values not supported: " + j2 + "/" + j3);
        }
    }

    static long zzd(String str, long j) {
        if (str == null || str.isEmpty()) {
            return zzJ(j);
        }
        byte[] bytes = str.getBytes(UTF_8);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return zzzq.zzn(allocate.array());
    }

    static zzb zzda(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        String str2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i = indexOf + 1;
        }
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 <= 0) {
            str2 = "LogSamplerImpl";
            String str3 = "Failed to parse the rule: ";
            String valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return new zzb(str2, parseLong, parseLong2);
            }
            Log.e("LogSamplerImpl", "negative values not supported: " + parseLong + "/" + parseLong2);
            return null;
        } catch (Throwable e) {
            Throwable th = e;
            str3 = "LogSamplerImpl";
            String str4 = "parseLong() failed while parsing: ";
            valueOf = String.valueOf(str);
            Log.e(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4), th);
            return null;
        }
    }

    public boolean zzh(String str, int i) {
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        long zzuW = this.zzaxV.zzuW();
        zzb zzda = zzda(this.zzaxV.zzdb(str));
        return zzda != null ? zza(zzd(zzda.zzaxW, zzuW), zzda.zzaxX, zzda.zzaxY) : true;
    }
}
