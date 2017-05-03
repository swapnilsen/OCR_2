package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompatApi21.SharedElementCallback21;
import android.view.View;
import java.util.List;
import java.util.Map;

@TargetApi(23)
@RequiresApi(23)
class ActivityCompatApi23 {

    public static abstract class SharedElementCallback23 extends SharedElementCallback21 {
        public abstract void onSharedElementsArrived(List<String> list, List<View> list2, OnSharedElementsReadyListenerBridge onSharedElementsReadyListenerBridge);
    }

    public interface OnSharedElementsReadyListenerBridge {
        void onSharedElementsReady();
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    private static class SharedElementCallbackImpl extends SharedElementCallback {
        private SharedElementCallback23 mCallback;

        /* renamed from: android.support.v4.app.ActivityCompatApi23.SharedElementCallbackImpl.1 */
        class C00881 implements OnSharedElementsReadyListenerBridge {
            final /* synthetic */ OnSharedElementsReadyListener val$listener;

            C00881(OnSharedElementsReadyListener onSharedElementsReadyListener) {
                this.val$listener = onSharedElementsReadyListener;
            }

            public void onSharedElementsReady() {
                this.val$listener.onSharedElementsReady();
            }
        }

        public SharedElementCallbackImpl(SharedElementCallback23 sharedElementCallback23) {
            this.mCallback = sharedElementCallback23;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementStart(list, list2, list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementEnd(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.mCallback.onRejectSharedElements(list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.mCallback.onMapSharedElements(list, map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.mCallback.onCreateSnapshotView(context, parcelable);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.mCallback.onSharedElementsArrived(list, list2, new C00881(onSharedElementsReadyListener));
        }
    }

    ActivityCompatApi23() {
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback23 sharedElementCallback23) {
        activity.setEnterSharedElementCallback(createCallback(sharedElementCallback23));
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback23 sharedElementCallback23) {
        activity.setExitSharedElementCallback(createCallback(sharedElementCallback23));
    }

    private static SharedElementCallback createCallback(SharedElementCallback23 sharedElementCallback23) {
        if (sharedElementCallback23 != null) {
            return new SharedElementCallbackImpl(sharedElementCallback23);
        }
        return null;
    }
}
