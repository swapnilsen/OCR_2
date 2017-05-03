package com.crashlytics.android.core;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;
import p000a.p001a.p002a.p003a.p004a.p012g.PromptSettingsData;

class CrashPromptDialog {
    private final Builder dialog;
    private final OptInLatch latch;

    /* renamed from: com.crashlytics.android.core.CrashPromptDialog.1 */
    static class C03831 implements OnClickListener {
        final /* synthetic */ OptInLatch val$latch;

        C03831(OptInLatch optInLatch) {
            this.val$latch = optInLatch;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.val$latch.setOptIn(true);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashPromptDialog.2 */
    static class C03842 implements OnClickListener {
        final /* synthetic */ OptInLatch val$latch;

        C03842(OptInLatch optInLatch) {
            this.val$latch = optInLatch;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.val$latch.setOptIn(false);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashPromptDialog.3 */
    static class C03853 implements OnClickListener {
        final /* synthetic */ AlwaysSendCallback val$alwaysSendCallback;
        final /* synthetic */ OptInLatch val$latch;

        C03853(AlwaysSendCallback alwaysSendCallback, OptInLatch optInLatch) {
            this.val$alwaysSendCallback = alwaysSendCallback;
            this.val$latch = optInLatch;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.val$alwaysSendCallback.sendUserReportsWithoutPrompting(true);
            this.val$latch.setOptIn(true);
            dialogInterface.dismiss();
        }
    }

    interface AlwaysSendCallback {
        void sendUserReportsWithoutPrompting(boolean z);
    }

    private static class OptInLatch {
        private final CountDownLatch latch;
        private boolean send;

        private OptInLatch() {
            this.send = false;
            this.latch = new CountDownLatch(1);
        }

        void setOptIn(boolean z) {
            this.send = z;
            this.latch.countDown();
        }

        boolean getOptIn() {
            return this.send;
        }

        void await() {
            try {
                this.latch.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public static CrashPromptDialog create(Activity activity, PromptSettingsData promptSettingsData, AlwaysSendCallback alwaysSendCallback) {
        OptInLatch optInLatch = new OptInLatch();
        DialogStringResolver dialogStringResolver = new DialogStringResolver(activity, promptSettingsData);
        Builder builder = new Builder(activity);
        View createDialogView = createDialogView(activity, dialogStringResolver.getMessage());
        builder.setView(createDialogView).setTitle(dialogStringResolver.getTitle()).setCancelable(false).setNeutralButton(dialogStringResolver.getSendButtonTitle(), new C03831(optInLatch));
        if (promptSettingsData.f250d) {
            builder.setNegativeButton(dialogStringResolver.getCancelButtonTitle(), new C03842(optInLatch));
        }
        if (promptSettingsData.f252f) {
            builder.setPositiveButton(dialogStringResolver.getAlwaysSendButtonTitle(), new C03853(alwaysSendCallback, optInLatch));
        }
        return new CrashPromptDialog(builder, optInLatch);
    }

    private static ScrollView createDialogView(Activity activity, String str) {
        float f = activity.getResources().getDisplayMetrics().density;
        int dipsToPixels = dipsToPixels(f, 5);
        View textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, 16973892);
        textView.setPadding(dipsToPixels, dipsToPixels, dipsToPixels, dipsToPixels);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(dipsToPixels(f, 14), dipsToPixels(f, 2), dipsToPixels(f, 10), dipsToPixels(f, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    private static int dipsToPixels(float f, int i) {
        return (int) (((float) i) * f);
    }

    private CrashPromptDialog(Builder builder, OptInLatch optInLatch) {
        this.latch = optInLatch;
        this.dialog = builder;
    }

    public void show() {
        this.dialog.show();
    }

    public void await() {
        this.latch.await();
    }

    public boolean getOptIn() {
        return this.latch.getOptIn();
    }
}
