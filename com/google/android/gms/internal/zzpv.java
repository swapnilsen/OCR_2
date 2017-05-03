package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;

@zzme
public class zzpv {
    private static zzm zzYm;
    private static final Object zzYn;
    public static final zza<Void> zzYo;

    public interface zza<T> {
        T zzh(InputStream inputStream);

        T zzji();
    }

    /* renamed from: com.google.android.gms.internal.zzpv.1 */
    class C13731 implements zza<Void> {
        C13731() {
        }

        public /* bridge */ /* synthetic */ Object zzh(InputStream inputStream) {
            return null;
        }

        public /* bridge */ /* synthetic */ Object zzji() {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpv.2 */
    class C13742 implements com.google.android.gms.internal.zzn.zza {
        final /* synthetic */ zzc zzYp;
        final /* synthetic */ String zzsg;

        C13742(zzpv com_google_android_gms_internal_zzpv, String str, zzc com_google_android_gms_internal_zzpv_zzc) {
            this.zzsg = str;
            this.zzYp = com_google_android_gms_internal_zzpv_zzc;
        }

        public void zze(zzs com_google_android_gms_internal_zzs) {
            String str = this.zzsg;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzs.toString());
            zzqf.zzbh(new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(valueOf).length()).append("Failed to load URL: ").append(str).append("\n").append(valueOf).toString());
            this.zzYp.zzb(null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpv.3 */
    class C13753 extends zzac {
        final /* synthetic */ byte[] zzYq;
        final /* synthetic */ Map zzYr;

        C13753(zzpv com_google_android_gms_internal_zzpv, int i, String str, com.google.android.gms.internal.zzn.zzb com_google_android_gms_internal_zzn_zzb, com.google.android.gms.internal.zzn.zza com_google_android_gms_internal_zzn_zza, byte[] bArr, Map map) {
            this.zzYq = bArr;
            this.zzYr = map;
            super(i, str, com_google_android_gms_internal_zzn_zzb, com_google_android_gms_internal_zzn_zza);
        }

        public Map<String, String> getHeaders() {
            return this.zzYr == null ? super.getHeaders() : this.zzYr;
        }

        public byte[] zzm() {
            return this.zzYq == null ? super.zzm() : this.zzYq;
        }
    }

    private static class zzb<T> extends zzl<InputStream> {
        private final zza<T> zzYs;
        private final com.google.android.gms.internal.zzn.zzb<T> zzaG;

        /* renamed from: com.google.android.gms.internal.zzpv.zzb.1 */
        class C13761 implements com.google.android.gms.internal.zzn.zza {
            final /* synthetic */ com.google.android.gms.internal.zzn.zzb zzYt;
            final /* synthetic */ zza zzYu;

            C13761(com.google.android.gms.internal.zzn.zzb com_google_android_gms_internal_zzn_zzb, zza com_google_android_gms_internal_zzpv_zza) {
                this.zzYt = com_google_android_gms_internal_zzn_zzb;
                this.zzYu = com_google_android_gms_internal_zzpv_zza;
            }

            public void zze(zzs com_google_android_gms_internal_zzs) {
                this.zzYt.zzb(this.zzYu.zzji());
            }
        }

        /* renamed from: com.google.android.gms.internal.zzpv.zzb.2 */
        class C13772 implements Callable<T> {
            final /* synthetic */ InputStream zzYv;
            final /* synthetic */ zzb zzYw;

            C13772(zzb com_google_android_gms_internal_zzpv_zzb, InputStream inputStream) {
                this.zzYw = com_google_android_gms_internal_zzpv_zzb;
                this.zzYv = inputStream;
            }

            public T call() {
                return this.zzYw.zzYs.zzh(this.zzYv);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzpv.zzb.3 */
        class C13783 implements Runnable {
            final /* synthetic */ zzb zzYw;
            final /* synthetic */ zzqm zzYx;

            C13783(zzb com_google_android_gms_internal_zzpv_zzb, zzqm com_google_android_gms_internal_zzqm) {
                this.zzYw = com_google_android_gms_internal_zzpv_zzb;
                this.zzYx = com_google_android_gms_internal_zzqm;
            }

            public void run() {
                try {
                    this.zzYw.zzaG.zzb(this.zzYx.get());
                } catch (Throwable e) {
                    zzqf.zzb("Error occured while dispatching http response in getter.", e);
                    zzw.zzcQ().zza(e, "HttpGetter.deliverResponse.1");
                }
            }
        }

        public zzb(String str, zza<T> com_google_android_gms_internal_zzpv_zza_T, com.google.android.gms.internal.zzn.zzb<T> com_google_android_gms_internal_zzn_zzb_T) {
            super(0, str, new C13761(com_google_android_gms_internal_zzn_zzb_T, com_google_android_gms_internal_zzpv_zza_T));
            this.zzYs = com_google_android_gms_internal_zzpv_zza_T;
            this.zzaG = com_google_android_gms_internal_zzn_zzb_T;
        }

        protected zzn<InputStream> zza(zzj com_google_android_gms_internal_zzj) {
            return zzn.zza(new ByteArrayInputStream(com_google_android_gms_internal_zzj.data), zzy.zzb(com_google_android_gms_internal_zzj));
        }

        protected /* synthetic */ void zza(Object obj) {
            zzi((InputStream) obj);
        }

        protected void zzi(InputStream inputStream) {
            zzqm zza = zzpn.zza(new C13772(this, inputStream));
            zza.zzd(new C13783(this, zza));
        }
    }

    private class zzc<T> extends zzqj<T> implements com.google.android.gms.internal.zzn.zzb<T> {
        private zzc(zzpv com_google_android_gms_internal_zzpv) {
        }

        public void zzb(@Nullable T t) {
            super.zzh(t);
        }
    }

    static {
        zzYn = new Object();
        zzYo = new C13731();
    }

    public zzpv(Context context) {
        zzZ(context);
    }

    private static zzm zzZ(Context context) {
        zzm com_google_android_gms_internal_zzm;
        synchronized (zzYn) {
            if (zzYm == null) {
                zzYm = zzad.zza(context.getApplicationContext());
            }
            com_google_android_gms_internal_zzm = zzYm;
        }
        return com_google_android_gms_internal_zzm;
    }

    public zzqm<String> zza(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        Object com_google_android_gms_internal_zzpv_zzc = new zzc();
        zzYm.zze(new C13753(this, i, str, com_google_android_gms_internal_zzpv_zzc, new C13742(this, str, com_google_android_gms_internal_zzpv_zzc), bArr, map));
        return com_google_android_gms_internal_zzpv_zzc;
    }

    public <T> zzqm<T> zza(String str, zza<T> com_google_android_gms_internal_zzpv_zza_T) {
        Object com_google_android_gms_internal_zzpv_zzc = new zzc();
        zzYm.zze(new zzb(str, com_google_android_gms_internal_zzpv_zza_T, com_google_android_gms_internal_zzpv_zzc));
        return com_google_android_gms_internal_zzpv_zzc;
    }

    public zzqm<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
