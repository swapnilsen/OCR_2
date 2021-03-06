package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;

public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    PrintHelperVersionImpl mImpl;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback);

        void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback);

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    private static class PrintHelperImpl<RealHelper extends PrintHelperKitkat> implements PrintHelperVersionImpl {
        private final RealHelper mPrintHelper;

        /* renamed from: android.support.v4.print.PrintHelper.PrintHelperImpl.1 */
        class C01781 implements android.support.v4.print.PrintHelperKitkat.OnPrintFinishCallback {
            final /* synthetic */ OnPrintFinishCallback val$callback;

            C01781(OnPrintFinishCallback onPrintFinishCallback) {
                this.val$callback = onPrintFinishCallback;
            }

            public void onFinish() {
                this.val$callback.onFinish();
            }
        }

        /* renamed from: android.support.v4.print.PrintHelper.PrintHelperImpl.2 */
        class C01792 implements android.support.v4.print.PrintHelperKitkat.OnPrintFinishCallback {
            final /* synthetic */ OnPrintFinishCallback val$callback;

            C01792(OnPrintFinishCallback onPrintFinishCallback) {
                this.val$callback = onPrintFinishCallback;
            }

            public void onFinish() {
                this.val$callback.onFinish();
            }
        }

        protected PrintHelperImpl(RealHelper realHelper) {
            this.mPrintHelper = realHelper;
        }

        public void setScaleMode(int i) {
            this.mPrintHelper.setScaleMode(i);
        }

        public int getScaleMode() {
            return this.mPrintHelper.getScaleMode();
        }

        public void setColorMode(int i) {
            this.mPrintHelper.setColorMode(i);
        }

        public int getColorMode() {
            return this.mPrintHelper.getColorMode();
        }

        public void setOrientation(int i) {
            this.mPrintHelper.setOrientation(i);
        }

        public int getOrientation() {
            return this.mPrintHelper.getOrientation();
        }

        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            android.support.v4.print.PrintHelperKitkat.OnPrintFinishCallback onPrintFinishCallback2 = null;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback2 = new C01781(onPrintFinishCallback);
            }
            this.mPrintHelper.printBitmap(str, bitmap, onPrintFinishCallback2);
        }

        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
            android.support.v4.print.PrintHelperKitkat.OnPrintFinishCallback onPrintFinishCallback2 = null;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback2 = new C01792(onPrintFinishCallback);
            }
            this.mPrintHelper.printBitmap(str, uri, onPrintFinishCallback2);
        }
    }

    private static final class PrintHelperApi20Impl extends PrintHelperImpl<PrintHelperApi20> {
        PrintHelperApi20Impl(Context context) {
            super(new PrintHelperApi20(context));
        }
    }

    private static final class PrintHelperApi23Impl extends PrintHelperImpl<PrintHelperApi23> {
        PrintHelperApi23Impl(Context context) {
            super(new PrintHelperApi23(context));
        }
    }

    private static final class PrintHelperApi24Impl extends PrintHelperImpl<PrintHelperApi24> {
        PrintHelperApi24Impl(Context context) {
            super(new PrintHelperApi24(context));
        }
    }

    private static final class PrintHelperKitkatImpl extends PrintHelperImpl<PrintHelperKitkat> {
        PrintHelperKitkatImpl(Context context) {
            super(new PrintHelperKitkat(context));
        }
    }

    private static final class PrintHelperStubImpl implements PrintHelperVersionImpl {
        int mColorMode;
        int mOrientation;
        int mScaleMode;

        private PrintHelperStubImpl() {
            this.mScaleMode = PrintHelper.SCALE_MODE_FILL;
            this.mColorMode = PrintHelper.SCALE_MODE_FILL;
            this.mOrientation = PrintHelper.SCALE_MODE_FIT;
        }

        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        public int getColorMode() {
            return this.mColorMode;
        }

        public void setColorMode(int i) {
            this.mColorMode = i;
        }

        public void setOrientation(int i) {
            this.mOrientation = i;
        }

        public int getOrientation() {
            return this.mOrientation;
        }

        public int getScaleMode() {
            return this.mScaleMode;
        }

        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        }

        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        }
    }

    public static boolean systemSupportsPrint() {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return false;
    }

    public PrintHelper(Context context) {
        if (!systemSupportsPrint()) {
            this.mImpl = new PrintHelperStubImpl();
        } else if (VERSION.SDK_INT >= 24) {
            this.mImpl = new PrintHelperApi24Impl(context);
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new PrintHelperApi23Impl(context);
        } else if (VERSION.SDK_INT >= 20) {
            this.mImpl = new PrintHelperApi20Impl(context);
        } else {
            this.mImpl = new PrintHelperKitkatImpl(context);
        }
    }

    public void setScaleMode(int i) {
        this.mImpl.setScaleMode(i);
    }

    public int getScaleMode() {
        return this.mImpl.getScaleMode();
    }

    public void setColorMode(int i) {
        this.mImpl.setColorMode(i);
    }

    public int getColorMode() {
        return this.mImpl.getColorMode();
    }

    public void setOrientation(int i) {
        this.mImpl.setOrientation(i);
    }

    public int getOrientation() {
        return this.mImpl.getOrientation();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.mImpl.printBitmap(str, bitmap, null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        this.mImpl.printBitmap(str, bitmap, onPrintFinishCallback);
    }

    public void printBitmap(String str, Uri uri) {
        this.mImpl.printBitmap(str, uri, null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        this.mImpl.printBitmap(str, uri, onPrintFinishCallback);
    }
}
