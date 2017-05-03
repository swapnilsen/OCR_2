package p000a.p001a.p002a.p003a.p004a.p011f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import p000a.p001a.p002a.p003a.Kit;

/* renamed from: a.a.a.a.a.f.d */
public class PreferenceStoreImpl implements PreferenceStore {
    private final SharedPreferences f197a;
    private final String f198b;
    private final Context f199c;

    public PreferenceStoreImpl(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f199c = context;
        this.f198b = str;
        this.f197a = this.f199c.getSharedPreferences(this.f198b, 0);
    }

    @Deprecated
    public PreferenceStoreImpl(Kit kit) {
        this(kit.getContext(), kit.getClass().getName());
    }

    public SharedPreferences m304a() {
        return this.f197a;
    }

    public Editor m306b() {
        return this.f197a.edit();
    }

    @TargetApi(9)
    public boolean m305a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
