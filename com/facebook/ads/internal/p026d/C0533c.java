package com.facebook.ads.internal.p026d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.ads.internal.p021m.ak;
import com.facebook.ads.internal.p033j.p034a.C0614p;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.facebook.ads.internal.d.c */
public class C0533c {
    private static final String f1164a;
    private static C0533c f1165b;
    private final Context f1166c;

    static {
        f1164a = C0533c.class.getSimpleName();
    }

    private C0533c(Context context) {
        this.f1166c = context;
    }

    public static C0533c m1649a(Context context) {
        if (f1165b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f1165b == null) {
                    f1165b = new C0533c(applicationContext);
                }
            }
        }
        return f1165b;
    }

    private static void m1650a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    @Nullable
    private Bitmap m1651b(String str) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(str.substring("file://".length())), null, null);
            m1654a(str, decodeStream);
            return decodeStream;
        } catch (Throwable e) {
            Log.e(f1164a, "Failed to copy local image into cache (url=" + str + ").", e);
            return null;
        }
    }

    @Nullable
    private Bitmap m1652c(String str) {
        InputStream open;
        Bitmap decodeStream;
        Throwable th;
        C0614p c0614p = null;
        if (str.startsWith("asset:///")) {
            try {
                open = this.f1166c.getAssets().open(str.substring(9, str.length()));
                try {
                    decodeStream = BitmapFactory.decodeStream(open);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return decodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                open = c0614p;
                if (open != null) {
                    open.close();
                }
                return decodeStream;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                open = c0614p;
                th = th4;
                if (open != null) {
                    open.close();
                }
                throw th;
            }
        }
        byte[] d = ak.m2161a(this.f1166c).m1881a(str, c0614p).m1924d();
        decodeStream = BitmapFactory.decodeByteArray(d, 0, d.length);
        m1654a(str, decodeStream);
        return decodeStream;
    }

    @Nullable
    public Bitmap m1653a(String str) {
        File file = new File(this.f1166c.getCacheDir(), str.hashCode() + ".png");
        return !file.exists() ? str.startsWith("file://") ? m1651b(str) : m1652c(str) : BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public void m1654a(String str, Bitmap bitmap) {
        Closeable fileOutputStream;
        Throwable e;
        Closeable closeable = null;
        File file = new File(this.f1166c.getCacheDir(), str.hashCode() + ".png");
        Closeable byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                if (byteArrayOutputStream.size() >= 3145728) {
                    Log.d(f1164a, "Bitmap size exceeds max size for storage");
                    C0533c.m1650a(byteArrayOutputStream);
                    C0533c.m1650a(null);
                    return;
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    fileOutputStream.flush();
                    C0533c.m1650a(byteArrayOutputStream);
                    C0533c.m1650a(fileOutputStream);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    closeable = fileOutputStream;
                    fileOutputStream = byteArrayOutputStream;
                    try {
                        Log.e(f1164a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
                        C0533c.m1650a(fileOutputStream);
                        C0533c.m1650a(closeable);
                    } catch (Throwable th) {
                        e = th;
                        byteArrayOutputStream = fileOutputStream;
                        C0533c.m1650a(byteArrayOutputStream);
                        C0533c.m1650a(closeable);
                        throw e;
                    }
                } catch (IOException e3) {
                    e = e3;
                    closeable = fileOutputStream;
                    try {
                        Log.e(f1164a, "Unable to write bitmap to file (url=" + str + ").", e);
                        C0533c.m1650a(byteArrayOutputStream);
                        C0533c.m1650a(closeable);
                    } catch (Throwable th2) {
                        e = th2;
                        C0533c.m1650a(byteArrayOutputStream);
                        C0533c.m1650a(closeable);
                        throw e;
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    closeable = fileOutputStream;
                    Log.e(f1164a, "Unable to write bitmap to output stream", e);
                    C0533c.m1650a(byteArrayOutputStream);
                    C0533c.m1650a(closeable);
                } catch (Throwable th3) {
                    e = th3;
                    closeable = fileOutputStream;
                    C0533c.m1650a(byteArrayOutputStream);
                    C0533c.m1650a(closeable);
                    throw e;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = byteArrayOutputStream;
                Log.e(f1164a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
                C0533c.m1650a(fileOutputStream);
                C0533c.m1650a(closeable);
            } catch (IOException e6) {
                e = e6;
                Log.e(f1164a, "Unable to write bitmap to file (url=" + str + ").", e);
                C0533c.m1650a(byteArrayOutputStream);
                C0533c.m1650a(closeable);
            } catch (OutOfMemoryError e7) {
                e = e7;
                Log.e(f1164a, "Unable to write bitmap to output stream", e);
                C0533c.m1650a(byteArrayOutputStream);
                C0533c.m1650a(closeable);
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            fileOutputStream = null;
            Log.e(f1164a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
            C0533c.m1650a(fileOutputStream);
            C0533c.m1650a(closeable);
        } catch (IOException e9) {
            e = e9;
            byteArrayOutputStream = null;
            Log.e(f1164a, "Unable to write bitmap to file (url=" + str + ").", e);
            C0533c.m1650a(byteArrayOutputStream);
            C0533c.m1650a(closeable);
        } catch (OutOfMemoryError e10) {
            e = e10;
            byteArrayOutputStream = null;
            Log.e(f1164a, "Unable to write bitmap to output stream", e);
            C0533c.m1650a(byteArrayOutputStream);
            C0533c.m1650a(closeable);
        } catch (Throwable th4) {
            e = th4;
            byteArrayOutputStream = null;
            C0533c.m1650a(byteArrayOutputStream);
            C0533c.m1650a(closeable);
            throw e;
        }
    }
}
