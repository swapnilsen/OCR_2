package p000a.p001a.p002a.p003a;

import p000a.p001a.p002a.p003a.p004a.p006b.TimingMetric;
import p000a.p001a.p002a.p003a.p004a.p007c.Priority;
import p000a.p001a.p002a.p003a.p004a.p007c.PriorityAsyncTask;
import p000a.p001a.p002a.p003a.p004a.p007c.UnmetDependencyException;

/* renamed from: a.a.a.a.h */
class InitializationTask<Result> extends PriorityAsyncTask<Void, Void, Result> {
    final Kit<Result> f325a;

    public InitializationTask(Kit<Result> kit) {
        this.f325a = kit;
    }

    protected void m419a() {
        super.m157a();
        TimingMetric a = m416a("onPreExecute");
        try {
            boolean onPreExecute = this.f325a.onPreExecute();
            a.m143b();
            if (!onPreExecute) {
                m159a(true);
            }
        } catch (UnmetDependencyException e) {
            throw e;
        } catch (Throwable e2) {
            Fabric.m397h().m367e("Fabric", "Failure onPreExecute()", e2);
            a.m143b();
            m159a(true);
        } catch (Throwable th) {
            a.m143b();
            m159a(true);
        }
    }

    protected Result m418a(Void... voidArr) {
        TimingMetric a = m416a("doInBackground");
        Result result = null;
        if (!m164d()) {
            result = this.f325a.doInBackground();
        }
        a.m143b();
        return result;
    }

    protected void m420a(Result result) {
        this.f325a.onPostExecute(result);
        this.f325a.initializationCallback.m382a((Object) result);
    }

    protected void m421b(Result result) {
        this.f325a.onCancelled(result);
        this.f325a.initializationCallback.m381a(new InitializationException(this.f325a.getIdentifier() + " Initialization was cancelled"));
    }

    public Priority getPriority() {
        return Priority.HIGH;
    }

    private TimingMetric m416a(String str) {
        TimingMetric timingMetric = new TimingMetric(this.f325a.getIdentifier() + "." + str, "KitInitialization");
        timingMetric.m142a();
        return timingMetric;
    }
}
