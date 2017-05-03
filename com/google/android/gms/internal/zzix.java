package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzm;
import java.util.LinkedList;
import java.util.List;

@zzme
class zzix {
    private final List<zza> zzth;

    interface zza {
        void zzb(zziy com_google_android_gms_internal_zziy);
    }

    /* renamed from: com.google.android.gms.internal.zzix.1 */
    class C12221 extends com.google.android.gms.internal.zzep.zza {
        final /* synthetic */ zzix zzIN;

        /* renamed from: com.google.android.gms.internal.zzix.1.1 */
        class C12171 implements zza {
            C12171(C12221 c12221) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zztk != null) {
                    com_google_android_gms_internal_zziy.zztk.onAdClosed();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.1.2 */
        class C12182 implements zza {
            final /* synthetic */ int zzIO;

            C12182(C12221 c12221, int i) {
                this.zzIO = i;
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zztk != null) {
                    com_google_android_gms_internal_zziy.zztk.onAdFailedToLoad(this.zzIO);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.1.3 */
        class C12193 implements zza {
            C12193(C12221 c12221) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zztk != null) {
                    com_google_android_gms_internal_zziy.zztk.onAdLeftApplication();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.1.4 */
        class C12204 implements zza {
            C12204(C12221 c12221) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zztk != null) {
                    com_google_android_gms_internal_zziy.zztk.onAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.1.5 */
        class C12215 implements zza {
            C12215(C12221 c12221) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zztk != null) {
                    com_google_android_gms_internal_zziy.zztk.onAdOpened();
                }
            }
        }

        C12221(zzix com_google_android_gms_internal_zzix) {
            this.zzIN = com_google_android_gms_internal_zzix;
        }

        public void onAdClosed() {
            this.zzIN.zzth.add(new C12171(this));
        }

        public void onAdFailedToLoad(int i) {
            this.zzIN.zzth.add(new C12182(this, i));
            zzpk.m4709v("Pooled interstitial failed to load.");
        }

        public void onAdLeftApplication() {
            this.zzIN.zzth.add(new C12193(this));
        }

        public void onAdLoaded() {
            this.zzIN.zzth.add(new C12204(this));
            zzpk.m4709v("Pooled interstitial loaded.");
        }

        public void onAdOpened() {
            this.zzIN.zzth.add(new C12215(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzix.2 */
    class C12242 extends com.google.android.gms.internal.zzev.zza {
        final /* synthetic */ zzix zzIN;

        /* renamed from: com.google.android.gms.internal.zzix.2.1 */
        class C12231 implements zza {
            final /* synthetic */ String val$name;
            final /* synthetic */ String zzIP;

            C12231(C12242 c12242, String str, String str2) {
                this.val$name = str;
                this.zzIP = str2;
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIV != null) {
                    com_google_android_gms_internal_zziy.zzIV.onAppEvent(this.val$name, this.zzIP);
                }
            }
        }

        C12242(zzix com_google_android_gms_internal_zzix) {
            this.zzIN = com_google_android_gms_internal_zzix;
        }

        public void onAppEvent(String str, String str2) {
            this.zzIN.zzth.add(new C12231(this, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzix.3 */
    class C12263 extends com.google.android.gms.internal.zzle.zza {
        final /* synthetic */ zzix zzIN;

        /* renamed from: com.google.android.gms.internal.zzix.3.1 */
        class C12251 implements zza {
            final /* synthetic */ zzld zzIQ;

            C12251(C12263 c12263, zzld com_google_android_gms_internal_zzld) {
                this.zzIQ = com_google_android_gms_internal_zzld;
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIW != null) {
                    com_google_android_gms_internal_zziy.zzIW.zza(this.zzIQ);
                }
            }
        }

        C12263(zzix com_google_android_gms_internal_zzix) {
            this.zzIN = com_google_android_gms_internal_zzix;
        }

        public void zza(zzld com_google_android_gms_internal_zzld) {
            this.zzIN.zzth.add(new C12251(this, com_google_android_gms_internal_zzld));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzix.4 */
    class C12284 extends com.google.android.gms.internal.zzgp.zza {
        final /* synthetic */ zzix zzIN;

        /* renamed from: com.google.android.gms.internal.zzix.4.1 */
        class C12271 implements zza {
            final /* synthetic */ zzgo zzIR;

            C12271(C12284 c12284, zzgo com_google_android_gms_internal_zzgo) {
                this.zzIR = com_google_android_gms_internal_zzgo;
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIX != null) {
                    com_google_android_gms_internal_zziy.zzIX.zza(this.zzIR);
                }
            }
        }

        C12284(zzix com_google_android_gms_internal_zzix) {
            this.zzIN = com_google_android_gms_internal_zzix;
        }

        public void zza(zzgo com_google_android_gms_internal_zzgo) {
            this.zzIN.zzth.add(new C12271(this, com_google_android_gms_internal_zzgo));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzix.5 */
    class C12305 extends com.google.android.gms.internal.zzeo.zza {
        final /* synthetic */ zzix zzIN;

        /* renamed from: com.google.android.gms.internal.zzix.5.1 */
        class C12291 implements zza {
            C12291(C12305 c12305) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIY != null) {
                    com_google_android_gms_internal_zziy.zzIY.onAdClicked();
                }
            }
        }

        C12305(zzix com_google_android_gms_internal_zzix) {
            this.zzIN = com_google_android_gms_internal_zzix;
        }

        public void onAdClicked() {
            this.zzIN.zzth.add(new C12291(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzix.6 */
    class C12386 extends com.google.android.gms.internal.zznw.zza {
        final /* synthetic */ zzix zzIN;

        /* renamed from: com.google.android.gms.internal.zzix.6.1 */
        class C12311 implements zza {
            C12311(C12386 c12386) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIZ != null) {
                    com_google_android_gms_internal_zziy.zzIZ.onRewardedVideoAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.6.2 */
        class C12322 implements zza {
            C12322(C12386 c12386) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIZ != null) {
                    com_google_android_gms_internal_zziy.zzIZ.onRewardedVideoAdOpened();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.6.3 */
        class C12333 implements zza {
            C12333(C12386 c12386) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIZ != null) {
                    com_google_android_gms_internal_zziy.zzIZ.onRewardedVideoStarted();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.6.4 */
        class C12344 implements zza {
            C12344(C12386 c12386) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIZ != null) {
                    com_google_android_gms_internal_zziy.zzIZ.onRewardedVideoAdClosed();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.6.5 */
        class C12355 implements zza {
            final /* synthetic */ zznt zzIS;

            C12355(C12386 c12386, zznt com_google_android_gms_internal_zznt) {
                this.zzIS = com_google_android_gms_internal_zznt;
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIZ != null) {
                    com_google_android_gms_internal_zziy.zzIZ.zza(this.zzIS);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.6.6 */
        class C12366 implements zza {
            C12366(C12386 c12386) {
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIZ != null) {
                    com_google_android_gms_internal_zziy.zzIZ.onRewardedVideoAdLeftApplication();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzix.6.7 */
        class C12377 implements zza {
            final /* synthetic */ int zzIO;

            C12377(C12386 c12386, int i) {
                this.zzIO = i;
            }

            public void zzb(zziy com_google_android_gms_internal_zziy) {
                if (com_google_android_gms_internal_zziy.zzIZ != null) {
                    com_google_android_gms_internal_zziy.zzIZ.onRewardedVideoAdFailedToLoad(this.zzIO);
                }
            }
        }

        C12386(zzix com_google_android_gms_internal_zzix) {
            this.zzIN = com_google_android_gms_internal_zzix;
        }

        public void onRewardedVideoAdClosed() {
            this.zzIN.zzth.add(new C12344(this));
        }

        public void onRewardedVideoAdFailedToLoad(int i) {
            this.zzIN.zzth.add(new C12377(this, i));
        }

        public void onRewardedVideoAdLeftApplication() {
            this.zzIN.zzth.add(new C12366(this));
        }

        public void onRewardedVideoAdLoaded() {
            this.zzIN.zzth.add(new C12311(this));
        }

        public void onRewardedVideoAdOpened() {
            this.zzIN.zzth.add(new C12322(this));
        }

        public void onRewardedVideoStarted() {
            this.zzIN.zzth.add(new C12333(this));
        }

        public void zza(zznt com_google_android_gms_internal_zznt) {
            this.zzIN.zzth.add(new C12355(this, com_google_android_gms_internal_zznt));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzix.7 */
    class C12397 implements Runnable {
        final /* synthetic */ zza zzIT;
        final /* synthetic */ zziy zzIU;

        C12397(zzix com_google_android_gms_internal_zzix, zza com_google_android_gms_internal_zzix_zza, zziy com_google_android_gms_internal_zziy) {
            this.zzIT = com_google_android_gms_internal_zzix_zza;
            this.zzIU = com_google_android_gms_internal_zziy;
        }

        public void run() {
            try {
                this.zzIT.zzb(this.zzIU);
            } catch (Throwable e) {
                zzqf.zzc("Could not propagate interstitial ad event.", e);
            }
        }
    }

    zzix() {
        this.zzth = new LinkedList();
    }

    void zza(zziy com_google_android_gms_internal_zziy) {
        Handler handler = zzpo.zzXC;
        for (zza c12397 : this.zzth) {
            handler.post(new C12397(this, c12397, com_google_android_gms_internal_zziy));
        }
        this.zzth.clear();
    }

    void zzc(zzm com_google_android_gms_ads_internal_zzm) {
        com_google_android_gms_ads_internal_zzm.zza(new C12221(this));
        com_google_android_gms_ads_internal_zzm.zza(new C12242(this));
        com_google_android_gms_ads_internal_zzm.zza(new C12263(this));
        com_google_android_gms_ads_internal_zzm.zza(new C12284(this));
        com_google_android_gms_ads_internal_zzm.zza(new C12305(this));
        com_google_android_gms_ads_internal_zzm.zza(new C12386(this));
    }
}
