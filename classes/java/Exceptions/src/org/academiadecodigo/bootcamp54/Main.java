package org.academiadecodigo.bootcamp54;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        fileManager.login();

        try {
            File file = fileManager.getFile("test");
            System.out.println(file.getName());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        }

        try {
            fileManager.createFile("test");
        } catch (NotEnoughSpaceException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        }

        try {
            File file = fileManager.getFile("test");
            System.out.println(file.getName());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        }

        try {
            fileManager.logout();
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        }
    }
}
