package org.academiadecodigo.bootcamp54;

public class FileNotFoundException extends FileException {
    @Override
    public String getMessage() {
        return "File not found";
    }
}
