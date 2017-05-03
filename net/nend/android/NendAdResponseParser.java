package net.nend.android;

import android.content.Context;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.AdParameter.ViewType;
import org.json.JSONArray;
import org.json.JSONObject;

final class NendAdResponseParser extends AbsNendAdResponseParser<AdParameter> {
    private static /* synthetic */ int[] f5096xba5e9225;

    static /* synthetic */ int[] m5583xba5e9225() {
        int[] iArr = f5096xba5e9225;
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
            f5096xba5e9225 = iArr;
        }
        return iArr;
    }

    public NendAdResponseParser(Context context) {
        super(context);
    }

    AdParameter getResponseObject(ResponseType responseType, JSONObject jSONObject) {
        switch (m5583xba5e9225()[responseType.ordinal()]) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return getNormalAd(jSONObject);
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return getWebViewAd(jSONObject);
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return getAppTargetingAd(jSONObject);
            default:
                throw new NendException(NendStatus.ERR_INVALID_RESPONSE_TYPE);
        }
    }

    private AdParameter getNormalAd(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("default_ad");
        Builder width = new Builder().setViewType(ViewType.ADVIEW).setImageUrl(jSONObject2.getString("image_url")).setClickUrl(jSONObject2.getString("click_url")).setHeight(jSONObject.getInt("height")).setWidth(jSONObject.getInt("width"));
        if (!jSONObject2.isNull("animation_gif_flg")) {
            width.setAnimationGifFlag(jSONObject2.getString("animation_gif_flg"));
        }
        if (!jSONObject.isNull("reload")) {
            width.setReloadIntervalInSeconds(jSONObject.getInt("reload"));
        }
        return width.build();
    }

    private AdParameter getWebViewAd(JSONObject jSONObject) {
        return new Builder().setViewType(ViewType.WEBVIEW).setWebViewUrl(jSONObject.getString("web_view_url")).setHeight(jSONObject.getInt("height")).setWidth(jSONObject.getInt("width")).build();
    }

    private AdParameter getAppTargetingAd(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("targeting_ads");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            JSONArray jSONArray2 = jSONObject2.getJSONArray("conditions");
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                if (isTarget(jSONArray2.getJSONArray(i2))) {
                    Builder animationGifFlag = new Builder().setViewType(ViewType.ADVIEW).setImageUrl(jSONObject2.getString("image_url")).setClickUrl(jSONObject2.getString("click_url")).setHeight(jSONObject.getInt("height")).setWidth(jSONObject.getInt("width")).setAnimationGifFlag(jSONObject2.getString("animation_gif_flg"));
                    if (!jSONObject.isNull("reload")) {
                        animationGifFlag.setReloadIntervalInSeconds(jSONObject.getInt("reload"));
                    }
                    return animationGifFlag.build();
                }
            }
        }
        if (!jSONObject.isNull("default_ad")) {
            return getNormalAd(jSONObject);
        }
        throw new NendException(NendStatus.ERR_OUT_OF_STOCK);
    }
}
