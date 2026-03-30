package defpackage;

import java.util.HashMap;

/* renamed from: u3  reason: default package */
public abstract class u3 {
    private static final HashMap<Character, char[]> a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final char[][] f5188a = {new char[]{1569, 65152}, new char[]{1570, 65153, 65154}, new char[]{1571, 65155, 65156}, new char[]{1572, 65157, 65158}, new char[]{1573, 65159, 65160}, new char[]{1574, 65161, 65162, 65163, 65164}, new char[]{1575, 65165, 65166}, new char[]{1576, 65167, 65168, 65169, 65170}, new char[]{1577, 65171, 65172}, new char[]{1578, 65173, 65174, 65175, 65176}, new char[]{1579, 65177, 65178, 65179, 65180}, new char[]{1580, 65181, 65182, 65183, 65184}, new char[]{1581, 65185, 65186, 65187, 65188}, new char[]{1582, 65189, 65190, 65191, 65192}, new char[]{1583, 65193, 65194}, new char[]{1584, 65195, 65196}, new char[]{1585, 65197, 65198}, new char[]{1586, 65199, 65200}, new char[]{1587, 65201, 65202, 65203, 65204}, new char[]{1588, 65205, 65206, 65207, 65208}, new char[]{1589, 65209, 65210, 65211, 65212}, new char[]{1590, 65213, 65214, 65215, 65216}, new char[]{1591, 65217, 65218, 65219, 65220}, new char[]{1592, 65221, 65222, 65223, 65224}, new char[]{1593, 65225, 65226, 65227, 65228}, new char[]{1594, 65229, 65230, 65231, 65232}, new char[]{1600, 1600, 1600, 1600, 1600}, new char[]{1601, 65233, 65234, 65235, 65236}, new char[]{1602, 65237, 65238, 65239, 65240}, new char[]{1603, 65241, 65242, 65243, 65244}, new char[]{1604, 65245, 65246, 65247, 65248}, new char[]{1605, 65249, 65250, 65251, 65252}, new char[]{1606, 65253, 65254, 65255, 65256}, new char[]{1607, 65257, 65258, 65259, 65260}, new char[]{1608, 65261, 65262}, new char[]{1609, 65263, 65264, 64488, 64489}, new char[]{1610, 65265, 65266, 65267, 65268}, new char[]{1649, 64336, 64337}, new char[]{1657, 64358, 64359, 64360, 64361}, new char[]{1658, 64350, 64351, 64352, 64353}, new char[]{1659, 64338, 64339, 64340, 64341}, new char[]{1662, 64342, 64343, 64344, 64345}, new char[]{1663, 64354, 64355, 64356, 64357}, new char[]{1664, 64346, 64347, 64348, 64349}, new char[]{1667, 64374, 64375, 64376, 64377}, new char[]{1668, 64370, 64371, 64372, 64373}, new char[]{1670, 64378, 64379, 64380, 64381}, new char[]{1671, 64382, 64383, 64384, 64385}, new char[]{1672, 64392, 64393}, new char[]{1676, 64388, 64389}, new char[]{1677, 64386, 64387}, new char[]{1678, 64390, 64391}, new char[]{1681, 64396, 64397}, new char[]{1688, 64394, 64395}, new char[]{1700, 64362, 64363, 64364, 64365}, new char[]{1702, 64366, 64367, 64368, 64369}, new char[]{1705, 64398, 64399, 64400, 64401}, new char[]{1709, 64467, 64468, 64469, 64470}, new char[]{1711, 64402, 64403, 64404, 64405}, new char[]{1713, 64410, 64411, 64412, 64413}, new char[]{1715, 64406, 64407, 64408, 64409}, new char[]{1722, 64414, 64415}, new char[]{1723, 64416, 64417, 64418, 64419}, new char[]{1726, 64426, 64427, 64428, 64429}, new char[]{1728, 64420, 64421}, new char[]{1729, 64422, 64423, 64424, 64425}, new char[]{1733, 64480, 64481}, new char[]{1734, 64473, 64474}, new char[]{1735, 64471, 64472}, new char[]{1736, 64475, 64476}, new char[]{1737, 64482, 64483}, new char[]{1739, 64478, 64479}, new char[]{1740, 64508, 64509, 64510, 64511}, new char[]{1744, 64484, 64485, 64486, 64487}, new char[]{1746, 64430, 64431}, new char[]{1747, 64432, 64433}};
    private static final HashMap<Character, Character> b = new HashMap<>();

