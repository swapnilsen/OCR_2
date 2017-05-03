package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzdi {
    private Context mContext;
    private Tracker zzabD;
    private GoogleAnalytics zzabF;

    static class zza implements Logger {
        zza() {
        }

        private static int zznI(int i) {
            switch (i) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    return 0;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    return 1;
                case Type.OTHER_PROFILE /*5*/:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            zzbo.zzb(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, exception);
        }

        public void error(String str) {
            zzbo.m4711e(str);
        }

        public int getLogLevel() {
            return zznI(zzbo.getLogLevel());
        }

        public void info(String str) {
            zzbo.zzbg(str);
        }

        public void setLogLevel(int i) {
            zzbo.zzbh("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String str) {
            zzbo.m4712v(str);
        }

        public void warn(String str) {
            zzbo.zzbh(str);
        }
    }

    public zzdi(Context context) {
        this.mContext = context;
    }

    private synchronized void zzhu(String str) {
        if (this.zzabF == null) {
            this.zzabF = GoogleAnalytics.getInstance(this.mContext);
            this.zzabF.setLogger(new zza());
            this.zzabD = this.zzabF.newTracker(str);
        }
    }

    public Tracker zzht(String str) {
        zzhu(str);
        return this.zzabD;
    }
}
