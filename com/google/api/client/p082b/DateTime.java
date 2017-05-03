package com.google.api.client.p082b;

import com.google.api.client.http.ExponentialBackOffPolicy;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.api.client.b.l */
public final class DateTime implements Serializable {
    private static final TimeZone f4174a;
    private static final Pattern f4175b;
    private final long f4176c;
    private final boolean f4177d;
    private final int f4178e;

    static {
        f4174a = TimeZone.getTimeZone("GMT");
        f4175b = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
    }

    public DateTime(long j) {
        this(false, j, null);
    }

    public DateTime(boolean z, long j, Integer num) {
        this.f4177d = z;
        this.f4176c = j;
        int offset = z ? 0 : num == null ? TimeZone.getDefault().getOffset(j) / ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS : num.intValue();
        this.f4178e = offset;
    }

    public String m4916a() {
        StringBuilder stringBuilder = new StringBuilder();
        Calendar gregorianCalendar = new GregorianCalendar(f4174a);
        gregorianCalendar.setTimeInMillis(this.f4176c + (((long) this.f4178e) * 60000));
        DateTime.m4915a(stringBuilder, gregorianCalendar.get(1), 4);
        stringBuilder.append('-');
        DateTime.m4915a(stringBuilder, gregorianCalendar.get(2) + 1, 2);
        stringBuilder.append('-');
        DateTime.m4915a(stringBuilder, gregorianCalendar.get(5), 2);
        if (!this.f4177d) {
            stringBuilder.append('T');
            DateTime.m4915a(stringBuilder, gregorianCalendar.get(11), 2);
            stringBuilder.append(':');
            DateTime.m4915a(stringBuilder, gregorianCalendar.get(12), 2);
            stringBuilder.append(':');
            DateTime.m4915a(stringBuilder, gregorianCalendar.get(13), 2);
            if (gregorianCalendar.isSet(14)) {
                stringBuilder.append('.');
                DateTime.m4915a(stringBuilder, gregorianCalendar.get(14), 3);
            }
            if (this.f4178e == 0) {
                stringBuilder.append('Z');
            } else {
                int i = this.f4178e;
                if (this.f4178e > 0) {
                    stringBuilder.append('+');
                } else {
                    stringBuilder.append('-');
                    i = -i;
                }
                int i2 = i / 60;
                i %= 60;
                DateTime.m4915a(stringBuilder, i2, 2);
                stringBuilder.append(':');
                DateTime.m4915a(stringBuilder, i, 2);
            }
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return m4916a();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DateTime)) {
            return false;
        }
        DateTime dateTime = (DateTime) obj;
        if (this.f4177d == dateTime.f4177d && this.f4176c == dateTime.f4176c && this.f4178e == dateTime.f4178e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long[] jArr = new long[3];
        jArr[0] = this.f4176c;
        jArr[1] = this.f4177d ? 1 : 0;
        jArr[2] = (long) this.f4178e;
        return Arrays.hashCode(jArr);
    }

    public static DateTime m4914a(String str) {
        Matcher matcher = f4175b.matcher(str);
        if (matcher.matches()) {
            Object obj;
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2)) - 1;
            int parseInt3 = Integer.parseInt(matcher.group(3));
            Object obj2 = matcher.group(4) != null ? 1 : null;
            String group = matcher.group(9);
            if (group != null) {
                obj = 1;
            } else {
                obj = null;
            }
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            if (obj == null || obj2 != null) {
                int parseInt4;
                Calendar gregorianCalendar;
                long timeInMillis;
                Integer num;
                boolean z;
                if (obj2 != null) {
                    i = Integer.parseInt(matcher.group(5));
                    i2 = Integer.parseInt(matcher.group(6));
                    i3 = Integer.parseInt(matcher.group(7));
                    if (matcher.group(8) != null) {
                        parseInt4 = (int) (((double) ((float) Integer.parseInt(matcher.group(8).substring(1)))) / Math.pow(10.0d, (double) (matcher.group(8).substring(1).length() - 3)));
                        gregorianCalendar = new GregorianCalendar(f4174a);
                        gregorianCalendar.set(parseInt, parseInt2, parseInt3, i, i2, i3);
                        gregorianCalendar.set(14, parseInt4);
                        timeInMillis = gregorianCalendar.getTimeInMillis();
                        if (obj2 != null || obj == null) {
                            num = null;
                        } else {
                            int i4;
                            if (Character.toUpperCase(group.charAt(0)) == 'Z') {
                                i4 = 0;
                            } else {
                                i4 = (Integer.parseInt(matcher.group(11)) * 60) + Integer.parseInt(matcher.group(12));
                                if (matcher.group(10).charAt(0) == '-') {
                                    i4 = -i4;
                                }
                                timeInMillis -= ((long) i4) * 60000;
                            }
                            num = Integer.valueOf(i4);
                        }
                        if (obj2 != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return new DateTime(z, timeInMillis, num);
                    }
                }
                parseInt4 = 0;
                gregorianCalendar = new GregorianCalendar(f4174a);
                gregorianCalendar.set(parseInt, parseInt2, parseInt3, i, i2, i3);
                gregorianCalendar.set(14, parseInt4);
                timeInMillis = gregorianCalendar.getTimeInMillis();
                if (obj2 != null) {
                }
                num = null;
                if (obj2 != null) {
                    z = false;
                } else {
                    z = true;
                }
                return new DateTime(z, timeInMillis, num);
            }
            throw new NumberFormatException("Invalid date/time format, cannot specify time zone shift without specifying time: " + str);
        }
        throw new NumberFormatException("Invalid date/time format: " + str);
    }

    private static void m4915a(StringBuilder stringBuilder, int i, int i2) {
        if (i < 0) {
            stringBuilder.append('-');
            i = -i;
        }
        int i3 = i;
        while (i3 > 0) {
            i3 /= 10;
            i2--;
        }
        for (i3 = 0; i3 < i2; i3++) {
            stringBuilder.append('0');
        }
        if (i != 0) {
            stringBuilder.append(i);
        }
    }
}
