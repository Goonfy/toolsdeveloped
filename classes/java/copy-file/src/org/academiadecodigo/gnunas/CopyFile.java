package org.academiadecodigo.gnunas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void copy(String originalFile, String newFile) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        try {
            fileInputStream = new FileInputStream(originalFile);
            fileOutputStream = new FileOutputStream(newFile);

            byte[] buffer = new byte[1024];
            while (fileInputStream.available() != 0) {
                int readBytes = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, readBytes);
            }

            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
