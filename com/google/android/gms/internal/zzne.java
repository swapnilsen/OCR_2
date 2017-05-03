package com.google.android.gms.internal;

import com.google.android.gms.internal.zzji.zzc;
import java.util.Map;
import java.util.concurrent.Future;

@zzme
public final class zzne {
    private String zzOV;
    private String zzTK;
    private zzqj<zznh> zzTL;
    zzc zzTM;
    public final zzid zzTN;
    public final zzid zzTO;
    public final zzid zzTP;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.internal.zzne.1 */
    class C13331 implements zzid {
        final /* synthetic */ zzne zzTQ;

        C13331(zzne com_google_android_gms_internal_zzne) {
            this.zzTQ = com_google_android_gms_internal_zzne;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            synchronized (this.zzTQ.zzrJ) {
                if (this.zzTQ.zzTL.isDone()) {
                } else if (this.zzTQ.zzOV.equals(map.get("request_id"))) {
                    zznh com_google_android_gms_internal_zznh = new zznh(1, map);
                    String valueOf = String.valueOf(com_google_android_gms_internal_zznh.getType());
                    String valueOf2 = String.valueOf(com_google_android_gms_internal_zznh.zzjx());
                    zzqf.zzbh(new StringBuilder((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()).append("Invalid ").append(valueOf).append(" request error: ").append(valueOf2).toString());
                    this.zzTQ.zzTL.zzh(com_google_android_gms_internal_zznh);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzne.2 */
    class C13342 implements zzid {
        final /* synthetic */ zzne zzTQ;

        C13342(zzne com_google_android_gms_internal_zzne) {
            this.zzTQ = com_google_android_gms_internal_zzne;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            synchronized (this.zzTQ.zzrJ) {
                if (this.zzTQ.zzTL.isDone()) {
                    return;
                }
                zznh com_google_android_gms_internal_zznh = new zznh(-2, map);
                if (this.zzTQ.zzOV.equals(com_google_android_gms_internal_zznh.getRequestId())) {
                    String url = com_google_android_gms_internal_zznh.getUrl();
                    if (url == null) {
                        zzqf.zzbh("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String replaceAll = url.replaceAll("%40mediation_adapters%40", zzpi.zzc(com_google_android_gms_internal_zzqw.getContext(), (String) map.get("check_adapters"), this.zzTQ.zzTK));
                        com_google_android_gms_internal_zznh.setUrl(replaceAll);
                        url = "Ad request URL modified to ";
                        replaceAll = String.valueOf(replaceAll);
                        zzpk.m4709v(replaceAll.length() != 0 ? url.concat(replaceAll) : new String(url));
                    }
                    this.zzTQ.zzTL.zzh(com_google_android_gms_internal_zznh);
                    return;
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzne.3 */
    class C13353 implements zzid {
        final /* synthetic */ zzne zzTQ;

        C13353(zzne com_google_android_gms_internal_zzne) {
            this.zzTQ = com_google_android_gms_internal_zzne;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            synchronized (this.zzTQ.zzrJ) {
                if (this.zzTQ.zzTL.isDone()) {
                    return;
                }
                zznh com_google_android_gms_internal_zznh = new zznh(-2, map);
                if (this.zzTQ.zzOV.equals(com_google_android_gms_internal_zznh.getRequestId())) {
                    this.zzTQ.zzTL.zzh(com_google_android_gms_internal_zznh);
                    return;
                }
            }
        }
    }

    public zzne(String str, String str2) {
        this.zzrJ = new Object();
        this.zzTL = new zzqj();
        this.zzTN = new C13331(this);
        this.zzTO = new C13342(this);
        this.zzTP = new C13353(this);
        this.zzTK = str2;
        this.zzOV = str;
    }

    public void zzb(zzc com_google_android_gms_internal_zzji_zzc) {
        this.zzTM = com_google_android_gms_internal_zzji_zzc;
    }

    public zzc zzjv() {
        return this.zzTM;
    }

    public Future<zznh> zzjw() {
        return this.zzTL;
    }
}
