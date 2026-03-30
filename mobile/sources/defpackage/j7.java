package defpackage;

import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.a;
import com.itextpdf.text.pdf.b;
import java.util.ArrayList;

/* renamed from: j7  reason: default package */
public abstract class j7 {
    private static final h70 a = new h70("CMapName");

    public static void a(String cmapName, g cmap, q8 location) {
        b(cmapName, cmap, location, 0);
    }

    private static void b(String cmapName, g cmap, q8 location, int level) {
        if (level < 10) {
            a inp = location.a(cmapName);
            try {
                ArrayList<PdfObject> list = new ArrayList<>();
                b cp = new b(inp);
                int maxExc = 50;
                while (true) {
                    try {
                        cp.b(list);
                        if (list.isEmpty()) {
                            break;
                        }
                        String last = ((o70) list.get(list.size() - 1)).toString();
                        if (level == 0 && list.size() == 3 && last.equals("def")) {
                            o70 key = (o70) list.get(0);
                            if (h70.H9.equals(key)) {
                                cmap.l(((o70) list.get(1)).toString());
                            } else if (h70.b8.equals(key)) {
                                cmap.k(((o70) list.get(1)).toString());
                            } else if (a.equals(key)) {
                                cmap.j(((o70) list.get(1)).toString());
                            } else if (h70.vb.equals(key)) {
                                try {
                                    cmap.m(((k70) list.get(1)).J());
                                } catch (Exception e) {
                                }
                            }
                        } else if ((last.equals("endcidchar") || last.equals("endbfchar")) && list.size() >= 3) {
                            int lmax = list.size() - 2;
                            for (int k = 0; k < lmax; k += 2) {
                                if (list.get(k) instanceof n80) {
                                    cmap.a((n80) list.get(k), (o70) list.get(k + 1));
                                }
                            }
                        } else if ((last.equals("endcidrange") || last.equals("endbfrange")) && list.size() >= 4) {
                            int lmax2 = list.size() - 3;
                            for (int k2 = 0; k2 < lmax2; k2 += 3) {
                                if ((list.get(k2) instanceof n80) && (list.get(k2 + 1) instanceof n80)) {
                                    cmap.b((n80) list.get(k2), (n80) list.get(k2 + 1), (o70) list.get(k2 + 2));
                                }
                            }
                        } else if (last.equals("usecmap") && list.size() == 2 && (list.get(0) instanceof h70)) {
                            b(h70.I(((o70) list.get(0)).toString()), cmap, location, level + 1);
                        }
                    } catch (Exception e2) {
                        maxExc--;
                        if (maxExc < 0) {
                            break;
                        }
                    }
                }
            } finally {
                inp.b();
            }
        }
    }
}
