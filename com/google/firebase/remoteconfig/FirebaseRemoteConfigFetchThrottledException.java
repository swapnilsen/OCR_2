package com.google.firebase.remoteconfig;

public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigFetchException {
    private final long f4643a;

    public FirebaseRemoteConfigFetchThrottledException(long j) {
        this.f4643a = j;
    }

    public long getThrottleEndTimeMillis() {
        return this.f4643a;
    }
}
