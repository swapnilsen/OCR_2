package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.CurrentTimeProvider;

/* renamed from: a.a.a.a.a.d.b */
public abstract class EventsFilesManager<T> {
    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    protected final CurrentTimeProvider currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final EventsStorage eventStorage;
    protected volatile long lastRollOverTime;
    protected final List<EventsStorageListener> rollOverListeners;
    protected final EventTransform<T> transform;

    /* renamed from: a.a.a.a.a.d.b.1 */
    class EventsFilesManager implements Comparator<EventsFilesManager> {
        final /* synthetic */ EventsFilesManager f146a;

        EventsFilesManager(EventsFilesManager eventsFilesManager) {
            this.f146a = eventsFilesManager;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m188a((EventsFilesManager) obj, (EventsFilesManager) obj2);
        }

        public int m188a(EventsFilesManager eventsFilesManager, EventsFilesManager eventsFilesManager2) {
            return (int) (eventsFilesManager.f148b - eventsFilesManager2.f148b);
        }
    }

    /* renamed from: a.a.a.a.a.d.b.a */
    static class EventsFilesManager {
        final File f147a;
        final long f148b;

        public EventsFilesManager(File file, long j) {
            this.f147a = file;
            this.f148b = j;
        }
    }

    protected abstract String generateUniqueRollOverFileName();

    public EventsFilesManager(Context context, EventTransform<T> eventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage, int i) {
        this.rollOverListeners = new CopyOnWriteArrayList();
        this.context = context.getApplicationContext();
        this.transform = eventTransform;
        this.eventStorage = eventsStorage;
        this.currentTimeProvider = currentTimeProvider;
        this.lastRollOverTime = this.currentTimeProvider.m84a();
        this.defaultMaxFilesToKeep = i;
    }

    public void writeEvent(T t) {
        byte[] toBytes = this.transform.toBytes(t);
        rollFileOverIfNeeded(toBytes.length);
        this.eventStorage.m193a(toBytes);
    }

    public void registerRollOverListener(EventsStorageListener eventsStorageListener) {
        if (eventsStorageListener != null) {
            this.rollOverListeners.add(eventsStorageListener);
        }
    }

    public boolean rollFileOver() {
        boolean z = true;
        String str = null;
        if (this.eventStorage.m195b()) {
            z = false;
        } else {
            str = generateUniqueRollOverFileName();
            this.eventStorage.m191a(str);
            Object[] objArr = new Object[MAX_FILES_IN_BATCH];
            objArr[0] = str;
            CommonUtils.m53a(this.context, 4, "Fabric", String.format(Locale.US, "generated new file %s", objArr));
            this.lastRollOverTime = this.currentTimeProvider.m84a();
        }
        triggerRollOverOnListeners(str);
        return z;
    }

    private void rollFileOverIfNeeded(int i) {
        if (!this.eventStorage.m194a(i, getMaxByteSizePerFile())) {
            CommonUtils.m53a(this.context, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.eventStorage.m189a()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())}));
            rollFileOver();
        }
    }

    protected int getMaxFilesToKeep() {
        return this.defaultMaxFilesToKeep;
    }

    protected int getMaxByteSizePerFile() {
        return MAX_BYTE_SIZE_PER_FILE;
    }

    public long getLastRollOverTime() {
        return this.lastRollOverTime;
    }

    private void triggerRollOverOnListeners(String str) {
        for (EventsStorageListener onRollOver : this.rollOverListeners) {
            try {
                onRollOver.onRollOver(str);
            } catch (Throwable e) {
                CommonUtils.m55a(this.context, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> getBatchOfFilesToSend() {
        return this.eventStorage.m190a((int) MAX_FILES_IN_BATCH);
    }

    public void deleteSentFiles(List<File> list) {
        this.eventStorage.m192a((List) list);
    }

    public void deleteAllEventsFiles() {
        this.eventStorage.m192a(this.eventStorage.m196c());
        this.eventStorage.m197d();
    }

    public void deleteOldestInRollOverIfOverMax() {
        List<File> c = this.eventStorage.m196c();
        int maxFilesToKeep = getMaxFilesToKeep();
        if (c.size() > maxFilesToKeep) {
            int size = c.size() - maxFilesToKeep;
            CommonUtils.m54a(this.context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(maxFilesToKeep), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new EventsFilesManager(this));
            for (File file : c) {
                treeSet.add(new EventsFilesManager(file, parseCreationTimestampFromFileName(file.getName())));
            }
            List arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((EventsFilesManager) it.next()).f147a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.eventStorage.m192a(arrayList);
        }
    }

    public long parseCreationTimestampFromFileName(String str) {
        long j = 0;
        String[] split = str.split(ROLL_OVER_FILE_NAME_SEPARATOR);
        if (split.length == 3) {
            try {
                j = Long.valueOf(split[2]).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}
