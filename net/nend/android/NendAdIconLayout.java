package net.nend.android;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import net.nend.android.NendAdIconLoader.OnClickListner;
import net.nend.android.NendAdIconLoader.OnFailedListner;
import net.nend.android.NendAdIconLoader.OnReceiveListner;

public class NendAdIconLayout extends LinearLayout implements OnClickListner, OnFailedListner, OnReceiveListner {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private final int WC;
    private String mApiKey;
    private OnClickListner mClickListner;
    private OnFailedListner mFailedListner;
    private int mIconCount;
    private NendAdIconLoader mIconLoader;
    private boolean mIconSpaceEnabled;
    private OnReceiveListner mReceiveListner;
    private int mSpotId;
    private int mTitleColor;
    private boolean mTitleVisible;

    public NendAdIconLayout(Context context, int i, String str, int i2) {
        super(context);
        this.mIconCount = HORIZONTAL;
        this.mTitleVisible = true;
        this.mTitleColor = ViewCompat.MEASURED_STATE_MASK;
        this.mIconSpaceEnabled = true;
        this.WC = -2;
        this.mSpotId = i;
        this.mApiKey = str;
        this.mIconCount = i2;
    }

    public NendAdIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIconCount = HORIZONTAL;
        this.mTitleVisible = true;
        this.mTitleColor = ViewCompat.MEASURED_STATE_MASK;
        this.mIconSpaceEnabled = true;
        this.WC = -2;
        if (attributeSet == null) {
            throw new NullPointerException(NendStatus.ERR_INVALID_ATTRIBUTE_SET.getMsg());
        }
        String attributeValue = attributeSet.getAttributeValue(null, IconAttribute.ICON_COUNT.getName());
        if (attributeValue == null) {
            throw new NullPointerException(NendStatus.ERR_INVALID_ICON_COUNT.getMsg());
        }
        String attributeValue2 = attributeSet.getAttributeValue(null, IconAttribute.ICON_ORIENTATION.getName());
        if (attributeValue2 != null && "vertical".equals(attributeValue2)) {
            setOrientation(VERTICAL);
        }
        attributeValue2 = attributeSet.getAttributeValue(null, IconAttribute.TITLE_COLOR.getName());
        if (attributeValue2 != null) {
            try {
                this.mTitleColor = Color.parseColor(attributeValue2);
            } catch (Exception e) {
                this.mTitleColor = ViewCompat.MEASURED_STATE_MASK;
            }
        }
        this.mTitleVisible = attributeSet.getAttributeBooleanValue(null, IconAttribute.TITLE_VISIBLE.getName(), true);
        this.mIconSpaceEnabled = attributeSet.getAttributeBooleanValue(null, IconAttribute.ICON_SPACE.getName(), true);
        this.mIconCount = Integer.parseInt(attributeValue);
        this.mSpotId = Integer.parseInt(attributeSet.getAttributeValue(null, Attribute.SPOT_ID.getName()));
        this.mApiKey = attributeSet.getAttributeValue(null, Attribute.API_KEY.getName());
        loadAd();
    }

    public void loadAd() {
        this.mIconLoader = new NendAdIconLoader(getContext(), this.mSpotId, this.mApiKey);
        int i = HORIZONTAL;
        while (i < this.mIconCount && i <= 7) {
            View nendAdIconView = new NendAdIconView(getContext());
            nendAdIconView.setTitleColor(this.mTitleColor);
            nendAdIconView.setTitleVisible(this.mTitleVisible);
            nendAdIconView.setIconSpaceEnabled(this.mIconSpaceEnabled);
            this.mIconLoader.addIconView(nendAdIconView);
            addView(nendAdIconView, new LayoutParams(-2, -2));
            i += VERTICAL;
        }
        this.mIconLoader.loadAd();
        this.mIconLoader.setOnClickListner(this);
        this.mIconLoader.setOnFailedListner(this);
        this.mIconLoader.setOnReceiveLisner(this);
    }

    public void resume() {
        this.mIconLoader.resume();
    }

    public void pause() {
        this.mIconLoader.pause();
    }

    public void setIconOrientation(int i) {
        setOrientation(i);
    }

    public void setTitleColor(int i) {
        this.mTitleColor = i;
    }

    public void setTitleVisible(boolean z) {
        this.mTitleVisible = z;
    }

    public void setIconSpaceEnabled(boolean z) {
        this.mIconSpaceEnabled = z;
    }

    public void onReceiveAd(NendAdIconView nendAdIconView) {
        if (this.mReceiveListner != null) {
            this.mReceiveListner.onReceiveAd(nendAdIconView);
        }
    }

    public void setOnReceiveLisner(OnReceiveListner onReceiveListner) {
        this.mReceiveListner = onReceiveListner;
    }

    public void onFailedToReceiveAd(NendIconError nendIconError) {
        if (this.mFailedListner != null) {
            this.mFailedListner.onFailedToReceiveAd(nendIconError);
        }
    }

    public void setOnFailedListner(OnFailedListner onFailedListner) {
        this.mFailedListner = onFailedListner;
    }

    public void onClick(NendAdIconView nendAdIconView) {
        if (this.mClickListner != null) {
            this.mClickListner.onClick(nendAdIconView);
        }
    }

    public void setOnClickListner(OnClickListner onClickListner) {
        this.mClickListner = onClickListner;
    }
}
