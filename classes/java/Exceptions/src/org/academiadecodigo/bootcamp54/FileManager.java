package org.academiadecodigo.bootcamp54;

public class FileManager {
    private File file;

    private boolean logged;

    public void login() {
        logged = true;
    }

    public void logout() throws NotEnoughPermissionsException {
        if (!logged) {
            throw new NotEnoughPermissionsException();
        }

        logged = false;
    }

    public File getFile(String fileName) throws FileNotFoundException, NotEnoughPermissionsException {
        if (!logged) {
            throw new NotEnoughPermissionsException();
        }

        if (file == null || !file.getName().equals(fileName)) {
            throw new FileNotFoundException();
        }

        return file;
    }

    public void createFile(String filename) throws NotEnoughSpaceException, NotEnoughPermissionsException {
        if (!logged) {
            throw new NotEnoughPermissionsException();
        }

        if (file == null) {
            file = new File(filename);
            return;
        }

        throw new NotEnoughSpaceException();
    }
}
