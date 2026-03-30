package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: dl  reason: default package */
public final class dl<T> implements ck0<T> {
    /* access modifiers changed from: private */
    public final ck0<T> a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final vn<T, Boolean> f2784a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2785a;

    public dl(ck0<? extends T> sequence, boolean sendWhen, vn<? super T, Boolean> predicate) {
        lu.f(sequence, "sequence");
        lu.f(predicate, "predicate");
        this.a = sequence;
        this.f2785a = sendWhen;
        this.f2784a = predicate;
    }

    /* renamed from: dl$a */
    public static final class a implements Iterator<T> {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ dl<T> f2786a;

        /* renamed from: a  reason: collision with other field name */
        private T f2787a;

        /* renamed from: a  reason: collision with other field name */
        private final Iterator<T> f2788a;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(dl<T> $receiver) {
            this.f2786a = $receiver;
            this.f2788a = $receiver.a.iterator();
        }

        private final void a() {
            while (this.f2788a.hasNext()) {
                Object item = this.f2788a.next();
                if (((Boolean) this.f2786a.f2784a.invoke(item)).booleanValue() == this.f2786a.f2785a) {
                    this.f2787a = item;
                    this.a = 1;
                    return;
                }
            }
            this.a = 0;
        }

        public T next() {
            if (this.a == -1) {
                a();
            }
            if (this.a != 0) {
                Object result = this.f2787a;
                this.f2787a = null;
                this.a = -1;
                return result;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
