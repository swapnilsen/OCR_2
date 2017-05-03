package com.google.android.gms.tagmanager;

class zzdk extends Number implements Comparable<zzdk> {
    private long zzbIA;
    private boolean zzbIB;
    private double zzbIz;

    private zzdk(double d) {
        this.zzbIz = d;
        this.zzbIB = false;
    }

    private zzdk(long j) {
        this.zzbIA = j;
        this.zzbIB = true;
    }

    public static zzdk zza(Double d) {
        return new zzdk(d.doubleValue());
    }

    public static zzdk zzaA(long j) {
        return new zzdk(j);
    }

    public static zzdk zzhv(String str) {
        try {
            return new zzdk(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new zzdk(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(String.valueOf(str).concat(" is not a valid TypedNumber"));
            }
        }
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zza((zzdk) obj);
    }

    public double doubleValue() {
        return zzRH() ? (double) this.zzbIA : this.zzbIz;
    }

    public boolean equals(Object obj) {
        return (obj instanceof zzdk) && zza((zzdk) obj) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return zzRJ();
    }

    public long longValue() {
        return zzRI();
    }

    public short shortValue() {
        return zzRK();
    }

    public String toString() {
        return zzRH() ? Long.toString(this.zzbIA) : Double.toString(this.zzbIz);
    }

    public boolean zzRG() {
        return !zzRH();
    }

    public boolean zzRH() {
        return this.zzbIB;
    }

    public long zzRI() {
        return zzRH() ? this.zzbIA : (long) this.zzbIz;
    }

    public int zzRJ() {
        return (int) longValue();
    }

    public short zzRK() {
        return (short) ((int) longValue());
    }

    public int zza(zzdk com_google_android_gms_tagmanager_zzdk) {
        return (zzRH() && com_google_android_gms_tagmanager_zzdk.zzRH()) ? new Long(this.zzbIA).compareTo(Long.valueOf(com_google_android_gms_tagmanager_zzdk.zzbIA)) : Double.compare(doubleValue(), com_google_android_gms_tagmanager_zzdk.doubleValue());
    }
}
