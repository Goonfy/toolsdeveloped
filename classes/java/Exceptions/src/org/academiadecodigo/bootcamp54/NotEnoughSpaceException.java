package org.academiadecodigo.bootcamp54;

public class NotEnoughSpaceException extends FileException {
    @Override
    public String getMessage() {
        return "Not enough space on disk";
    }
}
