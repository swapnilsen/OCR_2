package net.nend.android;

import android.content.Context;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import java.util.ArrayList;
import net.nend.android.AdParameter.ViewType;
import org.json.JSONArray;
import org.json.JSONObject;

final class NendAdIconResponseParser extends AbsNendAdResponseParser<NendAdIconResponse> {
    private static /* synthetic */ int[] f5093xba5e9225;
    private final int mIconViewCount;

    static /* synthetic */ int[] m5580xba5e9225() {
        int[] iArr = f5093xba5e9225;
        if (iArr == null) {
            iArr = new int[ResponseType.values().length];
            try {
                iArr[ResponseType.BANNER_APP_TARGETING.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ResponseType.BANNER_NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ResponseType.BANNER_WEB_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ResponseType.ICON_APP_TARGETING.ordinal()] = 6;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ResponseType.ICON_NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ResponseType.INTERSTITIAL_APP_TARGETING.ordinal()] = 8;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ResponseType.INTERSTITIAL_APP_TARGETING_ICON.ordinal()] = 9;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ResponseType.INTERSTITIAL_APP_TARGETING_RECT.ordinal()] = 10;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ResponseType.INTERSTITIAL_NORMAL.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[ResponseType.UNSUPPORTED.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            f5093xba5e9225 = iArr;
        }
        return iArr;
    }

    NendAdIconResponseParser(Context context, int i) {
        super(context);
        this.mIconViewCount = i;
    }

    NendAdIconResponse getResponseObject(ResponseType responseType, JSONObject jSONObject) {
        switch (m5580xba5e9225()[responseType.ordinal()]) {
            case Type.OTHER_PROFILE /*5*/:
                return getNormalAd(jSONObject);
            case Type.CONTRIBUTOR /*6*/:
                return getAppTargetingAd(jSONObject);
            default:
                throw new NendException(NendStatus.ERR_INVALID_RESPONSE_TYPE);
        }
    }

    private NendAdIconResponse getNormalAd(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        Builder builder = new Builder();
        JSONArray jSONArray = jSONObject.getJSONArray("default_ads");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Builder animationGifFlag = new Builder().setViewType(ViewType.ADVIEW).setIconId(jSONObject2.getString("icon_id")).setImageUrl(jSONObject2.getString("image_url")).setClickUrl(jSONObject2.getString("click_url")).setAnimationGifFlag(jSONObject2.getString("animation_gif_flg"));
            if (!jSONObject2.isNull("icon_text")) {
                animationGifFlag.setTitleText(jSONObject2.getString("icon_text"));
            }
            arrayList.add(animationGifFlag.build());
            if (arrayList.size() >= this.mIconViewCount) {
                break;
            }
        }
        if (arrayList.size() == 0) {
            throw new NendException(NendStatus.ERR_OUT_OF_STOCK);
        }
        builder.setAdParameterList(arrayList);
        if (!jSONObject.isNull("status_code")) {
            builder.setStatusCode(jSONObject.getInt("status_code"));
        }
        if (!jSONObject.isNull("message")) {
            builder.setMessage(jSONObject.getString("message"));
        }
        if (!jSONObject.isNull("reload")) {
            builder.setReloadIntervalInSeconds(jSONObject.getInt("reload"));
        }
        if (!jSONObject.isNull("impression_count_url")) {
            builder.setImpressionCountUrl(jSONObject.getString("impression_count_url"));
        }
        builder.setViewType(ViewType.ADVIEW);
        return builder.build();
    }

    private NendAdIconResponse getAppTargetingAd(JSONObject jSONObject) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        Builder builder = new Builder();
        JSONArray jSONArray = jSONObject.getJSONArray("targeting_ads");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            JSONArray jSONArray2 = jSONObject2.getJSONArray("conditions");
            int length2 = jSONArray2.length();
            int i3 = 0;
            while (i3 < length2) {
                if (isTarget(jSONArray2.getJSONArray(i3))) {
                    Builder animationGifFlag = new Builder().setViewType(ViewType.ADVIEW).setIconId(jSONObject2.getString("icon_id")).setImageUrl(jSONObject2.getString("image_url")).setClickUrl(jSONObject2.getString("click_url")).setAnimationGifFlag(jSONObject2.getString("animation_gif_flg"));
                    if (!jSONObject2.isNull("icon_text")) {
                        animationGifFlag.setTitleText(jSONObject2.getString("icon_text"));
                    }
                    arrayList.add(animationGifFlag.build());
                    if (arrayList.size() < this.mIconViewCount) {
                        break;
                    }
                } else {
                    i3++;
                }
            }
            if (arrayList.size() < this.mIconViewCount) {
                break;
            }
        }
        if (arrayList.size() < this.mIconViewCount && !jSONObject.isNull("default_ads")) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("default_ads");
            while (i < jSONArray3.length()) {
                JSONObject jSONObject3 = jSONArray3.getJSONObject(i);
                Builder animationGifFlag2 = new Builder().setViewType(ViewType.ADVIEW).setIconId(jSONObject3.getString("icon_id")).setImageUrl(jSONObject3.getString("image_url")).setClickUrl(jSONObject3.getString("click_url")).setAnimationGifFlag(jSONObject3.getString("animation_gif_flg"));
                if (!jSONObject3.isNull("icon_text")) {
                    animationGifFlag2.setTitleText(jSONObject3.getString("icon_text"));
                }
                arrayList.add(animationGifFlag2.build());
                if (arrayList.size() >= this.mIconViewCount) {
                    break;
                }
                i++;
            }
        }
        if (arrayList.size() == 0) {
            throw new NendException(NendStatus.ERR_OUT_OF_STOCK);
        }
        builder.setAdParameterList(arrayList);
        if (!jSONObject.isNull("status_code")) {
            builder.setStatusCode(jSONObject.getInt("status_code"));
        }
        if (!jSONObject.isNull("message")) {
            builder.setMessage(jSONObject.getString("message"));
        }
        if (!jSONObject.isNull("reload")) {
            builder.setReloadIntervalInSeconds(jSONObject.getInt("reload"));
        }
        if (!jSONObject.isNull("impression_count_url")) {
            builder.setImpressionCountUrl(jSONObject.getString("impression_count_url"));
        }
        builder.setViewType(ViewType.ADVIEW);
        return builder.build();
    }
}
