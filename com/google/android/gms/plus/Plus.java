package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.zzv;
import com.google.android.gms.internal.zzazb;
import com.google.android.gms.internal.zzazc;
import com.google.android.gms.internal.zzazd;
import com.google.android.gms.internal.zzaze;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.internal.zzh;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class Plus {
    @Deprecated
    public static final Api<PlusOptions> API;
    @Deprecated
    public static final Account AccountApi;
    @Deprecated
    public static final People PeopleApi;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    public static final zzf<zze> zzaid;
    static final com.google.android.gms.common.api.Api.zza<zze, PlusOptions> zzaie;
    @Deprecated
    public static final zzb zzbBH;
    public static final zza zzbBI;

    public static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzaad.zza<R, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.zzaid, googleApiClient);
        }

        public /* synthetic */ void setResult(Object obj) {
            super.zzb((Result) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus.1 */
    class C14281 extends com.google.android.gms.common.api.Api.zza<zze, PlusOptions> {
        C14281() {
        }

        public int getPriority() {
            return 2;
        }

        public zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new zze(context, looper, com_google_android_gms_common_internal_zzg, new zzh(com_google_android_gms_common_internal_zzg.zzxB().name, zzv.zzd(com_google_android_gms_common_internal_zzg.zzxM()), (String[]) plusOptions.zzbBK.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class PlusOptions implements Optional {
        final String zzbBJ;
        final Set<String> zzbBK;

        public static final class Builder {
            String zzbBJ;
            final Set<String> zzbBK;

            public Builder() {
                this.zzbBK = new HashSet();
            }

            public Builder addActivityTypes(String... strArr) {
                zzac.zzb((Object) strArr, (Object) "activityTypes may not be null.");
                for (Object add : strArr) {
                    this.zzbBK.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String str) {
                this.zzbBJ = str;
                return this;
            }
        }

        private PlusOptions() {
            this.zzbBJ = null;
            this.zzbBK = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.zzbBJ = builder.zzbBJ;
            this.zzbBK = builder.zzbBK;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    static {
        zzaid = new zzf();
        zzaie = new C14281();
        API = new Api("Plus.API", zzaie, zzaid);
        SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
        SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
        PeopleApi = new zzaze();
        AccountApi = new zzazb();
        zzbBH = new zzazd();
        zzbBI = new zzazc();
    }

    private Plus() {
    }

    public static zze zzd(GoogleApiClient googleApiClient, boolean z) {
        zzac.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzac.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzac.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zze) googleApiClient.zza(zzaid) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
