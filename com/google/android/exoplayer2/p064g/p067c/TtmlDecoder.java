package com.google.android.exoplayer2.p064g.p067c;

import android.support.v7.appcompat.C0268R;
import android.util.Log;
import android.util.Pair;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.exoplayer2.p050j.XmlPullParserUtil;
import com.google.android.exoplayer2.p064g.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.p064g.Subtitle;
import com.google.android.exoplayer2.p064g.SubtitleDecoderException;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.google.android.exoplayer2.g.c.a */
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final Pattern f3455a;
    private static final Pattern f3456b;
    private static final Pattern f3457c;
    private static final Pattern f3458d;
    private static final TtmlDecoder f3459e;
    private final XmlPullParserFactory f3460f;

    /* renamed from: com.google.android.exoplayer2.g.c.a.a */
    private static final class TtmlDecoder {
        final float f3452a;
        final int f3453b;
        final int f3454c;

        TtmlDecoder(float f, int i, int i2) {
            this.f3452a = f;
            this.f3453b = i;
            this.f3454c = i2;
        }
    }

    protected /* synthetic */ Subtitle m4047a(byte[] bArr, int i) {
        return m4048b(bArr, i);
    }

    static {
        f3455a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
        f3456b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
        f3457c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
        f3458d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
        f3459e = new TtmlDecoder(30.0f, 1, 1);
    }

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            this.f3460f = XmlPullParserFactory.newInstance();
            this.f3460f.setNamespaceAware(true);
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    protected TtmlSubtitle m4048b(byte[] bArr, int i) {
        TtmlSubtitle ttmlSubtitle = null;
        int i2 = 0;
        try {
            XmlPullParser newPullParser = this.f3460f.newPullParser();
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            hashMap2.put(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, new TtmlRegion());
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            TtmlDecoder ttmlDecoder = f3459e;
            for (int i3 = eventType; i3 != 1; i3 = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) linkedList.peekLast();
                if (i2 == 0) {
                    TtmlSubtitle ttmlSubtitle2;
                    TtmlDecoder ttmlDecoder2;
                    int i4;
                    String name = newPullParser.getName();
                    if (i3 == 2) {
                        if ("tt".equals(name)) {
                            ttmlDecoder = m4038a(newPullParser);
                        }
                        int i5;
                        if (!TtmlDecoder.m4046b(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            eventType = i2 + 1;
                            ttmlSubtitle2 = ttmlSubtitle;
                            i5 = eventType;
                            ttmlDecoder2 = ttmlDecoder;
                            i4 = i5;
                        } else if ("head".equals(name)) {
                            m4042a(newPullParser, hashMap, hashMap2);
                            ttmlDecoder2 = ttmlDecoder;
                            i4 = i2;
                            ttmlSubtitle2 = ttmlSubtitle;
                        } else {
                            try {
                                TtmlNode a = m4039a(newPullParser, ttmlNode, hashMap2, ttmlDecoder);
                                linkedList.addLast(a);
                                if (ttmlNode != null) {
                                    ttmlNode.m4060a(a);
                                }
                                ttmlDecoder2 = ttmlDecoder;
                                i4 = i2;
                                ttmlSubtitle2 = ttmlSubtitle;
                            } catch (Throwable e) {
                                Log.w("TtmlDecoder", "Suppressing parser error", e);
                                eventType = i2 + 1;
                                ttmlSubtitle2 = ttmlSubtitle;
                                i5 = eventType;
                                ttmlDecoder2 = ttmlDecoder;
                                i4 = i5;
                            }
                        }
                    } else if (i3 == 4) {
                        ttmlNode.m4060a(TtmlNode.m4051a(newPullParser.getText()));
                        ttmlDecoder2 = ttmlDecoder;
                        i4 = i2;
                        ttmlSubtitle2 = ttmlSubtitle;
                    } else if (i3 == 3) {
                        TtmlSubtitle ttmlSubtitle3;
                        if (newPullParser.getName().equals("tt")) {
                            ttmlSubtitle3 = new TtmlSubtitle((TtmlNode) linkedList.getLast(), hashMap, hashMap2);
                        } else {
                            ttmlSubtitle3 = ttmlSubtitle;
                        }
                        linkedList.removeLast();
                        TtmlDecoder ttmlDecoder3 = ttmlDecoder;
                        i4 = i2;
                        ttmlSubtitle2 = ttmlSubtitle3;
                        ttmlDecoder2 = ttmlDecoder3;
                    } else {
                        ttmlDecoder2 = ttmlDecoder;
                        i4 = i2;
                        ttmlSubtitle2 = ttmlSubtitle;
                    }
                    ttmlSubtitle = ttmlSubtitle2;
                    i2 = i4;
                    ttmlDecoder = ttmlDecoder2;
                } else if (i3 == 2) {
                    i2++;
                } else if (i3 == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            return ttmlSubtitle;
        } catch (Throwable e2) {
            throw new SubtitleDecoderException("Unable to decode source", e2);
        } catch (Throwable e22) {
            throw new IllegalStateException("Unexpected error when reading input.", e22);
        }
    }

    private TtmlDecoder m4038a(XmlPullParser xmlPullParser) {
        int i = 30;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        }
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(" ");
            if (split.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
        }
        int i2 = f3459e.f3453b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = f3459e.f3454c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new TtmlDecoder(((float) i) * f, i2, i3);
    }

    private Map<String, TtmlStyle> m4042a(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.m4530b(xmlPullParser, FacebookAdapter.KEY_STYLE)) {
                String c = XmlPullParserUtil.m4531c(xmlPullParser, FacebookAdapter.KEY_STYLE);
                TtmlStyle a = m4041a(xmlPullParser, new TtmlStyle());
                if (c != null) {
                    for (Object obj : m4044a(c)) {
                        a.m4072a((TtmlStyle) map.get(obj));
                    }
                }
                if (a.m4088i() != null) {
                    map.put(a.m4088i(), a);
                }
            } else if (XmlPullParserUtil.m4530b(xmlPullParser, "region")) {
                Pair b = m4045b(xmlPullParser);
                if (b != null) {
                    map2.put(b.first, b.second);
                }
            }
        } while (!XmlPullParserUtil.m4528a(xmlPullParser, "head"));
        return map;
    }

    private Pair<String, TtmlRegion> m4045b(XmlPullParser xmlPullParser) {
        String c = XmlPullParserUtil.m4531c(xmlPullParser, FacebookAdapter.KEY_ID);
        Object c2 = XmlPullParserUtil.m4531c(xmlPullParser, Param.ORIGIN);
        Object c3 = XmlPullParserUtil.m4531c(xmlPullParser, "extent");
        if (c2 == null || c == null) {
            return null;
        }
        float parseFloat;
        float parseFloat2;
        float parseFloat3;
        Matcher matcher = f3458d.matcher(c2);
        if (matcher.matches()) {
            try {
                parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
            } catch (Throwable e) {
                Log.w("TtmlDecoder", "Ignoring region with malformed origin: '" + c2 + "'", e);
                parseFloat2 = Float.MIN_VALUE;
                parseFloat = Float.MIN_VALUE;
            }
        } else {
            parseFloat2 = Float.MIN_VALUE;
            parseFloat = Float.MIN_VALUE;
        }
        if (c3 != null) {
            matcher = f3458d.matcher(c3);
            if (matcher.matches()) {
                try {
                    parseFloat3 = Float.parseFloat(matcher.group(1)) / 100.0f;
                } catch (Throwable e2) {
                    Log.w("TtmlDecoder", "Ignoring malformed region extent: '" + c3 + "'", e2);
                }
                if (parseFloat == Float.MIN_VALUE) {
                    return new Pair(c, new TtmlRegion(parseFloat, parseFloat2, 0, parseFloat3));
                }
                return null;
            }
        }
        parseFloat3 = Float.MIN_VALUE;
        if (parseFloat == Float.MIN_VALUE) {
            return null;
        }
        return new Pair(c, new TtmlRegion(parseFloat, parseFloat2, 0, parseFloat3));
    }

    private String[] m4044a(String str) {
        return str.split("\\s+");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.p064g.p067c.TtmlStyle m4041a(org.xmlpull.v1.XmlPullParser r13, com.google.android.exoplayer2.p064g.p067c.TtmlStyle r14) {
        /*
        r12 = this;
        r6 = 3;
        r5 = 2;
        r3 = -1;
        r4 = 1;
        r2 = 0;
        r8 = r13.getAttributeCount();
        r7 = r2;
        r0 = r14;
    L_0x000b:
        if (r7 >= r8) goto L_0x0223;
    L_0x000d:
        r9 = r13.getAttributeValue(r7);
        r1 = r13.getAttributeName(r7);
        r10 = r1.hashCode();
        switch(r10) {
            case -1550943582: goto L_0x0060;
            case -1224696685: goto L_0x0042;
            case -1065511464: goto L_0x006a;
            case -879295043: goto L_0x0074;
            case -734428249: goto L_0x0056;
            case 3355: goto L_0x0024;
            case 94842723: goto L_0x0038;
            case 365601008: goto L_0x004c;
            case 1287124693: goto L_0x002e;
            default: goto L_0x001c;
        };
    L_0x001c:
        r1 = r3;
    L_0x001d:
        switch(r1) {
            case 0: goto L_0x007f;
            case 1: goto L_0x0094;
            case 2: goto L_0x00c1;
            case 3: goto L_0x00ef;
            case 4: goto L_0x00f9;
            case 5: goto L_0x0123;
            case 6: goto L_0x0133;
            case 7: goto L_0x0143;
            case 8: goto L_0x01c2;
            default: goto L_0x0020;
        };
    L_0x0020:
        r1 = r7 + 1;
        r7 = r1;
        goto L_0x000b;
    L_0x0024:
        r10 = "id";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x002c:
        r1 = r2;
        goto L_0x001d;
    L_0x002e:
        r10 = "backgroundColor";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0036:
        r1 = r4;
        goto L_0x001d;
    L_0x0038:
        r10 = "color";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0040:
        r1 = r5;
        goto L_0x001d;
    L_0x0042:
        r10 = "fontFamily";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x004a:
        r1 = r6;
        goto L_0x001d;
    L_0x004c:
        r10 = "fontSize";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0054:
        r1 = 4;
        goto L_0x001d;
    L_0x0056:
        r10 = "fontWeight";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x005e:
        r1 = 5;
        goto L_0x001d;
    L_0x0060:
        r10 = "fontStyle";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0068:
        r1 = 6;
        goto L_0x001d;
    L_0x006a:
        r10 = "textAlign";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0072:
        r1 = 7;
        goto L_0x001d;
    L_0x0074:
        r10 = "textDecoration";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x007c:
        r1 = 8;
        goto L_0x001d;
    L_0x007f:
        r1 = "style";
        r10 = r13.getName();
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x0020;
    L_0x008b:
        r0 = r12.m4040a(r0);
        r0 = r0.m4076b(r9);
        goto L_0x0020;
    L_0x0094:
        r0 = r12.m4040a(r0);
        r1 = com.google.android.exoplayer2.p050j.ColorParser.m4413a(r9);	 Catch:{ IllegalArgumentException -> 0x00a0 }
        r0.m4075b(r1);	 Catch:{ IllegalArgumentException -> 0x00a0 }
        goto L_0x0020;
    L_0x00a0:
        r1 = move-exception;
        r1 = "TtmlDecoder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "failed parsing background value: '";
        r10 = r10.append(r11);
        r9 = r10.append(r9);
        r10 = "'";
        r9 = r9.append(r10);
        r9 = r9.toString();
        android.util.Log.w(r1, r9);
        goto L_0x0020;
    L_0x00c1:
        r0 = r12.m4040a(r0);
        r1 = com.google.android.exoplayer2.p050j.ColorParser.m4413a(r9);	 Catch:{ IllegalArgumentException -> 0x00ce }
        r0.m4070a(r1);	 Catch:{ IllegalArgumentException -> 0x00ce }
        goto L_0x0020;
    L_0x00ce:
        r1 = move-exception;
        r1 = "TtmlDecoder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "failed parsing color value: '";
        r10 = r10.append(r11);
        r9 = r10.append(r9);
        r10 = "'";
        r9 = r9.append(r10);
        r9 = r9.toString();
        android.util.Log.w(r1, r9);
        goto L_0x0020;
    L_0x00ef:
        r0 = r12.m4040a(r0);
        r0 = r0.m4073a(r9);
        goto L_0x0020;
    L_0x00f9:
        r0 = r12.m4040a(r0);	 Catch:{ g -> 0x0102 }
        com.google.android.exoplayer2.p064g.p067c.TtmlDecoder.m4043a(r9, r0);	 Catch:{ g -> 0x0102 }
        goto L_0x0020;
    L_0x0102:
        r1 = move-exception;
        r1 = "TtmlDecoder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "failed parsing fontSize value: '";
        r10 = r10.append(r11);
        r9 = r10.append(r9);
        r10 = "'";
        r9 = r9.append(r10);
        r9 = r9.toString();
        android.util.Log.w(r1, r9);
        goto L_0x0020;
    L_0x0123:
        r0 = r12.m4040a(r0);
        r1 = "bold";
        r1 = r1.equalsIgnoreCase(r9);
        r0 = r0.m4080c(r1);
        goto L_0x0020;
    L_0x0133:
        r0 = r12.m4040a(r0);
        r1 = "italic";
        r1 = r1.equalsIgnoreCase(r9);
        r0 = r0.m4082d(r1);
        goto L_0x0020;
    L_0x0143:
        r1 = com.google.android.exoplayer2.p050j.Util.m4523d(r9);
        r9 = r1.hashCode();
        switch(r9) {
            case -1364013995: goto L_0x0188;
            case 100571: goto L_0x017e;
            case 3317767: goto L_0x0160;
            case 108511772: goto L_0x0174;
            case 109757538: goto L_0x016a;
            default: goto L_0x014e;
        };
    L_0x014e:
        r1 = r3;
    L_0x014f:
        switch(r1) {
            case 0: goto L_0x0154;
            case 1: goto L_0x0192;
            case 2: goto L_0x019e;
            case 3: goto L_0x01aa;
            case 4: goto L_0x01b6;
            default: goto L_0x0152;
        };
    L_0x0152:
        goto L_0x0020;
    L_0x0154:
        r0 = r12.m4040a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r0 = r0.m4071a(r1);
        goto L_0x0020;
    L_0x0160:
        r9 = "left";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0168:
        r1 = r2;
        goto L_0x014f;
    L_0x016a:
        r9 = "start";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0172:
        r1 = r4;
        goto L_0x014f;
    L_0x0174:
        r9 = "right";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x017c:
        r1 = r5;
        goto L_0x014f;
    L_0x017e:
        r9 = "end";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0186:
        r1 = r6;
        goto L_0x014f;
    L_0x0188:
        r9 = "center";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0190:
        r1 = 4;
        goto L_0x014f;
    L_0x0192:
        r0 = r12.m4040a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r0 = r0.m4071a(r1);
        goto L_0x0020;
    L_0x019e:
        r0 = r12.m4040a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        r0 = r0.m4071a(r1);
        goto L_0x0020;
    L_0x01aa:
        r0 = r12.m4040a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        r0 = r0.m4071a(r1);
        goto L_0x0020;
    L_0x01b6:
        r0 = r12.m4040a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_CENTER;
        r0 = r0.m4071a(r1);
        goto L_0x0020;
    L_0x01c2:
        r1 = com.google.android.exoplayer2.p050j.Util.m4523d(r9);
        r9 = r1.hashCode();
        switch(r9) {
            case -1461280213: goto L_0x01fb;
            case -1026963764: goto L_0x01f1;
            case 913457136: goto L_0x01e7;
            case 1679736913: goto L_0x01dd;
            default: goto L_0x01cd;
        };
    L_0x01cd:
        r1 = r3;
    L_0x01ce:
        switch(r1) {
            case 0: goto L_0x01d3;
            case 1: goto L_0x0205;
            case 2: goto L_0x020f;
            case 3: goto L_0x0219;
            default: goto L_0x01d1;
        };
    L_0x01d1:
        goto L_0x0020;
    L_0x01d3:
        r0 = r12.m4040a(r0);
        r0 = r0.m4074a(r4);
        goto L_0x0020;
    L_0x01dd:
        r9 = "linethrough";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x01e5:
        r1 = r2;
        goto L_0x01ce;
    L_0x01e7:
        r9 = "nolinethrough";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x01ef:
        r1 = r4;
        goto L_0x01ce;
    L_0x01f1:
        r9 = "underline";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x01f9:
        r1 = r5;
        goto L_0x01ce;
    L_0x01fb:
        r9 = "nounderline";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x0203:
        r1 = r6;
        goto L_0x01ce;
    L_0x0205:
        r0 = r12.m4040a(r0);
        r0 = r0.m4074a(r2);
        goto L_0x0020;
    L_0x020f:
        r0 = r12.m4040a(r0);
        r0 = r0.m4077b(r4);
        goto L_0x0020;
    L_0x0219:
        r0 = r12.m4040a(r0);
        r0 = r0.m4077b(r2);
        goto L_0x0020;
    L_0x0223:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.c.a.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.g.c.e):com.google.android.exoplayer2.g.c.e");
    }

    private TtmlStyle m4040a(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.p064g.p067c.TtmlNode m4039a(org.xmlpull.v1.XmlPullParser r20, com.google.android.exoplayer2.p064g.p067c.TtmlNode r21, java.util.Map<java.lang.String, com.google.android.exoplayer2.p064g.p067c.TtmlRegion> r22, com.google.android.exoplayer2.p064g.p067c.TtmlDecoder.TtmlDecoder r23) {
        /*
        r19 = this;
        r12 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r6 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r4 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r10 = "";
        r9 = 0;
        r14 = r20.getAttributeCount();
        r2 = 0;
        r0 = r19;
        r1 = r20;
        r8 = r0.m4041a(r1, r2);
        r2 = 0;
        r11 = r2;
    L_0x0021:
        if (r11 >= r14) goto L_0x00b3;
    L_0x0023:
        r0 = r20;
        r15 = r0.getAttributeName(r11);
        r0 = r20;
        r2 = r0.getAttributeValue(r11);
        r3 = -1;
        r16 = r15.hashCode();
        switch(r16) {
            case -934795532: goto L_0x006b;
            case 99841: goto L_0x0057;
            case 100571: goto L_0x004d;
            case 93616297: goto L_0x0043;
            case 109780401: goto L_0x0061;
            default: goto L_0x0037;
        };
    L_0x0037:
        switch(r3) {
            case 0: goto L_0x0075;
            case 1: goto L_0x0082;
            case 2: goto L_0x008b;
            case 3: goto L_0x0098;
            case 4: goto L_0x00a6;
            default: goto L_0x003a;
        };
    L_0x003a:
        r2 = r4;
        r4 = r6;
        r6 = r12;
    L_0x003d:
        r11 = r11 + 1;
        r12 = r6;
        r6 = r4;
        r4 = r2;
        goto L_0x0021;
    L_0x0043:
        r16 = "begin";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x004b:
        r3 = 0;
        goto L_0x0037;
    L_0x004d:
        r16 = "end";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x0055:
        r3 = 1;
        goto L_0x0037;
    L_0x0057:
        r16 = "dur";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x005f:
        r3 = 2;
        goto L_0x0037;
    L_0x0061:
        r16 = "style";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x0069:
        r3 = 3;
        goto L_0x0037;
    L_0x006b:
        r16 = "region";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x0073:
        r3 = 4;
        goto L_0x0037;
    L_0x0075:
        r0 = r23;
        r2 = com.google.android.exoplayer2.p064g.p067c.TtmlDecoder.m4037a(r2, r0);
        r6 = r12;
        r17 = r2;
        r2 = r4;
        r4 = r17;
        goto L_0x003d;
    L_0x0082:
        r0 = r23;
        r2 = com.google.android.exoplayer2.p064g.p067c.TtmlDecoder.m4037a(r2, r0);
        r4 = r6;
        r6 = r12;
        goto L_0x003d;
    L_0x008b:
        r0 = r23;
        r2 = com.google.android.exoplayer2.p064g.p067c.TtmlDecoder.m4037a(r2, r0);
        r17 = r4;
        r4 = r6;
        r6 = r2;
        r2 = r17;
        goto L_0x003d;
    L_0x0098:
        r0 = r19;
        r2 = r0.m4044a(r2);
        r3 = r2.length;
        if (r3 <= 0) goto L_0x003a;
    L_0x00a1:
        r9 = r2;
        r2 = r4;
        r4 = r6;
        r6 = r12;
        goto L_0x003d;
    L_0x00a6:
        r0 = r22;
        r3 = r0.containsKey(r2);
        if (r3 == 0) goto L_0x003a;
    L_0x00ae:
        r10 = r2;
        r2 = r4;
        r4 = r6;
        r6 = r12;
        goto L_0x003d;
    L_0x00b3:
        if (r21 == 0) goto L_0x0114;
    L_0x00b5:
        r0 = r21;
        r2 = r0.f3464d;
        r14 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
        if (r2 == 0) goto L_0x0114;
    L_0x00c2:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x00d0;
    L_0x00cb:
        r0 = r21;
        r2 = r0.f3464d;
        r6 = r6 + r2;
    L_0x00d0:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0114;
    L_0x00d9:
        r0 = r21;
        r2 = r0.f3464d;
        r4 = r4 + r2;
        r17 = r4;
        r4 = r6;
        r6 = r17;
    L_0x00e3:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x00f7;
    L_0x00ec:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0100;
    L_0x00f5:
        r6 = r4 + r12;
    L_0x00f7:
        r3 = r20.getName();
        r2 = com.google.android.exoplayer2.p064g.p067c.TtmlNode.m4052a(r3, r4, r6, r8, r9, r10);
        return r2;
    L_0x0100:
        if (r21 == 0) goto L_0x00f7;
    L_0x0102:
        r0 = r21;
        r2 = r0.f3465e;
        r12 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r2 == 0) goto L_0x00f7;
    L_0x010f:
        r0 = r21;
        r6 = r0.f3465e;
        goto L_0x00f7;
    L_0x0114:
        r17 = r4;
        r4 = r6;
        r6 = r17;
        goto L_0x00e3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.c.a.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.g.c.b, java.util.Map, com.google.android.exoplayer2.g.c.a$a):com.google.android.exoplayer2.g.c.b");
    }

    private static boolean m4046b(String str) {
        if (str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals(FacebookAdapter.KEY_STYLE) || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information")) {
            return true;
        }
        return false;
    }

    private static void m4043a(String str, TtmlStyle ttmlStyle) {
        Matcher matcher;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = f3457c.matcher(str);
        } else if (split.length == 2) {
            matcher = f3457c.matcher(split[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            int i = -1;
            switch (group.hashCode()) {
                case C0268R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                    if (group.equals("%")) {
                        i = 2;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        i = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    ttmlStyle.m4079c(1);
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    ttmlStyle.m4079c(2);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    ttmlStyle.m4079c(3);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
            }
            ttmlStyle.m4069a(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private static long m4037a(String str, TtmlDecoder ttmlDecoder) {
        double d = 0.0d;
        Matcher matcher = f3455a.matcher(str);
        double parseLong;
        if (matcher.matches()) {
            double parseLong2 = ((double) Long.parseLong(matcher.group(3))) + (((double) (Long.parseLong(matcher.group(1)) * 3600)) + ((double) (Long.parseLong(matcher.group(2)) * 60)));
            String group = matcher.group(4);
            parseLong2 += group != null ? Double.parseDouble(group) : 0.0d;
            group = matcher.group(5);
            if (group != null) {
                parseLong = (double) (((float) Long.parseLong(group)) / ttmlDecoder.f3452a);
            } else {
                parseLong = 0.0d;
            }
            parseLong += parseLong2;
            String group2 = matcher.group(6);
            if (group2 != null) {
                d = (((double) Long.parseLong(group2)) / ((double) ttmlDecoder.f3453b)) / ((double) ttmlDecoder.f3452a);
            }
            return (long) ((parseLong + d) * 1000000.0d);
        }
        Matcher matcher2 = f3456b.matcher(str);
        if (matcher2.matches()) {
            parseLong = Double.parseDouble(matcher2.group(1));
            String group3 = matcher2.group(2);
            int i = -1;
            switch (group3.hashCode()) {
                case C0268R.styleable.AppCompatTheme_buttonStyle /*102*/:
                    if (group3.equals("f")) {
                        i = 4;
                        break;
                    }
                    break;
                case C0268R.styleable.AppCompatTheme_checkboxStyle /*104*/:
                    if (group3.equals("h")) {
                        i = 0;
                        break;
                    }
                    break;
                case C0268R.styleable.AppCompatTheme_ratingBarStyleIndicator /*109*/:
                    if (group3.equals("m")) {
                        i = 1;
                        break;
                    }
                    break;
                case 115:
                    if (group3.equals("s")) {
                        i = 2;
                        break;
                    }
                    break;
                case 116:
                    if (group3.equals("t")) {
                        i = 5;
                        break;
                    }
                    break;
                case 3494:
                    if (group3.equals("ms")) {
                        i = 3;
                        break;
                    }
                    break;
            }
            switch (i) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    parseLong *= 3600.0d;
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    parseLong *= 60.0d;
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    parseLong /= 1000.0d;
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    parseLong /= (double) ttmlDecoder.f3452a;
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    parseLong /= (double) ttmlDecoder.f3454c;
                    break;
            }
            return (long) (parseLong * 1000000.0d);
        }
        throw new SubtitleDecoderException("Malformed time expression: " + str);
    }
}
