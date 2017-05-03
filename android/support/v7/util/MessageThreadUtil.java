package android.support.v7.util;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ParallelExecutorCompat;
import android.support.v7.util.ThreadUtil.BackgroundCallback;
import android.support.v7.util.ThreadUtil.MainThreadCallback;
import android.support.v7.util.TileList.Tile;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* renamed from: android.support.v7.util.MessageThreadUtil.1 */
    class C02761 implements MainThreadCallback<T> {
        static final int ADD_TILE = 2;
        static final int REMOVE_TILE = 3;
        static final int UPDATE_ITEM_COUNT = 1;
        private final Handler mMainThreadHandler;
        private Runnable mMainThreadRunnable;
        final MessageQueue mQueue;
        final /* synthetic */ MainThreadCallback val$callback;

        /* renamed from: android.support.v7.util.MessageThreadUtil.1.1 */
        class C02751 implements Runnable {
            C02751() {
            }

            public void run() {
                SyncQueueItem next = C02761.this.mQueue.next();
                while (next != null) {
                    switch (next.what) {
                        case C02761.UPDATE_ITEM_COUNT /*1*/:
                            C02761.this.val$callback.updateItemCount(next.arg1, next.arg2);
                            break;
                        case C02761.ADD_TILE /*2*/:
                            C02761.this.val$callback.addTile(next.arg1, (Tile) next.data);
                            break;
                        case C02761.REMOVE_TILE /*3*/:
                            C02761.this.val$callback.removeTile(next.arg1, next.arg2);
                            break;
                        default:
                            Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                            break;
                    }
                    next = C02761.this.mQueue.next();
                }
            }
        }

        C02761(MainThreadCallback mainThreadCallback) {
            this.val$callback = mainThreadCallback;
            this.mQueue = new MessageQueue();
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
            this.mMainThreadRunnable = new C02751();
        }

        public void updateItemCount(int i, int i2) {
            sendMessage(SyncQueueItem.obtainMessage((int) UPDATE_ITEM_COUNT, i, i2));
        }

        public void addTile(int i, Tile<T> tile) {
            sendMessage(SyncQueueItem.obtainMessage((int) ADD_TILE, i, (Object) tile));
        }

        public void removeTile(int i, int i2) {
            sendMessage(SyncQueueItem.obtainMessage((int) REMOVE_TILE, i, i2));
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessage(syncQueueItem);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }
    }

    /* renamed from: android.support.v7.util.MessageThreadUtil.2 */
    class C02782 implements BackgroundCallback<T> {
        static final int LOAD_TILE = 3;
        static final int RECYCLE_TILE = 4;
        static final int REFRESH = 1;
        static final int UPDATE_RANGE = 2;
        private Runnable mBackgroundRunnable;
        AtomicBoolean mBackgroundRunning;
        private final Executor mExecutor;
        final MessageQueue mQueue;
        final /* synthetic */ BackgroundCallback val$callback;

        /* renamed from: android.support.v7.util.MessageThreadUtil.2.1 */
        class C02771 implements Runnable {
            C02771() {
            }

            public void run() {
                while (true) {
                    SyncQueueItem next = C02782.this.mQueue.next();
                    if (next != null) {
                        switch (next.what) {
                            case C02782.REFRESH /*1*/:
                                C02782.this.mQueue.removeMessages(C02782.REFRESH);
                                C02782.this.val$callback.refresh(next.arg1);
                                break;
                            case C02782.UPDATE_RANGE /*2*/:
                                C02782.this.mQueue.removeMessages(C02782.UPDATE_RANGE);
                                C02782.this.mQueue.removeMessages(C02782.LOAD_TILE);
                                C02782.this.val$callback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                                break;
                            case C02782.LOAD_TILE /*3*/:
                                C02782.this.val$callback.loadTile(next.arg1, next.arg2);
                                break;
                            case C02782.RECYCLE_TILE /*4*/:
                                C02782.this.val$callback.recycleTile((Tile) next.data);
                                break;
                            default:
                                Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                                break;
                        }
                    }
                    C02782.this.mBackgroundRunning.set(false);
                    return;
                }
            }
        }

        C02782(BackgroundCallback backgroundCallback) {
            this.val$callback = backgroundCallback;
            this.mQueue = new MessageQueue();
            this.mExecutor = ParallelExecutorCompat.getParallelExecutor();
            this.mBackgroundRunning = new AtomicBoolean(false);
            this.mBackgroundRunnable = new C02771();
        }

        public void refresh(int i) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage((int) REFRESH, i, null));
        }

        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(UPDATE_RANGE, i, i2, i3, i4, i5, null));
        }

        public void loadTile(int i, int i2) {
            sendMessage(SyncQueueItem.obtainMessage((int) LOAD_TILE, i, i2));
        }

        public void recycleTile(Tile<T> tile) {
            sendMessage(SyncQueueItem.obtainMessage((int) RECYCLE_TILE, 0, (Object) tile));
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessage(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        private void maybeExecuteBackgroundRunnable() {
            if (this.mBackgroundRunning.compareAndSet(false, true)) {
                this.mExecutor.execute(this.mBackgroundRunnable);
            }
        }
    }

    static class MessageQueue {
        private SyncQueueItem mRoot;

        MessageQueue() {
        }

        synchronized SyncQueueItem next() {
            SyncQueueItem syncQueueItem;
            if (this.mRoot == null) {
                syncQueueItem = null;
            } else {
                syncQueueItem = this.mRoot;
                this.mRoot = this.mRoot.next;
            }
            return syncQueueItem;
        }

        synchronized void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            syncQueueItem.next = this.mRoot;
            this.mRoot = syncQueueItem;
        }

        synchronized void sendMessage(SyncQueueItem syncQueueItem) {
            if (this.mRoot == null) {
                this.mRoot = syncQueueItem;
            } else {
                SyncQueueItem syncQueueItem2 = this.mRoot;
                while (syncQueueItem2.next != null) {
                    syncQueueItem2 = syncQueueItem2.next;
                }
                syncQueueItem2.next = syncQueueItem;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        synchronized void removeMessages(int r5) {
            /*
            r4 = this;
            monitor-enter(r4);
        L_0x0001:
            r0 = r4.mRoot;	 Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x001c;
        L_0x0005:
            r0 = r4.mRoot;	 Catch:{ all -> 0x0019 }
            r0 = r0.what;	 Catch:{ all -> 0x0019 }
            if (r0 != r5) goto L_0x001c;
        L_0x000b:
            r0 = r4.mRoot;	 Catch:{ all -> 0x0019 }
            r1 = r4.mRoot;	 Catch:{ all -> 0x0019 }
            r1 = r1.next;	 Catch:{ all -> 0x0019 }
            r4.mRoot = r1;	 Catch:{ all -> 0x0019 }
            r0.recycle();	 Catch:{ all -> 0x0019 }
            goto L_0x0001;
        L_0x0019:
            r0 = move-exception;
            monitor-exit(r4);
            throw r0;
        L_0x001c:
            r0 = r4.mRoot;	 Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x003a;
        L_0x0020:
            r0 = r4.mRoot;	 Catch:{ all -> 0x0019 }
            r1 = r0.next;	 Catch:{ all -> 0x0019 }
        L_0x0026:
            if (r1 == 0) goto L_0x003a;
        L_0x0028:
            r2 = r1.next;	 Catch:{ all -> 0x0019 }
            r3 = r1.what;	 Catch:{ all -> 0x0019 }
            if (r3 != r5) goto L_0x0038;
        L_0x0030:
            r0.next = r2;	 Catch:{ all -> 0x0019 }
            r1.recycle();	 Catch:{ all -> 0x0019 }
        L_0x0036:
            r1 = r2;
            goto L_0x0026;
        L_0x0038:
            r0 = r1;
            goto L_0x0036;
        L_0x003a:
            monitor-exit(r4);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.util.MessageThreadUtil.MessageQueue.removeMessages(int):void");
        }
    }

    static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        private SyncQueueItem next;
        public int what;

        SyncQueueItem() {
        }

        static {
            sPoolLock = new Object();
        }

        void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                if (sPool != null) {
                    this.next = sPool;
                }
                sPool = this;
            }
        }

        static SyncQueueItem obtainMessage(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (sPoolLock) {
                if (sPool == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    syncQueueItem = sPool;
                    sPool = sPool.next;
                    syncQueueItem.next = null;
                }
                syncQueueItem.what = i;
                syncQueueItem.arg1 = i2;
                syncQueueItem.arg2 = i3;
                syncQueueItem.arg3 = i4;
                syncQueueItem.arg4 = i5;
                syncQueueItem.arg5 = i6;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        static SyncQueueItem obtainMessage(int i, int i2, int i3) {
            return obtainMessage(i, i2, i3, 0, 0, 0, null);
        }

        static SyncQueueItem obtainMessage(int i, int i2, Object obj) {
            return obtainMessage(i, i2, 0, 0, 0, 0, obj);
        }
    }

    MessageThreadUtil() {
    }

    public MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback) {
        return new C02761(mainThreadCallback);
    }

    public BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback) {
        return new C02782(backgroundCallback);
    }
}
