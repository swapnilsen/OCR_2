package com.facebook.ads;

import com.crashlytics.android.answers.AnswersEvent;
import com.google.api.client.http.HttpStatusCodes;

/* renamed from: com.facebook.ads.o */
public class C0871o {

    /* renamed from: com.facebook.ads.o.a */
    public enum C0870a {
        HEIGHT_100(-1, 100),
        HEIGHT_120(-1, 120),
        HEIGHT_300(-1, HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES),
        HEIGHT_400(-1, 400);
        
        private final int f2193e;
        private final int f2194f;

        private C0870a(int i, int i2) {
            this.f2193e = i;
            this.f2194f = i2;
        }

        public int m2737a() {
            switch (this.f2194f) {
                case AnswersEvent.MAX_STRING_LENGTH /*100*/:
                    return 1;
                case 120:
                    return 2;
                case HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES /*300*/:
                    return 3;
                case 400:
                    return 4;
                default:
                    return -1;
            }
        }
    }
}
