package com.google.android.exoplayer2.p052c;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.c */
public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static List<Class<? extends Extractor>> f2686a;

    public DefaultExtractorsFactory() {
        synchronized (DefaultExtractorsFactory.class) {
            if (f2686a == null) {
                List arrayList = new ArrayList();
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.b.d").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.d.e").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e2) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.d.f").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e3) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.c.c").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e4) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.f.c").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e5) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.f.a").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e6) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.f.p").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e7) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.a.b").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e8) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.e.c").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e9) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.f.n").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e10) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.c.g.a").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e11) {
                }
                try {
                    arrayList.add(Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class));
                } catch (ClassNotFoundException e12) {
                }
                f2686a = arrayList;
            }
        }
    }

    public Extractor[] m3295a() {
        Extractor[] extractorArr = new Extractor[f2686a.size()];
        int i = 0;
        while (i < extractorArr.length) {
            try {
                extractorArr[i] = (Extractor) ((Class) f2686a.get(i)).getConstructor(new Class[0]).newInstance(new Object[0]);
                i++;
            } catch (Throwable e) {
                throw new IllegalStateException("Unexpected error creating default extractor", e);
            }
        }
        return extractorArr;
    }
}
