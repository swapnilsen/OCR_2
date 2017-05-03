package com.google.android.exoplayer2.p049d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.ads.AdSize;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.nend.android.NendIconError;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.d.d */
public final class MediaCodecUtil {
    private static final MediaCodecInfo f3291a;
    private static final Pattern f3292b;
    private static final HashMap<MediaCodecUtil, List<MediaCodecInfo>> f3293c;
    private static final Map<Integer, Integer> f3294d;
    private static final Map<Integer, Integer> f3295e;
    private static final Map<String, Integer> f3296f;
    private static int f3297g;

    /* renamed from: com.google.android.exoplayer2.d.d.a */
    private static final class MediaCodecUtil {
        public final String f3287a;
        public final boolean f3288b;

        public MediaCodecUtil(String str, boolean z) {
            this.f3287a = str;
            this.f3288b = z;
        }

        public int hashCode() {
            return (this.f3288b ? 1231 : 1237) + (((this.f3287a == null ? 0 : this.f3287a.hashCode()) + 31) * 31);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != MediaCodecUtil.class) {
                return false;
            }
            MediaCodecUtil mediaCodecUtil = (MediaCodecUtil) obj;
            if (TextUtils.equals(this.f3287a, mediaCodecUtil.f3287a) && this.f3288b == mediaCodecUtil.f3288b) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.google.android.exoplayer2.d.d.b */
    public static class MediaCodecUtil extends Exception {
        private MediaCodecUtil(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* renamed from: com.google.android.exoplayer2.d.d.c */
    private interface MediaCodecUtil {
        int m3774a();

        MediaCodecInfo m3775a(int i);

        boolean m3776a(String str, CodecCapabilities codecCapabilities);

        boolean m3777b();
    }

    /* renamed from: com.google.android.exoplayer2.d.d.d */
    private static final class MediaCodecUtil implements MediaCodecUtil {
        private MediaCodecUtil() {
        }

        public int m3778a() {
            return MediaCodecList.getCodecCount();
        }

        public MediaCodecInfo m3779a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public boolean m3781b() {
            return false;
        }

        public boolean m3780a(String str, CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    @TargetApi(21)
    /* renamed from: com.google.android.exoplayer2.d.d.e */
    private static final class MediaCodecUtil implements MediaCodecUtil {
        private final int f3289a;
        private MediaCodecInfo[] f3290b;

        public MediaCodecUtil(boolean z) {
            this.f3289a = z ? 1 : 0;
        }

        public int m3783a() {
            m3782c();
            return this.f3290b.length;
        }

        public MediaCodecInfo m3784a(int i) {
            m3782c();
            return this.f3290b[i];
        }

        public boolean m3786b() {
            return true;
        }

        public boolean m3785a(String str, CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void m3782c() {
            if (this.f3290b == null) {
                this.f3290b = new MediaCodecList(this.f3289a).getCodecInfos();
            }
        }
    }

    static {
        f3291a = MediaCodecInfo.m3758a("OMX.google.raw.decoder");
        f3292b = Pattern.compile("^\\D?(\\d+)$");
        f3293c = new HashMap();
        f3297g = -1;
        f3294d = new HashMap();
        f3294d.put(Integer.valueOf(66), Integer.valueOf(1));
        f3294d.put(Integer.valueOf(77), Integer.valueOf(2));
        f3294d.put(Integer.valueOf(88), Integer.valueOf(4));
        f3294d.put(Integer.valueOf(100), Integer.valueOf(8));
        f3295e = new HashMap();
        f3295e.put(Integer.valueOf(10), Integer.valueOf(1));
        f3295e.put(Integer.valueOf(11), Integer.valueOf(4));
        f3295e.put(Integer.valueOf(12), Integer.valueOf(8));
        f3295e.put(Integer.valueOf(13), Integer.valueOf(16));
        f3295e.put(Integer.valueOf(20), Integer.valueOf(32));
        f3295e.put(Integer.valueOf(21), Integer.valueOf(64));
        f3295e.put(Integer.valueOf(22), Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS));
        f3295e.put(Integer.valueOf(30), Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY));
        f3295e.put(Integer.valueOf(31), Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH));
        f3295e.put(Integer.valueOf(32), Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT));
        f3295e.put(Integer.valueOf(40), Integer.valueOf(ItemAnimator.FLAG_MOVED));
        f3295e.put(Integer.valueOf(41), Integer.valueOf(CodedOutputStream.DEFAULT_BUFFER_SIZE));
        f3295e.put(Integer.valueOf(42), Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD));
        f3295e.put(Integer.valueOf(50), Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_COPY));
        f3295e.put(Integer.valueOf(51), Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_PASTE));
        f3295e.put(Integer.valueOf(52), Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_CUT));
        f3296f = new HashMap();
        f3296f.put("L30", Integer.valueOf(1));
        f3296f.put("L60", Integer.valueOf(4));
        f3296f.put("L63", Integer.valueOf(16));
        f3296f.put("L90", Integer.valueOf(64));
        f3296f.put("L93", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY));
        f3296f.put("L120", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT));
        f3296f.put("L123", Integer.valueOf(CodedOutputStream.DEFAULT_BUFFER_SIZE));
        f3296f.put("L150", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_COPY));
        f3296f.put("L153", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_CUT));
        f3296f.put("L156", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_EXPAND));
        f3296f.put("L180", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_DISMISS));
        f3296f.put("L183", Integer.valueOf(AccessibilityEventCompat.TYPE_WINDOWS_CHANGED));
        f3296f.put("L186", Integer.valueOf(AccessibilityEventCompat.TYPE_ASSIST_READING_CONTEXT));
        f3296f.put("H30", Integer.valueOf(2));
        f3296f.put("H60", Integer.valueOf(8));
        f3296f.put("H63", Integer.valueOf(32));
        f3296f.put("H90", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS));
        f3296f.put("H93", Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH));
        f3296f.put("H120", Integer.valueOf(ItemAnimator.FLAG_MOVED));
        f3296f.put("H123", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD));
        f3296f.put("H150", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_PASTE));
        f3296f.put("H153", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION));
        f3296f.put("H156", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_COLLAPSE));
        f3296f.put("H180", Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_SET_TEXT));
        f3296f.put("H183", Integer.valueOf(AccessibilityEventCompat.TYPE_VIEW_CONTEXT_CLICKED));
        f3296f.put("H186", Integer.valueOf(33554432));
    }

    public static MediaCodecInfo m3790a() {
        return f3291a;
    }

    public static MediaCodecInfo m3791a(String str, boolean z) {
        List b = MediaCodecUtil.m3796b(str, z);
        return b.isEmpty() ? null : (MediaCodecInfo) b.get(0);
    }

    public static synchronized List<MediaCodecInfo> m3796b(String str, boolean z) {
        List<MediaCodecInfo> list;
        synchronized (MediaCodecUtil.class) {
            MediaCodecUtil mediaCodecUtil = new MediaCodecUtil(str, z);
            list = (List) f3293c.get(mediaCodecUtil);
            if (list == null) {
                List a = MediaCodecUtil.m3792a(mediaCodecUtil, Util.f3855a >= 21 ? new MediaCodecUtil(z) : new MediaCodecUtil());
                if (z && a.isEmpty() && 21 <= Util.f3855a && Util.f3855a <= 23) {
                    List a2 = MediaCodecUtil.m3792a(mediaCodecUtil, new MediaCodecUtil());
                    if (!a2.isEmpty()) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((MediaCodecInfo) a2.get(0)).f3278a);
                    }
                    a = a2;
                }
                list = Collections.unmodifiableList(a);
                f3293c.put(mediaCodecUtil, list);
            }
        }
        return list;
    }

    private static List<MediaCodecInfo> m3792a(MediaCodecUtil mediaCodecUtil, MediaCodecUtil mediaCodecUtil2) {
        String name;
        try {
            List<MediaCodecInfo> arrayList = new ArrayList();
            String str = mediaCodecUtil.f3287a;
            int a = mediaCodecUtil2.m3774a();
            boolean b = mediaCodecUtil2.m3777b();
            loop0:
            for (int i = 0; i < a; i++) {
                MediaCodecInfo a2 = mediaCodecUtil2.m3775a(i);
                name = a2.getName();
                if (MediaCodecUtil.m3793a(a2, name, b)) {
                    for (String str2 : a2.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(str2);
                            boolean a3 = mediaCodecUtil2.m3776a(str, capabilitiesForType);
                            if ((!b || mediaCodecUtil.f3288b != a3) && (b || mediaCodecUtil.f3288b)) {
                                if (!b && a3) {
                                    arrayList.add(MediaCodecInfo.m3759a(name + ".secure", str, capabilitiesForType));
                                    break loop0;
                                }
                            }
                            arrayList.add(MediaCodecInfo.m3759a(name, str, capabilitiesForType));
                        }
                    }
                    continue;
                }
            }
            return arrayList;
        } catch (Exception e) {
            if (Util.f3855a > 23 || arrayList.isEmpty()) {
                Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str2 + ")");
                throw e;
            }
            Log.e("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
        } catch (Throwable e2) {
            throw new MediaCodecUtil(null);
        }
    }

    private static boolean m3793a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (!z && str.endsWith(".secure")) {
            return false;
        }
        if (Util.f3855a < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (Util.f3855a < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (Util.f3855a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && "a70".equals(Util.f3856b)) {
            return false;
        }
        if (Util.f3855a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(Util.f3856b) || "protou".equals(Util.f3856b) || "ville".equals(Util.f3856b) || "villeplus".equals(Util.f3856b) || "villec2".equals(Util.f3856b) || Util.f3856b.startsWith("gee") || "C6602".equals(Util.f3856b) || "C6603".equals(Util.f3856b) || "C6606".equals(Util.f3856b) || "C6616".equals(Util.f3856b) || "L36h".equals(Util.f3856b) || "SO-02E".equals(Util.f3856b))) {
            return false;
        }
        if (Util.f3855a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(Util.f3856b) || "C1505".equals(Util.f3856b) || "C1604".equals(Util.f3856b) || "C1605".equals(Util.f3856b))) {
            return false;
        }
        if (Util.f3855a <= 19 && ((Util.f3856b.startsWith("d2") || Util.f3856b.startsWith("serrano") || Util.f3856b.startsWith("jflte") || Util.f3856b.startsWith("santos")) && "samsung".equals(Util.f3857c) && "OMX.SEC.vp8.dec".equals(str))) {
            return false;
        }
        if (Util.f3855a <= 19 && Util.f3856b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return true;
    }

    public static int m3794b() {
        int i = 0;
        if (f3297g == -1) {
            MediaCodecInfo a = MediaCodecUtil.m3791a("video/avc", false);
            if (a != null) {
                CodecProfileLevel[] a2 = a.m3765a();
                int length = a2.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(MediaCodecUtil.m3787a(a2[i].level), i2);
                    i++;
                }
                i = Math.max(i2, 172800);
            }
            f3297g = i;
        }
        return f3297g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> m3788a(java.lang.String r6) {
        /*
        r0 = 0;
        r1 = 0;
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = "\\.";
        r3 = r6.split(r2);
        r4 = r3[r1];
        r2 = -1;
        r5 = r4.hashCode();
        switch(r5) {
            case 3006243: goto L_0x0032;
            case 3006244: goto L_0x003c;
            case 3199032: goto L_0x001f;
            case 3214780: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r1 = r2;
    L_0x0016:
        switch(r1) {
            case 0: goto L_0x001a;
            case 1: goto L_0x001a;
            case 2: goto L_0x0046;
            case 3: goto L_0x0046;
            default: goto L_0x0019;
        };
    L_0x0019:
        goto L_0x0004;
    L_0x001a:
        r0 = com.google.android.exoplayer2.p049d.MediaCodecUtil.m3789a(r6, r3);
        goto L_0x0004;
    L_0x001f:
        r5 = "hev1";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0015;
    L_0x0027:
        goto L_0x0016;
    L_0x0028:
        r1 = "hvc1";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0015;
    L_0x0030:
        r1 = 1;
        goto L_0x0016;
    L_0x0032:
        r1 = "avc1";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0015;
    L_0x003a:
        r1 = 2;
        goto L_0x0016;
    L_0x003c:
        r1 = "avc2";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0015;
    L_0x0044:
        r1 = 3;
        goto L_0x0016;
    L_0x0046:
        r0 = com.google.android.exoplayer2.p049d.MediaCodecUtil.m3795b(r6, r3);
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.d.a(java.lang.String):android.util.Pair<java.lang.Integer, java.lang.Integer>");
    }

    private static Pair<Integer, Integer> m3789a(String str, String[] strArr) {
        if (strArr.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = f3292b.matcher(strArr[1]);
        if (matcher.matches()) {
            int i;
            String group = matcher.group(1);
            if ("1".equals(group)) {
                i = 1;
            } else if ("2".equals(group)) {
                i = 2;
            } else {
                Log.w("MediaCodecUtil", "Unknown HEVC profile string: " + group);
                return null;
            }
            Integer num = (Integer) f3296f.get(strArr[3]);
            if (num != null) {
                return new Pair(Integer.valueOf(i), num);
            }
            Log.w("MediaCodecUtil", "Unknown HEVC level string: " + matcher.group(1));
            return null;
        }
        Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
        return null;
    }

    private static Pair<Integer, Integer> m3795b(String str, String[] strArr) {
        if (strArr.length < 2) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            Object valueOf;
            Object valueOf2;
            if (strArr[1].length() == 6) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                Integer valueOf3 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            Integer num = (Integer) f3294d.get(valueOf);
            if (num == null) {
                Log.w("MediaCodecUtil", "Unknown AVC profile: " + valueOf);
                return null;
            }
            Integer num2 = (Integer) f3295e.get(valueOf2);
            if (num2 != null) {
                return new Pair(num, num2);
            }
            Log.w("MediaCodecUtil", "Unknown AVC level: " + valueOf2);
            return null;
        } catch (NumberFormatException e) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static int m3787a(int i) {
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return 25344;
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                return 101376;
            case CommonStatusCodes.CANCELED /*16*/:
                return 101376;
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                return 101376;
            case C0268R.styleable.AppCompatTheme_editTextBackground /*64*/:
                return 202752;
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                return 414720;
            case AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY /*256*/:
                return 414720;
            case AdRequest.MAX_CONTENT_URL_LENGTH /*512*/:
                return 921600;
            case AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT /*1024*/:
                return 1310720;
            case ItemAnimator.FLAG_MOVED /*2048*/:
                return AccessibilityNodeInfoCompat.ACTION_SET_TEXT;
            case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                return AccessibilityNodeInfoCompat.ACTION_SET_TEXT;
            case AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD /*8192*/:
                return 2228224;
            case AccessibilityNodeInfoCompat.ACTION_COPY /*16384*/:
                return 5652480;
            case AccessibilityNodeInfoCompat.ACTION_PASTE /*32768*/:
                return 9437184;
            default:
                return -1;
        }
    }
}
