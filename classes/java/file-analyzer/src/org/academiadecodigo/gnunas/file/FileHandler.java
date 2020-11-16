package org.academiadecodigo.gnunas.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileHandler {

    public Stream<String> getStream(String path) throws IOException {
        return Files.lines(Paths.get(path))
                .filter(s -> s.length() > 0)
                .map(s -> s.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(s -> s.length() > 0);
    }
}
