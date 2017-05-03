package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Map;
import java.util.Map.Entry;

public final class RemoteMessage extends zza {
    public static final Creator<RemoteMessage> CREATOR;
    Bundle f4621a;
    private Map<String, String> f4622b;
    private Notification f4623c;

    public static class Builder {
        private final Bundle f4607a;
        private final Map<String, String> f4608b;

        public Builder(String str) {
            this.f4607a = new Bundle();
            this.f4608b = new ArrayMap();
            if (TextUtils.isEmpty(str)) {
                String str2 = "Invalid to: ";
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            this.f4607a.putString("google.to", str);
        }

        public Builder addData(String str, String str2) {
            this.f4608b.put(str, str2);
            return this;
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            for (Entry entry : this.f4608b.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
            bundle.putAll(this.f4607a);
            String d = FirebaseInstanceId.m5100a().m5114d();
            if (d != null) {
                this.f4607a.putString("from", d);
            } else {
                this.f4607a.remove("from");
            }
            return new RemoteMessage(bundle);
        }

        public Builder clearData() {
            this.f4608b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f4607a.putString("collapse_key", str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f4608b.clear();
            this.f4608b.putAll(map);
            return this;
        }

        public Builder setMessageId(String str) {
            this.f4607a.putString("google.message_id", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f4607a.putString("message_type", str);
            return this;
        }

        public Builder setTtl(int i) {
            this.f4607a.putString("google.ttl", String.valueOf(i));
            return this;
        }
    }

    public static class Notification {
        private final String f4609a;
        private final String f4610b;
        private final String[] f4611c;
        private final String f4612d;
        private final String f4613e;
        private final String[] f4614f;
        private final String f4615g;
        private final String f4616h;
        private final String f4617i;
        private final String f4618j;
        private final String f4619k;
        private final Uri f4620l;

        private Notification(Bundle bundle) {
            this.f4609a = C1510a.m5230a(bundle, "gcm.n.title");
            this.f4610b = C1510a.m5239b(bundle, "gcm.n.title");
            this.f4611c = m5225a(bundle, "gcm.n.title");
            this.f4612d = C1510a.m5230a(bundle, "gcm.n.body");
            this.f4613e = C1510a.m5239b(bundle, "gcm.n.body");
            this.f4614f = m5225a(bundle, "gcm.n.body");
            this.f4615g = C1510a.m5230a(bundle, "gcm.n.icon");
            this.f4616h = C1510a.m5244d(bundle);
            this.f4617i = C1510a.m5230a(bundle, "gcm.n.tag");
            this.f4618j = C1510a.m5230a(bundle, "gcm.n.color");
            this.f4619k = C1510a.m5230a(bundle, "gcm.n.click_action");
            this.f4620l = C1510a.m5238b(bundle);
        }

        private String[] m5225a(Bundle bundle, String str) {
            Object[] c = C1510a.m5242c(bundle, str);
            if (c == null) {
                return null;
            }
            String[] strArr = new String[c.length];
            for (int i = 0; i < c.length; i++) {
                strArr[i] = String.valueOf(c[i]);
            }
            return strArr;
        }

        @Nullable
        public String getBody() {
            return this.f4612d;
        }

        @Nullable
        public String[] getBodyLocalizationArgs() {
            return this.f4614f;
        }

        @Nullable
        public String getBodyLocalizationKey() {
            return this.f4613e;
        }

        @Nullable
        public String getClickAction() {
            return this.f4619k;
        }

        @Nullable
        public String getColor() {
            return this.f4618j;
        }

        @Nullable
        public String getIcon() {
            return this.f4615g;
        }

        @Nullable
        public Uri getLink() {
            return this.f4620l;
        }

        @Nullable
        public String getSound() {
            return this.f4616h;
        }

        @Nullable
        public String getTag() {
            return this.f4617i;
        }

        @Nullable
        public String getTitle() {
            return this.f4609a;
        }

        @Nullable
        public String[] getTitleLocalizationArgs() {
            return this.f4611c;
        }

        @Nullable
        public String getTitleLocalizationKey() {
            return this.f4610b;
        }
    }

    static {
        CREATOR = new zze();
    }

    RemoteMessage(Bundle bundle) {
        this.f4621a = bundle;
    }

    void m5226a(Intent intent) {
        intent.putExtras(this.f4621a);
    }

    public String getCollapseKey() {
        return this.f4621a.getString("collapse_key");
    }

    public Map<String, String> getData() {
        if (this.f4622b == null) {
            this.f4622b = new ArrayMap();
            for (String str : this.f4621a.keySet()) {
                Object obj = this.f4621a.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!(str.startsWith("google.") || str.startsWith("gcm.") || str.equals("from") || str.equals("message_type") || str.equals("collapse_key"))) {
                        this.f4622b.put(str, str2);
                    }
                }
            }
        }
        return this.f4622b;
    }

    public String getFrom() {
        return this.f4621a.getString("from");
    }

    public String getMessageId() {
        String string = this.f4621a.getString("google.message_id");
        return string == null ? this.f4621a.getString("message_id") : string;
    }

    public String getMessageType() {
        return this.f4621a.getString("message_type");
    }

    public Notification getNotification() {
        if (this.f4623c == null && C1510a.m5235a(this.f4621a)) {
            this.f4623c = new Notification(null);
        }
        return this.f4623c;
    }

    public long getSentTime() {
        Object obj = this.f4621a.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException e) {
                String valueOf = String.valueOf(obj);
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid sent time: ").append(valueOf).toString());
            }
        }
        return 0;
    }

    public String getTo() {
        return this.f4621a.getString("google.to");
    }

    public int getTtl() {
        Object obj = this.f4621a.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                String valueOf = String.valueOf(obj);
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(valueOf).length() + 13).append("Invalid TTL: ").append(valueOf).toString());
            }
        }
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.m5279a(this, parcel, i);
    }
}
