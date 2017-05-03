package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import p000a.p001a.p002a.p003a.Fabric;

/* renamed from: a.a.a.a.a.b.d */
class AdvertisingInfoReflectionStrategy implements AdvertisingInfoStrategy {
    private final Context f12a;

    public AdvertisingInfoReflectionStrategy(Context context) {
        this.f12a = context.getApplicationContext();
    }

    boolean m26a(Context context) {
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public AdvertisingInfo m25a() {
        if (m26a(this.f12a)) {
            return new AdvertisingInfo(m22b(), m23c());
        }
        return null;
    }

    private String m22b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m24d(), new Object[0]);
        } catch (Exception e) {
            Fabric.m397h().m364d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean m23c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m24d(), new Object[0])).booleanValue();
        } catch (Exception e) {
            Fabric.m397h().m364d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object m24d() {
        Object obj = null;
        try {
            obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f12a});
        } catch (Exception e) {
            Fabric.m397h().m364d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
        }
        return obj;
    }
}
