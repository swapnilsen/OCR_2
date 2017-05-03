package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.zza;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzdd;
import com.google.android.gms.internal.zzdn;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzga;
import com.google.android.gms.internal.zzgb;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzjm;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzlq;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.internal.zzqy;

@zzme
public class zzw {
    private static final Object zztX;
    private static zzw zzuD;
    private final zza zzuE;
    private final zzmf zzuF;
    private final zzf zzuG;
    private final zzlq zzuH;
    private final zzpo zzuI;
    private final zzqy zzuJ;
    private final zzpp zzuK;
    private final zzdd zzuL;
    private final zzpe zzuM;
    private final zzdn zzuN;
    private final zzdo zzuO;
    private final zze zzuP;
    private final zzh zzuQ;
    private final zzgg zzuR;
    private final zzps zzuS;
    private final zznj zzuT;
    private final zzga zzuU;
    private final zzgb zzuV;
    private final zzgc zzuW;
    private final zzqo zzuX;
    private final zzi zzuY;
    private final zziz zzuZ;
    private final zzjm zzva;
    private final zzpw zzvb;
    private final zzr zzvc;
    private final zzs zzvd;
    private final zzjw zzve;
    private final zzpx zzvf;
    private final zzr zzvg;
    private final zzir zzvh;
    private final zzqr zzvi;
    private final zzow zzvj;

    static {
        zztX = new Object();
        zza(new zzw());
    }

    protected zzw() {
        this.zzuE = new zza();
        this.zzuF = new zzmf();
        this.zzuG = new zzf();
        this.zzuH = new zzlq();
        this.zzuI = new zzpo();
        this.zzuJ = new zzqy();
        this.zzuK = zzpp.zzaj(VERSION.SDK_INT);
        this.zzuL = new zzdd();
        this.zzuM = new zzpe(this.zzuI);
        this.zzuN = new zzdn();
        this.zzuO = new zzdo();
        this.zzuP = com.google.android.gms.common.util.zzi.zzzc();
        this.zzuQ = new zzh();
        this.zzuR = new zzgg();
        this.zzuS = new zzps();
        this.zzuT = new zznj();
        this.zzuU = new zzga();
        this.zzuV = new zzgb();
        this.zzuW = new zzgc();
        this.zzuX = new zzqo();
        this.zzuY = new zzi();
        this.zzuZ = new zziz();
        this.zzva = new zzjm();
        this.zzvb = new zzpw();
        this.zzvc = new zzr();
        this.zzvd = new zzs();
        this.zzve = new zzjw();
        this.zzvf = new zzpx();
        this.zzvg = new zzr();
        this.zzvh = new zzir();
        this.zzvi = new zzqr();
        this.zzvj = new zzow();
    }

    protected static void zza(zzw com_google_android_gms_ads_internal_zzw) {
        synchronized (zztX) {
            zzuD = com_google_android_gms_ads_internal_zzw;
        }
    }

    private static zzw zzcH() {
        zzw com_google_android_gms_ads_internal_zzw;
        synchronized (zztX) {
            com_google_android_gms_ads_internal_zzw = zzuD;
        }
        return com_google_android_gms_ads_internal_zzw;
    }

    public static zzmf zzcI() {
        return zzcH().zzuF;
    }

    public static zza zzcJ() {
        return zzcH().zzuE;
    }

    public static zzf zzcK() {
        return zzcH().zzuG;
    }

    public static zzlq zzcL() {
        return zzcH().zzuH;
    }

    public static zzpo zzcM() {
        return zzcH().zzuI;
    }

    public static zzqy zzcN() {
        return zzcH().zzuJ;
    }

    public static zzpp zzcO() {
        return zzcH().zzuK;
    }

    public static zzdd zzcP() {
        return zzcH().zzuL;
    }

    public static zzpe zzcQ() {
        return zzcH().zzuM;
    }

    public static zzdo zzcR() {
        return zzcH().zzuO;
    }

    public static zze zzcS() {
        return zzcH().zzuP;
    }

    public static zzgg zzcT() {
        return zzcH().zzuR;
    }

    public static zzps zzcU() {
        return zzcH().zzuS;
    }

    public static zznj zzcV() {
        return zzcH().zzuT;
    }

    public static zzgb zzcW() {
        return zzcH().zzuV;
    }

    public static zzga zzcX() {
        return zzcH().zzuU;
    }

    public static zzgc zzcY() {
        return zzcH().zzuW;
    }

    public static zzqo zzcZ() {
        return zzcH().zzuX;
    }

    public static zzi zzda() {
        return zzcH().zzuY;
    }

    public static zziz zzdb() {
        return zzcH().zzuZ;
    }

    public static zzpw zzdc() {
        return zzcH().zzvb;
    }

    public static zzr zzdd() {
        return zzcH().zzvc;
    }

    public static zzs zzde() {
        return zzcH().zzvd;
    }

    public static zzjw zzdf() {
        return zzcH().zzve;
    }

    public static zzr zzdg() {
        return zzcH().zzvg;
    }

    public static zzpx zzdh() {
        return zzcH().zzvf;
    }

    public static zzh zzdi() {
        return zzcH().zzuQ;
    }

    public static zzir zzdj() {
        return zzcH().zzvh;
    }

    public static zzqr zzdk() {
        return zzcH().zzvi;
    }

    public static zzow zzdl() {
        return zzcH().zzvj;
    }
}
