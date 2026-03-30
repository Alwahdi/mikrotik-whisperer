package defpackage;

import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.util.ArrayList;

/* renamed from: i50  reason: default package */
public class i50 {
    public static final int a = qb0.f4807b.size();

    public ArrayList<UsermanagerCards> a(int currentPage, int item_per_pages) {
        int startItem = currentPage * item_per_pages;
        int lastItem = startItem + item_per_pages;
        ArrayList<UsermanagerCards> currentGalaxys = new ArrayList<>();
        int i = 0;
        while (i < qb0.f4807b.size()) {
            try {
                if (i >= startItem && i < lastItem) {
                    currentGalaxys.add(qb0.f4807b.get(i));
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return currentGalaxys;
    }
}
