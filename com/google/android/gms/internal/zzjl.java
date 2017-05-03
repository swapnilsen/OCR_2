package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzme
public class zzjl implements zzjk {
    private final zzjj zzKl;
    private final HashSet<SimpleEntry<String, zzid>> zzKm;

    public zzjl(zzjj com_google_android_gms_internal_zzjj) {
        this.zzKl = com_google_android_gms_internal_zzjj;
        this.zzKm = new HashSet();
    }

    public void zza(String str, zzid com_google_android_gms_internal_zzid) {
        this.zzKl.zza(str, com_google_android_gms_internal_zzid);
        this.zzKm.add(new SimpleEntry(str, com_google_android_gms_internal_zzid));
    }

    public void zza(String str, JSONObject jSONObject) {
        this.zzKl.zza(str, jSONObject);
    }

    public void zzb(String str, zzid com_google_android_gms_internal_zzid) {
        this.zzKl.zzb(str, com_google_android_gms_internal_zzid);
        this.zzKm.remove(new SimpleEntry(str, com_google_android_gms_internal_zzid));
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzKl.zzb(str, jSONObject);
    }

    public void zzgT() {
        Iterator it = this.zzKm.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            String str = "Unregistering eventhandler: ";
            String valueOf = String.valueOf(((zzid) simpleEntry.getValue()).toString());
            zzpk.m4709v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.zzKl.zzb((String) simpleEntry.getKey(), (zzid) simpleEntry.getValue());
        }
        this.zzKm.clear();
    }

    public void zzj(String str, String str2) {
        this.zzKl.zzj(str, str2);
    }
}
