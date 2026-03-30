package defpackage;

/* renamed from: do0  reason: default package */
abstract class do0 extends co0 {
    public static /* synthetic */ String e(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return d(str, str2, str3, z);
    }

    public static final String d(String $this$replace, String oldValue, String newValue, boolean ignoreCase) {
        lu.f($this$replace, "<this>");
        lu.f(oldValue, "oldValue");
        lu.f(newValue, "newValue");
        String $this$replace_u24lambda_u242 = $this$replace;
        int occurrenceIndex = eo0.j($this$replace_u24lambda_u242, oldValue, 0, ignoreCase);
        if (occurrenceIndex < 0) {
            return $this$replace_u24lambda_u242;
        }
        int oldValueLength = oldValue.length();
        int searchStep = hd0.a(oldValueLength, 1);
        int newLengthHint = ($this$replace_u24lambda_u242.length() - oldValueLength) + newValue.length();
        if (newLengthHint >= 0) {
            StringBuilder stringBuilder = new StringBuilder(newLengthHint);
            int i = 0;
            do {
                stringBuilder.append($this$replace_u24lambda_u242, i, occurrenceIndex);
                stringBuilder.append(newValue);
                i = occurrenceIndex + oldValueLength;
                if (occurrenceIndex >= $this$replace_u24lambda_u242.length() || (occurrenceIndex = eo0.j($this$replace_u24lambda_u242, oldValue, occurrenceIndex + searchStep, ignoreCase)) <= 0) {
                    stringBuilder.append($this$replace_u24lambda_u242, i, $this$replace_u24lambda_u242.length());
                    String sb = stringBuilder.toString();
                    lu.e(sb, "stringBuilder.append(this, i, length).toString()");
                }
                stringBuilder.append($this$replace_u24lambda_u242, i, occurrenceIndex);
                stringBuilder.append(newValue);
                i = occurrenceIndex + oldValueLength;
                break;
            } while ((occurrenceIndex = eo0.j($this$replace_u24lambda_u242, oldValue, occurrenceIndex + searchStep, ignoreCase)) <= 0);
            stringBuilder.append($this$replace_u24lambda_u242, i, $this$replace_u24lambda_u242.length());
            String sb2 = stringBuilder.toString();
            lu.e(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ boolean g(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return f(str, str2, z);
    }

    public static final boolean f(String $this$startsWith, String prefix, boolean ignoreCase) {
        lu.f($this$startsWith, "<this>");
        lu.f(prefix, "prefix");
        if (!ignoreCase) {
            return $this$startsWith.startsWith(prefix);
        }
        return c($this$startsWith, 0, prefix, 0, prefix.length(), ignoreCase);
    }

    public static final boolean c(String $this$regionMatches, int thisOffset, String other, int otherOffset, int length, boolean ignoreCase) {
        lu.f($this$regionMatches, "<this>");
        lu.f(other, "other");
        if (!ignoreCase) {
            return $this$regionMatches.regionMatches(thisOffset, other, otherOffset, length);
        }
        return $this$regionMatches.regionMatches(ignoreCase, thisOffset, other, otherOffset, length);
    }
}
