package net.nend.android;

import android.content.Context;
import android.os.AsyncTask;

class GetAdvertisingIdTask extends AsyncTask<Void, Void, String> {
    private final Context mContext;
    private final OnFinishListener mListener;

    interface OnFinishListener {
        void onFinish(String str);
    }

    GetAdvertisingIdTask(Context context, OnFinishListener onFinishListener) {
        this.mContext = context;
        this.mListener = onFinishListener;
    }

    protected String doInBackground(Void... voidArr) {
        return NendHelper.getAdvertisingId(this.mContext);
    }

    protected void onPostExecute(String str) {
        super.onPostExecute(str);
        if (this.mListener != null) {
            this.mListener.onFinish(str);
        }
    }
}
