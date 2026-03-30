package defpackage;

/* renamed from: h80  reason: default package */
class h80 extends j60 {
    h80() {
    }

    /* access modifiers changed from: package-private */
    public void T(h70 key, j60 resource) {
        if (resource.size() != 0) {
            j60 dic = K(key);
            if (dic == null) {
                Q(key, resource);
            } else {
                dic.R(resource);
            }
        }
    }
}
