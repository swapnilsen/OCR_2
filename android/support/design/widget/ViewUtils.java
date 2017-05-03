package android.support.design.widget;

import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;

class ViewUtils {
    static final Creator DEFAULT_ANIMATOR_CREATOR;

    /* renamed from: android.support.design.widget.ViewUtils.1 */
    static class C00631 implements Creator {
        C00631() {
        }

        public ValueAnimatorCompat createAnimator() {
            return new ValueAnimatorCompat(VERSION.SDK_INT >= 12 ? new ValueAnimatorCompatImplHoneycombMr1() : new ValueAnimatorCompatImplGingerbread());
        }
    }

    ViewUtils() {
    }

    static {
        DEFAULT_ANIMATOR_CREATOR = new C00631();
    }

    static ValueAnimatorCompat createAnimator() {
        return DEFAULT_ANIMATOR_CREATOR.createAnimator();
    }

    static boolean objectEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static Mode parseTintMode(int i, Mode mode) {
        switch (i) {
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return Mode.SRC_OVER;
            case Type.OTHER_PROFILE /*5*/:
                return Mode.SRC_IN;
            case ConnectionResult.SERVICE_INVALID /*9*/:
                return Mode.SRC_ATOP;
            case CommonStatusCodes.INTERRUPTED /*14*/:
                return Mode.MULTIPLY;
            case CommonStatusCodes.TIMEOUT /*15*/:
                return Mode.SCREEN;
            default:
                return mode;
        }
    }
}
