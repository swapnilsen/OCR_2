package net.nend.android;

final class NendConstants {
    static final boolean IS_DEBUG_CODE = false;
    static final int MAX_ICON_COUNT = 8;
    static final String NEND_UID_KEY = "NENDUUID";
    static final String VERSION = "2.5.3";

    static class AdDefaultParams {
        static final int HEIGHT = 50;
        static final int MAX_AD_RELOAD_INTERVAL_IN_SECONDS = 99999;
        static final int MIN_AD_RELOAD_INTERVAL_IN_SECONDS = 30;
        static final int RELOAD_INTERVAL_IN_SECONDS = 60;
        static final int WIDTH = 320;

        private AdDefaultParams() {
        }
    }

    enum Attribute {
        SPOT_ID("NendSpotId"),
        API_KEY("NendApiKey"),
        RELOADABLE("NendReloadable");
        
        private String name;

        private Attribute(String str) {
            this.name = str;
        }

        String getName() {
            return this.name;
        }
    }

    enum DialogMessage {
        JA("\u30a2\u30d7\u30ea\u3092\u7d42\u4e86\u3057\u307e\u3059\u304b\uff1f"),
        EN("Close this app?");
        
        private String message;

        private DialogMessage(String str) {
            this.message = str;
        }

        String getMessage() {
            return this.message;
        }
    }

    enum IconAttribute {
        TITLE_COLOR("NendTitleColor"),
        TITLE_VISIBLE("NendTitleVisible"),
        ICON_COUNT("NendIconCount"),
        ICON_ORIENTATION("NendOrientation"),
        ICON_SPACE("NendIconSpaceEnabled");
        
        private String name;

        private IconAttribute(String str) {
            this.name = str;
        }

        String getName() {
            return this.name;
        }
    }

    enum MetaData {
        ADSCHEME("NendAdScheme"),
        ADAUTHORITY("NendAdAuthority"),
        ADPATH("NendAdPath"),
        OPT_OUT_URL("NendOptOutUrl"),
        OPT_OUT_IMAGE_URL("NendOptOutImageUrl");
        
        private String name;

        private MetaData(String str) {
            this.name = str;
        }

        String getName() {
            return this.name;
        }
    }

    static class NendHttpParams {
        static final int CONNECTION_TIMEOUT_IN_SECOND = 10;
        static final int SOCKET_TIMEOUT_IN_SECOND = 10;

        private NendHttpParams() {
        }
    }

    static final class OptOutParams {
        static final String PAGE_URL = "http://nend.net/privacy/optsdkgate";

        private OptOutParams() {
        }
    }

    static final class RequestParams {
        static final String BANNER_DOMAIN = "ad1.nend.net";
        static final String BANNER_PATH = "na.php";
        static final String ICON_DOMAIN = "ad3.nend.net";
        static final String ICON_PATH = "nia.php";
        static final String INTERSTITIAL_DOMAIN = "lois.nend.net";
        static final String INTERSTITIAL_PATH = "nsa.php";
        static final String PROTOCOL = "http";

        private RequestParams() {
        }
    }

    private NendConstants() {
    }
}
