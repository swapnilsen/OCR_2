package net.nend.android;

import net.nend.android.NendAdView.NendError;

interface AdListener {
    void onFailedToReceiveAd(NendError nendError);

    void onReceiveAd();
}
