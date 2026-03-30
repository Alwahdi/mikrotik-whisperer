package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;

/* renamed from: ip0  reason: default package */
public class ip0 extends FragmentStateAdapter {
    private ArrayList<Fragment> a = new ArrayList<>();

    public ip0(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new y2();
            case 1:
                return new j0();
            case 2:
                return new kw0();
            case 3:
                return new yu();
            case 4:
                return new bf0();
            default:
                return null;
        }
    }

    public int getItemCount() {
        return 5;
    }
}
