package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.internal.zzaaf;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzaaf<BatchResult> {
    private int zzayM;
    private boolean zzayN;
    private boolean zzayO;
    private final PendingResult<?>[] zzayP;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.common.api.Batch.1 */
    class C09791 implements zza {
        final /* synthetic */ Batch zzayQ;

        C09791(Batch batch) {
            this.zzayQ = batch;
        }

        public void zzy(Status status) {
            synchronized (this.zzayQ.zzrJ) {
                if (this.zzayQ.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.zzayQ.zzayO = true;
                } else if (!status.isSuccess()) {
                    this.zzayQ.zzayN = true;
                }
                this.zzayQ.zzayM = this.zzayQ.zzayM - 1;
                if (this.zzayQ.zzayM == 0) {
                    if (this.zzayQ.zzayO) {
                        super.cancel();
                    } else {
                        this.zzayQ.zzb(new BatchResult(this.zzayQ.zzayN ? new Status(13) : Status.zzazx, this.zzayQ.zzayP));
                    }
                }
            }
        }
    }

    public static final class Builder {
        private GoogleApiClient zzanE;
        private List<PendingResult<?>> zzayR;

        public Builder(GoogleApiClient googleApiClient) {
            this.zzayR = new ArrayList();
            this.zzanE = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.zzayR.size());
            this.zzayR.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zzanE, null);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzrJ = new Object();
        this.zzayM = list.size();
        this.zzayP = new PendingResult[this.zzayM];
        if (list.isEmpty()) {
            zzb(new BatchResult(Status.zzazx, this.zzayP));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult pendingResult = (PendingResult) list.get(i);
            this.zzayP[i] = pendingResult;
            pendingResult.zza(new C09791(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.zzayP) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zzayP);
    }

    public /* synthetic */ Result zzc(Status status) {
        return createFailedResult(status);
    }
}
