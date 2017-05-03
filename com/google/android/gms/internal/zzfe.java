package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzme
public final class zzfe {
    private final Bundle zzAa;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzAb;
    private final SearchAdRequest zzAc;
    private final Set<String> zzAd;
    private final Set<String> zzAe;
    private final Date zzcR;
    private final Set<String> zzcT;
    private final Location zzcV;
    private final boolean zzsS;
    private final int zzzk;
    private final int zzzn;
    private final String zzzo;
    private final String zzzq;
    private final Bundle zzzs;
    private final String zzzu;
    private final boolean zzzw;

    public static final class zza {
        private final Bundle zzAa;
        private final HashSet<String> zzAf;
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzAg;
        private final HashSet<String> zzAh;
        private final HashSet<String> zzAi;
        private Date zzcR;
        private Location zzcV;
        private boolean zzsS;
        private int zzzk;
        private int zzzn;
        private String zzzo;
        private String zzzq;
        private final Bundle zzzs;
        private String zzzu;
        private boolean zzzw;

        public zza() {
            this.zzAf = new HashSet();
            this.zzAa = new Bundle();
            this.zzAg = new HashMap();
            this.zzAh = new HashSet();
            this.zzzs = new Bundle();
            this.zzAi = new HashSet();
            this.zzzk = -1;
            this.zzsS = false;
            this.zzzn = -1;
        }

        public void setManualImpressionsEnabled(boolean z) {
            this.zzsS = z;
        }

        public void zzL(String str) {
            this.zzAf.add(str);
        }

        public void zzM(String str) {
            this.zzAh.add(str);
        }

        public void zzN(String str) {
            this.zzAh.remove(str);
        }

        public void zzO(String str) {
            this.zzzq = str;
        }

        public void zzP(String str) {
            this.zzzo = str;
        }

        public void zzQ(String str) {
            this.zzzu = str;
        }

        public void zzR(String str) {
            this.zzAi.add(str);
        }

        @Deprecated
        public void zza(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.zzAg.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void zza(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzAa.putBundle(cls.getName(), bundle);
        }

        public void zza(Date date) {
            this.zzcR = date;
        }

        public void zzb(Location location) {
            this.zzcV = location;
        }

        public void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.zzAa.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.zzAa.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.zzAa.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void zzf(String str, String str2) {
            this.zzzs.putString(str, str2);
        }

        public void zzo(boolean z) {
            this.zzzn = z ? 1 : 0;
        }

        public void zzp(boolean z) {
            this.zzzw = z;
        }

        public void zzy(int i) {
            this.zzzk = i;
        }
    }

    public zzfe(zza com_google_android_gms_internal_zzfe_zza) {
        this(com_google_android_gms_internal_zzfe_zza, null);
    }

    public zzfe(zza com_google_android_gms_internal_zzfe_zza, SearchAdRequest searchAdRequest) {
        this.zzcR = com_google_android_gms_internal_zzfe_zza.zzcR;
        this.zzzq = com_google_android_gms_internal_zzfe_zza.zzzq;
        this.zzzk = com_google_android_gms_internal_zzfe_zza.zzzk;
        this.zzcT = Collections.unmodifiableSet(com_google_android_gms_internal_zzfe_zza.zzAf);
        this.zzcV = com_google_android_gms_internal_zzfe_zza.zzcV;
        this.zzsS = com_google_android_gms_internal_zzfe_zza.zzsS;
        this.zzAa = com_google_android_gms_internal_zzfe_zza.zzAa;
        this.zzAb = Collections.unmodifiableMap(com_google_android_gms_internal_zzfe_zza.zzAg);
        this.zzzo = com_google_android_gms_internal_zzfe_zza.zzzo;
        this.zzzu = com_google_android_gms_internal_zzfe_zza.zzzu;
        this.zzAc = searchAdRequest;
        this.zzzn = com_google_android_gms_internal_zzfe_zza.zzzn;
        this.zzAd = Collections.unmodifiableSet(com_google_android_gms_internal_zzfe_zza.zzAh);
        this.zzzs = com_google_android_gms_internal_zzfe_zza.zzzs;
        this.zzAe = Collections.unmodifiableSet(com_google_android_gms_internal_zzfe_zza.zzAi);
        this.zzzw = com_google_android_gms_internal_zzfe_zza.zzzw;
    }

    public Date getBirthday() {
        return this.zzcR;
    }

    public String getContentUrl() {
        return this.zzzq;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzAa.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(cls.getName()) : null;
    }

    public Bundle getCustomTargeting() {
        return this.zzzs;
    }

    public int getGender() {
        return this.zzzk;
    }

    public Set<String> getKeywords() {
        return this.zzcT;
    }

    public Location getLocation() {
        return this.zzcV;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zzsS;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzAb.get(cls);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzAa.getBundle(cls.getName());
    }

    public String getPublisherProvidedId() {
        return this.zzzo;
    }

    public boolean isDesignedForFamilies() {
        return this.zzzw;
    }

    public boolean isTestDevice(Context context) {
        return this.zzAd.contains(zzel.zzeT().zzad(context));
    }

    public String zzfb() {
        return this.zzzu;
    }

    public SearchAdRequest zzfc() {
        return this.zzAc;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> zzfd() {
        return this.zzAb;
    }

    public Bundle zzfe() {
        return this.zzAa;
    }

    public int zzff() {
        return this.zzzn;
    }

    public Set<String> zzfg() {
        return this.zzAe;
    }
}
