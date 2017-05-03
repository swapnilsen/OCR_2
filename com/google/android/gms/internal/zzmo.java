package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.appcompat.C0268R;
import android.support.v7.cardview.C0269R;
import com.google.ads.AdSize;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import net.nend.android.NendIconError;

public class zzmo implements Creator<zzmn> {
    static void zza(zzmn com_google_android_gms_internal_zzmn, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzmn.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzmn.zzNJ, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzmn.body, false);
        zzc.zzb(parcel, 4, com_google_android_gms_internal_zzmn.zzKF, false);
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzmn.errorCode);
        zzc.zzb(parcel, 6, com_google_android_gms_internal_zzmn.zzKG, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzmn.zzSm);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzmn.zzSn);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzmn.zzSo);
        zzc.zzb(parcel, 10, com_google_android_gms_internal_zzmn.zzSp, false);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzmn.zzKL);
        zzc.zzc(parcel, 12, com_google_android_gms_internal_zzmn.orientation);
        zzc.zza(parcel, 13, com_google_android_gms_internal_zzmn.zzSq, false);
        zzc.zza(parcel, 14, com_google_android_gms_internal_zzmn.zzSr);
        zzc.zza(parcel, 15, com_google_android_gms_internal_zzmn.zzSs, false);
        zzc.zza(parcel, 18, com_google_android_gms_internal_zzmn.zzSt);
        zzc.zza(parcel, 19, com_google_android_gms_internal_zzmn.zzSu, false);
        zzc.zza(parcel, 21, com_google_android_gms_internal_zzmn.zzSv, false);
        zzc.zza(parcel, 22, com_google_android_gms_internal_zzmn.zzSw);
        zzc.zza(parcel, 23, com_google_android_gms_internal_zzmn.zzzB);
        zzc.zza(parcel, 24, com_google_android_gms_internal_zzmn.zzRG);
        zzc.zza(parcel, 25, com_google_android_gms_internal_zzmn.zzSx);
        zzc.zza(parcel, 26, com_google_android_gms_internal_zzmn.zzSy);
        zzc.zza(parcel, 28, com_google_android_gms_internal_zzmn.zzSz, i, false);
        zzc.zza(parcel, 29, com_google_android_gms_internal_zzmn.zzSA, false);
        zzc.zza(parcel, 30, com_google_android_gms_internal_zzmn.zzSB, false);
        zzc.zza(parcel, 31, com_google_android_gms_internal_zzmn.zzzC);
        zzc.zza(parcel, 32, com_google_android_gms_internal_zzmn.zzzD);
        zzc.zza(parcel, 33, com_google_android_gms_internal_zzmn.zzSC, i, false);
        zzc.zzb(parcel, 34, com_google_android_gms_internal_zzmn.zzSD, false);
        zzc.zzb(parcel, 35, com_google_android_gms_internal_zzmn.zzSE, false);
        zzc.zza(parcel, 36, com_google_android_gms_internal_zzmn.zzSF);
        zzc.zza(parcel, 37, com_google_android_gms_internal_zzmn.zzSG, i, false);
        zzc.zza(parcel, 38, com_google_android_gms_internal_zzmn.zzRV);
        zzc.zza(parcel, 39, com_google_android_gms_internal_zzmn.zzRW, false);
        zzc.zzb(parcel, 40, com_google_android_gms_internal_zzmn.zzKI, false);
        zzc.zza(parcel, 42, com_google_android_gms_internal_zzmn.zzKJ);
        zzc.zza(parcel, 43, com_google_android_gms_internal_zzmn.zzSH, false);
        zzc.zza(parcel, 44, com_google_android_gms_internal_zzmn.zzSI, i, false);
        zzc.zza(parcel, 45, com_google_android_gms_internal_zzmn.zzSJ, false);
        zzc.zza(parcel, 46, com_google_android_gms_internal_zzmn.zzSK);
        zzc.zza(parcel, 47, com_google_android_gms_internal_zzmn.zzSh);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzW(i);
    }

    public zzmn[] zzW(int i) {
        return new zzmn[i];
    }

    public zzmn zzo(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        zzmv com_google_android_gms_internal_zzmv = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        boolean z9 = false;
        zzoo com_google_android_gms_internal_zzoo = null;
        List list4 = null;
        List list5 = null;
        boolean z10 = false;
        zzmp com_google_android_gms_internal_zzmp = null;
        boolean z11 = false;
        String str9 = null;
        List list6 = null;
        boolean z12 = false;
        String str10 = null;
        zzor com_google_android_gms_internal_zzor = null;
        String str11 = null;
        boolean z13 = false;
        boolean z14 = false;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    list = zzb.zzE(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    list2 = zzb.zzE(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    j = zzb.zzi(parcel, zzaX);
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    j2 = zzb.zzi(parcel, zzaX);
                    break;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    list3 = zzb.zzE(parcel, zzaX);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    j3 = zzb.zzi(parcel, zzaX);
                    break;
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    i3 = zzb.zzg(parcel, zzaX);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    break;
                case CommonStatusCodes.INTERRUPTED /*14*/:
                    j4 = zzb.zzi(parcel, zzaX);
                    break;
                case CommonStatusCodes.TIMEOUT /*15*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    break;
                case CommonStatusCodes.DEAD_CLIENT /*18*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    str5 = zzb.zzq(parcel, zzaX);
                    break;
                case C0268R.styleable.Toolbar_buttonGravity /*21*/:
                    str6 = zzb.zzq(parcel, zzaX);
                    break;
                case C0268R.styleable.Toolbar_collapseIcon /*22*/:
                    z3 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.Toolbar_collapseContentDescription /*23*/:
                    z4 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                    z5 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.Toolbar_navigationContentDescription /*25*/:
                    z6 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.Toolbar_logoDescription /*26*/:
                    z7 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.Toolbar_subtitleTextColor /*28*/:
                    com_google_android_gms_internal_zzmv = (zzmv) zzb.zza(parcel, zzaX, zzmv.CREATOR);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    str7 = zzb.zzq(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModeSplitBackground /*30*/:
                    str8 = zzb.zzq(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    z8 = zzb.zzc(parcel, zzaX);
                    break;
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    z9 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    com_google_android_gms_internal_zzoo = (zzoo) zzb.zza(parcel, zzaX, zzoo.CREATOR);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    list4 = zzb.zzE(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    list5 = zzb.zzE(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                    z10 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                    com_google_android_gms_internal_zzmp = (zzmp) zzb.zza(parcel, zzaX, zzmp.CREATOR);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    z11 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    str9 = zzb.zzq(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    list6 = zzb.zzE(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    z12 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_dialogTheme /*43*/:
                    str10 = zzb.zzq(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    com_google_android_gms_internal_zzor = (zzor) zzb.zza(parcel, zzaX, zzor.CREATOR);
                    break;
                case C0268R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                    str11 = zzb.zzq(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                    z13 = zzb.zzc(parcel, zzaX);
                    break;
                case C0268R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    z14 = zzb.zzc(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzmn(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, com_google_android_gms_internal_zzmv, str7, str8, z8, z9, com_google_android_gms_internal_zzoo, list4, list5, z10, com_google_android_gms_internal_zzmp, z11, str9, list6, z12, str10, com_google_android_gms_internal_zzor, str11, z13, z14);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }
}
