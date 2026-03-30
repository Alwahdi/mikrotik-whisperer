package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class Scope extends x implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new a();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final String f1380a;

    Scope(int i, String str) {
        y90.g(str, "scopeUri must not be null or empty");
        this.a = i;
        this.f1380a = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final String m() {
        return this.f1380a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f1380a.equals(((Scope) obj).f1380a);
    }

    public final int hashCode() {
        return this.f1380a.hashCode();
    }

    public final String toString() {
        return this.f1380a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.a);
        fi0.l(parcel, 2, m(), false);
        fi0.b(parcel, a2);
    }
}
