package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HTTP;

public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public long determineLength(HttpMessage message) throws HttpException {
        if (message != null) {
            Header transferEncodingHeader = message.getFirstHeader("Transfer-Encoding");
            Header contentLengthHeader = message.getFirstHeader("Content-Length");
            if (transferEncodingHeader != null) {
                String s = transferEncodingHeader.getValue();
                if (HTTP.CHUNK_CODING.equalsIgnoreCase(s)) {
                    if (!message.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                        return -2;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Chunked transfer encoding not allowed for ");
                    stringBuffer.append(message.getProtocolVersion());
                    throw new ProtocolException(stringBuffer.toString());
                } else if (HTTP.IDENTITY_CODING.equalsIgnoreCase(s)) {
                    return -1;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Unsupported transfer encoding: ");
                    stringBuffer2.append(s);
                    throw new ProtocolException(stringBuffer2.toString());
                }
            } else if (contentLengthHeader == null) {
                return -1;
            } else {
                String s2 = contentLengthHeader.getValue();
                try {
                    return Long.parseLong(s2);
                } catch (NumberFormatException e) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Invalid content length: ");
                    stringBuffer3.append(s2);
                    throw new ProtocolException(stringBuffer3.toString());
                }
            }
        } else {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
    }
}
