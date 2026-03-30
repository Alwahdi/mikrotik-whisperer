package defpackage;

/* renamed from: re0  reason: default package */
public abstract class re0 extends qe0 implements wo<Object> {
    private final int arity;

    public int getArity() {
        return this.arity;
    }

    public re0(int arity2, rc<Object> completion) {
        super(completion);
        this.arity = arity2;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String f = xd0.f(this);
        lu.e(f, "renderLambdaToString(this)");
        return f;
    }
}
