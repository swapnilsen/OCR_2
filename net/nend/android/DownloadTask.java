package net.nend.android;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.api.client.http.HttpStatusCodes;
import java.lang.ref.WeakReference;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

final class DownloadTask<T> extends AsyncTask<Void, Void, T> {
    private final WeakReference<Downloadable<T>> mReference;

    /* renamed from: net.nend.android.DownloadTask.1 */
    class C16241 implements ResponseHandler<T> {
        private final /* synthetic */ String val$requestUrl;

        C16241(String str) {
            this.val$requestUrl = str;
        }

        public T handleResponse(HttpResponse httpResponse) {
            NendLog.m5584d("get response!");
            if (!DownloadTask.this.isCancelled() && httpResponse.getStatusLine().getStatusCode() == HttpStatusCodes.STATUS_CODE_OK) {
                Downloadable downloadable = (Downloadable) DownloadTask.this.mReference.get();
                if (downloadable != null) {
                    return downloadable.makeResponse(httpResponse.getEntity());
                }
            }
            if (!DownloadTask.this.isCancelled()) {
                NendLog.m5617w(NendStatus.ERR_HTTP_REQUEST, "http status : " + httpResponse.getStatusLine().getStatusCode());
            }
            return null;
        }
    }

    /* renamed from: net.nend.android.DownloadTask.2 */
    class C16252 implements Runnable {
        private final /* synthetic */ Downloadable val$downloadable;
        private final /* synthetic */ Object val$response;

        C16252(Downloadable downloadable, Object obj) {
            this.val$downloadable = downloadable;
            this.val$response = obj;
        }

        public void run() {
            this.val$downloadable.onDownload(this.val$response);
        }
    }

    interface Downloadable<T> {
        String getRequestUrl();

        T makeResponse(HttpEntity httpEntity);

        void onDownload(T t);
    }

    DownloadTask(Downloadable<T> downloadable) {
        this.mReference = new WeakReference(downloadable);
    }

    protected T doInBackground(Void... voidArr) {
        T t = null;
        Thread.currentThread().setPriority(10);
        if (isCancelled()) {
            return null;
        }
        Downloadable downloadable = (Downloadable) this.mReference.get();
        if (downloadable != null) {
            String requestUrl = downloadable.getRequestUrl();
            NendLog.m5605v("Download from " + requestUrl);
            if (TextUtils.isEmpty(requestUrl)) {
                NendLog.m5616w(NendStatus.ERR_INVALID_URL);
                return null;
            }
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            try {
                HttpParams params = defaultHttpClient.getParams();
                HttpConnectionParams.setConnectionTimeout(params, AbstractSpiCall.DEFAULT_TIMEOUT);
                HttpConnectionParams.setSoTimeout(params, AbstractSpiCall.DEFAULT_TIMEOUT);
                NendLog.m5584d("start request!");
                T execute = defaultHttpClient.execute(new HttpGet(requestUrl), new C16241(requestUrl));
                return execute;
            } catch (Throwable e) {
                NendLog.m5618w(NendStatus.ERR_HTTP_REQUEST, e);
            } catch (Throwable e2) {
                NendLog.m5618w(NendStatus.ERR_HTTP_REQUEST, e2);
            } catch (Throwable e22) {
                NendLog.m5618w(NendStatus.ERR_HTTP_REQUEST, e22);
            } catch (Throwable e222) {
                NendLog.m5618w(NendStatus.ERR_HTTP_REQUEST, e222);
            } finally {
                t = defaultHttpClient.getConnectionManager();
                t.shutdown();
            }
        } else {
            NendLog.m5616w(NendStatus.ERR_UNEXPECTED);
            return t;
        }
    }

    protected void onPostExecute(T t) {
        Downloadable downloadable = (Downloadable) this.mReference.get();
        if (!isCancelled() && downloadable != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new C16252(downloadable, t));
            } else {
                downloadable.onDownload(t);
            }
        }
    }

    boolean isFinished() {
        return getStatus() == Status.FINISHED;
    }
}
