package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

public class BufferedHeader implements FormattedHeader, Cloneable, Serializable {
    private static final long serialVersionUID = -2768352615787625448L;
    private final CharArrayBuffer buffer;
    private final String name;
    private final int valuePos;

    public BufferedHeader(CharArrayBuffer buffer2) throws ParseException {
        if (buffer2 != null) {
            int colon = buffer2.indexOf(58);
            if (colon != -1) {
                String s = buffer2.substringTrimmed(0, colon);
                if (s.length() != 0) {
                    this.buffer = buffer2;
                    this.name = s;
                    this.valuePos = colon + 1;
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid header: ");
                stringBuffer.append(buffer2.toString());
                throw new ParseException(stringBuffer.toString());
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Invalid header: ");
            stringBuffer2.append(buffer2.toString());
            throw new ParseException(stringBuffer2.toString());
        }
        throw new IllegalArgumentException("Char array buffer may not be null");
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        CharArrayBuffer charArrayBuffer = this.buffer;
        return charArrayBuffer.substringTrimmed(this.valuePos, charArrayBuffer.length());
    }

    public HeaderElement[] getElements() throws ParseException {
        ParserCursor cursor = new ParserCursor(0, this.buffer.length());
        cursor.updatePos(this.valuePos);
        return BasicHeaderValueParser.DEFAULT.parseElements(this.buffer, cursor);
    }

    public int getValuePos() {
        return this.valuePos;
    }

    public CharArrayBuffer getBuffer() {
        return this.buffer;
    }

    public String toString() {
        return this.buffer.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
