package com.google.firebase.firestore;

public abstract class g {
    private static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final b f2258a = new b();

    /* access modifiers changed from: package-private */
    public abstract String a();

    g() {
    }

    static class a extends g {
        a() {
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return "FieldValue.delete";
        }
    }

    static class b extends g {
        b() {
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return "FieldValue.serverTimestamp";
        }
    }

    public static g b() {
        return f2258a;
    }
}
