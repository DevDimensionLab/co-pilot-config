package org.devdimensionlab.templates.client.http;

public class HttpRestClientError extends RuntimeException {

    public HttpRestClientError(String message, Throwable cause) {
        super(message, cause);
    }
}
