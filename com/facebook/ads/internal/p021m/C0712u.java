package com.facebook.ads.internal.p021m;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C0430b;
import com.facebook.ads.C0441e;
import com.facebook.ads.C0442f;
import com.facebook.ads.C0852j;
import com.facebook.ads.internal.C0565g;
import com.facebook.ads.internal.C0649j;
import com.facebook.ads.internal.view.p040a.C0730d;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.m.u */
public class C0712u {
    private static final Uri f1740a;
    private static final String f1741b;
    private static final Map<C0442f, C0565g> f1742c;

    /* renamed from: com.facebook.ads.internal.m.u.a */
    public static class C0711a {
        public String f1737a;
        public String f1738b;
        public boolean f1739c;

        public C0711a(String str, String str2, boolean z) {
            this.f1737a = str;
            this.f1738b = str2;
            this.f1739c = z;
        }
    }

    static {
        f1740a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
        f1741b = C0712u.class.getSimpleName();
        f1742c = new HashMap();
        f1742c.put(C0442f.f756b, C0565g.WEBVIEW_INTERSTITIAL_UNKNOWN);
        f1742c.put(C0442f.f759e, C0565g.WEBVIEW_BANNER_250);
        f1742c.put(C0442f.f758d, C0565g.WEBVIEW_BANNER_90);
        f1742c.put(C0442f.f757c, C0565g.WEBVIEW_BANNER_50);
    }

    private static Intent m2291a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setComponent(null);
        if (VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    public static final <P, PR, R> AsyncTask<P, PR, R> m2292a(AsyncTask<P, PR, R> asyncTask, P... pArr) {
        if (VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, pArr);
        } else {
            asyncTask.execute(pArr);
        }
        return asyncTask;
    }

    public static C0565g m2293a(C0442f c0442f) {
        C0565g c0565g = (C0565g) f1742c.get(c0442f);
        return c0565g == null ? C0565g.WEBVIEW_BANNER_LEGACY : c0565g;
    }

    public static C0711a m2294a(ContentResolver contentResolver) {
        C0711a c0711a;
        Throwable th;
        Cursor query;
        try {
            ContentResolver contentResolver2 = contentResolver;
            query = contentResolver2.query(f1740a, new String[]{"aid", "androidid", "limit_tracking"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c0711a = new C0711a(query.getString(query.getColumnIndex("aid")), query.getString(query.getColumnIndex("androidid")), Boolean.valueOf(query.getString(query.getColumnIndex("limit_tracking"))).booleanValue());
                        if (query != null) {
                            query.close();
                        }
                        return c0711a;
                    }
                } catch (Exception e) {
                    try {
                        c0711a = new C0711a(null, null, false);
                        if (query != null) {
                            query.close();
                        }
                        return c0711a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            c0711a = new C0711a(null, null, false);
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            query = null;
            c0711a = new C0711a(null, null, false);
            if (query != null) {
                query.close();
            }
            return c0711a;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return c0711a;
    }

    public static Object m2295a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String m2296a(double d) {
        return String.format(Locale.US, "%.3f", new Object[]{Double.valueOf(d)});
    }

    public static String m2297a(long j) {
        return C0712u.m2296a(((double) j) / 1000.0d);
    }

    public static String m2298a(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                stringWriter.write(cArr, 0, read);
            } else {
                String stringWriter2 = stringWriter.toString();
                stringWriter.close();
                inputStreamReader.close();
                return stringWriter2;
            }
        }
    }

    public static String m2299a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    public static String m2300a(JSONObject jSONObject, String str) {
        return C0712u.m2301a(jSONObject, str, null);
    }

    public static String m2301a(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str, str2);
        return "null".equals(optString) ? null : optString;
    }

    public static String m2302a(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            String a = C0712u.m2298a(gZIPInputStream);
            gZIPInputStream.close();
            byteArrayInputStream.close();
            return a;
        } catch (Throwable e) {
            C0706q.m2279a(C0705p.m2276a(e, "Error decompressing data"));
            e.printStackTrace();
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
    }

    public static Method m2303a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method m2304a(String str, String str2, Class<?>... clsArr) {
        try {
            return C0712u.m2303a(Class.forName(str), str2, (Class[]) clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static void m2305a(Context context, Uri uri) {
        Intent a = C0712u.m2291a(uri);
        a.addCategory("android.intent.category.BROWSABLE");
        a.addFlags(268435456);
        a.putExtra("com.android.browser.application_id", context.getPackageName());
        a.putExtra("create_new_tab", false);
        context.startActivity(a);
    }

    public static void m2306a(Context context, Uri uri, String str) {
        if (C0730d.m2351a(uri.getScheme()) && C0649j.m2053c(context)) {
            C0712u.m2312b(context, uri, str);
        } else {
            C0712u.m2305a(context, uri);
        }
    }

    public static void m2307a(Context context, String str) {
        if (C0441e.m1055a(context)) {
            Log.d("FBAudienceNetworkLog", str + " (displayed for test ads only)");
        }
    }

    public static void m2308a(DisplayMetrics displayMetrics, View view, C0442f c0442f) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= c0442f.m1060a() ? displayMetrics.widthPixels : (int) Math.ceil((double) (((float) c0442f.m1060a()) * displayMetrics.density)), (int) Math.ceil((double) (((float) c0442f.m1061b()) * displayMetrics.density)));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }

    public static boolean m2309a(Context context) {
        try {
            RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(2).get(0);
            String str = runningTaskInfo.topActivity.getPackageName() + ".UnityPlayerActivity";
            boolean z = runningTaskInfo.topActivity.getClassName() == str || C0712u.m2313b(str);
            Boolean valueOf = Boolean.valueOf(z);
            Log.d("IS_UNITY", Boolean.toString(valueOf.booleanValue()));
            return valueOf.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean m2310a(String str, String str2) {
        try {
            Class.forName(str + "." + str2);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static byte[] m2311a(String str) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Throwable e) {
            C0706q.m2279a(C0705p.m2276a(e, "Error compressing data"));
            e.printStackTrace();
            return new byte[0];
        }
    }

    private static void m2312b(Context context, Uri uri, String str) {
        Intent intent = new Intent(context, AudienceNetworkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("viewType", C0430b.BROWSER);
        intent.putExtra("browserURL", uri.toString());
        intent.putExtra("clientToken", str);
        intent.putExtra("handlerTime", System.currentTimeMillis());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setClass(context, C0852j.class);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                C0712u.m2305a(context, uri);
            }
        }
    }

    public static boolean m2313b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
