package org.devdimensionlab.templates.client.http;

public class HttpRestExeption extends RuntimeException {

    public HttpRestExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
