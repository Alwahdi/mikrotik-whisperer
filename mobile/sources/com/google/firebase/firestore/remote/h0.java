package com.google.firebase.firestore.remote;

import io.grpc.p;
import java.util.List;

public abstract class h0 {

    public enum e {
        NoChange,
        Added,
        Removed,
        Current,
        Reset
    }

    private h0() {
    }

    public static final class b extends h0 {
        private final com.google.firebase.firestore.model.c a;

        /* renamed from: a  reason: collision with other field name */
        private final List<Integer> f2336a;

        /* renamed from: a  reason: collision with other field name */
        private final mh f2337a;
        private final List<Integer> b;

        public b(List<Integer> updatedTargetIds, List<Integer> removedTargetIds, mh key, com.google.firebase.firestore.model.c document) {
            super();
            this.f2336a = updatedTargetIds;
            this.b = removedTargetIds;
            this.f2337a = key;
            this.a = document;
        }

        public List<Integer> d() {
            return this.f2336a;
        }

        public List<Integer> c() {
            return this.b;
        }

        public com.google.firebase.firestore.model.c b() {
            return this.a;
        }

        public mh a() {
            return this.f2337a;
        }

        public String toString() {
            return "DocumentChange{updatedTargetIds=" + this.f2336a + ", removedTargetIds=" + this.b + ", key=" + this.f2337a + ", newDocument=" + this.a + '}';
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            b that = (b) o;
            if (!this.f2336a.equals(that.f2336a) || !this.b.equals(that.b) || !this.f2337a.equals(that.f2337a)) {
                return false;
            }
            com.google.firebase.firestore.model.c cVar = this.a;
            if (cVar != null) {
                return cVar.equals(that.a);
            }
            if (that.a == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = ((((this.f2336a.hashCode() * 31) + this.b.hashCode()) * 31) + this.f2337a.hashCode()) * 31;
            com.google.firebase.firestore.model.c cVar = this.a;
            return result + (cVar != null ? cVar.hashCode() : 0);
        }
    }

    public static final class c extends h0 {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private final yj f2338a;

        public c(int targetId, yj existenceFilter) {
            super();
            this.a = targetId;
            this.f2338a = existenceFilter;
        }

        public int b() {
            return this.a;
        }

        public yj a() {
            return this.f2338a;
        }

        public String toString() {
            return "ExistenceFilterWatchChange{targetId=" + this.a + ", existenceFilter=" + this.f2338a + '}';
        }
    }

    public static final class d extends h0 {
        private final e a;

        /* renamed from: a  reason: collision with other field name */
        private final com.google.protobuf.e f2339a;

        /* renamed from: a  reason: collision with other field name */
        private final p f2340a;

        /* renamed from: a  reason: collision with other field name */
        private final List<Integer> f2341a;

        public d(e changeType, List<Integer> targetIds, com.google.protobuf.e resumeToken, p cause) {
            super();
            n4.d(cause == null || changeType == e.Removed, "Got cause for a target change that was not a removal", new Object[0]);
            this.a = changeType;
            this.f2341a = targetIds;
            this.f2339a = resumeToken;
            if (cause == null || cause.o()) {
                this.f2340a = null;
            } else {
                this.f2340a = cause;
            }
        }

        public e b() {
            return this.a;
        }

        public List<Integer> d() {
            return this.f2341a;
        }

        public com.google.protobuf.e c() {
            return this.f2339a;
        }

        public p a() {
            return this.f2340a;
        }

        public String toString() {
            return "WatchTargetChange{changeType=" + this.a + ", targetIds=" + this.f2341a + '}';
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            d that = (d) o;
            if (this.a != that.a || !this.f2341a.equals(that.f2341a) || !this.f2339a.equals(that.f2339a)) {
                return false;
            }
            p pVar = this.f2340a;
            if (pVar != null) {
                if (that.f2340a == null || !pVar.m().equals(that.f2340a.m())) {
                    return false;
                }
                return true;
            } else if (that.f2340a == null) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode() {
            int result = ((((this.a.hashCode() * 31) + this.f2341a.hashCode()) * 31) + this.f2339a.hashCode()) * 31;
            p pVar = this.f2340a;
            return result + (pVar != null ? pVar.m().hashCode() : 0);
        }
    }
}
