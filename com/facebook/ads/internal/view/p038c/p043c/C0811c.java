package com.facebook.ads.internal.view.p038c.p043c;

import android.net.Uri;
import android.view.View;

/* renamed from: com.facebook.ads.internal.view.c.c.c */
public interface C0811c {
    void m2467a(boolean z);

    void m2468c();

    void m2469d();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    C0816d getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void pause();

    void seekTo(int i);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z);

    void setRequestedVolume(float f);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(C0817e c0817e);

    void setup(Uri uri);

    void start();
}
