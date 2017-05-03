package net.nend.android;

import android.os.AsyncTask;
import android.text.TextUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

final class ImpressionCountTask extends AsyncTask<String, Void, Void> {

    /* renamed from: net.nend.android.ImpressionCountTask.1 */
    class C16261 implements ResponseHandler<Void> {
        C16261() {
        }

        public Void handleResponse(HttpResponse httpResponse) {
            return null;
        }
    }

    ImpressionCountTask() {
    }

    protected Void doInBackground(String... strArr) {
        ClientConnectionManager clientConnectionManager = null;
        Thread.currentThread().setPriority(10);
        if (isCancelled()) {
            return null;
        }
        Object obj = strArr[0];
        if (TextUtils.isEmpty(obj)) {
            NendLog.m5616w(NendStatus.ERR_INVALID_URL);
            return clientConnectionManager;
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpParams params = defaultHttpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, AbstractSpiCall.DEFAULT_TIMEOUT);
            HttpConnectionParams.setSoTimeout(params, AbstractSpiCall.DEFAULT_TIMEOUT);
            NendLog.m5584d("start request!");
            Void voidR = (Void) defaultHttpClient.execute(new HttpGet(obj), new C16261());
            return voidR;
        } catch (Throwable e) {
            NendLog.m5618w(NendStatus.ERR_HTTP_REQUEST, e);
        } catch (Throwable e2) {
            NendLog.m5618w(NendStatus.ERR_HTTP_REQUEST, e2);
        } catch (Throwable e22) {
            NendLog.m5618w(NendStatus.ERR_HTTP_REQUEST, e22);
        } catch (Throwable e222) {
            NendLog.m5618w(NendStatus.ERR_HTTP_REQUEST, e222);
        } finally {
            clientConnectionManager = defaultHttpClient.getConnectionManager();
            clientConnectionManager.shutdown();
        }
    }

    protected void onPostExecute(Void voidR) {
    }
}
