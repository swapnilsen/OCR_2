package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class zzaze implements People {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<LoadPeopleResult> {

        /* renamed from: com.google.android.gms.internal.zzaze.zza.1 */
        class C11191 implements LoadPeopleResult {
            final /* synthetic */ Status zzanl;

            C11191(zza com_google_android_gms_internal_zzaze_zza, Status status) {
                this.zzanl = status;
            }

            public String getNextPageToken() {
                return null;
            }

            public PersonBuffer getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return this.zzanl;
            }

            public void release() {
            }
        }

        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPeopleResult zzbB(Status status) {
            return new C11191(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbB(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaze.1 */
    class C11141 extends zza {
        final /* synthetic */ int zzbCh;
        final /* synthetic */ String zzbCi;

        C11141(zzaze com_google_android_gms_internal_zzaze, GoogleApiClient googleApiClient, int i, String str) {
            this.zzbCh = i;
            this.zzbCi = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            zza(com_google_android_gms_plus_internal_zze.zza(this, this.zzbCh, this.zzbCi));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaze.2 */
    class C11152 extends zza {
        final /* synthetic */ String zzbCi;

        C11152(zzaze com_google_android_gms_internal_zzaze, GoogleApiClient googleApiClient, String str) {
            this.zzbCi = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            zza(com_google_android_gms_plus_internal_zze.zzu(this, this.zzbCi));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaze.3 */
    class C11163 extends zza {
        C11163(zzaze com_google_android_gms_internal_zzaze, GoogleApiClient googleApiClient) {
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzu(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaze.4 */
    class C11174 extends zza {
        final /* synthetic */ Collection zzbCj;

        C11174(zzaze com_google_android_gms_internal_zzaze, GoogleApiClient googleApiClient, Collection collection) {
            this.zzbCj = collection;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zza(this, this.zzbCj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaze.5 */
    class C11185 extends zza {
        final /* synthetic */ String[] zzbCk;

        C11185(zzaze com_google_android_gms_internal_zzaze, GoogleApiClient googleApiClient, String[] strArr) {
            this.zzbCk = strArr;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzd(this, this.zzbCk);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzd(googleApiClient, true).zzOY();
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> collection) {
        return googleApiClient.zza(new C11174(this, googleApiClient, collection));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, String... strArr) {
        return googleApiClient.zza(new C11185(this, googleApiClient, strArr));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C11163(this, googleApiClient));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int i, String str) {
        return googleApiClient.zza(new C11141(this, googleApiClient, i, str));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new C11152(this, googleApiClient, str));
    }
}
