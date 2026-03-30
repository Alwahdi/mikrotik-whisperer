package defpackage;

/* renamed from: av0  reason: default package */
public final class av0 {
    private static av0 a = null;
    public static String e = " (AGPL-version)";

    /* renamed from: a  reason: collision with other field name */
    private String f123a = "iText®";
    private String b = "5.5.13";
    private String c = (this.f123a + " " + this.b + " ©2000-2018 iText Group NV");
    private String d = null;

    public static av0 a() {
        if (a == null) {
            av0 av0 = new av0();
            a = av0;
            synchronized (av0) {
                try {
                    Class<?> klass = Class.forName("com.itextpdf.licensekey.LicenseKey");
                    String[] info = (String[]) klass.getMethod("getLicenseeInfoForVersion", new Class[]{String.class}).invoke(klass.newInstance(), new Object[]{a.b});
                    if (info[3] == null || info[3].trim().length() <= 0) {
                        a.d = "Trial version ";
                        if (info[5] == null) {
                            StringBuilder sb = new StringBuilder();
                            av0 av02 = a;
                            sb.append(av02.d);
                            sb.append("unauthorised");
                            av02.d = sb.toString();
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            av0 av03 = a;
                            sb2.append(av03.d);
                            sb2.append(info[5]);
                            av03.d = sb2.toString();
                        }
                    } else {
                        a.d = info[3];
                    }
                    if (info[4] != null && info[4].trim().length() > 0) {
                        a.c = info[4];
                    } else if (info[2] != null && info[2].trim().length() > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        av0 av04 = a;
                        sb3.append(av04.c);
                        sb3.append(" (");
                        sb3.append(info[2]);
                        av04.c = sb3.toString();
                        if (!a.d.toLowerCase().startsWith("trial")) {
                            StringBuilder sb4 = new StringBuilder();
                            av0 av05 = a;
                            sb4.append(av05.c);
                            sb4.append("; licensed version)");
                            av05.c = sb4.toString();
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            av0 av06 = a;
                            sb5.append(av06.c);
                            sb5.append("; ");
                            sb5.append(a.d);
                            sb5.append(")");
                            av06.c = sb5.toString();
                        }
                    } else if (info[0] == null || info[0].trim().length() <= 0) {
                        throw new Exception();
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        av0 av07 = a;
                        sb6.append(av07.c);
                        sb6.append(" (");
                        sb6.append(info[0]);
                        av07.c = sb6.toString();
                        if (!a.d.toLowerCase().startsWith("trial")) {
                            StringBuilder sb7 = new StringBuilder();
                            av0 av08 = a;
                            sb7.append(av08.c);
                            sb7.append("; licensed version)");
                            av08.c = sb7.toString();
                        } else {
                            StringBuilder sb8 = new StringBuilder();
                            av0 av09 = a;
                            sb8.append(av09.c);
                            sb8.append("; ");
                            sb8.append(a.d);
                            sb8.append(")");
                            av09.c = sb8.toString();
                        }
                    }
                } catch (Exception e2) {
                    StringBuilder sb9 = new StringBuilder();
                    av0 av010 = a;
                    sb9.append(av010.c);
                    sb9.append(e);
                    av010.c = sb9.toString();
                }
            }
        }
        return a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public static boolean e() {
        return a().d().indexOf(e) > 0;
    }
}
