package com.google.android.exoplayer2.p052c.p054b;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import android.support.v7.cardview.C0269R;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.p050j.LongArray;
import com.google.android.exoplayer2.p050j.MimeTypes;
import com.google.android.exoplayer2.p050j.NalUnitUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.ChunkIndex;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap.SeekMap;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p071k.AvcConfig;
import com.google.android.exoplayer2.p071k.HevcConfig;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;

/* renamed from: com.google.android.exoplayer2.c.b.d */
public final class MatroskaExtractor implements Extractor {
    public static final ExtractorsFactory f2592a;
    private static final byte[] f2593b;
    private static final byte[] f2594c;
    private static final UUID f2595d;
    private boolean f2596A;
    private long f2597B;
    private long f2598C;
    private long f2599D;
    private LongArray f2600E;
    private LongArray f2601F;
    private boolean f2602G;
    private int f2603H;
    private long f2604I;
    private long f2605J;
    private int f2606K;
    private int f2607L;
    private int[] f2608M;
    private int f2609N;
    private int f2610O;
    private int f2611P;
    private int f2612Q;
    private boolean f2613R;
    private boolean f2614S;
    private boolean f2615T;
    private boolean f2616U;
    private byte f2617V;
    private int f2618W;
    private int f2619X;
    private int f2620Y;
    private boolean f2621Z;
    private boolean aa;
    private ExtractorOutput ab;
    private final EbmlReader f2622e;
    private final VarintReader f2623f;
    private final SparseArray<MatroskaExtractor> f2624g;
    private final ParsableByteArray f2625h;
    private final ParsableByteArray f2626i;
    private final ParsableByteArray f2627j;
    private final ParsableByteArray f2628k;
    private final ParsableByteArray f2629l;
    private final ParsableByteArray f2630m;
    private final ParsableByteArray f2631n;
    private final ParsableByteArray f2632o;
    private final ParsableByteArray f2633p;
    private ByteBuffer f2634q;
    private long f2635r;
    private long f2636s;
    private long f2637t;
    private long f2638u;
    private long f2639v;
    private MatroskaExtractor f2640w;
    private boolean f2641x;
    private int f2642y;
    private long f2643z;

    /* renamed from: com.google.android.exoplayer2.c.b.d.1 */
    static class MatroskaExtractor implements ExtractorsFactory {
        MatroskaExtractor() {
        }

