package com.google.android.gms.internal;

import com.google.android.gms.internal.zzay.zza;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzbz {
    protected static final String TAG;
    private final String className;
    private final zzbd zzpz;
    private final String zzrc;
    private final int zzrd;
    private volatile Method zzre;
    private List<Class> zzrf;
    private CountDownLatch zzrg;

    /* renamed from: com.google.android.gms.internal.zzbz.1 */
    class C11311 implements Runnable {
        final /* synthetic */ zzbz zzrh;

        C11311(zzbz com_google_android_gms_internal_zzbz) {
            this.zzrh = com_google_android_gms_internal_zzbz;
        }

        public void run() {
            this.zzrh.zzbl();
        }
    }

    static {
        TAG = zzbz.class.getSimpleName();
    }

    public zzbz(zzbd com_google_android_gms_internal_zzbd, String str, String str2, List<Class> list) {
        this.zzrd = 2;
        this.zzre = null;
        this.zzrg = new CountDownLatch(1);
        this.zzpz = com_google_android_gms_internal_zzbd;
        this.className = str;
        this.zzrc = str2;
        this.zzrf = new ArrayList(list);
        this.zzpz.zzaI().submit(new C11311(this));
    }

    private void zzbl() {
        try {
            Class loadClass = this.zzpz.zzaJ().loadClass(zzd(this.zzpz.zzaL(), this.className));
            if (loadClass != null) {
                this.zzre = loadClass.getMethod(zzd(this.zzpz.zzaL(), this.zzrc), (Class[]) this.zzrf.toArray(new Class[this.zzrf.size()]));
                if (this.zzre == null) {
                    this.zzrg.countDown();
                } else {
                    this.zzrg.countDown();
                }
            }
        } catch (zza e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.zzrg.countDown();
        }
    }

    private String zzd(byte[] bArr, String str) {
        return new String(this.zzpz.zzaK().zzc(bArr, str), "UTF-8");
    }

    public Method zzbm() {
        if (this.zzre != null) {
            return this.zzre;
        }
        try {
            return this.zzrg.await(2, TimeUnit.SECONDS) ? this.zzre : null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
