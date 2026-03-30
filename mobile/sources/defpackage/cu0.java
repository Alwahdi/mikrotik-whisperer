package defpackage;

import com.google.firebase.firestore.core.c0;

/* renamed from: cu0  reason: default package */
public class cu0 {
    private final bu0 a;

    /* renamed from: a  reason: collision with other field name */
    private final pk f2674a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2675a;

    /* synthetic */ cu0(bu0 x0, pk x1, boolean x2, au0 x3) {
        this(x0, x1, x2);
    }

    private cu0(bu0 accumulator, pk path, boolean arrayElement) {
        this.a = accumulator;
        this.f2674a = path;
        this.f2675a = arrayElement;
    }

    public boolean h() {
        return this.f2675a;
    }

    public c0 f() {
        return this.a.a;
    }

    public pk g() {
        return this.f2674a;
    }

    public boolean i() {
        switch (au0.a[this.a.a.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
            case 5:
                return false;
            default:
                throw n4.a("Unexpected case for UserDataSource: %s", this.a.a.name());
        }
    }

    public cu0 d(String fieldName) {
        pk pkVar = this.f2674a;
        cu0 context = new cu0(this.a, pkVar == null ? null : (pk) pkVar.b(fieldName), false);
        context.j(fieldName);
        return context;
    }

    public cu0 c(int arrayIndex) {
        return new cu0(this.a, (pk) null, true);
    }

    public void a(pk fieldPath) {
        this.a.b(fieldPath);
    }

    public void b(pk fieldPath, yr0 transformOperation) {
        this.a.c(fieldPath, transformOperation);
    }

    public RuntimeException e(String reason) {
        String fieldDescription;
        pk pkVar = this.f2674a;
        if (pkVar == null || pkVar.j()) {
            fieldDescription = "";
        } else {
            fieldDescription = " (found in field " + this.f2674a.toString() + ")";
        }
        return new IllegalArgumentException("Invalid data. " + reason + fieldDescription);
    }

    private void j(String segment) {
        if (segment.isEmpty()) {
            throw e("Document fields must not be empty");
        } else if (i() && segment.startsWith("__") && segment.endsWith("__")) {
            throw e("Document fields cannot begin and end with \"__\"");
        }
    }
}
