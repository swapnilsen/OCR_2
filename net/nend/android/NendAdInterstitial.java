package net.nend.android;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Locale;
import net.nend.android.NendHelper.AsyncTaskHelper;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class NendAdInterstitial {
    private static final int INVALID_SPOT_ID = Integer.MIN_VALUE;
    private static final String PREF_KEY = "count";
    private static RequestCallback sCallback;
    private static OnCompletionListener sCompletionListener;
    private static SparseArray<Delegate> sDelegates;
    private static int sLatestLoadSpotId;

    public interface OnCompletionListener {
        void onCompletion(NendAdInterstitialStatusCode nendAdInterstitialStatusCode);
    }

    public interface OnClickListener {
        void onClick(NendAdInterstitialClickType nendAdInterstitialClickType);
    }

    /* renamed from: net.nend.android.NendAdInterstitial.1 */
    class C16381 implements RequestCallback {
        C16381() {
        }

        public void onCallback(int i, NendAdInterstitialStatusCode nendAdInterstitialStatusCode) {
            if (NendAdInterstitial.sCompletionListener != null) {
                if (NendAdInterstitial.sCompletionListener instanceof OnCompletionListenerSpot) {
                    ((OnCompletionListenerSpot) NendAdInterstitial.sCompletionListener).onCompletion(nendAdInterstitialStatusCode, i);
                } else {
                    NendAdInterstitial.sCompletionListener.onCompletion(nendAdInterstitialStatusCode);
                }
            }
        }
    }

    /* renamed from: net.nend.android.NendAdInterstitial.2 */
    class C16392 implements android.content.DialogInterface.OnClickListener {
        private final /* synthetic */ Activity val$activity;

        C16392(Activity activity) {
            this.val$activity = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.val$activity.finish();
        }
    }

    /* renamed from: net.nend.android.NendAdInterstitial.3 */
    class C16403 implements android.content.DialogInterface.OnClickListener {
        C16403() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    private static class Delegate implements Downloadable<NendAdInterstitialResponse> {
        private String mAdId;
        private NendAdInterstitialRequest mAdRequest;
        private String mApiKey;
        private RequestCallback mCallback;
        private Context mContext;
        private int mFrequency;
        private String mImpressionCountUrl;
        private NendAdInterstitialView mInterstitialView;
        private boolean mIsLoadCompleted;
        private String mRequestUrl;
        private int mSpotId;

        private interface RequestCallback {
            void onCallback(int i, NendAdInterstitialStatusCode nendAdInterstitialStatusCode);
        }

        /* renamed from: net.nend.android.NendAdInterstitial.Delegate.1 */
        class C16411 implements OnClickListener {
            private static /* synthetic */ int[] f5094xa0548526;
            private final /* synthetic */ Activity val$activity;
            private final /* synthetic */ OnClickListener val$clickListener;

            C16411(OnClickListener onClickListener, Activity activity) {
                this.val$clickListener = onClickListener;
                this.val$activity = activity;
            }

            static /* synthetic */ int[] m5581xa0548526() {
                int[] iArr = f5094xa0548526;
                if (iArr == null) {
                    iArr = new int[NendAdInterstitialClickType.values().length];
                    try {
                        iArr[NendAdInterstitialClickType.CLOSE.ordinal()] = 2;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[NendAdInterstitialClickType.DOWNLOAD.ordinal()] = 1;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[NendAdInterstitialClickType.EXIT.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    f5094xa0548526 = iArr;
                }
                return iArr;
            }

            public void onClick(NendAdInterstitialClickType nendAdInterstitialClickType) {
                if (this.val$clickListener != null) {
                    if (this.val$clickListener instanceof OnClickListenerSpot) {
                        ((OnClickListenerSpot) this.val$clickListener).onClick(nendAdInterstitialClickType, Delegate.this.mSpotId);
                    } else {
                        this.val$clickListener.onClick(nendAdInterstitialClickType);
                    }
                }
                switch (C16411.m5581xa0548526()[nendAdInterstitialClickType.ordinal()]) {
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        Delegate.this.requestAd(this.val$activity.getApplicationContext());
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        this.val$activity.finish();
                    default:
                }
            }
        }

        /* renamed from: net.nend.android.NendAdInterstitial.Delegate.2 */
        class C16422 implements OnCompleationListener {
            C16422() {
            }

            public void onCompleation(NendAdInterstitialStatusCode nendAdInterstitialStatusCode) {
                Delegate.this.mCallback.onCallback(Delegate.this.mSpotId, nendAdInterstitialStatusCode);
                Delegate.this.mIsLoadCompleted = true;
            }
        }

        private Delegate(int i, String str, RequestCallback requestCallback) {
            this.mSpotId = NendAdInterstitial.INVALID_SPOT_ID;
            this.mApiKey = null;
            this.mIsLoadCompleted = false;
            this.mSpotId = i;
            this.mApiKey = str;
            this.mCallback = requestCallback;
        }

        private void requestAd(Context context) {
            if (NendAdInterstitial.INVALID_SPOT_ID != this.mSpotId && !TextUtils.isEmpty(this.mApiKey)) {
                this.mContext = context;
                this.mIsLoadCompleted = false;
                this.mAdRequest = new NendAdInterstitialRequest(context, this.mSpotId, this.mApiKey);
                AsyncTaskHelper.execute(new DownloadTask(this), new Void[0]);
            }
        }

        private NendAdInterstitialShowResult showAd(Activity activity, boolean z, OnClickListener onClickListener) {
            if (!this.mIsLoadCompleted) {
                requestAd(activity.getApplicationContext());
                if (z) {
                    NendAdInterstitial.showFinishDialog(activity);
                }
                return getStatus();
            } else if (!isAdStandby()) {
                loadWebView();
                if (z) {
                    NendAdInterstitial.showFinishDialog(activity);
                }
                return NendAdInterstitialShowResult.AD_DOWNLOAD_INCOMPLETE;
            } else if (!z && !isFrequency(activity.getApplicationContext())) {
                return NendAdInterstitialShowResult.AD_FREQUENCY_NOT_RECHABLE;
            } else {
                if (showAdInternal(activity, onClickListener, z)) {
                    impression();
                    return NendAdInterstitialShowResult.AD_SHOW_SUCCESS;
                }
                requestAd(activity.getApplicationContext());
                if (z) {
                    NendAdInterstitial.showFinishDialog(activity);
                }
                return NendAdInterstitialShowResult.AD_REQUEST_INCOMPLETE;
            }
        }

        private boolean showAdInternal(Activity activity, OnClickListener onClickListener, boolean z) {
            this.mInterstitialView.setOnClickListener(new C16411(onClickListener, activity));
            return this.mInterstitialView.show(activity, z);
        }

        private boolean dismissAd() {
            if (this.mInterstitialView == null || !this.mInterstitialView.dissmiss()) {
                return false;
            }
            requestAd(this.mInterstitialView.getContext());
            return true;
        }

        private void loadWebView() {
            if (this.mInterstitialView != null) {
                this.mInterstitialView.load(this.mRequestUrl + "&ad=" + this.mAdId + "&dn=");
            }
        }

        private boolean isAdShown() {
            return this.mInterstitialView != null && this.mInterstitialView.isShown();
        }

        private boolean isAdStandby() {
            return this.mInterstitialView != null && this.mInterstitialView.isStanby();
        }

        private NendAdInterstitialShowResult getStatus() {
            return this.mInterstitialView != null ? this.mInterstitialView.getStatus() : NendAdInterstitialShowResult.AD_LOAD_INCOMPLETE;
        }

        private boolean isFrequency(Context context) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Editor edit = defaultSharedPreferences.edit();
            String keyForFrequency = keyForFrequency(this.mSpotId);
            int i = defaultSharedPreferences.getInt(keyForFrequency, 0);
            if (i >= this.mFrequency) {
                edit.putInt(keyForFrequency, 0);
                edit.apply();
                return true;
            }
            edit.putInt(keyForFrequency, i + 1);
            edit.apply();
            return false;
        }

        private void impression() {
            AsyncTaskHelper.execute(new ImpressionCountTask(), this.mImpressionCountUrl + "&ad=" + this.mAdId);
        }

        private static String keyForFrequency(int i) {
            return String.format(Locale.US, "%s_%d", new Object[]{NendAdInterstitial.PREF_KEY, Integer.valueOf(i)});
        }

        public String getRequestUrl() {
            return this.mAdRequest != null ? this.mAdRequest.getRequestUrl(NendHelper.makeUid(this.mContext)) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }

        public NendAdInterstitialResponse makeResponse(HttpEntity httpEntity) {
            if (httpEntity != null) {
                try {
                    return (NendAdInterstitialResponse) new NendAdInterstitialResponseParser(this.mContext).parseResponse(EntityUtils.toString(httpEntity));
                } catch (Throwable e) {
                    NendLog.m5590d(NendStatus.ERR_HTTP_REQUEST, e);
                } catch (Throwable e2) {
                    NendLog.m5590d(NendStatus.ERR_HTTP_REQUEST, e2);
                }
            }
            return null;
        }

        public void onDownload(NendAdInterstitialResponse nendAdInterstitialResponse) {
            if (nendAdInterstitialResponse == null) {
                this.mCallback.onCallback(this.mSpotId, NendAdInterstitialStatusCode.FAILED_AD_REQUEST);
                this.mIsLoadCompleted = false;
            } else if (nendAdInterstitialResponse.getErrorCode() != null) {
                this.mCallback.onCallback(this.mSpotId, nendAdInterstitialResponse.getErrorCode());
                this.mIsLoadCompleted = false;
            } else {
                this.mImpressionCountUrl = nendAdInterstitialResponse.getImpressionCountUrl();
                this.mFrequency = nendAdInterstitialResponse.getFrequency();
                this.mRequestUrl = nendAdInterstitialResponse.getRequestUrl();
                this.mAdId = nendAdInterstitialResponse.getAdId();
                this.mInterstitialView = new NendAdInterstitialView(this.mContext, nendAdInterstitialResponse);
                this.mInterstitialView.setOnCompleationListener(new C16422());
                loadWebView();
            }
        }
    }

    public enum NendAdInterstitialClickType {
        DOWNLOAD,
        CLOSE,
        EXIT
    }

    public enum NendAdInterstitialShowResult {
        AD_SHOW_SUCCESS,
        AD_LOAD_INCOMPLETE,
        AD_REQUEST_INCOMPLETE,
        AD_DOWNLOAD_INCOMPLETE,
        AD_FREQUENCY_NOT_RECHABLE,
        AD_SHOW_ALREADY
    }

    public enum NendAdInterstitialStatusCode {
        SUCCESS,
        INVALID_RESPONSE_TYPE,
        FAILED_AD_REQUEST,
        FAILED_AD_INCOMPLETE,
        FAILED_AD_DOWNLOAD
    }

    public interface OnClickListenerSpot extends OnClickListener {
        void onClick(NendAdInterstitialClickType nendAdInterstitialClickType, int i);
    }

    public interface OnCompletionListenerSpot extends OnCompletionListener {
        void onCompletion(NendAdInterstitialStatusCode nendAdInterstitialStatusCode, int i);
    }

    static {
        sDelegates = new SparseArray();
        sLatestLoadSpotId = INVALID_SPOT_ID;
        sCallback = new C16381();
    }

    public static void loadAd(Context context, String str, int i) {
        Delegate delegate = (Delegate) sDelegates.get(i);
        if (delegate == null) {
            delegate = new Delegate(str, sCallback, null);
            sDelegates.put(i, delegate);
        }
        delegate.requestAd(context);
        sLatestLoadSpotId = i;
    }

    public static NendAdInterstitialShowResult showAd(Activity activity) {
        return showInterstitialAd(activity, sLatestLoadSpotId, null, false);
    }

    public static NendAdInterstitialShowResult showAd(Activity activity, OnClickListener onClickListener) {
        return showInterstitialAd(activity, sLatestLoadSpotId, onClickListener, false);
    }

    public static NendAdInterstitialShowResult showAd(Activity activity, int i) {
        return showInterstitialAd(activity, i, null, false);
    }

    public static NendAdInterstitialShowResult showAd(Activity activity, int i, OnClickListener onClickListener) {
        return showInterstitialAd(activity, i, onClickListener, false);
    }

    public static NendAdInterstitialShowResult showFinishAd(Activity activity) {
        return showInterstitialAd(activity, sLatestLoadSpotId, null, true);
    }

    public static NendAdInterstitialShowResult showFinishAd(Activity activity, OnClickListener onClickListener) {
        return showInterstitialAd(activity, sLatestLoadSpotId, onClickListener, true);
    }

    public static NendAdInterstitialShowResult showFinishAd(Activity activity, int i) {
        return showInterstitialAd(activity, i, null, true);
    }

    public static NendAdInterstitialShowResult showFinishAd(Activity activity, int i, OnClickListener onClickListener) {
        return showInterstitialAd(activity, i, onClickListener, true);
    }

    public static boolean dismissAd() {
        boolean z = false;
        for (int i = 0; i < sDelegates.size(); i++) {
            if (((Delegate) sDelegates.get(sDelegates.keyAt(i))).dismissAd()) {
                z = true;
            }
        }
        return z;
    }

    public static void setListener(OnCompletionListener onCompletionListener) {
        sCompletionListener = onCompletionListener;
    }

    private static NendAdInterstitialShowResult showInterstitialAd(Activity activity, int i, OnClickListener onClickListener, boolean z) {
        if (isAdShown()) {
            return NendAdInterstitialShowResult.AD_SHOW_ALREADY;
        }
        Delegate delegate = (Delegate) sDelegates.get(i);
        if (delegate != null) {
            return delegate.showAd(activity, z, onClickListener);
        }
        if (z) {
            showFinishDialog(activity);
        }
        return NendAdInterstitialShowResult.AD_LOAD_INCOMPLETE;
    }

    private static void showFinishDialog(Activity activity) {
        Builder builder = new Builder(activity);
        builder.setPositiveButton(activity.getString(17039370), new C16392(activity));
        builder.setNegativeButton(activity.getString(17039360), new C16403());
        if (Locale.JAPAN.equals(Locale.getDefault())) {
            builder.setMessage(DialogMessage.JA.getMessage());
        } else {
            builder.setMessage(DialogMessage.EN.getMessage());
        }
        builder.show();
    }

    private static boolean isAdShown() {
        for (int i = 0; i < sDelegates.size(); i++) {
            if (((Delegate) sDelegates.get(sDelegates.keyAt(i))).isAdShown()) {
                return true;
            }
        }
        return false;
    }
}
