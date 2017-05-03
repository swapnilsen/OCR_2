package com.google.android.exoplayer2.p052c.p056d;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import java.util.UUID;

/* renamed from: com.google.android.exoplayer2.c.d.g */
public final class PsshAtomUtil {
    public static UUID m3410a(byte[] bArr) {
        Pair b = PsshAtomUtil.m3411b(bArr);
        if (b == null) {
            return null;
        }
        return (UUID) b.first;
    }

    private static Pair<UUID, byte[]> m3411b(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.m4454c() < 32) {
            return null;
        }
        parsableByteArray.m4455c(0);
        if (parsableByteArray.m4468n() != parsableByteArray.m4452b() + 4 || parsableByteArray.m4468n() != Atom.f2727T) {
            return null;
        }
        int a = Atom.m3310a(parsableByteArray.m4468n());
        if (a > 1) {
            Log.w("PsshAtomUtil", "Unsupported pssh version: " + a);
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.m4470p(), parsableByteArray.m4470p());
        if (a == 1) {
            parsableByteArray.m4457d(parsableByteArray.m4474t() * 16);
        }
        a = parsableByteArray.m4474t();
        if (a != parsableByteArray.m4452b()) {
            return null;
        }
        Object obj = new byte[a];
        parsableByteArray.m4451a(obj, 0, a);
        return Pair.create(uuid, obj);
    }
}