    static {
        for (char[] c : f5188a) {
            a.put(Character.valueOf(c[0]), c);
            switch (c.length) {
                case 3:
                    break;
                case 5:
                    b.put(Character.valueOf(c[4]), Character.valueOf(c[3]));
                    break;
            }
            HashMap<Character, Character> hashMap = b;
            hashMap.put(Character.valueOf(c[2]), Character.valueOf(c[1]));
            hashMap.put(Character.valueOf(c[1]), Character.valueOf(c[0]));
            if (c[0] == 1591 || c[0] == 1592) {
                HashMap<Character, Character> hashMap2 = b;
                hashMap2.put(Character.valueOf(c[4]), Character.valueOf(c[1]));
                hashMap2.put(Character.valueOf(c[3]), Character.valueOf(c[1]));
            }
        }
    }

    static boolean g(char s) {
        return (s >= 1611 && s <= 1621) || s == 1648;
    }

    static char b(char s, int which) {
        if (s >= 1569 && s <= 1747) {
            char[] c = a.get(Character.valueOf(s));
            if (c != null) {
                return c[which + 1];
            }
        } else if (s >= 65269 && s <= 65275) {
            return (char) (s + which);
        }
        return s;
    }

    static int l(char s) {
        if (s >= 1569 && s <= 1747 && !g(s)) {
            char[] c = a.get(Character.valueOf(s));
            if (c != null) {
                return c.length - 1;
            }
        } else if (s == 8205) {
            return 4;
        }
        return 1;
    }

    static int h(char newchar, a oldchar) {
        if (oldchar.a == 0) {
            return 0;
        }
        if (g(newchar)) {
            int retval = 1;
            if (!(oldchar.c == 0 || newchar == 1617)) {
                retval = 2;
            }
            switch (newchar) {
                case 1617:
                    if (oldchar.b == 0) {
                        oldchar.b = 1617;
                        break;
                    } else {
                        return 0;
                    }
                case 1619:
                    switch (oldchar.a) {
                        case 1575:
                            oldchar.a = 1570;
                            retval = 2;
                            break;
                    }
                case 1620:
                    switch (oldchar.a) {
                        case 1575:
                            oldchar.a = 1571;
                            retval = 2;
                            break;
                        case 1608:
                            oldchar.a = 1572;
                            retval = 2;
                            break;
                        case 1609:
                        case 1610:
                        case 1740:
                            oldchar.a = 1574;
                            retval = 2;
                            break;
                        case 65275:
                            oldchar.a = 65271;
                            retval = 2;
                            break;
                        default:
                            oldchar.b = 1620;
                            break;
                    }
                case 1621:
                    switch (oldchar.a) {
                        case 1575:
                            oldchar.a = 1573;
                            retval = 2;
                            break;
                        case 65275:
                            oldchar.a = 65273;
                            retval = 2;
                            break;
                        default:
                            oldchar.b = 1621;
                            break;
                    }
                default:
                    oldchar.c = newchar;
                    break;
            }
            if (retval == 1) {
                oldchar.f5189a++;
            }
            return retval;
        } else if (oldchar.c != 0) {
            return 0;
        } else {
            switch (oldchar.a) {
                case 0:
                    oldchar.a = newchar;
                    oldchar.f5190b = l(newchar);
                    return 1;
                case 1604:
                    switch (newchar) {
                        case 1570:
                            oldchar.a = 65269;
                            oldchar.f5190b = 2;
                            return 3;
                        case 1571:
                            oldchar.a = 65271;
                            oldchar.f5190b = 2;
                            return 3;
                        case 1573:
                            oldchar.a = 65273;
                            oldchar.f5190b = 2;
                            return 3;
                        case 1575:
                            oldchar.a = 65275;
                            oldchar.f5190b = 2;
                            return 3;
                        default:
                            return 0;
                    }
                default:
                    return 0;
            }
        }
    }

