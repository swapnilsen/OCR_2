package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v7.appcompat.C0268R;
import com.google.ads.AdSize;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public interface zzaj {

    public static final class zza extends zzbxn<zza> {
        public int level;
        public int zzkn;
        public int zzko;

        public zza() {
            zzw();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzaj_zza = (zza) obj;
            return (this.level == com_google_android_gms_internal_zzaj_zza.level && this.zzkn == com_google_android_gms_internal_zzaj_zza.zzkn && this.zzko == com_google_android_gms_internal_zzaj_zza.zzko) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zza.zzcuI == null || com_google_android_gms_internal_zzaj_zza.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zza.zzcuI) : false;
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zzkn) * 31) + this.zzko) * 31;
            int hashCode2 = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.level != 1) {
                com_google_android_gms_internal_zzbxm.zzJ(1, this.level);
            }
            if (this.zzkn != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(2, this.zzkn);
            }
            if (this.zzko != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(3, this.zzko);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzn(com_google_android_gms_internal_zzbxl);
        }

        public zza zzn(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        zzaeo = com_google_android_gms_internal_zzbxl.zzaes();
                        switch (zzaeo) {
                            case NendIconError.ERROR_ICONVIEW /*1*/:
                            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                                this.level = zzaeo;
                                break;
                            default:
                                continue;
                        }
                    case CommonStatusCodes.CANCELED /*16*/:
                        this.zzkn = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                        this.zzko = com_google_android_gms_internal_zzbxl.zzaes();
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

        protected int zzu() {
            int zzu = super.zzu();
            if (this.level != 1) {
                zzu += zzbxm.zzL(1, this.level);
            }
            if (this.zzkn != 0) {
                zzu += zzbxm.zzL(2, this.zzkn);
            }
            return this.zzko != 0 ? zzu + zzbxm.zzL(3, this.zzko) : zzu;
        }

        public zza zzw() {
            this.level = 1;
            this.zzkn = 0;
            this.zzko = 0;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }
    }

    public static final class zzb extends zzbxn<zzb> {
        private static volatile zzb[] zzkp;
        public int name;
        public int[] zzkq;
        public int zzkr;
        public boolean zzks;
        public boolean zzkt;

        public zzb() {
            zzy();
        }

        public static zzb[] zzx() {
            if (zzkp == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzkp == null) {
                        zzkp = new zzb[0];
                    }
                }
            }
            return zzkp;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzaj_zzb = (zzb) obj;
            return (zzbxr.equals(this.zzkq, com_google_android_gms_internal_zzaj_zzb.zzkq) && this.zzkr == com_google_android_gms_internal_zzaj_zzb.zzkr && this.name == com_google_android_gms_internal_zzaj_zzb.name && this.zzks == com_google_android_gms_internal_zzaj_zzb.zzks && this.zzkt == com_google_android_gms_internal_zzaj_zzb.zzkt) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zzb.zzcuI == null || com_google_android_gms_internal_zzaj_zzb.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zzb.zzcuI) : false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzks ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzbxr.hashCode(this.zzkq)) * 31) + this.zzkr) * 31) + this.name) * 31)) * 31;
            if (!this.zzkt) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode + i;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.zzkt) {
                com_google_android_gms_internal_zzbxm.zzg(1, this.zzkt);
            }
            com_google_android_gms_internal_zzbxm.zzJ(2, this.zzkr);
            if (this.zzkq != null && this.zzkq.length > 0) {
                for (int zzJ : this.zzkq) {
                    com_google_android_gms_internal_zzbxm.zzJ(3, zzJ);
                }
            }
            if (this.name != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(4, this.name);
            }
            if (this.zzks) {
                com_google_android_gms_internal_zzbxm.zzg(6, this.zzks);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzo(com_google_android_gms_internal_zzbxl);
        }

        public zzb zzo(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                int zzb;
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        this.zzkt = com_google_android_gms_internal_zzbxl.zzaeu();
                        continue;
                    case CommonStatusCodes.CANCELED /*16*/:
                        this.zzkr = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 24);
                        zzaeo = this.zzkq == null ? 0 : this.zzkq.length;
                        Object obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkq, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzkq = obj;
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        int zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzkq == null ? 0 : this.zzkq.length;
                        Object obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzkq, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzkq = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.name = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case C0268R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        this.zzks = com_google_android_gms_internal_zzbxl.zzaeu();
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

        protected int zzu() {
            int i = 0;
            int zzu = super.zzu();
            if (this.zzkt) {
                zzu += zzbxm.zzh(1, this.zzkt);
            }
            int zzL = zzbxm.zzL(2, this.zzkr) + zzu;
            if (this.zzkq == null || this.zzkq.length <= 0) {
                zzu = zzL;
            } else {
                for (int zzrg : this.zzkq) {
                    i += zzbxm.zzrg(zzrg);
                }
                zzu = (zzL + i) + (this.zzkq.length * 1);
            }
            if (this.name != 0) {
                zzu += zzbxm.zzL(4, this.name);
            }
            return this.zzks ? zzu + zzbxm.zzh(6, this.zzks) : zzu;
        }

        public zzb zzy() {
            this.zzkq = zzbxw.zzcuW;
            this.zzkr = 0;
            this.name = 0;
            this.zzks = false;
            this.zzkt = false;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }
    }

    public static final class zzc extends zzbxn<zzc> {
        private static volatile zzc[] zzku;
        public String zzaB;
        public long zzkv;
        public long zzkw;
        public boolean zzkx;
        public long zzky;

        public zzc() {
            zzA();
        }

        public static zzc[] zzz() {
            if (zzku == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzku == null) {
                        zzku = new zzc[0];
                    }
                }
            }
            return zzku;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzaj_zzc = (zzc) obj;
            if (this.zzaB == null) {
                if (com_google_android_gms_internal_zzaj_zzc.zzaB != null) {
                    return false;
                }
            } else if (!this.zzaB.equals(com_google_android_gms_internal_zzaj_zzc.zzaB)) {
                return false;
            }
            return (this.zzkv == com_google_android_gms_internal_zzaj_zzc.zzkv && this.zzkw == com_google_android_gms_internal_zzaj_zzc.zzkw && this.zzkx == com_google_android_gms_internal_zzaj_zzc.zzkx && this.zzky == com_google_android_gms_internal_zzaj_zzc.zzky) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zzc.zzcuI == null || com_google_android_gms_internal_zzaj_zzc.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zzc.zzcuI) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzkx ? 1231 : 1237) + (((((((this.zzaB == null ? 0 : this.zzaB.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zzkv ^ (this.zzkv >>> 32)))) * 31) + ((int) (this.zzkw ^ (this.zzkw >>> 32)))) * 31)) * 31) + ((int) (this.zzky ^ (this.zzky >>> 32)))) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public zzc zzA() {
            this.zzaB = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzkv = 0;
            this.zzkw = 2147483647L;
            this.zzkx = false;
            this.zzky = 0;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (!(this.zzaB == null || this.zzaB.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(1, this.zzaB);
            }
            if (this.zzkv != 0) {
                com_google_android_gms_internal_zzbxm.zzb(2, this.zzkv);
            }
            if (this.zzkw != 2147483647L) {
                com_google_android_gms_internal_zzbxm.zzb(3, this.zzkw);
            }
            if (this.zzkx) {
                com_google_android_gms_internal_zzbxm.zzg(4, this.zzkx);
            }
            if (this.zzky != 0) {
                com_google_android_gms_internal_zzbxm.zzb(5, this.zzky);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzp(com_google_android_gms_internal_zzbxl);
        }

        public zzc zzp(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.zzaB = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case CommonStatusCodes.CANCELED /*16*/:
                        this.zzkv = com_google_android_gms_internal_zzbxl.zzaer();
                        continue;
                    case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                        this.zzkw = com_google_android_gms_internal_zzbxl.zzaer();
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.zzkx = com_google_android_gms_internal_zzbxl.zzaeu();
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        this.zzky = com_google_android_gms_internal_zzbxl.zzaer();
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

        protected int zzu() {
            int zzu = super.zzu();
            if (!(this.zzaB == null || this.zzaB.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(1, this.zzaB);
            }
            if (this.zzkv != 0) {
                zzu += zzbxm.zzf(2, this.zzkv);
            }
            if (this.zzkw != 2147483647L) {
                zzu += zzbxm.zzf(3, this.zzkw);
            }
            if (this.zzkx) {
                zzu += zzbxm.zzh(4, this.zzkx);
            }
            return this.zzky != 0 ? zzu + zzbxm.zzf(5, this.zzky) : zzu;
        }
    }

    public static final class zzd extends zzbxn<zzd> {
        public com.google.android.gms.internal.zzak.zza[] zzkA;
        public zzc[] zzkB;
        public com.google.android.gms.internal.zzak.zza[] zzkz;

        public zzd() {
            zzB();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzaj_zzd = (zzd) obj;
            return (zzbxr.equals(this.zzkz, com_google_android_gms_internal_zzaj_zzd.zzkz) && zzbxr.equals(this.zzkA, com_google_android_gms_internal_zzaj_zzd.zzkA) && zzbxr.equals(this.zzkB, com_google_android_gms_internal_zzaj_zzd.zzkB)) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zzd.zzcuI == null || com_google_android_gms_internal_zzaj_zzd.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zzd.zzcuI) : false;
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzbxr.hashCode(this.zzkz)) * 31) + zzbxr.hashCode(this.zzkA)) * 31) + zzbxr.hashCode(this.zzkB)) * 31;
            int hashCode2 = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode2 + hashCode;
        }

        public zzd zzB() {
            this.zzkz = com.google.android.gms.internal.zzak.zza.zzL();
            this.zzkA = com.google.android.gms.internal.zzak.zza.zzL();
            this.zzkB = zzc.zzz();
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            int i = 0;
            if (this.zzkz != null && this.zzkz.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzkz) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        com_google_android_gms_internal_zzbxm.zza(1, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            if (this.zzkA != null && this.zzkA.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt2 : this.zzkA) {
                    if (com_google_android_gms_internal_zzbxt2 != null) {
                        com_google_android_gms_internal_zzbxm.zza(2, com_google_android_gms_internal_zzbxt2);
                    }
                }
            }
            if (this.zzkB != null && this.zzkB.length > 0) {
                while (i < this.zzkB.length) {
                    zzbxt com_google_android_gms_internal_zzbxt3 = this.zzkB[i];
                    if (com_google_android_gms_internal_zzbxt3 != null) {
                        com_google_android_gms_internal_zzbxm.zza(3, com_google_android_gms_internal_zzbxt3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzq(com_google_android_gms_internal_zzbxl);
        }

        public zzd zzq(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                int zzb;
                Object obj;
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 10);
                        zzaeo = this.zzkz == null ? 0 : this.zzkz.length;
                        obj = new com.google.android.gms.internal.zzak.zza[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkz, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new com.google.android.gms.internal.zzak.zza();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new com.google.android.gms.internal.zzak.zza();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzkz = obj;
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 18);
                        zzaeo = this.zzkA == null ? 0 : this.zzkA.length;
                        obj = new com.google.android.gms.internal.zzak.zza[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkA, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new com.google.android.gms.internal.zzak.zza();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new com.google.android.gms.internal.zzak.zza();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzkA = obj;
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 26);
                        zzaeo = this.zzkB == null ? 0 : this.zzkB.length;
                        obj = new zzc[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkB, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zzc();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zzc();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzkB = obj;
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

        protected int zzu() {
            int i;
            int i2 = 0;
            int zzu = super.zzu();
            if (this.zzkz != null && this.zzkz.length > 0) {
                i = zzu;
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzkz) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        i += zzbxm.zzc(1, com_google_android_gms_internal_zzbxt);
                    }
                }
                zzu = i;
            }
            if (this.zzkA != null && this.zzkA.length > 0) {
                i = zzu;
                for (zzbxt com_google_android_gms_internal_zzbxt2 : this.zzkA) {
                    if (com_google_android_gms_internal_zzbxt2 != null) {
                        i += zzbxm.zzc(2, com_google_android_gms_internal_zzbxt2);
                    }
                }
                zzu = i;
            }
            if (this.zzkB != null && this.zzkB.length > 0) {
                while (i2 < this.zzkB.length) {
                    zzbxt com_google_android_gms_internal_zzbxt3 = this.zzkB[i2];
                    if (com_google_android_gms_internal_zzbxt3 != null) {
                        zzu += zzbxm.zzc(3, com_google_android_gms_internal_zzbxt3);
                    }
                    i2++;
                }
            }
            return zzu;
        }
    }

    public static final class zze extends zzbxn<zze> {
        private static volatile zze[] zzkC;
        public int key;
        public int value;

        public zze() {
            zzD();
        }

        public static zze[] zzC() {
            if (zzkC == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzkC == null) {
                        zzkC = new zze[0];
                    }
                }
            }
            return zzkC;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzaj_zze = (zze) obj;
            return (this.key == com_google_android_gms_internal_zzaj_zze.key && this.value == com_google_android_gms_internal_zzaj_zze.value) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zze.zzcuI == null || com_google_android_gms_internal_zzaj_zze.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zze.zzcuI) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31;
            int hashCode2 = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode2 + hashCode;
        }

        public zze zzD() {
            this.key = 0;
            this.value = 0;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            com_google_android_gms_internal_zzbxm.zzJ(1, this.key);
            com_google_android_gms_internal_zzbxm.zzJ(2, this.value);
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzr(com_google_android_gms_internal_zzbxl);
        }

        public zze zzr(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        this.key = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case CommonStatusCodes.CANCELED /*16*/:
                        this.value = com_google_android_gms_internal_zzbxl.zzaes();
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

        protected int zzu() {
            return (super.zzu() + zzbxm.zzL(1, this.key)) + zzbxm.zzL(2, this.value);
        }
    }

    public static final class zzf extends zzbxn<zzf> {
        public String version;
        public String[] zzkD;
        public String[] zzkE;
        public com.google.android.gms.internal.zzak.zza[] zzkF;
        public zze[] zzkG;
        public zzb[] zzkH;
        public zzb[] zzkI;
        public zzb[] zzkJ;
        public zzg[] zzkK;
        public String zzkL;
        public String zzkM;
        public String zzkN;
        public zza zzkO;
        public float zzkP;
        public boolean zzkQ;
        public String[] zzkR;
        public int zzkS;

        public zzf() {
            zzE();
        }

        public static zzf zzf(byte[] bArr) {
            return (zzf) zzbxt.zza(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzaj_zzf = (zzf) obj;
            if (!zzbxr.equals(this.zzkD, com_google_android_gms_internal_zzaj_zzf.zzkD) || !zzbxr.equals(this.zzkE, com_google_android_gms_internal_zzaj_zzf.zzkE) || !zzbxr.equals(this.zzkF, com_google_android_gms_internal_zzaj_zzf.zzkF) || !zzbxr.equals(this.zzkG, com_google_android_gms_internal_zzaj_zzf.zzkG) || !zzbxr.equals(this.zzkH, com_google_android_gms_internal_zzaj_zzf.zzkH) || !zzbxr.equals(this.zzkI, com_google_android_gms_internal_zzaj_zzf.zzkI) || !zzbxr.equals(this.zzkJ, com_google_android_gms_internal_zzaj_zzf.zzkJ) || !zzbxr.equals(this.zzkK, com_google_android_gms_internal_zzaj_zzf.zzkK)) {
                return false;
            }
            if (this.zzkL == null) {
                if (com_google_android_gms_internal_zzaj_zzf.zzkL != null) {
                    return false;
                }
            } else if (!this.zzkL.equals(com_google_android_gms_internal_zzaj_zzf.zzkL)) {
                return false;
            }
            if (this.zzkM == null) {
                if (com_google_android_gms_internal_zzaj_zzf.zzkM != null) {
                    return false;
                }
            } else if (!this.zzkM.equals(com_google_android_gms_internal_zzaj_zzf.zzkM)) {
                return false;
            }
            if (this.zzkN == null) {
                if (com_google_android_gms_internal_zzaj_zzf.zzkN != null) {
                    return false;
                }
            } else if (!this.zzkN.equals(com_google_android_gms_internal_zzaj_zzf.zzkN)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzaj_zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzaj_zzf.version)) {
                return false;
            }
            if (this.zzkO == null) {
                if (com_google_android_gms_internal_zzaj_zzf.zzkO != null) {
                    return false;
                }
            } else if (!this.zzkO.equals(com_google_android_gms_internal_zzaj_zzf.zzkO)) {
                return false;
            }
            return (Float.floatToIntBits(this.zzkP) == Float.floatToIntBits(com_google_android_gms_internal_zzaj_zzf.zzkP) && this.zzkQ == com_google_android_gms_internal_zzaj_zzf.zzkQ && zzbxr.equals(this.zzkR, com_google_android_gms_internal_zzaj_zzf.zzkR) && this.zzkS == com_google_android_gms_internal_zzaj_zzf.zzkS) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zzf.zzcuI == null || com_google_android_gms_internal_zzaj_zzf.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zzf.zzcuI) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.zzkQ ? 1231 : 1237) + (((((this.zzkO == null ? 0 : this.zzkO.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzkN == null ? 0 : this.zzkN.hashCode()) + (((this.zzkM == null ? 0 : this.zzkM.hashCode()) + (((this.zzkL == null ? 0 : this.zzkL.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzbxr.hashCode(this.zzkD)) * 31) + zzbxr.hashCode(this.zzkE)) * 31) + zzbxr.hashCode(this.zzkF)) * 31) + zzbxr.hashCode(this.zzkG)) * 31) + zzbxr.hashCode(this.zzkH)) * 31) + zzbxr.hashCode(this.zzkI)) * 31) + zzbxr.hashCode(this.zzkJ)) * 31) + zzbxr.hashCode(this.zzkK)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zzkP)) * 31)) * 31) + zzbxr.hashCode(this.zzkR)) * 31) + this.zzkS) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public zzf zzE() {
            this.zzkD = zzbxw.zzcvb;
            this.zzkE = zzbxw.zzcvb;
            this.zzkF = com.google.android.gms.internal.zzak.zza.zzL();
            this.zzkG = zze.zzC();
            this.zzkH = zzb.zzx();
            this.zzkI = zzb.zzx();
            this.zzkJ = zzb.zzx();
            this.zzkK = zzg.zzF();
            this.zzkL = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzkM = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzkN = "0";
            this.version = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzkO = null;
            this.zzkP = 0.0f;
            this.zzkQ = false;
            this.zzkR = zzbxw.zzcvb;
            this.zzkS = 0;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            int i = 0;
            if (this.zzkE != null && this.zzkE.length > 0) {
                for (String str : this.zzkE) {
                    if (str != null) {
                        com_google_android_gms_internal_zzbxm.zzq(1, str);
                    }
                }
            }
            if (this.zzkF != null && this.zzkF.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzkF) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        com_google_android_gms_internal_zzbxm.zza(2, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            if (this.zzkG != null && this.zzkG.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt2 : this.zzkG) {
                    if (com_google_android_gms_internal_zzbxt2 != null) {
                        com_google_android_gms_internal_zzbxm.zza(3, com_google_android_gms_internal_zzbxt2);
                    }
                }
            }
            if (this.zzkH != null && this.zzkH.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt22 : this.zzkH) {
                    if (com_google_android_gms_internal_zzbxt22 != null) {
                        com_google_android_gms_internal_zzbxm.zza(4, com_google_android_gms_internal_zzbxt22);
                    }
                }
            }
            if (this.zzkI != null && this.zzkI.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt222 : this.zzkI) {
                    if (com_google_android_gms_internal_zzbxt222 != null) {
                        com_google_android_gms_internal_zzbxm.zza(5, com_google_android_gms_internal_zzbxt222);
                    }
                }
            }
            if (this.zzkJ != null && this.zzkJ.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt2222 : this.zzkJ) {
                    if (com_google_android_gms_internal_zzbxt2222 != null) {
                        com_google_android_gms_internal_zzbxm.zza(6, com_google_android_gms_internal_zzbxt2222);
                    }
                }
            }
            if (this.zzkK != null && this.zzkK.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt22222 : this.zzkK) {
                    if (com_google_android_gms_internal_zzbxt22222 != null) {
                        com_google_android_gms_internal_zzbxm.zza(7, com_google_android_gms_internal_zzbxt22222);
                    }
                }
            }
            if (!(this.zzkL == null || this.zzkL.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(9, this.zzkL);
            }
            if (!(this.zzkM == null || this.zzkM.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(10, this.zzkM);
            }
            if (!(this.zzkN == null || this.zzkN.equals("0"))) {
                com_google_android_gms_internal_zzbxm.zzq(12, this.zzkN);
            }
            if (!(this.version == null || this.version.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(13, this.version);
            }
            if (this.zzkO != null) {
                com_google_android_gms_internal_zzbxm.zza(14, this.zzkO);
            }
            if (Float.floatToIntBits(this.zzkP) != Float.floatToIntBits(0.0f)) {
                com_google_android_gms_internal_zzbxm.zzc(15, this.zzkP);
            }
            if (this.zzkR != null && this.zzkR.length > 0) {
                for (String str2 : this.zzkR) {
                    if (str2 != null) {
                        com_google_android_gms_internal_zzbxm.zzq(16, str2);
                    }
                }
            }
            if (this.zzkS != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(17, this.zzkS);
            }
            if (this.zzkQ) {
                com_google_android_gms_internal_zzbxm.zzg(18, this.zzkQ);
            }
            if (this.zzkD != null && this.zzkD.length > 0) {
                while (i < this.zzkD.length) {
                    String str3 = this.zzkD[i];
                    if (str3 != null) {
                        com_google_android_gms_internal_zzbxm.zzq(19, str3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzs(com_google_android_gms_internal_zzbxl);
        }

        public zzf zzs(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                int zzb;
                Object obj;
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 10);
                        zzaeo = this.zzkE == null ? 0 : this.zzkE.length;
                        obj = new String[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkE, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                        this.zzkE = obj;
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 18);
                        zzaeo = this.zzkF == null ? 0 : this.zzkF.length;
                        obj = new com.google.android.gms.internal.zzak.zza[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkF, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new com.google.android.gms.internal.zzak.zza();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new com.google.android.gms.internal.zzak.zza();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzkF = obj;
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 26);
                        zzaeo = this.zzkG == null ? 0 : this.zzkG.length;
                        obj = new zze[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkG, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zze();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zze();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzkG = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 34);
                        zzaeo = this.zzkH == null ? 0 : this.zzkH.length;
                        obj = new zzb[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkH, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zzb();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zzb();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzkH = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 42);
                        zzaeo = this.zzkI == null ? 0 : this.zzkI.length;
                        obj = new zzb[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkI, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zzb();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zzb();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzkI = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 50);
                        zzaeo = this.zzkJ == null ? 0 : this.zzkJ.length;
                        obj = new zzb[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkJ, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zzb();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zzb();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzkJ = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 58);
                        zzaeo = this.zzkK == null ? 0 : this.zzkK.length;
                        obj = new zzg[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkK, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zzg();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zzg();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzkK = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                        this.zzkL = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        this.zzkM = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                        this.zzkN = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_editTextStyle /*106*/:
                        this.version = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                        if (this.zzkO == null) {
                            this.zzkO = new zza();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzkO);
                        continue;
                    case 125:
                        this.zzkP = com_google_android_gms_internal_zzbxl.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, TransportMediator.KEYCODE_MEDIA_RECORD);
                        zzaeo = this.zzkR == null ? 0 : this.zzkR.length;
                        obj = new String[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkR, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                        this.zzkR = obj;
                        continue;
                    case 136:
                        this.zzkS = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case 144:
                        this.zzkQ = com_google_android_gms_internal_zzbxl.zzaeu();
                        continue;
                    case 154:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 154);
                        zzaeo = this.zzkD == null ? 0 : this.zzkD.length;
                        obj = new String[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkD, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.readString();
                        this.zzkD = obj;
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

        protected int zzu() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzu = super.zzu();
            if (this.zzkE == null || this.zzkE.length <= 0) {
                i = zzu;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzkE) {
                    if (str != null) {
                        i3++;
                        i2 += zzbxm.zzkb(str);
                    }
                }
                i = (zzu + i2) + (i3 * 1);
            }
            if (this.zzkF != null && this.zzkF.length > 0) {
                i2 = i;
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzkF) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        i2 += zzbxm.zzc(2, com_google_android_gms_internal_zzbxt);
                    }
                }
                i = i2;
            }
            if (this.zzkG != null && this.zzkG.length > 0) {
                i2 = i;
                for (zzbxt com_google_android_gms_internal_zzbxt2 : this.zzkG) {
                    if (com_google_android_gms_internal_zzbxt2 != null) {
                        i2 += zzbxm.zzc(3, com_google_android_gms_internal_zzbxt2);
                    }
                }
                i = i2;
            }
            if (this.zzkH != null && this.zzkH.length > 0) {
                i2 = i;
                for (zzbxt com_google_android_gms_internal_zzbxt22 : this.zzkH) {
                    if (com_google_android_gms_internal_zzbxt22 != null) {
                        i2 += zzbxm.zzc(4, com_google_android_gms_internal_zzbxt22);
                    }
                }
                i = i2;
            }
            if (this.zzkI != null && this.zzkI.length > 0) {
                i2 = i;
                for (zzbxt com_google_android_gms_internal_zzbxt222 : this.zzkI) {
                    if (com_google_android_gms_internal_zzbxt222 != null) {
                        i2 += zzbxm.zzc(5, com_google_android_gms_internal_zzbxt222);
                    }
                }
                i = i2;
            }
            if (this.zzkJ != null && this.zzkJ.length > 0) {
                i2 = i;
                for (zzbxt com_google_android_gms_internal_zzbxt2222 : this.zzkJ) {
                    if (com_google_android_gms_internal_zzbxt2222 != null) {
                        i2 += zzbxm.zzc(6, com_google_android_gms_internal_zzbxt2222);
                    }
                }
                i = i2;
            }
            if (this.zzkK != null && this.zzkK.length > 0) {
                i2 = i;
                for (zzbxt com_google_android_gms_internal_zzbxt22222 : this.zzkK) {
                    if (com_google_android_gms_internal_zzbxt22222 != null) {
                        i2 += zzbxm.zzc(7, com_google_android_gms_internal_zzbxt22222);
                    }
                }
                i = i2;
            }
            if (!(this.zzkL == null || this.zzkL.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                i += zzbxm.zzr(9, this.zzkL);
            }
            if (!(this.zzkM == null || this.zzkM.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                i += zzbxm.zzr(10, this.zzkM);
            }
            if (!(this.zzkN == null || this.zzkN.equals("0"))) {
                i += zzbxm.zzr(12, this.zzkN);
            }
            if (!(this.version == null || this.version.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                i += zzbxm.zzr(13, this.version);
            }
            if (this.zzkO != null) {
                i += zzbxm.zzc(14, this.zzkO);
            }
            if (Float.floatToIntBits(this.zzkP) != Float.floatToIntBits(0.0f)) {
                i += zzbxm.zzd(15, this.zzkP);
            }
            if (this.zzkR != null && this.zzkR.length > 0) {
                i3 = 0;
                zzu = 0;
                for (String str2 : this.zzkR) {
                    if (str2 != null) {
                        zzu++;
                        i3 += zzbxm.zzkb(str2);
                    }
                }
                i = (i + i3) + (zzu * 2);
            }
            if (this.zzkS != 0) {
                i += zzbxm.zzL(17, this.zzkS);
            }
            if (this.zzkQ) {
                i += zzbxm.zzh(18, this.zzkQ);
            }
            if (this.zzkD == null || this.zzkD.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.zzkD.length) {
                String str3 = this.zzkD[i4];
                if (str3 != null) {
                    i3++;
                    i2 += zzbxm.zzkb(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }
    }

    public static final class zzg extends zzbxn<zzg> {
        private static volatile zzg[] zzkT;
        public int[] zzkU;
        public int[] zzkV;
        public int[] zzkW;
        public int[] zzkX;
        public int[] zzkY;
        public int[] zzkZ;
        public int[] zzla;
        public int[] zzlb;
        public int[] zzlc;
        public int[] zzld;

        public zzg() {
            zzG();
        }

        public static zzg[] zzF() {
            if (zzkT == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzkT == null) {
                        zzkT = new zzg[0];
                    }
                }
            }
            return zzkT;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg com_google_android_gms_internal_zzaj_zzg = (zzg) obj;
            return (zzbxr.equals(this.zzkU, com_google_android_gms_internal_zzaj_zzg.zzkU) && zzbxr.equals(this.zzkV, com_google_android_gms_internal_zzaj_zzg.zzkV) && zzbxr.equals(this.zzkW, com_google_android_gms_internal_zzaj_zzg.zzkW) && zzbxr.equals(this.zzkX, com_google_android_gms_internal_zzaj_zzg.zzkX) && zzbxr.equals(this.zzkY, com_google_android_gms_internal_zzaj_zzg.zzkY) && zzbxr.equals(this.zzkZ, com_google_android_gms_internal_zzaj_zzg.zzkZ) && zzbxr.equals(this.zzla, com_google_android_gms_internal_zzaj_zzg.zzla) && zzbxr.equals(this.zzlb, com_google_android_gms_internal_zzaj_zzg.zzlb) && zzbxr.equals(this.zzlc, com_google_android_gms_internal_zzaj_zzg.zzlc) && zzbxr.equals(this.zzld, com_google_android_gms_internal_zzaj_zzg.zzld)) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zzg.zzcuI == null || com_google_android_gms_internal_zzaj_zzg.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zzg.zzcuI) : false;
        }

        public int hashCode() {
            int hashCode = (((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzbxr.hashCode(this.zzkU)) * 31) + zzbxr.hashCode(this.zzkV)) * 31) + zzbxr.hashCode(this.zzkW)) * 31) + zzbxr.hashCode(this.zzkX)) * 31) + zzbxr.hashCode(this.zzkY)) * 31) + zzbxr.hashCode(this.zzkZ)) * 31) + zzbxr.hashCode(this.zzla)) * 31) + zzbxr.hashCode(this.zzlb)) * 31) + zzbxr.hashCode(this.zzlc)) * 31) + zzbxr.hashCode(this.zzld)) * 31;
            int hashCode2 = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode2 + hashCode;
        }

        public zzg zzG() {
            this.zzkU = zzbxw.zzcuW;
            this.zzkV = zzbxw.zzcuW;
            this.zzkW = zzbxw.zzcuW;
            this.zzkX = zzbxw.zzcuW;
            this.zzkY = zzbxw.zzcuW;
            this.zzkZ = zzbxw.zzcuW;
            this.zzla = zzbxw.zzcuW;
            this.zzlb = zzbxw.zzcuW;
            this.zzlc = zzbxw.zzcuW;
            this.zzld = zzbxw.zzcuW;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            int i = 0;
            if (this.zzkU != null && this.zzkU.length > 0) {
                for (int zzJ : this.zzkU) {
                    com_google_android_gms_internal_zzbxm.zzJ(1, zzJ);
                }
            }
            if (this.zzkV != null && this.zzkV.length > 0) {
                for (int zzJ2 : this.zzkV) {
                    com_google_android_gms_internal_zzbxm.zzJ(2, zzJ2);
                }
            }
            if (this.zzkW != null && this.zzkW.length > 0) {
                for (int zzJ22 : this.zzkW) {
                    com_google_android_gms_internal_zzbxm.zzJ(3, zzJ22);
                }
            }
            if (this.zzkX != null && this.zzkX.length > 0) {
                for (int zzJ222 : this.zzkX) {
                    com_google_android_gms_internal_zzbxm.zzJ(4, zzJ222);
                }
            }
            if (this.zzkY != null && this.zzkY.length > 0) {
                for (int zzJ2222 : this.zzkY) {
                    com_google_android_gms_internal_zzbxm.zzJ(5, zzJ2222);
                }
            }
            if (this.zzkZ != null && this.zzkZ.length > 0) {
                for (int zzJ22222 : this.zzkZ) {
                    com_google_android_gms_internal_zzbxm.zzJ(6, zzJ22222);
                }
            }
            if (this.zzla != null && this.zzla.length > 0) {
                for (int zzJ222222 : this.zzla) {
                    com_google_android_gms_internal_zzbxm.zzJ(7, zzJ222222);
                }
            }
            if (this.zzlb != null && this.zzlb.length > 0) {
                for (int zzJ2222222 : this.zzlb) {
                    com_google_android_gms_internal_zzbxm.zzJ(8, zzJ2222222);
                }
            }
            if (this.zzlc != null && this.zzlc.length > 0) {
                for (int zzJ22222222 : this.zzlc) {
                    com_google_android_gms_internal_zzbxm.zzJ(9, zzJ22222222);
                }
            }
            if (this.zzld != null && this.zzld.length > 0) {
                while (i < this.zzld.length) {
                    com_google_android_gms_internal_zzbxm.zzJ(10, this.zzld[i]);
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzt(com_google_android_gms_internal_zzbxl);
        }

        public zzg zzt(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                int zzb;
                Object obj;
                int zzra;
                Object obj2;
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 8);
                        zzaeo = this.zzkU == null ? 0 : this.zzkU.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkU, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzkU = obj;
                        continue;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzkU == null ? 0 : this.zzkU.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzkU, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzkU = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case CommonStatusCodes.CANCELED /*16*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 16);
                        zzaeo = this.zzkV == null ? 0 : this.zzkV.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkV, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzkV = obj;
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzkV == null ? 0 : this.zzkV.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzkV, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzkV = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 24);
                        zzaeo = this.zzkW == null ? 0 : this.zzkW.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkW, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzkW = obj;
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
                        zzb = this.zzkW == null ? 0 : this.zzkW.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzkW, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzkW = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 32);
                        zzaeo = this.zzkX == null ? 0 : this.zzkX.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkX, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzkX = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzkX == null ? 0 : this.zzkX.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzkX, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzkX = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 40);
                        zzaeo = this.zzkY == null ? 0 : this.zzkY.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkY, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzkY = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzkY == null ? 0 : this.zzkY.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzkY, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzkY = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 48);
                        zzaeo = this.zzkZ == null ? 0 : this.zzkZ.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzkZ, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzkZ = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzkZ == null ? 0 : this.zzkZ.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzkZ, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzkZ = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.AppCompatTheme_dividerVertical /*56*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 56);
                        zzaeo = this.zzla == null ? 0 : this.zzla.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzla, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzla = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzla == null ? 0 : this.zzla.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzla, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzla = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.AppCompatTheme_editTextBackground /*64*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 64);
                        zzaeo = this.zzlb == null ? 0 : this.zzlb.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlb, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzlb = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzlb == null ? 0 : this.zzlb.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzlb, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzlb = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 72);
                        zzaeo = this.zzlc == null ? 0 : this.zzlc.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlc, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzlc = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzlc == null ? 0 : this.zzlc.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzlc, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzlc = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 80);
                        zzaeo = this.zzld == null ? 0 : this.zzld.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzld, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzld = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzld == null ? 0 : this.zzld.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzld, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzld = obj2;
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

        protected int zzu() {
            int i;
            int i2;
            int i3 = 0;
            int zzu = super.zzu();
            if (this.zzkU == null || this.zzkU.length <= 0) {
                i = zzu;
            } else {
                i2 = 0;
                for (int zzrg : this.zzkU) {
                    i2 += zzbxm.zzrg(zzrg);
                }
                i = (zzu + i2) + (this.zzkU.length * 1);
            }
            if (this.zzkV != null && this.zzkV.length > 0) {
                zzu = 0;
                for (int zzrg2 : this.zzkV) {
                    zzu += zzbxm.zzrg(zzrg2);
                }
                i = (i + zzu) + (this.zzkV.length * 1);
            }
            if (this.zzkW != null && this.zzkW.length > 0) {
                zzu = 0;
                for (int zzrg22 : this.zzkW) {
                    zzu += zzbxm.zzrg(zzrg22);
                }
                i = (i + zzu) + (this.zzkW.length * 1);
            }
            if (this.zzkX != null && this.zzkX.length > 0) {
                zzu = 0;
                for (int zzrg222 : this.zzkX) {
                    zzu += zzbxm.zzrg(zzrg222);
                }
                i = (i + zzu) + (this.zzkX.length * 1);
            }
            if (this.zzkY != null && this.zzkY.length > 0) {
                zzu = 0;
                for (int zzrg2222 : this.zzkY) {
                    zzu += zzbxm.zzrg(zzrg2222);
                }
                i = (i + zzu) + (this.zzkY.length * 1);
            }
            if (this.zzkZ != null && this.zzkZ.length > 0) {
                zzu = 0;
                for (int zzrg22222 : this.zzkZ) {
                    zzu += zzbxm.zzrg(zzrg22222);
                }
                i = (i + zzu) + (this.zzkZ.length * 1);
            }
            if (this.zzla != null && this.zzla.length > 0) {
                zzu = 0;
                for (int zzrg222222 : this.zzla) {
                    zzu += zzbxm.zzrg(zzrg222222);
                }
                i = (i + zzu) + (this.zzla.length * 1);
            }
            if (this.zzlb != null && this.zzlb.length > 0) {
                zzu = 0;
                for (int zzrg2222222 : this.zzlb) {
                    zzu += zzbxm.zzrg(zzrg2222222);
                }
                i = (i + zzu) + (this.zzlb.length * 1);
            }
            if (this.zzlc != null && this.zzlc.length > 0) {
                zzu = 0;
                for (int zzrg22222222 : this.zzlc) {
                    zzu += zzbxm.zzrg(zzrg22222222);
                }
                i = (i + zzu) + (this.zzlc.length * 1);
            }
            if (this.zzld == null || this.zzld.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.zzld.length) {
                i2 += zzbxm.zzrg(this.zzld[i3]);
                i3++;
            }
            return (i + i2) + (this.zzld.length * 1);
        }
    }

    public static final class zzh extends zzbxn<zzh> {
        public static final zzbxo<com.google.android.gms.internal.zzak.zza, zzh> zzle;
        private static final zzh[] zzlf;
        public int[] zzlg;
        public int[] zzlh;
        public int[] zzli;
        public int zzlj;
        public int[] zzlk;
        public int zzll;
        public int zzlm;

        static {
            zzle = zzbxo.zza(11, zzh.class, 810);
            zzlf = new zzh[0];
        }

        public zzh() {
            zzH();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh com_google_android_gms_internal_zzaj_zzh = (zzh) obj;
            return (zzbxr.equals(this.zzlg, com_google_android_gms_internal_zzaj_zzh.zzlg) && zzbxr.equals(this.zzlh, com_google_android_gms_internal_zzaj_zzh.zzlh) && zzbxr.equals(this.zzli, com_google_android_gms_internal_zzaj_zzh.zzli) && this.zzlj == com_google_android_gms_internal_zzaj_zzh.zzlj && zzbxr.equals(this.zzlk, com_google_android_gms_internal_zzaj_zzh.zzlk) && this.zzll == com_google_android_gms_internal_zzaj_zzh.zzll && this.zzlm == com_google_android_gms_internal_zzaj_zzh.zzlm) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zzh.zzcuI == null || com_google_android_gms_internal_zzaj_zzh.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zzh.zzcuI) : false;
        }

        public int hashCode() {
            int hashCode = (((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzbxr.hashCode(this.zzlg)) * 31) + zzbxr.hashCode(this.zzlh)) * 31) + zzbxr.hashCode(this.zzli)) * 31) + this.zzlj) * 31) + zzbxr.hashCode(this.zzlk)) * 31) + this.zzll) * 31) + this.zzlm) * 31;
            int hashCode2 = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode2 + hashCode;
        }

        public zzh zzH() {
            this.zzlg = zzbxw.zzcuW;
            this.zzlh = zzbxw.zzcuW;
            this.zzli = zzbxw.zzcuW;
            this.zzlj = 0;
            this.zzlk = zzbxw.zzcuW;
            this.zzll = 0;
            this.zzlm = 0;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            int i = 0;
            if (this.zzlg != null && this.zzlg.length > 0) {
                for (int zzJ : this.zzlg) {
                    com_google_android_gms_internal_zzbxm.zzJ(1, zzJ);
                }
            }
            if (this.zzlh != null && this.zzlh.length > 0) {
                for (int zzJ2 : this.zzlh) {
                    com_google_android_gms_internal_zzbxm.zzJ(2, zzJ2);
                }
            }
            if (this.zzli != null && this.zzli.length > 0) {
                for (int zzJ22 : this.zzli) {
                    com_google_android_gms_internal_zzbxm.zzJ(3, zzJ22);
                }
            }
            if (this.zzlj != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(4, this.zzlj);
            }
            if (this.zzlk != null && this.zzlk.length > 0) {
                while (i < this.zzlk.length) {
                    com_google_android_gms_internal_zzbxm.zzJ(5, this.zzlk[i]);
                    i++;
                }
            }
            if (this.zzll != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(6, this.zzll);
            }
            if (this.zzlm != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(7, this.zzlm);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzu(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int i;
            int i2;
            int i3 = 0;
            int zzu = super.zzu();
            if (this.zzlg == null || this.zzlg.length <= 0) {
                i = zzu;
            } else {
                i2 = 0;
                for (int zzrg : this.zzlg) {
                    i2 += zzbxm.zzrg(zzrg);
                }
                i = (zzu + i2) + (this.zzlg.length * 1);
            }
            if (this.zzlh != null && this.zzlh.length > 0) {
                zzu = 0;
                for (int zzrg2 : this.zzlh) {
                    zzu += zzbxm.zzrg(zzrg2);
                }
                i = (i + zzu) + (this.zzlh.length * 1);
            }
            if (this.zzli != null && this.zzli.length > 0) {
                zzu = 0;
                for (int zzrg22 : this.zzli) {
                    zzu += zzbxm.zzrg(zzrg22);
                }
                i = (i + zzu) + (this.zzli.length * 1);
            }
            if (this.zzlj != 0) {
                i += zzbxm.zzL(4, this.zzlj);
            }
            if (this.zzlk != null && this.zzlk.length > 0) {
                i2 = 0;
                while (i3 < this.zzlk.length) {
                    i2 += zzbxm.zzrg(this.zzlk[i3]);
                    i3++;
                }
                i = (i + i2) + (this.zzlk.length * 1);
            }
            if (this.zzll != 0) {
                i += zzbxm.zzL(6, this.zzll);
            }
            return this.zzlm != 0 ? i + zzbxm.zzL(7, this.zzlm) : i;
        }

        public zzh zzu(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                int zzb;
                Object obj;
                int zzra;
                Object obj2;
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 8);
                        zzaeo = this.zzlg == null ? 0 : this.zzlg.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlg, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzlg = obj;
                        continue;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzlg == null ? 0 : this.zzlg.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzlg, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzlg = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case CommonStatusCodes.CANCELED /*16*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 16);
                        zzaeo = this.zzlh == null ? 0 : this.zzlh.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlh, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzlh = obj;
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzlh == null ? 0 : this.zzlh.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzlh, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzlh = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 24);
                        zzaeo = this.zzli == null ? 0 : this.zzli.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzli, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzli = obj;
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
                        zzb = this.zzli == null ? 0 : this.zzli.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzli, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzli = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.zzlj = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 40);
                        zzaeo = this.zzlk == null ? 0 : this.zzlk.length;
                        obj = new int[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlk, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.zzaes();
                        this.zzlk = obj;
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        zzra = com_google_android_gms_internal_zzbxl.zzra(com_google_android_gms_internal_zzbxl.zzaex());
                        zzb = com_google_android_gms_internal_zzbxl.getPosition();
                        zzaeo = 0;
                        while (com_google_android_gms_internal_zzbxl.zzaeC() > 0) {
                            com_google_android_gms_internal_zzbxl.zzaes();
                            zzaeo++;
                        }
                        com_google_android_gms_internal_zzbxl.zzrc(zzb);
                        zzb = this.zzlk == null ? 0 : this.zzlk.length;
                        obj2 = new int[(zzaeo + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzlk, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzbxl.zzaes();
                            zzb++;
                        }
                        this.zzlk = obj2;
                        com_google_android_gms_internal_zzbxl.zzrb(zzra);
                        continue;
                    case C0268R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        this.zzll = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case C0268R.styleable.AppCompatTheme_dividerVertical /*56*/:
                        this.zzlm = com_google_android_gms_internal_zzbxl.zzaes();
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

    public static final class zzi extends zzbxn<zzi> {
        private static volatile zzi[] zzln;
        public String name;
        public com.google.android.gms.internal.zzak.zza zzlo;
        public zzd zzlp;

        public zzi() {
            zzJ();
        }

        public static zzi[] zzI() {
            if (zzln == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzln == null) {
                        zzln = new zzi[0];
                    }
                }
            }
            return zzln;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi com_google_android_gms_internal_zzaj_zzi = (zzi) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzaj_zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzaj_zzi.name)) {
                return false;
            }
            if (this.zzlo == null) {
                if (com_google_android_gms_internal_zzaj_zzi.zzlo != null) {
                    return false;
                }
            } else if (!this.zzlo.equals(com_google_android_gms_internal_zzaj_zzi.zzlo)) {
                return false;
            }
            if (this.zzlp == null) {
                if (com_google_android_gms_internal_zzaj_zzi.zzlp != null) {
                    return false;
                }
            } else if (!this.zzlp.equals(com_google_android_gms_internal_zzaj_zzi.zzlp)) {
                return false;
            }
            return (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zzi.zzcuI == null || com_google_android_gms_internal_zzaj_zzi.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zzi.zzcuI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzlp == null ? 0 : this.zzlp.hashCode()) + (((this.zzlo == null ? 0 : this.zzlo.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public zzi zzJ() {
            this.name = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzlo = null;
            this.zzlp = null;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (!(this.name == null || this.name.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(1, this.name);
            }
            if (this.zzlo != null) {
                com_google_android_gms_internal_zzbxm.zza(2, this.zzlo);
            }
            if (this.zzlp != null) {
                com_google_android_gms_internal_zzbxm.zza(3, this.zzlp);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzv(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (!(this.name == null || this.name.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(1, this.name);
            }
            if (this.zzlo != null) {
                zzu += zzbxm.zzc(2, this.zzlo);
            }
            return this.zzlp != null ? zzu + zzbxm.zzc(3, this.zzlp) : zzu;
        }

        public zzi zzv(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.name = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        if (this.zzlo == null) {
                            this.zzlo = new com.google.android.gms.internal.zzak.zza();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzlo);
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        if (this.zzlp == null) {
                            this.zzlp = new zzd();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzlp);
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

    public static final class zzj extends zzbxn<zzj> {
        public zzi[] zzlq;
        public zzf zzlr;
        public String zzls;

        public zzj() {
            zzK();
        }

        public static zzj zzg(byte[] bArr) {
            return (zzj) zzbxt.zza(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj com_google_android_gms_internal_zzaj_zzj = (zzj) obj;
            if (!zzbxr.equals(this.zzlq, com_google_android_gms_internal_zzaj_zzj.zzlq)) {
                return false;
            }
            if (this.zzlr == null) {
                if (com_google_android_gms_internal_zzaj_zzj.zzlr != null) {
                    return false;
                }
            } else if (!this.zzlr.equals(com_google_android_gms_internal_zzaj_zzj.zzlr)) {
                return false;
            }
            if (this.zzls == null) {
                if (com_google_android_gms_internal_zzaj_zzj.zzls != null) {
                    return false;
                }
            } else if (!this.zzls.equals(com_google_android_gms_internal_zzaj_zzj.zzls)) {
                return false;
            }
            return (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzaj_zzj.zzcuI == null || com_google_android_gms_internal_zzaj_zzj.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzaj_zzj.zzcuI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzls == null ? 0 : this.zzls.hashCode()) + (((this.zzlr == null ? 0 : this.zzlr.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzbxr.hashCode(this.zzlq)) * 31)) * 31)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public zzj zzK() {
            this.zzlq = zzi.zzI();
            this.zzlr = null;
            this.zzls = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.zzlq != null && this.zzlq.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzlq) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        com_google_android_gms_internal_zzbxm.zza(1, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            if (this.zzlr != null) {
                com_google_android_gms_internal_zzbxm.zza(2, this.zzlr);
            }
            if (!(this.zzls == null || this.zzls.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(3, this.zzls);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzw(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (this.zzlq != null && this.zzlq.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzlq) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        zzu += zzbxm.zzc(1, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            if (this.zzlr != null) {
                zzu += zzbxm.zzc(2, this.zzlr);
            }
            return (this.zzls == null || this.zzls.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)) ? zzu : zzu + zzbxm.zzr(3, this.zzls);
        }

        public zzj zzw(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        int zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 10);
                        zzaeo = this.zzlq == null ? 0 : this.zzlq.length;
                        Object obj = new zzi[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzlq, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zzi();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zzi();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzlq = obj;
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        if (this.zzlr == null) {
                            this.zzlr = new zzf();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzlr);
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        this.zzls = com_google_android_gms_internal_zzbxl.readString();
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
