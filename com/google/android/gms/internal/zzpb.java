package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzme
public class zzpb {
    public final int errorCode;
    public final int orientation;
    public final List<String> zzKF;
    public final List<String> zzKG;
    @Nullable
    public final List<String> zzKI;
    public final long zzKL;
    @Nullable
    public final zzjq zzLi;
    @Nullable
    public final zzkb zzLj;
    @Nullable
    public final String zzLk;
    @Nullable
    public final zzjt zzLl;
    @Nullable
    public final zzqw zzNH;
    public final String zzRB;
    public final zzec zzRy;
    @Nullable
    public final zzoo zzSC;
    @Nullable
    public final List<String> zzSE;
    public final boolean zzSF;
    public final zzmp zzSG;
    public final String zzSJ;
    public final long zzSm;
    public final boolean zzSn;
    public final long zzSo;
    public final List<String> zzSp;
    public final String zzSs;
    public final JSONObject zzWa;
    public boolean zzWb;
    public final zzjr zzWc;
    @Nullable
    public final String zzWd;
    public final zzeg zzWe;
    @Nullable
    public final List<String> zzWf;
    public final long zzWg;
    public final long zzWh;
    @Nullable
    public final com.google.android.gms.internal.zzha.zza zzWi;
    public boolean zzWj;
    public boolean zzWk;
    public boolean zzWl;

    @zzme
    public static final class zza {
        public final int errorCode;
        public final zzmk zzTi;
        @Nullable
        public final JSONObject zzWa;
        public final zzjr zzWc;
        public final long zzWg;
        public final long zzWh;
        public final zzmn zzWm;
        @Nullable
        public final zzeg zzvr;

        public zza(zzmk com_google_android_gms_internal_zzmk, zzmn com_google_android_gms_internal_zzmn, zzjr com_google_android_gms_internal_zzjr, zzeg com_google_android_gms_internal_zzeg, int i, long j, long j2, JSONObject jSONObject) {
            this.zzTi = com_google_android_gms_internal_zzmk;
            this.zzWm = com_google_android_gms_internal_zzmn;
            this.zzWc = com_google_android_gms_internal_zzjr;
            this.zzvr = com_google_android_gms_internal_zzeg;
            this.errorCode = i;
            this.zzWg = j;
            this.zzWh = j2;
            this.zzWa = jSONObject;
        }
    }

    public zzpb(zzec com_google_android_gms_internal_zzec, @Nullable zzqw com_google_android_gms_internal_zzqw, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, @Nullable zzjq com_google_android_gms_internal_zzjq, @Nullable zzkb com_google_android_gms_internal_zzkb, @Nullable String str2, zzjr com_google_android_gms_internal_zzjr, @Nullable zzjt com_google_android_gms_internal_zzjt, long j2, zzeg com_google_android_gms_internal_zzeg, long j3, long j4, long j5, String str3, JSONObject jSONObject, @Nullable com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza, zzoo com_google_android_gms_internal_zzoo, List<String> list4, List<String> list5, boolean z2, zzmp com_google_android_gms_internal_zzmp, @Nullable String str4, List<String> list6, String str5) {
        this.zzWj = false;
        this.zzWk = false;
        this.zzWl = false;
        this.zzRy = com_google_android_gms_internal_zzec;
        this.zzNH = com_google_android_gms_internal_zzqw;
        this.zzKF = zzm(list);
        this.errorCode = i;
        this.zzKG = zzm(list2);
        this.zzSp = zzm(list3);
        this.orientation = i2;
        this.zzKL = j;
        this.zzRB = str;
        this.zzSn = z;
        this.zzLi = com_google_android_gms_internal_zzjq;
        this.zzLj = com_google_android_gms_internal_zzkb;
        this.zzLk = str2;
        this.zzWc = com_google_android_gms_internal_zzjr;
        this.zzLl = com_google_android_gms_internal_zzjt;
        this.zzSo = j2;
        this.zzWe = com_google_android_gms_internal_zzeg;
        this.zzSm = j3;
        this.zzWg = j4;
        this.zzWh = j5;
        this.zzSs = str3;
        this.zzWa = jSONObject;
        this.zzWi = com_google_android_gms_internal_zzha_zza;
        this.zzSC = com_google_android_gms_internal_zzoo;
        this.zzWf = zzm(list4);
        this.zzSE = zzm(list5);
        this.zzSF = z2;
        this.zzSG = com_google_android_gms_internal_zzmp;
        this.zzWd = str4;
        this.zzKI = zzm(list6);
        this.zzSJ = str5;
    }

