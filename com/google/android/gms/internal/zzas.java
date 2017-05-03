package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzae.zza;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public abstract class zzas implements zzar {
    protected MotionEvent zzpF;
    protected LinkedList<MotionEvent> zzpG;
    protected long zzpH;
    protected long zzpI;
    protected long zzpJ;
    protected long zzpK;
    protected long zzpL;
    protected long zzpM;
    protected long zzpN;
    private boolean zzpO;
    protected boolean zzpP;
    protected DisplayMetrics zzpQ;

    protected zzas(Context context) {
        this.zzpG = new LinkedList();
        this.zzpH = 0;
        this.zzpI = 0;
        this.zzpJ = 0;
        this.zzpK = 0;
        this.zzpL = 0;
        this.zzpM = 0;
        this.zzpN = 0;
        this.zzpO = false;
        this.zzpP = false;
        try {
            zzao.zzO();
            this.zzpQ = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
        }
    }

    private String zza(Context context, String str, boolean z, View view, byte[] bArr) {
        boolean z2 = true;
        zza com_google_android_gms_internal_zzae_zza = null;
        if (bArr != null && bArr.length > 0) {
            try {
                com_google_android_gms_internal_zzae_zza = zza.zzc(bArr);
            } catch (zzbxs e) {
            }
        }
        if (z) {
            try {
                zzag.zza zza = zza(context, view);
                this.zzpO = true;
            } catch (NoSuchAlgorithmException e2) {
                return Integer.toString(7);
            } catch (UnsupportedEncodingException e3) {
                return Integer.toString(7);
            } catch (Throwable th) {
                return Integer.toString(3);
            }
        }
        zza = zza(context, com_google_android_gms_internal_zzae_zza);
        if (zza == null || zza.zzaeT() == 0) {
            return Integer.toString(5);
        }
        if (zzb(z)) {
            z2 = false;
        }
        return zzao.zza(zza, str, z2);
    }

    private static boolean zza(zzbe com_google_android_gms_internal_zzbe) {
        return (com_google_android_gms_internal_zzbe == null || com_google_android_gms_internal_zzbe.zzcf == null || com_google_android_gms_internal_zzbe.zzqM == null) ? false : true;
    }

    private boolean zzb(zzbe com_google_android_gms_internal_zzbe) {
        return (this.zzpQ == null || com_google_android_gms_internal_zzbe == null || com_google_android_gms_internal_zzbe.zzcd == null || com_google_android_gms_internal_zzbe.zzqN == null) ? false : true;
    }

    private static boolean zzb(boolean z) {
        return !((Boolean) zzgd.zzDP.get()).booleanValue() ? true : ((Boolean) zzgd.zzDV.get()).booleanValue() && z;
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr);

    protected abstract zzag.zza zza(Context context, View view);

    protected abstract zzag.zza zza(Context context, zza com_google_android_gms_internal_zzae_zza);

    public String zza(Context context, String str, View view) {
        return zza(context, str, true, view, null);
    }

    public String zza(Context context, byte[] bArr) {
        if (!zzbf.zzbc() || !((Boolean) zzgd.zzDU.get()).booleanValue()) {
            return zza(context, null, false, null, bArr);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public void zza(int i, int i2, int i3) {
        if (this.zzpF != null) {
            this.zzpF.recycle();
        }
        if (this.zzpQ != null) {
            this.zzpF = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.zzpQ.density, ((float) i2) * this.zzpQ.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzpF = null;
        }
        this.zzpP = false;
    }

    public void zza(MotionEvent motionEvent) {
        if (this.zzpO) {
            this.zzpK = 0;
            this.zzpJ = 0;
            this.zzpI = 0;
            this.zzpH = 0;
            this.zzpL = 0;
            this.zzpN = 0;
            this.zzpM = 0;
            Iterator it = this.zzpG.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzpG.clear();
            this.zzpF = null;
            this.zzpO = false;
        }
        switch (motionEvent.getAction()) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                this.zzpH++;
                break;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                this.zzpF = MotionEvent.obtain(motionEvent);
                this.zzpG.add(this.zzpF);
                if (this.zzpG.size() > 6) {
                    ((MotionEvent) this.zzpG.remove()).recycle();
                }
                this.zzpJ++;
                try {
                    this.zzpL = zza(new Throwable().getStackTrace());
                    break;
                } catch (zzba e) {
                    break;
                }
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                this.zzpI += (long) (motionEvent.getHistorySize() + 1);
                try {
                    zzbe zzb = zzb(motionEvent);
                    if (zza(zzb)) {
                        this.zzpM += zzb.zzcf.longValue() + zzb.zzqM.longValue();
                    }
                    if (zzb(zzb)) {
                        this.zzpN = (zzb.zzqN.longValue() + zzb.zzcd.longValue()) + this.zzpN;
                        break;
                    }
                } catch (zzba e2) {
                    break;
                }
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                this.zzpK++;
                break;
        }
        this.zzpP = true;
    }

    protected abstract zzbe zzb(MotionEvent motionEvent);

    public String zzb(Context context) {
        if (!zzbf.zzbc() || !((Boolean) zzgd.zzDU.get()).booleanValue()) {
            return zza(context, null, false, null, null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public String zzb(Context context, String str) {
        return zza(context, str, null);
    }
}
