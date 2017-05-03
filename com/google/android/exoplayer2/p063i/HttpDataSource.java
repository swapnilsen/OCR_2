package com.google.android.exoplayer2.p063i;

import android.text.TextUtils;
import com.google.android.exoplayer2.p050j.Predicate;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p063i.DataSource.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.i.p */
public interface HttpDataSource extends DataSource {
    public static final Predicate<String> f3746a;

    /* renamed from: com.google.android.exoplayer2.i.p.a */
    public interface C0897a extends DataSource {
    }

    /* renamed from: com.google.android.exoplayer2.i.p.1 */
    static class HttpDataSource implements Predicate<String> {
        HttpDataSource() {
        }

        public boolean m4384a(String str) {
            String d = Util.m4523d(str);
            return (TextUtils.isEmpty(d) || ((d.contains("text") && !d.contains("text/vtt")) || d.contains("html") || d.contains("xml"))) ? false : true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.i.p.b */
    public static class HttpDataSource extends IOException {
        public final int f3774a;
        public final DataSpec f3775b;

        public HttpDataSource(String str, DataSpec dataSpec, int i) {
            super(str);
            this.f3775b = dataSpec;
            this.f3774a = i;
        }

        public HttpDataSource(IOException iOException, DataSpec dataSpec, int i) {
            super(iOException);
            this.f3775b = dataSpec;
            this.f3774a = i;
        }

        public HttpDataSource(String str, IOException iOException, DataSpec dataSpec, int i) {
            super(str, iOException);
            this.f3775b = dataSpec;
            this.f3774a = i;
        }
    }

    /* renamed from: com.google.android.exoplayer2.i.p.c */
    public static final class HttpDataSource extends HttpDataSource {
        public final String f3776c;

        public HttpDataSource(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, 1);
            this.f3776c = str;
        }
    }

    /* renamed from: com.google.android.exoplayer2.i.p.d */
    public static final class HttpDataSource extends HttpDataSource {
        public final int f3777c;
        public final Map<String, List<String>> f3778d;

        public HttpDataSource(int i, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Response code: " + i, dataSpec, 1);
            this.f3777c = i;
            this.f3778d = map;
        }
    }

    static {
        f3746a = new HttpDataSource();
    }
}
