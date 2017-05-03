package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzu;
import java.util.HashSet;
import java.util.Set;

public class zzsp {
    private final zzsc zzabn;
    private volatile Boolean zzaeZ;
    private String zzafa;
    private Set<Integer> zzafb;

    protected zzsp(zzsc com_google_android_gms_internal_zzsc) {
        zzac.zzw(com_google_android_gms_internal_zzsc);
        this.zzabn = com_google_android_gms_internal_zzsc;
    }

    public boolean zzoW() {
        if (this.zzaeZ == null) {
            synchronized (this) {
                if (this.zzaeZ == null) {
                    ApplicationInfo applicationInfo = this.zzabn.getContext().getApplicationInfo();
                    String zzzr = zzu.zzzr();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(zzzr);
                        this.zzaeZ = Boolean.valueOf(z);
                    }
                    if ((this.zzaeZ == null || !this.zzaeZ.booleanValue()) && "com.google.android.gms.analytics".equals(zzzr)) {
                        this.zzaeZ = Boolean.TRUE;
                    }
                    if (this.zzaeZ == null) {
                        this.zzaeZ = Boolean.TRUE;
                        this.zzabn.zznS().zzbT("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzaeZ.booleanValue();
    }

    public boolean zzoX() {
        return ((Boolean) zzsw.zzafk.get()).booleanValue();
    }

    public int zzoY() {
        return ((Integer) zzsw.zzafD.get()).intValue();
    }

    public int zzoZ() {
        return ((Integer) zzsw.zzafH.get()).intValue();
    }

    public int zzpa() {
        return ((Integer) zzsw.zzafI.get()).intValue();
    }

    public int zzpb() {
        return ((Integer) zzsw.zzafJ.get()).intValue();
    }

    public long zzpc() {
        return ((Long) zzsw.zzafs.get()).longValue();
    }

    public long zzpd() {
        return ((Long) zzsw.zzafr.get()).longValue();
    }

    public long zzpe() {
        return ((Long) zzsw.zzafv.get()).longValue();
    }

    public long zzpf() {
        return ((Long) zzsw.zzafw.get()).longValue();
    }

    public int zzpg() {
        return ((Integer) zzsw.zzafx.get()).intValue();
    }

    public int zzph() {
        return ((Integer) zzsw.zzafy.get()).intValue();
    }

    public long zzpi() {
        return (long) ((Integer) zzsw.zzafL.get()).intValue();
    }

    public String zzpj() {
        return (String) zzsw.zzafA.get();
    }

    public String zzpk() {
        return (String) zzsw.zzafz.get();
    }

    public String zzpl() {
        return (String) zzsw.zzafB.get();
    }

    public String zzpm() {
        return (String) zzsw.zzafC.get();
    }

    public zzsj zzpn() {
        return zzsj.zzbY((String) zzsw.zzafE.get());
    }

    public zzsm zzpo() {
        return zzsm.zzbZ((String) zzsw.zzafF.get());
    }

    public Set<Integer> zzpp() {
        String str = (String) zzsw.zzafK.get();
        if (this.zzafb == null || this.zzafa == null || !this.zzafa.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.zzafa = str;
            this.zzafb = hashSet;
        }
        return this.zzafb;
    }

    public long zzpq() {
        return ((Long) zzsw.zzafT.get()).longValue();
    }

    public long zzpr() {
        return ((Long) zzsw.zzafU.get()).longValue();
    }

    public long zzps() {
        return ((Long) zzsw.zzafX.get()).longValue();
    }

    public int zzpt() {
        return ((Integer) zzsw.zzafo.get()).intValue();
    }

    public int zzpu() {
        return ((Integer) zzsw.zzafq.get()).intValue();
    }

    public String zzpv() {
        return "google_analytics_v4.db";
    }

    public int zzpw() {
        return ((Integer) zzsw.zzafN.get()).intValue();
    }

    public int zzpx() {
        return ((Integer) zzsw.zzafO.get()).intValue();
    }

    public long zzpy() {
        return ((Long) zzsw.zzafP.get()).longValue();
    }

    public long zzpz() {
        return ((Long) zzsw.zzafY.get()).longValue();
    }
}
