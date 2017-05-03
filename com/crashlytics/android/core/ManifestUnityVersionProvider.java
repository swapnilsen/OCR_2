package com.crashlytics.android.core;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

class ManifestUnityVersionProvider implements UnityVersionProvider {
    static final String FABRIC_UNITY_CRASHLYTICS_VERSION_KEY = "io.fabric.unity.crashlytics.version";
    private final Context context;
    private final String packageName;

    public ManifestUnityVersionProvider(Context context, String str) {
        this.context = context;
        this.packageName = str;
    }

    public String getUnityVersion() {
        String str = null;
        try {
            Bundle bundle = this.context.getPackageManager().getApplicationInfo(this.packageName, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS).metaData;
            if (bundle != null) {
                str = bundle.getString(FABRIC_UNITY_CRASHLYTICS_VERSION_KEY);
            }
        } catch (Exception e) {
        }
        return str;
    }
}
