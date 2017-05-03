package net.nend.android;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import net.nend.android.AdParameter.ViewType;
import net.nend.android.NendAdInterstitial.NendAdInterstitialStatusCode;
import org.json.JSONArray;
import org.json.JSONObject;

final class NendAdInterstitialResponseParser extends AbsNendAdResponseParser<NendAdInterstitialResponse> {
    private static /* synthetic */ int[] f5095xba5e9225;

    static /* synthetic */ int[] m5582xba5e9225() {
        int[] iArr = f5095xba5e9225;
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
            f5095xba5e9225 = iArr;
        }
        return iArr;
    }

    NendAdInterstitialResponseParser(Context context) {
        super(context);
    }

    NendAdInterstitialResponse getResponseObject(ResponseType responseType, JSONObject jSONObject) {
        switch (m5582xba5e9225()[responseType.ordinal()]) {
            case Type.WEBSITE /*7*/:
                return getNormalAd(jSONObject);
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
            case ConnectionResult.SERVICE_INVALID /*9*/:
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                return getAppTargetingAd(jSONObject);
            default:
                Builder builder = new Builder();
                builder.setViewType(ViewType.ADVIEW);
                builder.setErrorCode(NendAdInterstitialStatusCode.INVALID_RESPONSE_TYPE);
                return builder.build();
        }
    }

    private NendAdInterstitialResponse getNormalAd(JSONObject jSONObject) {
        Builder builder = new Builder();
        builder.setAdId(jSONObject.getJSONObject("ad").getJSONObject("default_ad").getString("ad_id"));
        if (!jSONObject.isNull("status_code")) {
            builder.setStatusCode(jSONObject.getInt("status_code"));
        }
        if (!jSONObject.isNull("message")) {
            builder.setMessage(jSONObject.getString("message"));
        }
        if (!jSONObject.isNull("impression_count_url")) {
            builder.setImpressionCountUrl(jSONObject.getString("impression_count_url"));
        }
        if (!jSONObject.isNull("request_url")) {
            builder.setRequestUrl(jSONObject.getString("request_url"));
        }
        if (!jSONObject.isNull("size")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("size");
            if (!(jSONObject2.isNull("portrait") || jSONObject2.isNull("landscape"))) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("portrait");
                jSONObject2 = jSONObject2.getJSONObject("landscape");
                if (!(jSONObject3 == null || jSONObject3.isNull("width") || jSONObject3.isNull("height"))) {
                    builder.setPortraitHeight(jSONObject3.getInt("height"));
                    builder.setPortraitWidth(jSONObject3.getInt("width"));
                }
                if (!(jSONObject2 == null || jSONObject2.isNull("width") || jSONObject2.isNull("height"))) {
                    builder.setLandscapeHeight(jSONObject2.getInt("height"));
                    builder.setLandscapeWidth(jSONObject2.getInt("width"));
                }
            }
        }
        if (!jSONObject.isNull("frequency")) {
            builder.setFrequency(jSONObject.getInt("frequency"));
        }
        builder.setViewType(ViewType.ADVIEW);
        return builder.build();
    }

    private NendAdInterstitialResponse getAppTargetingAd(JSONObject jSONObject) {
        Builder builder = new Builder();
        JSONObject jSONObject2 = jSONObject.getJSONObject("ad");
        JSONArray jSONArray = jSONObject2.getJSONArray("targeting_ads");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            JSONArray jSONArray2 = jSONObject3.getJSONArray("conditions");
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                if (isTarget(jSONArray2.getJSONArray(i2))) {
                    builder.setAdId(jSONObject3.getString("ad_id"));
                    if (!jSONObject.isNull("status_code")) {
                        builder.setStatusCode(jSONObject.getInt("status_code"));
                    }
                    if (!jSONObject.isNull("message")) {
                        builder.setMessage(jSONObject.getString("message"));
                    }
                    if (!jSONObject.isNull("impression_count_url")) {
                        builder.setImpressionCountUrl(jSONObject.getString("impression_count_url"));
                    }
                    if (!jSONObject.isNull("request_url")) {
                        builder.setRequestUrl(jSONObject.getString("request_url"));
                    }
                    if (!jSONObject.isNull("size")) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject("size");
                        if (!(jSONObject4.isNull("portrait") || jSONObject4.isNull("landscape"))) {
                            JSONObject jSONObject5 = jSONObject4.getJSONObject("portrait");
                            jSONObject4 = jSONObject4.getJSONObject("landscape");
                            if (!(jSONObject5 == null || jSONObject5.isNull("width") || jSONObject5.isNull("height"))) {
                                builder.setPortraitHeight(jSONObject5.getInt("height"));
                                builder.setPortraitWidth(jSONObject5.getInt("width"));
                            }
                            if (!(jSONObject4 == null || jSONObject4.isNull("width") || jSONObject4.isNull("height"))) {
                                builder.setLandscapeHeight(jSONObject4.getInt("height"));
                                builder.setLandscapeWidth(jSONObject4.getInt("width"));
                            }
                        }
                    }
                    if (!jSONObject.isNull("frequency")) {
                        builder.setFrequency(jSONObject.getInt("frequency"));
                    }
                    builder.setViewType(ViewType.ADVIEW);
                    return builder.build();
                }
            }
        }
        if (!jSONObject2.isNull("default_ad")) {
            return getNormalAd(jSONObject);
        }
        throw new NendException(NendStatus.ERR_OUT_OF_STOCK);
    }
}
