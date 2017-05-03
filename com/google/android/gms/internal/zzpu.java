package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.List;

@zzme
public class zzpu {
    private final String[] zzYb;
    private final double[] zzYc;
    private final double[] zzYd;
    private final int[] zzYe;
    private int zzYf;

    public static class zza {
        public final int count;
        public final String name;
        public final double zzYg;
        public final double zzYh;
        public final double zzYi;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzYh = d;
            this.zzYg = d2;
            this.zzYi = d3;
            this.count = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzpu_zza = (zza) obj;
            return zzaa.equal(this.name, com_google_android_gms_internal_zzpu_zza.name) && this.zzYg == com_google_android_gms_internal_zzpu_zza.zzYg && this.zzYh == com_google_android_gms_internal_zzpu_zza.zzYh && this.count == com_google_android_gms_internal_zzpu_zza.count && Double.compare(this.zzYi, com_google_android_gms_internal_zzpu_zza.zzYi) == 0;
        }

        public int hashCode() {
            return zzaa.hashCode(this.name, Double.valueOf(this.zzYg), Double.valueOf(this.zzYh), Double.valueOf(this.zzYi), Integer.valueOf(this.count));
        }

        public String toString() {
            return zzaa.zzv(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzYh)).zzg("maxBound", Double.valueOf(this.zzYg)).zzg("percent", Double.valueOf(this.zzYi)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public static class zzb {
        private final List<String> zzYj;
        private final List<Double> zzYk;
        private final List<Double> zzYl;

        public zzb() {
            this.zzYj = new ArrayList();
            this.zzYk = new ArrayList();
            this.zzYl = new ArrayList();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.internal.zzpu.zzb zza(java.lang.String r7, double r8, double r10) {
            /*
            r6 = this;
            r0 = 0;
            r1 = r0;
        L_0x0002:
            r0 = r6.zzYj;
            r0 = r0.size();
            if (r1 >= r0) goto L_0x0026;
        L_0x000a:
            r0 = r6.zzYl;
            r0 = r0.get(r1);
            r0 = (java.lang.Double) r0;
            r2 = r0.doubleValue();
            r0 = r6.zzYk;
            r0 = r0.get(r1);
            r0 = (java.lang.Double) r0;
            r4 = r0.doubleValue();
            r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x003e;
        L_0x0026:
            r0 = r6.zzYj;
            r0.add(r1, r7);
            r0 = r6.zzYl;
            r2 = java.lang.Double.valueOf(r8);
            r0.add(r1, r2);
            r0 = r6.zzYk;
            r2 = java.lang.Double.valueOf(r10);
            r0.add(r1, r2);
            return r6;
        L_0x003e:
            r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
            if (r0 != 0) goto L_0x0046;
        L_0x0042:
            r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
            if (r0 < 0) goto L_0x0026;
        L_0x0046:
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x0002;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpu.zzb.zza(java.lang.String, double, double):com.google.android.gms.internal.zzpu$zzb");
        }

        public zzpu zzla() {
            return new zzpu();
        }
    }

    private zzpu(zzb com_google_android_gms_internal_zzpu_zzb) {
        int size = com_google_android_gms_internal_zzpu_zzb.zzYk.size();
        this.zzYb = (String[]) com_google_android_gms_internal_zzpu_zzb.zzYj.toArray(new String[size]);
        this.zzYc = zzn(com_google_android_gms_internal_zzpu_zzb.zzYk);
        this.zzYd = zzn(com_google_android_gms_internal_zzpu_zzb.zzYl);
        this.zzYe = new int[size];
        this.zzYf = 0;
    }

    private double[] zzn(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<zza> getBuckets() {
        List<zza> arrayList = new ArrayList(this.zzYb.length);
        for (int i = 0; i < this.zzYb.length; i++) {
            arrayList.add(new zza(this.zzYb[i], this.zzYd[i], this.zzYc[i], ((double) this.zzYe[i]) / ((double) this.zzYf), this.zzYe[i]));
        }
        return arrayList;
    }

    public void zza(double d) {
        this.zzYf++;
        int i = 0;
        while (i < this.zzYd.length) {
            if (this.zzYd[i] <= d && d < this.zzYc[i]) {
                int[] iArr = this.zzYe;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.zzYd[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
