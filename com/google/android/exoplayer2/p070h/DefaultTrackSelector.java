package com.google.android.exoplayer2.p070h;

import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p062f.TrackGroup;
import com.google.android.exoplayer2.p062f.TrackGroupArray;
import com.google.android.exoplayer2.p070h.TrackSelection.TrackSelection;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.h.c */
public class DefaultTrackSelector extends MappingTrackSelector {
    private static final int[] f3643a;
    private final TrackSelection f3644b;
    private final AtomicReference<DefaultTrackSelector> f3645c;

    /* renamed from: com.google.android.exoplayer2.h.c.a */
    public static final class DefaultTrackSelector {
        public final String f3627a;
        public final String f3628b;
        public final boolean f3629c;
        public final boolean f3630d;
        public final int f3631e;
        public final int f3632f;
        public final boolean f3633g;
        public final int f3634h;
        public final int f3635i;
        public final boolean f3636j;

        public DefaultTrackSelector() {
            this(null, null, false, true, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true);
        }

        public DefaultTrackSelector(String str, String str2, boolean z, boolean z2, int i, int i2, boolean z3, int i3, int i4, boolean z4) {
            this.f3627a = str;
            this.f3628b = str2;
            this.f3629c = z;
            this.f3630d = z2;
            this.f3631e = i;
            this.f3632f = i2;
            this.f3633g = z3;
            this.f3634h = i3;
            this.f3635i = i4;
            this.f3636j = z4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DefaultTrackSelector defaultTrackSelector = (DefaultTrackSelector) obj;
            if (this.f3629c == defaultTrackSelector.f3629c && this.f3630d == defaultTrackSelector.f3630d && this.f3631e == defaultTrackSelector.f3631e && this.f3632f == defaultTrackSelector.f3632f && this.f3633g == defaultTrackSelector.f3633g && this.f3636j == defaultTrackSelector.f3636j && this.f3634h == defaultTrackSelector.f3634h && this.f3635i == defaultTrackSelector.f3635i && TextUtils.equals(this.f3627a, defaultTrackSelector.f3627a) && TextUtils.equals(this.f3628b, defaultTrackSelector.f3628b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 1;
            int hashCode = ((this.f3629c ? 1 : 0) + (((this.f3627a.hashCode() * 31) + this.f3628b.hashCode()) * 31)) * 31;
            if (this.f3630d) {
                i = 1;
            } else {
                i = 0;
            }
            hashCode = (((((i + hashCode) * 31) + this.f3631e) * 31) + this.f3632f) * 31;
            if (this.f3633g) {
                i = 1;
            } else {
                i = 0;
            }
            i = (i + hashCode) * 31;
            if (!this.f3636j) {
                i2 = 0;
            }
            return ((((i + i2) * 31) + this.f3634h) * 31) + this.f3635i;
        }
    }

    static {
        f3643a = new int[0];
    }

    public DefaultTrackSelector(Handler handler, TrackSelection trackSelection) {
        super(handler);
        this.f3644b = trackSelection;
        this.f3645c = new AtomicReference(new DefaultTrackSelector());
    }

    protected TrackSelection[] m4278a(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) {
        TrackSelection[] trackSelectionArr = new TrackSelection[rendererCapabilitiesArr.length];
        DefaultTrackSelector defaultTrackSelector = (DefaultTrackSelector) this.f3645c.get();
        for (int i = 0; i < rendererCapabilitiesArr.length; i++) {
            switch (rendererCapabilitiesArr[i].m2979a()) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    trackSelectionArr[i] = m4275a(trackGroupArrayArr[i], iArr[i], defaultTrackSelector.f3627a);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    trackSelectionArr[i] = m4277a(rendererCapabilitiesArr[i], trackGroupArrayArr[i], iArr[i], defaultTrackSelector.f3631e, defaultTrackSelector.f3632f, defaultTrackSelector.f3630d, defaultTrackSelector.f3629c, defaultTrackSelector.f3634h, defaultTrackSelector.f3635i, defaultTrackSelector.f3636j, this.f3644b, defaultTrackSelector.f3633g);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    trackSelectionArr[i] = m4276a(trackGroupArrayArr[i], iArr[i], defaultTrackSelector.f3628b, defaultTrackSelector.f3627a);
                    break;
                default:
                    trackSelectionArr[i] = m4274a(rendererCapabilitiesArr[i].m2979a(), trackGroupArrayArr[i], iArr[i]);
                    break;
            }
        }
        return trackSelectionArr;
    }

