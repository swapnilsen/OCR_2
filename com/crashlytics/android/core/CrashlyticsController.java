package com.crashlytics.android.core;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.internal.models.SessionEventData;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.Logger;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.Crash.Crash;
import p000a.p001a.p002a.p003a.p004a.p006b.DeliveryMechanism;
import p000a.p001a.p002a.p003a.p004a.p006b.IdManager;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;
import p000a.p001a.p002a.p003a.p004a.p011f.FileStore;
import p000a.p001a.p002a.p003a.p004a.p012g.PromptSettingsData;
import p000a.p001a.p002a.p003a.p004a.p012g.SessionSettingsData;
import p000a.p001a.p002a.p003a.p004a.p012g.Settings;
import p000a.p001a.p002a.p003a.p004a.p012g.SettingsData;

class CrashlyticsController {
    private static final int ANALYZER_VERSION = 1;
    static final FilenameFilter ANY_SESSION_FILENAME_FILTER;
    private static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    private static final String[] INITIAL_SESSION_PART_TAGS;
    static final String INVALID_CLS_CACHE_DIR = "invalidClsFiles";
    static final Comparator<File> LARGEST_FILE_NAME_FIRST;
    private static final int MAX_COMPLETE_SESSIONS_COUNT = 4;
    static final int MAX_INVALID_SESSIONS = 4;
    private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
    static final int MAX_OPEN_SESSIONS = 8;
    static final int MAX_STACK_SIZE = 1024;
    static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private static final Map<String, String> SEND_AT_CRASHTIME_HEADER;
    static final String SESSION_APP_TAG = "SessionApp";
    static final String SESSION_BEGIN_TAG = "BeginSession";
    static final String SESSION_DEVICE_TAG = "SessionDevice";
    static final String SESSION_EVENT_MISSING_BINARY_IMGS_TAG = "SessionMissingBinaryImages";
    static final String SESSION_FATAL_TAG = "SessionCrash";
    static final FilenameFilter SESSION_FILE_FILTER;
    private static final Pattern SESSION_FILE_PATTERN;
    private static final int SESSION_ID_LENGTH = 35;
    static final String SESSION_NON_FATAL_TAG = "SessionEvent";
    static final String SESSION_OS_TAG = "SessionOS";
    static final String SESSION_USER_TAG = "SessionUser";
    private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
    static final Comparator<File> SMALLEST_FILE_NAME_FIRST;
    private final AppData appData;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    private final CrashlyticsCore crashlyticsCore;
    private final DevicePowerStateListener devicePowerStateListener;
    private final AtomicInteger eventCounter;
    private final FileStore fileStore;
    private final HttpRequestFactory httpRequestFactory;
    private final IdManager idManager;
    private final LogFileManager logFileManager;
    private final PreferenceManager preferenceManager;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    private final String unityVersion;

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.10 */
    class AnonymousClass10 implements Callable<Void> {
        final /* synthetic */ Map val$keyData;

        AnonymousClass10(Map map) {
            this.val$keyData = map;
        }

