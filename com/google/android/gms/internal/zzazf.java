package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.appcompat.C0268R;
import android.support.v7.cardview.C0269R;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzazf extends zzact implements Person {
    public static final Creator<zzazf> CREATOR;
    private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
    String zzE;
    String zzGV;
    String zzacX;
    final int zzaiI;
    String zzakb;
    List<zzg> zzbCA;
    int zzbCB;
    int zzbCC;
    String zzbCD;
    List<zzh> zzbCE;
    boolean zzbCF;
    final Set<Integer> zzbCm;
    String zzbCn;
    zza zzbCo;
    String zzbCp;
    String zzbCq;
    int zzbCr;
    zzb zzbCs;
    String zzbCt;
    zzc zzbCu;
    boolean zzbCv;
    zzd zzbCw;
    String zzbCx;
    int zzbCy;
    List<zzf> zzbCz;
    int zzzk;

    public static final class zza extends zzact implements AgeRange {
        public static final Creator<zza> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
        final int zzaiI;
        int zzbCG;
        int zzbCH;
        final Set<Integer> zzbCm;

        static {
            CREATOR = new zzazh();
            zzbCl = new HashMap();
            zzbCl.put("max", com.google.android.gms.internal.zzacs.zza.zzk("max", 2));
            zzbCl.put("min", com.google.android.gms.internal.zzacs.zza.zzk("min", 3));
        }

        public zza() {
            this.zzaiI = 1;
            this.zzbCm = new HashSet();
        }

        zza(Set<Integer> set, int i, int i2, int i3) {
            this.zzbCm = set;
            this.zzaiI = i;
            this.zzbCG = i2;
            this.zzbCH = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza com_google_android_gms_internal_zzazf_zza = (zza) obj;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    if (!com_google_android_gms_internal_zzazf_zza.zza(com_google_android_gms_internal_zzacs_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf_zza.zzb(com_google_android_gms_internal_zzacs_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzazf_zza.zza(com_google_android_gms_internal_zzacs_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzPl();
        }

        public int getMax() {
            return this.zzbCG;
        }

        public int getMin() {
            return this.zzbCH;
        }

        public boolean hasMax() {
            return this.zzbCm.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.zzbCm.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzazh.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
            return zzbCl;
        }

        public zza zzPl() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
        }

        protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    return Integer.valueOf(this.zzbCG);
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    return Integer.valueOf(this.zzbCH);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
            }
        }

        public /* synthetic */ Map zzyr() {
            return zzPj();
        }
    }

    public static final class zzb extends zzact implements Cover {
        public static final Creator<zzb> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
        final int zzaiI;
        zza zzbCI;
        zzb zzbCJ;
        int zzbCK;
        final Set<Integer> zzbCm;

        public static final class zza extends zzact implements CoverInfo {
            public static final Creator<zza> CREATOR;
            private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
            final int zzaiI;
            int zzbCL;
            int zzbCM;
            final Set<Integer> zzbCm;

            static {
                CREATOR = new zzazj();
                zzbCl = new HashMap();
                zzbCl.put("leftImageOffset", com.google.android.gms.internal.zzacs.zza.zzk("leftImageOffset", 2));
                zzbCl.put("topImageOffset", com.google.android.gms.internal.zzacs.zza.zzk("topImageOffset", 3));
            }

            public zza() {
                this.zzaiI = 1;
                this.zzbCm = new HashSet();
            }

            zza(Set<Integer> set, int i, int i2, int i3) {
                this.zzbCm = set;
                this.zzaiI = i;
                this.zzbCL = i2;
                this.zzbCM = i3;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof zza)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                zza com_google_android_gms_internal_zzazf_zzb_zza = (zza) obj;
                for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                    if (zza(com_google_android_gms_internal_zzacs_zza)) {
                        if (!com_google_android_gms_internal_zzazf_zzb_zza.zza(com_google_android_gms_internal_zzacs_zza)) {
                            return false;
                        }
                        if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf_zzb_zza.zzb(com_google_android_gms_internal_zzacs_zza))) {
                            return false;
                        }
                    } else if (com_google_android_gms_internal_zzazf_zzb_zza.zza(com_google_android_gms_internal_zzacs_zza)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzPn();
            }

            public int getLeftImageOffset() {
                return this.zzbCL;
            }

            public int getTopImageOffset() {
                return this.zzbCM;
            }

            public boolean hasLeftImageOffset() {
                return this.zzbCm.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.zzbCm.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                    int hashCode;
                    if (zza(com_google_android_gms_internal_zzacs_zza)) {
                        hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel parcel, int i) {
                zzazj.zza(this, parcel, i);
            }

            public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
                return zzbCl;
            }

            public zza zzPn() {
                return this;
            }

            protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
                return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
            }

            protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
                switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        return Integer.valueOf(this.zzbCL);
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        return Integer.valueOf(this.zzbCM);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
                }
            }

            public /* synthetic */ Map zzyr() {
                return zzPj();
            }
        }

        public static final class zzb extends zzact implements CoverPhoto {
            public static final Creator<zzb> CREATOR;
            private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
            String zzE;
            final int zzaiI;
            final Set<Integer> zzbCm;
            int zzrC;
            int zzrD;

            static {
                CREATOR = new zzazk();
                zzbCl = new HashMap();
                zzbCl.put("height", com.google.android.gms.internal.zzacs.zza.zzk("height", 2));
                zzbCl.put(PlusShare.KEY_CALL_TO_ACTION_URL, com.google.android.gms.internal.zzacs.zza.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzbCl.put("width", com.google.android.gms.internal.zzacs.zza.zzk("width", 4));
            }

            public zzb() {
                this.zzaiI = 1;
                this.zzbCm = new HashSet();
            }

            zzb(Set<Integer> set, int i, int i2, String str, int i3) {
                this.zzbCm = set;
                this.zzaiI = i;
                this.zzrD = i2;
                this.zzE = str;
                this.zzrC = i3;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof zzb)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                zzb com_google_android_gms_internal_zzazf_zzb_zzb = (zzb) obj;
                for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                    if (zza(com_google_android_gms_internal_zzacs_zza)) {
                        if (!com_google_android_gms_internal_zzazf_zzb_zzb.zza(com_google_android_gms_internal_zzacs_zza)) {
                            return false;
                        }
                        if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf_zzb_zzb.zzb(com_google_android_gms_internal_zzacs_zza))) {
                            return false;
                        }
                    } else if (com_google_android_gms_internal_zzazf_zzb_zzb.zza(com_google_android_gms_internal_zzacs_zza)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzPo();
            }

            public int getHeight() {
                return this.zzrD;
            }

            public String getUrl() {
                return this.zzE;
            }

            public int getWidth() {
                return this.zzrC;
            }

            public boolean hasHeight() {
                return this.zzbCm.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.zzbCm.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.zzbCm.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                    int hashCode;
                    if (zza(com_google_android_gms_internal_zzacs_zza)) {
                        hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel parcel, int i) {
                zzazk.zza(this, parcel, i);
            }

            public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
                return zzbCl;
            }

            public zzb zzPo() {
                return this;
            }

            protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
                return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
            }

            protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
                switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        return Integer.valueOf(this.zzrD);
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        return this.zzE;
                    case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                        return Integer.valueOf(this.zzrC);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
                }
            }

            public /* synthetic */ Map zzyr() {
                return zzPj();
            }
        }

        static {
            CREATOR = new zzazi();
            zzbCl = new HashMap();
            zzbCl.put("coverInfo", com.google.android.gms.internal.zzacs.zza.zza("coverInfo", 2, zza.class));
            zzbCl.put("coverPhoto", com.google.android.gms.internal.zzacs.zza.zza("coverPhoto", 3, zzb.class));
            zzbCl.put("layout", com.google.android.gms.internal.zzacs.zza.zza("layout", 4, new zzacp().zzj("banner", 0), false));
        }

        public zzb() {
            this.zzaiI = 1;
            this.zzbCm = new HashSet();
        }

        zzb(Set<Integer> set, int i, zza com_google_android_gms_internal_zzazf_zzb_zza, zzb com_google_android_gms_internal_zzazf_zzb_zzb, int i2) {
            this.zzbCm = set;
            this.zzaiI = i;
            this.zzbCI = com_google_android_gms_internal_zzazf_zzb_zza;
            this.zzbCJ = com_google_android_gms_internal_zzazf_zzb_zzb;
            this.zzbCK = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzb com_google_android_gms_internal_zzazf_zzb = (zzb) obj;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    if (!com_google_android_gms_internal_zzazf_zzb.zza(com_google_android_gms_internal_zzacs_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf_zzb.zzb(com_google_android_gms_internal_zzacs_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzazf_zzb.zza(com_google_android_gms_internal_zzacs_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzPm();
        }

        public CoverInfo getCoverInfo() {
            return this.zzbCI;
        }

        public CoverPhoto getCoverPhoto() {
            return this.zzbCJ;
        }

        public int getLayout() {
            return this.zzbCK;
        }

        public boolean hasCoverInfo() {
            return this.zzbCm.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.zzbCm.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.zzbCm.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzazi.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
            return zzbCl;
        }

        public zzb zzPm() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
        }

        protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    return this.zzbCI;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    return this.zzbCJ;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    return Integer.valueOf(this.zzbCK);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
            }
        }

        public /* synthetic */ Map zzyr() {
            return zzPj();
        }
    }

    public static final class zzc extends zzact implements Image {
        public static final Creator<zzc> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
        String zzE;
        final int zzaiI;
        final Set<Integer> zzbCm;

        static {
            CREATOR = new zzazl();
            zzbCl = new HashMap();
            zzbCl.put(PlusShare.KEY_CALL_TO_ACTION_URL, com.google.android.gms.internal.zzacs.zza.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public zzc() {
            this.zzaiI = 1;
            this.zzbCm = new HashSet();
        }

        public zzc(String str) {
            this.zzbCm = new HashSet();
            this.zzaiI = 1;
            this.zzE = str;
            this.zzbCm.add(Integer.valueOf(2));
        }

        zzc(Set<Integer> set, int i, String str) {
            this.zzbCm = set;
            this.zzaiI = i;
            this.zzE = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc com_google_android_gms_internal_zzazf_zzc = (zzc) obj;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    if (!com_google_android_gms_internal_zzazf_zzc.zza(com_google_android_gms_internal_zzacs_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf_zzc.zzb(com_google_android_gms_internal_zzacs_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzazf_zzc.zza(com_google_android_gms_internal_zzacs_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzPp();
        }

        public String getUrl() {
            return this.zzE;
        }

        public boolean hasUrl() {
            return this.zzbCm.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzazl.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
            return zzbCl;
        }

        public zzc zzPp() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
        }

        protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    return this.zzE;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
            }
        }

        public /* synthetic */ Map zzyr() {
            return zzPj();
        }
    }

    public static final class zzd extends zzact implements Name {
        public static final Creator<zzd> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
        final int zzaiI;
        String zzajl;
        String zzajm;
        String zzbCN;
        String zzbCO;
        String zzbCP;
        String zzbCQ;
        final Set<Integer> zzbCm;

        static {
            CREATOR = new zzazm();
            zzbCl = new HashMap();
            zzbCl.put("familyName", com.google.android.gms.internal.zzacs.zza.zzm("familyName", 2));
            zzbCl.put("formatted", com.google.android.gms.internal.zzacs.zza.zzm("formatted", 3));
            zzbCl.put("givenName", com.google.android.gms.internal.zzacs.zza.zzm("givenName", 4));
            zzbCl.put("honorificPrefix", com.google.android.gms.internal.zzacs.zza.zzm("honorificPrefix", 5));
            zzbCl.put("honorificSuffix", com.google.android.gms.internal.zzacs.zza.zzm("honorificSuffix", 6));
            zzbCl.put("middleName", com.google.android.gms.internal.zzacs.zza.zzm("middleName", 7));
        }

        public zzd() {
            this.zzaiI = 1;
            this.zzbCm = new HashSet();
        }

        zzd(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.zzbCm = set;
            this.zzaiI = i;
            this.zzajm = str;
            this.zzbCN = str2;
            this.zzajl = str3;
            this.zzbCO = str4;
            this.zzbCP = str5;
            this.zzbCQ = str6;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzd)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzd com_google_android_gms_internal_zzazf_zzd = (zzd) obj;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    if (!com_google_android_gms_internal_zzazf_zzd.zza(com_google_android_gms_internal_zzacs_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf_zzd.zzb(com_google_android_gms_internal_zzacs_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzazf_zzd.zza(com_google_android_gms_internal_zzacs_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzPq();
        }

        public String getFamilyName() {
            return this.zzajm;
        }

        public String getFormatted() {
            return this.zzbCN;
        }

        public String getGivenName() {
            return this.zzajl;
        }

        public String getHonorificPrefix() {
            return this.zzbCO;
        }

        public String getHonorificSuffix() {
            return this.zzbCP;
        }

        public String getMiddleName() {
            return this.zzbCQ;
        }

        public boolean hasFamilyName() {
            return this.zzbCm.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.zzbCm.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.zzbCm.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.zzbCm.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.zzbCm.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.zzbCm.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzazm.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
            return zzbCl;
        }

        public zzd zzPq() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
        }

        protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    return this.zzajm;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    return this.zzbCN;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    return this.zzajl;
                case Type.OTHER_PROFILE /*5*/:
                    return this.zzbCO;
                case Type.CONTRIBUTOR /*6*/:
                    return this.zzbCP;
                case Type.WEBSITE /*7*/:
                    return this.zzbCQ;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
            }
        }

        public /* synthetic */ Map zzyr() {
            return zzPj();
        }
    }

    public static class zze {
        public static int zzgs(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            String str2 = "Unknown objectType string: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    public static final class zzf extends zzact implements Organizations {
        public static final Creator<zzf> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
        String mName;
        String zzade;
        final int zzaiI;
        int zzakD;
        String zzamJ;
        String zzbCR;
        String zzbCS;
        String zzbCT;
        boolean zzbCU;
        String zzbCV;
        final Set<Integer> zzbCm;

        static {
            CREATOR = new zzazn();
            zzbCl = new HashMap();
            zzbCl.put("department", com.google.android.gms.internal.zzacs.zza.zzm("department", 2));
            zzbCl.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, com.google.android.gms.internal.zzacs.zza.zzm(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzbCl.put("endDate", com.google.android.gms.internal.zzacs.zza.zzm("endDate", 4));
            zzbCl.put(Param.LOCATION, com.google.android.gms.internal.zzacs.zza.zzm(Param.LOCATION, 5));
            zzbCl.put("name", com.google.android.gms.internal.zzacs.zza.zzm("name", 6));
            zzbCl.put("primary", com.google.android.gms.internal.zzacs.zza.zzl("primary", 7));
            zzbCl.put("startDate", com.google.android.gms.internal.zzacs.zza.zzm("startDate", 8));
            zzbCl.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, com.google.android.gms.internal.zzacs.zza.zzm(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzbCl.put("type", com.google.android.gms.internal.zzacs.zza.zza("type", 10, new zzacp().zzj("work", 0).zzj("school", 1), false));
        }

        public zzf() {
            this.zzaiI = 1;
            this.zzbCm = new HashSet();
        }

        zzf(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.zzbCm = set;
            this.zzaiI = i;
            this.zzbCR = str;
            this.zzade = str2;
            this.zzbCS = str3;
            this.zzbCT = str4;
            this.mName = str5;
            this.zzbCU = z;
            this.zzbCV = str6;
            this.zzamJ = str7;
            this.zzakD = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzf)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzf com_google_android_gms_internal_zzazf_zzf = (zzf) obj;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    if (!com_google_android_gms_internal_zzazf_zzf.zza(com_google_android_gms_internal_zzacs_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf_zzf.zzb(com_google_android_gms_internal_zzacs_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzazf_zzf.zza(com_google_android_gms_internal_zzacs_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzPr();
        }

        public String getDepartment() {
            return this.zzbCR;
        }

        public String getDescription() {
            return this.zzade;
        }

        public String getEndDate() {
            return this.zzbCS;
        }

        public String getLocation() {
            return this.zzbCT;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.zzbCV;
        }

        public String getTitle() {
            return this.zzamJ;
        }

        public int getType() {
            return this.zzakD;
        }

        public boolean hasDepartment() {
            return this.zzbCm.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.zzbCm.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.zzbCm.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.zzbCm.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.zzbCm.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.zzbCm.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.zzbCm.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.zzbCm.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.zzbCm.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.zzbCU;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzazn.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
            return zzbCl;
        }

        public zzf zzPr() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
        }

        protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    return this.zzbCR;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    return this.zzade;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    return this.zzbCS;
                case Type.OTHER_PROFILE /*5*/:
                    return this.zzbCT;
                case Type.CONTRIBUTOR /*6*/:
                    return this.mName;
                case Type.WEBSITE /*7*/:
                    return Boolean.valueOf(this.zzbCU);
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    return this.zzbCV;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    return this.zzamJ;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    return Integer.valueOf(this.zzakD);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
            }
        }

        public /* synthetic */ Map zzyr() {
            return zzPj();
        }
    }

    public static final class zzg extends zzact implements PlacesLived {
        public static final Creator<zzg> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
        String mValue;
        final int zzaiI;
        boolean zzbCU;
        final Set<Integer> zzbCm;

        static {
            CREATOR = new zzazo();
            zzbCl = new HashMap();
            zzbCl.put("primary", com.google.android.gms.internal.zzacs.zza.zzl("primary", 2));
            zzbCl.put(Param.VALUE, com.google.android.gms.internal.zzacs.zza.zzm(Param.VALUE, 3));
        }

        public zzg() {
            this.zzaiI = 1;
            this.zzbCm = new HashSet();
        }

        zzg(Set<Integer> set, int i, boolean z, String str) {
            this.zzbCm = set;
            this.zzaiI = i;
            this.zzbCU = z;
            this.mValue = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzg)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzg com_google_android_gms_internal_zzazf_zzg = (zzg) obj;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    if (!com_google_android_gms_internal_zzazf_zzg.zza(com_google_android_gms_internal_zzacs_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf_zzg.zzb(com_google_android_gms_internal_zzacs_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzazf_zzg.zza(com_google_android_gms_internal_zzacs_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzPs();
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.zzbCm.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.zzbCm.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.zzbCU;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzazo.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
            return zzbCl;
        }

        public zzg zzPs() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
        }

        protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    return Boolean.valueOf(this.zzbCU);
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
            }
        }

        public /* synthetic */ Map zzyr() {
            return zzPj();
        }
    }

    public static final class zzh extends zzact implements Urls {
        public static final Creator<zzh> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzbCl;
        String mValue;
        String zzadc;
        final int zzaiI;
        int zzakD;
        private final int zzbCW;
        final Set<Integer> zzbCm;

        static {
            CREATOR = new zzazp();
            zzbCl = new HashMap();
            zzbCl.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, com.google.android.gms.internal.zzacs.zza.zzm(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzbCl.put("type", com.google.android.gms.internal.zzacs.zza.zza("type", 6, new zzacp().zzj("home", 0).zzj("work", 1).zzj("blog", 2).zzj(Scopes.PROFILE, 3).zzj("other", 4).zzj("otherProfile", 5).zzj("contributor", 6).zzj("website", 7), false));
            zzbCl.put(Param.VALUE, com.google.android.gms.internal.zzacs.zza.zzm(Param.VALUE, 4));
        }

        public zzh() {
            this.zzbCW = 4;
            this.zzaiI = 1;
            this.zzbCm = new HashSet();
        }

        zzh(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.zzbCW = 4;
            this.zzbCm = set;
            this.zzaiI = i;
            this.zzadc = str;
            this.zzakD = i2;
            this.mValue = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzh)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzh com_google_android_gms_internal_zzazf_zzh = (zzh) obj;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    if (!com_google_android_gms_internal_zzazf_zzh.zza(com_google_android_gms_internal_zzacs_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf_zzh.zzb(com_google_android_gms_internal_zzacs_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzazf_zzh.zza(com_google_android_gms_internal_zzacs_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzPu();
        }

        public String getLabel() {
            return this.zzadc;
        }

        public int getType() {
            return this.zzakD;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.zzbCm.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.zzbCm.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.zzbCm.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzacs_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzazp.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
            return zzbCl;
        }

        @Deprecated
        public int zzPt() {
            return 4;
        }

        public zzh zzPu() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
        }

        protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
            switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    return this.mValue;
                case Type.OTHER_PROFILE /*5*/:
                    return this.zzadc;
                case Type.CONTRIBUTOR /*6*/:
                    return Integer.valueOf(this.zzakD);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
            }
        }

        public /* synthetic */ Map zzyr() {
            return zzPj();
        }
    }

    static {
        CREATOR = new zzazg();
        zzbCl = new HashMap();
        zzbCl.put("aboutMe", com.google.android.gms.internal.zzacs.zza.zzm("aboutMe", 2));
        zzbCl.put("ageRange", com.google.android.gms.internal.zzacs.zza.zza("ageRange", 3, zza.class));
        zzbCl.put("birthday", com.google.android.gms.internal.zzacs.zza.zzm("birthday", 4));
        zzbCl.put("braggingRights", com.google.android.gms.internal.zzacs.zza.zzm("braggingRights", 5));
        zzbCl.put("circledByCount", com.google.android.gms.internal.zzacs.zza.zzk("circledByCount", 6));
        zzbCl.put("cover", com.google.android.gms.internal.zzacs.zza.zza("cover", 7, zzb.class));
        zzbCl.put("currentLocation", com.google.android.gms.internal.zzacs.zza.zzm("currentLocation", 8));
        zzbCl.put("displayName", com.google.android.gms.internal.zzacs.zza.zzm("displayName", 9));
        zzbCl.put("gender", com.google.android.gms.internal.zzacs.zza.zza("gender", 12, new zzacp().zzj("male", 0).zzj("female", 1).zzj("other", 2), false));
        zzbCl.put(FacebookAdapter.KEY_ID, com.google.android.gms.internal.zzacs.zza.zzm(FacebookAdapter.KEY_ID, 14));
        zzbCl.put("image", com.google.android.gms.internal.zzacs.zza.zza("image", 15, zzc.class));
        zzbCl.put("isPlusUser", com.google.android.gms.internal.zzacs.zza.zzl("isPlusUser", 16));
        zzbCl.put("language", com.google.android.gms.internal.zzacs.zza.zzm("language", 18));
        zzbCl.put("name", com.google.android.gms.internal.zzacs.zza.zza("name", 19, zzd.class));
        zzbCl.put("nickname", com.google.android.gms.internal.zzacs.zza.zzm("nickname", 20));
        zzbCl.put("objectType", com.google.android.gms.internal.zzacs.zza.zza("objectType", 21, new zzacp().zzj("person", 0).zzj("page", 1), false));
        zzbCl.put("organizations", com.google.android.gms.internal.zzacs.zza.zzb("organizations", 22, zzf.class));
        zzbCl.put("placesLived", com.google.android.gms.internal.zzacs.zza.zzb("placesLived", 23, zzg.class));
        zzbCl.put("plusOneCount", com.google.android.gms.internal.zzacs.zza.zzk("plusOneCount", 24));
        zzbCl.put("relationshipStatus", com.google.android.gms.internal.zzacs.zza.zza("relationshipStatus", 25, new zzacp().zzj("single", 0).zzj("in_a_relationship", 1).zzj("engaged", 2).zzj("married", 3).zzj("its_complicated", 4).zzj("open_relationship", 5).zzj("widowed", 6).zzj("in_domestic_partnership", 7).zzj("in_civil_union", 8), false));
        zzbCl.put("tagline", com.google.android.gms.internal.zzacs.zza.zzm("tagline", 26));
        zzbCl.put(PlusShare.KEY_CALL_TO_ACTION_URL, com.google.android.gms.internal.zzacs.zza.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzbCl.put("urls", com.google.android.gms.internal.zzacs.zza.zzb("urls", 28, zzh.class));
        zzbCl.put("verified", com.google.android.gms.internal.zzacs.zza.zzl("verified", 29));
    }

    public zzazf() {
        this.zzaiI = 1;
        this.zzbCm = new HashSet();
    }

    public zzazf(String str, String str2, zzc com_google_android_gms_internal_zzazf_zzc, int i, String str3) {
        this.zzaiI = 1;
        this.zzbCm = new HashSet();
        this.zzakb = str;
        this.zzbCm.add(Integer.valueOf(9));
        this.zzGV = str2;
        this.zzbCm.add(Integer.valueOf(14));
        this.zzbCu = com_google_android_gms_internal_zzazf_zzc;
        this.zzbCm.add(Integer.valueOf(15));
        this.zzbCy = i;
        this.zzbCm.add(Integer.valueOf(21));
        this.zzE = str3;
        this.zzbCm.add(Integer.valueOf(27));
    }

    zzazf(Set<Integer> set, int i, String str, zza com_google_android_gms_internal_zzazf_zza, String str2, String str3, int i2, zzb com_google_android_gms_internal_zzazf_zzb, String str4, String str5, int i3, String str6, zzc com_google_android_gms_internal_zzazf_zzc, boolean z, String str7, zzd com_google_android_gms_internal_zzazf_zzd, String str8, int i4, List<zzf> list, List<zzg> list2, int i5, int i6, String str9, String str10, List<zzh> list3, boolean z2) {
        this.zzbCm = set;
        this.zzaiI = i;
        this.zzbCn = str;
        this.zzbCo = com_google_android_gms_internal_zzazf_zza;
        this.zzbCp = str2;
        this.zzbCq = str3;
        this.zzbCr = i2;
        this.zzbCs = com_google_android_gms_internal_zzazf_zzb;
        this.zzbCt = str4;
        this.zzakb = str5;
        this.zzzk = i3;
        this.zzGV = str6;
        this.zzbCu = com_google_android_gms_internal_zzazf_zzc;
        this.zzbCv = z;
        this.zzacX = str7;
        this.zzbCw = com_google_android_gms_internal_zzazf_zzd;
        this.zzbCx = str8;
        this.zzbCy = i4;
        this.zzbCz = list;
        this.zzbCA = list2;
        this.zzbCB = i5;
        this.zzbCC = i6;
        this.zzbCD = str9;
        this.zzE = str10;
        this.zzbCE = list3;
        this.zzbCF = z2;
    }

    public static zzazf zzG(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        zzazf com_google_android_gms_internal_zzazf = (zzazf) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return com_google_android_gms_internal_zzazf;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzazf)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzazf com_google_android_gms_internal_zzazf = (zzazf) obj;
        for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
            if (zza(com_google_android_gms_internal_zzacs_zza)) {
                if (!com_google_android_gms_internal_zzazf.zza(com_google_android_gms_internal_zzacs_zza)) {
                    return false;
                }
                if (!zzb(com_google_android_gms_internal_zzacs_zza).equals(com_google_android_gms_internal_zzazf.zzb(com_google_android_gms_internal_zzacs_zza))) {
                    return false;
                }
            } else if (com_google_android_gms_internal_zzazf.zza(com_google_android_gms_internal_zzacs_zza)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzPk();
    }

    public String getAboutMe() {
        return this.zzbCn;
    }

    public AgeRange getAgeRange() {
        return this.zzbCo;
    }

    public String getBirthday() {
        return this.zzbCp;
    }

    public String getBraggingRights() {
        return this.zzbCq;
    }

    public int getCircledByCount() {
        return this.zzbCr;
    }

    public Cover getCover() {
        return this.zzbCs;
    }

    public String getCurrentLocation() {
        return this.zzbCt;
    }

    public String getDisplayName() {
        return this.zzakb;
    }

    public int getGender() {
        return this.zzzk;
    }

    public String getId() {
        return this.zzGV;
    }

    public Image getImage() {
        return this.zzbCu;
    }

    public String getLanguage() {
        return this.zzacX;
    }

    public Name getName() {
        return this.zzbCw;
    }

    public String getNickname() {
        return this.zzbCx;
    }

    public int getObjectType() {
        return this.zzbCy;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.zzbCz;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzbCA;
    }

    public int getPlusOneCount() {
        return this.zzbCB;
    }

    public int getRelationshipStatus() {
        return this.zzbCC;
    }

    public String getTagline() {
        return this.zzbCD;
    }

    public String getUrl() {
        return this.zzE;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.zzbCE;
    }

    public boolean hasAboutMe() {
        return this.zzbCm.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.zzbCm.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.zzbCm.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.zzbCm.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.zzbCm.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.zzbCm.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.zzbCm.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.zzbCm.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.zzbCm.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.zzbCm.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.zzbCm.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.zzbCm.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.zzbCm.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.zzbCm.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.zzbCm.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.zzbCm.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.zzbCm.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.zzbCm.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.zzbCm.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.zzbCm.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.zzbCm.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.zzbCm.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.zzbCm.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.zzbCm.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza : zzbCl.values()) {
            int hashCode;
            if (zza(com_google_android_gms_internal_zzacs_zza)) {
                hashCode = zzb(com_google_android_gms_internal_zzacs_zza).hashCode() + (i + com_google_android_gms_internal_zzacs_zza.zzyx());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.zzbCv;
    }

    public boolean isVerified() {
        return this.zzbCF;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzazg.zza(this, parcel, i);
    }

    public HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> zzPj() {
        return zzbCl;
    }

    public zzazf zzPk() {
        return this;
    }

    protected boolean zza(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
        return this.zzbCm.contains(Integer.valueOf(com_google_android_gms_internal_zzacs_zza.zzyx()));
    }

    protected Object zzb(com.google.android.gms.internal.zzacs.zza com_google_android_gms_internal_zzacs_zza) {
        switch (com_google_android_gms_internal_zzacs_zza.zzyx()) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return this.zzbCn;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return this.zzbCo;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return this.zzbCp;
            case Type.OTHER_PROFILE /*5*/:
                return this.zzbCq;
            case Type.CONTRIBUTOR /*6*/:
                return Integer.valueOf(this.zzbCr);
            case Type.WEBSITE /*7*/:
                return this.zzbCs;
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                return this.zzbCt;
            case ConnectionResult.SERVICE_INVALID /*9*/:
                return this.zzakb;
            case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                return Integer.valueOf(this.zzzk);
            case CommonStatusCodes.INTERRUPTED /*14*/:
                return this.zzGV;
            case CommonStatusCodes.TIMEOUT /*15*/:
                return this.zzbCu;
            case CommonStatusCodes.CANCELED /*16*/:
                return Boolean.valueOf(this.zzbCv);
            case CommonStatusCodes.DEAD_CLIENT /*18*/:
                return this.zzacX;
            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                return this.zzbCw;
            case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                return this.zzbCx;
            case C0268R.styleable.Toolbar_buttonGravity /*21*/:
                return Integer.valueOf(this.zzbCy);
            case C0268R.styleable.Toolbar_collapseIcon /*22*/:
                return this.zzbCz;
            case C0268R.styleable.Toolbar_collapseContentDescription /*23*/:
                return this.zzbCA;
            case C0268R.styleable.Toolbar_navigationIcon /*24*/:
                return Integer.valueOf(this.zzbCB);
            case C0268R.styleable.Toolbar_navigationContentDescription /*25*/:
                return Integer.valueOf(this.zzbCC);
            case C0268R.styleable.Toolbar_logoDescription /*26*/:
                return this.zzbCD;
            case C0268R.styleable.Toolbar_titleTextColor /*27*/:
                return this.zzE;
            case C0268R.styleable.Toolbar_subtitleTextColor /*28*/:
                return this.zzbCE;
            case C0268R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                return Boolean.valueOf(this.zzbCF);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzacs_zza.zzyx());
        }
    }

    public /* synthetic */ Map zzyr() {
        return zzPj();
    }
}
