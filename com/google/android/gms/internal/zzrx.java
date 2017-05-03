package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public class zzrx extends zzsa {
    public static boolean zzadA;
    private Info zzadB;
    private final zztj zzadC;
    private String zzadD;
    private boolean zzadE;
    private Object zzadF;

    zzrx(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
        this.zzadE = false;
        this.zzadF = new Object();
        this.zzadC = new zztj(com_google_android_gms_internal_zzsc.zznR());
    }

    private boolean zza(Info info, Info info2) {
        Object obj = null;
        CharSequence id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String zzoQ = zznX().zzoQ();
        synchronized (this.zzadF) {
            String valueOf;
            String valueOf2;
            if (!this.zzadE) {
                this.zzadD = zznJ();
                this.zzadE = true;
            } else if (TextUtils.isEmpty(this.zzadD)) {
                if (info != null) {
                    obj = info.getId();
                }
                if (obj == null) {
                    valueOf = String.valueOf(id);
                    String valueOf3 = String.valueOf(zzoQ);
                    boolean zzbO = zzbO(valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf));
                    return zzbO;
                }
                valueOf2 = String.valueOf(obj);
                valueOf = String.valueOf(zzoQ);
                this.zzadD = zzbN(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            }
            valueOf2 = String.valueOf(id);
            valueOf = String.valueOf(zzoQ);
            obj = zzbN(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            if (TextUtils.isEmpty(obj)) {
                return false;
            } else if (obj.equals(this.zzadD)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.zzadD)) {
                    valueOf = zzoQ;
                } else {
                    zzbP("Resetting the client id because Advertising Id changed.");
                    obj = zznX().zzoR();
                    zza("New client Id", obj);
                }
                String valueOf4 = String.valueOf(id);
                valueOf3 = String.valueOf(obj);
                zzbO = zzbO(valueOf3.length() != 0 ? valueOf4.concat(valueOf3) : new String(valueOf4));
                return zzbO;
            }
        }
    }

    private static String zzbN(String str) {
        if (zztm.zzch("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zztm.zzch("MD5").digest(str.getBytes()))});
    }

    private boolean zzbO(String str) {
        try {
            String zzbN = zzbN(str);
            zzbP("Storing hashed adid.");
            FileOutputStream openFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzbN.getBytes());
            openFileOutput.close();
            this.zzadD = zzbN;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private synchronized Info zznH() {
        if (this.zzadC.zzA(1000)) {
            this.zzadC.start();
            Info zznI = zznI();
            if (zza(this.zzadB, zznI)) {
                this.zzadB = zznI;
            } else {
                zzbT("Failed to reset client id on adid change. Not using adid");
                this.zzadB = new Info(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, false);
            }
        }
        return this.zzadB;
    }

    protected void zzmS() {
    }

    public String zznG() {
        zzob();
        Info zznH = zznH();
        CharSequence id = zznH != null ? zznH.getId() : null;
        return TextUtils.isEmpty(id) ? null : id;
    }

    protected Info zznI() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException e) {
            zzbS("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (Throwable th) {
            if (!zzadA) {
                zzadA = true;
                zzd("Error getting advertiser id", th);
            }
        }
        return info;
    }

    protected String zznJ() {
        Object obj;
        String str = null;
        try {
            FileInputStream openFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS];
            int read = openFileInput.read(bArr, 0, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            if (openFileInput.available() > 0) {
                zzbS("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                getContext().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                zzbP("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    IOException iOException = e2;
                    str = str2;
                    IOException iOException2 = iOException;
                    zzd("Error reading Hash file, deleting it", obj);
                    getContext().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            obj = e4;
            zzd("Error reading Hash file, deleting it", obj);
            getContext().deleteFile("gaClientIdData");
            return str;
        }
    }

    public boolean zznw() {
        zzob();
        Info zznH = zznH();
        return (zznH == null || zznH.isLimitAdTrackingEnabled()) ? false : true;
    }
}