    protected TrackSelection m4277a(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, int i, int i2, boolean z, boolean z2, int i3, int i4, boolean z3, TrackSelection trackSelection, boolean z4) {
        TrackSelection trackSelection2 = null;
        if (trackSelection != null) {
            trackSelection2 = DefaultTrackSelector.m4267a(rendererCapabilities, trackGroupArray, iArr, i, i2, z, z2, i3, i4, z3, trackSelection);
        }
        if (trackSelection2 == null) {
            return DefaultTrackSelector.m4266a(trackGroupArray, iArr, i, i2, i3, i4, z3, z4);
        }
        return trackSelection2;
    }

    private static TrackSelection m4267a(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, int i, int i2, boolean z, boolean z2, int i3, int i4, boolean z3, TrackSelection trackSelection) {
        int i5 = z ? 12 : 8;
        boolean z4 = z2 && (rendererCapabilities.m2981l() & i5) != 0;
        for (int i6 = 0; i6 < trackGroupArray.f3405a; i6++) {
            TrackGroup a = trackGroupArray.m3958a(i6);
            int[] a2 = DefaultTrackSelector.m4272a(a, iArr[i6], z4, i5, i, i2, i3, i4, z3);
            if (a2.length > 0) {
                return trackSelection.m4238b(a, a2);
            }
        }
        return null;
    }

    private static int[] m4272a(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, boolean z2) {
        if (trackGroup.f3402a < 2) {
            return f3643a;
        }
        List a = DefaultTrackSelector.m4268a(trackGroup, i4, i5, z2);
        if (a.size() < 2) {
            return f3643a;
        }
        String str;
        String str2 = null;
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            int i6 = 0;
            int i7 = 0;
            while (i7 < a.size()) {
                int a2;
                str = trackGroup.m3956a(((Integer) a.get(i7)).intValue()).f2324e;
                if (!hashSet.contains(str)) {
                    hashSet.add(str);
                    a2 = DefaultTrackSelector.m4264a(trackGroup, iArr, i, str, i2, i3, a);
                    if (a2 > i6) {
                        i7++;
                        i6 = a2;
                        str2 = str;
                    }
                }
                a2 = i6;
                str = str2;
                i7++;
                i6 = a2;
                str2 = str;
            }
            str = str2;
        }
        DefaultTrackSelector.m4273b(trackGroup, iArr, i, str, i2, i3, a);
        return a.size() < 2 ? f3643a : Util.m4518a(a);
    }

