package net.nend.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.SparseArray;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;

abstract class AbsNendAdResponseParser<T> {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected static final String RESPONSE_ENCODING = "UTF-8";
    private final PackageManager mPackageManager;

    protected static final class JsonParam {
        protected static final String AD = "ad";
        protected static final String AD_ID = "ad_id";
        protected static final String ANIMATION_GIF = "animation_gif_flg";
        protected static final String CLICK_URL = "click_url";
        protected static final String CONDITIONS = "conditions";
        protected static final String DEFAULT_AD = "default_ad";
        protected static final String DEFAULT_ADS = "default_ads";
        protected static final String FREQUENCY = "frequency";
        protected static final String HEIGHT = "height";
        protected static final String ICON_ADS = "icon_ads";
        protected static final String ICON_ID = "icon_id";
        protected static final String IMAGE_URL = "image_url";
        protected static final String IMPRESSHON_COUNT_URL = "impression_count_url";
        protected static final String LANDSCAPE = "landscape";
        protected static final String LOGICAL_OPERATOR = "logical_operator";
        protected static final String MESSAGE = "message";
        protected static final String PACKAGE_NAME = "url_scheme";
        protected static final String PORTRAIT = "portrait";
        protected static final String RELOAD = "reload";
        protected static final String REQUEST_URL = "request_url";
        protected static final String RESPONSE_TYPE = "response_type";
        protected static final String SIZE = "size";
        protected static final String STATUS_CODE = "status_code";
        protected static final String TARGETING_ADS = "targeting_ads";
        protected static final String TITLE_TEXT = "icon_text";
        protected static final String WEB_VIEW_URL = "web_view_url";
        protected static final String WIDTH = "width";

        private JsonParam() {
        }
    }

    protected enum ResponseType {
        UNSUPPORTED(0),
        BANNER_NORMAL(1),
        BANNER_WEB_VIEW(2),
        BANNER_APP_TARGETING(3),
        ICON_NORMAL(11),
        ICON_APP_TARGETING(13),
        INTERSTITIAL_NORMAL(21),
        INTERSTITIAL_APP_TARGETING(23),
        INTERSTITIAL_APP_TARGETING_ICON(24),
        INTERSTITIAL_APP_TARGETING_RECT(25);
        
        private static final SparseArray<ResponseType> intToEnum;
        private int type;

        static {
            intToEnum = new SparseArray();
            ResponseType[] values = values();
            int length = values.length;
            int i;
            while (i < length) {
                ResponseType responseType = values[i];
                intToEnum.put(responseType.type, responseType);
                i++;
            }
        }

        private ResponseType(int i) {
            this.type = i;
        }

        protected static ResponseType valueOf(int i) {
            return (ResponseType) intToEnum.get(i, UNSUPPORTED);
        }
    }

    abstract T getResponseObject(ResponseType responseType, JSONObject jSONObject);

    static {
        $assertionsDisabled = !AbsNendAdResponseParser.class.desiredAssertionStatus() ? true : $assertionsDisabled;
    }

    public AbsNendAdResponseParser(Context context) {
        if (context == null) {
            throw new NullPointerException(NendStatus.ERR_INVALID_CONTEXT.getMsg());
        }
        this.mPackageManager = context.getPackageManager();
    }

    T parseResponse(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    JSONObject jSONObject = new JSONObject(URLDecoder.decode(str, RESPONSE_ENCODING));
                    if (jSONObject.getInt("status_code") == NendStatus.SUCCESS.getCode()) {
                        return getResponseObject(ResponseType.valueOf(jSONObject.getInt("response_type")), jSONObject);
                    }
                    throw new NendException(NendStatus.ERR_INVALID_AD_STATUS, "Ad status : " + jSONObject.getInt("status_code") + ", Message : " + jSONObject.getString("message"));
                }
            } catch (UnsupportedEncodingException e) {
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
                return null;
            } catch (Throwable e2) {
                NendLog.m5618w(NendStatus.ERR_FAILED_TO_PARSE, e2);
                return null;
            } catch (Throwable e22) {
                NendLog.m5618w(NendStatus.ERR_FAILED_TO_PARSE, e22);
                return null;
            } catch (Throwable e222) {
                NendLog.m5618w(NendStatus.ERR_FAILED_TO_PARSE, e222);
                return null;
            }
        }
        throw new IllegalArgumentException(NendStatus.ERR_INVALID_RESPONSE.getMsg());
    }

    protected boolean isTarget(JSONArray jSONArray) {
        if ($assertionsDisabled || jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int i2 = jSONObject.getInt("logical_operator");
                if (i2 == 1) {
                    try {
                        this.mPackageManager.getPackageInfo(jSONObject.getString("url_scheme"), 1);
                    } catch (NameNotFoundException e) {
                        return $assertionsDisabled;
                    } catch (RuntimeException e2) {
                        return $assertionsDisabled;
                    }
                } else if (i2 != 2) {
                    return $assertionsDisabled;
                } else {
                    try {
                        this.mPackageManager.getPackageInfo(jSONObject.getString("url_scheme"), 1);
                        return $assertionsDisabled;
                    } catch (NameNotFoundException e3) {
                    } catch (RuntimeException e4) {
                        return $assertionsDisabled;
                    }
                }
            }
            return true;
        }
        throw new AssertionError();
    }
}
