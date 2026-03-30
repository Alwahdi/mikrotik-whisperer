package org.apache.http.impl.cookie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.http.annotation.Immutable;

@Immutable
public class PublicSuffixListParser {
    private static final int MAX_LINE_LEN = 256;
    private final PublicSuffixFilter filter;

    PublicSuffixListParser(PublicSuffixFilter filter2) {
        this.filter = filter2;
    }

    public void parse(Reader list) throws IOException {
        Collection<String> rules = new ArrayList<>();
        Collection<String> exceptions = new ArrayList<>();
        BufferedReader r = new BufferedReader(list);
        StringBuilder sb = new StringBuilder(256);
        boolean more = true;
        while (more) {
            more = readLine(r, sb);
            String line = sb.toString();
            if (line.length() != 0 && !line.startsWith("//")) {
                if (line.startsWith(".")) {
                    line = line.substring(1);
                }
                boolean isException = line.startsWith("!");
                if (isException) {
                    line = line.substring(1);
                }
                if (isException) {
                    exceptions.add(line);
                } else {
                    rules.add(line);
                }
            }
        }
        this.filter.setPublicSuffixes(rules);
        this.filter.setExceptions(exceptions);
    }

    private boolean readLine(Reader r, StringBuilder sb) throws IOException {
        char c;
        sb.setLength(0);
        boolean hitWhitespace = false;
        do {
            int read = r.read();
            int b = read;
            if (read != -1 && (c = (char) b) != 10) {
                if (Character.isWhitespace(c)) {
                    hitWhitespace = true;
                }
                if (!hitWhitespace) {
                    sb.append(c);
                }
            } else if (b != -1) {
                return true;
            } else {
                return false;
            }
        } while (sb.length() <= 256);
        throw new IOException("Line too long");
    }
}
