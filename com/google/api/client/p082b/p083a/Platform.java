package com.google.api.client.p082b.p083a;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: com.google.api.client.b.a.d */
final class Platform {
    private static final ThreadLocal<char[]> f4120a;

    /* renamed from: com.google.api.client.b.a.d.1 */
    static class Platform extends ThreadLocal<char[]> {
        Platform() {
        }

        protected /* synthetic */ Object initialValue() {
            return m4825a();
        }

        protected char[] m4825a() {
            return new char[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        }
    }

    static char[] m4826a() {
        return (char[]) f4120a.get();
    }

    static {
        f4120a = new Platform();
    }
}
