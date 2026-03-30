package defpackage;

import androidx.core.os.EnvironmentCompat;
import com.itextpdf.text.a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: j10  reason: default package */
public class j10 implements bi {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final StringBuffer f4026a;

    j10(int type, String content) {
        this.a = type;
        this.f4026a = new StringBuffer(content);
    }

    public boolean a(ci listener) {
        try {
            return listener.c(this);
        } catch (ih e) {
            return false;
        }
    }

    public int v() {
        return this.a;
    }

    public List<a> t() {
        return new ArrayList();
    }

    public boolean r() {
        return false;
    }

    public String b() {
        return this.f4026a.toString();
    }

    public String c() {
        switch (this.a) {
            case 1:
                return "title";
            case 2:
                return "subject";
            case 3:
                return "keywords";
            case 4:
                return "author";
            case 5:
                return "producer";
            case 6:
                return "creationdate";
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }
}
