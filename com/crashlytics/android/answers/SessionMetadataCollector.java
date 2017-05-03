package com.crashlytics.android.answers;

import android.content.Context;
import java.util.Map;
import java.util.UUID;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.IdManager;

class SessionMetadataCollector {
    private final Context context;
    private final IdManager idManager;
    private final String versionCode;
    private final String versionName;

    public SessionMetadataCollector(Context context, IdManager idManager, String str, String str2) {
        this.context = context;
        this.idManager = idManager;
        this.versionCode = str;
        this.versionName = str2;
    }

    public SessionEventMetadata getMetadata() {
        Map i = this.idManager.m104i();
        return new SessionEventMetadata(this.idManager.m98c(), UUID.randomUUID().toString(), this.idManager.m97b(), (String) i.get(IdManager.IdManager.ANDROID_ID), (String) i.get(IdManager.IdManager.ANDROID_ADVERTISING_ID), this.idManager.m107l(), (String) i.get(IdManager.IdManager.FONT_TOKEN), CommonUtils.m80m(this.context), this.idManager.m99d(), this.idManager.m102g(), this.versionCode, this.versionName);
    }
}
