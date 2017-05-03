package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzx;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.firebase.iid.h */
class C1507h {
    SharedPreferences f4601a;
    Context f4602b;

    /* renamed from: com.google.firebase.iid.h.a */
    static class C1506a {
        private static final long f4597d;
        final String f4598a;
        final String f4599b;
        final long f4600c;

        static {
            f4597d = TimeUnit.DAYS.toMillis(7);
        }

        private C1506a(String str, String str2, long j) {
            this.f4598a = str;
            this.f4599b = str2;
            this.f4600c = j;
        }

        static C1506a m5200a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new C1506a(str, null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new C1506a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to parse token: ").append(valueOf).toString());
                return null;
            }
        }

        static String m5201a(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to encode token: ").append(valueOf).toString());
                return null;
            }
        }

        boolean m5202b(String str) {
            return System.currentTimeMillis() > this.f4600c + f4597d || !str.equals(this.f4599b);
        }
    }

    public C1507h(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public C1507h(Context context, String str) {
        this.f4602b = context;
        this.f4601a = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        m5205e(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private String m5203a(String str, String str2) {
        String valueOf = String.valueOf("|S|");
        return new StringBuilder((String.valueOf(str).length() + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    private String m5204c(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder((((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    private void m5205e(String str) {
        File file = new File(zzx.getNoBackupFilesDir(this.f4602b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !m5213b()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.m5103a(this.f4602b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String str2 = "InstanceID/Store";
                    String str3 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                }
            }
        }
    }

    private void m5206f(String str) {
        Editor edit = this.f4601a.edit();
        for (String str2 : this.f4601a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public SharedPreferences m5207a() {
        return this.f4601a;
    }

    public synchronized C1506a m5208a(String str, String str2, String str3) {
        return C1506a.m5200a(this.f4601a.getString(m5204c(str, str2, str3), null));
    }

    synchronized KeyPair m5209a(String str) {
        KeyPair a;
        a = C1492a.m5142a();
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = this.f4601a.edit();
        edit.putString(m5203a(str, "|P|"), FirebaseInstanceId.m5102a(a.getPublic().getEncoded()));
        edit.putString(m5203a(str, "|K|"), FirebaseInstanceId.m5102a(a.getPrivate().getEncoded()));
        edit.putString(m5203a(str, "cre"), Long.toString(currentTimeMillis));
        edit.commit();
        return a;
    }

    public synchronized void m5210a(String str, String str2, String str3, String str4, String str5) {
        String a = C1506a.m5201a(str4, str5, System.currentTimeMillis());
        if (a != null) {
            Editor edit = this.f4601a.edit();
            edit.putString(m5204c(str, str2, str3), a);
            edit.commit();
        }
    }

    synchronized void m5211b(String str) {
        m5206f(String.valueOf(str).concat("|"));
    }

    public synchronized void m5212b(String str, String str2, String str3) {
        String c = m5204c(str, str2, str3);
        Editor edit = this.f4601a.edit();
        edit.remove(c);
        edit.commit();
    }

    public synchronized boolean m5213b() {
        return this.f4601a.getAll().isEmpty();
    }

    public synchronized void m5214c() {
        this.f4601a.edit().clear().commit();
    }

    public synchronized void m5215c(String str) {
        m5206f(String.valueOf(str).concat("|T|"));
    }

    public synchronized KeyPair m5216d(String str) {
        KeyPair keyPair;
        Object e;
        String string = this.f4601a.getString(m5203a(str, "|P|"), null);
        String string2 = this.f4601a.getString(m5203a(str, "|K|"), null);
        if (string == null || string2 == null) {
            keyPair = null;
        } else {
            try {
                byte[] decode = Base64.decode(string, 8);
                byte[] decode2 = Base64.decode(string2, 8);
                KeyFactory instance = KeyFactory.getInstance("RSA");
                keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (InvalidKeySpecException e2) {
                e = e2;
                string = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(string).length() + 19).append("Invalid key stored ").append(string).toString());
                FirebaseInstanceId.m5103a(this.f4602b, this);
                keyPair = null;
                return keyPair;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                string = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(string).length() + 19).append("Invalid key stored ").append(string).toString());
                FirebaseInstanceId.m5103a(this.f4602b, this);
                keyPair = null;
                return keyPair;
            }
        }
        return keyPair;
    }
}
