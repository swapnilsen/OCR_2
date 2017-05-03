package com.google.android.exoplayer2.p048a;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p050j.ParsableBitArray;
import com.google.android.gms.ads.AdRequest;
import java.nio.ByteBuffer;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;

/* renamed from: com.google.android.exoplayer2.a.e */
public final class DtsUtil {
    private static final int[] f2430a;
    private static final int[] f2431b;
    private static final int[] f2432c;

    static {
        f2430a = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        f2431b = new int[]{-1, EventsFilesManager.MAX_BYTE_SIZE_PER_FILE, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
        f2432c = new int[]{64, C0268R.styleable.AppCompatTheme_spinnerStyle, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, 192, 224, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 384, 448, AdRequest.MAX_CONTENT_URL_LENGTH, 640, 768, 896, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, 1152, 1280, 1536, 1920, ItemAnimator.FLAG_MOVED, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, CodedOutputStream.DEFAULT_BUFFER_SIZE, 6144, 7680};
    }

    public static Format m2958a(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.m4443b(60);
        int i2 = f2430a[parsableBitArray.m4445c(6)];
        int i3 = f2431b[parsableBitArray.m4445c(4)];
        int c = parsableBitArray.m4445c(5);
        c = c >= f2432c.length ? -1 : (f2432c[c] * PointerIconCompat.TYPE_DEFAULT) / 2;
        parsableBitArray.m4443b(10);
        if (parsableBitArray.m4445c(2) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        return Format.m2862a(str, "audio/vnd.dts", null, c, -1, i2 + i, i3, null, drmInitData, 0, str2);
    }

    public static int m2957a(byte[] bArr) {
        return ((((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2)) + 1) * 32;
    }

    public static int m2956a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int m2959b(byte[] bArr) {
        return ((((bArr[5] & 2) << 12) | ((bArr[6] & MotionEventCompat.ACTION_MASK) << 4)) | ((bArr[7] & 240) >> 4)) + 1;
    }
}
