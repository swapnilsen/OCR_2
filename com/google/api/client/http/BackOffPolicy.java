package com.google.api.client.http;

@Deprecated
public interface BackOffPolicy {
    public static final long STOP = -1;

    long getNextBackOffMillis();

    boolean isBackOffRequired(int i);

    void reset();
}
