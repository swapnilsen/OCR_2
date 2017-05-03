package com.google.android.gms.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

@zzme
public class zzdm {
    private final boolean zzyA;
    private final int zzyB;
    private final int zzyC;
    private final int zzyo;
    private final zzdg zzyq;
    private String zzyy;
    private String zzyz;

    public class zza implements Comparator<zzdf> {
        public zza(zzdm com_google_android_gms_internal_zzdm) {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((zzdf) obj, (zzdf) obj2);
        }

        public int zza(zzdf com_google_android_gms_internal_zzdf, zzdf com_google_android_gms_internal_zzdf2) {
            if (com_google_android_gms_internal_zzdf.zzep() < com_google_android_gms_internal_zzdf2.zzep()) {
                return -1;
            }
            if (com_google_android_gms_internal_zzdf.zzep() > com_google_android_gms_internal_zzdf2.zzep()) {
                return 1;
            }
            if (com_google_android_gms_internal_zzdf.zzeo() < com_google_android_gms_internal_zzdf2.zzeo()) {
                return -1;
            }
            if (com_google_android_gms_internal_zzdf.zzeo() > com_google_android_gms_internal_zzdf2.zzeo()) {
                return 1;
            }
            float zzer = (com_google_android_gms_internal_zzdf.zzer() - com_google_android_gms_internal_zzdf.zzep()) * (com_google_android_gms_internal_zzdf.zzeq() - com_google_android_gms_internal_zzdf.zzeo());
            float zzer2 = (com_google_android_gms_internal_zzdf2.zzer() - com_google_android_gms_internal_zzdf2.zzep()) * (com_google_android_gms_internal_zzdf2.zzeq() - com_google_android_gms_internal_zzdf2.zzeo());
            return zzer <= zzer2 ? zzer < zzer2 ? 1 : 0 : -1;
        }
    }

    public zzdm(int i, int i2, int i3) {
        this.zzyo = i;
        this.zzyA = false;
        if (i2 > 64 || i2 < 0) {
            this.zzyB = 64;
        } else {
            this.zzyB = i2;
        }
        if (i3 < 1) {
            this.zzyC = 1;
        } else {
            this.zzyC = i3;
        }
        this.zzyq = new zzdl(this.zzyB);
    }

    String zza(String str, char c) {
        StringBuilder stringBuilder = new StringBuilder(str);
        Object obj = null;
        int i = 1;
        while (i + 2 <= stringBuilder.length()) {
            if (stringBuilder.charAt(i) == '\'') {
                if (stringBuilder.charAt(i - 1) == c || !((stringBuilder.charAt(i + 1) == 's' || stringBuilder.charAt(i + 1) == 'S') && (i + 2 == stringBuilder.length() || stringBuilder.charAt(i + 2) == c))) {
                    stringBuilder.setCharAt(i, c);
                } else {
                    stringBuilder.insert(i, c);
                    i += 2;
                }
                obj = 1;
            }
            i++;
        }
        return obj != null ? stringBuilder.toString() : null;
    }

    public String zza(ArrayList<String> arrayList, ArrayList<zzdf> arrayList2) {
        Collections.sort(arrayList2, new zza(this));
        HashSet hashSet = new HashSet();
        int i = 0;
        while (i < arrayList2.size() && zza(Normalizer.normalize((CharSequence) arrayList.get(((zzdf) arrayList2.get(i)).zzes()), Form.NFKC).toLowerCase(Locale.US), hashSet)) {
            i++;
        }
        zza com_google_android_gms_internal_zzdh_zza = new zza();
        this.zzyy = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                com_google_android_gms_internal_zzdh_zza.write(this.zzyq.zzF((String) it.next()));
            } catch (Throwable e) {
                zzqf.zzb("Error while writing hash to byteStream", e);
            }
        }
        return com_google_android_gms_internal_zzdh_zza.toString();
    }

    boolean zza(String str, HashSet<String> hashSet) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return true;
        }
        for (String str2 : split) {
            String str22;
            String zza;
            String[] zzd;
            int i;
            Object obj;
            int i2;
            boolean z;
            if (str22.indexOf("'") != -1) {
                zza = zza(str22, ' ');
                if (zza != null) {
                    this.zzyz = zza;
                    zzd = zzdi.zzd(zza, true);
                    if (zzd.length < this.zzyC) {
                        for (i = 0; i < zzd.length; i++) {
                            obj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
                            for (i2 = 0; i2 < this.zzyC; i2++) {
                                if (i + i2 < zzd.length) {
                                    z = false;
                                    break;
                                }
                                if (i2 > 0) {
                                    obj = String.valueOf(obj).concat(" ");
                                }
                                String valueOf = String.valueOf(obj);
                                str22 = String.valueOf(zzd[i + i2]);
                                obj = str22.length() == 0 ? valueOf.concat(str22) : new String(valueOf);
                            }
                            z = true;
                            if (z) {
                                break;
                            }
                            hashSet.add(obj);
                            if (hashSet.size() < this.zzyo) {
                                return false;
                            }
                        }
                        if (hashSet.size() < this.zzyo) {
                            return false;
                        }
                    }
                }
            }
            zza = str22;
            zzd = zzdi.zzd(zza, true);
            if (zzd.length < this.zzyC) {
                while (i < zzd.length) {
                    obj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
                    while (i2 < this.zzyC) {
                        if (i + i2 < zzd.length) {
                            if (i2 > 0) {
                                obj = String.valueOf(obj).concat(" ");
                            }
                            String valueOf2 = String.valueOf(obj);
                            str22 = String.valueOf(zzd[i + i2]);
                            if (str22.length() == 0) {
                            }
                        } else {
                            z = false;
                            break;
                            if (z) {
                                break;
                                if (hashSet.size() < this.zzyo) {
                                    return false;
                                }
                            } else {
                                hashSet.add(obj);
                                if (hashSet.size() < this.zzyo) {
                                    return false;
                                }
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        break;
                        if (hashSet.size() < this.zzyo) {
                            return false;
                        }
                    } else {
                        hashSet.add(obj);
                        if (hashSet.size() < this.zzyo) {
                            return false;
                        }
                    }
                }
                if (hashSet.size() < this.zzyo) {
                    return false;
                }
            }
        }
        return true;
    }
}
