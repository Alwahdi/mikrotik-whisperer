package defpackage;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* renamed from: j40  reason: default package */
public final class j40 implements HostnameVerifier {
    public static final j40 a = new j40();

    /* renamed from: a  reason: collision with other field name */
    private static final Pattern f4029a = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private j40() {
    }

    public boolean verify(String host, SSLSession session) {
        try {
            return b(host, (X509Certificate) session.getPeerCertificates()[0]);
        } catch (SSLException e) {
            return false;
        }
    }

    public boolean b(String host, X509Certificate certificate) {
        if (c(host)) {
            return f(host, certificate);
        }
        return e(host, certificate);
    }

    static boolean c(String host) {
        return f4029a.matcher(host).matches();
    }

    private boolean f(String ipAddress, X509Certificate certificate) {
        List<String> altNames = a(certificate, 7);
        int size = altNames.size();
        for (int i = 0; i < size; i++) {
            if (ipAddress.equalsIgnoreCase(altNames.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean e(String hostName, X509Certificate certificate) {
        String cn;
        String hostName2 = hostName.toLowerCase(Locale.US);
        boolean hasDns = false;
        List<String> altNames = a(certificate, 2);
        int size = altNames.size();
        for (int i = 0; i < size; i++) {
            hasDns = true;
            if (d(hostName2, altNames.get(i))) {
                return true;
            }
        }
        if (hasDns || (cn = new dh(certificate.getSubjectX500Principal()).b("cn")) == null) {
            return false;
        }
        return d(hostName2, cn);
    }

    private static List<String> a(X509Certificate certificate, int type) {
        String altName;
        List<String> result = new ArrayList<>();
        try {
            Collection<List<?>> subjectAlternativeNames = certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> entry : subjectAlternativeNames) {
                if (entry != null) {
                    if (entry.size() >= 2) {
                        Integer altNameType = (Integer) entry.get(0);
                        if (altNameType != null) {
                            if (altNameType.intValue() == type && (altName = (String) entry.get(1)) != null) {
                                result.add(altName);
                            }
                        }
                    }
                }
            }
            return result;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    private boolean d(String hostName, String pattern) {
        if (hostName == null || hostName.length() == 0 || hostName.startsWith(".") || hostName.endsWith("..") || pattern == null || pattern.length() == 0 || pattern.startsWith(".") || pattern.endsWith("..")) {
            return false;
        }
        if (!hostName.endsWith(".")) {
            hostName = hostName + '.';
        }
        if (!pattern.endsWith(".")) {
            pattern = pattern + '.';
        }
        String pattern2 = pattern.toLowerCase(Locale.US);
        if (!pattern2.contains("*")) {
            return hostName.equals(pattern2);
        }
        if (!pattern2.startsWith("*.") || pattern2.indexOf(42, 1) != -1 || hostName.length() < pattern2.length() || "*.".equals(pattern2)) {
            return false;
        }
        String suffix = pattern2.substring(1);
        if (!hostName.endsWith(suffix)) {
            return false;
        }
        int suffixStartIndexInHostName = hostName.length() - suffix.length();
        if (suffixStartIndexInHostName <= 0 || hostName.lastIndexOf(46, suffixStartIndexInHostName - 1) == -1) {
            return true;
        }
        return false;
    }
}
