package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(24)
@RequiresApi(24)
class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String str, Bundle bundle);

        void onPrepareFromSearch(String str, Bundle bundle);

        void onPrepareFromUri(Uri uri, Bundle bundle);
    }

    static class CallbackProxy<T extends Callback> extends CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onPrepare() {
            ((Callback) this.mCallback).onPrepare();
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromMediaId(str, bundle);
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromSearch(str, bundle);
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromUri(uri, bundle);
        }
    }

    MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCallingPackage(java.lang.Object r3) {
        /*
        r3 = (android.media.session.MediaSession) r3;
        r0 = r3.getClass();	 Catch:{ NoSuchMethodException -> 0x0023, InvocationTargetException -> 0x0025, IllegalAccessException -> 0x0019 }
        r1 = "getCallingPackage";
        r2 = 0;
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0023, InvocationTargetException -> 0x0025, IllegalAccessException -> 0x0019 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0023, InvocationTargetException -> 0x0025, IllegalAccessException -> 0x0019 }
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ NoSuchMethodException -> 0x0023, InvocationTargetException -> 0x0025, IllegalAccessException -> 0x0019 }
        r0 = r0.invoke(r3, r1);	 Catch:{ NoSuchMethodException -> 0x0023, InvocationTargetException -> 0x0025, IllegalAccessException -> 0x0019 }
        r0 = (java.lang.String) r0;	 Catch:{ NoSuchMethodException -> 0x0023, InvocationTargetException -> 0x0025, IllegalAccessException -> 0x0019 }
    L_0x0018:
        return r0;
    L_0x0019:
        r0 = move-exception;
    L_0x001a:
        r1 = "MediaSessionCompatApi24";
        r2 = "Cannot execute MediaSession.getCallingPackage()";
        android.util.Log.e(r1, r2, r0);
        r0 = 0;
        goto L_0x0018;
    L_0x0023:
        r0 = move-exception;
        goto L_0x001a;
    L_0x0025:
        r0 = move-exception;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompatApi24.getCallingPackage(java.lang.Object):java.lang.String");
    }
}
