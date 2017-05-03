package p000a.p001a.p002a.p003a.p004a.p006b;

/* renamed from: a.a.a.a.a.b.b */
class AdvertisingInfo {
    public final String f6a;
    public final boolean f7b;

    AdvertisingInfo(String str, boolean z) {
        this.f6a = str;
        this.f7b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdvertisingInfo advertisingInfo = (AdvertisingInfo) obj;
        if (this.f7b != advertisingInfo.f7b) {
            return false;
        }
        if (this.f6a != null) {
            if (this.f6a.equals(advertisingInfo.f6a)) {
                return true;
            }
        } else if (advertisingInfo.f6a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f6a != null) {
            hashCode = this.f6a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f7b) {
            i = 1;
        }
        return hashCode + i;
    }
}
