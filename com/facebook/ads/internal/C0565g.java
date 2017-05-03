package com.facebook.ads.internal;

import android.support.v7.appcompat.C0268R;
import com.google.api.client.http.HttpStatusCodes;

/* renamed from: com.facebook.ads.internal.g */
public enum C0565g {
    UNKNOWN(0),
    WEBVIEW_BANNER_LEGACY(4),
    WEBVIEW_BANNER_50(5),
    WEBVIEW_BANNER_90(6),
    WEBVIEW_BANNER_250(7),
    WEBVIEW_INTERSTITIAL_UNKNOWN(100),
    WEBVIEW_INTERSTITIAL_HORIZONTAL(C0268R.styleable.AppCompatTheme_autoCompleteTextViewStyle),
    WEBVIEW_INTERSTITIAL_VERTICAL(C0268R.styleable.AppCompatTheme_buttonStyle),
    WEBVIEW_INTERSTITIAL_TABLET(C0268R.styleable.AppCompatTheme_buttonStyleSmall),
    NATIVE_UNKNOWN(HttpStatusCodes.STATUS_CODE_OK),
    REWARDED_VIDEO(400),
    NATIVE_250(201),
    INSTREAM_VIDEO(HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES);
    
    private final int f1331n;

    private C0565g(int i) {
        this.f1331n = i;
    }

    public int m1750a() {
        return this.f1331n;
    }
}
