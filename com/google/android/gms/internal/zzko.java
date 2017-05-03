package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.zza;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Date;
import java.util.HashSet;
import net.nend.android.NendIconError;

@zzme
public final class zzko {

    /* renamed from: com.google.android.gms.internal.zzko.1 */
    static /* synthetic */ class C12801 {
        static final /* synthetic */ int[] zzLM;
        static final /* synthetic */ int[] zzLN;

        static {
            zzLN = new int[ErrorCode.values().length];
            try {
                zzLN[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzLN[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzLN[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzLN[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            zzLM = new int[Gender.values().length];
            try {
                zzLM[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                zzLM[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                zzLM[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static Gender zzI(int i) {
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return Gender.MALE;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static int zza(ErrorCode errorCode) {
        switch (C12801.zzLN[errorCode.ordinal()]) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return 1;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return 2;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize zzc(zzeg com_google_android_gms_internal_zzeg) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < 6) {
            if (adSizeArr[i].getWidth() == com_google_android_gms_internal_zzeg.width && adSizeArr[i].getHeight() == com_google_android_gms_internal_zzeg.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(zza.zza(com_google_android_gms_internal_zzeg.width, com_google_android_gms_internal_zzeg.height, com_google_android_gms_internal_zzeg.zzzy));
    }

    public static MediationAdRequest zzr(zzec com_google_android_gms_internal_zzec) {
        return new MediationAdRequest(new Date(com_google_android_gms_internal_zzec.zzyT), zzI(com_google_android_gms_internal_zzec.zzyU), com_google_android_gms_internal_zzec.zzyV != null ? new HashSet(com_google_android_gms_internal_zzec.zzyV) : null, com_google_android_gms_internal_zzec.zzyW, com_google_android_gms_internal_zzec.zzzb);
    }
}
