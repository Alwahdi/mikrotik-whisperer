package defpackage;

import com.google.firebase.firestore.core.c0;

/* renamed from: au0  reason: default package */
abstract /* synthetic */ class au0 {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[c0.values().length];
        a = iArr;
        try {
            iArr[c0.Set.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[c0.MergeSet.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[c0.Update.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[c0.Argument.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[c0.ArrayArgument.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
