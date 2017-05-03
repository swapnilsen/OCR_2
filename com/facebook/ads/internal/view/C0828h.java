package com.facebook.ads.internal.view;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.C0854l;
import com.facebook.ads.C0855m;
import com.facebook.ads.internal.p021m.C0690e;
import com.facebook.ads.internal.p024b.C0475g;
import com.facebook.ads.internal.p025h.C0578f;
import com.facebook.ads.internal.p037k.C0652a;
import com.facebook.ads.internal.view.p038c.p042b.C0788f;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.facebook.ads.internal.view.h */
public class C0828h extends C0827j {
    static final /* synthetic */ boolean f2046a;
    private final String f2047c;
    private final C0854l f2048d;
    private final C0578f f2049e;
    private final C0652a f2050f;
    private final C0475g f2051g;
    private final C0788f f2052h;
    @Nullable
    private C0690e f2053i;
    @Nullable
    private String f2054j;
    @Nullable
    private Uri f2055k;
    @Nullable
    private String f2056l;
    @Nullable
    private String f2057m;
    @Nullable
    private C0855m f2058n;
    private boolean f2059o;

    static {
        f2046a = !C0828h.class.desiredAssertionStatus();
    }

    private void m2559k() {
        if (getVisibility() == 0 && this.f2059o) {
            this.f2050f.m2088a();
        } else {
            this.f2050f.m2091b();
        }
    }

    public void m2560a(String str, @Nullable String str2) {
        if (this.f2053i != null) {
            this.f2053i.m2249a();
        }
        String str3 = str2 == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING : str2;
        this.f2053i = new C0690e(getContext(), this.f2049e, this, str, str3);
        this.f2056l = str3;
        this.f2054j = str;
    }

    public void m2561d() {
        if (C0652a.m2073a((View) this, 50).m2093a()) {
            super.m2553d();
        }
    }

    @Nullable
    public C0855m getListener() {
        return this.f2058n;
    }

    public C0854l getMediaView() {
        return this.f2048d;
    }

    public String getUniqueId() {
        return this.f2047c;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2059o = true;
        this.f2051g.m1241a();
        m2559k();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2059o = false;
        this.f2051g.m1242b();
        m2559k();
    }

    protected void onVisibilityChanged(View view, int i) {
        m2559k();
        super.onVisibilityChanged(view, i);
    }

    public void setImage(String str) {
        this.f2052h.setImage(str);
    }

    public void setListener(C0855m c0855m) {
        this.f2058n = c0855m;
    }

    public void setVideoMPD(String str) {
        if (f2046a || this.f2053i != null) {
            this.f2057m = str;
            super.setVideoMPD(str);
            return;
        }
        throw new AssertionError();
    }

    public void setVideoURI(Uri uri) {
        if (f2046a || this.f2053i != null) {
            this.f2055k = uri;
            super.setVideoURI(uri);
            return;
        }
        throw new AssertionError();
    }
}
