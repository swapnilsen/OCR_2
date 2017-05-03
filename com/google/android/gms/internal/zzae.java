package com.google.android.gms.internal;

import android.support.v7.appcompat.C0268R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public interface zzae {

    public static final class zza extends zzbxn<zza> {
        public zzb zzaK;
        public zzc zzaL;

        public zza() {
            this.zzcuR = -1;
        }

        public static zza zzc(byte[] bArr) {
            return (zza) zzbxt.zza(new zza(), bArr);
        }

        public zza zza(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        if (this.zzaK == null) {
                            this.zzaK = new zzb();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzaK);
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        if (this.zzaL == null) {
                            this.zzaL = new zzc();
                        }
                        com_google_android_gms_internal_zzbxl.zza(this.zzaL);
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
            if (this.zzaK != null) {
                com_google_android_gms_internal_zzbxm.zza(1, this.zzaK);
            }
            if (this.zzaL != null) {
                com_google_android_gms_internal_zzbxm.zza(2, this.zzaL);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zza(com_google_android_gms_internal_zzbxl);
        }

        protected int zzu() {
            int zzu = super.zzu();
            if (this.zzaK != null) {
                zzu += zzbxm.zzc(1, this.zzaK);
            }
            return this.zzaL != null ? zzu + zzbxm.zzc(2, this.zzaL) : zzu;
        }
    }

    public static final class zzb extends zzbxn<zzb> {
        public Integer zzaM;

        public zzb() {
            this.zzaM = null;
            this.zzcuR = -1;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.zzaM != null) {
                com_google_android_gms_internal_zzbxm.zzJ(27, this.zzaM.intValue());
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzc(com_google_android_gms_internal_zzbxl);
        }

        public zzb zzc(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case 216:
                        zzaeo = com_google_android_gms_internal_zzbxl.zzaes();
                        switch (zzaeo) {
                            case NendAdIconLayout.HORIZONTAL /*0*/:
                            case NendIconError.ERROR_ICONVIEW /*1*/:
                            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                                this.zzaM = Integer.valueOf(zzaeo);
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

        protected int zzu() {
            int zzu = super.zzu();
            return this.zzaM != null ? zzu + zzbxm.zzL(27, this.zzaM.intValue()) : zzu;
        }
    }

    public static final class zzc extends zzbxn<zzc> {
        public String zzaN;
        public String zzaO;
        public String zzaP;
        public String zzaQ;
        public String zzaR;

        public zzc() {
            this.zzaN = null;
            this.zzaO = null;
            this.zzaP = null;
            this.zzaQ = null;
            this.zzaR = null;
            this.zzcuR = -1;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.zzaN != null) {
                com_google_android_gms_internal_zzbxm.zzq(1, this.zzaN);
            }
            if (this.zzaO != null) {
                com_google_android_gms_internal_zzbxm.zzq(2, this.zzaO);
            }
            if (this.zzaP != null) {
                com_google_android_gms_internal_zzbxm.zzq(3, this.zzaP);
            }
            if (this.zzaQ != null) {
                com_google_android_gms_internal_zzbxm.zzq(4, this.zzaQ);
            }
            if (this.zzaR != null) {
                com_google_android_gms_internal_zzbxm.zzq(5, this.zzaR);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zzd(com_google_android_gms_internal_zzbxl);
        }

        public zzc zzd(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.zzaN = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case CommonStatusCodes.DEAD_CLIENT /*18*/:
                        this.zzaO = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        this.zzaP = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzaQ = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        this.zzaR = com_google_android_gms_internal_zzbxl.readString();
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
            if (this.zzaN != null) {
                zzu += zzbxm.zzr(1, this.zzaN);
            }
            if (this.zzaO != null) {
                zzu += zzbxm.zzr(2, this.zzaO);
            }
            if (this.zzaP != null) {
                zzu += zzbxm.zzr(3, this.zzaP);
            }
            if (this.zzaQ != null) {
                zzu += zzbxm.zzr(4, this.zzaQ);
            }
            return this.zzaR != null ? zzu + zzbxm.zzr(5, this.zzaR) : zzu;
        }
    }
}
