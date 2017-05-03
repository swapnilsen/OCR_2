package com.google.android.exoplayer2.p050j;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.j.c */
public final class ColorParser {
    private static final Pattern f3795a;
    private static final Pattern f3796b;
    private static final Pattern f3797c;
    private static final Map<String, Integer> f3798d;

    static {
        f3795a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f3796b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f3797c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        f3798d = new HashMap();
        f3798d.put("aliceblue", Integer.valueOf(-984833));
        f3798d.put("antiquewhite", Integer.valueOf(-332841));
        f3798d.put("aqua", Integer.valueOf(-16711681));
        f3798d.put("aquamarine", Integer.valueOf(-8388652));
        f3798d.put("azure", Integer.valueOf(-983041));
        f3798d.put("beige", Integer.valueOf(-657956));
        f3798d.put("bisque", Integer.valueOf(-6972));
        f3798d.put("black", Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
        f3798d.put("blanchedalmond", Integer.valueOf(-5171));
        f3798d.put("blue", Integer.valueOf(-16776961));
        f3798d.put("blueviolet", Integer.valueOf(-7722014));
        f3798d.put("brown", Integer.valueOf(-5952982));
        f3798d.put("burlywood", Integer.valueOf(-2180985));
        f3798d.put("cadetblue", Integer.valueOf(-10510688));
        f3798d.put("chartreuse", Integer.valueOf(-8388864));
        f3798d.put("chocolate", Integer.valueOf(-2987746));
        f3798d.put("coral", Integer.valueOf(-32944));
        f3798d.put("cornflowerblue", Integer.valueOf(-10185235));
        f3798d.put("cornsilk", Integer.valueOf(-1828));
        f3798d.put("crimson", Integer.valueOf(-2354116));
        f3798d.put("cyan", Integer.valueOf(-16711681));
        f3798d.put("darkblue", Integer.valueOf(-16777077));
        f3798d.put("darkcyan", Integer.valueOf(-16741493));
        f3798d.put("darkgoldenrod", Integer.valueOf(-4684277));
        f3798d.put("darkgray", Integer.valueOf(-5658199));
        f3798d.put("darkgreen", Integer.valueOf(-16751616));
        f3798d.put("darkgrey", Integer.valueOf(-5658199));
        f3798d.put("darkkhaki", Integer.valueOf(-4343957));
        f3798d.put("darkmagenta", Integer.valueOf(-7667573));
        f3798d.put("darkolivegreen", Integer.valueOf(-11179217));
        f3798d.put("darkorange", Integer.valueOf(-29696));
        f3798d.put("darkorchid", Integer.valueOf(-6737204));
        f3798d.put("darkred", Integer.valueOf(-7667712));
        f3798d.put("darksalmon", Integer.valueOf(-1468806));
        f3798d.put("darkseagreen", Integer.valueOf(-7357297));
        f3798d.put("darkslateblue", Integer.valueOf(-12042869));
        f3798d.put("darkslategray", Integer.valueOf(-13676721));
        f3798d.put("darkslategrey", Integer.valueOf(-13676721));
        f3798d.put("darkturquoise", Integer.valueOf(-16724271));
        f3798d.put("darkviolet", Integer.valueOf(-7077677));
        f3798d.put("deeppink", Integer.valueOf(-60269));
        f3798d.put("deepskyblue", Integer.valueOf(-16728065));
        f3798d.put("dimgray", Integer.valueOf(-9868951));
        f3798d.put("dimgrey", Integer.valueOf(-9868951));
        f3798d.put("dodgerblue", Integer.valueOf(-14774017));
        f3798d.put("firebrick", Integer.valueOf(-5103070));
        f3798d.put("floralwhite", Integer.valueOf(-1296));
        f3798d.put("forestgreen", Integer.valueOf(-14513374));
        f3798d.put("fuchsia", Integer.valueOf(-65281));
        f3798d.put("gainsboro", Integer.valueOf(-2302756));
        f3798d.put("ghostwhite", Integer.valueOf(-460545));
        f3798d.put("gold", Integer.valueOf(-10496));
        f3798d.put("goldenrod", Integer.valueOf(-2448096));
        f3798d.put("gray", Integer.valueOf(-8355712));
        f3798d.put("green", Integer.valueOf(-16744448));
        f3798d.put("greenyellow", Integer.valueOf(-5374161));
        f3798d.put("grey", Integer.valueOf(-8355712));
        f3798d.put("honeydew", Integer.valueOf(-983056));
        f3798d.put("hotpink", Integer.valueOf(-38476));
        f3798d.put("indianred", Integer.valueOf(-3318692));
        f3798d.put("indigo", Integer.valueOf(-11861886));
        f3798d.put("ivory", Integer.valueOf(-16));
        f3798d.put("khaki", Integer.valueOf(-989556));
        f3798d.put("lavender", Integer.valueOf(-1644806));
        f3798d.put("lavenderblush", Integer.valueOf(-3851));
        f3798d.put("lawngreen", Integer.valueOf(-8586240));
        f3798d.put("lemonchiffon", Integer.valueOf(-1331));
        f3798d.put("lightblue", Integer.valueOf(-5383962));
        f3798d.put("lightcoral", Integer.valueOf(-1015680));
        f3798d.put("lightcyan", Integer.valueOf(-2031617));
        f3798d.put("lightgoldenrodyellow", Integer.valueOf(-329006));
        f3798d.put("lightgray", Integer.valueOf(-2894893));
        f3798d.put("lightgreen", Integer.valueOf(-7278960));
        f3798d.put("lightgrey", Integer.valueOf(-2894893));
        f3798d.put("lightpink", Integer.valueOf(-18751));
        f3798d.put("lightsalmon", Integer.valueOf(-24454));
        f3798d.put("lightseagreen", Integer.valueOf(-14634326));
        f3798d.put("lightskyblue", Integer.valueOf(-7876870));
        f3798d.put("lightslategray", Integer.valueOf(-8943463));
        f3798d.put("lightslategrey", Integer.valueOf(-8943463));
        f3798d.put("lightsteelblue", Integer.valueOf(-5192482));
        f3798d.put("lightyellow", Integer.valueOf(-32));
        f3798d.put("lime", Integer.valueOf(-16711936));
        f3798d.put("limegreen", Integer.valueOf(-13447886));
        f3798d.put("linen", Integer.valueOf(-331546));
        f3798d.put("magenta", Integer.valueOf(-65281));
        f3798d.put("maroon", Integer.valueOf(-8388608));
        f3798d.put("mediumaquamarine", Integer.valueOf(-10039894));
        f3798d.put("mediumblue", Integer.valueOf(-16777011));
        f3798d.put("mediumorchid", Integer.valueOf(-4565549));
        f3798d.put("mediumpurple", Integer.valueOf(-7114533));
        f3798d.put("mediumseagreen", Integer.valueOf(-12799119));
        f3798d.put("mediumslateblue", Integer.valueOf(-8689426));
        f3798d.put("mediumspringgreen", Integer.valueOf(-16713062));
        f3798d.put("mediumturquoise", Integer.valueOf(-12004916));
        f3798d.put("mediumvioletred", Integer.valueOf(-3730043));
        f3798d.put("midnightblue", Integer.valueOf(-15132304));
        f3798d.put("mintcream", Integer.valueOf(-655366));
        f3798d.put("mistyrose", Integer.valueOf(-6943));
        f3798d.put("moccasin", Integer.valueOf(-6987));
        f3798d.put("navajowhite", Integer.valueOf(-8531));
        f3798d.put("navy", Integer.valueOf(-16777088));
        f3798d.put("oldlace", Integer.valueOf(-133658));
        f3798d.put("olive", Integer.valueOf(-8355840));
        f3798d.put("olivedrab", Integer.valueOf(-9728477));
        f3798d.put("orange", Integer.valueOf(-23296));
        f3798d.put("orangered", Integer.valueOf(-47872));
        f3798d.put("orchid", Integer.valueOf(-2461482));
        f3798d.put("palegoldenrod", Integer.valueOf(-1120086));
        f3798d.put("palegreen", Integer.valueOf(-6751336));
        f3798d.put("paleturquoise", Integer.valueOf(-5247250));
        f3798d.put("palevioletred", Integer.valueOf(-2396013));
        f3798d.put("papayawhip", Integer.valueOf(-4139));
        f3798d.put("peachpuff", Integer.valueOf(-9543));
        f3798d.put("peru", Integer.valueOf(-3308225));
        f3798d.put("pink", Integer.valueOf(-16181));
        f3798d.put("plum", Integer.valueOf(-2252579));
        f3798d.put("powderblue", Integer.valueOf(-5185306));
        f3798d.put("purple", Integer.valueOf(-8388480));
        f3798d.put("rebeccapurple", Integer.valueOf(-10079335));
        f3798d.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
        f3798d.put("rosybrown", Integer.valueOf(-4419697));
        f3798d.put("royalblue", Integer.valueOf(-12490271));
        f3798d.put("saddlebrown", Integer.valueOf(-7650029));
        f3798d.put("salmon", Integer.valueOf(-360334));
        f3798d.put("sandybrown", Integer.valueOf(-744352));
        f3798d.put("seagreen", Integer.valueOf(-13726889));
        f3798d.put("seashell", Integer.valueOf(-2578));
        f3798d.put("sienna", Integer.valueOf(-6270419));
        f3798d.put("silver", Integer.valueOf(-4144960));
        f3798d.put("skyblue", Integer.valueOf(-7876885));
        f3798d.put("slateblue", Integer.valueOf(-9807155));
        f3798d.put("slategray", Integer.valueOf(-9404272));
        f3798d.put("slategrey", Integer.valueOf(-9404272));
        f3798d.put("snow", Integer.valueOf(-1286));
        f3798d.put("springgreen", Integer.valueOf(-16711809));
        f3798d.put("steelblue", Integer.valueOf(-12156236));
        f3798d.put("tan", Integer.valueOf(-2968436));
        f3798d.put("teal", Integer.valueOf(-16744320));
        f3798d.put("thistle", Integer.valueOf(-2572328));
        f3798d.put("tomato", Integer.valueOf(-40121));
        f3798d.put("transparent", Integer.valueOf(0));
        f3798d.put("turquoise", Integer.valueOf(-12525360));
        f3798d.put("violet", Integer.valueOf(-1146130));
        f3798d.put("wheat", Integer.valueOf(-663885));
        f3798d.put("white", Integer.valueOf(-1));
        f3798d.put("whitesmoke", Integer.valueOf(-657931));
        f3798d.put("yellow", Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
        f3798d.put("yellowgreen", Integer.valueOf(-6632142));
    }

    public static int m4413a(String str) {
        return ColorParser.m4414a(str, false);
    }

    public static int m4415b(String str) {
        return ColorParser.m4414a(str, true);
    }

    private static int m4414a(String str, boolean z) {
        Assertions.m4404a(!TextUtils.isEmpty(str));
        Object replace = str.replace(" ", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        int parseLong;
        if (replace.charAt(0) == '#') {
            parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return parseLong | ViewCompat.MEASURED_STATE_MASK;
            }
            if (replace.length() == 9) {
                return (parseLong >>> 8) | ((parseLong & MotionEventCompat.ACTION_MASK) << 24);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z ? f3797c : f3796b).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseLong = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseLong = Integer.parseInt(matcher.group(4), 10);
                }
                return ColorParser.m4412a(parseLong, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f3795a.matcher(replace);
            if (matcher2.matches()) {
                return ColorParser.m4411a(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = (Integer) f3798d.get(Util.m4523d(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private static int m4412a(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    private static int m4411a(int i, int i2, int i3) {
        return ColorParser.m4412a(MotionEventCompat.ACTION_MASK, i, i2, i3);
    }
}
