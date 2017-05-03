package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.Random;

/* renamed from: com.google.firebase.iid.f */
public class C1504f {
    static String f4575a;
    static boolean f4576b;
    static int f4577c;
    static int f4578d;
    static int f4579e;
    static BroadcastReceiver f4580f;
    Context f4581g;
    Messenger f4582h;
    Messenger f4583i;
    MessengerCompat f4584j;
    PendingIntent f4585k;
    long f4586l;
    long f4587m;
    int f4588n;
    int f4589o;
    long f4590p;
    private final SimpleArrayMap<String, C1502b> f4591q;

    /* renamed from: com.google.firebase.iid.f.1 */
    class C15001 extends Handler {
        final /* synthetic */ C1504f f4570a;

        C15001(C1504f c1504f, Looper looper) {
            this.f4570a = c1504f;
            super(looper);
        }

        public void handleMessage(Message message) {
            this.f4570a.m5184a(message);
        }
    }

    /* renamed from: com.google.firebase.iid.f.2 */
    class C15012 extends BroadcastReceiver {
        final /* synthetic */ C1504f f4571a;

        C15012(C1504f c1504f) {
            this.f4571a = c1504f;
        }

        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 44).append("Received GSF callback via dynamic receiver: ").append(valueOf).toString());
            }
            this.f4571a.m5188d(intent);
        }
    }

    /* renamed from: com.google.firebase.iid.f.b */
    private interface C1502b {
        void m5163a(Intent intent);

        void m5164a(String str);
    }

    /* renamed from: com.google.firebase.iid.f.a */
    private static class C1503a implements C1502b {
        private final ConditionVariable f4572a;
        private Intent f4573b;
        private String f4574c;

        private C1503a() {
            this.f4572a = new ConditionVariable();
        }

        public Intent m5165a() {
            if (!this.f4572a.block(30000)) {
                Log.w("InstanceID/Rpc", "No response");
                throw new IOException("TIMEOUT");
            } else if (this.f4574c == null) {
                return this.f4573b;
            } else {
                throw new IOException(this.f4574c);
            }
        }

        public void m5166a(Intent intent) {
            this.f4573b = intent;
            this.f4572a.open();
        }

        public void m5167a(String str) {
            this.f4574c = str;
            this.f4572a.open();
        }
    }

    static {
        f4575a = null;
        f4576b = false;
        f4577c = 0;
        f4578d = 0;
        f4579e = 0;
        f4580f = null;
    }

    public C1504f(Context context) {
        this.f4591q = new SimpleArrayMap();
        this.f4581g = context;
    }

    public static String m5168a(Context context) {
        if (f4575a != null) {
            return f4575a;
        }
        f4577c = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (zzt.zzzq()) {
            if (C1504f.m5177b(packageManager) || C1504f.m5173a(packageManager)) {
                return f4575a;
            }
        } else if (C1504f.m5173a(packageManager) || C1504f.m5177b(packageManager)) {
            return f4575a;
        }
        Log.w("InstanceID/Rpc", "Failed to resolve IID implementation package, falling back");
        if (C1504f.m5174a(packageManager, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
            f4576b = zzt.zzzq();
            return f4575a;
        } else if (VERSION.SDK_INT >= 21 || !C1504f.m5174a(packageManager, "com.google.android.gsf")) {
            Log.w("InstanceID/Rpc", "Google Play services is missing, unable to get tokens");
            return null;
        } else {
            f4576b = false;
            return f4575a;
        }
    }

    static String m5169a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = FirebaseInstanceId.m5102a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void m5170a(String str) {
        if ("com.google.android.gsf".equals(f4575a)) {
            this.f4588n++;
            if (this.f4588n >= 3) {
                if (this.f4588n == 3) {
                    this.f4589o = new Random().nextInt(PointerIconCompat.TYPE_DEFAULT) + PointerIconCompat.TYPE_DEFAULT;
                }
                this.f4589o *= 2;
                this.f4590p = SystemClock.elapsedRealtime() + ((long) this.f4589o);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.f4589o).toString());
            }
        }
    }

    private void m5171a(String str, Intent intent) {
        synchronized (this.f4591q) {
            C1502b c1502b = (C1502b) this.f4591q.remove(str);
            if (c1502b == null) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Missing callback for ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return;
            }
            c1502b.m5163a(intent);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5172a(java.lang.String r6, java.lang.String r7) {
        /*
        r5 = this;
        r2 = r5.f4591q;
        monitor-enter(r2);
        if (r6 != 0) goto L_0x0025;
    L_0x0005:
        r0 = 0;
        r1 = r0;
    L_0x0007:
        r0 = r5.f4591q;	 Catch:{ all -> 0x0046 }
        r0 = r0.size();	 Catch:{ all -> 0x0046 }
        if (r1 >= r0) goto L_0x001e;
    L_0x000f:
        r0 = r5.f4591q;	 Catch:{ all -> 0x0046 }
        r0 = r0.valueAt(r1);	 Catch:{ all -> 0x0046 }
        r0 = (com.google.firebase.iid.C1504f.C1502b) r0;	 Catch:{ all -> 0x0046 }
        r0.m5164a(r7);	 Catch:{ all -> 0x0046 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0007;
    L_0x001e:
        r0 = r5.f4591q;	 Catch:{ all -> 0x0046 }
        r0.clear();	 Catch:{ all -> 0x0046 }
    L_0x0023:
        monitor-exit(r2);	 Catch:{ all -> 0x0046 }
    L_0x0024:
        return;
    L_0x0025:
        r0 = r5.f4591q;	 Catch:{ all -> 0x0046 }
        r0 = r0.remove(r6);	 Catch:{ all -> 0x0046 }
        r0 = (com.google.firebase.iid.C1504f.C1502b) r0;	 Catch:{ all -> 0x0046 }
        if (r0 != 0) goto L_0x004f;
    L_0x002f:
        r1 = "InstanceID/Rpc";
        r3 = "Missing callback for ";
        r0 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x0046 }
        r4 = r0.length();	 Catch:{ all -> 0x0046 }
        if (r4 == 0) goto L_0x0049;
    L_0x003d:
        r0 = r3.concat(r0);	 Catch:{ all -> 0x0046 }
    L_0x0041:
        android.util.Log.w(r1, r0);	 Catch:{ all -> 0x0046 }
        monitor-exit(r2);	 Catch:{ all -> 0x0046 }
        goto L_0x0024;
    L_0x0046:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0046 }
        throw r0;
    L_0x0049:
        r0 = new java.lang.String;	 Catch:{ all -> 0x0046 }
        r0.<init>(r3);	 Catch:{ all -> 0x0046 }
        goto L_0x0041;
    L_0x004f:
        r0.m5164a(r7);	 Catch:{ all -> 0x0046 }
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.f.a(java.lang.String, java.lang.String):void");
    }

    private static boolean m5173a(PackageManager packageManager) {
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (C1504f.m5175a(packageManager, resolveInfo.serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                f4576b = false;
                return true;
            }
        }
        return false;
    }

    private static boolean m5174a(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            f4575a = applicationInfo.packageName;
            f4578d = applicationInfo.uid;
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static boolean m5175a(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return C1504f.m5174a(packageManager, str);
        }
        Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(str).length() + 56) + String.valueOf(str2).length()).append("Possible malicious package ").append(str).append(" declares ").append(str2).append(" without permission").toString());
        return false;
    }

    private Intent m5176b(Bundle bundle, KeyPair keyPair) {
        String c = C1504f.m5178c();
        C1503a c1503a = new C1503a();
        synchronized (this.f4591q) {
            this.f4591q.put(c, c1503a);
        }
        m5183a(bundle, keyPair, c);
        try {
            Intent a = c1503a.m5165a();
            synchronized (this.f4591q) {
                this.f4591q.remove(c);
            }
            return a;
        } catch (Throwable th) {
            synchronized (this.f4591q) {
            }
            this.f4591q.remove(c);
        }
    }

    private static boolean m5177b(PackageManager packageManager) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0)) {
            if (C1504f.m5175a(packageManager, resolveInfo.activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                f4576b = true;
                return true;
            }
        }
        return false;
    }

    public static synchronized String m5178c() {
        String num;
        synchronized (C1504f.class) {
            int i = f4579e;
            f4579e = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    Intent m5179a(Bundle bundle, KeyPair keyPair) {
        Intent b = m5176b(bundle, keyPair);
        if (b == null || !b.hasExtra("google.messenger")) {
            return b;
        }
        b = m5176b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : null;
    }

    void m5180a() {
        if (this.f4582h == null) {
            C1504f.m5168a(this.f4581g);
            this.f4582h = new Messenger(new C15001(this, Looper.getMainLooper()));
        }
    }

    synchronized void m5181a(Intent intent) {
        if (this.f4585k == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f4585k = PendingIntent.getBroadcast(this.f4581g, 0, intent2, 0);
        }
        intent.putExtra("app", this.f4585k);
    }

    protected void m5182a(Intent intent, String str) {
        this.f4586l = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(f4575a);
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (equals) {
            m5186b();
            this.f4581g.startService(intent);
            return;
        }
        intent.putExtra("google.messenger", this.f4582h);
        if (!(this.f4583i == null && this.f4584j == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.f4583i != null) {
                    this.f4583i.send(obtain);
                    return;
                } else {
                    this.f4584j.send(obtain);
                    return;
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (f4576b) {
            this.f4581g.sendBroadcast(intent);
        } else {
            this.f4581g.startService(intent);
        }
    }

    public void m5183a(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f4590p == 0 || elapsedRealtime > this.f4590p) {
            m5180a();
            if (f4575a == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.f4586l = SystemClock.elapsedRealtime();
            Intent intent = new Intent(f4576b ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(f4575a);
            bundle.putString("gmsv", Integer.toString(FirebaseInstanceId.m5099a(this.f4581g, C1504f.m5168a(this.f4581g))));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.m5098a(this.f4581g)));
            bundle.putString("app_ver_name", FirebaseInstanceId.m5105b(this.f4581g));
            bundle.putString("cliv", "fiid-10298000");
            bundle.putString("appid", FirebaseInstanceId.m5101a(keyPair));
            bundle.putString("pub2", FirebaseInstanceId.m5102a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", C1504f.m5169a(keyPair, this.f4581g.getPackageName(), r0));
            intent.putExtras(bundle);
            m5181a(intent);
            m5182a(intent, str);
            return;
        }
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.f4590p - elapsedRealtime) + " interval: " + this.f4589o);
        throw new IOException("RETRY_LATER");
    }

    void m5184a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f4584j = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f4583i = (Messenger) parcelableExtra;
                    }
                }
                m5188d((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    String m5185b(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    void m5186b() {
        synchronized (this) {
            if (f4580f == null) {
                f4580f = new C15012(this);
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Registered GSF callback receiver");
                }
                IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
                intentFilter.addCategory(this.f4581g.getPackageName());
                this.f4581g.registerReceiver(f4580f, intentFilter, "com.google.android.c2dm.permission.SEND", null);
            }
        }
    }

    void m5187c(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        String valueOf2;
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            valueOf = "InstanceID/Rpc";
            String str = "Received InstanceID error ";
            valueOf2 = String.valueOf(stringExtra);
            Log.d(valueOf, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Unexpected structured response ";
                valueOf2 = String.valueOf(stringExtra);
                Log.w(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            }
            if (split.length > 2) {
                valueOf2 = split[2];
                valueOf = split[3];
                if (valueOf.startsWith(":")) {
                    valueOf = valueOf.substring(1);
                }
            } else {
                valueOf = "UNKNOWN";
                valueOf2 = null;
            }
            intent.putExtra("error", valueOf);
        } else {
            valueOf2 = null;
            valueOf = stringExtra;
        }
        m5172a(valueOf2, valueOf);
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.f4587m = SystemClock.elapsedRealtime();
            this.f4589o = ((int) longExtra) * PointerIconCompat.TYPE_DEFAULT;
            this.f4590p = SystemClock.elapsedRealtime() + ((long) this.f4589o);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.f4589o);
        } else if ("SERVICE_NOT_AVAILABLE".equals(valueOf) || "AUTHENTICATION_FAILED".equals(valueOf)) {
            m5170a(valueOf);
        }
    }

    void m5188d(Intent intent) {
        if (intent != null) {
            String stringExtra;
            String str;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                stringExtra = intent.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    m5187c(intent);
                    return;
                }
                this.f4586l = SystemClock.elapsedRealtime();
                this.f4590p = 0;
                this.f4588n = 0;
                this.f4589o = 0;
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        str = "InstanceID/Rpc";
                        String str2 = "Unexpected structured response ";
                        stringExtra = String.valueOf(stringExtra);
                        Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                    }
                    str = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            FirebaseInstanceId.m5106c(this.f4581g);
                        } else if ("RST".equals(split[3])) {
                            FirebaseInstanceId.m5103a(this.f4581g, C1498d.m5152a(this.f4581g, null).m5157c());
                            intent.removeExtra("registration_id");
                            m5171a(str, intent);
                            return;
                        }
                    }
                    stringExtra = split[split.length - 1];
                    if (stringExtra.startsWith(":")) {
                        stringExtra = stringExtra.substring(1);
                    }
                    intent.putExtra("registration_id", stringExtra);
                    stringExtra = str;
                } else {
                    stringExtra = null;
                }
                if (stringExtra != null) {
                    m5171a(stringExtra, intent);
                } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Ignoring response without a request ID");
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                str = "InstanceID/Rpc";
                String str3 = "Unexpected response ";
                stringExtra = String.valueOf(intent.getAction());
                Log.d(str, stringExtra.length() != 0 ? str3.concat(stringExtra) : new String(str3));
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
