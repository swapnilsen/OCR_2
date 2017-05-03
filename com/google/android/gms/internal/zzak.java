package com.google.android.gms.internal;

import android.support.v7.appcompat.C0268R;
import android.support.v7.cardview.C0269R;
import com.google.ads.AdSize;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public interface zzak {

    public static final class zza extends zzbxn<zza> {
        private static volatile zza[] zzlt;
        public String string;
        public int type;
        public boolean zzlA;
        public zza[] zzlB;
        public int[] zzlC;
        public boolean zzlD;
        public zza[] zzlu;
        public zza[] zzlv;
        public zza[] zzlw;
        public String zzlx;
        public String zzly;
        public long zzlz;

        public zza() {
            zzM();
        }

        public static zza[] zzL() {
            if (zzlt == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzlt == null) {
                        zzlt = new zza[0];
                    }
                }
            }
            return zzlt;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzak_zza = (zza) obj;
            if (this.type != com_google_android_gms_internal_zzak_zza.type) {
                return false;
            }
            if (this.string == null) {
                if (com_google_android_gms_internal_zzak_zza.string != null) {
                    return false;
                }
            } else if (!this.string.equals(com_google_android_gms_internal_zzak_zza.string)) {
                return false;
            }
            if (!zzbxr.equals(this.zzlu, com_google_android_gms_internal_zzak_zza.zzlu) || !zzbxr.equals(this.zzlv, com_google_android_gms_internal_zzak_zza.zzlv) || !zzbxr.equals(this.zzlw, com_google_android_gms_internal_zzak_zza.zzlw)) {
                return false;
            }
            if (this.zzlx == null) {
                if (com_google_android_gms_internal_zzak_zza.zzlx != null) {
                    return false;
                }
            } else if (!this.zzlx.equals(com_google_android_gms_internal_zzak_zza.zzlx)) {
                return false;
            }
            if (this.zzly == null) {
                if (com_google_android_gms_internal_zzak_zza.zzly != null) {
                    return false;
                }
            } else if (!this.zzly.equals(com_google_android_gms_internal_zzak_zza.zzly)) {
                return false;
            }
            return (this.zzlz == com_google_android_gms_internal_zzak_zza.zzlz && this.zzlA == com_google_android_gms_internal_zzak_zza.zzlA && zzbxr.equals(this.zzlB, com_google_android_gms_internal_zzak_zza.zzlB) && zzbxr.equals(this.zzlC, com_google_android_gms_internal_zzak_zza.zzlC) && this.zzlD == com_google_android_gms_internal_zzak_zza.zzlD) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzak_zza.zzcuI == null || com_google_android_gms_internal_zzak_zza.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzak_zza.zzcuI) : false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.zzlA ? 1231 : 1237) + (((((this.zzly == null ? 0 : this.zzly.hashCode()) + (((this.zzlx == null ? 0 : this.zzlx.hashCode()) + (((((((((this.string == null ? 0 : this.string.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzbxr.hashCode(this.zzlu)) * 31) + zzbxr.hashCode(this.zzlv)) * 31) + zzbxr.hashCode(this.zzlw)) * 31)) * 31)) * 31) + ((int) (this.zzlz ^ (this.zzlz >>> 32)))) * 31)) * 31) + zzbxr.hashCode(this.zzlB)) * 31) + zzbxr.hashCode(this.zzlC)) * 31;
            if (!this.zzlD) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i2 = this.zzcuI.hashCode();
            }
            return hashCode + i2;
        }

        public zza zzM() {
            this.type = 1;
            this.string = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzlu = zzL();
            this.zzlv = zzL();
            this.zzlw = zzL();
            this.zzlx = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzly = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzlz = 0;
            this.zzlA = false;
            this.zzlB = zzL();
            this.zzlC = zzbxw.zzcuW;
            this.zzlD = false;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            int i = 0;
            com_google_android_gms_internal_zzbxm.zzJ(1, this.type);
            if (!(this.string == null || this.string.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(2, this.string);
            }
            if (this.zzlu != null && this.zzlu.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzlu) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        com_google_android_gms_internal_zzbxm.zza(3, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            if (this.zzlv != null && this.zzlv.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt2 : this.zzlv) {
                    if (com_google_android_gms_internal_zzbxt2 != null) {
                        com_google_android_gms_internal_zzbxm.zza(4, com_google_android_gms_internal_zzbxt2);
                    }
                }
            }
            if (this.zzlw != null && this.zzlw.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt22 : this.zzlw) {
                    if (com_google_android_gms_internal_zzbxt22 != null) {
                        com_google_android_gms_internal_zzbxm.zza(5, com_google_android_gms_internal_zzbxt22);
                    }
                }
            }
            if (!(this.zzlx == null || this.zzlx.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(6, this.zzlx);
            }
            if (!(this.zzly == null || this.zzly.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(7, this.zzly);
            }
            if (this.zzlz != 0) {
                com_google_android_gms_internal_zzbxm.zzb(8, this.zzlz);
            }
            if (this.zzlD) {
                com_google_android_gms_internal_zzbxm.zzg(9, this.zzlD);
            }
            if (this.zzlC != null && this.zzlC.length > 0) {
                for (int zzJ : this.zzlC) {
                    com_google_android_gms_internal_zzbxm.zzJ(10, zzJ);
                }
            }
            if (this.zzlB != null && this.zzlB.length > 0) {
                while (i < this.zzlB.length) {
                    zzbxt com_google_android_gms_internal_zzbxt3 = this.zzlB[i];
                    if (com_google_android_gms_internal_zzbxt3 != null) {
                        com_google_android_gms_internal_zzbxm.zza(11, com_google_android_gms_internal_zzbxt3);
                    }
                    i++;
                }
            }
            if (this.zzlA) {
                com_google_android_gms_internal_zzbxm.zzg(12, this.zzlA);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzx(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int i;
            int i2 = 0;
            int zzu = super.zzu() + zzbxm.zzL(1, this.type);
            if (!(this.string == null || this.string.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(2, this.string);
            }
            if (this.zzlu != null && this.zzlu.length > 0) {
                i = zzu;
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzlu) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        i += zzbxm.zzc(3, com_google_android_gms_internal_zzbxt);
                    }
                }
                zzu = i;
            }
            if (this.zzlv != null && this.zzlv.length > 0) {
                i = zzu;
                for (zzbxt com_google_android_gms_internal_zzbxt2 : this.zzlv) {
                    if (com_google_android_gms_internal_zzbxt2 != null) {
                        i += zzbxm.zzc(4, com_google_android_gms_internal_zzbxt2);
                    }
                }
                zzu = i;
            }
            if (this.zzlw != null && this.zzlw.length > 0) {
                i = zzu;
                for (zzbxt com_google_android_gms_internal_zzbxt22 : this.zzlw) {
                    if (com_google_android_gms_internal_zzbxt22 != null) {
                        i += zzbxm.zzc(5, com_google_android_gms_internal_zzbxt22);
                    }
                }
                zzu = i;
            }
            if (!(this.zzlx == null || this.zzlx.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(6, this.zzlx);
            }
            if (!(this.zzly == null || this.zzly.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(7, this.zzly);
            }
            if (this.zzlz != 0) {
                zzu += zzbxm.zzf(8, this.zzlz);
            }
            if (this.zzlD) {
                zzu += zzbxm.zzh(9, this.zzlD);
            }
            if (this.zzlC != null && this.zzlC.length > 0) {
                int i3 = 0;
                for (int zzrg : this.zzlC) {
                    i3 += zzbxm.zzrg(zzrg);
                }
                zzu = (zzu + i3) + (this.zzlC.length * 1);
            }
            if (this.zzlB != null && this.zzlB.length > 0) {
                while (i2 < this.zzlB.length) {
                    zzbxt com_google_android_gms_internal_zzbxt3 = this.zzlB[i2];
                    if (com_google_android_gms_internal_zzbxt3 != null) {
                        zzu += zzbxm.zzc(11, com_google_android_gms_internal_zzbxt3);
                    }
                    i2++;
                }
            }
            return this.zzlA ? zzu + zzbxm.zzh(12, this.zzlA) : zzu;
        }

        public zza zzx(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                int zzb;
                Object obj;
                int i;
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        zzaeo = com_google_android_gms_internal_zzbxl.zzaes();
                        switch (zzaeo) {
                            case NendIconError.ERROR_ICONVIEW /*1*/:
                            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                            case Type.OTHER_PROFILE /*5*/:
                            case Type.CONTRIBUTOR /*6*/:
                            case Type.WEBSITE /*7*/:
                            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                                this.type = zzaeo;
                                break;
                            default:
                                continue;
                        }
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        this.string = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 26);
                        zzaeo = this.zzlu == null ? 0 : this.zzlu.length;
                        obj = new zza[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlu, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zza();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zza();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzlu = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 34);
                        zzaeo = this.zzlv == null ? 0 : this.zzlv.length;
                        obj = new zza[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlv, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zza();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zza();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzlv = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 42);
                        zzaeo = this.zzlw == null ? 0 : this.zzlw.length;
                        obj = new zza[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlw, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zza();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zza();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzlw = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.zzlx = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        this.zzly = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_editTextBackground /*64*/:
                        this.zzlz = com_google_android_gms_internal_zzbxl.zzaer();
                        continue;
                    case C0268R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                        this.zzlD = com_google_android_gms_internal_zzbxl.zzaeu();
                        continue;
                    case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        int zzb2 = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 80);
                        Object obj2 = new int[zzb2];
                        i = 0;
                        zzb = 0;
                        while (i < zzb2) {
                            if (i != 0) {
                                com_google_android_gms_internal_zzbxl.zzaeo();
                            }
                            int zzaes = com_google_android_gms_internal_zzbxl.zzaes();
                            switch (zzaes) {
                                case NendIconError.ERROR_ICONVIEW /*1*/:
                                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                                case Type.OTHER_PROFILE /*5*/:
                                case Type.CONTRIBUTOR /*6*/:
                                case Type.WEBSITE /*7*/:
                                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                                case ConnectionResult.SERVICE_INVALID /*9*/:
                                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                                case CommonStatusCodes.ERROR /*13*/:
                                case CommonStatusCodes.INTERRUPTED /*14*/:
                                case CommonStatusCodes.TIMEOUT /*15*/:
                                case CommonStatusCodes.CANCELED /*16*/:
                                case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                                    zzaeo = zzb + 1;
                                    obj2[zzb] = zzaes;
                                    break;
                                default:
                                    zzaeo = zzb;
                                    break;
                            }
                            i++;
                            zzb = zzaeo;
                        }
                        if (zzb != 0) {
                            zzaeo = this.zzlC == null ? 0 : this.zzlC.length;
                            if (zzaeo != 0 || zzb != obj2.length) {
                                Object obj3 = new int[(zzaeo + zzb)];
                                if (zzaeo != 0) {
                                    System.arraycopy(this.zzlC, 0, obj3, 0, zzaeo);
                                }
                                System.arraycopy(obj2, 0, obj3, zzaeo, zzb);
                                this.zzlC = obj3;
                                break;
                            }
                            this.zzlC = obj2;
                            break;
                        }
                        continue;
                    case C0268R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        i = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            switch (com_google_android_gms_internal_zzbxl.zzaes()) {
                                case NendIconError.ERROR_ICONVIEW /*1*/:
                                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                                case Type.OTHER_PROFILE /*5*/:
                                case Type.CONTRIBUTOR /*6*/:
                                case Type.WEBSITE /*7*/:
                                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                                case ConnectionResult.SERVICE_INVALID /*9*/:
                                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                                case CommonStatusCodes.ERROR /*13*/:
                                case CommonStatusCodes.INTERRUPTED /*14*/:
                                case CommonStatusCodes.TIMEOUT /*15*/:
                                case CommonStatusCodes.CANCELED /*16*/:
                                case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                                    zzaeo++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (zzaeo != 0) {
                            com_google_android_gms_internal_zzbxl.zzrc(zzb);
                            zzb = this.zzlC == null ? 0 : this.zzlC.length;
                            Object obj4 = new int[(zzaeo + zzb)];
                            if (zzb != 0) {
                                System.arraycopy(this.zzlC, 0, obj4, 0, zzb);
                            }
                            while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                                int zzaes2 = com_google_android_gms_internal_zzbxl.zzaes();
                                switch (zzaes2) {
                                    case NendIconError.ERROR_ICONVIEW /*1*/:
                                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                                    case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                                    case Type.OTHER_PROFILE /*5*/:
                                    case Type.CONTRIBUTOR /*6*/:
                                    case Type.WEBSITE /*7*/:
                                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                                    case ConnectionResult.SERVICE_INVALID /*9*/:
                                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                                    case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                    case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                                    case CommonStatusCodes.ERROR /*13*/:
                                    case CommonStatusCodes.INTERRUPTED /*14*/:
                                    case CommonStatusCodes.TIMEOUT /*15*/:
                                    case CommonStatusCodes.CANCELED /*16*/:
                                    case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                                        zzaeo = zzb + 1;
                                        obj4[zzb] = zzaes2;
                                        zzb = zzaeo;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.zzlC = obj4;
                        }
                        com_google_android_gms_internal_zzbxl.zzrb(i);
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 90);
                        zzaeo = this.zzlB == null ? 0 : this.zzlB.length;
                        obj = new zza[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlB, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zza();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zza();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzlB = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_alertDialogTheme /*96*/:
                        this.zzlA = com_google_android_gms_internal_zzbxl.zzaeu();
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
    }
}
