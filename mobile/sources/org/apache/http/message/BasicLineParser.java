package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public class BasicLineParser implements LineParser {
    public static final BasicLineParser DEFAULT = new BasicLineParser();
    protected final ProtocolVersion protocol;

    public BasicLineParser(ProtocolVersion proto) {
        this.protocol = proto == null ? HttpVersion.HTTP_1_1 : proto;
    }

    public BasicLineParser() {
        this((ProtocolVersion) null);
    }

    public static final ProtocolVersion parseProtocolVersion(String value, LineParser parser) throws ParseException {
        if (value != null) {
            if (parser == null) {
                parser = DEFAULT;
            }
            CharArrayBuffer buffer = new CharArrayBuffer(value.length());
            buffer.append(value);
            return parser.parseProtocolVersion(buffer, new ParserCursor(0, value.length()));
        }
        throw new IllegalArgumentException("Value to parse may not be null.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.http.ProtocolVersion parseProtocolVersion(org.apache.http.util.CharArrayBuffer r18, org.apache.http.message.ParserCursor r19) throws org.apache.http.ParseException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            if (r2 == 0) goto L_0x0115
            if (r3 == 0) goto L_0x010d
            org.apache.http.ProtocolVersion r0 = r1.protocol
            java.lang.String r4 = r0.getProtocol()
            int r5 = r4.length()
            int r6 = r19.getPos()
            int r7 = r19.getUpperBound()
            r17.skipWhitespace(r18, r19)
            int r0 = r19.getPos()
            int r8 = r0 + r5
            int r8 = r8 + 4
            java.lang.String r9 = "Not a valid protocol version: "
            if (r8 > r7) goto L_0x00f4
            r8 = 1
            r10 = 0
        L_0x002d:
            r11 = 0
            r12 = 1
            if (r8 == 0) goto L_0x0044
            if (r10 >= r5) goto L_0x0044
            int r13 = r0 + r10
            char r13 = r2.charAt(r13)
            char r14 = r4.charAt(r10)
            if (r13 != r14) goto L_0x0040
            r11 = 1
        L_0x0040:
            r8 = r11
            int r10 = r10 + 1
            goto L_0x002d
        L_0x0044:
            if (r8 == 0) goto L_0x0053
            int r10 = r0 + r5
            char r10 = r2.charAt(r10)
            r13 = 47
            if (r10 != r13) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r12 = 0
        L_0x0052:
            r8 = r12
        L_0x0053:
            if (r8 == 0) goto L_0x00db
            int r9 = r5 + 1
            int r9 = r9 + r0
            r0 = 46
            int r10 = r2.indexOf(r0, r9, r7)
            r0 = -1
            if (r10 == r0) goto L_0x00c0
            java.lang.String r12 = r2.substringTrimmed(r9, r10)     // Catch:{ NumberFormatException -> 0x00a4 }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ NumberFormatException -> 0x00a4 }
            int r9 = r10 + 1
            r13 = 32
            int r13 = r2.indexOf(r13, r9, r7)
            if (r13 != r0) goto L_0x0075
            r13 = r7
        L_0x0075:
            java.lang.String r0 = r2.substringTrimmed(r9, r13)     // Catch:{ NumberFormatException -> 0x0086 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0086 }
            r3.updatePos(r13)
            org.apache.http.ProtocolVersion r11 = r1.createProtocolVersion(r12, r0)
            return r11
        L_0x0086:
            r0 = move-exception
            org.apache.http.ParseException r14 = new org.apache.http.ParseException
            java.lang.StringBuffer r15 = new java.lang.StringBuffer
            r15.<init>()
            r16 = r0
            java.lang.String r0 = "Invalid protocol minor version number: "
            r15.append(r0)
            java.lang.String r0 = r2.substring(r6, r7)
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            r14.<init>(r0)
            throw r14
        L_0x00a4:
            r0 = move-exception
            org.apache.http.ParseException r12 = new org.apache.http.ParseException
            java.lang.StringBuffer r13 = new java.lang.StringBuffer
            r13.<init>()
            java.lang.String r14 = "Invalid protocol major version number: "
            r13.append(r14)
            java.lang.String r14 = r2.substring(r6, r7)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L_0x00c0:
            org.apache.http.ParseException r0 = new org.apache.http.ParseException
            java.lang.StringBuffer r11 = new java.lang.StringBuffer
            r11.<init>()
            java.lang.String r12 = "Invalid protocol version number: "
            r11.append(r12)
            java.lang.String r12 = r2.substring(r6, r7)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r0.<init>(r11)
            throw r0
        L_0x00db:
            org.apache.http.ParseException r10 = new org.apache.http.ParseException
            java.lang.StringBuffer r11 = new java.lang.StringBuffer
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = r2.substring(r6, r7)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        L_0x00f4:
            org.apache.http.ParseException r8 = new org.apache.http.ParseException
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            r10.append(r9)
            java.lang.String r9 = r2.substring(r6, r7)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L_0x010d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Parser cursor may not be null"
            r0.<init>(r4)
            throw r0
        L_0x0115:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Char array buffer may not be null"
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.message.BasicLineParser.parseProtocolVersion(org.apache.http.util.CharArrayBuffer, org.apache.http.message.ParserCursor):org.apache.http.ProtocolVersion");
    }

    /* access modifiers changed from: protected */
    public ProtocolVersion createProtocolVersion(int major, int minor) {
        return this.protocol.forVersion(major, minor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasProtocolVersion(org.apache.http.util.CharArrayBuffer r10, org.apache.http.message.ParserCursor r11) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x0077
            if (r11 == 0) goto L_0x006f
            int r0 = r11.getPos()
            org.apache.http.ProtocolVersion r1 = r9.protocol
            java.lang.String r1 = r1.getProtocol()
            int r2 = r1.length()
            int r3 = r10.length()
            int r4 = r2 + 4
            r5 = 0
            if (r3 >= r4) goto L_0x001c
            return r5
        L_0x001c:
            if (r0 >= 0) goto L_0x0027
            int r3 = r10.length()
            int r3 = r3 + -4
            int r0 = r3 - r2
            goto L_0x003c
        L_0x0027:
            if (r0 != 0) goto L_0x003c
        L_0x0029:
            int r3 = r10.length()
            if (r0 >= r3) goto L_0x003c
            char r3 = r10.charAt(r0)
            boolean r3 = org.apache.http.protocol.HTTP.isWhitespace(r3)
            if (r3 == 0) goto L_0x003c
            int r0 = r0 + 1
            goto L_0x0029
        L_0x003c:
            int r3 = r0 + r2
            int r3 = r3 + 4
            int r4 = r10.length()
            if (r3 <= r4) goto L_0x0047
            return r5
        L_0x0047:
            r3 = 1
            r4 = 0
        L_0x0049:
            r6 = 1
            if (r3 == 0) goto L_0x0060
            if (r4 >= r2) goto L_0x0060
            int r7 = r0 + r4
            char r7 = r10.charAt(r7)
            char r8 = r1.charAt(r4)
            if (r7 != r8) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r6 = 0
        L_0x005c:
            r3 = r6
            int r4 = r4 + 1
            goto L_0x0049
        L_0x0060:
            if (r3 == 0) goto L_0x006e
            int r4 = r0 + r2
            char r4 = r10.charAt(r4)
            r7 = 47
            if (r4 != r7) goto L_0x006d
            r5 = 1
        L_0x006d:
            r3 = r5
        L_0x006e:
            return r3
        L_0x006f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Parser cursor may not be null"
            r0.<init>(r1)
            throw r0
        L_0x0077:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Char array buffer may not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.message.BasicLineParser.hasProtocolVersion(org.apache.http.util.CharArrayBuffer, org.apache.http.message.ParserCursor):boolean");
    }

    public static final RequestLine parseRequestLine(String value, LineParser parser) throws ParseException {
        if (value != null) {
            if (parser == null) {
                parser = DEFAULT;
            }
            CharArrayBuffer buffer = new CharArrayBuffer(value.length());
            buffer.append(value);
            return parser.parseRequestLine(buffer, new ParserCursor(0, value.length()));
        }
        throw new IllegalArgumentException("Value to parse may not be null.");
    }

    public RequestLine parseRequestLine(CharArrayBuffer buffer, ParserCursor cursor) throws ParseException {
        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        } else if (cursor != null) {
            int indexFrom = cursor.getPos();
            int indexTo = cursor.getUpperBound();
            try {
                skipWhitespace(buffer, cursor);
                int i = cursor.getPos();
                int blank = buffer.indexOf(32, i, indexTo);
                if (blank >= 0) {
                    String method = buffer.substringTrimmed(i, blank);
                    cursor.updatePos(blank);
                    skipWhitespace(buffer, cursor);
                    int i2 = cursor.getPos();
                    int blank2 = buffer.indexOf(32, i2, indexTo);
                    if (blank2 >= 0) {
                        String uri = buffer.substringTrimmed(i2, blank2);
                        cursor.updatePos(blank2);
                        ProtocolVersion ver = parseProtocolVersion(buffer, cursor);
                        skipWhitespace(buffer, cursor);
                        if (cursor.atEnd()) {
                            return createRequestLine(method, uri, ver);
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Invalid request line: ");
                        stringBuffer.append(buffer.substring(indexFrom, indexTo));
                        throw new ParseException(stringBuffer.toString());
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Invalid request line: ");
                    stringBuffer2.append(buffer.substring(indexFrom, indexTo));
                    throw new ParseException(stringBuffer2.toString());
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Invalid request line: ");
                stringBuffer3.append(buffer.substring(indexFrom, indexTo));
                throw new ParseException(stringBuffer3.toString());
            } catch (IndexOutOfBoundsException e) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Invalid request line: ");
                stringBuffer4.append(buffer.substring(indexFrom, indexTo));
                throw new ParseException(stringBuffer4.toString());
            }
        } else {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public RequestLine createRequestLine(String method, String uri, ProtocolVersion ver) {
        return new BasicRequestLine(method, uri, ver);
    }

    public static final StatusLine parseStatusLine(String value, LineParser parser) throws ParseException {
        if (value != null) {
            if (parser == null) {
                parser = DEFAULT;
            }
            CharArrayBuffer buffer = new CharArrayBuffer(value.length());
            buffer.append(value);
            return parser.parseStatusLine(buffer, new ParserCursor(0, value.length()));
        }
        throw new IllegalArgumentException("Value to parse may not be null.");
    }

    public StatusLine parseStatusLine(CharArrayBuffer buffer, ParserCursor cursor) throws ParseException {
        String reasonPhrase;
        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        } else if (cursor != null) {
            int indexFrom = cursor.getPos();
            int indexTo = cursor.getUpperBound();
            try {
                ProtocolVersion ver = parseProtocolVersion(buffer, cursor);
                skipWhitespace(buffer, cursor);
                int i = cursor.getPos();
                int blank = buffer.indexOf(32, i, indexTo);
                if (blank < 0) {
                    blank = indexTo;
                }
                String s = buffer.substringTrimmed(i, blank);
                int j = 0;
                while (j < s.length()) {
                    if (Character.isDigit(s.charAt(j))) {
                        j++;
                    } else {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Status line contains invalid status code: ");
                        stringBuffer.append(buffer.substring(indexFrom, indexTo));
                        throw new ParseException(stringBuffer.toString());
                    }
                }
                int statusCode = Integer.parseInt(s);
                int i2 = blank;
                if (i2 < indexTo) {
                    reasonPhrase = buffer.substringTrimmed(i2, indexTo);
                } else {
                    reasonPhrase = "";
                }
                return createStatusLine(ver, statusCode, reasonPhrase);
            } catch (NumberFormatException e) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Status line contains invalid status code: ");
                stringBuffer2.append(buffer.substring(indexFrom, indexTo));
                throw new ParseException(stringBuffer2.toString());
            } catch (IndexOutOfBoundsException e2) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Invalid status line: ");
                stringBuffer3.append(buffer.substring(indexFrom, indexTo));
                throw new ParseException(stringBuffer3.toString());
            }
        } else {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public StatusLine createStatusLine(ProtocolVersion ver, int status, String reason) {
        return new BasicStatusLine(ver, status, reason);
    }

    public static final Header parseHeader(String value, LineParser parser) throws ParseException {
        if (value != null) {
            if (parser == null) {
                parser = DEFAULT;
            }
            CharArrayBuffer buffer = new CharArrayBuffer(value.length());
            buffer.append(value);
            return parser.parseHeader(buffer);
        }
        throw new IllegalArgumentException("Value to parse may not be null");
    }

    public Header parseHeader(CharArrayBuffer buffer) throws ParseException {
        return new BufferedHeader(buffer);
    }

    /* access modifiers changed from: protected */
    public void skipWhitespace(CharArrayBuffer buffer, ParserCursor cursor) {
        int pos = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        while (pos < indexTo && HTTP.isWhitespace(buffer.charAt(pos))) {
            pos++;
        }
        cursor.updatePos(pos);
    }
}
