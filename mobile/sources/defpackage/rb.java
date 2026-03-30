package defpackage;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: rb  reason: default package */
public final class rb extends RuntimeException {
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f4888a;

    /* renamed from: a  reason: collision with other field name */
    private final List<Throwable> f4889a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public rb(Throwable... exceptions) {
        this((Iterable<? extends Throwable>) exceptions == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(exceptions));
    }

    public rb(Iterable<? extends Throwable> errors) {
        Set<Throwable> deDupedExceptions = new LinkedHashSet<>();
        List<Throwable> localExceptions = new ArrayList<>();
        if (errors != null) {
            for (Throwable ex : errors) {
                if (ex instanceof rb) {
                    deDupedExceptions.addAll(((rb) ex).b());
                } else if (ex != null) {
                    deDupedExceptions.add(ex);
                } else {
                    deDupedExceptions.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            deDupedExceptions.add(new NullPointerException("errors was null"));
        }
        if (!deDupedExceptions.isEmpty()) {
            localExceptions.addAll(deDupedExceptions);
            List<T> unmodifiableList = Collections.unmodifiableList(localExceptions);
            this.f4889a = unmodifiableList;
            this.a = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    public List<Throwable> b() {
        return this.f4889a;
    }

    public String getMessage() {
        return this.a;
    }

    public synchronized Throwable getCause() {
        if (this.f4888a == null) {
            Throwable localCause = new a();
            Set<Throwable> seenCauses = new HashSet<>();
            Throwable chain = localCause;
            Iterator<Throwable> it = this.f4889a.iterator();
            while (it.hasNext()) {
                Throwable e = it.next();
                if (!seenCauses.contains(e)) {
                    seenCauses.add(e);
                    for (Throwable child : c(e)) {
                        if (seenCauses.contains(child)) {
                            e = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            seenCauses.add(child);
                        }
                    }
                    try {
                        chain.initCause(e);
                    } catch (Throwable th) {
                    }
                    chain = d(chain);
                }
            }
            this.f4888a = localCause;
        }
        return this.f4888a;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream s) {
        e(new c(s));
    }

    public void printStackTrace(PrintWriter s) {
        e(new d(s));
    }

    private void e(b s) {
        StringBuilder b2 = new StringBuilder(128);
        b2.append(this);
        b2.append(10);
        for (StackTraceElement myStackElement : getStackTrace()) {
            b2.append("\tat ");
            b2.append(myStackElement);
            b2.append(10);
        }
        int i = 1;
        for (Throwable ex : this.f4889a) {
            b2.append("  ComposedException ");
            b2.append(i);
            b2.append(" :\n");
            a(b2, ex, "\t");
            i++;
        }
        s.a(b2.toString());
    }

    private void a(StringBuilder b2, Throwable ex, String prefix) {
        b2.append(prefix);
        b2.append(ex);
        b2.append(10);
        for (StackTraceElement stackElement : ex.getStackTrace()) {
            b2.append("\t\tat ");
            b2.append(stackElement);
            b2.append(10);
        }
        if (ex.getCause() != null) {
            b2.append("\tCaused by: ");
            a(b2, ex.getCause(), "");
        }
    }

    /* renamed from: rb$b */
    static abstract class b {
        /* access modifiers changed from: package-private */
        public abstract void a(Object obj);

        b() {
        }
    }

    /* renamed from: rb$c */
    static final class c extends b {
        private final PrintStream a;

        c(PrintStream printStream) {
            this.a = printStream;
        }

        /* access modifiers changed from: package-private */
        public void a(Object o) {
            this.a.println(o);
        }
    }

    /* renamed from: rb$d */
    static final class d extends b {
        private final PrintWriter a;

        d(PrintWriter printWriter) {
            this.a = printWriter;
        }

        /* access modifiers changed from: package-private */
        public void a(Object o) {
            this.a.println(o);
        }
    }

    /* renamed from: rb$a */
    static final class a extends RuntimeException {
        a() {
        }

        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    private List<Throwable> c(Throwable ex) {
        List<Throwable> list = new ArrayList<>();
        Throwable root = ex.getCause();
        if (root == null || root == ex) {
            return list;
        }
        while (true) {
            list.add(root);
            Throwable cause = root.getCause();
            if (cause == null || cause == root) {
                return list;
            }
            root = cause;
        }
        return list;
    }

    private Throwable d(Throwable e) {
        Throwable root = e.getCause();
        if (root == null || this.f4888a == root) {
            return e;
        }
        while (true) {
            Throwable cause = root.getCause();
            if (cause == null || cause == root) {
                return root;
            }
            root = cause;
        }
        return root;
    }
}
