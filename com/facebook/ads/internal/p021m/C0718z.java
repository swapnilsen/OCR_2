package com.facebook.ads.internal.p021m;

import android.text.TextUtils;
import com.facebook.ads.internal.view.p040a.C0730d;

/* renamed from: com.facebook.ads.internal.m.z */
public class C0718z {
    private final C0730d f1765a;
    private boolean f1766b;

    public C0718z(C0730d c0730d) {
        this.f1766b = true;
        this.f1765a = c0730d;
    }

    private static long m2330a(String str, String str2) {
        long j = -1;
        Object substring = str.substring(str2.length());
        if (!TextUtils.isEmpty(substring)) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(substring));
                if (valueOf.longValue() >= 0) {
                    j = valueOf.longValue();
                }
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public void m2331a() {
        if (!this.f1766b) {
            return;
        }
        if (this.f1765a.canGoBack() || this.f1765a.canGoForward()) {
            this.f1766b = false;
        } else {
            this.f1765a.m2361b("void((function() {try {  if (!window.performance || !window.performance.timing || !document ||       !document.body || document.body.scrollHeight <= 0 ||       !document.body.children || document.body.children.length < 1) {    return;  }  var nvtiming__an_t = window.performance.timing;  if (nvtiming__an_t.responseEnd > 0) {    console.log('ANNavResponseEnd:'+nvtiming__an_t.responseEnd);  }  if (nvtiming__an_t.domContentLoadedEventStart > 0) {    console.log('ANNavDomContentLoaded:' + nvtiming__an_t.domContentLoadedEventStart);  }  if (nvtiming__an_t.loadEventEnd > 0) {    console.log('ANNavLoadEventEnd:' + nvtiming__an_t.loadEventEnd);  }} catch(err) {  console.log('an_navigation_timing_error:' + err.message);}})());");
        }
    }

    public void m2332a(String str) {
        if (!this.f1766b) {
            return;
        }
        if (str.startsWith("ANNavResponseEnd:")) {
            this.f1765a.m2358a(C0718z.m2330a(str, "ANNavResponseEnd:"));
        } else if (str.startsWith("ANNavDomContentLoaded:")) {
            this.f1765a.m2360b(C0718z.m2330a(str, "ANNavDomContentLoaded:"));
        } else if (str.startsWith("ANNavLoadEventEnd:")) {
            this.f1765a.m2362c(C0718z.m2330a(str, "ANNavLoadEventEnd:"));
        }
    }

    public void m2333a(boolean z) {
        this.f1766b = z;
    }
}
