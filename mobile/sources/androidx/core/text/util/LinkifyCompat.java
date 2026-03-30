package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR = a.a;
    private static final String[] EMPTY_STRING = new String[0];

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(LinkSpec a, LinkSpec b) {
        int i = a.start;
        int i2 = b.start;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return Integer.compare(b.end, a.end);
    }

    public static boolean addLinks(@NonNull Spannable text, int mask) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(text, mask);
        }
        if (mask == 0) {
            return false;
        }
        URLSpan[] old = (URLSpan[]) text.getSpans(0, text.length(), URLSpan.class);
        for (int i = old.length - 1; i >= 0; i--) {
            text.removeSpan(old[i]);
        }
        if ((mask & 4) != 0) {
            Linkify.addLinks(text, 4);
        }
        ArrayList<LinkSpec> links = new ArrayList<>();
        if ((mask & 1) != 0) {
            gatherLinks(links, text, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, (Linkify.TransformFilter) null);
        }
        if ((mask & 2) != 0) {
            gatherLinks(links, text, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
        if ((mask & 8) != 0) {
            gatherMapLinks(links, text);
        }
        pruneOverlaps(links, text);
        if (links.size() == 0) {
            return false;
        }
        Iterator<LinkSpec> it = links.iterator();
        while (it.hasNext()) {
            LinkSpec link = it.next();
            if (link.frameworkAddedSpan == null) {
                applyLink(link.url, link.start, link.end, text);
            }
        }
        return true;
    }

    public static boolean addLinks(@NonNull TextView text, int mask) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(text, mask);
        }
        if (mask == 0) {
            return false;
        }
        CharSequence t = text.getText();
        if (!(t instanceof Spannable)) {
            SpannableString s = SpannableString.valueOf(t);
            if (addLinks((Spannable) s, mask)) {
                addLinkMovementMethod(text);
                text.setText(s);
                return true;
            }
        } else if (addLinks((Spannable) t, mask)) {
            addLinkMovementMethod(text);
            return true;
        }
        return false;
    }

    public static void addLinks(@NonNull TextView text, @NonNull Pattern pattern, @Nullable String scheme) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(text, pattern, scheme);
        } else {
            addLinks(text, pattern, scheme, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void addLinks(@NonNull TextView text, @NonNull Pattern pattern, @Nullable String scheme, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(text, pattern, scheme, matchFilter, transformFilter);
        } else {
            addLinks(text, pattern, scheme, (String[]) null, matchFilter, transformFilter);
        }
    }

    public static void addLinks(@NonNull TextView text, @NonNull Pattern pattern, @Nullable String defaultScheme, @Nullable String[] schemes, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Api24Impl.addLinks(text, pattern, defaultScheme, schemes, matchFilter, transformFilter);
            return;
        }
        SpannableString spannable = SpannableString.valueOf(text.getText());
        if (addLinks((Spannable) spannable, pattern, defaultScheme, schemes, matchFilter, transformFilter)) {
            text.setText(spannable);
            addLinkMovementMethod(text);
        }
    }

    public static boolean addLinks(@NonNull Spannable text, @NonNull Pattern pattern, @Nullable String scheme) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(text, pattern, scheme);
        }
        return addLinks(text, pattern, scheme, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String scheme, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, scheme, matchFilter, transformFilter);
        }
        return addLinks(spannable, pattern, scheme, (String[]) null, matchFilter, transformFilter);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String defaultScheme, @Nullable String[] schemes, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            return Api24Impl.addLinks(spannable, pattern, defaultScheme, schemes, matchFilter, transformFilter);
        }
        if (defaultScheme == null) {
            defaultScheme = "";
        }
        if (schemes == null || schemes.length < 1) {
            schemes = EMPTY_STRING;
        }
        String[] schemesCopy = new String[(schemes.length + 1)];
        schemesCopy[0] = defaultScheme.toLowerCase(Locale.ROOT);
        for (int index = 0; index < schemes.length; index++) {
            String scheme = schemes[index];
            schemesCopy[index + 1] = scheme == null ? "" : scheme.toLowerCase(Locale.ROOT);
        }
        boolean hasMatches = false;
        Matcher m = pattern.matcher(spannable);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            String match = m.group(0);
            boolean allowed = true;
            if (matchFilter != null) {
                allowed = matchFilter.acceptMatch(spannable, start, end);
            }
            if (allowed && match != null) {
                applyLink(makeUrl(match, schemesCopy, m, transformFilter), start, end, spannable);
                hasMatches = true;
            }
        }
        return hasMatches;
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        return Build.VERSION.SDK_INT >= 28;
    }

    private static void addLinkMovementMethod(@NonNull TextView t) {
        if (!(t.getMovementMethod() instanceof LinkMovementMethod) && t.getLinksClickable()) {
            t.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private static String makeUrl(@NonNull String url, @NonNull String[] prefixes, Matcher matcher, @Nullable Linkify.TransformFilter filter) {
        if (filter != null) {
            url = filter.transformUrl(matcher, url);
        }
        boolean hasPrefix = false;
        int length = prefixes.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String prefix = prefixes[i];
            if (url.regionMatches(true, 0, prefix, 0, prefix.length())) {
                hasPrefix = true;
                if (!url.regionMatches(false, 0, prefix, 0, prefix.length())) {
                    url = prefix + url.substring(prefix.length());
                }
            } else {
                i++;
            }
        }
        if (hasPrefix || prefixes.length <= 0) {
            return url;
        }
        return prefixes[0] + url;
    }

    private static void gatherLinks(ArrayList<LinkSpec> links, Spannable s, Pattern pattern, String[] schemes, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            String match = m.group(0);
            if ((matchFilter == null || matchFilter.acceptMatch(s, start, end)) && match != null) {
                LinkSpec spec = new LinkSpec();
                spec.url = makeUrl(match, schemes, m, transformFilter);
                spec.start = start;
                spec.end = end;
                links.add(spec);
            }
        }
    }

    private static void applyLink(String url, int start, int end, Spannable text) {
        text.setSpan(new URLSpan(url), start, end, 33);
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> links, Spannable s) {
        String string = s.toString();
        int base = 0;
        while (true) {
            try {
                String findAddress = findAddress(string);
                String address = findAddress;
                if (findAddress != null) {
                    int start = string.indexOf(address);
                    if (start >= 0) {
                        LinkSpec spec = new LinkSpec();
                        int end = start + address.length();
                        spec.start = base + start;
                        spec.end = base + end;
                        string = string.substring(end);
                        base += end;
                        try {
                            String encodedAddress = URLEncoder.encode(address, HTTP.UTF_8);
                            spec.url = "geo:0,0?q=" + encodedAddress;
                            links.add(spec);
                        } catch (UnsupportedEncodingException e) {
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } catch (UnsupportedOperationException e2) {
                return;
            }
        }
    }

    private static String findAddress(String addr) {
        if (Build.VERSION.SDK_INT >= 28) {
            return WebView.findAddress(addr);
        }
        return FindAddress.findAddress(addr);
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> links, Spannable text) {
        int i;
        for (URLSpan urlSpan : (URLSpan[]) text.getSpans(0, text.length(), URLSpan.class)) {
            LinkSpec spec = new LinkSpec();
            spec.frameworkAddedSpan = urlSpan;
            spec.start = text.getSpanStart(urlSpan);
            spec.end = text.getSpanEnd(urlSpan);
            links.add(spec);
        }
        Collections.sort(links, COMPARATOR);
        int len = links.size();
        int i2 = 0;
        while (i2 < len - 1) {
            LinkSpec a = links.get(i2);
            LinkSpec b = links.get(i2 + 1);
            int remove = -1;
            int i3 = a.start;
            int i4 = b.start;
            if (i3 <= i4 && (i = a.end) > i4) {
                int i5 = b.end;
                if (i5 <= i) {
                    remove = i2 + 1;
                } else if (i - i3 > i5 - i4) {
                    remove = i2 + 1;
                } else if (i - i3 < i5 - i4) {
                    remove = i2;
                }
                if (remove != -1) {
                    URLSpan span = links.get(remove).frameworkAddedSpan;
                    if (span != null) {
                        text.removeSpan(span);
                    }
                    links.remove(remove);
                    len--;
                }
            }
            i2++;
        }
    }

    private LinkifyCompat() {
    }

    private static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void addLinks(TextView text, Pattern pattern, String defaultScheme, String[] schemes, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            Linkify.addLinks(text, pattern, defaultScheme, schemes, matchFilter, transformFilter);
        }

        @DoNotInline
        static boolean addLinks(Spannable spannable, Pattern pattern, String defaultScheme, String[] schemes, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks(spannable, pattern, defaultScheme, schemes, matchFilter, transformFilter);
        }
    }
}
