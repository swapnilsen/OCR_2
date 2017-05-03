package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.appcompat.C0268R;
import android.support.v7.cardview.C0269R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzazf.zza;
import com.google.android.gms.internal.zzazf.zzd;
import com.google.android.gms.internal.zzazf.zzf;
import com.google.android.gms.internal.zzazf.zzg;
import com.google.android.gms.internal.zzazf.zzh;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzazg implements Creator<zzazf> {
    static void zza(zzazf com_google_android_gms_internal_zzazf, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        Set set = com_google_android_gms_internal_zzazf.zzbCm;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzazf.zzaiI);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzazf.zzbCn, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzazf.zzbCo, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zza(parcel, 4, com_google_android_gms_internal_zzazf.zzbCp, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzc.zza(parcel, 5, com_google_android_gms_internal_zzazf.zzbCq, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzc.zzc(parcel, 6, com_google_android_gms_internal_zzazf.zzbCr);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzc.zza(parcel, 7, com_google_android_gms_internal_zzazf.zzbCs, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzc.zza(parcel, 8, com_google_android_gms_internal_zzazf.zzbCt, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzc.zza(parcel, 9, com_google_android_gms_internal_zzazf.zzakb, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzc.zzc(parcel, 12, com_google_android_gms_internal_zzazf.zzzk);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzc.zza(parcel, 14, com_google_android_gms_internal_zzazf.zzGV, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzc.zza(parcel, 15, com_google_android_gms_internal_zzazf.zzbCu, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzc.zza(parcel, 16, com_google_android_gms_internal_zzazf.zzbCv);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzc.zza(parcel, 18, com_google_android_gms_internal_zzazf.zzacX, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzc.zza(parcel, 19, com_google_android_gms_internal_zzazf.zzbCw, i, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzc.zza(parcel, 20, com_google_android_gms_internal_zzazf.zzbCx, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzc.zzc(parcel, 21, com_google_android_gms_internal_zzazf.zzbCy);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzc.zzc(parcel, 22, com_google_android_gms_internal_zzazf.zzbCz, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzc.zzc(parcel, 23, com_google_android_gms_internal_zzazf.zzbCA, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzc.zzc(parcel, 24, com_google_android_gms_internal_zzazf.zzbCB);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzc.zzc(parcel, 25, com_google_android_gms_internal_zzazf.zzbCC);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzc.zza(parcel, 26, com_google_android_gms_internal_zzazf.zzbCD, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzc.zza(parcel, 27, com_google_android_gms_internal_zzazf.zzE, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzc.zzc(parcel, 28, com_google_android_gms_internal_zzazf.zzbCE, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzc.zza(parcel, 29, com_google_android_gms_internal_zzazf.zzbCF);
        }
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzje(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznc(i);
    }

    public zzazf zzje(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        zza com_google_android_gms_internal_zzazf_zza = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        zzazf.zzb com_google_android_gms_internal_zzazf_zzb = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        zzazf.zzc com_google_android_gms_internal_zzazf_zzc = null;
        boolean z = false;
        String str7 = null;
        zzd com_google_android_gms_internal_zzazf_zzd = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    zza com_google_android_gms_internal_zzazf_zza2 = (zza) zzb.zza(parcel, zzaX, zza.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    com_google_android_gms_internal_zzazf_zza = com_google_android_gms_internal_zzazf_zza2;
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Type.WEBSITE /*7*/:
                    zzazf.zzb com_google_android_gms_internal_zzazf_zzb2 = (zzazf.zzb) zzb.zza(parcel, zzaX, zzazf.zzb.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    com_google_android_gms_internal_zzazf_zzb = com_google_android_gms_internal_zzazf_zzb2;
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str5 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    i3 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case CommonStatusCodes.INTERRUPTED /*14*/:
                    str6 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case CommonStatusCodes.TIMEOUT /*15*/:
                    zzazf.zzc com_google_android_gms_internal_zzazf_zzc2 = (zzazf.zzc) zzb.zza(parcel, zzaX, zzazf.zzc.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    com_google_android_gms_internal_zzazf_zzc = com_google_android_gms_internal_zzazf_zzc2;
                    break;
                case CommonStatusCodes.CANCELED /*16*/:
                    z = zzb.zzc(parcel, zzaX);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case CommonStatusCodes.DEAD_CLIENT /*18*/:
                    str7 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    zzd com_google_android_gms_internal_zzazf_zzd2 = (zzd) zzb.zza(parcel, zzaX, zzd.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    com_google_android_gms_internal_zzazf_zzd = com_google_android_gms_internal_zzazf_zzd2;
                    break;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    str8 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case C0268R.styleable.Toolbar_buttonGravity /*21*/:
                    i4 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case C0268R.styleable.Toolbar_collapseIcon /*22*/:
                    list = zzb.zzc(parcel, zzaX, zzf.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case C0268R.styleable.Toolbar_collapseContentDescription /*23*/:
                    list2 = zzb.zzc(parcel, zzaX, zzg.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                    i5 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case C0268R.styleable.Toolbar_navigationContentDescription /*25*/:
                    i6 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case C0268R.styleable.Toolbar_logoDescription /*26*/:
                    str9 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case C0268R.styleable.Toolbar_titleTextColor /*27*/:
                    str10 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case C0268R.styleable.Toolbar_subtitleTextColor /*28*/:
                    list3 = zzb.zzc(parcel, zzaX, zzh.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case C0268R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzazf(hashSet, i, str, com_google_android_gms_internal_zzazf_zza, str2, str3, i2, com_google_android_gms_internal_zzazf_zzb, str4, str5, i3, str6, com_google_android_gms_internal_zzazf_zzc, z, str7, com_google_android_gms_internal_zzazf_zzd, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzazf[] zznc(int i) {
        return new zzazf[i];
    }
}
