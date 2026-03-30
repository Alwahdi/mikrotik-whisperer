package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T> implements ThreadUtil<T> {
    MessageThreadUtil() {
    }

    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(final ThreadUtil.MainThreadCallback<T> callback) {
        return new ThreadUtil.MainThreadCallback<T>() {
            static final int ADD_TILE = 2;
            static final int REMOVE_TILE = 3;
            static final int UPDATE_ITEM_COUNT = 1;
            private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
            private Runnable mMainThreadRunnable = new Runnable() {
                public void run() {
                    SyncQueueItem msg = AnonymousClass1.this.mQueue.next();
                    while (msg != null) {
                        switch (msg.what) {
                            case 1:
                                callback.updateItemCount(msg.arg1, msg.arg2);
                                break;
                            case 2:
                                callback.addTile(msg.arg1, (TileList.Tile) msg.data);
                                break;
                            case 3:
                                callback.removeTile(msg.arg1, msg.arg2);
                                break;
                            default:
                                Log.e("ThreadUtil", "Unsupported message, what=" + msg.what);
                                break;
                        }
                        msg = AnonymousClass1.this.mQueue.next();
                    }
                }
            };
            final MessageQueue mQueue = new MessageQueue();

            public void updateItemCount(int generation, int itemCount) {
                sendMessage(SyncQueueItem.obtainMessage(1, generation, itemCount));
            }

            public void addTile(int generation, TileList.Tile<T> tile) {
                sendMessage(SyncQueueItem.obtainMessage(2, generation, (Object) tile));
            }

            public void removeTile(int generation, int position) {
                sendMessage(SyncQueueItem.obtainMessage(3, generation, position));
            }

            private void sendMessage(SyncQueueItem msg) {
                this.mQueue.sendMessage(msg);
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }
        };
    }

    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(final ThreadUtil.BackgroundCallback<T> callback) {
        return new ThreadUtil.BackgroundCallback<T>() {
            static final int LOAD_TILE = 3;
            static final int RECYCLE_TILE = 4;
            static final int REFRESH = 1;
            static final int UPDATE_RANGE = 2;
            private Runnable mBackgroundRunnable = new Runnable() {
                public void run() {
                    while (true) {
                        SyncQueueItem msg = AnonymousClass2.this.mQueue.next();
                        if (msg != null) {
                            switch (msg.what) {
                                case 1:
                                    AnonymousClass2.this.mQueue.removeMessages(1);
                                    callback.refresh(msg.arg1);
                                    break;
                                case 2:
                                    AnonymousClass2.this.mQueue.removeMessages(2);
                                    AnonymousClass2.this.mQueue.removeMessages(3);
                                    callback.updateRange(msg.arg1, msg.arg2, msg.arg3, msg.arg4, msg.arg5);
                                    break;
                                case 3:
                                    callback.loadTile(msg.arg1, msg.arg2);
                                    break;
                                case 4:
                                    callback.recycleTile((TileList.Tile) msg.data);
                                    break;
                                default:
                                    Log.e("ThreadUtil", "Unsupported message, what=" + msg.what);
                                    break;
                            }
                        } else {
                            AnonymousClass2.this.mBackgroundRunning.set(false);
                            return;
                        }
                    }
                }
            };
            AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
            private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            final MessageQueue mQueue = new MessageQueue();

            public void refresh(int generation) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, generation, (Object) null));
            }

            public void updateRange(int rangeStart, int rangeEnd, int extRangeStart, int extRangeEnd, int scrollHint) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, rangeStart, rangeEnd, extRangeStart, extRangeEnd, scrollHint, (Object) null));
            }

            public void loadTile(int position, int scrollHint) {
                sendMessage(SyncQueueItem.obtainMessage(3, position, scrollHint));
            }

            public void recycleTile(TileList.Tile<T> tile) {
                sendMessage(SyncQueueItem.obtainMessage(4, 0, (Object) tile));
            }

            private void sendMessage(SyncQueueItem msg) {
                this.mQueue.sendMessage(msg);
                maybeExecuteBackgroundRunnable();
            }

            private void sendMessageAtFrontOfQueue(SyncQueueItem msg) {
                this.mQueue.sendMessageAtFrontOfQueue(msg);
                maybeExecuteBackgroundRunnable();
            }

            private void maybeExecuteBackgroundRunnable() {
                if (this.mBackgroundRunning.compareAndSet(false, true)) {
                    this.mExecutor.execute(this.mBackgroundRunnable);
                }
            }
        };
    }

    static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        public int what;

        SyncQueueItem() {
        }

        /* access modifiers changed from: package-private */
        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                SyncQueueItem syncQueueItem = sPool;
                if (syncQueueItem != null) {
                    this.next = syncQueueItem;
                }
                sPool = this;
            }
        }

        static SyncQueueItem obtainMessage(int what2, int arg12, int arg22, int arg32, int arg42, int arg52, Object data2) {
            SyncQueueItem item;
            synchronized (sPoolLock) {
                SyncQueueItem item2 = sPool;
                if (item2 == null) {
                    item = new SyncQueueItem();
                } else {
                    SyncQueueItem item3 = item2;
                    sPool = item2.next;
                    item3.next = null;
                    item = item3;
                }
                item.what = what2;
                item.arg1 = arg12;
                item.arg2 = arg22;
                item.arg3 = arg32;
                item.arg4 = arg42;
                item.arg5 = arg52;
                item.data = data2;
            }
            return item;
        }

        static SyncQueueItem obtainMessage(int what2, int arg12, int arg22) {
            return obtainMessage(what2, arg12, arg22, 0, 0, 0, (Object) null);
        }

        static SyncQueueItem obtainMessage(int what2, int arg12, Object data2) {
            return obtainMessage(what2, arg12, 0, 0, 0, 0, data2);
        }
    }

    static class MessageQueue {
        private final Object mLock = new Object();
        private SyncQueueItem mRoot;

        MessageQueue() {
        }

        /* access modifiers changed from: package-private */
        public SyncQueueItem next() {
            synchronized (this.mLock) {
                SyncQueueItem syncQueueItem = this.mRoot;
                if (syncQueueItem == null) {
                    return null;
                }
                SyncQueueItem next = syncQueueItem;
                this.mRoot = syncQueueItem.next;
                return next;
            }
        }

        /* access modifiers changed from: package-private */
        public void sendMessageAtFrontOfQueue(SyncQueueItem item) {
            synchronized (this.mLock) {
                item.next = this.mRoot;
                this.mRoot = item;
            }
        }

        /* access modifiers changed from: package-private */
        public void sendMessage(SyncQueueItem item) {
            synchronized (this.mLock) {
                SyncQueueItem last = this.mRoot;
                if (last == null) {
                    this.mRoot = item;
                    return;
                }
                while (true) {
                    SyncQueueItem syncQueueItem = last.next;
                    if (syncQueueItem != null) {
                        last = syncQueueItem;
                    } else {
                        last.next = item;
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0016  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void removeMessages(int r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.mLock
                monitor-enter(r0)
            L_0x0003:
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r1 = r5.mRoot     // Catch:{ all -> 0x002c }
                if (r1 == 0) goto L_0x0014
                int r2 = r1.what     // Catch:{ all -> 0x002c }
                if (r2 != r6) goto L_0x0014
                r2 = r1
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r1 = r1.next     // Catch:{ all -> 0x002c }
                r5.mRoot = r1     // Catch:{ all -> 0x002c }
                r2.recycle()     // Catch:{ all -> 0x002c }
                goto L_0x0003
            L_0x0014:
                if (r1 == 0) goto L_0x002a
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r2 = r1.next     // Catch:{ all -> 0x002c }
            L_0x0019:
                if (r2 == 0) goto L_0x002a
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r3 = r2.next     // Catch:{ all -> 0x002c }
                int r4 = r2.what     // Catch:{ all -> 0x002c }
                if (r4 != r6) goto L_0x0027
                r1.next = r3     // Catch:{ all -> 0x002c }
                r2.recycle()     // Catch:{ all -> 0x002c }
                goto L_0x0028
            L_0x0027:
                r1 = r2
            L_0x0028:
                r2 = r3
                goto L_0x0019
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                return
            L_0x002c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.MessageThreadUtil.MessageQueue.removeMessages(int):void");
        }
    }
}
