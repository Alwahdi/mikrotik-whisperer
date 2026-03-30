package defpackage;

/* renamed from: eo0  reason: default package */
abstract class eo0 extends do0 {
    public static CharSequence D(CharSequence $this$trim) {
        lu.f($this$trim, "<this>");
        CharSequence $this$trim$iv = $this$trim;
        int startIndex$iv = 0;
        int endIndex$iv = $this$trim$iv.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            char p0 = g8.c($this$trim$iv.charAt(!startFound$iv ? startIndex$iv : endIndex$iv));
            if (!startFound$iv) {
                if (p0 == 0) {
                    startFound$iv = true;
                } else {
                    startIndex$iv++;
                }
            } else if (p0 == 0) {
                break;
            } else {
                endIndex$iv--;
            }
        }
        return $this$trim$iv.subSequence(startIndex$iv, endIndex$iv + 1);
    }

    public static final int h(CharSequence $this$lastIndex) {
        lu.f($this$lastIndex, "<this>");
        return $this$lastIndex.length() - 1;
    }

    public static /* synthetic */ String B(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return z(str, c, str2);
    }

    public static final String z(String $this$substringBefore, char delimiter, String missingDelimiterValue) {
        lu.f($this$substringBefore, "<this>");
        lu.f(missingDelimiterValue, "missingDelimiterValue");
        int index = m($this$substringBefore, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String substring = $this$substringBefore.substring(0, index);
        lu.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String C(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return A(str, str2, str3);
    }

    public static final String A(String $this$substringBefore, String delimiter, String missingDelimiterValue) {
        lu.f($this$substringBefore, "<this>");
        lu.f(delimiter, "delimiter");
        lu.f(missingDelimiterValue, "missingDelimiterValue");
        int index = n($this$substringBefore, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String substring = $this$substringBefore.substring(0, index);
        lu.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String w(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return v(str, str2, str3);
    }

    public static final String v(String $this$substringAfter, String delimiter, String missingDelimiterValue) {
        lu.f($this$substringAfter, "<this>");
        lu.f(delimiter, "delimiter");
        lu.f(missingDelimiterValue, "missingDelimiterValue");
        int index = n($this$substringAfter, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String substring = $this$substringAfter.substring(delimiter.length() + index, $this$substringAfter.length());
        lu.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String y(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return x(str, c, str2);
    }

    public static final String x(String $this$substringAfterLast, char delimiter, String missingDelimiterValue) {
        lu.f($this$substringAfterLast, "<this>");
        lu.f(missingDelimiterValue, "missingDelimiterValue");
        int index = r($this$substringAfterLast, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String substring = $this$substringAfterLast.substring(index + 1, $this$substringAfterLast.length());
        lu.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean u(CharSequence $this$regionMatchesImpl, int thisOffset, CharSequence other, int otherOffset, int length, boolean ignoreCase) {
        lu.f($this$regionMatchesImpl, "<this>");
        lu.f(other, "other");
        if (otherOffset < 0 || thisOffset < 0 || thisOffset > $this$regionMatchesImpl.length() - length || otherOffset > other.length() - length) {
            return false;
        }
        for (int index = 0; index < length; index++) {
            if (!h8.d($this$regionMatchesImpl.charAt(thisOffset + index), other.charAt(otherOffset + index), ignoreCase)) {
                return false;
            }
        }
        return true;
    }

    public static final int o(CharSequence $this$indexOfAny, char[] chars, int startIndex, boolean ignoreCase) {
        boolean z;
        lu.f($this$indexOfAny, "<this>");
        lu.f(chars, "chars");
        if (ignoreCase || chars.length != 1 || !($this$indexOfAny instanceof String)) {
            zs d = new dt(hd0.a(startIndex, 0), h($this$indexOfAny)).iterator();
            while (d.hasNext()) {
                int index = d.nextInt();
                char charAtIndex = $this$indexOfAny.charAt(index);
                char[] $this$any$iv = chars;
                int length = $this$any$iv.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        continue;
                        break;
                    } else if (h8.d($this$any$iv[i], charAtIndex, ignoreCase) != 0) {
                        z = true;
                        continue;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return index;
                }
            }
            return -1;
        }
        return ((String) $this$indexOfAny).indexOf(l4.l(chars), startIndex);
    }

    public static final int t(CharSequence $this$lastIndexOfAny, char[] chars, int startIndex, boolean ignoreCase) {
        lu.f($this$lastIndexOfAny, "<this>");
        lu.f(chars, "chars");
        if (ignoreCase || chars.length != 1 || !($this$lastIndexOfAny instanceof String)) {
            for (int index = hd0.b(startIndex, h($this$lastIndexOfAny)); -1 < index; index--) {
                char charAtIndex = $this$lastIndexOfAny.charAt(index);
                char[] $this$any$iv = chars;
                int length = $this$any$iv.length;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (h8.d($this$any$iv[i], charAtIndex, ignoreCase) != 0) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return index;
                }
            }
            return -1;
        }
        return ((String) $this$lastIndexOfAny).lastIndexOf(l4.l(chars), startIndex);
    }

    static /* synthetic */ int l(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return k(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int k(CharSequence $this$indexOf, CharSequence other, int startIndex, int endIndex, boolean ignoreCase, boolean last) {
        bt btVar;
        if (!last) {
            btVar = new dt(hd0.a(startIndex, 0), hd0.b(endIndex, $this$indexOf.length()));
        } else {
            btVar = hd0.d(hd0.b(startIndex, h($this$indexOf)), hd0.a(endIndex, 0));
        }
        bt indices = btVar;
        if (!($this$indexOf instanceof String) || !(other instanceof String)) {
            int index = indices.a();
            int b = indices.b();
            int c = indices.c();
            if ((c <= 0 || index > b) && (c >= 0 || b > index)) {
                return -1;
            }
            while (true) {
                if (u(other, 0, $this$indexOf, index, other.length(), ignoreCase)) {
                    return index;
                }
                if (index == b) {
                    return -1;
                }
                index += c;
            }
        } else {
            int index2 = indices.a();
            int b2 = indices.b();
            int c2 = indices.c();
            if ((c2 <= 0 || index2 > b2) && (c2 >= 0 || b2 > index2)) {
                return -1;
            }
            while (true) {
                if (do0.c((String) other, 0, (String) $this$indexOf, index2, other.length(), ignoreCase)) {
                    return index2;
                }
                if (index2 == b2) {
                    return -1;
                }
                index2 += c2;
            }
        }
    }

    public static /* synthetic */ int m(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return i(charSequence, c, i, z);
    }

    public static final int i(CharSequence $this$indexOf, char c, int startIndex, boolean ignoreCase) {
        lu.f($this$indexOf, "<this>");
        if (!ignoreCase && ($this$indexOf instanceof String)) {
            return ((String) $this$indexOf).indexOf(c, startIndex);
        }
        return o($this$indexOf, new char[]{c}, startIndex, ignoreCase);
    }

    public static /* synthetic */ int n(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return j(charSequence, str, i, z);
    }

    public static final int j(CharSequence $this$indexOf, String string, int startIndex, boolean ignoreCase) {
        lu.f($this$indexOf, "<this>");
        lu.f(string, "string");
        if (!ignoreCase && ($this$indexOf instanceof String)) {
            return ((String) $this$indexOf).indexOf(string, startIndex);
        }
        return l($this$indexOf, string, startIndex, $this$indexOf.length(), ignoreCase, false, 16, (Object) null);
    }

    public static /* synthetic */ int r(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = h(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return p(charSequence, c, i, z);
    }

    public static final int p(CharSequence $this$lastIndexOf, char c, int startIndex, boolean ignoreCase) {
        lu.f($this$lastIndexOf, "<this>");
        if (!ignoreCase && ($this$lastIndexOf instanceof String)) {
            return ((String) $this$lastIndexOf).lastIndexOf(c, startIndex);
        }
        return t($this$lastIndexOf, new char[]{c}, startIndex, ignoreCase);
    }

    public static /* synthetic */ int s(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = h(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return q(charSequence, str, i, z);
    }

    public static final int q(CharSequence $this$lastIndexOf, String string, int startIndex, boolean ignoreCase) {
        lu.f($this$lastIndexOf, "<this>");
        lu.f(string, "string");
        if (ignoreCase || !($this$lastIndexOf instanceof String)) {
            return k($this$lastIndexOf, string, startIndex, 0, ignoreCase, true);
        }
        return ((String) $this$lastIndexOf).lastIndexOf(string, startIndex);
    }
}
