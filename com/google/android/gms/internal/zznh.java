package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzme
class zznh {
    private String zzE;
    private final String zzOV;
    private int zzPY;
    private final String zzUA;
    private final boolean zzUB;
    private final boolean zzUC;
    private final String zzUD;
    private final List<String> zzUv;
    private final List<String> zzUw;
    private final String zzUx;
    private final String zzUy;
    private final String zzUz;

    public zznh(int i, Map<String, String> map) {
        this.zzE = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        this.zzUy = (String) map.get("base_uri");
        this.zzUz = (String) map.get("post_parameters");
        this.zzUB = parseBoolean((String) map.get("drt_include"));
        this.zzUC = parseBoolean((String) map.get("pan_include"));
        this.zzUx = (String) map.get("activation_overlay_url");
        this.zzUw = zzaM((String) map.get("check_packages"));
        this.zzOV = (String) map.get("request_id");
        this.zzUA = (String) map.get("type");
        this.zzUv = zzaM((String) map.get("errors"));
        this.zzPY = i;
        this.zzUD = (String) map.get("fetched_ad");
    }

    private static boolean parseBoolean(String str) {
        return str != null && (str.equals("1") || str.equals("true"));
    }

    private List<String> zzaM(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    public int getErrorCode() {
        return this.zzPY;
    }

    public String getRequestId() {
        return this.zzOV;
    }

    public String getType() {
        return this.zzUA;
    }

    public String getUrl() {
        return this.zzE;
    }

    public void setUrl(String str) {
        this.zzE = str;
    }

    public boolean zzjA() {
        return this.zzUB;
    }

    public String zzjB() {
        return this.zzUD;
    }

    public List<String> zzjx() {
        return this.zzUv;
    }

    public String zzjy() {
        return this.zzUy;
    }

    public String zzjz() {
        return this.zzUz;
    }
}
