package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzac;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.UUID;

public class zztg extends zzsa {
    private SharedPreferences zzagD;
    private long zzagE;
    private long zzagF;
    private final zza zzagG;

    public final class zza {
        private final String mName;
        private final long zzagH;
        final /* synthetic */ zztg zzagI;

        private zza(zztg com_google_android_gms_internal_zztg, String str, long j) {
            this.zzagI = com_google_android_gms_internal_zztg;
            zzac.zzdr(str);
            zzac.zzax(j > 0);
            this.mName = str;
            this.zzagH = j;
        }

        private void zzqk() {
            long currentTimeMillis = this.zzagI.zznR().currentTimeMillis();
            Editor edit = this.zzagI.zzagD.edit();
            edit.remove(zzqp());
            edit.remove(zzqq());
            edit.putLong(zzqo(), currentTimeMillis);
            edit.commit();
        }

        private long zzql() {
            long zzqn = zzqn();
            return zzqn == 0 ? 0 : Math.abs(zzqn - this.zzagI.zznR().currentTimeMillis());
        }

        private long zzqn() {
            return this.zzagI.zzagD.getLong(zzqo(), 0);
        }

        private String zzqo() {
            return String.valueOf(this.mName).concat(":start");
        }

        private String zzqp() {
            return String.valueOf(this.mName).concat(":count");
        }

        public void zzcc(String str) {
            if (zzqn() == 0) {
                zzqk();
            }
            if (str == null) {
                str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            }
            synchronized (this) {
                long j = this.zzagI.zzagD.getLong(zzqp(), 0);
                if (j <= 0) {
                    Editor edit = this.zzagI.zzagD.edit();
                    edit.putString(zzqq(), str);
                    edit.putLong(zzqp(), 1);
                    edit.apply();
                    return;
                }
                Object obj = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1) ? 1 : null;
                Editor edit2 = this.zzagI.zzagD.edit();
                if (obj != null) {
                    edit2.putString(zzqq(), str);
                }
                edit2.putLong(zzqp(), j + 1);
                edit2.apply();
            }
        }

        public Pair<String, Long> zzqm() {
            long zzql = zzql();
            if (zzql < this.zzagH) {
                return null;
            }
            if (zzql > this.zzagH * 2) {
                zzqk();
                return null;
            }
            String string = this.zzagI.zzagD.getString(zzqq(), null);
            zzql = this.zzagI.zzagD.getLong(zzqp(), 0);
            zzqk();
            return (string == null || zzql <= 0) ? null : new Pair(string, Long.valueOf(zzql));
        }

        protected String zzqq() {
            return String.valueOf(this.mName).concat(":value");
        }
    }

    protected zztg(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
        this.zzagF = -1;
        this.zzagG = new zza("monitoring", zznT().zzpz(), null);
    }

    public void zzcb(String str) {
        zzmR();
        zzob();
        Editor edit = this.zzagD.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            zzbS("Failed to commit campaign data");
        }
    }

    protected void zzmS() {
        this.zzagD = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public long zzqe() {
        zzmR();
        zzob();
        if (this.zzagE == 0) {
            long j = this.zzagD.getLong("first_run", 0);
            if (j != 0) {
                this.zzagE = j;
            } else {
                j = zznR().currentTimeMillis();
                Editor edit = this.zzagD.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    zzbS("Failed to commit first run time");
                }
                this.zzagE = j;
            }
        }
        return this.zzagE;
    }

    public zztj zzqf() {
        return new zztj(zznR(), zzqe());
    }

    public long zzqg() {
        zzmR();
        zzob();
        if (this.zzagF == -1) {
            this.zzagF = this.zzagD.getLong("last_dispatch", 0);
        }
        return this.zzagF;
    }

    public void zzqh() {
        zzmR();
        zzob();
        long currentTimeMillis = zznR().currentTimeMillis();
        Editor edit = this.zzagD.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.zzagF = currentTimeMillis;
    }

    public String zzqi() {
        zzmR();
        zzob();
        CharSequence string = this.zzagD.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }

    public zza zzqj() {
        return this.zzagG;
    }
}
