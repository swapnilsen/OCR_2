package net.nend.android;

import net.nend.android.NendAdView.NendError;

public class NendIconError {
    public static final int ERROR_ICONVIEW = 1;
    public static final int ERROR_LOADER = 0;
    private int errorType;
    private NendAdIconView iconView;
    private NendAdIconLoader loader;
    private NendError nendError;

    public NendIconError() {
        this.loader = null;
        this.iconView = null;
    }

    public NendAdIconLoader getLoader() {
        return this.loader;
    }

    void setLoader(NendAdIconLoader nendAdIconLoader) {
        this.loader = nendAdIconLoader;
    }

    public NendAdIconView getIconView() {
        return this.iconView;
    }

    void setIconView(NendAdIconView nendAdIconView) {
        this.iconView = nendAdIconView;
    }

    public NendError getNendError() {
        return this.nendError;
    }

    public void setNendError(NendError nendError) {
        this.nendError = nendError;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public void setErrorType(int i) {
        this.errorType = i;
    }
}
