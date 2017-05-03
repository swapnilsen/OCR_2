package com.google.api.client.p082b;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.google.api.client.b.y */
public final class Objects {

    /* renamed from: com.google.api.client.b.y.a */
    public static final class Objects {
        private final String f4222a;
        private Objects f4223b;
        private Objects f4224c;
        private boolean f4225d;

        /* renamed from: com.google.api.client.b.y.a.a */
        private static final class Objects {
            String f4219a;
            Object f4220b;
            Objects f4221c;

            private Objects() {
            }
        }

        Objects(String str) {
            this.f4223b = new Objects();
            this.f4224c = this.f4223b;
            this.f4222a = str;
        }

        public Objects m4965a(String str, Object obj) {
            return m4964b(str, obj);
        }

        public String toString() {
            boolean z = this.f4225d;
            String str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            StringBuilder append = new StringBuilder(32).append(this.f4222a).append('{');
            String str2 = str;
            Objects objects = this.f4223b.f4221c;
            while (objects != null) {
                if (!z || objects.f4220b != null) {
                    append.append(str2);
                    str2 = ", ";
                    if (objects.f4219a != null) {
                        append.append(objects.f4219a).append('=');
                    }
                    append.append(objects.f4220b);
                }
                objects = objects.f4221c;
            }
            return append.append('}').toString();
        }

        private Objects m4963a() {
            Objects objects = new Objects();
            this.f4224c.f4221c = objects;
            this.f4224c = objects;
            return objects;
        }

        private Objects m4964b(String str, Object obj) {
            Objects a = m4963a();
            a.f4220b = obj;
            a.f4219a = (String) Preconditions.m4968a((Object) str);
            return this;
        }
    }

    public static boolean m4967a(Object obj, Object obj2) {
        return com.google.api.client.p072a.p073a.p074a.p075a.p076a.Objects.m4747a(obj, obj2);
    }

    public static Objects m4966a(Object obj) {
        return new Objects(obj.getClass().getSimpleName());
    }
}
