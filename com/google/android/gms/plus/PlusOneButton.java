package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzap;
import com.google.android.gms.plus.internal.zzg;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private String zzE;
    private View zzbBL;
    private int zzbBM;
    private int zzbBN;
    private OnPlusOneClickListener zzbBO;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzbBP;
        final /* synthetic */ PlusOneButton zzbBQ;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener onPlusOneClickListener) {
            this.zzbBQ = plusOneButton;
            this.zzbBP = onPlusOneClickListener;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.zzbBQ.zzbBL.getTag();
            if (this.zzbBP != null) {
                this.zzbBP.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.zzbBQ.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.zzbBQ.zzbBN);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = getSize(context, attributeSet);
        this.zzbBM = getAnnotation(context, attributeSet);
        this.zzbBN = DEFAULT_ACTIVITY_REQUEST_CODE;
        zzaO(getContext());
        if (!isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attributeSet) {
        String zza = zzap.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeSet, true, false, "PlusOneButton");
        return "INLINE".equalsIgnoreCase(zza) ? SIZE_TALL : !"NONE".equalsIgnoreCase(zza) ? SIZE_MEDIUM : SIZE_SMALL;
    }

    protected static int getSize(Context context, AttributeSet attributeSet) {
        String zza = zzap.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeSet, true, false, "PlusOneButton");
        return "SMALL".equalsIgnoreCase(zza) ? SIZE_SMALL : "MEDIUM".equalsIgnoreCase(zza) ? SIZE_MEDIUM : "TALL".equalsIgnoreCase(zza) ? SIZE_TALL : SIZE_STANDARD;
    }

    private void zzaO(Context context) {
        if (this.zzbBL != null) {
            removeView(this.zzbBL);
        }
        this.zzbBL = zzg.zza(context, this.mSize, this.zzbBM, this.zzE, this.zzbBN);
        setOnPlusOneClickListener(this.zzbBO);
        addView(this.zzbBL);
    }

    public void initialize(String str, int i) {
        zzac.zza(getContext() instanceof Activity, (Object) "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzE = str;
        this.zzbBN = i;
        zzaO(getContext());
    }

    public void initialize(String str, OnPlusOneClickListener onPlusOneClickListener) {
        this.zzE = str;
        this.zzbBN = SIZE_SMALL;
        zzaO(getContext());
        setOnPlusOneClickListener(onPlusOneClickListener);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.zzbBL.layout(SIZE_SMALL, SIZE_SMALL, i3 - i, i4 - i2);
    }

    protected void onMeasure(int i, int i2) {
        View view = this.zzbBL;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void plusOneClick() {
        this.zzbBL.performClick();
    }

    public void setAnnotation(int i) {
        this.zzbBM = i;
        zzaO(getContext());
    }

    public void setIntent(Intent intent) {
        this.zzbBL.setTag(intent);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.zzbBO = onPlusOneClickListener;
        this.zzbBL.setOnClickListener(new DefaultOnPlusOneClickListener(this, onPlusOneClickListener));
    }

    public void setSize(int i) {
        this.mSize = i;
        zzaO(getContext());
    }
}
