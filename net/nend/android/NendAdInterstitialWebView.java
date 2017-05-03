package net.nend.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import net.nend.android.NendAdInterstitial.NendAdInterstitialClickType;
import net.nend.android.NendHelper.AsyncTaskHelper;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

@SuppressLint({"InlinedApi"})
public class NendAdInterstitialWebView extends WebView implements Downloadable<String> {
    private OnAdClickListener mClickListener;
    private CompleationListener mListener;
    private String mRequestUrl;
    private WebViewStatus mStatusCode;

    interface CompleationListener {
        void onCompleation();

        void onError();
    }

    interface OnAdClickListener {
        void onClick(NendAdInterstitialClickType nendAdInterstitialClickType, String str);
    }

    /* renamed from: net.nend.android.NendAdInterstitialWebView.1 */
    class C16441 extends WebViewClient {
        C16441() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            NendAdInterstitialWebView.this.mStatusCode = WebViewStatus.SUCCESS;
            if (NendAdInterstitialWebView.this.mListener != null && NendAdInterstitialWebView.this.mStatusCode != WebViewStatus.FAILD) {
                NendAdInterstitialWebView.this.mListener.onCompleation();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            NendAdInterstitialWebView.this.mClickListener.onClick(NendAdInterstitialClickType.DOWNLOAD, str);
            return true;
        }
    }

    enum WebViewStatus {
        SUCCESS,
        FAILD,
        INCOMPLETE
    }

    public NendAdInterstitialWebView(Context context, LayoutParams layoutParams) {
        super(context);
        this.mStatusCode = WebViewStatus.INCOMPLETE;
        this.mRequestUrl = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        clearCache(false);
        setLayoutParams(layoutParams);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setRenderPriority(RenderPriority.HIGH);
        getSettings().setCacheMode(2);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        setWebViewClient(new C16441());
        setBackgroundColor(0);
        if (11 <= VERSION.SDK_INT) {
            setLayerType(1, null);
        }
    }

    public void load(String str) {
        this.mStatusCode = WebViewStatus.INCOMPLETE;
        this.mRequestUrl = str;
        AsyncTaskHelper.execute(new DownloadTask(this), new Void[0]);
    }

    public WebViewStatus getStatusCode() {
        return this.mStatusCode;
    }

    public void setOnCompleationListener(CompleationListener compleationListener) {
        this.mListener = compleationListener;
    }

    public void setOnAdClickListener(OnAdClickListener onAdClickListener) {
        this.mClickListener = onAdClickListener;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String makeResponse(HttpEntity httpEntity) {
        if (httpEntity == null) {
            return null;
        }
        String str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        try {
            return EntityUtils.toString(httpEntity, "UTF-8");
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        } catch (IOException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public void onDownload(String str) {
        if (str != null) {
            loadDataWithBaseURL("http://output.nend.net", str, "text/html", "UTF-8", null);
            return;
        }
        this.mStatusCode = WebViewStatus.FAILD;
        if (this.mListener != null) {
            this.mListener.onError();
        }
    }
}
