package com.google.firebase.iid;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import com.google.firebase.iid.C1507h.C1506a;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class FirebaseInstanceIdService extends C1491b {
    @VisibleForTesting
    static final Object f4544a;
    @VisibleForTesting
    static boolean f4545b;
    private static BroadcastReceiver f4546d;
    private boolean f4547e;

    /* renamed from: com.google.firebase.iid.FirebaseInstanceIdService.1 */
    class C14901 extends BroadcastReceiver {
        final /* synthetic */ int f4537a;
        final /* synthetic */ FirebaseInstanceIdService f4538b;

        C14901(FirebaseInstanceIdService firebaseInstanceIdService, int i) {
            this.f4538b = firebaseInstanceIdService;
            this.f4537a = i;
        }

        public void onReceive(Context context, Intent intent) {
            if (FirebaseInstanceIdService.m5137c(context)) {
                if (this.f4538b.f4547e) {
                    Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                }
                this.f4538b.getApplicationContext().unregisterReceiver(this);
                C1505g.m5191a().m5197a(context, FirebaseInstanceIdService.m5135c(this.f4537a));
            }
        }
    }

    static {
        f4544a = new Object();
        f4545b = false;
    }

    public FirebaseInstanceIdService() {
        this.f4547e = false;
    }

    private int m5125a(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        return (intExtra >= 10 || z) ? intExtra >= 10 ? intExtra > 28800 ? 28800 : intExtra : 10 : 30;
    }

    private C1498d m5127a(String str) {
        if (str == null) {
            return C1498d.m5152a(this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return C1498d.m5152a(this, bundle);
    }

    static void m5128a(Context context) {
        if (C1504f.m5168a(context) != null) {
            synchronized (f4544a) {
                if (!f4545b) {
                    C1505g.m5191a().m5197a(context, m5135c(0));
                    f4545b = true;
                }
            }
        }
    }

    static void m5129a(Context context, FirebaseInstanceId firebaseInstanceId) {
        synchronized (f4544a) {
            if (f4545b) {
                return;
            }
            C1506a e = firebaseInstanceId.m5115e();
            if (e == null || e.m5202b(C1498d.f4562e) || firebaseInstanceId.m5117g().m5160a() != null) {
                m5128a(context);
            }
        }
    }

    private void m5130a(Intent intent, String str) {
        boolean c = m5137c((Context) this);
        int a = m5125a(intent, c);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(a).append("s").toString());
        synchronized (f4544a) {
            m5138d(a);
            f4545b = true;
        }
        if (!c) {
            if (this.f4547e) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (f4546d == null) {
                f4546d = new C14901(this, a);
            }
            getApplicationContext().registerReceiver(f4546d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5131a(android.content.Intent r9, boolean r10, boolean r11) {
        /*
        r8 = this;
        r2 = 1;
        r1 = 0;
        r3 = f4544a;
        monitor-enter(r3);
        r0 = 0;
        f4545b = r0;	 Catch:{ all -> 0x0010 }
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        r0 = com.google.firebase.iid.C1504f.m5168a(r8);
        if (r0 != 0) goto L_0x0013;
    L_0x000f:
        return;
    L_0x0010:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        throw r0;
    L_0x0013:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m5100a();
        r3 = r0.m5115e();
        if (r3 == 0) goto L_0x0025;
    L_0x001d:
        r4 = com.google.firebase.iid.C1498d.f4562e;
        r4 = r3.m5202b(r4);
        if (r4 == 0) goto L_0x0063;
    L_0x0025:
        r1 = r0.m5116f();	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r1 == 0) goto L_0x0054;
    L_0x002b:
        r2 = r8.f4547e;	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r2 == 0) goto L_0x0036;
    L_0x002f:
        r2 = "FirebaseInstanceId";
        r4 = "get master token succeeded";
        android.util.Log.d(r2, r4);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
    L_0x0036:
        m5129a(r8, r0);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r11 != 0) goto L_0x0047;
    L_0x003b:
        if (r3 == 0) goto L_0x0047;
    L_0x003d:
        if (r3 == 0) goto L_0x000f;
    L_0x003f:
        r0 = r3.f4598a;	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        r0 = r1.equals(r0);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r0 != 0) goto L_0x000f;
    L_0x0047:
        r8.m5140a();	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        goto L_0x000f;
    L_0x004b:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m5130a(r9, r0);
        goto L_0x000f;
    L_0x0054:
        r0 = "returned token is null";
        r8.m5130a(r9, r0);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        goto L_0x000f;
    L_0x005a:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = "Unable to get master token";
        android.util.Log.e(r1, r2, r0);
        goto L_0x000f;
    L_0x0063:
        r4 = r0.m5117g();
        r0 = r4.m5160a();
        r3 = r0;
    L_0x006c:
        if (r3 == 0) goto L_0x00d4;
    L_0x006e:
        r0 = "!";
        r0 = r3.split(r0);
        r5 = r0.length;
        r6 = 2;
        if (r5 != r6) goto L_0x0087;
    L_0x0078:
        r5 = r0[r1];
        r6 = r0[r2];
        r0 = -1;
        r7 = r5.hashCode();	 Catch:{ IOException -> 0x00b7 }
        switch(r7) {
            case 83: goto L_0x0090;
            case 84: goto L_0x0084;
            case 85: goto L_0x009a;
            default: goto L_0x0084;
        };
    L_0x0084:
        switch(r0) {
            case 0: goto L_0x00a4;
            case 1: goto L_0x00c1;
            default: goto L_0x0087;
        };
    L_0x0087:
        r4.m5162b(r3);
        r0 = r4.m5160a();
        r3 = r0;
        goto L_0x006c;
    L_0x0090:
        r7 = "S";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00b7 }
        if (r5 == 0) goto L_0x0084;
    L_0x0098:
        r0 = r1;
        goto L_0x0084;
    L_0x009a:
        r7 = "U";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00b7 }
        if (r5 == 0) goto L_0x0084;
    L_0x00a2:
        r0 = r2;
        goto L_0x0084;
    L_0x00a4:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m5100a();	 Catch:{ IOException -> 0x00b7 }
        r0.m5111b(r6);	 Catch:{ IOException -> 0x00b7 }
        r0 = r8.f4547e;	 Catch:{ IOException -> 0x00b7 }
        if (r0 == 0) goto L_0x0087;
    L_0x00af:
        r0 = "FirebaseInstanceId";
        r5 = "subscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00b7 }
        goto L_0x0087;
    L_0x00b7:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m5130a(r9, r0);
        goto L_0x000f;
    L_0x00c1:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m5100a();	 Catch:{ IOException -> 0x00b7 }
        r0.m5113c(r6);	 Catch:{ IOException -> 0x00b7 }
        r0 = r8.f4547e;	 Catch:{ IOException -> 0x00b7 }
        if (r0 == 0) goto L_0x0087;
    L_0x00cc:
        r0 = "FirebaseInstanceId";
        r5 = "unsubscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00b7 }
        goto L_0x0087;
    L_0x00d4:
        r0 = "FirebaseInstanceId";
        r1 = "topic sync succeeded";
        android.util.Log.d(r0, r1);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Intent, boolean, boolean):void");
    }

    private void m5132a(C1504f c1504f, Bundle bundle) {
        String a = C1504f.m5168a((Context) this);
        if (a == null) {
            Log.w("FirebaseInstanceId", "Unable to respond to ping due to missing target package");
            return;
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        intent.setPackage(a);
        intent.putExtras(bundle);
        c1504f.m5181a(intent);
        intent.putExtra("google.to", "google.com/iid");
        intent.putExtra("google.message_id", C1504f.m5178c());
        sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    private static Intent m5135c(int i) {
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return intent;
    }

    private String m5136c(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING : stringExtra;
    }

    private static boolean m5137c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void m5138d(int i) {
        ((AlarmManager) getSystemService(NotificationCompatApi24.CATEGORY_ALARM)).set(3, SystemClock.elapsedRealtime() + ((long) (i * PointerIconCompat.TYPE_DEFAULT)), C1505g.m5189a(this, 0, m5135c(i * 2), 134217728));
    }

    protected Intent m5139a(Intent intent) {
        return C1505g.m5191a().m5198b();
    }

    @WorkerThread
    public void m5140a() {
    }

    public void m5141b(Intent intent) {
        String c = m5136c(intent);
        C1498d a = m5127a(c);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.f4547e) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(((String.valueOf(c).length() + 18) + String.valueOf(stringExtra).length()) + String.valueOf(valueOf).length()).append("Service command ").append(c).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            C1507h c2 = a.m5157c();
            if (c == null) {
                c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            }
            c2.m5215c(c);
            a.m5159d().m5188d(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            a.m5157c().m5215c(c);
            m5131a(intent, false, true);
        } else if ("RST".equals(stringExtra)) {
            a.m5156b();
            m5131a(intent, true, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!a.m5157c().m5213b()) {
                a.m5156b();
                a.m5157c().m5214c();
                m5131a(intent, true, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            a.m5157c().m5215c(c);
            m5131a(intent, false, true);
        } else if ("PING".equals(stringExtra)) {
            m5132a(a.m5159d(), intent.getExtras());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleIntent(android.content.Intent r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r5.getAction();
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        r0 = "";
    L_0x0009:
        r2 = -1;
        r3 = r0.hashCode();
        switch(r3) {
            case -1737547627: goto L_0x0019;
            default: goto L_0x0011;
        };
    L_0x0011:
        r0 = r2;
    L_0x0012:
        switch(r0) {
            case 0: goto L_0x0023;
            default: goto L_0x0015;
        };
    L_0x0015:
        r4.m5141b(r5);
    L_0x0018:
        return;
    L_0x0019:
        r3 = "ACTION_TOKEN_REFRESH_RETRY";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0011;
    L_0x0021:
        r0 = r1;
        goto L_0x0012;
    L_0x0023:
        r4.m5131a(r5, r1, r1);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.handleIntent(android.content.Intent):void");
    }

    public boolean zzE(Intent intent) {
        this.f4547e = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return false;
        }
        String c = m5136c(intent);
        if (this.f4547e) {
            String str = "FirebaseInstanceId";
            String str2 = "Register result in service ";
            String valueOf = String.valueOf(c);
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        m5127a(c).m5159d().m5188d(intent);
        return true;
    }
}
