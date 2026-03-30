package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

public final class ImmutableHttpProcessor implements HttpProcessor {
    private final HttpRequestInterceptor[] requestInterceptors;
    private final HttpResponseInterceptor[] responseInterceptors;

    public ImmutableHttpProcessor(HttpRequestInterceptor[] requestInterceptors2, HttpResponseInterceptor[] responseInterceptors2) {
        if (requestInterceptors2 != null) {
            int count = requestInterceptors2.length;
            this.requestInterceptors = new HttpRequestInterceptor[count];
            for (int i = 0; i < count; i++) {
                this.requestInterceptors[i] = requestInterceptors2[i];
            }
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (responseInterceptors2 != null) {
            int count2 = responseInterceptors2.length;
            this.responseInterceptors = new HttpResponseInterceptor[count2];
            for (int i2 = 0; i2 < count2; i2++) {
                this.responseInterceptors[i2] = responseInterceptors2[i2];
            }
            return;
        }
        this.responseInterceptors = new HttpResponseInterceptor[0];
    }

    public ImmutableHttpProcessor(HttpRequestInterceptorList requestInterceptors2, HttpResponseInterceptorList responseInterceptors2) {
        if (requestInterceptors2 != null) {
            int count = requestInterceptors2.getRequestInterceptorCount();
            this.requestInterceptors = new HttpRequestInterceptor[count];
            for (int i = 0; i < count; i++) {
                this.requestInterceptors[i] = requestInterceptors2.getRequestInterceptor(i);
            }
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (responseInterceptors2 != null) {
            int count2 = responseInterceptors2.getResponseInterceptorCount();
            this.responseInterceptors = new HttpResponseInterceptor[count2];
            for (int i2 = 0; i2 < count2; i2++) {
                this.responseInterceptors[i2] = responseInterceptors2.getResponseInterceptor(i2);
            }
            return;
        }
        this.responseInterceptors = new HttpResponseInterceptor[0];
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor[] requestInterceptors2) {
        this(requestInterceptors2, (HttpResponseInterceptor[]) null);
    }

    public ImmutableHttpProcessor(HttpResponseInterceptor[] responseInterceptors2) {
        this((HttpRequestInterceptor[]) null, responseInterceptors2);
    }

    public void process(HttpRequest request, HttpContext context) throws IOException, HttpException {
        int i = 0;
        while (true) {
            HttpRequestInterceptor[] httpRequestInterceptorArr = this.requestInterceptors;
            if (i < httpRequestInterceptorArr.length) {
                httpRequestInterceptorArr[i].process(request, context);
                i++;
            } else {
                return;
            }
        }
    }

    public void process(HttpResponse response, HttpContext context) throws IOException, HttpException {
        int i = 0;
        while (true) {
            HttpResponseInterceptor[] httpResponseInterceptorArr = this.responseInterceptors;
            if (i < httpResponseInterceptorArr.length) {
                httpResponseInterceptorArr[i].process(response, context);
                i++;
            } else {
                return;
            }
        }
    }
}
