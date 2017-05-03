package com.google.gson.internal.bind.util;

import com.google.api.client.http.ExponentialBackOffPolicy;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import net.nend.android.NendIconError;

public class ISO8601Utils {
    private static final TimeZone f4913a;

    static {
        f4913a = TimeZone.getTimeZone("UTC");
    }

    public static String format(Date date) {
        return format(date, false, f4913a);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, f4913a);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        int length;
        Calendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        int length2 = "yyyy-MM-ddThh:mm:ss".length() + (z ? ".sss".length() : 0);
        if (timeZone.getRawOffset() == 0) {
            length = "Z".length();
        } else {
            length = "+hh:mm".length();
        }
        StringBuilder stringBuilder = new StringBuilder(length + length2);
        m5511a(stringBuilder, gregorianCalendar.get(1), "yyyy".length());
        stringBuilder.append('-');
        m5511a(stringBuilder, gregorianCalendar.get(2) + 1, "MM".length());
        stringBuilder.append('-');
        m5511a(stringBuilder, gregorianCalendar.get(5), "dd".length());
        stringBuilder.append('T');
        m5511a(stringBuilder, gregorianCalendar.get(11), "hh".length());
        stringBuilder.append(':');
        m5511a(stringBuilder, gregorianCalendar.get(12), "mm".length());
        stringBuilder.append(':');
        m5511a(stringBuilder, gregorianCalendar.get(13), "ss".length());
        if (z) {
            stringBuilder.append('.');
            m5511a(stringBuilder, gregorianCalendar.get(14), "sss".length());
        }
        length = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (length != 0) {
            int abs = Math.abs((length / ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS) / 60);
            int abs2 = Math.abs((length / ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS) % 60);
            stringBuilder.append(length < 0 ? '-' : '+');
            m5511a(stringBuilder, abs, "hh".length());
            stringBuilder.append(':');
            m5511a(stringBuilder, abs2, "mm".length());
        } else {
            stringBuilder.append('Z');
        }
        return stringBuilder.toString();
    }

    public static Date parse(String str, ParsePosition parsePosition) {
        Throwable th;
        String message;
        ParseException parseException;
        String substring;
        try {
            int index = parsePosition.getIndex();
            int i = index + 4;
            int a = m5510a(str, index, i);
            if (m5512a(str, i, '-')) {
                index = i + 1;
            } else {
                index = i;
            }
            i = index + 2;
            int a2 = m5510a(str, index, i);
            if (m5512a(str, i, '-')) {
                index = i + 1;
            } else {
                index = i;
            }
            i = index + 2;
            int a3 = m5510a(str, index, i);
            boolean a4 = m5512a(str, i, 'T');
            if (a4 || str.length() > i) {
                int a5;
                int i2;
                int i3;
                if (a4) {
                    index = i + 1;
                    i = index + 2;
                    a5 = m5510a(str, index, i);
                    if (m5512a(str, i, ':')) {
                        index = i + 1;
                    } else {
                        index = i;
                    }
                    i = index + 2;
                    index = m5510a(str, index, i);
                    if (m5512a(str, i, ':')) {
                        i++;
                    }
                    if (str.length() > i) {
                        char charAt = str.charAt(i);
                        if (!(charAt == 'Z' || charAt == '+' || charAt == '-')) {
                            i2 = i + 2;
                            i = m5510a(str, i, i2);
                            if (i > 59 && i < 63) {
                                i = 59;
                            }
                            if (m5512a(str, i2, '.')) {
                                i3 = i2 + 1;
                                i2 = m5509a(str, i3 + 1);
                                int min = Math.min(i2, i3 + 3);
                                int a6 = m5510a(str, i3, min);
                                switch (min - i3) {
                                    case NendIconError.ERROR_ICONVIEW /*1*/:
                                        a6 *= 100;
                                        break;
                                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                                        a6 *= 10;
                                        break;
                                }
                                i3 = a5;
                                a5 = i;
                                i = i2;
                                i2 = index;
                                index = a6;
                            } else {
                                i3 = a5;
                                a5 = i;
                                i = i2;
                                i2 = index;
                                index = 0;
                            }
                        }
                    }
                    i2 = index;
                    i3 = a5;
                    index = 0;
                    a5 = 0;
                } else {
                    index = 0;
                    a5 = 0;
                    i2 = 0;
                    i3 = 0;
                }
                if (str.length() <= i) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                TimeZone timeZone;
                char charAt2 = str.charAt(i);
                if (charAt2 == 'Z') {
                    timeZone = f4913a;
                    i++;
                } else if (charAt2 == '+' || charAt2 == '-') {
                    substring = str.substring(i);
                    if (substring.length() < 5) {
                        substring = substring + "00";
                    }
                    i += substring.length();
                    if ("+0000".equals(substring) || "+00:00".equals(substring)) {
                        timeZone = f4913a;
                    } else {
                        String str2 = "GMT" + substring;
                        timeZone = TimeZone.getTimeZone(str2);
                        String id = timeZone.getID();
                        if (!(id.equals(str2) || id.replace(":", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING).equals(str2))) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone.getID());
                        }
                    }
                } else {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                }
                Calendar gregorianCalendar = new GregorianCalendar(timeZone);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, a);
                gregorianCalendar.set(2, a2 - 1);
                gregorianCalendar.set(5, a3);
                gregorianCalendar.set(11, i3);
                gregorianCalendar.set(12, i2);
                gregorianCalendar.set(13, a5);
                gregorianCalendar.set(14, index);
                parsePosition.setIndex(i);
                return gregorianCalendar.getTime();
            }
            Calendar gregorianCalendar2 = new GregorianCalendar(a, a2 - 1, a3);
            parsePosition.setIndex(i);
            return gregorianCalendar2.getTime();
        } catch (Throwable e) {
            th = e;
            if (str == null) {
                substring = null;
            } else {
                substring = '\"' + str + "'";
            }
            message = th.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + th.getClass().getName() + ")";
            }
            parseException = new ParseException("Failed to parse date [" + substring + "]: " + message, parsePosition.getIndex());
            parseException.initCause(th);
            throw parseException;
        } catch (Throwable e2) {
            th = e2;
            if (str == null) {
                substring = '\"' + str + "'";
            } else {
                substring = null;
            }
            message = th.getMessage();
            message = "(" + th.getClass().getName() + ")";
            parseException = new ParseException("Failed to parse date [" + substring + "]: " + message, parsePosition.getIndex());
            parseException.initCause(th);
            throw parseException;
        } catch (Throwable e22) {
            th = e22;
            if (str == null) {
                substring = null;
            } else {
                substring = '\"' + str + "'";
            }
            message = th.getMessage();
            message = "(" + th.getClass().getName() + ")";
            parseException = new ParseException("Failed to parse date [" + substring + "]: " + message, parsePosition.getIndex());
            parseException.initCause(th);
            throw parseException;
        }
    }

    private static boolean m5512a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int m5510a(String str, int i, int i2) {
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i3;
        int i4 = 0;
        if (i < i2) {
            i3 = i + 1;
            i4 = Character.digit(str.charAt(i), 10);
            if (i4 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -i4;
        } else {
            i3 = i;
        }
        while (i3 < i2) {
            int i5 = i3 + 1;
            i3 = Character.digit(str.charAt(i3), 10);
            if (i3 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - i3;
            i3 = i5;
        }
        return -i4;
    }

    private static void m5511a(StringBuilder stringBuilder, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(num);
    }

    private static int m5509a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
