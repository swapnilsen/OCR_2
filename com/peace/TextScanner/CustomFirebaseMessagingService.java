package com.peace.TextScanner;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Locale;

public class CustomFirebaseMessagingService extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            int i = VERSION.SDK_INT < 21 ? 2130837654 : 2130837653;
            String str = (String) remoteMessage.getData().get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            String str2 = (String) remoteMessage.getData().get("message");
            String str3 = (String) remoteMessage.getData().get("emoji");
            String str4 = (String) remoteMessage.getData().get("action");
            if (str3 == null || !str3.matches("0x.*")) {
                str3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            } else {
                str3 = new String(Character.toChars(Integer.decode(str3).intValue()));
            }
            Builder contentText = new Builder(this).setAutoCancel(true).setColor(16711680).setSmallIcon(i).setLargeIcon(BitmapFactory.decodeResource(getResources(), 2130837654)).setContentTitle(str + str3).setContentText(str2);
            Intent intent = new Intent(this, CameraActivity.class);
            intent.putExtra("action", str4);
            intent.putExtra("from", "notification");
            contentText.setContentIntent(PendingIntent.getActivity(this, 0, intent, 268435456));
            ((NotificationManager) getSystemService("notification")).notify(0, contentText.build());
            Globals globals = (Globals) getApplication();
            str2 = Locale.getDefault().getLanguage();
            if (str2 == null) {
                str2 = "N/A";
            }
            globals.f5011t.send(new EventBuilder().setCategory("CameraActivity").setAction("NotificationReceive").setLabel(str2).build());
        } catch (Throwable th) {
        }
    }
}
