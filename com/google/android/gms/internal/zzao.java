package com.google.android.gms.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.internal.zzag.zzc;
import com.google.android.gms.internal.zzag.zzf;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzao {
    static boolean zzlF;
    private static MessageDigest zzlG;
    private static final Object zzlH;
    private static final Object zzlI;
    static CountDownLatch zzlJ;

    private static final class zza implements Runnable {
        private zza() {
        }

        public void run() {
            try {
                zzao.zzlG = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            } finally {
                zzao.zzlJ.countDown();
            }
        }
    }

    static {
        zzlF = false;
        zzlG = null;
        zzlH = new Object();
        zzlI = new Object();
        zzlJ = new CountDownLatch(1);
    }

    static void zzO() {
        synchronized (zzlI) {
            if (!zzlF) {
                zzlF = true;
                new Thread(new zza()).start();
            }
        }
    }

    static MessageDigest zzP() {
        zzO();
        boolean z = false;
        try {
            z = zzlJ.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return (z && zzlG != null) ? zzlG : null;
    }

    private static int zza(boolean z) {
        return z ? 239 : MotionEventCompat.ACTION_MASK;
    }

    static String zza(com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza, String str, boolean z) {
        return zza(zzbxt.zzf(com_google_android_gms_internal_zzag_zza), str, z);
    }

    static String zza(String str, String str2, boolean z) {
        return zza(str, str2, z, ((Boolean) zzgd.zzDP.get()).booleanValue());
    }

    static String zza(String str, String str2, boolean z, boolean z2) {
        byte[] zzb = zzb(str, str2, z, z2);
        return zzb != null ? zzam.zza(zzb, true) : Integer.toString(7);
    }

    static String zza(byte[] bArr, String str, boolean z) {
        return zzam.zza(z ? zzb(bArr, str) : zza(bArr, str), true);
    }

    static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + i) - 1) / i;
        Vector<byte[]> vector = new Vector();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * i;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > i ? i3 + i : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    static void zza(String str, byte[] bArr) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new zzbwl(str.getBytes("UTF-8")).zzaa(bArr);
    }

    static byte[] zza(byte[] bArr, String str) {
        Vector zza = zza(bArr, (int) MotionEventCompat.ACTION_MASK);
        if (zza == null || zza.size() == 0) {
            return zzb(zzbxt.zzf(zzb(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)), str);
        }
        zzbxt com_google_android_gms_internal_zzag_zzf = new zzf();
        com_google_android_gms_internal_zzag_zzf.zzcA = new byte[zza.size()][];
        Iterator it = zza.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            com_google_android_gms_internal_zzag_zzf.zzcA[i] = zzb((byte[]) it.next(), str, false);
            i = i2;
        }
        com_google_android_gms_internal_zzag_zzf.zzcv = zzh(bArr);
        return zzbxt.zzf(com_google_android_gms_internal_zzag_zzf);
    }

    static com.google.android.gms.internal.zzag.zza zzb(long j) {
        com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza = new com.google.android.gms.internal.zzag.zza();
        com_google_android_gms_internal_zzag_zza.zzbt = Long.valueOf(j);
        return com_google_android_gms_internal_zzag_zza;
    }

    static byte[] zzb(String str, String str2, boolean z, boolean z2) {
        zzbxt com_google_android_gms_internal_zzag_zzc = new zzc();
        try {
            com_google_android_gms_internal_zzag_zzc.zzct = str.length() < 3 ? str.getBytes("ISO-8859-1") : zzam.zza(str, true);
            byte[] bytes = z ? str2.length() < 3 ? str2.getBytes("ISO-8859-1") : zzam.zza(str2, true) : (str2 == null || str2.length() == 0) ? Integer.toString(5).getBytes("ISO-8859-1") : zzam.zza(zza(str2.getBytes("ISO-8859-1"), null, z2), true);
            com_google_android_gms_internal_zzag_zzc.zzcu = bytes;
            return zzbxt.zzf(com_google_android_gms_internal_zzag_zzc);
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }

    static byte[] zzb(byte[] bArr, String str) {
        return zzb(bArr, str, true);
    }

    private static byte[] zzb(byte[] bArr, String str, boolean z) {
        byte[] bArr2;
        byte[] array;
        int zza = zza(z);
        if (bArr.length > zza) {
            bArr = zzbxt.zzf(zzb(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        }
        if (bArr.length < zza) {
            bArr2 = new byte[(zza - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(zza + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(zza + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY).put(zzh(array)).put(array).array();
        }
        bArr2 = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        new zzap().zzb(array, bArr2);
        if (str != null && str.length() > 0) {
            zza(str, bArr2);
        }
        return bArr2;
    }

    public static byte[] zzh(byte[] bArr) {
        byte[] digest;
        synchronized (zzlH) {
            MessageDigest zzP = zzP();
            if (zzP == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            zzP.reset();
            zzP.update(bArr);
            digest = zzlG.digest();
        }
        return digest;
    }
}
