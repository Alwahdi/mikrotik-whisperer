package defpackage;

/* renamed from: oz0  reason: default package */
public abstract class oz0 {
    protected oz0() {
    }

    public abstract boolean b(char c);

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        t01.b(i, length, "index");
        while (i < length) {
            if (b(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static String d(char c) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }
}
