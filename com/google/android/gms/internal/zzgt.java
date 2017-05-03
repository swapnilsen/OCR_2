package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.zzac;
import java.util.List;

@zzme
public class zzgt extends RelativeLayout {
    private static final float[] zzGl;
    @Nullable
    private AnimationDrawable zzGm;

    static {
        zzGl = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    }

    public zzgt(Context context, zzgs com_google_android_gms_internal_zzgs, LayoutParams layoutParams) {
        super(context);
        zzac.zzw(com_google_android_gms_internal_zzgs);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzGl, null, null));
        shapeDrawable.getPaint().setColor(com_google_android_gms_internal_zzgs.getBackgroundColor());
        setLayoutParams(layoutParams);
        zzw.zzcO().zza((View) this, shapeDrawable);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzgs.getText())) {
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-2, -2);
            View textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(com_google_android_gms_internal_zzgs.getText());
            textView.setTextColor(com_google_android_gms_internal_zzgs.getTextColor());
            textView.setTextSize((float) com_google_android_gms_internal_zzgs.getTextSize());
            textView.setPadding(zzel.zzeT().zzb(context, 4), 0, zzel.zzeT().zzb(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        View imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<Drawable> zzfL = com_google_android_gms_internal_zzgs.zzfL();
        if (zzfL.size() > 1) {
            this.zzGm = new AnimationDrawable();
            for (Drawable shapeDrawable2 : zzfL) {
                this.zzGm.addFrame(shapeDrawable2, com_google_android_gms_internal_zzgs.zzfM());
            }
            zzw.zzcO().zza(imageView, this.zzGm);
        } else if (zzfL.size() == 1) {
            imageView.setImageDrawable((Drawable) zzfL.get(0));
        }
        addView(imageView);
    }

    public void onAttachedToWindow() {
        if (this.zzGm != null) {
            this.zzGm.start();
        }
        super.onAttachedToWindow();
    }
}
