package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.R.R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public final class AspectRatioFrameLayout extends FrameLayout {
    private float f3975a;
    private int f3976b;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3976b = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.AspectRatioFrameLayout, 0, 0);
            try {
                this.f3976b = obtainStyledAttributes.getInt(R.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setAspectRatio(float f) {
        if (this.f3975a != f) {
            this.f3975a = f;
            requestLayout();
        }
    }

    public void setResizeMode(int i) {
        if (this.f3976b != i) {
            this.f3976b = i;
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3975a != 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f = (this.f3975a / (((float) measuredWidth) / ((float) measuredHeight))) - 1.0f;
            if (Math.abs(f) > 0.01f) {
                switch (this.f3976b) {
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        measuredHeight = (int) (((float) measuredWidth) / this.f3975a);
                        break;
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        measuredWidth = (int) (((float) measuredHeight) * this.f3975a);
                        break;
                    default:
                        if (f <= 0.0f) {
                            measuredWidth = (int) (((float) measuredHeight) * this.f3975a);
                            break;
                        } else {
                            measuredHeight = (int) (((float) measuredWidth) / this.f3975a);
                            break;
                        }
                }
                super.onMeasure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }
}
