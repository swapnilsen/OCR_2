package com.google.android.exoplayer2.p064g.p067c;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: com.google.android.exoplayer2.g.c.b */
final class TtmlNode {
    public final String f3461a;
    public final String f3462b;
    public final boolean f3463c;
    public final long f3464d;
    public final long f3465e;
    public final TtmlStyle f3466f;
    public final String f3467g;
    private final String[] f3468h;
    private final HashMap<String, Integer> f3469i;
    private final HashMap<String, Integer> f3470j;
    private List<TtmlNode> f3471k;

    public static TtmlNode m4051a(String str) {
        return new TtmlNode(null, TtmlRenderUtil.m4064a(str), -9223372036854775807L, -9223372036854775807L, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
    }

    public static TtmlNode m4052a(String str, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str2) {
        return new TtmlNode(str, null, j, j2, ttmlStyle, strArr, str2);
    }

    private TtmlNode(String str, String str2, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str3) {
        this.f3461a = str;
        this.f3462b = str2;
        this.f3466f = ttmlStyle;
        this.f3468h = strArr;
        this.f3463c = str2 != null;
        this.f3464d = j;
        this.f3465e = j2;
        this.f3467g = (String) Assertions.m4402a((Object) str3);
        this.f3469i = new HashMap();
        this.f3470j = new HashMap();
    }

    public boolean m4061a(long j) {
        return (this.f3464d == -9223372036854775807L && this.f3465e == -9223372036854775807L) || ((this.f3464d <= j && this.f3465e == -9223372036854775807L) || ((this.f3464d == -9223372036854775807L && j < this.f3465e) || (this.f3464d <= j && j < this.f3465e)));
    }

    public void m4060a(TtmlNode ttmlNode) {
        if (this.f3471k == null) {
            this.f3471k = new ArrayList();
        }
        this.f3471k.add(ttmlNode);
    }

    public TtmlNode m4058a(int i) {
        if (this.f3471k != null) {
            return (TtmlNode) this.f3471k.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int m4057a() {
        return this.f3471k == null ? 0 : this.f3471k.size();
    }

    public long[] m4062b() {
        TreeSet treeSet = new TreeSet();
        m4056a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            jArr[i] = ((Long) it.next()).longValue();
            i = i2;
        }
        return jArr;
    }

    private void m4056a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f3461a);
        if (z || equals) {
            if (this.f3464d != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f3464d));
            }
            if (this.f3465e != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f3465e));
            }
        }
        if (this.f3471k != null) {
            for (int i = 0; i < this.f3471k.size(); i++) {
                boolean z2;
                TtmlNode ttmlNode = (TtmlNode) this.f3471k.get(i);
                if (z || equals) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ttmlNode.m4056a((TreeSet) treeSet, z2);
            }
        }
    }

    public List<Cue> m4059a(long j, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        Map treeMap = new TreeMap();
        m4053a(j, false, this.f3467g, treeMap);
        m4055a((Map) map, treeMap);
        List<Cue> arrayList = new ArrayList();
        for (Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion = (TtmlRegion) map2.get(entry.getKey());
            arrayList.add(new Cue(m4049a((SpannableStringBuilder) entry.getValue()), null, ttmlRegion.f3473b, ttmlRegion.f3474c, RtlSpacingHelper.UNDEFINED, ttmlRegion.f3472a, RtlSpacingHelper.UNDEFINED, ttmlRegion.f3475d));
        }
        return arrayList;
    }

    private void m4053a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.f3469i.clear();
        this.f3470j.clear();
        String str2 = this.f3467g;
        if (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING.equals(str2)) {
            str2 = str;
        }
        if (this.f3463c && z) {
            TtmlNode.m4050a(str2, (Map) map).append(this.f3462b);
        } else if ("br".equals(this.f3461a) && z) {
            TtmlNode.m4050a(str2, (Map) map).append('\n');
        } else if (!"metadata".equals(this.f3461a) && m4061a(j)) {
            boolean equals = "p".equals(this.f3461a);
            for (Entry entry : map.entrySet()) {
                this.f3469i.put(entry.getKey(), Integer.valueOf(((SpannableStringBuilder) entry.getValue()).length()));
            }
            for (int i = 0; i < m4057a(); i++) {
                boolean z2;
                TtmlNode a = m4058a(i);
                if (z || equals) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                a.m4053a(j, z2, str2, (Map) map);
            }
            if (equals) {
                TtmlRenderUtil.m4065a(TtmlNode.m4050a(str2, (Map) map));
            }
            for (Entry entry2 : map.entrySet()) {
                this.f3470j.put(entry2.getKey(), Integer.valueOf(((SpannableStringBuilder) entry2.getValue()).length()));
            }
        }
    }

    private static SpannableStringBuilder m4050a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return (SpannableStringBuilder) map.get(str);
    }

    private void m4055a(Map<String, TtmlStyle> map, Map<String, SpannableStringBuilder> map2) {
        for (Entry entry : this.f3470j.entrySet()) {
            int intValue;
            String str = (String) entry.getKey();
            if (this.f3469i.containsKey(str)) {
                intValue = ((Integer) this.f3469i.get(str)).intValue();
            } else {
                intValue = 0;
            }
            m4054a((Map) map, (SpannableStringBuilder) map2.get(str), intValue, ((Integer) entry.getValue()).intValue());
            for (int i = 0; i < m4057a(); i++) {
                m4058a(i).m4055a((Map) map, (Map) map2);
            }
        }
    }

    private void m4054a(Map<String, TtmlStyle> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i != i2) {
            TtmlStyle a = TtmlRenderUtil.m4063a(this.f3466f, this.f3468h, map);
            if (a != null) {
                TtmlRenderUtil.m4066a(spannableStringBuilder, i, i2, a);
            }
        }
    }

    private SpannableStringBuilder m4049a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int length = spannableStringBuilder.length();
        int i2 = 0;
        while (i2 < length) {
            if (spannableStringBuilder.charAt(i2) == ' ') {
                i = i2 + 1;
                while (i < spannableStringBuilder.length() && spannableStringBuilder.charAt(i) == ' ') {
                    i++;
                }
                i -= i2 + 1;
                if (i > 0) {
                    spannableStringBuilder.delete(i2, i2 + i);
                    i = length - i;
                    i2++;
                    length = i;
                }
            }
            i = length;
            i2++;
            length = i;
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        i = length;
        length = 0;
        while (length < i - 1) {
            if (spannableStringBuilder.charAt(length) == '\n' && spannableStringBuilder.charAt(length + 1) == ' ') {
                spannableStringBuilder.delete(length + 1, length + 2);
                i--;
            }
            length++;
        }
        if (i > 0 && spannableStringBuilder.charAt(i - 1) == ' ') {
            spannableStringBuilder.delete(i - 1, i);
            i--;
        }
        length = 0;
        while (length < i - 1) {
            if (spannableStringBuilder.charAt(length) == ' ' && spannableStringBuilder.charAt(length + 1) == '\n') {
                spannableStringBuilder.delete(length, length + 1);
                i--;
            }
            length++;
        }
        if (i > 0 && spannableStringBuilder.charAt(i - 1) == '\n') {
            spannableStringBuilder.delete(i - 1, i);
        }
        return spannableStringBuilder;
    }
}
