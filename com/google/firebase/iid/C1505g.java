package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.api.client.http.HttpStatusCodes;
import java.util.LinkedList;
import java.util.Queue;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.firebase.iid.g */
public class C1505g {
    private static C1505g f4592c;
    @VisibleForTesting
    final Queue<Intent> f4593a;
    @VisibleForTesting
    final Queue<Intent> f4594b;
    private final SimpleArrayMap<String, String> f4595d;
    private Boolean f4596e;

    private C1505g() {
        this.f4595d = new SimpleArrayMap();
        this.f4596e = null;
        this.f4593a = new LinkedList();
        this.f4594b = new LinkedList();
    }

    public static PendingIntent m5189a(Context context, int i, Intent intent, int i2) {
        return C1505g.m5190a(context, i, "com.google.firebase.INSTANCE_ID_EVENT", intent, i2);
    }

    private static PendingIntent m5190a(Context context, int i, String str, Intent intent, int i2) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdInternalReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, i2);
    }

    public static synchronized C1505g m5191a() {
        C1505g c1505g;
        synchronized (C1505g.class) {
            if (f4592c == null) {
                f4592c = new C1505g();
            }
            c1505g = f4592c;
        }
        return c1505g;
    }

    private boolean m5192a(Context context) {
        if (this.f4596e == null) {
            this.f4596e = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        return this.f4596e.booleanValue();
    }

    private int m5193b(Context context, Intent intent) {
        m5195c(context, intent);
        try {
            ComponentName startWakefulService;
            if (m5192a(context)) {
                startWakefulService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                startWakefulService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (startWakefulService != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return HttpStatusCodes.STATUS_CODE_NOT_FOUND;
        } catch (Throwable e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return HttpStatusCodes.STATUS_CODE_UNAUTHORIZED;
        }
    }

    public static PendingIntent m5194b(Context context, int i, Intent intent, int i2) {
        return C1505g.m5190a(context, i, "com.google.firebase.MESSAGING_EVENT", intent, i2);
    }

    private void m5195c(Context context, Intent intent) {
        String str;
        synchronized (this.f4595d) {
            str = (String) this.f4595d.get(intent.getAction());
        }
        if (str == null) {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
                return;
            }
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                String valueOf = String.valueOf(serviceInfo.packageName);
                str = String.valueOf(serviceInfo.name);
                Log.e("FirebaseInstanceId", new StringBuilder((String.valueOf(valueOf).length() + 94) + String.valueOf(str).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(valueOf).append("/").append(str).toString());
                return;
            }
            str = serviceInfo.name;
            if (str.startsWith(".")) {
                String valueOf2 = String.valueOf(context.getPackageName());
                str = String.valueOf(str);
                str = str.length() != 0 ? valueOf2.concat(str) : new String(valueOf2);
            }
            synchronized (this.f4595d) {
                this.f4595d.put(intent.getAction(), str);
            }
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            valueOf = "FirebaseInstanceId";
            String str2 = "Restricting intent to a specific service: ";
            valueOf2 = String.valueOf(str);
            Log.d(valueOf, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
        intent.setClassName(context.getPackageName(), str);
    }

    public int m5196a(Context context, String str, Intent intent) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -842411455:
                if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
                    obj = null;
                    break;
                }
                break;
            case 41532704:
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                this.f4593a.offer(intent);
                break;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                this.f4594b.offer(intent);
                break;
            default:
                String str2 = "FirebaseInstanceId";
                String str3 = "Unknown service action: ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return HttpStatusCodes.STATUS_CODE_SERVER_ERROR;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return m5193b(context, intent2);
    }

    public void m5197a(Context context, Intent intent) {
        m5196a(context, "com.google.firebase.INSTANCE_ID_EVENT", intent);
    }

    public Intent m5198b() {
        return (Intent) this.f4593a.poll();
    }

    public Intent m5199c() {
        return (Intent) this.f4594b.poll();
    }
}
