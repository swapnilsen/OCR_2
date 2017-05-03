package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0902R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.internal.zzadg;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public final class zzh {
    private static final SimpleArrayMap<String, String> zzaFE;

    static {
        zzaFE = new SimpleArrayMap();
    }

    @Nullable
    private static String zzB(Context context, String str) {
        synchronized (zzaFE) {
            String str2 = (String) zzaFE.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            if (identifier == 0) {
                String str3 = "GoogleApiAvailability";
                String str4 = "Missing resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            Object string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            zzaFE.put(str, string);
            return string;
        }
    }

    public static String zzaT(Context context) {
        String str = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
            try {
                str = zzadg.zzbi(context).zzdA(context.getPackageName()).toString();
            } catch (NameNotFoundException e) {
            }
        }
        return str;
    }

    @Nullable
    public static String zzg(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return resources.getString(C0902R.string.common_google_play_services_install_title);
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return resources.getString(C0902R.string.common_google_play_services_update_title);
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return resources.getString(C0902R.string.common_google_play_services_enable_title);
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
            case Type.CONTRIBUTOR /*6*/:
            case CommonStatusCodes.DEAD_CLIENT /*18*/:
                return null;
            case Type.OTHER_PROFILE /*5*/:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zzB(context, "common_google_play_services_invalid_account_title");
            case Type.WEBSITE /*7*/:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zzB(context, "common_google_play_services_network_error_title");
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case ConnectionResult.SERVICE_INVALID /*9*/:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case CommonStatusCodes.CANCELED /*16*/:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zzB(context, "common_google_play_services_sign_in_failed_title");
            case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zzB(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    @NonNull
    public static String zzh(Context context, int i) {
        String zzB = i == 6 ? zzB(context, "common_google_play_services_resolution_required_title") : zzg(context, i);
        return zzB == null ? context.getResources().getString(C0902R.string.common_google_play_services_notification_ticker) : zzB;
    }

    @NonNull
    public static String zzi(Context context, int i) {
        Resources resources = context.getResources();
        String zzaT = zzaT(context);
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return resources.getString(C0902R.string.common_google_play_services_install_text, new Object[]{zzaT});
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                if (zzj.zzba(context)) {
                    return resources.getString(C0902R.string.common_google_play_services_wear_update_text);
                }
                return resources.getString(C0902R.string.common_google_play_services_update_text, new Object[]{zzaT});
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return resources.getString(C0902R.string.common_google_play_services_enable_text, new Object[]{zzaT});
            case Type.OTHER_PROFILE /*5*/:
                return zzo(context, "common_google_play_services_invalid_account_text", zzaT);
            case Type.WEBSITE /*7*/:
                return zzo(context, "common_google_play_services_network_error_text", zzaT);
            case ConnectionResult.SERVICE_INVALID /*9*/:
                return resources.getString(C0902R.string.common_google_play_services_unsupported_text, new Object[]{zzaT});
            case CommonStatusCodes.CANCELED /*16*/:
                return zzo(context, "common_google_play_services_api_unavailable_text", zzaT);
            case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                return zzo(context, "common_google_play_services_sign_in_failed_text", zzaT);
            case CommonStatusCodes.DEAD_CLIENT /*18*/:
                return resources.getString(C0902R.string.common_google_play_services_updating_text, new Object[]{zzaT});
            case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                return zzo(context, "common_google_play_services_restricted_profile_text", zzaT);
            default:
                return resources.getString(C0902R.string.common_google_play_services_unknown_issue, new Object[]{zzaT});
        }
    }

    @NonNull
    public static String zzj(Context context, int i) {
        return i == 6 ? zzo(context, "common_google_play_services_resolution_required_text", zzaT(context)) : zzi(context, i);
    }

    @NonNull
    public static String zzk(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return resources.getString(C0902R.string.common_google_play_services_install_button);
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return resources.getString(C0902R.string.common_google_play_services_update_button);
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return resources.getString(C0902R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    private static String zzo(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zzB = zzB(context, str);
        if (zzB == null) {
            zzB = resources.getString(C0902R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zzB, new Object[]{str2});
    }
}
