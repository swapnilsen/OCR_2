package com.facebook.ads.internal.p021m;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.facebook.ads.internal.p026d.C0533c;
import com.facebook.ads.internal.view.C0818d;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.m.ad */
public class ad extends AsyncTask<String, Void, Bitmap[]> {
    private static final String f1574a;
    private final WeakReference<Context> f1575b;
    private final WeakReference<ImageView> f1576c;
    private final WeakReference<C0818d> f1577d;
    private ae f1578e;

    static {
        f1574a = ad.class.getSimpleName();
    }

    public ad(ImageView imageView) {
        this.f1575b = new WeakReference(imageView.getContext());
        this.f1577d = null;
        this.f1576c = new WeakReference(imageView);
    }

    public ad(C0818d c0818d) {
        this.f1575b = new WeakReference(c0818d.getContext());
        this.f1577d = new WeakReference(c0818d);
        this.f1576c = null;
    }

    public ad m2143a(ae aeVar) {
        this.f1578e = aeVar;
        return this;
    }

    protected void m2144a(Bitmap[] bitmapArr) {
        if (this.f1576c != null) {
            ImageView imageView = (ImageView) this.f1576c.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmapArr[0]);
            }
        }
        if (this.f1577d != null) {
            C0818d c0818d = (C0818d) this.f1577d.get();
            if (c0818d != null) {
                c0818d.m2507a(bitmapArr[0], bitmapArr[1]);
            }
        }
        if (this.f1578e != null) {
            this.f1578e.m1301a();
        }
    }

    public void m2145a(String... strArr) {
        executeOnExecutor(THREAD_POOL_EXECUTOR, strArr);
    }

    protected Bitmap[] m2146b(String... strArr) {
        Throwable th;
        String str = strArr[0];
        Context context = (Context) this.f1575b.get();
        if (context == null) {
            return new Bitmap[]{null, null};
        }
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a;
        try {
            a = C0533c.m1649a(context).m1653a(str);
            try {
                if (this.f1577d == null || this.f1577d.get() == null || a == null) {
                    bitmap = null;
                } else {
                    try {
                        C0691f c0691f = new C0691f(a);
                        c0691f.m2251a(Math.round(((float) a.getWidth()) / 40.0f));
                        bitmap = c0691f.m2250a();
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap = a;
                        Log.e(f1574a, "Error downloading image: " + str, th);
                        C0706q.m2279a(C0705p.m2276a(th, null));
                        bitmap2 = a;
                        return new Bitmap[]{bitmap2, bitmap};
                    }
                }
                bitmap2 = a;
            } catch (Throwable th22) {
                th = th22;
                bitmap = null;
                Log.e(f1574a, "Error downloading image: " + str, th);
                C0706q.m2279a(C0705p.m2276a(th, null));
                bitmap2 = a;
                return new Bitmap[]{bitmap2, bitmap};
            }
        } catch (Throwable th222) {
            th = th222;
            a = null;
            bitmap = null;
            Log.e(f1574a, "Error downloading image: " + str, th);
            C0706q.m2279a(C0705p.m2276a(th, null));
            bitmap2 = a;
            return new Bitmap[]{bitmap2, bitmap};
        }
        return new Bitmap[]{bitmap2, bitmap};
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2146b((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m2144a((Bitmap[]) obj);
    }
}
