package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztm;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> zzabN;
        ProductAction zzabO;
        Map<String, List<Product>> zzabP;
        List<Promotion> zzabQ;
        List<Product> zzabR;

        protected HitBuilder() {
            this.zzabN = new HashMap();
            this.zzabP = new HashMap();
            this.zzabQ = new ArrayList();
            this.zzabR = new ArrayList();
        }

        private T zzo(String str, String str2) {
            if (str == null) {
                zztc.zzbh("HitBuilder.setIfNonNull() called with a null paramName.");
            } else if (str2 != null) {
                this.zzabN.put(str, str2);
            }
            return this;
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zztc.zzbh("product should be non-null");
            } else {
                Object obj;
                if (str == null) {
                    obj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
                }
                if (!this.zzabP.containsKey(obj)) {
                    this.zzabP.put(obj, new ArrayList());
                }
                ((List) this.zzabP.get(obj)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zztc.zzbh("product should be non-null");
            } else {
                this.zzabR.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zztc.zzbh("promotion should be non-null");
            } else {
                this.zzabQ.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.zzabN);
            if (this.zzabO != null) {
                hashMap.putAll(this.zzabO.build());
            }
            int i = 1;
            for (Promotion zzbM : this.zzabQ) {
                hashMap.putAll(zzbM.zzbM(zzc.zzat(i)));
                i++;
            }
            i = 1;
            for (Product zzbM2 : this.zzabR) {
                hashMap.putAll(zzbM2.zzbM(zzc.zzar(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.zzabP.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String zzaw = zzc.zzaw(i2);
                int i3 = 1;
                for (Product product : list) {
                    String valueOf = String.valueOf(zzaw);
                    String valueOf2 = String.valueOf(zzc.zzav(i3));
                    hashMap.putAll(product.zzbM(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    String valueOf3 = String.valueOf(zzaw);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        protected String get(String str) {
            return (String) this.zzabN.get(str);
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.zzabN.put(str, str2);
            } else {
                zztc.zzbh("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> map) {
            if (map != null) {
                this.zzabN.putAll(new HashMap(map));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            Object zzcg = zztm.zzcg(str);
            if (!TextUtils.isEmpty(zzcg)) {
                Map zzce = zztm.zzce(zzcg);
                zzo("&cc", (String) zzce.get("utm_content"));
                zzo("&cm", (String) zzce.get("utm_medium"));
                zzo("&cn", (String) zzce.get("utm_campaign"));
                zzo("&cs", (String) zzce.get("utm_source"));
                zzo("&ck", (String) zzce.get("utm_term"));
                zzo("&ci", (String) zzce.get("utm_id"));
                zzo("&anid", (String) zzce.get("anid"));
                zzo("&gclid", (String) zzce.get("gclid"));
                zzo("&dclid", (String) zzce.get("dclid"));
                zzo("&aclid", (String) zzce.get(Param.ACLID));
                zzo("&gmob_t", (String) zzce.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int i, String str) {
            set(zzc.zzan(i), str);
            return this;
        }

        public T setCustomMetric(int i, float f) {
            set(zzc.zzap(i), Float.toString(f));
            return this;
        }

        protected T setHitType(String str) {
            set("&t", str);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z) {
            set("&ni", zztm.zzX(z));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.zzabO = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.zzabN.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", zztm.zzX(z));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", NotificationCompatApi24.CATEGORY_SOCIAL);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}
