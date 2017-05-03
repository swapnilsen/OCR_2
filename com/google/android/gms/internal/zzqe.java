package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.zze;
import com.google.api.client.http.ExponentialBackOffPolicy;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

@zzme
public class zzqe {
    public static final Handler zzYP;
    private static final String zzYQ;
    private static final String zzYR;
    private static final String zzYS;
    private static final String zzYT;
    private static final String zzYU;
    private static final String zzYV;

    public interface zza {
        void zzu(String str);
    }

    /* renamed from: com.google.android.gms.internal.zzqe.1 */
    class C13821 implements zza {

        /* renamed from: com.google.android.gms.internal.zzqe.1.1 */
        class C13811 extends Thread {
            final /* synthetic */ String zzsg;

            C13811(C13821 c13821, String str) {
                this.zzsg = str;
            }

            public void run() {
                new zzqg().zzu(this.zzsg);
            }
        }

        C13821(zzqe com_google_android_gms_internal_zzqe) {
        }

        public void zzu(String str) {
            new C13811(this, str).start();
        }
    }

    static {
        zzYP = new Handler(Looper.getMainLooper());
        zzYQ = AdView.class.getName();
        zzYR = InterstitialAd.class.getName();
        zzYS = PublisherAdView.class.getName();
        zzYT = PublisherInterstitialAd.class.getName();
        zzYU = SearchAdView.class.getName();
        zzYV = AdLoader.class.getName();
    }

    private void zza(ViewGroup viewGroup, zzeg com_google_android_gms_internal_zzeg, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int zzb = zzb(context, 3);
            frameLayout.addView(textView, new LayoutParams(com_google_android_gms_internal_zzeg.widthPixels - zzb, com_google_android_gms_internal_zzeg.heightPixels - zzb, 17));
            viewGroup.addView(frameLayout, com_google_android_gms_internal_zzeg.widthPixels, com_google_android_gms_internal_zzeg.heightPixels);
        }
    }

    public int zza(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    @Nullable
    public String zza(StackTraceElement[] stackTraceElementArr, String str) {
        String className;
        for (int i = 0; i + 1 < stackTraceElementArr.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzYQ.equalsIgnoreCase(className2) || zzYR.equalsIgnoreCase(className2) || zzYS.equalsIgnoreCase(className2) || zzYT.equalsIgnoreCase(className2) || zzYU.equalsIgnoreCase(className2) || zzYV.equalsIgnoreCase(className2))) {
                className = stackTraceElementArr[i + 1].getClassName();
                break;
            }
        }
        className = null;
        if (str != null) {
            CharSequence zzb = zzb(str, ".", 3);
            if (!(className == null || className.contains(zzb))) {
                return className;
            }
        }
        return null;
    }

    public void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        zza(context, str, str2, bundle, z, new C13821(this));
    }

    public void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z, zza com_google_android_gms_internal_zzqe_zza) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("appid", applicationContext.getPackageName());
            if (str == null) {
                str = zze.zzuY().zzaC(context) + "." + 10298000;
            }
            bundle.putString("js", str);
        }
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter(FacebookAdapter.KEY_ID, str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        com_google_android_gms_internal_zzqe_zza.zzu(appendQueryParameter.toString());
    }

    public void zza(ViewGroup viewGroup, zzeg com_google_android_gms_internal_zzeg, String str) {
        zza(viewGroup, com_google_android_gms_internal_zzeg, str, (int) ViewCompat.MEASURED_STATE_MASK, -1);
    }

    public void zza(ViewGroup viewGroup, zzeg com_google_android_gms_internal_zzeg, String str, String str2) {
        zzqf.zzbh(str2);
        zza(viewGroup, com_google_android_gms_internal_zzeg, str, (int) SupportMenu.CATEGORY_MASK, (int) ViewCompat.MEASURED_STATE_MASK);
    }

    public void zza(boolean z, HttpURLConnection httpURLConnection, @Nullable String str) {
        httpURLConnection.setConnectTimeout(ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS);
        if (str != null) {
            httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public String zzad(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || zzli()) {
            string = "emulator";
        }
        return zzbe(string);
    }

    @Nullable
    public String zzae(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
    }

    public boolean zzaf(Context context) {
        return zze.zzuY().isGooglePlayServicesAvailable(context) == 0;
    }

    public boolean zzag(Context context) {
        int isGooglePlayServicesAvailable = zze.zzuY().isGooglePlayServicesAvailable(context);
        return isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2;
    }

    public boolean zzah(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    @TargetApi(17)
    public boolean zzai(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (zzt.zzzj()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            i = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        } else {
            try {
                i = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        boolean z = displayMetrics.heightPixels == i && displayMetrics.widthPixels == i2;
        return z;
    }

    public int zzaj(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }

    public int zzb(Context context, int i) {
        return zza(context.getResources().getDisplayMetrics(), i);
    }

    public int zzb(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    java.lang.String zzb(java.lang.String r6, java.lang.String r7, int r8) {
        /*
        r5 = this;
        r2 = new java.util.StringTokenizer;
        r2.<init>(r6, r7);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = r8 + -1;
        if (r8 <= 0) goto L_0x0038;
    L_0x000e:
        r1 = r2.hasMoreElements();
        if (r1 == 0) goto L_0x0038;
    L_0x0014:
        r1 = r2.nextToken();
        r3.append(r1);
    L_0x001b:
        r1 = r0 + -1;
        if (r0 <= 0) goto L_0x0034;
    L_0x001f:
        r0 = r2.hasMoreElements();
        if (r0 == 0) goto L_0x0034;
    L_0x0025:
        r0 = ".";
        r0 = r3.append(r0);
        r4 = r2.nextToken();
        r0.append(r4);
        r0 = r1;
        goto L_0x001b;
    L_0x0034:
        r6 = r3.toString();
    L_0x0038:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqe.zzb(java.lang.String, java.lang.String, int):java.lang.String");
    }

    public String zzbe(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    public int zzc(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return zzb(displayMetrics, i);
    }

    public boolean zzli() {
        return Build.DEVICE.startsWith("generic");
    }

    public boolean zzlj() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
