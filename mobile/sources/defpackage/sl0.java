package defpackage;

import java.util.HashMap;
import java.util.StringTokenizer;

/* renamed from: sl0  reason: default package */
public abstract class sl0 {
    static void a(j60 outline, HashMap<String, Object> map, v80 writer, boolean namedAsNames) {
        String file;
        j60 j60 = outline;
        HashMap<String, Object> hashMap = map;
        v80 v80 = writer;
        try {
            String action = (String) hashMap.get("Action");
            if ("GoTo".equals(action)) {
                String str = (String) hashMap.get("Named");
                String p = str;
                if (str == null) {
                    String str2 = (String) hashMap.get("Page");
                    String p2 = str2;
                    if (str2 != null) {
                        x50 ar = new x50();
                        StringTokenizer tk = new StringTokenizer(p2);
                        ar.I(v80.k0(Integer.parseInt(tk.nextToken())));
                        if (!tk.hasMoreTokens()) {
                            ar.I(h70.Wd);
                            ar.J(new float[]{0.0f, 10000.0f, 0.0f});
                        } else {
                            String fn = tk.nextToken();
                            if (fn.startsWith("/")) {
                                fn = fn.substring(1);
                            }
                            ar.I(new h70(fn));
                            for (int k = 0; k < 4 && tk.hasMoreTokens(); k++) {
                                String fn2 = tk.nextToken();
                                if (fn2.equals("null")) {
                                    ar.I(j70.a);
                                } else {
                                    ar.I(new k70(fn2));
                                }
                            }
                        }
                        j60.Q(h70.o2, ar);
                    }
                } else if (namedAsNames) {
                    j60.Q(h70.o2, new h70(p));
                } else {
                    j60.Q(h70.o2, new n80(p, (String) null));
                }
            } else if ("GoToR".equals(action)) {
                j60 dic = new j60();
                String str3 = (String) hashMap.get("Named");
                String p3 = str3;
                if (str3 != null) {
                    dic.Q(h70.W1, new n80(p3, (String) null));
                } else {
                    String str4 = (String) hashMap.get("NamedN");
                    String p4 = str4;
                    if (str4 != null) {
                        dic.Q(h70.W1, new h70(p4));
                    } else {
                        String str5 = (String) hashMap.get("Page");
                        String p5 = str5;
                        if (str5 != null) {
                            x50 ar2 = new x50();
                            StringTokenizer tk2 = new StringTokenizer(p5);
                            ar2.I(new k70(tk2.nextToken()));
                            if (!tk2.hasMoreTokens()) {
                                ar2.I(h70.Wd);
                                ar2.J(new float[]{0.0f, 10000.0f, 0.0f});
                            } else {
                                String fn3 = tk2.nextToken();
                                if (fn3.startsWith("/")) {
                                    fn3 = fn3.substring(1);
                                }
                                ar2.I(new h70(fn3));
                                for (int k2 = 0; k2 < 4 && tk2.hasMoreTokens(); k2++) {
                                    String fn4 = tk2.nextToken();
                                    if (fn4.equals("null")) {
                                        ar2.I(j70.a);
                                    } else {
                                        ar2.I(new k70(fn4));
                                    }
                                }
                            }
                            dic.Q(h70.W1, ar2);
                        }
                    }
                }
                String file2 = (String) hashMap.get("File");
                if (dic.size() > 0 && file2 != null) {
                    dic.Q(h70.ta, h70.H4);
                    dic.Q(h70.w3, new n80(file2));
                    String nw = (String) hashMap.get("NewWindow");
                    if (nw != null) {
                        if (nw.equals("true")) {
                            dic.Q(h70.q7, z50.a);
                        } else if (nw.equals("false")) {
                            dic.Q(h70.q7, z50.b);
                        }
                    }
                    j60.Q(h70.b, dic);
                }
            } else if ("URI".equals(action)) {
                String uri = (String) hashMap.get("URI");
                if (uri != null) {
                    j60 dic2 = new j60();
                    h70 h70 = h70.ta;
                    h70 h702 = h70.Pc;
                    dic2.Q(h70, h702);
                    dic2.Q(h702, new n80(uri));
                    j60.Q(h70.b, dic2);
                }
            } else if ("JS".equals(action)) {
                String code = (String) hashMap.get("Code");
                if (code != null) {
                    j60.Q(h70.b, u50.T(code, v80));
                }
            } else if ("Launch".equals(action) && (file = (String) hashMap.get("File")) != null) {
                j60 dic3 = new j60();
                dic3.Q(h70.ta, h70.i6);
                dic3.Q(h70.w3, new n80(file));
                j60.Q(h70.b, dic3);
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2 A[SYNTHETIC, Splitter:B:27:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0149 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object[] b(defpackage.v80 r19, defpackage.z60 r20, java.util.List<java.util.HashMap<java.lang.String, java.lang.Object>> r21, boolean r22) {
        /*
            r1 = r19
            r2 = r22
            int r0 = r21.size()
            z60[] r3 = new defpackage.z60[r0]
            r0 = 0
        L_0x000b:
            int r4 = r3.length
            if (r0 >= r4) goto L_0x0017
            z60 r4 = r19.m0()
            r3[r0] = r4
            int r0 = r0 + 1
            goto L_0x000b
        L_0x0017:
            r0 = 0
            r4 = 0
            java.util.ListIterator r5 = r21.listIterator()
            r18 = r4
            r4 = r0
            r0 = r18
        L_0x0022:
            boolean r6 = r5.hasNext()
            r7 = 3
            r8 = 2
            r9 = 0
            r10 = 1
            if (r6 == 0) goto L_0x0158
            java.lang.Object r6 = r5.next()
            java.util.HashMap r6 = (java.util.HashMap) r6
            r11 = 0
            java.lang.String r12 = "Kids"
            java.lang.Object r12 = r6.get(r12)
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x0049
            boolean r13 = r12.isEmpty()
            if (r13 != 0) goto L_0x0049
            r13 = r3[r4]
            java.lang.Object[] r11 = b(r1, r13, r12, r2)
        L_0x0049:
            j60 r13 = new j60
            r13.<init>()
            int r0 = r0 + 1
            if (r11 == 0) goto L_0x0093
            h70 r14 = defpackage.h70.L3
            r9 = r11[r9]
            z60 r9 = (defpackage.z60) r9
            r13.Q(r14, r9)
            h70 r9 = defpackage.h70.f6
            r14 = r11[r10]
            z60 r14 = (defpackage.z60) r14
            r13.Q(r9, r14)
            r8 = r11[r8]
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.String r9 = "Open"
            java.lang.Object r9 = r6.get(r9)
            java.lang.String r14 = "false"
            boolean r9 = r14.equals(r9)
            if (r9 == 0) goto L_0x0086
            h70 r9 = defpackage.h70.G1
            k70 r14 = new k70
            int r15 = -r8
            r14.<init>((int) r15)
            r13.Q(r9, r14)
            goto L_0x0093
        L_0x0086:
            h70 r9 = defpackage.h70.G1
            k70 r14 = new k70
            r14.<init>((int) r8)
            r13.Q(r9, r14)
            int r0 = r0 + r8
            r8 = r0
            goto L_0x0094
        L_0x0093:
            r8 = r0
        L_0x0094:
            h70 r0 = defpackage.h70.u8
            r14 = r20
            r13.Q(r0, r14)
            if (r4 <= 0) goto L_0x00a6
            h70 r0 = defpackage.h70.X8
            int r9 = r4 + -1
            r9 = r3[r9]
            r13.Q(r0, r9)
        L_0x00a6:
            int r0 = r3.length
            int r0 = r0 - r10
            if (r4 >= r0) goto L_0x00b3
            h70 r0 = defpackage.h70.r7
            int r9 = r4 + 1
            r9 = r3[r9]
            r13.Q(r0, r9)
        L_0x00b3:
            h70 r0 = defpackage.h70.Zb
            n80 r9 = new n80
            java.lang.String r10 = "Title"
            java.lang.Object r10 = r6.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r15 = "UnicodeBig"
            r9.<init>(r10, r15)
            r13.Q(r0, r9)
            java.lang.String r0 = "Color"
            java.lang.Object r0 = r6.get(r0)
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0118
            x50 r0 = new x50     // Catch:{ Exception -> 0x0114 }
            r0.<init>()     // Catch:{ Exception -> 0x0114 }
            java.util.StringTokenizer r10 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x0114 }
            r10.<init>(r9)     // Catch:{ Exception -> 0x0114 }
            r15 = 0
        L_0x00dd:
            if (r15 >= r7) goto L_0x010a
            java.lang.String r16 = r10.nextToken()     // Catch:{ Exception -> 0x0114 }
            float r16 = java.lang.Float.parseFloat(r16)     // Catch:{ Exception -> 0x0114 }
            r17 = 0
            int r17 = (r16 > r17 ? 1 : (r16 == r17 ? 0 : -1))
            if (r17 >= 0) goto L_0x00ef
            r16 = 0
        L_0x00ef:
            r17 = 1065353216(0x3f800000, float:1.0)
            int r17 = (r16 > r17 ? 1 : (r16 == r17 ? 0 : -1))
            if (r17 <= 0) goto L_0x00f7
            r16 = 1065353216(0x3f800000, float:1.0)
        L_0x00f7:
            r7 = r16
            r16 = r5
            k70 r5 = new k70     // Catch:{ Exception -> 0x0112 }
            r5.<init>((float) r7)     // Catch:{ Exception -> 0x0112 }
            r0.I(r5)     // Catch:{ Exception -> 0x0112 }
            int r15 = r15 + 1
            r5 = r16
            r7 = 3
            goto L_0x00dd
        L_0x010a:
            r16 = r5
            h70 r5 = defpackage.h70.B0     // Catch:{ Exception -> 0x0112 }
            r13.Q(r5, r0)     // Catch:{ Exception -> 0x0112 }
            goto L_0x0117
        L_0x0112:
            r0 = move-exception
            goto L_0x0117
        L_0x0114:
            r0 = move-exception
            r16 = r5
        L_0x0117:
            goto L_0x011a
        L_0x0118:
            r16 = r5
        L_0x011a:
            java.lang.String r0 = "Style"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0149
            java.lang.String r0 = r0.toLowerCase()
            r5 = 0
            java.lang.String r7 = "italic"
            int r7 = r0.indexOf(r7)
            if (r7 < 0) goto L_0x0133
            r5 = r5 | 1
        L_0x0133:
            java.lang.String r7 = "bold"
            int r7 = r0.indexOf(r7)
            if (r7 < 0) goto L_0x013d
            r5 = r5 | 2
        L_0x013d:
            if (r5 == 0) goto L_0x0149
            h70 r7 = defpackage.h70.w3
            k70 r10 = new k70
            r10.<init>((int) r5)
            r13.Q(r7, r10)
        L_0x0149:
            a(r13, r6, r1, r2)
            r5 = r3[r4]
            r1.z(r13, r5)
            int r4 = r4 + 1
            r0 = r8
            r5 = r16
            goto L_0x0022
        L_0x0158:
            r16 = r5
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = r3[r9]
            r5[r9] = r6
            int r6 = r3.length
            int r6 = r6 - r10
            r6 = r3[r6]
            r5[r10] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r5[r8] = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl0.b(v80, z60, java.util.List, boolean):java.lang.Object[]");
    }
}
