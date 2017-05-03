package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.C0902R;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@zzme
public class zzpr {
    private final Context mContext;
    private int mState;
    private final float zzMx;
    private String zzXK;
    private float zzXL;
    private float zzXM;
    private float zzXN;
    private String zzts;
    private String zzwd;

    /* renamed from: com.google.android.gms.internal.zzpr.1 */
    class C13651 implements OnClickListener {
        final /* synthetic */ int zzXO;
        final /* synthetic */ int zzXP;
        final /* synthetic */ int zzXQ;
        final /* synthetic */ zzpr zzXR;

        C13651(zzpr com_google_android_gms_internal_zzpr, int i, int i2, int i3) {
            this.zzXR = com_google_android_gms_internal_zzpr;
            this.zzXO = i;
            this.zzXP = i2;
            this.zzXQ = i3;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == this.zzXO) {
                this.zzXR.zzkV();
            } else if (i == this.zzXP && ((Boolean) zzgd.zzFl.get()).booleanValue()) {
                this.zzXR.zzkW();
            } else if (i == this.zzXQ && ((Boolean) zzgd.zzFm.get()).booleanValue()) {
                this.zzXR.zzkX();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpr.2 */
    class C13662 implements OnClickListener {
        final /* synthetic */ zzpr zzXR;
        final /* synthetic */ String zzXS;

        C13662(zzpr com_google_android_gms_internal_zzpr, String str) {
            this.zzXR = com_google_android_gms_internal_zzpr;
            this.zzXS = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            zzw.zzcM().zzb(this.zzXR.mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.zzXS), "Share via"));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpr.3 */
    class C13673 implements OnClickListener {
        C13673(zzpr com_google_android_gms_internal_zzpr) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpr.4 */
    class C13684 implements Runnable {
        final /* synthetic */ zzpr zzXR;

        C13684(zzpr com_google_android_gms_internal_zzpr) {
            this.zzXR = com_google_android_gms_internal_zzpr;
        }

        public void run() {
            zzw.zzcU().zzh(this.zzXR.mContext, this.zzXR.zzts, this.zzXR.zzwd);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpr.5 */
    class C13695 implements Runnable {
        final /* synthetic */ zzpr zzXR;

        C13695(zzpr com_google_android_gms_internal_zzpr) {
            this.zzXR = com_google_android_gms_internal_zzpr;
        }

        public void run() {
            zzw.zzcU().zzi(this.zzXR.mContext, this.zzXR.zzts, this.zzXR.zzwd);
        }
    }

    public zzpr(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzMx = context.getResources().getDisplayMetrics().density;
    }

    public zzpr(Context context, String str) {
        this(context);
        this.zzXK = str;
    }

    private int zza(List<String> list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    static String zzbc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map zzg = zzw.zzcM().zzg(build);
        for (String str2 : zzg.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) zzg.get(str2)).append("\n\n");
        }
        Object trim = stringBuilder.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    private void zzkU() {
        if (this.mContext instanceof Activity) {
            CharSequence string;
            Resources resources = zzw.zzcQ().getResources();
            if (resources != null) {
                string = resources.getString(C0902R.string.debug_menu_title);
            } else {
                Object obj = "Select a Debug Mode";
            }
            String string2 = resources != null ? resources.getString(C0902R.string.debug_menu_ad_information) : "Ad Information";
            String string3 = resources != null ? resources.getString(C0902R.string.debug_menu_creative_preview) : "Creative Preview";
            String string4 = resources != null ? resources.getString(C0902R.string.debug_menu_troubleshooting) : "Troubleshooting";
            List arrayList = new ArrayList();
            new AlertDialog.Builder(this.mContext).setTitle(string).setItems((CharSequence[]) arrayList.toArray(new String[0]), new C13651(this, zza(arrayList, string2, true), zza(arrayList, string3, ((Boolean) zzgd.zzFl.get()).booleanValue()), zza(arrayList, string4, ((Boolean) zzgd.zzFm.get()).booleanValue()))).create().show();
            return;
        }
        zzqf.zzbg("Can not create dialog without Activity Context");
    }

    private void zzkV() {
        if (this.mContext instanceof Activity) {
            Object zzbc = zzbc(this.zzXK);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
            builder.setMessage(zzbc);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new C13662(this, zzbc));
            builder.setNegativeButton("Close", new C13673(this));
            builder.create().show();
            return;
        }
        zzqf.zzbg("Can not create dialog without Activity Context");
    }

    private void zzkW() {
        zzqf.zzbf("Debug mode [Creative Preview] selected.");
        zzpn.zza(new C13684(this));
    }

    private void zzkX() {
        zzqf.zzbf("Debug mode [Troubleshooting] selected.");
        zzpn.zza(new C13695(this));
    }

    public void setAdUnitId(String str) {
        this.zzts = str;
    }

    public void showDialog() {
        if (((Boolean) zzgd.zzFm.get()).booleanValue() || ((Boolean) zzgd.zzFl.get()).booleanValue()) {
            zzkU();
        } else {
            zzkV();
        }
    }

    void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzXL = f;
            this.zzXM = f2;
            this.zzXN = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.zzXM) {
                    this.zzXM = f2;
                } else if (f2 < this.zzXN) {
                    this.zzXN = f2;
                }
                if (this.zzXM - this.zzXN > 30.0f * this.zzMx) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.zzXL >= 50.0f * this.zzMx) {
                        this.zzXL = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.zzXL <= -50.0f * this.zzMx) {
                    this.zzXL = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.zzXL) {
                        this.zzXL = f;
                    }
                } else if (this.mState == 2 && f < this.zzXL) {
                    this.zzXL = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    public void zzba(String str) {
        this.zzwd = str;
    }

    public void zzbb(String str) {
        this.zzXK = str;
    }

    public void zzg(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
