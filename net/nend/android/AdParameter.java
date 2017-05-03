package net.nend.android;

interface AdParameter {

    public enum ViewType {
        NONE,
        ADVIEW,
        WEBVIEW
    }

    String getAdId();

    String getClickUrl();

    int getHeight();

    String getIconId();

    String getImageUrl();

    int getReloadIntervalInSeconds();

    String getTitleText();

    ViewType getViewType();

    String getWebViewUrl();

    int getWidth();

    boolean isAnimationGif();
}
