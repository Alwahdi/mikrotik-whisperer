package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: os  reason: default package */
public final class os {
    public static final b a = new b((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    private final Context f4591a;

    /* renamed from: a  reason: collision with other field name */
    private final AttributeSet f4592a;

    /* renamed from: a  reason: collision with other field name */
    private final View f4593a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4594a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof os)) {
            return false;
        }
        os osVar = (os) obj;
        return lu.a(this.f4593a, osVar.f4593a) && lu.a(this.f4594a, osVar.f4594a) && lu.a(this.f4591a, osVar.f4591a) && lu.a(this.f4592a, osVar.f4592a);
    }

    public int hashCode() {
        View view = this.f4593a;
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        String str = this.f4594a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Context context = this.f4591a;
        int hashCode3 = (hashCode2 + (context != null ? context.hashCode() : 0)) * 31;
        AttributeSet attributeSet = this.f4592a;
        if (attributeSet != null) {
            i = attributeSet.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "InflateResult(view=" + this.f4593a + ", name=" + this.f4594a + ", context=" + this.f4591a + ", attrs=" + this.f4592a + ")";
    }

    public os(View view, String name, Context context, AttributeSet attrs) {
        lu.g(name, "name");
        lu.g(context, "context");
        this.f4593a = view;
        this.f4594a = name;
        this.f4591a = context;
        this.f4592a = attrs;
    }

    public final View e() {
        return this.f4593a;
    }

    public final String c() {
        return this.f4594a;
    }

    public final Context b() {
        return this.f4591a;
    }

    public final AttributeSet a() {
        return this.f4592a;
    }

    public final a d() {
        return new a(this);
    }

    /* renamed from: os$a */
    public static final class a {
        private Context a;

        /* renamed from: a  reason: collision with other field name */
        private AttributeSet f4595a;

        /* renamed from: a  reason: collision with other field name */
        private View f4596a;

        /* renamed from: a  reason: collision with other field name */
        private String f4597a;

        public a(os result) {
            lu.g(result, "result");
            this.f4596a = result.e();
            this.f4597a = result.c();
            this.a = result.b();
            this.f4595a = result.a();
        }

        public final a b(View view) {
            this.f4596a = view;
            return this;
        }

        public final os a() {
            String finalName = this.f4597a;
            if (finalName != null) {
                View view = this.f4596a;
                if (view != null) {
                    View it = view;
                    if (!lu.a(finalName, it.getClass().getName())) {
                        throw new IllegalStateException(("name (" + finalName + ") must be the view's fully qualified name (" + it.getClass().getName() + ')').toString());
                    }
                } else {
                    view = null;
                }
                Context context = this.a;
                if (context != null) {
                    return new os(view, finalName, context, this.f4595a);
                }
                throw new IllegalStateException("context == null");
            }
            throw new IllegalStateException("name == null".toString());
        }
    }

    /* renamed from: os$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(Cif $constructor_marker) {
            this();
        }
    }
}
