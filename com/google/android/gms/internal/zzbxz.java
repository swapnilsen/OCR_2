package com.google.android.gms.internal;

import android.support.v7.appcompat.C0268R;
import com.google.ads.AdSize;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public interface zzbxz {

    public static final class zza extends zzbxn<zza> {
        private static volatile zza[] zzcvO;
        public String zzcvP;

        public zza() {
            zzafj();
        }

        public static zza[] zzafi() {
            if (zzcvO == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzcvO == null) {
                        zzcvO = new zza[0];
                    }
                }
            }
            return zzcvO;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (!(this.zzcvP == null || this.zzcvP.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(1, this.zzcvP);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zza zzaV(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.zzcvP = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    default:
                        if (!super.zza(com_google_android_gms_internal_zzbxl, zzaeo)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zza zzafj() {
            this.zzcvP = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzaV(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            return (this.zzcvP == null || this.zzcvP.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)) ? zzu : zzu + zzbxm.zzr(1, this.zzcvP);
        }
    }

    public static final class zzb extends zzbxn<zzb> {
        public String zzcvP;
        public String zzcvQ;
        public long zzcvR;
        public String zzcvS;
        public int zzcvT;
        public int zzcvU;
        public String zzcvV;
        public String zzcvW;
        public String zzcvX;
        public String zzcvY;
        public String zzcvZ;
        public int zzcwa;
        public zza[] zzcwb;

        public zzb() {
            zzafk();
        }

        public static zzb zzak(byte[] bArr) {
            return (zzb) zzbxt.zza(new zzb(), bArr);
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (!(this.zzcvP == null || this.zzcvP.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(1, this.zzcvP);
            }
            if (!(this.zzcvQ == null || this.zzcvQ.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(2, this.zzcvQ);
            }
            if (this.zzcvR != 0) {
                com_google_android_gms_internal_zzbxm.zzb(3, this.zzcvR);
            }
            if (!(this.zzcvS == null || this.zzcvS.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(4, this.zzcvS);
            }
            if (this.zzcvT != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(5, this.zzcvT);
            }
            if (this.zzcvU != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(6, this.zzcvU);
            }
            if (!(this.zzcvV == null || this.zzcvV.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(7, this.zzcvV);
            }
            if (!(this.zzcvW == null || this.zzcvW.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(8, this.zzcvW);
            }
            if (!(this.zzcvX == null || this.zzcvX.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(9, this.zzcvX);
            }
            if (!(this.zzcvY == null || this.zzcvY.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(10, this.zzcvY);
            }
            if (!(this.zzcvZ == null || this.zzcvZ.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(11, this.zzcvZ);
            }
            if (this.zzcwa != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(12, this.zzcwa);
            }
            if (this.zzcwb != null && this.zzcwb.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcwb) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        com_google_android_gms_internal_zzbxm.zza(13, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zzb zzaW(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.zzcvP = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        this.zzcvQ = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                        this.zzcvR = com_google_android_gms_internal_zzbxl.zzaer();
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzcvS = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        this.zzcvT = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case C0268R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        this.zzcvU = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case C0268R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        this.zzcvV = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                        this.zzcvW = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                        this.zzcvX = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        this.zzcvY = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        this.zzcvZ = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_alertDialogTheme /*96*/:
                        zzaeo = com_google_android_gms_internal_zzbxl.zzaes();
                        switch (zzaeo) {
                            case NendAdIconLayout.HORIZONTAL /*0*/:
                            case NendIconError.ERROR_ICONVIEW /*1*/:
                            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                                this.zzcwa = zzaeo;
                                break;
                            default:
                                continue;
                        }
                    case C0268R.styleable.AppCompatTheme_editTextStyle /*106*/:
                        int zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, C0268R.styleable.AppCompatTheme_editTextStyle);
                        zzaeo = this.zzcwb == null ? 0 : this.zzcwb.length;
                        Object obj = new zza[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcwb, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zza();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zza();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzcwb = obj;
                        continue;
                    default:
                        if (!super.zza(com_google_android_gms_internal_zzbxl, zzaeo)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzb zzafk() {
            this.zzcvP = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvQ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvR = 0;
            this.zzcvS = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvT = 0;
            this.zzcvU = 0;
            this.zzcvV = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvW = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvX = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvY = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvZ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcwa = 0;
            this.zzcwb = zza.zzafi();
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzaW(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (!(this.zzcvP == null || this.zzcvP.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(1, this.zzcvP);
            }
            if (!(this.zzcvQ == null || this.zzcvQ.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(2, this.zzcvQ);
            }
            if (this.zzcvR != 0) {
                zzu += zzbxm.zzf(3, this.zzcvR);
            }
            if (!(this.zzcvS == null || this.zzcvS.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(4, this.zzcvS);
            }
            if (this.zzcvT != 0) {
                zzu += zzbxm.zzL(5, this.zzcvT);
            }
            if (this.zzcvU != 0) {
                zzu += zzbxm.zzL(6, this.zzcvU);
            }
            if (!(this.zzcvV == null || this.zzcvV.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(7, this.zzcvV);
            }
            if (!(this.zzcvW == null || this.zzcvW.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(8, this.zzcvW);
            }
            if (!(this.zzcvX == null || this.zzcvX.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(9, this.zzcvX);
            }
            if (!(this.zzcvY == null || this.zzcvY.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(10, this.zzcvY);
            }
            if (!(this.zzcvZ == null || this.zzcvZ.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(11, this.zzcvZ);
            }
            if (this.zzcwa != 0) {
                zzu += zzbxm.zzL(12, this.zzcwa);
            }
            if (this.zzcwb == null || this.zzcwb.length <= 0) {
                return zzu;
            }
            int i = zzu;
            for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcwb) {
                if (com_google_android_gms_internal_zzbxt != null) {
                    i += zzbxm.zzc(13, com_google_android_gms_internal_zzbxt);
                }
            }
            return i;
        }
    }
}
