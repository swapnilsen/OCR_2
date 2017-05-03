package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.zzg;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.Callable;

@zzme
@TargetApi(17)
public class zzqc {
    private static zzqc zzYH;
    String zzIA;

    /* renamed from: com.google.android.gms.internal.zzqc.1 */
    class C13801 implements Callable<String> {
        final /* synthetic */ Context zzYI;
        final /* synthetic */ Context zztf;

        C13801(zzqc com_google_android_gms_internal_zzqc, Context context, Context context2) {
            this.zzYI = context;
            this.zztf = context2;
        }

        public /* synthetic */ Object call() {
            return zzbY();
        }

        public String zzbY() {
            SharedPreferences sharedPreferences;
            int i = 1;
            if (this.zzYI != null) {
                zzpk.m4709v("Attempting to read user agent from Google Play Services.");
                sharedPreferences = this.zzYI.getSharedPreferences("admob_user_agent", 1);
                i = 0;
            } else {
                zzpk.m4709v("Attempting to read user agent from local cache.");
                sharedPreferences = this.zztf.getSharedPreferences("admob_user_agent", 0);
            }
            String string = sharedPreferences.getString("user_agent", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
            if (TextUtils.isEmpty(string)) {
                zzpk.m4709v("Reading user agent from WebSettings");
                string = WebSettings.getDefaultUserAgent(this.zztf);
                if (i != 0) {
                    this.zztf.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", string).apply();
                    zzpk.m4709v("Persisting user agent.");
                }
            }
            return string;
        }
    }

    static {
        zzYH = null;
    }

    private zzqc() {
    }

    public static zzqc zzld() {
        if (zzYH == null) {
            zzYH = new zzqc();
        }
        return zzYH;
    }

    public void zzaa(Context context) {
        if (TextUtils.isEmpty(this.zzIA)) {
            this.zzIA = (String) zzqb.zzb(new C13801(this, zzg.getRemoteContext(context), context));
        }
    }

    public void zzab(Context context) {
        zzpk.m4709v("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(this.zzIA)) {
            if (zzg.getRemoteContext(context) == null) {
                context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context)).apply();
            }
            this.zzIA = defaultUserAgent;
        }
        zzpk.m4709v("User agent is updated.");
    }

    public String zzac(Context context) {
        zzaa(context);
        return this.zzIA;
    }
}
