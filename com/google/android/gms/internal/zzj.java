package com.google.android.gms.internal;

import com.google.api.client.http.HttpStatusCodes;
import java.util.Map;

public class zzj {
    public final byte[] data;
    public final int statusCode;
    public final boolean zzA;
    public final long zzB;
    public final Map<String, String> zzz;

    public zzj(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzz = map;
        this.zzA = z;
        this.zzB = j;
    }

    public zzj(byte[] bArr, Map<String, String> map) {
        this(HttpStatusCodes.STATUS_CODE_OK, bArr, map, false, 0);
    }
}
