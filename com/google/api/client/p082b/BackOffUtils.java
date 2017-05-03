package com.google.api.client.p082b;

/* renamed from: com.google.api.client.b.d */
public final class BackOffUtils {
    public static boolean m4883a(ac acVar, BackOff backOff) {
        long a = backOff.m4880a();
        if (a == -1) {
            return false;
        }
        acVar.m4850a(a);
        return true;
    }
}
