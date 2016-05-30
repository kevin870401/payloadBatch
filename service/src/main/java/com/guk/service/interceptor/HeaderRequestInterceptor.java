package com.guk.service.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {

    /** */
    private final String headerName;

    /** */
    private final String headerValue;

    /**
     *
     * @param headerName
     * @param headerValue
     */
    public HeaderRequestInterceptor(String headerName, String headerValue) {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    /**
     *
     * @param request
     * @param body
     * @param execution
     * @return
     * @throws
     */
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        HttpHeaders headers = request.getHeaders();
        headers.add(headerName, headerValue);
        return execution.execute(request, body);

//        HttpRequest wrapper = new HttpRequestWrapper(request);
//        wrapper.getHeaders().set(headerName, headerValue);
//        return execution.execute(wrapper, body);
    }
}