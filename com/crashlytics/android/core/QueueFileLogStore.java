package com.crashlytics.android.core;

import java.io.File;
import java.io.InputStream;
import java.util.Locale;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.QueueFile;

class QueueFileLogStore implements FileLogStore {
    private QueueFile logFile;
    private final int maxLogSize;
    private final File workingFile;

    /* renamed from: com.crashlytics.android.core.QueueFileLogStore.1 */
    class C04081 implements QueueFile.QueueFile {
        final /* synthetic */ byte[] val$logBytes;
        final /* synthetic */ int[] val$offsetHolder;

        C04081(byte[] bArr, int[] iArr) {
            this.val$logBytes = bArr;
            this.val$offsetHolder = iArr;
        }

        public void read(InputStream inputStream, int i) {
            try {
                inputStream.read(this.val$logBytes, this.val$offsetHolder[0], i);
                int[] iArr = this.val$offsetHolder;
                iArr[0] = iArr[0] + i;
            } finally {
                inputStream.close();
            }
        }
    }

    public QueueFileLogStore(File file, int i) {
        this.workingFile = file;
        this.maxLogSize = i;
    }

    public void writeToLog(long j, String str) {
        openLogFile();
        doWriteToLog(j, str);
    }

    public ByteString getLogAsByteString() {
        if (!this.workingFile.exists()) {
            return null;
        }
        openLogFile();
        if (this.logFile == null) {
            return null;
        }
        int[] iArr = new int[]{0};
        byte[] bArr = new byte[this.logFile.m131a()];
        try {
            this.logFile.m132a(new C04081(bArr, iArr));
        } catch (Throwable e) {
            Fabric.m397h().m367e(CrashlyticsCore.TAG, "A problem occurred while reading the Crashlytics log file.", e);
        }
        return ByteString.copyFrom(bArr, 0, iArr[0]);
    }

    public void closeLogFile() {
        CommonUtils.m57a(this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = null;
    }

    public void deleteLogFile() {
        closeLogFile();
        this.workingFile.delete();
    }

    private void openLogFile() {
        if (this.logFile == null) {
            try {
                this.logFile = new QueueFile(this.workingFile);
            } catch (Throwable e) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "Could not open log file: " + this.workingFile, e);
            }
        }
    }

    private void doWriteToLog(long j, String str) {
        if (this.logFile != null) {
            String str2;
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            try {
                int i = this.maxLogSize / 4;
                if (str2.length() > i) {
                    str2 = "..." + str2.substring(str2.length() - i);
                }
                str2 = str2.replaceAll("\r", " ").replaceAll("\n", " ");
                this.logFile.m133a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str2}).getBytes("UTF-8"));
                while (!this.logFile.m136b() && this.logFile.m131a() > this.maxLogSize) {
                    this.logFile.m137c();
                }
            } catch (Throwable e) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
