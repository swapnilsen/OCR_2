package net.nend.android;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.View;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import net.nend.android.NendAdView.NendError;
import net.nend.android.NendHelper.AsyncTaskHelper;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class NendAdIconLoader implements Downloadable<NendAdIconResponse>, AdListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int MESSAGE_CODE = 719;
    private boolean isStarted;
    private NendAdIconRequest mAdRequest;
    private OnClickListner mClickListner;
    private Context mContext;
    private DownloadTask<NendAdIconResponse> mDownloadTask;
    private OnFailedListner mFailedListner;
    private Handler mHandler;
    private boolean mHasWindowForcus;
    private List<NendAdIconView> mIconViewList;
    private ImpressionCountTask mImpressionTask;
    private OnReceiveListner mReceiveListner;
    private int mReloadIntervalInSeconds;
    private boolean mReloadable;
    private int mSpotId;

    public interface OnClickListner {
        void onClick(NendAdIconView nendAdIconView);
    }

    public interface OnFailedListner {
        void onFailedToReceiveAd(NendIconError nendIconError);
    }

    public interface OnReceiveListner {
        void onReceiveAd(NendAdIconView nendAdIconView);
    }

    /* renamed from: net.nend.android.NendAdIconLoader.1 */
    class C16301 extends Handler {
        C16301() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (NendAdIconLoader.this.mIconViewList.size() > 0) {
                NendAdIconLoader.this.mAdRequest.setRequestCount(NendAdIconLoader.this.mIconViewList.size());
                NendAdIconLoader.this.mDownloadTask = new DownloadTask(NendAdIconLoader.this);
                AsyncTaskHelper.execute(NendAdIconLoader.this.mDownloadTask, new Void[0]);
                return;
            }
            NendLog.m5584d(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        }
    }

    static {
        $assertionsDisabled = !NendAdIconLoader.class.desiredAssertionStatus() ? true : $assertionsDisabled;
    }

    public NendAdIconLoader(Context context, int i, String str) {
        this.mReloadIntervalInSeconds = 60;
        this.isStarted = $assertionsDisabled;
        this.mReloadable = true;
        this.mContext = context;
        this.mSpotId = i;
        if (i <= 0) {
            throw new IllegalArgumentException(NendStatus.ERR_INVALID_SPOT_ID.getMsg("spot id : " + i));
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(NendStatus.ERR_INVALID_API_KEY.getMsg("api key : " + str));
        } else {
            NendHelper.setDebuggable(context);
            this.mIconViewList = new ArrayList();
            this.mHandler = new C16301();
            this.mAdRequest = new NendAdIconRequest(context, i, str);
        }
    }

    public void addIconView(NendAdIconView nendAdIconView) {
        if (nendAdIconView != null && this.mIconViewList.size() < 8 && !this.mIconViewList.contains(nendAdIconView)) {
            if (this.isStarted) {
                loadAd();
            }
            this.mReloadable = true;
            this.mIconViewList.add(nendAdIconView);
            nendAdIconView.setListner(this);
        }
    }

    public void removeIconView(NendAdIconView nendAdIconView) {
        if (nendAdIconView != null) {
            nendAdIconView.deallocate();
            this.mIconViewList.remove(nendAdIconView);
            if (this.mIconViewList.size() == 0) {
                pause();
            }
        }
    }

    public int getIconCount() {
        return this.mIconViewList.size();
    }

    public void loadAd() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        this.mHandler.removeMessages(MESSAGE_CODE);
        this.mHandler.sendEmptyMessage(MESSAGE_CODE);
        this.isStarted = true;
    }

    public void resume() {
        this.mReloadable = true;
        startLoading();
    }

    private void startLoading() {
        if (this.mReloadable && !this.mHandler.hasMessages(MESSAGE_CODE)) {
            this.mHandler.sendEmptyMessageDelayed(MESSAGE_CODE, (long) (this.mReloadIntervalInSeconds * PointerIconCompat.TYPE_DEFAULT));
        }
    }

    public void pause() {
        this.mReloadable = $assertionsDisabled;
        stopLoading();
    }

    private void stopLoading() {
        if (!(this.mDownloadTask == null || this.mDownloadTask.isCancelled())) {
            this.mDownloadTask.cancel(true);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MESSAGE_CODE);
        }
    }

    public void onDownload(NendAdIconResponse nendAdIconResponse) {
        if (nendAdIconResponse != null) {
            this.mReloadIntervalInSeconds = NendHelper.setReloadIntervalInSeconds(nendAdIconResponse.getReloadIntervalInSeconds());
            String impressionCountUrl = nendAdIconResponse.getImpressionCountUrl();
            ArrayList adParameterList = nendAdIconResponse.getAdParameterList();
            CharSequence charSequence = impressionCountUrl;
            for (int i = 0; i < this.mIconViewList.size(); i++) {
                if (adParameterList.size() > i) {
                    String stringBuilder;
                    AdParameter adParameter = (AdParameter) adParameterList.get(i);
                    if (TextUtils.isEmpty(charSequence)) {
                        CharSequence charSequence2 = charSequence;
                    } else {
                        stringBuilder = new StringBuilder(String.valueOf(charSequence)).append(String.format("&ic[]=%s", new Object[]{adParameter.getIconId()})).toString();
                    }
                    ((NendAdIconView) this.mIconViewList.get(i)).loadImage(adParameter, this.mSpotId);
                    charSequence = stringBuilder;
                }
            }
            this.mImpressionTask = new ImpressionCountTask();
            AsyncTaskHelper.execute(this.mImpressionTask, charSequence);
        } else {
            NendLog.m5584d("onFailedToImageDownload!");
            if (this.mFailedListner != null) {
                NendIconError nendIconError = new NendIconError();
                nendIconError.setLoader(this);
                nendIconError.setErrorType(0);
                nendIconError.setNendError(NendError.FAILED_AD_REQUEST);
                this.mFailedListner.onFailedToReceiveAd(nendIconError);
            }
        }
        if (this.mReloadable && !this.mHandler.hasMessages(MESSAGE_CODE)) {
            this.mHandler.sendEmptyMessageDelayed(MESSAGE_CODE, (long) (this.mReloadIntervalInSeconds * PointerIconCompat.TYPE_DEFAULT));
        }
    }

    public NendAdIconResponse makeResponse(HttpEntity httpEntity) {
        if (httpEntity != null) {
            try {
                return (NendAdIconResponse) new NendAdIconResponseParser(this.mContext, this.mIconViewList.size()).parseResponse(EntityUtils.toString(httpEntity));
            } catch (Throwable e) {
                if ($assertionsDisabled) {
                    NendLog.m5590d(NendStatus.ERR_HTTP_REQUEST, e);
                } else {
                    throw new AssertionError();
                }
            } catch (Throwable e2) {
                if ($assertionsDisabled) {
                    NendLog.m5590d(NendStatus.ERR_HTTP_REQUEST, e2);
                } else {
                    throw new AssertionError();
                }
            }
        }
        return null;
    }

    public String getRequestUrl() {
        return this.mAdRequest.getRequestUrl(NendHelper.makeUid(this.mContext));
    }

    public void setOnClickListner(OnClickListner onClickListner) {
        this.mClickListner = onClickListner;
    }

    public void onClick(View view) {
        if (this.mClickListner != null) {
            this.mClickListner.onClick((NendAdIconView) view);
        }
    }

    public void setOnReceiveLisner(OnReceiveListner onReceiveListner) {
        this.mReceiveListner = onReceiveListner;
    }

    public void onReceive(View view) {
        if (this.mReceiveListner != null) {
            this.mReceiveListner.onReceiveAd((NendAdIconView) view);
        }
    }

    public void setOnFailedListner(OnFailedListner onFailedListner) {
        this.mFailedListner = onFailedListner;
    }

    public void onFailedToReceive(NendIconError nendIconError) {
        if (this.mFailedListner != null) {
            this.mFailedListner.onFailedToReceiveAd(nendIconError);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            if (!this.mHasWindowForcus) {
                this.mHasWindowForcus = true;
                resume();
            }
        } else if (this.mHasWindowForcus) {
            this.mHasWindowForcus = $assertionsDisabled;
            pause();
        }
    }
}
