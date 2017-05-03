package com.google.android.exoplayer2.p050j;

import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.google.android.exoplayer2.j.s */
public final class XmlPullParserUtil {
    public static boolean m4528a(XmlPullParser xmlPullParser, String str) {
        return XmlPullParserUtil.m4527a(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean m4527a(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean m4530b(XmlPullParser xmlPullParser, String str) {
        return XmlPullParserUtil.m4529b(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean m4529b(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    public static String m4531c(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.equals(xmlPullParser.getAttributeName(i))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