        public Void call() {
            new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeKeyData(CrashlyticsController.this.getCurrentSessionId(), this.val$keyData);
            return null;
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.12 */
    class AnonymousClass12 implements Callable<Boolean> {
        final /* synthetic */ SessionSettingsData val$sessionSettingsData;

        AnonymousClass12(SessionSettingsData sessionSettingsData) {
            this.val$sessionSettingsData = sessionSettingsData;
        }

        public Boolean call() {
            if (CrashlyticsController.this.isHandlingException()) {
                Fabric.m397h().m359a(CrashlyticsCore.TAG, "Skipping session finalization because a crash has already occurred.");
                return Boolean.FALSE;
            }
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Finalizing previously open sessions.");
            CrashlyticsController.this.doCloseSessions(this.val$sessionSettingsData, true);
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Closed all previously open sessions");
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.14 */
    class AnonymousClass14 implements FilenameFilter {
        final /* synthetic */ Set val$invalidSessionIds;

        AnonymousClass14(Set set) {
            this.val$invalidSessionIds = set;
        }

        public boolean accept(File file, String str) {
            if (str.length() < CrashlyticsController.SESSION_ID_LENGTH) {
                return false;
            }
            return this.val$invalidSessionIds.contains(str.substring(0, CrashlyticsController.SESSION_ID_LENGTH));
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.15 */
    class AnonymousClass15 implements Callable<Void> {
        final /* synthetic */ SessionEventData val$crashEventData;

        AnonymousClass15(SessionEventData sessionEventData) {
            this.val$crashEventData = sessionEventData;
        }

        public Void call() {
            if (!CrashlyticsController.this.isHandlingException()) {
                CrashlyticsController.this.doWriteExternalCrashEvent(this.val$crashEventData);
            }
            return null;
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.1 */
    static class C03891 implements FilenameFilter {
        C03891() {
        }

        public boolean accept(File file, String str) {
            return str.length() == ClsFileOutputStream.SESSION_FILE_EXTENSION.length() + CrashlyticsController.SESSION_ID_LENGTH && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.2 */
    static class C03902 implements Comparator<File> {
        C03902() {
        }

        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.3 */
    static class C03913 implements Comparator<File> {
        C03913() {
        }

        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.4 */
    static class C03924 implements FilenameFilter {
        C03924() {
        }

        public boolean accept(File file, String str) {
            return CrashlyticsController.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.5 */
    class C03935 implements CrashListener {
        C03935() {
        }

        public void onUncaughtException(Thread thread, Throwable th) {
            CrashlyticsController.this.handleUncaughtException(thread, th);
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.6 */
    class C03946 implements Callable<Void> {
        final /* synthetic */ Throwable val$ex;
        final /* synthetic */ Thread val$thread;
        final /* synthetic */ Date val$time;

        C03946(Date date, Thread thread, Throwable th) {
            this.val$time = date;
            this.val$thread = thread;
            this.val$ex = th;
        }

        public Void call() {
            CrashlyticsController.this.crashlyticsCore.createCrashMarker();
            CrashlyticsController.this.writeFatal(this.val$time, this.val$thread, this.val$ex);
            SettingsData b = Settings.m347a().m350b();
            CrashlyticsController.this.doCloseSessions(b != null ? b.f270b : null);
            CrashlyticsController.this.doOpenSession();
            CrashlyticsController.this.trimSessionFiles();
            if (!CrashlyticsController.this.shouldPromptUserBeforeSendingCrashReports(b)) {
                CrashlyticsController.this.sendSessionReports(b);
            }
            return null;
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.7 */
    class C03957 implements Callable<Void> {
        final /* synthetic */ String val$msg;
        final /* synthetic */ long val$timestamp;

        C03957(long j, String str) {
            this.val$timestamp = j;
            this.val$msg = str;
        }

        public Void call() {
            if (!CrashlyticsController.this.isHandlingException()) {
                CrashlyticsController.this.logFileManager.writeToLog(this.val$timestamp, this.val$msg);
            }
            return null;
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.8 */
    class C03968 implements Runnable {
        final /* synthetic */ Throwable val$ex;
        final /* synthetic */ Date val$now;
        final /* synthetic */ Thread val$thread;

        C03968(Date date, Thread thread, Throwable th) {
            this.val$now = date;
            this.val$thread = thread;
            this.val$ex = th;
        }

        public void run() {
            if (!CrashlyticsController.this.isHandlingException()) {
                CrashlyticsController.this.doWriteNonFatal(this.val$now, this.val$thread, this.val$ex);
            }
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsController.9 */
    class C03979 implements Callable<Void> {
        final /* synthetic */ String val$userEmail;
        final /* synthetic */ String val$userId;
        final /* synthetic */ String val$userName;

        C03979(String str, String str2, String str3) {
            this.val$userId = str;
            this.val$userName = str2;
            this.val$userEmail = str3;
        }

        public Void call() {
            new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeUserData(CrashlyticsController.this.getCurrentSessionId(), new UserMetaData(this.val$userId, this.val$userName, this.val$userEmail));
            return null;
        }
    }

    private static class AnySessionPartFileFilter implements FilenameFilter {
        private AnySessionPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            return !CrashlyticsController.SESSION_FILE_FILTER.accept(file, str) && CrashlyticsController.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    }

    static class FileNameContainsFilter implements FilenameFilter {
        private final String string;

        public FileNameContainsFilter(String str) {
            this.string = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.string) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    }

    static class InvalidPartFileFilter implements FilenameFilter {
        InvalidPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            return ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(file, str) || str.contains(CrashlyticsController.SESSION_EVENT_MISSING_BINARY_IMGS_TAG);
        }
    }

    private static final class PrivacyDialogCheck implements SendCheck {
        private final Kit kit;
        private final PreferenceManager preferenceManager;
        private final PromptSettingsData promptData;

        /* renamed from: com.crashlytics.android.core.CrashlyticsController.PrivacyDialogCheck.1 */
        class C03981 implements AlwaysSendCallback {
            C03981() {
            }

            public void sendUserReportsWithoutPrompting(boolean z) {
                PrivacyDialogCheck.this.preferenceManager.setShouldAlwaysSendReports(z);
            }
        }

        /* renamed from: com.crashlytics.android.core.CrashlyticsController.PrivacyDialogCheck.2 */
        class C03992 implements Runnable {
            final /* synthetic */ CrashPromptDialog val$dialog;

            C03992(CrashPromptDialog crashPromptDialog) {
                this.val$dialog = crashPromptDialog;
            }

            public void run() {
                this.val$dialog.show();
            }
        }

        public PrivacyDialogCheck(Kit kit, PreferenceManager preferenceManager, PromptSettingsData promptSettingsData) {
            this.kit = kit;
            this.preferenceManager = preferenceManager;
            this.promptData = promptSettingsData;
        }

        public boolean canSendReports() {
            Activity b = this.kit.getFabric().m404b();
            if (b == null || b.isFinishing()) {
                return true;
            }
            CrashPromptDialog create = CrashPromptDialog.create(b, this.promptData, new C03981());
            b.runOnUiThread(new C03992(create));
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Waiting for user opt-in.");
            create.await();
            return create.getOptIn();
        }
    }

    private static final class SendReportRunnable implements Runnable {
        private final Context context;
        private final Report report;
        private final ReportUploader reportUploader;

        public SendReportRunnable(Context context, Report report, ReportUploader reportUploader) {
            this.context = context;
            this.report = report;
            this.reportUploader = reportUploader;
        }

        public void run() {
            if (CommonUtils.m81n(this.context)) {
                Fabric.m397h().m359a(CrashlyticsCore.TAG, "Attempting to send crash report at time of crash...");
                this.reportUploader.forceUpload(this.report);
            }
        }
    }

    static class SessionPartFileFilter implements FilenameFilter {
        private final String sessionId;

        public SessionPartFileFilter(String str) {
            this.sessionId = str;
        }

        public boolean accept(File file, String str) {
            if (str.equals(this.sessionId + ClsFileOutputStream.SESSION_FILE_EXTENSION) || !str.contains(this.sessionId) || str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION)) {
                return false;
            }
            return true;
        }
    }

    static {
        SESSION_FILE_FILTER = new C03891();
        LARGEST_FILE_NAME_FIRST = new C03902();
        SMALLEST_FILE_NAME_FIRST = new C03913();
        ANY_SESSION_FILENAME_FILTER = new C03924();
        SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
        SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
        String[] strArr = new String[MAX_INVALID_SESSIONS];
        strArr[0] = SESSION_USER_TAG;
        strArr[ANALYZER_VERSION] = SESSION_APP_TAG;
        strArr[2] = SESSION_OS_TAG;
        strArr[3] = SESSION_DEVICE_TAG;
        INITIAL_SESSION_PART_TAGS = strArr;
    }

    CrashlyticsController(CrashlyticsCore crashlyticsCore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, HttpRequestFactory httpRequestFactory, IdManager idManager, PreferenceManager preferenceManager, FileStore fileStore, AppData appData, UnityVersionProvider unityVersionProvider) {
        this.eventCounter = new AtomicInteger(0);
        this.crashlyticsCore = crashlyticsCore;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.httpRequestFactory = httpRequestFactory;
        this.idManager = idManager;
        this.preferenceManager = preferenceManager;
        this.fileStore = fileStore;
        this.appData = appData;
        this.unityVersion = unityVersionProvider.getUnityVersion();
        Context context = crashlyticsCore.getContext();
        this.logFileManager = new LogFileManager(context, fileStore);
        this.devicePowerStateListener = new DevicePowerStateListener(context);
        StackTraceTrimmingStrategy[] stackTraceTrimmingStrategyArr = new StackTraceTrimmingStrategy[ANALYZER_VERSION];
        stackTraceTrimmingStrategyArr[0] = new RemoveRepeatsStrategy(NUM_STACK_REPETITIONS_ALLOWED);
        this.stackTraceTrimmingStrategy = new MiddleOutFallbackStrategy(MAX_STACK_SIZE, stackTraceTrimmingStrategyArr);
    }

    void enableExceptionHandling(UncaughtExceptionHandler uncaughtExceptionHandler) {
        openSession();
        this.crashHandler = new CrashlyticsUncaughtExceptionHandler(new C03935(), uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.crashHandler);
    }

    synchronized void handleUncaughtException(Thread thread, Throwable th) {
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        this.devicePowerStateListener.dispose();
        this.backgroundWorker.submitAndWait(new C03946(new Date(), thread, th));
    }

    void submitAllReports(float f, SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.m397h().m364d(CrashlyticsCore.TAG, "Could not send reports. Settings are not available.");
            return;
        }
        new ReportUploader(this.appData.apiKey, getCreateReportSpiCall(settingsData.f269a.f226d)).uploadReports(f, shouldPromptUserBeforeSendingCrashReports(settingsData) ? new PrivacyDialogCheck(this.crashlyticsCore, this.preferenceManager, settingsData.f271c) : new AlwaysSendCheck());
    }

    void writeToLog(long j, String str) {
        this.backgroundWorker.submit(new C03957(j, str));
    }

    void writeNonFatalException(Thread thread, Throwable th) {
        this.backgroundWorker.submit(new C03968(new Date(), thread, th));
    }

    void cacheUserData(String str, String str2, String str3) {
        this.backgroundWorker.submit(new C03979(str, str2, str3));
    }

    void cacheKeyData(Map<String, String> map) {
        this.backgroundWorker.submit(new AnonymousClass10(map));
    }

    void openSession() {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() {
                CrashlyticsController.this.doOpenSession();
                return null;
            }
        });
    }

    private String getCurrentSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        return listSortedSessionBeginFiles.length > 0 ? getSessionIdFromSessionFile(listSortedSessionBeginFiles[0]) : null;
    }

    private String getPreviousSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        return listSortedSessionBeginFiles.length > ANALYZER_VERSION ? getSessionIdFromSessionFile(listSortedSessionBeginFiles[ANALYZER_VERSION]) : null;
    }

    static String getSessionIdFromSessionFile(File file) {
        return file.getName().substring(0, SESSION_ID_LENGTH);
    }

    boolean hasOpenSession() {
        return listSessionBeginFiles().length > 0;
    }

    boolean finalizeSessions(SessionSettingsData sessionSettingsData) {
        return ((Boolean) this.backgroundWorker.submitAndWait(new AnonymousClass12(sessionSettingsData))).booleanValue();
    }

    private void doOpenSession() {
        Date date = new Date();
        String clsuuid = new CLSUUID(this.idManager).toString();
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Opening a new session with ID " + clsuuid);
        writeBeginSession(clsuuid, date);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
    }

    void doCloseSessions(SessionSettingsData sessionSettingsData) {
        doCloseSessions(sessionSettingsData, false);
    }

    private void doCloseSessions(SessionSettingsData sessionSettingsData, boolean z) {
        int i = z ? ANALYZER_VERSION : 0;
        trimOpenSessions(i + MAX_OPEN_SESSIONS);
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length <= i) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "No open sessions to be closed.");
            return;
        }
        writeSessionUser(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i]));
        if (sessionSettingsData == null) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Unable to close session. Settings are not loaded.");
        } else {
            closeOpenSessions(listSortedSessionBeginFiles, i, sessionSettingsData.f256c);
        }
    }

    private void closeOpenSessions(File[] fileArr, int i, int i2) {
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String sessionIdFromSessionFile = getSessionIdFromSessionFile(file);
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Closing session: " + sessionIdFromSessionFile);
            writeSessionPartsToSessionFile(file, sessionIdFromSessionFile, i2);
            i += ANALYZER_VERSION;
        }
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.closeInProgressStream();
            } catch (Throwable e) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void deleteSessionPartFilesFor(String str) {
        File[] listSessionPartFilesFor = listSessionPartFilesFor(str);
        int length = listSessionPartFilesFor.length;
        for (int i = 0; i < length; i += ANALYZER_VERSION) {
            listSessionPartFilesFor[i].delete();
        }
    }

    private File[] listSessionPartFilesFor(String str) {
        return listFilesMatching(new SessionPartFileFilter(str));
    }

    private File[] listCompleteSessionFiles() {
        return listFilesMatching(SESSION_FILE_FILTER);
    }

    File[] listSessionBeginFiles() {
        return listFilesMatching(new FileNameContainsFilter(SESSION_BEGIN_TAG));
    }

    private File[] listSortedSessionBeginFiles() {
        File[] listSessionBeginFiles = listSessionBeginFiles();
        Arrays.sort(listSessionBeginFiles, LARGEST_FILE_NAME_FIRST);
        return listSessionBeginFiles;
    }

    private File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(getFilesDir(), filenameFilter);
    }

    private File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }

    private File[] listFiles(File file) {
        return ensureFileArrayNotNull(file.listFiles());
    }

    private File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void trimSessionEventFiles(String str, int i) {
        Utils.capFileCount(getFilesDir(), new FileNameContainsFilter(str + SESSION_NON_FATAL_TAG), i, SMALLEST_FILE_NAME_FIRST);
    }

    void trimSessionFiles() {
        Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, MAX_INVALID_SESSIONS, SMALLEST_FILE_NAME_FIRST);
    }

    private void trimOpenSessions(int i) {
        Set hashSet = new HashSet();
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        int min = Math.min(i, listSortedSessionBeginFiles.length);
        for (int i2 = 0; i2 < min; i2 += ANALYZER_VERSION) {
            hashSet.add(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i2]));
        }
        this.logFileManager.discardOldLogFiles(hashSet);
        retainSessions(listFilesMatching(new AnySessionPartFileFilter()), hashSet);
    }

    private void retainSessions(File[] fileArr, Set<String> set) {
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            String name = file.getName();
            Matcher matcher = SESSION_FILE_PATTERN.matcher(name);
            if (matcher.matches()) {
                if (!set.contains(matcher.group(ANALYZER_VERSION))) {
                    Fabric.m397h().m359a(CrashlyticsCore.TAG, "Trimming session file: " + name);
                    file.delete();
                }
                i += ANALYZER_VERSION;
            } else {
                Fabric.m397h().m359a(CrashlyticsCore.TAG, "Deleting unknown file: " + name);
                file.delete();
                return;
            }
        }
    }

    private File[] getTrimmedNonFatalFiles(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        Logger h = Fabric.m397h();
        String str2 = CrashlyticsCore.TAG;
        Object[] objArr = new Object[ANALYZER_VERSION];
        objArr[0] = Integer.valueOf(i);
        h.m359a(str2, String.format(Locale.US, "Trimming down to %d logged exceptions.", objArr));
        trimSessionEventFiles(str, i);
        return listFilesMatching(new FileNameContainsFilter(str + SESSION_NON_FATAL_TAG));
    }

    void cleanInvalidTempFiles() {
        this.backgroundWorker.submit(new Runnable() {
            public void run() {
                CrashlyticsController.this.doCleanInvalidTempFiles(CrashlyticsController.this.listFilesMatching(new InvalidPartFileFilter()));
            }
        });
    }

    void doCleanInvalidTempFiles(File[] fileArr) {
        int i = 0;
        Set hashSet = new HashSet();
        int length = fileArr.length;
        for (int i2 = 0; i2 < length; i2 += ANALYZER_VERSION) {
            File file = fileArr[i2];
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Found invalid session part file: " + file);
            hashSet.add(getSessionIdFromSessionFile(file));
        }
        if (!hashSet.isEmpty()) {
            File invalidFilesDir = getInvalidFilesDir();
            if (!invalidFilesDir.exists()) {
                invalidFilesDir.mkdir();
            }
            File[] listFilesMatching = listFilesMatching(new AnonymousClass14(hashSet));
            length = listFilesMatching.length;
            while (i < length) {
                file = listFilesMatching[i];
                Fabric.m397h().m359a(CrashlyticsCore.TAG, "Moving session file: " + file);
                if (!file.renameTo(new File(invalidFilesDir, file.getName()))) {
                    Fabric.m397h().m359a(CrashlyticsCore.TAG, "Could not move session file. Deleting " + file);
                    file.delete();
                }
                i += ANALYZER_VERSION;
            }
            trimInvalidSessionFiles();
        }
    }

    private void trimInvalidSessionFiles() {
        File invalidFilesDir = getInvalidFilesDir();
        if (invalidFilesDir.exists()) {
            File[] listFilesMatching = listFilesMatching(invalidFilesDir, new InvalidPartFileFilter());
            Arrays.sort(listFilesMatching, Collections.reverseOrder());
            Set hashSet = new HashSet();
            for (int i = 0; i < listFilesMatching.length && hashSet.size() < MAX_INVALID_SESSIONS; i += ANALYZER_VERSION) {
                hashSet.add(getSessionIdFromSessionFile(listFilesMatching[i]));
            }
            retainSessions(listFiles(invalidFilesDir), hashSet);
        }
    }

    private void writeFatal(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        try {
            String currentSessionId = getCurrentSessionId();
            if (currentSessionId == null) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "Tried to write a fatal exception while no session was open.", null);
                CommonUtils.m58a(null, "Failed to flush to session begin file.");
                CommonUtils.m57a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            recordFatalExceptionAnswersEvent(currentSessionId, th.getClass().getName());
            Closeable clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), currentSessionId + SESSION_FATAL_TAG);
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                writeSessionEvent(flushable, date, thread, th, EVENT_TYPE_CRASH, true);
                CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                closeable = clsFileOutputStream;
                try {
                    Fabric.m397h().m367e(CrashlyticsCore.TAG, "An error occurred in the fatal exception logger", e);
                    CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m57a(closeable, "Failed to close fatal exception file output stream.");
                } catch (Throwable th2) {
                    e = th2;
                    CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m57a(closeable, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                closeable = clsFileOutputStream;
                CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m57a(closeable, "Failed to close fatal exception file output stream.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            closeable = null;
            Fabric.m397h().m367e(CrashlyticsCore.TAG, "An error occurred in the fatal exception logger", e);
            CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m57a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            e = th4;
            closeable = null;
            CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m57a(closeable, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    void writeExternalCrashEvent(SessionEventData sessionEventData) {
        this.backgroundWorker.submit(new AnonymousClass15(sessionEventData));
    }

    private void doWriteExternalCrashEvent(SessionEventData sessionEventData) {
        Closeable clsFileOutputStream;
        Throwable e;
        Object obj = ANALYZER_VERSION;
        Flushable flushable = null;
        try {
            String previousSessionId = getPreviousSessionId();
            if (previousSessionId == null) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "Tried to write a native crash while no session was open.", null);
                CommonUtils.m58a(null, "Failed to flush to session begin file.");
                CommonUtils.m57a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            recordFatalExceptionAnswersEvent(previousSessionId, String.format(Locale.US, "<native-crash [%s (%s)]>", new Object[]{sessionEventData.signal.code, sessionEventData.signal.name}));
            if (sessionEventData.binaryImages == null || sessionEventData.binaryImages.length <= 0) {
                obj = null;
            }
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), previousSessionId + (obj != null ? SESSION_FATAL_TAG : SESSION_EVENT_MISSING_BINARY_IMGS_TAG));
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                NativeCrashWriter.writeNativeCrash(sessionEventData, new LogFileManager(this.crashlyticsCore.getContext(), this.fileStore, previousSessionId), new MetaDataStore(getFilesDir()).readKeyData(previousSessionId), flushable);
                CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    Fabric.m397h().m367e(CrashlyticsCore.TAG, "An error occurred in the native crash logger", e);
                    CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m57a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m57a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
            Fabric.m397h().m367e(CrashlyticsCore.TAG, "An error occurred in the native crash logger", e);
            CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m57a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
        } catch (Throwable th2) {
            e = th2;
            clsFileOutputStream = null;
            CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m57a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void doWriteNonFatal(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        String currentSessionId = getCurrentSessionId();
        if (currentSessionId == null) {
            Fabric.m397h().m367e(CrashlyticsCore.TAG, "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        recordLoggedExceptionAnswersEvent(currentSessionId, th.getClass().getName());
        try {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
            Closeable clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), currentSessionId + SESSION_NON_FATAL_TAG + CommonUtils.m44a(this.eventCounter.getAndIncrement()));
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                writeSessionEvent(flushable, date, thread, th, EVENT_TYPE_LOGGED, false);
                CommonUtils.m58a(flushable, "Failed to flush to non-fatal file.");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            } catch (Exception e2) {
                e = e2;
                closeable = clsFileOutputStream;
                try {
                    Fabric.m397h().m367e(CrashlyticsCore.TAG, "An error occurred in the non-fatal exception logger", e);
                    CommonUtils.m58a(flushable, "Failed to flush to non-fatal file.");
                    CommonUtils.m57a(closeable, "Failed to close non-fatal file output stream.");
                    trimSessionEventFiles(currentSessionId, MAX_LOCAL_LOGGED_EXCEPTIONS);
                } catch (Throwable th2) {
                    e = th2;
                    CommonUtils.m58a(flushable, "Failed to flush to non-fatal file.");
                    CommonUtils.m57a(closeable, "Failed to close non-fatal file output stream.");
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                closeable = clsFileOutputStream;
                CommonUtils.m58a(flushable, "Failed to flush to non-fatal file.");
                CommonUtils.m57a(closeable, "Failed to close non-fatal file output stream.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            closeable = null;
            Fabric.m397h().m367e(CrashlyticsCore.TAG, "An error occurred in the non-fatal exception logger", e);
            CommonUtils.m58a(flushable, "Failed to flush to non-fatal file.");
            CommonUtils.m57a(closeable, "Failed to close non-fatal file output stream.");
            trimSessionEventFiles(currentSessionId, MAX_LOCAL_LOGGED_EXCEPTIONS);
        } catch (Throwable th4) {
            e = th4;
            closeable = null;
            CommonUtils.m58a(flushable, "Failed to flush to non-fatal file.");
            CommonUtils.m57a(closeable, "Failed to close non-fatal file output stream.");
            throw e;
        }
        try {
            trimSessionEventFiles(currentSessionId, MAX_LOCAL_LOGGED_EXCEPTIONS);
        } catch (Throwable e4) {
            Fabric.m397h().m367e(CrashlyticsCore.TAG, "An error occurred when trimming non-fatal files.", e4);
        }
    }

    private void writeBeginSession(String str, Date date) {
        Closeable clsFileOutputStream;
        Throwable th;
        Flushable flushable = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_BEGIN_TAG);
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                Locale locale = Locale.US;
                String str2 = GENERATOR_FORMAT;
                Object[] objArr = new Object[ANALYZER_VERSION];
                objArr[0] = this.crashlyticsCore.getVersion();
                SessionProtobufHelper.writeBeginSession(flushable, str, String.format(locale, str2, objArr), date.getTime() / 1000);
                CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close begin session file.");
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            CommonUtils.m58a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m57a(clsFileOutputStream, "Failed to close begin session file.");
            throw th;
        }
    }

    private void writeSessionApp(String str) {
        Closeable closeable;
        Throwable th;
        Flushable flushable = null;
        try {
            Closeable clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_APP_TAG);
            try {
                Flushable newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                try {
                    SessionProtobufHelper.writeSessionApp(newInstance, this.idManager.m98c(), this.appData.apiKey, this.appData.versionCode, this.appData.versionName, this.idManager.m97b(), DeliveryMechanism.m85a(this.appData.installerPackageName).m86a(), this.unityVersion);
                    CommonUtils.m58a(newInstance, "Failed to flush to session app file.");
                    CommonUtils.m57a(clsFileOutputStream, "Failed to close session app file.");
                } catch (Throwable th2) {
                    closeable = clsFileOutputStream;
                    Flushable flushable2 = newInstance;
                    th = th2;
                    flushable = flushable2;
                    CommonUtils.m58a(flushable, "Failed to flush to session app file.");
                    CommonUtils.m57a(closeable, "Failed to close session app file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = clsFileOutputStream;
                CommonUtils.m58a(flushable, "Failed to flush to session app file.");
                CommonUtils.m57a(closeable, "Failed to close session app file.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            CommonUtils.m58a(flushable, "Failed to flush to session app file.");
            CommonUtils.m57a(closeable, "Failed to close session app file.");
            throw th;
        }
    }

    private void writeSessionOS(String str) {
        Closeable clsFileOutputStream;
        Throwable th;
        Flushable flushable = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_OS_TAG);
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                SessionProtobufHelper.writeSessionOS(flushable, CommonUtils.m74g(this.crashlyticsCore.getContext()));
                CommonUtils.m58a(flushable, "Failed to flush to session OS file.");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close session OS file.");
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m58a(flushable, "Failed to flush to session OS file.");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            CommonUtils.m58a(flushable, "Failed to flush to session OS file.");
            CommonUtils.m57a(clsFileOutputStream, "Failed to close session OS file.");
            throw th;
        }
    }

    private void writeSessionDevice(String str) {
        Throwable th;
        Closeable closeable = null;
        Flushable flushable = null;
        try {
            OutputStream clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_DEVICE_TAG);
            try {
                flushable = CodedOutputStream.newInstance(clsFileOutputStream);
                Context context = this.crashlyticsCore.getContext();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                SessionProtobufHelper.writeSessionDevice(flushable, this.idManager.m103h(), CommonUtils.m38a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.m61b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.m73f(context), this.idManager.m104i(), CommonUtils.m75h(context), Build.MANUFACTURER, Build.PRODUCT);
                CommonUtils.m58a(flushable, "Failed to flush session device info.");
                CommonUtils.m57a((Closeable) clsFileOutputStream, "Failed to close session device file.");
            } catch (Throwable th2) {
                th = th2;
                Object obj = clsFileOutputStream;
                CommonUtils.m58a(flushable, "Failed to flush session device info.");
                CommonUtils.m57a(closeable, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.m58a(flushable, "Failed to flush session device info.");
            CommonUtils.m57a(closeable, "Failed to close session device file.");
            throw th;
        }
    }

    private void writeSessionUser(String str) {
        Throwable th;
        Flushable flushable = null;
        Closeable clsFileOutputStream;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_USER_TAG);
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                UserMetaData userMetaData = getUserMetaData(str);
                if (userMetaData.isEmpty()) {
                    CommonUtils.m58a(flushable, "Failed to flush session user file.");
                    CommonUtils.m57a(clsFileOutputStream, "Failed to close session user file.");
                    return;
                }
                SessionProtobufHelper.writeSessionUser(flushable, userMetaData.id, userMetaData.name, userMetaData.email);
                CommonUtils.m58a(flushable, "Failed to flush session user file.");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close session user file.");
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m58a(flushable, "Failed to flush session user file.");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            CommonUtils.m58a(flushable, "Failed to flush session user file.");
            CommonUtils.m57a(clsFileOutputStream, "Failed to close session user file.");
            throw th;
        }
    }

    private void writeSessionEvent(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) {
        Thread[] threadArr;
        Map treeMap;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy);
        Context context = this.crashlyticsCore.getContext();
        long time = date.getTime() / 1000;
        Float c = CommonUtils.m67c(context);
        int a = CommonUtils.m40a(context, this.devicePowerStateListener.isPowerConnected());
        boolean d = CommonUtils.m71d(context);
        int i = context.getResources().getConfiguration().orientation;
        long b = CommonUtils.m61b() - CommonUtils.m62b(context);
        long b2 = CommonUtils.m63b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = CommonUtils.m42a(context.getPackageName(), context);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String str2 = this.appData.buildId;
        String c2 = this.idManager.m98c();
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr[i2] = (Thread) entry.getKey();
                linkedList.add(this.stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[]) entry.getValue()));
                i2 += ANALYZER_VERSION;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (CommonUtils.m60a(context, COLLECT_CUSTOM_KEYS, true)) {
            Map attributes = this.crashlyticsCore.getAttributes();
            treeMap = (attributes == null || attributes.size() <= ANALYZER_VERSION) ? attributes : new TreeMap(attributes);
        } else {
            treeMap = new TreeMap();
        }
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.logFileManager, a2, i, c2, str2, c, a, d, b, b2);
    }

