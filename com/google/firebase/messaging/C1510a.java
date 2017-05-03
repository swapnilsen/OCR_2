package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzt;
import com.google.firebase.iid.C1505g;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.google.firebase.messaging.a */
class C1510a {
    static C1510a f4625a;
    private final Context f4626b;
    private Bundle f4627c;
    private final AtomicInteger f4628d;

    private C1510a(Context context) {
        this.f4628d = new AtomicInteger((int) SystemClock.elapsedRealtime());
        this.f4626b = context.getApplicationContext();
    }

    private PendingIntent m5228a(Bundle bundle, PendingIntent pendingIntent) {
        Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
        m5232a(intent, bundle);
        intent.putExtra("pending_intent", pendingIntent);
        return C1505g.m5194b(this.f4626b, m5236b(), intent, 1073741824);
    }

    static synchronized C1510a m5229a(Context context) {
        C1510a c1510a;
        synchronized (C1510a.class) {
            if (f4625a == null) {
                f4625a = new C1510a(context);
            }
            c1510a = f4625a;
        }
        return c1510a;
    }

    static String m5230a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private static String m5231a(String str) {
        return str.substring("gcm.n.".length());
    }

    private void m5232a(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private void m5233a(String str, Notification notification) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.f4626b.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    private boolean m5234a() {
        if (((KeyguardManager) this.f4626b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!zzt.zzzn()) {
            SystemClock.sleep(10);
        }
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f4626b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    static boolean m5235a(Bundle bundle) {
        return "1".equals(C1510a.m5230a(bundle, "gcm.n.e")) || C1510a.m5230a(bundle, "gcm.n.icon") != null;
    }

    private int m5236b() {
        return this.f4628d.incrementAndGet();
    }

    private int m5237b(String str) {
        int identifier;
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.f4626b.getResources();
            identifier = resources.getIdentifier(str, "drawable", this.f4626b.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            identifier = resources.getIdentifier(str, "mipmap", this.f4626b.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 61).append("Icon resource ").append(str).append(" not found. Notification will use default icon.").toString());
        }
        identifier = m5240c().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (identifier == 0) {
            identifier = this.f4626b.getApplicationInfo().icon;
        }
        return identifier == 0 ? 17301651 : identifier;
    }

    @Nullable
    static Uri m5238b(@NonNull Bundle bundle) {
        Object a = C1510a.m5230a(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(a)) {
            a = C1510a.m5230a(bundle, "gcm.n.link");
        }
        return !TextUtils.isEmpty(a) ? Uri.parse(a) : null;
    }

    static String m5239b(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        return C1510a.m5230a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private Bundle m5240c() {
        if (this.f4627c != null) {
            return this.f4627c;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.f4626b.getPackageManager().getApplicationInfo(this.f4626b.getPackageName(), AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return Bundle.EMPTY;
        }
        this.f4627c = applicationInfo.metaData;
        return this.f4627c;
    }

    private Integer m5241c(String str) {
        Integer num = null;
        if (VERSION.SDK_INT >= 21) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    num = Integer.valueOf(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 54).append("Color ").append(str).append(" not valid. Notification will use default color.").toString());
                }
            }
            int i = m5240c().getInt("com.google.firebase.messaging.default_notification_color", 0);
            if (i != 0) {
                try {
                    num = Integer.valueOf(ContextCompat.getColor(this.f4626b, i));
                } catch (NotFoundException e2) {
                    Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
                }
            }
        }
        return num;
    }

