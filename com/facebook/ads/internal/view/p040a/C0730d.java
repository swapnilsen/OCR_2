package com.facebook.ads.internal.view.p040a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.p021m.C0713v;
import com.facebook.ads.internal.p021m.C0718z;
import com.facebook.ads.internal.view.C0729a;
import java.util.HashSet;
import java.util.Set;

@TargetApi(19)
/* renamed from: com.facebook.ads.internal.view.a.d */
public class C0730d extends C0729a {
    private static final String f1789a;
    private static final Set<String> f1790b;
    private C0728a f1791c;
    private C0718z f1792d;
    private long f1793e;
    private long f1794f;
    private long f1795g;
    private long f1796h;

    /* renamed from: com.facebook.ads.internal.view.a.d.1 */
    class C07261 extends WebChromeClient {
        final /* synthetic */ C0730d f1785a;

        C07261(C0730d c0730d) {
            this.f1785a = c0730d;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            if (!TextUtils.isEmpty(message) && consoleMessage.messageLevel() == MessageLevel.LOG) {
                this.f1785a.f1792d.m2332a(message);
            }
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            this.f1785a.f1792d.m2331a();
            if (this.f1785a.f1791c != null) {
                this.f1785a.f1791c.m2342a(i);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (this.f1785a.f1791c != null) {
                this.f1785a.f1791c.m2344b(str);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a.d.2 */
    class C07272 extends WebViewClient {
        final /* synthetic */ C0730d f1786a;

        C07272(C0730d c0730d) {
            this.f1786a = c0730d;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f1786a.f1791c != null) {
                this.f1786a.f1791c.m2345c(str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (this.f1786a.f1791c != null) {
                this.f1786a.f1791c.m2343a(str);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            if (!C0730d.f1790b.contains(parse.getScheme())) {
                try {
                    this.f1786a.getContext().startActivity(new Intent("android.intent.action.VIEW", parse));
                    return true;
                } catch (Throwable e) {
                    Log.w(C0730d.f1789a, "Activity not found to handle URI.", e);
                } catch (Throwable e2) {
                    Log.e(C0730d.f1789a, "Unknown exception occurred when trying to handle URI.", e2);
                }
            }
            return false;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a.d.a */
    public interface C0728a {
        void m2342a(int i);

        void m2343a(String str);

        void m2344b(String str);

        void m2345c(String str);
    }

    static {
        f1789a = C0730d.class.getSimpleName();
        f1790b = new HashSet(2);
        f1790b.add("http");
        f1790b.add("https");
    }

    public C0730d(Context context) {
        super(context);
        this.f1793e = -1;
        this.f1794f = -1;
        this.f1795g = -1;
        this.f1796h = -1;
        m2355f();
    }

    public static boolean m2351a(String str) {
        return f1790b.contains(str);
    }

    private void m2355f() {
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        this.f1792d = new C0718z(this);
    }

    private void m2356g() {
        if (this.f1794f > -1 && this.f1795g > -1 && this.f1796h > -1) {
            this.f1792d.m2333a(false);
        }
    }

    protected WebChromeClient m2357a() {
        return new C07261(this);
    }

    public void m2358a(long j) {
        if (this.f1793e < 0) {
            this.f1793e = j;
        }
    }

    protected WebViewClient m2359b() {
        return new C07272(this);
    }

    public void m2360b(long j) {
        if (this.f1794f < 0) {
            this.f1794f = j;
        }
        m2356g();
    }

    public void m2361b(String str) {
        try {
            evaluateJavascript(str, null);
        } catch (IllegalStateException e) {
            loadUrl("javascript:" + str);
        }
    }

    public void m2362c(long j) {
        if (this.f1796h < 0) {
            this.f1796h = j;
        }
        m2356g();
    }

    public void destroy() {
        C0713v.m2315a(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.f1794f;
    }

    public String getFirstUrl() {
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        return copyBackForwardList.getSize() > 0 ? copyBackForwardList.getItemAtIndex(0).getUrl() : getUrl();
    }

    public long getLoadFinishMs() {
        return this.f1796h;
    }

    public long getResponseEndMs() {
        return this.f1793e;
    }

    public long getScrollReadyMs() {
        return this.f1795g;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1795g < 0 && computeVerticalScrollRange() > getHeight()) {
            this.f1795g = System.currentTimeMillis();
            m2356g();
        }
    }

    public void setListener(C0728a c0728a) {
        this.f1791c = c0728a;
    }
}