    private void writeSessionPartsToSessionFile(File file, String str, int i) {
        boolean z;
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Collecting session parts for ID " + str);
        File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + SESSION_FATAL_TAG));
        boolean z2 = listFilesMatching != null && listFilesMatching.length > 0;
        Fabric.m397h().m359a(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)}));
        File[] listFilesMatching2 = listFilesMatching(new FileNameContainsFilter(str + SESSION_NON_FATAL_TAG));
        if (listFilesMatching2 == null || listFilesMatching2.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        Fabric.m397h().m359a(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z)}));
        if (z2 || z) {
            synthesizeSessionFile(file, str, getTrimmedNonFatalFiles(str, listFilesMatching2, i), z2 ? listFilesMatching[0] : null);
        } else {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "No events present for session ID " + str);
        }
        Fabric.m397h().m359a(CrashlyticsCore.TAG, "Removing session part files for ID " + str);
        deleteSessionPartFilesFor(str);
    }

    private void synthesizeSessionFile(File file, String str, File[] fileArr, File file2) {
        Closeable clsFileOutputStream;
        Throwable e;
        boolean z = true;
        if (file2 == null) {
            z = false;
        }
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str);
            try {
                Flushable newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                Fabric.m397h().m359a(CrashlyticsCore.TAG, "Collecting SessionStart data for session ID " + str);
                writeToCosFromFile(newInstance, file);
                newInstance.writeUInt64(MAX_INVALID_SESSIONS, new Date().getTime() / 1000);
                newInstance.writeBool(5, z);
                newInstance.writeUInt32(11, ANALYZER_VERSION);
                newInstance.writeEnum(12, 3);
                writeInitialPartsTo(newInstance, str);
                writeNonFatalEventsTo(newInstance, fileArr, str);
                if (z) {
                    writeToCosFromFile(newInstance, file2);
                }
                CommonUtils.m58a(newInstance, "Error flushing session file stream");
                CommonUtils.m57a(clsFileOutputStream, "Failed to close CLS file");
            } catch (Exception e2) {
                e = e2;
                try {
                    Fabric.m397h().m367e(CrashlyticsCore.TAG, "Failed to write session file for session ID: " + str, e);
                    CommonUtils.m58a(null, "Error flushing session file stream");
                    closeWithoutRenamingOrLog(clsFileOutputStream);
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m58a(null, "Error flushing session file stream");
                    CommonUtils.m57a(clsFileOutputStream, "Failed to close CLS file");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
            Fabric.m397h().m367e(CrashlyticsCore.TAG, "Failed to write session file for session ID: " + str, e);
            CommonUtils.m58a(null, "Error flushing session file stream");
            closeWithoutRenamingOrLog(clsFileOutputStream);
        } catch (Throwable th2) {
            e = th2;
            clsFileOutputStream = null;
            CommonUtils.m58a(null, "Error flushing session file stream");
            CommonUtils.m57a(clsFileOutputStream, "Failed to close CLS file");
            throw e;
        }
    }

    private static void writeNonFatalEventsTo(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.f29a);
        int length = fileArr.length;
        for (int i = 0; i < length; i += ANALYZER_VERSION) {
            File file = fileArr[i];
            try {
                Fabric.m397h().m359a(CrashlyticsCore.TAG, String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, file.getName()}));
                writeToCosFromFile(codedOutputStream, file);
            } catch (Throwable e) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "Error writting non-fatal to session.", e);
            }
        }
    }

    private void writeInitialPartsTo(CodedOutputStream codedOutputStream, String str) {
        String[] strArr = INITIAL_SESSION_PART_TAGS;
        int length = strArr.length;
        for (int i = 0; i < length; i += ANALYZER_VERSION) {
            String str2 = strArr[i];
            File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + str2));
            if (listFilesMatching.length == 0) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                Fabric.m397h().m359a(CrashlyticsCore.TAG, "Collecting " + str2 + " data for session ID " + str);
                writeToCosFromFile(codedOutputStream, listFilesMatching[0]);
            }
        }
    }

    private static void writeToCosFromFile(CodedOutputStream codedOutputStream, File file) {
        Closeable fileInputStream;
        Throwable th;
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    copyToCodedOutputStream(fileInputStream, codedOutputStream, (int) file.length());
                    CommonUtils.m57a(fileInputStream, "Failed to close file input stream.");
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.m57a(fileInputStream, "Failed to close file input stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                CommonUtils.m57a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        Fabric.m397h().m367e(CrashlyticsCore.TAG, "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private static void copyToCodedOutputStream(InputStream inputStream, CodedOutputStream codedOutputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = inputStream.read(bArr, i2, bArr.length - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        codedOutputStream.writeRawBytes(bArr);
    }

    private UserMetaData getUserMetaData(String str) {
        return isHandlingException() ? new UserMetaData(this.crashlyticsCore.getUserIdentifier(), this.crashlyticsCore.getUserName(), this.crashlyticsCore.getUserEmail()) : new MetaDataStore(getFilesDir()).readUserData(str);
    }

    boolean isHandlingException() {
        return this.crashHandler != null && this.crashHandler.isHandlingException();
    }

    File getFilesDir() {
        return this.fileStore.m298a();
    }

    File getInvalidFilesDir() {
        return new File(getFilesDir(), INVALID_CLS_CACHE_DIR);
    }

    private boolean shouldPromptUserBeforeSendingCrashReports(SettingsData settingsData) {
        if (settingsData == null || !settingsData.f272d.f239a || this.preferenceManager.shouldAlwaysSendReports()) {
            return false;
        }
        return true;
    }

    private CreateReportSpiCall getCreateReportSpiCall(String str) {
        return new DefaultCreateReportSpiCall(this.crashlyticsCore, CommonUtils.m65b(this.crashlyticsCore.getContext(), CRASHLYTICS_API_ENDPOINT), str, this.httpRequestFactory);
    }

    private void sendSessionReports(SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.m397h().m364d(CrashlyticsCore.TAG, "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context context = this.crashlyticsCore.getContext();
        ReportUploader reportUploader = new ReportUploader(this.appData.apiKey, getCreateReportSpiCall(settingsData.f269a.f226d));
        File[] listCompleteSessionFiles = listCompleteSessionFiles();
        int length = listCompleteSessionFiles.length;
        for (int i = 0; i < length; i += ANALYZER_VERSION) {
            this.backgroundWorker.submit(new SendReportRunnable(context, new SessionReport(listCompleteSessionFiles[i], SEND_AT_CRASHTIME_HEADER), reportUploader));
        }
    }

    private static void recordLoggedExceptionAnswersEvent(String str, String str2) {
        Answers answers = (Answers) Fabric.m389a(Answers.class);
        if (answers == null) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Answers is not available");
        } else {
            answers.onException(new Crash(str, str2));
        }
    }

    private static void recordFatalExceptionAnswersEvent(String str, String str2) {
        Answers answers = (Answers) Fabric.m389a(Answers.class);
        if (answers == null) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Answers is not available");
        } else {
            answers.onException(new Crash(str, str2));
        }
    }
}
