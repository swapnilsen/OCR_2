package com.google.android.exoplayer2.p052c.p053a;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.a.c */
final class ScriptTagPayloadReader extends TagPayloadReader {
    private long f2544b;

    public ScriptTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        this.f2544b = -9223372036854775807L;
    }

    public long m3153a() {
        return this.f2544b;
    }

    protected boolean m3155a(ParsableByteArray parsableByteArray) {
        return true;
    }

    protected void m3154a(ParsableByteArray parsableByteArray, long j) {
        if (ScriptTagPayloadReader.m3145b(parsableByteArray) != 2) {
            throw new ParserException();
        }
        if (!"onMetaData".equals(ScriptTagPayloadReader.m3148e(parsableByteArray))) {
            return;
        }
        if (ScriptTagPayloadReader.m3145b(parsableByteArray) != 8) {
            throw new ParserException();
        }
        Map h = ScriptTagPayloadReader.m3151h(parsableByteArray);
        if (h.containsKey("duration")) {
            double doubleValue = ((Double) h.get("duration")).doubleValue();
            if (doubleValue > 0.0d) {
                this.f2544b = (long) (doubleValue * 1000000.0d);
            }
        }
    }

    private static int m3145b(ParsableByteArray parsableByteArray) {
        return parsableByteArray.m4461g();
    }

    private static Boolean m3146c(ParsableByteArray parsableByteArray) {
        boolean z = true;
        if (parsableByteArray.m4461g() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static Double m3147d(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.m4470p()));
    }

    private static String m3148e(ParsableByteArray parsableByteArray) {
        int h = parsableByteArray.m4462h();
        int d = parsableByteArray.m4456d();
        parsableByteArray.m4457d(h);
        return new String(parsableByteArray.f3831a, d, h);
    }

    private static ArrayList<Object> m3149f(ParsableByteArray parsableByteArray) {
        int t = parsableByteArray.m4474t();
        ArrayList<Object> arrayList = new ArrayList(t);
        for (int i = 0; i < t; i++) {
            arrayList.add(ScriptTagPayloadReader.m3144a(parsableByteArray, ScriptTagPayloadReader.m3145b(parsableByteArray)));
        }
        return arrayList;
    }

    private static HashMap<String, Object> m3150g(ParsableByteArray parsableByteArray) {
        HashMap<String, Object> hashMap = new HashMap();
        while (true) {
            String e = ScriptTagPayloadReader.m3148e(parsableByteArray);
            int b = ScriptTagPayloadReader.m3145b(parsableByteArray);
            if (b == 9) {
                return hashMap;
            }
            hashMap.put(e, ScriptTagPayloadReader.m3144a(parsableByteArray, b));
        }
    }

    private static HashMap<String, Object> m3151h(ParsableByteArray parsableByteArray) {
        int t = parsableByteArray.m4474t();
        HashMap<String, Object> hashMap = new HashMap(t);
        for (int i = 0; i < t; i++) {
            hashMap.put(ScriptTagPayloadReader.m3148e(parsableByteArray), ScriptTagPayloadReader.m3144a(parsableByteArray, ScriptTagPayloadReader.m3145b(parsableByteArray)));
        }
        return hashMap;
    }

    private static Date m3152i(ParsableByteArray parsableByteArray) {
        Date date = new Date((long) ScriptTagPayloadReader.m3147d(parsableByteArray).doubleValue());
        parsableByteArray.m4457d(2);
        return date;
    }

    private static Object m3144a(ParsableByteArray parsableByteArray, int i) {
        switch (i) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return ScriptTagPayloadReader.m3147d(parsableByteArray);
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return ScriptTagPayloadReader.m3146c(parsableByteArray);
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return ScriptTagPayloadReader.m3148e(parsableByteArray);
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return ScriptTagPayloadReader.m3150g(parsableByteArray);
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                return ScriptTagPayloadReader.m3151h(parsableByteArray);
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                return ScriptTagPayloadReader.m3149f(parsableByteArray);
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return ScriptTagPayloadReader.m3152i(parsableByteArray);
            default:
                return null;
        }
    }
}
