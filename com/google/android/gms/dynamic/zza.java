package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzh;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private T zzaRA;
    private Bundle zzaRB;
    private LinkedList<zza> zzaRC;
    private final zze<T> zzaRD;

    /* renamed from: com.google.android.gms.dynamic.zza.1 */
    class C09941 implements zze<T> {
        final /* synthetic */ zza zzaRE;

        C09941(zza com_google_android_gms_dynamic_zza) {
            this.zzaRE = com_google_android_gms_dynamic_zza;
        }

        public void zza(T t) {
            this.zzaRE.zzaRA = t;
            Iterator it = this.zzaRE.zzaRC.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzb(this.zzaRE.zzaRA);
            }
            this.zzaRE.zzaRC.clear();
            this.zzaRE.zzaRB = null;
        }
    }

    private interface zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    /* renamed from: com.google.android.gms.dynamic.zza.2 */
    class C09952 implements zza {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ zza zzaRE;
        final /* synthetic */ Bundle zzaRF;
        final /* synthetic */ Bundle zzxo;

        C09952(zza com_google_android_gms_dynamic_zza, Activity activity, Bundle bundle, Bundle bundle2) {
            this.zzaRE = com_google_android_gms_dynamic_zza;
            this.val$activity = activity;
            this.zzaRF = bundle;
            this.zzxo = bundle2;
        }

        public int getState() {
            return 0;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzaRE.zzaRA.onInflate(this.val$activity, this.zzaRF, this.zzxo);
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.3 */
    class C09963 implements zza {
        final /* synthetic */ zza zzaRE;
        final /* synthetic */ Bundle zzxo;

        C09963(zza com_google_android_gms_dynamic_zza, Bundle bundle) {
            this.zzaRE = com_google_android_gms_dynamic_zza;
            this.zzxo = bundle;
        }

        public int getState() {
            return 1;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzaRE.zzaRA.onCreate(this.zzxo);
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.4 */
    class C09974 implements zza {
        final /* synthetic */ zza zzaRE;
        final /* synthetic */ FrameLayout zzaRG;
        final /* synthetic */ LayoutInflater zzaRH;
        final /* synthetic */ ViewGroup zzaRI;
        final /* synthetic */ Bundle zzxo;

        C09974(zza com_google_android_gms_dynamic_zza, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.zzaRE = com_google_android_gms_dynamic_zza;
            this.zzaRG = frameLayout;
            this.zzaRH = layoutInflater;
            this.zzaRI = viewGroup;
            this.zzxo = bundle;
        }

        public int getState() {
            return 2;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzaRG.removeAllViews();
            this.zzaRG.addView(this.zzaRE.zzaRA.onCreateView(this.zzaRH, this.zzaRI, this.zzxo));
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.5 */
    class C09985 implements OnClickListener {
        final /* synthetic */ Intent zzaRJ;
        final /* synthetic */ Context zztf;

        C09985(Context context, Intent intent) {
            this.zztf = context;
            this.zzaRJ = intent;
        }

        public void onClick(View view) {
            try {
                this.zztf.startActivity(this.zzaRJ);
            } catch (Throwable e) {
                Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.6 */
    class C09996 implements zza {
        final /* synthetic */ zza zzaRE;

        C09996(zza com_google_android_gms_dynamic_zza) {
            this.zzaRE = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzaRE.zzaRA.onStart();
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.7 */
    class C10007 implements zza {
        final /* synthetic */ zza zzaRE;

        C10007(zza com_google_android_gms_dynamic_zza) {
            this.zzaRE = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzaRE.zzaRA.onResume();
        }
    }

    public zza() {
        this.zzaRD = new C09941(this);
    }

    private void zza(Bundle bundle, zza com_google_android_gms_dynamic_zza_zza) {
        if (this.zzaRA != null) {
            com_google_android_gms_dynamic_zza_zza.zzb(this.zzaRA);
            return;
        }
        if (this.zzaRC == null) {
            this.zzaRC = new LinkedList();
        }
        this.zzaRC.add(com_google_android_gms_dynamic_zza_zza);
        if (bundle != null) {
            if (this.zzaRB == null) {
                this.zzaRB = (Bundle) bundle.clone();
            } else {
                this.zzaRB.putAll(bundle);
            }
        }
        zza(this.zzaRD);
    }

    @VisibleForTesting
    static void zza(FrameLayout frameLayout, GoogleApiAvailability googleApiAvailability) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
        CharSequence zzi = zzh.zzi(context, isGooglePlayServicesAvailable);
        CharSequence zzk = zzh.zzk(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zzi);
        linearLayout.addView(textView);
        Intent zzb = googleApiAvailability.zzb(context, isGooglePlayServicesAvailable, null);
        if (zzb != null) {
            View button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzk);
            linearLayout.addView(button);
            button.setOnClickListener(new C09985(context, zzb));
        }
    }

    public static void zzb(FrameLayout frameLayout) {
        zza(frameLayout, GoogleApiAvailability.getInstance());
    }

    private void zzgt(int i) {
        while (!this.zzaRC.isEmpty() && ((zza) this.zzaRC.getLast()).getState() >= i) {
            this.zzaRC.removeLast();
        }
    }

    public void onCreate(Bundle bundle) {
        zza(bundle, new C09963(this, bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        zza(bundle, new C09974(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.zzaRA == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzaRA != null) {
            this.zzaRA.onDestroy();
        } else {
            zzgt(1);
        }
    }

    public void onDestroyView() {
        if (this.zzaRA != null) {
            this.zzaRA.onDestroyView();
        } else {
            zzgt(2);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        zza(bundle2, new C09952(this, activity, bundle, bundle2));
    }

    public void onLowMemory() {
        if (this.zzaRA != null) {
            this.zzaRA.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzaRA != null) {
            this.zzaRA.onPause();
        } else {
            zzgt(5);
        }
    }

    public void onResume() {
        zza(null, new C10007(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.zzaRA != null) {
            this.zzaRA.onSaveInstanceState(bundle);
        } else if (this.zzaRB != null) {
            bundle.putAll(this.zzaRB);
        }
    }

    public void onStart() {
        zza(null, new C09996(this));
    }

    public void onStop() {
        if (this.zzaRA != null) {
            this.zzaRA.onStop();
        } else {
            zzgt(4);
        }
    }

    public T zzBN() {
        return this.zzaRA;
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zze<T> com_google_android_gms_dynamic_zze_T);
}
