package com.google.android.gms.ads;

import com.google.android.gms.internal.zzme;

@zzme
public final class VideoOptions {
    private final boolean zzrM;

    public static final class Builder {
        private boolean zzrM;

        public Builder() {
            this.zzrM = false;
        }

        public VideoOptions build() {
            return new VideoOptions();
        }

        public Builder setStartMuted(boolean z) {
            this.zzrM = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.zzrM = builder.zzrM;
    }

    public boolean getStartMuted() {
        return this.zzrM;
    }
}
