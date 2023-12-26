package org.devdimensionlab.templates.client.http;

public class HttpRestException extends RuntimeException {

    public HttpRestException(String message, Throwable cause) {
        super(message, cause);
    }
}
