package defpackage;

/* renamed from: oq  reason: default package */
abstract class oq {
    static int a(int hashCode) {
        return (int) (((long) Integer.rotateLeft((int) (((long) hashCode) * -862048943), 15)) * 461845907);
    }

    static int b(Object o) {
        return a(o == null ? 0 : o.hashCode());
    }
}
