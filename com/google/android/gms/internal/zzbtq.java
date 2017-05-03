package com.google.android.gms.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

public class zzbtq implements FirebaseRemoteConfigValue {
    public static final Charset UTF_8;
    public static final Pattern zzaII;
    public static final Pattern zzaIJ;
    private final int zzAW;
    private final byte[] zzcmn;

    static {
        UTF_8 = Charset.forName("UTF-8");
        zzaII = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        zzaIJ = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    public zzbtq(byte[] bArr, int i) {
        this.zzcmn = bArr;
        this.zzAW = i;
    }

    private void zzach() {
        if (this.zzcmn == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    public boolean asBoolean() {
        if (this.zzAW == 0) {
            return false;
        }
        Object asString = asString();
        if (zzaII.matcher(asString).matches()) {
            return true;
        }
        if (zzaIJ.matcher(asString).matches()) {
            return false;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(asString).length() + 45).append("[Value: ").append(asString).append("] cannot be interpreted as a boolean.").toString());
    }

    public byte[] asByteArray() {
        return this.zzAW == 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY : this.zzcmn;
    }

    public double asDouble() {
        if (this.zzAW == 0) {
            return 0.0d;
        }
        String asString = asString();
        try {
            return Double.valueOf(asString).doubleValue();
        } catch (Throwable e) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(asString).length() + 42).append("[Value: ").append(asString).append("] cannot be converted to a double.").toString(), e);
        }
    }

    public long asLong() {
        if (this.zzAW == 0) {
            return 0;
        }
        String asString = asString();
        try {
            return Long.valueOf(asString).longValue();
        } catch (Throwable e) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(asString).length() + 40).append("[Value: ").append(asString).append("] cannot be converted to a long.").toString(), e);
        }
    }

    public String asString() {
        if (this.zzAW == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        zzach();
        return new String(this.zzcmn, UTF_8);
    }

    public int getSource() {
        return this.zzAW;
    }
}
