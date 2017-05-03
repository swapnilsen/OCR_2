package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class zzzk {
    @Deprecated
    public static final Api<NoOptions> API;
    public static final zzf<zzzp> zzaid;
    public static final com.google.android.gms.common.api.Api.zza<zzzp, NoOptions> zzaie;
    private final String zzRg;
    private final int zzaxp;
    private String zzaxq;
    private int zzaxr;
    private String zzaxs;
    private String zzaxt;
    private final boolean zzaxu;
    private int zzaxv;
    private final zzzl zzaxw;
    private zzd zzaxx;
    private final zzb zzaxy;
    private final zze zzuP;

    /* renamed from: com.google.android.gms.internal.zzzk.1 */
    class C14241 extends com.google.android.gms.common.api.Api.zza<zzzp, NoOptions> {
        C14241() {
        }

        public /* synthetic */ Api.zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zze(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzzp zze(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzzp(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public class zza {
        private ArrayList<Integer> zzaxA;
        private ArrayList<String> zzaxB;
        private ArrayList<Integer> zzaxC;
        private ArrayList<byte[]> zzaxD;
        private boolean zzaxE;
        private final com.google.android.gms.internal.zzbxy.zzd zzaxF;
        private boolean zzaxG;
        final /* synthetic */ zzzk zzaxH;
        private String zzaxq;
        private int zzaxr;
        private String zzaxs;
        private String zzaxt;
        private int zzaxv;
        private final zzc zzaxz;

        private zza(zzzk com_google_android_gms_internal_zzzk, byte[] bArr) {
            this(com_google_android_gms_internal_zzzk, bArr, null);
        }

        private zza(zzzk com_google_android_gms_internal_zzzk, byte[] bArr, zzc com_google_android_gms_internal_zzzk_zzc) {
            this.zzaxH = com_google_android_gms_internal_zzzk;
            this.zzaxr = this.zzaxH.zzaxr;
            this.zzaxq = this.zzaxH.zzaxq;
            this.zzaxs = this.zzaxH.zzaxs;
            this.zzaxt = this.zzaxH.zzaxt;
            this.zzaxv = 0;
            this.zzaxA = null;
            this.zzaxB = null;
            this.zzaxC = null;
            this.zzaxD = null;
            this.zzaxE = true;
            this.zzaxF = new com.google.android.gms.internal.zzbxy.zzd();
            this.zzaxG = false;
            this.zzaxs = com_google_android_gms_internal_zzzk.zzaxs;
            this.zzaxt = com_google_android_gms_internal_zzzk.zzaxt;
            this.zzaxF.zzcvr = com_google_android_gms_internal_zzzk.zzuP.currentTimeMillis();
            this.zzaxF.zzcvs = com_google_android_gms_internal_zzzk.zzuP.elapsedRealtime();
            this.zzaxF.zzcvD = com_google_android_gms_internal_zzzk.zzaxx.zzH(this.zzaxF.zzcvr);
            if (bArr != null) {
                this.zzaxF.zzcvy = bArr;
            }
            this.zzaxz = com_google_android_gms_internal_zzzk_zzc;
        }

        public zza zzcq(int i) {
            this.zzaxF.zzcvu = i;
            return this;
        }

        public zza zzcr(int i) {
            this.zzaxF.zzri = i;
            return this;
        }

        @Deprecated
        public PendingResult<Status> zze(GoogleApiClient googleApiClient) {
            return zzuU();
        }

        public zzzm zzuT() {
            return new zzzm(new zzzu(this.zzaxH.zzRg, this.zzaxH.zzaxp, this.zzaxr, this.zzaxq, this.zzaxs, this.zzaxt, this.zzaxH.zzaxu, this.zzaxv), this.zzaxF, this.zzaxz, null, zzzk.zzb(null), zzzk.zzc(null), zzzk.zzb(null), zzzk.zzd(null), this.zzaxE);
        }

        @Deprecated
        public PendingResult<Status> zzuU() {
            if (this.zzaxG) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzaxG = true;
            zzzm zzuT = zzuT();
            zzzu com_google_android_gms_internal_zzzu = zzuT.zzaxI;
            return this.zzaxH.zzaxy.zzh(com_google_android_gms_internal_zzzu.zzaye, com_google_android_gms_internal_zzzu.zzaya) ? this.zzaxH.zzaxw.zza(zzuT) : PendingResults.immediatePendingResult(Status.zzazx);
        }
    }

    public interface zzb {
        boolean zzh(String str, int i);
    }

    public interface zzc {
        byte[] zzuV();
    }

    public static class zzd {
        public long zzH(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / PointerIconCompat.TYPE_DEFAULT);
        }
    }

    static {
        zzaid = new zzf();
        zzaie = new C14241();
        API = new Api("ClearcutLogger.API", zzaie, zzaid);
    }

    public zzzk(Context context, int i, String str, String str2, String str3, boolean z, zzzl com_google_android_gms_internal_zzzl, zze com_google_android_gms_common_util_zze, zzd com_google_android_gms_internal_zzzk_zzd, zzb com_google_android_gms_internal_zzzk_zzb) {
        boolean z2 = false;
        this.zzaxr = -1;
        this.zzaxv = 0;
        this.zzRg = context.getPackageName();
        this.zzaxp = zzaz(context);
        this.zzaxr = i;
        this.zzaxq = str;
        this.zzaxs = str2;
        this.zzaxt = str3;
        this.zzaxu = z;
        this.zzaxw = com_google_android_gms_internal_zzzl;
        this.zzuP = com_google_android_gms_common_util_zze;
        if (com_google_android_gms_internal_zzzk_zzd == null) {
            com_google_android_gms_internal_zzzk_zzd = new zzd();
        }
        this.zzaxx = com_google_android_gms_internal_zzzk_zzd;
        this.zzaxv = 0;
        this.zzaxy = com_google_android_gms_internal_zzzk_zzb;
        if (this.zzaxu) {
            if (this.zzaxs == null) {
                z2 = true;
            }
            zzac.zzb(z2, (Object) "can't be anonymous with an upload account");
        }
    }

    public zzzk(Context context, String str, String str2) {
        this(context, -1, str, str2, null, false, zzzo.zzaA(context), zzi.zzzc(), null, new zzzt(context));
    }

    private int zzaz(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return i;
        }
    }

    private static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            iArr[i] = ((Integer) it.next()).intValue();
            i = i2;
        }
        return iArr;
    }

    private static String[] zzc(ArrayList<String> arrayList) {
        return arrayList == null ? null : (String[]) arrayList.toArray(new String[0]);
    }

    private static byte[][] zzd(ArrayList<byte[]> arrayList) {
        return arrayList == null ? null : (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public zza zzm(byte[] bArr) {
        return new zza(bArr, null);
    }
}
