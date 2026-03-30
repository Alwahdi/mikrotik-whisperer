package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import java.util.Objects;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0013a();
    /* access modifiers changed from: private */
    public final int a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final c f1675a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final j f1676a;
    private final int b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final j f1677b;
    private final int c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public j f1678c;

    public interface c extends Parcelable {
        boolean g(long j);
    }

    /* synthetic */ a(j x0, j x1, c x2, j x3, int x4, C0013a x5) {
        this(x0, x1, x2, x3, x4);
    }

    private a(j start, j end, c validator, j openAt, int firstDayOfWeek) {
        Objects.requireNonNull(start, "start cannot be null");
        Objects.requireNonNull(end, "end cannot be null");
        Objects.requireNonNull(validator, "validator cannot be null");
        this.f1676a = start;
        this.f1677b = end;
        this.f1678c = openAt;
        this.a = firstDayOfWeek;
        this.f1675a = validator;
        if (openAt != null && start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (openAt != null && openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        } else if (firstDayOfWeek < 0 || firstDayOfWeek > p.k().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        } else {
            this.c = start.x(end) + 1;
            this.b = (end.b - start.b) + 1;
        }
    }

    public c r() {
        return this.f1675a;
    }

    /* access modifiers changed from: package-private */
    public j w() {
        return this.f1676a;
    }

    /* access modifiers changed from: package-private */
    public j s() {
        return this.f1677b;
    }

    /* access modifiers changed from: package-private */
    public j v() {
        return this.f1678c;
    }

    /* access modifiers changed from: package-private */
    public int t() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public int u() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public int x() {
        return this.b;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof a)) {
            return false;
        }
        a that = (a) o;
        if (!this.f1676a.equals(that.f1676a) || !this.f1677b.equals(that.f1677b) || !ObjectsCompat.equals(this.f1678c, that.f1678c) || this.a != that.a || !this.f1675a.equals(that.f1675a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1676a, this.f1677b, this.f1678c, Integer.valueOf(this.a), this.f1675a});
    }

    /* renamed from: com.google.android.material.datepicker.a$a  reason: collision with other inner class name */
    class C0013a implements Parcelable.Creator<a> {
        C0013a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel source) {
            return new a((j) source.readParcelable(j.class.getClassLoader()), (j) source.readParcelable(j.class.getClassLoader()), (c) source.readParcelable(c.class.getClassLoader()), (j) source.readParcelable(j.class.getClassLoader()), source.readInt(), (C0013a) null);
        }

        /* renamed from: b */
        public a[] newArray(int size) {
            return new a[size];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.f1676a, 0);
        dest.writeParcelable(this.f1677b, 0);
        dest.writeParcelable(this.f1678c, 0);
        dest.writeParcelable(this.f1675a, 0);
        dest.writeInt(this.a);
    }

    /* access modifiers changed from: package-private */
    public j q(j month) {
        if (month.compareTo(this.f1676a) < 0) {
            return this.f1676a;
        }
        if (month.compareTo(this.f1677b) > 0) {
            return this.f1677b;
        }
        return month;
    }

    public static final class b {
        static final long c = p.a(j.o(1900, 0).f1737a);
        static final long d = p.a(j.o(2100, 11).f1737a);
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private long f1679a = c;

        /* renamed from: a  reason: collision with other field name */
        private c f1680a = e.f(Long.MIN_VALUE);

        /* renamed from: a  reason: collision with other field name */
        private Long f1681a;
        private long b = d;

        b(a clone) {
            this.f1679a = clone.f1676a.f1737a;
            this.b = clone.f1677b.f1737a;
            this.f1681a = Long.valueOf(clone.f1678c.f1737a);
            this.a = clone.a;
            this.f1680a = clone.f1675a;
        }

        public b b(long month) {
            this.f1681a = Long.valueOf(month);
            return this;
        }

        public a a() {
            Bundle deepCopyBundle = new Bundle();
            deepCopyBundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f1680a);
            j p = j.p(this.f1679a);
            j p2 = j.p(this.b);
            c cVar = (c) deepCopyBundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l = this.f1681a;
            return new a(p, p2, cVar, l == null ? null : j.p(l.longValue()), this.a, (C0013a) null);
        }
    }
}
