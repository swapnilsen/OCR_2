package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class zzm<K, V> {
    final zza<K, V> zzbET;

    public interface zza<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: com.google.android.gms.tagmanager.zzm.1 */
    class C14591 implements zza<K, V> {
        C14591(zzm com_google_android_gms_tagmanager_zzm) {
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    public zzm() {
        this.zzbET = new C14591(this);
    }

    public zzl<K, V> zza(int i, zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        zzzA();
        return new zzbi(i, com_google_android_gms_tagmanager_zzm_zza_K__V);
    }

    int zzzA() {
        return VERSION.SDK_INT;
    }
}
