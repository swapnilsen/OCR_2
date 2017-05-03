package p000a.p001a.p002a.p003a.p004a.p012g;

import android.support.v4.view.MotionEventCompat;
import com.crashlytics.android.beta.BuildConfig;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p006b.CurrentTimeProvider;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;

/* renamed from: a.a.a.a.a.g.k */
class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    DefaultSettingsJsonTransform() {
    }

    public SettingsData m336a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new SettingsData(m328a(currentTimeProvider, (long) optInt2, jSONObject), m329a(jSONObject.getJSONObject("app")), m333e(jSONObject.getJSONObject("session")), m334f(jSONObject.getJSONObject("prompt")), m331c(jSONObject.getJSONObject("features")), m332d(jSONObject.getJSONObject("analytics")), m335g(jSONObject.getJSONObject(BuildConfig.ARTIFACT_ID)), optInt, optInt2);
    }

    private AppSettingsData m329a(JSONObject jSONObject) {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString(NotificationCompatApi24.CATEGORY_STATUS);
        String string3 = jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
        String string4 = jSONObject.getString("reports_url");
        boolean optBoolean = jSONObject.optBoolean("update_required", false);
        AppIconSettingsData appIconSettingsData = null;
        if (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) {
            appIconSettingsData = m330b(jSONObject.getJSONObject("icon"));
        }
        return new AppSettingsData(string, string2, string3, string4, optBoolean, appIconSettingsData);
    }

    private AppIconSettingsData m330b(JSONObject jSONObject) {
        return new AppIconSettingsData(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private FeaturesSettingsData m331c(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    private AnalyticsSettingsData m332d(JSONObject jSONObject) {
        return new AnalyticsSettingsData(jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL, "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", EventsFilesManager.MAX_BYTE_SIZE_PER_FILE), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    private SessionSettingsData m333e(JSONObject jSONObject) {
        return new SessionSettingsData(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", MotionEventCompat.ACTION_MASK), jSONObject.optBoolean("send_session_without_crash", false));
    }

    private PromptSettingsData m334f(JSONObject jSONObject) {
        return new PromptSettingsData(jSONObject.optString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private BetaSettingsData m335g(JSONObject jSONObject) {
        return new BetaSettingsData(jSONObject.optString("update_endpoint", SettingsJsonConstants.f278a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    private long m328a(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return currentTimeProvider.m84a() + (1000 * j);
    }
}