    static void d(StringBuffer string, a s, int level) {
        char c = s.a;
        if (c != 0) {
            string.append(c);
            int i = s.f5189a - 1;
            s.f5189a = i;
            char c2 = s.b;
            if (c2 != 0) {
                if ((level & 1) == 0) {
                    string.append(c2);
                    s.f5189a--;
                } else {
                    s.f5189a = i - 1;
                }
            }
            char c3 = s.c;
            if (c3 == 0) {
                return;
            }
            if ((level & 1) == 0) {
                string.append(c3);
                s.f5189a--;
                return;
            }
            s.f5189a--;
        }
    }

    static void e(StringBuffer string, int level) {
        int olen = string.length();
        int len = olen;
        int j = 0;
        int si = 1;
        while (si < olen) {
            char lapresult = 0;
            if ((level & 4) != 0) {
                switch (string.charAt(j)) {
                    case 1614:
                        if (string.charAt(si) == 1617) {
                            lapresult = 64608;
                            break;
                        }
                        break;
                    case 1615:
                        if (string.charAt(si) == 1617) {
                            lapresult = 64609;
                            break;
                        }
                        break;
                    case 1616:
                        if (string.charAt(si) == 1617) {
                            lapresult = 64610;
                            break;
                        }
                        break;
                    case 1617:
                        switch (string.charAt(si)) {
                            case 1612:
                                lapresult = 64606;
                                break;
                            case 1613:
                                lapresult = 64607;
                                break;
                            case 1614:
                                lapresult = 64608;
                                break;
                            case 1615:
                                lapresult = 64609;
                                break;
                            case 1616:
                                lapresult = 64610;
                                break;
                        }
                }
            }
            if ((level & 8) != 0) {
                switch (string.charAt(j)) {
                    case 65169:
                        switch (string.charAt(si)) {
                            case 65184:
                                lapresult = 64668;
                                break;
                            case 65188:
                                lapresult = 64669;
                                break;
                            case 65192:
                                lapresult = 64670;
                                break;
                        }
                    case 65175:
                        switch (string.charAt(si)) {
                            case 65184:
                                lapresult = 64673;
                                break;
                            case 65188:
                                lapresult = 64674;
                                break;
                            case 65192:
                                lapresult = 64675;
                                break;
                        }
                    case 65235:
                        switch (string.charAt(si)) {
                            case 65266:
                                lapresult = 64562;
                                break;
                        }
                    case 65247:
                        switch (string.charAt(si)) {
                            case 65182:
                                lapresult = 64575;
                                break;
                            case 65184:
                                lapresult = 64713;
                                break;
                            case 65186:
                                lapresult = 64576;
                                break;
                            case 65188:
                                lapresult = 64714;
                                break;
                            case 65190:
                                lapresult = 64577;
                                break;
                            case 65192:
                                lapresult = 64715;
                                break;
                            case 65250:
                                lapresult = 64578;
                                break;
                            case 65252:
                                lapresult = 64716;
                                break;
                        }
                    case 65251:
                        switch (string.charAt(si)) {
                            case 65184:
                                lapresult = 64718;
                                break;
                            case 65188:
                                lapresult = 64719;
                                break;
                            case 65192:
                                lapresult = 64720;
                                break;
                            case 65252:
                                lapresult = 64721;
                                break;
                        }
                    case 65255:
                        switch (string.charAt(si)) {
                            case 65184:
                                lapresult = 64722;
                                break;
                            case 65188:
                                lapresult = 64723;
                                break;
                            case 65192:
                                lapresult = 64724;
                                break;
                        }
                    case 65256:
                        switch (string.charAt(si)) {
                            case 65198:
                                lapresult = 64650;
                                break;
                            case 65200:
                                lapresult = 64651;
                                break;
                        }
                }
            }
            if (lapresult != 0) {
                string.setCharAt(j, lapresult);
                len--;
                si++;
            } else {
                j++;
                string.setCharAt(j, string.charAt(si));
                si++;
            }
        }
        string.setLength(len);
    }

