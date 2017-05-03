package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.p004a.p006b.BackgroundPriorityRunnable;

class ReportUploader {
    private static final String CLS_FILE_EXT = ".cls";
    static final Map<String, String> HEADER_INVALID_CLS_FILE;
    private static final short[] RETRY_INTERVALS;
    private static final FilenameFilter crashFileFilter;
    private final String apiKey;
    private final CreateReportSpiCall createReportCall;
    private final Object fileAccessLock;
    private Thread uploadThread;

    interface SendCheck {
        boolean canSendReports();
    }

    /* renamed from: com.crashlytics.android.core.ReportUploader.1 */
    static class C04101 implements FilenameFilter {
        C04101() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(ReportUploader.CLS_FILE_EXT) && !str.contains("Session");
        }
    }

    static final class AlwaysSendCheck implements SendCheck {
        AlwaysSendCheck() {
        }

        public boolean canSendReports() {
            return true;
        }
    }

    private class Worker extends BackgroundPriorityRunnable {
        private final float delay;
        private final SendCheck sendCheck;

        Worker(float f, SendCheck sendCheck) {
            this.delay = f;
            this.sendCheck = sendCheck;
        }

        public void onRun() {
            try {
                attemptUploadWithRetry();
            } catch (Throwable e) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.uploadThread = null;
        }

        private void attemptUploadWithRetry() {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Starting report processing in " + this.delay + " second(s)...");
            if (this.delay > 0.0f) {
                try {
                    Thread.sleep((long) (this.delay * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            CrashlyticsController controller = CrashlyticsCore.getInstance().getController();
            List<Report> findReports = ReportUploader.this.findReports();
            if (!controller.isHandlingException()) {
                if (findReports.isEmpty() || this.sendCheck.canSendReports()) {
                    List list = findReports;
                    int i = 0;
                    while (!r0.isEmpty() && !controller.isHandlingException()) {
                        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Attempting to send " + r0.size() + " report(s)");
                        for (Report forceUpload : r0) {
                            ReportUploader.this.forceUpload(forceUpload);
                        }
                        List findReports2 = ReportUploader.this.findReports();
                        if (findReports2.isEmpty()) {
                            list = findReports2;
                        } else {
                            int i2 = i + 1;
                            long j = (long) ReportUploader.RETRY_INTERVALS[Math.min(i, ReportUploader.RETRY_INTERVALS.length - 1)];
                            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                                list = findReports2;
                            } catch (InterruptedException e2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                Fabric.m397h().m359a(CrashlyticsCore.TAG, "User declined to send. Removing " + findReports.size() + " Report(s).");
                for (Report forceUpload2 : findReports) {
                    forceUpload2.remove();
                }
            }
        }
    }

    static {
        crashFileFilter = new C04101();
        HEADER_INVALID_CLS_FILE = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
        RETRY_INTERVALS = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    }

    public ReportUploader(String str, CreateReportSpiCall createReportSpiCall) {
        this.fileAccessLock = new Object();
        if (createReportSpiCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.createReportCall = createReportSpiCall;
        this.apiKey = str;
    }

    public synchronized void uploadReports(float f, SendCheck sendCheck) {
        if (this.uploadThread != null) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Report upload has already been started.");
        } else {
            this.uploadThread = new Thread(new Worker(f, sendCheck), "Crashlytics Report Uploader");
            this.uploadThread.start();
        }
    }

    boolean isUploading() {
        return this.uploadThread != null;
    }

    boolean forceUpload(Report report) {
        boolean z = false;
        synchronized (this.fileAccessLock) {
            try {
                boolean invoke = this.createReportCall.invoke(new CreateReportRequest(this.apiKey, report));
                Fabric.m397h().m363c(CrashlyticsCore.TAG, "Crashlytics report upload " + (invoke ? "complete: " : "FAILED: ") + report.getIdentifier());
                if (invoke) {
                    report.remove();
                    z = true;
                }
            } catch (Throwable e) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "Error occurred sending report " + report, e);
            }
        }
        return z;
    }

    List<Report> findReports() {
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Checking for crash reports...");
        CrashlyticsController controller = CrashlyticsCore.getInstance().getController();
        synchronized (this.fileAccessLock) {
            File[] listFiles = controller.getFilesDir().listFiles(crashFileFilter);
            File[] listFiles2 = controller.getInvalidFilesDir().listFiles();
        }
        List<Report> linkedList = new LinkedList();
        for (File file : listFiles) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Found crash report " + file.getPath());
            linkedList.add(new SessionReport(file));
        }
        Map hashMap = new HashMap();
        if (listFiles2 != null) {
            for (File file2 : listFiles2) {
                String sessionIdFromSessionFile = CrashlyticsController.getSessionIdFromSessionFile(file2);
                if (!hashMap.containsKey(sessionIdFromSessionFile)) {
                    hashMap.put(sessionIdFromSessionFile, new LinkedList());
                }
                ((List) hashMap.get(sessionIdFromSessionFile)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Found invalid session: " + str);
            List list = (List) hashMap.get(str);
            linkedList.add(new InvalidSessionReport(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (linkedList.isEmpty()) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "No reports found.");
        }
        return linkedList;
    }
}
