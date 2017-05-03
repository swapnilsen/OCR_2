package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zzbIu;
    private final Context mContext;
    private final DataLayer zzbEV;
    private final zzt zzbHu;
    private final zza zzbIr;
    private final zzdb zzbIs;
    private final ConcurrentMap<String, zzo> zzbIt;

    /* renamed from: com.google.android.gms.tagmanager.TagManager.1 */
    class C14371 implements zzb {
        final /* synthetic */ TagManager zzbIv;

        C14371(TagManager tagManager) {
            this.zzbIv = tagManager;
        }

        public void zzaa(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.zzbIv.zzhs(obj.toString());
            }
        }
    }

    public interface zza {
        zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzt com_google_android_gms_tagmanager_zzt);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.2 */
    class C14382 implements zza {
        C14382() {
        }

        public zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzt com_google_android_gms_tagmanager_zzt) {
            return new zzp(context, tagManager, looper, str, i, com_google_android_gms_tagmanager_zzt);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.3 */
    class C14393 implements ComponentCallbacks2 {
        final /* synthetic */ TagManager zzbIv;

        C14393(TagManager tagManager) {
            this.zzbIv = tagManager;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.zzbIv.dispatch();
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.4 */
    static /* synthetic */ class C14404 {
        static final /* synthetic */ int[] zzbIw;

        static {
            zzbIw = new int[zza.values().length];
            try {
                zzbIw[zza.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzbIw[zza.CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzbIw[zza.CONTAINER_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    TagManager(Context context, zza com_google_android_gms_tagmanager_TagManager_zza, DataLayer dataLayer, zzdb com_google_android_gms_tagmanager_zzdb) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzbIs = com_google_android_gms_tagmanager_zzdb;
        this.zzbIr = com_google_android_gms_tagmanager_TagManager_zza;
        this.zzbIt = new ConcurrentHashMap();
        this.zzbEV = dataLayer;
        this.zzbEV.zza(new C14371(this));
        this.zzbEV.zza(new zzd(this.mContext));
        this.zzbHu = new zzt();
        zzRE();
        zzRF();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzbIu == null) {
                if (context == null) {
                    zzbo.m4711e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzbIu = new TagManager(context, new C14382(), new DataLayer(new zzx(context)), zzdc.zzRy());
            }
            tagManager = zzbIu;
        }
        return tagManager;
    }

    @TargetApi(14)
    private void zzRE() {
        int i = VERSION.SDK_INT;
        this.mContext.registerComponentCallbacks(new C14393(this));
    }

    private void zzRF() {
        zza.zzbS(this.mContext);
    }

    private void zzhs(String str) {
        for (zzo zzgU : this.zzbIt.values()) {
            zzgU.zzgU(str);
        }
    }

    public void dispatch() {
        this.zzbIs.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzbEV;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, @RawRes int i) {
        PendingResult zza = this.zzbIr.zza(this.mContext, this, null, str, i, this.zzbHu);
        zza.zzQk();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, @RawRes int i, Handler handler) {
        PendingResult zza = this.zzbIr.zza(this.mContext, this, handler.getLooper(), str, i, this.zzbHu);
        zza.zzQk();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, @RawRes int i) {
        PendingResult zza = this.zzbIr.zza(this.mContext, this, null, str, i, this.zzbHu);
        zza.zzQm();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, @RawRes int i, Handler handler) {
        PendingResult zza = this.zzbIr.zza(this.mContext, this, handler.getLooper(), str, i, this.zzbHu);
        zza.zzQm();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, @RawRes int i) {
        PendingResult zza = this.zzbIr.zza(this.mContext, this, null, str, i, this.zzbHu);
        zza.zzQl();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, @RawRes int i, Handler handler) {
        PendingResult zza = this.zzbIr.zza(this.mContext, this, handler.getLooper(), str, i, this.zzbHu);
        zza.zzQl();
        return zza;
    }

    public void setVerboseLoggingEnabled(boolean z) {
        zzbo.setLogLevel(z ? 2 : 5);
    }

    public int zza(zzo com_google_android_gms_tagmanager_zzo) {
        this.zzbIt.put(com_google_android_gms_tagmanager_zzo.getContainerId(), com_google_android_gms_tagmanager_zzo);
        return this.zzbIt.size();
    }

    public boolean zzb(zzo com_google_android_gms_tagmanager_zzo) {
        return this.zzbIt.remove(com_google_android_gms_tagmanager_zzo.getContainerId()) != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean zzv(android.net.Uri r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r2 = com.google.android.gms.tagmanager.zzcj.zzRe();	 Catch:{ all -> 0x0033 }
        r0 = r2.zzv(r6);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0073;
    L_0x000b:
        r3 = r2.getContainerId();	 Catch:{ all -> 0x0033 }
        r0 = com.google.android.gms.tagmanager.TagManager.C14404.zzbIw;	 Catch:{ all -> 0x0033 }
        r1 = r2.zzRf();	 Catch:{ all -> 0x0033 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x0033 }
        r0 = r0[r1];	 Catch:{ all -> 0x0033 }
        switch(r0) {
            case 1: goto L_0x0021;
            case 2: goto L_0x0036;
            case 3: goto L_0x0036;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = 1;
    L_0x001f:
        monitor-exit(r5);
        return r0;
    L_0x0021:
        r0 = r5.zzbIt;	 Catch:{ all -> 0x0033 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0033 }
        r0 = (com.google.android.gms.tagmanager.zzo) r0;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x001e;
    L_0x002b:
        r1 = 0;
        r0.zzgW(r1);	 Catch:{ all -> 0x0033 }
        r0.refresh();	 Catch:{ all -> 0x0033 }
        goto L_0x001e;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0036:
        r0 = r5.zzbIt;	 Catch:{ all -> 0x0033 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0033 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0033 }
    L_0x0040:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x001e;
    L_0x0046:
        r0 = r4.next();	 Catch:{ all -> 0x0033 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0033 }
        r1 = r5.zzbIt;	 Catch:{ all -> 0x0033 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x0033 }
        r1 = (com.google.android.gms.tagmanager.zzo) r1;	 Catch:{ all -> 0x0033 }
        r0 = r0.equals(r3);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0065;
    L_0x005a:
        r0 = r2.zzRg();	 Catch:{ all -> 0x0033 }
        r1.zzgW(r0);	 Catch:{ all -> 0x0033 }
        r1.refresh();	 Catch:{ all -> 0x0033 }
        goto L_0x0040;
    L_0x0065:
        r0 = r1.zzQh();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0040;
    L_0x006b:
        r0 = 0;
        r1.zzgW(r0);	 Catch:{ all -> 0x0033 }
        r1.refresh();	 Catch:{ all -> 0x0033 }
        goto L_0x0040;
    L_0x0073:
        r0 = 0;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.TagManager.zzv(android.net.Uri):boolean");
    }
}
