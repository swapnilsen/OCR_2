package p000a.p001a.p002a.p003a.p004a.p012g;

/* renamed from: a.a.a.a.a.g.t */
public class SettingsData {
    public final AppSettingsData f269a;
    public final SessionSettingsData f270b;
    public final PromptSettingsData f271c;
    public final FeaturesSettingsData f272d;
    public final AnalyticsSettingsData f273e;
    public final BetaSettingsData f274f;
    public final long f275g;
    public final int f276h;
    public final int f277i;

    public SettingsData(long j, AppSettingsData appSettingsData, SessionSettingsData sessionSettingsData, PromptSettingsData promptSettingsData, FeaturesSettingsData featuresSettingsData, AnalyticsSettingsData analyticsSettingsData, BetaSettingsData betaSettingsData, int i, int i2) {
        this.f275g = j;
        this.f269a = appSettingsData;
        this.f270b = sessionSettingsData;
        this.f271c = promptSettingsData;
        this.f272d = featuresSettingsData;
        this.f276h = i;
        this.f277i = i2;
        this.f273e = analyticsSettingsData;
        this.f274f = betaSettingsData;
    }

    public boolean m353a(long j) {
        return this.f275g < j;
    }
}