    private static int m4264a(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, List<Integer> list) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < list.size()) {
            int intValue = ((Integer) list.get(i4)).intValue();
            if (DefaultTrackSelector.m4271a(trackGroup.m3956a(intValue), str, iArr[intValue], i, i2, i3)) {
                intValue = i5 + 1;
            } else {
                intValue = i5;
            }
            i4++;
            i5 = intValue;
        }
        return i5;
    }

    private static void m4273b(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!DefaultTrackSelector.m4271a(trackGroup.m3956a(intValue), str, iArr[intValue], i, i2, i3)) {
                list.remove(size);
            }
        }
    }

    private static boolean m4271a(Format format, String str, int i, int i2, int i3, int i4) {
        return DefaultTrackSelector.m4269a(i) && (i & i2) != 0 && ((str == null || Util.m4517a(format.f2324e, (Object) str)) && ((format.f2328i == -1 || format.f2328i <= i3) && (format.f2329j == -1 || format.f2329j <= i4)));
    }

    private static TrackSelection m4266a(TrackGroupArray trackGroupArray, int[][] iArr, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        TrackGroup trackGroup = null;
        int i5 = 0;
        int i6 = -1;
        Object obj = null;
        for (int i7 = 0; i7 < trackGroupArray.f3405a; i7++) {
            TrackGroup a = trackGroupArray.m3958a(i7);
            List a2 = DefaultTrackSelector.m4268a(a, i3, i4, z);
            int[] iArr2 = iArr[i7];
            int i8 = 0;
            while (i8 < a.f3402a) {
                Object obj2;
                int a3;
                int i9;
                TrackGroup trackGroup2;
                if (DefaultTrackSelector.m4269a(iArr2[i8])) {
                    Format a4 = a.m3956a(i8);
                    obj2 = (!a2.contains(Integer.valueOf(i8)) || ((a4.f2328i != -1 && a4.f2328i > i) || (a4.f2329j != -1 && a4.f2329j > i2))) ? null : 1;
                    a3 = a4.m2870a();
                    Object obj3 = obj != null ? (obj2 == null || DefaultTrackSelector.m4263a(a3, i6) <= 0) ? null : 1 : (obj2 != null || (z2 && (trackGroup == null || DefaultTrackSelector.m4263a(a3, i6) < 0))) ? 1 : null;
                    if (obj3 != null) {
                        i9 = a3;
                        trackGroup2 = a;
                        a3 = i8;
                        i8++;
                        i5 = a3;
                        trackGroup = trackGroup2;
                        i6 = i9;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                a3 = i5;
                i9 = i6;
                trackGroup2 = trackGroup;
                i8++;
                i5 = a3;
                trackGroup = trackGroup2;
                i6 = i9;
                obj = obj2;
            }
        }
        return trackGroup == null ? null : new FixedTrackSelection(trackGroup, i5);
    }

    private static int m4263a(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    protected TrackSelection m4275a(TrackGroupArray trackGroupArray, int[][] iArr, String str) {
        Object obj = null;
        int i = 0;
        TrackGroup trackGroup = null;
        for (int i2 = 0; i2 < trackGroupArray.f3405a; i2++) {
            TrackGroup a = trackGroupArray.m3958a(i2);
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < a.f3402a) {
                Object obj2;
                int i4;
                TrackGroup trackGroup2;
                if (DefaultTrackSelector.m4269a(iArr2[i3])) {
                    Format a2 = a.m3956a(i3);
                    if ((a2.f2341v & 1) != 0) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (DefaultTrackSelector.m4270a(a2, str)) {
                        obj2 = obj2 != null ? 4 : 3;
                    } else if (obj2 != null) {
                        obj2 = 2;
                    } else {
                        int i5 = 1;
                    }
                    if (obj2 > obj) {
                        i4 = i3;
                        trackGroup2 = a;
                        i3++;
                        trackGroup = trackGroup2;
                        i = i4;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                i4 = i;
                trackGroup2 = trackGroup;
                i3++;
                trackGroup = trackGroup2;
                i = i4;
                obj = obj2;
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i);
    }

    protected TrackSelection m4276a(TrackGroupArray trackGroupArray, int[][] iArr, String str, String str2) {
        TrackGroup trackGroup = null;
        int i = 0;
        Object obj = null;
        for (int i2 = 0; i2 < trackGroupArray.f3405a; i2++) {
            TrackGroup a = trackGroupArray.m3958a(i2);
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < a.f3402a) {
                Object obj2;
                int i4;
                TrackGroup trackGroup2;
                if (DefaultTrackSelector.m4269a(iArr2[i3])) {
                    Format a2 = a.m3956a(i3);
                    obj2 = (a2.f2341v & 1) != 0 ? 1 : null;
                    Object obj3 = (a2.f2341v & 2) != 0 ? 1 : null;
                    if (DefaultTrackSelector.m4270a(a2, str)) {
                        if (obj2 != null) {
                            obj2 = 6;
                        } else if (obj3 == null) {
                            obj2 = 5;
                        } else {
                            obj2 = 4;
                        }
                    } else if (obj2 != null) {
                        obj2 = 3;
                    } else if (obj3 == null) {
                        obj2 = null;
                    } else if (DefaultTrackSelector.m4270a(a2, str2)) {
                        obj2 = 2;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 > obj) {
                        i4 = i3;
                        trackGroup2 = a;
                        i3++;
                        trackGroup = trackGroup2;
                        i = i4;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                i4 = i;
                trackGroup2 = trackGroup;
                i3++;
                trackGroup = trackGroup2;
                i = i4;
                obj = obj2;
            }
        }
        return trackGroup == null ? null : new FixedTrackSelection(trackGroup, i);
    }

    protected TrackSelection m4274a(int i, TrackGroupArray trackGroupArray, int[][] iArr) {
        Object obj = null;
        int i2 = 0;
        TrackGroup trackGroup = null;
        for (int i3 = 0; i3 < trackGroupArray.f3405a; i3++) {
            TrackGroup a = trackGroupArray.m3958a(i3);
            int[] iArr2 = iArr[i3];
            int i4 = 0;
            while (i4 < a.f3402a) {
                Object obj2;
                int i5;
                TrackGroup trackGroup2;
                if (DefaultTrackSelector.m4269a(iArr2[i4])) {
                    if ((a.m3956a(i4).f2341v & 1) != 0) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        obj2 = 2;
                    } else {
                        int i6 = 1;
                    }
                    if (obj2 > obj) {
                        i5 = i4;
                        trackGroup2 = a;
                        i4++;
                        trackGroup = trackGroup2;
                        i2 = i5;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                i5 = i2;
                trackGroup2 = trackGroup;
                i4++;
                trackGroup = trackGroup2;
                i2 = i5;
                obj = obj2;
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i2);
    }

    private static boolean m4269a(int i) {
        return (i & 3) == 3;
    }

    private static boolean m4270a(Format format, String str) {
        return str != null && str.equals(Util.m4521b(format.f2342w));
    }

    private static List<Integer> m4268a(TrackGroup trackGroup, int i, int i2, boolean z) {
        int i3;
        int i4 = 0;
        ArrayList arrayList = new ArrayList(trackGroup.f3402a);
        for (i3 = 0; i3 < trackGroup.f3402a; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED || i2 == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return arrayList;
        }
        int i5 = Integer.MAX_VALUE;
        while (i4 < trackGroup.f3402a) {
            Format a = trackGroup.m3956a(i4);
            if (a.f2328i > 0 && a.f2329j > 0) {
                Point a2 = DefaultTrackSelector.m4265a(z, i, i2, a.f2328i, a.f2329j);
                i3 = a.f2328i * a.f2329j;
                if (a.f2328i >= ((int) (((float) a2.x) * 0.98f)) && a.f2329j >= ((int) (((float) a2.y) * 0.98f)) && i3 < i5) {
                    i4++;
                    i5 = i3;
                }
            }
            i3 = i5;
            i4++;
            i5 = i3;
        }
        if (i5 != Integer.MAX_VALUE) {
            for (i4 = arrayList.size() - 1; i4 >= 0; i4--) {
                i3 = trackGroup.m3956a(((Integer) arrayList.get(i4)).intValue()).m2870a();
                if (i3 == -1 || i3 > i5) {
                    arrayList.remove(i4);
                }
            }
        }
        return arrayList;
    }

    private static Point m4265a(boolean z, int i, int i2, int i3, int i4) {
        Object obj = 1;
        if (z) {
            Object obj2 = i3 > i4 ? 1 : null;
            if (i <= i2) {
                obj = null;
            }
            if (obj2 != obj) {
                int i5 = i;
                i = i2;
                i2 = i5;
            }
        }
        if (i3 * i2 >= i4 * i) {
            return new Point(i, Util.m4507a(i * i4, i3));
        }
        return new Point(Util.m4507a(i2 * i3, i4), i2);
    }
}
