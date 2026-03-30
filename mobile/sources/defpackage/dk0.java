package defpackage;

import defpackage.se0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: dk0  reason: default package */
final class dk0<T> extends ek0<T> implements Iterator<T>, rc<jt0> {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private T f2781a;

    /* renamed from: a  reason: collision with other field name */
    private Iterator<? extends T> f2782a;

    /* renamed from: a  reason: collision with other field name */
    private rc<? super jt0> f2783a;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void g(rc<? super jt0> rcVar) {
        this.f2783a = rcVar;
    }

    public boolean hasNext() {
        while (true) {
            switch (this.a) {
                case 0:
                    break;
                case 1:
                    Iterator<? extends T> it = this.f2782a;
                    lu.c(it);
                    if (!it.hasNext()) {
                        this.f2782a = null;
                        break;
                    } else {
                        this.a = 2;
                        return true;
                    }
                case 2:
                case 3:
                    return true;
                case 4:
                    return false;
                default:
                    throw e();
            }
            this.a = 5;
            rc step = this.f2783a;
            lu.c(step);
            this.f2783a = null;
            se0.a aVar = se0.a;
            step.resumeWith(se0.a(jt0.a));
        }
    }

    public T next() {
        switch (this.a) {
            case 0:
            case 1:
                return f();
            case 2:
                this.a = 1;
                Iterator<? extends T> it = this.f2782a;
                lu.c(it);
                return it.next();
            case 3:
                this.a = 0;
                Object result = this.f2781a;
                this.f2781a = null;
                return result;
            default:
                throw e();
        }
    }

    private final T f() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    private final Throwable e() {
        switch (this.a) {
            case 4:
                return new NoSuchElementException();
            case 5:
                return new IllegalStateException("Iterator has failed.");
            default:
                return new IllegalStateException("Unexpected state of the iterator: " + this.a);
        }
    }

    public Object a(T value, rc<? super jt0> $completion) {
        this.f2781a = value;
        this.a = 3;
        this.f2783a = $completion;
        Object d = ou.d();
        if (d == ou.d()) {
            df.c($completion);
        }
        return d == ou.d() ? d : jt0.a;
    }

    public Object d(Iterator<? extends T> iterator, rc<? super jt0> $completion) {
        if (!iterator.hasNext()) {
            return jt0.a;
        }
        this.f2782a = iterator;
        this.a = 2;
        this.f2783a = $completion;
        Object d = ou.d();
        if (d == ou.d()) {
            df.c($completion);
        }
        return d == ou.d() ? d : jt0.a;
    }

    public void resumeWith(Object result) {
        te0.b(result);
        this.a = 4;
    }

    public yc getContext() {
        return gi.a;
    }
}
