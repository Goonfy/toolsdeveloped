package org.academiadecodigo.gnunas;

import java.io.*;

public class WriteFile {
    private final String filePath;

    public WriteFile(String filePath) {
        this.filePath = filePath;
    }

    public FileOutputStream copy(InputStream file) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filePath);

        byte[] buffer = new byte[file.available()];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) file.read();
        }

        //outputStream.write(file.readAllBytes());
        outputStream.write(buffer);

        return outputStream;
    }
}
