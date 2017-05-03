package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzf;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzrq extends zzf<zzrq> {
    private ProductAction zzabO;
    private final Map<String, List<Product>> zzabP;
    private final List<Promotion> zzabQ;
    private final List<Product> zzabR;

    public zzrq() {
        this.zzabR = new ArrayList();
        this.zzabQ = new ArrayList();
        this.zzabP = new HashMap();
    }

    public String toString() {
        Map hashMap = new HashMap();
        if (!this.zzabR.isEmpty()) {
            hashMap.put("products", this.zzabR);
        }
        if (!this.zzabQ.isEmpty()) {
            hashMap.put("promotions", this.zzabQ);
        }
        if (!this.zzabP.isEmpty()) {
            hashMap.put("impressions", this.zzabP);
        }
        hashMap.put("productAction", this.zzabO);
        return zzf.zzj(hashMap);
    }

    public void zza(Product product, String str) {
        if (product != null) {
            Object obj;
            if (str == null) {
                obj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            }
            if (!this.zzabP.containsKey(obj)) {
                this.zzabP.put(obj, new ArrayList());
            }
            ((List) this.zzabP.get(obj)).add(product);
        }
    }

    public void zza(zzrq com_google_android_gms_internal_zzrq) {
        com_google_android_gms_internal_zzrq.zzabR.addAll(this.zzabR);
        com_google_android_gms_internal_zzrq.zzabQ.addAll(this.zzabQ);
        for (Entry entry : this.zzabP.entrySet()) {
            String str = (String) entry.getKey();
            for (Product zza : (List) entry.getValue()) {
                com_google_android_gms_internal_zzrq.zza(zza, str);
            }
        }
        if (this.zzabO != null) {
            com_google_android_gms_internal_zzrq.zzabO = this.zzabO;
        }
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrq) com_google_android_gms_analytics_zzf);
    }

    public ProductAction zznp() {
        return this.zzabO;
    }

    public List<Product> zznq() {
        return Collections.unmodifiableList(this.zzabR);
    }

    public Map<String, List<Product>> zznr() {
        return this.zzabP;
    }

    public List<Promotion> zzns() {
        return Collections.unmodifiableList(this.zzabQ);
    }
}
