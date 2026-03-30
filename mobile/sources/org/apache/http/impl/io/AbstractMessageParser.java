package org.apache.http.impl.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractMessageParser implements HttpMessageParser {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List headerLines;
    protected final LineParser lineParser;
    private final int maxHeaderCount;
    private final int maxLineLen;
    private HttpMessage message;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    /* access modifiers changed from: protected */
    public abstract HttpMessage parseHead(SessionInputBuffer sessionInputBuffer) throws IOException, HttpException, ParseException;

    public AbstractMessageParser(SessionInputBuffer buffer, LineParser parser, HttpParams params) {
        if (buffer == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        } else if (params != null) {
            this.sessionBuffer = buffer;
            this.maxHeaderCount = params.getIntParameter(CoreConnectionPNames.MAX_HEADER_COUNT, -1);
            this.maxLineLen = params.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
            this.lineParser = parser != null ? parser : BasicLineParser.DEFAULT;
            this.headerLines = new ArrayList();
            this.state = 0;
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }

    public static Header[] parseHeaders(SessionInputBuffer inbuffer, int maxHeaderCount2, int maxLineLen2, LineParser parser) throws HttpException, IOException {
        if (parser == null) {
            parser = BasicLineParser.DEFAULT;
        }
        return parseHeaders(inbuffer, maxHeaderCount2, maxLineLen2, parser, new ArrayList());
    }

    public static Header[] parseHeaders(SessionInputBuffer inbuffer, int maxHeaderCount2, int maxLineLen2, LineParser parser, List headerLines2) throws HttpException, IOException {
        if (inbuffer == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        } else if (parser == null) {
            throw new IllegalArgumentException("Line parser may not be null");
        } else if (headerLines2 != null) {
            CharArrayBuffer current = null;
            CharArrayBuffer previous = null;
            while (true) {
                if (current == null) {
                    current = new CharArrayBuffer(64);
                } else {
                    current.clear();
                }
                if (inbuffer.readLine(current) == -1 || current.length() < 1) {
                    Header[] headers = new Header[headerLines2.size()];
                    int i = 0;
                } else {
                    if ((current.charAt(0) == ' ' || current.charAt(0) == 9) && previous != null) {
                        int i2 = 0;
                        while (i2 < current.length() && ((ch = current.charAt(i2)) == ' ' || ch == 9)) {
                            i2++;
                        }
                        if (maxLineLen2 <= 0 || ((previous.length() + 1) + current.length()) - i2 <= maxLineLen2) {
                            previous.append(' ');
                            previous.append(current, i2, current.length() - i2);
                        } else {
                            throw new IOException("Maximum line length limit exceeded");
                        }
                    } else {
                        headerLines2.add(current);
                        previous = current;
                        current = null;
                    }
                    if (maxHeaderCount2 > 0 && headerLines2.size() >= maxHeaderCount2) {
                        throw new IOException("Maximum header count exceeded");
                    }
                }
            }
            Header[] headers2 = new Header[headerLines2.size()];
            int i3 = 0;
            while (i3 < headerLines2.size()) {
                try {
                    headers2[i3] = parser.parseHeader((CharArrayBuffer) headerLines2.get(i3));
                    i3++;
                } catch (ParseException ex) {
                    throw new ProtocolException(ex.getMessage());
                }
            }
            return headers2;
        } else {
            throw new IllegalArgumentException("Header line list may not be null");
        }
    }

    public HttpMessage parse() throws IOException, HttpException {
        switch (this.state) {
            case 0:
                try {
                    this.message = parseHead(this.sessionBuffer);
                    this.state = 1;
                    break;
                } catch (ParseException px) {
                    throw new ProtocolException(px.getMessage(), px);
                }
            case 1:
                break;
            default:
                throw new IllegalStateException("Inconsistent parser state");
        }
        this.message.setHeaders(parseHeaders(this.sessionBuffer, this.maxHeaderCount, this.maxLineLen, this.lineParser, this.headerLines));
        HttpMessage result = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return result;
    }
}
