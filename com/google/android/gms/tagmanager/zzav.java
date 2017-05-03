package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzav extends Thread implements zzau {
    private static zzav zzbGq;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean zzNA;
    private final LinkedBlockingQueue<Runnable> zzbGp;
    private volatile zzaw zzbGr;

    /* renamed from: com.google.android.gms.tagmanager.zzav.1 */
    class C14431 implements Runnable {
        final /* synthetic */ zzau zzbGs;
        final /* synthetic */ long zzbGt;
        final /* synthetic */ zzav zzbGu;
        final /* synthetic */ String zzsg;

        C14431(zzav com_google_android_gms_tagmanager_zzav, zzau com_google_android_gms_tagmanager_zzau, long j, String str) {
            this.zzbGu = com_google_android_gms_tagmanager_zzav;
            this.zzbGs = com_google_android_gms_tagmanager_zzau;
            this.zzbGt = j;
            this.zzsg = str;
        }

        public void run() {
            if (this.zzbGu.zzbGr == null) {
                zzdc zzRy = zzdc.zzRy();
                zzRy.zza(this.zzbGu.mContext, this.zzbGs);
                this.zzbGu.zzbGr = zzRy.zzRB();
            }
            this.zzbGu.zzbGr.zzg(this.zzbGt, this.zzsg);
        }
    }

    private zzav(Context context) {
        super("GAThread");
        this.zzbGp = new LinkedBlockingQueue();
        this.zzNA = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static zzav zzca(Context context) {
        if (zzbGq == null) {
            zzbGq = new zzav(context);
        }
        return zzbGq;
    }

    private String zzg(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void run() {
        while (true) {
            boolean z = this.mClosed;
            try {
                Runnable runnable = (Runnable) this.zzbGp.take();
                if (!this.zzNA) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                zzbo.zzbg(e.toString());
            } catch (Throwable th) {
                String str = "Error on Google TagManager Thread: ";
                String valueOf = String.valueOf(zzg(th));
                zzbo.m4711e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                zzbo.m4711e("Google TagManager is shutting down.");
                this.zzNA = true;
            }
        }
    }

    public void zzhj(String str) {
        zzp(str, System.currentTimeMillis());
    }

    public void zzp(Runnable runnable) {
        this.zzbGp.add(runnable);
    }

    void zzp(String str, long j) {
        zzp(new C14431(this, this, j, str));
    }
}