        public Extractor[] m3182a() {
            return new Extractor[]{new MatroskaExtractor()};
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.b.d.a */
    private final class MatroskaExtractor implements EbmlReaderOutput {
        final /* synthetic */ MatroskaExtractor f2565a;

        private MatroskaExtractor(MatroskaExtractor matroskaExtractor) {
            this.f2565a = matroskaExtractor;
        }

        public int m3183a(int i) {
            return this.f2565a.m3210a(i);
        }

        public boolean m3189b(int i) {
            return this.f2565a.m3220b(i);
        }

        public void m3187a(int i, long j, long j2) {
            this.f2565a.m3215a(i, j, j2);
        }

        public void m3190c(int i) {
            this.f2565a.m3222c(i);
        }

        public void m3186a(int i, long j) {
            this.f2565a.m3214a(i, j);
        }

        public void m3184a(int i, double d) {
            this.f2565a.m3212a(i, d);
        }

        public void m3188a(int i, String str) {
            this.f2565a.m3216a(i, str);
        }

        public void m3185a(int i, int i2, ExtractorInput extractorInput) {
            this.f2565a.m3213a(i, i2, extractorInput);
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.b.d.b */
    private static final class MatroskaExtractor {
        public String f2566a;
        public int f2567b;
        public int f2568c;
        public int f2569d;
        public boolean f2570e;
        public byte[] f2571f;
        public byte[] f2572g;
        public byte[] f2573h;
        public DrmInitData f2574i;
        public int f2575j;
        public int f2576k;
        public int f2577l;
        public int f2578m;
        public int f2579n;
        public byte[] f2580o;
        public int f2581p;
        public int f2582q;
        public int f2583r;
        public int f2584s;
        public long f2585t;
        public long f2586u;
        public boolean f2587v;
        public boolean f2588w;
        public TrackOutput f2589x;
        public int f2590y;
        private String f2591z;

        private MatroskaExtractor() {
            this.f2575j = -1;
            this.f2576k = -1;
            this.f2577l = -1;
            this.f2578m = -1;
            this.f2579n = 0;
            this.f2580o = null;
            this.f2581p = -1;
            this.f2582q = 1;
            this.f2583r = -1;
            this.f2584s = EventsFilesManager.MAX_BYTE_SIZE_PER_FILE;
            this.f2585t = 0;
            this.f2586u = 0;
            this.f2588w = true;
            this.f2591z = "eng";
        }

        public void m3195a(ExtractorOutput extractorOutput, int i) {
            Format a;
            int i2 = -1;
            int i3 = -1;
            List list = null;
            String str = this.f2566a;
            Object obj = -1;
            switch (str.hashCode()) {
                case -2095576542:
                    if (str.equals("V_MPEG4/ISO/AP")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -2095575984:
                    if (str.equals("V_MPEG4/ISO/SP")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -1985379776:
                    if (str.equals("A_MS/ACM")) {
                        obj = 21;
                        break;
                    }
                    break;
                case -1784763192:
                    if (str.equals("A_TRUEHD")) {
                        obj = 16;
                        break;
                    }
                    break;
                case -1730367663:
                    if (str.equals("A_VORBIS")) {
                        obj = 10;
                        break;
                    }
                    break;
                case -1482641357:
                    if (str.equals("A_MPEG/L3")) {
                        obj = 13;
                        break;
                    }
                    break;
                case -1373388978:
                    if (str.equals("V_MS/VFW/FOURCC")) {
                        obj = 8;
                        break;
                    }
                    break;
                case -538363189:
                    if (str.equals("V_MPEG4/ISO/ASP")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -538363109:
                    if (str.equals("V_MPEG4/ISO/AVC")) {
                        obj = 6;
                        break;
                    }
                    break;
                case -425012669:
                    if (str.equals("S_VOBSUB")) {
                        obj = 24;
                        break;
                    }
                    break;
                case -356037306:
                    if (str.equals("A_DTS/LOSSLESS")) {
                        obj = 19;
                        break;
                    }
                    break;
                case 62923557:
                    if (str.equals("A_AAC")) {
                        obj = 12;
                        break;
                    }
                    break;
                case 62923603:
                    if (str.equals("A_AC3")) {
                        obj = 14;
                        break;
                    }
                    break;
                case 62927045:
                    if (str.equals("A_DTS")) {
                        obj = 17;
                        break;
                    }
                    break;
                case 82338133:
                    if (str.equals("V_VP8")) {
                        obj = null;
                        break;
                    }
                    break;
                case 82338134:
                    if (str.equals("V_VP9")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 99146302:
                    if (str.equals("S_HDMV/PGS")) {
                        obj = 25;
                        break;
                    }
                    break;
                case 444813526:
                    if (str.equals("V_THEORA")) {
                        obj = 9;
                        break;
                    }
                    break;
                case 542569478:
                    if (str.equals("A_DTS/EXPRESS")) {
                        obj = 18;
                        break;
                    }
                    break;
                case 725957860:
                    if (str.equals("A_PCM/INT/LIT")) {
                        obj = 22;
                        break;
                    }
                    break;
                case 855502857:
                    if (str.equals("V_MPEGH/ISO/HEVC")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 1422270023:
                    if (str.equals("S_TEXT/UTF8")) {
                        obj = 23;
                        break;
                    }
                    break;
                case 1809237540:
                    if (str.equals("V_MPEG2")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1950749482:
                    if (str.equals("A_EAC3")) {
                        obj = 15;
                        break;
                    }
                    break;
                case 1950789798:
                    if (str.equals("A_FLAC")) {
                        obj = 20;
                        break;
                    }
                    break;
                case 1951062397:
                    if (str.equals("A_OPUS")) {
                        obj = 11;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    str = "video/x-vnd.on2.vp8";
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    str = "video/x-vnd.on2.vp9";
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str = "video/mpeg2";
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                case Type.OTHER_PROFILE /*5*/:
                    List list2;
                    str = "video/mp4v-es";
                    if (this.f2573h == null) {
                        list2 = null;
                    } else {
                        list2 = Collections.singletonList(this.f2573h);
                    }
                    list = list2;
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    str = "video/avc";
                    AvcConfig a2 = AvcConfig.m4532a(new ParsableByteArray(this.f2573h));
                    list = a2.f3864a;
                    this.f2590y = a2.f3865b;
                    break;
                case Type.WEBSITE /*7*/:
                    str = "video/hevc";
                    HevcConfig a3 = HevcConfig.m4534a(new ParsableByteArray(this.f2573h));
                    list = a3.f3869a;
                    this.f2590y = a3.f3870b;
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    list = MatroskaExtractor.m3192a(new ParsableByteArray(this.f2573h));
                    str = list == null ? "video/x-unknown" : "video/wvc1";
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str = "video/x-unknown";
                    break;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    str = "audio/vorbis";
                    i2 = AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD;
                    list = MatroskaExtractor.m3193a(this.f2573h);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    str = "audio/opus";
                    i2 = 5760;
                    list = new ArrayList(3);
                    list.add(this.f2573h);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.f2585t).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.f2586u).array());
                    break;
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    str = "audio/mp4a-latm";
                    list = Collections.singletonList(this.f2573h);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str = "audio/mpeg";
                    i2 = CodedOutputStream.DEFAULT_BUFFER_SIZE;
                    break;
                case CommonStatusCodes.INTERRUPTED /*14*/:
                    str = "audio/ac3";
                    break;
                case CommonStatusCodes.TIMEOUT /*15*/:
                    str = "audio/eac3";
                    break;
                case CommonStatusCodes.CANCELED /*16*/:
                    str = "audio/true-hd";
                    break;
                case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                case CommonStatusCodes.DEAD_CLIENT /*18*/:
                    str = "audio/vnd.dts";
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    str = "audio/vnd.dts.hd";
                    break;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    str = "audio/x-flac";
                    list = Collections.singletonList(this.f2573h);
                    break;
                case C0268R.styleable.Toolbar_buttonGravity /*21*/:
                    str = "audio/raw";
                    if (MatroskaExtractor.m3194b(new ParsableByteArray(this.f2573h))) {
                        i3 = Util.m4506a(this.f2583r);
                        if (i3 == 0) {
                            throw new ParserException("Unsupported PCM bit depth: " + this.f2583r);
                        }
                    }
                    throw new ParserException("Non-PCM MS/ACM is unsupported");
                    break;
                case C0268R.styleable.Toolbar_collapseIcon /*22*/:
                    str = "audio/raw";
                    i3 = Util.m4506a(this.f2583r);
                    if (i3 == 0) {
                        throw new ParserException("Unsupported PCM bit depth: " + this.f2583r);
                    }
                    break;
                case C0268R.styleable.Toolbar_collapseContentDescription /*23*/:
                    str = "application/x-subrip";
                    break;
                case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                    str = "application/vobsub";
                    list = Collections.singletonList(this.f2573h);
                    break;
                case C0268R.styleable.Toolbar_navigationContentDescription /*25*/:
                    str = "application/pgs";
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            int i4 = (0 | (this.f2588w ? 1 : 0)) | (this.f2587v ? 2 : 0);
            if (MimeTypes.m4425a(str)) {
                a = Format.m2861a(Integer.toString(i), str, null, -1, i2, this.f2582q, this.f2584s, i3, list, this.f2574i, i4, this.f2591z);
            } else if (MimeTypes.m4426b(str)) {
                if (this.f2579n == 0) {
                    this.f2577l = this.f2577l == -1 ? this.f2575j : this.f2577l;
                    this.f2578m = this.f2578m == -1 ? this.f2576k : this.f2578m;
                }
                float f = -1.0f;
                if (!(this.f2577l == -1 || this.f2578m == -1)) {
                    f = ((float) (this.f2576k * this.f2577l)) / ((float) (this.f2575j * this.f2578m));
                }
                a = Format.m2859a(Integer.toString(i), str, null, -1, i2, this.f2575j, this.f2576k, -1.0f, list, -1, f, this.f2580o, this.f2581p, this.f2574i);
            } else if ("application/x-subrip".equals(str)) {
                a = Format.m2863a(Integer.toString(i), str, null, -1, i4, this.f2591z, this.f2574i);
            } else if ("application/vobsub".equals(str) || "application/pgs".equals(str)) {
                a = Format.m2866a(Integer.toString(i), str, null, -1, list, this.f2591z, this.f2574i);
            } else {
                throw new ParserException("Unexpected MIME type.");
            }
            this.f2589x = extractorOutput.m3725a(this.f2567b);
            this.f2589x.m3426a(a);
        }

        private static List<byte[]> m3192a(ParsableByteArray parsableByteArray) {
            try {
                parsableByteArray.m4457d(16);
                if (parsableByteArray.m4467m() != 826496599) {
                    return null;
                }
                int d = parsableByteArray.m4456d() + 20;
                byte[] bArr = parsableByteArray.f3831a;
                while (d < bArr.length - 4) {
                    if (bArr[d] == null && bArr[d + 1] == null && bArr[d + 2] == 1 && bArr[d + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, d, bArr.length));
                    }
                    d++;
                }
                throw new ParserException("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing FourCC VC1 codec private");
            }
        }

        private static List<byte[]> m3193a(byte[] bArr) {
            int i = 0;
            try {
                if (bArr[0] != 2) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i2 = 0;
                int i3 = 1;
                while (bArr[i3] == (byte) -1) {
                    i3++;
                    i2 += MotionEventCompat.ACTION_MASK;
                }
                int i4 = i3 + 1;
                i2 += bArr[i3];
                while (bArr[i4] == (byte) -1) {
                    i += MotionEventCompat.ACTION_MASK;
                    i4++;
                }
                i3 = i4 + 1;
                i += bArr[i4];
                if (bArr[i3] != (byte) 1) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                Object obj = new byte[i2];
                System.arraycopy(bArr, i3, obj, 0, i2);
                i2 += i3;
                if (bArr[i2] != 3) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                i += i2;
                if (bArr[i] != 5) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                Object obj2 = new byte[(bArr.length - i)];
                System.arraycopy(bArr, i, obj2, 0, bArr.length - i);
                List<byte[]> arrayList = new ArrayList(2);
                arrayList.add(obj);
                arrayList.add(obj2);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        private static boolean m3194b(ParsableByteArray parsableByteArray) {
            try {
                int i = parsableByteArray.m4463i();
                if (i == 1) {
                    return true;
                }
                if (i != 65534) {
                    return false;
                }
                parsableByteArray.m4455c(24);
                if (parsableByteArray.m4470p() == MatroskaExtractor.f2595d.getMostSignificantBits() && parsableByteArray.m4470p() == MatroskaExtractor.f2595d.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }
    }

    static {
        f2592a = new MatroskaExtractor();
        f2593b = new byte[]{(byte) 49, (byte) 10, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 32, (byte) 45, (byte) 45, (byte) 62, (byte) 32, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 10};
        f2594c = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
        f2595d = new UUID(72057594037932032L, -9223371306706625679L);
    }

    public MatroskaExtractor() {
        this(new DefaultEbmlReader());
    }

    MatroskaExtractor(EbmlReader ebmlReader) {
        this.f2636s = -1;
        this.f2637t = -9223372036854775807L;
        this.f2638u = -9223372036854775807L;
        this.f2639v = -9223372036854775807L;
        this.f2597B = -1;
        this.f2598C = -1;
        this.f2599D = -9223372036854775807L;
        this.f2622e = ebmlReader;
        this.f2622e.m3165a(new MatroskaExtractor());
        this.f2623f = new VarintReader();
        this.f2624g = new SparseArray();
        this.f2627j = new ParsableByteArray(4);
        this.f2628k = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f2629l = new ParsableByteArray(4);
        this.f2625h = new ParsableByteArray(NalUnitUtil.f3823a);
        this.f2626i = new ParsableByteArray(4);
        this.f2630m = new ParsableByteArray();
        this.f2631n = new ParsableByteArray();
        this.f2632o = new ParsableByteArray(8);
        this.f2633p = new ParsableByteArray();
    }

    public boolean m3219a(ExtractorInput extractorInput) {
        return new Sniffer().m3224a(extractorInput);
    }

    public void m3218a(ExtractorOutput extractorOutput) {
        this.ab = extractorOutput;
    }

    public void m3217a(long j) {
        this.f2599D = -9223372036854775807L;
        this.f2603H = 0;
        this.f2622e.m3164a();
        this.f2623f.m3228a();
        m3208b();
    }

    public void m3221c() {
    }

    public int m3211a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        this.f2621Z = false;
        boolean z = true;
        while (z && !this.f2621Z) {
            z = this.f2622e.m3166a(extractorInput);
            if (z && m3204a(positionHolder, extractorInput.m3238c())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        return -1;
    }

    int m3210a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
                return 5;
            default:
                return 0;
        }
    }

    boolean m3220b(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    void m3215a(int i, long j, long j2) {
        switch (i) {
            case 160:
                this.aa = false;
            case 174:
                this.f2640w = new MatroskaExtractor();
            case 187:
                this.f2602G = false;
            case 19899:
                this.f2642y = -1;
                this.f2643z = -1;
            case 20533:
                this.f2640w.f2570e = true;
            case 408125543:
                if (this.f2636s == -1 || this.f2636s == j) {
                    this.f2636s = j;
                    this.f2635r = j2;
                    return;
                }
                throw new ParserException("Multiple Segment elements not supported");
            case 475249515:
                this.f2600E = new LongArray();
                this.f2601F = new LongArray();
            case 524531317:
                if (!this.f2641x) {
                    if (this.f2597B != -1) {
                        this.f2596A = true;
                        return;
                    }
                    this.ab.m3727a(new SeekMap(this.f2639v));
                    this.f2641x = true;
                }
            default:
        }
    }

    void m3222c(int i) {
        switch (i) {
            case 160:
                if (this.f2603H == 2) {
                    if (!this.aa) {
                        this.f2611P |= 1;
                    }
                    m3199a((MatroskaExtractor) this.f2624g.get(this.f2609N), this.f2604I);
                    this.f2603H = 0;
                }
            case 174:
                if (this.f2624g.get(this.f2640w.f2567b) == null && MatroskaExtractor.m3205a(this.f2640w.f2566a)) {
                    this.f2640w.m3195a(this.ab, this.f2640w.f2567b);
                    this.f2624g.put(this.f2640w.f2567b, this.f2640w);
                }
                this.f2640w = null;
            case 19899:
                if (this.f2642y == -1 || this.f2643z == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                } else if (this.f2642y == 475249515) {
                    this.f2597B = this.f2643z;
                }
            case 25152:
                if (!this.f2640w.f2570e) {
                    return;
                }
                if (this.f2640w.f2572g == null) {
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
                this.f2640w.f2574i = new DrmInitData(new SchemeData(C.f2522b, "video/webm", this.f2640w.f2572g));
            case 28032:
                if (this.f2640w.f2570e && this.f2640w.f2571f != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            case 357149030:
                if (this.f2637t == -9223372036854775807L) {
                    this.f2637t = 1000000;
                }
                if (this.f2638u != -9223372036854775807L) {
                    this.f2639v = m3207b(this.f2638u);
                }
            case 374648427:
                if (this.f2624g.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.ab.m3726a();
            case 475249515:
                if (!this.f2641x) {
                    this.ab.m3727a(m3209d());
                    this.f2641x = true;
                }
            default:
        }
    }

    void m3214a(int i, long j) {
        boolean z = true;
        MatroskaExtractor matroskaExtractor;
        switch (i) {
            case 131:
                this.f2640w.f2568c = (int) j;
            case 136:
                matroskaExtractor = this.f2640w;
                if (j != 1) {
                    z = false;
                }
                matroskaExtractor.f2587v = z;
            case 155:
                this.f2605J = m3207b(j);
            case 159:
                this.f2640w.f2582q = (int) j;
            case 176:
                this.f2640w.f2575j = (int) j;
            case 179:
                this.f2600E.m4423a(m3207b(j));
            case 186:
                this.f2640w.f2576k = (int) j;
            case 215:
                this.f2640w.f2567b = (int) j;
            case 231:
                this.f2599D = m3207b(j);
            case 241:
                if (!this.f2602G) {
                    this.f2601F.m4423a(j);
                    this.f2602G = true;
                }
            case 251:
                this.aa = true;
            case 16980:
                if (j != 3) {
                    throw new ParserException("ContentCompAlgo " + j + " not supported");
                }
            case 17029:
                if (j < 1 || j > 2) {
                    throw new ParserException("DocTypeReadVersion " + j + " not supported");
                }
            case 17143:
                if (j != 1) {
                    throw new ParserException("EBMLReadVersion " + j + " not supported");
                }
            case 18401:
                if (j != 5) {
                    throw new ParserException("ContentEncAlgo " + j + " not supported");
                }
            case 18408:
                if (j != 1) {
                    throw new ParserException("AESSettingsCipherMode " + j + " not supported");
                }
            case 20529:
                if (j != 0) {
                    throw new ParserException("ContentEncodingOrder " + j + " not supported");
                }
            case 20530:
                if (j != 1) {
                    throw new ParserException("ContentEncodingScope " + j + " not supported");
                }
            case 21420:
                this.f2643z = this.f2636s + j;
            case 21432:
                switch ((int) j) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        this.f2640w.f2581p = 0;
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        this.f2640w.f2581p = 2;
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        this.f2640w.f2581p = 1;
                    default:
                }
            case 21680:
                this.f2640w.f2577l = (int) j;
            case 21682:
                this.f2640w.f2579n = (int) j;
            case 21690:
                this.f2640w.f2578m = (int) j;
            case 21930:
                matroskaExtractor = this.f2640w;
                if (j != 1) {
                    z = false;
                }
                matroskaExtractor.f2588w = z;
            case 22186:
                this.f2640w.f2585t = j;
            case 22203:
                this.f2640w.f2586u = j;
            case 25188:
                this.f2640w.f2583r = (int) j;
            case 2352003:
                this.f2640w.f2569d = (int) j;
            case 2807729:
                this.f2637t = j;
            default:
        }
    }

    void m3212a(int i, double d) {
        switch (i) {
            case 181:
                this.f2640w.f2584s = (int) d;
            case 17545:
                this.f2638u = (long) d;
            default:
        }
    }

    void m3216a(int i, String str) {
        switch (i) {
            case 134:
                this.f2640w.f2566a = str;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
            case 2274716:
                this.f2640w.f2591z = str;
            default:
        }
    }

    void m3213a(int i, int i2, ExtractorInput extractorInput) {
        switch (i) {
            case 161:
            case 163:
                if (this.f2603H == 0) {
                    this.f2609N = (int) this.f2623f.m3227a(extractorInput, false, true, 8);
                    this.f2610O = this.f2623f.m3229b();
                    this.f2605J = -9223372036854775807L;
                    this.f2603H = 1;
                    this.f2627j.m4447a();
                }
                MatroskaExtractor matroskaExtractor = (MatroskaExtractor) this.f2624g.get(this.f2609N);
                if (matroskaExtractor == null) {
                    extractorInput.m3235b(i2 - this.f2610O);
                    this.f2603H = 0;
                    return;
                }
                if (this.f2603H == 1) {
                    int i3;
                    m3200a(extractorInput, 3);
                    int i4 = (this.f2627j.f3831a[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.f2607L = 1;
                        this.f2608M = MatroskaExtractor.m3206a(this.f2608M, 1);
                        this.f2608M[0] = (i2 - this.f2610O) - 3;
                    } else if (i != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    } else {
                        m3200a(extractorInput, 4);
                        this.f2607L = (this.f2627j.f3831a[3] & MotionEventCompat.ACTION_MASK) + 1;
                        this.f2608M = MatroskaExtractor.m3206a(this.f2608M, this.f2607L);
                        if (i4 == 2) {
                            Arrays.fill(this.f2608M, 0, this.f2607L, ((i2 - this.f2610O) - 4) / this.f2607L);
                        } else if (i4 == 1) {
                            r5 = 0;
                            i3 = 4;
                            for (i4 = 0; i4 < this.f2607L - 1; i4++) {
                                this.f2608M[i4] = 0;
                                do {
                                    i3++;
                                    m3200a(extractorInput, i3);
                                    r6 = this.f2627j.f3831a[i3 - 1] & MotionEventCompat.ACTION_MASK;
                                    r7 = this.f2608M;
                                    r7[i4] = r7[i4] + r6;
                                } while (r6 == MotionEventCompat.ACTION_MASK);
                                r5 += this.f2608M[i4];
                            }
                            this.f2608M[this.f2607L - 1] = ((i2 - this.f2610O) - i3) - r5;
                        } else if (i4 == 3) {
                            r5 = 0;
                            i3 = 4;
                            i4 = 0;
                            while (i4 < this.f2607L - 1) {
                                this.f2608M[i4] = 0;
                                i3++;
                                m3200a(extractorInput, i3);
                                if (this.f2627j.f3831a[i3 - 1] == null) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                long j = 0;
                                int i5 = 0;
                                while (i5 < 8) {
                                    int i6 = 1 << (7 - i5);
                                    if ((this.f2627j.f3831a[i3 - 1] & i6) != 0) {
                                        int i7 = i3 - 1;
                                        i3 += i5;
                                        m3200a(extractorInput, i3);
                                        j = (long) ((this.f2627j.f3831a[i7] & MotionEventCompat.ACTION_MASK) & (i6 ^ -1));
                                        for (i6 = i7 + 1; i6 < i3; i6++) {
                                            j = ((long) (this.f2627j.f3831a[i6] & MotionEventCompat.ACTION_MASK)) | (j << 8);
                                        }
                                        if (i4 > 0) {
                                            j -= (1 << ((i5 * 7) + 6)) - 1;
                                        }
                                        if (j >= -2147483648L || j > 2147483647L) {
                                            throw new ParserException("EBML lacing sample size out of range.");
                                        }
                                        r6 = (int) j;
                                        r7 = this.f2608M;
                                        if (i4 != 0) {
                                            r6 += this.f2608M[i4 - 1];
                                        }
                                        r7[i4] = r6;
                                        r5 += this.f2608M[i4];
                                        i4++;
                                    } else {
                                        i5++;
                                    }
                                }
                                if (j >= -2147483648L) {
                                    break;
                                }
                                throw new ParserException("EBML lacing sample size out of range.");
                            }
                            this.f2608M[this.f2607L - 1] = ((i2 - this.f2610O) - i3) - r5;
                        } else {
                            throw new ParserException("Unexpected lacing value: " + i4);
                        }
                    }
                    this.f2604I = this.f2599D + m3207b((long) ((this.f2627j.f3831a[0] << 8) | (this.f2627j.f3831a[1] & MotionEventCompat.ACTION_MASK)));
                    Object obj = (this.f2627j.f3831a[2] & 8) == 8 ? 1 : null;
                    Object obj2 = (matroskaExtractor.f2568c == 2 || (i == 163 && (this.f2627j.f3831a[2] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS)) ? 1 : null;
                    i3 = obj2 != null ? 1 : 0;
                    if (obj != null) {
                        i4 = RtlSpacingHelper.UNDEFINED;
                    } else {
                        i4 = 0;
                    }
                    this.f2611P = i4 | i3;
                    this.f2603H = 2;
                    this.f2606K = 0;
                }
                if (i == 163) {
                    while (this.f2606K < this.f2607L) {
                        m3201a(extractorInput, matroskaExtractor, this.f2608M[this.f2606K]);
                        m3199a(matroskaExtractor, this.f2604I + ((long) ((this.f2606K * matroskaExtractor.f2569d) / PointerIconCompat.TYPE_DEFAULT)));
                        this.f2606K++;
                    }
                    this.f2603H = 0;
                    return;
                }
                m3201a(extractorInput, matroskaExtractor, this.f2608M[0]);
            case 16981:
                this.f2640w.f2571f = new byte[i2];
                extractorInput.m3236b(this.f2640w.f2571f, 0, i2);
            case 18402:
                this.f2640w.f2572g = new byte[i2];
                extractorInput.m3236b(this.f2640w.f2572g, 0, i2);
            case 21419:
                Arrays.fill(this.f2629l.f3831a, (byte) 0);
                extractorInput.m3236b(this.f2629l.f3831a, 4 - i2, i2);
                this.f2629l.m4455c(0);
                this.f2642y = (int) this.f2629l.m4466l();
            case 25506:
                this.f2640w.f2573h = new byte[i2];
                extractorInput.m3236b(this.f2640w.f2573h, 0, i2);
            case 30322:
                this.f2640w.f2580o = new byte[i2];
                extractorInput.m3236b(this.f2640w.f2580o, 0, i2);
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    private void m3199a(MatroskaExtractor matroskaExtractor, long j) {
        if ("S_TEXT/UTF8".equals(matroskaExtractor.f2566a)) {
            m3198a(matroskaExtractor);
        }
        matroskaExtractor.f2589x.m3425a(j, this.f2611P, this.f2620Y, 0, matroskaExtractor.f2572g);
        this.f2621Z = true;
        m3208b();
    }

    private void m3208b() {
        this.f2612Q = 0;
        this.f2620Y = 0;
        this.f2619X = 0;
        this.f2613R = false;
        this.f2614S = false;
        this.f2616U = false;
        this.f2618W = 0;
        this.f2617V = (byte) 0;
        this.f2615T = false;
        this.f2630m.m4447a();
    }

    private void m3200a(ExtractorInput extractorInput, int i) {
        if (this.f2627j.m4454c() < i) {
            if (this.f2627j.m4458e() < i) {
                this.f2627j.m4450a(Arrays.copyOf(this.f2627j.f3831a, Math.max(this.f2627j.f3831a.length * 2, i)), this.f2627j.m4454c());
            }
            extractorInput.m3236b(this.f2627j.f3831a, this.f2627j.m4454c(), i - this.f2627j.m4454c());
            this.f2627j.m4453b(i);
        }
    }

    private void m3201a(ExtractorInput extractorInput, MatroskaExtractor matroskaExtractor, int i) {
        int length;
        if ("S_TEXT/UTF8".equals(matroskaExtractor.f2566a)) {
            length = f2593b.length + i;
            if (this.f2631n.m4458e() < length) {
                this.f2631n.f3831a = Arrays.copyOf(f2593b, length + i);
            }
            extractorInput.m3236b(this.f2631n.f3831a, f2593b.length, i);
            this.f2631n.m4455c(0);
            this.f2631n.m4453b(length);
            return;
        }
        int t;
        TrackOutput trackOutput = matroskaExtractor.f2589x;
        if (!this.f2613R) {
            if (matroskaExtractor.f2570e) {
                this.f2611P &= -1073741825;
                if (!this.f2614S) {
                    extractorInput.m3236b(this.f2627j.f3831a, 0, 1);
                    this.f2612Q++;
                    if ((this.f2627j.f3831a[0] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                        throw new ParserException("Extension bit is set in signal byte");
                    }
                    this.f2617V = this.f2627j.f3831a[0];
                    this.f2614S = true;
                }
                if ((this.f2617V & 1) == 1) {
                    boolean z;
                    int i2;
                    if ((this.f2617V & 2) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.f2611P |= 1073741824;
                    if (!this.f2615T) {
                        extractorInput.m3236b(this.f2632o.f3831a, 0, 8);
                        this.f2612Q += 8;
                        this.f2615T = true;
                        byte[] bArr = this.f2627j.f3831a;
                        if (z) {
                            i2 = AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
                        } else {
                            i2 = 0;
                        }
                        bArr[0] = (byte) (i2 | 8);
                        this.f2627j.m4455c(0);
                        trackOutput.m3427a(this.f2627j, 1);
                        this.f2620Y++;
                        this.f2632o.m4455c(0);
                        trackOutput.m3427a(this.f2632o, 8);
                        this.f2620Y += 8;
                    }
                    if (z) {
                        if (!this.f2616U) {
                            extractorInput.m3236b(this.f2627j.f3831a, 0, 1);
                            this.f2612Q++;
                            this.f2627j.m4455c(0);
                            this.f2618W = this.f2627j.m4461g();
                            this.f2616U = true;
                        }
                        length = this.f2618W * 4;
                        this.f2627j.m4448a(length);
                        extractorInput.m3236b(this.f2627j.f3831a, 0, length);
                        this.f2612Q = length + this.f2612Q;
                        short s = (short) ((this.f2618W / 2) + 1);
                        int i3 = (s * 6) + 2;
                        if (this.f2634q == null || this.f2634q.capacity() < i3) {
                            this.f2634q = ByteBuffer.allocate(i3);
                        }
                        this.f2634q.position(0);
                        this.f2634q.putShort(s);
                        length = 0;
                        i2 = 0;
                        while (length < this.f2618W) {
                            t = this.f2627j.m4474t();
                            if (length % 2 == 0) {
                                this.f2634q.putShort((short) (t - i2));
                            } else {
                                this.f2634q.putInt(t - i2);
                            }
                            length++;
                            i2 = t;
                        }
                        length = (i - this.f2612Q) - i2;
                        if (this.f2618W % 2 == 1) {
                            this.f2634q.putInt(length);
                        } else {
                            this.f2634q.putShort((short) length);
                            this.f2634q.putInt(0);
                        }
                        this.f2633p.m4450a(this.f2634q.array(), i3);
                        trackOutput.m3427a(this.f2633p, i3);
                        this.f2620Y += i3;
                    }
                }
            } else if (matroskaExtractor.f2571f != null) {
                this.f2630m.m4450a(matroskaExtractor.f2571f, matroskaExtractor.f2571f.length);
            }
            this.f2613R = true;
        }
        length = this.f2630m.m4454c() + i;
        if ("V_MPEG4/ISO/AVC".equals(matroskaExtractor.f2566a) || "V_MPEGH/ISO/HEVC".equals(matroskaExtractor.f2566a)) {
            byte[] bArr2 = this.f2626i.f3831a;
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            bArr2[2] = (byte) 0;
            int i4 = matroskaExtractor.f2590y;
            t = 4 - matroskaExtractor.f2590y;
            while (this.f2612Q < length) {
                if (this.f2619X == 0) {
                    m3202a(extractorInput, bArr2, t, i4);
                    this.f2626i.m4455c(0);
                    this.f2619X = this.f2626i.m4474t();
                    this.f2625h.m4455c(0);
                    trackOutput.m3427a(this.f2625h, 4);
                    this.f2620Y += 4;
                } else {
                    this.f2619X -= m3196a(extractorInput, trackOutput, this.f2619X);
                }
            }
        } else {
            while (this.f2612Q < length) {
                m3196a(extractorInput, trackOutput, length - this.f2612Q);
            }
        }
        if ("A_VORBIS".equals(matroskaExtractor.f2566a)) {
            this.f2628k.m4455c(0);
            trackOutput.m3427a(this.f2628k, 4);
            this.f2620Y += 4;
        }
    }

    private void m3198a(MatroskaExtractor matroskaExtractor) {
        MatroskaExtractor.m3203a(this.f2631n.f3831a, this.f2605J);
        matroskaExtractor.f2589x.m3427a(this.f2631n, this.f2631n.m4454c());
        this.f2620Y += this.f2631n.m4454c();
    }

    private static void m3203a(byte[] bArr, long j) {
        Object obj;
        if (j == -9223372036854775807L) {
            obj = f2594c;
        } else {
            long j2 = j - (((long) ((int) (j / 3600000000L))) * 3600000000L);
            j2 -= (long) (60000000 * ((int) (j2 / 60000000)));
            int i = (int) ((j2 - ((long) (1000000 * ((int) (j2 / 1000000))))) / 1000);
            obj = Util.m4522c(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf((int) (j / 3600000000L)), Integer.valueOf(r1), Integer.valueOf(r4), Integer.valueOf(i)}));
        }
        System.arraycopy(obj, 0, bArr, 19, 12);
    }

    private void m3202a(ExtractorInput extractorInput, byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.f2630m.m4452b());
        extractorInput.m3236b(bArr, i + min, i2 - min);
        if (min > 0) {
            this.f2630m.m4451a(bArr, i, min);
        }
        this.f2612Q += i2;
    }

    private int m3196a(ExtractorInput extractorInput, TrackOutput trackOutput, int i) {
        int b = this.f2630m.m4452b();
        if (b > 0) {
            b = Math.min(i, b);
            trackOutput.m3427a(this.f2630m, b);
        } else {
            b = trackOutput.m3424a(extractorInput, i, false);
        }
        this.f2612Q += b;
        this.f2620Y += b;
        return b;
    }

    private com.google.android.exoplayer2.p052c.SeekMap m3209d() {
        int i = 0;
        if (this.f2636s == -1 || this.f2639v == -9223372036854775807L || this.f2600E == null || this.f2600E.m4421a() == 0 || this.f2601F == null || this.f2601F.m4421a() != this.f2600E.m4421a()) {
            this.f2600E = null;
            this.f2601F = null;
            return new SeekMap(this.f2639v);
        }
        int a = this.f2600E.m4421a();
        int[] iArr = new int[a];
        long[] jArr = new long[a];
        long[] jArr2 = new long[a];
        long[] jArr3 = new long[a];
        for (int i2 = 0; i2 < a; i2++) {
            jArr3[i2] = this.f2600E.m4422a(i2);
            jArr[i2] = this.f2636s + this.f2601F.m4422a(i2);
        }
        while (i < a - 1) {
            iArr[i] = (int) (jArr[i + 1] - jArr[i]);
            jArr2[i] = jArr3[i + 1] - jArr3[i];
            i++;
        }
        iArr[a - 1] = (int) ((this.f2636s + this.f2635r) - jArr[a - 1]);
        jArr2[a - 1] = this.f2639v - jArr3[a - 1];
        this.f2600E = null;
        this.f2601F = null;
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    private boolean m3204a(PositionHolder positionHolder, long j) {
        if (this.f2596A) {
            this.f2598C = j;
            positionHolder.f3266a = this.f2597B;
            this.f2596A = false;
            return true;
        } else if (!this.f2641x || this.f2598C == -1) {
            return false;
        } else {
            positionHolder.f3266a = this.f2598C;
            this.f2598C = -1;
            return true;
        }
    }

    private long m3207b(long j) {
        if (this.f2637t == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return Util.m4510a(j, this.f2637t, 1000);
    }

    private static boolean m3205a(String str) {
        if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str)) {
            return true;
        }
        return false;
    }

    private static int[] m3206a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length < i ? new int[Math.max(iArr.length * 2, i)] : iArr;
    }
}
