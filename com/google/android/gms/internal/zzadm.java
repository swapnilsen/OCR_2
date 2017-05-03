package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzadm {
    static AppMeasurement zzbj(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    public static List<zzadk> zzbk(Context context) {
        AppMeasurement zzbj = zzbj(context);
        if (zzbj != null) {
            Map zzaJ;
            try {
                zzaJ = zzbj.zzaJ(false);
            } catch (Throwable e) {
                if (Log.isLoggable("FRCAnalytics", 3)) {
                    Log.d("FRCAnalytics", "Unable to get user properties.", e);
                }
                zzaJ = null;
            }
            if (zzaJ == null) {
                return null;
            }
            List<zzadk> arrayList = new ArrayList();
            for (Entry entry : zzaJ.entrySet()) {
                if (entry.getValue() != null) {
                    arrayList.add(new zzadk((String) entry.getKey(), entry.getValue().toString()));
                }
            }
            return arrayList;
        } else if (!Log.isLoggable("FRCAnalytics", 3)) {
            return null;
        } else {
            Log.d("FRCAnalytics", "Unable to get user properties: analytics library is missing.");
            return null;
        }
    }
}
