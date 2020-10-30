package org.academiadecodigo.gnunas.handler;

import java.io.File;

public enum HeaderType {
    HTML("200 Document Follows", "text/html"),
    IMAGE("200 Document Follows", "image/gif"),
    NOTFOUND("404 Not Found", "text/html");

    private final String code;
    private final String contentType;

    HeaderType(String code, String contentType) {
        this.code = code;
        this.contentType = contentType;
    }

    public byte[] setHeader(File file) {
        return ("HTTP/1.0 " + code + "\r\n" +
                "Content-Type: " + contentType + "; charset=UTF-8\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "\r\n").getBytes();
    }
}
