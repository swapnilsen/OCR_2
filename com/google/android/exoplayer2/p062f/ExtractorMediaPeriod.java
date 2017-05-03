package com.google.android.exoplayer2.p062f;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.ConditionVariable;
import com.google.android.exoplayer2.p051b.DecoderInputBuffer;
import com.google.android.exoplayer2.p052c.DefaultTrackOutput.DefaultTrackOutput;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p062f.ExtractorMediaSource.ExtractorMediaSource;
import com.google.android.exoplayer2.p062f.MediaPeriod.MediaPeriod;
import com.google.android.exoplayer2.p062f.MediaSource.MediaSource;
import com.google.android.exoplayer2.p063i.Allocator;
import com.google.android.exoplayer2.p063i.DataSource;
import com.google.android.exoplayer2.p063i.Loader.Loader;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.f.a */
final class ExtractorMediaPeriod implements DefaultTrackOutput, ExtractorOutput, MediaPeriod, Loader<ExtractorMediaPeriod> {
    private long f3355A;
    private int f3356B;
    private boolean f3357C;
    private boolean f3358D;
    private final Uri f3359a;
    private final DataSource f3360b;
    private final int f3361c;
    private final Handler f3362d;
    private final ExtractorMediaSource f3363e;
    private final MediaSource f3364f;
    private final Allocator f3365g;
    private final com.google.android.exoplayer2.p063i.Loader f3366h;
    private final ExtractorMediaPeriod f3367i;
    private final ConditionVariable f3368j;
    private final Runnable f3369k;
    private final Runnable f3370l;
    private final Handler f3371m;
    private final SparseArray<com.google.android.exoplayer2.p052c.DefaultTrackOutput> f3372n;
    private MediaPeriod f3373o;
    private SeekMap f3374p;
    private boolean f3375q;
    private boolean f3376r;
    private boolean f3377s;
    private boolean f3378t;
    private int f3379u;
    private TrackGroupArray f3380v;
    private long f3381w;
    private boolean[] f3382x;
    private long f3383y;
    private long f3384z;

    /* renamed from: com.google.android.exoplayer2.f.a.1 */
    class ExtractorMediaPeriod implements Runnable {
        final /* synthetic */ ExtractorMediaPeriod f3335a;

        ExtractorMediaPeriod(ExtractorMediaPeriod extractorMediaPeriod) {
            this.f3335a = extractorMediaPeriod;
        }