    static Object[] m5242c(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String a = C1510a.m5230a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(a);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException e) {
            valueOf = "FirebaseMessaging";
            String valueOf3 = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_args");
            valueOf2 = String.valueOf(C1510a.m5231a(valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3)));
            Log.w(valueOf, new StringBuilder((String.valueOf(valueOf2).length() + 41) + String.valueOf(a).length()).append("Malformed ").append(valueOf2).append(": ").append(a).append("  Default value will be used.").toString());
            return null;
        }
    }

    private Uri m5243d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("default".equals(str) || this.f4626b.getResources().getIdentifier(str, "raw", this.f4626b.getPackageName()) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        String valueOf = String.valueOf("android.resource://");
        String valueOf2 = String.valueOf(this.f4626b.getPackageName());
        return Uri.parse(new StringBuilder(((String.valueOf(valueOf).length() + 5) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()).append(valueOf).append(valueOf2).append("/raw/").append(str).toString());
    }

    static String m5244d(Bundle bundle) {
        Object a = C1510a.m5230a(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(a) ? C1510a.m5230a(bundle, "gcm.n.sound") : a;
    }

    private String m5245d(Bundle bundle, String str) {
        Object a = C1510a.m5230a(bundle, str);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String b = C1510a.m5239b(bundle, str);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        Resources resources = this.f4626b.getResources();
        int identifier = resources.getIdentifier(b, "string", this.f4626b.getPackageName());
        if (identifier == 0) {
            String str2 = "FirebaseMessaging";
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf("_loc_key");
            valueOf2 = String.valueOf(C1510a.m5231a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
            Log.w(str2, new StringBuilder((String.valueOf(valueOf2).length() + 49) + String.valueOf(b).length()).append(valueOf2).append(" resource not found: ").append(b).append(" Default value will be used.").toString());
            return null;
        }
        Object[] c = C1510a.m5242c(bundle, str);
        if (c == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, c);
        } catch (Throwable e) {
            valueOf = String.valueOf(Arrays.toString(c));
            Log.w("FirebaseMessaging", new StringBuilder((String.valueOf(b).length() + 58) + String.valueOf(valueOf).length()).append("Missing format argument for ").append(b).append(": ").append(valueOf).append(" Default value will be used.").toString(), e);
            return null;
        }
    }

    private Notification m5246e(Bundle bundle) {
        CharSequence d = m5245d(bundle, "gcm.n.title");
        CharSequence d2 = m5245d(bundle, "gcm.n.body");
        int b = m5237b(C1510a.m5230a(bundle, "gcm.n.icon"));
        Integer c = m5241c(C1510a.m5230a(bundle, "gcm.n.color"));
        Uri d3 = m5243d(C1510a.m5244d(bundle));
        PendingIntent f = m5247f(bundle);
        PendingIntent pendingIntent = null;
        if (FirebaseMessagingService.m5220b(bundle)) {
            f = m5228a(bundle, f);
            pendingIntent = m5249h(bundle);
        }
        Builder smallIcon = new Builder(this.f4626b).setAutoCancel(true).setSmallIcon(b);
        if (TextUtils.isEmpty(d)) {
            smallIcon.setContentTitle(this.f4626b.getApplicationInfo().loadLabel(this.f4626b.getPackageManager()));
        } else {
            smallIcon.setContentTitle(d);
        }
        if (!TextUtils.isEmpty(d2)) {
            smallIcon.setContentText(d2);
            smallIcon.setStyle(new BigTextStyle().bigText(d2));
        }
        if (c != null) {
            smallIcon.setColor(c.intValue());
        }
        if (d3 != null) {
            smallIcon.setSound(d3);
        }
        if (f != null) {
            smallIcon.setContentIntent(f);
        }
        if (pendingIntent != null) {
            smallIcon.setDeleteIntent(pendingIntent);
        }
        return smallIcon.build();
    }

    private PendingIntent m5247f(Bundle bundle) {
        Intent g = m5248g(bundle);
        if (g == null) {
            return null;
        }
        g.addFlags(67108864);
        Bundle bundle2 = new Bundle(bundle);
        FirebaseMessagingService.m5218a(bundle2);
        g.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                g.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.f4626b, m5236b(), g, 1073741824);
    }

    private Intent m5248g(Bundle bundle) {
        Object a = C1510a.m5230a(bundle, "gcm.n.click_action");
        Intent intent;
        if (TextUtils.isEmpty(a)) {
            Uri b = C1510a.m5238b(bundle);
            if (b != null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(this.f4626b.getPackageName());
                intent.setData(b);
                return intent;
            }
            intent = this.f4626b.getPackageManager().getLaunchIntentForPackage(this.f4626b.getPackageName());
            if (intent != null) {
                return intent;
            }
            Log.w("FirebaseMessaging", "No activity found to launch app");
            return intent;
        }
        intent = new Intent(a);
        intent.setPackage(this.f4626b.getPackageName());
        intent.setFlags(268435456);
        return intent;
    }

    private PendingIntent m5249h(Bundle bundle) {
        Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
        m5232a(intent, bundle);
        return C1505g.m5194b(this.f4626b, m5236b(), intent, 1073741824);
    }

    boolean m5250c(Bundle bundle) {
        if ("1".equals(C1510a.m5230a(bundle, "gcm.n.noui"))) {
            return true;
        }
        if (m5234a()) {
            return false;
        }
        m5233a(C1510a.m5230a(bundle, "gcm.n.tag"), m5246e(bundle));
        return true;
    }
}
