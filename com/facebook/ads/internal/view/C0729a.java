package com.facebook.ads.internal.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.p021m.C0713v;

/* renamed from: com.facebook.ads.internal.view.a */
public abstract class C0729a extends WebView {
    private static final String f1787a;
    private boolean f1788b;

    static {
        f1787a = C0729a.class.getSimpleName();
    }

    public C0729a(Context context) {
        super(context);
        m2346c();
    }

    private void m2346c() {
        setWebChromeClient(m2347a());
        setWebViewClient(m2348b());
        C0713v.m2316b(this);
        getSettings().setJavaScriptEnabled(true);
        if (VERSION.SDK_INT >= 17) {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        if (VERSION.SDK_INT >= 21) {
            try {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            } catch (Exception e) {
                Log.w(f1787a, "Failed to initialize CookieManager.");
            }
        }
    }

    protected WebChromeClient m2347a() {
        return new WebChromeClient();
    }

    protected WebViewClient m2348b() {
        return new WebViewClient();
    }

    public void destroy() {
        this.f1788b = true;
        super.destroy();
    }

    public boolean m2349e() {
        return this.f1788b;
    }
}
