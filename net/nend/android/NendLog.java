package net.nend.android;

import android.util.Log;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

final class NendLog {
    static final String TAG = "nend_SDK";

    private NendLog() {
    }

    private static boolean isLoggable(String str, int i) {
        switch (i) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                if (Log.isLoggable(str, i) && NendHelper.isDebuggable() && NendHelper.isDev()) {
                    return true;
                }
                return false;
            default:
                if (Log.isLoggable(str, i) && NendHelper.isDebuggable()) {
                    return true;
                }
                return false;
        }
    }

    private static int outputLog(int i, String str, String str2, Throwable th) {
        if (!isLoggable(str, i)) {
            return 0;
        }
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String str3 = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ":\n" + str2;
        if (th != null) {
            str3 = new StringBuilder(String.valueOf(str3)).append('\n').append(Log.getStackTraceString(th)).toString();
        }
        return Log.println(i, str, str3);
    }

    static int m5605v(String str) {
        return outputLog(2, TAG, str, null);
    }

    static int m5608v(String str, Throwable th) {
        return outputLog(2, TAG, str, th);
    }

    static int m5606v(String str, String str2) {
        return outputLog(2, str, str2, null);
    }

    static int m5607v(String str, String str2, Throwable th) {
        return outputLog(2, str, str2, th);
    }

    static int m5609v(NendStatus nendStatus) {
        return outputLog(2, TAG, nendStatus.getMsg(), null);
    }

    static int m5610v(NendStatus nendStatus, String str) {
        return outputLog(2, TAG, nendStatus.getMsg(str), null);
    }

    static int m5611v(NendStatus nendStatus, Throwable th) {
        return outputLog(2, TAG, nendStatus.getMsg(), th);
    }

    static int m5584d(String str) {
        return outputLog(3, TAG, str, null);
    }

    static int m5587d(String str, Throwable th) {
        return outputLog(3, TAG, str, th);
    }

    static int m5585d(String str, String str2) {
        return outputLog(3, str, str2, null);
    }

    static int m5586d(String str, String str2, Throwable th) {
        return outputLog(3, str, str2, th);
    }

    static int m5588d(NendStatus nendStatus) {
        return outputLog(3, TAG, nendStatus.getMsg(), null);
    }

    static int m5589d(NendStatus nendStatus, String str) {
        return outputLog(3, TAG, nendStatus.getMsg(str), null);
    }

    static int m5590d(NendStatus nendStatus, Throwable th) {
        return outputLog(3, TAG, nendStatus.getMsg(), th);
    }

    static int m5598i(String str) {
        return outputLog(4, TAG, str, null);
    }

    static int m5601i(String str, Throwable th) {
        return outputLog(4, TAG, str, th);
    }

    static int m5599i(String str, String str2) {
        return outputLog(4, str, str2, null);
    }

    static int m5600i(String str, String str2, Throwable th) {
        return outputLog(4, str, str2, th);
    }

    static int m5602i(NendStatus nendStatus) {
        return outputLog(4, TAG, nendStatus.getMsg(), null);
    }

    static int m5603i(NendStatus nendStatus, String str) {
        return outputLog(4, TAG, nendStatus.getMsg(str), null);
    }

    static int m5604i(NendStatus nendStatus, Throwable th) {
        return outputLog(4, TAG, nendStatus.getMsg(), th);
    }

    static int m5612w(String str) {
        return outputLog(5, TAG, str, null);
    }

    static int m5615w(String str, Throwable th) {
        return outputLog(5, TAG, str, th);
    }

    static int m5613w(String str, String str2) {
        return outputLog(5, str, str2, null);
    }

    static int m5614w(String str, String str2, Throwable th) {
        return outputLog(5, str, str2, th);
    }

    static int m5616w(NendStatus nendStatus) {
        return outputLog(5, TAG, nendStatus.getMsg(), null);
    }

    static int m5617w(NendStatus nendStatus, String str) {
        return outputLog(5, TAG, nendStatus.getMsg(str), null);
    }

    static int m5618w(NendStatus nendStatus, Throwable th) {
        return outputLog(5, TAG, nendStatus.getMsg(), th);
    }

    static int m5591e(String str) {
        return outputLog(6, TAG, str, null);
    }

    static int m5594e(String str, Throwable th) {
        return outputLog(6, TAG, str, th);
    }

    static int m5592e(String str, String str2) {
        return outputLog(6, str, str2, null);
    }

    static int m5593e(String str, String str2, Throwable th) {
        return outputLog(6, str, str2, th);
    }

    static int m5595e(NendStatus nendStatus) {
        return outputLog(6, TAG, nendStatus.getMsg(), null);
    }

    static int m5596e(NendStatus nendStatus, String str) {
        return outputLog(6, TAG, nendStatus.getMsg(str), null);
    }

    static int m5597e(NendStatus nendStatus, Throwable th) {
        return outputLog(6, TAG, nendStatus.getMsg(), th);
    }
}
