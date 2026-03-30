package defpackage;

import java.util.List;

/* renamed from: r  reason: default package */
public abstract class r<E> extends h<E> implements List<E> {
    public static final a a = new a((Cif) null);

    /* renamed from: r$a */
    public static final class a {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }

        public final void a(int index, int size) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
            }
        }

        public final void b(int index, int size) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
            }
        }
    }
}
