package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzbjg {
    public static final Integer zzbNn;
    public static final Integer zzbNo;
    private final Context mContext;
    private final ExecutorService zzbtI;

    static {
        zzbNn = Integer.valueOf(0);
        zzbNo = Integer.valueOf(1);
    }

    public zzbjg(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzbjg(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzbtI = executorService;
    }
}
