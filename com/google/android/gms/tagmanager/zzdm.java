package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzdm extends zzdj {
    private static final String ID;
    private static final String zzbIL;
    private static final String zzbIM;
    private static final String zzbIN;
    private static final String zzbIO;
    private static final String zzbIP;
    private static final String zzbIQ;
    private static final String zzbIR;
    private static final String zzbIS;
    private static final String zzbIT;
    private static final List<String> zzbIU;
    private static final Pattern zzbIV;
    private static final Pattern zzbIW;
    private static Map<String, String> zzbIX;
    private static Map<String, String> zzbIY;
    private final DataLayer zzbEV;
    private final Set<String> zzbIZ;
    private final zzdi zzbJa;

    static {
        ID = zzah.UNIVERSAL_ANALYTICS.toString();
        zzbIL = zzai.ACCOUNT.toString();
        zzbIM = zzai.ANALYTICS_PASS_THROUGH.toString();
        zzbIN = zzai.ENABLE_ECOMMERCE.toString();
        zzbIO = zzai.ECOMMERCE_USE_DATA_LAYER.toString();
        zzbIP = zzai.ECOMMERCE_MACRO_DATA.toString();
        zzbIQ = zzai.ANALYTICS_FIELDS.toString();
        zzbIR = zzai.TRACK_TRANSACTION.toString();
        zzbIS = zzai.TRANSACTION_DATALAYER_MAP.toString();
        zzbIT = zzai.TRANSACTION_ITEM_DATALAYER_MAP.toString();
        zzbIU = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, Promotion.ACTION_CLICK, ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND});
        zzbIV = Pattern.compile("dimension(\\d+)");
        zzbIW = Pattern.compile("metric(\\d+)");
    }

    public zzdm(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new zzdi(context));
    }

    zzdm(Context context, DataLayer dataLayer, zzdi com_google_android_gms_tagmanager_zzdi) {
        super(ID, new String[0]);
        this.zzbEV = dataLayer;
        this.zzbJa = com_google_android_gms_tagmanager_zzdi;
        this.zzbIZ = new HashSet();
        this.zzbIZ.add(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        this.zzbIZ.add("0");
        this.zzbIZ.add("false");
    }

    private Double zzV(Object obj) {
        String str;
        String valueOf;
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                str = "Cannot convert the object to Double: ";
                valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            str = "Cannot convert the object to Double: ";
            valueOf = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private Integer zzW(Object obj) {
        String str;
        String valueOf;
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                str = "Cannot convert the object to Integer: ";
                valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            str = "Cannot convert the object to Integer: ";
            valueOf = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private void zza(Tracker tracker, Map<String, zza> map) {
        String zzhB = zzhB("transactionId");
        if (zzhB == null) {
            zzbo.m4711e("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map zzk = zzk((zza) map.get(zzbIQ));
            zzk.put("&t", "transaction");
            for (Entry entry : zzal(map).entrySet()) {
                zze(zzk, (String) entry.getValue(), zzhB((String) entry.getKey()));
            }
            linkedList.add(zzk);
            List<Map> zzhC = zzhC("transactionProducts");
            if (zzhC != null) {
                for (Map map2 : zzhC) {
                    if (map2.get("name") == null) {
                        zzbo.m4711e("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map zzk2 = zzk((zza) map.get(zzbIQ));
                    zzk2.put("&t", "item");
                    zzk2.put("&ti", zzhB);
                    for (Entry entry2 : zzam(map).entrySet()) {
                        zze(zzk2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(zzk2);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            zzbo.zzb("Unable to send transaction", e);
        }
    }

    private Promotion zzaj(Map<String, String> map) {
        Promotion promotion = new Promotion();
        String str = (String) map.get(FacebookAdapter.KEY_ID);
        if (str != null) {
            promotion.setId(String.valueOf(str));
        }
        str = (String) map.get("name");
        if (str != null) {
            promotion.setName(String.valueOf(str));
        }
        str = (String) map.get("creative");
        if (str != null) {
            promotion.setCreative(String.valueOf(str));
        }
        str = (String) map.get("position");
        if (str != null) {
            promotion.setPosition(String.valueOf(str));
        }
        return promotion;
    }

    private Product zzak(Map<String, Object> map) {
        String str;
        Product product = new Product();
        Object obj = map.get(FacebookAdapter.KEY_ID);
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        obj = map.get("name");
        if (obj != null) {
            product.setName(String.valueOf(obj));
        }
        obj = map.get("brand");
        if (obj != null) {
            product.setBrand(String.valueOf(obj));
        }
        obj = map.get("category");
        if (obj != null) {
            product.setCategory(String.valueOf(obj));
        }
        obj = map.get("variant");
        if (obj != null) {
            product.setVariant(String.valueOf(obj));
        }
        obj = map.get(Param.COUPON);
        if (obj != null) {
            product.setCouponCode(String.valueOf(obj));
        }
        obj = map.get("position");
        if (obj != null) {
            product.setPosition(zzW(obj).intValue());
        }
        obj = map.get(Param.PRICE);
        if (obj != null) {
            product.setPrice(zzV(obj).doubleValue());
        }
        obj = map.get(Param.QUANTITY);
        if (obj != null) {
            product.setQuantity(zzW(obj).intValue());
        }
        for (String str2 : map.keySet()) {
            String str22;
            Matcher matcher = zzbIV.matcher(str22);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str22)));
                } catch (NumberFormatException e) {
                    str = "illegal number in custom dimension value: ";
                    str22 = String.valueOf(str22);
                    zzbo.zzbh(str22.length() != 0 ? str.concat(str22) : new String(str));
                }
            } else {
                matcher = zzbIW.matcher(str22);
                if (matcher.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher.group(1)), zzW(map.get(str22)).intValue());
                    } catch (NumberFormatException e2) {
                        str = "illegal number in custom metric value: ";
                        str22 = String.valueOf(str22);
                        zzbo.zzbh(str22.length() != 0 ? str.concat(str22) : new String(str));
                    }
                }
            }
        }
        return product;
    }

    private Map<String, String> zzal(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbIS);
        if (com_google_android_gms_internal_zzak_zza != null) {
            return zzc(com_google_android_gms_internal_zzak_zza);
        }
        if (zzbIX == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            zzbIX = hashMap;
        }
        return zzbIX;
    }

    private Map<String, String> zzam(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbIT);
        if (com_google_android_gms_internal_zzak_zza != null) {
            return zzc(com_google_android_gms_internal_zzak_zza);
        }
        if (zzbIY == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put(Param.PRICE, "&ip");
            hashMap.put(Param.QUANTITY, "&iq");
            hashMap.put(Param.CURRENCY, "&cu");
            zzbIY = hashMap;
        }
        return zzbIY;
    }

    private void zzb(Tracker tracker, Map<String, zza> map) {
        Object obj;
        Map map2;
        String str;
        ScreenViewBuilder screenViewBuilder = new ScreenViewBuilder();
        Map zzk = zzk((zza) map.get(zzbIQ));
        screenViewBuilder.setAll(zzk);
        if (zzi(map, zzbIO)) {
            obj = this.zzbEV.get("ecommerce");
            map2 = obj instanceof Map ? (Map) obj : null;
        } else {
            obj = zzdl.zzj((zza) map.get(zzbIP));
            map2 = obj instanceof Map ? (Map) obj : null;
        }
        if (map2 != null) {
            Map map3;
            List<Map> list;
            String str2 = (String) zzk.get("&cu");
            if (str2 == null) {
                str2 = (String) map2.get("currencyCode");
            }
            if (str2 != null) {
                screenViewBuilder.set("&cu", str2);
            }
            obj = map2.get("impressions");
            if (obj instanceof List) {
                for (Map map4 : (List) obj) {
                    try {
                        screenViewBuilder.addImpression(zzak(map4), (String) map4.get("list"));
                    } catch (RuntimeException e) {
                        str = "Failed to extract a product from DataLayer. ";
                        str2 = String.valueOf(e.getMessage());
                        zzbo.m4711e(str2.length() != 0 ? str.concat(str2) : new String(str));
                    }
                }
            }
            List list2 = map2.containsKey("promoClick") ? (List) ((Map) map2.get("promoClick")).get("promotions") : map2.containsKey("promoView") ? (List) ((Map) map2.get("promoView")).get("promotions") : null;
            if (r0 != null) {
                for (Map map42 : r0) {
                    try {
                        screenViewBuilder.addPromotion(zzaj(map42));
                    } catch (RuntimeException e2) {
                        str = "Failed to extract a promotion from DataLayer. ";
                        str2 = String.valueOf(e2.getMessage());
                        zzbo.m4711e(str2.length() != 0 ? str.concat(str2) : new String(str));
                    }
                }
                if (map2.containsKey("promoClick")) {
                    screenViewBuilder.set("&promoa", Promotion.ACTION_CLICK);
                    obj = null;
                    if (obj != null) {
                        for (String str22 : zzbIU) {
                            if (map2.containsKey(str22)) {
                                map3 = (Map) map2.get(str22);
                                list = (List) map3.get("products");
                                if (list != null) {
                                    for (Map map22 : list) {
                                        try {
                                            screenViewBuilder.addProduct(zzak(map22));
                                        } catch (RuntimeException e3) {
                                            str = "Failed to extract a product from DataLayer. ";
                                            String valueOf = String.valueOf(e3.getMessage());
                                            zzbo.m4711e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                                        }
                                    }
                                }
                                try {
                                    screenViewBuilder.setProductAction(map3.containsKey("actionField") ? zzh(str22, (Map) map3.get("actionField")) : new ProductAction(str22));
                                } catch (RuntimeException e22) {
                                    String str3 = "Failed to extract a product action from DataLayer. ";
                                    str22 = String.valueOf(e22.getMessage());
                                    zzbo.m4711e(str22.length() != 0 ? str3.concat(str22) : new String(str3));
                                }
                            }
                        }
                    }
                } else {
                    screenViewBuilder.set("&promoa", Promotion.ACTION_VIEW);
                }
            }
            int i = 1;
            if (obj != null) {
                for (String str222 : zzbIU) {
                    if (map22.containsKey(str222)) {
                        map3 = (Map) map22.get(str222);
                        list = (List) map3.get("products");
                        if (list != null) {
                            while (r4.hasNext()) {
                                screenViewBuilder.addProduct(zzak(map22));
                            }
                        }
                        if (map3.containsKey("actionField")) {
                        }
                        screenViewBuilder.setProductAction(map3.containsKey("actionField") ? zzh(str222, (Map) map3.get("actionField")) : new ProductAction(str222));
                    }
                }
            }
        }
        tracker.send(screenViewBuilder.build());
    }

    private Map<String, String> zzc(zza com_google_android_gms_internal_zzak_zza) {
        Object zzj = zzdl.zzj(com_google_android_gms_internal_zzak_zza);
        if (!(zzj instanceof Map)) {
            return null;
        }
        Map map = (Map) zzj;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private void zze(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private ProductAction zzh(String str, Map<String, Object> map) {
        ProductAction productAction = new ProductAction(str);
        Object obj = map.get(FacebookAdapter.KEY_ID);
        if (obj != null) {
            productAction.setTransactionId(String.valueOf(obj));
        }
        obj = map.get("affiliation");
        if (obj != null) {
            productAction.setTransactionAffiliation(String.valueOf(obj));
        }
        obj = map.get(Param.COUPON);
        if (obj != null) {
            productAction.setTransactionCouponCode(String.valueOf(obj));
        }
        obj = map.get("list");
        if (obj != null) {
            productAction.setProductActionList(String.valueOf(obj));
        }
        obj = map.get("option");
        if (obj != null) {
            productAction.setCheckoutOptions(String.valueOf(obj));
        }
        obj = map.get("revenue");
        if (obj != null) {
            productAction.setTransactionRevenue(zzV(obj).doubleValue());
        }
        obj = map.get(Param.TAX);
        if (obj != null) {
            productAction.setTransactionTax(zzV(obj).doubleValue());
        }
        obj = map.get(Param.SHIPPING);
        if (obj != null) {
            productAction.setTransactionShipping(zzV(obj).doubleValue());
        }
        obj = map.get("step");
        if (obj != null) {
            productAction.setCheckoutStep(zzW(obj).intValue());
        }
        return productAction;
    }

    private String zzhB(String str) {
        Object obj = this.zzbEV.get(str);
        return obj == null ? null : obj.toString();
    }

    private List<Map<String, String>> zzhC(String str) {
        Object obj = this.zzbEV.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private boolean zzi(Map<String, zza> map, String str) {
        zza com_google_android_gms_internal_zzak_zza = (zza) map.get(str);
        return com_google_android_gms_internal_zzak_zza == null ? false : zzdl.zzi(com_google_android_gms_internal_zzak_zza).booleanValue();
    }

    private Map<String, String> zzk(zza com_google_android_gms_internal_zzak_zza) {
        if (com_google_android_gms_internal_zzak_zza == null) {
            return new HashMap();
        }
        Map<String, String> zzc = zzc(com_google_android_gms_internal_zzak_zza);
        if (zzc == null) {
            return new HashMap();
        }
        String str = (String) zzc.get("&aip");
        if (str != null && this.zzbIZ.contains(str.toLowerCase())) {
            zzc.remove("&aip");
        }
        return zzc;
    }

    public /* bridge */ /* synthetic */ String zzQL() {
        return super.zzQL();
    }

    public /* bridge */ /* synthetic */ Set zzQM() {
        return super.zzQM();
    }

    public /* bridge */ /* synthetic */ boolean zzQb() {
        return super.zzQb();
    }

    public /* bridge */ /* synthetic */ zza zzZ(Map map) {
        return super.zzZ(map);
    }

    public void zzab(Map<String, zza> map) {
        Tracker zzht = this.zzbJa.zzht("_GTM_DEFAULT_TRACKER_");
        zzht.enableAdvertisingIdCollection(zzi(map, "collect_adid"));
        if (zzi(map, zzbIN)) {
            zzb(zzht, map);
        } else if (zzi(map, zzbIM)) {
            zzht.send(zzk((zza) map.get(zzbIQ)));
        } else if (zzi(map, zzbIR)) {
            zza(zzht, map);
        } else {
            zzbo.zzbh("Ignoring unknown tag.");
        }
    }
}
