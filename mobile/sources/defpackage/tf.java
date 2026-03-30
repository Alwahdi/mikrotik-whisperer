package defpackage;

/* renamed from: tf  reason: default package */
public class tf implements om0 {
    public static final om0 a = new tf();

    /* renamed from: a  reason: collision with other field name */
    protected char[] f5097a;

    public boolean a(int start, int current, int end, char[] cc, b60[] ck) {
        char c = b(current, cc, ck);
        if (this.f5097a != null) {
            int i = 0;
            while (true) {
                char[] cArr = this.f5097a;
                if (i >= cArr.length) {
                    return false;
                }
                if (c == cArr[i]) {
                    return true;
                }
                i++;
            }
        } else if (c <= ' ' || c == '-' || c == 8208) {
            return true;
        } else {
            if (c < 8194) {
                return false;
            }
            if ((c < 8194 || c > 8203) && ((c < 11904 || c >= 55200) && ((c < 63744 || c >= 64256) && ((c < 65072 || c >= 65104) && (c < 65377 || c >= 65440))))) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public char b(int current, char[] cc, b60[] ck) {
        if (ck == null) {
            return cc[current];
        }
        return (char) ck[Math.min(current, ck.length - 1)].q(cc[current]);
    }
}
