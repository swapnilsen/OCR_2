package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v7.appcompat.C0268R;
import android.support.v7.cardview.C0269R;
import com.crashlytics.android.answers.AnswersEvent;
import com.google.ads.AdSize;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public interface zzbxy {

    public static final class zza extends zzbxn<zza> implements Cloneable {
        public String[] zzcvg;
        public String[] zzcvh;
        public int[] zzcvi;
        public long[] zzcvj;
        public long[] zzcvk;

        public zza() {
            zzaeV();
        }

        public /* synthetic */ Object clone() {
            return zzaeW();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzbxy_zza = (zza) obj;
            return (zzbxr.equals(this.zzcvg, com_google_android_gms_internal_zzbxy_zza.zzcvg) && zzbxr.equals(this.zzcvh, com_google_android_gms_internal_zzbxy_zza.zzcvh) && zzbxr.equals(this.zzcvi, com_google_android_gms_internal_zzbxy_zza.zzcvi) && zzbxr.equals(this.zzcvj, com_google_android_gms_internal_zzbxy_zza.zzcvj) && zzbxr.equals(this.zzcvk, com_google_android_gms_internal_zzbxy_zza.zzcvk)) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbxy_zza.zzcuI == null || com_google_android_gms_internal_zzbxy_zza.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbxy_zza.zzcuI) : false;
        }

        public int hashCode() {
            int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + zzbxr.hashCode(this.zzcvg)) * 31) + zzbxr.hashCode(this.zzcvh)) * 31) + zzbxr.hashCode(this.zzcvi)) * 31) + zzbxr.hashCode(this.zzcvj)) * 31) + zzbxr.hashCode(this.zzcvk)) * 31;
            int hashCode2 = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            int i = 0;
            if (this.zzcvg != null && this.zzcvg.length > 0) {
                for (String str : this.zzcvg) {
                    if (str != null) {
                        com_google_android_gms_internal_zzbxm.zzq(1, str);
                    }
                }
            }
            if (this.zzcvh != null && this.zzcvh.length > 0) {
                for (String str2 : this.zzcvh) {
                    if (str2 != null) {
                        com_google_android_gms_internal_zzbxm.zzq(2, str2);
                    }
                }
            }
            if (this.zzcvi != null && this.zzcvi.length > 0) {
                for (int zzJ : this.zzcvi) {
                    com_google_android_gms_internal_zzbxm.zzJ(3, zzJ);
                }
            }
            if (this.zzcvj != null && this.zzcvj.length > 0) {
                for (long zzb : this.zzcvj) {
                    com_google_android_gms_internal_zzbxm.zzb(4, zzb);
                }
            }
            if (this.zzcvk != null && this.zzcvk.length > 0) {
                while (i < this.zzcvk.length) {
                    com_google_android_gms_internal_zzbxm.zzb(5, this.zzcvk[i]);
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zza zzaP(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                int zzb;
                Object obj;
                int zzra;
                Object obj2;
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 10);
                        zzaeo = this.zzcvg == null ? 0 : this.zzcvg.length;
                        obj = new String[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcvg, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                        this.zzcvg = obj;
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 18);
                        zzaeo = this.zzcvh == null ? 0 : this.zzcvh.length;
                        obj = new String[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcvh, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                        this.zzcvh = obj;
                        continue;
                    case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 24);
                        zzaeo = this.zzcvi == null ? 0 : this.zzcvi.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcvi, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzcvi = obj;
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzcvi == null ? 0 : this.zzcvi.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzcvi, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzcvi = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 32);
                        zzaeo = this.zzcvj == null ? 0 : this.zzcvj.length;
                        obj = new long[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcvj, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaer();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaer();
                        this.zzcvj = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaer();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzcvj == null ? 0 : this.zzcvj.length;
                        obj2 = new long[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzcvj, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaer();
                            zzb++;
                        }
                        this.zzcvj = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 40);
                        zzaeo = this.zzcvk == null ? 0 : this.zzcvk.length;
                        obj = new long[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcvk, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaer();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaer();
                        this.zzcvk = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaer();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzcvk == null ? 0 : this.zzcvk.length;
                        obj2 = new long[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzcvk, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaer();
                            zzb++;
                        }
                        this.zzcvk = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
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

        public /* synthetic */ zzbxn zzaeH() {
            return (zza) clone();
        }

        public /* synthetic */ zzbxt zzaeI() {
            return (zza) clone();
        }

        public zza zzaeV() {
            this.zzcvg = zzbxw.zzcvb;
            this.zzcvh = zzbxw.zzcvb;
            this.zzcvi = zzbxw.zzcuW;
            this.zzcvj = zzbxw.zzcuX;
            this.zzcvk = zzbxw.zzcuX;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zza zzaeW() {
            try {
                zza com_google_android_gms_internal_zzbxy_zza = (zza) super.zzaeH();
                if (this.zzcvg != null && this.zzcvg.length > 0) {
                    com_google_android_gms_internal_zzbxy_zza.zzcvg = (String[]) this.zzcvg.clone();
                }
                if (this.zzcvh != null && this.zzcvh.length > 0) {
                    com_google_android_gms_internal_zzbxy_zza.zzcvh = (String[]) this.zzcvh.clone();
                }
                if (this.zzcvi != null && this.zzcvi.length > 0) {
                    com_google_android_gms_internal_zzbxy_zza.zzcvi = (int[]) this.zzcvi.clone();
                }
                if (this.zzcvj != null && this.zzcvj.length > 0) {
                    com_google_android_gms_internal_zzbxy_zza.zzcvj = (long[]) this.zzcvj.clone();
                }
                if (this.zzcvk != null && this.zzcvk.length > 0) {
                    com_google_android_gms_internal_zzbxy_zza.zzcvk = (long[]) this.zzcvk.clone();
                }
                return com_google_android_gms_internal_zzbxy_zza;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzaP(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzu = super.zzu();
            if (this.zzcvg == null || this.zzcvg.length <= 0) {
                i = zzu;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzcvg) {
                    if (str != null) {
                        i3++;
                        i2 += zzbxm.zzkb(str);
                    }
                }
                i = (zzu + i2) + (i3 * 1);
            }
            if (this.zzcvh != null && this.zzcvh.length > 0) {
                i3 = 0;
                zzu = 0;
                for (String str2 : this.zzcvh) {
                    if (str2 != null) {
                        zzu++;
                        i3 += zzbxm.zzkb(str2);
                    }
                }
                i = (i + i3) + (zzu * 1);
            }
            if (this.zzcvi != null && this.zzcvi.length > 0) {
                i3 = 0;
                for (int zzu2 : this.zzcvi) {
                    i3 += zzbxm.zzrg(zzu2);
                }
                i = (i + i3) + (this.zzcvi.length * 1);
            }
            if (this.zzcvj != null && this.zzcvj.length > 0) {
                i3 = 0;
                for (long zzbf : this.zzcvj) {
                    i3 += zzbxm.zzbf(zzbf);
                }
                i = (i + i3) + (this.zzcvj.length * 1);
            }
            if (this.zzcvk == null || this.zzcvk.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.zzcvk.length) {
                i2 += zzbxm.zzbf(this.zzcvk[i4]);
                i4++;
            }
            return (i + i2) + (this.zzcvk.length * 1);
        }
    }

    public static final class zzb extends zzbxn<zzb> implements Cloneable {
        public String version;
        public int zzcvl;
        public String zzcvm;

        public zzb() {
            zzaeX();
        }

        public /* synthetic */ Object clone() {
            return zzaeY();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzbxy_zzb = (zzb) obj;
            if (this.zzcvl != com_google_android_gms_internal_zzbxy_zzb.zzcvl) {
                return false;
            }
            if (this.zzcvm == null) {
                if (com_google_android_gms_internal_zzbxy_zzb.zzcvm != null) {
                    return false;
                }
            } else if (!this.zzcvm.equals(com_google_android_gms_internal_zzbxy_zzb.zzcvm)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzbxy_zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzbxy_zzb.version)) {
                return false;
            }
            return (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbxy_zzb.zzcuI == null || com_google_android_gms_internal_zzbxy_zzb.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbxy_zzb.zzcuI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzcvm == null ? 0 : this.zzcvm.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzcvl) * 31)) * 31)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.zzcvl != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(1, this.zzcvl);
            }
            if (!(this.zzcvm == null || this.zzcvm.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(2, this.zzcvm);
            }
            if (!(this.version == null || this.version.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(3, this.version);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zzb zzaQ(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        this.zzcvl = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        this.zzcvm = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        this.version = com_google_android_gms_internal_zzbxl.readString();
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

        public /* synthetic */ zzbxn zzaeH() {
            return (zzb) clone();
        }

        public /* synthetic */ zzbxt zzaeI() {
            return (zzb) clone();
        }

        public zzb zzaeX() {
            this.zzcvl = 0;
            this.zzcvm = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.version = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zzb zzaeY() {
            try {
                return (zzb) super.zzaeH();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzaQ(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (this.zzcvl != 0) {
                zzu += zzbxm.zzL(1, this.zzcvl);
            }
            if (!(this.zzcvm == null || this.zzcvm.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(2, this.zzcvm);
            }
            return (this.version == null || this.version.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)) ? zzu : zzu + zzbxm.zzr(3, this.version);
        }
    }

    public static final class zzc extends zzbxn<zzc> implements Cloneable {
        public byte[] zzcvn;
        public String zzcvo;
        public byte[][] zzcvp;
        public boolean zzcvq;

        public zzc() {
            zzaeZ();
        }

        public /* synthetic */ Object clone() {
            return zzafa();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzbxy_zzc = (zzc) obj;
            if (!Arrays.equals(this.zzcvn, com_google_android_gms_internal_zzbxy_zzc.zzcvn)) {
                return false;
            }
            if (this.zzcvo == null) {
                if (com_google_android_gms_internal_zzbxy_zzc.zzcvo != null) {
                    return false;
                }
            } else if (!this.zzcvo.equals(com_google_android_gms_internal_zzbxy_zzc.zzcvo)) {
                return false;
            }
            return (zzbxr.zza(this.zzcvp, com_google_android_gms_internal_zzbxy_zzc.zzcvp) && this.zzcvq == com_google_android_gms_internal_zzbxy_zzc.zzcvq) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbxy_zzc.zzcuI == null || com_google_android_gms_internal_zzbxy_zzc.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbxy_zzc.zzcuI) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcvq ? 1231 : 1237) + (((((this.zzcvo == null ? 0 : this.zzcvo.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzcvn)) * 31)) * 31) + zzbxr.zzb(this.zzcvp)) * 31)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (!Arrays.equals(this.zzcvn, zzbxw.zzcvd)) {
                com_google_android_gms_internal_zzbxm.zzb(1, this.zzcvn);
            }
            if (this.zzcvp != null && this.zzcvp.length > 0) {
                for (byte[] bArr : this.zzcvp) {
                    if (bArr != null) {
                        com_google_android_gms_internal_zzbxm.zzb(2, bArr);
                    }
                }
            }
            if (this.zzcvq) {
                com_google_android_gms_internal_zzbxm.zzg(3, this.zzcvq);
            }
            if (!(this.zzcvo == null || this.zzcvo.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(4, this.zzcvo);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zzc zzaR(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.zzcvn = com_google_android_gms_internal_zzbxl.readBytes();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        int zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 18);
                        zzaeo = this.zzcvp == null ? 0 : this.zzcvp.length;
                        Object obj = new byte[(zzb + zzaeo)][];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcvp, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.readBytes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.readBytes();
                        this.zzcvp = obj;
                        continue;
                    case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                        this.zzcvq = com_google_android_gms_internal_zzbxl.zzaeu();
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzcvo = com_google_android_gms_internal_zzbxl.readString();
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

        public /* synthetic */ zzbxn zzaeH() {
            return (zzc) clone();
        }

        public /* synthetic */ zzbxt zzaeI() {
            return (zzc) clone();
        }

        public zzc zzaeZ() {
            this.zzcvn = zzbxw.zzcvd;
            this.zzcvo = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvp = zzbxw.zzcvc;
            this.zzcvq = false;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zzc zzafa() {
            try {
                zzc com_google_android_gms_internal_zzbxy_zzc = (zzc) super.zzaeH();
                if (this.zzcvp != null && this.zzcvp.length > 0) {
                    com_google_android_gms_internal_zzbxy_zzc.zzcvp = (byte[][]) this.zzcvp.clone();
                }
                return com_google_android_gms_internal_zzbxy_zzc;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzaR(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int i = 0;
            int zzu = super.zzu();
            if (!Arrays.equals(this.zzcvn, zzbxw.zzcvd)) {
                zzu += zzbxm.zzc(1, this.zzcvn);
            }
            if (this.zzcvp != null && this.zzcvp.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.zzcvp.length) {
                    byte[] bArr = this.zzcvp[i];
                    if (bArr != null) {
                        i3++;
                        i2 += zzbxm.zzai(bArr);
                    }
                    i++;
                }
                zzu = (zzu + i2) + (i3 * 1);
            }
            if (this.zzcvq) {
                zzu += zzbxm.zzh(3, this.zzcvq);
            }
            return (this.zzcvo == null || this.zzcvo.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)) ? zzu : zzu + zzbxm.zzr(4, this.zzcvo);
        }
    }

    public static final class zzd extends zzbxn<zzd> implements Cloneable {
        public String tag;
        public boolean zzced;
        public String zzcvA;
        public zza zzcvB;
        public String zzcvC;
        public long zzcvD;
        public zzc zzcvE;
        public byte[] zzcvF;
        public String zzcvG;
        public int zzcvH;
        public int[] zzcvI;
        public long zzcvJ;
        public zzf zzcvK;
        public long zzcvr;
        public long zzcvs;
        public long zzcvt;
        public int zzcvu;
        public zze[] zzcvv;
        public byte[] zzcvw;
        public zzb zzcvx;
        public byte[] zzcvy;
        public String zzcvz;
        public int zzri;

        public zzd() {
            zzafb();
        }

        public /* synthetic */ Object clone() {
            return zzafc();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzbxy_zzd = (zzd) obj;
            if (this.zzcvr != com_google_android_gms_internal_zzbxy_zzd.zzcvr || this.zzcvs != com_google_android_gms_internal_zzbxy_zzd.zzcvs || this.zzcvt != com_google_android_gms_internal_zzbxy_zzd.zzcvt) {
                return false;
            }
            if (this.tag == null) {
                if (com_google_android_gms_internal_zzbxy_zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(com_google_android_gms_internal_zzbxy_zzd.tag)) {
                return false;
            }
            if (this.zzcvu != com_google_android_gms_internal_zzbxy_zzd.zzcvu || this.zzri != com_google_android_gms_internal_zzbxy_zzd.zzri || this.zzced != com_google_android_gms_internal_zzbxy_zzd.zzced || !zzbxr.equals(this.zzcvv, com_google_android_gms_internal_zzbxy_zzd.zzcvv) || !Arrays.equals(this.zzcvw, com_google_android_gms_internal_zzbxy_zzd.zzcvw)) {
                return false;
            }
            if (this.zzcvx == null) {
                if (com_google_android_gms_internal_zzbxy_zzd.zzcvx != null) {
                    return false;
                }
            } else if (!this.zzcvx.equals(com_google_android_gms_internal_zzbxy_zzd.zzcvx)) {
                return false;
            }
            if (!Arrays.equals(this.zzcvy, com_google_android_gms_internal_zzbxy_zzd.zzcvy)) {
                return false;
            }
            if (this.zzcvz == null) {
                if (com_google_android_gms_internal_zzbxy_zzd.zzcvz != null) {
                    return false;
                }
            } else if (!this.zzcvz.equals(com_google_android_gms_internal_zzbxy_zzd.zzcvz)) {
                return false;
            }
            if (this.zzcvA == null) {
                if (com_google_android_gms_internal_zzbxy_zzd.zzcvA != null) {
                    return false;
                }
            } else if (!this.zzcvA.equals(com_google_android_gms_internal_zzbxy_zzd.zzcvA)) {
                return false;
            }
            if (this.zzcvB == null) {
                if (com_google_android_gms_internal_zzbxy_zzd.zzcvB != null) {
                    return false;
                }
            } else if (!this.zzcvB.equals(com_google_android_gms_internal_zzbxy_zzd.zzcvB)) {
                return false;
            }
            if (this.zzcvC == null) {
                if (com_google_android_gms_internal_zzbxy_zzd.zzcvC != null) {
                    return false;
                }
            } else if (!this.zzcvC.equals(com_google_android_gms_internal_zzbxy_zzd.zzcvC)) {
                return false;
            }
            if (this.zzcvD != com_google_android_gms_internal_zzbxy_zzd.zzcvD) {
                return false;
            }
            if (this.zzcvE == null) {
                if (com_google_android_gms_internal_zzbxy_zzd.zzcvE != null) {
                    return false;
                }
            } else if (!this.zzcvE.equals(com_google_android_gms_internal_zzbxy_zzd.zzcvE)) {
                return false;
            }
            if (!Arrays.equals(this.zzcvF, com_google_android_gms_internal_zzbxy_zzd.zzcvF)) {
                return false;
            }
            if (this.zzcvG == null) {
                if (com_google_android_gms_internal_zzbxy_zzd.zzcvG != null) {
                    return false;
                }
            } else if (!this.zzcvG.equals(com_google_android_gms_internal_zzbxy_zzd.zzcvG)) {
                return false;
            }
            if (this.zzcvH != com_google_android_gms_internal_zzbxy_zzd.zzcvH || !zzbxr.equals(this.zzcvI, com_google_android_gms_internal_zzbxy_zzd.zzcvI) || this.zzcvJ != com_google_android_gms_internal_zzbxy_zzd.zzcvJ) {
                return false;
            }
            if (this.zzcvK == null) {
                if (com_google_android_gms_internal_zzbxy_zzd.zzcvK != null) {
                    return false;
                }
            } else if (!this.zzcvK.equals(com_google_android_gms_internal_zzbxy_zzd.zzcvK)) {
                return false;
            }
            return (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbxy_zzd.zzcuI == null || com_google_android_gms_internal_zzbxy_zzd.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbxy_zzd.zzcuI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcvK == null ? 0 : this.zzcvK.hashCode()) + (((((((((this.zzcvG == null ? 0 : this.zzcvG.hashCode()) + (((((this.zzcvE == null ? 0 : this.zzcvE.hashCode()) + (((((this.zzcvC == null ? 0 : this.zzcvC.hashCode()) + (((this.zzcvB == null ? 0 : this.zzcvB.hashCode()) + (((this.zzcvA == null ? 0 : this.zzcvA.hashCode()) + (((this.zzcvz == null ? 0 : this.zzcvz.hashCode()) + (((((this.zzcvx == null ? 0 : this.zzcvx.hashCode()) + (((((((this.zzced ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzcvr ^ (this.zzcvr >>> 32)))) * 31) + ((int) (this.zzcvs ^ (this.zzcvs >>> 32)))) * 31) + ((int) (this.zzcvt ^ (this.zzcvt >>> 32)))) * 31)) * 31) + this.zzcvu) * 31) + this.zzri) * 31)) * 31) + zzbxr.hashCode(this.zzcvv)) * 31) + Arrays.hashCode(this.zzcvw)) * 31)) * 31) + Arrays.hashCode(this.zzcvy)) * 31)) * 31)) * 31)) * 31)) * 31) + ((int) (this.zzcvD ^ (this.zzcvD >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.zzcvF)) * 31)) * 31) + this.zzcvH) * 31) + zzbxr.hashCode(this.zzcvI)) * 31) + ((int) (this.zzcvJ ^ (this.zzcvJ >>> 32)))) * 31)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            int i = 0;
            if (this.zzcvr != 0) {
                com_google_android_gms_internal_zzbxm.zzb(1, this.zzcvr);
            }
            if (!(this.tag == null || this.tag.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(2, this.tag);
            }
            if (this.zzcvv != null && this.zzcvv.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcvv) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        com_google_android_gms_internal_zzbxm.zza(3, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            if (!Arrays.equals(this.zzcvw, zzbxw.zzcvd)) {
                com_google_android_gms_internal_zzbxm.zzb(4, this.zzcvw);
            }
            if (!Arrays.equals(this.zzcvy, zzbxw.zzcvd)) {
                com_google_android_gms_internal_zzbxm.zzb(6, this.zzcvy);
            }
            if (this.zzcvB != null) {
                com_google_android_gms_internal_zzbxm.zza(7, this.zzcvB);
            }
            if (!(this.zzcvz == null || this.zzcvz.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(8, this.zzcvz);
            }
            if (this.zzcvx != null) {
                com_google_android_gms_internal_zzbxm.zza(9, this.zzcvx);
            }
            if (this.zzced) {
                com_google_android_gms_internal_zzbxm.zzg(10, this.zzced);
            }
            if (this.zzcvu != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(11, this.zzcvu);
            }
            if (this.zzri != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(12, this.zzri);
            }
            if (!(this.zzcvA == null || this.zzcvA.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(13, this.zzcvA);
            }
            if (!(this.zzcvC == null || this.zzcvC.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(14, this.zzcvC);
            }
            if (this.zzcvD != 180000) {
                com_google_android_gms_internal_zzbxm.zzd(15, this.zzcvD);
            }
            if (this.zzcvE != null) {
                com_google_android_gms_internal_zzbxm.zza(16, this.zzcvE);
            }
            if (this.zzcvs != 0) {
                com_google_android_gms_internal_zzbxm.zzb(17, this.zzcvs);
            }
            if (!Arrays.equals(this.zzcvF, zzbxw.zzcvd)) {
                com_google_android_gms_internal_zzbxm.zzb(18, this.zzcvF);
            }
            if (this.zzcvH != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(19, this.zzcvH);
            }
            if (this.zzcvI != null && this.zzcvI.length > 0) {
                while (i < this.zzcvI.length) {
                    com_google_android_gms_internal_zzbxm.zzJ(20, this.zzcvI[i]);
                    i++;
                }
            }
            if (this.zzcvt != 0) {
                com_google_android_gms_internal_zzbxm.zzb(21, this.zzcvt);
            }
            if (this.zzcvJ != 0) {
                com_google_android_gms_internal_zzbxm.zzb(22, this.zzcvJ);
            }
            if (this.zzcvK != null) {
                com_google_android_gms_internal_zzbxm.zza(23, this.zzcvK);
            }
            if (!(this.zzcvG == null || this.zzcvG.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(24, this.zzcvG);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zzd zzaS(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                int zzb;
                Object obj;
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        this.zzcvr = com_google_android_gms_internal_zzbxl.zzaer();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        this.tag = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 26);
                        zzaeo = this.zzcvv == null ? 0 : this.zzcvv.length;
                        obj = new zze[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcvv, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zze();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zze();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzcvv = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzcvw = com_google_android_gms_internal_zzbxl.readBytes();
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.zzcvy = com_google_android_gms_internal_zzbxl.readBytes();
                        continue;
                    case C0268R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        if (this.zzcvB == null) {
                            this.zzcvB = new zza();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzcvB);
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                        this.zzcvz = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                        if (this.zzcvx == null) {
                            this.zzcvx = new zzb();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzcvx);
                        continue;
                    case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        this.zzced = com_google_android_gms_internal_zzbxl.zzaeu();
                        continue;
                    case C0268R.styleable.AppCompatTheme_colorControlHighlight /*88*/:
                        this.zzcvu = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case C0268R.styleable.AppCompatTheme_alertDialogTheme /*96*/:
                        this.zzri = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case C0268R.styleable.AppCompatTheme_editTextStyle /*106*/:
                        this.zzcvA = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                        this.zzcvC = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case 120:
                        this.zzcvD = com_google_android_gms_internal_zzbxl.zzaew();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        if (this.zzcvE == null) {
                            this.zzcvE = new zzc();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzcvE);
                        continue;
                    case 136:
                        this.zzcvs = com_google_android_gms_internal_zzbxl.zzaer();
                        continue;
                    case 146:
                        this.zzcvF = com_google_android_gms_internal_zzbxl.readBytes();
                        continue;
                    case 152:
                        zzaeo = com_google_android_gms_internal_zzbxl.zzaes();
                        switch (zzaeo) {
                            case NendAdIconLayout.HORIZONTAL /*0*/:
                            case NendIconError.ERROR_ICONVIEW /*1*/:
                            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                                this.zzcvH = zzaeo;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 160);
                        zzaeo = this.zzcvI == null ? 0 : this.zzcvI.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcvI, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzcvI = obj;
                        continue;
                    case 162:
                        int zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzcvI == null ? 0 : this.zzcvI.length;
                        Object obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzcvI, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzcvI = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case 168:
                        this.zzcvt = com_google_android_gms_internal_zzbxl.zzaer();
                        continue;
                    case 176:
                        this.zzcvJ = com_google_android_gms_internal_zzbxl.zzaer();
                        continue;
                    case 186:
                        if (this.zzcvK == null) {
                            this.zzcvK = new zzf();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzcvK);
                        continue;
                    case 194:
                        this.zzcvG = com_google_android_gms_internal_zzbxl.readString();
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

        public /* synthetic */ zzbxn zzaeH() {
            return (zzd) clone();
        }

        public /* synthetic */ zzbxt zzaeI() {
            return (zzd) clone();
        }

        public zzd zzafb() {
            this.zzcvr = 0;
            this.zzcvs = 0;
            this.zzcvt = 0;
            this.tag = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvu = 0;
            this.zzri = 0;
            this.zzced = false;
            this.zzcvv = zze.zzafd();
            this.zzcvw = zzbxw.zzcvd;
            this.zzcvx = null;
            this.zzcvy = zzbxw.zzcvd;
            this.zzcvz = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvA = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvB = null;
            this.zzcvC = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvD = 180000;
            this.zzcvE = null;
            this.zzcvF = zzbxw.zzcvd;
            this.zzcvG = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcvH = 0;
            this.zzcvI = zzbxw.zzcuW;
            this.zzcvJ = 0;
            this.zzcvK = null;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zzd zzafc() {
            try {
                zzd com_google_android_gms_internal_zzbxy_zzd = (zzd) super.zzaeH();
                if (this.zzcvv != null && this.zzcvv.length > 0) {
                    com_google_android_gms_internal_zzbxy_zzd.zzcvv = new zze[this.zzcvv.length];
                    for (int i = 0; i < this.zzcvv.length; i++) {
                        if (this.zzcvv[i] != null) {
                            com_google_android_gms_internal_zzbxy_zzd.zzcvv[i] = (zze) this.zzcvv[i].clone();
                        }
                    }
                }
                if (this.zzcvx != null) {
                    com_google_android_gms_internal_zzbxy_zzd.zzcvx = (zzb) this.zzcvx.clone();
                }
                if (this.zzcvB != null) {
                    com_google_android_gms_internal_zzbxy_zzd.zzcvB = (zza) this.zzcvB.clone();
                }
                if (this.zzcvE != null) {
                    com_google_android_gms_internal_zzbxy_zzd.zzcvE = (zzc) this.zzcvE.clone();
                }
                if (this.zzcvI != null && this.zzcvI.length > 0) {
                    com_google_android_gms_internal_zzbxy_zzd.zzcvI = (int[]) this.zzcvI.clone();
                }
                if (this.zzcvK != null) {
                    com_google_android_gms_internal_zzbxy_zzd.zzcvK = (zzf) this.zzcvK.clone();
                }
                return com_google_android_gms_internal_zzbxy_zzd;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzaS(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int i;
            int i2 = 0;
            int zzu = super.zzu();
            if (this.zzcvr != 0) {
                zzu += zzbxm.zzf(1, this.zzcvr);
            }
            if (!(this.tag == null || this.tag.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(2, this.tag);
            }
            if (this.zzcvv != null && this.zzcvv.length > 0) {
                i = zzu;
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcvv) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        i += zzbxm.zzc(3, com_google_android_gms_internal_zzbxt);
                    }
                }
                zzu = i;
            }
            if (!Arrays.equals(this.zzcvw, zzbxw.zzcvd)) {
                zzu += zzbxm.zzc(4, this.zzcvw);
            }
            if (!Arrays.equals(this.zzcvy, zzbxw.zzcvd)) {
                zzu += zzbxm.zzc(6, this.zzcvy);
            }
            if (this.zzcvB != null) {
                zzu += zzbxm.zzc(7, this.zzcvB);
            }
            if (!(this.zzcvz == null || this.zzcvz.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(8, this.zzcvz);
            }
            if (this.zzcvx != null) {
                zzu += zzbxm.zzc(9, this.zzcvx);
            }
            if (this.zzced) {
                zzu += zzbxm.zzh(10, this.zzced);
            }
            if (this.zzcvu != 0) {
                zzu += zzbxm.zzL(11, this.zzcvu);
            }
            if (this.zzri != 0) {
                zzu += zzbxm.zzL(12, this.zzri);
            }
            if (!(this.zzcvA == null || this.zzcvA.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(13, this.zzcvA);
            }
            if (!(this.zzcvC == null || this.zzcvC.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(14, this.zzcvC);
            }
            if (this.zzcvD != 180000) {
                zzu += zzbxm.zzh(15, this.zzcvD);
            }
            if (this.zzcvE != null) {
                zzu += zzbxm.zzc(16, this.zzcvE);
            }
            if (this.zzcvs != 0) {
                zzu += zzbxm.zzf(17, this.zzcvs);
            }
            if (!Arrays.equals(this.zzcvF, zzbxw.zzcvd)) {
                zzu += zzbxm.zzc(18, this.zzcvF);
            }
            if (this.zzcvH != 0) {
                zzu += zzbxm.zzL(19, this.zzcvH);
            }
            if (this.zzcvI != null && this.zzcvI.length > 0) {
                i = 0;
                while (i2 < this.zzcvI.length) {
                    i += zzbxm.zzrg(this.zzcvI[i2]);
                    i2++;
                }
                zzu = (zzu + i) + (this.zzcvI.length * 2);
            }
            if (this.zzcvt != 0) {
                zzu += zzbxm.zzf(21, this.zzcvt);
            }
            if (this.zzcvJ != 0) {
                zzu += zzbxm.zzf(22, this.zzcvJ);
            }
            if (this.zzcvK != null) {
                zzu += zzbxm.zzc(23, this.zzcvK);
            }
            return (this.zzcvG == null || this.zzcvG.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)) ? zzu : zzu + zzbxm.zzr(24, this.zzcvG);
        }
    }

    public static final class zze extends zzbxn<zze> implements Cloneable {
        private static volatile zze[] zzcvL;
        public String value;
        public String zzaB;

        public zze() {
            zzafe();
        }

        public static zze[] zzafd() {
            if (zzcvL == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzcvL == null) {
                        zzcvL = new zze[0];
                    }
                }
            }
            return zzcvL;
        }

        public /* synthetic */ Object clone() {
            return zzaff();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzbxy_zze = (zze) obj;
            if (this.zzaB == null) {
                if (com_google_android_gms_internal_zzbxy_zze.zzaB != null) {
                    return false;
                }
            } else if (!this.zzaB.equals(com_google_android_gms_internal_zzbxy_zze.zzaB)) {
                return false;
            }
            if (this.value == null) {
                if (com_google_android_gms_internal_zzbxy_zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(com_google_android_gms_internal_zzbxy_zze.value)) {
                return false;
            }
            return (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbxy_zze.zzcuI == null || com_google_android_gms_internal_zzbxy_zze.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbxy_zze.zzcuI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.zzaB == null ? 0 : this.zzaB.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (!(this.zzaB == null || this.zzaB.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(1, this.zzaB);
            }
            if (!(this.value == null || this.value.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(2, this.value);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zze zzaT(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.zzaB = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        this.value = com_google_android_gms_internal_zzbxl.readString();
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

        public /* synthetic */ zzbxn zzaeH() {
            return (zze) clone();
        }

        public /* synthetic */ zzbxt zzaeI() {
            return (zze) clone();
        }

        public zze zzafe() {
            this.zzaB = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.value = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zze zzaff() {
            try {
                return (zze) super.zzaeH();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzaT(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (!(this.zzaB == null || this.zzaB.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(1, this.zzaB);
            }
            return (this.value == null || this.value.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)) ? zzu : zzu + zzbxm.zzr(2, this.value);
        }
    }

    public static final class zzf extends zzbxn<zzf> implements Cloneable {
        public int zzcvM;
        public int zzcvN;

        public zzf() {
            zzafg();
        }

        public /* synthetic */ Object clone() {
            return zzafh();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzbxy_zzf = (zzf) obj;
            return (this.zzcvM == com_google_android_gms_internal_zzbxy_zzf.zzcvM && this.zzcvN == com_google_android_gms_internal_zzbxy_zzf.zzcvN) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbxy_zzf.zzcuI == null || com_google_android_gms_internal_zzbxy_zzf.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbxy_zzf.zzcuI) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.zzcvM) * 31) + this.zzcvN) * 31;
            int hashCode2 = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.zzcvM != -1) {
                com_google_android_gms_internal_zzbxm.zzJ(1, this.zzcvM);
            }
            if (this.zzcvN != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(2, this.zzcvN);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zzf zzaU(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        zzaeo = com_google_android_gms_internal_zzbxl.zzaes();
                        switch (zzaeo) {
                            case FirebaseRemoteConfig.LAST_FETCH_STATUS_SUCCESS /*-1*/:
                            case NendAdIconLayout.HORIZONTAL /*0*/:
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
                                this.zzcvM = zzaeo;
                                break;
                            default:
                                continue;
                        }
                    case CommonStatusCodes.CANCELED /*16*/:
                        zzaeo = com_google_android_gms_internal_zzbxl.zzaes();
                        switch (zzaeo) {
                            case NendAdIconLayout.HORIZONTAL /*0*/:
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
                            case AnswersEvent.MAX_STRING_LENGTH /*100*/:
                                this.zzcvN = zzaeo;
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!super.zza(com_google_android_gms_internal_zzbxl, zzaeo)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public /* synthetic */ zzbxn zzaeH() {
            return (zzf) clone();
        }

        public /* synthetic */ zzbxt zzaeI() {
            return (zzf) clone();
        }

        public zzf zzafg() {
            this.zzcvM = -1;
            this.zzcvN = 0;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zzf zzafh() {
            try {
                return (zzf) super.zzaeH();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzaU(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (this.zzcvM != -1) {
                zzu += zzbxm.zzL(1, this.zzcvM);
            }
            return this.zzcvN != 0 ? zzu + zzbxm.zzL(2, this.zzcvN) : zzu;
        }
    }
}
