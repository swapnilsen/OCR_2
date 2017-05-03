package net.nend.android;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.nend.android.NendHelper.MetaDataHelper;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

abstract class AbsNendAdRequest {
    protected final String mApiKey;
    private final Context mContext;
    protected final String mDomain;
    protected final String mPath;
    protected final String mProtocol;
    protected final int mSpotId;

    /* renamed from: net.nend.android.AbsNendAdRequest.1 */
    class C16231 implements Callable<String> {
        C16231() {
        }

        public String call() {
            return NendHelper.getAdvertisingId(AbsNendAdRequest.this.mContext);
        }
    }

    abstract String buildRequestUrl(String str);

    abstract String getDomain();

    abstract String getPath();

    AbsNendAdRequest(Context context, int i, String str) {
        if (context == null) {
            throw new NullPointerException("Context is null.");
        } else if (i <= 0) {
            throw new IllegalArgumentException("Spot id is invalid. spot id : " + i);
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Api key is invalid. api key : " + str);
        } else {
            this.mContext = context;
            this.mSpotId = i;
            this.mApiKey = str;
            this.mProtocol = MetaDataHelper.getStringValue(context, MetaData.ADSCHEME.getName(), "http");
            this.mDomain = MetaDataHelper.getStringValue(context, MetaData.ADAUTHORITY.getName(), getDomain());
            this.mPath = MetaDataHelper.getStringValue(context, MetaData.ADPATH.getName(), getPath());
        }
    }

    protected String getOS() {
        return AbstractSpiCall.ANDROID_CLIENT_TYPE;
    }

    protected String getSDKVersion() {
        return "2.5.3";
    }

    protected String getModel() {
        return Build.MODEL;
    }

    protected String getDevice() {
        return Build.DEVICE;
    }

    protected String getLocale() {
        return Locale.getDefault().toString();
    }

    protected String getVersion() {
        return VERSION.RELEASE;
    }

    String getRequestUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            return buildRequestUrl(str);
        }
        throw new IllegalArgumentException("UID is invalid. uid : " + str);
    }

    protected String getAdvertisingId() {
        String str;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            str = (String) newSingleThreadExecutor.submit(new C16231()).get();
            return str;
        } catch (ExecutionException e) {
            str = e;
            NendLog.m5615w("Failed to get the Advertising ID", (Throwable) str);
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        } catch (InterruptedException e2) {
            str = e2;
            NendLog.m5615w("Failed to get the Advertising ID", (Throwable) str);
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }
}
