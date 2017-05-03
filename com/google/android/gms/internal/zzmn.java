package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.List;

@zzme
public final class zzmn extends zza {
    public static final Creator<zzmn> CREATOR;
    public String body;
    public final int errorCode;
    public final int orientation;
    public final int versionCode;
    public final List<String> zzKF;
    public final List<String> zzKG;
    public final List<String> zzKI;
    public final boolean zzKJ;
    public final long zzKL;
    private zzmk zzLo;
    public final String zzNJ;
    public final boolean zzRG;
    public final boolean zzRV;
    @Nullable
    public String zzRW;
    public String zzSA;
    public final String zzSB;
    @Nullable
    public final zzoo zzSC;
    @Nullable
    public final List<String> zzSD;
    @Nullable
    public final List<String> zzSE;
    public final boolean zzSF;
    @Nullable
    public final zzmp zzSG;
    @Nullable
    public final String zzSH;
    @Nullable
    public final zzor zzSI;
    @Nullable
    public final String zzSJ;
    public final boolean zzSK;
    public final boolean zzSh;
    public final long zzSm;
    public final boolean zzSn;
    public final long zzSo;
    public final List<String> zzSp;
    public final String zzSq;
    public final long zzSr;
    public final String zzSs;
    public final boolean zzSt;
    public final String zzSu;
    public final String zzSv;
    public final boolean zzSw;
    public final boolean zzSx;
    public final boolean zzSy;
    public zzmv zzSz;
    public final boolean zzzB;
    public final boolean zzzC;
    public final boolean zzzD;

    static {
        CREATOR = new zzmo();
    }

    public zzmn(int i) {
        this(19, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false);
    }

    public zzmn(int i, long j) {
        this(19, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false);
    }

    zzmn(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, zzmv com_google_android_gms_internal_zzmv, String str7, String str8, boolean z8, boolean z9, zzoo com_google_android_gms_internal_zzoo, List<String> list4, List<String> list5, boolean z10, zzmp com_google_android_gms_internal_zzmp, boolean z11, String str9, List<String> list6, boolean z12, String str10, zzor com_google_android_gms_internal_zzor, String str11, boolean z13, boolean z14) {
        this.versionCode = i;
        this.zzNJ = str;
        this.body = str2;
        this.zzKF = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzKG = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzSm = j;
        this.zzSn = z;
        this.zzSo = j2;
        this.zzSp = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzKL = j3;
        this.orientation = i3;
        this.zzSq = str3;
        this.zzSr = j4;
        this.zzSs = str4;
        this.zzSt = z2;
        this.zzSu = str5;
        this.zzSv = str6;
        this.zzSw = z3;
        this.zzzB = z4;
        this.zzRG = z5;
        this.zzSx = z6;
        this.zzSK = z13;
        this.zzSy = z7;
        this.zzSz = com_google_android_gms_internal_zzmv;
        this.zzSA = str7;
        this.zzSB = str8;
        if (this.body == null && this.zzSz != null) {
            zzmy com_google_android_gms_internal_zzmy = (zzmy) this.zzSz.zza(zzmy.CREATOR);
            if (!(com_google_android_gms_internal_zzmy == null || TextUtils.isEmpty(com_google_android_gms_internal_zzmy.zzjt()))) {
                this.body = com_google_android_gms_internal_zzmy.zzjt();
            }
        }
        this.zzzC = z8;
        this.zzzD = z9;
        this.zzSC = com_google_android_gms_internal_zzoo;
        this.zzSD = list4;
        this.zzSE = list5;
        this.zzSF = z10;
        this.zzSG = com_google_android_gms_internal_zzmp;
        this.zzRV = z11;
        this.zzRW = str9;
        this.zzKI = list6;
        this.zzKJ = z12;
        this.zzSH = str10;
        this.zzSI = com_google_android_gms_internal_zzor;
        this.zzSJ = str11;
        this.zzSh = z14;
    }

    public zzmn(zzmk com_google_android_gms_internal_zzmk, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, zzoo com_google_android_gms_internal_zzoo, List<String> list4, List<String> list5, boolean z9, zzmp com_google_android_gms_internal_zzmp, boolean z10, String str7, List<String> list6, boolean z11, String str8, zzor com_google_android_gms_internal_zzor, String str9, boolean z12, boolean z13) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6, null, null, str6, z7, z8, com_google_android_gms_internal_zzoo, list4, list5, z9, com_google_android_gms_internal_zzmp, z10, str7, list6, z11, str8, com_google_android_gms_internal_zzor, str9, z12, z13);
        this.zzLo = com_google_android_gms_internal_zzmk;
    }

    public zzmn(zzmk com_google_android_gms_internal_zzmk, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, zzoo com_google_android_gms_internal_zzoo, List<String> list4, List<String> list5, boolean z10, zzmp com_google_android_gms_internal_zzmp, boolean z11, String str8, List<String> list6, boolean z12, String str9, zzor com_google_android_gms_internal_zzor, String str10, boolean z13, boolean z14) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, com_google_android_gms_internal_zzoo, list4, list5, z10, com_google_android_gms_internal_zzmp, z11, str8, list6, z12, str9, com_google_android_gms_internal_zzor, str10, z13, z14);
        this.zzLo = com_google_android_gms_internal_zzmk;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (!(this.zzLo == null || this.zzLo.versionCode < 9 || TextUtils.isEmpty(this.body))) {
            this.zzSz = new zzmv(new zzmy(this.body));
            this.body = null;
        }
        zzmo.zza(this, parcel, i);
    }
}
