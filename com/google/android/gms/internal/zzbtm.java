package com.google.android.gms.internal;

import android.content.Context;
import java.util.List;

public class zzbtm implements Runnable {
    private final Context mContext;
    private final List<byte[]> zzaIP;
    private final long zzcmf;

    public zzbtm(Context context, List<byte[]> list, long j) {
        this.mContext = context;
        this.zzaIP = list;
        this.zzcmf = j;
    }

    public void run() {
        zzblq.zza(this.mContext, "frc", this.zzaIP, 1, new zzblp(), this.zzcmf);
    }
}
