package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzw;
import java.lang.ref.WeakReference;

@zzme
class zzqs extends zzqu implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> zzZs;

    public zzqs(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.zzZs = new WeakReference(onGlobalLayoutListener);
    }

    public void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.zzZs.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            detach();
        }
    }

    protected void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    protected void zzb(ViewTreeObserver viewTreeObserver) {
        zzw.zzcO().zza(viewTreeObserver, (OnGlobalLayoutListener) this);
    }
}
