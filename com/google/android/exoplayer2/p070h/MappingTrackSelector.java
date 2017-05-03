package com.google.android.exoplayer2.p070h;

import android.os.Handler;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.p062f.TrackGroup;
import com.google.android.exoplayer2.p062f.TrackGroupArray;
import com.google.android.exoplayer2.p070h.TrackSelection.TrackSelection;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.h.e */
public abstract class MappingTrackSelector extends TrackSelector<MappingTrackSelector> {
    private final SparseArray<Map<TrackGroupArray, MappingTrackSelector>> f3641a;
    private final SparseBooleanArray f3642b;

    /* renamed from: com.google.android.exoplayer2.h.e.a */
    public static final class MappingTrackSelector {
        private final int[] f3648a;
        private final TrackGroupArray[] f3649b;
        private final int[] f3650c;
        private final int[][][] f3651d;
        private final TrackGroupArray f3652e;
        private final int f3653f;

        MappingTrackSelector(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f3648a = iArr;
            this.f3649b = trackGroupArrayArr;
            this.f3651d = iArr3;
            this.f3650c = iArr2;
            this.f3652e = trackGroupArray;
            this.f3653f = trackGroupArrayArr.length;
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.e.b */
    public static final class MappingTrackSelector {
        public final TrackSelection f3654a;
        public final int f3655b;
        public final int[] f3656c;

        public TrackSelection m4279a(TrackGroupArray trackGroupArray) {
            return this.f3654a.m4238b(trackGroupArray.m3958a(this.f3655b), this.f3656c);
        }
    }

    protected abstract TrackSelection[] m4262a(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr);

    public MappingTrackSelector(Handler handler) {
        super(handler);
        this.f3641a = new SparseArray();
        this.f3642b = new SparseBooleanArray();
    }

    public final TrackSelections<MappingTrackSelector> m4261a(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) {
        int i;
        int[] iArr;
        int i2 = 0;
        int[] iArr2 = new int[(rendererCapabilitiesArr.length + 1)];
        TrackGroup[][] trackGroupArr = new TrackGroup[(rendererCapabilitiesArr.length + 1)][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr.length + 1)][][];
        for (i = 0; i < trackGroupArr.length; i++) {
            trackGroupArr[i] = new TrackGroup[trackGroupArray.f3405a];
            iArr3[i] = new int[trackGroupArray.f3405a][];
        }
        int[] a = MappingTrackSelector.m4260a(rendererCapabilitiesArr);
        for (i = 0; i < trackGroupArray.f3405a; i++) {
            TrackGroup a2 = trackGroupArray.m3958a(i);
            int a3 = MappingTrackSelector.m4258a(rendererCapabilitiesArr, a2);
            if (a3 == rendererCapabilitiesArr.length) {
                iArr = new int[a2.f3402a];
            } else {
                iArr = MappingTrackSelector.m4259a(rendererCapabilitiesArr[a3], a2);
            }
            int i3 = iArr2[a3];
            trackGroupArr[a3][i3] = a2;
            iArr3[a3][i3] = iArr;
            iArr2[a3] = iArr2[a3] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        iArr = new int[rendererCapabilitiesArr.length];
        for (a3 = 0; a3 < rendererCapabilitiesArr.length; a3++) {
            i3 = iArr2[a3];
            trackGroupArrayArr[a3] = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[a3], i3));
            iArr3[a3] = (int[][]) Arrays.copyOf(iArr3[a3], i3);
            iArr[a3] = rendererCapabilitiesArr[a3].m2979a();
        }
        TrackGroupArray trackGroupArray2 = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[rendererCapabilitiesArr.length], iArr2[rendererCapabilitiesArr.length]));
        TrackSelection[] a4 = m4262a(rendererCapabilitiesArr, trackGroupArrayArr, iArr3);
        while (i2 < rendererCapabilitiesArr.length) {
            if (this.f3642b.get(i2)) {
                a4[i2] = null;
            } else {
                TrackGroupArray trackGroupArray3 = trackGroupArrayArr[i2];
                Map map = (Map) this.f3641a.get(i2);
                MappingTrackSelector mappingTrackSelector = map == null ? null : (MappingTrackSelector) map.get(trackGroupArray3);
                if (mappingTrackSelector != null) {
                    a4[i2] = mappingTrackSelector.m4279a(trackGroupArray3);
                }
            }
            i2++;
        }
        return new TrackSelections(new MappingTrackSelector(iArr, trackGroupArrayArr, a, iArr3, trackGroupArray2), a4);
    }

    private static int m4258a(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup) {
        int i = 0;
        int length = rendererCapabilitiesArr.length;
        for (int i2 = 0; i2 < rendererCapabilitiesArr.length; i2++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i2];
            int i3 = 0;
            while (i3 < trackGroup.f3402a) {
                int a = rendererCapabilities.m2980a(trackGroup.m3956a(i3));
                if (a <= i) {
                    a = length;
                    length = i;
                } else if (a == 3) {
                    return i2;
                } else {
                    length = a;
                    a = i2;
                }
                i3++;
                i = length;
                length = a;
            }
        }
        return length;
    }

    private static int[] m4259a(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) {
        int[] iArr = new int[trackGroup.f3402a];
        for (int i = 0; i < trackGroup.f3402a; i++) {
            iArr[i] = rendererCapabilities.m2980a(trackGroup.m3956a(i));
        }
        return iArr;
    }

    private static int[] m4260a(RendererCapabilities[] rendererCapabilitiesArr) {
        int[] iArr = new int[rendererCapabilitiesArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = rendererCapabilitiesArr[i].m2981l();
        }
        return iArr;
    }
}
