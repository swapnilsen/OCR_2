package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import com.google.android.gms.internal.zzbjf;
import com.google.android.gms.internal.zzbjf.zzc;
import com.google.android.gms.internal.zzbjf.zzd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class zzbh {
    private static zza zzK(Object obj) {
        return zzdl.zzR(zzL(obj));
    }

    static Object zzL(Object obj) {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, zzL(jSONObject.get(str)));
            }
            return hashMap;
        }
    }

    public static zzc zzhl(String str) {
        zza zzK = zzK(new JSONObject(str));
        zzd zzTy = zzc.zzTy();
        for (int i = 0; i < zzK.zzlv.length; i++) {
            zzTy.zzc(zzbjf.zza.zzTw().zzb(zzai.INSTANCE_NAME.toString(), zzK.zzlv[i]).zzb(zzai.FUNCTION.toString(), zzdl.zzhw(zzn.zzQd())).zzb(zzn.zzQe(), zzK.zzlw[i]).zzTx());
        }
        return zzTy.zzTA();
    }
}
