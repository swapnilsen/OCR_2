package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzdl {
    private static final Object zzbIC;
    private static Long zzbID;
    private static Double zzbIE;
    private static zzdk zzbIF;
    private static String zzbIG;
    private static Boolean zzbIH;
    private static List<Object> zzbII;
    private static Map<Object, Object> zzbIJ;
    private static zza zzbIK;

    static {
        zzbIC = null;
        zzbID = new Long(0);
        zzbIE = new Double(0.0d);
        zzbIF = zzdk.zzaA(0);
        zzbIG = new String(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        zzbIH = new Boolean(false);
        zzbII = new ArrayList(0);
        zzbIJ = new HashMap();
        zzbIK = zzR(zzbIG);
    }

    private static double getDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzbo.m4711e("getDouble received non-Number");
        return 0.0d;
    }

    public static String zzM(Object obj) {
        return obj == null ? zzbIG : obj.toString();
    }

    public static zzdk zzN(Object obj) {
        return obj instanceof zzdk ? (zzdk) obj : zzT(obj) ? zzdk.zzaA(zzU(obj)) : zzS(obj) ? zzdk.zza(Double.valueOf(getDouble(obj))) : zzhx(zzM(obj));
    }

    public static Long zzO(Object obj) {
        return zzT(obj) ? Long.valueOf(zzU(obj)) : zzhy(zzM(obj));
    }

    public static Double zzP(Object obj) {
        return zzS(obj) ? Double.valueOf(getDouble(obj)) : zzhz(zzM(obj));
    }

    public static Boolean zzQ(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : zzhA(zzM(obj));
    }

    public static zza zzR(Object obj) {
        boolean z = false;
        zza com_google_android_gms_internal_zzak_zza = new zza();
        if (obj instanceof zza) {
            return (zza) obj;
        }
        if (obj instanceof String) {
            com_google_android_gms_internal_zzak_zza.type = 1;
            com_google_android_gms_internal_zzak_zza.string = (String) obj;
        } else if (obj instanceof List) {
            com_google_android_gms_internal_zzak_zza.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object zzR : list) {
                zza zzR2 = zzR(zzR);
                if (zzR2 == zzbIK) {
                    return zzbIK;
                }
                r0 = r1 || zzR2.zzlD;
                r5.add(zzR2);
                r1 = r0;
            }
            com_google_android_gms_internal_zzak_zza.zzlu = (zza[]) r5.toArray(new zza[0]);
            z = r1;
        } else if (obj instanceof Map) {
            com_google_android_gms_internal_zzak_zza.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                zza zzR3 = zzR(entry.getKey());
                zza zzR4 = zzR(entry.getValue());
                if (zzR3 == zzbIK || zzR4 == zzbIK) {
                    return zzbIK;
                }
                r0 = r1 || zzR3.zzlD || zzR4.zzlD;
                r5.add(zzR3);
                arrayList.add(zzR4);
                r1 = r0;
            }
            com_google_android_gms_internal_zzak_zza.zzlv = (zza[]) r5.toArray(new zza[0]);
            com_google_android_gms_internal_zzak_zza.zzlw = (zza[]) arrayList.toArray(new zza[0]);
            z = r1;
        } else if (zzS(obj)) {
            com_google_android_gms_internal_zzak_zza.type = 1;
            com_google_android_gms_internal_zzak_zza.string = obj.toString();
        } else if (zzT(obj)) {
            com_google_android_gms_internal_zzak_zza.type = 6;
            com_google_android_gms_internal_zzak_zza.zzlz = zzU(obj);
        } else if (obj instanceof Boolean) {
            com_google_android_gms_internal_zzak_zza.type = 8;
            com_google_android_gms_internal_zzak_zza.zzlA = ((Boolean) obj).booleanValue();
        } else {
            String str = "Converting to Value from unknown object type: ";
            String valueOf = String.valueOf(obj == null ? "null" : obj.getClass().toString());
            zzbo.m4711e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return zzbIK;
        }
        com_google_android_gms_internal_zzak_zza.zzlD = z;
        return com_google_android_gms_internal_zzak_zza;
    }

    public static Object zzRL() {
        return null;
    }

    public static Long zzRM() {
        return zzbID;
    }

    public static Double zzRN() {
        return zzbIE;
    }

    public static Boolean zzRO() {
        return zzbIH;
    }

    public static zzdk zzRP() {
        return zzbIF;
    }

    public static String zzRQ() {
        return zzbIG;
    }

    public static zza zzRR() {
        return zzbIK;
    }

    private static boolean zzS(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzdk) && ((zzdk) obj).zzRG());
    }

    private static boolean zzT(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzdk) && ((zzdk) obj).zzRH());
    }

    private static long zzU(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbo.m4711e("getInt64 received non-Number");
        return 0;
    }

    public static String zze(zza com_google_android_gms_internal_zzak_zza) {
        return zzM(zzj(com_google_android_gms_internal_zzak_zza));
    }

    public static zzdk zzf(zza com_google_android_gms_internal_zzak_zza) {
        return zzN(zzj(com_google_android_gms_internal_zzak_zza));
    }

    public static Long zzg(zza com_google_android_gms_internal_zzak_zza) {
        return zzO(zzj(com_google_android_gms_internal_zzak_zza));
    }

    public static Double zzh(zza com_google_android_gms_internal_zzak_zza) {
        return zzP(zzj(com_google_android_gms_internal_zzak_zza));
    }

    private static Boolean zzhA(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : zzbIH;
    }

    public static zza zzhw(String str) {
        zza com_google_android_gms_internal_zzak_zza = new zza();
        com_google_android_gms_internal_zzak_zza.type = 5;
        com_google_android_gms_internal_zzak_zza.zzly = str;
        return com_google_android_gms_internal_zzak_zza;
    }

    private static zzdk zzhx(String str) {
        try {
            return zzdk.zzhv(str);
        } catch (NumberFormatException e) {
            zzbo.m4711e(new StringBuilder(String.valueOf(str).length() + 33).append("Failed to convert '").append(str).append("' to a number.").toString());
            return zzbIF;
        }
    }

    private static Long zzhy(String str) {
        zzdk zzhx = zzhx(str);
        return zzhx == zzbIF ? zzbID : Long.valueOf(zzhx.longValue());
    }

    private static Double zzhz(String str) {
        zzdk zzhx = zzhx(str);
        return zzhx == zzbIF ? zzbIE : Double.valueOf(zzhx.doubleValue());
    }

    public static Boolean zzi(zza com_google_android_gms_internal_zzak_zza) {
        return zzQ(zzj(com_google_android_gms_internal_zzak_zza));
    }

    public static Object zzj(zza com_google_android_gms_internal_zzak_zza) {
        int i = 0;
        if (com_google_android_gms_internal_zzak_zza == null) {
            return null;
        }
        zza[] com_google_android_gms_internal_zzak_zzaArr;
        int length;
        switch (com_google_android_gms_internal_zzak_zza.type) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return com_google_android_gms_internal_zzak_zza.string;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                ArrayList arrayList = new ArrayList(com_google_android_gms_internal_zzak_zza.zzlu.length);
                com_google_android_gms_internal_zzak_zzaArr = com_google_android_gms_internal_zzak_zza.zzlu;
                length = com_google_android_gms_internal_zzak_zzaArr.length;
                while (i < length) {
                    Object zzj = zzj(com_google_android_gms_internal_zzak_zzaArr[i]);
                    if (zzj == null) {
                        return null;
                    }
                    arrayList.add(zzj);
                    i++;
                }
                return arrayList;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                if (com_google_android_gms_internal_zzak_zza.zzlv.length != com_google_android_gms_internal_zzak_zza.zzlw.length) {
                    String str = "Converting an invalid value to object: ";
                    String valueOf = String.valueOf(com_google_android_gms_internal_zzak_zza.toString());
                    zzbo.m4711e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return null;
                }
                Map hashMap = new HashMap(com_google_android_gms_internal_zzak_zza.zzlw.length);
                while (i < com_google_android_gms_internal_zzak_zza.zzlv.length) {
                    Object zzj2 = zzj(com_google_android_gms_internal_zzak_zza.zzlv[i]);
                    Object zzj3 = zzj(com_google_android_gms_internal_zzak_zza.zzlw[i]);
                    if (zzj2 == null || zzj3 == null) {
                        return null;
                    }
                    hashMap.put(zzj2, zzj3);
                    i++;
                }
                return hashMap;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                zzbo.m4711e("Trying to convert a macro reference to object");
                return null;
            case Type.OTHER_PROFILE /*5*/:
                zzbo.m4711e("Trying to convert a function id to object");
                return null;
            case Type.CONTRIBUTOR /*6*/:
                return Long.valueOf(com_google_android_gms_internal_zzak_zza.zzlz);
            case Type.WEBSITE /*7*/:
                StringBuffer stringBuffer = new StringBuffer();
                com_google_android_gms_internal_zzak_zzaArr = com_google_android_gms_internal_zzak_zza.zzlB;
                length = com_google_android_gms_internal_zzak_zzaArr.length;
                while (i < length) {
                    String zze = zze(com_google_android_gms_internal_zzak_zzaArr[i]);
                    if (zze == zzbIG) {
                        return null;
                    }
                    stringBuffer.append(zze);
                    i++;
                }
                return stringBuffer.toString();
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                return Boolean.valueOf(com_google_android_gms_internal_zzak_zza.zzlA);
            default:
                zzbo.m4711e("Failed to convert a value of type: " + com_google_android_gms_internal_zzak_zza.type);
                return null;
        }
    }
}
