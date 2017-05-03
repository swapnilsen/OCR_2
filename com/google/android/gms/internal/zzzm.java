package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzbxy.zzd;
import com.google.android.gms.internal.zzzk.zzc;
import java.util.Arrays;

public class zzzm extends zza {
    public static final Creator<zzzm> CREATOR;
    public zzzu zzaxI;
    public byte[] zzaxJ;
    public int[] zzaxK;
    public String[] zzaxL;
    public int[] zzaxM;
    public byte[][] zzaxN;
    public boolean zzaxO;
    public final zzd zzaxP;
    public final zzc zzaxQ;
    public final zzc zzaxR;

    static {
        CREATOR = new zzzn();
    }

    public zzzm(zzzu com_google_android_gms_internal_zzzu, zzd com_google_android_gms_internal_zzbxy_zzd, zzc com_google_android_gms_internal_zzzk_zzc, zzc com_google_android_gms_internal_zzzk_zzc2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, boolean z) {
        this.zzaxI = com_google_android_gms_internal_zzzu;
        this.zzaxP = com_google_android_gms_internal_zzbxy_zzd;
        this.zzaxQ = com_google_android_gms_internal_zzzk_zzc;
        this.zzaxR = com_google_android_gms_internal_zzzk_zzc2;
        this.zzaxK = iArr;
        this.zzaxL = strArr;
        this.zzaxM = iArr2;
        this.zzaxN = bArr;
        this.zzaxO = z;
    }

    zzzm(zzzu com_google_android_gms_internal_zzzu, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z) {
        this.zzaxI = com_google_android_gms_internal_zzzu;
        this.zzaxJ = bArr;
        this.zzaxK = iArr;
        this.zzaxL = strArr;
        this.zzaxP = null;
        this.zzaxQ = null;
        this.zzaxR = null;
        this.zzaxM = iArr2;
        this.zzaxN = bArr2;
        this.zzaxO = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzm)) {
            return false;
        }
        zzzm com_google_android_gms_internal_zzzm = (zzzm) obj;
        return zzaa.equal(this.zzaxI, com_google_android_gms_internal_zzzm.zzaxI) && Arrays.equals(this.zzaxJ, com_google_android_gms_internal_zzzm.zzaxJ) && Arrays.equals(this.zzaxK, com_google_android_gms_internal_zzzm.zzaxK) && Arrays.equals(this.zzaxL, com_google_android_gms_internal_zzzm.zzaxL) && zzaa.equal(this.zzaxP, com_google_android_gms_internal_zzzm.zzaxP) && zzaa.equal(this.zzaxQ, com_google_android_gms_internal_zzzm.zzaxQ) && zzaa.equal(this.zzaxR, com_google_android_gms_internal_zzzm.zzaxR) && Arrays.equals(this.zzaxM, com_google_android_gms_internal_zzzm.zzaxM) && Arrays.deepEquals(this.zzaxN, com_google_android_gms_internal_zzzm.zzaxN) && this.zzaxO == com_google_android_gms_internal_zzzm.zzaxO;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaxI, this.zzaxJ, this.zzaxK, this.zzaxL, this.zzaxP, this.zzaxQ, this.zzaxR, this.zzaxM, this.zzaxN, Boolean.valueOf(this.zzaxO));
    }

    public String toString() {
        return "LogEventParcelable[" + this.zzaxI + ", " + "LogEventBytes: " + (this.zzaxJ == null ? null : new String(this.zzaxJ)) + ", " + "TestCodes: " + Arrays.toString(this.zzaxK) + ", " + "MendelPackages: " + Arrays.toString(this.zzaxL) + ", " + "LogEvent: " + this.zzaxP + ", " + "ExtensionProducer: " + this.zzaxQ + ", " + "VeProducer: " + this.zzaxR + ", " + "ExperimentIDs: " + Arrays.toString(this.zzaxM) + ", " + "ExperimentTokens: " + Arrays.toString(this.zzaxN) + ", " + "AddPhenotypeExperimentTokens: " + this.zzaxO + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzzn.zza(this, parcel, i);
    }
}
