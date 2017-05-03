package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.http.SslError;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.p021m.C0675b;
import com.facebook.ads.internal.p021m.C0693h;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.C0713v;
import com.facebook.ads.internal.p037k.C0652a;
import com.facebook.ads.internal.p037k.C0652a.C0650a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.b */
public class C0737b extends C0729a {
    private static final String f1808a;
    private final C0428b f1809b;
    private C0693h f1810c;
    private C0652a f1811d;

    /* renamed from: com.facebook.ads.internal.view.b.b */
    public interface C0428b {
        void m1005a();

        void m1006a(int i);

        void m1007a(String str, Map<String, String> map);

        void m1008b();
    }

    /* renamed from: com.facebook.ads.internal.view.b.1 */
    class C07311 extends C0650a {
        final /* synthetic */ C0428b f1797a;
        final /* synthetic */ C0737b f1798b;

        C07311(C0737b c0737b, C0428b c0428b) {
            this.f1798b = c0737b;
            this.f1797a = c0428b;
        }

        public void m2363a() {
            this.f1798b.f1810c.m2253a();
            this.f1797a.m1008b();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.b.2 */
    class C07322 extends WebChromeClient {
        final /* synthetic */ C0737b f1799a;

        C07322(C0737b c0737b) {
            this.f1799a = c0737b;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.b.3 */
    class C07333 extends WebViewClient {
        final /* synthetic */ C0737b f1800a;

        C07333(C0737b c0737b) {
            this.f1800a = c0737b;
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Map hashMap = new HashMap();
            this.f1800a.f1811d.m2090a(hashMap);
            hashMap.put("touch", C0712u.m2299a(this.f1800a.getTouchData()));
            this.f1800a.f1809b.m1007a(str, hashMap);
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.b.a */
    public class C0734a {
        final /* synthetic */ C0737b f1801a;
        private final String f1802b;

        public C0734a(C0737b c0737b) {
            this.f1801a = c0737b;
            this.f1802b = C0734a.class.getSimpleName();
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f1802b, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return C0712u.m2299a(C0675b.m2179a());
        }

        @JavascriptInterface
        public void onPageInitialized() {
            if (!this.f1801a.m2349e()) {
                this.f1801a.f1809b.m1005a();
                if (this.f1801a.f1811d != null) {
                    this.f1801a.f1811d.m2088a();
                }
            }
        }
    }

    static {
        f1808a = C0737b.class.getSimpleName();
    }

    public C0737b(Context context, C0428b c0428b, int i) {
        super(context);
        this.f1809b = c0428b;
        getSettings().setSupportZoom(false);
        addJavascriptInterface(new C0734a(this), "AdControl");
        this.f1810c = new C0693h();
        this.f1811d = new C0652a(this, i, new C07311(this, c0428b));
    }

    protected WebChromeClient m2369a() {
        return new C07322(this);
    }

    public void m2370a(int i, int i2) {
        this.f1811d.m2089a(i);
        this.f1811d.m2092b(i2);
    }

    protected WebViewClient m2371b() {
        return new C07333(this);
    }

    public void destroy() {
        if (this.f1811d != null) {
            this.f1811d.m2091b();
            this.f1811d = null;
        }
        C0713v.m2315a(this);
        super.destroy();
    }

    public Map<String, String> getTouchData() {
        return this.f1810c.m2259e();
    }

    public C0652a getViewabilityChecker() {
        return this.f1811d;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1810c.m2254a(motionEvent, this, this);
        return super.onTouchEvent(motionEvent);
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f1809b != null) {
            this.f1809b.m1006a(i);
        }
        if (this.f1811d == null) {
            return;
        }
        if (i == 0) {
            this.f1811d.m2088a();
        } else if (i == 8) {
            this.f1811d.m2091b();
        }
    }
}
