package com.google.firebase.remoteconfig;

public class FirebaseRemoteConfigSettings {
    private final boolean f4645a;

    public static class Builder {
        private boolean f4644a;

        public Builder() {
            this.f4644a = false;
        }

        public FirebaseRemoteConfigSettings build() {
            return new FirebaseRemoteConfigSettings();
        }

        public Builder setDeveloperModeEnabled(boolean z) {
            this.f4644a = z;
            return this;
        }
    }

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.f4645a = builder.f4644a;
    }

    public boolean isDeveloperModeEnabled() {
        return this.f4645a;
    }
}
