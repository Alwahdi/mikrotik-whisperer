package defpackage;

import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.c;
import com.google.firebase.firestore.model.e;
import com.google.firebase.firestore.model.value.FieldValue;
import java.util.ArrayList;
import java.util.List;

/* renamed from: xr0  reason: default package */
public final class xr0 extends u20 {
    private final List<qk> a;

    public xr0(mh key, List<qk> fieldTransforms) {
        super(key, u90.a(true));
        this.a = fieldTransforms;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        xr0 that = (xr0) o;
        if (!g(that) || !this.a.equals(that.a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (h() * 31) + this.a.hashCode();
    }

    public String toString() {
        return "TransformMutation{" + i() + ", fieldTransforms=" + this.a + "}";
    }

    public List<qk> k() {
        return this.a;
    }

    public c b(c maybeDoc, y20 mutationResult) {
        j(maybeDoc);
        n4.d(mutationResult.a() != null, "Transform results missing for TransformMutation.", new Object[0]);
        if (!f().e(maybeDoc)) {
            return new e(d(), mutationResult.b());
        }
        b doc = m(maybeDoc);
        return new b(d(), mutationResult.b(), b.a.COMMITTED_MUTATIONS, o(doc.d(), n(doc, mutationResult.a())));
    }

    public c a(c maybeDoc, c baseDoc, pr0 localWriteTime) {
        j(maybeDoc);
        if (!f().e(maybeDoc)) {
            return maybeDoc;
        }
        b doc = m(maybeDoc);
        return new b(d(), doc.b(), b.a.LOCAL_MUTATIONS, o(doc.d(), l(localWriteTime, maybeDoc, baseDoc)));
    }

    public c40 c(c maybeDoc) {
        c40 baseObject = null;
        for (qk transform : this.a) {
            rk existingValue = null;
            if (maybeDoc instanceof b) {
                existingValue = ((b) maybeDoc).e(transform.a());
            }
            rk coercedValue = transform.b().b(existingValue);
            if (coercedValue != null) {
                if (baseObject == null) {
                    baseObject = c40.g().n(transform.a(), coercedValue);
                } else {
                    baseObject = baseObject.n(transform.a(), coercedValue);
                }
            }
        }
        return baseObject;
    }

    private b m(c maybeDoc) {
        n4.d(maybeDoc instanceof b, "Unknown MaybeDocument type %s", maybeDoc);
        b doc = (b) maybeDoc;
        n4.d(doc.a().equals(d()), "Can only transform a document with the same key", new Object[0]);
        return doc;
    }

    private List<rk> n(c baseDoc, List<rk> serverTransformResults) {
        ArrayList<FieldValue> transformResults = new ArrayList<>(this.a.size());
        n4.d(this.a.size() == serverTransformResults.size(), "server transform count (%d) should match field transform count (%d)", Integer.valueOf(serverTransformResults.size()), Integer.valueOf(this.a.size()));
        for (int i = 0; i < serverTransformResults.size(); i++) {
            qk fieldTransform = this.a.get(i);
            yr0 transform = fieldTransform.b();
            rk previousValue = null;
            if (baseDoc instanceof b) {
                previousValue = ((b) baseDoc).e(fieldTransform.a());
            }
            transformResults.add(transform.c(previousValue, serverTransformResults.get(i)));
        }
        return transformResults;
    }

    private List<rk> l(pr0 localWriteTime, c maybeDoc, c baseDoc) {
        ArrayList<FieldValue> transformResults = new ArrayList<>(this.a.size());
        for (qk fieldTransform : this.a) {
            yr0 transform = fieldTransform.b();
            rk previousValue = null;
            if (maybeDoc instanceof b) {
                previousValue = ((b) maybeDoc).e(fieldTransform.a());
            }
            if (previousValue == null && (baseDoc instanceof b)) {
                previousValue = ((b) baseDoc).e(fieldTransform.a());
            }
            transformResults.add(transform.a(previousValue, localWriteTime));
        }
        return transformResults;
    }

    private c40 o(c40 objectValue, List<rk> transformResults) {
        n4.d(transformResults.size() == this.a.size(), "Transform results length mismatch.", new Object[0]);
        for (int i = 0; i < this.a.size(); i++) {
            objectValue = objectValue.n(this.a.get(i).a(), transformResults.get(i));
        }
        return objectValue;
    }
}
