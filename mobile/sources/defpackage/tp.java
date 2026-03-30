package defpackage;

import android.content.Context;
import android.util.SparseIntArray;
import defpackage.i3;

/* renamed from: tp  reason: default package */
public class tp {
    private final SparseIntArray a = new SparseIntArray();

    /* renamed from: a  reason: collision with other field name */
    private up f5124a;

    public tp(up upVar) {
        y90.j(upVar);
        this.f5124a = upVar;
    }

    public int b(Context context, i3.f fVar) {
        y90.j(context);
        y90.j(fVar);
        int i = 0;
        if (!fVar.d()) {
            return 0;
        }
        int i2 = fVar.i();
        int i3 = this.a.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.a.size()) {
                i = i3;
                break;
            }
            int keyAt = this.a.keyAt(i4);
            if (keyAt > i2 && this.a.get(keyAt) == 0) {
                break;
            }
            i4++;
        }
        if (i == -1) {
            i = this.f5124a.g(context, i2);
        }
        this.a.put(i2, i);
        return i;
    }

    public void a() {
        this.a.clear();
    }
}
