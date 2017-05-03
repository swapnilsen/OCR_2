package com.google.android.gms.internal;

import android.support.v7.appcompat.C0268R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.api.client.http.HttpRequest;
import net.nend.android.NendAdIconLayout;

public interface zzaf {

    public static final class zza extends zzbxn<zza> {
        public String stackTrace;
        public String zzaS;
        public Long zzaT;
        public String zzaU;
        public String zzaV;
        public Long zzaW;
        public Long zzaX;
        public String zzaY;
        public Long zzaZ;
        public String zzba;

        public zza() {
            this.zzaS = null;
            this.zzaT = null;
            this.stackTrace = null;
            this.zzaU = null;
            this.zzaV = null;
            this.zzaW = null;
            this.zzaX = null;
            this.zzaY = null;
            this.zzaZ = null;
            this.zzba = null;
            this.zzcuR = -1;
        }

        public void zza(zzbxm com_google_android_gms_internal_zzbxm) {
            if (this.zzaS != null) {
                com_google_android_gms_internal_zzbxm.zzq(1, this.zzaS);
            }
            if (this.zzaT != null) {
                com_google_android_gms_internal_zzbxm.zzb(2, this.zzaT.longValue());
            }
            if (this.stackTrace != null) {
                com_google_android_gms_internal_zzbxm.zzq(3, this.stackTrace);
            }
            if (this.zzaU != null) {
                com_google_android_gms_internal_zzbxm.zzq(4, this.zzaU);
            }
            if (this.zzaV != null) {
                com_google_android_gms_internal_zzbxm.zzq(5, this.zzaV);
            }
            if (this.zzaW != null) {
                com_google_android_gms_internal_zzbxm.zzb(6, this.zzaW.longValue());
            }
            if (this.zzaX != null) {
                com_google_android_gms_internal_zzbxm.zzb(7, this.zzaX.longValue());
            }
            if (this.zzaY != null) {
                com_google_android_gms_internal_zzbxm.zzq(8, this.zzaY);
            }
            if (this.zzaZ != null) {
                com_google_android_gms_internal_zzbxm.zzb(9, this.zzaZ.longValue());
            }
            if (this.zzba != null) {
                com_google_android_gms_internal_zzbxm.zzq(10, this.zzba);
            }
            super.zza(com_google_android_gms_internal_zzbxm);
        }

        public /* synthetic */ zzbxt zzb(zzbxl com_google_android_gms_internal_zzbxl) {
            return zze(com_google_android_gms_internal_zzbxl);
        }

        public zza zze(zzbxl com_google_android_gms_internal_zzbxl) {
            while (true) {
                int zzaeo = com_google_android_gms_internal_zzbxl.zzaeo();
                switch (zzaeo) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        break;
                    case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                        this.zzaS = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case CommonStatusCodes.CANCELED /*16*/:
                        this.zzaT = Long.valueOf(com_google_android_gms_internal_zzbxl.zzaer());
                        continue;
                    case C0268R.styleable.Toolbar_logoDescription /*26*/:
                        this.stackTrace = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzaU = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        this.zzaV = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        this.zzaW = Long.valueOf(com_google_android_gms_internal_zzbxl.zzaer());
                        continue;
                    case C0268R.styleable.AppCompatTheme_dividerVertical /*56*/:
                        this.zzaX = Long.valueOf(com_google_android_gms_internal_zzbxl.zzaer());
                        continue;
                    case C0268R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                        this.zzaY = com_google_android_gms_internal_zzbxl.readString();
                        continue;
                    case C0268R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                        this.zzaZ = Long.valueOf(com_google_android_gms_internal_zzbxl.zzaer());
                        continue;
                    case C0268R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        this.zzba = com_google_android_gms_internal_zzbxl.readString();
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
            if (this.zzaS != null) {
                zzu += zzbxm.zzr(1, this.zzaS);
            }
            if (this.zzaT != null) {
                zzu += zzbxm.zzf(2, this.zzaT.longValue());
            }
            if (this.stackTrace != null) {
                zzu += zzbxm.zzr(3, this.stackTrace);
            }
            if (this.zzaU != null) {
                zzu += zzbxm.zzr(4, this.zzaU);
            }
            if (this.zzaV != null) {
                zzu += zzbxm.zzr(5, this.zzaV);
            }
            if (this.zzaW != null) {
                zzu += zzbxm.zzf(6, this.zzaW.longValue());
            }
            if (this.zzaX != null) {
                zzu += zzbxm.zzf(7, this.zzaX.longValue());
            }
            if (this.zzaY != null) {
                zzu += zzbxm.zzr(8, this.zzaY);
            }
            if (this.zzaZ != null) {
                zzu += zzbxm.zzf(9, this.zzaZ.longValue());
            }
            return this.zzba != null ? zzu + zzbxm.zzr(10, this.zzba) : zzu;
        }
    }
}
