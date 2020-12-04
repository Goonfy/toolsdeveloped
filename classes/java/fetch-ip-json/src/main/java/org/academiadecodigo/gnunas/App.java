package org.academiadecodigo.gnunas;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            FetchHandler fetchHandler = new FetchHandler();

            String ext = "json";
            String url = "http://ipinfo.io/";
            url = args.length == 1 ? url + args[0] + "/" + ext : url + ext;

            System.out.println(fetchHandler.read(url));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}