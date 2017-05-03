package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzp {
    public static long zza(InputStream inputStream, OutputStream outputStream) {
        return zza(inputStream, outputStream, false);
    }

    public static long zza(InputStream inputStream, OutputStream outputStream, boolean z) {
        return zza(inputStream, outputStream, z, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
    }

    public static long zza(InputStream inputStream, OutputStream outputStream, boolean z, int i) {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    zzb(inputStream);
                    zzb(outputStream);
                }
            }
        }
        return j;
    }

    public static void zza(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] zza(InputStream inputStream, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zza(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    public static void zzb(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] zzj(InputStream inputStream) {
        return zza(inputStream, true);
    }
}