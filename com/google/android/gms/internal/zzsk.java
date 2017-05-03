package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzac;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class zzsk extends zzsa {
    private volatile String zzadh;
    private Future<String> zzaeS;

    /* renamed from: com.google.android.gms.internal.zzsk.1 */
    class C14151 implements Callable<String> {
        final /* synthetic */ zzsk zzaeT;

        C14151(zzsk com_google_android_gms_internal_zzsk) {
            this.zzaeT = com_google_android_gms_internal_zzsk;
        }

        public /* synthetic */ Object call() {
            return zzbY();
        }

        public String zzbY() {
            return this.zzaeT.zzoS();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsk.2 */
    class C14162 implements Callable<String> {
        final /* synthetic */ zzsk zzaeT;

        C14162(zzsk com_google_android_gms_internal_zzsk) {
            this.zzaeT = com_google_android_gms_internal_zzsk;
        }

        public /* synthetic */ Object call() {
            return zzbY();
        }

        public String zzbY() {
            return this.zzaeT.zzoT();
        }
    }

    protected zzsk(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
    }

    private String zzoT() {
        String zzoU = zzoU();
        try {
            return !zzx(zznU().getContext(), zzoU) ? "0" : zzoU;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    private boolean zzx(Context context, String str) {
        zzac.zzdr(str);
        zzac.zzdk("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            zza("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    zze("Failed to close clientId writing stream", e);
                }
            }
            return true;
        } catch (FileNotFoundException e2) {
            zze("Error creating clientId file", e2);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e3) {
                zze("Failed to close clientId writing stream", e3);
                return false;
            }
        } catch (IOException e32) {
            zze("Error writing to clientId file", e32);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e322) {
                zze("Failed to close clientId writing stream", e322);
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3222) {
                    zze("Failed to close clientId writing stream", e3222);
                }
            }
        }
    }

    protected String zzap(Context context) {
        FileInputStream fileInputStream;
        Object e;
        Throwable th;
        zzac.zzdk("ClientId should be loaded from worker thread");
        FileInputStream openFileInput;
        try {
            openFileInput = context.openFileInput("gaClientId");
            try {
                byte[] bArr = new byte[36];
                int read = openFileInput.read(bArr, 0, 36);
                if (openFileInput.available() > 0) {
                    zzbS("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2) {
                        zze("Failed to close client id reading stream", e2);
                        return null;
                    }
                } else if (read < 14) {
                    zzbS("clientId file is empty, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e22) {
                        zze("Failed to close client id reading stream", e22);
                        return null;
                    }
                } else {
                    openFileInput.close();
                    String str = new String(bArr, 0, read);
                    zza("Read client id from disk", str);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e3) {
                            zze("Failed to close client id reading stream", e3);
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException e4) {
                fileInputStream = openFileInput;
                if (fileInputStream != null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e222) {
                    zze("Failed to close client id reading stream", e222);
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                try {
                    zze("Error reading client id file, deleting it", e);
                    context.deleteFile("gaClientId");
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2222) {
                        zze("Failed to close client id reading stream", e2222);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e22222) {
                            zze("Failed to close client id reading stream", e22222);
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            fileInputStream = null;
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (IOException e7) {
            e = e7;
            openFileInput = null;
            zze("Error reading client id file, deleting it", e);
            context.deleteFile("gaClientId");
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th3) {
            openFileInput = null;
            th = th3;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }

    protected void zzmS() {
    }

    public String zzoQ() {
        String str;
        zzob();
        synchronized (this) {
            if (this.zzadh == null) {
                this.zzaeS = zznU().zzc(new C14151(this));
            }
            if (this.zzaeS != null) {
                try {
                    this.zzadh = (String) this.zzaeS.get();
                } catch (InterruptedException e) {
                    zzd("ClientId loading or generation was interrupted", e);
                    this.zzadh = "0";
                } catch (ExecutionException e2) {
                    zze("Failed to load or generate client id", e2);
                    this.zzadh = "0";
                }
                if (this.zzadh == null) {
                    this.zzadh = "0";
                }
                zza("Loaded clientId", this.zzadh);
                this.zzaeS = null;
            }
            str = this.zzadh;
        }
        return str;
    }

    String zzoR() {
        synchronized (this) {
            this.zzadh = null;
            this.zzaeS = zznU().zzc(new C14162(this));
        }
        return zzoQ();
    }

    String zzoS() {
        String zzap = zzap(zznU().getContext());
        return zzap == null ? zzoT() : zzap;
    }

    protected String zzoU() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
