package org.devdimensionlab.template.http.rest.client;

public class HttpRestClientError extends RuntimeException {

    public HttpRestClientError(String message, Throwable cause) {
        super(message, cause);
    }
}
