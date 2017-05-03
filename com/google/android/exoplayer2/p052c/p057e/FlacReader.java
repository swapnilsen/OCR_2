package com.google.android.exoplayer2.p052c.p057e;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.cardview.C0269R;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.FlacStreamInfo;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.SeekMap;
import com.google.android.exoplayer2.p052c.p057e.StreamReader.StreamReader;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.e.b */
final class FlacReader extends StreamReader {
    private FlacStreamInfo f2944a;
    private FlacReader f2945b;

    /* renamed from: com.google.android.exoplayer2.c.e.b.a */
    private class FlacReader implements OggSeeker, SeekMap {
        final /* synthetic */ FlacReader f2924a;
        private long[] f2925b;
        private long[] f2926c;
        private long f2927d;
        private volatile long f2928e;
        private volatile long f2929f;
        private long f2930g;

        private FlacReader(FlacReader flacReader) {
            this.f2924a = flacReader;
            this.f2927d = -1;
            this.f2930g = -1;
        }

        public void m3472a(long j) {
            this.f2927d = j;
        }

        public void m3473a(ParsableByteArray parsableByteArray) {
            parsableByteArray.m4457d(1);
            int k = parsableByteArray.m4465k() / 18;
            this.f2925b = new long[k];
            this.f2926c = new long[k];
            for (int i = 0; i < k; i++) {
                this.f2925b[i] = parsableByteArray.m4470p();
                this.f2926c[i] = parsableByteArray.m4470p();
                parsableByteArray.m4457d(2);
            }
        }

        public long m3471a(ExtractorInput extractorInput) {
            if (this.f2930g < 0) {
                return -1;
            }
            this.f2930g = (-this.f2930g) - 2;
            return this.f2930g;
        }

        public synchronized long a_() {
            this.f2930g = this.f2929f;
            return this.f2928e;
        }

        public SeekMap m3477d() {
            return this;
        }

        public boolean m3474a() {
            return true;
        }

        public synchronized long m3476b(long j) {
            int a;
            this.f2928e = this.f2924a.m3487c(j);
            a = Util.m4509a(this.f2925b, this.f2928e, true, true);
            this.f2929f = this.f2925b[a];
            return this.f2926c[a] + this.f2927d;
        }

        public long m3475b() {
            return this.f2924a.f2944a.m4420b();
        }
    }

    FlacReader() {
    }

    public static boolean m3490a(ParsableByteArray parsableByteArray) {
        return parsableByteArray.m4452b() >= 5 && parsableByteArray.m4461g() == TransportMediator.KEYCODE_MEDIA_PAUSE && parsableByteArray.m4466l() == 1179402563;
    }

    protected void m3493a(boolean z) {
        super.m3483a(z);
        if (z) {
            this.f2944a = null;
            this.f2945b = null;
        }
    }

    private static boolean m3491a(byte[] bArr) {
        return bArr[0] == -1;
    }

    protected long m3495b(ParsableByteArray parsableByteArray) {
        if (FlacReader.m3491a(parsableByteArray.f3831a)) {
            return (long) m3492c(parsableByteArray);
        }
        return -1;
    }

    protected boolean m3494a(ParsableByteArray parsableByteArray, long j, StreamReader streamReader) {
        byte[] bArr = parsableByteArray.f3831a;
        if (this.f2944a == null) {
            this.f2944a = new FlacStreamInfo(bArr, 17);
            Object copyOfRange = Arrays.copyOfRange(bArr, 9, parsableByteArray.m4454c());
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            streamReader.f2968a = Format.m2862a(null, "audio/x-flac", null, -1, this.f2944a.m4419a(), this.f2944a.f3805f, this.f2944a.f3804e, singletonList, null, 0, null);
        } else if ((bArr[0] & TransportMediator.KEYCODE_MEDIA_PAUSE) == 3) {
            this.f2945b = new FlacReader();
            this.f2945b.m3473a(parsableByteArray);
        } else if (FlacReader.m3491a(bArr)) {
            if (this.f2945b == null) {
                return false;
            }
            this.f2945b.m3472a(j);
            streamReader.f2969b = this.f2945b;
            return false;
        }
        return true;
    }

    private int m3492c(ParsableByteArray parsableByteArray) {
        int i = (parsableByteArray.f3831a[2] & MotionEventCompat.ACTION_MASK) >> 4;
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return 192;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
            case Type.OTHER_PROFILE /*5*/:
                return 576 << (i - 2);
            case Type.CONTRIBUTOR /*6*/:
            case Type.WEBSITE /*7*/:
                parsableByteArray.m4457d(4);
                parsableByteArray.m4479y();
                i = i == 6 ? parsableByteArray.m4461g() : parsableByteArray.m4462h();
                parsableByteArray.m4455c(0);
                return i + 1;
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
            case ConnectionResult.SERVICE_INVALID /*9*/:
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
            case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
            case CommonStatusCodes.ERROR /*13*/:
            case CommonStatusCodes.INTERRUPTED /*14*/:
            case CommonStatusCodes.TIMEOUT /*15*/:
                return AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY << (i - 8);
            default:
                return -1;
        }
    }
}
