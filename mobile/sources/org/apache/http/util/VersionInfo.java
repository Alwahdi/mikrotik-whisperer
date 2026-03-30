package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    protected VersionInfo(String pckg, String module, String release, String time, String clsldr) {
        if (pckg != null) {
            this.infoPackage = pckg;
            String str = UNAVAILABLE;
            this.infoModule = module != null ? module : str;
            this.infoRelease = release != null ? release : str;
            this.infoTimestamp = time != null ? time : str;
            this.infoClassloader = clsldr != null ? clsldr : str;
            return;
        }
        throw new IllegalArgumentException("Package identifier must not be null.");
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(this.infoPackage.length() + 20 + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length());
        sb.append("VersionInfo(");
        sb.append(this.infoPackage);
        sb.append(':');
        sb.append(this.infoModule);
        if (!UNAVAILABLE.equals(this.infoRelease)) {
            sb.append(':');
            sb.append(this.infoRelease);
        }
        if (!UNAVAILABLE.equals(this.infoTimestamp)) {
            sb.append(':');
            sb.append(this.infoTimestamp);
        }
        sb.append(')');
        if (!UNAVAILABLE.equals(this.infoClassloader)) {
            sb.append('@');
            sb.append(this.infoClassloader);
        }
        return sb.toString();
    }

    public static final VersionInfo[] loadVersionInfo(String[] pckgs, ClassLoader clsldr) {
        if (pckgs != null) {
            ArrayList vil = new ArrayList(pckgs.length);
            for (String loadVersionInfo : pckgs) {
                VersionInfo vi = loadVersionInfo(loadVersionInfo, clsldr);
                if (vi != null) {
                    vil.add(vi);
                }
            }
            return (VersionInfo[]) vil.toArray(new VersionInfo[vil.size()]);
        }
        throw new IllegalArgumentException("Package identifier list must not be null.");
    }

    public static final VersionInfo loadVersionInfo(String pckg, ClassLoader clsldr) {
        InputStream is;
        if (pckg != null) {
            if (clsldr == null) {
                clsldr = Thread.currentThread().getContextClassLoader();
            }
            Properties vip = null;
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(pckg.replace('.', '/'));
                stringBuffer.append("/");
                stringBuffer.append(VERSION_PROPERTY_FILE);
                is = clsldr.getResourceAsStream(stringBuffer.toString());
                if (is != null) {
                    Properties props = new Properties();
                    props.load(is);
                    vip = props;
                    is.close();
                }
            } catch (IOException e) {
            } catch (Throwable th) {
                is.close();
                throw th;
            }
            if (vip != null) {
                return fromMap(pckg, vip, clsldr);
            }
            return null;
        }
        throw new IllegalArgumentException("Package identifier must not be null.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static final org.apache.http.util.VersionInfo fromMap(java.lang.String r11, java.util.Map r12, java.lang.ClassLoader r13) {
        /*
            if (r11 == 0) goto L_0x0064
            r0 = 0
            r1 = 0
            r2 = 0
            if (r12 == 0) goto L_0x004e
            java.lang.String r3 = "info.module"
            java.lang.Object r3 = r12.get(r3)
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
            r3 = 1
            if (r0 == 0) goto L_0x001a
            int r4 = r0.length()
            if (r4 >= r3) goto L_0x001a
            r0 = 0
        L_0x001a:
            java.lang.String r4 = "info.release"
            java.lang.Object r4 = r12.get(r4)
            r1 = r4
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0034
            int r4 = r1.length()
            if (r4 < r3) goto L_0x0033
            java.lang.String r4 = "${pom.version}"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            java.lang.String r4 = "info.timestamp"
            java.lang.Object r4 = r12.get(r4)
            r2 = r4
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x004e
            int r4 = r2.length()
            if (r4 < r3) goto L_0x004d
            java.lang.String r3 = "${mvn.timestamp}"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x004e
        L_0x004d:
            r2 = 0
        L_0x004e:
            r3 = 0
            if (r13 == 0) goto L_0x0057
            java.lang.String r3 = r13.toString()
            r9 = r3
            goto L_0x0058
        L_0x0057:
            r9 = r3
        L_0x0058:
            org.apache.http.util.VersionInfo r10 = new org.apache.http.util.VersionInfo
            r3 = r10
            r4 = r11
            r5 = r0
            r6 = r1
            r7 = r2
            r8 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        L_0x0064:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Package identifier must not be null."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.util.VersionInfo.fromMap(java.lang.String, java.util.Map, java.lang.ClassLoader):org.apache.http.util.VersionInfo");
    }
}