    static boolean c(a a2) {
        return a2.f5190b > 2;
    }

    static void j(char[] text, StringBuffer string, int level) {
        int which;
        int which2;
        int p = 0;
        a oldchar = new a();
        a curchar = new a();
        while (p < text.length) {
            int p2 = p + 1;
            char nextletter = text[p];
            if (h(nextletter, curchar) == 0) {
                int nc = l(nextletter);
                if (nc == 1) {
                    which2 = 0;
                } else {
                    which2 = 2;
                }
                if (c(oldchar)) {
                    which2++;
                }
                curchar.a = b(curchar.a, which2 % curchar.f5190b);
                d(string, oldchar, level);
                oldchar = curchar;
                curchar = new a();
                curchar.a = nextletter;
                curchar.f5190b = nc;
                curchar.f5189a++;
                p = p2;
            } else {
                p = p2;
            }
        }
        if (c(oldchar) != 0) {
            which = 1;
        } else {
            which = 0;
        }
        curchar.a = b(curchar.a, which % curchar.f5190b);
        d(string, oldchar, level);
        d(string, curchar, level);
    }

    public static int a(char[] src, int srcoffset, int srclength, char[] dest, int destoffset, int destlength, int level) {
        char[] str = new char[srclength];
        for (int k = (srclength + srcoffset) - 1; k >= srcoffset; k--) {
            str[k - srcoffset] = src[k];
        }
        StringBuffer string = new StringBuffer(srclength);
        j(str, string, level);
        if ((level & 12) != 0) {
            e(string, level);
        }
        System.arraycopy(string.toString().toCharArray(), 0, dest, destoffset, string.length());
        return string.length();
    }

    public static void i(char[] text, int offset, int length, int options) {
        int limit = offset + length;
        if ((options & 224) != 0) {
            char digitBase = '0';
            switch (options & 256) {
                case 0:
                    digitBase = 1632;
                    break;
                case 256:
                    digitBase = 1776;
                    break;
            }
            switch (options & 224) {
                case 32:
                    int digitDelta = digitBase - '0';
                    for (int i = offset; i < limit; i++) {
                        char ch = text[i];
                        if (ch <= '9' && ch >= '0') {
                            text[i] = (char) (text[i] + digitDelta);
                        }
                    }
                    return;
                case 64:
                    char digitTop = (char) (digitBase + 9);
                    int digitDelta2 = '0' - digitBase;
                    for (int i2 = offset; i2 < limit; i2++) {
                        char ch2 = text[i2];
                        if (ch2 <= digitTop && ch2 >= digitBase) {
                            text[i2] = (char) (text[i2] + digitDelta2);
                        }
                    }
                    return;
                case 96:
                    k(text, 0, length, digitBase, false);
                    return;
                case 128:
                    k(text, 0, length, digitBase, true);
                    return;
                default:
                    return;
            }
        }
    }

    static void k(char[] dest, int start, int length, char digitBase, boolean lastStrongWasAL) {
        char digitBase2 = (char) (digitBase - '0');
        int limit = start + length;
        for (int i = start; i < limit; i++) {
            char ch = dest[i];
            switch (k6.d(ch)) {
                case 0:
                case 3:
                    lastStrongWasAL = false;
                    break;
                case 4:
                    lastStrongWasAL = true;
                    break;
                case 8:
                    if (lastStrongWasAL && ch <= '9') {
                        dest[i] = (char) (ch + digitBase2);
                        break;
                    }
            }
        }
    }

    public static Character f(char c) {
        return b.get(Character.valueOf(c));
    }

    /* renamed from: u3$a */
    static class a {
        char a;

        /* renamed from: a  reason: collision with other field name */
        int f5189a;
        char b;

        /* renamed from: b  reason: collision with other field name */
        int f5190b = 1;
        char c;

        a() {
        }
    }
}