        public void run() {
            this.f3335a.m3900i();
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.a.2 */
    class ExtractorMediaPeriod implements Runnable {
        final /* synthetic */ ExtractorMediaPeriod f3336a;

        ExtractorMediaPeriod(ExtractorMediaPeriod extractorMediaPeriod) {
            this.f3336a = extractorMediaPeriod;
        }

        public void run() {
            if (!this.f3336a.f3358D) {
                this.f3336a.f3373o.m3941a(this.f3336a);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.a.3 */
    class ExtractorMediaPeriod implements Runnable {
        final /* synthetic */ ExtractorMediaPeriod f3337a;
        final /* synthetic */ ExtractorMediaPeriod f3338b;

        ExtractorMediaPeriod(ExtractorMediaPeriod extractorMediaPeriod, ExtractorMediaPeriod extractorMediaPeriod2) {
            this.f3338b = extractorMediaPeriod;
            this.f3337a = extractorMediaPeriod2;
        }

        public void run() {
            this.f3337a.m3867a();
            int size = this.f3338b.f3372n.size();
            for (int i = 0; i < size; i++) {
                ((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3338b.f3372n.valueAt(i)).m3446b();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.a.4 */
    class ExtractorMediaPeriod implements Runnable {
        final /* synthetic */ IOException f3339a;
        final /* synthetic */ ExtractorMediaPeriod f3340b;

        ExtractorMediaPeriod(ExtractorMediaPeriod extractorMediaPeriod, IOException iOException) {
            this.f3340b = extractorMediaPeriod;
            this.f3339a = iOException;
        }

        public void run() {
            this.f3340b.f3363e.m3928a(this.f3339a);
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.a.a */
    final class ExtractorMediaPeriod implements Loader {
        final /* synthetic */ ExtractorMediaPeriod f3341a;
        private final Uri f3342b;
        private final DataSource f3343c;
        private final ExtractorMediaPeriod f3344d;
        private final ConditionVariable f3345e;
        private final PositionHolder f3346f;
        private volatile boolean f3347g;
        private boolean f3348h;
        private long f3349i;

        public ExtractorMediaPeriod(ExtractorMediaPeriod extractorMediaPeriod, Uri uri, DataSource dataSource, ExtractorMediaPeriod extractorMediaPeriod2, ConditionVariable conditionVariable) {
            this.f3341a = extractorMediaPeriod;
            this.f3342b = (Uri) Assertions.m4402a((Object) uri);
            this.f3343c = (DataSource) Assertions.m4402a((Object) dataSource);
            this.f3344d = (ExtractorMediaPeriod) Assertions.m4402a((Object) extractorMediaPeriod2);
            this.f3345e = conditionVariable;
            this.f3346f = new PositionHolder();
            this.f3348h = true;
            this.f3349i = -1;
        }

        public void m3863a(long j) {
            this.f3346f.f3266a = j;
            this.f3348h = true;
        }

        public void m3862a() {
            this.f3347g = true;
        }

        public boolean m3864b() {
            return this.f3347g;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m3865c() {
            /*
            r13 = this;
            r8 = 0;
        L_0x0001:
            if (r8 != 0) goto L_0x00b5;
        L_0x0003:
            r0 = r13.f3347g;
            if (r0 != 0) goto L_0x00b5;
        L_0x0007:
            r7 = 0;
            r0 = r13.f3346f;	 Catch:{ all -> 0x009e }
            r2 = r0.f3266a;	 Catch:{ all -> 0x009e }
            r9 = r13.f3343c;	 Catch:{ all -> 0x009e }
            r0 = new com.google.android.exoplayer2.i.h;	 Catch:{ all -> 0x009e }
            r1 = r13.f3342b;	 Catch:{ all -> 0x009e }
            r4 = -1;
            r6 = r13.f3342b;	 Catch:{ all -> 0x009e }
            r6 = r6.toString();	 Catch:{ all -> 0x009e }
            r6 = com.google.android.exoplayer2.p050j.Util.m4526g(r6);	 Catch:{ all -> 0x009e }
            r0.<init>(r1, r2, r4, r6);	 Catch:{ all -> 0x009e }
            r0 = r9.m4332a(r0);	 Catch:{ all -> 0x009e }
            r13.f3349i = r0;	 Catch:{ all -> 0x009e }
            r0 = r13.f3349i;	 Catch:{ all -> 0x009e }
            r4 = -1;
            r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r0 == 0) goto L_0x0034;
        L_0x002f:
            r0 = r13.f3349i;	 Catch:{ all -> 0x009e }
            r0 = r0 + r2;
            r13.f3349i = r0;	 Catch:{ all -> 0x009e }
        L_0x0034:
            r0 = new com.google.android.exoplayer2.c.b;	 Catch:{ all -> 0x009e }
            r1 = r13.f3343c;	 Catch:{ all -> 0x009e }
            r4 = r13.f3349i;	 Catch:{ all -> 0x009e }
            r0.<init>(r1, r2, r4);	 Catch:{ all -> 0x009e }
            r1 = r13.f3344d;	 Catch:{ all -> 0x00b6 }
            r6 = r1.m3866a(r0);	 Catch:{ all -> 0x00b6 }
            r1 = r13.f3348h;	 Catch:{ all -> 0x00b6 }
            if (r1 == 0) goto L_0x004d;
        L_0x0047:
            r6.m3124a(r2);	 Catch:{ all -> 0x00b6 }
            r1 = 0;
            r13.f3348h = r1;	 Catch:{ all -> 0x00b6 }
        L_0x004d:
            r4 = r2;
            r1 = r8;
        L_0x004f:
            if (r1 != 0) goto L_0x0086;
        L_0x0051:
            r2 = r13.f3347g;	 Catch:{ all -> 0x00bc }
            if (r2 != 0) goto L_0x0086;
        L_0x0055:
            r2 = r13.f3345e;	 Catch:{ all -> 0x00bc }
            r2.m4418c();	 Catch:{ all -> 0x00bc }
            r2 = r13.f3346f;	 Catch:{ all -> 0x00bc }
            r2 = r6.m3123a(r0, r2);	 Catch:{ all -> 0x00bc }
            r8 = r0.m3238c();	 Catch:{ all -> 0x00c2 }
            r10 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
            r10 = r10 + r4;
            r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
            if (r1 <= 0) goto L_0x00c7;
        L_0x006c:
            r4 = r0.m3238c();	 Catch:{ all -> 0x00c2 }
            r1 = r13.f3345e;	 Catch:{ all -> 0x00c2 }
            r1.m4417b();	 Catch:{ all -> 0x00c2 }
            r1 = r13.f3341a;	 Catch:{ all -> 0x00c2 }
            r1 = r1.f3371m;	 Catch:{ all -> 0x00c2 }
            r3 = r13.f3341a;	 Catch:{ all -> 0x00c2 }
            r3 = r3.f3370l;	 Catch:{ all -> 0x00c2 }
            r1.post(r3);	 Catch:{ all -> 0x00c2 }
            r1 = r2;
            goto L_0x004f;
        L_0x0086:
            r2 = 1;
            if (r1 != r2) goto L_0x0092;
        L_0x0089:
            r0 = 0;
        L_0x008a:
            r1 = r13.f3343c;
            r1.m4333a();
            r8 = r0;
            goto L_0x0001;
        L_0x0092:
            if (r0 == 0) goto L_0x009c;
        L_0x0094:
            r2 = r13.f3346f;
            r4 = r0.m3238c();
            r2.f3266a = r4;
        L_0x009c:
            r0 = r1;
            goto L_0x008a;
        L_0x009e:
            r0 = move-exception;
            r1 = r7;
            r2 = r8;
        L_0x00a1:
            r3 = 1;
            if (r2 != r3) goto L_0x00aa;
        L_0x00a4:
            r1 = r13.f3343c;
            r1.m4333a();
            throw r0;
        L_0x00aa:
            if (r1 == 0) goto L_0x00a4;
        L_0x00ac:
            r2 = r13.f3346f;
            r4 = r1.m3238c();
            r2.f3266a = r4;
            goto L_0x00a4;
        L_0x00b5:
            return;
        L_0x00b6:
            r1 = move-exception;
            r2 = r8;
            r12 = r0;
            r0 = r1;
            r1 = r12;
            goto L_0x00a1;
        L_0x00bc:
            r2 = move-exception;
            r12 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r12;
            goto L_0x00a1;
        L_0x00c2:
            r1 = move-exception;
            r12 = r1;
            r1 = r0;
            r0 = r12;
            goto L_0x00a1;
        L_0x00c7:
            r1 = r2;
            goto L_0x004f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.a.a.c():void");
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.a.b */
    private static final class ExtractorMediaPeriod {
        private final Extractor[] f3350a;
        private final ExtractorOutput f3351b;
        private Extractor f3352c;

        public ExtractorMediaPeriod(Extractor[] extractorArr, ExtractorOutput extractorOutput) {
            this.f3350a = extractorArr;
            this.f3351b = extractorOutput;
        }

        public Extractor m3866a(ExtractorInput extractorInput) {
            if (this.f3352c != null) {
                return this.f3352c;
            }
            Extractor[] extractorArr = this.f3350a;
            int length = extractorArr.length;
            int i = 0;
            loop0:
            while (i < length) {
                Extractor extractor = extractorArr[i];
                try {
                    if (extractor.m3126a(extractorInput)) {
                        this.f3352c = extractor;
                        extractorInput.m3232a();
                        break loop0;
                    }
                    i++;
                } catch (EOFException e) {
                    i++;
                } finally {
                    extractorInput.m3232a();
                }
            }
            if (this.f3352c == null) {
                throw new ExtractorMediaSource(this.f3350a);
            }
            this.f3352c.m3125a(this.f3351b);
            return this.f3352c;
        }

        public void m3867a() {
            if (this.f3352c != null) {
                this.f3352c.m3127c();
                this.f3352c = null;
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.a.c */
    private final class ExtractorMediaPeriod implements SampleStream {
        final /* synthetic */ ExtractorMediaPeriod f3353a;
        private final int f3354b;

        public ExtractorMediaPeriod(ExtractorMediaPeriod extractorMediaPeriod, int i) {
            this.f3353a = extractorMediaPeriod;
            this.f3354b = i;
        }

        public boolean m3875a() {
            return this.f3353a.m3921b(this.f3354b);
        }

        public void m3876b() {
            this.f3353a.m3927h();
        }

        public int m3873a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
            return this.f3353a.m3905a(this.f3354b, formatHolder, decoderInputBuffer);
        }

        public void m3874a(long j) {
            ((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3353a.f3372n.valueAt(this.f3354b)).m3445a(j);
        }
    }

    public ExtractorMediaPeriod(Uri uri, DataSource dataSource, Extractor[] extractorArr, int i, Handler handler, ExtractorMediaSource extractorMediaSource, MediaSource mediaSource, Allocator allocator) {
        this.f3359a = uri;
        this.f3360b = dataSource;
        this.f3361c = i;
        this.f3362d = handler;
        this.f3363e = extractorMediaSource;
        this.f3364f = mediaSource;
        this.f3365g = allocator;
        this.f3366h = new com.google.android.exoplayer2.p063i.Loader("Loader:ExtractorMediaPeriod");
        this.f3367i = new ExtractorMediaPeriod(extractorArr, this);
        this.f3368j = new ConditionVariable();
        this.f3369k = new ExtractorMediaPeriod(this);
        this.f3370l = new ExtractorMediaPeriod(this);
        this.f3371m = new Handler();
        this.f3355A = -9223372036854775807L;
        this.f3372n = new SparseArray();
        this.f3383y = -1;
    }

    public void m3920b() {
        this.f3366h.m4397a(new ExtractorMediaPeriod(this, this.f3367i));
        this.f3371m.removeCallbacksAndMessages(null);
        this.f3358D = true;
    }

    public void m3915a(MediaPeriod mediaPeriod) {
        this.f3373o = mediaPeriod;
        this.f3368j.m4416a();
        m3901j();
    }

    public void m3922c() {
        m3927h();
    }

    public TrackGroupArray m3923d() {
        return this.f3380v;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m3908a(com.google.android.exoplayer2.p070h.TrackSelection[] r8, boolean[] r9, com.google.android.exoplayer2.p062f.SampleStream[] r10, boolean[] r11, long r12) {
        /*
        r7 = this;
        r3 = 1;
        r2 = 0;
        r0 = r7.f3376r;
        com.google.android.exoplayer2.p050j.Assertions.m4406b(r0);
        r1 = r2;
    L_0x0008:
        r0 = r8.length;
        if (r1 >= r0) goto L_0x0042;
    L_0x000b:
        r0 = r10[r1];
        if (r0 == 0) goto L_0x003e;
    L_0x000f:
        r0 = r8[r1];
        if (r0 == 0) goto L_0x0017;
    L_0x0013:
        r0 = r9[r1];
        if (r0 != 0) goto L_0x003e;
    L_0x0017:
        r0 = r10[r1];
        r0 = (com.google.android.exoplayer2.p062f.ExtractorMediaPeriod.ExtractorMediaPeriod) r0;
        r0 = r0.f3354b;
        r4 = r7.f3382x;
        r4 = r4[r0];
        com.google.android.exoplayer2.p050j.Assertions.m4406b(r4);
        r4 = r7.f3379u;
        r4 = r4 + -1;
        r7.f3379u = r4;
        r4 = r7.f3382x;
        r4[r0] = r2;
        r4 = r7.f3372n;
        r0 = r4.valueAt(r0);
        r0 = (com.google.android.exoplayer2.p052c.DefaultTrackOutput) r0;
        r0.m3446b();
        r0 = 0;
        r10[r1] = r0;
    L_0x003e:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0008;
    L_0x0042:
        r0 = r2;
        r1 = r2;
    L_0x0044:
        r4 = r8.length;
        if (r0 >= r4) goto L_0x0096;
    L_0x0047:
        r4 = r10[r0];
        if (r4 != 0) goto L_0x008d;
    L_0x004b:
        r4 = r8[r0];
        if (r4 == 0) goto L_0x008d;
    L_0x004f:
        r4 = r8[r0];
        r1 = r4.m4243b();
        if (r1 != r3) goto L_0x0090;
    L_0x0057:
        r1 = r3;
    L_0x0058:
        com.google.android.exoplayer2.p050j.Assertions.m4406b(r1);
        r1 = r4.m4244b(r2);
        if (r1 != 0) goto L_0x0092;
    L_0x0061:
        r1 = r3;
    L_0x0062:
        com.google.android.exoplayer2.p050j.Assertions.m4406b(r1);
        r1 = r7.f3380v;
        r4 = r4.m4242a();
        r4 = r1.m3957a(r4);
        r1 = r7.f3382x;
        r1 = r1[r4];
        if (r1 != 0) goto L_0x0094;
    L_0x0075:
        r1 = r3;
    L_0x0076:
        com.google.android.exoplayer2.p050j.Assertions.m4406b(r1);
        r1 = r7.f3379u;
        r1 = r1 + 1;
        r7.f3379u = r1;
        r1 = r7.f3382x;
        r1[r4] = r3;
        r1 = new com.google.android.exoplayer2.f.a$c;
        r1.<init>(r7, r4);
        r10[r0] = r1;
        r11[r0] = r3;
        r1 = r3;
    L_0x008d:
        r0 = r0 + 1;
        goto L_0x0044;
    L_0x0090:
        r1 = r2;
        goto L_0x0058;
    L_0x0092:
        r1 = r2;
        goto L_0x0062;
    L_0x0094:
        r1 = r2;
        goto L_0x0076;
    L_0x0096:
        r0 = r7.f3377s;
        if (r0 != 0) goto L_0x00b8;
    L_0x009a:
        r0 = r7.f3372n;
        r5 = r0.size();
        r4 = r2;
    L_0x00a1:
        if (r4 >= r5) goto L_0x00b8;
    L_0x00a3:
        r0 = r7.f3382x;
        r0 = r0[r4];
        if (r0 != 0) goto L_0x00b4;
    L_0x00a9:
        r0 = r7.f3372n;
        r0 = r0.valueAt(r4);
        r0 = (com.google.android.exoplayer2.p052c.DefaultTrackOutput) r0;
        r0.m3446b();
    L_0x00b4:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x00a1;
    L_0x00b8:
        r0 = r7.f3379u;
        if (r0 != 0) goto L_0x00ce;
    L_0x00bc:
        r7.f3378t = r2;
        r0 = r7.f3366h;
        r0 = r0.m4398a();
        if (r0 == 0) goto L_0x00cb;
    L_0x00c6:
        r0 = r7.f3366h;
        r0.m4399b();
    L_0x00cb:
        r7.f3377s = r3;
        return r12;
    L_0x00ce:
        r0 = r7.f3377s;
        if (r0 == 0) goto L_0x00e4;
    L_0x00d2:
        if (r1 == 0) goto L_0x00cb;
    L_0x00d4:
        r12 = r7.m3919b(r12);
    L_0x00d8:
        r0 = r10.length;
        if (r2 >= r0) goto L_0x00cb;
    L_0x00db:
        r0 = r10[r2];
        if (r0 == 0) goto L_0x00e1;
    L_0x00df:
        r11[r2] = r3;
    L_0x00e1:
        r2 = r2 + 1;
        goto L_0x00d8;
    L_0x00e4:
        r0 = 0;
        r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x00cb;
    L_0x00ea:
        goto L_0x00d4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.a.a(com.google.android.exoplayer2.h.f[], boolean[], com.google.android.exoplayer2.f.e[], boolean[], long):long");
    }

    public boolean m3918a(long j) {
        if (this.f3357C) {
            return false;
        }
        boolean a = this.f3368j.m4416a();
        if (this.f3366h.m4398a()) {
            return a;
        }
        m3901j();
        return true;
    }

    public long m3924e() {
        return m3926g();
    }

    public long m3925f() {
        if (!this.f3378t) {
            return -9223372036854775807L;
        }
        this.f3378t = false;
        return this.f3384z;
    }

    public long m3926g() {
        if (this.f3357C) {
            return Long.MIN_VALUE;
        }
        if (m3904m()) {
            return this.f3355A;
        }
        long l = m3903l();
        return l == Long.MIN_VALUE ? this.f3384z : l;
    }

    public long m3919b(long j) {
        boolean z;
        if (!this.f3374p.m3128a()) {
            j = 0;
        }
        this.f3384z = j;
        int size = this.f3372n.size();
        if (m3904m()) {
            z = false;
        } else {
            z = true;
        }
        int i = 0;
        while (z && i < size) {
            if (this.f3382x[i]) {
                z = ((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i)).m3445a(j);
            }
            i++;
        }
        if (!z) {
            this.f3355A = j;
            this.f3357C = false;
            if (this.f3366h.m4398a()) {
                this.f3366h.m4399b();
            } else {
                for (i = 0; i < size; i++) {
                    ((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i)).m3444a(this.f3382x[i]);
                }
            }
        }
        this.f3378t = false;
        return j;
    }

    boolean m3921b(int i) {
        return this.f3357C || !(m3904m() || ((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i)).m3447c());
    }

    void m3927h() {
        this.f3366h.m4400c();
    }

    int m3905a(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
        if (this.f3378t || m3904m()) {
            return -3;
        }
        return ((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i)).m3439a(formatHolder, decoderInputBuffer, this.f3357C, this.f3384z);
    }

    public void m3913a(ExtractorMediaPeriod extractorMediaPeriod, long j, long j2) {
        m3889a(extractorMediaPeriod);
        this.f3357C = true;
        if (this.f3381w == -9223372036854775807L) {
            long l = m3903l();
            this.f3381w = l == Long.MIN_VALUE ? 0 : l + 10000;
            this.f3364f.m3934a(new SinglePeriodTimeline(this.f3381w, this.f3374p.m3128a()), null);
        }
    }

    public void m3914a(ExtractorMediaPeriod extractorMediaPeriod, long j, long j2, boolean z) {
        m3889a(extractorMediaPeriod);
        if (!z && this.f3379u > 0) {
            int size = this.f3372n.size();
            for (int i = 0; i < size; i++) {
                ((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i)).m3444a(this.f3382x[i]);
            }
            this.f3373o.m3941a(this);
        }
    }

    public int m3906a(ExtractorMediaPeriod extractorMediaPeriod, long j, long j2, IOException iOException) {
        m3889a(extractorMediaPeriod);
        m3893b(iOException);
        if (m3891a(iOException)) {
            return 3;
        }
        int i;
        if (m3902k() > this.f3356B) {
            i = 1;
        } else {
            i = 0;
        }
        m3892b(extractorMediaPeriod);
        this.f3356B = m3902k();
        if (i == 0) {
            return 0;
        }
        return 1;
    }

    public TrackOutput m3909a(int i) {
        com.google.android.exoplayer2.p052c.DefaultTrackOutput defaultTrackOutput = (com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.get(i);
        if (defaultTrackOutput != null) {
            return defaultTrackOutput;
        }
        TrackOutput defaultTrackOutput2 = new com.google.android.exoplayer2.p052c.DefaultTrackOutput(this.f3365g);
        defaultTrackOutput2.m3442a((DefaultTrackOutput) this);
        this.f3372n.put(i, defaultTrackOutput2);
        return defaultTrackOutput2;
    }

    public void m3910a() {
        this.f3375q = true;
        this.f3371m.post(this.f3369k);
    }

    public void m3912a(SeekMap seekMap) {
        this.f3374p = seekMap;
        this.f3371m.post(this.f3369k);
    }

    public void m3911a(Format format) {
        this.f3371m.post(this.f3369k);
    }

    private void m3900i() {
        if (!this.f3358D && !this.f3376r && this.f3374p != null && this.f3375q) {
            int size = this.f3372n.size();
            int i = 0;
            while (i < size) {
                if (((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i)).m3448d() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.f3368j.m4417b();
            TrackGroup[] trackGroupArr = new TrackGroup[size];
            this.f3382x = new boolean[size];
            this.f3381w = this.f3374p.m3129b();
            for (i = 0; i < size; i++) {
                trackGroupArr[i] = new TrackGroup(((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i)).m3448d());
            }
            this.f3380v = new TrackGroupArray(trackGroupArr);
            this.f3376r = true;
            this.f3364f.m3934a(new SinglePeriodTimeline(this.f3381w, this.f3374p.m3128a()), null);
            this.f3373o.m3942a(this);
        }
    }

    private void m3889a(ExtractorMediaPeriod extractorMediaPeriod) {
        if (this.f3383y == -1) {
            this.f3383y = extractorMediaPeriod.f3349i;
        }
    }

    private void m3901j() {
        Loader extractorMediaPeriod = new ExtractorMediaPeriod(this, this.f3359a, this.f3360b, this.f3367i, this.f3368j);
        if (this.f3376r) {
            Assertions.m4406b(m3904m());
            if (this.f3381w == -9223372036854775807L || this.f3355A < this.f3381w) {
                extractorMediaPeriod.m3863a(this.f3374p.m3130b(this.f3355A));
                this.f3355A = -9223372036854775807L;
            } else {
                this.f3357C = true;
                this.f3355A = -9223372036854775807L;
                return;
            }
        }
        this.f3356B = m3902k();
        int i = this.f3361c;
        if (i == -1) {
            i = (this.f3376r && this.f3383y == -1 && (this.f3374p == null || this.f3374p.m3129b() == -9223372036854775807L)) ? 6 : 3;
        }
        this.f3366h.m4395a(extractorMediaPeriod, this, i);
    }

    private void m3892b(ExtractorMediaPeriod extractorMediaPeriod) {
        if (this.f3383y != -1) {
            return;
        }
        if (this.f3374p == null || this.f3374p.m3129b() == -9223372036854775807L) {
            this.f3384z = 0;
            this.f3378t = this.f3376r;
            int size = this.f3372n.size();
            int i = 0;
            while (i < size) {
                boolean z;
                com.google.android.exoplayer2.p052c.DefaultTrackOutput defaultTrackOutput = (com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i);
                if (!this.f3376r || this.f3382x[i]) {
                    z = true;
                } else {
                    z = false;
                }
                defaultTrackOutput.m3444a(z);
                i++;
            }
            extractorMediaPeriod.m3863a(0);
        }
    }

    private int m3902k() {
        int i = 0;
        for (int i2 = 0; i2 < this.f3372n.size(); i2++) {
            i += ((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i2)).m3437a();
        }
        return i;
    }

    private long m3903l() {
        long j = Long.MIN_VALUE;
        int size = this.f3372n.size();
        for (int i = 0; i < size; i++) {
            j = Math.max(j, ((com.google.android.exoplayer2.p052c.DefaultTrackOutput) this.f3372n.valueAt(i)).m3449e());
        }
        return j;
    }

    private boolean m3904m() {
        return this.f3355A != -9223372036854775807L;
    }

    private boolean m3891a(IOException iOException) {
        return iOException instanceof ExtractorMediaSource;
    }

    private void m3893b(IOException iOException) {
        if (this.f3362d != null && this.f3363e != null) {
            this.f3362d.post(new ExtractorMediaPeriod(this, iOException));
        }
    }
}
