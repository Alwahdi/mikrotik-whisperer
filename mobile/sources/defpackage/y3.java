package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: y3  reason: default package */
public class y3 {
    private final Pattern a;

    public y3(String[] tokens) {
        this.a = Pattern.compile(a(tokens));
    }

    public String[] b(String text) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = this.a.matcher(text);
        int endIndexOfpreviousMatch = 0;
        while (matcher.find()) {
            String previousToken = text.substring(endIndexOfpreviousMatch, matcher.start());
            if (previousToken.length() > 0) {
                tokens.add(previousToken);
            }
            tokens.add(matcher.group());
            endIndexOfpreviousMatch = matcher.end();
        }
        String tail = text.substring(endIndexOfpreviousMatch, text.length());
        if (tail.length() > 0) {
            tokens.add(tail);
        }
        return (String[]) tokens.toArray(new String[0]);
    }

    private String a(String[] tokens) {
        StringBuilder regexBuilder = new StringBuilder(100);
        for (String token : tokens) {
            regexBuilder.append("(");
            regexBuilder.append(token);
            regexBuilder.append(")|");
        }
        regexBuilder.setLength(regexBuilder.length() - 1);
        return regexBuilder.toString();
    }
}
