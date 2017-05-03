package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzw;

@zzme
public abstract class zzfz<T> {
    private final int zzAW;
    private final String zzAX;
    private final T zzAY;

    /* renamed from: com.google.android.gms.internal.zzfz.1 */
    class C11801 extends zzfz<Boolean> {
        C11801(int i, String str, Boolean bool) {
            super(str, bool, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzb(sharedPreferences);
        }

        public Boolean zzb(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzfr()).booleanValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfz.2 */
    class C11812 extends zzfz<Integer> {
        C11812(int i, String str, Integer num) {
            super(str, num, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzc(sharedPreferences);
        }

        public Integer zzc(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzfr()).intValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfz.3 */
    class C11823 extends zzfz<Long> {
        C11823(int i, String str, Long l) {
            super(str, l, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzd(sharedPreferences);
        }

        public Long zzd(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzfr()).longValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfz.4 */
    class C11834 extends zzfz<Float> {
        C11834(int i, String str, Float f) {
            super(str, f, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zze(sharedPreferences);
        }

        public Float zze(SharedPreferences sharedPreferences) {
            return Float.valueOf(sharedPreferences.getFloat(getKey(), ((Float) zzfr()).floatValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfz.5 */
    class C11845 extends zzfz<String> {
        C11845(int i, String str, String str2) {
            super(str, str2, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzf(sharedPreferences);
        }

        public String zzf(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(getKey(), (String) zzfr());
        }
    }

    private zzfz(int i, String str, T t) {
        this.zzAW = i;
        this.zzAX = str;
        this.zzAY = t;
        zzw.zzcX().zza(this);
    }

    public static zzfz<String> zza(int i, String str) {
        zzfz<String> zza = zza(i, str, null);
        zzw.zzcX().zzb(zza);
        return zza;
    }

    public static zzfz<Float> zza(int i, String str, float f) {
        return new C11834(i, str, Float.valueOf(f));
    }

    public static zzfz<Integer> zza(int i, String str, int i2) {
        return new C11812(i, str, Integer.valueOf(i2));
    }

    public static zzfz<Long> zza(int i, String str, long j) {
        return new C11823(i, str, Long.valueOf(j));
    }

    public static zzfz<Boolean> zza(int i, String str, Boolean bool) {
        return new C11801(i, str, bool);
    }

    public static zzfz<String> zza(int i, String str, String str2) {
        return new C11845(i, str, str2);
    }

    public static zzfz<String> zzb(int i, String str) {
        zzfz<String> zza = zza(i, str, null);
        zzw.zzcX().zzc(zza);
        return zza;
    }

    public T get() {
        return zzw.zzcY().zzd(this);
    }

    public String getKey() {
        return this.zzAX;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzfr() {
        return this.zzAY;
    }
}
