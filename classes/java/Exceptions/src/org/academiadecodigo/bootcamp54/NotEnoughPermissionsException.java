package org.academiadecodigo.bootcamp54;

public class NotEnoughPermissionsException extends FileException {
    @Override
    public String getMessage() {
        return "Not enough permission to execute operation";
    }
}
