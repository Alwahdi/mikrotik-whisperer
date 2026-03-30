package defpackage;

import com.itextpdf.text.pdf.PdfIndirectReference;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: b80  reason: default package */
public class b80 {
    private int a = 10;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<z60> f213a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private v80 f214a;

    /* renamed from: a  reason: collision with other field name */
    private z60 f215a;
    private ArrayList<z60> b = new ArrayList<>();

    b80(v80 writer) {
        this.f214a = writer;
    }

    /* access modifiers changed from: package-private */
    public void a(j60 page) {
        try {
            if (this.f213a.size() % this.a == 0) {
                this.b.add(this.f214a.m0());
            }
            ArrayList<z60> arrayList = this.b;
            page.Q(h70.u8, arrayList.get(arrayList.size() - 1));
            z60 current = this.f214a.V();
            this.f214a.z(page, current);
            this.f213a.add(current);
        } catch (Exception e) {
            throw new mj(e);
        }
    }

    /* access modifiers changed from: package-private */
    public z60 b() {
        int count;
        if (!this.f213a.isEmpty()) {
            int leaf = 1;
            ArrayList<z60> arrayList = this.b;
            ArrayList<z60> arrayList2 = this.f213a;
            ArrayList<PdfIndirectReference> nextParents = new ArrayList<>();
            while (true) {
                leaf *= this.a;
                int stdCount = this.a;
                int rightCount = arrayList2.size() % this.a;
                if (rightCount == 0) {
                    rightCount = this.a;
                }
                for (int p = 0; p < arrayList.size(); p++) {
                    int thisLeaf = leaf;
                    if (p == arrayList.size() - 1) {
                        count = rightCount;
                        thisLeaf = this.f213a.size() % leaf;
                        if (thisLeaf == 0) {
                            thisLeaf = leaf;
                        }
                    } else {
                        count = stdCount;
                    }
                    j60 top = new j60(h70.q8);
                    top.Q(h70.G1, new k70(thisLeaf));
                    x50 kids = new x50();
                    kids.N().addAll(arrayList2.subList(p * stdCount, (p * stdCount) + count));
                    top.Q(h70.Z5, kids);
                    if (arrayList.size() > 1) {
                        if (p % this.a == 0) {
                            nextParents.add(this.f214a.m0());
                        }
                        top.Q(h70.u8, (o70) nextParents.get(p / this.a));
                    }
                    this.f214a.z(top, arrayList.get(p));
                }
                if (arrayList.size() == 1) {
                    z60 z60 = arrayList.get(0);
                    this.f215a = z60;
                    return z60;
                }
                arrayList2 = arrayList;
                arrayList = nextParents;
                nextParents = new ArrayList<>();
            }
        } else {
            throw new IOException(i10.b("the.document.has.no.pages", new Object[0]));
        }
    }
}
