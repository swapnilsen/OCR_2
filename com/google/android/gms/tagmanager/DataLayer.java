package com.google.android.gms.tagmanager;

import android.support.v7.appcompat.C0268R;
import com.crashlytics.android.answers.AnswersEvent;
import com.google.api.client.http.HttpStatusCodes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT;
    static final String[] zzbFB;
    private static final Pattern zzbFC;
    private final ConcurrentHashMap<zzb, Integer> zzbFD;
    private final Map<String, Object> zzbFE;
    private final ReentrantLock zzbFF;
    private final LinkedList<Map<String, Object>> zzbFG;
    private final zzc zzbFH;
    private final CountDownLatch zzbFI;

    interface zzc {

        public interface zza {
            void zzM(List<zza> list);
        }

        void zza(zza com_google_android_gms_tagmanager_DataLayer_zzc_zza);

        void zza(List<zza> list, long j);

        void zzhc(String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.1 */
    class C14331 implements zzc {
        C14331() {
        }

        public void zza(zza com_google_android_gms_tagmanager_DataLayer_zzc_zza) {
            com_google_android_gms_tagmanager_DataLayer_zzc_zza.zzM(new ArrayList());
        }

        public void zza(List<zza> list, long j) {
        }

        public void zzhc(String str) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.2 */
    class C14342 implements zza {
        final /* synthetic */ DataLayer zzbFJ;

        C14342(DataLayer dataLayer) {
            this.zzbFJ = dataLayer;
        }

        public void zzM(List<zza> list) {
            for (zza com_google_android_gms_tagmanager_DataLayer_zza : list) {
                this.zzbFJ.zzac(this.zzbFJ.zzo(com_google_android_gms_tagmanager_DataLayer_zza.zzAX, com_google_android_gms_tagmanager_DataLayer_zza.mValue));
            }
            this.zzbFJ.zzbFI.countDown();
        }
    }

    static final class zza {
        public final Object mValue;
        public final String zzAX;

        zza(String str, Object obj) {
            this.zzAX = str;
            this.mValue = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_tagmanager_DataLayer_zza = (zza) obj;
            return this.zzAX.equals(com_google_android_gms_tagmanager_DataLayer_zza.zzAX) && this.mValue.equals(com_google_android_gms_tagmanager_DataLayer_zza.mValue);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zzAX.hashCode()), Integer.valueOf(this.mValue.hashCode())});
        }

        public String toString() {
            String str = this.zzAX;
            String valueOf = String.valueOf(this.mValue.toString());
            return new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()).append("Key: ").append(str).append(" value: ").append(valueOf).toString();
        }
    }

    interface zzb {
        void zzaa(Map<String, Object> map);
    }

    static {
        OBJECT_NOT_PRESENT = new Object();
        zzbFB = "gtm.lifetime".toString().split("\\.");
        zzbFC = Pattern.compile("(\\d+)\\s*([smhd]?)");
    }

    DataLayer() {
        this(new C14331());
    }

    DataLayer(zzc com_google_android_gms_tagmanager_DataLayer_zzc) {
        this.zzbFH = com_google_android_gms_tagmanager_DataLayer_zzc;
        this.zzbFD = new ConcurrentHashMap();
        this.zzbFE = new HashMap();
        this.zzbFF = new ReentrantLock();
        this.zzbFG = new LinkedList();
        this.zzbFI = new CountDownLatch(1);
        zzQw();
    }

    public static List<Object> listOf(Object... objArr) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objArr) {
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (i < objArr.length) {
            if (objArr[i] instanceof String) {
                hashMap.put((String) objArr[i], objArr[i + 1]);
                i += 2;
            } else {
                String valueOf = String.valueOf(objArr[i]);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 21).append("key is not a string: ").append(valueOf).toString());
            }
        }
        return hashMap;
    }

    private void zzQw() {
        this.zzbFH.zza(new C14342(this));
    }

    private void zzQx() {
        int i = 0;
        while (true) {
            Map map = (Map) this.zzbFG.poll();
            if (map != null) {
                zzah(map);
                int i2 = i + 1;
                if (i2 > HttpStatusCodes.STATUS_CODE_SERVER_ERROR) {
                    break;
                }
                i = i2;
            } else {
                return;
            }
        }
        this.zzbFG.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    private void zza(Map<String, Object> map, String str, Collection<zza> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str.length() == 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING : ".";
            String str3 = (String) entry.getKey();
            str3 = new StringBuilder((String.valueOf(str).length() + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(str2).append(str3).toString();
            if (entry.getValue() instanceof Map) {
                zza((Map) entry.getValue(), str3, collection);
            } else if (!str3.equals("gtm.lifetime")) {
                collection.add(new zza(str3, entry.getValue()));
            }
        }
    }

    private void zzac(Map<String, Object> map) {
        this.zzbFF.lock();
        try {
            this.zzbFG.offer(map);
            if (this.zzbFF.getHoldCount() == 1) {
                zzQx();
            }
            zzad(map);
        } finally {
            this.zzbFF.unlock();
        }
    }

    private void zzad(Map<String, Object> map) {
        Long zzae = zzae(map);
        if (zzae != null) {
            this.zzbFH.zza(zzag(map), zzae.longValue());
        }
    }

    private Long zzae(Map<String, Object> map) {
        Object zzaf = zzaf(map);
        return zzaf == null ? null : zzhb(zzaf.toString());
    }

    private Object zzaf(Map<String, Object> map) {
        String[] strArr = zzbFB;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<zza> zzag(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        zza(map, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, arrayList);
        return arrayList;
    }

    private void zzah(Map<String, Object> map) {
        synchronized (this.zzbFE) {
            for (String str : map.keySet()) {
                zzd(zzo(str, map.get(str)), this.zzbFE);
            }
        }
        zzai(map);
    }

    private void zzai(Map<String, Object> map) {
        for (zzb zzaa : this.zzbFD.keySet()) {
            zzaa.zzaa(map);
        }
    }

    static Long zzhb(String str) {
        String str2;
        String valueOf;
        Matcher matcher = zzbFC.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                str2 = "illegal number in _lifetime value: ";
                valueOf = String.valueOf(str);
                zzbo.zzbh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                parseLong = 0;
            }
            if (parseLong <= 0) {
                str2 = "non-positive _lifetime: ";
                valueOf = String.valueOf(str);
                zzbo.zzbg(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            }
            valueOf = matcher.group(2);
            if (valueOf.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (valueOf.charAt(0)) {
                case AnswersEvent.MAX_STRING_LENGTH /*100*/:
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case C0268R.styleable.AppCompatTheme_checkboxStyle /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case C0268R.styleable.AppCompatTheme_ratingBarStyleIndicator /*109*/:
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    str2 = "unknown units in _lifetime: ";
                    valueOf = String.valueOf(str);
                    zzbo.zzbh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
            }
        }
        str2 = "unknown _lifetime: ";
        valueOf = String.valueOf(str);
        zzbo.zzbg(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return null;
    }

    public Object get(String str) {
        synchronized (this.zzbFE) {
            Map map = this.zzbFE;
            String[] split = str.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String str, Object obj) {
        push(zzo(str, obj));
    }

    public void push(Map<String, Object> map) {
        try {
            this.zzbFI.await();
        } catch (InterruptedException e) {
            zzbo.zzbh("DataLayer.push: unexpected InterruptedException");
        }
        zzac(map);
    }

    public void pushEvent(String str, Map<String, Object> map) {
        Map hashMap = new HashMap(map);
        hashMap.put(EVENT_KEY, str);
        push(hashMap);
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.zzbFE) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.zzbFE.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    void zza(zzb com_google_android_gms_tagmanager_DataLayer_zzb) {
        this.zzbFD.put(com_google_android_gms_tagmanager_DataLayer_zzb, Integer.valueOf(0));
    }

    void zzb(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                zzb((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                zzd((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    void zzd(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                zzb((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                zzd((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void zzha(String str) {
        push(str, null);
        this.zzbFH.zzhc(str);
    }

    Map<String, Object> zzo(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }
}
