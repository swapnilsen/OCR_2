package com.facebook.ads.internal.p021m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

/* renamed from: com.facebook.ads.internal.m.ah */
public class ah {
    public static Bitmap m2153a(Context context, af afVar) {
        byte[] decode = Base64.decode(afVar.m2147a(context.getResources().getDisplayMetrics().density), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable m2154b(Context context, af afVar) {
        return new BitmapDrawable(context.getResources(), ah.m2153a(context, afVar));
    }
}
