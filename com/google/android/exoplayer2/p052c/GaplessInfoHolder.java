package com.google.android.exoplayer2.p052c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.c.j */
public final class GaplessInfoHolder {
    private static final Pattern f3249c;
    public int f3250a;
    public int f3251b;

    static {
        f3249c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    }

    public GaplessInfoHolder() {
        this.f3250a = -1;
        this.f3251b = -1;
    }

    public boolean m3729a(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.f3250a = i2;
        this.f3251b = i3;
        return true;
    }

    public boolean m3730a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = f3249c.matcher(str2);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f3250a = parseInt;
            this.f3251b = parseInt2;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean m3728a() {
        return (this.f3250a == -1 || this.f3251b == -1) ? false : true;
    }
}
