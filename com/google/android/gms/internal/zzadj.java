package com.google.android.gms.internal;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class zzadj extends CommonStatusCodes {
    public static String getStatusCodeString(int i) {
        switch (i) {
            case -6508:
                return "SUCCESS_CACHE_STALE";
            case -6506:
                return "SUCCESS_CACHE";
            case -6505:
                return "SUCCESS_FRESH";
            case 6500:
                return "NOT_AUTHORIZED_TO_FETCH";
            case 6501:
                return "ANOTHER_FETCH_INFLIGHT";
            case 6502:
                return "FETCH_THROTTLED";
            case 6503:
                return "NOT_AVAILABLE";
            case 6504:
                return "FAILURE_CACHE";
            case 6507:
                return "FETCH_THROTTLED_STALE";
            default:
                return CommonStatusCodes.getStatusCodeString(i);
        }
    }
}
