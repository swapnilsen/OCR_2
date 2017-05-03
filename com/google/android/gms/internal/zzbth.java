package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.C1488a;
import com.google.firebase.C1489c;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzbth {
    private static final AtomicReference<zzbth> zzbWM;

    static {
        zzbWM = new AtomicReference();
    }

    zzbth(Context context) {
    }

    @Nullable
    public static zzbth zzabY() {
        return (zzbth) zzbWM.get();
    }

    public static zzbth zzcw(Context context) {
        zzbWM.compareAndSet(null, new zzbth(context));
        return (zzbth) zzbWM.get();
    }

    public Set<String> zzabZ() {
        return Collections.emptySet();
    }

    public void zzg(@NonNull C1488a c1488a) {
    }

    public C1489c zzjC(@NonNull String str) {
        return null;
    }
}
