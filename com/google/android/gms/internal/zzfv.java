package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.Callable;

@zzme
public class zzfv {
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.zzfv.1 */
    class C11791 implements Callable<Boolean> {
        C11791() {
        }

        public /* synthetic */ Object call() {
            return zzbX();
        }

        public Boolean zzbX() {
            return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
        }
    }

    public zzfv(Context context) {
        zzac.zzb((Object) context, (Object) "Context can not be null");
        this.mContext = context;
    }

    public static boolean zzfo() {
        return ((Boolean) zzqb.zzb(new C11791())).booleanValue();
    }

    public boolean zza(Intent intent) {
        zzac.zzb((Object) intent, (Object) "Intent can not be null");
        return !this.mContext.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean zzfl() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public boolean zzfm() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return zza(intent);
    }

    public boolean zzfn() {
        return zzfo() && zzadg.zzbi(this.mContext).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public boolean zzfp() {
        Intent type = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event");
        int i = VERSION.SDK_INT;
        return zza(type);
    }
}
