package org.apache.http.impl.conn.tsccm;

import java.util.LinkedList;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;

@NotThreadSafe
public class RouteSpecificPool {
    protected final ConnPerRoute connPerRoute;
    protected final LinkedList<BasicPoolEntry> freeEntries;
    private final Log log = LogFactory.getLog(getClass());
    @Deprecated
    protected final int maxEntries;
    protected int numEntries;
    protected final HttpRoute route;
    protected final Queue<WaitingThread> waitingThreads;

    @Deprecated
    public RouteSpecificPool(HttpRoute route2, int maxEntries2) {
        this.route = route2;
        this.maxEntries = maxEntries2;
        this.connPerRoute = new ConnPerRoute() {
            public int getMaxForRoute(HttpRoute route) {
                return RouteSpecificPool.this.maxEntries;
            }
        };
        this.freeEntries = new LinkedList<>();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }

    public RouteSpecificPool(HttpRoute route2, ConnPerRoute connPerRoute2) {
        this.route = route2;
        this.connPerRoute = connPerRoute2;
        this.maxEntries = connPerRoute2.getMaxForRoute(route2);
        this.freeEntries = new LinkedList<>();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }

    public final HttpRoute getRoute() {
        return this.route;
    }

    public final int getMaxEntries() {
        return this.maxEntries;
    }

    public boolean isUnused() {
        return this.numEntries < 1 && this.waitingThreads.isEmpty();
    }

    public int getCapacity() {
        return this.connPerRoute.getMaxForRoute(this.route) - this.numEntries;
    }

    public final int getEntryCount() {
        return this.numEntries;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.http.impl.conn.tsccm.BasicPoolEntry allocEntry(java.lang.Object r6) {
        /*
            r5 = this;
            java.util.LinkedList<org.apache.http.impl.conn.tsccm.BasicPoolEntry> r0 = r5.freeEntries
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0034
            java.util.LinkedList<org.apache.http.impl.conn.tsccm.BasicPoolEntry> r0 = r5.freeEntries
            int r1 = r0.size()
            java.util.ListIterator r0 = r0.listIterator(r1)
        L_0x0012:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r0.previous()
            org.apache.http.impl.conn.tsccm.BasicPoolEntry r1 = (org.apache.http.impl.conn.tsccm.BasicPoolEntry) r1
            java.lang.Object r2 = r1.getState()
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r1.getState()
            boolean r2 = org.apache.http.util.LangUtils.equals((java.lang.Object) r6, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            goto L_0x0012
        L_0x0030:
            r0.remove()
            return r1
        L_0x0034:
            int r0 = r5.getCapacity()
            if (r0 != 0) goto L_0x005e
            java.util.LinkedList<org.apache.http.impl.conn.tsccm.BasicPoolEntry> r0 = r5.freeEntries
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x005e
            java.util.LinkedList<org.apache.http.impl.conn.tsccm.BasicPoolEntry> r0 = r5.freeEntries
            java.lang.Object r0 = r0.remove()
            org.apache.http.impl.conn.tsccm.BasicPoolEntry r0 = (org.apache.http.impl.conn.tsccm.BasicPoolEntry) r0
            r0.shutdownEntry()
            org.apache.http.conn.OperatedClientConnection r1 = r0.getConnection()
            r1.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x005d
        L_0x0055:
            r2 = move-exception
            org.apache.commons.logging.Log r3 = r5.log
            java.lang.String r4 = "I/O error closing connection"
            r3.debug(r4, r2)
        L_0x005d:
            return r0
        L_0x005e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.tsccm.RouteSpecificPool.allocEntry(java.lang.Object):org.apache.http.impl.conn.tsccm.BasicPoolEntry");
    }

    public void freeEntry(BasicPoolEntry entry) {
        int i = this.numEntries;
        if (i < 1) {
            throw new IllegalStateException("No entry created for this pool. " + this.route);
        } else if (i > this.freeEntries.size()) {
            this.freeEntries.add(entry);
        } else {
            throw new IllegalStateException("No entry allocated from this pool. " + this.route);
        }
    }

    public void createdEntry(BasicPoolEntry entry) {
        if (this.route.equals(entry.getPlannedRoute())) {
            this.numEntries++;
            return;
        }
        throw new IllegalArgumentException("Entry not planned for this pool.\npool: " + this.route + "\nplan: " + entry.getPlannedRoute());
    }

    public boolean deleteEntry(BasicPoolEntry entry) {
        boolean found = this.freeEntries.remove(entry);
        if (found) {
            this.numEntries--;
        }
        return found;
    }

    public void dropEntry() {
        int i = this.numEntries;
        if (i >= 1) {
            this.numEntries = i - 1;
            return;
        }
        throw new IllegalStateException("There is no entry that could be dropped.");
    }

    public void queueThread(WaitingThread wt) {
        if (wt != null) {
            this.waitingThreads.add(wt);
            return;
        }
        throw new IllegalArgumentException("Waiting thread must not be null.");
    }

    public boolean hasThread() {
        return !this.waitingThreads.isEmpty();
    }

    public WaitingThread nextThread() {
        return this.waitingThreads.peek();
    }

    public void removeThread(WaitingThread wt) {
        if (wt != null) {
            this.waitingThreads.remove(wt);
        }
    }
}
