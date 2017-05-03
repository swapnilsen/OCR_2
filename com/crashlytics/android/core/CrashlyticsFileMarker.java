package com.crashlytics.android.core;

import java.io.File;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.p004a.p011f.FileStore;

class CrashlyticsFileMarker {
    private final FileStore fileStore;
    private final String markerName;

    public CrashlyticsFileMarker(String str, FileStore fileStore) {
        this.markerName = str;
        this.fileStore = fileStore;
    }

    public boolean create() {
        boolean z = false;
        try {
            z = getMarkerFile().createNewFile();
        } catch (Throwable e) {
            Fabric.m397h().m367e(CrashlyticsCore.TAG, "Error creating marker: " + this.markerName, e);
        }
        return z;
    }

    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    public boolean remove() {
        return getMarkerFile().delete();
    }

    private File getMarkerFile() {
        return new File(this.fileStore.m298a(), this.markerName);
    }
}
