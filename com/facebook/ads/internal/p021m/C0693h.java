package com.facebook.ads.internal.p021m;

import android.graphics.Rect;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.facebook.ads.internal.m.h */
public class C0693h {
    private static final String f1671a;
    private boolean f1672b;
    private int f1673c;
    private int f1674d;
    private long f1675e;
    private int f1676f;
    private long f1677g;
    private long f1678h;
    private int f1679i;
    private int f1680j;
    private int f1681k;
    private int f1682l;
    private float f1683m;
    private float f1684n;
    private float f1685o;

    static {
        f1671a = C0693h.class.getSimpleName();
    }

    public C0693h() {
        this.f1673c = -1;
        this.f1674d = -1;
        this.f1675e = -1;
        this.f1676f = -1;
        this.f1677g = -1;
        this.f1678h = -1;
        this.f1679i = -1;
        this.f1680j = -1;
        this.f1681k = -1;
        this.f1682l = -1;
        this.f1683m = -1.0f;
        this.f1684n = -1.0f;
        this.f1685o = -1.0f;
    }

    public void m2253a() {
        this.f1675e = System.currentTimeMillis();
    }

    public void m2254a(MotionEvent motionEvent, View view, View view2) {
        if (!this.f1672b) {
            this.f1672b = true;
            InputDevice device = motionEvent.getDevice();
            if (device != null) {
                this.f1685o = Math.min(device.getMotionRange(0).getRange(), device.getMotionRange(1).getRange());
            } else {
                this.f1685o = (float) Math.min(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr2);
        switch (motionEvent.getAction()) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                this.f1673c = view.getWidth();
                this.f1674d = view.getHeight();
                this.f1676f = 1;
                this.f1677g = System.currentTimeMillis();
                this.f1679i = (((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0];
                this.f1680j = (iArr2[1] + ((int) (motionEvent.getY() + 0.5f))) - iArr[1];
                this.f1683m = motionEvent.getPressure();
                this.f1684n = motionEvent.getSize();
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                this.f1678h = System.currentTimeMillis();
                this.f1681k = (((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0];
                this.f1682l = (iArr2[1] + ((int) (motionEvent.getY() + 0.5f))) - iArr[1];
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                this.f1683m -= this.f1683m / ((float) this.f1676f);
                this.f1683m += motionEvent.getPressure() / ((float) this.f1676f);
                this.f1684n -= this.f1684n / ((float) this.f1676f);
                this.f1684n += motionEvent.getSize() / ((float) this.f1676f);
                this.f1676f++;
            default:
        }
    }

    public boolean m2255a(int i) {
        if (!m2258d() || this.f1681k == -1 || this.f1682l == -1 || this.f1673c == -1 || this.f1674d == -1) {
            return false;
        }
        int i2 = (this.f1674d * i) / 100;
        int i3 = (this.f1673c * i) / 100;
        return !new Rect(i3, i2, this.f1673c - i3, this.f1674d - i2).contains(this.f1681k, this.f1682l);
    }

    public boolean m2256b() {
        return this.f1675e != -1;
    }

    public long m2257c() {
        return m2256b() ? System.currentTimeMillis() - this.f1675e : -1;
    }

    public boolean m2258d() {
        return this.f1672b;
    }

    public Map<String, String> m2259e() {
        if (!this.f1672b) {
            return null;
        }
        String valueOf = String.valueOf((this.f1684n * this.f1685o) / 2.0f);
        long j = (this.f1675e <= 0 || this.f1678h <= this.f1675e) ? -1 : this.f1678h - this.f1675e;
        Map<String, String> hashMap = new HashMap();
        hashMap.put("width", String.valueOf(this.f1673c));
        hashMap.put("height", String.valueOf(this.f1674d));
        hashMap.put("clickDelayTime", String.valueOf(j));
        hashMap.put("startTime", String.valueOf(this.f1677g));
        hashMap.put("endTime", String.valueOf(this.f1678h));
        hashMap.put("startX", String.valueOf(this.f1679i));
        hashMap.put("startY", String.valueOf(this.f1680j));
        hashMap.put("clickX", String.valueOf(this.f1681k));
        hashMap.put("clickY", String.valueOf(this.f1682l));
        hashMap.put("endX", String.valueOf(this.f1681k));
        hashMap.put("endY", String.valueOf(this.f1682l));
        hashMap.put("force", String.valueOf(this.f1683m));
        hashMap.put("radiusX", valueOf);
        hashMap.put("radiusY", valueOf);
        return hashMap;
    }
}
