package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.internal.zzazf;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class zze extends zzl<zzd> {
    private Person zzbBT;
    private final zzh zzbBU;

    static final class zza implements LoadPeopleResult {
        private final Status zzair;
        private final String zzbBV;
        private final PersonBuffer zzbBW;

        public zza(Status status, DataHolder dataHolder, String str) {
            this.zzair = status;
            this.zzbBV = str;
            this.zzbBW = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        public String getNextPageToken() {
            return this.zzbBV;
        }

        public PersonBuffer getPersonBuffer() {
            return this.zzbBW;
        }

        public Status getStatus() {
            return this.zzair;
        }

        public void release() {
            if (this.zzbBW != null) {
                this.zzbBW.release();
            }
        }
    }

    static final class zzb extends zza {
        private final com.google.android.gms.internal.zzaad.zzb<LoadPeopleResult> zzbkL;

        public zzb(com.google.android.gms.internal.zzaad.zzb<LoadPeopleResult> com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
            this.zzbkL = com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult;
        }

        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzxf() != null ? (PendingIntent) dataHolder.zzxf().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzbkL.setResult(new zza(status, dataHolder, str));
        }
    }

    static final class zzc extends zza {
        private final com.google.android.gms.internal.zzaad.zzb<Status> zzbkL;

        public zzc(com.google.android.gms.internal.zzaad.zzb<Status> com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_common_api_Status) {
            this.zzbkL = com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzk(int i, Bundle bundle) {
            this.zzbkL.setResult(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, zzh com_google_android_gms_plus_internal_zzh, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzbBU = com_google_android_gms_plus_internal_zzh;
    }

    public static boolean zze(Set<Scope> set) {
        return (set == null || set.isEmpty()) ? false : (set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    public String getAccountName() {
        zzxC();
        try {
            return ((zzd) zzxD()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzOW() {
        zzxC();
        try {
            this.zzbBT = null;
            ((zzd) zzxD()).zzOW();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person zzOY() {
        zzxC();
        return this.zzbBT;
    }

    public zzs zza(com.google.android.gms.internal.zzaad.zzb<LoadPeopleResult> com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult, int i, String str) {
        zzxC();
        Object com_google_android_gms_plus_internal_zze_zzb = new zzb(com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            return ((zzd) zzxD()).zza(com_google_android_gms_plus_internal_zze_zzb, 1, i, -1, str);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzb.zza(DataHolder.zzcJ(8), null);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzbBT = zzazf.zzG(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(com.google.android.gms.internal.zzaad.zzb<LoadPeopleResult> com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Collection<String> collection) {
        zzxC();
        zzb com_google_android_gms_plus_internal_zze_zzb = new zzb(com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzxD()).zza(com_google_android_gms_plus_internal_zze_zzb, new ArrayList(collection));
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzb.zza(DataHolder.zzcJ(8), null);
        }
    }

    public void zzd(com.google.android.gms.internal.zzaad.zzb<LoadPeopleResult> com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String[] strArr) {
        zza(com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Arrays.asList(strArr));
    }

    protected String zzeA() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected zzd zzeW(IBinder iBinder) {
        return com.google.android.gms.plus.internal.zzd.zza.zzeV(iBinder);
    }

    protected String zzez() {
        return "com.google.android.gms.plus.service.START";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzeW(iBinder);
    }

    protected Bundle zzqL() {
        Bundle zzPi = this.zzbBU.zzPi();
        zzPi.putStringArray("request_visible_actions", this.zzbBU.zzPc());
        zzPi.putString("auth_package", this.zzbBU.zzPe());
        return zzPi;
    }

    public boolean zzrd() {
        return zze(zzxW().zzc(Plus.API));
    }

    public zzs zzu(com.google.android.gms.internal.zzaad.zzb<LoadPeopleResult> com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String str) {
        return zza(com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult, 0, str);
    }

    public void zzu(com.google.android.gms.internal.zzaad.zzb<LoadPeopleResult> com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
        zzxC();
        Object com_google_android_gms_plus_internal_zze_zzb = new zzb(com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzxD()).zza(com_google_android_gms_plus_internal_zze_zzb, 2, 1, -1, null);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzb.zza(DataHolder.zzcJ(8), null);
        }
    }

    public void zzv(com.google.android.gms.internal.zzaad.zzb<Status> com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_common_api_Status) {
        zzxC();
        zzOW();
        Object com_google_android_gms_plus_internal_zze_zzc = new zzc(com_google_android_gms_internal_zzaad_zzb_com_google_android_gms_common_api_Status);
        try {
            ((zzd) zzxD()).zzb(com_google_android_gms_plus_internal_zze_zzc);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzc.zzk(8, null);
        }
    }
}
