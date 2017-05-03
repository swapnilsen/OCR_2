package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.widget.TextView;
import com.facebook.ads.internal.p025h.C0492s;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0750n;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.internal.view.c.b.c */
public class C0773c extends C0765m {
    private final TextView f1845b;
    private final String f1846c;
    private final C0492s<C0750n> f1847d;

    /* renamed from: com.facebook.ads.internal.view.c.b.c.1 */
    class C07721 extends C0492s<C0750n> {
        final /* synthetic */ C0773c f1844a;

        C07721(C0773c c0773c) {
            this.f1844a = c0773c;
        }

        public Class<C0750n> m2401a() {
            return C0750n.class;
        }

        public void m2403a(C0750n c0750n) {
            this.f1844a.f1845b.setText(this.f1844a.m2405a((long) (this.f1844a.getVideoView().getDuration() - this.f1844a.getVideoView().getCurrentPosition())));
        }
    }

    public C0773c(Context context, String str) {
        super(context);
        this.f1847d = new C07721(this);
        this.f1845b = new TextView(context);
        this.f1846c = str;
        addView(this.f1845b);
    }

    private String m2405a(long j) {
        if (j <= 0) {
            return "00:00";
        }
        long toMinutes = TimeUnit.MILLISECONDS.toMinutes(j);
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(j % 60000);
        if (this.f1846c.isEmpty()) {
            return String.format("%02d:%02d", new Object[]{Long.valueOf(toMinutes), Long.valueOf(toSeconds)});
        }
        return this.f1846c.replace("{{REMAINING_TIME}}", String.format("%02d:%02d", new Object[]{Long.valueOf(toMinutes), Long.valueOf(toSeconds)}));
    }

    protected void a_(C0827j c0827j) {
        c0827j.getEventBus().m1846a(this.f1847d);
        super.a_(c0827j);
    }

    public void setCountdownTextColor(int i) {
        this.f1845b.setTextColor(i);
    }
}
