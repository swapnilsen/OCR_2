package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@zzme
public class zzga {
    private final Collection<zzfz> zzAZ;
    private final Collection<zzfz<String>> zzBa;
    private final Collection<zzfz<String>> zzBb;

    public zzga() {
        this.zzAZ = new ArrayList();
        this.zzBa = new ArrayList();
        this.zzBb = new ArrayList();
    }

    public void zza(zzfz com_google_android_gms_internal_zzfz) {
        this.zzAZ.add(com_google_android_gms_internal_zzfz);
    }

    public void zzb(zzfz<String> com_google_android_gms_internal_zzfz_java_lang_String) {
        this.zzBa.add(com_google_android_gms_internal_zzfz_java_lang_String);
    }

    public void zzc(zzfz<String> com_google_android_gms_internal_zzfz_java_lang_String) {
        this.zzBb.add(com_google_android_gms_internal_zzfz_java_lang_String);
    }

    public List<String> zzfs() {
        List<String> arrayList = new ArrayList();
        for (zzfz com_google_android_gms_internal_zzfz : this.zzBa) {
            String str = (String) com_google_android_gms_internal_zzfz.get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public List<String> zzft() {
        List<String> zzfs = zzfs();
        for (zzfz com_google_android_gms_internal_zzfz : this.zzBb) {
            String str = (String) com_google_android_gms_internal_zzfz.get();
            if (str != null) {
                zzfs.add(str);
            }
        }
        return zzfs;
    }
}
