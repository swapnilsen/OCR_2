package com.google.firebase;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;

/* renamed from: com.google.firebase.b */
public class C1130b extends Exception {
    @Deprecated
    protected C1130b() {
    }

    public C1130b(@NonNull String str) {
        super(zzac.zzh(str, "Detail message must not be empty"));
    }

    public C1130b(@NonNull String str, Throwable th) {
        super(zzac.zzh(str, "Detail message must not be empty"), th);
    }
}
