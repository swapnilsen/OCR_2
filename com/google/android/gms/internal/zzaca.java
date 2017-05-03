package com.google.android.gms.internal;

public abstract class zzaca<T> {
    private static String READ_PERMISSION;
    private static zza zzaDC;
    private static int zzaDD;
    private static final Object zztX;
    protected final String zzAX;
    protected final T zzAY;
    private T zzaDE;

    /* renamed from: com.google.android.gms.internal.zzaca.1 */
    class C10431 extends zzaca<Boolean> {
        C10431(String str, Boolean bool) {
            super(str, bool);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaca.2 */
    class C10442 extends zzaca<Long> {
        C10442(String str, Long l) {
            super(str, l);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaca.3 */
    class C10453 extends zzaca<Integer> {
        C10453(String str, Integer num) {
            super(str, num);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaca.4 */
    class C10464 extends zzaca<Float> {
        C10464(String str, Float f) {
            super(str, f);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaca.5 */
    class C10475 extends zzaca<String> {
        C10475(String str, String str2) {
            super(str, str2);
        }
    }

    private interface zza {
    }

    static {
        zztX = new Object();
        zzaDC = null;
        zzaDD = 0;
        READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    }

    protected zzaca(String str, T t) {
        this.zzaDE = null;
        this.zzAX = str;
        this.zzAY = t;
    }

    public static zzaca<String> zzB(String str, String str2) {
        return new C10475(str, str2);
    }

    public static zzaca<Float> zza(String str, Float f) {
        return new C10464(str, f);
    }

    public static zzaca<Integer> zza(String str, Integer num) {
        return new C10453(str, num);
    }

    public static zzaca<Long> zza(String str, Long l) {
        return new C10442(str, l);
    }

    public static zzaca<Boolean> zzj(String str, boolean z) {
        return new C10431(str, Boolean.valueOf(z));
    }
}
