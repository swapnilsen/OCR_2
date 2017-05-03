package net.nend.android;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import java.lang.ref.WeakReference;

final class NendAdController {
    private static final int MESSAGE_CODE = 718;
    private final Ad mAd;
    private final Handler mHandler;
    private boolean mHasWindowFocus;
    private boolean mReloadable;

    private static class ControllerHandler extends Handler {
        private WeakReference<Ad> weakReference;

        ControllerHandler(Looper looper, Ad ad) {
            super(looper);
            this.weakReference = new WeakReference(ad);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            Ad ad = (Ad) this.weakReference.get();
            if (ad != null) {
                ad.requestAd();
            }
        }
    }

    NendAdController(Ad ad) {
        this.mHasWindowFocus = false;
        this.mReloadable = true;
        if (ad == null) {
            throw new NullPointerException("Ad object is null.");
        }
        this.mAd = ad;
        this.mHandler = new ControllerHandler(Looper.getMainLooper(), ad);
    }

    void setReloadable(boolean z) {
        this.mReloadable = z;
        if (z) {
            reloadAd();
        } else {
            cancelRequest();
        }
    }

    void requestAd() {
        cancelRequest();
        this.mHandler.sendEmptyMessage(MESSAGE_CODE);
    }

    boolean reloadAd() {
        if (!this.mReloadable || !this.mHasWindowFocus || this.mHandler.hasMessages(MESSAGE_CODE)) {
            return false;
        }
        this.mHandler.sendEmptyMessageDelayed(MESSAGE_CODE, (long) (this.mAd.getReloadIntervalInSeconds() * PointerIconCompat.TYPE_DEFAULT));
        return true;
    }

    void cancelRequest() {
        this.mHandler.removeMessages(MESSAGE_CODE);
        this.mAd.cancelRequest();
    }

    void onWindowFocusChanged(boolean z) {
        this.mHasWindowFocus = z;
        if (z && this.mAd.isRequestable()) {
            reloadAd();
        }
    }
}
