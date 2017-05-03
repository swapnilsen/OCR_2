package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.PriorityQueue;

@zzme
public class zzdk {

    public static class zza {
        final long value;
        final String zzyu;
        final int zzyv;

        zza(long j, String str, int i) {
            this.value = j;
            this.zzyu = str;
            this.zzyv = i;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj == null || !(obj instanceof zza)) ? false : ((zza) obj).value == this.value && ((zza) obj).zzyv == this.zzyv;
        }

        public int hashCode() {
            return (int) this.value;
        }
    }

    static long zza(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long zza(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? zza((j * j) % 1073807359, i / 2) % 1073807359 : ((zza((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String zza(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            zzqf.m4708e("Unable to construct shingle");
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void zza(int i, long j, String str, int i2, PriorityQueue<zza> priorityQueue) {
        zza com_google_android_gms_internal_zzdk_zza = new zza(j, str, i2);
        if ((priorityQueue.size() != i || (((zza) priorityQueue.peek()).zzyv <= com_google_android_gms_internal_zzdk_zza.zzyv && ((zza) priorityQueue.peek()).value <= com_google_android_gms_internal_zzdk_zza.value)) && !priorityQueue.contains(com_google_android_gms_internal_zzdk_zza)) {
            priorityQueue.add(com_google_android_gms_internal_zzdk_zza);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zza> priorityQueue) {
        if (strArr.length < i2) {
            int i3 = i;
            zza(i3, zzb(strArr, 0, strArr.length), zza(strArr, 0, strArr.length), strArr.length, (PriorityQueue) priorityQueue);
            return;
        }
        long zzb = zzb(strArr, 0, i2);
        zza(i, zzb, zza(strArr, 0, i2), i2, (PriorityQueue) priorityQueue);
        long zza = zza(16785407, i2 - 1);
        int i4 = 1;
        while (i4 < (strArr.length - i2) + 1) {
            long zza2 = zza(zzdi.zzH(strArr[i4 - 1]), zzdi.zzH(strArr[(i4 + i2) - 1]), zzb, zza, 16785407);
            zza(i, zza2, zza(strArr, i4, i2), strArr.length, (PriorityQueue) priorityQueue);
            i4++;
            zzb = zza2;
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        long zzH = (((long) zzdi.zzH(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            zzH = (((zzH * 16785407) % 1073807359) + ((((long) zzdi.zzH(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzH;
    }
}
