package net.nend.android;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.ref.WeakReference;
import net.nend.android.AdParameter.ViewType;
import net.nend.android.NendAdView.NendError;
import net.nend.android.NendHelper.AsyncTaskHelper;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

final class NendAd implements Ad, Downloadable<AdParameter> {
    private static /* synthetic */ int[] $SWITCH_TABLE$net$nend$android$AdParameter$ViewType;
    static final /* synthetic */ boolean $assertionsDisabled;
    private String mAdId;
    private String mClickUrl;
    private final Context mContext;
    private int mHeight;
    private String mIconId;
    private String mImageUrl;
    private boolean mIsAnimationGif;
    private WeakReference<AdListener> mListenerReference;
    private DisplayMetrics mMetrics;
    private int mReloadIntervalInSeconds;
    private final NendAdRequest mRequest;
    private DownloadTask<AdParameter> mTask;
    private String mTitleText;
    private final String mUid;
    private ViewType mViewType;
    private String mWebViewUrl;
    private int mWidth;

    static /* synthetic */ int[] $SWITCH_TABLE$net$nend$android$AdParameter$ViewType() {
        int[] iArr = $SWITCH_TABLE$net$nend$android$AdParameter$ViewType;
        if (iArr == null) {
            iArr = new int[ViewType.values().length];
            try {
                iArr[ViewType.ADVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ViewType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ViewType.WEBVIEW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$net$nend$android$AdParameter$ViewType = iArr;
        }
        return iArr;
    }

    static {
        $assertionsDisabled = !NendAd.class.desiredAssertionStatus();
    }

    NendAd(Context context, int i, String str, DisplayMetrics displayMetrics) {
        this.mViewType = ViewType.NONE;
        this.mImageUrl = null;
        this.mClickUrl = null;
        this.mWebViewUrl = null;
        this.mTitleText = null;
        this.mWidth = 320;
        this.mHeight = 50;
        this.mReloadIntervalInSeconds = 60;
        this.mListenerReference = null;
        this.mTask = null;
        if (context == null) {
            throw new NullPointerException("Context is null.");
        } else if (i <= 0) {
            throw new IllegalArgumentException("Spot id is invalid. spot id : " + i);
        } else if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Api key is invalid. api key : " + str);
        } else {
            this.mContext = context;
            this.mMetrics = displayMetrics;
            this.mRequest = new NendAdRequest(context, i, str);
            this.mUid = NendHelper.makeUid(context);
        }
    }

    public ViewType getViewType() {
        return this.mViewType;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getClickUrl() {
        return this.mClickUrl;
    }

    public String getWebViewUrl() {
        return this.mWebViewUrl;
    }

    public String getTitleText() {
        return this.mTitleText;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getReloadIntervalInSeconds() {
        return this.mReloadIntervalInSeconds;
    }

    public String getIconId() {
        return this.mIconId;
    }

    public String getAdId() {
        return this.mAdId;
    }

    public boolean isAnimationGif() {
        return this.mIsAnimationGif;
    }

    public String getUid() {
        return this.mUid;
    }

    public boolean isRequestable() {
        return this.mTask == null || this.mTask.isFinished();
    }

    public boolean requestAd() {
        if (!isRequestable()) {
            return false;
        }
        this.mTask = new DownloadTask(this);
        AsyncTaskHelper.execute(this.mTask, new Void[0]);
        return true;
    }

    public void cancelRequest() {
        if (this.mTask != null) {
            this.mTask.cancel(true);
        }
    }

    public void setListener(AdListener adListener) {
        this.mListenerReference = new WeakReference(adListener);
    }

    public AdListener getListener() {
        if (this.mListenerReference != null) {
            return (AdListener) this.mListenerReference.get();
        }
        return null;
    }

    public void removeListener() {
        this.mListenerReference = null;
    }

    public String getRequestUrl() {
        return this.mRequest.getRequestUrl(this.mUid);
    }

    public AdParameter makeResponse(HttpEntity httpEntity) {
        if (httpEntity == null) {
            return null;
        }
        try {
            return (AdParameter) new NendAdResponseParser(this.mContext).parseResponse(EntityUtils.toString(httpEntity));
        } catch (Throwable e) {
            if ($assertionsDisabled) {
                NendLog.m5590d(NendStatus.ERR_HTTP_REQUEST, e);
                return null;
            }
            throw new AssertionError();
        } catch (Throwable e2) {
            if ($assertionsDisabled) {
                NendLog.m5590d(NendStatus.ERR_HTTP_REQUEST, e2);
                return null;
            }
            throw new AssertionError();
        }
    }

    public void onDownload(AdParameter adParameter) {
        Object obj = 1;
        AdListener listener = getListener();
        if (adParameter != null) {
            float f = this.mMetrics.density;
            float width = ((float) adParameter.getWidth()) * f;
            f *= (float) adParameter.getHeight();
            if (width / 2.0f > ((float) this.mMetrics.widthPixels) || f / 2.0f > ((float) this.mMetrics.heightPixels) || width > ((float) this.mMetrics.widthPixels) || f > ((float) this.mMetrics.heightPixels)) {
                obj = null;
                if (listener != null) {
                    listener.onFailedToReceiveAd(NendError.AD_SIZE_TOO_LARGE);
                }
            }
            switch ($SWITCH_TABLE$net$nend$android$AdParameter$ViewType()[adParameter.getViewType().ordinal()]) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    setAdViewParam(adParameter);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    setWebViewParam(adParameter);
                    break;
                default:
                    if (!$assertionsDisabled) {
                        throw new AssertionError();
                    } else if (listener != null) {
                        listener.onFailedToReceiveAd(NendError.INVALID_RESPONSE_TYPE);
                        return;
                    } else {
                        return;
                    }
            }
            if (listener != null && r0 != null) {
                listener.onReceiveAd();
            }
        } else if (listener != null) {
            listener.onFailedToReceiveAd(NendError.FAILED_AD_REQUEST);
        }
    }

    private void setAdViewParam(AdParameter adParameter) {
        if ($assertionsDisabled || adParameter != null) {
            this.mViewType = ViewType.ADVIEW;
            this.mReloadIntervalInSeconds = NendHelper.setReloadIntervalInSeconds(adParameter.getReloadIntervalInSeconds());
            this.mImageUrl = adParameter.getImageUrl();
            this.mClickUrl = adParameter.getClickUrl();
            this.mTitleText = adParameter.getTitleText();
            this.mHeight = adParameter.getHeight();
            this.mWidth = adParameter.getWidth();
            this.mIconId = adParameter.getIconId();
            this.mAdId = adParameter.getAdId();
            this.mIsAnimationGif = adParameter.isAnimationGif();
            this.mWebViewUrl = null;
            return;
        }
        throw new AssertionError();
    }

    private void setWebViewParam(AdParameter adParameter) {
        if ($assertionsDisabled || adParameter != null) {
            this.mViewType = ViewType.WEBVIEW;
            this.mWebViewUrl = adParameter.getWebViewUrl();
            this.mImageUrl = null;
            this.mClickUrl = null;
            this.mTitleText = null;
            this.mIconId = null;
            this.mAdId = null;
            this.mIsAnimationGif = adParameter.isAnimationGif();
            this.mHeight = adParameter.getHeight();
            this.mWidth = adParameter.getWidth();
            return;
        }
        throw new AssertionError();
    }
}
