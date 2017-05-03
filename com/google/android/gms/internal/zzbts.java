package com.google.android.gms.internal;

import android.support.v7.appcompat.C0268R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import net.nend.android.NendAdIconLayout;

public interface zzbts {

    public static final class zza extends zzbxn<zza> {
        public long timestamp;
        public zzd[] zzcmq;
        public byte[][] zzcmr;

        public zza() {
            zzacl();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzbts_zza = (zza) obj;
            return (zzbxr.equals(this.zzcmq, com_google_android_gms_internal_zzbts_zza.zzcmq) && this.timestamp == com_google_android_gms_internal_zzbts_zza.timestamp && zzbxr.zza(this.zzcmr, com_google_android_gms_internal_zzbts_zza.zzcmr)) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbts_zza.zzcuI == null || com_google_android_gms_internal_zzbts_zza.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbts_zza.zzcuI) : false;
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzbxr.hashCode(this.zzcmq)) * 31) + ((int) (this.timestamp ^ (this.timestamp >>> 32)))) * 31) + zzbxr.zzb(this.zzcmr)) * 31;
            int hashCode2 = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            int i = 0;
            if (this.zzcmq != null && this.zzcmq.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcmq) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        com_google_android_gms_internal_zzbxm.zza(1, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            if (this.timestamp != 0) {
                com_google_android_gms_internal_zzbxm.zzc(2, this.timestamp);
            }
            if (this.zzcmr != null && this.zzcmr.length > 0) {
                while (i < this.zzcmr.length) {
                    byte[] bArr = this.zzcmr[i];
                    if (bArr != null) {
                        com_google_android_gms_internal_zzbxm.zzb(3, bArr);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zza zzac(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                int zzb;
                Object obj;
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 10);
                        zzaeo = this.zzcmq == null ? 0 : this.zzcmq.length;
                        obj = new zzd[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcmq, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zzd();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zzd();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzcmq = obj;
                        continue;
                    case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                        this.timestamp = com_google_android_gms_internal_zzbxl.zzaet();
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 26);
                        zzaeo = this.zzcmr == null ? 0 : this.zzcmr.length;
                        obj = new byte[(zzb + zzaeo)][];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcmr, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = com_google_android_gms_internal_zzbxl.readBytes();
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = com_google_android_gms_internal_zzbxl.readBytes();
                        this.zzcmr = obj;
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

        public zza zzacl() {
            this.zzcmq = zzd.zzacp();
            this.timestamp = 0;
            this.zzcmr = zzbxw.zzcvc;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzac(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int i;
            int i2 = 0;
            int zzu = super.zzu();
            if (this.zzcmq != null && this.zzcmq.length > 0) {
                i = zzu;
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcmq) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        i += zzbxm.zzc(1, com_google_android_gms_internal_zzbxt);
                    }
                }
                zzu = i;
            }
            if (this.timestamp != 0) {
                zzu += zzbxm.zzg(2, this.timestamp);
            }
            if (this.zzcmr == null || this.zzcmr.length <= 0) {
                return zzu;
            }
            i = 0;
            int i3 = 0;
            while (i2 < this.zzcmr.length) {
                byte[] bArr = this.zzcmr[i2];
                if (bArr != null) {
                    i3++;
                    i += zzbxm.zzai(bArr);
                }
                i2++;
            }
            return (zzu + i) + (i3 * 1);
        }
    }

    public static final class zzb extends zzbxn<zzb> {
        private static volatile zzb[] zzcms;
        public String zzaB;
        public byte[] zzcmt;

        public zzb() {
            zzacn();
        }

        public static zzb[] zzacm() {
            if (zzcms == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzcms == null) {
                        zzcms = new zzb[0];
                    }
                }
            }
            return zzcms;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzbts_zzb = (zzb) obj;
            if (this.zzaB == null) {
                if (com_google_android_gms_internal_zzbts_zzb.zzaB != null) {
                    return false;
                }
            } else if (!this.zzaB.equals(com_google_android_gms_internal_zzbts_zzb.zzaB)) {
                return false;
            }
            return Arrays.equals(this.zzcmt, com_google_android_gms_internal_zzbts_zzb.zzcmt) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbts_zzb.zzcuI == null || com_google_android_gms_internal_zzbts_zzb.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbts_zzb.zzcuI) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzaB == null ? 0 : this.zzaB.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + Arrays.hashCode(this.zzcmt)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (!(this.zzaB == null || this.zzaB.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(1, this.zzaB);
            }
            if (!Arrays.equals(this.zzcmt, zzbxw.zzcvd)) {
                com_google_android_gms_internal_zzbxm.zzb(2, this.zzcmt);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zzb zzacn() {
            this.zzaB = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcmt = zzbxw.zzcvd;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zzb zzad(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.zzaB = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        this.zzcmt = com_google_android_gms_internal_zzbxl.readBytes();
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

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzad(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (!(this.zzaB == null || this.zzaB.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(1, this.zzaB);
            }
            return !Arrays.equals(this.zzcmt, zzbxw.zzcvd) ? zzu + zzbxm.zzc(2, this.zzcmt) : zzu;
        }
    }

    public static final class zzc extends zzbxn<zzc> {
        public int zzcmu;
        public boolean zzcmv;
        public long zzcmw;

        public zzc() {
            zzaco();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzbts_zzc = (zzc) obj;
            return (this.zzcmu == com_google_android_gms_internal_zzbts_zzc.zzcmu && this.zzcmv == com_google_android_gms_internal_zzbts_zzc.zzcmv && this.zzcmw == com_google_android_gms_internal_zzbts_zzc.zzcmw) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbts_zzc.zzcuI == null || com_google_android_gms_internal_zzbts_zzc.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbts_zzc.zzcuI) : false;
        }

        public int hashCode() {
            int hashCode = ((((this.zzcmv ? 1231 : 1237) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzcmu) * 31)) * 31) + ((int) (this.zzcmw ^ (this.zzcmw >>> 32)))) * 31;
            int hashCode2 = (this.zzcuI == null || this.zzcuI.isEmpty()) ? 0 : this.zzcuI.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.zzcmu != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(1, this.zzcmu);
            }
            if (this.zzcmv) {
                com_google_android_gms_internal_zzbxm.zzg(2, this.zzcmv);
            }
            if (this.zzcmw != 0) {
                com_google_android_gms_internal_zzbxm.zzc(3, this.zzcmw);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zzc zzaco() {
            this.zzcmu = 0;
            this.zzcmv = false;
            this.zzcmw = 0;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zzc zzae(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        this.zzcmu = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case CommonStatusCodes.CANCELED /*16*/:
                        this.zzcmv = com_google_android_gms_internal_zzbxl.zzaeu();
                        continue;
                    case C0268R.styleable.Toolbar_navigationContentDescription /*25*/:
                        this.zzcmw = com_google_android_gms_internal_zzbxl.zzaet();
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

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzae(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (this.zzcmu != 0) {
                zzu += zzbxm.zzL(1, this.zzcmu);
            }
            if (this.zzcmv) {
                zzu += zzbxm.zzh(2, this.zzcmv);
            }
            return this.zzcmw != 0 ? zzu + zzbxm.zzg(3, this.zzcmw) : zzu;
        }
    }

    public static final class zzd extends zzbxn<zzd> {
        private static volatile zzd[] zzcmx;
        public String zzaGP;
        public zzb[] zzcmy;

        public zzd() {
            zzacq();
        }

        public static zzd[] zzacp() {
            if (zzcmx == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzcmx == null) {
                        zzcmx = new zzd[0];
                    }
                }
            }
            return zzcmx;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzbts_zzd = (zzd) obj;
            if (this.zzaGP == null) {
                if (com_google_android_gms_internal_zzbts_zzd.zzaGP != null) {
                    return false;
                }
            } else if (!this.zzaGP.equals(com_google_android_gms_internal_zzbts_zzd.zzaGP)) {
                return false;
            }
            return zzbxr.equals(this.zzcmy, com_google_android_gms_internal_zzbts_zzd.zzcmy) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbts_zzd.zzcuI == null || com_google_android_gms_internal_zzbts_zzd.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbts_zzd.zzcuI) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzaGP == null ? 0 : this.zzaGP.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzbxr.hashCode(this.zzcmy)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (!(this.zzaGP == null || this.zzaGP.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(1, this.zzaGP);
            }
            if (this.zzcmy != null && this.zzcmy.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcmy) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        com_google_android_gms_internal_zzbxm.zza(2, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zzd zzacq() {
            this.zzaGP = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcmy = zzb.zzacm();
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zzd zzaf(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.zzaGP = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        int zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 18);
                        zzaeo = this.zzcmy == null ? 0 : this.zzcmy.length;
                        Object obj = new zzb[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcmy, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zzb();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zzb();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzcmy = obj;
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

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzaf(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (!(this.zzaGP == null || this.zzaGP.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                zzu += zzbxm.zzr(1, this.zzaGP);
            }
            if (this.zzcmy == null || this.zzcmy.length <= 0) {
                return zzu;
            }
            int i = zzu;
            for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcmy) {
                if (com_google_android_gms_internal_zzbxt != null) {
                    i += zzbxm.zzc(2, com_google_android_gms_internal_zzbxt);
                }
            }
            return i;
        }
    }

    public static final class zze extends zzbxn<zze> {
        public zza zzcmA;
        public zza zzcmB;
        public zzc zzcmC;
        public zzf[] zzcmD;
        public zza zzcmz;

        public zze() {
            zzacr();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzbts_zze = (zze) obj;
            if (this.zzcmz == null) {
                if (com_google_android_gms_internal_zzbts_zze.zzcmz != null) {
                    return false;
                }
            } else if (!this.zzcmz.equals(com_google_android_gms_internal_zzbts_zze.zzcmz)) {
                return false;
            }
            if (this.zzcmA == null) {
                if (com_google_android_gms_internal_zzbts_zze.zzcmA != null) {
                    return false;
                }
            } else if (!this.zzcmA.equals(com_google_android_gms_internal_zzbts_zze.zzcmA)) {
                return false;
            }
            if (this.zzcmB == null) {
                if (com_google_android_gms_internal_zzbts_zze.zzcmB != null) {
                    return false;
                }
            } else if (!this.zzcmB.equals(com_google_android_gms_internal_zzbts_zze.zzcmB)) {
                return false;
            }
            if (this.zzcmC == null) {
                if (com_google_android_gms_internal_zzbts_zze.zzcmC != null) {
                    return false;
                }
            } else if (!this.zzcmC.equals(com_google_android_gms_internal_zzbts_zze.zzcmC)) {
                return false;
            }
            return zzbxr.equals(this.zzcmD, com_google_android_gms_internal_zzbts_zze.zzcmD) ? (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbts_zze.zzcuI == null || com_google_android_gms_internal_zzbts_zze.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbts_zze.zzcuI) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzcmC == null ? 0 : this.zzcmC.hashCode()) + (((this.zzcmB == null ? 0 : this.zzcmB.hashCode()) + (((this.zzcmA == null ? 0 : this.zzcmA.hashCode()) + (((this.zzcmz == null ? 0 : this.zzcmz.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31) + zzbxr.hashCode(this.zzcmD)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.zzcmz != null) {
                com_google_android_gms_internal_zzbxm.zza(1, this.zzcmz);
            }
            if (this.zzcmA != null) {
                com_google_android_gms_internal_zzbxm.zza(2, this.zzcmA);
            }
            if (this.zzcmB != null) {
                com_google_android_gms_internal_zzbxm.zza(3, this.zzcmB);
            }
            if (this.zzcmC != null) {
                com_google_android_gms_internal_zzbxm.zza(4, this.zzcmC);
            }
            if (this.zzcmD != null && this.zzcmD.length > 0) {
                for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcmD) {
                    if (com_google_android_gms_internal_zzbxt != null) {
                        com_google_android_gms_internal_zzbxm.zza(5, com_google_android_gms_internal_zzbxt);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zze zzacr() {
            this.zzcmz = null;
            this.zzcmA = null;
            this.zzcmB = null;
            this.zzcmC = null;
            this.zzcmD = zzf.zzacs();
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zze zzag(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        if (this.zzcmz == null) {
                            this.zzcmz = new zza();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzcmz);
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        if (this.zzcmA == null) {
                            this.zzcmA = new zza();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzcmA);
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        if (this.zzcmB == null) {
                            this.zzcmB = new zza();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzcmB);
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        if (this.zzcmC == null) {
                            this.zzcmC = new zzc();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzcmC);
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        int zzb = zzbxw.zzb(com_google_android_gms_internal_zzbxl, 42);
                        zzaeo = this.zzcmD == null ? 0 : this.zzcmD.length;
                        Object obj = new zzf[(zzb + zzaeo)];
                        if (zzaeo != 0) {
                            System.arraycopy(this.zzcmD, 0, obj, 0, zzaeo);
                        }
                        while (zzaeo < obj.length - 1) {
                            obj[zzaeo] = new zzf();
                            com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                            com_google_android_gms_internal_zzbxl.zzaeo();
                            zzaeo++;
                        }
                        obj[zzaeo] = new zzf();
                        com_google_android_gms_internal_zzbxl.zza(obj[zzaeo]);
                        this.zzcmD = obj;
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

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzag(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (this.zzcmz != null) {
                zzu += zzbxm.zzc(1, this.zzcmz);
            }
            if (this.zzcmA != null) {
                zzu += zzbxm.zzc(2, this.zzcmA);
            }
            if (this.zzcmB != null) {
                zzu += zzbxm.zzc(3, this.zzcmB);
            }
            if (this.zzcmC != null) {
                zzu += zzbxm.zzc(4, this.zzcmC);
            }
            if (this.zzcmD == null || this.zzcmD.length <= 0) {
                return zzu;
            }
            int i = zzu;
            for (zzbxt com_google_android_gms_internal_zzbxt : this.zzcmD) {
                if (com_google_android_gms_internal_zzbxt != null) {
                    i += zzbxm.zzc(5, com_google_android_gms_internal_zzbxt);
                }
            }
            return i;
        }
    }

    public static final class zzf extends zzbxn<zzf> {
        private static volatile zzf[] zzcmE;
        public int resourceId;
        public String zzaGP;
        public long zzcmF;

        public zzf() {
            zzact();
        }

        public static zzf[] zzacs() {
            if (zzcmE == null) {
                synchronized (zzbxr.zzcuQ) {
                    if (zzcmE == null) {
                        zzcmE = new zzf[0];
                    }
                }
            }
            return zzcmE;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzbts_zzf = (zzf) obj;
            if (this.resourceId != com_google_android_gms_internal_zzbts_zzf.resourceId || this.zzcmF != com_google_android_gms_internal_zzbts_zzf.zzcmF) {
                return false;
            }
            if (this.zzaGP == null) {
                if (com_google_android_gms_internal_zzbts_zzf.zzaGP != null) {
                    return false;
                }
            } else if (!this.zzaGP.equals(com_google_android_gms_internal_zzbts_zzf.zzaGP)) {
                return false;
            }
            return (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbts_zzf.zzcuI == null || com_google_android_gms_internal_zzbts_zzf.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbts_zzf.zzcuI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaGP == null ? 0 : this.zzaGP.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.resourceId) * 31) + ((int) (this.zzcmF ^ (this.zzcmF >>> 32)))) * 31)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.resourceId != 0) {
                com_google_android_gms_internal_zzbxm.zzJ(1, this.resourceId);
            }
            if (this.zzcmF != 0) {
                com_google_android_gms_internal_zzbxm.zzc(2, this.zzcmF);
            }
            if (!(this.zzaGP == null || this.zzaGP.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING))) {
                com_google_android_gms_internal_zzbxm.zzq(3, this.zzaGP);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public zzf zzact() {
            this.resourceId = 0;
            this.zzcmF = 0;
            this.zzaGP = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zzf zzah(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        this.resourceId = com_google_android_gms_internal_zzbxl.zzaes();
                        continue;
                    case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                        this.zzcmF = com_google_android_gms_internal_zzbxl.zzaet();
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        this.zzaGP = com_google_android_gms_internal_zzbxl.readString();
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

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzah(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (this.resourceId != 0) {
                zzu += zzbxm.zzL(1, this.resourceId);
            }
            if (this.zzcmF != 0) {
                zzu += zzbxm.zzg(2, this.zzcmF);
            }
            return (this.zzaGP == null || this.zzaGP.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)) ? zzu : zzu + zzbxm.zzr(3, this.zzaGP);
        }
    }
}
