package org.apache.http.impl.conn.tsccm;

import androidx.core.location.LocationRequestCompat;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;

@NotThreadSafe
public class BasicPoolEntry extends AbstractPoolEntry {
    private final long created;
    private long expiry;
    private long updated;
    private long validUntil;

    @Deprecated
    public BasicPoolEntry(ClientConnectionOperator op, HttpRoute route, ReferenceQueue<Object> referenceQueue) {
        super(op, route);
        if (route != null) {
            this.created = System.currentTimeMillis();
            this.validUntil = LocationRequestCompat.PASSIVE_INTERVAL;
            this.expiry = LocationRequestCompat.PASSIVE_INTERVAL;
            return;
        }
        throw new IllegalArgumentException("HTTP route may not be null");
    }

    public BasicPoolEntry(ClientConnectionOperator op, HttpRoute route) {
        this(op, route, -1, TimeUnit.MILLISECONDS);
    }

    public BasicPoolEntry(ClientConnectionOperator op, HttpRoute route, long connTTL, TimeUnit timeunit) {
        super(op, route);
        if (route != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.created = currentTimeMillis;
            if (connTTL > 0) {
                this.validUntil = currentTimeMillis + timeunit.toMillis(connTTL);
            } else {
                this.validUntil = LocationRequestCompat.PASSIVE_INTERVAL;
            }
            this.expiry = this.validUntil;
            return;
        }
        throw new IllegalArgumentException("HTTP route may not be null");
    }

    /* access modifiers changed from: protected */
    public final OperatedClientConnection getConnection() {
        return this.connection;
    }

    /* access modifiers changed from: protected */
    public final HttpRoute getPlannedRoute() {
        return this.route;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public final BasicPoolEntryRef getWeakRef() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void shutdownEntry() {
        super.shutdownEntry();
    }

    public long getCreated() {
        return this.created;
    }

    public long getUpdated() {
        return this.updated;
    }

    public long getExpiry() {
        return this.expiry;
    }

    public long getValidUntil() {
        return this.validUntil;
    }

    public void updateExpiry(long time, TimeUnit timeunit) {
        long newExpiry;
        long currentTimeMillis = System.currentTimeMillis();
        this.updated = currentTimeMillis;
        if (time > 0) {
            newExpiry = currentTimeMillis + timeunit.toMillis(time);
        } else {
            newExpiry = LocationRequestCompat.PASSIVE_INTERVAL;
        }
        this.expiry = Math.min(this.validUntil, newExpiry);
    }

    public boolean isExpired(long now) {
        return now >= this.expiry;
    }
}
