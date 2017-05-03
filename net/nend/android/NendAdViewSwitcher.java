package net.nend.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendHelper.AsyncTaskHelper;
import org.apache.http.HttpEntity;

class NendAdViewSwitcher extends ViewSwitcher implements OnClickListener, Downloadable<Bitmap> {
    private static final int IMAGE_INDEX = 0;
    private static final Object[] LOCK;
    private static final int MP = -1;
    private static final int WEB_INDEX = 1;
    private AdParameter mAdParameter;
    private Bitmap mBitmap;
    private String mClickUrl;
    private EventListener mEventListener;
    private ImageView mImageView;
    private DownloadTask<Bitmap> mTask;
    private NendAdAnimationWebView mWebView;

    interface EventListener {
        void onClickAd();

        void onFailure();

        void onSuccess();

        boolean onValidation(int i, int i2);
    }

    /* renamed from: net.nend.android.NendAdViewSwitcher.1 */
    class C16451 implements EventListener {
        C16451() {
        }

        public void onSuccess() {
            NendAdViewSwitcher.this.setDisplayedChild(NendAdViewSwitcher.WEB_INDEX);
            NendAdViewSwitcher.this.onDownloadAdSuccessfully();
        }

        public void onFailure() {
            NendAdViewSwitcher.this.notifyFailure();
        }

        public boolean onValidation(int i, int i2) {
            return NendAdViewSwitcher.this.isValidAdSize(i, i2);
        }
    }

    static {
        LOCK = new Object[IMAGE_INDEX];
    }

    NendAdViewSwitcher(Context context) {
        super(context);
        this.mClickUrl = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        initViewIfNeeded(context);
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.mClickUrl) && hasAdImage()) {
            notifyClick();
            NendHelper.startBrowser(getContext(), this.mClickUrl);
        }
    }

    public String getRequestUrl() {
        return this.mAdParameter != null ? this.mAdParameter.getImageUrl() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public Bitmap makeResponse(HttpEntity httpEntity) {
        if (httpEntity != null) {
            try {
                Bitmap decodeStream;
                synchronized (LOCK) {
                    decodeStream = BitmapFactory.decodeStream(httpEntity.getContent());
                }
                return decodeStream;
            } catch (Throwable e) {
                System.gc();
                NendLog.m5590d(NendStatus.ERR_HTTP_REQUEST, e);
            } catch (Throwable e2) {
                NendLog.m5590d(NendStatus.ERR_HTTP_REQUEST, e2);
            } catch (Throwable e22) {
                NendLog.m5590d(NendStatus.ERR_HTTP_REQUEST, e22);
            }
        }
        return null;
    }

    public void onDownload(Bitmap bitmap) {
        this.mTask = null;
        if (bitmap == null) {
            notifyFailure();
        } else if (isValidAdSize(bitmap.getWidth(), bitmap.getHeight())) {
            this.mWebView.cancel();
            recycleBitmap();
            this.mBitmap = bitmap;
            this.mImageView.setImageBitmap(bitmap);
            setDisplayedChild(IMAGE_INDEX);
            onDownloadAdSuccessfully();
        }
    }

    void download(AdParameter adParameter, EventListener eventListener) {
        if (adParameter != null) {
            cancelDownload();
            this.mAdParameter = adParameter;
            this.mEventListener = eventListener;
            initViewIfNeeded(getContext());
            if (adParameter.isAnimationGif()) {
                this.mWebView.loadAnimationGif(adParameter.getImageUrl(), new C16451());
                return;
            }
            this.mTask = new DownloadTask(this);
            AsyncTaskHelper.execute(this.mTask, new Void[IMAGE_INDEX]);
        }
    }

    boolean hasAdImage() {
        if (isDeallocated()) {
            return false;
        }
        switch (getDisplayedChild()) {
            case IMAGE_INDEX /*0*/:
                if (this.mImageView.getDrawable() == null || !(this.mImageView.getDrawable() instanceof BitmapDrawable)) {
                    return false;
                }
                return true;
            case WEB_INDEX /*1*/:
                return this.mWebView.isLoaded();
            default:
                return false;
        }
    }

    void abort() {
        this.mEventListener = null;
        cancelDownload();
        deallocateAllViews();
    }

    private void initViewIfNeeded(Context context) {
        if (this.mImageView == null) {
            this.mImageView = new ImageView(context);
            this.mImageView.setScaleType(ScaleType.FIT_XY);
            addView(this.mImageView, new LayoutParams(MP, MP));
        }
        if (this.mWebView == null) {
            this.mWebView = new NendAdAnimationWebView(context);
            addView(this.mWebView, new LayoutParams(MP, MP));
        }
    }

    private void cancelDownload() {
        if (!(this.mTask == null || this.mTask.isCancelled())) {
            this.mTask.cancel(true);
        }
        if (this.mWebView != null) {
            this.mWebView.cancel();
        }
    }

    private void recycleBitmap() {
        if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
            this.mBitmap.recycle();
        }
        this.mBitmap = null;
        if (this.mImageView != null && this.mImageView.getDrawable() != null) {
            this.mImageView.getDrawable().setCallback(null);
            this.mImageView.setImageDrawable(null);
        }
    }

    private void deallocateAllViews() {
        removeAllViews();
        recycleBitmap();
        this.mImageView = null;
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
            this.mWebView.clearCache(true);
            this.mWebView.setWebViewClient(null);
            this.mWebView.setWebChromeClient(null);
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    private void onDownloadAdSuccessfully() {
        if (!isDeallocated()) {
            this.mClickUrl = this.mAdParameter.getClickUrl();
            this.mImageView.setOnClickListener(this);
            this.mWebView.setOnClickListener(this);
            notifySuccess();
        }
    }

    private void notifySuccess() {
        if (this.mEventListener != null) {
            this.mEventListener.onSuccess();
        }
    }

    private void notifyFailure() {
        if (this.mEventListener != null) {
            this.mEventListener.onFailure();
        }
    }

    private void notifyClick() {
        if (this.mEventListener != null) {
            this.mEventListener.onClickAd();
        }
    }

    private boolean isValidAdSize(int i, int i2) {
        if (this.mEventListener != null) {
            return this.mEventListener.onValidation(i, i2);
        }
        return false;
    }

    private boolean isDeallocated() {
        return this.mImageView == null || this.mWebView == null;
    }
}
