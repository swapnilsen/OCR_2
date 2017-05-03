package com.peace.TextScanner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import net.nend.android.NendIconError;

/* renamed from: com.peace.TextScanner.d */
class CameraActivity extends ViewGroup implements Callback {
    static int f5071g;
    static CameraInfo f5072h;
    SurfaceView f5073a;
    SurfaceHolder f5074b;
    Size f5075c;
    List<Size> f5076d;
    Camera f5077e;
    CameraActivity f5078f;
    int f5079i;
    Boolean f5080j;
    boolean f5081k;
    int f5082l;
    int f5083m;
    CountDownTimer f5084n;
    public AutoFocusCallback f5085o;
    public AutoFocusCallback f5086p;
    long f5087q;
    long f5088r;
    long f5089s;
    boolean f5090t;
    private final String f5091u;
    private final PreviewCallback f5092v;

    /* renamed from: com.peace.TextScanner.d.1 */
    class CameraActivity implements ErrorCallback {
        final /* synthetic */ CameraActivity f5067a;

        CameraActivity(CameraActivity cameraActivity) {
            this.f5067a = cameraActivity;
        }

        public void onError(int i, Camera camera) {
            this.f5067a.m5577a();
            try {
                if (!this.f5067a.f5078f.isFinishing()) {
                    this.f5067a.f5078f.m5528b(i);
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.peace.TextScanner.d.2 */
    class CameraActivity implements AutoFocusCallback {
        final /* synthetic */ CameraActivity f5068a;

        CameraActivity(CameraActivity cameraActivity) {
            this.f5068a = cameraActivity;
        }

        public void onAutoFocus(boolean z, Camera camera) {
            this.f5068a.f5080j = Boolean.valueOf(false);
            if (this.f5068a.f5079i == 1) {
                this.f5068a.f5079i = 2;
                Log.d("DEBUG", "mShutterState = 2");
            }
        }
    }

    /* renamed from: com.peace.TextScanner.d.3 */
    class CameraActivity implements AutoFocusCallback {
        final /* synthetic */ CameraActivity f5069a;

        CameraActivity(CameraActivity cameraActivity) {
            this.f5069a = cameraActivity;
        }

        public void onAutoFocus(boolean z, Camera camera) {
            this.f5069a.f5080j = Boolean.valueOf(false);
            if (this.f5069a.f5078f.f4968d.f5004m) {
                this.f5069a.f5081k = true;
            }
        }
    }

    /* renamed from: com.peace.TextScanner.d.4 */
    class CameraActivity implements PreviewCallback {
        final /* synthetic */ CameraActivity f5070a;

        CameraActivity(CameraActivity cameraActivity) {
            this.f5070a = cameraActivity;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (this.f5070a.f5079i == 1) {
                this.f5070a.f5079i = 0;
                this.f5070a.f5078f.m5551y();
                try {
                    this.f5070a.f5078f.m5524a(this.f5070a.m5575a(this.f5070a.m5576a(bArr, this.f5070a.f5077e), 1200));
                } catch (Throwable th) {
                }
            }
        }
    }

    CameraActivity(Context context) {
        super(context);
        this.f5091u = "Preview";
        this.f5079i = 0;
        this.f5080j = Boolean.valueOf(false);
        this.f5081k = false;
        this.f5082l = 2;
        this.f5083m = 0;
        this.f5085o = new CameraActivity(this);
        this.f5086p = new CameraActivity(this);
        this.f5087q = 0;
        this.f5088r = 0;
        this.f5089s = 0;
        this.f5090t = true;
        this.f5092v = new CameraActivity(this);
        this.f5073a = new SurfaceView(context);
        addView(this.f5073a);
        this.f5074b = this.f5073a.getHolder();
        this.f5074b.addCallback(this);
        this.f5074b.setType(3);
        setWillNotDraw(false);
    }

    public void m5578a(Camera camera) {
        this.f5077e = camera;
        if (this.f5077e != null) {
            this.f5076d = this.f5077e.getParameters().getSupportedPreviewSizes();
            if (this.f5076d != null) {
                this.f5075c = m5572a(this.f5076d);
            }
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(CameraActivity.resolveSize(getSuggestedMinimumWidth(), i), CameraActivity.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            View childAt = getChildAt(0);
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.f5077e != null) {
                double d = ((double) this.f5075c.width) / ((double) this.f5075c.height);
                try {
                    int i7;
                    int i8;
                    Parameters parameters = this.f5077e.getParameters();
                    for (Size size : parameters.getSupportedPictureSizes()) {
                        if (Math.abs((((double) size.width) / ((double) size.height)) - d) < 0.1d) {
                            i7 = size.width;
                            i8 = size.height;
                            break;
                        }
                    }
                    i8 = 0;
                    i7 = 0;
                    if (i7 == 0) {
                        childAt.layout(0, 0, i5, i6);
                        return;
                    }
                    parameters.setPictureSize(i7, i8);
                    this.f5077e.setParameters(parameters);
                    if (this.f5078f.f4988x <= 0 || this.f5078f.f4989y <= 0) {
                        i8 = i6;
                        i6 = i5;
                    } else {
                        i6 = this.f5078f.f4988x;
                        i8 = this.f5078f.f4989y;
                    }
                    i5 = this.f5075c.height;
                    i7 = this.f5075c.width;
                    if (((float) i8) / ((float) i6) < ((float) i7) / ((float) i5)) {
                        i5 = (int) ((((float) i6) / ((float) i5)) * ((float) i7));
                        childAt.layout(0, (i8 - i5) / 2, i6, i5);
                        return;
                    }
                    i5 = (int) ((((float) i7) / ((float) i5)) * ((float) i6));
                    childAt.layout(0, (i8 - i5) / 2, i6, i5);
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f5078f.f4966b == null) {
            try {
                this.f5078f.f4966b = Camera.open(this.f5078f.f4968d.f4992a);
                m5578a(this.f5078f.f4966b);
            } catch (Throwable th) {
                if (this.f5078f.f4960V) {
                    this.f5078f.m5523a(this.f5078f);
                    return;
                }
            }
        }
        try {
            if (this.f5077e != null) {
                this.f5077e.setPreviewDisplay(surfaceHolder);
                this.f5078f.m5535i();
            }
            try {
                if (this.f5077e != null) {
                    this.f5077e.setErrorCallback(new CameraActivity(this));
                }
            } catch (Throwable th2) {
            }
        } catch (Throwable th3) {
            m5577a();
            this.f5078f.m5528b(0);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        m5577a();
    }

    void m5577a() {
        try {
            this.f5078f.f4966b.stopPreview();
            this.f5078f.f4966b.setPreviewCallback(null);
            this.f5078f.f4966b.release();
        } catch (Throwable th) {
        }
        this.f5078f.f4966b = null;
        m5578a(null);
    }

    private Size m5572a(List<Size> list) {
        float abs;
        Size size = null;
        float f = 100.0f;
        int i = 0;
        for (Size size2 : list) {
            int i2;
            Size size3;
            if (size2.width <= 1920 && size2.height <= 1920) {
                if (size2.width > i) {
                    int i3 = size2.width;
                    i2 = i3;
                    size3 = size2;
                    abs = Math.abs((((float) size2.width) / ((float) size2.height)) - 1.7777778f);
                } else if (size2.width == i) {
                    float abs2 = Math.abs((((float) size2.width) / ((float) size2.height)) - 1.7777778f);
                    if (abs2 < f) {
                        size3 = size2;
                        abs = abs2;
                        i2 = i;
                    }
                }
                i = i2;
                size = size3;
                f = abs;
            }
            abs = f;
            i2 = i;
            size3 = size;
            i = i2;
            size = size3;
            f = abs;
        }
        try {
            if (this.f5078f.f4962X.equals("SH-06E") || this.f5078f.f4962X.equals("SHL22") || this.f5078f.f4962X.equals("SBM206SH") || this.f5078f.f4962X.equals("SH-07E") || this.f5078f.f4962X.equals("SBM205SH") || this.f5078f.f4962X.equals("SHL21")) {
                for (Size size22 : list) {
                    if (size22.width == 1280 && size22.height == 720) {
                        size = size22;
                        break;
                    }
                }
            }
        } catch (Throwable th) {
        }
        if (this.f5078f.f4968d.f5008q == -1) {
            abs = ((float) size.width) / ((float) size.height);
            if (((double) abs) > 1.7d) {
                this.f5078f.f4968d.f5008q = 0;
            } else if (((double) abs) > 1.4d) {
                this.f5078f.f4968d.f5008q = 1;
            } else if (((double) abs) > 1.3d) {
                this.f5078f.f4968d.f5008q = 2;
            } else if (((double) abs) == 1.0d) {
                this.f5078f.f4968d.f5008q = 3;
            } else {
                this.f5078f.f4968d.f5008q = 0;
            }
        }
        return size;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        try {
            Parameters parameters = this.f5077e.getParameters();
            if (VERSION.SDK_INT >= 14 && parameters.getSupportedFocusModes().indexOf("continuous-picture") != -1 && this.f5078f.f4968d.f4995d) {
                parameters.setFocusMode("continuous-picture");
            }
            parameters.setPreviewSize(this.f5075c.width, this.f5075c.height);
            this.f5077e.setParameters(parameters);
            requestLayout();
            this.f5077e.stopPreview();
            CameraActivity.m5573a(this.f5078f, this.f5078f.f4968d.f4992a, this.f5077e);
            this.f5077e.setPreviewCallback(this.f5092v);
            this.f5077e.startPreview();
        } catch (Exception e) {
            Log.i("DEBUG", "surfaceChanged == false");
        }
    }

    public static void m5573a(Activity activity, int i, Camera camera) {
        int i2 = 0;
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                i2 = 90;
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                i2 = 180;
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                i2 = 270;
                break;
        }
        if (cameraInfo.facing == 1) {
            i2 = (360 - ((i2 + cameraInfo.orientation) % 360)) % 360;
        } else {
            i2 = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        camera.setDisplayOrientation(i2);
        f5071g = i2;
        f5072h = cameraInfo;
    }

    public void m5579a(CameraActivity cameraActivity) {
        this.f5078f = cameraActivity;
    }

    public Bitmap m5575a(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > width) {
            width = (int) ((((float) width) * ((float) i)) / ((float) height));
        } else if (width > height) {
            int i2 = (int) ((((float) height) * ((float) i)) / ((float) width));
            width = i;
            i = i2;
        } else if (height == width) {
            width = i;
        } else {
            width = i;
        }
        return Bitmap.createScaledBitmap(bitmap, width, i, false);
    }

    Bitmap m5576a(byte[] bArr, Camera camera) {
        Size previewSize = camera.getParameters().getPreviewSize();
        int[] iArr = new int[(previewSize.width * previewSize.height)];
        Log.d("TIME", "1:" + System.currentTimeMillis());
        CameraActivity.m5574a(iArr, bArr, previewSize.width, previewSize.height);
        Log.d("TIME", "2:" + System.currentTimeMillis());
        return Bitmap.createBitmap(iArr, previewSize.width, previewSize.height, Config.ARGB_8888);
    }

    public static final void m5574a(int[] iArr, byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i3 + ((i5 >> 1) * i);
            int i7 = 0;
            int i8 = 0;
            int i9 = i4;
            int i10 = 0;
            while (i8 < i) {
                int i11;
                int i12;
                int i13 = (bArr[i9] & MotionEventCompat.ACTION_MASK) - 16;
                if (i13 < 0) {
                    i11 = 0;
                } else {
                    i11 = i13;
                }
                if ((i8 & 1) == 0) {
                    i7 = i6 + 1;
                    i10 = (bArr[i6] & MotionEventCompat.ACTION_MASK) - 128;
                    i13 = i10;
                    i4 = (bArr[i7] & MotionEventCompat.ACTION_MASK) - 128;
                    i12 = i7 + 1;
                } else {
                    i13 = i10;
                    i4 = i7;
                    i12 = i6;
                }
                i10 = i11 * 1192;
                i6 = i10 + (i13 * 1634);
                i7 = (i10 - (i13 * 833)) - (i4 * 400);
                i10 += i4 * 2066;
                if (i6 < 0) {
                    i6 = 0;
                } else if (i6 > 262143) {
                    i6 = 262143;
                }
                if (i7 < 0) {
                    i7 = 0;
                } else if (i7 > 262143) {
                    i7 = 262143;
                }
                if (i10 < 0) {
                    i10 = 0;
                } else if (i10 > 262143) {
                    i10 = 262143;
                }
                i10 = (i10 >> 10) & MotionEventCompat.ACTION_MASK;
                iArr[i9] = i10 | (((i7 >> 2) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (((i6 << 6) & 16711680) | ViewCompat.MEASURED_STATE_MASK));
                i8++;
                i6 = i12;
                i9++;
                i10 = i13;
                i7 = i4;
            }
            i4 = i9;
        }
    }
}
