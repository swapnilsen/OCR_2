package com.google.android.gms.internal;

public final class zzbxw {
    static final int zzcuS;
    static final int zzcuT;
    static final int zzcuU;
    static final int zzcuV;
    public static final int[] zzcuW;
    public static final long[] zzcuX;
    public static final float[] zzcuY;
    public static final double[] zzcuZ;
    public static final boolean[] zzcva;
    public static final String[] zzcvb;
    public static final byte[][] zzcvc;
    public static final byte[] zzcvd;

    static {
        zzcuS = zzO(1, 3);
        zzcuT = zzO(1, 4);
        zzcuU = zzO(2, 0);
        zzcuV = zzO(3, 2);
        zzcuW = new int[0];
        zzcuX = new long[0];
        zzcuY = new float[0];
        zzcuZ = new double[0];
        zzcva = new boolean[0];
        zzcvb = new String[0];
        zzcvc = new byte[0][];
        zzcvd = new byte[0];
    }

    public static int zzO(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int zzb(zzbxl com_google_android_gms_internal_zzbxl, int i) {
        int i2 = 1;
        int position = com_google_android_gms_internal_zzbxl.getPosition();
        com_google_android_gms_internal_zzbxl.zzqY(i);
        while (com_google_android_gms_internal_zzbxl.zzaeo() == i) {
            com_google_android_gms_internal_zzbxl.zzqY(i);
            i2++;
        }
        com_google_android_gms_internal_zzbxl.zzrc(position);
        return i2;
    }

    static int zzrr(int i) {
        return i & 7;
    }

    public static int zzrs(int i) {
        return i >>> 3;
    }
}
