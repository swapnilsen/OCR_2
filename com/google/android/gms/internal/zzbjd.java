package com.google.android.gms.internal;

import android.support.v7.appcompat.C0268R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.internal.zzaj.zzf;
import com.google.android.gms.internal.zzaj.zzj;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import net.nend.android.NendAdIconLayout;

public interface zzbjd {

    public static final class zza extends zzbxn<zza> {
        public long zzbNe;
        public zzj zzbNf;
        public zzf zzlr;

        public zza() {
            zzTv();
        }

        public static zza zzQ(byte[] bArr) {
            return (zza) zzbxt.zza(new zza(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzbjd_zza = (zza) obj;
            if (this.zzbNe != com_google_android_gms_internal_zzbjd_zza.zzbNe) {
                return false;
            }
            if (this.zzlr == null) {
                if (com_google_android_gms_internal_zzbjd_zza.zzlr != null) {
                    return false;
                }
            } else if (!this.zzlr.equals(com_google_android_gms_internal_zzbjd_zza.zzlr)) {
                return false;
            }
            if (this.zzbNf == null) {
                if (com_google_android_gms_internal_zzbjd_zza.zzbNf != null) {
                    return false;
                }
            } else if (!this.zzbNf.equals(com_google_android_gms_internal_zzbjd_zza.zzbNf)) {
                return false;
            }
            return (this.zzcuI == null || this.zzcuI.isEmpty()) ? com_google_android_gms_internal_zzbjd_zza.zzcuI == null || com_google_android_gms_internal_zzbjd_zza.zzcuI.isEmpty() : this.zzcuI.equals(com_google_android_gms_internal_zzbjd_zza.zzcuI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbNf == null ? 0 : this.zzbNf.hashCode()) + (((this.zzlr == null ? 0 : this.zzlr.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbNe ^ (this.zzbNe >>> 32)))) * 31)) * 31)) * 31;
            if (!(this.zzcuI == null || this.zzcuI.isEmpty())) {
                i = this.zzcuI.hashCode();
            }
            return hashCode + i;
        }

        public zza zzTv() {
            this.zzbNe = 0;
            this.zzlr = null;
            this.zzbNf = null;
            this.zzcuI = null;
            this.zzcuR = -1;
            return this;
        }

        public zza zzW(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                        this.zzbNe = com_google_android_gms_internal_zzbxl.zzaer();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        if (this.zzlr == null) {
                            this.zzlr = new zzf();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzlr);
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        if (this.zzbNf == null) {
                            this.zzbNf = new zzj();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzbNf);
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

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            com_google_android_gms_internal_zzbxm.zzb(1, this.zzbNe);
            if (this.zzlr != null) {
                com_google_android_gms_internal_zzbxm.zza(2, this.zzlr);
            }
            if (this.zzbNf != null) {
                com_google_android_gms_internal_zzbxm.zza(3, this.zzbNf);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzW(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu() + zzbxm.zzf(1, this.zzbNe);
            if (this.zzlr != null) {
                zzu += zzbxm.zzc(2, this.zzlr);
            }
            return this.zzbNf != null ? zzu + zzbxm.zzc(3, this.zzbNf) : zzu;
        }
    }
}
