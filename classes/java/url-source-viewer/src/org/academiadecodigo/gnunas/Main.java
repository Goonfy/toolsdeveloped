package org.academiadecodigo.gnunas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(">");
                for (String word : words) {
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