    public zzpb(zza com_google_android_gms_internal_zzpb_zza, @Nullable zzqw com_google_android_gms_internal_zzqw, @Nullable zzjq com_google_android_gms_internal_zzjq, @Nullable zzkb com_google_android_gms_internal_zzkb, @Nullable String str, @Nullable zzjt com_google_android_gms_internal_zzjt, @Nullable com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza, @Nullable String str2) {
        zzqw com_google_android_gms_internal_zzqw2 = com_google_android_gms_internal_zzqw;
        zzjq com_google_android_gms_internal_zzjq2 = com_google_android_gms_internal_zzjq;
        zzkb com_google_android_gms_internal_zzkb2 = com_google_android_gms_internal_zzkb;
        String str3 = str;
        zzjt com_google_android_gms_internal_zzjt2 = com_google_android_gms_internal_zzjt;
        com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza2 = com_google_android_gms_internal_zzha_zza;
        String str4 = str2;
        this(com_google_android_gms_internal_zzpb_zza.zzTi.zzRy, com_google_android_gms_internal_zzqw2, com_google_android_gms_internal_zzpb_zza.zzWm.zzKF, com_google_android_gms_internal_zzpb_zza.errorCode, com_google_android_gms_internal_zzpb_zza.zzWm.zzKG, com_google_android_gms_internal_zzpb_zza.zzWm.zzSp, com_google_android_gms_internal_zzpb_zza.zzWm.orientation, com_google_android_gms_internal_zzpb_zza.zzWm.zzKL, com_google_android_gms_internal_zzpb_zza.zzTi.zzRB, com_google_android_gms_internal_zzpb_zza.zzWm.zzSn, com_google_android_gms_internal_zzjq2, com_google_android_gms_internal_zzkb2, str3, com_google_android_gms_internal_zzpb_zza.zzWc, com_google_android_gms_internal_zzjt2, com_google_android_gms_internal_zzpb_zza.zzWm.zzSo, com_google_android_gms_internal_zzpb_zza.zzvr, com_google_android_gms_internal_zzpb_zza.zzWm.zzSm, com_google_android_gms_internal_zzpb_zza.zzWg, com_google_android_gms_internal_zzpb_zza.zzWh, com_google_android_gms_internal_zzpb_zza.zzWm.zzSs, com_google_android_gms_internal_zzpb_zza.zzWa, com_google_android_gms_internal_zzha_zza2, com_google_android_gms_internal_zzpb_zza.zzWm.zzSC, com_google_android_gms_internal_zzpb_zza.zzWm.zzSD, com_google_android_gms_internal_zzpb_zza.zzWm.zzSD, com_google_android_gms_internal_zzpb_zza.zzWm.zzSF, com_google_android_gms_internal_zzpb_zza.zzWm.zzSG, str4, com_google_android_gms_internal_zzpb_zza.zzWm.zzKI, com_google_android_gms_internal_zzpb_zza.zzWm.zzSJ);
    }

    @Nullable
    private static <T> List<T> zzm(@Nullable List<T> list) {
        return list == null ? null : Collections.unmodifiableList(list);
    }

    public boolean zzdD() {
        return (this.zzNH == null || this.zzNH.zzlv() == null) ? false : this.zzNH.zzlv().zzdD();
    }
}
