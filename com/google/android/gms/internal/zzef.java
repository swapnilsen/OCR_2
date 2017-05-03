package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@zzme
public class zzef {
    public static final zzef zzzx;

    static {
        zzzx = new zzef();
    }

    protected zzef() {
    }

    public static zzef zzeD() {
        return zzzx;
    }

    public zzec zza(Context context, zzfe com_google_android_gms_internal_zzfe) {
        Date birthday = com_google_android_gms_internal_zzfe.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = com_google_android_gms_internal_zzfe.getContentUrl();
        int gender = com_google_android_gms_internal_zzfe.getGender();
        Collection keywords = com_google_android_gms_internal_zzfe.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = com_google_android_gms_internal_zzfe.isTestDevice(context);
        int zzff = com_google_android_gms_internal_zzfe.zzff();
        Location location = com_google_android_gms_internal_zzfe.getLocation();
        Bundle networkExtrasBundle = com_google_android_gms_internal_zzfe.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = com_google_android_gms_internal_zzfe.getManualImpressionsEnabled();
        String publisherProvidedId = com_google_android_gms_internal_zzfe.getPublisherProvidedId();
        SearchAdRequest zzfc = com_google_android_gms_internal_zzfe.zzfc();
        zzfp com_google_android_gms_internal_zzfp = zzfc != null ? new zzfp(zzfc) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = zzel.zzeT().zza(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new zzec(7, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzff, manualImpressionsEnabled, publisherProvidedId, com_google_android_gms_internal_zzfp, location, contentUrl, com_google_android_gms_internal_zzfe.zzfe(), com_google_android_gms_internal_zzfe.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(com_google_android_gms_internal_zzfe.zzfg())), com_google_android_gms_internal_zzfe.zzfb(), str, com_google_android_gms_internal_zzfe.isDesignedForFamilies());
    }

    public zzoa zza(Context context, zzfe com_google_android_gms_internal_zzfe, String str) {
        return new zzoa(zza(context, com_google_android_gms_internal_zzfe), str);
    }
}
