package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    /* renamed from: com.google.android.gms.tagmanager.PreviewActivity.1 */
    class C14351 implements OnClickListener {
        C14351(PreviewActivity previewActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private void zzp(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C14351(this));
        create.show();
    }

    public void onCreate(Bundle bundle) {
        String str;
        String valueOf;
        try {
            super.onCreate(bundle);
            zzbo.zzbg("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).zzv(data)) {
                valueOf = String.valueOf(data);
                valueOf = new StringBuilder(String.valueOf(valueOf).length() + 73).append("Cannot preview the app with the uri: ").append(valueOf).append(". Launching current version instead.").toString();
                zzbo.zzbh(valueOf);
                zzp("Preview failure", valueOf, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                String str2 = "Invoke the launch activity for package name: ";
                valueOf = String.valueOf(getPackageName());
                zzbo.zzbg(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                startActivity(launchIntentForPackage);
                return;
            }
            str = "No launch activity found for package name: ";
            valueOf = String.valueOf(getPackageName());
            zzbo.zzbg(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } catch (Exception e) {
            str = "Calling preview threw an exception: ";
            valueOf = String.valueOf(e.getMessage());
            zzbo.m4711e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
