package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.api.client.http.ExponentialBackOffPolicy;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public class PlusOneDummyView extends FrameLayout {
    public static final String TAG = "PlusOneDummyView";

    private interface zzd {
        Drawable getDrawable(int i);

        boolean isValid();
    }

    private static class zza implements zzd {
        private Context mContext;

        private zza(Context context) {
            this.mContext = context;
        }

        public Drawable getDrawable(int i) {
            return this.mContext.getResources().getDrawable(17301508);
        }

        public boolean isValid() {
            return true;
        }
    }

    private static class zzb implements zzd {
        private Context mContext;

        private zzb(Context context) {
            this.mContext = context;
        }

        public Drawable getDrawable(int i) {
            try {
                String str;
                Resources resources = this.mContext.createPackageContext(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 4).getResources();
                String str2 = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
                switch (i) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        str = "ic_plusone_small";
                        break;
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        str = "ic_plusone_medium";
                        break;
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        str = "ic_plusone_tall";
                        break;
                    default:
                        str = "ic_plusone_standard";
                        break;
                }
                return resources.getDrawable(resources.getIdentifier(str, "drawable", str2));
            } catch (NameNotFoundException e) {
                return null;
            }
        }

        public boolean isValid() {
            try {
                this.mContext.createPackageContext(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 4).getResources();
                return true;
            } catch (NameNotFoundException e) {
                return false;
            }
        }
    }

    private static class zzc implements zzd {
        private Context mContext;

        private zzc(Context context) {
            this.mContext = context;
        }

        public Drawable getDrawable(int i) {
            String str;
            switch (i) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    str = "ic_plusone_small_off_client";
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    str = "ic_plusone_medium_off_client";
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str = "ic_plusone_tall_off_client";
                    break;
                default:
                    str = "ic_plusone_standard_off_client";
                    break;
            }
            return this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName()));
        }

        public boolean isValid() {
            return (this.mContext.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.mContext.getPackageName()) == 0 || this.mContext.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.mContext.getPackageName()) == 0 || this.mContext.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.mContext.getPackageName()) == 0 || this.mContext.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.mContext.getPackageName()) == 0) ? false : true;
        }
    }

    public PlusOneDummyView(Context context, int i) {
        super(context);
        View button = new Button(context);
        button.setEnabled(false);
        button.setBackgroundDrawable(zzOV().getDrawable(i));
        Point zzmZ = zzmZ(i);
        addView(button, new LayoutParams(zzmZ.x, zzmZ.y, 17));
    }

    private zzd zzOV() {
        zzd com_google_android_gms_plus_PlusOneDummyView_zzb = new zzb(null);
        if (!com_google_android_gms_plus_PlusOneDummyView_zzb.isValid()) {
            com_google_android_gms_plus_PlusOneDummyView_zzb = new zzc(null);
        }
        return !com_google_android_gms_plus_PlusOneDummyView_zzb.isValid() ? new zza(null) : com_google_android_gms_plus_PlusOneDummyView_zzb;
    }

    private Point zzmZ(int i) {
        int i2 = 24;
        int i3 = 20;
        Point point = new Point();
        switch (i) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                i3 = 14;
                break;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                i2 = 32;
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                i2 = 50;
                break;
            default:
                i2 = 38;
                i3 = 24;
                break;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, (float) i2, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, (float) i3, displayMetrics);
        point.x = (int) (((double) applyDimension) + ExponentialBackOffPolicy.DEFAULT_RANDOMIZATION_FACTOR);
        point.y = (int) (((double) applyDimension2) + ExponentialBackOffPolicy.DEFAULT_RANDOMIZATION_FACTOR);
        return point;
    }
}
