package com.google.firebase.firestore;

public class o {
    private final boolean a;
    private final boolean b;

    o(boolean hasPendingWrites, boolean isFromCache) {
        this.a = hasPendingWrites;
        this.b = isFromCache;
    }

    public boolean a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o other = (o) obj;
        if (this.a == other.a && this.b == other.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.a) * true) + (this.b ? 1 : 0);
    }

    public String toString() {
        return "SnapshotMetadata{hasPendingWrites=" + this.a + ", isFromCache=" + this.b + '}';
    }
}
