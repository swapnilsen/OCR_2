package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@zzme
public final class zzmk extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zzmk> CREATOR;
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final boolean zzKJ;
    public final String zzRA;
    public final String zzRB;
    public final String zzRC;
    public final Bundle zzRD;
    public final int zzRE;
    public final Bundle zzRF;
    public final boolean zzRG;
    public final int zzRH;
    public final int zzRI;
    public final String zzRJ;
    public final long zzRK;
    public final String zzRL;
    @Nullable
    public final List<String> zzRM;
    public final List<String> zzRN;
    public final long zzRO;
    public final zzmr zzRP;
    public final String zzRQ;
    public final float zzRR;
    public final int zzRS;
    public final int zzRT;
    public final boolean zzRU;
    public final boolean zzRV;
    public final String zzRW;
    public final boolean zzRX;
    public final String zzRY;
    public final int zzRZ;
    @Nullable
    public final Bundle zzRx;
    public final zzec zzRy;
    @Nullable
    public final PackageInfo zzRz;
    public final Bundle zzSa;
    public final String zzSb;
    public final boolean zzSc;
    public final Bundle zzSd;
    @Nullable
    public final String zzSe;
    @Nullable
    public final String zzSf;
    @Nullable
    public final String zzSg;
    @Nullable
    public final boolean zzSh;
    public final zzhc zzvF;
    @Nullable
    public final zzfc zzvH;
    public final List<String> zzvK;
    public final String zzvk;
    public final String zzvl;
    public final zzqh zzvn;
    public final zzeg zzvr;
    public final float zzxk;

    @zzme
    public static final class zza {
        public final ApplicationInfo applicationInfo;
        public final boolean zzKJ;
        public final String zzRB;
        public final String zzRC;
        public final Bundle zzRD;
        public final int zzRE;
        public final Bundle zzRF;
        public final boolean zzRG;
        public final int zzRH;
        public final int zzRI;
        public final String zzRJ;
        public final long zzRK;
        public final String zzRL;
        @Nullable
        public final List<String> zzRM;
        public final List<String> zzRN;
        public final String zzRQ;
        public final float zzRR;
        public final int zzRS;
        public final int zzRT;
        public final boolean zzRU;
        public final boolean zzRV;
        public final boolean zzRX;
        public final String zzRY;
        public final int zzRZ;
        @Nullable
        public final Bundle zzRx;
        public final zzec zzRy;
        @Nullable
        public final PackageInfo zzRz;
        public final Bundle zzSa;
        public final String zzSb;
        public final boolean zzSc;
        @Nullable
        public final Bundle zzSd;
        public final boolean zzSh;
        public final Future<zzmr> zzSi;
        public final Future<String> zzSj;
        public final Future<String> zzSk;
        public final zzhc zzvF;
        @Nullable
        public final zzfc zzvH;
        public final List<String> zzvK;
        public final String zzvk;
        public final String zzvl;
        public final zzqh zzvn;
        public final zzeg zzvr;
        public final float zzxk;

        public zza(@Nullable Bundle bundle, zzec com_google_android_gms_internal_zzec, zzeg com_google_android_gms_internal_zzeg, String str, ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, String str2, String str3, zzqh com_google_android_gms_internal_zzqh, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i, int i2, float f, String str4, long j, String str5, @Nullable List<String> list3, String str6, zzhc com_google_android_gms_internal_zzhc, Future<zzmr> future, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, Future<String> future2, String str8, boolean z5, int i5, Bundle bundle4, String str9, @Nullable zzfc com_google_android_gms_internal_zzfc, boolean z6, Bundle bundle5, boolean z7, Future<String> future3) {
            this.zzRx = bundle;
            this.zzRy = com_google_android_gms_internal_zzec;
            this.zzvr = com_google_android_gms_internal_zzeg;
            this.zzvl = str;
            this.applicationInfo = applicationInfo;
            this.zzRz = packageInfo;
            this.zzRB = str2;
            this.zzRC = str3;
            this.zzvn = com_google_android_gms_internal_zzqh;
            this.zzRD = bundle2;
            this.zzRG = z;
            this.zzRH = i;
            this.zzRI = i2;
            this.zzxk = f;
            if (list == null || list.size() <= 0) {
                this.zzRE = 0;
                this.zzvK = null;
                this.zzRN = null;
            } else {
                this.zzRE = 3;
                this.zzvK = list;
                this.zzRN = list2;
            }
            this.zzRF = bundle3;
            this.zzRJ = str4;
            this.zzRK = j;
            this.zzRL = str5;
            this.zzRM = list3;
            this.zzvk = str6;
            this.zzvF = com_google_android_gms_internal_zzhc;
            this.zzSi = future;
            this.zzRQ = str7;
            this.zzRR = f2;
            this.zzRX = z2;
            this.zzRS = i3;
            this.zzRT = i4;
            this.zzRU = z3;
            this.zzRV = z4;
            this.zzSj = future2;
            this.zzRY = str8;
            this.zzKJ = z5;
            this.zzRZ = i5;
            this.zzSa = bundle4;
            this.zzSb = str9;
            this.zzvH = com_google_android_gms_internal_zzfc;
            this.zzSc = z6;
            this.zzSd = bundle5;
            this.zzSh = z7;
            this.zzSk = future3;
        }
    }

    static {
        CREATOR = new zzml();
    }

    zzmk(int i, Bundle bundle, zzec com_google_android_gms_internal_zzec, zzeg com_google_android_gms_internal_zzeg, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzqh com_google_android_gms_internal_zzqh, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, zzhc com_google_android_gms_internal_zzhc, List<String> list3, long j2, zzmr com_google_android_gms_internal_zzmr, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4, String str11, zzfc com_google_android_gms_internal_zzfc, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7) {
        this.versionCode = i;
        this.zzRx = bundle;
        this.zzRy = com_google_android_gms_internal_zzec;
        this.zzvr = com_google_android_gms_internal_zzeg;
        this.zzvl = str;
        this.applicationInfo = applicationInfo;
        this.zzRz = packageInfo;
        this.zzRA = str2;
        this.zzRB = str3;
        this.zzRC = str4;
        this.zzvn = com_google_android_gms_internal_zzqh;
        this.zzRD = bundle2;
        this.zzRE = i2;
        this.zzvK = list;
        this.zzRN = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzRF = bundle3;
        this.zzRG = z;
        this.zzRH = i3;
        this.zzRI = i4;
        this.zzxk = f;
        this.zzRJ = str5;
        this.zzRK = j;
        this.zzRL = str6;
        this.zzRM = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzvk = str7;
        this.zzvF = com_google_android_gms_internal_zzhc;
        this.zzRO = j2;
        this.zzRP = com_google_android_gms_internal_zzmr;
        this.zzRQ = str8;
        this.zzRR = f2;
        this.zzRX = z2;
        this.zzRS = i5;
        this.zzRT = i6;
        this.zzRU = z3;
        this.zzRV = z4;
        this.zzRW = str9;
        this.zzRY = str10;
        this.zzKJ = z5;
        this.zzRZ = i7;
        this.zzSa = bundle4;
        this.zzSb = str11;
        this.zzvH = com_google_android_gms_internal_zzfc;
        this.zzSc = z6;
        this.zzSd = bundle5;
        this.zzSe = str12;
        this.zzSf = str13;
        this.zzSg = str14;
        this.zzSh = z7;
    }

    public zzmk(@Nullable Bundle bundle, zzec com_google_android_gms_internal_zzec, zzeg com_google_android_gms_internal_zzeg, String str, ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, String str2, String str3, String str4, zzqh com_google_android_gms_internal_zzqh, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, @Nullable List<String> list3, String str7, zzhc com_google_android_gms_internal_zzhc, long j2, zzmr com_google_android_gms_internal_zzmr, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, @Nullable zzfc com_google_android_gms_internal_zzfc, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7) {
        this(22, bundle, com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzeg, str, applicationInfo, packageInfo, str2, str3, str4, com_google_android_gms_internal_zzqh, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, com_google_android_gms_internal_zzhc, list2, j2, com_google_android_gms_internal_zzmr, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, com_google_android_gms_internal_zzfc, z6, bundle5, str12, str13, str14, z7);
    }

    public zzmk(zza com_google_android_gms_internal_zzmk_zza, long j, String str, String str2, String str3) {
        zzmr com_google_android_gms_internal_zzmr;
        Bundle bundle = com_google_android_gms_internal_zzmk_zza.zzRx;
        zzec com_google_android_gms_internal_zzec = com_google_android_gms_internal_zzmk_zza.zzRy;
        zzeg com_google_android_gms_internal_zzeg = com_google_android_gms_internal_zzmk_zza.zzvr;
        String str4 = com_google_android_gms_internal_zzmk_zza.zzvl;
        ApplicationInfo applicationInfo = com_google_android_gms_internal_zzmk_zza.applicationInfo;
        PackageInfo packageInfo = com_google_android_gms_internal_zzmk_zza.zzRz;
        String str5 = (String) zzql.zza(com_google_android_gms_internal_zzmk_zza.zzSk, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, 2, TimeUnit.SECONDS);
        String str6 = com_google_android_gms_internal_zzmk_zza.zzRB;
        String str7 = com_google_android_gms_internal_zzmk_zza.zzRC;
        zzqh com_google_android_gms_internal_zzqh = com_google_android_gms_internal_zzmk_zza.zzvn;
        Bundle bundle2 = com_google_android_gms_internal_zzmk_zza.zzRD;
        int i = com_google_android_gms_internal_zzmk_zza.zzRE;
        List list = com_google_android_gms_internal_zzmk_zza.zzvK;
        List list2 = com_google_android_gms_internal_zzmk_zza.zzRN;
        Bundle bundle3 = com_google_android_gms_internal_zzmk_zza.zzRF;
        boolean z = com_google_android_gms_internal_zzmk_zza.zzRG;
        int i2 = com_google_android_gms_internal_zzmk_zza.zzRH;
        int i3 = com_google_android_gms_internal_zzmk_zza.zzRI;
        float f = com_google_android_gms_internal_zzmk_zza.zzxk;
        String str8 = com_google_android_gms_internal_zzmk_zza.zzRJ;
        long j2 = com_google_android_gms_internal_zzmk_zza.zzRK;
        String str9 = com_google_android_gms_internal_zzmk_zza.zzRL;
        List list3 = com_google_android_gms_internal_zzmk_zza.zzRM;
        String str10 = com_google_android_gms_internal_zzmk_zza.zzvk;
        zzhc com_google_android_gms_internal_zzhc = com_google_android_gms_internal_zzmk_zza.zzvF;
        if (com_google_android_gms_internal_zzmk_zza.zzSi != null) {
            com_google_android_gms_internal_zzmr = (zzmr) zzql.zza(com_google_android_gms_internal_zzmk_zza.zzSi, null, 6, TimeUnit.SECONDS);
        } else {
            com_google_android_gms_internal_zzmr = null;
        }
        String str11 = com_google_android_gms_internal_zzmk_zza.zzRQ;
        float f2 = com_google_android_gms_internal_zzmk_zza.zzRR;
        boolean z2 = com_google_android_gms_internal_zzmk_zza.zzRX;
        int i4 = com_google_android_gms_internal_zzmk_zza.zzRS;
        int i5 = com_google_android_gms_internal_zzmk_zza.zzRT;
        boolean z3 = com_google_android_gms_internal_zzmk_zza.zzRU;
        boolean z4 = com_google_android_gms_internal_zzmk_zza.zzRV;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long j3 = j;
        String str12 = str;
        String str13 = str2;
        String str14 = str3;
        this(bundle, com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzeg, str4, applicationInfo, packageInfo, str5, str6, str7, com_google_android_gms_internal_zzqh, bundle2, i, list, list2, bundle3, z, i2, i3, f, str8, j2, str9, list3, str10, com_google_android_gms_internal_zzhc, j3, com_google_android_gms_internal_zzmr, r0, r0, r0, r0, r0, r0, r0, (String) zzql.zza(com_google_android_gms_internal_zzmk_zza.zzSj, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, 1, r31), com_google_android_gms_internal_zzmk_zza.zzRY, com_google_android_gms_internal_zzmk_zza.zzKJ, com_google_android_gms_internal_zzmk_zza.zzRZ, com_google_android_gms_internal_zzmk_zza.zzSa, com_google_android_gms_internal_zzmk_zza.zzSb, com_google_android_gms_internal_zzmk_zza.zzvH, com_google_android_gms_internal_zzmk_zza.zzSc, com_google_android_gms_internal_zzmk_zza.zzSd, str12, str13, str14, com_google_android_gms_internal_zzmk_zza.zzSh);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzml.zza(this, parcel, i);
    }
}
