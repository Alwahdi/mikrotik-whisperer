package defpackage;

/* renamed from: g70  reason: default package */
public class g70 extends j60 {
    g70(String file, q60 fs, String mimeType) {
        Q(h70.Bc, new h70("MediaClip"));
        Q(h70.ta, new h70("MCD"));
        h70 h70 = h70.b7;
        Q(h70, new n80("Media clip for " + file));
        Q(new h70("CT"), new n80(mimeType));
        j60 dic = new j60();
        dic.Q(new h70("TF"), new n80("TEMPACCESS"));
        Q(new h70("P"), dic);
        Q(h70.W1, fs.X());
    }
}
