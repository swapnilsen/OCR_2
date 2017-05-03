package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

public final class zzbxl {
    private final byte[] buffer;
    private int zzcuA;
    private int zzcuB;
    private int zzcuC;
    private int zzcuD;
    private int zzcuE;
    private int zzcuF;
    private int zzcuG;
    private int zzcuy;
    private int zzcuz;

    private zzbxl(byte[] bArr, int i, int i2) {
        this.zzcuD = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzcuF = 64;
        this.zzcuG = 67108864;
        this.buffer = bArr;
        this.zzcuy = i;
        this.zzcuz = i + i2;
        this.zzcuB = i;
    }

    public static long zzaZ(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private void zzaeB() {
        this.zzcuz += this.zzcuA;
        int i = this.zzcuz;
        if (i > this.zzcuD) {
            this.zzcuA = i - this.zzcuD;
            this.zzcuz -= this.zzcuA;
            return;
        }
        this.zzcuA = 0;
    }

    public static zzbxl zzaf(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static zzbxl zzb(byte[] bArr, int i, int i2) {
        return new zzbxl(bArr, i, i2);
    }

    public static int zzqZ(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public int getPosition() {
        return this.zzcuB - this.zzcuy;
    }

    public byte[] readBytes() {
        int zzaex = zzaex();
        if (zzaex < 0) {
            throw zzbxs.zzaeM();
        } else if (zzaex == 0) {
            return zzbxw.zzcvd;
        } else {
            if (zzaex > this.zzcuz - this.zzcuB) {
                throw zzbxs.zzaeL();
            }
            Object obj = new byte[zzaex];
            System.arraycopy(this.buffer, this.zzcuB, obj, 0, zzaex);
            this.zzcuB = zzaex + this.zzcuB;
            return obj;
        }
    }

    public double readDouble() {
        return Double.longBitsToDouble(zzaeA());
    }

    public float readFloat() {
        return Float.intBitsToFloat(zzaez());
    }

    public String readString() {
        int zzaex = zzaex();
        if (zzaex < 0) {
            throw zzbxs.zzaeM();
        } else if (zzaex > this.zzcuz - this.zzcuB) {
            throw zzbxs.zzaeL();
        } else {
            String str = new String(this.buffer, this.zzcuB, zzaex, zzbxr.UTF_8);
            this.zzcuB = zzaex + this.zzcuB;
            return str;
        }
    }

    public byte[] zzI(int i, int i2) {
        if (i2 == 0) {
            return zzbxw.zzcvd;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.zzcuy + i, obj, 0, i2);
        return obj;
    }

    public void zza(zzbxt com_google_android_gms_internal_zzbxt) {
        int zzaex = zzaex();
        if (this.zzcuE >= this.zzcuF) {
            throw zzbxs.zzaeR();
        }
        zzaex = zzra(zzaex);
        this.zzcuE++;
        com_google_android_gms_internal_zzbxt.zzb(this);
        zzqX(0);
        this.zzcuE--;
        zzrb(zzaex);
    }

    public void zza(zzbxt com_google_android_gms_internal_zzbxt, int i) {
        if (this.zzcuE >= this.zzcuF) {
            throw zzbxs.zzaeR();
        }
        this.zzcuE++;
        com_google_android_gms_internal_zzbxt.zzb(this);
        zzqX(zzbxw.zzO(i, 4));
        this.zzcuE--;
    }

    public long zzaeA() {
        byte zzaeE = zzaeE();
        byte zzaeE2 = zzaeE();
        return ((((((((((long) zzaeE2) & 255) << 8) | (((long) zzaeE) & 255)) | ((((long) zzaeE()) & 255) << 16)) | ((((long) zzaeE()) & 255) << 24)) | ((((long) zzaeE()) & 255) << 32)) | ((((long) zzaeE()) & 255) << 40)) | ((((long) zzaeE()) & 255) << 48)) | ((((long) zzaeE()) & 255) << 56);
    }

    public int zzaeC() {
        if (this.zzcuD == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return -1;
        }
        return this.zzcuD - this.zzcuB;
    }

    public boolean zzaeD() {
        return this.zzcuB == this.zzcuz;
    }

    public byte zzaeE() {
        if (this.zzcuB == this.zzcuz) {
            throw zzbxs.zzaeL();
        }
        byte[] bArr = this.buffer;
        int i = this.zzcuB;
        this.zzcuB = i + 1;
        return bArr[i];
    }

    public int zzaeo() {
        if (zzaeD()) {
            this.zzcuC = 0;
            return 0;
        }
        this.zzcuC = zzaex();
        if (this.zzcuC != 0) {
            return this.zzcuC;
        }
        throw zzbxs.zzaeO();
    }

    public void zzaep() {
        int zzaeo;
        do {
            zzaeo = zzaeo();
            if (zzaeo == 0) {
                return;
            }
        } while (zzqY(zzaeo));
    }

    public long zzaeq() {
        return zzaey();
    }

    public long zzaer() {
        return zzaey();
    }

    public int zzaes() {
        return zzaex();
    }

    public long zzaet() {
        return zzaeA();
    }

    public boolean zzaeu() {
        return zzaex() != 0;
    }

    public int zzaev() {
        return zzqZ(zzaex());
    }

    public long zzaew() {
        return zzaZ(zzaey());
    }

    public int zzaex() {
        byte zzaeE = zzaeE();
        if (zzaeE >= null) {
            return zzaeE;
        }
        int i = zzaeE & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte zzaeE2 = zzaeE();
        if (zzaeE2 >= null) {
            return i | (zzaeE2 << 7);
        }
        i |= (zzaeE2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        zzaeE2 = zzaeE();
        if (zzaeE2 >= null) {
            return i | (zzaeE2 << 14);
        }
        i |= (zzaeE2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        zzaeE2 = zzaeE();
        if (zzaeE2 >= null) {
            return i | (zzaeE2 << 21);
        }
        i |= (zzaeE2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        zzaeE2 = zzaeE();
        i |= zzaeE2 << 28;
        if (zzaeE2 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (zzaeE() >= null) {
                return i;
            }
        }
        throw zzbxs.zzaeN();
    }

    public long zzaey() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzaeE = zzaeE();
            j |= ((long) (zzaeE & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((zzaeE & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == 0) {
                return j;
            }
        }
        throw zzbxs.zzaeN();
    }

    public int zzaez() {
        return (((zzaeE() & MotionEventCompat.ACTION_MASK) | ((zzaeE() & MotionEventCompat.ACTION_MASK) << 8)) | ((zzaeE() & MotionEventCompat.ACTION_MASK) << 16)) | ((zzaeE() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public void zzqX(int i) {
        if (this.zzcuC != i) {
            throw zzbxs.zzaeP();
        }
    }

    public boolean zzqY(int i) {
        switch (zzbxw.zzrr(i)) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                zzaes();
                return true;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                zzaeA();
                return true;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                zzrd(zzaex());
                return true;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                zzaep();
                zzqX(zzbxw.zzO(zzbxw.zzrs(i), 4));
                return true;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return false;
            case Type.OTHER_PROFILE /*5*/:
                zzaez();
                return true;
            default:
                throw zzbxs.zzaeQ();
        }
    }

    public int zzra(int i) {
        if (i < 0) {
            throw zzbxs.zzaeM();
        }
        int i2 = this.zzcuB + i;
        int i3 = this.zzcuD;
        if (i2 > i3) {
            throw zzbxs.zzaeL();
        }
        this.zzcuD = i2;
        zzaeB();
        return i3;
    }

    public void zzrb(int i) {
        this.zzcuD = i;
        zzaeB();
    }

    public void zzrc(int i) {
        if (i > this.zzcuB - this.zzcuy) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzcuB - this.zzcuy));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzcuB = this.zzcuy + i;
        }
    }

    public void zzrd(int i) {
        if (i < 0) {
            throw zzbxs.zzaeM();
        } else if (this.zzcuB + i > this.zzcuD) {
            zzrd(this.zzcuD - this.zzcuB);
            throw zzbxs.zzaeL();
        } else if (i <= this.zzcuz - this.zzcuB) {
            this.zzcuB += i;
        } else {
            throw zzbxs.zzaeL();
        }
    }
}
