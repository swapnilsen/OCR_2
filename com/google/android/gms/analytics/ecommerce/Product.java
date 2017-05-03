package com.google.android.gms.analytics.ecommerce;

import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.analytics.zzc;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzac;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Product {
    Map<String, String> zzadz;

    public Product() {
        this.zzadz = new HashMap();
    }

    void put(String str, String str2) {
        zzac.zzb((Object) str, (Object) "Name should be non-null");
        this.zzadz.put(str, str2);
    }

    public Product setBrand(String str) {
        put("br", str);
        return this;
    }

    public Product setCategory(String str) {
        put("ca", str);
        return this;
    }

    public Product setCouponCode(String str) {
        put("cc", str);
        return this;
    }

    public Product setCustomDimension(int i, String str) {
        put(zzc.zzay(i), str);
        return this;
    }

    public Product setCustomMetric(int i, int i2) {
        put(zzc.zzaz(i), Integer.toString(i2));
        return this;
    }

    public Product setId(String str) {
        put(FacebookAdapter.KEY_ID, str);
        return this;
    }

    public Product setName(String str) {
        put("nm", str);
        return this;
    }

    public Product setPosition(int i) {
        put("ps", Integer.toString(i));
        return this;
    }

    public Product setPrice(double d) {
        put("pr", Double.toString(d));
        return this;
    }

    public Product setQuantity(int i) {
        put("qt", Integer.toString(i));
        return this;
    }

    public Product setVariant(String str) {
        put("va", str);
        return this;
    }

    public String toString() {
        return zzf.zzS(this.zzadz);
    }

    public Map<String, String> zzbM(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.zzadz.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) entry.getValue());
        }
        return hashMap;
    }
}
