package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.google.android.gms.tagmanager.zzm.zza;

@TargetApi(12)
class zzbi<K, V> implements zzl<K, V> {
    private LruCache<K, V> zzbGF;

    /* renamed from: com.google.android.gms.tagmanager.zzbi.1 */
    class C14451 extends LruCache<K, V> {
        final /* synthetic */ zza zzbGG;

        C14451(zzbi com_google_android_gms_tagmanager_zzbi, int i, zza com_google_android_gms_tagmanager_zzm_zza) {
            this.zzbGG = com_google_android_gms_tagmanager_zzm_zza;
            super(i);
        }

        protected int sizeOf(K k, V v) {
            return this.zzbGG.sizeOf(k, v);
        }
    }

    zzbi(int i, zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        this.zzbGF = new C14451(this, i, com_google_android_gms_tagmanager_zzm_zza_K__V);
    }

    public V get(K k) {
        return this.zzbGF.get(k);
    }

    public void zzh(K k, V v) {
        this.zzbGF.put(k, v);
    }
}
