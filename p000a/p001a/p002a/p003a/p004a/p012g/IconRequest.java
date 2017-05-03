package p000a.p001a.p002a.p003a.p004a.p012g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;

/* renamed from: a.a.a.a.a.g.n */
public class IconRequest {
    public final String f243a;
    public final int f244b;
    public final int f245c;
    public final int f246d;

    public IconRequest(String str, int i, int i2, int i3) {
        this.f243a = str;
        this.f244b = i;
        this.f245c = i2;
        this.f246d = i3;
    }

    public static IconRequest m345a(Context context, String str) {
        if (str != null) {
            try {
                int l = CommonUtils.m79l(context);
                Fabric.m397h().m359a("Fabric", "App icon resource ID is " + l);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new IconRequest(str, l, options.outWidth, options.outHeight);
            } catch (Throwable e) {
                Fabric.m397h().m367e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
